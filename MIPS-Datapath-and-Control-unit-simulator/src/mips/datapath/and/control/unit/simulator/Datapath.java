package mips.datapath.and.control.unit.simulator;

public class Datapath {
    String instruction;
    //SignExtend signextend;
   
    /*Adder addbeq;
    Memory memory;
    ShiftLeft shift;
    int memAdress;
    int memwritedata;
    int i2521 ;
    int i2016;
    int i1511,i250,jadress,pc,addresult, muxresult;
    int i150;
    String i50;
    int readdata1,readdata2,aluresult,regwritedata,memreaddata,muxtoalu;
    boolean zero;*/
    private int i2521 ;
    private int i2016;
    private int i1511,i250;
    private int i150;
    String i50;
    private int readData1, readData2;
    private int currentPCAddress = ProgramCounter.getAddress();
    private Adder pcAdder = new Adder();
    private Adder branchAdder = new Adder();
    private Mux regDstMux = new Mux();
    private Mux aluSrcMux = new Mux();
    private Mux memtoRegMux = new Mux();
    private Mux pcSrcMux = new Mux();
    private Mux jumpMux = new Mux();
    private int andGateResult;
    private int jumpAddress;
    
    public Datapath (){
    }
    
    public void InstructionSeprator ()
    {
        i2521 =Integer.parseInt( instruction.substring(31-25, 32-21),2);
        i2016 =Integer.parseInt( instruction.substring(31-20, 32-16),2);

        i1511 =Integer.parseInt( instruction.substring(31-15, 32-11),2);
        i250 =Integer.parseInt( instruction.substring(31-25, 32-0),2);
        i50 = instruction.substring(31-5, 32-0);
        i150= Integer.parseInt(instruction.substring(31-15, 32-0), 2);

    }
    public void setInstruction (String ins)
    {
        instruction= ins;
        InstructionSeprator();
        excute();
    }
    private void excute()
    {
        pcAdder.performOperation(currentPCAddress, 4);
        jumpAddress = Integer.parseInt(ToBinary.convertToBinary(pcAdder.getOutput()
                , 32).substring(0, 4) + instruction.substring(31 - 26, 32), 2);
        
        regDstMux.selectOutput(i2016, i1511, Control.getRegdst());
        
        readData1 = RegisterFile.getRegister(i2521).getData();
        readData2 = RegisterFile.getRegister(i2016).getData();
        
        aluSrcMux.selectOutput(readData2, i150, Control.getAlusrc());
        ALU.execute(Control.getAluop(), i50, readData1, aluSrcMux.getOutput());
        
        if(Control.getMemread() == 1) {
            Memory.load(ALU.getOutput());
        }
        if(Control.getMemwrite() == 1) {
            Memory.store(ALU.getOutput(), readData2);
        }
        
        memtoRegMux.selectOutput(ALU.getOutput(), Memory.getReadData(), 
                Control.getMemtoreg());
        
        if(Control.getRegwrite() == 1) {
            RegisterFile.getRegister(regDstMux.getOutput()).setData(memtoRegMux.getOutput());
        }
        
        branchAdder.performOperation(pcAdder.getOutput(), i150 * 4);
        if(Control.getBranch() == 1 && ALU.getZeroSignal() == 1) {
            andGateResult = 1;
        } else {
            andGateResult = 0;
        }
        
        pcSrcMux.selectOutput(pcAdder.getOutput(), branchAdder.getOutput(),
                andGateResult);
        jumpMux.selectOutput(jumpAddress, pcSrcMux.getOutput(), Control.getJump());
        
        ProgramCounter.setAddress(jumpMux.getOutput());
        print();
    }
    
    public void print() {
        System.out.println("Machine code : " + instruction);
        System.out.println("Current pc : " + currentPCAddress);
        System.out.println("First source for pc adder : " + currentPCAddress);
        System.out.println("second source for pc adder : 4");
        System.out.println("Wires to control unit : " + instruction.substring(0, 6));
        System.out.println("read register 1 wire : " + i2521);
        System.out.println("read register 2 wire : " + i2016);
        System.out.println("first source to regDst mux : " + i2016);
        System.out.println("sec source to regDst mux : " + i1511);
        System.out.println("regDst mux output : " + regDstMux.getOutput());
        System.out.println("input to sign extends : " + i150);
        System.out.println("read data 1 output wire : " + readData1);
        System.out.println("read data 2 output wire : " + readData2);
        System.out.println("sign extend output wire : " + i150);
        System.out.println("alusrc mux output : " + aluSrcMux.getOutput());
        System.out.println("instruction 5 - 0 wire : " + i50);
        System.out.println("alu output : " + ALU.getOutput());
        System.out.println("alu zero signal : " + ALU.getZeroSignal());
        System.out.println("wire going to write data in memory : " +readData2);
        System.out.println("read data from memory wire : " + Memory.getReadData());
        System.out.println("memtoReg mux output wire : " + memtoRegMux.getOutput());
        System.out.println("first src for branch adder wire : " + pcAdder.getOutput());
        System.out.println("second src for branch adder wire : " + i150 * 4);
        System.out.println("branch adder result wire  : " + branchAdder.getOutput());
        System.out.println("first src for jump mux : " + jumpAddress);
        System.out.println("pcsrc mux output wire : " + pcSrcMux.getOutput());
    }
    
}
