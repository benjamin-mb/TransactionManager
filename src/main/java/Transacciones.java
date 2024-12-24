import java.util.ArrayList;
import java.util.Scanner;

public class Transacciones {

    Scanner sc=new Scanner(System.in);
    private String name;
    private int amount;
    private String description;
    private String type;


    public  Transacciones(String name,int amount,String description,String type){
        this.name=name;
        this.amount=amount;
        this.description=description;
        this.type=type;

    }

    //get
    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }



    //set

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " - $" + amount + " - " + type + " - " + description;
    }




}
