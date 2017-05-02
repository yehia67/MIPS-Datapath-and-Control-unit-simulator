package mips.datapath.and.control.unit.simulator;

public class JFormat extends Instruction{
    private int opCode;
    private int address;
    
    public JFormat(String label, int mOpCode, int mAddress) {
        super(label);
        opCode = mOpCode;
        address = mAddress;
    }
    
    @Override
    public void execute() {
        
    }
}
