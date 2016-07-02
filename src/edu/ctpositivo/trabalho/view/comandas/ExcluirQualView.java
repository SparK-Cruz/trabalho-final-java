package edu.ctpositivo.trabalho.view.comandas;

import edu.ctpositivo.trabalho.view.View;
import edu.ctpositivo.trabalho.controller.ComandasController;

public class ExcluirQualView extends View{
  public ExcluirQualView(ComandasController controller){
    super(controller);
  }

  public int render(){
    return entrada.readInt("Digite o número da comanda para excluir (ou 0 para cancelar)");
  }
  public int renderInvalid(){
    println("Comanda inválida");
    return 0;
  }
}