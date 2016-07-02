package edu.ctpositivo.trabalho.view.produtos;

import java.util.List;
import edu.ctpositivo.trabalho.model.Produto;
import edu.ctpositivo.trabalho.controller.ProdutosController;
import edu.ctpositivo.trabalho.view.View;

public class ListarView extends View{
  private List<Produto> produtos;

  public ListarView(ProdutosController controller, List<Produto> produtos){
    super(controller);

    this.produtos = produtos;
  }

  public int render(){
    println("--- Produtos disponíveis ---");
    println(String.format("%s\t%10s\t%9s\t%s", "Código", "Nome", "Tipo", "Valor"));
    for(Produto produto : produtos){
      println(String.format("%d\t%10s\t%9s\t%.2f",
        produto.getId(),
        produto.getNome(),
        produto.getTipo().getDescricao(),
        produto.getValor()));
    }
    println();
    return 0;
  }
}