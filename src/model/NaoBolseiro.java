package model;

/**
 * REQUISITO 1.3.2: Classe NaoBolseiro que herda de Aluno
 * Implementa regras específicas para alunos não bolseiros
 */
public class NaoBolseiro extends Aluno {
    
    public NaoBolseiro(String nome, int idade, String matricula, String curso, double notaFinal) {
        super(nome, idade, matricula, curso, notaFinal);
    }
    
    /**
     * REQUISITO 2.3.2: Calcula mensalidade para não bolseiros:
     * - Sempre paga a mensalidade completa
     */
    @Override
    public double calcularMensalidade(double valorBase) {
        return valorBase; // Sempre paga valor completo
    }
    
    /**
     * REQUISITO 2.2: Verifica dispensa acadêmica para não bolseiros:
     * - Dispensa se nota final ≥ 14
     */
    @Override
    public boolean isDispensado() {
        return notaFinal >= 14;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Mensalidade: " + calcularMensalidade(1000) + " (Não-Bolseiro)";
    }
}
