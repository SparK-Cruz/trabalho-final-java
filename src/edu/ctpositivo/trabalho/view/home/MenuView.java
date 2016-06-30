package edu.ctpositivo.trabalho.view.home;

import edu.ctpositivo.trabalho.view.View;

public class MenuView extends View{
  private final String MENU =
"------ MENU PRINCIPAL ------
1. Nova comanda
2. Listar comandas
3. Detalhes da comanda
4. Cancelar comanda
5. Total de vendas

0. Sair
----------------------------";

  public MenuView(HomeController controller){
    super(controller);

  }

  public int render(){
    println(MENU);
    return entrada.readInt("Digite uma opção:");
  }
}