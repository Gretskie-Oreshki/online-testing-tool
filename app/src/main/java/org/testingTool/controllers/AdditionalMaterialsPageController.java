package org.testingTool.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/materials")
public class AdditionalMaterialsPageController {

  @Value("${upload.dir}")
  private String uploadDir;

  @GetMapping
  public String listFiles(Model model) throws IOException {
    Path uploadPath = Paths.get(uploadDir);
    if (!Files.exists(uploadPath)) {
      Files.createDirectories(uploadPath);
    }

    List<String> files =
        Files.list(uploadPath)
            .filter(Files::isRegularFile)
            .map(p -> p.getFileName().toString())
            .toList();

    model.addAttribute("files", files);
    return "add_additional_materials";
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    Path target = Paths.get(uploadDir).resolve(file.getOriginalFilename());
    Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
    return "redirect:/materials";
  }
}
