package com.univali.carros.carros.marca;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/marca")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @PostMapping()
    public @ResponseBody String addNewMarca (@RequestBody @Valid Marca marca) {
        marcaRepository.save(marca);
        return "Saved";
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteMarca(@PathVariable Integer id) {
        marcaRepository.deleteById(id);
        return "Deleted";
    }

    @PutMapping(path="/{id}")
    public @ResponseBody String editMarca (@PathVariable Integer id, @RequestBody @Valid Marca marca) {
        Optional<Marca> oldMarca = marcaRepository.findById(id);
        if (oldMarca.isEmpty()) {
            return "No row with ID";
        }
        marca.setId(id);
        marcaRepository.save(marca);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Marca> getMarca(@PathVariable Integer id) {
        return marcaRepository.findById(id);
    }
}