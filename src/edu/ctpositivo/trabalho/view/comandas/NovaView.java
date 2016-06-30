package edu.ctpositivo.trabalho.view.comandas;

import java.util.List;
import java.util.ArrayList;
import edu.ctpositivo.trabalho.controller.ComandasController;
import edu.ctpositivo.trabalho.model.Comanda;
import edu.ctpositivo.trabalho.model.ItemComanda;
import edu.ctpositivo.trabalho.model.Produto;
import edu.ctpositivo.trabalho.view.View;

public class NovaView extends View{
  private List<ItemComanda> itens = new ArrayList<ItemComanda>;

  public List<ItemComanda> getItens(){
    return itens;
  }

  public int render(){
    int idProduto = 0;
    while((idProduto = entrada.readInt("Digite um código de produto ou 0 para finalizar o pedido")) != 0){
      try{
        ((ComandasController)_).validarProduto(idProduto);
      }catch(Exception e){
        println("Produto inválido");
        continue;
      }

      ItemComanda item = new ItemComanda();
      item.setIdProduto(idProduto);
      System.out.println(produto.getNome());

      int quantidade = 0;
      while((quantidade = entrada.readInt("Digite uma quantidade")) <= 0){
        System.out.println("A quantidade deve ser maior que 0");
      }
      item.setQuantidade(quantidade);

      itens.add(item);

      println(item.getQuantidade() * produto.getValor());
    }
    return 0;
  }
}