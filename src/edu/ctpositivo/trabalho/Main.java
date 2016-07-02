package edu.ctpositivo.trabalho;

import edu.ctpositivo.trabalho.dao.*;
import edu.ctpositivo.trabalho.controller.*;

class Main{
  public static final void main(String[] args){
    HomeController controller = ControllerFactory.getHomeController();

    ProdutoDAO.seed();

    while(true){
      try{
        rotear(controller.menu());
      }catch(CanceladoPeloUsuarioException e){
        break;
      }
    }
    controller.tchau();
  }

  public static final void rotear(int indice) throws CanceladoPeloUsuarioException{
    switch(indice){
      case 0: //Sair
        throw new CanceladoPeloUsuarioException();
      case 1: //Nova comanda
        ControllerFactory.getComandasController().nova();
        break;
      case 2: //Listar comandas
        ControllerFactory.getComandasController().listar();
        break;
      case 3: //Detalhes da comanda
        ControllerFactory.getComandasController().mostrar();
        break;
      case 4: //Cancelar comanda
        ControllerFactory.getComandasController().excluir();
        break;
      case 5: //Total de vendas
        ControllerFactory.getReportsController().vendas();
        break;
      default:
        ControllerFactory.getHomeController().rotaInvalida();
    }
  }
}