import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TaskManager {
    private final ArrayList<String> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    // Add task
    public void addTask(String task) {
        tasks.add(task);
    }

    // Remove task
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void startFromScratch(Scanner scanner) {
        // If tasks are present, ask for confirmation to clear them
        if (!tasks.isEmpty()) {
            System.out.println("Are you sure you want to remove all tasks? (yes/no):");
            String confirmation = scanner.nextLine().toLowerCase();

            if (confirmation.equals("yes")) {
                tasks.clear();
                System.out.println("All tasks have been removed.");
            } else {
                System.out.println("No tasks were removed.");
            }
        } else {
            System.out.println("There are no tasks to remove.");
        }
    }

    // Display tasks using ListIterator
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }

        ListIterator<String> iterator = tasks.listIterator();

        System.out.println("Listing tasks (forward):");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nListing tasks (backward):");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Start From Scratch (Remove All)");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline left by nextInt()

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter task name:");
                    String task = scanner.nextLine();
                    taskManager.addTask(task);
                }
                case 2 -> {
                    System.out.println("Enter task index to remove:");
                    int index = scanner.nextInt();
                    taskManager.removeTask(index);
                }
                case 3 -> taskManager.listTasks();
                case 4 -> taskManager.startFromScratch(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }
}
