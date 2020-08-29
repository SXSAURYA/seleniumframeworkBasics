package listeners;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

public class ReportListeners implements IReporter{

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for (ISuite iSuite : suites) {
			System.out.println(iSuite.getName());
			System.out.println(iSuite.getAllMethods().size());
			System.out.println(iSuite.getResults());
		}
	}

}
