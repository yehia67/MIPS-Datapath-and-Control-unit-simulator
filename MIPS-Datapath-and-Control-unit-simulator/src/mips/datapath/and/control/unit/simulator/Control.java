package mips.datapath.and.control.unit.simulator;

public class Control {
    private static int regdst, branch , memread, memtoreg,aluop, memwrite,
            alusrc,regwrite, jump;
    public Control ()
    {
       regdst=0;
       branch = 0;
       memread = 0;
       memtoreg = 0;
       aluop = 0;
       memwrite = 0;
       alusrc = 0;
       regwrite = 0;
    }
    public static void setSignals (int mRegdst,int mBranch ,int mMemread,int mMemtoreg,
            int mAluop,int mMemwrite,int mAlusrc,int mRegwrite, int mJump ){
        regdst = mRegdst;
        branch = mBranch;
        memread = mMemread;
        memtoreg = mMemtoreg;
        aluop = mAluop;
        memwrite = mMemwrite;
        alusrc = mAlusrc;
        regwrite = mRegwrite;
        jump = mJump;
    }

    public static int getRegdst() {
        return regdst;
    }

    public static int getBranch() {
        return branch;
    }

    public static int getMemread() {
        return memread;
    }

    public static int getMemtoreg() {
        return memtoreg;
    }

    public static int getAluop() {
        return aluop;
    }

    public static int getMemwrite() {
        return memwrite;
    }

    public static int getAlusrc() {
        return alusrc;
    }

    public static int getRegwrite() {
        return regwrite;
    }
    
    public static int getJump() {
        return jump;
    }
            
}
