package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controleur.Client;
import Controleur.Formation;
import Controleur.Entreprise;
import Controleur.Particulier;

public class Modele 
{
	public static String verifConnexion(String login, String mdp)
	{
		String droits ="";
		String requete ="select count(*) as nb, droits from USER where login='"+login +"' and mdp = '"+mdp +"';";
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int nb = unRes.getInt("nb");
				if (nb>0){
					droits = unRes.getString("droits");
				}
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
		System.out.println("Erreur :"+ requete);
		}
		catch (NullPointerException exp)
		{
			System.out.println("Erreur Connexion BDD non fonctionnelle");
		}
		return droits;
	}
	
	/******************** Model Client ********************/
	
	public static ArrayList<Client> selectAllClients(){
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete="select * from CLIENT";
	
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				int NUMEROC = unRes.getInt("NUMEROC");
				String ADRESSEC = unRes.getString("ADRESSEC");
				String MAILC = unRes.getString("MAILC");
				int TELC = unRes.getInt("TELC");
				String MDPC = unRes.getString("MDPC");
				Client unClient = new Client(NUMEROC,ADRESSEC,MAILC,TELC,MDPC);
				lesClients.add(unClient);
									
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
			
		}catch (SQLException e) {
			
			System.out.println("Erreur fetch client");
		}
			return lesClients;
	}
	
	public static Client selectWhereClient (Client unClient) {
		
		Client leClient = null;
		
		String requete = "select NUMEROC from CLIENT where NUMEROC='"+unClient.getNumeroC()+
				"' AND ADRESSEC = '"+unClient.getAdresseC()+
				"' AND TELC = '"+unClient.getTelC()+"');";
		
		Bdd uneBdd = new Bdd("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int idClient = unRes.getInt("idclient");
				leClient = new Client (idClient, unClient.getAdresseC(), unClient.getMailC(), unClient.getTelC(), unClient.getMdpC());
				
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}catch (SQLException e) {
			System.out.println("Erreur : "+requete);
		}
		return leClient;
	}
	
	public static void insertClient (Client unClient) {
		String requete = "insert into CLIENT values (null, '"+unClient.getAdresseC()+
				"','"+unClient.getTelC()+
				"','"+unClient.getMailC()+
				"','"+unClient.getMdpC()+"');";
		execRequete(requete);

			
		
	}
	
	public static void updateClient (Client unClient) {

		String requete = "update into CLIENT set ADRESSEC='"+unClient.getAdresseC()+
				"', MAILC = '"+unClient.getMailC()+
				"', TELC = '"+unClient.getTelC()+
				"', MDPC = '"+unClient.getMdpC()+
				"', NUMEROC = '"+unClient.getNumeroC()+"');";
		execRequete(requete);

		
			
		
	}
	
	public static void deleteClient (Client unClient) {

		String requete = "delete from CLIENT where NUMEROC = "+unClient.getNumeroC()+" ;";
		
		execRequete(requete);
			
		
	}
	
	private static void execRequete (String requete) {
		
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
			
		}catch (SQLException e) {
			
			System.out.println("Erreur" +requete);
		}
	}
	/******************** Model Formation ********************/
	
	public static ArrayList<Formation> selectAllFormation(){
		ArrayList<Formation> lesFormations = new ArrayList<Formation>();
		String requete="select * from FORMATION";
	
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				int NUMEROFORMATION = unRes.getInt("NUMEROFORMATION");
				int NUMTYPE = unRes.getInt("NUMTYPE");
				int NUMEROC = unRes.getInt("NUMEROC");
				int NOMBREPERSONNE = unRes.getInt("NOMBREPERSONNEF");
				String DATEF = unRes.getString("DATEF");
				Formation uneFormation = new Formation(NUMEROFORMATION,NUMTYPE,NUMEROC,NOMBREPERSONNE,DATEF);
				lesFormations.add(uneFormation);
									
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
			
		}catch (SQLException e) {
			
			System.out.println("Erreur fetch formation");
		}
			return lesFormations;
	}

	public static Formation selectWhereFormation (Formation uneFormation) {
		
		Formation laFormation = null;
		
		String requete = "select NUMEROFORMATION from FORMATION where NUMEROFORMATION='"+uneFormation.getNUMEROFORMATION()+
				"' AND NUMTYPE = '"+uneFormation.getNUMTYPE()+
				"' AND NUMEROC = '"+uneFormation.getNUMEROC()+
				"' AND DATEF = '"+uneFormation.getDATEF()+
				"' AND NOMBREPERSONNEF = '"+uneFormation.getNOMBREPERSONNE()+"');";
		
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int NUMEROFORMATION = unRes.getInt("NUMEROFORMATION");
				laFormation = new Formation (NUMEROFORMATION, uneFormation.getNUMTYPE(), uneFormation.getNUMEROC(), uneFormation.getNOMBREPERSONNE(),uneFormation.getDATEF());
				
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}catch (SQLException e) {
			System.out.println("Erreur : "+requete);
		}
		return laFormation;
	}
	
	public static void insertFormation (Formation uneFormation) {
		String requete = "insert into FORMATION values (null, '"+uneFormation.getNUMTYPE()+
				"','"+uneFormation.getNUMEROC()+
				"','"+uneFormation.getNOMBREPERSONNE()+
				"','"+uneFormation.getDATEF()+"');";
		execRequete(requete);

			
		
	}
	
	public static void updateFormation (Formation uneFormation) {

		String requete = "update into FORMATION set NUMETYPE='"+uneFormation.getNUMTYPE()+
				"', NUMEROC = '"+uneFormation.getNUMEROC()+
				"', NOMBREPERSONNEF = '"+uneFormation.getNOMBREPERSONNE()+
				"', DATEF = '"+uneFormation.getDATEF()+
				"', NUMEFORMATION = '"+uneFormation.getNUMEROFORMATION()+"');";
		execRequete(requete);

		
			
		
	}
	
	public static void deleteFormation (Formation uneFormation) {

		String requete = "delete from FORMATION where NUMEROFORMATION = "+uneFormation.getNUMEROFORMATION()+" ;";
		
		execRequete(requete);
			
		
	}
	/******************** Model Entreprise ********************/
	
	public static ArrayList<Entreprise> selectAllEntreprise(){
		ArrayList<Entreprise> lesEntreprises = new ArrayList<Entreprise>();
		String requete="select * from ENTREPRISE";
	
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				int NUMEROC = unRes.getInt("NUMEROC");
				String ADRESSEC = unRes.getString("ADRESSEC");
				String MAILC = unRes.getString("MAILC");
				int TELC = unRes.getInt("TELC");
				String MDPC = unRes.getString("MDPC");
				String NOMENTREPRISE = unRes.getString("NOMENTREPRISE");
				String NOMRESPONSABLE = unRes.getString("NOMRESPONSABLE");
				Entreprise uneEntreprise = new Entreprise(NUMEROC,ADRESSEC,MAILC,TELC,MDPC,NOMENTREPRISE,NOMRESPONSABLE);
				lesEntreprises.add(uneEntreprise);
									
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
			
		}catch (SQLException e) {
			
			System.out.println("Erreur fetch client");
		}
			return lesEntreprises;
	}
	
	public static Entreprise selectWhereEntreprise (Entreprise uneEntreprise) {
		
		Entreprise lEntreprise = null;
		
		String requete = "select NUMEROC from ENTREPRISE where NUMEROC='"+uneEntreprise.getNumeroC()+
				"' AND ADRESSEC = '"+uneEntreprise.getAdresseC()+
				"' AND TELC = '"+uneEntreprise.getTelC()+"');";
		
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int idClient = unRes.getInt("NUMEROC");
				lEntreprise = new Entreprise (idClient, uneEntreprise.getAdresseC(), uneEntreprise.getMailC(), uneEntreprise.getTelC(), uneEntreprise.getMdpC(), uneEntreprise.getNOMENTREPRISE(), uneEntreprise.getNOMRESPONSABLE());
				
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}catch (SQLException e) {
			System.out.println("Erreur : "+requete);
		}
		return lEntreprise;
	}
	
	public static void insertEntreprise (Entreprise uneEntreprise) {
		String requete = "insert into ENTREPRISE values (null, '"+uneEntreprise.getAdresseC()+
				"','"+uneEntreprise.getNOMENTREPRISE()+
				"','"+uneEntreprise.getNOMRESPONSABLE()+
				"','"+uneEntreprise.getTelC()+
				"','"+uneEntreprise.getMailC()+
				"','"+uneEntreprise.getMdpC()+"');";
		execRequete(requete);

			
		
	}
	
	public static void updateEntreprise (Entreprise uneEntreprise) {

		String requete = "update into ENTREPRISE set ADRESSEC='"+uneEntreprise.getAdresseC()+
				"', MAILC = '"+uneEntreprise.getMailC()+
				"', TELC = '"+uneEntreprise.getTelC()+
				"', MDPC = '"+uneEntreprise.getMdpC()+
				"', NOMENTREPRISE = '"+uneEntreprise.getNOMENTREPRISE()+
				"', NOMRESPONSABLE = '"+uneEntreprise.getNOMRESPONSABLE()+
				"', NUMEROC = '"+uneEntreprise.getNumeroC()+"');";
		execRequete(requete);

		
			
		
	}
	
	public static void deleteEntreprise (Entreprise uneEntreprise) {

		String requete = "delete from ENTREPRISE where NUMEROC = "+uneEntreprise.getNumeroC()+" ;";
		
		execRequete(requete);
			
		
	}
	
	/******************** Model Particulier ********************/
	
	public static ArrayList<Particulier> selectAllParticulier(){
		ArrayList<Particulier> lesParticuliers = new ArrayList<Particulier>();
		String requete="select * from PARTICULIER";
	
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				int NUMEROC = unRes.getInt("NUMEROC");
				String ADRESSEC = unRes.getString("ADRESSEC");
				String MAILC = unRes.getString("MAILC");
				int TELC = unRes.getInt("TELC");
				String MDPC = unRes.getString("MDPC");
				String NOMPARTICULIER = unRes.getString("NOMPARTICULIER");
				String PRENOMPARTICULIER = unRes.getString("PRENOMPARTICULIER");
				Particulier unParticulier = new Particulier(NUMEROC,ADRESSEC,MAILC,TELC,MDPC,NOMPARTICULIER,PRENOMPARTICULIER);
				lesParticuliers.add(unParticulier);
									
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
			
		}catch (SQLException e) {
			
			System.out.println("Erreur fetch client");
		}
			return lesParticuliers;
	}
	
	public static Particulier selectWhereParticulier (Particulier unParticulier) {
		
		Particulier leParticulier = null;
		
		String requete = "select NUMEROC from PARTICULIER where NUMEROC='"+unParticulier.getNumeroC()+
				"' AND ADRESSEC = '"+unParticulier.getAdresseC()+
				"' AND TELC = '"+unParticulier.getTelC()+"');";
		
		Bdd uneBdd = new Bdd ("192.168.8.217", "db730661205", "lepape", "lepape");
		try{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int idClient = unRes.getInt("NUMEROC");
				leParticulier = new Particulier (idClient, unParticulier.getAdresseC(), unParticulier.getMailC(), unParticulier.getTelC(), unParticulier.getMdpC(), unParticulier.getNOMPARTICULIER(), unParticulier.getPRENOMPARTICULIER());
				
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
		}catch (SQLException e) {
			System.out.println("Erreur : "+requete);
		}
		return leParticulier;
	}
	
	public static void insertParticulier (Particulier unParticulier) {
		String requete = "insert into PARTICULIER values (null, '"+unParticulier.getAdresseC()+
				"','"+unParticulier.getNOMPARTICULIER()+
				"','"+unParticulier.getPRENOMPARTICULIER()+
				"','"+unParticulier.getTelC()+
				"','"+unParticulier.getMailC()+
				"','"+unParticulier.getMdpC()+"');";
		execRequete(requete);

			
		
	}
	
	public static void updateParticulier (Particulier unParticulier) {

		String requete = "update into PARTICULIER set ADRESSEC='"+unParticulier.getAdresseC()+
				"', NOMPARTICULIER = '"+unParticulier.getNOMPARTICULIER()+
				"', PRENOMPARTICULIER = '"+unParticulier.getPRENOMPARTICULIER()+
				"', MAILC = '"+unParticulier.getMailC()+
				"', TELC = '"+unParticulier.getTelC()+
				"', MDPC = '"+unParticulier.getMdpC()+
				"', NUMEROC = '"+unParticulier.getNumeroC()+"');";
		execRequete(requete);

		
			
		
	}
	
	public static void deleteParticulier (Particulier unParticulier) {

		String requete = "delete from PARTICULIER where NUMEROC = "+unParticulier.getNumeroC()+" ;";
		
		execRequete(requete);
			
		
	}
}
