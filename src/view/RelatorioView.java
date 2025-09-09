package view;

import javax.swing.*;
import java.awt.*;

/**
 * REQUISITO 4.1: Tela de relatórios do sistema
 * Permite visualizar e exportar relatórios de alunos e professores
 */
public class RelatorioView extends JFrame {
    private JComboBox<String> cmbTipoRelatorio;
    private JButton btnGerar, btnExportar, btnVoltar;
    private JTextArea areaRelatorio;
    
    public RelatorioView() {
        setTitle("Sistema Acadêmico - Relatórios");
        setSize(700, 500);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de controles
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        controlPanel.add(new JLabel("Tipo de Relatório:"));
        
        cmbTipoRelatorio = new JComboBox<>(new String[]{
            "Todos", "Alunos", "Professores", "Mensalidades", "Salários"
        });
        controlPanel.add(cmbTipoRelatorio);
        
        btnGerar = new JButton("Gerar Relatório");
        controlPanel.add(btnGerar);
        
        btnExportar = new JButton("Exportar para TXT");
        controlPanel.add(btnExportar);
        
        btnVoltar = new JButton("Voltar");
        controlPanel.add(btnVoltar);
        
        // Área de relatório
        areaRelatorio = new JTextArea();
        areaRelatorio.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaRelatorio);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Relatório"));
        
        // Adicionando componentes ao painel principal
        panel.add(controlPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        add(panel);
    }
    
    // Getters para os componentes
    public JComboBox<String> getCmbTipoRelatorio() { return cmbTipoRelatorio; }
    public JButton getBtnGerar() { return btnGerar; }
    public JButton getBtnExportar() { return btnExportar; }
    public JButton getBtnVoltar() { return btnVoltar; }
    public JTextArea getAreaRelatorio() { return areaRelatorio; }
}
