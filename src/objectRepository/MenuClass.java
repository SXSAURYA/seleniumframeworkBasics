package objectRepository;

public class MenuClass {

	Records records;

	public enum Records {
		Select_All_Records("Select All Records"), Select_Current_Page("Select Current Page");

		private String text;
		 
		private Records(String text) {
			this.text = text;
		}
	 
		public String getCompanyLetter() {
			return text;
		}
	}
}
