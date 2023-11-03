package br.com.meli.produtosapi.model.dto;

import br.com.meli.produtosapi.model.Produto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DadosCadastroProduto {

    private Long id;
    private String produto;
    private double preco;
    private String descricao;

    public DadosCadastroProduto(){

    }

    public DadosCadastroProduto(Produto produto){
        this.id = produto.getId();
        this.produto = produto.getProduto();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
    }
}
