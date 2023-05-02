package com.daivu.telas;

import java.awt.Color;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.daivu.classes.Cliente;

public class TelaCadastro extends JFrame {
	private static final long serialVersionUID = 1L;
	// CRIANDO OBJETOS
	private JLabel jl_Nome = new JLabel("Nome");
	private JLabel jl_Email = new JLabel("Email");
	private JLabel jl_Cpf = new JLabel("CPF");
	private JLabel jl_Telefone = new JLabel("Telefone");
	private JLabel jl_Titulo = new JLabel("Bem Vindo!");
	private JLabel jl_Logo = new JLabel();
	private JLabel jl_SubTitulo = new JLabel("Selecione a opção desejada");
	private JLabel jl_CriarConta = new JLabel("Cadastrar Cliente");
	private JLabel jl_Fundo = new JLabel();
	private JLabel jl_Genero = new JLabel("Escolha seu gênero");
	private JTextField jtf_Nome = new JTextField();
	private JTextField jtf_Email = new JTextField();
	private JTextField jtf_Cpf = new JTextField();
	private JTextField jtf_Telefone = new JTextField();

	private JButton jbCadastrar = new JButton("Cadastrar");
	private JButton jbMostrar = new JButton("Mostrar");
	private JButton jbPesquisar = new JButton("Pesquisar");
	private JButton jbSair = new JButton();

	private JRadioButton jrb_f = new JRadioButton("Feminino");
	private JRadioButton jrb_m = new JRadioButton("Masculino");
	private JRadioButton jrb_o = new JRadioButton("Outro");
	private ButtonGroup bg_genero = new ButtonGroup();

	private ImageIcon img_logo = new ImageIcon(getClass().getResource("/com/daivu/imagens/logo.png"));
	private ImageIcon img_fechar = new ImageIcon(getClass().getResource("/com/daivu/imagens/cruzar.png"));

	private Cliente[] clientes = new Cliente[20];
	private int contador = 0;

	// DEFININDO CORES
	Color corDestaque = new Color(99, 171, 154);
	Color corTexto = new Color(71, 74, 81);
	Color corEntrada = new Color(236, 240, 241);
	Color corFundo = new Color(255, 255, 255);

	// DEFININDO TAMANHO
	int largura = 1000, altura = 600;
	int pAltura = altura / 100;
	int pLargura = largura / 100;
	
	// VARIAVEIS
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private String genero;

	public TelaCadastro(String title) throws HeadlessException {
		super(title);
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		configurarComponentes();
		criarEventos();
	}

