package mips.datapath.and.control.unit.simulator;

public class Register {
    private String name;
    private int data;
    private String binaryData ;
    
    public Register(String mName, int mData) {
        name = mName;
        data = mData;
    }
    
    public Register(String mName) {
        name = mName;
        data = 0;
    }
    
    public void setData(int newData) {
        data = newData;
       this. setBinaryData (); // law nadah 3la set bel int el 3ady 
    }
    private void  setBinaryData()
    {
        binaryData = Integer.toBinaryString(data);
    }
    public void setBinaryData (String s )
    {
        binaryData = s.trim();
        this.setData(); // 3shan law han3ml set bel binary
    }
    private void setData ()
    {
        data = Integer.parseInt(binaryData);
    }
    public String getBinaryData()
    {
        return binaryData;
    }
    public int getData() {
        return data;
    }
    
    public String getName() {
        return name;
    }
}
