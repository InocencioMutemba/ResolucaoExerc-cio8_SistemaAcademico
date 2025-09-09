package controller;

import model.SistemaAcademico;
import util.FileManager;
import view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AlunoView;
import view.ProfessorView;
import view.RelatorioView;

/**
 * REQUISITO TÉCNICO: Controlador principal do sistema
 * Gerencia a navegação entre telas e operações básicas
 */
public class MainController {
    private MainView view;
    private SistemaAcademico sistema;
    
    public MainController(MainView view, SistemaAcademico sistema) {
        this.view = view;
        this.sistema = sistema;
        
        // REQUISITO 3: Carregar dados ao iniciar
        FileManager.carregarDados(sistema);
        
        // Adicionar listeners aos botões
        this.view.getBtnAlunos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaAlunos();
            }
        });
        
        this.view.getBtnProfessores().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaProfessores();
            }
        });
        
        this.view.getBtnRelatorios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaRelatorios();
            }
        });
        
        this.view.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }
    
    private void abrirTelaAlunos() {
        view.setVisible(false);
        AlunoView alunoView = new AlunoView();
        AlunoController alunoController = new AlunoController(alunoView, sistema);
        alunoView.setVisible(true);
    }
    
    private void abrirTelaProfessores() {
        view.setVisible(false);
        ProfessorView professorView = new ProfessorView();
        ProfessorController professorController = new ProfessorController(professorView, sistema);
        professorView.setVisible(true);
    }
    
    private void abrirTelaRelatorios() {
        view.setVisible(false);
        RelatorioView relatorioView = new RelatorioView();
        RelatorioController relatorioController = new RelatorioController(relatorioView, sistema);
        relatorioView.setVisible(true);
    }
    
    private void sair() {
        // REQUISITO 3: Salvar dados antes de sair
        FileManager.salvarDados(sistema);
        System.exit(0);
    }
    
    public void iniciar() {
        view.setVisible(true);
    }
}
