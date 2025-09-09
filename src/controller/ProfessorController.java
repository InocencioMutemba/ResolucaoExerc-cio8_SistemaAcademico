package controller;

import model.Professor;
import model.SistemaAcademico;
import view.ProfessorView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainView;

/**
 * REQUISITO 2.1: Controlador para gestão de professores
 * Implementa a lógica de cadastro e listagem de professores
 */
public class ProfessorController {
    private ProfessorView view;
    private SistemaAcademico sistema;
    
    public ProfessorController(ProfessorView view, SistemaAcademico sistema) {
        this.view = view;
        this.sistema = sistema;
        
        // Adicionar listeners aos botões
        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarProfessor();
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
        
        // Carregar lista de professores
        atualizarListagem();
    }
    
    private void salvarProfessor() {
        try {
            String nome = view.getTxtNome().getText();
            int idade = Integer.parseInt(view.getTxtIdade().getText());
            String disciplina = view.getTxtDisciplina().getText();
            double salario = Double.parseDouble(view.getTxtSalario().getText());
            
            Professor professor = new Professor(nome, idade, disciplina, salario);
            sistema.adicionarPessoa(professor);
            
            JOptionPane.showMessageDialog(view, "Professor salvo com sucesso!");
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
        view.getTxtDisciplina().setText("");
        view.getTxtSalario().setText("");
    }
    
    private void atualizarListagem() {
        StringBuilder sb = new StringBuilder();
        for (Professor professor : sistema.getProfessores()) {
            sb.append(professor.toString()).append("\n");
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
