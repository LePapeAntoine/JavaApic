package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Particulier;
import Controleur.Tableau;
import modele.Modele;

public class VueParticulier extends JPanel implements ActionListener {
	
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtNumeroC = new JTextField();
	private JTextField txtMailC = new JTextField();
	private JTextField txtAdresseC = new JTextField();
	private JTextField txtTelC = new JTextField();
	private JTextField txtMdpC = new JTextField();
	private JTextField txtNOMPARTICULIER = new JTextField();
	private JTextField txtPRENOMPARTICULIER = new JTextField();
	
	private JPanel unPanel = new JPanel();
	
	//declaration d'une JTable
	private JTable tabParticulier;
	private Tableau unTableau; //objet modele de la classe tableau
	
	
	
	
	public VueParticulier() {
		
			
		this.setLayout(null);
		this.setBounds(50, 50, 600, 350);
		this.setBackground(Color.red);
		
		this.unPanel.setLayout(new GridLayout(2, 2));
		this.unPanel.setBounds(20, 200, 550, 100);
		this.unPanel.add(new JLabel("Id Client : "));
		this.unPanel.add(this.txtNumeroC);
		
		this.txtNumeroC.setEditable(false);
		
		
		this.unPanel.add(new JLabel("Mail Client : "));
		this.unPanel.add(this.txtMailC);
		
		this.unPanel.add(new JLabel("Adresse Client : "));
		this.unPanel.add(this.txtAdresseC);
		

		this.unPanel.add(new JLabel("Tel Client : "));
		this.unPanel.add(this.txtTelC);
		
		this.unPanel.add(new JLabel("Mdp Client : "));
		this.unPanel.add(this.txtMdpC);
		
		this.unPanel.add(new JLabel("Nom : "));
		this.unPanel.add(this.txtNOMPARTICULIER);
		
		this.unPanel.add(new JLabel("Prenom : "));
		this.unPanel.add(this.txtPRENOMPARTICULIER);
		
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btAjouter);
		this.unPanel.add(this.btSupprimer);
		this.unPanel.add(this.btEditer);
		this.unPanel.add(this.btAjouter);
		this.unPanel.setVisible(true);
		this.add(unPanel);


		//rendre boutons cliquable
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		this.btAnnuler.addActionListener(this);


		//insertion de la table dans la fenetre
		String  entete[] ={"Id Client", "Mail Client","Nom  : ", "Prenom : "};
		
		Object donnees[][] = this.remplirDonnees();
		
		//instanciation de la classe tableau
		this.unTableau = new Tableau(donnees, entete);
		//instanciation de la jtable avec l'objet modele de table
		this.tabParticulier = new JTable(this.unTableau);
		
		JScrollPane uneScroll=new JScrollPane(tabParticulier);
		uneScroll.setBounds(20, 10, 550, 150);
		this.add(uneScroll);
		
		
		//ajout event click
		this.tabParticulier.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne = tabParticulier.getSelectedRow();
				txtNumeroC.setText(tabParticulier.getValueAt(ligne, 0).toString());
				txtMailC.setText(tabParticulier.getValueAt(ligne, 1).toString());
				txtAdresseC.setText(tabParticulier.getValueAt(ligne, 2).toString());
				txtNOMPARTICULIER.setText(tabParticulier.getValueAt(ligne, 3).toString());
			}
		});
		
		this.setVisible(false);
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.btAjouter) {
			
			String mailc=this.txtMailC.getText();
			String adressec=this.txtAdresseC.getText();
			int telc=Integer.parseInt(this.txtTelC.getText());
			String MdpC=this.txtMdpC.getText();
			String Nom =this.txtNOMPARTICULIER.getText();
			String Prenom =this.txtPRENOMPARTICULIER.getText();
			
			if(mailc.equals("") || adressec.equals("")) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir les donnees");
			}
			//instanciation de la classe clients
			
			Particulier unParticulier = new Particulier(adressec, telc,mailc, MdpC,Nom,Prenom);
			
			//appel du Modele pour inserer un client dans la bdd
			
			Modele.insertParticulier(unParticulier);
			JOptionPane.showMessageDialog(this, "Insertion reussie !");
			unParticulier = Modele.selectWhereParticulier(unParticulier);
			Object uneLigne[] = {unParticulier.getNumeroC(), unParticulier.getMailC(), unParticulier.getAdresseC(), unParticulier.getTelC(), unParticulier.getMdpC(), unParticulier.getNOMPARTICULIER(), unParticulier.getPRENOMPARTICULIER()};
			this.unTableau.add(uneLigne);
			this.txtMailC.setText("");
			this.txtAdresseC.setText("");

			
			
		}else if (e.getSource()== this.btSupprimer) {
			
			
			int NUMEROC = Integer.parseInt(this.txtNumeroC.getText());
			String ADRESSEC=this.txtAdresseC.getText();
			String MAILC=this.txtMailC.getText();
			int TELC=Integer.parseInt(this.txtNumeroC.getText());
			String MDPC=this.txtMdpC.getText();
			String Nom=this.txtNOMPARTICULIER.getText();
			String Prenom=this.txtPRENOMPARTICULIER.getText();
			
			Particulier unParticulier = new Particulier (NUMEROC,ADRESSEC,MAILC,TELC,MDPC,Nom,Prenom);
			
			Modele.deleteParticulier(unParticulier);
			JOptionPane.showMessageDialog(this, "Suppression reussie !");
			
			
			
		}else if (e.getSource()==this.btEditer) {
			

			int NUMEROC = Integer.parseInt(this.txtNumeroC.getText());
			String ADRESSEC=this.txtAdresseC.getText();
			String MAILC=this.txtMailC.getText();
			int TELC=Integer.parseInt(this.txtTelC.getText());
			String MDPC=this.txtMdpC.getText();
			String Prenom=this.txtNOMPARTICULIER.getText();
			String Nom=this.txtPRENOMPARTICULIER.getText();
			
			Particulier unParticulier = new Particulier (NUMEROC,ADRESSEC,MAILC,TELC,MDPC,Nom, Prenom);
						
			Modele.updateParticulier(unParticulier);
			JOptionPane.showMessageDialog(this, "Edition reussie !");
			
		}else if(e.getSource()==this.btAnnuler) {
			
			this.txtAdresseC.setText("");
			this.txtMailC.setText("");
			this.txtNumeroC.setText("");

		}
		
		
	}
	
	public Object[][] remplirDonnees(){
		
		ArrayList<Particulier> lesParticulier = Modele.selectAllParticulier();
		Object donnees [][] = new Object[lesParticulier.size()][4];
		int i = 0;
		for(Particulier unParticulier : lesParticulier) {
			donnees[i][0] = unParticulier.getNumeroC() +"";
			donnees[i][1] = unParticulier.getMailC();
			donnees[i][2] = unParticulier.getNOMPARTICULIER();
			donnees[i][3] = unParticulier.getPRENOMPARTICULIER();
			i++;

			
		}return donnees;
		
	}

}

