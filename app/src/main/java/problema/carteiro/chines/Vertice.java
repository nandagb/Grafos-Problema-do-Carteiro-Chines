package problema.carteiro.chines;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertice {
    public int n; // Valor do vértice
    public Vertice(int n){
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return n == vertice.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
