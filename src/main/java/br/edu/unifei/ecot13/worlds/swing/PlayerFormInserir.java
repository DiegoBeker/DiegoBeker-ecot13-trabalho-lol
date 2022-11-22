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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PlayerFormInserir extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textNickname;
	private JTextField textKda;
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("lolPU");
	private EntityManager em = emf.createEntityManager();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerFormInserir frame = new PlayerFormInserir();
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
	public PlayerFormInserir() {
		
		setTitle("Salvar Player");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 30, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(26, 66, 86, 14);
		contentPane.add(lblNickname);
		
		JLabel lblKDA = new JLabel("KDA");
		lblKDA.setBounds(26, 106, 46, 14);
		contentPane.add(lblKDA);
		
		JLabel lblTotalGames = new JLabel("TotalGames");
		lblTotalGames.setBounds(26, 146, 86, 14);
		contentPane.add(lblTotalGames);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(26, 191, 46, 14);
		contentPane.add(lblRole);
		
		textName = new JTextField();
		textName.setBounds(141, 27, 191, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textNickname = new JTextField();
		textNickname.setText("");
		textNickname.setBounds(141, 63, 191, 20);
		contentPane.add(textNickname);
		textNickname.setColumns(10);
		
		JSpinner spinnerTotalGames = new JSpinner();
		spinnerTotalGames.setBounds(141, 143, 86, 20);
		contentPane.add(spinnerTotalGames);
		
		JComboBox comboBoxRole = new JComboBox(RoleEnum.values());
		comboBoxRole.setMaximumRowCount(5);
		comboBoxRole.setBounds(141, 187, 86, 22);
		contentPane.add(comboBoxRole);
		
		textKda = new JTextField();
		textKda.setBounds(141, 103, 86, 20);
		contentPane.add(textKda);
		textKda.setColumns(10);
		textKda.setText("0.0");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = new Player();
				
				player.setName(textName.getText());
				player.setNickname(textNickname.getText());
				player.setKda(Double.parseDouble(textKda.getText()));
				player.setTotalGames((int) spinnerTotalGames.getValue());
				player.setRole(RoleEnum.valueOf(comboBoxRole.getSelectedItem().toString()));
				
				em.getTransaction().begin();
				em.persist(player);
				em.getTransaction().commit();
				
				JOptionPane.showMessageDialog(null, "Player salvo!", "Message", JOptionPane.PLAIN_MESSAGE);
			
				textName.setText("");
				textNickname.setText("");
				textKda.setText("0.0");
				spinnerTotalGames.setValue(0);
				comboBoxRole.setSelectedIndex(0);
				
			}
		});
		btnSalvar.setBounds(163, 227, 89, 23);
		contentPane.add(btnSalvar);
	}
}
