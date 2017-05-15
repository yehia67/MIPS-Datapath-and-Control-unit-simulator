package mips.datapath.and.control.unit.simulator;

public class Data {
    private int address;
    private int value;
    
    public Data(int mAddress, int mValue) {
        address = mAddress;
        value = mValue;
    }
    
    public void setValue(int mValue) {
        value = mValue;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getAddress() {
        return address;
    }
}
