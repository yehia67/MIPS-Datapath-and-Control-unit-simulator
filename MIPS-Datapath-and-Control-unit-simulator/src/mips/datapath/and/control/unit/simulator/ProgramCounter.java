package mips.datapath.and.control.unit.simulator;

public class ProgramCounter {
    private static int address;
    
    public ProgramCounter(int mAddress) {
        address = mAddress;
    }
    
    public static int getAddress() {
        return address;
    }
    
    public static void setAddress(int mAddress) {
        address = mAddress;
    }
}
