package Controleur;

public class Client {
	
		
		private int NUMEROC,TELC;
		private String ADRESSEC,MAILC,MDPC;
		
		public Client() {
			this.NUMEROC=0;
			this.ADRESSEC ="";
			this.TELC =0;
			this.MAILC="";
			this.MDPC="";
		}
		
		public Client (int NUMEROC,String ADRESSEC,String MAILC, int TELC, String MDPC) {
			this.NUMEROC= NUMEROC;
			this.ADRESSEC =ADRESSEC;
			this.TELC =TELC;
			this.MAILC=MAILC;
			this.MDPC=MDPC;
		}
		public Client ( String ADRESSEC, int TELC,String MAILC, String MDPC) {
			this.NUMEROC=0;
			this.ADRESSEC =ADRESSEC;
			this.TELC =TELC;
			this.MAILC=MAILC;
			this.MDPC=MDPC;
		}

		public int getNumeroC() {
			return NUMEROC;
		}

		public void setNumeroC(int NUMEROC) {
			this.NUMEROC = NUMEROC;
		}


		public int getTelC() {
			return TELC;
		}

		public void setTelC(int TELC) {
			this.TELC = TELC;
		}
		public String getMailC() {
			return MAILC;
		}

		public void setMailC(String MAILC) {
			this.MAILC = MAILC;
		}
		public String getAdresseC() {
			return ADRESSEC;
		}

		public void setAdresseC(String ADRESSEC) {
			this.ADRESSEC = ADRESSEC;
		}
		
		public String getMdpC() {
			return MDPC;
		}

		public void setMdpC(String MDPC) {
			this.MDPC = MDPC;
		}

}

