package br.com.meli.produtosapi.service;

import br.com.meli.produtosapi.model.dto.AtualizacaoProdutoDto;
import br.com.meli.produtosapi.model.dto.DadosCadastroProduto;
import br.com.meli.produtosapi.model.Produto;
import br.com.meli.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository repository;

    public List<DadosCadastroProduto> getAllProdutos(){

        List<Produto> todosProdutos = repository.findAll();

        return converteListaDto(todosProdutos);
    }

    /*public void buscarProdutoById(AtualizacaoProdutoDto produto){
        repository.findById(produto.getId());
    }*/

    public void cadastrarProduto(DadosCadastroProduto produto){
        Produto p = new Produto();
        p.setId(produto.getId());
        p.setProduto(produto.getProduto());
        p.setPreco(produto.getPreco());
        p.setDescricao(produto.getDescricao());
        repository.save(p);
    }

    public DadosCadastroProduto atualizarCadastroProduto(AtualizacaoProdutoDto produto, Long id){
        Optional<Produto> produtos = repository.findById(id);

        if(produtos.isPresent()){
            Produto p = produtos.get();

            if(produto.getProduto() != null){
                p.setProduto(produto.getProduto());
            }

            if(produto.getPreco() > 0.00){
                p.setPreco(produto.getPreco());
            }

            if(produto.getDescricao() != null){
                p.setDescricao(produto.getDescricao());
            }

            repository.save(p);
            return ConverterToDto(p);
        }

        return null;

    }

    public void excluirProdutoId(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    private DadosCadastroProduto ConverterToDto(Produto produto) {
        DadosCadastroProduto produtoDto = new DadosCadastroProduto();

        produtoDto.setId(produto.getId());
        produtoDto.setProduto(produto.getProduto());
        produtoDto.setPreco(produto.getPreco());
        produtoDto.setDescricao(produto.getDescricao());

        return produtoDto;
    }

    private static List<DadosCadastroProduto> converteListaDto(List<Produto> produtos){
        return produtos.stream().map(DadosCadastroProduto::new).collect(Collectors.toList());
    }
}
