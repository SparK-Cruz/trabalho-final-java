package edu.ctpositivo.trabalho.view.home;

import edu.ctpositivo.trabalho.controller.HomeController;
import edu.ctpositivo.trabalho.view.View;

public class TchauView extends View{
  public TchauView(HomeController controller){
    super(controller);
  }

  public int render(){
    println("Tchau!");
    println();
    return 0;
  }
}