package mips.datapath.and.control.unit.simulator;

public class Register {
    private String name;
    private int data;
    private int registerIndex;
    
    public Register(String mName, int mData, int index) {
        name = mName;
        data = mData;
        registerIndex = index;
    }
    
    public Register(String mName) {
        name = mName;
        data = 0;
    }
    
    public void setData(int newData) {
        if(!(registerIndex == 0))
            data = newData;
    }
    
    public int getData() {
        return data;
    }
    
    public String getName() {
        return name;
    }
    
    public int getRegisterIndex() {
        return registerIndex;
    }
}
