package me.shenchao.stack;

/**
 * 表达式求值<br>
 * 为方便演示，这里假设所给的字符串表达式中操作数都是10以内整数，否则需要区分
 */
public class SuffixExpressionCal {

    /**
     * 判断字符是数字还是操作符
     *
     * @param ch 传入字符
     * @return 如果是数字返回true
     */
    private static boolean isOperand(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        String expression = "32422*+13*-^*5-";
        Stack<Integer> stack = new Stack<>();
        // 依次判断每一个字符
        for (int i = 0; i < expression.length(); ++i) {
            // 如果是操作数，则入栈
            if (isOperand(expression.charAt(i))) {
                stack.push(Integer.parseInt(expression.charAt(i) + ""));
            } else {
                // 如果是运算符，从栈中弹出两个数，将运算结果再压入栈
                int operandB = stack.pop();
                int operandA = stack.pop();
                int operandC = 0;

                switch (expression.charAt(i)) {
                    case '+':
                        operandC = operandA + operandB;
                        break;
                    case '-':
                        operandC = operandA - operandB;
                        break;
                    case '*':
                        operandC = operandA * operandB;
                        break;
                    case '/':
                        operandC = operandA / operandB;
                        break;
                    case '^':
                        operandC = (int) Math.pow(operandA, operandB);
                }
                stack.push(operandC);
            }
        }
        System.out.println(stack.peek());
    }
}
