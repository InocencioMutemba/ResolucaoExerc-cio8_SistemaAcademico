package controller;

import model.*;
import view.RelatorioView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import view.MainView;

/**
 * REQUISITO 4: Controlador para geração de relatórios
 * Implementa relatórios com recursividade conforme exigido
 */
public class RelatorioController {
    private RelatorioView view;
    private SistemaAcademico sistema;
    
    public RelatorioController(RelatorioView view, SistemaAcademico sistema) {
        this.view = view;
        this.sistema = sistema;
        
        // Adicionar listeners aos botões
        this.view.getBtnGerar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarRelatorio();
            }
        });
        
        this.view.getBtnExportar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportarRelatorio();
            }
        });
        
        this.view.getBtnVoltar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
    }
    
    private void gerarRelatorio() {
        String tipo = (String) view.getCmbTipoRelatorio().getSelectedItem();
        StringBuilder relatorio = new StringBuilder();
        
        switch (tipo) {
            case "Todos":
                relatorio.append("=== RELATÓRIO COMPLETO ===\n\n");
                relatorio.append(gerarRelatorioRecursivo(sistema.getPessoas(), 0));
                break;
                
            case "Alunos":
                relatorio.append("=== RELATÓRIO DE ALUNOS ===\n\n");
                relatorio.append(gerarRelatorioAlunosRecursivo(sistema.getAlunos(), 0));
                break;
                
            case "Professores":
                relatorio.append("=== RELATÓRIO DE PROFESSORES ===\n\n");
                relatorio.append(gerarRelatorioProfessoresRecursivo(sistema.getProfessores(), 0));
                break;
                
            case "Mensalidades":
                relatorio.append("=== RELATÓRIO DE MENSALIDADES ===\n\n");
                double totalMensalidades = sistema.calcularTotalMensalidades(sistema.getAlunos(), 0, 1000);
                relatorio.append("Total de mensalidades: ").append(totalMensalidades).append("\n");
                break;
                
            case "Salários":
                relatorio.append("=== RELATÓRIO DE SALÁRIOS ===\n\n");
                double totalSalarios = sistema.calcularTotalSalarios(sistema.getProfessores(), 0);
                relatorio.append("Total de salários: ").append(totalSalarios).append("\n");
                break;
        }
        
        view.getAreaRelatorio().setText(relatorio.toString());
    }
    
    /**
     * REQUISITO 4.2: Método recursivo para gerar relatório de todas as pessoas
     * @param pessoas lista de pessoas
     * @param index índice atual para recursão
     * @return string com relatório
     */
    private String gerarRelatorioRecursivo(java.util.List<Pessoa> pessoas, int index) {
        if (index >= pessoas.size()) {
            return "";
        }
        
        Pessoa p = pessoas.get(index);
        String linha = (index + 1) + ". " + p.toString() + "\n";
        
        return linha + gerarRelatorioRecursivo(pessoas, index + 1);
    }
    
    /**
     * REQUISITO 4.2: Método recursivo para gerar relatório de alunos
     * @param alunos lista de alunos
     * @param index índice atual para recursão
     * @return string com relatório
     */
    private String gerarRelatorioAlunosRecursivo(java.util.List<Aluno> alunos, int index) {
        if (index >= alunos.size()) {
            return "";
        }
        
        Aluno a = alunos.get(index);
        String linha = (index + 1) + ". " + a.toString() + 
                      ", Dispensado: " + a.isDispensado() + "\n";
        
        return linha + gerarRelatorioAlunosRecursivo(alunos, index + 1);
    }
    
    /**
     * REQUISITO 4.2: Método recursivo para gerar relatório de professores
     * @param professores lista de professores
     * @param index índice atual para recursão
     * @return string com relatório
     */
    private String gerarRelatorioProfessoresRecursivo(java.util.List<Professor> professores, int index) {
        if (index >= professores.size()) {
            return "";
        }
        
        Professor p = professores.get(index);
        String linha = (index + 1) + ". " + p.toString() + "\n";
        
        return linha + gerarRelatorioProfessoresRecursivo(professores, index + 1);
    }
    
    /**
     * REQUISITO 4.1: Exportar relatório para ficheiro TXT
     */
    private void exportarRelatorio() {
        try {
            String relatorio = view.getAreaRelatorio().getText();
            if (relatorio.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Gere um relatório primeiro!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relatório");
            if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.endsWith(".txt")) {
                    filePath += ".txt";
                }
                
                try (FileWriter writer = new FileWriter(filePath)) {
                    writer.write(relatorio);
                    JOptionPane.showMessageDialog(view, "Relatório exportado com sucesso!");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao exportar relatório: " + ex.getMessage(), 
                                         "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void voltar() {
        view.dispose();
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView, sistema);
        mainView.setVisible(true);
    }
}
