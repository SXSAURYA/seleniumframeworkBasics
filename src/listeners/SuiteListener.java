package listeners;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;

public class SuiteListener implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		//Send Email --> Suite execution start..
		
	}

	@Override
	public void onFinish(ISuite suite) {
	//Snend Email with all of the reports
		Map<String, ISuiteResult> results = suite.getResults();
		Iterator<ISuiteResult> itestresults = results.values().iterator();
		System.out.println(":::Cases passed::::::"+itestresults.next().getTestContext().getPassedTests().size());
	}

}
