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
import java.util.*;
public class MIPSDatapathAndControlUnitSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Registers[] reg = new Registers[4000];
        System.out.println("please write the registers that u want to use and it s value that hold");
        System.out.println("if u want to use a register without initialization please press 0");
        System.out.println("When u finish please press eof");
        Scanner sc = new Scanner(System.in);
        int j = 1;
        String s,rs,rt,rd;
        int imediate;
        int[] regindx =  new int [1000];
        int address  = 100;
        int pc = address;
        reg[0].data = 0;
        reg[0].name = "$0";
        while( sc.hasNextLine())
        {   
            s = sc.toString();
            if(s == "addi")
            {
                // we we intialize a value
                pc =+4;
                rs = sc.toString();
                rt = sc.toString();
               // reg[j].name = sc.toString();//rs
                
                //reg[j+1].name = sc.toString();//rt
                imediate = sc.nextInt();
                
                if( rt == "$zero" || rt == "$0")
                {
                    reg[j].name = rs;
                    reg[j+1].name = rt;
                    reg[j+1].data = 0; 
                     reg[j].data = imediate + reg[j+1].data;
                }
                else// keda register already initialize
                {
                    for(int i = 1;reg[i].data != 0; i++ )
                    {
                        if(rs == reg[i].name)
                        {
                           reg[i].data = imediate +  reg[j+1].data ; 
                        }
                    }
                }
                 j +=2;
            }
             if(s == "add")
            {
                // we we intialize a value
                
                rd = sc.toString();
                rs = sc.toString();
                rt = sc.toString();
                reg[j].name =rd;
                reg[j+1].name =rs;
                reg[j+2].name =rt;
                int holdrt = 0,holdrs = 0;
                    for(int i = 1;reg[i].data != 0; i++ )
                    {
                        if(rs == reg[i].name)
                        {
                          holdrs = reg[i].data;     
                        }
                         if(rt == reg[i].name)
                        {
                          holdrt = reg[i].data;     
                        }
                         
                    }
                    for(int i = 1; reg[i].data != 0; i++ )
                    { if(rd == reg[i].name)
                        {
                           reg[i].data = holdrt + holdrs;     
                        }    
                    }
            }
                 j +=3;
        }
        
    
    }
    }
       
        
   
      
           
       
   
        
    
    

