# Assignment 3 Airport Queue | Heap & Priority Queues
Made by Viktor Kim Christiansen, Chris Rosendorf & William Pfaffe


Assignment [PDF](https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_09/Assignment_03/03%20Assignment%20Airport%20Queue.pdf)

## Solution
We were required to write the project in Java, implementing the PriorityQueue interface.
We decided to make a Heap as a solution, our implementation is called `BingoHeap`, and mainly makes use of 2 functions - swapWithParent and swapWithChild - when you `enqueue` or `dequeue`, respectively.


## Arguments
A Heap is a good solution for this assignment, because it satisfies the properties which are required - namely that the enqueue and dequeue function must have a runtime of O(LogN). This is achieved, as the Heap runs in a Binary Tree format, where each "node" of a parent must be smaller than, or equal to the parents' value.


## Results, Showing it adds and removes in O(LogN)
1. Adding / Enqueueing
When you are enqueueing, then each move will remove a lot of potential nodes that one might have had to traverse. We add the new element to the bottom next available spot, and bobble it up to the correct position. Thus traversing in O(LogN) time. (For the function that gets called look in `src/BingoHeap.java` under `swapWithParent()`).

```
heap.add(current);
swapWithParent(current, heap.size() -1);
```



2. Removing / Dequeueing
Since it's a binary tree and we move down a branch every "move", while recursively calling the next element, it results in effectively traversing down the tree in O(LogN) time.
The strategy consists of removing the top element, then putting the newest (or lowest value) from the bottom of the tree to the top. Then we "bubble" it down to the correct spot. (For the function that gets called look in `src/BingoHeap.java` under `swapWithChild()`).
```
Passenger oldRoot = heap.get(0);
        Passenger newest = heap.get(heap.size() - 1);
        heap.set(0, newest);
        heap.remove(heap.size() - 1);
        swapWithChild(0);
```

# Open in IntelliJ / IDE of choice
1. Import or open the project
2. Set correct JDK version
3. Build & Run Main

# Run With Docker
Run
1. `docker build -t prioqueue .`
2. `docker run --rm prioqueue`

Cleanup
1. `docker rmi prioqueue`
2. `docker rmi openjdk:13-ea-9-jdk-alpine3.9`
