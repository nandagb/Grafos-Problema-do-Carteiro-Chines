/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package problema.carteiro.chines;


import java.util.ArrayList;
import java.util.List;

public class Algoritmos {
    /**
     * Função que checa se o grafo é conexo.
     * @param grafo Grafo para ser verificado
     * @param ver Vertice sendo verificado no momento
     * @param visitados Lista de vértices já visitados
     */
    public void checarGrafoConexo(Grafo grafo, Vertice ver, List<Vertice> visitados){
        for (Vertice v: grafo.getListaAdjacencia().get(ver)) {
            if (!visitados.contains(v))
            {
                visitados.add(v);
                checarGrafoConexo(grafo, v, visitados);
            }
        }
    }

    /**
     * Função que checa se o grafo é Euleriano.
     * Para isto se utiliza do teorema 2.1 do livro Teoria Computacional de Grafos do autor Jayme Luiz Szwarcfiter.
     * @param grafo grafo para ser verificado
     * @return true caso seja Euleriano, false CC
     */
    public boolean checarGrafoEuleriano(Grafo grafo){
        boolean conexo = false;
        boolean euleriano = false;
        boolean grauPar = true;

        List<Vertice> visitados = new ArrayList<>();

        // Verificar se é conexo
        Vertice ver = grafo.getListaAdjacencia().keySet().stream().findFirst().get();
        visitados.add(ver);
        checarGrafoConexo(grafo, ver, visitados);
        if (visitados.size() == grafo.getV())
            conexo = true;

        System.out.println("Conexo: " + conexo);

        // Se conexo, verificar se todo nó tem grau par
        if (conexo){
            for (Vertice v: grafo.getListaAdjacencia().keySet()) {
                if (grafo.getListaAdjacencia().get(v).size() % 2 != 0)
                {
                    grauPar = false;
                }
            }
        }
        System.out.println("Grau Par: " + grauPar);

        if (conexo && grauPar)
            euleriano = true;

        System.out.println("Euleriano: " + euleriano);

        return euleriano;
    }

    public boolean main(Grafo grafo) {
        boolean euleriano;
        grafo.printGrafo();
        euleriano = checarGrafoEuleriano(grafo);

        return euleriano;
    }
}