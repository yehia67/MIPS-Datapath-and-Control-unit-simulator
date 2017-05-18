package mips.datapath.and.control.unit.simulator;

public class Control {
    private int regdst, branch , memread, memtoreg,aluop, memwrite,
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
    public void setSignals (int mRegdst,int mBranch ,int mMemread,int mMemtoreg,
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

    public int getRegdst() {
        return regdst;
    }

    public int getBranch() {
        return branch;
    }

    public int getMemread() {
        return memread;
    }

    public int getMemtoreg() {
        return memtoreg;
    }

    public int getAluop() {
        return aluop;
    }

    public int getMemwrite() {
        return memwrite;
    }

    public int getAlusrc() {
        return alusrc;
    }

    public int getRegwrite() {
        return regwrite;
    }
    
    public int getJump() {
        return jump;
    }
            
}
