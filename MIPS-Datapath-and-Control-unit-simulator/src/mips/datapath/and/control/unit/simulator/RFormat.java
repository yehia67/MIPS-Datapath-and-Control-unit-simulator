package mips.datapath.and.control.unit.simulator;

public class RFormat extends Instruction{
    private String operation;
    private int rs;
    private int rt;
    private int rd;
    private int shamt;
    
    public RFormat(String newLabel,int mAddress,String operation,
            String rsName, String rtName, String rdName, int shamt) {
        super(newLabel, mAddress);
        this.operation = operation;
        rs = RegisterFile.getRegisterNum(rsName);
        rt = RegisterFile.getRegisterNum(rtName);
        rd = RegisterFile.getRegisterNum(rdName);
        this.shamt = shamt;
    }
    
    public void generateMachineCode() {
        String machineCode = "000000";
        String funcCode = "";
        switch(operation) {
            case "add" :
                funcCode = "100000";
                break;
            case "and" :
                funcCode = "100100";
                break;
            case "nor" :
                funcCode = "100111";
                break;
            case "or" :
                funcCode = "100101";
                break;
            case "sll" :
                funcCode = "000000";
                break;
            case "slt" :
                funcCode = "101010";
                break;
            case "jr" :
                funcCode = "001000";
                break;
        }
        
        machineCode += ToBinary.convertToBinary(rs, 5);
        machineCode += ToBinary.convertToBinary(rt, 5);
        machineCode += ToBinary.convertToBinary(rd, 5);
        machineCode += ToBinary.convertToBinary(shamt, 5);
        machineCode += funcCode;
        
        setMachineCode(machineCode);
    }
    
    @Override
    public void setControl(Control control) {
        switch(operation) {
            case "add":
                control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
                break;
            case "and":
                control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
                break;
            case "or":
                control.setSignals(1, 0, 0, 0, 2, 0, 0, 1,0);
                break;
            case "nor":
                control.setSignals(1, 0, 0, 0, 2, 0, 0, 1,0);
                break;
            case "slt":
                control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
                break;
            case "sll":
                control.setSignals(0, 0, 0, 0, 2, 0, 0, 1, 0);
                break;
            case "jr" :
                control.setSignals(0, 0, 0, 0, 0, 0, 0, 0, 2);
                break;
        }
    }
      
}
