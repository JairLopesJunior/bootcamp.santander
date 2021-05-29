package com.project.bootcamp.santander.controller;

import com.project.bootcamp.santander.model.dto.StockDTO;
import com.project.bootcamp.santander.service.StockService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService service;

    @ApiOperation("Register stock.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Stock registered successfully."),
            @ApiResponse(code = 422, message = "Unable to process present instructions.")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@RequestBody @Valid StockDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @ApiOperation("Update stock.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Stock updated successfully."),
            @ApiResponse(code = 422, message = "Unable to process present instructions.")
    })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@RequestBody @Valid StockDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @ApiOperation("Search all stocks.")
    @ApiResponse(code = 200, message = "Search carried out successfully.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation("Search a single stock.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Search carried out successfully."),
            @ApiResponse(code = 404, message = "Stock not found.")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @ApiOperation("Delete stock.")
    @ApiResponse(code = 200, message = "Stock successfully deleted.")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @ApiOperation("Search stock today.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Search carried out successfully."),
            @ApiResponse(code = 404, message = "Stock not found.")
    })
    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(service.findByToday());
    }
}
