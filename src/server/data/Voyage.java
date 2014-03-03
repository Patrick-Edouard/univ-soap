package server.data;

public class Voyage {
	@Override
	public String toString() {
		return "Voyage [destinationPays=" + destinationPays
				+ ", destinationVille=" + destinationVille + ", description="
				+ description + ", prix=" + prix + ", regime=" + regime
				+ ", photo=" + photo + "]";
	}
	private String destinationPays;
	private String destinationVille;
	private String description;
	private String prix;
	private String regime;
	private String photo = "";
	
	public Voyage(String destinationPays, String destinationVille,
			String description, String prix, String regime) {
		super();
		this.destinationPays = destinationPays;
		this.destinationVille = destinationVille;
		this.description = description;
		this.prix = prix;
		this.regime = regime;
	}
	
	public Voyage(String destinationPays, String destinationVille,
			String description, String prix, String regime, String photo) {
		super();
		this.destinationPays = destinationPays;
		this.destinationVille = destinationVille;
		this.description = description;
		this.prix = prix;
		this.regime = regime;
		this.photo = photo;
	}
	
	public String getDestinationPays() {
		return destinationPays;
	}
	public void setDestinationPays(String destinationPays) {
		this.destinationPays = destinationPays;
	}
	public String getDestinationVille() {
		return destinationVille;
	}
	public void setDestinationVille(String destinationVille) {
		this.destinationVille = destinationVille;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getRegime() {
		return regime;
	}
	public void setRegime(String regime) {
		this.regime = regime;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
