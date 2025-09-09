package controller;

import model.*;
import view.AlunoView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainView;

/**
 * REQUISITO 2.1: Controlador para gestão de alunos
 * Implementa a lógica de cadastro e listagem de alunos
 */
public class AlunoController {
    private AlunoView view;
    private SistemaAcademico sistema;
    
    public AlunoController(AlunoView view, SistemaAcademico sistema) {
        this.view = view;
        this.sistema = sistema;
        
        // Adicionar listeners aos botões
        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAluno();
            }
        });
        
        this.view.getBtnLimpar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparFormulario();
            }
        });
        
        this.view.getBtnVoltar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        
        // Carregar lista de alunos
        atualizarListagem();
    }
    
    private void salvarAluno() {
        try {
            String nome = view.getTxtNome().getText();
            int idade = Integer.parseInt(view.getTxtIdade().getText());
            String matricula = view.getTxtMatricula().getText();
            String curso = view.getTxtCurso().getText();
            double notaFinal = Double.parseDouble(view.getTxtNota().getText());
            String tipo = (String) view.getCmbTipoAluno().getSelectedItem();
            
            Aluno aluno;
            if ("Bolseiro".equals(tipo)) {
                aluno = new Bolseiro(nome, idade, matricula, curso, notaFinal);
            } else {
                aluno = new NaoBolseiro(nome, idade, matricula, curso, notaFinal);
            }
            
            sistema.adicionarPessoa(aluno);
            JOptionPane.showMessageDialog(view, "Aluno salvo com sucesso!");
            limparFormulario();
            atualizarListagem();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Erro: Verifique os campos numéricos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparFormulario() {
        view.getTxtNome().setText("");
        view.getTxtIdade().setText("");
        view.getTxtMatricula().setText("");
        view.getTxtCurso().setText("");
        view.getTxtNota().setText("");
        view.getCmbTipoAluno().setSelectedIndex(0);
    }
    
    private void atualizarListagem() {
        StringBuilder sb = new StringBuilder();
        for (Aluno aluno : sistema.getAlunos()) {
            sb.append(aluno.toString()).append("\n");
        }
        view.getAreaListagem().setText(sb.toString());
    }
    
    private void voltar() {
        view.dispose();
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView, sistema);
        mainView.setVisible(true);
    }
}

