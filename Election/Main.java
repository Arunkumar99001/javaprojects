import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Election election = new Election();
        // Display election details
        try (Scanner scanner = new Scanner(System.in)) {
            // Display election details
            election.displayElectionInfo();
            
            // Loop to accept multiple voters
            while (true) {
                System.out.println("\nEnter your name (or type 'exit' to finish): ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if the user types 'exit'
                }
                
                System.out.println("Enter your age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left after nextInt()
                
                Voter voter = new Voter(name, age);
                voter.CheckingEligible();
                
                // If eligible, allow the voter to vote
                if (voter.isEligible()) {
                    System.out.println("Please cast your vote:\n1. " + election.candidatesA + "\n2. " + election.candidatesB);
                    int voteChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after nextInt()
                    
                    if (!voter.hasVoted()) {
                        election.castVote(voteChoice); // Cast the vote
                        voter.setHasVoted(true); // Mark voter as voted
                        System.out.println(voter.getName() + " has voted.");
                    } else {
                        System.out.println("You have already voted.");
                    }
                } else {
                    System.out.println("Sorry, you are not eligible to vote.");
                }
            }
            
            // Display election results after the loop ends
            election.displayResults();
        }
    }
}
