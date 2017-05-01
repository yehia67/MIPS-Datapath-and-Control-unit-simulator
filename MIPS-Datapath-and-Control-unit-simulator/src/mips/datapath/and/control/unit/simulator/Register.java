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
   private int value;
    public String name;
    public int data;// value that we take from user
  private int zero = 0;// la2ytha hint fl project discription
 // get w set malhomsh lazma bas ana saybhom 7orss
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
public int determinvalue(String x) //hanshoof el function di fl a5r matrkzoosh fiha dlw2ty
{
    if(x == "$zero" || x == "$0")
    {
        return value =  0;
    }
if(x == "$at")
{
    return value = 1;
}
if(x == "$at")
{
    return value = 1;
}
if(x == "$vo")
{
    return value = 2;
}
if(x == "$v1")
{
    return value = 3;
}
if(x == "$ao")
{
    return value = 4;
}
if(x == "$a1")
{
    return value = 5;
}
if(x == "$a2")
{
    return value = 6;
}
if(x == "$a3")
{
    return value = 7;
}
if(x == "$t0")
{
    return value = 8;
}
if(x == "$t1")
{
    return value = 9;
}
if(x == "$t2")
{
    return value = 10;
}
if(x == "$t3")
{
    return value = 11;
}
if(x == "$t4")
{
    return value = 12;
}
if(x == "$t5")
{
    return value = 13;
}
if(x == "$t6")
{
    return value = 14;
}
if(x == "$t7")
{
    return value = 12;
}
// zh2t hakml el ba2yy ama nygy n3mlo
return -1;
}
}
