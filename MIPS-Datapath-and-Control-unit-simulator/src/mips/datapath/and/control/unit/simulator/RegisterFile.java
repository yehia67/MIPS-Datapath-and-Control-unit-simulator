package mips.datapath.and.control.unit.simulator;

public class RegisterFile {
    private Register[] registers;
    
    public RegisterFile() {
        registers = new Register[32];
        initializeRegisters();
    }
    
    public void initializeRegisters() {
        registers[0] = new Register("$0", 0);
        registers[1] = new Register("$at", 0);
        registers[2] = new Register("$v0", 0);
        registers[3] = new Register("$v1", 0);
        
        //initialize registers from a0-a3
        for(int i = 4, j = 0; i < 8; i++, j++) {
            registers[i] = new Register("$a" + j, 0);
        }
        
        //initialize registers from t0-t7
        for(int i = 8, j = 0; i < 16; i++, j++) {
            registers[i] = new Register("$t" + j, 0);
        }
        
        //initialize registers from s0-s7
        for(int i = 16, j = 0; i < 24; i++, j++) {
            registers[i] = new Register("$s" + j, 0);
        }
        
        //initialize registers from t8-t9
        for(int i = 24, j = 8; i < 26; i++, j++) {
            registers[i] = new Register("$t" + j, 0);
        }
        
        registers[26] = new Register("$k0", 0);
        registers[27] = new Register("$k1", 0);
        registers[28] = new Register("$gp", 0);
        registers[29] = new Register("$sp", 0);
        registers[30] = new Register("$fp", 0);
        registers[31] = new Register("$ra", 0);
        
        registers[8].setData(10);
        registers[9].setData(11);
    }
    
    public int getRegisterNum(String regName) {
        for(int i = 0; i < registers.length; i++) {
            if(registers[i].getName().equals(regName)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public void readData(int srcRegIndex, int targetRegIndex) {

        System.out.println("Read data 1 wire from regsiter" + 
                " file holds value: " + registers[srcRegIndex].getData());
        System.out.println("Read data 1 wire from regsiter" + 
                " file holds value: " + registers[targetRegIndex].getData());  
    }
    
    public void writeData(int newValue, int index) {
        
    }
}