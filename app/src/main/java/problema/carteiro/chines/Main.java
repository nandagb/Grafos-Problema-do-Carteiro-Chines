package problema.carteiro.chines;

import java.util.Scanner;

public class Main {

    public static void GrafoNaoConexoTest(){
        boolean equals = false;
        Algoritmos main = new Algoritmos();

        Grafo grafoNaoConexo = new Grafo();

        grafoNaoConexo.addVertice(1);
        grafoNaoConexo.addVertice(2);
        grafoNaoConexo.addVertice(3);
        grafoNaoConexo.addVertice(4);
        grafoNaoConexo.addVertice(5);
        grafoNaoConexo.addVertice(6);
        grafoNaoConexo.addVertice(7);
        grafoNaoConexo.addVertice(8);

        grafoNaoConexo.addAresta(1,2);
        grafoNaoConexo.addAresta(1,3);
        grafoNaoConexo.addAresta(1,4);
        grafoNaoConexo.addAresta(1,5);
        grafoNaoConexo.addAresta(2,3);
        grafoNaoConexo.addAresta(2,4);
        grafoNaoConexo.addAresta(2,5);
        grafoNaoConexo.addAresta(3,4);
        grafoNaoConexo.addAresta(3,5);
        grafoNaoConexo.addAresta(4,5);
        grafoNaoConexo.addAresta(6,7);
        grafoNaoConexo.addAresta(7,8);

        equals = main.algoritmoLinks(grafoNaoConexo);
    }

    public static void GrafoConexoImpar() {
        Algoritmos main = new Algoritmos();

        Grafo grafoConexoImpar = new Grafo();

        grafoConexoImpar.addVertice(1);
        grafoConexoImpar.addVertice(2);
        grafoConexoImpar.addVertice(3);
        grafoConexoImpar.addVertice(4);
        grafoConexoImpar.addVertice(5);
        grafoConexoImpar.addVertice(6);
        grafoConexoImpar.addVertice(7);
        grafoConexoImpar.addVertice(8);

        grafoConexoImpar.addAresta(1,2);
        grafoConexoImpar.addAresta(1,3);
        grafoConexoImpar.addAresta(1,4);
        grafoConexoImpar.addAresta(1,5);
        grafoConexoImpar.addAresta(2,3);
        grafoConexoImpar.addAresta(2,4);
        grafoConexoImpar.addAresta(2,5);
        grafoConexoImpar.addAresta(3,4);
        grafoConexoImpar.addAresta(3,5);
        grafoConexoImpar.addAresta(3,6);
        grafoConexoImpar.addAresta(3,7);
        grafoConexoImpar.addAresta(4,5);
        grafoConexoImpar.addAresta(6,7);
        grafoConexoImpar.addAresta(7,8);

        main.algoritmoLinks(grafoConexoImpar);

        main.numGrauImpar(grafoConexoImpar);

        main.dijkstra(grafoConexoImpar, grafoConexoImpar.getListaVertices().get(0));
    }
    

    public static void GrafoEuleriano() {
        Algoritmos main = new Algoritmos();

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

        main.algoritmoLinks(grafoEuleriano);

    }

    public static void GrafoNaoEuleriano() {
        Algoritmos main = new Algoritmos();

        Grafo grafoNaoEuleriano = new Grafo();

        grafoNaoEuleriano.addVertice(1);
        grafoNaoEuleriano.addVertice(2);
        grafoNaoEuleriano.addVertice(3);
        grafoNaoEuleriano.addVertice(4);
        grafoNaoEuleriano.addVertice(5);
        grafoNaoEuleriano.addVertice(6);
        grafoNaoEuleriano.addVertice(7);
        grafoNaoEuleriano.addVertice(8);

        grafoNaoEuleriano.addAresta(1,2);
        grafoNaoEuleriano.addAresta(1,3);
        grafoNaoEuleriano.addAresta(1,4);
        grafoNaoEuleriano.addAresta(1,5);
        grafoNaoEuleriano.addAresta(2,3);
        grafoNaoEuleriano.addAresta(2,4);
        grafoNaoEuleriano.addAresta(3,4);
        grafoNaoEuleriano.addAresta(3,5);
        grafoNaoEuleriano.addAresta(3,6);
        grafoNaoEuleriano.addAresta(3,7);
        grafoNaoEuleriano.addAresta(4,5);
        grafoNaoEuleriano.addAresta(7,8);

        main.algoritmoLinks(grafoNaoEuleriano);

        main.numGrauImpar(grafoNaoEuleriano);

        main.dijkstra(grafoNaoEuleriano, grafoNaoEuleriano.getListaVertices().get(0));
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Olá, qual teste você deseja realizar?");
        System.out.println("0 - Sair");
        System.out.println("1 - Grafo não conexo");
        System.out.println("2 - Grafo Conexo de Grau Impar");
        System.out.println("3 - Grafo conexo de Grau par");
        System.out.println("4 - Grafo não Euleriano");                

        int test = scan.nextInt();
        while (test != 0) {
            switch (test) {
                case 1:
                    GrafoNaoConexoTest();
                    break;
                case 2:
                    GrafoConexoImpar();
                    break;
                case 3:
                    GrafoEuleriano();
                    break;
                case 4:
                    GrafoNaoEuleriano();
                    break;
                default:
                    System.out.println("Não possui esse caso de teste");
                    break;
            }
            test = scan.nextInt();
        }
    }
}
