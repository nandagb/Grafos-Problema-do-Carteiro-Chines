/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package problema.carteiro.chines;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class Algoritmos {

    public static int PESO = 1;

    /**
     * Função que checa se o grafo é conexo.
     * Complexidade: O(n^2) -> Executa o for até n*n-1 vezes
     * 
     * @param grafo     Grafo para ser verificado
     * @param ver       Vertice sendo verificado no momento
     * @param visitados Lista de vértices já visitados
     */
    public void checarGrafoConexo(Grafo grafo, Vertice ver, List<Integer> visitados) {
        // Para cada vértice adjascente do atual, se ele não foi visitado, visita e
        // checa seus adjascentes
        for (Integer nVertice : ver.listaAdjascencia) {
            if (!visitados.contains(nVertice)) {
                visitados.add(nVertice);
                checarGrafoConexo(grafo,
                        grafo.getListaVertices().get(grafo.getListaVertices().indexOf(new Vertice(nVertice))),
                        visitados);
            }
        }
    }

    public boolean eConexo(Grafo grafo){
        boolean conexo = false;

        List<Integer> visitados = new ArrayList<>();

        // Verificar se é conexo
        Vertice ver = grafo.getListaVertices().get(0);
        visitados.add(ver.getN());
        checarGrafoConexo(grafo, ver, visitados);
        // Se todos vertices foram visitados, o grafo é conexo
        if (visitados.size() == grafo.getV())
            conexo = true;
    
        return conexo;
    }

    /**
     * Função que checa se o grafo é Euleriano.
     * Para isto se utiliza do teorema 2.1 do livro Teoria Computacional de Grafos
     * do autor Jayme Luiz Szwarcfiter.
     * Complexidade: O(n^3) -> checagem do grafo conexo e checagem do grau par
     * executa n vezes
     * 
     * @param grafo grafo para ser verificado
     * @return true caso seja Euleriano, false CC
     */
    public boolean checarGrafoEuleriano(Grafo grafo) {
        boolean conexo = false;
        boolean euleriano = false;
        boolean grauPar = true;

        List<Integer> visitados = new ArrayList<>();

        // Verificar se é conexo
        Vertice ver = grafo.getListaVertices().get(0);
        visitados.add(ver.getN());
        checarGrafoConexo(grafo, ver, visitados);
        // Se todos vertices foram visitados, o grafo é conexo
        if (visitados.size() == grafo.getV())
            conexo = true;

        System.out.println("Conexo: " + conexo);

        // Se conexo, verificar se todo nó tem grau par
        if (conexo) {
            for (Vertice v : grafo.getListaVertices()) {
                if (v.listaAdjascencia.size() % 2 != 0) {
                    grauPar = false;
                }
            }
        }
        System.out.println("Grau Par: " + grauPar);

        // Se for conexo e todo nor for par, é euleriano
        if (conexo && grauPar)
            euleriano = true;

        System.out.println("Euleriano: " + euleriano);

        return euleriano;
    }

    /**
     * Algoritmo de Hierholzer.
     * Implementado assim como descrito no relatório.
     * Complexidade: O(m) -> número máximo de arestas que ele pode percorrer
     * 
     * @param grafo           Grafo que gerará a trilha euleriana
     * @param ver             Vértice atual sendo adicionado à trilha
     * @param trilhaEuleriana Lista que possui a trilha
     */
    public void hierholzer(Grafo grafo, Vertice ver, List<Vertice> trilhaEuleriana) {
        for (int i = 0; i < grafo.getListaVertices().get(grafo.getListaVertices().indexOf(ver)).listaAdjascencia
                .size(); i++) {
            Vertice v = grafo.getListaVertices()
                    .get(grafo.getListaVertices().indexOf(new Vertice(ver.listaAdjascencia.get(i))));
            grafo.remAresta(ver.getN(), v.getN());
            hierholzer(grafo, v, trilhaEuleriana);
        }
        trilhaEuleriana.add(ver);
    }

    public boolean algoritmoLinks(Grafo grafo) {
        boolean linkado = false;
        boolean euleriano = false;
        System.out.println();
        System.out.println("grafo:");
        grafo.printGrafo();
        System.out.println();
        euleriano = checarGrafoEuleriano(grafo);

        if (euleriano) {
            List<Vertice> trilhaEuleriana = new ArrayList<>();
            Vertice ver = grafo.getListaVertices().get(0);
            hierholzer(grafo, ver, trilhaEuleriana);

            System.out.print("Trilha euleriana: ");
            for (Vertice v : trilhaEuleriana) {
                System.out.print(v.getN() + " ");
            }
            System.out.println();

            linkado = true;

            return linkado;
        }

        return euleriano;
    }

    /***
     * Retorna uma lista com todos os pares de vértices com grau ímpar
     * 
     * @param grafo a ser analisado
     * @return Lista com os vértices de grau ímpar
     */
    public void caminhoCasoNaoEuleriano(Grafo grafo) {
        ArrayList<Integer> impares = new ArrayList<>();

        // Verifica se o grau dos vértices é ímpar, se o vértice for ímpar adiona na
        // lista de impares
        for (Vertice ver : grafo.getListaVertices()) {
            if (ver.getGrau() % 2 != 0) {
                //System.out.println("o vértice : " + ver.getN() + " tem grau ímpar");
                impares.add(ver.getN());
            }
        }


        ArrayList<Pair<Integer, Integer>> pares = new ArrayList<>();
        int permutacoes = impares.size() * (impares.size() - 1) / 2;

        // Cria lista com todos os pares possíveis para os vértices ímpares
        for (int i = 0; i < permutacoes; i++) {
            for (int j = 1; j < impares.size(); j++) {
                Pair<Integer, Integer> par = new Pair<Integer, Integer>(impares.get(0), impares.get(j));
                pares.add(par);
            }
            impares.remove(0);
            if (impares.size() == 1)
                break;
        }

        System.out.println();
        System.out.println("Lista com pares de ímpares:");
        for (int i = 0; i < pares.size(); i++) {
            System.out.println("(" + pares.get(i).getKey() + ", " + pares.get(i).getValue() + ")");
        }

        ArrayList<ArrayList<Pair<Integer, Integer>>> combinacoesDePares = new ArrayList<>();
        int perm = pares.size() * (pares.size() - 1) / 2;
        if(pares.size() == 1){
            ArrayList<Pair<Integer, Integer>> combinacao = new ArrayList<>();
            combinacao.add(pares.get(0));// adiciona o primeiro par na primeira combinacao
            combinacoesDePares.add(combinacao);// adiciona a primeira combinacao
        }
        // Achar todas as combinações que passem por todos os vértices
        for (int i = 0; i < perm; i++) {// par que será adicionado primeiro
            ArrayList<Pair<Integer, Integer>> combinacao = new ArrayList<>();
            combinacao.add(pares.get(0));// adiciona o primeiro par na primeira combinacao
            combinacoesDePares.add(combinacao);// adiciona a primeira combinacao
            for (int j = 1; j < pares.size(); j++) {// para todos os pares depois do par adicionado
                for (int k = 0; k < combinacao.size(); k++) {// para todos os elementos de combinação
                    if (pares.get(j).getKey() == combinacao.get(k).getKey() ||
                            pares.get(j).getKey() == combinacao.get(k).getValue() ||
                            pares.get(j).getValue() == combinacao.get(k).getKey() ||
                            pares.get(j).getValue() == combinacao.get(k).getValue()) {
                        break;
                    }
                    combinacao.add(pares.get(j));
                }
            }
            if (pares.get(1).getKey() != pares.get(0).getKey())
                break;
            pares.remove(0);// atualiza o primeiro elemento
            if (pares.size() == 1)
                break;
        }

        System.out.println();
        System.out.println("imprimindo combinacoes de pares:");
        for (int i = 0; i < combinacoesDePares.size(); i++) {
            System.out.println("par " + i + ": ");
            for (int j = 0; j < combinacoesDePares.get(i).size(); j++) {
                System.out.print("(" + combinacoesDePares.get(i).get(j).getKey() + ", "
                        + combinacoesDePares.get(i).get(j).getValue() + ") ");
            }
            System.out.println();
        }

        // entre as combinacoes, encontrar a que tem menor distancia total
        int menor = 0;
        double menorD = Double.POSITIVE_INFINITY;
        double soma = 0;
        for (int i = 0; i < combinacoesDePares.size(); i++) {
            for (int j = 0; j < combinacoesDePares.get(i).size(); j++) {// percorre a combinacao
                // calcula as distancias de key
                dijkstra(grafo, grafo.getListaVertices().get(combinacoesDePares.get(i).get(j).getKey() - 1));
                // System.out.println("distancia " + combinacoesDePares.get(i).get(j).getKey() +
                // " - " + combinacoesDePares.get(i).get(j).getValue() + ": " +
                // grafo.getListaVertices().get(combinacoesDePares.get(i).get(j).getValue()-1).getD());
                soma += grafo.getListaVertices().get(combinacoesDePares.get(i).get(j).getValue() - 1).getD();
            }
            if (soma < menorD) {
                menorD = soma;
                menor = i;
            }
            soma = 0;

        }

        //System.out.println("menor dupla encontrada: ");
        //for (int i = 0; i < combinacoesDePares.get(menor).size(); i++) {
        //    System.out.print("( " + combinacoesDePares.get(menor).get(i).getKey() + ", "
        //            + combinacoesDePares.get(menor).get(i).getValue() + ")");
        //}
        //System.out.println();

        ArrayList<ArrayList<Integer>> caminhosGerados = new ArrayList<>();
        //System.out.println("antes de usar dijkstra");
        // usar dikjstra de novo para calcular os caminhos
        if(combinacoesDePares.size() != 0){
            for (int i = 0; i < combinacoesDePares.get(menor).size(); i++) {
                dijkstra(grafo, grafo.getListaVertices().get(combinacoesDePares.get(menor).get(i).getKey() - 1));
                caminhosGerados.add(
                        calculaCaminho(grafo, combinacoesDePares.get(menor).get(i).getKey(),
                                combinacoesDePares.get(menor).get(i).getValue()));
                //System.out.println("distancia: " + combinacoesDePares.get(menor).get(i).getKey() + " - "
                //        + combinacoesDePares.get(menor).get(i).getValue() + ": "
                //        + grafo.getListaVertices().get(combinacoesDePares.get(menor).get(i).getValue() - 1).getD());
            }
        }

        // 1. ADICIONAR NO GRAFO, AS ARESTAS FORMADAS PELOS CAMINHOS ENCONTRADOS
        for (ArrayList<Integer> caminho : caminhosGerados) {
            for (int i = 0; i < caminho.size() - 1; i++) {
                grafo.addAresta(caminho.get(i), caminho.get(i + 1));
            }
        }

        // 2. COMO O GRAFO AGORA É EULERIANO É SO CHAMAR A FUNCAO DE TRILHA EULERIANA
        Vertice ver = grafo.getListaVertices().get(0);
        List<Vertice> trilhaEuleriana = new ArrayList<>();
        hierholzer(grafo, ver, trilhaEuleriana);

        System.out.print("Trilha euleriana: ");
        for (Vertice v : trilhaEuleriana) {
            System.out.print(v.getN() + " ");
        }
        System.out.println();
    }

    // retorna o vértice com menor distância em uma lista de vértices
    public Vertice menorD(ArrayList<Vertice> lista) {
        Vertice m = lista.get(0);

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getD() < m.getD()) {
                m = lista.get(i);
            }
        }

        return m;
    }

    /**
     * Dijkstra
     * Calcula a menor distância entre o vértice fonte
     * e os demais vértices do grafo
     * 
     * @param grafo
     * @param fonte
     */
    public void dijkstra(Grafo grafo, Vertice fonte) {

        ArrayList<Vertice> F = new ArrayList<>();// grupo dos vértices fechados
        ArrayList<Vertice> A = new ArrayList<>();// grupo dos vértices abertos

        F.add(fonte);

        for (Vertice ver : grafo.getListaVertices()) {
            if (ver.getN() != fonte.getN()) {
                A.add(ver);
            }
        }

        fonte.setD(0);
        fonte.setRot(Double.POSITIVE_INFINITY);

        for (Vertice ver : grafo.getListaVertices()) {// percorre o grafo
            if (ver != fonte) {// se nao for a fonte
                // rotulação inicial
                if (fonte.getListaAdjacencia().contains(ver.getN())) {// se o vértice estiver a distancia de 1 da fonte
                    ver.setRot(fonte.getN());// o rotulo dos vértices adjacentes a fonte é a própria fonte
                    ver.setD(1);// distancia da fonte é 1
                } else {
                    ver.setRot(0);// não definimos um rótulo
                    ver.setD(Double.POSITIVE_INFINITY);// não definimos uma distância
                }
            }
        }

        Vertice ver;

        while (A.size() != 0) {
            ver = menorD(A);// recebe o vértice com a menor distância entre os vértices abertos

            // fecha o vértice
            A.remove(ver);
            F.add(ver);

            for (Integer k : ver.listaAdjascencia) {// para todos os adjacentes de ver
                Vertice adjver = grafo.getListaVertices().get(k - 1);
                if (A.contains(adjver)) {// que estiverem abertos
                    if (adjver.getD() > ver.getD() + PESO) {
                        adjver.setD(ver.getD() + PESO);
                        adjver.setRot(ver.getN());
                    }
                }
            }
        }
        // System.out.println();
        // System.out.println("grafo final: ");
        // grafo.printVertices();
    }

    // retorna o menor caminho do vértice destino até o vértice fonte depois que
    // dijkstra é executado
    public ArrayList<Integer> calculaCaminho(Grafo grafo, Integer fonte, Integer destino) {

        ArrayList<Integer> caminho = new ArrayList<>();
        caminho.add(destino);
        Integer i = destino;// posicao atual

        while (grafo.getListaVertices().get(i - 1).getRot() != fonte) {// enquanto não chegar em fonte
            double rotulo = grafo.getListaVertices().get(i - 1).getRot();
            i = (int) rotulo;
            // System.out.println("i depois de receber rotulo: " + i);
            caminho.add(i);
        }

        caminho.add(fonte);

        //System.out.println("caminho " + destino + " - " + fonte + ": ");
        //for (Integer j : caminho) {
        //    System.out.print(j + " - ");
        //}
        //System.out.println();

        return caminho;
    }

}