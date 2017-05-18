 package mips.datapath.and.control.unit.simulator;

public class ALU {
    private String functionCode;
    private int ALUOp;
    private int firstSrc,secondSrc;
    private int output;
    private int zero;
    public ALU() {
        
    }
    
    
    public void execute(int op, String funcCode, int src1,
        int src2, int shamt) {
        
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
                   if(output == 0) {
                       zero = 1;
                   }
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
               case "000000" :
                   output = firstSrc << shamt;
                   break;           }
    
        } else if(op == 3)
        {
            output = firstSrc & secondSrc;
            zero = 0;
        }
        else if(op == 4)
        {
            output = firstSrc | secondSrc;
            zero = 0;
        }
     
    }
    
    public int getOutput() {
        return output;
    }
    
    public int getZeroSignal() {
        return zero;
    }
}
