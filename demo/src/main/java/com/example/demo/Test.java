package com.example.demo;

public class Test {
    int quantity;
    String name;

    public Test() {
    }

    public Test(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public static void main(String args[]) {
        Test t = new Test();

        acaoProd comprar = (int qtd,int nome) -> {t.setQuantity(t.getQuantity() + qtd);
                                                    t.setName(nome); return true;};
        t.operate(a:1, b: "Joao", comprar);
        System.out.println("quantidade " + t.name + "nome " + t.name);
    }

    interface acaoProd {
        boolean opProd(int a, int b);
    }
    private int operate(int a, int b, Test.acaoProd acao) {
        return acao.operation(a, b);
    }*/

}
