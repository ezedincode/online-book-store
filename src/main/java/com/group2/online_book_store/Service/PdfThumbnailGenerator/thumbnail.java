package com.group2.online_book_store.Service.PdfThumbnailGenerator;

import com.group2.online_book_store.Service.storage.StorageService;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class thumbnail {
     private final StorageService service;

    public String generate(MultipartFile file){
        String name = file.getOriginalFilename();
        String url="";
        try(PDDocument document = PDDocument.load(file.getInputStream()))
        {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage image = pdfRenderer.renderImageWithDPI(0, 150);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            byte[] imageBytes = outputStream.toByteArray();
            url= service.generateSignedUrl(service.uploadThumbnail(imageBytes, name),"thumbnail");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return url;
    }


}
