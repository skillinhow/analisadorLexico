/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.analisadorlexico.model;

import java.util.regex.Pattern;
/**
 *
 * @author Alyson Dantas e Fada Cardoso
 */
public class Analisador {
    private static final Pattern number = Pattern.compile("[-]?\\s*(\\d)+(\\.\\d+)?");
    private static final Pattern digit = Pattern.compile("[0-9]");
    private static final Pattern identific = Pattern.compile("[a-zA-Z]([a-zA-Z]|[0-9]|\\_)*");
    private static final Pattern letter = Pattern.compile("[a-zA-Z]");
    private static final Pattern reserved = Pattern.compile("bool|class|const|else|extends|false|float|if|int|main|method|read|return|string|then|true|variables|void|while|write");
    private static final Pattern mathoperators = Pattern.compile("\\+|\\-|\\++|\\--|\\*|\\/");
    private static final Pattern reloperators = Pattern.compile("\\!=|\\==|\\>|\\<|\\>=|\\<=|\\=");
    private static final Pattern logoperators = Pattern.compile("\\!|\\&\\&|\\|\\|");
    private static final Pattern delimiters = Pattern.compile("\\x3b|\\x2c|\\x28|\\x29|\\x5b|\\x5d|\\x7b|\\x7d|\\x2e");
    private static final Pattern chararray = Pattern.compile("\\\" |[a-zA-Z]|[\\x20-\\x7e]*");
    private static final Pattern simbol = Pattern.compile("[\\x20-\\x21]*|[\\x23-\\x7e]*");
    private static final Pattern space = Pattern.compile("\\s");
    
    
    
    public static boolean validarNumero(String palavra) {
        return number.matcher(palavra).matches();
    }
    
    public static boolean validarDigito(String palavra) {
        return digit.matcher(palavra).matches();
    }
    
    public static boolean validarIdentificador(String palavra) {
        return identific.matcher(palavra).matches();
    }
    
    public static boolean validarPalavrasReservadas(String palavra) {
        return reserved.matcher(palavra).matches();
    }
    
    public static boolean validarLetra(String palavra) {
        return letter.matcher(palavra).matches();
    }
    
    public static boolean validarOperadoresAritimeticos(String palavra) {
        return mathoperators.matcher(palavra).matches();
    }
    
    public static boolean validarOperadoresRelacionais(String palavra) {
        return reloperators.matcher(palavra).matches();
    }
    
    public static boolean validarOperadoresLogicos(String palavra) {
        return logoperators.matcher(palavra).matches();
    }
    
    public static boolean validarDelimitadores(String palavra) {
        return delimiters.matcher(palavra).matches();
    }
    
    public static boolean validarCadeiaCaracteres(String palavra) {
        return chararray.matcher(palavra).matches();
    }
    
    public static boolean validarSimbolos(String palavra) {
        return simbol.matcher(palavra).matches();
    }
    
    public static boolean validarEspaco(String palavra) {
        return space.matcher(palavra).matches();
    }

    public void verificador(String palavra){
        if (validarPalavrasReservadas(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Palavra Reservada>\n");
        }else if (validarIdentificador(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Identificador>\n");
        }else if (validarNumero(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Número>\n");
        }else if (validarDigito(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Digito>\n");
        }else if (validarLetra(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Letra>\n");
        }else if (validarOperadoresAritimeticos(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Operador Aritmético>\n");
        }else if (validarOperadoresRelacionais(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Operador Relacional>\n");
        }else if (validarOperadoresLogicos(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Operador Lógico>\n");
        }else if (validarDelimitadores(palavra)) {
            System.out.println("Token <"+palavra+"> Classificação <Delimitador>\n");
        }
                
    }
}
