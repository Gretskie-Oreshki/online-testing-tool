package org.testingTool.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.testingTool.model.MaterialEntity;
import org.testingTool.repository.MaterialRepository;
import org.testingTool.services.MaterialService;

@Controller
@RequestMapping("/materials")
@RequiredArgsConstructor
public class MaterialsPageController {

  @Value("${upload.dir}")
  private String uploadDir;

  private final MaterialRepository materialRepository;
  private final MaterialService materialService;

  @GetMapping("/")
  public String listMaterials(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(required = false) String query,
      Model model) {
    if (query != null && !query.isBlank()) {
      model.addAttribute("materialsPage", materialService.getPageableMaterials(page, size, query));
    } else {
      model.addAttribute("materialsPage", materialService.getPageableMaterials(page, size));
    }
    model.addAttribute("query", query);
    return "materials";
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    materialService.saveMaterial(file);
    return "redirect:/materials/";
  }

  @GetMapping("/download/{id}")
  public ResponseEntity<?> serveFile(@PathVariable Long id) {
    Optional<MaterialEntity> optionalMaterial = materialRepository.findById(id);
    if (optionalMaterial.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Файл с ID " + id + " не найден в базе данных.");
    }

    MaterialEntity material = optionalMaterial.get();
    File file = new File(uploadDir + "/" + material.getFilePath());
    if (!file.exists()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Файл " + material.getFileName() + " не найден на сервере.");
    }

    Resource resource = new FileSystemResource(file);

    return ResponseEntity.ok()
        .header(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + material.getFileName() + "\"")
        .body(resource);
  }
}
