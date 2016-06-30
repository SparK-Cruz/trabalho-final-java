package edu.ctpositivo.trabalho.view;

import edu.ctpositivo.trabalho.model.IModel;

public class View{
  protected Input entrada;
  protected BaseController _;
  protected IModel model;

  public View(BaseController controller){
    this.entrada = new Input();
    this._ = controller;
  }
  public View(BaseController controller, IModel model){
    this.entrada = new Input();
    this._ = controller;
    this.model = model;
  }

  public void println(String string){
    System.out.println(string);
  }

  public abstract int render();
}