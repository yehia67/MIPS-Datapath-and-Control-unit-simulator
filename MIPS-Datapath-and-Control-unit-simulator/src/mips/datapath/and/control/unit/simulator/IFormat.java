package mips.datapath.and.control.unit.simulator;

public class IFormat extends Instruction{
    private int opCode;
    private Register rs;
    private Register rt;
    private int offset;
    private Control control;
    public IFormat(String label,int address,
            int mOpCode, Register mRs, Register mRt
           /* int mOffset*/, Control c) {
        super(label, address);
        opCode = mOpCode;
        rs = mRs;
        rt = mRt;
        control = c;
       // mOffset = offset;
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
         control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
    }
     private void andi ()
    {
        rt.setData (rs.getData()&offset);
        control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
    }
      private void ori ()
    {
         rt.setData (rs.getData()|offset);
         control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
    }
       private void lw ()
    {
      control.setSignals(0, 0, 1, 0, 0, 0, 1, 0, 0);  
    }
        private void sw ()
    {
      control.setSignals(0, 0, 0, 0, 0, 1, 1, 0, 0);   
    }
              private void beq ()
    {
        //if (rs.getData()==rt.getData())
            control.setSignals(0, 1, 0, 0, 1, 0,0, 0, 0); 
            
    }
}
