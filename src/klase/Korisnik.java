package klase;

public class Korisnik {

	
		private String ime;
		private String prezime;
		private String pol;
		private String telefon;
		private String adresa;
		private String korisnickoIme;
		private String lozinka;
		
		public Korisnik() {
			ime="probaIme";
			prezime="probaPrezime";
			pol="probaPol";
			telefon="probaTelefon";
			korisnickoIme="probaKorisnickoIme";
			lozinka="probaLozinka";
		}
		
		public Korisnik(String ime, String prezime, String pol, String telefon, String adresa, String korisnickoIme, String lozinka) {
			this.ime=ime;
			this.prezime=prezime;
			this.pol=pol;
			this.telefon=telefon;
			this.adresa=adresa;
			this.korisnickoIme=korisnickoIme;
			this.lozinka=lozinka;
		}
		
		public String getIme() {
			return ime;
		}
		public void setIme(String ime) {
			this.ime = ime;
		}
		public String getPrezime() {
			return prezime;
		}
		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}
		public String getPol() {
			return pol;
		}
		public void setPol(String pol) {
			this.pol = pol;
		}
		public String getTelefon() {
			return telefon;
		}
		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}
		public String getAdresa() {
			return adresa;
		}
		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}
		public String getKorisnickoIme() {
			return korisnickoIme;
		}
		public void setKorisnickoIme(String korisnickoIme) {
			this.korisnickoIme = korisnickoIme;
		}
		public String getLozinka() {
			return lozinka;
		}
		public void setLozinka(String lozinka) {
			this.lozinka = lozinka;
		}
		public void izmenaKorisnika(Korisnik novi) {
			if(novi.getIme()!=this.getIme()) {
				this.setIme(novi.getIme());
			}
			if(novi.getPrezime()!=this.getPrezime()) {
				this.setPrezime(novi.getPrezime());
			}
			if(novi.getPol()!=this.getPol()) {
				this.setPol(novi.getPol());
			}
			if(novi.getTelefon()!=this.getTelefon()) {
				this.setTelefon(novi.getTelefon());
			}
			if(novi.getAdresa()!=this.getAdresa()) {
				this.setAdresa(novi.getAdresa());
			}
			if(novi.getKorisnickoIme()!=this.getKorisnickoIme()) {
				this.setKorisnickoIme(novi.getKorisnickoIme());
			}
			if(novi.getLozinka()!=this.getLozinka()) {
				this.setLozinka(novi.getLozinka());
			}
		}
}