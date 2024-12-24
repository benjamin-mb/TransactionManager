import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        Administrator administrator = new Administrator();

        System.out.println("Ingresa la opcion:" + "\n" +
                "1.Registrarse" + "\n" +
                "2.Ingresar");
        int mainMenu = sc.nextInt();
        switch (mainMenu){
            case 1:
            System.out.println("Ingresa tu Nombre: ");
            String name=sc.nextLine();
            sc.nextLine();
            System.out.println("Ingresa tu Email: ");
            String email=sc.nextLine();
            sc.nextLine();
            System.out.println("Crea tu contraseña: ");
            String password=sc.nextLine();
            System.out.println("Ingresa nuevamente tu contraseña: ");
            String password2=sc.nextLine();
            if (Objects.equals(password2, password)){
                User user=new User(name,email,password);
                administrator.addUser(user);
                if (administrator.validateUser(name,password)){
                    menu(user);
                }

            }
            else {
                System.out.println("las contraseñas no coinciden");
            }
            break;

            case 2:
                System.out.println("Ingresa tu Email:");
                String validateEmail=sc.nextLine();
                sc.nextLine();
                System.out.println("Ingresa tu contraseña:");
                String validatePassword=sc.nextLine();
                if(administrator.validateUser(validateEmail,validatePassword)){
                    User user1= administrator.getUserByEmail(validateEmail);
                }
            break;
    }
}

public static void menu( User user1){
    Scanner sc=new Scanner(System.in);
    int opcion;
    System.out.println("//////////////////MENU///////////////////////////");
    System.out.println(
            "1.Crear una Categoria" + "\n" +
                    "2.Eliminar una categoria" + '\n' +
                    "3.Ver categorias" + "\n" +
                    "4.Ver Categoria Y sus transacciones" + "\n" +
                    "5.Agregar Transaccion" + "\n" +
                    "6.Salir"
    );
    System.out.println("ingresa la opcion:");
    opcion= sc.nextInt();
    sc.nextLine();

    do {
        switch (opcion){
            case 1:
                System.out.println("ingresa el nombre de la categoria:");
                String nameCategory = sc.nextLine();

                System.out.print("el id de la categoria "+ nameCategory + "es: ");
                double idCategory = (int) (Math.random()*1000);

                int totalAmountCategory=0;

                Categoria newCategory = new Categoria(nameCategory,totalAmountCategory,idCategory);
                user1.addCategory(newCategory);


                System.out.println("Categoria creada exitosamente!!");
                break;

            case 2:
                if (user1.getCategoriaArrayList().isEmpty()){
                    System.out.println("No hay Categorias Creadas");
                }
                else {
                    user1.viewCategories();
                    System.out.println("selecciona una categoria:");
                    int seleccionCategory = sc.nextInt();
                    if (seleccionCategory > 0 && seleccionCategory <= user1.getCategoriaArrayList().size()) {
                        Categoria categoriaEliminar = user1.getCategoriaArrayList().get(seleccionCategory - 1);
                        System.out.println("Estas seguro que deseas borrar la categoria " + categoriaEliminar.getName() + "\n" +
                                "(Esto borrara todas tus transacciones)" + "\n" +
                                "1.Si" + "\n" +
                                "2.No" + "\n"
                        );
                        int seleccionSiNo = sc.nextInt();
                        if (seleccionSiNo == 1) {
                            user1.deleteCategory(categoriaEliminar);
                        } else if (seleccionSiNo == 2) {
                            System.out.println("Categoria no eliminada");
                        } else {
                            System.out.println("Opcion incorrecta");
                        }
                    } else {
                        System.out.println("Tu seleccion ha sido incorrecta." + "\n" +
                                "Intentalo Nuevamente.");
                    }
                }
                break;


            case 3:
                user1.viewCategories();
                break;

            case 4:
                user1.categoryTocheckTransaction();//
                break;
            case 5:
                if (0==user1.getCategoriaArrayList().size()){
                    System.out.println("no hay categorias creadas");
                }
                else {
                    System.out.println("Selecciona la categoría donde quieres agregar una transacción:");
                    int index = 1;
                    for (Categoria categoria : user1.getCategoriaArrayList()) {
                        System.out.println(index + ". " + categoria.getName());
                        index++;
                    }

                    System.out.print("Ingresa el número de la categoría: ");
                    int categoriaSeleccionada = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea restante

                    if (categoriaSeleccionada > 0 && categoriaSeleccionada <= user1.getCategoriaArrayList().size()) {
                        Categoria categoriaElegida = user1.getCategoriaArrayList().get(categoriaSeleccionada - 1);
                        categoriaElegida.createTransaction();
                    } else {
                        System.out.println("Número inválido. Intenta nuevamente.");
                    }
                }
                break;
        }
        // Prompt the user again after each iteration
        System.out.println("\n//////////////////MENU///////////////////////////");
        System.out.println(
                "1.Crear una Categoria" + "\n" +
                        "2.Eliminar una categoria" + '\n' +
                        "3.Ver categorias" + "\n" +
                        "4.Ver Categoria Y sus transacciones" + "\n" +
                        "5.Agregar Transaccion" + "\n" +
                        "6.Salir"
        );
        System.out.println("ingresa la opcion:");
        opcion = sc.nextInt();
        sc.nextLine();
    }
    while (opcion >0 && opcion < 6);
}
}
