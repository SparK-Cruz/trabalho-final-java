package edu.ctpositivo.trabalho.controller;

import edu.ctpositivo.trabalho.view.View;
import edu.ctpositivo.trabalho.view.RotaInvalidaView;

public class BaseController{
  public View rotaInvalida(){
    return new RotaInvalidaView(this);
  }
}