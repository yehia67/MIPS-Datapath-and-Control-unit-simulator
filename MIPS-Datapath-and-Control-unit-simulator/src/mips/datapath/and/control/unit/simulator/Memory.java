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
    private ArrayList <Data> Datamem;
    private ArrayList <Instruction> instrucmem;// 27tmal n3'ayr el data type di ama nygy n3ml class ll instruction
    public static int c = 0, pc = 0;// pc b3dyn haswyha bl adrress
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
>>>>>>> origin/master
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
            
    public Memory(double x, Instruction y)
    {   
        //Datamem.set(counter, x);
        instrucmem.set(counter, y);
        counter ++;
        PCcounter += 4;
        c = counter;
        pc = PCcounter;
    }
    public void show()
    {
        for(int i = 0; i < Datamem.size(); i++)
        {
            System.out.println("the adress of memory is "+Datamem.get(i)+" it instruction is "+instrucmem.get(i));

        }
        
        return -1;
    }

    public static void load (int address)
    {
        for(int i = 0; i < Datamem.size(); i++) {
            if(Datamem.get(i).getAddress() == address) {
                readData =  Datamem.get(i).getValue();
            }

    
    
    public int IF(int temp)
    {
        if(temp > Memory.pc)
        {
           return -1; 
        }
    return pc-temp/4;
    }


    public static void store(int address, int data)
    {
        Datamem.add(new Data(address, data));
    }
    
    public static int getReadData() {
        return readData;
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
>>>>>>> origin/master
        
}

