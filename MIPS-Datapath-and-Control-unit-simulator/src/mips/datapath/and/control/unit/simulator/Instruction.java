package mips.datapath.and.control.unit.simulator;

public abstract class Instruction {
    private String label;
    private String machineCode;
    private ProgramCounter programCounter;
    private int address;
    protected int aluOutput;
    protected int memOuput;
    protected int pcAdderOutput;
    protected int branchAdderOutput;
    protected Memory memory;
    protected RegisterFile registers;
    protected Adder pcAdder;
    protected Adder branchAdder;
    protected Mux mux;
    protected ALU alu;
    protected ShiftLeft shiftLeft;
    protected SignExtend signExtend;
    
    public Instruction(String newLabel, int mAddress) {
        label = newLabel;
        address = mAddress;
    }
    
    public Instruction(int address, ProgramCounter mProgramCounter) {
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
    
    //public abstract void generateMachineCode();
    
    public abstract void execute();
}
