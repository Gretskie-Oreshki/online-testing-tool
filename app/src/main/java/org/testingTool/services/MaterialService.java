package org.testingTool.services;

import jakarta.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.testingTool.model.MaterialEntity;
import org.testingTool.repository.MaterialRepository;

@Component
@RequiredArgsConstructor
public class MaterialService {

  @Value("${upload.dir}")
  private String uploadDir;

  private final MaterialRepository materialRepository;

  public Page<MaterialEntity> getPageableMaterials(int page, int size, String query) {
    Pageable pageable = PageRequest.of(page, size);
    Page<MaterialEntity> materials;

    if (query != null && !query.isBlank()) {
      materials = materialRepository.findByFileNameContainingIgnoreCase(query, pageable);
    } else {
      materials = materialRepository.findAll(pageable);
    }
    return materials;
  }

  @Transactional
  public void saveMaterial(MultipartFile file) throws IOException {
    String originalFilename = file.getOriginalFilename();
    String extension =
        Objects.requireNonNull(file.getOriginalFilename())
            .substring(file.getOriginalFilename().lastIndexOf("."));
    String storedName = UUID.randomUUID() + extension;

    Path path = Paths.get(uploadDir).resolve(storedName);
    Files.createDirectories(path.getParent());
    Files.copy(file.getInputStream(), path);

    MaterialEntity material = new MaterialEntity();
    material.setFileName(originalFilename);
    material.setFilePath(storedName);

    materialRepository.save(material);
  }
}
