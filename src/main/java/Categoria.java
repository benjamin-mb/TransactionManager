import java.util.ArrayList;
import java.util.Scanner;

public class Categoria {
    public  Scanner sc=new Scanner(System.in);
    private String name;
    private  int totalAmount;
    private double id;
    public static ArrayList<Transacciones> transactionsArray;


    public Categoria(String name, int totalAmount, double id) {
        this.name = name;
        this.totalAmount =0;
        this.id = id;
        this.transactionsArray = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public double getId() {
        return id;
    }

    public ArrayList<Transacciones> getTransactionsArray() {
        return transactionsArray;
    }


    //set
    public void setName(String name) {
        this.name = name;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setId(int id) {this.id = id;}

    //METODOS TRANSACTIONS

    public void createTransaction(){
        System.out.println("ingresa el nombre de la transaccion:");
        String name=sc.nextLine();

        System.out.println("ingresa el monto de la transaccion:");
        int amount=sc.nextInt();
        sc.nextLine();

        System.out.println("ingresa la descripcion de la transaccion:");
        String description=sc.nextLine();

        String type;
        System.out.println("ingresa el tipo de gasto:");
        System.out.println("1.ingreso");
        System.out.println("2.gasto");
        int choice=sc.nextInt();
        sc.nextLine();
        if (choice==1){
            type="ingreso";
        } else if (choice==2) {
            type="gasto";
        }
        else{
            System.out.println("opcion no valida/tipo por defecto gasto");
            type="gasto";
        }


        Transacciones newtransaction=new Transacciones(name,amount,description,type);
        transactionsArray.add(newtransaction);
        totalAmount += newtransaction.getAmount();

    }

    //Metodo deletetransaction

    public void deleteTransaction(){
        int contador=1;
        for (Transacciones i:transactionsArray){
            System.out.println(contador+i.getName()+"-"+i.getAmount()+"-"+i.getType()+"-"+i.getDescription());
            contador++;
        }
        System.out.println("ingresa la transaccion que deseas borrar:");
        int decision=sc.nextInt();
        sc.nextLine();

        if (decision<0 && decision<=transactionsArray.size()){
            Transacciones transactionDelete=transactionsArray.get(decision-1);
            transactionsArray.remove(transactionDelete);
        }else{
            System.out.println("numero invalido. ninguna transaccion ha sido eliminada");
        }
    }

}
