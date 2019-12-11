import tokenReceiver;

public class QueryMaker{

private String stock;
//private String action;
private String query;

public QueryMaker(String stock, /*action ,*/tokenReceiver token){
stock=stock;
//action=action;

//if (action=="quote"){
return query = "https://cloud.iexapis.com/v1/"+stock+"/quote/latestPrice?"+tokenReceiver.getToken();
//}//End if
}//End constructor

public QueryMaker(String stock, tokenReceiver token){}
}//End of Class