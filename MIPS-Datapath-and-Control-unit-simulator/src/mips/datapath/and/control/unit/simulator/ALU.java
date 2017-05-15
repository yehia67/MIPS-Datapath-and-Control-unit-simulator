 package mips.datapath.and.control.unit.simulator;

public class ALU {
    String functioncode;
    int ALUOp;
    int firstsrc,secondsrc;
    private int output;
    private boolean zero;
    public ALU(int aluop,String funcod,int f, int s)
    {
        ALUOp = aluop;
        functioncode = funcod;
        firstsrc = f;
        secondsrc = s;
    }
    public void operation(int op,String func){
        if(op == 0)     // I type
        {
          output = firstsrc + secondsrc;
          zero = false;
        }
        else if(op == 1)
        {
             output = firstsrc - secondsrc;
             if(output == 0) {
                 zero = true;
             } else {
                 zero = false;
             }
        } else if(op == 2)
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
                   if(output >= 0)
                       output = 0;
                   else 
                       output = 1;
                   break;
           }
        }
    }
    public boolean getZero(){
        return zero;
    }
    public int getOutput(){
        return output;
    }
}
