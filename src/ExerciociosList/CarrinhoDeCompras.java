package ExerciociosList;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> carrinhoList;

    public CarrinhoDeCompras() {
        this.carrinhoList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinhoList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
    List<Item> itensParaRemover = new ArrayList<>();
    if (!carrinhoList.isEmpty()) {
        for (Item i : carrinhoList) {
            if (i.getNome().equals(nome)) {
                itensParaRemover.add(i);
            }
        }
        carrinhoList.removeAll(itensParaRemover);
    }else{
        System.out.println("O carrinho está vazio!");
    }
    }

    public double calcularValorTotal(){
        double total = 0;
    if (!carrinhoList.isEmpty()) {
        for(Item i : carrinhoList){
        total = total + (i.getPreco() * i.getQuantidade());
    }
      return total;
    }else {
        throw new RuntimeException("O carrinho está vazio!");
    }
    }


    public int quantidadeItem(){
        return carrinhoList.size();
    }

    public void exibirItens(){
System.out.println("Os itens que estão no carrinho são: " + carrinhoList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Extrato de Tomate", 3.99, 2);
        carrinho.adicionarItem("Extrato de Tomate", 3.55, 1);
        carrinho.adicionarItem("Batata palha", 1.50, 5);

        System.out.println("A quantidade de itens neste carrinho é: " + carrinho.quantidadeItem());
        System.out.println("O valor total no carrinho é: " + carrinho.calcularValorTotal());
        carrinho.removerItem("Extrato de Tomate");
        System.out.println("A quantidade de itens neste carrinho é: " + carrinho.quantidadeItem());
        carrinho.exibirItens();

    }
}
