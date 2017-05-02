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

