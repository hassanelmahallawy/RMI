import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl extends UnicastRemoteObject implements TaskManagerInterface {

    private static final String FILE_NAME = "tasks.txt";

    protected TaskManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public void addTask(String task) throws RemoteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(task);
            writer.newLine();
            System.out.println("Task added: " + task);
        } catch (IOException e) {
            System.err.println("Error writing task: " + e.getMessage());
        }
    }

    @Override
    public List<String> getTasks() throws RemoteException {
        List<String> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading tasks: " + e.getMessage());
        }
        return tasks;
    }
}
