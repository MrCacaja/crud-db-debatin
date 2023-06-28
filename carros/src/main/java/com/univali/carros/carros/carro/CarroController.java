package com.univali.carros.carros.carro;

import com.univali.carros.carros.modelo.Modelo;
import com.univali.carros.carros.modelo.ModeloController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/carro")
public class CarroController {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModeloController modeloController;

    @PostMapping()
    public @ResponseBody String addNewCarro (@RequestBody CarroBody carro) {
        Optional<Modelo> modelo = modeloController.getModelo(carro.getId_modelo());
        if (modelo.isEmpty()) {
            return "No modelo found with ID";
        }
        Carro carroData = new Carro(modelo.get(), carro.getNome(), carro.getRenavam(), carro.getPlaca(), carro.getValor(), carro.getAno());
        carroRepository.save(carroData);
        return "Saved";
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteCarro(@PathVariable Integer id) {
        carroRepository.deleteById(id);
        return "Deleted";
    }

    @PutMapping(path="/{id}")
    public @ResponseBody String editCarro (@PathVariable Integer id, @RequestBody @Valid CarroBody carro) {
        Optional<Carro> oldCarro = carroRepository.findById(id);
        if (oldCarro.isEmpty()) {
            return "No row with ID";
        }
        Optional<Modelo> modelo = modeloController.getModelo(carro.getId_modelo());
        if (modelo.isEmpty()) {
            return "No modelo with Id";
        }

        Carro oldCarroData = oldCarro.get();
        oldCarroData.setModelo(modelo.get());
        oldCarroData.setAno(carro.getAno());
        oldCarroData.setNome(carro.getNome());
        oldCarroData.setValor(carro.getValor());
        oldCarroData.setRenavam(carro.getRenavam());
        oldCarroData.setPlaca(carro.getPlaca());
        carroRepository.save(oldCarroData);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Carro> getAllCarros() {
        return carroRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Carro> getCarro(@PathVariable Integer id) {
        return carroRepository.findById(id);
    }
}