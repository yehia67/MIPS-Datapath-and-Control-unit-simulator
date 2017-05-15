package mips.datapath.and.control.unit.simulator;

public class JFormat extends Instruction{
    private String operation,jaddress;
    private int address;
    private Control con;
    public JFormat(String label,int instruction_address,String operation,String lbladdress,Control c){
        super(label,instruction_address);
        this.operation=operation;
        jaddress=lbladdress;
        con=c;
    }
    
    @Override
    public void execute(){
        switch(operation)
        {
            case "j":
                jump();
                break;
            case "jal":
                jumpAndLink();
                break;
        }
    }
    
    public void jump(){
        con.setSignals(0, 0,0,0,0,0,0,0,1);
    }
    public void jumpAndLink(){
        
    }
}
