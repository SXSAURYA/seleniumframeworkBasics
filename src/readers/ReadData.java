package readers;

public class ReadData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nagarajuAddress = ExcelReader.getRowData("Data", "Person Details");
		
		System.out.println(nagarajuAddress);
		
		String locatorValue = JSONReader.getValue("LoginLocator", "submitButton", "xpath");
		System.out.println(locatorValue);
	}

}
