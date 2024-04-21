package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.dtos.Alimentos_Donados_Por_DonanteDTO;
import com.upc.grupo2.backendhungerfood.dtos.SumAlimentosDonadosDTO;
import com.upc.grupo2.backendhungerfood.entities.Alimentos_Donados_Por_Donante;
import com.upc.grupo2.backendhungerfood.services.Alimentos_Donados_Por_DonanteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/HungerFood")
public class Alimentos_Donados_Por_DonanteController {
    @Autowired
    private Alimentos_Donados_Por_DonanteService alimentos_Donados_Por_DonanteService;

    //Registrar
    @PostMapping("/RegistrarAlimentosDonados")
    public ResponseEntity<Alimentos_Donados_Por_DonanteDTO> registrar(@RequestBody Alimentos_Donados_Por_DonanteDTO alimentos_donados_por_donanteDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Alimentos_Donados_Por_Donante alimentos_donados_por_donante = modelMapper.map(alimentos_donados_por_donanteDTO, Alimentos_Donados_Por_Donante.class);
            alimentos_donados_por_donante = alimentos_Donados_Por_DonanteService.registrar(alimentos_donados_por_donante);
            alimentos_donados_por_donanteDTO = modelMapper.map(alimentos_donados_por_donante, Alimentos_Donados_Por_DonanteDTO.class);
            return new ResponseEntity<>(alimentos_donados_por_donanteDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar");
        }
    }

    //Listar
    @GetMapping("/ListarAlimentosDonados")
    public ResponseEntity<List<Alimentos_Donados_Por_DonanteDTO>> findAll(){
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Alimentos_Donados_Por_DonanteDTO> list = Arrays.asList(modelMapper.map(alimentos_Donados_Por_DonanteService.listar(),
                    Alimentos_Donados_Por_DonanteDTO[].class));
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar");
        }
    }

    //Actualizar
    @PutMapping("/ActualizarAlimentosDonados")
    public ResponseEntity<Alimentos_Donados_Por_DonanteDTO> actualizarUsuario(@RequestBody Alimentos_Donados_Por_DonanteDTO alimentos_donados_por_donanteDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Alimentos_Donados_Por_Donante alimentos_donados_por_donante = modelMapper.map(alimentos_donados_por_donanteDTO, Alimentos_Donados_Por_Donante.class);
            alimentos_donados_por_donante = alimentos_Donados_Por_DonanteService.actualizar(alimentos_donados_por_donante);
            alimentos_donados_por_donanteDTO = modelMapper.map(alimentos_donados_por_donante, Alimentos_Donados_Por_DonanteDTO.class);
            return new ResponseEntity<>(alimentos_donados_por_donanteDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar");
        }
    }

    //Eliminar
    @DeleteMapping("/EliminarAlimentosDonados/{id}")
    public ResponseEntity<Alimentos_Donados_Por_DonanteDTO> eliminar(@PathVariable("id") Long id){
        Alimentos_Donados_Por_Donante alimentos_donados_por_donante;
        Alimentos_Donados_Por_DonanteDTO alimentos_donados_por_donanteDTO;
        try{
            alimentos_donados_por_donante = alimentos_Donados_Por_DonanteService.eliminar(id);
            ModelMapper modelMapper = new ModelMapper();
            alimentos_donados_por_donanteDTO = modelMapper.map(alimentos_donados_por_donante, Alimentos_Donados_Por_DonanteDTO.class);
            return new ResponseEntity<>(alimentos_donados_por_donanteDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar");
        }
    }

    //Listar total de alimentos donados por donante buscado
    @GetMapping("/ListarAlimentosDonadosPorDonante/{usuarioId}")
    public ResponseEntity<SumAlimentosDonadosDTO> getCantidadAlimentosDonadosPorDonante(@PathVariable("usuarioId") Long usuarioId){
        try{
            ModelMapper modelMapper = new ModelMapper();
            SumAlimentosDonadosDTO totalAlimentosDonados = alimentos_Donados_Por_DonanteService.getCantidadAlimentosDonadosPorDonante(usuarioId);
            return new ResponseEntity<>(totalAlimentosDonados, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar por usuario");
        }
    }

}
