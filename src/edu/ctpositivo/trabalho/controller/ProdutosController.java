package edu.ctpositivo.trabalho.controller;

import java.util.List;
import edu.ctpositivo.trabalho.model.Produto;
import edu.ctpositivo.trabalho.dao.ProdutoDAO;
import edu.ctpositivo.trabalho.view.produtos.*;

public class ProdutosController extends BaseController{
  public void listar(){
    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> produtos = dao.all();

    (new ListarView(this, produtos)).render();
  }
}