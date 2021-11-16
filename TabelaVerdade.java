import java.util.Scanner; 

// criacao da classe TabelaVerdade, principal classe da funcao 

public class TabelaVerdade { 
    // criacao de uma classe que vai receber um valor booleano e retornar v ou f, de acordo com a classe
    // o char tem funcao de receber como atributo uma letra em específica, no caso V ou F, representativas como verdadeira ou falso
    public char printBit(boolean p) {
      if (p)
        return 'V'; 
      else 
        return 'F';
    }
  // agora sera criado uma funcao void que retornará um print com "formula correta"

    public void printFormula (String formulaCorreta) {
      System.out.print(" (" + formulaCorreta + ") ");
    }

    // criacao de outra funcao com o nome tabelaUmLiberal que terá como finalidade imprimir a tabela verdade com apenas uma variavel

    public void tabelaUmLiteral(String formulaCorreta) {
      int i;
      // atribuir valor booleano para p e resp 
      boolean p, resp; 

      System.out.println("+---+");
      System.out.print  ("| p |");
      // aqui vou estar chamando a função FormulaCorreta
      printFormula (formulaCorreta);
      System.out.println(); 
      System.out.println("+---+");

    // dentro dessa funcao vou definir um for que tem como objetivo percorrer a funcao e analisar os valores booleanos ainda nao definidos nela
      for (i = 1; i >= 0; i--) {
        // o switch funciona como if, no caso se I, e tem os casos que estao definidos, no primeiro case  = 1, p será true e automaticamente o for parará, caso 

          switch (i) {
          case 1:
            p = true; 
            break; 
          default:
            p = false; 
          }

          // aqui sera criado um condicional trnario no qual x irá receber uma expressao booleana 

          resp = (formulaCorreta.charAt(0)=='~')? !p : p; 
          System.out.print ("| " + printBit(p) + " |  ");
          System.out.println(printBit(resp) );

      }
    // aqui vou fazer um print que irá dividir a linha
      System.out.println("+----+");

    }

    // a proxima funcao será uma tabela com dois literais, imprime tabela verdade de formula com duas variaveis 

    public void tabelaDoisLiterais(String formulaCorreta) {
      int i; 
      boolean p, q, resp = true;

      System.out.println("+---+---+");
      // aqui o system out esta printando as duas variaveis 
      System.out.print  ("| p | q |");
      printFormula (formulaCorreta); 
      System.out.println();
      // aqui o system out fará uma quebra de linha
      System.out.println("+---+---+");
      // vamos criar um novo for que ira iniciar no 3 e irá diminuir com o passar do tempo 
      for (i = 3; i >= 0; i--) {
        switch (i) {
        case 3: 
        // aqui sera atribuido os casos que ocorreram, em todas as opcoes de p e q, se for verdadeiro ou falso 
          p = true; q = true;
          break;
        case 2: 
          p = true; q = false; 
          break; 
        case 1: 
          p = false; q = true; 
          break; 
        default: 
          p = false; q = false; 
        }

        //aqui esta a definicao dos if's que irao ser responsaveis por organizar o codigo junto com ou and necessário
        if (formulaCorreta.length() == 3)
            resp = formulaCorreta.charAt(1) == '^'? p && q: p || q;
          else if (formulaCorreta.length() == 4) {
                  if (formulaCorreta.charAt(0)=='~')
                      resp = formulaCorreta.charAt(2) == '^'? (!p && q) : (!p || q);
                  else if (formulaCorreta.charAt(2)=='˜')
                      resp = formulaCorreta.charAt(1) == 'ˆ'? (p && !q): (p || !q);
            else if (formulaCorreta.length() == 5) {
          }
          
          }

          // o print aqui vai ser responsavel por printar o código do console junto com as barrinhas que serao organizadas 

          System.out.print  ("| "    + printBit(p) + " | " + printBit(q) );
          System.out.println(" |  "  + printBit(resp) );
      }
      System.out.println("+---+---+");
    }

// agora sera criado a classe responsavel pela tabela que contera tres literais 
    public void tabelaTresLiterais (String formulaCorreta) { 
  // primeiro atribuimos o i como valor inteiro para que ele corresponda como igual na hora que criar o for 
      int i; 
      boolean p, q, r, resp;

      System.out.println("+----+----+----+");
      System.out.println("| p | q | r | " );
      System.out.println("+----+----+----+");
// aqui sera realizado o for responsavel pela tabela com 3 literais 
      for (i = 7; i >= 0; i--) {
        switch (i) {
        case 7: 
            p = true; q = true; r = true; 
            break;
        case 6: 
            p = true; q = true; r = false; 
            break;
        case 5: 
            p = true; q = false; r = true; 
            break;
        case 4: 
            p = true; q = false; r = false; 
            break;
        case 3: 
            p = false; q = true; r = true; 
            break;
        case 2: 
            p = false; q = false; r = true; 
            break;
        case 1: 
            p = false; q = false; r = false; 
            break;
        default: 
            p = false; q = false; r = false;
        }

        resp = true; 
        System.out.print  ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
        System.out.println("| " + printBit(resp)  );
    }
    System.out.println("+----+----+----+"); 
  }

  public boolean achaFormulaCom1Variavel(String formula) {
      if ((formula.charAt(0) == '~' && formula.charAt(1) == 'p')|| 
          (formula.charAt(0) == 'p' && formula.length()   == 1)) {
          tabelaUmLiteral (formula);
          return true;
      }else
          return false;
  }

