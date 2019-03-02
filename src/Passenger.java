public class Passenger implements Comparable{
    private long minutesEarly;
    private long yearlyEarnings;
    private long amountOfPets;
    private long treesPlantedThisYear;
    private long crimesCommited;

    @Override
    public int compareTo(Object o) {
        if(this.calculatePriority() < ((Passenger)o).calculatePriority()){
            return -1;
        }
        else if(this.calculatePriority() > ((Passenger)o).calculatePriority()){
            return 1;
        }
        return 0;
    }

    public Passenger(long minutesEarly, long yearlyEarnings, long amountOfPets, long treesPlantedThisYear, long crimesCommited) throws Exception {
        this.minutesEarly = minutesEarly;
        this.yearlyEarnings = yearlyEarnings;
        this.amountOfPets = amountOfPets;
        this.treesPlantedThisYear = treesPlantedThisYear;
        this.crimesCommited = crimesCommited;
        if(crimesCommited < 0){
            throw new Exception("We both know that's not true");
        }
    }

    public long calculatePriority(){
        return ((this.minutesEarly * 4) + (this.yearlyEarnings / 100) + (amountOfPets * 10) + (treesPlantedThisYear * 5) / (crimesCommited + 1));
    }

    @Override
    public String toString() {
        return "" + this.calculatePriority();
    }
}
