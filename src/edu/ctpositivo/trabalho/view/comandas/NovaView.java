package edu.ctpositivo.trabalho.view.comandas;

import java.util.List;
import java.util.ArrayList;
import edu.ctpositivo.trabalho.controller.ComandasController;
import edu.ctpositivo.trabalho.model.Comanda;
import edu.ctpositivo.trabalho.model.ItemComanda;
import edu.ctpositivo.trabalho.model.Produto;
import edu.ctpositivo.trabalho.view.View;

public class NovaView extends View{
  private List<ItemComanda> itens = new ArrayList<ItemComanda>();

  public List<ItemComanda> getItens(){
    return itens;
  }

  public NovaView(ComandasController controller, Comanda model){
    super(controller, model);
  }

  public int render(){
    int idProduto = 0;
    Produto produto = null;
    while((idProduto = entrada.readInt("Digite um código de produto ou 0 para finalizar o pedido")) != 0){
      try{
        produto = ((ComandasController)ctrl).findProduto(idProduto);
      }catch(Exception e){
        println("Produto inválido");
        continue;
      }

      ItemComanda item = new ItemComanda();
      item.setIdProduto(idProduto);
      println(produto.getNome());

      int quantidade = 0;
      while((quantidade = entrada.readInt("Digite uma quantidade")) <= 0){
        println("A quantidade deve ser maior que 0");
      }
      item.setQuantidade(quantidade);

      itens.add(item);

      println(String.format("%.2f",item.getQuantidade() * produto.getValor()));
      println();
    }
    return 0;
  }
}