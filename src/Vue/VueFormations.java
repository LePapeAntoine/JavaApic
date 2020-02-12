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

import Controleur.Formation;
import Controleur.Tableau;
import modele.Modele;

public class VueFormations extends JPanel implements ActionListener{

	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtNUMEROC = new JTextField();
	private JTextField txtNUMEROFORMATION = new JTextField();
	private JTextField txtDATE = new JTextField();
	private JTextField txtTYPE = new JTextField();
	private JTextField txtNOMBREPERSONNE = new JTextField();
	
	private JPanel unPanel = new JPanel();
	
	//declaration d'une JTable
	private JTable tabFormation;
	private Tableau unTableau; //objet modele de la classe tableau
	
	
	
	
	public VueFormations() {
		
			
		this.setLayout(null);
		this.setBounds(50, 50, 600, 350);
		this.setBackground(Color.blue);
		
		this.unPanel.setLayout(new GridLayout(2, 2));
		this.unPanel.setBounds(20, 200, 550, 100);
		this.unPanel.add(new JLabel("Id Formation : "));
		this.unPanel.add(this.txtNUMEROFORMATION);
		
		this.txtNUMEROFORMATION.setEditable(false);
		
		
		this.unPanel.add(new JLabel("ID Client : "));
		this.unPanel.add(this.txtNUMEROC);
		
		this.unPanel.add(new JLabel("Type Formation : "));
		this.unPanel.add(this.txtTYPE);
		

		this.unPanel.add(new JLabel("Date : "));
		this.unPanel.add(this.txtDATE);
		
		this.unPanel.add(new JLabel("Nombre Personne : "));
		this.unPanel.add(this.txtNOMBREPERSONNE);
		
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
		String  entete[] ={"Id Formation", "Id Client", "Id TypeFormation", "NombrePersonne","Date"};
		
		Object donnees[][] = this.remplirDonnees();
		
		//instanciation de la classe tableau
		this.unTableau = new Tableau(donnees, entete);
		//instanciation de la jtable avec l'objet modele de table
		this.tabFormation = new JTable(this.unTableau);
		
		JScrollPane uneScroll=new JScrollPane(tabFormation);
		uneScroll.setBounds(20, 10, 550, 150);
		this.add(uneScroll);
		
		
		//ajout event click
		this.tabFormation.addMouseListener(new MouseListener() {
			
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
				int ligne = tabFormation.getSelectedRow();
				txtNUMEROFORMATION.setText(tabFormation.getValueAt(ligne, 0).toString());
				txtNUMEROC.setText(tabFormation.getValueAt(ligne, 1).toString());
				txtTYPE.setText(tabFormation.getValueAt(ligne, 2).toString());
				txtDATE.setText(tabFormation.getValueAt(ligne, 4).toString());
				txtNOMBREPERSONNE.setText(tabFormation.getValueAt(ligne, 3).toString());
			}
		});
		
		this.setVisible(false);
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.btAjouter) {
			
			int NUMEROC=Integer.parseInt(this.txtNUMEROC.getText());
			int TYPE=Integer.parseInt(this.txtTYPE.getText());
			int NOMBREPERSONNE=Integer.parseInt(this.txtNOMBREPERSONNE.getText());
			String DATE=this.txtDATE.getText();
			
			
			
			if(NUMEROC==0 || TYPE==0) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir les donnees");
			}
			//instanciation de la classe clients
			
			Formation uneFormation = new Formation(TYPE, NUMEROC,NOMBREPERSONNE, DATE);
			
			//appel du Modele pour inserer un client dans la bdd
			
			Modele.insertFormation(uneFormation);
			JOptionPane.showMessageDialog(this, "Insertion reussie !");
			uneFormation = Modele.selectWhereFormation(uneFormation);
			Object uneLigne[] = {uneFormation.getNUMEROFORMATION(), uneFormation.getNUMTYPE(), uneFormation.getNUMEROC(), uneFormation.getNOMBREPERSONNE(), uneFormation.getDATEF()};
			this.unTableau.add(uneLigne);
			this.txtNUMEROC.setText("");
			this.txtTYPE.setText("");

			
			
		}else if (e.getSource()== this.btSupprimer) {
			
			
			int NUMEROFORMATION = Integer.parseInt(this.txtNUMEROFORMATION.getText());
			int NUMEROC=Integer.parseInt(this.txtNUMEROC.getText());
			int NUMTYPE=Integer.parseInt(this.txtTYPE.getText());
			int NOMBREPERSONNE=Integer.parseInt(this.txtNOMBREPERSONNE.getText());
			String DATEF=this.txtDATE.getText();
			
			
			Formation uneFormation = new Formation (NUMEROFORMATION,NUMTYPE,NUMEROC,NOMBREPERSONNE,DATEF);
			
			Modele.deleteFormation(uneFormation);
			JOptionPane.showMessageDialog(this, "Suppression reussie !");
			
			
			
		}else if (e.getSource()==this.btEditer) {
			

			int NUMEROFORMATION = Integer.parseInt(this.txtNUMEROFORMATION.getText());
			int NUMEROC=Integer.parseInt(this.txtNUMEROC.getText());
			int NUMTYPE=Integer.parseInt(this.txtTYPE.getText());
			int NOMBREPERSONNE=Integer.parseInt(this.txtNOMBREPERSONNE.getText());
			String DATEF=this.txtDATE.getText();
			
			
			Formation uneFormation = new Formation (NUMEROFORMATION,NUMTYPE,NUMEROC,NOMBREPERSONNE,DATEF);
						
			Modele.updateFormation(uneFormation);
			JOptionPane.showMessageDialog(this, "Edition reussie !");
			
		}else if(e.getSource()==this.btAnnuler) {
			
			this.txtNUMEROC.setText("");
			this.txtTYPE.setText("");
			this.txtNUMEROFORMATION.setText("");

		}
		
		
	}
	
	public Object[][] remplirDonnees(){
		
		ArrayList<Formation> lesFormations = Modele.selectAllFormation();
		Object donnees [][] = new Object[lesFormations.size()][5];
		int i = 0;
		for(Formation uneFormation : lesFormations) {
			donnees[i][0] = uneFormation.getNUMEROFORMATION();
			donnees[i][1] = uneFormation.getNUMEROC();
			donnees[i][2] = uneFormation.getNUMTYPE();
			donnees[i][3] = uneFormation.getNOMBREPERSONNE();
			donnees[i][4] = uneFormation.getDATEF();
			i++;

			
		}return donnees;
		
	}

}
