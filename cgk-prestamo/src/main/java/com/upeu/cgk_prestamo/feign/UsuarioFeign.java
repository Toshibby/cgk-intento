package com.upeu.cgk_prestamo.feign;

import com.upeu.cgk_prestamo.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cgk-usuario", path = "/usuarios")
public interface UsuarioFeign {
    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id);

}
