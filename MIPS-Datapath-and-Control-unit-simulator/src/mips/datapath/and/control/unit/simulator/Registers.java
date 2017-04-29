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
public class Registers {
   public int value;
    public String name;
    public int data;// value that we take from user
  private int zero = 0;
 public String getname()
  {
     return name ;
  }
 public void setname(String x)
 {
     name = x;
 }
public void setvalue(int x)
{
    value = x;
} 
public int getvalue()
{
    return value;
}
public int determinvalue(String x)
{
    if(x == "$zero" || x == "$0")
    {
        return  0;
    }
if(x == "$at")
{
    return 1;
}
if(x == "$at")
{
    return 1;
}
if(x == "$vo")
{
    return 2;
}
if(x == "$v1")
{
    return 3;
}
if(x == "$ao")
{
    return 4;
}
if(x == "$a1")
{
    return 5;
}
if(x == "$a2")
{
    return 6;
}
if(x == "$a3")
{
    return 7;
}
if(x == "$t0")
{
    return 8;
}
if(x == "$t1")
{
    return 9;
}
if(x == "$t2")
{
    return 10;
}
if(x == "$t3")
{
    return 11;
}
if(x == "$t4")
{
    return 12;
}
if(x == "$t5")
{
    return 13;
}
if(x == "$t6")
{
    return 14;
}
if(x == "$t7")
{
    return 12;
}
// zh2t hakml el ba2yy ama nygy n3mlo
return -1;
}
}
