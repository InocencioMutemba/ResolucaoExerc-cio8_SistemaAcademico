package model;

/**
 * REQUISITO 1.4: Classe Professor que herda de Pessoa
 * Implementa funcionalidades específicas para professores
 */
public class Professor extends Pessoa {
    private String disciplina;
    private double salario;
    
    public Professor(String nome, int idade, String disciplina, double salario) {
        super(nome, idade);
        this.disciplina = disciplina;
        this.salario = salario;
    }
    
    // Getters e Setters
    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }
    
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    
    @Override
    public String toString() {
        return super.toString() + ", Disciplina: " + disciplina + ", Salário: " + salario;
    }
}
