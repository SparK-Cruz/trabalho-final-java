package edu.ctpositivo.trabalho.view.comandas;

import java.util.List;
import edu.ctpositivo.trabalho.view.View;

public class MostrarView extends View{
  private List<ItemComanda> itens;

  public MostrarView(ComandasController controller, Comanda model, List<ItemComanda> itens){
    super(controller, model);
    this.itens = itens;
  }

  public int render(){
    int indice = 1;
    double total = 0;

    println(String.format("------ Comanda nº %d ------", model.getId()));
    println(String.format("%3s\t%s\t%10s\t%9s\t%s\t%s\t%s",
      "", "código", "nome", "tipo", "preço", "qtd", "total"));
    for(ItemComanda item : itens){
      mostrarItem(indice++, item);
      try{
        total += item.getTotal();
      }catch(Exception e){
        //Produto inválido?
      }
    }
    println("--------------------------");
    println(String.format("Total: %.2f",
      total));
    return 0;
  }

  private void mostrarItem(int indice, ItemComanda item){
    Produto produto = null;
    try{
      produto = item.getProduto();

      if(indice <= 0){
        System.out.println(String.format("%d\t%10s\t%9s\t%.2f\t%d\t%.2f",
          produto.getId(), produto.getNome(), produto.getTipo().getDescricao(), produto.getValor(), item.getQuantidade(), item.getTotal()));
        return;
      }

      System.out.println(String.format("%d\t%d\t%10s\t%9s\t%.2f\t%d\t%.2f",
        indice, produto.getId(), produto.getNome(), produto.getTipo().getDescricao(), produto.getValor(), item.getQuantidade(), item.getTotal()));

    }catch(Exception e){
      System.out.println("Produto inválido");
      return;
    }
  }
}