package problema.carteiro.chines;

import java.util.Scanner;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void GrafoNaoConexo(){
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

        main.caminhoCasoNaoEuleriano(grafoNaoEuleriano);

    }

    public static void grafoAleatorio(int vertices, int arestas){
        Algoritmos main = new Algoritmos();
        Grafo grafoAleatorio = new Grafo();
        Random random = new Random();

        for(int i=1; i<=vertices; i++){
            grafoAleatorio.addVertice(i);    
        }

        ArrayList<Pair<Integer, Integer>> container = new ArrayList<>();

        int a1 = random.nextInt();
        int a2 = random.nextInt();
        if(a1<0) a1 = a1*(-1);
        if(a2<0) a2 = a2*(-1);
        a1 = (a1%vertices)+1;
        a2 = (a2%vertices)+1;

        //System.out.println("a1: " + a1);
        //System.out.println("a2: " + a2);

        Pair<Integer, Integer> par1 = new Pair(a1, a2);
        Pair<Integer, Integer> par2 = new Pair(a2, a1);

        for(int i=1; i<=arestas; i++){
            while( container.contains(par1) || container.contains(par2) || a1 == a2){
                int b1 = random.nextInt();
                int b2 = random.nextInt();
                if(b1<0) b1 = b1*(-1);
                if(b2<0) b2 = b2*(-1);
                b1 = (b1%vertices)+1;
                b2 = (b2%vertices)+1;

                Pair<Integer, Integer> par11 = new Pair(b1, b2);
                Pair<Integer, Integer> par22 = new Pair(b2, b1);

                par1 = par11;
                par2 = par22;
                a1 = b1;
                a2 = b2;
            }
            
            container.add(par1);
            grafoAleatorio.addAresta(a1,a2);
        }

        System.out.println();
        System.out.println("grafo:");
        grafoAleatorio.printGrafo();
        System.out.println();
        
        if(!main.checarGrafoEuleriano(grafoAleatorio)){
            if(main.eConexo(grafoAleatorio)){
                main.caminhoCasoNaoEuleriano(grafoAleatorio);
            }
            else{
                System.out.println("Não é conexo! Não consegui calcular o caminho!");
            }
        }
        
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Olá, qual teste você deseja realizar?");
        System.out.println("0 - Sair");
        System.out.println("1 - Grafo não conexo");
        System.out.println("2 - Grafo Conexo de Grau Impar");
        System.out.println("3 - Grafo conexo de Grau par");
        System.out.println("4 - Grafo não Euleriano");      
        System.out.println("5 - Grafo Aleatório");          

        int test = scan.nextInt();
        while (test != 0) {
            switch (test) {
                case 1:
                    GrafoNaoConexo();
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
                case 5:
                    System.out.print("Digite o número de vértices: ");
                    int vertices = scan.nextInt();
                    System.out.print("Digite o número de arestas: ");
                    int arestas = scan.nextInt();
                    grafoAleatorio(vertices, arestas);
                    break;
                default:
                    System.out.println("Não possui esse caso de teste");
                    break;
            }
            test = scan.nextInt();
        }
    }
}
