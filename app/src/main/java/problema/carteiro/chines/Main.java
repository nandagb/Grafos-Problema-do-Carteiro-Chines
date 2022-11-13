package problema.carteiro.chines;

public class Main {
    public static void main(String[] args) {
        Algoritmos algoritmos = new Algoritmos();

        Grafo grafoEuleriano = new Grafo();

        grafoEuleriano.addVertice(1);
        grafoEuleriano.addVertice(2);
        grafoEuleriano.addVertice(3);
        grafoEuleriano.addVertice(4);
        grafoEuleriano.addVertice(5);
        grafoEuleriano.addVertice(6);
        grafoEuleriano.addVertice(7);

        grafoEuleriano.addAresta(1,2);
        grafoEuleriano.addAresta(1,3);
        grafoEuleriano.addAresta(1,4);
        grafoEuleriano.addAresta(1,5);
        grafoEuleriano.addAresta(2,3);
        grafoEuleriano.addAresta(2,4);
        grafoEuleriano.addAresta(2,5);
        grafoEuleriano.addAresta(3,4);
        grafoEuleriano.addAresta(3,5);
        grafoEuleriano.addAresta(3,6);
        grafoEuleriano.addAresta(3,7);
        grafoEuleriano.addAresta(4,5);
        grafoEuleriano.addAresta(6,7);

        grafoEuleriano.printGrafo();

        algoritmos.checarGrafoEuleriano(grafoEuleriano);
    }
}
