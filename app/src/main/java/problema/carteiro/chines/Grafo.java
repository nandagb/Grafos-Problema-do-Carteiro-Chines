package problema.carteiro.chines;

import java.util.LinkedList;
import java.util.ArrayList;

public class Grafo {
    private int n = 0;//numero de vértices
    private ArrayList<LinkedList<Integer>> lista;

    void adAresta(int v1, int v2){
        //ao adicionar uma aresta estamos supondo que os vértices já estão no grafo
        this.lista.get(v1).add(v2);//v2 é adicionado como adjacente de v1
        this.lista.get(v2).add(v1);//v1 é adicionado como adjacente de v2

    }

    void adVertice(int v){
        LinkedList li = new LinkedList<>();//adicionamos uma lista para o novo vértice
        li.add(v);//adicionamos o vértice à lista
        this.lista.add(li);//adiciomanos a lista à lista de adjacência
        this.n++;//aumenta o numero vértices
    }
    public static void main(String[] args) {
        
    }

}
