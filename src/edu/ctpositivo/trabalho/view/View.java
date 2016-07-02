package edu.ctpositivo.trabalho.view;

import edu.ctpositivo.scanner.Input;
import edu.ctpositivo.trabalho.controller.BaseController;
import edu.ctpositivo.trabalho.model.IModel;

public abstract class View{
  protected Input entrada;
  protected BaseController ctrl;
  protected IModel model;

  public View() throws Exception{
    throw new Exception("Do not use this constructor!");
  }
  public View(BaseController controller){
    this.entrada = new Input();
    this.ctrl = controller;
  }
  public View(BaseController controller, IModel model){
    this.entrada = new Input();
    this.ctrl = controller;
    this.model = model;
  }

  public void println(){
    System.out.println("");
  }
  public void println(String string){
    System.out.println(string);
  }

  public abstract int render();
}