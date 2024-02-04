package br.com.alelvis.sistemAlevis.vew;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.springframework.stereotype.Component;

@Component
public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JMenu mnRelatrio;
	public static JMenuItem mntmUsurios;
	public static JLabel lblUsuario;

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Criando Janela
	 */
	public TelaPrincipal() {
		setTitle("X - Sistema para controle de OS..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		mnCadastro.add(mntmCliente);

		JMenuItem mntmOs = new JMenuItem("Os");
		mntmOs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
		mnCadastro.add(mntmOs);

		mntmUsurios = new JMenuItem("Usuários");
		mntmUsurios.setEnabled(false);
		mntmUsurios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));
		mnCadastro.add(mntmUsurios);

		mnRelatrio = new JMenu("Relatório");
		mnRelatrio.setEnabled(false);
		menuBar.add(mnRelatrio);

		JMenuItem mntmServios = new JMenuItem("Serviços");
		mntmServios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		mnRelatrio.add(mntmServios);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_DOWN_MASK));
		mnAjuda.add(mntmSobre);

		JMenu mnOpes = new JMenu("Opções");
		menuBar.add(mnOpes);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		mnOpes.add(mntmSair);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Desktop",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		desktopPane.setBackground(Color.WHITE);

		lblUsuario = new JLabel("Usuário");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 18));

		JLabel lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Trebuchet MS", Font.BOLD, 18));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 107,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addGap(6)
						.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblData).addGap(395)));
		contentPane.setLayout(gl_contentPane);

		// ação abriri tela cliente dentro do descktoppane
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCliente cliente = new TelaCliente();
				cliente.setVisible(true);
				desktopPane.add(cliente);
			}
		});

		// ação abriri tela usuario dentro do descktoppane
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario usuario = new TelaUsuario();
				usuario.setVisible(true);
				desktopPane.add(usuario);
			}
		});

		// ação mostrar data atual
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
		lblData.setText(formatador.format(data));

		// ação menu Sobre
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});

		// ação do menu sair
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção",
						JOptionPane.YES_NO_OPTION);
				if (sair == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

	}
}
