 import java.util.Scanner;
 // isso 
 public class Main {   
    public static void main(String[] args) { 
        Scanner leitor = new Scanner(System.in); 
        String formula; 
        boolean tabOk = false; 

        TabelaVerdade tb = new TabelaVerdade(); 

        System.out.print("Entre com a formula: ");
        formula = leitor.nextLine(); 
        formula = formula.toLowerCase(); 

        switch(formula.length()) {  
        case 1:
            tabOk = tb.achaFormulaCom1Variavel(formula);
            break;
        case 2:
            tabOk = tb.achaFormulaCom1Variavel(formula);
            break;
        case 3: 
            tabOk = tb.achaFormulaCom2Variaveis(formula);
            break;
        case 4: 
            tabOk = tb.achaFormulaCom2Variaveis(formula); 
            break;
        case 5:
            if (formula.charAt(0)!= '~')
                tabOk = tb.achaFormulaCom2Variaveis(formula);
                break;
        case 6:
            tabOk = tb.achaFormulaCom3Variaveis(formula); 
            break;
        case 7:
            tabOk = tb.achaFormulaCom3Variaveis(formula); 
            break;
        case 8:
            tabOk = tb.achaFormulaCom3Variaveis(formula); 
            break;

        default: 
            tabOk = false; 
        }
        if (!tabOk) 
        leitor.close();

      }}

// importar classe scanner para facilitar a entrada de dados

