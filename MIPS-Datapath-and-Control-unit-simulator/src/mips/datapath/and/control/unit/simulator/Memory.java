package mips.datapath.and.control.unit.simulator;

import java.util.ArrayList;

public class Memory {
    private static ArrayList <Data> dataMem = new ArrayList();
    private static ArrayList <Instruction> instructionMem = new ArrayList();
    private static int readData;
    
    public Memory() {
    }
    
    public static void addInstruction(Instruction newInstruction) {
        instructionMem.add(newInstruction);
    }
    
    public static Instruction getInstruction(int address) {
        for(int i = 0; i < instructionMem.size(); i++) {
            if(instructionMem.get(i).getAddress() == address) {
                return instructionMem.get(i);
            }
        }
        
        return null;
    }
    
    public static int getInstructionAddress(String label) {
        for(int i = 0; i < instructionMem.size(); i++) {
            if(instructionMem.get(i).getLabel() != null && instructionMem.get(i).getLabel().equals(label)) {
                return instructionMem.get(i).getAddress();
            }
        }
        
        return -1;
    }
  
    public static void load (int address)
    {
        for(int i = 0; i < dataMem.size(); i++) {
            if(dataMem.get(i).getAddress() == address) {
                readData =  dataMem.get(i).getValue();
            }
        }
    }

    public static void store(int address, int data)
    {
        for(int i = 0; i < dataMem.size(); i++) {
            if(dataMem.get(i).getAddress() == address) {
                dataMem.get(i).setValue(data);
                return;
            }
        }
        
        dataMem.add(new Data(address, data));
    }
    
    public static int getReadData() {
        return readData;
    }
    
    public static int getInstructionMemLength() {
        return instructionMem.size();
    }
        
}

