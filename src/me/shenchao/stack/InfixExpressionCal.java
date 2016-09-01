package me.shenchao.stack;

/**
 * 中缀表达式求值<br>
 * 为方便演示，这里假设所给的字符串表达式中操作数都是10以内整数，否则需要区分
 */
public class InfixExpressionCal {

    /**
     * 判断字符是数字还是操作符
     *
     * @param ch 传入字符
     * @return 如果是数字返回true
     */
    private static boolean isOperand(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 计算中缀表达式值
     *
     * @param infixExpression 中缀表达式
     * @return 结果值
     */
    private static int calInfixExpression(String infixExpression) {
        // 将原表达式末尾添加上 '#' 标记，作为结束标记
        infixExpression = infixExpression + "#";
        // 保存操作符的栈
        Stack<Character> optr = new Stack<>();
        optr.push('#'); // 首先让'#'入栈
        // 保存操作数的栈
        Stack<Integer> opnd = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            // 如果当前字符是一个数字
            if (isOperand(infixExpression.charAt(i))) {
                opnd.push(Integer.parseInt(infixExpression.charAt(i) + ""));
            } else {
                // 当前字符是一个操作符
                switch (infixExpression.charAt(i)) {
                    case '(':
                        // 由于左括号的优先级最高，所以肯定入栈
                        optr.push('(');
                        break;
                    case ')':
                        // 如果碰到右括号，则操作符栈一直弹栈，直到遇到匹配的左括号为止
                        while (optr.peek() != '(') {
                            // 每当弹出一个操作符时， 从操作数栈中弹出两个数进行相应数值运算，并将结果压入栈中
                            opnd.push(operate(optr.pop(), opnd));
                        }
                        optr.pop();// 弹出'('
                        break;
                    default:
                        // 默认情况下:+ - * /
                        while (optr.peek() != '#' && compare(optr.peek(), infixExpression.charAt(i))) {
                            opnd.push(operate(optr.pop(), opnd));
                        }
                        optr.push(infixExpression.charAt(i));
                        break;
                }
            }
        }
        return opnd.peek();
    }

    /**
     * 比较运算符之间的优先级(对照PPT上表格)
     *
     * @param cur  当前操作符
     * @param peek 栈顶操作符
     * @return 如果栈顶操作符大于当前操作符，返回true
     */
    private static boolean compare(char peek, char cur) {
        if (peek == '*'
                && (cur == '+' || cur == '-' || cur == '/' || cur == '*')) {// 如果cur是'('，那么cur的优先级高,如果是')'，是在上面处理
            return true;
        } else if (peek == '/'
                && (cur == '+' || cur == '-' || cur == '*' || cur == '/')) {
            return true;
        } else if (peek == '+' && (cur == '+' || cur == '-')) {
            return true;
        } else if (peek == '-' && (cur == '+' || cur == '-')) {
            return true;
        } else if (cur == '#') {
            return true;
        }
        return false;
    }

    private static int operate(char oper, Stack<Integer> opnd) {
        int opndB = opnd.pop();
        int opndA = opnd.pop();

        switch (oper) {
            case '+':
                return opndA + opndB;
            case '-':
                return opndA - opndB;
            case '*':
                return opndA * opndB;
            case '/':
                return opndA / opndB;
            default:
                return 0;
        }
    }


    public static void main(String arg[]) {
        String s = "3*(7-2*3+2)";
        System.out.println(calInfixExpression(s));
    }

}
