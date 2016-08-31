package me.shenchao.linearList.linkedList.polynomial;

/**
 * 多项式结点
 */
class PolynomialNode {

    /**
     * 多项式系数，假设系数都为整数
     */
    int factor;

    /**
     * 多项式指数
     */
    int indice;

    PolynomialNode next;

    public PolynomialNode(int factor, int indice) {
        this.factor = factor;
        this.indice = indice;
        this.next = null;
    }

    public PolynomialNode() {
        this(0,0);
    }

}
