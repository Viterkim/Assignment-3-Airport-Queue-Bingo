import interfaces.PriorityQueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BingoHeap implements PriorityQueue {
    private ArrayList<Passenger> heap;

    public BingoHeap(){
        heap = new ArrayList<Passenger>();
    }

    @Override
    public void enqueue(Object item) {
        Passenger current = (Passenger) item;
        heap.add(current);
        swapWithParent(current, heap.size() -1);
    }

    @Override
    public Object dequeue() {
        // Remove root
        if(heap.size() == 0){
            throw new NoSuchElementException("Queue is empty!");
        }
        Passenger oldRoot = heap.get(0);
        Passenger newest = heap.get(heap.size() - 1);
        heap.set(0, newest);
        heap.remove(heap.size() - 1);
        swapWithChild(0);
        return oldRoot;
    }

    @Override
    public Object peek() {
        if(heap.size() > 0){
            return heap.get(0);
        }
        throw new NoSuchElementException("No elements in the heap");
    }


    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return (heap.size() == 0);
    }

    public ArrayList<Passenger> getHeap(){
        return this.heap;
    }

    private void swapWithChild(int parentIndex){
        // compare x with biggest of y or z
        int leftChildIndex = parentIndex * 2;
        int rightChildIndex = (parentIndex * 2) + 1;
        if(heap.size() -1 >= rightChildIndex){
            int comparison = heap.get(leftChildIndex).compareTo(heap.get(rightChildIndex));
            int biggestChildIndex = leftChildIndex;
            if (comparison < 0){
                biggestChildIndex = rightChildIndex;
            }
            Passenger tmpPassenger = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(biggestChildIndex));
            heap.set(biggestChildIndex, tmpPassenger);
            swapWithChild(biggestChildIndex);
        }
    }

    private void swapWithParent(Passenger current, int currentIndex){
        int parentIndex = (int) Math.floor(currentIndex / 2);
        if(parentIndex >= 0){
            Passenger parent = heap.get(parentIndex);
            int comparison = current.compareTo(parent);
            if (comparison > 0){
                Passenger tmpPassenger = parent;
                heap.set(parentIndex, current);
                heap.set(currentIndex, tmpPassenger);
                swapWithParent(current, parentIndex);
            }
        }
    }
}
