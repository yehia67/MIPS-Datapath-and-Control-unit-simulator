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
    public void setControl(Control control){
        switch(operation)
        {
            case "j":
                control.setSignals(0, 0,0,0,0,0,0,0,1);
                break;
            case "jal":
                control.setSignals(2, 0, 0, 2, 0, 0, 0, 1, 1);
                break;
        }
    }

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
        
        machineCode += ToBinary.convertToBinary(Memory.getInstructionAddress(jaddress), 26);
        
        setMachineCode(machineCode);
    }
}