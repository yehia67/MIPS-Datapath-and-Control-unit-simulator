/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips.datapath.and.control.unit.simulator;

import java.util.ArrayList;

/**
 *
 * @author Sony
 */
public class Memory {
private ArrayList <Double> Datamem;
private ArrayList <Instruction> instrucmem;// 27tmal n3'ayr el data type di ama nygy n3ml class ll instruction
public static int c = 0, pc = 0;// pc b3dyn haswyha bl adrress
int counter = 0,PCcounter;
public void setPC(int c)
{
    Memory.pc = c;
}
public int getPC()
{
    return pc;
}
public Memory(double x, Instruction y)
{
    Datamem.set(counter, x);
    instrucmem.set(counter, y);
    counter ++;
    PCcounter += 4;
    c = counter;
    pc = PCcounter;
}
public void show()
{
    for(int i = 0; i < Datamem.size(); i++)
    {
        System.out.println("the adress of memory is "+Datamem.get(i)+" it instruction is "+instrucmem.get(i));
        
    }
}
public int found(double x){
     for(int i = 0; i < Datamem.size(); i++)
    {
        if(x == Datamem.get(i))
        {
            return i ;
        }
    }
return -1;
}
public double finddata (Instruction x)
{
    for(int i = 0; i < Datamem.size(); i++)
    {
        if(x == instrucmem.get(i))
        {
            return Datamem.get(i);
        }
    }
 return -1;
}
  public int IF(int temp)
  {
      if(temp > Memory.pc)
      {
         return -1; 
      }
  return pc-temp/4;
  }
  
public Double load (int address)
{
  int index = pc-address/4;
  return Datamem.get(index);
}

public void store(int address, Double data)
{
    int index = pc-address/4;
    Datamem.set(index, data);
}
        
        }

