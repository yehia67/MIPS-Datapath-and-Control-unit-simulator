/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips.datapath.and.control.unit.simulator;

/**
 *
 * @author mahmoud
 */
public class Control {
    int regdst, branch , memread, memtoreg,aluop, memwrite, alusrc,regwrite, jump;
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
       jump = 0;
    }
    public void setSignals ( int regdst,int branch ,int memread,int memtoreg,int aluop,int memwrite,int alusrc,int regwrite,int jump ){
         this.regdst=regdst;
        this.branch = branch;
        this. memread = memread;
        this. memtoreg = memtoreg;
        this. aluop = aluop;
        this. memwrite = memwrite;
        this. alusrc = alusrc;
        this. regwrite = regwrite;
        this.jump = jump;
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
