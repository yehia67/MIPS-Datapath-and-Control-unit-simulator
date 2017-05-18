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


import java.util.Scanner;

public class MIPSDatapathAndControlUnitSimulator {

    public static void main(String[] args) {
        RegisterFile.initializeRegisters();
        //addi $t1,$0,100
        IFormat addi = new IFormat(null, 0,"addi", "$t1", "$0", 100);
        
        //addi.execute();
    }
    
}
