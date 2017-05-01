/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips.datapath.and.control.unit.simulator;

/**
 *
 * @author Sony
 */
public class Register {
    private String name;
    private int data;
    
    public Register(String mName, int mData) {
        name = mName;
        data = mData;
    }
    
    public Register(String mName) {
        name = mName;
        data = 0;
    }
    
    public void setData(int newData) {
        data = newData;
    }
    
    public int getData() {
        return data;
    }
    
    public String getName() {
        return name;
    }
}