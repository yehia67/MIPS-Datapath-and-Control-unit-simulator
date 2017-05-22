package mips.datapath.and.control.unit.simulator;

import javax.swing.JTextArea;

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
    private int i2521, i2016,i1511,i250, i106, i150 ;
    String i50;
    private int readData1, readData2;
    private int currentPCAddress;
    private Adder pcAdder = new Adder();
    private Adder branchAdder = new Adder();
    private Mux regDstMux = new Mux();
    private Mux aluSrcMux = new Mux();
    private Mux memtoRegMux = new Mux();
    private Mux pcSrcMux = new Mux();
    private Mux jumpMux = new Mux();
    private Control control = new Control();
    private ALU alu = new ALU();
    private int andGateResult;
    private int jumpAddress;
    private int clockCycles;
    private int jrCntrlUnit;
    private JTextArea txtOuputArea;
    
    StringBuffer y = new StringBuffer();
    
    public Datapath(JTextArea txtArea) { 
        RegisterFile.initializeRegisters();
        currentPCAddress = ProgramCounter.getAddress();
        txtOuputArea = txtArea;
    }
    
    public void InstructionSeprator ()
    {
        i2521 =Integer.parseInt( instruction.substring(31-25, 32-21),2);
        i2016 =Integer.parseInt( instruction.substring(31-20, 32-16),2);

        i1511 =Integer.parseInt( instruction.substring(31-15, 32-11),2);
        i250 =Integer.parseInt( instruction.substring(31-25, 32-0),2);
        i106 = Integer.parseInt(instruction.substring(31-10, 32-6), 2);
        i50 = instruction.substring(31-5, 32-0);
        if(instruction.charAt(16) == '1') {
            System.out.println(instruction.substring(31-15, 32));
            i150 = Integer.parseUnsignedInt(instruction.substring(31-15, 32-0), 2);
            i150 = i150 - (int)Math.pow(2, 16);
        } else {
            i150 = Integer.parseInt(instruction.substring(31-15, 32-0), 2);            
        }
        

    }
    
    public void executeInstructions() {
        
        int initPCValue = currentPCAddress;
        while(ProgramCounter.getAddress() < (Memory.getInstructionMemLength() *4) + initPCValue){
            Instruction currentInstruction = (Instruction)Memory.getInstruction(currentPCAddress);
            currentInstruction.setControl(control);
            currentInstruction.generateMachineCode();
            setInstruction(currentInstruction.getMachineCode());
            print();
            
            currentPCAddress = ProgramCounter.getAddress();
            clockCycles++;
        }
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
        /*String jumpStr = ToBinary.convertToBinary(pcAdder.getOutput()
                , 32).substring(0, 4) + instruction.substring(31 - 25, 32) + "00";*/
        jumpAddress = Integer.parseInt(ToBinary.convertToBinary(pcAdder.getOutput()
                , 32).substring(0, 4) + instruction.substring(31 - 25, 32) + "00", 2);
        
        if(i50.equals("001000")) {
            jrCntrlUnit = 1;
        } else {
            jrCntrlUnit = 0;
        }
        
        regDstMux.selectOutput(i2016, i1511, 31, control.getRegdst());
        
        readData1 = RegisterFile.getRegister(i2521).getData();
        readData2 = RegisterFile.getRegister(i2016).getData();
        
        aluSrcMux.selectOutput(readData2, i150, control.getAlusrc());
        alu.execute(control.getAluop(), i50, readData1, aluSrcMux.getOutput(), i106);
        
        if(control.getMemread() == 1) {
            Memory.load(alu.getOutput());
        }
        if(control.getMemwrite() == 1) {
            Memory.store(alu.getOutput(), readData2);
        }
        
        memtoRegMux.selectOutput(alu.getOutput(), Memory.getReadData(), 
                pcAdder.getOutput(), control.getMemtoreg());
        
        if(control.getRegwrite() == 1) {
            RegisterFile.getRegister(regDstMux.getOutput()).setData(memtoRegMux.getOutput());
        }
        
        branchAdder.performOperation(pcAdder.getOutput(), i150 * 4);
        if(control.getBranch() == 1 && alu.getZeroSignal() == 1) {
            andGateResult = 1;
        } else {
            andGateResult = 0;
        }
        
        pcSrcMux.selectOutput(pcAdder.getOutput(), branchAdder.getOutput(),
                andGateResult);
        jumpMux.selectOutput(pcSrcMux.getOutput(), jumpAddress, readData1, control.getJump());
        
        ProgramCounter.setAddress(jumpMux.getOutput());

    }
    
    public void print() {
        y.append("Machine code : " + instruction+"\n");
        y.append("Current pc : " + currentPCAddress+"\n");
        y.append("First source for pc adder : " + currentPCAddress+"\n");
        y.append("second source for pc adder : 4"+"\n");
        y.append("Wires input for Jr Control Block : " + i50+"\n");
        y.append("Wire output from JR Control Block : " + jrCntrlUnit+"\n");
        y.append("Wires to control unit : " + instruction.substring(0, 6)+"\n");
        y.append("read register 1 wire : " + i2521+"\n");
        y.append("read register 2 wire : " + i2016+"\n");
        y.append("first source to regDst mux : " + i2016+"\n");
        y.append("sec source to regDst mux : " + i1511+"\n");
        y.append("regDst mux output : " + regDstMux.getOutput()+"\n");
        y.append("input to sign extends : " + i150+"\n");
        y.append("read data 1 output wire : " + readData1+"\n");
        y.append("read data 2 output wire : " + readData2+"\n");
        y.append("sign extend output wire : " + i150+"\n");
        y.append("alusrc mux output : " + aluSrcMux.getOutput()+"\n");
        y.append("instruction 5 - 0 wire : " + i50+"\n");
        y.append("alu output : " + alu.getOutput()+"\n");
        y.append("alu zero signal : " + alu.getZeroSignal()+"\n");
        y.append("wire going to write data in memory : " +readData2+"\n");
        y.append("read data from memory wire : " + Memory.getReadData()+"\n");
        y.append("memtoReg mux output wire : " + memtoRegMux.getOutput()+"\n");
        y.append("first src for branch adder wire : " + pcAdder.getOutput()+"\n");
        y.append("second src for branch adder wire : " + i150 * 4+"\n");
        y.append("branch adder result wire  : " + branchAdder.getOutput()+"\n");
        y.append("second src for jump mux : " + jumpAddress+"\n");
        y.append("pcsrc mux output wire : " + pcSrcMux.getOutput()+"\n");
        y.append("Register " + RegisterFile.getRegister(regDstMux.getOutput()).getName() + 
                " value : " + RegisterFile.getRegister(regDstMux.getOutput()).getData()+"\n");
        y.append("======================="+"\n");
        
        txtOuputArea.setText(txtOuputArea.getText() + y.toString());
    }
         
    public int getClockCycles() {
        return clockCycles;
    }
    
}
