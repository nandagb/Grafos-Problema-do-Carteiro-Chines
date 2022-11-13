package problema.carteiro.chines;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class Grafo {

    public Grafo(){
        listaAdjacencia = new LinkedHashMap<>();
    }
    private int V = 0; //Número de vértices
    private int L = 0; //Número de arestas
    private Map<Vertice, List<Vertice>> listaAdjacencia; // Lista de Adjacência dos vértices

    /**
     * Função para adicionar um vértice no grafo.
     * @param v Vértice a ser adicionado
     */
    void addVertice(int v){
        listaAdjacencia.putIfAbsent(new Vertice(v), new LinkedList<>());
        this.V++;
    }
    /**
     * Função para adicionar uma aresta de 2 vértices.
     * @param v1 Vértice 1
     * @param v2 Vértice 2
     */
    void addAresta(int v1, int v2){
        Vertice auxv1 = new Vertice(v1);
        Vertice auxv2 = new Vertice(v2);
        try {
            listaAdjacencia.get(auxv1).add(auxv2);
            listaAdjacencia.get(auxv2).add(auxv1);
        }
        catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("O vértice não existe");
        }
        this.L++;
    }

    /**
     * Função para remover uma aresta de 2 vértices.
     * @param v1 Vértice 1
     * @param v2 Vértice 2
     */
    void remAresta(int v1, int v2){
        Vertice auxv1 = new Vertice(v1);
        Vertice auxv2 = new Vertice(v2);
        List<Vertice> auxLV1 = listaAdjacencia.get(auxv1);
        List<Vertice> auxLV2 = listaAdjacencia.get(auxv2);
        try{
            auxLV1.remove(auxv2);
            auxLV2.remove(auxv1);
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("O vértice não existe");
        }
        this.L--;
    }

    public void printGrafo(){
        for (Vertice ver : this.getListaAdjacencia().keySet()) {
            System.out.print(ver.n + ": ");
            for (Vertice adjver: this.getListaAdjacencia().get(ver)) {
                System.out.print(adjver.n + " ");
            }
            System.out.println();
        }
    }

    // Getters e Setters
    public Map<Vertice, List<Vertice>> getListaAdjacencia() {
        return listaAdjacencia;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getL() {
        return L;
    }

    public void setL(int l) {
        L = l;
    }
}
