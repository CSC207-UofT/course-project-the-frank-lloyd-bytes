package login;

import java.util.Scanner;

import java.util.ArrayList;


public class Menu {
    public void runLogin(Controller controller) {
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        controller.runLogin(username, password);
    }

}
