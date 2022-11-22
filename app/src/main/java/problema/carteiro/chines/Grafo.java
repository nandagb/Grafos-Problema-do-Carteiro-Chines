package problema.carteiro.chines;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class Grafo {

    public Grafo() {
        listaVertices = new ArrayList<>();
    }

    private int V = 0; // Número de vértices
    private int L = 0; // Número de arestas

    private List<Vertice> listaVertices;

    /**
     * Função para adicionar um vértice no grafo.
     * 
     * @param v Vértice a ser adicionado
     */
    void addVertice(int v) {
        Vertice aux = new Vertice(v);
        if (!listaVertices.contains(aux))
            listaVertices.add(aux);
        this.V++;
    }

    /**
     * Função para adicionar uma aresta de 2 vértices.
     * 
     * @param v1 Vértice 1
     * @param v2 Vértice 2
     */
    void addAresta(int v1, int v2) {
        Vertice auxv1 = new Vertice(v1);
        Vertice auxv2 = new Vertice(v2);

        if (listaVertices.contains(auxv1) && listaVertices.contains(auxv2)) {
            listaVertices.get(listaVertices.indexOf(auxv1)).listaAdjascencia.add(v2);
            listaVertices.get(listaVertices.indexOf(auxv2)).listaAdjascencia.add(v1);
        } else
            System.out.println("O vértice não existe");
        this.L++;
    }

    /**
     * Função para remover uma aresta de 2 vértices.
     * 
     * @param v1 Vértice 1
     * @param v2 Vértice 2
     */
    void remAresta(int v1, int v2) {
        Vertice auxv1 = new Vertice(v1);
        Vertice auxv2 = new Vertice(v2);
        try {
            listaVertices.get(listaVertices.indexOf(auxv1)).listaAdjascencia.remove(new Integer(v2));
            listaVertices.get(listaVertices.indexOf(auxv2)).listaAdjascencia.remove(new Integer(v1));
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("O vértice não existe");
        }
        this.L--;
    }

    public void printGrafo() {
        for (Vertice ver : this.listaVertices) {
            System.out.print(ver.getN() + ": ");
            for (Integer adjver : ver.listaAdjascencia) {
                System.out.print(adjver + " ");
            }
            System.out.println();
        }
    }

    public void printVertices() {
        for (Vertice ver : this.listaVertices) {
            System.out.print("(n: " + ver.getN() + " d: " + ver.getD() + " rot: " + ver.getRot() + ") \n");
        }
    }

    // Getters e Setters

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

    public List<Vertice> getListaVertices() {
        return listaVertices;
    }

    public void setListaVertices(List<Vertice> listaVertices) {
        this.listaVertices = listaVertices;
    }
}
