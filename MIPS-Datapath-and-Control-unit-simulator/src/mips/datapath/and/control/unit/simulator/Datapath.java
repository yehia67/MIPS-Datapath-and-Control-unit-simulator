package mips.datapath.and.control.unit.simulator;
public class Datapath {
    ALU alu;
    Mux mux ;
    RegisterFile register = new RegisterFile ();
    String instruction;
    SignExtend signextend;
   
    Adder addbeq;
    Memory memory = new Memory();
    ShiftLeft shift;
    int memAdress;
    int memwritedata;
    int i2521 ;
    int i2016;
    int i1511,i250,jadress,pc,addresult, muxresult;
    int i150;
    String i50;
    int readdata1,readdata2,aluresult,regwritedata,memreaddata,muxtoalu;
    boolean zero;
    String pcAddress;
    Control control;
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
    public void setInstruction (String ins, Control c)
    {
        instruction= ins;
        control = c;
        InstructionSeprator();
        excute();
    }
    private void excute()
    {
       pc = ProgramCounter.getAddress();
       pc += 4;
       pcAddressToString();
       if(control.getJump()==1) {
           String newAddress = instruction.substring(31 - 25, 31 - 0) + "00";
           newAddress = Integer.toBinaryString(pc).substring(0, 4) + newAddress;
       }
       readdata1 = register.getRegister(i2521).getData();
       readdata2 = register.getRegister(i2016).getData();
       
       if (control.getAlusrc()==0)
           muxresult = i2016;
       else 
           muxresult = i1511;
       if (control.getAlusrc()==0)
           muxtoalu= readdata2;
       else {
          muxtoalu=i150;
       }
       alu = new ALU(control.getAluop(), i50, readdata1,muxtoalu);
       zero = alu.getZero();
       aluresult = alu.getOutput();
       if(control.getBranch() == 1 && zero == true) { // lama n3ml branching 
           int branchTargetAddress = i150 * 4;
           i250 = branchTargetAddress;
           pc += branchTargetAddress;
           jadress = pc;
       }
       if(control.getMemread() == 0 && control.getMemwrite() == 0&&control.getRegwrite()==1) { // law mesh han3m load wla store 
           register.writeData(aluresult, muxresult);
       }
       if(control.getMemread() == 1) {   // lama n3ml load 
           regwritedata= memory.load(aluresult);
           memreaddata = regwritedata;
           register.writeData(regwritedata, i2016);
       }
       if (control.getMemwrite()==1){                               // lama n3ml store
           memwritedata = register.getRegister(i2016).getData();
           memory.store(aluresult, memwritedata);
       }
    }
    
    public void print() {
        System.out.println("Datapath output :-\n");
        System.out.println("PC wire holds : " + ProgramCounter.getAddress());
        System.out.println("Instruction[31-26] wire holds : " + instruction.substring(0, 7));
        System.out.println("Instruction[25 - 21] wire holds : " + i2521);
        System.out.println("Instruction[20 - 16] wire holds : " + i2016);
        System.out.println("Instruction[15 - 0] wire holds : " + i150);
        System.out.println("Instruction[5 - 0] wire holds : " + i50);
        System.out.println("read data 1 wire holds : " + readdata1);
        System.out.println("read data 2 wire holds : " + readdata2);
        System.out.println("Sign extend output wire holds : " + i150);
        System.out.println("Second input to ALU wire holds : " + muxresult);
        System.out.println("ALU result wire holds : " + aluresult);
        System.out.println("Read data output from memory wire holds : " +
                memreaddata);
        System.out.println("Output from the MemtoReg mux holds : " + regwritedata);
        System.out.println("First input wire to PC + 4 Adder holds : " + pc);
        System.out.println("First input wire to PC + 4 Adder holds : " + pc);
           
    }
    
    public void pcAddressToString() {
        pcAddress = Integer.toBinaryString(pc);
        for(int i = 0; i < 32; i++) {
            pcAddress = "0" + pcAddress;
        }
    }
}
