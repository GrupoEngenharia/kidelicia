/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.model;

import java.util.InputMismatchException;

/**
 *
 * @author CJ
 */
public class ValidaCPF {
    public static boolean Validacao(String CPF1){
        String CPF = "";
        
        for(int i=0; i<14; i++){
           if((i == 3) || (i == 7) || (i == 11)){
               i++;
           }         
           CPF = CPF + CPF1.substring(i, i+1);
        }
        
        if(CPF.length()<11)
            return false;
        
        char dig10, dig11; //1º e 2º digito verificador
        int sm, i, r, num, peso;
        
        try{//caso não dê para transformar char em int
            //1ºDIGITO
            sm = 0;
            peso = 10;
            
            for(i=0; i<9; i++){
                num = (int)(CPF.charAt(i)-48); //48 pois estou usando tabela ASCI
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);//retorna a char
            
            //2º DIGITO
            sm = 0;
            peso = 11;
            
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
            
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
            
        }catch(InputMismatchException erro){
            return false;
        }
    }
    
    public static String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
}
