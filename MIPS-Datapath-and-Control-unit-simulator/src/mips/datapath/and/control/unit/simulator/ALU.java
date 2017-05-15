 package mips.datapath.and.control.unit.simulator;

public class ALU {
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
                   if(output >= 0)
                       output = 0;
                   else 
                       output = 1;
                   break;
           }
        }
    }
    
    public static int getOutput() {
        return output;
    }
    
    public static int getZeroSignal() {
        return zero;
    }
}
