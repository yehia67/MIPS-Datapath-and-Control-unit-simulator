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
        Registers[] x = new Registers[1000];
        System.out.println("please write the registers that u want to use and it s value that hold");
        System.out.println("if u want to use a register without initialization please press 0");
        System.out.println("When u finish please press eof");
        Scanner sc = new Scanner(System.in);
        int j = 0;
        String s;
        while( sc.hasNextLine())
        {   
            System.out.print(" name of register is ..");
            x[j].name = sc.toString();
            System.out.println("");
            if(x[j].name != "eof")
            {
                break;
            }
            System.out.print(" value of register is ..");
            x[j].data = sc.nextInt();
            System.out.println("");
            
            j++;
        }
  
    }
    
}
