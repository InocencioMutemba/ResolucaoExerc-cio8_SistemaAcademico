package util;

import model.Pessoa;
import model.SistemaAcademico;
import java.io.*;
import java.util.List;

/**
 * Classe utilitária para gerência de ficheiros
 * Implementa serialização de objetos para persistência
 */
public class FileManager {
    private static final String FILE_NAME = "sistema_academico.dat";
    
    public static void salvarDados(SistemaAcademico sistema) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(sistema.getPessoas());
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
    
    public static void carregarDados(SistemaAcademico sistema) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            @SuppressWarnings("unchecked")
            List<Pessoa> pessoas = (List<Pessoa>) ois.readObject();
            sistema.getPessoas().clear();
            sistema.getPessoas().addAll(pessoas);
            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro não encontrado. Iniciando com dados vazios.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

    private FileManager() {
    }
}
