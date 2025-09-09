package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal do sistema que gerencia todas as pessoas
 * Implementa Singleton pattern para garantir uma única instância
 */
public class SistemaAcademico {
    private static SistemaAcademico instance;
    private List<Pessoa> pessoas;
    
    private SistemaAcademico() {
        pessoas = new ArrayList<>();
    }
    
    public static SistemaAcademico getInstance() {
        if (instance == null) {
            instance = new SistemaAcademico();
        }
        return instance;
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
    
    public List<Pessoa> getPessoas() {
        return pessoas;
    }
    
    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Aluno) {
                alunos.add((Aluno) p);
            }
        }
        return alunos;
    }
    
    public List<Professor> getProfessores() {
        List<Professor> professors = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Professor) {
                professors.add((Professor) p);
            }
        }
        return professors;
    }
    
    /**
     * REQUISITO 4.2: Método recursivo para calcular o total de mensalidades
     * @param alunos lista de alunos
     * @param index índice atual para recursão
     * @param valorBase valor base da mensalidade
     * @return total de mensalidades
     */
    public double calcularTotalMensalidades(List<Aluno> alunos, int index, double valorBase) {
        if (index >= alunos.size()) {
            return 0;
        }
        return alunos.get(index).calcularMensalidade(valorBase) + 
               calcularTotalMensalidades(alunos, index + 1, valorBase);
    }
    
    /**
     *  Método recursivo para calcular o total de salários
     * @param professores lista de professores
     * @param index índice atual para recursão
     * @return total de salários
     */
    public double calcularTotalSalarios(List<Professor> professores, int index) {
        if (index >= professores.size()) {
            return 0;
        }
        return professores.get(index).getSalario() + 
               calcularTotalSalarios(professores, index + 1);
    }
}
