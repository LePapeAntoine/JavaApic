package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controleur.Main;

public class VueGenerale extends JFrame implements ActionListener {

	
	private JPanel panelMenu = new JPanel();
	private JButton tabButton [] = new JButton[5];
	private String tab[] = {"Clients","Entreprise","Particulier","Formation","Quitter"};
	
	//instanciation des panneaux
	private VueClients uneVueClients = new VueClients();
	private VueFormations uneVueFormations = new VueFormations();
	private VueEntreprise uneVueEntreprise = new VueEntreprise();
	private VueParticulier uneVueParticulier = new VueParticulier();
	
	
	
	/*********** LE CONSTRUCTEUR ********/
	
	public VueGenerale()
	{
		this.setTitle("Logiciel de gestion Apic");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(200, 200, 700, 400);
		this.getContentPane().setBackground(Color.gray);
		
		//construction panel menu
		this.panelMenu.setBounds(0, 20, 700, 30);
		this.panelMenu.setLayout(new GridLayout(1, 4));
		
		//construction des boutons
		for (int i = 0; i < this.tabButton.length; i++) {
			this.tabButton[i] = new JButton(this.tab[i]);
			this.panelMenu.add(this.tabButton[i]);
			this.tabButton[i].addActionListener(this);
			
		}
		
		this.panelMenu.setVisible(true);
		
		this.add(this.panelMenu);
		this.add(this.uneVueClients);
		this.add(this.uneVueFormations);
		this.add(this.uneVueEntreprise);
		this.add(this.uneVueParticulier);
		
		
		
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "Clients":
			this.uneVueClients.setVisible(true);
			this.uneVueFormations.setVisible(false);
			this.uneVueEntreprise.setVisible(false);
			this.uneVueParticulier.setVisible(false);
			break;
		case "Entreprise":
			this.uneVueEntreprise.setVisible(true);
			this.uneVueClients.setVisible(false);
			this.uneVueFormations.setVisible(false);
			this.uneVueParticulier.setVisible(false);
			break;
		case "Formation":
			this.uneVueClients.setVisible(false);
			this.uneVueFormations.setVisible(true);
			this.uneVueEntreprise.setVisible(false);
			this.uneVueParticulier.setVisible(false);
			break;
		case "Particulier":
			this.uneVueClients.setVisible(false);
			this.uneVueFormations.setVisible(false);
			this.uneVueEntreprise.setVisible(false);
			this.uneVueParticulier.setVisible(true);
			break;
		case "Quitter":
			this.dispose();
			Main.rendreVisible(true);
			break;
		
		}
		
		
	}

}