	private void configurarComponentes() {
		// CONFIGURANDO OBJETOS
		jl_Fundo.setBackground(corDestaque);
		jl_Fundo.setOpaque(true);
		jl_Titulo.setForeground(corFundo);
		jl_Titulo.setFont(new Font("Arial", Font.BOLD, 33));
		jl_SubTitulo.setForeground(corFundo);
		jl_SubTitulo.setFont(new Font("Helvetica", Font.PLAIN, 18));
		jl_Genero.setForeground(corTexto);

		jl_CriarConta.setForeground(corDestaque);
		jl_CriarConta.setFont(new Font("Arial", Font.BOLD, 33));

		jl_Email.setForeground(corTexto);
		jl_Cpf.setForeground(corTexto);
		jl_Telefone.setForeground(corTexto);
		jl_Nome.setForeground(corTexto);

		img_logo.setImage(img_logo.getImage().getScaledInstance(100, 100, 100));
		img_fechar.setImage(img_fechar.getImage().getScaledInstance(20, 20, 100));
		jl_Logo.setIcon(img_logo);
		jbSair.setIcon(img_fechar);
		jbSair.setBorder(null);
		jbSair.setOpaque(false);
		jbSair.setBackground(new Color(0,0,0,0));

		jbCadastrar.setForeground(corTexto);
		jbCadastrar.setBackground(corDestaque);
		jbCadastrar.setFocusPainted(false);
		jbCadastrar.setBorder(BorderFactory.createLineBorder(corDestaque));

		jbMostrar.setForeground(corFundo);
		jbMostrar.setBackground(corDestaque);
		jbMostrar.setFocusPainted(false);
		jbMostrar.setBorder(BorderFactory.createLineBorder(corFundo));

		jbPesquisar.setForeground(corFundo);
		jbPesquisar.setBackground(corDestaque);
		jbPesquisar.setFocusPainted(false);
		jbPesquisar.setBorder(BorderFactory.createLineBorder(corFundo));

		jtf_Cpf.setBackground(corEntrada);
		jtf_Email.setBackground(corEntrada);
		jtf_Nome.setBackground(corEntrada);
		jtf_Telefone.setBackground(corEntrada);

		jtf_Cpf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(corDestaque, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		jtf_Email.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(corDestaque, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		jtf_Nome.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(corDestaque, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		jtf_Telefone.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(corDestaque, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));

		jrb_m = new JRadioButton("Masculino", true);
		jrb_f = new JRadioButton("Feminino");
		jrb_o = new JRadioButton("Outros");

		jrb_m.setOpaque(false);
		jrb_f.setOpaque(false);
		jrb_o.setOpaque(false);
		jrb_m.setFocusPainted(false);
		jrb_f.setFocusPainted(false);
		jrb_o.setFocusPainted(false);
		jrb_m.setForeground(corTexto);
		jrb_f.setForeground(corTexto);
		jrb_o.setForeground(corTexto);
		bg_genero.add(jrb_f);
		bg_genero.add(jrb_m);
		bg_genero.add(jrb_o);

		// DIMENSIONAR O COMPONONENTE
		jl_Fundo.setBounds(0, 0, pLargura * 39, pAltura * 100);

		jbMostrar.setBounds(pLargura*6+2, pAltura*47, pLargura*13, pAltura*7);
		jbPesquisar.setBounds(pLargura*20+2, pAltura*47, pLargura*13, pAltura*7);
		jbCadastrar.setBounds(pLargura*70-pLargura*13/2+5, pAltura*80, pLargura*13, pAltura*7);
		jbSair.setBounds(pLargura*95, pAltura*3-10, 20, 20);

		jl_Titulo.setSize(jl_Titulo.getPreferredSize());
		jl_SubTitulo.setSize(250, 20);
		jl_CriarConta.setSize(300, 52);
		jl_Logo.setSize(jl_Logo.getPreferredSize());
		jl_Cpf.setSize(100, 15);
		jl_Email.setSize(jl_Email.getPreferredSize());
		jl_Nome.setSize(jl_Nome.getPreferredSize());
		jl_Telefone.setSize(100, 15);
		jrb_m.setSize(jrb_m.getPreferredSize());
		jrb_f.setSize(jrb_m.getPreferredSize());
		jrb_o.setSize(jrb_m.getPreferredSize());
		jl_Genero.setSize(115,15);

		jtf_Nome.setBounds(pLargura*70-pLargura*23,pAltura*32, pLargura*23, 41);
		jtf_Telefone.setBounds(pLargura*70+5,pAltura*32, pLargura*23, 41);
		jtf_Cpf.setBounds(pLargura*70-pLargura*23,pAltura*49, pLargura*23, 41);
		jtf_Email.setBounds(pLargura*70-pLargura*23,pAltura*62, pLargura*23, 41);

		// SETAR POSICAO
		jl_Titulo.setLocation(pLargura*19-jl_Titulo.getWidth()/2+7, pAltura*30);
		jl_SubTitulo.setLocation(pLargura*19-jl_SubTitulo.getWidth()/2+7, pAltura*37);
		jl_CriarConta.setLocation(pLargura*70-jl_CriarConta.getWidth()/2, pAltura*8);
		jl_Logo.setLocation(pLargura*19-jl_Logo.getWidth()/2+5,pAltura*65);
		jl_Genero.setLocation(pLargura*78+4, pAltura*45);

		jl_Cpf.setLocation(pLargura*70-pLargura*23, pAltura*45);
		jl_Email.setLocation(pLargura*70-pLargura*23, pAltura*58);
		jl_Nome.setLocation(pLargura*70-pLargura*23, pAltura*28);
		jl_Telefone.setLocation(pLargura*70+5,pAltura*28);

		jrb_m.setLocation(pLargura*78+10,pAltura*49);
		jrb_f.setLocation(pLargura*78+10,pAltura*54);
		jrb_o.setLocation(pLargura*78+10,pAltura*59);

		// ADICIONAR COMPONENTES
		add(jl_Nome);
		add(jl_Genero);
		add(jl_Email);
		add(jl_Cpf);
		add(jl_Telefone);
		add(jl_Titulo);
		add(jl_SubTitulo);
		add(jl_Logo);
		add(jl_CriarConta);
		add(jtf_Nome);
		add(jtf_Email);
		add(jtf_Cpf);
		add(jtf_Telefone);
		add(jbCadastrar);
		add(jbMostrar);
		add(jbPesquisar);
		add(jbSair);
		add(jrb_f);
		add(jrb_m);
		add(jrb_o);
		add(jl_Fundo);
	}

	private void criarEventos() {
		// EVENTO DO BOTÃO CADASTRAR
		jbCadastrar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (!jtf_Nome.getText().isEmpty() && !jtf_Email.getText().isEmpty() && !jtf_Cpf.getText().isEmpty() && !jtf_Telefone.getText().isEmpty())
				{
					// ENTRADAS
					nome = jtf_Nome.getText();
					email = jtf_Email.getText();
					cpf = jtf_Cpf.getText();
					telefone = jtf_Telefone.getText();

					// REDEFININDO COR
					jtf_Telefone.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(corDestaque, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
					jtf_Cpf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(corDestaque, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
					jtf_Email.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(corDestaque, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));

					if (cpf.matches(".*[a-zA-Z].*")) // VALIDAÇÃO CPF
					{ 
						JOptionPane.showMessageDialog(null, "O cpf nao pode conter letras!","Erro!",JOptionPane.ERROR_MESSAGE);
						jtf_Cpf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
						return;
					}
					if (cpf.length() != 11) // VALIDAÇÃO CPF 
					{
						JOptionPane.showMessageDialog(null, "O cpf tem que ter 11 digitos!","Erro!",JOptionPane.ERROR_MESSAGE);
						jtf_Cpf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
						return;
					}
					if(!email.contains("@") || !email.contains(".")) // VALIDAÇÃO EMAIL
					{
						JOptionPane.showMessageDialog(null, "Formato de email invalido!","Erro!",JOptionPane.ERROR_MESSAGE);
						jtf_Email.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
						return;
					}
					if(email.length() < 10)  // VALIDAÇÃO EMAIL
					{
						JOptionPane.showMessageDialog(null, "Formato de email invalido!","Erro!",JOptionPane.ERROR_MESSAGE);
						jtf_Email.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
						return;
					}
					if(telefone.matches(".*[a-zA-Z].*"))  // VALIDAÇÃO TELEFONE
					{
						JOptionPane.showMessageDialog(null, "O telefone nao pode conter letras!","Erro!",JOptionPane.ERROR_MESSAGE);
						jtf_Telefone.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
						return;
					}
					if(telefone.length() < 9 || telefone.length() > 13)  // VALIDAÇÃO TELEFONE
					{
						JOptionPane.showMessageDialog(null, "Formato de telefone invalido!","Erro!",JOptionPane.ERROR_MESSAGE);
						jtf_Telefone.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red, 1),BorderFactory.createEmptyBorder(0, 5, 0, 0)));
						return;
					}					
					if (jrb_m.isSelected()) genero = "Masculino";
					if (jrb_f.isSelected()) genero = "Feminino";
					if (jrb_o.isSelected()) genero = "Outros";

					// APAGAR CAMPOS
					jtf_Cpf.setText("");
					jtf_Email.setText("");
					jtf_Telefone.setText("");
					jtf_Nome.setText("");

					clientes[contador] = new Cliente(nome, email, cpf, telefone, genero); // OBJETO

					contador++; // INCREMENTO
					return;
				}
				// VALIDAÇÃO
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "DAIVU", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/com/daivu/imagens/logoJOP.png")));
				
			}
		});

		jbMostrar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// VERIFICAR SE O CLIENTE ESTÁ CADASTRADO
				if (clientes[0]!=null) 
				{
					JOptionPane.showMessageDialog(null, clientes[contador-1].mostrarDados(), "DAIVU", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/com/daivu/imagens/logoJOP.png")));
					return;
				}
				JOptionPane.showMessageDialog(null,"Não há cliente cadastrado!", "DAIVU", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/com/daivu/imagens/logoJOP.png")));
			}
		});


		jbPesquisar.addActionListener(new ActionListener() //EVENTO BOTAO PESQUISAR
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if (clientes[0]!=null) 
						{
							boolean achado = false;
							String nomePesquisa = JOptionPane.showInputDialog(null,"Entre com o nome do cliente a ser pesquisado!");
							for (int i = 0; i < contador; i++)
							{
								if (clientes[i] != null && clientes[i].getNome().equalsIgnoreCase(nomePesquisa))
								{
									JOptionPane.showMessageDialog(null, clientes[i].mostrarDados(), "DAIVU", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("/com/daivu/imagens/logoJOP.png")));
									achado = true;
								}
							}
							if(achado == false) 
							{
								JOptionPane.showMessageDialog(null,"Cliente não cadastrado", "DAIVU", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/com/daivu/imagens/logoJOP.png")));
							}
							return;
						} 
						JOptionPane.showMessageDialog(null,"Não tem cliente cadastrado!", "DAIVU", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/com/daivu/imagens/logoJOP.png")));
					}
				});

		jbSair.addActionListener(new ActionListener() //EVENTO BOTAO SAIR
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
}