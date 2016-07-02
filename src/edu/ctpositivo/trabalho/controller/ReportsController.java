package edu.ctpositivo.trabalho.controller;

import java.util.List;
import edu.ctpositivo.trabalho.model.Report;
import edu.ctpositivo.trabalho.model.Comanda;
import edu.ctpositivo.trabalho.dao.ComandaDAO;
import edu.ctpositivo.trabalho.view.reports.*;

public class ReportsController extends BaseController{
  public void vendas(){
    int size = 0;
    int lastId = 0;
    double total = 0;

    Report report = new Report();

    ComandaDAO comandaDao = new ComandaDAO();
    List<Comanda> comandas = comandaDao.all();

    size = comandaDao.count();
    lastId = comandaDao.getLastId();

    for(Comanda comanda : comandas){
      total += comanda.getTotal();
    }

    report.setVendasFeitas(size);
    report.setVendasCanceladas(lastId - size);
    report.setValorTotal(total);

    (new VendasView(this, report)).render();
  }
}
