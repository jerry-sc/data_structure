package me.shenchao.linearList.polynomial;

/**
 * 多项式加法<br>
 * 为了更直接表述多项式加法，此版本为LinkedList类简化版，如有需要可按照其修改
 */
public class PolynomialAddition {

    PolynomialNode header = null;

    /**
     * last指向尾结点
     */
    private PolynomialNode last = null;

    public PolynomialAddition() {
        this.header = new PolynomialNode();
    }

    /**
     * 从链表尾部插入新结点
     *
     * @param factor 系数
     * @param indice 指数
     */
    public void add(int factor, int indice) {
        PolynomialNode newNode = new PolynomialNode(factor, indice);
        // 如果第一次插入
        if (header.next == null) {
            header.next = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    /**
     * 打印多项式，如果某项指数为0，则不打印指数项，直接打印系数；如果系数绝对值为1，则不打印此1；如果指数为1，不打印^1 <br>
     * 例如：1 -x^2 +2x^4
     */
    public void print() {
        PolynomialNode p = header.next;
        while (p != null) {
            if (p.factor != 0) {
                if (p.indice == 0) {
                    System.out.print(p.factor);
                } else {
                    // 打印系数
                    if (p.factor > 0) {
                        System.out.print("+");
                    }
                    if (Math.abs(p.factor) != 1) {
                        System.out.print(p.factor);
                    } else {
                        if (p.factor < 0) {
                            System.out.print("-");
                        }
                    }
                    // 打印指数
                    if (p.indice == 1) {
                        System.out.print("x");
                    } else {
                        System.out.print("x^" + p.indice);
                    }
                }
            }
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 初始化多项式AB
        PolynomialAddition polynomialA = new PolynomialAddition();
        polynomialA.add(1, 0);
        polynomialA.add(-3, 6);
        polynomialA.add(7, 12);
        polynomialA.print();

        PolynomialAddition polynomialB = new PolynomialAddition();
        polynomialB.add(-1, 4);
        polynomialB.add(3, 6);
        polynomialB.add(-9, 10);
        polynomialB.add(8, 14);
        polynomialB.print();

        PolynomialAddition polynomialC = new PolynomialAddition();

        // 多项式相加
        PolynomialNode pa = polynomialA.header.next;
        PolynomialNode pb = polynomialB.header.next;
        // 如果多项式AB均未到达末尾
        while (pa != null && pb != null) {
            // 如果指数相等，则系数相加
            if (pa.indice == pb.indice) {
                int newIndice = pa.factor + pb.factor;
                // 如果新系数不为0，那么将结果加到多项式
                if (newIndice != 0) {
                    polynomialC.add(newIndice, pa.indice);
                }
                pa = pa.next;
                pb = pb.next;
            } else if (pa.indice > pb.indice) {
                // 如果多项式A的指数不等于多项式B的指数，将指数小者加到结果多项式
                polynomialC.add(pb.factor, pb.indice);
                pb = pb.next;
            } else {
                polynomialC.add(pa.factor, pa.indice);
                pa = pa.next;
            }
        }
        // 若其中一个到达末尾
        while (pa != null) {
            polynomialC.add(pa.factor, pa.indice);
            pa = pa.next;
        }
        while (pb != null) {
            polynomialC.add(pb.factor, pb.indice);
            pb = pb.next;
        }

        polynomialC.print();
    }
}
