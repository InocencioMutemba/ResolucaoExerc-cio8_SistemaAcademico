package view;

import javax.swing.*;
import java.awt.*;

/**
 * REQUISITO TÉCNICO: Tela principal do sistema com menu de navegação
 * Implementa interface gráfica usando Swing
 */
public class MainView extends JFrame {
    private JButton btnAlunos, btnProfessores, btnRelatorios, btnSair;
    
    public MainView() {
        setTitle("Sistema Acadêmico - Tela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        // Painel principal
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Título
        JLabel titulo = new JLabel("Sistema Acadêmico", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titulo, gbc);
        
        // Botões
        btnAlunos = new JButton("Gestão de Alunos");
        btnAlunos.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(btnAlunos, gbc);
        
        btnProfessores = new JButton("Gestão de Professores");
        btnProfessores.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 2;
        panel.add(btnProfessores, gbc);
        
        btnRelatorios = new JButton("Relatórios");
        btnRelatorios.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 3;
        panel.add(btnRelatorios, gbc);
        
        btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 4;
        panel.add(btnSair, gbc);
        
        add(panel);
    }
    
    public JButton getBtnAlunos() { return btnAlunos; }
    public JButton getBtnProfessores() { return btnProfessores; }
    public JButton getBtnRelatorios() { return btnRelatorios; }
    public JButton getBtnSair() { return btnSair; }
}
