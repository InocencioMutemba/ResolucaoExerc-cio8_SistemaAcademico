package model;

/**
 * REQUISITO 1.2: Classe Aluno que herda de Pessoa
 * Implementa funcionalidades básicas de aluno
 */
public abstract class Aluno extends Pessoa {
    protected String matricula;
    protected String curso;
    protected double notaFinal;
    
    public Aluno(String nome, int idade, String matricula, String curso, double notaFinal) {
        super(nome, idade);
        this.matricula = matricula;
        this.curso = curso;
        this.notaFinal = notaFinal;
    }
    
    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    
    public double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(double notaFinal) { this.notaFinal = notaFinal; }
    
    // REQUISITO 2.2: Método abstrato para cálculo de mensalidade
    public abstract double calcularMensalidade(double valorBase);
    
    // REQUISITO 2.2: Método para verificar dispensa acadêmica
    public abstract boolean isDispensado();
    
    @Override
    public String toString() {
        return super.toString() + ", Matrícula: " + matricula + ", Curso: " + curso + 
               ", Nota Final: " + notaFinal + ", Tipo: " + this.getClass().getSimpleName();
    }
}
