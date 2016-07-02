package edu.ctpositivo.trabalho.controller;

import java.util.List;
import java.util.ArrayList;
import edu.ctpositivo.trabalho.dao.ComandaDAO;
import edu.ctpositivo.trabalho.view.home.*;

public class HomeController extends BaseController{
  public int menu(){
    ComandaDAO comandaDao = new ComandaDAO();

    List<Integer> options = new ArrayList<Integer>();
    options.add(1);
    options.add(2);
    if(comandaDao.count() > 0){
      options.add(3);
      options.add(4);
    }
    options.add(5);
    options.add(0);

    return (new MenuView(this, options)).render();
  }

  public void tchau(){
    (new TchauView(this)).render();
  }
}