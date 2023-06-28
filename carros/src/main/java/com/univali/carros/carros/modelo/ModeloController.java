package com.univali.carros.carros.modelo;

import com.univali.carros.carros.marca.Marca;
import com.univali.carros.carros.marca.MarcaController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/modelo")
public class ModeloController {
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    MarcaController marcaController;

    @PostMapping()
    public @ResponseBody String addNewModelo(@RequestBody ModeloBody modelo) {
        Optional<Marca> optMarca = marcaController.getMarca(modelo.getId_marca());
        if (optMarca.isEmpty())
            return "No marca found with ID";
        Modelo modeloObj = new Modelo(optMarca.get(), modelo.getNome());
        modeloRepository.save(modeloObj);
        return "Saved";
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteModelo(@PathVariable Integer id) {
        modeloRepository.deleteById(id);
        return "Deleted";
    }

    @PutMapping(path="/{id}")
    public @ResponseBody String editModelo(@PathVariable Integer id, @RequestBody @Valid ModeloBody modelo) {
        Optional<Modelo> oldModelo = modeloRepository.findById(id);
        if (oldModelo.isEmpty()) {
            return "No row with ID";
        }
        Optional<Marca> marca = marcaController.getMarca(modelo.getId_marca());
        if (marca.isEmpty()) {
            return "No marca with ID";
        }

        Modelo oldModeloData = oldModelo.get();
        oldModeloData.set_marca(marca.get());
        oldModeloData.setNome(modelo.getNome());
        modeloRepository.save(oldModeloData);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Modelo> getAllModelos() {
        return modeloRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Modelo> getModelo(@PathVariable Integer id) {
        return modeloRepository.findById(id);
    }
}