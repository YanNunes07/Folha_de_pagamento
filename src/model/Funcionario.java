package model;

public class Funcionario {
    public String nome;
    private String CPF, cargo;
    private double valorHora, quantidadeDeHoras, dependentes;
    private int tipoInsalubridade, idade;

    public Funcionario(){}

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getQuantidadeDeHoras() {
        return quantidadeDeHoras;
    }

    public void setQuantidadeDeHoras(double quantidadeDeHoras) {
        this.quantidadeDeHoras = quantidadeDeHoras;
    }

    public double getInsalubridade() {
        return tipoInsalubridade;
    }

    public void setInsalubridade(int insalubridade) {
        this.tipoInsalubridade = insalubridade;
    }

    public double getDeprndentes() {
        return dependentes;
    }

    public void setDependentes(double dependentes) {
        this.dependentes = dependentes;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double calcularSalarioBruto(){
        return this.valorHora * this.quantidadeDeHoras;
    }

    public double valorVT(){
        return (this.calcularSalarioBruto() * 0.06);
    }

    public double valeTranspote(){
        return (9.60 * 20);
    }

    public double calcularVT(){
        if (this.valorVT()>valeTranspote()){
            return valeTranspote();
        }else{
            return this.valorVT();
        }
    }

    public double calcularSalarioFamilia(){

        if (this.calcularSalarioBruto()<907.77){
            return 46.54;
        }else if (this.calcularSalarioBruto()>= 907.78 && this.calcularSalarioBruto()<=1364.43){
            return 32.80;
        }else{
            return 0;
        }
    }

    public double quantidadesDeDependentes(){
        if (this.dependentes==1){
            return calcularSalarioFamilia()*1;
        }else if (this.dependentes==2){
            return calcularSalarioFamilia()*2;
        }else if (this.dependentes==3) {
            return calcularSalarioFamilia() * 3;
        }else {
            return 0;
        }
    }



    public double calcularInsalubridade(){
            if (this.tipoInsalubridade == 2){
                return 997*0.10;
            }else if (this.tipoInsalubridade == 3){
                return 997*0.20;
            }else if (this.tipoInsalubridade==4){
               return 997*0.30;
            }else{return 0;}
    }

    public double calcularInss(){
        double salarioBruto = this.calcularSalarioBruto();
        if (salarioBruto <= 1751.81){
            return salarioBruto * 0.08;
        }else if (salarioBruto >= 1751.82 && salarioBruto <=2919.72){
            return salarioBruto * 0.09;
        }else if (salarioBruto >= 2919.73 && salarioBruto <= 5839.45){
            return salarioBruto * 0.11;
        }else if (salarioBruto > 5839.46){
            return salarioBruto * 0.27;
        }else{
            return 0;
        }
    }

    public double descontoVR(){
        return 250*0.20;
    }

    public double beneficios(){
        return (this.calcularInsalubridade()+this.quantidadesDeDependentes());
    }

    public double descontos(){
        return (this.descontoVR()+this.calcularVT()+calcularInss());
    }

    public double calcularSalarioLiquido(){
        return (this.calcularSalarioBruto()+this.beneficios())-this.descontos();
    }

    @Override
    public String toString(){

        return "\nNome:"+nome+
                "\nCPF: "+CPF+
                "\nIdade:"+idade+
                "\nCargo:"+cargo;

    }
}
