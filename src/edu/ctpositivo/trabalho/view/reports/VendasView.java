package edu.ctpositivo.trabalho.view.reports;

import edu.ctpositivo.trabalho.view.View;
import edu.ctpositivo.trabalho.model.Report;
import edu.ctpositivo.trabalho.controller.ReportsController;

public class VendasView extends View{
  public VendasView(ReportsController controller, Report model){
    super(controller, model);
  }

  public int render(){
    Report model = (Report)this.model;
    println("------ Resumo geral ------");
    println(String.format("Vendas feitas: %d", model.getVendasFeitas()));
    println(String.format("Vendas canceladas: %d", model.getVendasCanceladas()));
    println(String.format("Total de entrada: %.2f", model.getValorTotal()));
    println("--------------------------");
    println();
    return 0;
  }
}