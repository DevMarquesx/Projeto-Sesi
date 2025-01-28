package com.sesi.projeto.controller;

import com.sesi.projeto.dto.ProdutoDto;
import com.sesi.projeto.model.ProdutoModel;
import com.sesi.projeto.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repo;

    @GetMapping
    public ResponseEntity<List<?>> amostrarTudo(){
        List<?> prod = repo.findAll();
        return ResponseEntity.ok(prod);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> create(@RequestBody ProdutoDto dto) {
        ProdutoModel newProduto = new ProdutoModel(dto);
        return ResponseEntity.ok(newProduto);
    }
}
