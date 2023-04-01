package com.api.protecaoanimal.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.protecaoanimal.dtos.TemperamentosDto;
import com.api.protecaoanimal.models.TemperamentosModel;
import com.api.protecaoanimal.services.TemperamentosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Temperamentos")
@RequestMapping("/temperamentos")
public class TemperamentosControler {

    final TemperamentosService temperamentosService;

    public TemperamentosControler(TemperamentosService temperamentosService){
        this.temperamentosService = temperamentosService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo temperamento para animais", description = "Cadastrar um novo temperamento para animais" )
    public ResponseEntity<TemperamentosModel> savetemperamentos(@RequestBody @Valid TemperamentosDto temperamentosDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(temperamentosService.save(temperamentosDto));
    }

    @GetMapping
    @Operation(summary = "Listar todos os temperamentos para animais", description = "Listar todos os temperamentos para animais")
    public ResponseEntity<List<TemperamentosModel>> getListtemperamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(temperamentosService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Exibir temperamentos por ID", description = "Exibir uma determinado temperamentos pelo seu ID")
    public ResponseEntity<TemperamentosModel> gettemperamentos(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(temperamentosService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar temperamentos", description = "Atualiza um determinado temperamento passando o seu ID e as configurações que deseja")
    public ResponseEntity<TemperamentosModel> updatetemperamentos(@PathVariable("id") UUID id, @RequestBody @Valid TemperamentosDto temperamentosDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(temperamentosService.save(temperamentosDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um temperamento", description = "Deleta uma determinado temperamento passando o seu ID")
    public ResponseEntity<String> deletetemperamentos(@PathVariable("id") UUID id){
        temperamentosService.delete(temperamentosService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com successo.");
    }

}
