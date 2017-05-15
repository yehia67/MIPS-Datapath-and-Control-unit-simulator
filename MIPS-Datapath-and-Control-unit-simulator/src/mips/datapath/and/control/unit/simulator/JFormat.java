package mips.datapath.and.control.unit.simulator;

public class JFormat extends Instruction{
    private String operation,jaddress;
    private int address;
    
    public JFormat(String label,int instruction_address,String operation,String lbladdress){
        super(label,instruction_address);
        this.operation=operation;
        jaddress=lbladdress;
    }
    
    @Override
    public void execute(){
        switch(operation)
        {
            case "j":
                Control.setSignals(0, 0,0,0,0,0,0,0,1);
                break;
            case "jal":
                //Control.setSignals(0, 0,0,0,0,0,0,0,1);
                break;
        }
        
        generateMachineCode();
    }

    @Override
    public void generateMachineCode() {
        String machineCode = "";
        switch(operation) {
            case "jal" :
                machineCode += "000011";
                break;
            case "j" :
                machineCode += "000010";
                break;
        }
        
        machineCode += ToBinary.convertToBinary(Memory.getInstructionAddress(jaddress) / 4, 26);
        
        setMachineCode(machineCode);
    }
}