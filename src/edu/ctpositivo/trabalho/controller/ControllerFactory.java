package edu.ctpositivo.trabalho.controller;

public class ControllerFactory{
  private static HomeController home;
  private static ComandasController comandas;
  private static ProdutosController produtos;
  private static ReportsController reports;

  public static HomeController getHomeController(){
    if (home == null)
      home = new HomeController();
    return home;
  }
  public static ComandasController getComandasController(){
    if (comandas == null)
      comandas = new ComandasController();
    return comandas;
  }
  public static ProdutosController getProdutosController(){
    if (produtos == null)
      produtos = new ProdutosController();
    return produtos;
  }
  public static ReportsController getReportsController(){
    if (reports == null)
      reports = new ReportsController();
    return reports;
  }
}