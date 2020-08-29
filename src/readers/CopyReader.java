package readers;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class CopyReader {
	
	private List<String[]> datas = new ArrayList<String[]>();
	private String filePath;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<String[]> getDatas() {
		return datas;
	}

	public CopyReader(String filePath) {
		super();
		this.filePath = filePath;
		readCSVData(filePath);
	}

	public void setDatas(List<String[]> datas) {
		this.datas = datas;
	}

	private  List<String[]> readCSVData(String filePath) {
		FileReader fileReader = null;
		CSVReader csvReader = null;
		List<String[]> allData = new ArrayList<String[]>();
		try {
			fileReader = new FileReader(System.getProperty("user.dir")+filePath);
			csvReader = new CSVReader(fileReader);
			allData = csvReader.readAll();
			
			allData.forEach(row->{
				for (String data : row) {
					System.out.print(data+"\t");
				}
				System.out.println();
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				csvReader.close();
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setDatas(allData);
		return allData;
	}
	
	private int getCellIndex(String cellColumn) {
		int index = 0;
		String[] cellHeaders = this.datas.get(0);
		List<String> columnHeaders = new ArrayList<String>();
		for (String cell : cellHeaders) {
			if (cell.equalsIgnoreCase(cellColumn)) {
				break;
			}
			index++;
		}
		return index;
	}
	
	public  String getCellValue(String cellColumn) {
		String cellValue = new ArrayList<>(Arrays.asList(datas.get(1))).get(getCellIndex(cellColumn));
		return cellValue;
	}
	
}
