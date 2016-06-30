package edu.ctpositivo.trabalho;

import edu.ctpositivo.scanner.Input;
import edu.ctpositivo.trabalho.dao.*;
import edu.ctpositivo.trabalho.controller.*;

class Main{
  private static ProdutoDAO produtoDao;

  public static final void main(String[] args){
    Input entrada = new Input();
    HomeController controller = ControllerFactory.getHomeController();

    //ProdutosController.seed();

    while(true){
      try{
        rotear(controller.menu());
      }catch(CanceladoPeloUsuarioException e){
        break;
      }
    }
    controller.tchau();
  }

  public static final int rotear(int indice) throws CanceladoPeloUsuarioException{
    switch(indice){
      case 0: //Sair
        throw new CanceladoPeloUsuarioException();
      case 1: //Nova comanda
        return ControllerFactory.getComandasController().nova();
      case 2: //Listar comandas
        return ControllerFactory.getComandasController().listar();
      case 3: //Detalhes da comanda
        return ControllerFactory.getComandasController().mostrar();
      case 4: //Cancelar comanda
        return ControllerFactory.getComandasController().excluir();
      case 5: //Total de vendas
        return ControllerFactory.getReportsController().vendas();
      default:
        return ControllerFactory.getHomeController().rotaInvalida();
    }
  }
}