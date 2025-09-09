package view;

import javax.swing.*;
import java.awt.*;

/**
 * REQUISITO 2.1: Tela de gestão de alunos
 * Permite cadastrar alunos (bolseiros e não bolseiros)
 */
public class AlunoView extends JFrame {
    private JTextField txtNome, txtIdade, txtMatricula, txtCurso, txtNota;
    private JComboBox<String> cmbTipoAluno;
    private JButton btnSalvar, btnLimpar, btnVoltar;
    private JTextArea areaListagem;
    
    public AlunoView() {
        setTitle("Sistema Acadêmico - Gestão de Alunos");
        setSize(600, 500);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de formulário
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Cadastro de Aluno"));
        
        formPanel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        formPanel.add(txtNome);
        
        formPanel.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        formPanel.add(txtIdade);
        
        formPanel.add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        formPanel.add(txtMatricula);
        
        formPanel.add(new JLabel("Curso:"));
        txtCurso = new JTextField();
        formPanel.add(txtCurso);
        
        formPanel.add(new JLabel("Nota Final:"));
        txtNota = new JTextField();
        formPanel.add(txtNota);
        
        formPanel.add(new JLabel("Tipo de Aluno:"));
        cmbTipoAluno = new JComboBox<>(new String[]{"Bolseiro", "Não-Bolseiro"});
        formPanel.add(cmbTipoAluno);
        
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
        scrollPane.setBorder(BorderFactory.createTitledBorder("Alunos Cadastrados"));
        
        // Adicionando componentes ao painel principal
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        
        add(panel);
    }
    
    // Getters para os componentes
    public JTextField getTxtNome() { return txtNome; }
    public JTextField getTxtIdade() { return txtIdade; }
    public JTextField getTxtMatricula() { return txtMatricula; }
    public JTextField getTxtCurso() { return txtCurso; }
    public JTextField getTxtNota() { return txtNota; }
    public JComboBox<String> getCmbTipoAluno() { return cmbTipoAluno; }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnLimpar() { return btnLimpar; }
    public JButton getBtnVoltar() { return btnVoltar; }
    public JTextArea getAreaListagem() { return areaListagem; }
}

