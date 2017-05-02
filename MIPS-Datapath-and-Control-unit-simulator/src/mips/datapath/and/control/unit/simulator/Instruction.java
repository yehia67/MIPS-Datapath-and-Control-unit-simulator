/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips.datapath.and.control.unit.simulator;

/**
 *
 * @author mahmoud
 */
public abstract class Instruction {
    private String label;
    
    public Instruction(String newLabel) {
        label = newLabel;
    }
    
    public Instruction() {
        this(null);
    }
    
    public String getLabel() {
        return label;
    }
    
    public abstract void execute();
}
