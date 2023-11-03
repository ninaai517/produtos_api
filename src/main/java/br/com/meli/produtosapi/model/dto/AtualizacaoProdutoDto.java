package br.com.meli.produtosapi.model.dto;

import br.com.meli.produtosapi.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoProdutoDto {
    private Long id;
    private String produto;
    private double preco;
    private String descricao;

    public AtualizacaoProdutoDto(){}

    public AtualizacaoProdutoDto(Produto produto){
        this.id = produto.getId();
        this.produto = produto.getProduto();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
    }
}
