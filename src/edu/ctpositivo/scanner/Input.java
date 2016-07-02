package edu.ctpositivo.scanner;

import java.util.Scanner;

public class Input{
  private Scanner scanner;

  public Input(){
    this.scanner = new Scanner(System.in);
  }
  public Input(Scanner scanner){
    this.scanner = scanner;
  }

  public String read(String prompt){
    System.out.println(prompt);
    String value = this.scanner.nextLine();
    System.out.println("");
    return value;
  }
  public double readDouble(String prompt){
    while(true){
      System.out.println(prompt);
      try{
        double value = Double.parseDouble(this.scanner.nextLine());
        System.out.println("");
        return value;
      }catch(NumberFormatException ex){
        //loop
      }
    }
  }
  public int readInt(String prompt){
    while(true){
      System.out.println(prompt);
      try{
        int value = Integer.parseInt(this.scanner.nextLine());
        System.out.println("");
        return value;
      }catch(NumberFormatException ex){
        //loop
      }
    }
  }
  public void pause(String prompt){
    System.out.println(prompt);
    this.scanner.nextLine();
    System.out.println("");
  }
}
