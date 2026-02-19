package com.group2.online_book_store.Service.storage;

import com.group2.online_book_store.Repository.bookRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
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
        String uploadUrl = supaBaseUrl + "/storage/v1/object/book/" + fileName;

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
        System.out.println(fileName);
        return fileName;
    }
    public String uploadThumbnail(byte[] bytes, String fileName) {
        String uploadUrl = supaBaseUrl + "/storage/v1/object/book/" + fileName;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.set("Authorization", "Bearer " + serviceKey);
        headers.set("apiKey", serviceKey);

        HttpEntity<byte[]> request = new HttpEntity<>(bytes, headers);

        restTemplate.exchange(
                uploadUrl,
                HttpMethod.POST,
                request,
                String.class
        );
        return fileName;
    }

    public String generateSignedUrl(String fileName) {

        String bucket = "book";

        String url = supaBaseUrl +
                "/storage/v1/object/sign/" +
                bucket + "/" + fileName;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + serviceKey);
        headers.set("apikey", serviceKey);

        String body = """
        {
          "expiresIn": 60
        }
        """;

        HttpEntity<String> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        request,
                        Map.class
                );

        String signedPath =
                (String) response.getBody().get("signedURL");

        return supaBaseUrl + "/storage/v1" + signedPath;
    }
    public void deleteFile(String fileName) {

        String bucket = "book";

        String url = supaBaseUrl +
                "/storage/v1/object/" + bucket;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + serviceKey);
        headers.set("apikey", serviceKey);

        String body = """
        {
          "prefixes": ["%s"]
        }
        """.formatted(fileName);

        HttpEntity<String> request =
                new HttpEntity<>(body, headers);
        System.out.println(request.toString());
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                request,
                String.class
        );
        System.out.println("final");
    }

}
