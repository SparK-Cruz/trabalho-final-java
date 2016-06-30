package edu.ctpositivo.trabalho.controller;

import java.util.List;
import java.util.ArrayList;
import edu.ctpositivo.scanner.Input;
import edu.ctpositivo.trabalho.dao.*;
import edu.ctpositivo.trabalho.model.*;

public class ComandasController{
  private static ComandaDAO comandaDao = new ComandaDAO();
  private static ItemComandaDAO itemDao = new ItemComandaDAO();
  private static ProdutoDAO produtoDao = new ProdutoDAO();

  //Helper
  public Produto findProduto(int idProduto) throws Exception{
    return produtoDao.findById(idProduto);
  }
  //Helper
  public Comanda findComanda(int idComanda) throws Exception{
    return comandaDao.findById(idComanda);
  }

  public void nova(Input entrada){
    Comanda model = new Comanda();
    List<ItemComanda> itens;

    ControllerFactory.getProdutosController().listar();
    NovaView novaView = new NovaView(this, model);
    novaView.render();

    itens = novaView.getItens();

    comandaDao.create(model);
    for(ItemComanda item : itens){
      item.setIdComanda(model.getId());
      itemDao.create(item);
    }

    ConfirmarNovaView confirmarNovaView = new ConfirmarNovaView(this, model);
    confirmarNovaView.render();
  }

  public void listar(){
    List<Comanda> comandas = comandaDao.all();

    ListarView listarView = new ListarView(this, comandas);
    listarView.render();
  }

  public void mostrar(){
    //entrada.readInt("Digite o número da comanda para exibir");
    Comanda model = null;
    try{
      model = comandaDao.findById(id);
    }catch(Exception e){
      System.out.println("Comanda inválida");
      return;
    }

    int indice = 1;
    double total = 0;
    List<ItemComanda> itens = itemDao.findByIdComanda(id);

    System.out.println(String.format("------ Comanda nº %d ------", model.getId()));
    System.out.println(String.format("%3s\t%s\t%10s\t%9s\t%s\t%s\t%s",
      "", "código", "nome", "tipo", "preço", "qtd", "total"));
    for(ItemComanda item : itens){
      mostrarItem(indice++, item);
      try{
        total += item.getTotal();
      }catch(Exception e){
        //Produto inválido?
      }
    }
    System.out.println("--------------------------");
    System.out.println(String.format("Total: %.2f",
      total));
  }

/*
  public void excluir(int id){
    //entrada.readInt("Digite o número da comanda para cancelar")
    Comanda model = null;
    try{
      model = comandaDao.findById(id);
    }catch(Exception e){
      System.out.println("Comanda inválida");
      return;
    }

    comandaDao.delete(id);
    System.out.println("Comanda cancelada com sucesso");
  }

  //private

  private void mostrarItem(ItemComanda item){
    mostrarItem(0, item);
  }
  private void mostrarItem(int indice, ItemComanda item){
    Produto produto = null;
    try{
      produto = item.getProduto();

      if(indice <= 0){
        System.out.println(String.format("%d\t%10s\t%9s\t%.2f\t%d\t%.2f",
          produto.getId(), produto.getNome(), produto.getTipo().getDescricao(), produto.getValor(), item.getQuantidade(), item.getTotal()));
        return;
      }

      System.out.println(String.format("%d\t%d\t%10s\t%9s\t%.2f\t%d\t%.2f",
        indice, produto.getId(), produto.getNome(), produto.getTipo().getDescricao(), produto.getValor(), item.getQuantidade(), item.getTotal()));

    }catch(Exception e){
      System.out.println("Produto inválido");
      return;
    }
  }
  */
}