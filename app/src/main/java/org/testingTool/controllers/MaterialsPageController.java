package org.testingTool.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.testingTool.model.MaterialEntity;
import org.testingTool.repository.MaterialRepository;

@Controller
@RequestMapping("/materials")
@RequiredArgsConstructor
public class MaterialsPageController {

  @Value("${upload.dir}")
  private String uploadDir;

  private final MaterialRepository materialRepository;

  @GetMapping()
  public String listMaterials(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(required = false) String query,
      Model model) {
    Pageable pageable = PageRequest.of(page, size);
    Page<MaterialEntity> materials;

    if (query != null && !query.isBlank()) {
      materials = materialRepository.findByFileNameContainingIgnoreCase(query, pageable);
    } else {
      materials = materialRepository.findAllBy(pageable);
    }

    model.addAttribute("materialsPage", materials);
    model.addAttribute("query", query);
    return "materials";
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
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

    return "redirect:/materials";
  }

  @GetMapping("/download/{id}")
  public ResponseEntity<Resource> serveFile(@PathVariable Long id) {
    MaterialEntity material = materialRepository.findById(id).get();
    Resource res =
        new FileSystemResource(Objects.requireNonNull(uploadDir + "/" + material.getFilePath()));

    return ResponseEntity.ok()
        .header(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + material.getFileName() + "\"")
        .body(res);
  }
}