  public boolean achaFormulaCom2Variaveis(String formula) {
    boolean formOk; 
    if ((formula.length() == 3) &&
        (formula.charAt(0) == 'p') &&
        (formula.charAt(2) == 'q')) {
          if ((formula.charAt(1) == '^') ||
              (formula.charAt(1) == 'v'))
              formOk = true; 
          else 
              formOk = false; 
        }else if ((formula.length() == 4) &&
                  (formula.charAt(0) == '~') &&
                  (formula.charAt(1) == 'p') &&
                  (formula.charAt(3) == 'q')) {
                    if ((formula.charAt(2) == '^') ||
                        (formula.charAt(2) == 'v'))
                        formOk = true;
                    else
                        formOk = false;
        }else if ((formula.length()  == 4) &&
                  (formula.charAt(0) == 'p') &&
                  (formula.charAt(2) == '~') &&
                  (formula.charAt(3) == 'q')) {
                    if ((formula.charAt(1) == '^')  ||
                        (formula.charAt(1) == 'v'))
                        formOk = true;
                    else
                        formOk = false;
        }else if ((formula.length()  == 5) &&
                  (formula.charAt(0) == '~') &&
                  (formula.charAt(1) == 'p') &&
                  (formula.charAt(3) == '~') &&
                  (formula.charAt(4) == 'q')) {
                    if ((formula.charAt(2) == '^')  ||
                        (formula.charAt(2) == 'v'))
                        formOk = true;
                    else
                        formOk = false;
        }else

                formOk = false; 
        tabelaDoisLiterais(formula);
        return formOk;
    }

    public boolean achaFormulaCom3Variaveis(String formula){
       boolean formOk;
       
       //Se a formula tiver 5 caracteres p AND/OR q AND/OR r.
       if((formula.length() == 5) &&
           (formula.charAt(0) == 'p') &&
           (formula.charAt(2) == 'q') &&
           (formula.charAt(4) == 'r') &&
           ((formula.charAt(1) == '^') ||
            (formula.charAt(1) == 'v')) &&
           ((formula.charAt(3) == '^') ||
            (formula.charAt(3) == 'v'))) {
        } else if (formula.length() == 6){
              switch(formula.indexOf('~')) {
               case 0:
                    if((formula.charAt(1) == 'p') &&
                        (formula.charAt(3) == 'q') &&
                        (formula.charAt(5) == 'r') &&
                        ((formula.charAt(2) == '^') ||
                         (formula.charAt(2) == 'v')) &&
                        ((formula.charAt(4) == '^') ||
                        (formula.charAt(4) == 'v'))){
                             formOk = true;
                    }else { 
                             formOk = false; }
                case 2:
                   if((formula.charAt(0) == 'p') &&
                        (formula.charAt(3) == 'q') &&
                        (formula.charAt(5) == 'r') &&
                        ((formula.charAt(1) == '^') ||
                         (formula.charAt(1) == 'v')) &&
                        ((formula.charAt(4) == '^') ||
                        (formula.charAt(4) == 'v'))){
                             formOk = true;
                        } else { 
                             formOk = false; }
                 case 3:
                    if((formula.charAt(0) == 'p') &&
                        (formula.charAt(2) == 'q') &&
                        (formula.charAt(5) == 'r') &&
                        ((formula.charAt(1) == '^') ||
                         (formula.charAt(1) == 'v')) &&
                        ((formula.charAt(3) == '^') ||
                        (formula.charAt(3) == 'v'))){
                             formOk = true;
                       }  else { 
                             formOk = false; }
                 default:
                    formOk = false;
                 }
              } else if (formula.length() == 7) {
                  switch(formula.indexOf('~')) {
                   case 0:
                       if((formula.charAt(1) == 'p') &&
                         (formula.charAt(3) == '~') &&
                        (formula.charAt(4) == 'q') &&
                        (formula.charAt(6) == 'r') &&
                        ((formula.charAt(2) == '^') ||
                         (formula.charAt(2) == 'v')) &&
                        ((formula.charAt(5) == '^') ||
                        (formula.charAt(5) == 'v'))){
                             formOk = true;
                         } else if ((formula.charAt(1) == 'p') &&
                        (formula.charAt(3) == 'q') &&
                        (formula.charAt(5) == '~') &&
                        (formula.charAt(6) == 'r') &&
                        ((formula.charAt(2) == '^') ||
                         (formula.charAt(2) == 'v')) &&
                        ((formula.charAt(4) == '^') ||
                        (formula.charAt(4) == 'v'))){
                             formOk = true;
                         } else {
                              formOk = false; }
                   case 2: 
                        if ((formula.charAt(0) == 'p') &&
                        (formula.charAt(3) == 'q') &&
                        (formula.charAt(5) == '~') &&
                        (formula.charAt(6) == 'r') &&
                        ((formula.charAt(1) == '^') ||
                         (formula.charAt(1) == 'v')) &&
                        ((formula.charAt(4) == '^') ||
                        (formula.charAt(4) == 'v'))){
                             formOk = true;
                         } else {
                              formOk = false; }
                   default: 
                       formOk = false;
                  }
              } else if ((formula.length() == 8) &&               (formula.charAt(0) == '~') &&
                        (formula.charAt(1) == 'p') &&
                        (formula.charAt(3) == '~') &&
                        (formula.charAt(4) == 'q') &&
                        (formula.charAt(6) == '~') &&
                        (formula.charAt(7) == 'r') &&
                        ((formula.charAt(2) == '^') ||
                         (formula.charAt(2) == 'v')) &&
                        ((formula.charAt(5) == '^') ||
                        (formula.charAt(5) == 'v'))){
                             formOk = true;
                         } else {
                              formOk = false; 
                  }
                formOk = false; 
        tabelaTresLiterais(formula);
        return formOk;
}
}
    