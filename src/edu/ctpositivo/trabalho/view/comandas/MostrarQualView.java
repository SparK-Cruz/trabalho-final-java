package edu.ctpositivo.trabalho.view.comandas;

import edu.ctpositivo.trabalho.view.View;

public class MostrarQualView extends View{
  public int render(){
    return entrada.readInt("Digite o número da comanda para exibir (ou 0 para sair)");
  }
  public int renderInvalid(){
    println("Comanda inválida");
    return 0;
  }
}