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
        String pcAddress = "";
        int pc = 80000;
        pcAddress = Integer.toBinaryString(pc);
        for(int i = 0; i < 32; i++) {
            pcAddress = "0" + pcAddress;
        }
        
        System.out.println(pcAddress);
    }
    
}
