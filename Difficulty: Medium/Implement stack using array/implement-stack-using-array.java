class myStack {
    private int[] arr;
    private int top;
    private int capacity;

    public myStack(int n) {
        arr = new int[n];
        capacity = n;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int x) {
        if (!isFull()) {
            arr[++top] = x;
        }
        // If full, do not push as per problem constraint all queries are valid
    }

    public void pop() {
        if (!isEmpty()) {
            top--;
        }
        // If empty, do nothing as per problem constraint all queries are valid
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }
}
