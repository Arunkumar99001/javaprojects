public class Voter {
    private final String name;
    private final int age;
    private boolean hasVoted; // Track if the voter has already voted

    public Voter(String name, int age) {
        this.name = name;
        this.age = age;
        this.hasVoted = false; // Initially, the voter hasn't voted
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public boolean isEligible() {
        return age >= 18;
    }

    public void CheckingEligible() {
        if (isEligible()) {
            System.out.println("Hi " + getName() + ", you are Eligible to Vote.");
        } else {
            int requiredAge = 18 - getAge();
            System.out.println("Sorry " + getName() + ", you are not Eligible to Vote. You need " + requiredAge + " more years.");
        }
    }
}
