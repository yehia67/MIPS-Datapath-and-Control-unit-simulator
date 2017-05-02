/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips.datapath.and.control.unit.simulator;

/**
 *
 * @author mahmoud
 */
public class RFormat extends Instruction{
    private int opCode;
    private Register rs;
    private Register rt;
    private Register rd;
    private int shamt;
    private int funcCode;
    private String label ;
   // private int Address ;
  //  private int pc ;
   // private Instruction i;
    public RFormat(String newLabel,int mOpCode, Register mRs, Register mRt, 
            Register mRd, int mShamt, int mFuncCode/*, int add*/ ) {
        label = newLabel;
        
        opCode = mOpCode;
        rs = mRs;
        rt = mRt;
        
        rd = mRd;
        shamt = mShamt;
        funcCode = mFuncCode;
       // this.Address=add;
       // this.pc=add;
    }
    
    @Override
    public void execute() {
        switch (funcCode){ 
                    case 32 :
                    this.add();
                    break;
               
                    case 0 :
                    this.shift();
                    break;
                    case 42 :
                    this.slt();
                    break;
                    case 36 :
                    this.and();
                    break;
                    case 37 :
                    this.or();
                    break;
                    case 39 :
                    this.nor();
                    break;
                    case 8 :
                    this.jr();
                    break;
        }
        
    }
    private void add ()
    {
        
        rd.setData((rt.getData()+rs.getData()));
       // pc+=4;
    }
      private void shift ()
    {
     rd.setData(rs.getData()*shamt*2);
           //  pc+=4;

    }
  
          private void slt ()
    {
        if (rs.getData()<rt.getData())
            rd.setData(1);
        else rd.setData(0);
               // pc+=4;

    }
     private void and ()
      {
        rd.setData(rt.getData()&rs.getData());
              //  pc+=4;

      }
    private void or ()
    {
        rd.setData (rt.getData()|rs.getData());
             //   pc+=4;

    }
      private void nor ()
    {
        rd.setData (~(rt.getData()|rs.getData())); // me7tag at2aked menha 
          //  pc+=4;
}
      
      private void jr()
      {
         
                 
      }
      
}
