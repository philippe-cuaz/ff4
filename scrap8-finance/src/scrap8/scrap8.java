package scrap8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.JSONArray;

public class scrap8 {
	static scrap8 x=new scrap8();
	static Timer timer;	
	public static void main(String[] args) {
		
		timer = new Timer();
	    int delay = 10;
	    int onesecond=1000;
	    int onehour=3600*onesecond;
	    int period = onehour*24;
	    TimerTask task = new TimerTask()
	    {
	     public void run()
	     {
	    	 mytimedata td=x.new mytimedata();
	    	
	 		 td.actionPerformed();
	         System.out.println("bye bye everybody");
	     }
	    };
	    timer.scheduleAtFixedRate(task, delay, period);
		}
	public class mytimedata  {
		public void actionPerformed(){
			  datawebimporttodatabase dat=new datawebimporttodatabase(); 
		      dat.getdata();
		    
		}
	}
	static public class datawebimporttodatabase{
		public void getdata(){

			try {

				
				 String url2="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/470/G";
				 JSONObject json2 = new JSONObject(IOUtils.toString(new URL(url2), Charset.forName("UTF-8")));
	             String myjsonstr2=json2.toString();
			     String filepath2="/home/phcuaz/Desktop/finance/sugar_future_json.txt";
			     
		         BufferedWriter out2 = new BufferedWriter(new FileWriter(filepath2));
		         out2.write(myjsonstr2);
		         out2.close();
				
				JSONObject obj2 = new JSONObject(myjsonstr2);
			
				JSONArray arr2 = obj2.getJSONArray("quotes");
				int s1=arr2.length();
				String[] idattr1=new String[s1+1];
	            String[] valuetext1=new String[s1+1];
	            String[] idattr2=new String[s1+1];
	            String[] valuetext2=new String[s1+1];
				for (int m = 0; m <s1 ; m++)
				{
					long productId = arr2.getJSONObject(m).getLong("productId");
					String quoteCode = arr2.getJSONObject(m).getString("quoteCode");
				    String priorSettle = arr2.getJSONObject(m).getString("priorSettle");
				    String last = arr2.getJSONObject(m).getString("last");
				    String title = arr2.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr1[m]=quoteCode;
				    idattr2[m]=title;
				    valuetext1[m]=priorSettle;
				    valuetext2[m]=last;
				}
				
				
				 
				 String url3="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/320/G";
				 JSONObject json3 = new JSONObject(IOUtils.toString(new URL(url3), Charset.forName("UTF-8")));
	             String myjsonstr3=json3.toString();
			   
			     String filepath3="/home/phcuaz/Desktop/finance/soybean_future_json.txt";
			     
		         BufferedWriter out3 = new BufferedWriter(new FileWriter(filepath3));
		         out3.write(myjsonstr3);
		         out3.close();
				
				JSONObject obj3 = new JSONObject(myjsonstr3);
			
				JSONArray arr3 = obj3.getJSONArray("quotes");
				int s3=arr3.length();
				String[] idattr3=new String[s3+1];
	            String[] valuetext3=new String[s3+1];
	            String[] idattr3b=new String[s3+1];
	            String[] valuetext3b=new String[s3+1];
				for (int m = 0; m < arr3.length(); m++)
				{
					String quoteCode = arr3.getJSONObject(m).getString("quoteCode");
				    long productId = arr3.getJSONObject(m).getLong("productId");
				    String priorSettle = arr3.getJSONObject(m).getString("priorSettle");
				    String last = arr3.getJSONObject(m).getString("last");
				    String title = arr3.getJSONObject(m).getJSONObject("priceChart").getString("title");	    
				    idattr3[m]=quoteCode;
				    idattr3b[m]=title;
				    valuetext3[m]=priorSettle;
				    valuetext3b[m]=last;
				    System.out.println("productId="+productId+" quoteCode="+idattr3[m]+" title="+idattr3b[m]+" priorSettle="+valuetext3[m]+" last="+valuetext3b[m]);
				}
				
					
				 String url4="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/22/G";
				 JSONObject json4 = new JSONObject(IOUtils.toString(new URL(url4), Charset.forName("UTF-8")));
	             String myjsonstr4=json4.toString();
			   
			     String filepath4="/home/phcuaz/Desktop/finance/live_cattle_future_json.txt";
			     
		         BufferedWriter out4 = new BufferedWriter(new FileWriter(filepath4));
		         out4.write(myjsonstr4);
		         out4.close();
				
				JSONObject obj4 = new JSONObject(myjsonstr4);
			
				JSONArray arr4 = obj4.getJSONArray("quotes");
				int s4=arr4.length();
				String[] idattr4=new String[s4+1];
	            String[] valuetext4=new String[s4+1];
	            String[] idattr4b=new String[s4+1];
	            String[] valuetext4b=new String[s4+1];
				for (int m = 0; m < arr4.length(); m++)
				{
					String quoteCode = arr4.getJSONObject(m).getString("quoteCode");
				    long productId = arr4.getJSONObject(m).getLong("productId");
				    String priorSettle = arr4.getJSONObject(m).getString("priorSettle");
				    String last = arr4.getJSONObject(m).getString("last");
				    String title = arr4.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr4[m]=quoteCode;
				    idattr4b[m]=title;
				    valuetext4[m]=priorSettle;
				    valuetext4b[m]=last;
				}
				
				
				
				 
				String url7="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/438/G";
				 JSONObject json7 = new JSONObject(IOUtils.toString(new URL(url7), Charset.forName("UTF-8")));
	            String myjsonstr7=json7.toString();
			   
			     String filepath7="/home/phcuaz/Desktop/finance/copper_future_json.txt";
			     
		         BufferedWriter out7 = new BufferedWriter(new FileWriter(filepath7));
		         out7.write(myjsonstr7);
		         out7.close();
				
				JSONObject obj7 = new JSONObject(myjsonstr7);
			
				JSONArray arr7 = obj7.getJSONArray("quotes");
				int s7=arr7.length();
				String[] idattr7=new String[s7+1];
	            String[] valuetext7=new String[s7+1];
	            String[] idattr7b=new String[s7+1];
	            String[] valuetext7b=new String[s7+1];
				for (int m = 0; m < arr7.length(); m++)
				{
					String quoteCode = arr7.getJSONObject(m).getString("quoteCode");
				    long productId = arr7.getJSONObject(m).getLong("productId");
				    String priorSettle = arr7.getJSONObject(m).getString("priorSettle");
				    String last = arr7.getJSONObject(m).getString("last");
				    String title = arr7.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr7[m]=quoteCode;
				    idattr7b[m]=title;
				    valuetext7[m]=priorSettle;
				    valuetext7b[m]=last;
				}
				
				String url5="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/460/G";
				JSONObject json5 = new JSONObject(IOUtils.toString(new URL(url5), Charset.forName("UTF-8")));
	            String myjsonstr5=json5.toString();
			   
			     String filepath5="/home/phcuaz/Desktop/finance/cotton_future_json.txt";
			     
		         BufferedWriter out5 = new BufferedWriter(new FileWriter(filepath5));
		         out5.write(myjsonstr5);
		         out5.close();
				
				JSONObject obj5 = new JSONObject(myjsonstr5);
			
				JSONArray arr5 = obj5.getJSONArray("quotes");
				int s5=arr5.length();
				String[] idattr5=new String[s5+1];
	            String[] valuetext5=new String[s5+1];
	            String[] idattr5b=new String[s5+1];
	            String[] valuetext5b=new String[s5+1];
				for (int m = 0; m < arr5.length(); m++)
				{
					String quoteCode = arr5.getJSONObject(m).getString("quoteCode");
				    long productId = arr5.getJSONObject(m).getLong("productId");
				    String priorSettle = arr5.getJSONObject(m).getString("priorSettle");
				    String last = arr5.getJSONObject(m).getString("last");
				    String title = arr5.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr5[m]=quoteCode;
				    idattr5b[m]=title;
				    valuetext5[m]=priorSettle;
				    valuetext5b[m]=last;
				}
				

				String url6="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/19/G";
				JSONObject json6 = new JSONObject(IOUtils.toString(new URL(url6), Charset.forName("UTF-8")));
	            String myjsonstr6=json6.toString();
			   
			     String filepath6="/home/phcuaz/Desktop/finance/lean_hogs_future_json.txt";
			     
		         BufferedWriter out6 = new BufferedWriter(new FileWriter(filepath6));
		         out6.write(myjsonstr6);
		         out6.close();
				
				JSONObject obj6 = new JSONObject(myjsonstr6);
			
				JSONArray arr6 = obj6.getJSONArray("quotes");
				int s6=arr6.length();
				String[] idattr6=new String[s6+1];
	            String[] valuetext6=new String[s6+1];
	            String[] idattr6b=new String[s6+1];
	            String[] valuetext6b=new String[s6+1];
				for (int m = 0; m < arr6.length(); m++)
				{
					String quoteCode = arr6.getJSONObject(m).getString("quoteCode");
				    long productId = arr6.getJSONObject(m).getLong("productId");
				    String priorSettle = arr6.getJSONObject(m).getString("priorSettle");
				    String last = arr6.getJSONObject(m).getString("last");
				    String title = arr6.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr6[m]=quoteCode;
				    idattr6b[m]=title;
				    valuetext6[m]=priorSettle;
				    valuetext6b[m]=last;
				}
				
				String url8="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/437/G";
				JSONObject json8 = new JSONObject(IOUtils.toString(new URL(url8), Charset.forName("UTF-8")));
	            String myjsonstr8=json8.toString();
			   
			     String filepath8="/home/phcuaz/Desktop/finance/gold_future_json.txt";
			     
		         BufferedWriter out8 = new BufferedWriter(new FileWriter(filepath8));
		         out8.write(myjsonstr8);
		         out8.close();
				
				JSONObject obj8 = new JSONObject(myjsonstr8);
			
				JSONArray arr8 = obj8.getJSONArray("quotes");
				int s8=arr8.length();
				String[] idattr8=new String[s8+1];
	            String[] valuetext8=new String[s8+1];
	            String[] idattr8b=new String[s8+1];
	            String[] valuetext8b=new String[s8+1];
				for (int m = 0; m < arr8.length(); m++)
				{
					String quoteCode = arr8.getJSONObject(m).getString("quoteCode");
				    long productId = arr8.getJSONObject(m).getLong("productId");
				    String priorSettle = arr8.getJSONObject(m).getString("priorSettle");
				    String last = arr8.getJSONObject(m).getString("last");
				    String title = arr8.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr8[m]=quoteCode;
				    idattr8b[m]=title;
				    valuetext8[m]=priorSettle;
				    valuetext8b[m]=last;
				}
				String url9="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/458/G";
				JSONObject json9 = new JSONObject(IOUtils.toString(new URL(url9), Charset.forName("UTF-8")));
	            String myjsonstr9=json9.toString();
			   
			     String filepath9="/home/phcuaz/Desktop/finance/silver_future_json.txt";
			     
		         BufferedWriter out9 = new BufferedWriter(new FileWriter(filepath9));
		         out9.write(myjsonstr9);
		         out9.close();
				
				JSONObject obj9 = new JSONObject(myjsonstr9);
			
				JSONArray arr9 = obj9.getJSONArray("quotes");
				int s9=arr9.length();
				String[] idattr9=new String[s9+1];
	            String[] valuetext9=new String[s9+1];
	            String[] idattr9b=new String[s9+1];
	            String[] valuetext9b=new String[s9+1];
				for (int m = 0; m < arr9.length(); m++)
				{
					String quoteCode = arr9.getJSONObject(m).getString("quoteCode");
				    long productId = arr9.getJSONObject(m).getLong("productId");
				    String priorSettle = arr9.getJSONObject(m).getString("priorSettle");
				    String last = arr9.getJSONObject(m).getString("last");
				    String title = arr9.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr9[m]=quoteCode;
				    idattr9b[m]=title;
				    valuetext9[m]=priorSettle;
				    valuetext9b[m]=last;
				}
				String url10="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/425/G";
				JSONObject json10 = new JSONObject(IOUtils.toString(new URL(url10), Charset.forName("UTF-8")));
	            String myjsonstr10=json10.toString();
			   
			     String filepath10="/home/phcuaz/Desktop/finance/crude_oil_future_json.txt";
			     
		         BufferedWriter out10 = new BufferedWriter(new FileWriter(filepath10));
		         out10.write(myjsonstr10);
		         out10.close();
				
				JSONObject obj10 = new JSONObject(myjsonstr10);
			
				JSONArray arr10 = obj10.getJSONArray("quotes");
				int s10=arr10.length();
				String[] idattr10=new String[s10+1];
	            String[] valuetext10=new String[s10+1];
	            String[] idattr10b=new String[s10+1];
	            String[] valuetext10b=new String[s10+1];
				for (int m = 0; m < arr10.length(); m++)
				{
					String quoteCode = arr10.getJSONObject(m).getString("quoteCode");
				    long productId = arr10.getJSONObject(m).getLong("productId");
				    String priorSettle = arr10.getJSONObject(m).getString("priorSettle");
				    String last = arr10.getJSONObject(m).getString("last");
				    String title = arr10.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr10[m]=quoteCode;
				    idattr10b[m]=title;
				    valuetext10[m]=priorSettle;
				    valuetext10b[m]=last;
				}

				 String url1=" http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/300/G?pageSize=50&_=1523283111207";
				 JSONObject json1 = new JSONObject(IOUtils.toString(new URL(url1), Charset.forName("UTF-8")));
	             String myjsonstr1=json1.toString();
			     String filepath1="/home/phcuaz/Desktop/finance/corn_future_json.txt";
			     
		         BufferedWriter out1 = new BufferedWriter(new FileWriter(filepath1));
		         out1.write(myjsonstr1);
		         out1.close();
				
				 JSONObject obj1 = new JSONObject(myjsonstr1);
			
				JSONArray arr14 = obj1.getJSONArray("quotes");
				int s14=arr14.length();
				String[] idattr14=new String[s14+1];
	            String[] valuetext14=new String[s14+1];
	            String[] idattr14b=new String[s14+1];
	            String[] valuetext14b=new String[s14+1];
				for (int m = 0; m < arr14.length(); m++)
				{
					long productId = arr14.getJSONObject(m).getLong("productId");
				    String quoteCode = arr14.getJSONObject(m).getString("quoteCode");
				    String priorSettle = arr14.getJSONObject(m).getString("priorSettle");
				    String last = arr14.getJSONObject(m).getString("last");
				    String title = arr14.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr14[m]=quoteCode;
				    idattr14b[m]=title;
				    valuetext14[m]=priorSettle;
				    valuetext14b[m]=last;
				}
				String url11="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/1/G";
				 JSONObject json11 = new JSONObject(IOUtils.toString(new URL(url11), Charset.forName("UTF-8")));
	            String myjsonstr11=json11.toString();
			     String filepath11="/home/phcuaz/Desktop/finance/eurodollard_future_json.txt";
			     
		         BufferedWriter out11 = new BufferedWriter(new FileWriter(filepath11));
		         out11.write(myjsonstr11);
		         out11.close();
				
				 JSONObject obj11 = new JSONObject(myjsonstr11);
			
				JSONArray arr11 = obj11.getJSONArray("quotes");
				int s11=arr11.length();
				String[] idattr11=new String[s11+1];
	            String[] valuetext11=new String[s11+1];
	            String[] idattr11b=new String[s11+1];
	            String[] valuetext11b=new String[s11+1];
				for (int m = 0; m < arr11.length(); m++)
				{
					long productId = arr11.getJSONObject(m).getLong("productId");
				    String quoteCode = arr11.getJSONObject(m).getString("quoteCode");
				    String priorSettle = arr11.getJSONObject(m).getString("priorSettle");
				    String last = arr11.getJSONObject(m).getString("last");
				    String title = arr11.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr11[m]=quoteCode;
				    idattr11b[m]=title;
				    valuetext11[m]=priorSettle;
				    valuetext11b[m]=last;
				}
				String url12="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/316/G";
				 JSONObject json12 = new JSONObject(IOUtils.toString(new URL(url12), Charset.forName("UTF-8")));
	           String myjsonstr12=json12.toString();
			     String filepath12="/home/phcuaz/Desktop/finance/10yearTnote_future_json.txt";
			     
		         BufferedWriter out12 = new BufferedWriter(new FileWriter(filepath12));
		         out12.write(myjsonstr12);
		         out12.close();
				
				 JSONObject obj12 = new JSONObject(myjsonstr12);
			
				JSONArray arr12 = obj12.getJSONArray("quotes");
				int s12=arr12.length();
				String[] idattr12=new String[s12+1];
	            String[] valuetext12=new String[s12+1];
	            String[] idattr12b=new String[s12+1];
	            String[] valuetext12b=new String[s12+1];
				for (int m = 0; m < arr12.length(); m++)
				{
					long productId = arr12.getJSONObject(m).getLong("productId");
				    String quoteCode = arr12.getJSONObject(m).getString("quoteCode");
				    String priorSettle = arr12.getJSONObject(m).getString("priorSettle");
				    String last = arr12.getJSONObject(m).getString("last");
				    String title = arr12.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr12[m]=quoteCode;
				    idattr12b[m]=title;
				    valuetext12[m]=priorSettle;
				    valuetext12b[m]=last;
				}
				
				
				String url13="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/331/G";
				 JSONObject json13 = new JSONObject(IOUtils.toString(new URL(url13), Charset.forName("UTF-8")));
	          String myjsonstr13=json13.toString();
			     String filepath13="/home/phcuaz/Desktop/finance/oats_future_json.txt";
			     
		         BufferedWriter out13 = new BufferedWriter(new FileWriter(filepath13));
		         out13.write(myjsonstr13);
		         out13.close();
				
				 JSONObject obj13 = new JSONObject(myjsonstr13);
			
				JSONArray arr13 = obj13.getJSONArray("quotes");
				int s13=arr13.length();
				String[] idattr13=new String[s13+1];
	            String[] valuetext13=new String[s13+1];
	            String[] idattr13b=new String[s13+1];
	            String[] valuetext13b=new String[s13+1];
				for (int m = 0; m < arr13.length(); m++)
				{
					long productId = arr13.getJSONObject(m).getLong("productId");
				    String quoteCode = arr13.getJSONObject(m).getString("quoteCode");
				    String priorSettle = arr13.getJSONObject(m).getString("priorSettle");
				    String last = arr13.getJSONObject(m).getString("last");
				    String title = arr13.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr13[m]=quoteCode;
				    idattr13b[m]=title;
				    valuetext13[m]=priorSettle;
				    valuetext13b[m]=last;
				}
				
				String url15="http://www.cmegroup.com/CmeWS/mvc/Quotes/Future/323/G";
				 JSONObject json15 = new JSONObject(IOUtils.toString(new URL(url15), Charset.forName("UTF-8")));
	         String myjsonstr15=json15.toString();
			     String filepath15="/home/phcuaz/Desktop/finance/wheat_future_json.txt";
			     
		         BufferedWriter out15 = new BufferedWriter(new FileWriter(filepath15));
		         out15.write(myjsonstr15);
		         out15.close();
				
				 JSONObject obj15 = new JSONObject(myjsonstr15);
			
				JSONArray arr15 = obj15.getJSONArray("quotes");
				int s15=arr15.length();
				String[] idattr15=new String[s15+1];
	           String[] valuetext15=new String[s15+1];
	           String[] idattr15b=new String[s15+1];
	           String[] valuetext15b=new String[s15+1];
				for (int m = 0; m < arr15.length(); m++)
				{
					long productId = arr15.getJSONObject(m).getLong("productId");
				    String quoteCode = arr15.getJSONObject(m).getString("quoteCode");
				    String priorSettle = arr15.getJSONObject(m).getString("priorSettle");
				    String last = arr15.getJSONObject(m).getString("last");
				    String title = arr15.getJSONObject(m).getJSONObject("priceChart").getString("title");
				    System.out.println("productId="+productId+" quoteCode="+quoteCode+" title="+title+" priorSettle="+priorSettle+" last="+last);
				    idattr15[m]=quoteCode;
				    idattr15b[m]=title;
				    valuetext15[m]=priorSettle;
				    valuetext15b[m]=last;
				}
				
				String tabledate="";
				Calendar cal = Calendar.getInstance();
				int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
				int Month = cal.get(Calendar.MONTH)+1;
				int Year = cal.get(Calendar.YEAR);
				
				String zero="0";	
				String stringdayofmonth="";
				String stringmonth="";
				if (dayOfMonth<10){stringdayofmonth=zero+String.valueOf(dayOfMonth);}
				if(dayOfMonth>9){stringdayofmonth=String.valueOf(dayOfMonth);}
				if(Month<10){stringmonth=zero+String.valueOf(Month);}
				if(Month>9){stringmonth=String.valueOf(Month);}
				tabledate=stringdayofmonth+stringmonth+String.valueOf(Year);
				
				String databasename="";
				databasename="postgres";
				String url    = "jdbc:postgresql://localhost:5432/"+databasename;
				String username = "postgres";  
		        String password="postgres";
		        Class.forName("org.postgresql.Driver");
				Connection conn=DriverManager.getConnection(url,username,password);
				Statement stat=conn.createStatement();
				boolean databasexistflag;
				ResultSet result1;
				//1
				databasexistflag=false;
				databasename="ff2plustrade";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//24
						databasexistflag=false;
						databasename="ff2plustradeb";
						result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
						while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
						if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//2
				databasexistflag=false;
				databasename="ff2boomspread";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//3
				databasexistflag=false;
				databasename="ff2beefsandwich";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//4
				databasexistflag=false;
				databasename="ff2coopercoup";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//5
				databasexistflag=false;
				databasename="ff2cottonconnection";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//6
				databasexistflag=false;
				databasename="ff2hamsandwich";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//7
				databasexistflag=false;
				databasename="ff2insuredgsrtradeg";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//8
				databasexistflag=false;
				databasename="ff2insuredgsrtrades";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//9
				databasexistflag=false;
				databasename="ff2multimarkmaneuver";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//10
				databasexistflag=false;
				databasename="ff2petroparlay";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//11
				databasexistflag=false;
				databasename="ff2quicksilverquest";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//12
				databasexistflag=false;
				databasename="ff2sacerealtradew";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//13
				databasexistflag=false;
				databasename="ff2sacerealtradec";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//14
				databasexistflag=false;
				databasename="ff2silverbutterfly";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//15
				databasexistflag=false;
				databasename="ff2superbeantrade";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//16
				databasexistflag=false;
				databasename="ff2sweetseasonal";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//17
				databasexistflag=false;
				databasename="ff2tedspreaded";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//18
				databasexistflag=false;
				databasename="ff2tedspreadtn";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//19
				databasexistflag=false;
				databasename="ff2timetactica";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//20
				databasexistflag=false;
				databasename="ff2timetacticb";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//21
				databasexistflag=false;
				databasename="ff2totalmarkettactic";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//22
				databasexistflag=false;
				databasename="ff2tripletbondtrade";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				//23
				databasexistflag=false;
				databasename="ff2wildoatswindfall";
				result1=stat.executeQuery("select datname from pg_database where datname like '"+databasename+"'");
				while(result1.next()){if(databasename.equalsIgnoreCase(result1.getString(1))){databasexistflag=true;};}
				if(databasexistflag==false){stat.executeUpdate("CREATE DATABASE "+databasename);}
				
				
				
				databasename="ff2plustrade";// sugar 11
				String driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				String tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    String scmd1="";
			    String scmd2="";
			    String scmd3="";
			    String scmd4="";
			    String rescmd3="";
			    String rescmd4="";
			    String res2cmd4="";
				String res1cmd3="";
				for(int i=0;i<s1;i++)
			    {
			    scmd1=idattr1[i];
			    scmd2=idattr2[i];
			    scmd3=valuetext1[i];
			    scmd4=valuetext2[i];
			    if(scmd3.length()>9){rescmd3 = scmd3.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4 = scmd4.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}	    
				if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				ResultSet result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				databasename="ff2boomspread";//soybean
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s3;i++)
			    {
			    scmd1=idattr3[i];
			    scmd2=idattr3b[i];
			    scmd3=valuetext3[i];
			    scmd4=valuetext3b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				
				databasename="ff2beefsandwich"; //live cattle
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s4;i++)
			    {
			    scmd1=idattr4[i];
			    scmd2=idattr4b[i];
			    scmd3=valuetext4[i];
			    scmd4=valuetext4b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				databasename="ff2coopercoup";  //copper
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s7;i++)
			    {
			    scmd1=idattr7[i];
			    scmd2=idattr7b[i];
			    scmd3=valuetext7[i];
			    scmd4=valuetext7b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				
				databasename="ff2cottonconnection";  //cotton
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s5;i++)
			    {
			    scmd1=idattr5[i];
			    scmd2=idattr5b[i];
			    scmd3=valuetext5[i];
			    scmd4=valuetext5b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				databasename="ff2hamsandwich";  //lean_hogs
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s6;i++)
			    {
			    scmd1=idattr6[i];
			    scmd2=idattr6b[i];
			    scmd3=valuetext6[i];
			    scmd4=valuetext6b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				databasename="ff2insuredgsrtradeg";  //gold_
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s8;i++)
			    {
			    scmd1=idattr8[i];
			    scmd2=idattr8b[i];
			    scmd3=valuetext8[i];
			    scmd4=valuetext8b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				databasename="ff2insuredgsrtrades";  // silver
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s9;i++)
			    {
			    scmd1=idattr9[i];
			    scmd2=idattr9b[i];
			    scmd3=valuetext9[i];
			    scmd4=valuetext9b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				databasename="ff2petroparlay";  // crude oil
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s10;i++)
			    {
			    scmd1=idattr10[i];
			    scmd2=idattr10b[i];
			    scmd3=valuetext10[i];
			    scmd4=valuetext10b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				databasename="ff2sacerealtradec";  // corn
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s14;i++)
			    {
			    scmd1=idattr14[i];
			    scmd2=idattr14b[i];
			    scmd3=valuetext14[i];
			    scmd4=valuetext14b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				databasename="ff2tedspreaded";  // euro dollars
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s11;i++)
			    {
			    scmd1=idattr11[i];
			    scmd2=idattr11b[i];
			    scmd3=valuetext11[i];
			    scmd4=valuetext11b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				
				databasename="ff2tripletbondtrade";  // 10yearTnote
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s12;i++)
			    {
			    scmd1=idattr12[i];
			    scmd2=idattr12b[i];
			    scmd3=valuetext12[i];
			    scmd4=valuetext12b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				
				databasename="ff2wildoatswindfall";  // oats
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s13;i++)
			    {
			    scmd1=idattr13[i];
			    scmd2=idattr13b[i];
			    scmd3=valuetext13[i];
			    scmd4=valuetext13b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				
				databasename="ff2sacerealtradew";  //  wheat
				driver = "org.postgresql.Driver";
				Class.forName(driver);
				url    = "jdbc:postgresql://localhost:5432/"+databasename;
				username = "postgres";
				password = "postgres";            // Change it to your Password	
				conn=DriverManager.getConnection(url,username,password);
				stat=conn.createStatement();	
				tablename="";	
				tablename=databasename+tabledate;
			    stat.executeUpdate("CREATE TABLE IF NOT EXISTS "+tablename+" (quoteCode CHAR(10),Title CHAR(30),priorSettle CHAR(10),Last CHAR(10))");   
			    scmd1="";
			    scmd2="";
			    scmd3="";
			    scmd4="";
			    rescmd3="";
			    rescmd4="";
			    res1cmd3="";
			    res2cmd4="";
			 //   System.out.println("lim="+s3);
			    for(int i=0;i<s15;i++)
			    {
			    scmd1=idattr15[i];
			    scmd2=idattr15b[i];
			    scmd3=valuetext15[i];
			    scmd4=valuetext15b[i];
			    if(scmd3.length()>9){rescmd3=scmd1.substring(0, 9);}else{rescmd3=scmd3;}
			    if(scmd4.length()>9){rescmd4=scmd2.substring(0, 9);}else{rescmd4=scmd4;}
			    if(rescmd3.contains("'")){res1cmd3=rescmd3.replace("'","''");}else{res1cmd3=rescmd3;}
			    if(rescmd4.contains("'")){res2cmd4=rescmd4.replace("'","''");}else{res2cmd4=rescmd4;}
			    if(res1cmd3.isEmpty()){res1cmd3="empty";}
			    if(res2cmd4.isEmpty()){res2cmd4="empty";}  
			  //  System.out.println(" 1 "+scmd1+" 2 "+scmd2+" 3 "+res1cmd3+" 4 "+res2cmd4);
			    String cmd="INSERT INTO "+tablename+" (quoteCode,Title,priorSettle,Last) VALUES ('"+scmd1+"','"+scmd2+"','"+res1cmd3+"','"+res2cmd4+"');"; 
			    stat.executeUpdate(cmd);
			    }
				result=stat.executeQuery("SELECT * FROM "+tablename);
				while(result.next())
				{
					System.out.println(result.getString(1).trim()+" "+ result.getString(2).trim()+" "+ result.getString(3).trim()+" "+ result.getString(4).trim());
				}
				result.close();
				result1.close();
				conn.close();
				}
				catch(Exception e) {e.getMessage();e.printStackTrace();}
		
		}
	}
}
