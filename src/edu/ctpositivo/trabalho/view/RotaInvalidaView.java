package edu.ctpositivo.trabalho.view;

import edu.ctpositivo.trabalho.controller.BaseController;

public class RotaInvalidaView extends View{
  public RotaInvalidaView(BaseController controller){
    super(controller);
  }

  public int render(){
    println("Opção inválida.");
    return 0;
  }
}