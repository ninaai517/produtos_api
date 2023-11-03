package br.com.meli.produtosapi.controller;

import br.com.meli.produtosapi.model.dto.AtualizacaoProdutoDto;
import br.com.meli.produtosapi.model.dto.DadosCadastroProduto;
import br.com.meli.produtosapi.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<DadosCadastroProduto> getProdutos(){

        return service.getAllProdutos();
    }

    @PostMapping
    @Validated
    public void salvarProduto(@RequestBody @Valid DadosCadastroProduto produto){

        service.cadastrarProduto(produto);
    }

    @PutMapping("/{id}")
    public DadosCadastroProduto atualizarProdutoById(@RequestBody AtualizacaoProdutoDto produto, @PathVariable("id") Long id){
        return service.atualizarCadastroProduto(produto, id);
    }

    @DeleteMapping("/{id}")
    public void excluirProdutoById(@PathVariable("id") Long id){
        service.excluirProdutoId(id);

    }


}
