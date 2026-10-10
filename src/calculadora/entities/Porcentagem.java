package calculadora.entities;

public class Porcentagem {
private double porcen; //Porcentagem
private double valorTotal; //Valor total

public double getPorcen() {
    return porcen;
}

public void setPorcen(double porcen) {
    this.porcen = porcen;
}

public double getValorTotal() {
    return valorTotal;
}

public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
}

 public double porceMath() {
    return this.porcen * (this.valorTotal / 100.0);
}

    @Override
    public String toString() {
        return ""
         + porceMath() +
          "";
    }
}
