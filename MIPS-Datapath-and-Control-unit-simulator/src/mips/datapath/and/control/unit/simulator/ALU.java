/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips.datapath.and.control.unit.simulator;

/**
 *
 * @author Sony
 */
public class ALU {
    String ALUOP,functioncode;
    int firstsrc,secondsrc;
    public ALU(String aluop,String funcod,int f, int s)
    {
        ALUOP = aluop;
        functioncode = funcod;
        firstsrc = f;
        secondsrc = s;
    }
    public int opersation(String op,String func){
        if(op == "00")    // I type
        {
          return firstsrc + secondsrc;
        }
        else if(op == "01")
        {
             return firstsrc - secondsrc;
        }
       
        else if(func + op == "0000")
        {
           if(secondsrc > 0 && firstsrc > 0)
           {
               return 1;
           }
           else
           {
               return 0;
           }
        }
        else if(func + op == "0001")
        {
            if(secondsrc > 0 || firstsrc > 0)
           {
               return 1;
           }
           else
           {
               return 0;
           }
        }
        else if(func + op == "0111")
        {
            return firstsrc - secondsrc;
        }
        else 
            return 9999; //error
            }
    
    
    
}
