package edu.ctpositivo.trabalho.view.comandas;

public class ConfirmarNovaView extends View{
  public int render(){
    println("----------------");
    println(String.format("Comanda número: %d", model.getId()));
    println("----------------");

    return model.getId();
  }
}