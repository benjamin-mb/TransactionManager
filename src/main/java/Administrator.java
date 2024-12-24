import java.util.ArrayList;

public class Administrator {
    public static ArrayList<User> userArrayt;

    public Administrator() {
        this.userArrayt = new ArrayList<>();
    }

    public static ArrayList<User> getUserArrayt() {
        return userArrayt;
    }

    public void addUser(User user){
        Administrator.userArrayt.add(user);
    }
   /* public void createUser(String name, String email, String password) {
        User newUser = new User(name, email, password);
        userArrayt.add(newUser);
        System.out.println("USUARIO CREADO EXITOSAMENTE!!");
    }*/

    public boolean validateUser(String user, String password) {

        for (User user1 : userArrayt) {
            if (user1.getName().equals(user) && user1.getPassword().equals(password)) {
                System.out.println("Bienvenido " + user1.getName());
                return true;
            }
        }
        System.out.println("Usuario o Contraseña invalido");
        return false;
    }

    public User getUserByEmail(String email){
        for (User user: userArrayt){
            if (user.getName().equals(email)){
                int index= Administrator.userArrayt.indexOf(user);
                User user1= Administrator.getUserArrayt().get(index);
            }
        }
        return null;
    }




}
