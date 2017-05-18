package mips.datapath.and.control.unit.simulator;

import java.util.Scanner;

public class MIPSDatapathAndControlUnitSimulator {
    
    public static String rsName;
    public static String rtName;
    public static String rdName;
    public static int constant;
    public static void inputmem(){
        System.out.println("Enter 1 to add new data in memory or -1 to skip");
        int x; 
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        while(x == 1)
        {
            System.out.println("Enter data address :-");
            int address = scan.nextInt();
            System.out.println("Enter data value :-");
            int data = scan.nextInt();
            Memory.store(address, data);
            System.out.println("Press 1 to add new data in memory or -1 to skip");
            x = scan.nextInt();
        }
        
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the starting address for the program :-");
        int startingAddr = scan.nextInt();
        ProgramCounter.setAddress(startingAddr);
        Datapath datapath = new Datapath();
        inputmem();
        System.out.println("Please enter the number of instructions to be executed :- ");
        int numOfInstr = scan.nextInt();
        scan.nextLine();
        inputInstructions(numOfInstr, startingAddr);
        datapath.executeInstructions();
    }
    
    public static void inputInstructions(int numOfInstr, int startingAddr) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < numOfInstr; i++) {
            System.out.println("Please enter the label of the instruction if it has one :-");
            String label = scan.nextLine();
            System.out.println("Please enter the operation name :- ");
            String operation = scan.nextLine();
            switch(operation) {
                case "add" :
                    add(label, startingAddr);
                    break;
                case "and" :
                    and(label, startingAddr);
                    break;
                case "addi" :
                    addi(label, startingAddr);
                    break;
                case "lw" :
                    lw(label, startingAddr);
                    break;
                case "sw" :
                    sw(label, startingAddr);
                    break;
                case "sll" :
                    sll(label, startingAddr);
                    break;
                case "andi" :
                    andi(label, startingAddr);
                    break;
                case "or" :
                    or(label, startingAddr);
                    break;
                case "ori" :
                    ori(label, startingAddr);
                    break;
                case "nor" :
                    nor(label, startingAddr);
                    break;
                case "beq" :
                    beq(label, startingAddr);
                    break;
                case "j" :
                    j(label, startingAddr);
                    break;
                case "jal" :
                    jal(label, startingAddr);
                    break;
                case "jr" :
                    jr(label, startingAddr);
                    break;
                case "slt" :
                    slt(label, startingAddr);
                    break;
                default:
                    System.out.println("Incorrect operation name!");
                    i--;
                    break;
            }
            startingAddr += 4;
        }
    
    }
    
    public static String jFormat() {
        System.out.println("Please enter the target instruction :-");
        Scanner scan = new Scanner(System.in);
        String targetLabel = scan.nextLine(); 
        return targetLabel;
    }
    
    public static void jr(String label, int address) {
        System.out.println("Please enter jump to register:-");
        Scanner scan = new Scanner(System.in);
        String ra = scan.nextLine();
        Memory.addInstruction(new RFormat(label, address, "jr", ra, "$0", "$0", 0));
    }
    
    public static void j(String label, int address) {
        Memory.addInstruction(new JFormat(label, address, "j", jFormat()));
    }
    
    public static void jal(String label, int address) {
        Memory.addInstruction(new JFormat(label, address, "jal", jFormat()));
    }
    
    public static void rFormat() {
        System.out.println("Please enter the destination register name : ");
        Scanner scan = new Scanner(System.in);
        rdName = scan.nextLine();
        
        System.out.println("Please enter the source register name : ");
        rsName = scan.nextLine();
        System.out.println("Please enter the target register name : ");
        rtName = scan.nextLine();
    }
    
    public static void iFormat() {
        System.out.println("Please enter the target register name : ");
        Scanner scan = new Scanner(System.in);
        rtName = scan.nextLine();
        System.out.println("Please enter the source register : ");
        rsName = scan.nextLine();
        System.out.println("Please enter the constant or the address : ");
        constant = scan.nextInt();
         if(rdName.equals("$sp"))
        {
            
        }
    }
    
    public static void add(String label, int address) {
        rFormat();
        Memory.addInstruction(new RFormat(label, address, "add", rsName, rtName, rdName, 0));
    }
    
    public static void and(String label, int address) {
        rFormat();
        Memory.addInstruction(new RFormat(label, address, "and", rsName, rtName, rdName, 0));
    }
    
    public static void or(String label, int address) {
        rFormat();
        Memory.addInstruction(new RFormat(label, address, "or", rsName, rtName, rdName, 0));
    }
    
    public static void nor(String label, int address) {
        rFormat();
        Memory.addInstruction(new RFormat(label, address, "nor", rsName, rtName, rdName, 0));
    }
    
    public static void sll(String label, int address) {
        System.out.println("Please enter the target register name : ");
        Scanner scan = new Scanner(System.in);
        rtName = scan.nextLine();
        System.out.println("Please enter the source register name : ");
        rsName = scan.nextLine();
        System.out.println("Please enter the shift amount :- ");
        int shamt = scan.nextInt();
        Memory.addInstruction(new RFormat(label, address, "sll", rsName, rtName, "$0", shamt));
    }
    
    public static void addi(String label, int address) {
        iFormat();
        Memory.addInstruction(new IFormat(label, address, "addi", rsName, rtName, constant));
    }
    
    public static void ori(String label, int address) {
        iFormat();
        Memory.addInstruction(new IFormat(label, address, "ori", rsName, rtName, constant));
    }
    
    public static void andi(String label, int address) {
        iFormat();
        Memory.addInstruction(new IFormat(label, address, "andi", rsName, rtName, constant));
    }
    
    public static void beq(String label, int address) {
        System.out.println("Please enter the source register name : ");
        Scanner scan = new Scanner(System.in);
        String rsName = scan.nextLine();
        System.out.println("Please enter the target register : ");
        String rtName = scan.nextLine();
        System.out.println("Please enter the label of the target instruction : ");
        String labelTarget = scan.nextLine();
        Memory.addInstruction(new IFormat(label, address, "addi", rsName, rtName, labelTarget));
    }
    
    public static void lw(String label, int address) {
        iFormat();
        Memory.addInstruction(new IFormat(label, address, "lw", rsName, rtName, constant));
    }
    
    public static void sw(String label, int address) {
        iFormat();
        Memory.addInstruction(new IFormat(label, address, "sw", rsName, rtName, constant));
    }
    
    public static void slt(String label, int address) {
        rFormat();
        Memory.addInstruction(new IFormat(label, address, "addi", rsName, rtName, rdName));
    }
}
