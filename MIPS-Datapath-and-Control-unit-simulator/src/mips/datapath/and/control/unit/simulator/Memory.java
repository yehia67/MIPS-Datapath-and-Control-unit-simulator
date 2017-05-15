package mips.datapath.and.control.unit.simulator;

import java.util.ArrayList;

public class Memory {
    private static ArrayList <Data> Datamem = new ArrayList();
    private static ArrayList <Instruction> instrucmem = new ArrayList();
    private static int readData;
    
    public static void addInstruction(Instruction newInstruction) {
        instrucmem.add(newInstruction);
    }
    
    public static Instruction getInstruction(int address) {
        for(int i = 0; i < instrucmem.size(); i++) {
            if(instrucmem.get(i).getAddress() == address) {
                return instrucmem.get(i);
            }
        }
        
        return null;
    }
    
    public static int getInstructionAddress(String label) {
        for(int i = 0; i < instrucmem.size(); i++) {
            if(instrucmem.get(i).getLabel() != null && instrucmem.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        
        return -1;
    }
  
    public static void load (int address)
    {
        for(int i = 0; i < Datamem.size(); i++) {
            if(Datamem.get(i).getAddress() == address) {
                readData =  Datamem.get(i).getValue();
            }
        }
    }

    public static void store(int address, int data)
    {
        Datamem.add(new Data(address, data));
    }
    
    public static int getReadData() {
        return readData;
    }
        
}

