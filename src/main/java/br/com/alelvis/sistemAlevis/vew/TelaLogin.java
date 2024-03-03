package br.com.alelvis.sistemAlevis.vew;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alelvis.sistemAlevis.Service.UsuarioService;
import br.com.alelvis.sistemAlevis.dto.LoginDTO;
import br.com.alelvis.sistemAlevis.dto.UsuarioDTO;

@Component
public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioService usuarioService;

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnLogin;
	private JLabel lblStatus;

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setTitle("X System - Login ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 215, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(12, 12, 70, 15);
		lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 39, 70, 15);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSenha);

		lblStatus = new JLabel("");
		lblStatus
				.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/alelvis/sistemAlevis/vew/icons/dbok.png")));
		lblStatus.setBounds(12, 66, 59, 45);
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(82, 10, 114, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(82, 37, 114, 19);
		contentPane.add(txtSenha);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(79, 81, 117, 25);
		contentPane.add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
	}

	protected void logar() {
		String login = txtUsuario.getText();
		String senha = new String(txtSenha.getPassword());

		LoginDTO loginDTO = new LoginDTO(login, senha);
		UsuarioDTO usuario = usuarioService.logar(loginDTO);

		if (usuario != null) {
			// Lógica para abrir a TelaPrincipal
			TelaPrincipal principal = new TelaPrincipal();
			principal.setVisible(true);

			// Lógica para configurar a TelaPrincipal com base no perfil
			switch (usuario.perfil()) {
			case ADMINISTRADOR:
				TelaPrincipal.mnRelatrio.setEnabled(true);
				TelaPrincipal.mntmUsurios.setEnabled(true);
				TelaPrincipal.lblUsuario.setForeground(Color.red);
				break;
			// Adicione mais casos conforme necessário
			default:
				break;
			}

			TelaPrincipal.lblUsuario.setText("<html>" + usuario.nome() + "</html>");

			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
		}

	}

}
