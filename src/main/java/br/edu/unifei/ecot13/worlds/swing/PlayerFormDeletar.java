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

public class PlayerFormDeletar extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textNickname;
	private JTextField textKda;
	private JTextField textId;
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("lolPU");
	private EntityManager em = emf.createEntityManager();
	private Player player = new Player();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerFormDeletar frame = new PlayerFormDeletar();
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
	public PlayerFormDeletar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(52, 69, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(52, 112, 86, 14);
		contentPane.add(lblNickname);
		
		JLabel lblKDA = new JLabel("KDA");
		lblKDA.setBounds(52, 150, 46, 14);
		contentPane.add(lblKDA);
		
		JLabel lblTotalGames = new JLabel("TotalGames");
		lblTotalGames.setBounds(52, 182, 86, 14);
		contentPane.add(lblTotalGames);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(52, 221, 46, 14);
		contentPane.add(lblRole);
		
		textName = new JTextField();
		textName.setEnabled(false);
		textName.setColumns(10);
		textName.setBounds(167, 66, 191, 20);
		contentPane.add(textName);
		
		textNickname = new JTextField();
		textNickname.setText("");
		textNickname.setEnabled(false);
		textNickname.setColumns(10);
		textNickname.setBounds(167, 109, 191, 20);
		contentPane.add(textNickname);
		
		JSpinner spinnerTotalGames = new JSpinner();
		spinnerTotalGames.setEnabled(false);
		spinnerTotalGames.setBounds(167, 179, 86, 20);
		contentPane.add(spinnerTotalGames);
		
		JComboBox comboBoxRole = new JComboBox(RoleEnum.values());
		comboBoxRole.setMaximumRowCount(5);
		comboBoxRole.setEnabled(false);
		comboBoxRole.setBounds(167, 217, 86, 22);
		contentPane.add(comboBoxRole);
		
		textKda = new JTextField();
		textKda.setText("0.0");
		textKda.setEnabled(false);
		textKda.setColumns(10);
		textKda.setBounds(167, 147, 86, 20);
		contentPane.add(textKda);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(52, 33, 46, 14);
		contentPane.add(lblId);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.setBounds(269, 29, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setEnabled(false);
		btnDeletar.setBounds(189, 294, 89, 23);
		contentPane.add(btnDeletar);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(167, 30, 86, 20);
		contentPane.add(textId);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player = em.find(Player.class, Long.parseLong(textId.getText()));
				if(player != null) {
					btnBuscar.setEnabled(false);
					btnDeletar.setEnabled(true);
					textId.setEnabled(false);
					textName.setText(player.getName());
					textNickname.setText(player.getNickname());
					textKda.setText("" + player.getKda());
					spinnerTotalGames.setValue(player.getTotalGames());
					comboBoxRole.setSelectedIndex(player.getRole().ordinal());
					
				}
			}
		});
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscar.setEnabled(true);
				btnDeletar.setEnabled(false);
				textId.setEnabled(true);
				textId.setText("");
				textName.setText("");
				textNickname.setText("");
				textKda.setText("0.0");
				spinnerTotalGames.setValue(0);
				comboBoxRole.setSelectedIndex(0);
				
				em.getTransaction().begin();
				em.remove(player);
				em.getTransaction().commit();
				
				JOptionPane.showMessageDialog(null, "Player removido!", "Message", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

}
