package br.edu.unifei.ecot13.worlds.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.worlds.Player;
import br.edu.unifei.ecot13.worlds.enumeration.RoleEnum;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerFormAlterar extends JFrame {
	private JTextField textName;
	private JTextField textNickname;
	private JTextField textKda;
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("lolPU");
	private EntityManager em = emf.createEntityManager();
	private Player player = new Player();
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerFormAlterar frame = new PlayerFormAlterar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayerFormAlterar() {
		setTitle("Alterar Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 356);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 434, 317);
		getContentPane().add(contentPane);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 58, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(26, 101, 86, 14);
		contentPane.add(lblNickname);
		
		JLabel lblKDA = new JLabel("KDA");
		lblKDA.setBounds(26, 139, 46, 14);
		contentPane.add(lblKDA);
		
		JLabel lblTotalGames = new JLabel("TotalGames");
		lblTotalGames.setBounds(26, 171, 86, 14);
		contentPane.add(lblTotalGames);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(26, 210, 46, 14);
		contentPane.add(lblRole);
		
		textName = new JTextField();
		textName.setEnabled(false);
		textName.setColumns(10);
		textName.setBounds(141, 55, 191, 20);
		contentPane.add(textName);
		
		textNickname = new JTextField();
		textNickname.setEnabled(false);
		textNickname.setText("");
		textNickname.setColumns(10);
		textNickname.setBounds(141, 98, 191, 20);
		contentPane.add(textNickname);
		
		JSpinner spinnerTotalGames = new JSpinner();
		spinnerTotalGames.setEnabled(false);
		spinnerTotalGames.setBounds(141, 168, 86, 20);
		contentPane.add(spinnerTotalGames);
		
		JComboBox comboBoxRole = new JComboBox(RoleEnum.values());
		comboBoxRole.setEnabled(false);
		comboBoxRole.setMaximumRowCount(5);
		comboBoxRole.setBounds(141, 206, 86, 22);
		contentPane.add(comboBoxRole);
		
		textKda = new JTextField();
		textKda.setEnabled(false);
		textKda.setText("0.0");
		textKda.setColumns(10);
		textKda.setBounds(141, 136, 86, 20);
		contentPane.add(textKda);
		
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(26, 22, 46, 14);
		contentPane.add(lblId);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(243, 18, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(163, 283, 89, 23);
		contentPane.add(btnSalvar);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				player = em.find(Player.class, Long.parseLong(textId.getText()));
				if(player != null) {
					textId.setEnabled(false);
					textName.setEnabled(true);
					textName.setText(player.getName());
					textNickname.setEnabled(true);
					textNickname.setText(player.getNickname());
					textKda.setEnabled(true);
					textKda.setText("" + player.getKda());
					spinnerTotalGames.setEnabled(true);
					spinnerTotalGames.setValue(player.getTotalGames());
					comboBoxRole.setEnabled(true);
					comboBoxRole.setSelectedIndex(player.getRole().ordinal());
					btnBuscar.setEnabled(false);
					btnSalvar.setEnabled(true);
				}
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.setName(textName.getText());
				textName.setEnabled(false);
				player.setNickname(textNickname.getText());
				textNickname.setEnabled(false);
				player.setKda(Double.parseDouble(textKda.getText()));
				textKda.setEnabled(false);
				player.setTotalGames((int) spinnerTotalGames.getValue());
				spinnerTotalGames.setEnabled(false);
				player.setRole(RoleEnum.valueOf(comboBoxRole.getSelectedItem().toString()));
				comboBoxRole.setEnabled(false);
				textId.setEnabled(true);
				btnBuscar.setEnabled(true);
				btnSalvar.setEnabled(false);
				
				em.getTransaction().begin();
				em.merge(player);
				em.getTransaction().commit();
				
				JOptionPane.showMessageDialog(null, "Player Atualizado!", "Message", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		textId = new JTextField();
		textId.setBounds(141, 19, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
	}
}
