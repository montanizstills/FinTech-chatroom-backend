import java.net.URLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class mainApplication{

private InputStream response;
private String parsedOutput;
private String uncleanURL = "https://cloud.iexapis.com/v1/stock/aapl/news?token=";
private URL cleanURL;
private URLConnection connection;


//Each try-catch should be a method.

public void createURL(String uncleanURL){
	try {
	 cleanURL = new URL(uncleanURL);
	} catch(Exception e){
		e.printStackTrace();
	}
}
public void establishConnection(){
	try {
	connection = cleanURL.openConnection();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
public void catchResponse(){
	try {
	response = connection.getInputStream();
	} catch(Exception e) {
		e.printStackTrace();
	}
}

public void connect(){
	//use QueryMaker.queryMaker() as param of URL;
	createURL(uncleanURL);
	establishConnection();
	catchResponse();
}

@Override
public String toString(){
	BufferedReader br = new BufferedReader(new InputStreamReader(response));
	StringBuffer sb = new StringBuffer();
	try{
	while((parsedOutput=br.readLine())!=null){sb.append(parsedOutput);}
	} catch(Exception e) {
		e.printStackTrace();
	}
	return sb.toString();
}

public static void main(String args []){
	mainApplication mainApp = new mainApplication();
	mainApp.connect();
	String parsedOutput = mainApp.toString();
	System.out.println(parsedOutput);
}

}//End of Class