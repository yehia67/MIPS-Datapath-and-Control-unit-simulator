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
        switch (opCode){ 
                    case 8 :
                    this.addi();
                    break;
                    case 12:
                    this.andi();
                    break;
                    case 13 :
                    this.ori();
                    break;
                    case 35 :
                    this.lw();
                    break;
                    case 43 :
                    this.sw();
                    break;
                         case 4:
                    this.beq();
                    break;
              
        }
        
    }
    private void addi ()
    {
        rt.setData(rs.getData()+offset);
    }
     private void andi ()
    {
        rt.setData (rs.getData()&offset);
    }
      private void ori ()
    {
         rt.setData (rs.getData()|offset);
    }
       private void lw ()
    {
        
    }
        private void sw ()
    {
        
    }
              private void beq ()
    {
        //if (rs.getData()==rt.getData())
            
            
    }
}
