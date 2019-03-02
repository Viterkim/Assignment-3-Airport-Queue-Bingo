import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BingoHeap bingoHeap = new BingoHeap();
        int amount = 20;
        // Generate random passengers
        System.out.println("Adding " + amount + " new passengers.");
        for(int i = 0; i < amount; i++){
            bingoHeap.enqueue(generateRandomPassenger());
        }
        printHeap(bingoHeap.getHeap());
        System.out.println("Removed: " + bingoHeap.dequeue().toString());
        printHeap(bingoHeap.getHeap());
    }

    public static Passenger generateRandomPassenger() throws Exception {
        return new Passenger(
            (long) (Math.random() * 12),
            (long) (Math.random() * 2000),
            (long) (Math.random() * 5),
            (long) (Math.random() * 4),
            (long) (Math.random() * 15)
        );
    }

    public static void printHeap(ArrayList<Passenger> heap){
        for(int i = 0; i < (int) Math.ceil((Math.log(heap.size()) / Math.log(2))); i++){
            for(int j = 0; j < Math.pow(2,i) && j + Math.pow(2,i) <= heap.size(); j++){
                System.out.print(heap.get(j + (int) Math.pow(2, i) -1).toString() + " ");
            }
            System.out.println();
        }
    }
}
