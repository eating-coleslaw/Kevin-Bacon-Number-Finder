public class personFilmPair {
	private String personName;
	private String filmName;
	
	public personFilmPair(String line) {
		String[] pair = line.split("\\|");
		personName = pair[0].replaceAll(" \\([A-Z]++\\)", "");
		filmName = pair[1].replaceAll(" \\([0-9]{4}\\)\r", "");
	}
	
	public String getPerson() {
		return personName;
	}
	
	public String getFilm() {
		return filmName;
	}

}