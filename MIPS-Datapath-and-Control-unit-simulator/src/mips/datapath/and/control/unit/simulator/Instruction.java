package mips.datapath.and.control.unit.simulator;

public abstract class Instruction {
    private String label;
    private String machineCode;
    private int address;
    protected Datapath dataPath = new Datapath();
    
    public Instruction(String newLabel, int mAddress) {
        label = newLabel;
        address = mAddress;
    }
    
    public String getLabel() {
        return label;
    }
    
    public int getAddress() {
        return address;
    }
    
    public void setMachineCode(String mMachineCode) {
        machineCode = mMachineCode;
    }
    
    public String getMachineCode() {
        return machineCode;
    }
    
    public abstract void generateMachineCode();
    
    public abstract void execute();
}
