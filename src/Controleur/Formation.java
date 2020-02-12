package Controleur;



public class Formation {
	private int NUMEROFORMATION, NOMBREPERSONNE, NUMTYPE, NUMEROC;
	private String DATEF;
	
	public Formation() {
		NUMEROFORMATION=0;
		NUMTYPE=0;
		NUMEROC=0;
		NOMBREPERSONNE=0;
		DATEF=""; 
	}
	
	public Formation (int NUMEROFORMATION,int NUMTYPE,int NUMEROC,int NOMBREPERSONNE, String DATEF) {
		this.NUMEROFORMATION= NUMEROC;
		this.NUMTYPE =NUMTYPE;
		this.NUMEROC =NUMEROC;
		this.NOMBREPERSONNE=NOMBREPERSONNE;
		this.DATEF=DATEF;
	}
	
	public Formation ( int NUMTYPE, int NUMEROC,int NOMBREPERSONNE, String DATEF) {
		this.NUMEROFORMATION=0;
		this.NUMTYPE =NUMTYPE;
		this.NUMEROC =NUMEROC;	
		this.NOMBREPERSONNE=NOMBREPERSONNE;
		this.DATEF=DATEF;
	}
	public int getNUMEROFORMATION() {
		return NUMEROFORMATION;
	}

	public void setNUMEROFORMATION(int nUMEROFORMATION) {
		NUMEROFORMATION = nUMEROFORMATION;
	}

	public int getNOMBREPERSONNE() {
		return NOMBREPERSONNE;
	}

	public void setNOMBREPERSONNE(int nOMBREPERSONNE) {
		NOMBREPERSONNE = nOMBREPERSONNE;
	}

	public int getNUMTYPE() {
		return NUMTYPE;
	}

	public void setNUMTYPE(int nUMTYPE) {
		NUMTYPE = nUMTYPE;
	}

	public int getNUMEROC() {
		return NUMEROC;
	}

	public void setNUMEROC(int nUMEROC) {
		NUMEROC = nUMEROC;
	}

	public String getDATEF() {
		return DATEF;
	}

	public void setDATEF(String dATEF) {
		DATEF = dATEF;
	}


}
