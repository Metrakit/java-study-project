//import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Object;


public class AdherentController {
	
	private ArrayList<Adherent> adherents = new ArrayList<Adherent>();
	
	private Scanner sc = new Scanner(System.in);
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRENCH);

	public static void main(String[] args)
	{	
		AdherentController self = new AdherentController();
		
		LocalDate date1 = LocalDate.parse("1 janvier 2015", self.formatter);
		
		self.addAdherent(self.setId(), "norris", "chuck", "blablabla", "010101", "texas", date1, 99, date1);
		self.addAdherent(self.setId(), "test", "sdsqd", "sdsdsdsd", "sss", "ddd", date1, 99, date1);
		self.listAdherents();
		
		Adherent findAdherent = self.findAdherent(1);
		
		if (findAdherent == null) {
			System.out.println("Adhérent introuvable !");
		} else {
			System.out.println("Résultat: ");
			System.out.println(findAdherent.read());
		}
		
		Adherent findAdherent3 = self.findAdherent(3);
		
		if (findAdherent3 == null) {
			System.out.println("Adhérent introuvable !");
		} else {
			System.out.println("Résultat: ");
			System.out.println(findAdherent3.read());
		}		
		
		// update
		LocalDate date = LocalDate.parse("1 janvier 2015", self.formatter);
		self.updateAdherent(1, "test", "sdsd", "sss", "050505", "ddd", date, 99, date);
		
		Adherent findad = self.findAdherent(1);
		System.out.println(findad.read());
		
		self.enableScanner(true);
		
	}
	
	public boolean enableScanner(boolean displayHelp)
	{
		this.sc = new Scanner(System.in);
		
		if (displayHelp) {
			System.out.println("======== MENU ========");
			System.out.println("L: Liste des adhérents");
			System.out.println("A: Ajouter un adhérent");
			System.out.println("M: Modifier un adhérent");
			System.out.println("V: Voir un adhérent");
			System.out.println("S: Supprimer un adhérent");
			System.out.println("Veuillez saisir une lettre [L|A|M|V|S] :");		
		} else {
			System.out.println("Une autre action ? [L|A|M|V|S] :");	
		}

		String key = this.sc.nextLine();
		this.keyTyped(key);
		
		this.enableScanner(false);
		return true;
	}

	//public void keyTyped(KeyEvent e)
	public boolean keyTyped(String key)
	{
		//int key = e.getKeyCode();
		//System.out.println("touche pressée !");
		
		/*if (key == KeyEvent.VK_L) {
			this.listAdherents();
		} else if (key == KeyEvent.VK_A) {
			this.addAdherent(this.setId(), "hey", "hi", "hahaha", "010101", "texas", new Date(), 99, new Date());
		} else if (key == KeyEvent.VK_M) {
			this.updateAdherent(1, "hhhhh", "dsqqq", "ddvv", "05606078", "ddd", new Date(), 99, new Date());
		} else if (key == KeyEvent.VK_V) {
			this.findAdherent(2);
		} else if (key == KeyEvent.VK_S) {
			this.deleteAdherent(2);
		}*/
		System.out.println("key: " + key);
		if (key.equals("L")) {
			System.out.println("Récupération de la liste des adhérents :");
			this.listAdherents();
			return true;
		} else if (key.equals("A")) {
			this.processAdAdherent();
			return true;
		} else if (key.equals("M")) {
			System.out.println("Tentative de msie à jour d'un adhérent");			
			LocalDate date = LocalDate.parse("January 1, 2015", this.formatter);
			this.updateAdherent(1, "hhhhh", "dsqqq", "ddvv", "05606078", "ddd", date, 99, date);
			return true;
		} else if (key.equals("V")) {
			System.out.println("Recherche d'un adhérent :");
			this.findAdherent(2);
			return true;
		} else if (key.equals("S")) {
			System.out.println("Tentative de suppression d'un adhérent");
			this.deleteAdherent(2);
			return true;
		} else {
			System.out.println("Commande inconnue !");
			return false;
		}
	}
	
	public boolean processAdAdherent()
	{
		
		
		System.out.println("==== Renseiger les informations pour ajouter un adhérent ====");
		
		// Nom
		System.out.println("Nom de l'adhérent :");
		String nomAd = this.sc.nextLine();
		
		// Prenom
		System.out.println("Prénom de l'adhérent :");
		String prenomAd = this.sc.nextLine();
		
		// Adresse
		System.out.println("Adresse de l'adhérent :");
		String adresseAd = this.sc.nextLine();
		
		// Code postal
		System.out.println("Code postal de l'adhérent :");
		String codePostal = this.sc.nextLine();
		
		// Ville
		System.out.println("Ville de l'adhérent :");
		String villeAd = this.sc.nextLine();
		
		// Date de naissance
		System.out.println("Date de naissance de l'adhérent :");
		String dateNaissanceAd = this.sc.nextLine();
		LocalDate dateNais = LocalDate.parse(dateNaissanceAd, this.formatter);		
		
		// Montant de la cotisation
		System.out.println("Montant de la cotisation de l'adhérent :");
		float cotisationAd = Float.parseFloat(this.sc.nextLine());		
		
		// Date de la cotisation
		System.out.println("Date de la cotisation de l'adhérent :");
		String dateCotisationAd = this.sc.nextLine();				
		LocalDate dateCoti = LocalDate.parse(dateCotisationAd, this.formatter);
		
		this.addAdherent(this.setId(), nomAd, prenomAd, adresseAd, codePostal, villeAd, dateNais, cotisationAd, dateCoti);
		
		return true;
	}
	
	public int setId()
	{
		int lastId = adherents.size();
		return lastId+1;
	}
	
	/**
	 * Liste les adhérents
	 * @return
	 */
	public boolean listAdherents()
	{
		int totalAdherents = adherents.size();
		
		for (int i = 0; i < totalAdherents; i++) {
			Object ad = adherents.get(i);
			String line = ((Adherent) ad).read();
			System.out.println(line);
		}
		return true;
	}
	
	public boolean updateAdherent(int adherentId, String Pnom, String Pprenom, String Padresse, String PcodePostal, String Pville, LocalDate PdateNaissance, float Pcotisation, LocalDate PdateCotisation)
	{
		Adherent ad = this.findAdherent(adherentId);
		
		if (ad != null) {
			ad.update(Pnom, Pprenom, Padresse, PcodePostal, Pville, PdateNaissance, Pcotisation, PdateCotisation);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Ajoute un adhérent
	 * @param Pid
	 * @param Pnom
	 * @param Pprenom
	 * @param Padresse
	 * @param PcodePostal
	 * @param Pville
	 * @param date
	 * @param Pcotisation
	 * @param PdateCotisation
	 * @return
	 */
	public int addAdherent(int Pid, String Pnom, String Pprenom, String Padresse, String PcodePostal, String Pville, LocalDate date, float Pcotisation, LocalDate PdateCotisation)
	{
		Adherent adherent = new Adherent();
		adherent.create(Pid, Pnom, Pprenom, Padresse, PcodePostal, Pville, date, Pcotisation, PdateCotisation);
		adherents.add(adherent);
		return 1;
	}
	
	/**
	 * Cherche un adhérent dans l'ArrayList
	 * @param idAdherent
	 * @return
	 */
	public Adherent findAdherent(int idAdherent)
	{
		int totalAdherents = adherents.size();
		
		for (int i = 0; i < totalAdherents; i++) {
			Object ad = adherents.get(i);
			int adId =  ((Adherent) ad).getId();
			if (adId == idAdherent) {
				//String line = ((Adherent) ad).read();
			    return ((Adherent) ad);
			}
		}
		return null;
	}
	
	public boolean deleteAdherent(int idAdherent)
	{
		Adherent ad = this.findAdherent(idAdherent);
		
		if (ad != null) {
			adherents.remove(ad);
			return true;
		}
				
		return false;
	}
	
}
