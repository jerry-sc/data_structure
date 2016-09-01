package me.shenchao.stack;

/**
 * 栈
 */
public class Stack<E> {

    /**
     * 初始化栈的最大容量为1000
     */
    private static final int STACK_CAPACITY = 1000;

    private Object[] elementData;

    /**
     * top用来记录目前堆栈顶端的变量
     */
    private int top;

    /**
     * 初始化堆栈，此时为一个空栈
     */
    public Stack() {
        this.top = -1;
        this.elementData = new Object[STACK_CAPACITY];
    }

    /**
     * 入栈
     *
     * @param data 入栈元素
     */
    public void push(E data) {
        // 判断栈是否满
        if (top >= STACK_CAPACITY) {
            throw new RuntimeException("栈满，无法插入新元素！");
        }
        elementData[++top] = data;
    }

    /**
     * 出栈
     *
     * @return 返回栈顶元素
     */
    public E pop() {
        // 判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("出栈顶失败，因为此时栈中没有元素！");
        }
        E data = (E) elementData[top];
        --top;
        return data;
    }

    /**
     * 获取栈顶元素
     *
     * @return 返回栈顶元素
     */
    public E peek() {
        // 判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("获取栈顶元素失败，因为此时栈中没有元素！");
        }
        return (E) elementData[top];
    }

    /**
     * 判断是否是空栈
     *
     * @return 如果是空栈返回true, 反之返回false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 打印栈中元素
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("此时为空栈！");
            return;
        }
        System.out.print("栈中共有 " + (top + 1) + " 个元素，内部元素为（从栈底至栈顶）： ");
        for (int i = 0; i <= top; ++i) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // 元素入栈
        stack.push(2);
        stack.push(4);
        stack.push(8);
        stack.push(7);
        stack.push(13);
        stack.print();

        // 元素出栈
        stack.pop();
        stack.print();
    }
}
