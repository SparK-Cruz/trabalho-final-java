package edu.ctpositivo.trabalho.view.home;

import java.util.List;
import edu.ctpositivo.trabalho.controller.HomeController;
import edu.ctpositivo.trabalho.view.View;

public class MenuView extends View{
  private List<Integer> options;

  public MenuView(HomeController controller, List<Integer> options){
    super(controller);
    this.options = options;
  }

  public int render(){
    println("------ MENU PRINCIPAL ------");
    if(options.contains(1))
      println("1. Nova comanda");
    if(options.contains(2))
      println("2. Listar comandas");
    if(options.contains(3))
      println("3. Detalhes da comanda");
    if(options.contains(4))
      println("4. Cancelar comanda");
    if(options.contains(5))
      println("5. Total de vendas");

    println();

    if(options.contains(0))
      println("0. Sair");

    println("----------------------------");
    println();
    return entrada.readInt("Digite uma opção:");
  }
}