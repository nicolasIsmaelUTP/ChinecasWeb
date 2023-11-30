package com.nibble.chinecas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nibble.chinecas.service.*;
import com.nibble.chinecas.model.*;

@RestController
@RequestMapping("/api/terrenos")
public class TerrenoRestController {

    @Autowired
    private TerrenoService terrenoService;

    @GetMapping("/distrito/{distrito}")
    public List<Terreno> getTerrenosByDistrito(@PathVariable("distrito")  int distrito) {
        return terrenoService.obtenerPorDistrito(distrito);
    }
}
