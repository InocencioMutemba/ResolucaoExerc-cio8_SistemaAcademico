package model;

import java.io.Serializable;

/**
 * REQUISITO 1.1: Classe base Pessoa com atributos comuns
 * Implementa Serializable para permitir gravação em ficheiro
 */
public abstract class Pessoa implements Serializable {
    protected String nome;
    protected int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
}
