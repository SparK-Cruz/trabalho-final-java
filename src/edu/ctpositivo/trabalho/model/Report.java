package edu.ctpositivo.trabalho.model;

public class Report implements IModel{
  private int id;

  private int vendasFeitas;
  private int vendasCanceladas;
  private double valorTotal;

  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }

  public int getVendasFeitas(){
    return vendasFeitas;
  }
  public void setVendasFeitas(int vendasFeitas){
    this.vendasFeitas = vendasFeitas;
  }

  public int getVendasCanceladas(){
    return vendasCanceladas;
  }
  public void setVendasCanceladas(int vendasCanceladas){
    this.vendasCanceladas = vendasCanceladas;
  }

  public double getValorTotal(){
    return valorTotal;
  }
  public void setValorTotal(double valorTotal){
    this.valorTotal = valorTotal;
  }

  public IModel clone(){
    Report model = new Report();
    model.setId(id);
    model.setVendasFeitas(vendasFeitas);
    model.setVendasCanceladas(vendasCanceladas);
    model.setValorTotal(valorTotal);
    return model;
  }

  public void copy(IModel model){
    Report local = (Report)model;
    this.id = local.getId();
    this.vendasFeitas = local.getVendasFeitas();
    this.vendasCanceladas = local.getVendasCanceladas();
    this.valorTotal = local.getValorTotal();
  }
}