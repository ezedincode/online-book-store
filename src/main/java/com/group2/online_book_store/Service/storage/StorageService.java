package com.group2.online_book_store.Service.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class StorageService {
    @Value("${supabase.url}")
    private String supaBaseUrl;

    @Value("${supabase.service.key}")
    private String serviceKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String uploadUrl = supaBaseUrl + "/storage/v1/object/books/" + fileName;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set("Authorization", "Bearer " + serviceKey);
        headers.set("apiKey", serviceKey);
        HttpEntity<byte[]> request =
                new HttpEntity<>(file.getBytes(), headers);
        restTemplate.exchange(
                uploadUrl,
                HttpMethod.POST,
                request,
                String.class
        );
        return supaBaseUrl + "/storage/v1/object/books/" + fileName;
    }
}
