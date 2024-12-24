import java.util.ArrayList;
import java.util.Scanner;

public class User
{
    Scanner sc=new Scanner(System.in);
    private  String name;
    private String email;
    private String password;
    public static ArrayList<Categoria>categoriaArrayList;




    //constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        categoriaArrayList = new ArrayList<>();
    }

    //get
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Categoria> getCategoriaArrayList() {return categoriaArrayList;}

    //setter

    public void setName(String name) {this.name = name;}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //METODOS CATEGORY

    public void addCategory(Categoria categoria){
    User.categoriaArrayList.add(categoria);
    }

    public void deleteCategory(Categoria categoria){
        User.categoriaArrayList.remove(categoria);
    }

    /*public void filterCategory(Categoria categoria){
        User.categoriaArrayList.stream().filter(categoria1 -> categoria.getTotalAmount()<int);
    }*/

    public void viewCategories(){
        System.out.println("Tus categorias son: ");
        int index = 1;
        for (Categoria categoria : User.getCategoriaArrayList()) {
            System.out.println(index + ". " + categoria.getName());
            index++;
        }

    }

    public void categoryTocheckTransaction(){
        System.out.println("tus categorias son: ");
        int enumerador=1;
        for(Categoria c:User.getCategoriaArrayList()){
            System.out.println(enumerador+"."+c);
            enumerador++;
        }
        System.out.println("Escoge la categoria del cual quisieras ver las transacciones: ");
        int selectionTransaction=sc.nextInt();

        if (selectionTransaction>0 && selectionTransaction<=User.getCategoriaArrayList().size()){
            Categoria categoryToShow = User.getCategoriaArrayList().get(selectionTransaction - 1);
            System.out.println("Transacciones en la categoría " + categoryToShow.getName() + ":");

            if (categoryToShow.getTransactionsArray().isEmpty()){
                System.out.println("No hay transacciones en esta categoria");
            }
            else {
                int enumerad=1;
                for (Transacciones t:categoryToShow.getTransactionsArray()){
                    System.out.println(enumerad+"."+t);
                }
            }
        }

    }


}
