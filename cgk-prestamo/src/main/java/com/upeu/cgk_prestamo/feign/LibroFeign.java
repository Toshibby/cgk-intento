package com.upeu.cgk_prestamo.feign;

import com.upeu.cgk_prestamo.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cgk-libro", path = "/libros")
public interface LibroFeign {
    @GetMapping("/{id}")
    public LibroDTO buscarPorId(@PathVariable Long id);

}
