package Controleur;

public class Particulier extends Client{
	private String NOMPARTICULIER, PRENOMPARTICULIER;
	public Particulier() {
		super();
		this.NOMPARTICULIER="";
		this.PRENOMPARTICULIER="";
	}

	public Particulier (int NUMEROC,String ADRESSEC,String MAILC, int TELC, String MDPC ,String NOMPARTICULIER, String PRENOMPARTICULIER) {
		super(NUMEROC,ADRESSEC,MAILC,TELC,MDPC);
		this.NOMPARTICULIER=NOMPARTICULIER;
		this.PRENOMPARTICULIER=PRENOMPARTICULIER;
	}
	public Particulier ( String ADRESSEC, int TELC,String MAILC, String MDPC, String NOMPARTICULIER, String PRENOMPARTICULIER){
		super(ADRESSEC,TELC,MAILC,MDPC);
		this.NOMPARTICULIER=NOMPARTICULIER;
		this.PRENOMPARTICULIER=PRENOMPARTICULIER;
	}
	
	public String getNOMPARTICULIER() {
		return NOMPARTICULIER;
	}
	public void setNOMPARTICULIER(String nOMPARTICULIER) {
		NOMPARTICULIER = nOMPARTICULIER;
	}
	public String getPRENOMPARTICULIER() {
		return PRENOMPARTICULIER;
	}
	public void setPRENOMPARTICULIER(String pRENOMPARTICULIER) {
		PRENOMPARTICULIER = pRENOMPARTICULIER;
	}
}
