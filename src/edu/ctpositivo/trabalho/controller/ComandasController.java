package edu.ctpositivo.trabalho.controller;

import java.util.List;
import java.util.ArrayList;
import edu.ctpositivo.scanner.Input;
import edu.ctpositivo.trabalho.dao.*;
import edu.ctpositivo.trabalho.model.*;
import edu.ctpositivo.trabalho.view.comandas.*;

public class ComandasController extends BaseController{
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
  //Helper
  public List<ItemComanda> findItensComanda(int idComanda) throws Exception{
    return itemDao.findByIdComanda(idComanda);
  }

  public void nova(){
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
    int id = 0;
    Comanda model;
    List<ItemComanda> itens;

    MostrarQualView mostrarQualView = new MostrarQualView(this);
    id = mostrarQualView.render();
    if(id == 0)
      return;

    while(true){
      try{
        model = comandaDao.findById(id);
        itens = itemDao.findByIdComanda(id);
        break;
      }catch(Exception e){
        mostrarQualView.renderInvalid();
        id = mostrarQualView.render();
        if(id == 0)
          return;
      }
    }

    MostrarView mostrarView = new MostrarView(this, model, itens);
    mostrarView.render();
  }

  public void excluir(){
    int id = 0;
    Comanda model = null;

    ExcluirQualView excluirQualView = new ExcluirQualView(this);
    id = excluirQualView.render();
    if(id == 0)
      return;

    while(true){
      try{
        model = comandaDao.findById(id);
        break;
      }catch(Exception e){
        excluirQualView.renderInvalid();
        id = excluirQualView.render();
        if(id == 0)
          return;
      }
    }

    comandaDao.delete(id);
    ExcluirView excluirView = new ExcluirView(this);
    excluirView.render();
  }
}