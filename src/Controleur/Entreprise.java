package Controleur;

public class Entreprise extends Client{
	private String NOMENTREPRISE,NOMRESPONSABLE;
	
	public Entreprise() {
		super();
		this.NOMENTREPRISE="";
		this.NOMRESPONSABLE="";
	}
	public Entreprise (int NUMEROC,String ADRESSEC,String MAILC, int TELC, String MDPC ,String NOMENTREPRISE, String NOMRESPONSABLE) {
		super(NUMEROC,ADRESSEC,MAILC,TELC,MDPC);
		this.NOMENTREPRISE=NOMENTREPRISE;
		this.NOMRESPONSABLE=NOMRESPONSABLE;
	}
	public Entreprise ( String ADRESSEC, int TELC,String MAILC, String MDPC, String NOMENTREPRISE, String NOMRESPONSABLE){
		super(ADRESSEC,TELC,MAILC,MDPC);
		this.NOMENTREPRISE=NOMENTREPRISE;
		this.NOMRESPONSABLE=NOMRESPONSABLE;
	}

	public String getNOMENTREPRISE() {
		return NOMENTREPRISE;
	}
	public void setNOMENTREPRISE(String nOMENTREPRISE) {
		NOMENTREPRISE = nOMENTREPRISE;
	}
	public String getNOMRESPONSABLE() {
		return NOMRESPONSABLE;
	}
	public void setNOMRESPONSABLE(String nOMRESPONSABLE) {
		NOMRESPONSABLE = nOMRESPONSABLE;
	}


}
