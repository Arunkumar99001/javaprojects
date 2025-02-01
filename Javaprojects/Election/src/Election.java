public class Election {
    final String candidatesA;
    final String candidatesB;
    private final String party1;
    private final String party2;
    private int countVotes1;
    private int countVotes2;

    // Constructor to initialize candidates and parties
    public Election() {
        this.candidatesA = "Lothor";
        this.candidatesB = "Jenji";
        this.party1 = "Ninja Storm";
        this.party2 = "Mystic Force";
        this.countVotes1 = 0;
        this.countVotes2 = 0;
    }

    // Method to display the election info
    public void displayElectionInfo() {
        System.out.println(party1 + " (from) " + candidatesA + " vs " + party2 + " (from) " + candidatesB);
    }

    // Method to cast a vote
    public void castVote(int choice) {
        switch (choice) {
            case 1 -> countVotes1++;
            case 2 -> countVotes2++;
            default -> System.out.println("Invalid vote! Please select either 1 or 2.");
        }
    }

    // Method to display the voting results
    public void displayResults() {
        System.out.println("\nVoting Results:");
        System.out.println(candidatesA + " (from " + party1 + ") : " + countVotes1 + " votes");
        System.out.println(candidatesB + " (from " + party2 + ") : " + countVotes2 + " votes");

        // Compare the vote counts, not the candidate names
        if (countVotes1 > countVotes2) {
            System.out.println(candidatesA + " wins the election!");
        } else if (countVotes2 > countVotes1) {
            System.out.println(candidatesB + " wins the election!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
