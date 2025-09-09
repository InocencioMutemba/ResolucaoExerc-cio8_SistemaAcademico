package model;

/**
 * REQUISITO 1.3.1: Classe Bolseiro que herda de Aluno
 * Implementa regras específicas para alunos bolseiros
 */
public class Bolseiro extends Aluno {
    
    public Bolseiro(String nome, int idade, String matricula, String curso, double notaFinal) {
        super(nome, idade, matricula, curso, notaFinal);
    }
    
    /**
     * REQUISITO 2.3.1: Calcula mensalidade para bolseiros:
     * - Dispensa total se nota ≥ 16
     * - Caso contrário, paga metade da mensalidade
     */
    @Override
    public double calcularMensalidade(double valorBase) {
        if (notaFinal >= 16) {
            return 0; // Dispensa total
        } else {
            return valorBase / 2; // Paga metade
        }
    }
    
    /**
     * REQUISITO 2.2: Verifica dispensa acadêmica para bolseiros:
     * - Dispensa se nota final ≥ 16
     */
    @Override
    public boolean isDispensado() {
        return notaFinal >= 16;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Mensalidade: " + calcularMensalidade(1000) + " (Bolseiro)";
    }
}
