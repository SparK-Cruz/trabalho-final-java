package edu.ctpositivo.trabalho.controller;

import edu.ctpositivo.trabalho.view.home.*;

public class HomeController{
  public int menu(){
    return (new MenuView(this)).render();
  }

  public int tchau(){
    return (new TchauView(this)).render();
  }
}