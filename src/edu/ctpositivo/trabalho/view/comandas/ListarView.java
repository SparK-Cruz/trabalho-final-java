package edu.ctpositivo.trabalho.view.comandas;

import java.util.List;
import edu.ctpositivo.trabalho.view.View;

public class ListarView extends View{
  private List<Comanda> comandas;

  public ListarView(ComandasController controller, List<Comanda> comandas){
    super(controller);
    this.comandas = comandas;
  }

  public int render(){
    println("--- Comandas ---");
    println(String.format("%s\t%s\t%s",
      "Código", "Itens", "Total"));
    for(Comanda comanda : comandas){
      println(String.format("%d\t%d\t%.2f",
        comanda.getId(), comanda.getItens().size(), comanda.getTotal()));
    }
    println(String.format("Total de comandas: %d", comandas.size()));
    return 0;
  }
}