package edu.ctpositivo.trabalho.view.comandas;

import edu.ctpositivo.trabalho.view.View;

public class ConfirmarNovaView extends View{
  public int render(){
    println("----------------");
    println(String.format("Comanda número: %d", model.getId()));
    println("----------------");

    return model.getId();
  }
}