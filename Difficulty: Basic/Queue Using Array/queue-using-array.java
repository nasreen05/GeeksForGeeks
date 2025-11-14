class myQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor to initialize the queue with size n
    public myQueue(int n) {
        capacity = n;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Enqueue operation
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    // Dequeue operation
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        front = (front + 1) % capacity;
        size--;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    // Get rear element
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }
}
