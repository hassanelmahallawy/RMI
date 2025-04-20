import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            TaskManagerInterface taskManager = (TaskManagerInterface) registry.lookup("TaskService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n1. Add Task");
                System.out.println("2. Show Tasks");
                System.out.println("3. Exit");
                System.out.print("Choose: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    taskManager.addTask(task);
                } else if (choice == 2) {
                    List<String> tasks = taskManager.getTasks();
                    System.out.println("Tasks:");
                    for (String t : tasks) {
                        System.out.println("- " + t);
                    }
                } else {
                    System.out.println("Bye!");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
