package com.example.proyectoUsuariosCleanArq.infraestructura.clientFeign;

import com.example.proyectoUsuariosCleanArq.dominio.modelo.FileImagenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Component
@FeignClient(name = "UserImageClientFeign", url = "http://localhost:8888/")
public interface UserImageClientFeign {

    @PostMapping("images/save")
    boolean saveUserImage(@RequestParam("file") MultipartFile file,@RequestParam("id") Integer id);

    @GetMapping("images/{id}")
    FileImagenDto getImageById(@PathVariable Integer id);
}
