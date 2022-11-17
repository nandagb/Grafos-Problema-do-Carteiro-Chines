package problema.carteiro.chines;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertice {
    public int n;
    private double d;
    private double rot;
    public Vertice(int n){
        this.n = n;
    }

    public Vertice(Vertice ver){
        this.n = ver.n;
        this.d = ver.d;
        this.rot = ver.rot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertice vertice = (Vertice) o;
        return n == vertice.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }


    //getters e setters
    public int getN(){
        return this.n;
    }

    public void setN(int n){
        this.n = n;
    }

    public double getD(){
        return this.d;
    }

    public void setD(double d){
        this.d = d;
    }

    public double getRot(){
        return this.rot;
    }

    public void setRot(double rot){
        this.rot = rot;
    }
}
