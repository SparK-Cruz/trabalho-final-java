package edu.ctpositivo.trabalho.dao;

import java.util.List;
import edu.ctpositivo.trabalho.model.Produto;

public class ProdutoDAO extends BaseDAO<Produto>{
  private static int nextId = 1;
  protected static List<Object> records;

  protected int getNextId(){
    return nextId++;
  }
  protected List<Object> getRecords(){
    return records;
  }
  protected void setRecords(List<Object> list){
    records = list;
  }

  public static void seed(){
    ProdutoDAO dao = new ProdutoDAO();

    Produto p1 = new Produto();
    p1.setNome("Batata");
    p1.setValor(12);
    p1.setTipo(Produto.Tipo.COMIDA);
    dao.create(p1);

    Produto p2 = new Produto();
    p2.setNome("Coca-cola");
    p2.setValor(6);
    p2.setTipo(Produto.Tipo.BEBIDA);
    dao.create(p2);

    Produto p3 = new Produto();
    p3.setNome("Hamburger");
    p3.setValor(15);
    p3.setTipo(Produto.Tipo.COMIDA);
    dao.create(p3);

    Produto p4 = new Produto();
    p4.setNome("Yogurte");
    p4.setValor(2.75);
    p4.setTipo(Produto.Tipo.SOBREMESA);
    dao.create(p4);
  }
}