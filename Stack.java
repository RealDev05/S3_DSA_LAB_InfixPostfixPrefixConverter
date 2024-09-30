class Stack {
    String[] arr;
    int size;
    int top;

    public Stack(int max) {
        size = max;
        arr = new String[max];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        return arr[top--];
    }

    public void insert(String val) {
        if (isFull()) {
            return;
        }
        arr[++top] = val;
    }
}