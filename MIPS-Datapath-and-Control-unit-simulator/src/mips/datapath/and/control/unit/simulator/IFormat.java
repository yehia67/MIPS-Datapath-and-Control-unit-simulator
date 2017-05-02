package mips.datapath.and.control.unit.simulator;

public class IFormat extends Instruction{
    private int opCode;
    private Register rs;
    private Register rt;
    private int offset;
    
    public IFormat(String label,int mOpCode, Register mRs, Register mRt,
            int mOffset) {
        super(label);
        opCode = mOpCode;
        rs = mRs;
        rt = mRt;
        mOffset = offset;
    }
    
    @Override
    public void execute() {
        
    }
}
