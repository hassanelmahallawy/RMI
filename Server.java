import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            TaskManagerImpl taskManager = new TaskManagerImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // start RMI registry
            registry.rebind("TaskService", taskManager);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
