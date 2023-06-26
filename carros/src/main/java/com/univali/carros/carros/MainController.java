package com.univali.carros.carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/carro")
public class MainController {
    @Autowired
    private CarroRepository carroRepository;

    @PostMapping()
    public @ResponseBody String addNewCarro (
            @RequestParam String nome,
            @RequestParam Integer renavam,
            @RequestParam String placa,
            @RequestParam Float valor,
            @RequestParam Integer ano,
            @RequestParam Integer idModelo
    ) {
        Carro carro = new Carro(idModelo, nome, renavam, placa, valor, ano);
        carroRepository.save(carro);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Carro> getAllCarros() {
        return carroRepository.findAll();
    }
}