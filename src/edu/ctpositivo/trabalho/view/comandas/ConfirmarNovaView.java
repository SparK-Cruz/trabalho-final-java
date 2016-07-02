package edu.ctpositivo.trabalho.view.comandas;

import edu.ctpositivo.trabalho.view.View;
import edu.ctpositivo.trabalho.model.Comanda;
import edu.ctpositivo.trabalho.controller.ComandasController;

public class ConfirmarNovaView extends View{
  public ConfirmarNovaView(ComandasController controller, Comanda model){
    super(controller, model);
  }

  public int render(){
    println("----------------");
    println(String.format("Comanda número: %d", model.getId()));
    println("----------------");
    println();

    return model.getId();
  }
}