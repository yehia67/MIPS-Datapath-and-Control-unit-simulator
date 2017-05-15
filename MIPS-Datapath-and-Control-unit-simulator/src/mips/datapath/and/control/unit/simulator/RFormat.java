package mips.datapath.and.control.unit.simulator;

public class RFormat extends Instruction{
    private String operation;
    private int rs;
    private int rt;
    private int rd;
    private int shamt;
    private Control control;
    public RFormat(String newLabel,int mAddress, 
            ProgramCounter mProgramCounter, String operationName, String srcReg,
            String targetReg, String dstReg, int mShamt, Control c ) {
        super(newLabel, mAddress);
        operation = operationName;
        rs = registers.getRegisterNum(srcReg);
        rt = registers.getRegisterNum(targetReg);
        rd = registers.getRegisterNum(dstReg);
        shamt = mShamt;
        control = c;
        //generateMachineCode();
    }
    
    /*@Override
    public void generateMachineCode() {
        String machineCode = "000000";
        switch(operation) {
            case "add":
                machineCode += Integer.toBinaryString(rs.getRegisterIndex());
                machineCode += 
        }
    }*/
    
    @Override
    public void execute() {
        switch(operation) {
            case "add":
                add();
                break;
            case "and":
                and();
                break;
            case "or":
                or();
                break;
            case "nor":
                nor();
                break;
            case "slt":
                slt();
                break;
            case "sll":
                //sll();
                break;
        }
    }
    
//    public void printRegisterFileWires() {
//        System.out.println("Read register 1 wire: " + rs.getRegisterIndex());
//        System.out.println("Read register 2 wire: " + rt.getRegisterIndex());
//        System.out.println("Write register wire: " + rd.getRegisterIndex());
//    }
//    
//    public void printRegDstMux() {
//        System.out.println("First input to RegDst mux: " + rt.getRegisterIndex());
//        System.out.println("Second input to RegDst mux: " +
//                rd.getRegisterIndex());
//    }
//    
//    public void printALUSrcMux() {
//        System.out.println("First input to ALUSrc mux: " + rt.getData());
//    }
//    
//    public void printALUWires() {
//        System.out.println("First input to ALU: " + rs.getData());
//        System.out.println("Second input to ALU: " + rt.getData());
//    }
//    public void printMemtoRegMux(int firstSrc, int secSrc) {
//        System.out.println("First input to MemtoReg mux: " + firstSrc);
//        System.out.println("Second input to MemtoReg mux: " + secSrc);
//    }
    private void add() {
        control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
    }
      private void shift ()
    {
    // rd.setData(rs.getData()*shamt*2);
     // control.setSignals(1, 0, 0, 0, 2, 0, 0, 1);
           //  pc+=4;

    }
  
          private void slt ()
    {
        /*if (rs.getData()<rt.getData())
            rd.setData(1);
        else rd.setData(0);*/
               // pc+=4;
        control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
    }
     private void and ()
      {
        //rd.setData(rt.getData()&rs.getData());
              //  pc+=4;
            control.setSignals(1, 0, 0, 0, 2, 0, 0, 1, 0);
      }
    private void or ()
    {
       // rd.setData (rt.getData()|rs.getData());
             //   pc+=4;
 control.setSignals(1, 0, 0, 0, 2, 0, 0, 1,0);
    }
      private void nor ()
    {
        //rd.setData (~(rt.getData()|rs.getData())); // me7tag at2aked menha 
          //  pc+=4;
           control.setSignals(1, 0, 0, 0, 2, 0, 0, 1,0);
}
      
      private void jr()
      {
         
                 
      }
      
}
