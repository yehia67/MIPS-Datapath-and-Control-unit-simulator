package mips.datapath.and.control.unit.simulator;
public class Mux {
    private Register rt,rd;
    private int RegDst,ALUSrc,MemtoReg,wire;
    private int n1,n2;
    public Mux(Register r1,Register r2,int sign){
        rt=r1;
        rd = r2;
        RegDst=sign;
    }
    public Mux(int a , int b,int c){
        n1 = a;
        n2 =b;
        wire = c;
    }
    public Register MuxSrc(){
        RegDst = wire;
        if(RegDst==1)
            return rd;
        else
            return rt;
    }
    public int MuxAlu(){
        ALUSrc = wire;
        if(ALUSrc == 1)
            return n2;
        else
            return n1;
    }
    public int MuxMemtoReg(){
        MemtoReg = wire;
        if(MemtoReg == 1)
            return n2;
        else
            return n1;
    }
    public int getALUSrc(){
        return ALUSrc;
    }
    public int getRegDst(){
        return RegDst;
    }
    public int getMemtoReg(){
        return MemtoReg;
    }
    
}
