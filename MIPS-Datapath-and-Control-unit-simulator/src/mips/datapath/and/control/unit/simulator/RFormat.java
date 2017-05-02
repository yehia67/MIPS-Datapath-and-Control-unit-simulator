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
public class RFormat extends Instruction{
    private int opCode;
    private String rs;
    private String rt;
    private String rd;
    private int shamt;
    private int funcCode;
    
    public RFormat(String newLabel,int mOpCode, String mRs, String mRt, 
            String mRd, int mShamt, int mFuncCode) {
        super(newLabel);
        opCode = mOpCode;
        rs = mRs;
        rt = mRt;
        rd = mRd;
        shamt = mShamt;
        funcCode = mFuncCode;
    }
    
    @Override
    public void execute() {
        
    }
}
