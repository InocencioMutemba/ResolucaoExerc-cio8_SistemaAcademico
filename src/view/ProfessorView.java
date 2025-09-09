package view;

import javax.swing.*;
import java.awt.*;

/**
 * REQUISITO 2.1: Tela de gestão de professores
 * Permite cadastrar professores
 */
public class ProfessorView extends JFrame {
    private JTextField txtNome, txtIdade, txtDisciplina, txtSalario;
    private JButton btnSalvar, btnLimpar, btnVoltar;
    private JTextArea areaListagem;
    
    public ProfessorView() {
        setTitle("Sistema Acadêmico - Gestão de Professores");
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de formulário
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Cadastro de Professor"));
        
        formPanel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        formPanel.add(txtNome);
        
        formPanel.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        formPanel.add(txtIdade);
        
        formPanel.add(new JLabel("Disciplina:"));
        txtDisciplina = new JTextField();
        formPanel.add(txtDisciplina);
        
        formPanel.add(new JLabel("Salário:"));
        txtSalario = new JTextField();
        formPanel.add(txtSalario);
        
        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnSalvar = new JButton("Salvar");
        btnLimpar = new JButton("Limpar");
        btnVoltar = new JButton("Voltar");
        
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnLimpar);
        buttonPanel.add(btnVoltar);
        
        // Área de listagem
        areaListagem = new JTextArea();
        areaListagem.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaListagem);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Professores Cadastrados"));
        
        // Adicionando componentes ao painel principal
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        
        add(panel);
    }
    
    // Getters para os componentes
    public JTextField getTxtNome() { return txtNome; }
    public JTextField getTxtIdade() { return txtIdade; }
    public JTextField getTxtDisciplina() { return txtDisciplina; }
    public JTextField getTxtSalario() { return txtSalario; }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnLimpar() { return btnLimpar; }
    public JButton getBtnVoltar() { return btnVoltar; }
    public JTextArea getAreaListagem() { return areaListagem; }
}
