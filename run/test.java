//$aapl.price --> example of user input

import java.net.URLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


class test{
public static void main (String args []){

String query = "https://cloud.iexapis.com/v1/stock/aapl/quote/latestPrice?token="
String token; 

try{
//connection tunnel
URL url = new URL(query+token);
URLConnection connection = url.openConnection();

//recieving data
InputStream response = connection.getInputStream();

//cleaning&&converting data
BufferedReader br = new BufferedReader(new InputStreamReader(response));
StringBuffer sb = new StringBuffer();
String line="";
while((line=br.readLine())!=null){
sb.append(line);}

//print data
System.out.println(sb.toString());
}//End Try

catch(java.lang.Exception e){
e.printStackTrace();
}

}//End of Main Method
}//End of Class