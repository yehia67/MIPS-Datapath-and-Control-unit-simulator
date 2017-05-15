 package mips.datapath.and.control.unit.simulator;

public class ALU {
<<<<<<< HEAD
    private static String functionCode;
    private static int ALUOp;
    private static int firstSrc,secondSrc;
    private static int output;
    private static int zero;
    public ALU() {
        
    }
    
    public static void execute(int op, String funcCode, int src1,
        int src2) {
        
        ALUOp = op;
        functionCode = funcCode;
        firstSrc = src1;
        secondSrc = src2;
       
        if(op == 0) {
          output = firstSrc + secondSrc;
          zero = 0;
        }
        else if(op == 1) {
             output = firstSrc - secondSrc;
             if(output == 0) {
                 zero = 1;
             } else {
                 zero = 0;
             }
        } else if(op == 2) {
           switch(functionCode) { 
               case "100000" :
                   output = firstSrc + secondSrc;
                   break;
               case "100010":
                   output = firstSrc - secondSrc;
                   break;
               case "100100":
                    output = firstSrc & secondSrc;
                    break;
               case "100101":
                   output = firstSrc | secondSrc;
                       break;
               case "101010":
                   output = firstSrc - secondSrc;
=======
    String ALUOP,functioncode;
    int firstsrc,secondsrc;
    private int output;
    private boolean zero;
    public ALU(String aluop,String funcod,int f, int s)
    {
        ALUOP = aluop;
        functioncode = funcod;
        firstsrc = f;
        secondsrc = s;
    }
    public void opersation(String op,String func){
        if(op.equals("00"))     // I type
        {
          output = firstsrc + secondsrc;
          zero = false;
        }
        else if(op.equals("01"))
        {
             output = firstsrc - secondsrc;
             if(output == 0) {
                 zero = true;
             } else {
                 zero = false;
             }
        } else if(op.equals("10"))
        {
           switch(functioncode) {
               case "0010" :
                   output = firstsrc + secondsrc;
                   break;
               case "0110":
                   output = firstsrc - secondsrc;
                   break;
               case "0000":
                    output = firstsrc & secondsrc;
                    break;
               case "0001":
                   output = firstsrc | secondsrc;
                       break;
               case "0111":
                   output = firstsrc - secondsrc;
>>>>>>> origin/master
                   if(output >= 0)
                       output = 0;
                   else 
                       output = 1;
                   break;
           }
        }
    }
<<<<<<< HEAD
    
    public static int getOutput() {
        return output;
    }
    
    public static int getZeroSignal() {
        return zero;
    }
=======
    public boolean getZero(){
        return zero;
    }
    public int getOutput(){
        return output;
    }
>>>>>>> origin/master
}
