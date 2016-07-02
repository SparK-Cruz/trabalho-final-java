package edu.ctpositivo.trabalho.view.comandas;

import edu.ctpositivo.trabalho.view.View;
import edu.ctpositivo.trabalho.controller.ComandasController;

public class ExcluirView extends View{
  public ExcluirView(ComandasController controller){
    super(controller);
  }

  public int render(){
    println("Comanda excluida com sucesso");
    println();
    return 0;
  }
}