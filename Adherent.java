import java.time.LocalDate;

public class Adherent {
	
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private LocalDate dateNaissance;
	private float cotisation;
	private LocalDate dateCotisation;
	
	public static void main(String[] args)
	{
		System.out.println("hello");
	}
	
	public int setId(int Pid)
	{
		id = Pid;
		return 1;
	}
	
	public int getId()
	{
		return id;
	}	
	
	public int setNom(String Pnom)
	{
		nom = Pnom;
		return 1;
	}
	
	public String getNom()
	{
		return nom;
	}		
	
	public int setPrenom(String PPrenom)
	{
		prenom = PPrenom;
		return 1;
	}
	
	public String getPrenom()
	{
		return prenom;
	}		
	
	public int setAdresse(String Padresse)
	{
		adresse = Padresse;
		return 1;
	}
	
	public String getAdresse()
	{
		return adresse;
	}		
	
	public int setCodePostal(String PcodePostal)
	{
		codePostal = PcodePostal;
		return 1;
	}
	
	public String getCodePostal()
	{
		return codePostal;
	}			
	
	public int setVille(String Pville)
	{
		ville = Pville;
		return 1;
	}
	
	public String getVille()
	{
		return ville;
	}		
	
	public int setDateNaissance(LocalDate pdateNaissance)
	{
		dateNaissance = pdateNaissance;
		return 1;
	}
	
	public LocalDate getDateNaissance()
	{
		return dateNaissance;
	}		
	
	public int setCotisation(float Pcotisation)
	{
		cotisation = Pcotisation;
		return 1;
	}
	
	public float getCotisation()
	{
		return cotisation;
	}		
	
	public int setDateCotisation(LocalDate PdateCotisation)
	{
		dateCotisation = PdateCotisation;
		return 1;
	}
	
	public LocalDate getDateCotisation()
	{
		return dateCotisation;
	}
	
	public int create(int Pid, String Pnom, String Pprenom, String Padresse, String PcodePostal, String Pville, LocalDate date, float Pcotisation, LocalDate pdateCotisation)
	{
		this.setId(Pid);
		this.setNom(Pnom);
		this.setPrenom(Pprenom);
		this.setAdresse(Padresse);
		this.setCodePostal(PcodePostal);
		this.setVille(Pville);
		this.setDateNaissance(date);
		this.setCotisation(Pcotisation);
		this.setDateCotisation(pdateCotisation);
		return 1;
	}
	
	public int update(String Pnom, String Pprenom, String Padresse, String PcodePostal, String Pville, LocalDate PdateNaissance, float Pcotisation, LocalDate PdateCotisation)
	{
		this.setNom(Pnom);
		this.setPrenom(Pprenom);
		this.setAdresse(Padresse);
		this.setCodePostal(PcodePostal);
		this.setVille(Pville);
		this.setDateNaissance(PdateNaissance);
		this.setCotisation(Pcotisation);
		this.setDateCotisation(PdateCotisation);
		return 1;
	}	
	
	public String read()
	{
		/*System.out.println(this.getId());
		System.out.println(this.getNom());
		System.out.println(this.getPrenom());
		System.out.println(this.getAdresse());
		System.out.println(this.getCodePostal());
		System.out.println(this.getVille());
		System.out.println(this.getDateNaissance());
		System.out.println(this.getCotisation());
		System.out.println(this.getDateCotisation());*/
		
		String line = this.getId() + "|" + 
					  this.getNom() + "|" +
					  this.getPrenom() + "|" +
					  this.getAdresse() + "|" +
					  this.getCodePostal() + "|" +
					  this.getVille() + "|" +
					  this.getDateNaissance() + "|" +
					  this.getCotisation() + "|" +
					  this.getDateCotisation();
		return line;
	}
	
}
