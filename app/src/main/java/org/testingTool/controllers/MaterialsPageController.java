package org.testingTool.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
  public ResponseEntity<Resource> serveFile(@PathVariable Long id) {
    Optional<MaterialEntity> optionalMaterial = materialRepository.findById(id);
    if (optionalMaterial.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    MaterialEntity material = optionalMaterial.get();
    Path filePath = Paths.get(uploadDir, material.getFilePath());
    if (!Files.exists(filePath)) {
      return ResponseEntity.notFound().build();
    }

    try {
      Resource resource = new InputStreamResource(Files.newInputStream(filePath));

      return ResponseEntity.ok()
          .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(filePath))
          .header(
              HttpHeaders.CONTENT_DISPOSITION,
              "attachment; filename=\"" + material.getFileName() + "\"")
          .body(resource);
    } catch (IOException e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
