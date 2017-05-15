package mips.datapath.and.control.unit.simulator;

import java.util.ArrayList;

public class Memory {
    private ArrayList <Data> Datamem = new ArrayList();
    private ArrayList <Instruction> instrucmem = new ArrayList();
    public static int c = 0, pc = 0;
    int counter = 0,PCcounter;
    public void setPC(int c)
    {
        Memory.pc = c;
    }
    public int getPC()
    {
        return pc;
    }
    
    public void addInstruction(Instruction newInstruction) {
        instrucmem.add(newInstruction);
    }
    
    public Instruction getInstruction(int address) {
        for(int i = 0; i < instrucmem.size(); i++) {
            if(instrucmem.get(i).getAddress() == address) {
                return instrucmem.get(i);
            }
        }
        
        return null;
    }
    
    /*public Memory(double x, Instruction y)
    {   
        //Datamem.set(counter, x);
        instrucmem.set(counter, y);
        counter ++;
        PCcounter += 4;
        c = counter;
        pc = PCcounter;
    }*/
    public void show()
    {
        for(int i = 0; i < Datamem.size(); i++)
        {
            System.out.println("the adress of memory is "+Datamem.get(i)+" it instruction is "+instrucmem.get(i));

        }
    }
    
    
    public int IF(int temp)
    {
        if(temp > Memory.pc)
        {
           return -1; 
        }
    return pc-temp/4;
    }
  
    public int load (int address)
    {
        for(int i = 0; i < Datamem.size(); i++) {
            if(Datamem.get(i).getAddress() == address) {
                return Datamem.get(i).getValue();
            }
        }
        
        return -1;
    }

    public void store(int address, int data)
    {
        Datamem.add(new Data(address, data));
    }
        
}

