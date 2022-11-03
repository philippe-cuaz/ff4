
package tracker;         

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
///§§//§§§§/import financefuture3.financefuture3;
//import financefuture3.financefuture3.datawebimporttodatabase;
//import financefuture3.financefuture3.mytimedata;


public class tracker extends JFrame 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try{
			tracker track = new tracker();
	//	track.creategui();
		track.creategui2();
			}
	    catch(Exception e2){e2.getMessage();e2.printStackTrace();}
	}//main
//	static trackerdatainput21072016 x=new trackerdatainput21072016();
	static Timer timer;	
	int row=0;
	int order=1;
	int selectedorder=0;
	boolean flagbear=false;
	boolean flagbull=false;
	boolean flagcurrent=false;
	boolean flagstrike=false;
	boolean flagpremium=false;
	boolean flaginthemoney=false;
	boolean flagoutthemoney=false;
	boolean flagatthemoney=false;
	boolean flagmaxlossnotallowed=false;
	boolean flagcreategui=false;
	boolean flagcreategui2=false;
	boolean flag731=true;
	boolean flag943=false;
	float flag732=(float)9.4339811320566038113;
	float flag944=(float)9.8488578017961047217;
	int flagu=0;
	int flag733=1166650940;
	int flag945=2097371669;
	double mystrike=0,myfutureprice=0,mypremium=0,mycurrent=0;
//	String astring1="4d8p98";
//	String astring2="gxxd6";
//	String astring3="ycj3f";
//	String astring4="dv72g";
//    String astring5="mjgg";
//    String astring6="md5rt";
  //  String astring7="4d8p98gxxd6ycj3fdv72gmjgg";
    String astring8="NGQ4cDk4Z3h4ZDZ5Y2ozZmR2NzJnbWpnZw==";
	MyTableModel mtm=new MyTableModel();
	MyString ms=new MyString();
	MyDataBase mdb=new MyDataBase();
	MyFlag mfg=new MyFlag();
	//JComboBox mycombo4=new JComboBox();//DATE mjcb1
	//JComboBox mycombo=new JComboBox();//DATABASE mjcb2
	JComboBox mcb=new JComboBox();//TABLE mjcb3
	JComboBox mjcb3=new JComboBox();//TABLE
	//JComboBox mycombo3=new JComboBox();//TREND mjcb4
	MyString ms2=new MyString();
	JLabel connectlabel=new JLabel();
	MyTable mtb=new MyTable();
	MyString ms3=new MyString();
	JComboBox cbb =new JComboBox();//SYMBOL mjcb6
	JComboBox mjcb6=new JComboBox();//SYMBOL
	MyString ms4=new MyString();
	MyString ms5=new MyString();
	MyString ms6=new MyString();
	JComboBox mcb2=new JComboBox();//VALUES mjcb8
	JComboBox mcb3=new JComboBox();//ORDER  mjcb7
	MySaveTable mst=new MySaveTable();
	JComboBox mycombo2=new JComboBox();//OPERATION mjcb5
	JButton buttonupdate = new JButton("update");  // updatebtn creategui2
	JComboBox mjcb7=new JComboBox();//ORDER
	MyUpdate mu=new MyUpdate();
	JComboBox mjcb9=new JComboBox();//LINE
	csavet cst=new csavet();// function of button savet
	cupdate cud=new cupdate();// function of button update
	buttontracktimerdata bttd=new buttontracktimerdata();
	buttonk bk=new buttonk();
	mytype mt=new mytype();
	
	public class mytimedata  {
		int mytimedatarow;
	public void actionPerformed(){
	    //  datawebimporttodatabase dat=new datawebimporttodatabase();
		//      dat.getdata();
		
		// track (each day: has been taken into account) the 2 lines of reference, one for future and one for option
		// create structure to communicate with track button part
		
		int myrow=mytimedatarow;
		
		
		// option line 
		
		bttd.getdatafromrow(myrow+1);
		System.out.println("option line bttd.getdatafromrow(myrow+1) myrow ="+myrow);
		int line1=bttd.getline();
	    int order1=bttd.getorder();
	    int date1=bttd.getdate();
	    String database1=bttd.getdatabase();
	    System.out.println("bttd.getdatabase database1 ="+database1);
	    String table1=bttd.getbttdtable();
	   // String table1=tmptable1.replace("option","");
	    System.out.println("bttd.getbttdtable table1 ="+table1);
	    String trend1=bttd.gettrend();
	    String operation1=bttd.getoperation();
	    String symbol1=bttd.getbttdsymbol();
	    String track1=bttd.gettrack();
	    String tracktime1=bttd.gettracktime();
	    float futureprice1=bttd.getfutureprice();
	    String futuremonth1=bttd.getfuturemonth();
	    int futureyear1=bttd.getfutureyear();
	    float callprice1=bttd.getcallprice();
	    float putprice1=bttd.getputprice();
	    String optionmonth1=bttd.getoptionmonth();
	    int optionyear1=bttd.getoptionyear();
	    String inoutthemoney1=bttd.getinoutthemoney();
	    float strike1=bttd.getstrike();
	    float price1=bttd.getprice();
	    float premium1=bttd.getpremium();
	    float ratioriskfactor1=bttd.getratioriskfactor();
	    float value1=bttd.getvalue();
	    float profitloss1=bttd.getprofitloss();
	    float no1=bttd.getno();
	    float totalpl1=bttd.gettotalpl();
	    
	    
	    // future line 
	    
	    bttd.getdatafromrow(myrow);
	    System.out.println("future line bttd.getdatafromrow(myrow) myrow ="+myrow);
		int line2=bttd.getline();
	    int order2=bttd.getorder();
	    int date2=bttd.getdate();
	    String database2=bttd.getdatabase();
	    System.out.println("bttd.getdatabase database2 ="+database2);
	    String table2=bttd.getbttdtable();
	    System.out.println("bttd.getbttdtable table2 ="+table2);
	    String trend2=bttd.gettrend();
	    String operation2=bttd.getoperation();
	    String symbol2=bttd.getbttdsymbol();
	    String track2=bttd.gettrack();
	    String tracktime2=bttd.gettracktime();
	    float futureprice2=bttd.getfutureprice();
	    String futuremonth2=bttd.getfuturemonth();
	    int futureyear2=bttd.getfutureyear();
	    float callprice2=bttd.getcallprice();
	    float putprice2=bttd.getputprice();
	    String optionmonth2=bttd.getoptionmonth();
	    int optionyear2=bttd.getoptionyear();
	    String inoutthemoney2=bttd.getinoutthemoney();
	    float strike2=bttd.getstrike();
	    float price2=bttd.getprice();
	    float premium2=bttd.getpremium();
	    float ratioriskfactor2=bttd.getratioriskfactor();
	    float value2=bttd.getvalue();
	    float profitloss2=bttd.getprofitloss();
	    float no2=bttd.getno();
	    float totalpl2=bttd.gettotalpl();
	    
	    // each day do it again (display/store in track table the data for selected order) 
	    int mylastrow=bttd.getlastrow();
	    int myorder=order1;
	    String myday=bttd.gettodaysdate();
	    String mysymbol=symbol2;
	    Float myfutureprice=futureprice2;
	    System.out.println("myfuturetable before adjust table2 ="+table2);
	    String myfuturetable=bttd.tableadjustday(table2,myday);
	    System.out.println("myfuturetable ="+myfuturetable);
	    String myfuturedatabase=database2;
	    System.out.println("myoptiontable before adjust table1 ="+table1);
	    String myoptiontable=bttd.tableadjustday(table1,myday);
	    System.out.println("myoptiontable ="+myoptiontable);
	    String myoptiondatabase=database1;
	    
	    // use/create 2 Classes (future,option) to pass  most of the data, else data is passed as parameters
	    
	    myfuture mf=new myfuture();
	    myoption mo=new myoption();
	    
	    mf.settrend(trend2);
	    mf.setoperation(operation2);
	    mf.settrack(track2);
	    mf.settracktime(tracktime2);
	    mf.setfutureprice(futureprice2);
	    mf.setfuturemonth(futuremonth2);
	    mf.setfutureyear(futureyear2);
	    
	    mo.settrend(trend1);
	    mo.setoperation(operation1);
	    mo.setmosymbol(symbol1);
	    mo.settrack(track1);
	    mo.settracktime(tracktime1);
	    mo.setcallprice(callprice1);
	    mo.setputprice(putprice1);
	    mo.setoptionmonth(optionmonth1);
	    mo.setoptionyear(optionyear1);
	    mo.setinoutthemoney(inoutthemoney1);
	    mo.setstrike(strike1);
	    mo.setprice(price1);
	    mo.setpremium(premium1);
	    mo.setratioriskfactor(ratioriskfactor1);
	    mo.setvalue(value1);
	    mo.setprofitloss(profitloss1);
	    mo.setno(no1);
	    mo.settotalpl(totalpl1);
	    
	    System.out.println(mylastrow+" "+myorder+" "+myday+" "+mysymbol+" "+myfutureprice+" "+myfuturetable+" "+myfuturedatabase+" "+myoptiontable+" "+myoptiondatabase);
	    bttd.storenewdata(mf,mo, mylastrow,myorder,myday,mysymbol,myfutureprice,myfuturetable, myfuturedatabase, myoptiontable, myoptiondatabase);
	    
	    
		}
		
	}
	private void creategui2()
	{
	try{
	        flagcreategui2=true;
	        flagcreategui=false;
	        this.setTitle("Finance Databases Tracker");
		    this.setSize(1210, 690);	  
		    mtm.setdata(0, 0, "");
		    JTable table = new JTable(mtm);
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	   
		    table.setFillsViewportHeight(true);
		    JScrollPane scrollPaneTable = new JScrollPane(table);
		    JPanel panel = new JPanel();
		    panel.setLayout(new SpringLayout());	    
		    int x2=100,y2=10,xwidth2=1010,ywidth2=200;	   
		    panel.add(scrollPaneTable,new SpringLayout.Constraints(Spring.constant(x2),Spring.constant(y2),Spring.constant(xwidth2),Spring.constant(ywidth2)));
		    int x3=1110,y3=10,xwidth3=90,ywidth3=30;
		    panel.add(new JButton("20"), new SpringLayout.Constraints(Spring.constant(x3),Spring.constant(y3),Spring.constant(xwidth3),Spring.constant(ywidth3)));
		    int x4=1110,y4=60,xwidth4=90,ywidth4=30;
		    panel.add(new JButton("19"), new SpringLayout.Constraints(Spring.constant(x4),Spring.constant(y4),Spring.constant(xwidth4),Spring.constant(ywidth4)));
		    int x5=1110,y5=110,xwidth5=90,ywidth5=30;
		    panel.add(new JButton("18"), new SpringLayout.Constraints(Spring.constant(x5),Spring.constant(y5),Spring.constant(xwidth5),Spring.constant(ywidth5)));
		    int x=1110,y=160,xwidth=90,ywidth=30;
		    panel.add(new JButton("17"), new SpringLayout.Constraints(Spring.constant(x),Spring.constant(y),Spring.constant(xwidth),Spring.constant(ywidth)));
		    int x1=1110,y1=210,xwidth1=90,ywidth1=30;
		    JButton printbtn=new JButton("print");
		    printbtn.addActionListener(
			        new ActionListener() 
			        {
			        public void actionPerformed(ActionEvent e) 
			        {
			        	if(flagu==flag733)
			        	{
			        cprint cp=new cprint();
			        cp.print();
			        	}
			        }          
			        }
			        );
		    panel.add(printbtn, new SpringLayout.Constraints(Spring.constant(x1),Spring.constant(y1),Spring.constant(xwidth1),Spring.constant(ywidth1)));
		    int x6=1010,y6=210,xwidth6=90,ywidth6=30;
		    JButton erasebtn=new JButton("erase");
		    erasebtn.addActionListener(
		    new ActionListener() 
		 	{
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		if(flagu==flag733)
	        	{
		 		int m=row;
		 		String empty="";
		 		mtm.setdata(m,0,empty);
	        	mtm.fireTableCellUpdated(m, 0);
				
				mtm.setdata(m,1,empty);
	        	mtm.fireTableCellUpdated(m, 1);
			
				mtm.setdata(m,2,empty);
	        	mtm.fireTableCellUpdated(m, 2);
				
				mtm.setdata(m,3,empty);
	        	mtm.fireTableCellUpdated(m, 3);
				
				mtm.setdata(m,4,empty);
	        	mtm.fireTableCellUpdated(m, 4);
			
				mtm.setdata(m,5,empty);
	        	mtm.fireTableCellUpdated(m, 5);
				
				mtm.setdata(m,6,empty);
	        	mtm.fireTableCellUpdated(m, 6);
			
				mtm.setdata(m,7,empty);
	        	mtm.fireTableCellUpdated(m, 7);
				
				mtm.setdata(m,8,empty);
	        	mtm.fireTableCellUpdated(m, 8);
		
				mtm.setdata(m,9,empty);
	        	mtm.fireTableCellUpdated(m, 9);
				
				mtm.setdata(m,10,empty);
	        	mtm.fireTableCellUpdated(m, 10);
				
				mtm.setdata(m,11,empty);
	        	mtm.fireTableCellUpdated(m, 11);
			
				mtm.setdata(m,12,empty);
	        	mtm.fireTableCellUpdated(m, 12);
	        	
	        	mtm.setdata(m,13,empty);
	        	mtm.fireTableCellUpdated(m, 13);
	        	
	        	mtm.setdata(m,14,empty);
	        	mtm.fireTableCellUpdated(m, 14);
	        	
	        	mtm.setdata(m,15,empty);
	        	mtm.fireTableCellUpdated(m, 15);
	        	
	        	mtm.setdata(m,16,empty);
	        	mtm.fireTableCellUpdated(m, 16);
	        	
	        	mtm.setdata(m,17,empty);
	        	mtm.fireTableCellUpdated(m, 17);
	        	
	        	mtm.setdata(m,18,empty);
	        	mtm.fireTableCellUpdated(m, 18);
	        	
	        	mtm.setdata(m,19,empty);
	        	mtm.fireTableCellUpdated(m, 19);
	        	
	        	mtm.setdata(m,20,empty);
	        	mtm.fireTableCellUpdated(m, 20);
	        	
	        	mtm.setdata(m,21,empty);
	        	mtm.fireTableCellUpdated(m, 21);
	        	
	        	mtm.setdata(m,22,empty);
	        	mtm.fireTableCellUpdated(m, 22);
	        	
	        	mtm.setdata(m,23,empty);
	        	mtm.fireTableCellUpdated(m, 23);
	        	
	        	mtm.setdata(m,24,empty);
	        	mtm.fireTableCellUpdated(m, 24);   
	        	
	        	mtm.setdata(m,25,empty);
	        	mtm.fireTableCellUpdated(m, 25);   
	        	}
		 	}          
		 	}
		 	);		
		    panel.add(erasebtn, new SpringLayout.Constraints(Spring.constant(x6),Spring.constant(y6),Spring.constant(xwidth6),Spring.constant(ywidth6)));
		    int x7=10,y7=210,xwidth7=90,ywidth7=30;
		    JButton fivebtn=new JButton("key");
		    fivebtn.addActionListener(
			        new ActionListener() 
			        {
			        public void actionPerformed(ActionEvent e) 
			        {
			         String my=bk.ak();
			         System.out.println("my= "+my);
			         float the=bk.myk(my);
			         System.out.println("the= "+the);
			         bk.k(the);	
			        }          
			        }
			        );
		    panel.add(fivebtn, new SpringLayout.Constraints(Spring.constant(x7),Spring.constant(y7),Spring.constant(xwidth7),Spring.constant(ywidth7)));
		    int x8=110,y8=210,xwidth8=90,ywidth8=30;
		    JButton recaltbtn=new JButton("recalt");
		    recaltbtn.addActionListener(
	        new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {
	        	if(flagu==flag733)
	        	{
	        int myrowcount=mst.restoredata();
	        System.out.println("restored row count="+myrowcount);
	        row=myrowcount;
	        //   statusLabel.setText("Ok Button clicked.");
	        //	mtm.setdata(0,0,mtm.getdate());
	        //	mtm.fireTableCellUpdated(0, 0);
	        	}
	        }          
	        }
	        );
		    panel.add(recaltbtn, new SpringLayout.Constraints(Spring.constant(x8),Spring.constant(y8),Spring.constant(xwidth8),Spring.constant(ywidth8)));
		    int x9=210,y9=210,xwidth9=90,ywidth9=30;
		    JButton savetbtn=new JButton("savet");
		    savetbtn.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {   
	        	if(flagu==flag733)
	        	{
	        	cst.savet();
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );		    
		    panel.add(savetbtn, new SpringLayout.Constraints(Spring.constant(x9),Spring.constant(y9),Spring.constant(xwidth9),Spring.constant(ywidth9)));
		    int x11=10,y11=10,xwidth11=90,ywidth11=30;
		    panel.add(new JButton("1"), new SpringLayout.Constraints(Spring.constant(x11),Spring.constant(y11),Spring.constant(xwidth11),Spring.constant(ywidth11)));
		    int x12=10,y12=60,xwidth12=90,ywidth12=30;
		    panel.add(new JButton("2"), new SpringLayout.Constraints(Spring.constant(x12),Spring.constant(y12),Spring.constant(xwidth12),Spring.constant(ywidth12)));
		    int x13=10,y13=110,xwidth13=90,ywidth13=30;
		    panel.add(new JButton("3"), new SpringLayout.Constraints(Spring.constant(x13),Spring.constant(y13),Spring.constant(xwidth13),Spring.constant(ywidth13)));
		    int x14=10,y14=160,xwidth14=90,ywidth14=30;
		    panel.add(new JButton("4"), new SpringLayout.Constraints(Spring.constant(x14),Spring.constant(y14),Spring.constant(xwidth14),Spring.constant(ywidth14)));
		    JButton mjbtn13=new JButton("nextr");
		    int x15=310,y15=210,xwidth15=90,ywidth15=30;
		    mjbtn13.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {   
	        	if(flagu==flag733)
	        	{
	        row=row+1;
	        mtm.setdata(row-1,0,(String)String.valueOf(row));
	        mtm.fireTableCellUpdated(row-1,0 ); 
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(mjbtn13, new SpringLayout.Constraints(Spring.constant(x15),Spring.constant(y15),Spring.constant(xwidth15),Spring.constant(ywidth15)));
		    int x16=410,y16=210,xwidth16=90,ywidth16=30;
		    JButton prevrbtn=new JButton("prevr");
		    prevrbtn.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {   
	        	if(flagu==flag733)
	        	{
	        row=row-1;
	        if((row-1)<0){row=row+1;}
	        mtm.setdata(row-1,0,(String)String.valueOf(row));
	        mtm.fireTableCellUpdated(row-1,0 ); 
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(prevrbtn, new SpringLayout.Constraints(Spring.constant(x16),Spring.constant(y16),Spring.constant(xwidth16),Spring.constant(ywidth16)));
		    int x17=510,y17=210,xwidth17=90,ywidth17=30;
		    JButton nexorbtn=new JButton("nexor");
		    nexorbtn.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {     
	        	if(flagu==flag733)
	        	{
	        order=order+1;
	        mtm.setdata(row,1,(String)String.valueOf(order));
	        mtm.fireTableCellUpdated(row,1 );   
	        mjcb7.removeAllItems();
	        for(int ii=1;ii<=order;ii++){
			mjcb7.addItem(ii);
	        }
			}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(nexorbtn, new SpringLayout.Constraints(Spring.constant(x17),Spring.constant(y17),Spring.constant(xwidth17),Spring.constant(ywidth17)));
		    int x18=610,y18=210,xwidth18=90,ywidth18=30;
		    JButton trackbtn=new JButton("track");
		    trackbtn.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {   
	        	if(flagu==flag733)
	        	{
	        	System.out.println("start track button");	        	
	        	int myorder=selectedorder;
	        	if (myorder==0){myorder=order;}
	        	System.out.println("myorder="+myorder+" row="+String.valueOf(row));
	        	// myline=getfirstlineoforder(myorder);
	        	// mysymbol=getsymbolname(myline);
	        	// tracksymboleveryday(mysymbol,timelimit);
	        	
	        	
	        	int myposition=8;
	        	String mypositionvalue="yes";
	        	mtm.setdata(row,myposition,(String)mypositionvalue);
	            mtm.fireTableCellUpdated(row,myposition );
	       
	            // track each day the 2 lines of reference, one for future and one for obligation
	            // create a class to communicate with timer part corresponding to row and row-1 data 
	            // fetch data from row
	            // fetch data from row - 1 
	            
	        	 
	            timer = new Timer();
	    	    int delay = 10;
	    	    int onesecond=1000;
	    	    int onehour=3600*onesecond;
	    	    int period = onehour*24;
	    	    TimerTask task = new TimerTask()
	    	    {
	    	     public void run()
	    	     {
	    	    	
	    	    	 mytimedata td=new mytimedata();
	    	    	 td.mytimedatarow=row;
	    	 		 td.actionPerformed();
	    	         System.out.println("bye bye tracker everybody");
	    	     }
	    	    };
	    	    timer.scheduleAtFixedRate(task, delay, period);
	            
	        	System.out.println("stop track button");  
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(trackbtn, new SpringLayout.Constraints(Spring.constant(x18),Spring.constant(y18),Spring.constant(xwidth18),Spring.constant(ywidth18)));
		    //  *UPDATE* 
		    int x20=710,y20=210,xwidth20=90,ywidth20=30;
		    JButton updatebtn=new JButton("update");
		    updatebtn.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {   
	        	if(flagu==flag733)
	        	{
	        cud.update();
	        	}
	        }
	        }
		    );    
		    panel.add(updatebtn, new SpringLayout.Constraints(Spring.constant(x20),Spring.constant(y20),Spring.constant(xwidth20),Spring.constant(ywidth20)));
		    // *CLOSE*
		    int x21=810,y21=210,xwidth21=90,ywidth21=30;
		    JButton closebtn=new JButton("close");
		    closebtn.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {     
	        	if(flagu==flag733)
	        	{
	        String tabledata="";
            System.out.println("max col count="+mtm.getColumnCount());
            int mycol=0;
            mycol=mtm.getColumnCount();
            System.out.println("max row count="+mtm.getRowCount());
            int myrow=0;
            for(int i=0;i<mtm.getRowCount();i++){
            for(int j=0;j<mtm.getColumnCount();j++){
            tabledata=mtm.getdata(i, j);
            if((tabledata!=null)&&(j==0)){myrow++;}
            }
            }
            System.out.println("to be saved myrow count="+myrow);
            System.out.println("to be saved mycolumn count="+mtm.getColumnCount());
            mst.savedata(myrow);
	        // should save the table before exit
	        System.exit(0);
	        	}
	        }
	        }
		    );                
		    panel.add(closebtn, new SpringLayout.Constraints(Spring.constant(x21),Spring.constant(y21),Spring.constant(xwidth21),Spring.constant(ywidth21)));
		    int x22=910,y22=210,xwidth22=90,ywidth22=30;
		    JButton prevorbtn=new JButton("prevor");
		    prevorbtn.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {  
	        	if(flagu==flag733)
	        	{
	        order=order-1;
	        mtm.setdata(row,1,(String)String.valueOf(order));
	        mtm.fireTableCellUpdated(row,1 );   
	        //mjcb7.removeAllItems();
	        // for(int ii=1;ii<=order;ii++){
			//mjcb7.addItem(ii);
			//}
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(prevorbtn, new SpringLayout.Constraints(Spring.constant(x22),Spring.constant(y22),Spring.constant(xwidth22),Spring.constant(ywidth22)));		  
		    int x10=10,y10=260,xwidth10=90,ywidth10=30;           
		    panel.add(new JButton("date"), new SpringLayout.Constraints(Spring.constant(x10),Spring.constant(y10),Spring.constant(xwidth10),Spring.constant(ywidth10)));
		    int x23=10,y23=310,xwidth23=90,ywidth23=30;
		    panel.add(new JButton("dbase"), new SpringLayout.Constraints(Spring.constant(x23),Spring.constant(y23),Spring.constant(xwidth23),Spring.constant(ywidth23)));
		    int x24=10,y24=360,xwidth24=90,ywidth24=30;
		    panel.add(new JButton("table"), new SpringLayout.Constraints(Spring.constant(x24),Spring.constant(y24),Spring.constant(xwidth24),Spring.constant(ywidth24)));
		    int x25=10,y25=410,xwidth25=90,ywidth25=30;
		    panel.add(new JButton("trend"), new SpringLayout.Constraints(Spring.constant(x25),Spring.constant(y25),Spring.constant(xwidth25),Spring.constant(ywidth25)));
		    int x26=10,y26=460,xwidth26=90,ywidth26=30;
		    panel.add(new JButton("operat"), new SpringLayout.Constraints(Spring.constant(x26),Spring.constant(y26),Spring.constant(xwidth26),Spring.constant(ywidth26)));
		    int x27=10,y27=510,xwidth27=90,ywidth27=30;
		    panel.add(new JButton("symbol"), new SpringLayout.Constraints(Spring.constant(x27),Spring.constant(y27),Spring.constant(xwidth27),Spring.constant(ywidth27)));
		    int x48=10,y48=560,xwidth48=90,ywidth48=30;
		    panel.add(new JButton("value"), new SpringLayout.Constraints(Spring.constant(x48),Spring.constant(y48),Spring.constant(xwidth48),Spring.constant(ywidth48)));	   
		    int x28=110,y28=260,xwidth28=250,ywidth28=30;
		    JComboBox mjcb1=new JComboBox();//DATE
		    mjcb1.addItem(mtm.getdate());
		    panel.add(mjcb1, new SpringLayout.Constraints(Spring.constant(x28),Spring.constant(y28),Spring.constant(xwidth28),Spring.constant(ywidth28)));
		    int x29=110,y29=310,xwidth29=250,ywidth29=30;
		    JComboBox mjcb2=new JComboBox();//DATABASE
		    int lim;	   	    
		    ms.setdata();	
		    lim=ms.getlim();	
		    mjcb2.removeAllItems();
		    for(int a=1;a<lim;a++){
		    mjcb2.addItem(ms.getmystr(a).trim());}	
		    mdb.setmydatabase(ms.getmystr(1));
		    panel.add(mjcb2, new SpringLayout.Constraints(Spring.constant(x29),Spring.constant(y29),Spring.constant(xwidth29),Spring.constant(ywidth29)));
		    int x30=110,y30=360,xwidth30=250,ywidth30=30;
		    //JComboBox mjcb3=new JComboBox();//TABLE
		    int lim2;	   			  
			ms2.setdata2(mdb.getmydatabase());	
			lim2=ms2.getlim2();	 
			mjcb3.removeAllItems();
			for(int a=1;a<lim2;a++){
			mjcb3.addItem(ms2.getmystr2(a).trim());			  
			}	    
		    panel.add(mjcb3, new SpringLayout.Constraints(Spring.constant(x30),Spring.constant(y30),Spring.constant(xwidth30),Spring.constant(ywidth30)));
		    int x31=110,y31=410,xwidth31=250,ywidth31=30;
		    JComboBox mjcb4=new JComboBox();//TREND
		    mjcb4.addItem("bullish low price going up");
		    mjcb4.addItem("bearish high price going down");
		    panel.add(mjcb4, new SpringLayout.Constraints(Spring.constant(x31),Spring.constant(y31),Spring.constant(xwidth31),Spring.constant(ywidth31)));
		    int x32=110,y32=460,xwidth32=250,ywidth32=30;
		    JComboBox mjcb5=new JComboBox();//OPERATION
		    if(flagbull==true){
		    mjcb5.removeAllItems();
		    mjcb5.addItem("buy long future");
		    mjcb5.addItem("sell put option");}		    
		    else
		    {
		    mjcb5.removeAllItems();
		    mjcb5.addItem("buy long future");	    
			mjcb5.addItem("sell short future");
			mjcb5.addItem("buy call option");
			mjcb5.addItem("sell put option");
		    }    
		    if(flagbear==true){
		    mjcb5.removeAllItems();
		    mjcb5.addItem("sell short future");
		    mjcb5.addItem("buy call option");  
		    }
		    else
		    {
		    mjcb5.removeAllItems();
		    mjcb5.addItem("buy long future");	    
			mjcb5.addItem("sell short future");
			mjcb5.addItem("buy call option");
			mjcb5.addItem("sell put option");	
		    }	  
		    panel.add(mjcb5, new SpringLayout.Constraints(Spring.constant(x32),Spring.constant(y32),Spring.constant(xwidth32),Spring.constant(ywidth32)));
		    int x33=110,y33=510,xwidth33=250,ywidth33=30;
		    //   JComboBox mjcb6=new JComboBox();//SYMBOL
		    int lim3;
		    ms3.setdata3();
		    lim3=ms3.getlim3();
		    mjcb6.removeAllItems();
		    String choice=(String)mjcb5.getSelectedItem();           	    
		    if(choice==null){choice="buy long future";}
		    System.out.println("choice="+choice);
		    switch(choice)
		    {
		    case "buy long future":
		    case "sell short future":
		    for(int d=1;d<lim3;d++){
		    if(ms3.getmystr3(d)!=null){
		    mjcb6.addItem(ms3.getmystr3(d).trim());}}
		    break;
		    case "buy call option":
		    case "sell put option":
		    mjcb6.addItem("strike");
		    mjcb6.addItem("high");
		    mjcb6.addItem("low");
		    mjcb6.addItem("current");
		    mjcb6.addItem("change");
		    mjcb6.addItem("volume");
		    mjcb6.addItem("time");
		    mjcb6.addItem("premium");
		    break;
		    default: break;	    	
		    }
		    try{
		    mjcb6.setSelectedIndex(2);
		    }
		    catch(Exception ex6){ex6.getMessage();ex6.getStackTrace();System.out.println("posgresql.jar might be missing from eclipse java build path libraries");}		   
		    panel.add(mjcb6, new SpringLayout.Constraints(Spring.constant(x33),Spring.constant(y33),Spring.constant(xwidth33),Spring.constant(ywidth33)));
		    int x49=110,y49=560,xwidth49=250,ywidth49=30;
		    JComboBox mjcb8=new JComboBox();//VALUES
		    int lim5;
		    ms5.setdata5();
		    lim5=ms5.getlim5();
		    mjcb8.removeAllItems();
		    for(int f=1;f<=lim5;f++){
		    if(ms5.getmystr5(f)!=null){
		    mjcb8.addItem(ms5.getmystr5(f).trim());}
		    }
		    panel.add(mjcb8, new SpringLayout.Constraints(Spring.constant(x49),Spring.constant(y49),Spring.constant(xwidth49),Spring.constant(ywidth49)));	  
		    JButton mjbtn1=new JButton("connect");//DATABASE
		    int x34=370,y34=310,xwidth34=90,ywidth34=30;
		    mjbtn1.addActionListener(
	        new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {    
	        	if(flagu==flag733)
	        	{
	        System.out.println("start connect button");
	        System.out.println("connect button 1");
	        mdb.setmydatabase((String)mjcb2.getSelectedItem());
	        System.out.println("database="+mdb.getmydatabase());
	        System.out.println("connect button 2");
	        mtm.connect(mdb.getmydatabase());
	        System.out.println("connect button 3");
	        System.out.println("stop connect button");
	        	}
	        }          
	        }
	        );
		    panel.add(mjbtn1, new SpringLayout.Constraints(Spring.constant(x34),Spring.constant(y34),Spring.constant(xwidth34),Spring.constant(ywidth34)));
		    JButton mjbtn2=new JButton("select");//TABLE
		    int x35=370,y35=360,xwidth35=90,ywidth35=30;
		    mjbtn2.addActionListener(
	        new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	if(flagu==flag733)
	        	{
		    System.out.println("start table select ");
		    mtb.setmytable((String)mjcb3.getSelectedItem());
		    System.out.println("table selected item="+mtb.getmytable());
		    mfg.setmyflag("");
		    connectlabel.setText(mfg.getmyflag());
		    mtb.getattributeid(mtb.getmytable());
		    //MyString ms4=new MyString();
		    int lim3=ms4.getlim4();
		    //JComboBox mjcb6=new JComboBox();//SYMBOL
		    mjcb6.removeAllItems();
		    for(int d=1;d<lim3;d++){
		    if(ms4.getmystr4(d)!=null){
		    mjcb6.addItem(ms4.getmystr4(d).trim());}	}
		    System.out.println("stop table select ");
	        	}
		    }          
		    }
		    );
		    panel.add(mjbtn2, new SpringLayout.Constraints(Spring.constant(x35),Spring.constant(y35),Spring.constant(xwidth35),Spring.constant(ywidth35)));
		    JButton mjbtn3=new JButton("select");//TREND
		    int x36=370,y36=410,xwidth36=90,ywidth36=30;
		    mjbtn3.addActionListener(
	        new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	if(flagu==flag733)
	        	{
		    System.out.println("start trend select ");
		    String item2=(String)mjcb4.getSelectedItem();
		    System.out.println("trend="+item2);
		    if(item2.contentEquals("bullish low price going up")){flagbull=true;}
		    if(item2.contentEquals("bearish high price going down")){flagbear=true;}
		    System.out.println("flagbull="+flagbull);
		    System.out.println("flagbear="+flagbear);
		    if(flagbull==true){
		    System.out.println("flagbull==true");
		    mjcb5.removeAllItems();
		    mjcb5.addItem("buy long future");
		    mjcb5.addItem("sell put option");}     	
		    if(flagbear==true){
		    System.out.println("flagbear==true");
		    mjcb5.removeAllItems();
		    mjcb5.addItem("sell short future");
		    mjcb5.addItem("buy call option");}   		   
		    System.out.println("stop trend select ");
	        	}
		    }          
		    }
		    );
		    panel.add(mjbtn3, new SpringLayout.Constraints(Spring.constant(x36),Spring.constant(y36),Spring.constant(xwidth36),Spring.constant(ywidth36)));
		    JButton mjbtn4=new JButton("select");//OPERATION
		    int x37=370,y37=460,xwidth37=90,ywidth37=30;
		    mjbtn4.addActionListener(
	        new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	if(flagu==flag733)
	        	{
		    System.out.println("start select operation");
		    String myitem2=(String) mjcb5.getSelectedItem();
		    // ms5.setmystr5(1,myitem);
    		ms6.setmystr6(1,myitem2); 		           
    		int lim3;
    	    ms3.setdata3();
    	    lim3=ms3.getlim3();
    	    mjcb6.removeAllItems();
    	    String choice=(String)mjcb5.getSelectedItem();           
    		System.out.println("choice="+choice);
    		switch(choice)
    		{
    		case "buy long future":
    		case "sell short future":
    		for(int d=1;d<lim3;d++){
    		if(ms3.getmystr3(d)!=null){
    		mjcb6.addItem(ms3.getmystr3(d).trim());}}
    		break;
    		case "buy call option":
    		case "sell put option":
    		mjcb6.addItem("strike");
    		mjcb6.addItem("high");
    		mjcb6.addItem("low");
    		mjcb6.addItem("current");
    		mjcb6.addItem("change");
    		mjcb6.addItem("volume");
    		mjcb6.addItem("time");
    		mjcb6.addItem("premium");
    		break;
    		default: break;	    	
    		}
    		try{
    		mjcb6.setSelectedIndex(2);
    		}
    		catch(Exception ex6){ex6.getMessage();ex6.getStackTrace();System.out.println("posgresql.jar might be missing from eclipse java build path libraries");}	    
		    System.out.println("stop select operation");
	        	}
		    }          
		    }
		    );
		    panel.add(mjbtn4, new SpringLayout.Constraints(Spring.constant(x37),Spring.constant(y37),Spring.constant(xwidth37),Spring.constant(ywidth37)));
		    JButton mjbtn5=new JButton("select");//SYMBOL
		    /* */
		    mjbtn5.addActionListener(new ActionListener() 
		    //    button3.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {
	        	if(flagu==flag733)
	        	{
	        System.out.println("start symbol select");
	        String myitem=(String)mjcb6.getSelectedItem();
	        // String myitem=(String) cbb.getSelectedItem();
	        System.out.println("symbol selected item="+myitem);
	        String mycolumn="",mytablename="",mycolumn2="",doublecolumn="";
	        switch((String) mjcb5.getSelectedItem())
	        //switch((String) mycombo2.getSelectedItem())
	        {
	        case "buy long future":
	        case "sell short future":
	        ms5.setmystr5(1,myitem);
		    ms5.setdata5();
		    int lim5=ms5.getlim5();
		    mjcb8.removeAllItems(); 
	        //mcb2.removeAllItems();
	 		for(int g=1;g<lim5;g++)
	 		{
	 		if(ms5.getmystr5(g)!=null)
	 		{
	 		mjcb8.addItem(ms5.getmystr5(g).trim());
	 		// mcb2.addItem(ms5.getmystr5(g).trim());
	 		}	
	 		}
	        break;
	        case "buy call option":
	        //select * from ff2plustradeboption1862016 where strike ilike '%c%';
	        ms5.setmystr7(1,myitem);
	        mycolumn=myitem;
	        mytablename=mtb.getmytable();
	        ms5.setdata7(mycolumn,mytablename);
	        mjcb8.removeAllItems();
	        // mcb2.removeAllItems();
	        int lim7=ms5.getlim7();
	        for(int g=1;g<lim7;g++)
		    {
		    if(ms5.getmystr7(g)!=null)
		    {
		    //doublecolumn=ms5.getmystr7a(g).trim()+ms5.getmystr7(g).trim();
		    mjcb8.addItem(ms5.getmystr7(g).trim());		 
		    //  mcb2.addItem(ms5.getmystr7(g).trim());
		    }	
		    }
	        break;
	        case "sell put option":
	        //select * from ff2plustradeboption1862016 where strike ilike '%p%';
	        ms5.setmystr8(1,myitem);
	        mycolumn=myitem;
	        mycolumn2="strike";
	        mytablename=mtb.getmytable();
	        ms5.setdata8(mycolumn,mycolumn2,mytablename); 
	        mjcb8.removeAllItems();
	        // mcb2.removeAllItems();
	        int lim8=ms5.getlim8();
	        for(int g=1;g<lim8;g++)
		 	{
		 	if(ms5.getmystr8(g)!=null)
		 	{
		 	//c.ipadx=1;
		    doublecolumn=ms5.getmystr8(g).trim()+" "+ms5.getmystr8a(g).trim();
		 	if(doublecolumn.length()>20){doublecolumn="";}
		 	mjcb8.addItem(doublecolumn.trim());	
		    // mcb2.addItem(doublecolumn.trim()); 
		 	}	
		 	}
	        break;
	        default:break;
	        }   
	        //  	mtm.setdata(0,1,(String)cbb.getSelectedItem());
	        //mtm.fireTableCellUpdated(0, 1);
 		    System.out.println("stop symbol select");
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
	        //    c.gridx=2;
	        //    c.gridy=6;
	        //      c.ipadx=18;
	        //     panel.add(button3,c);
	        /*	     */
		    int x38=370,y38=510,xwidth38=90,ywidth38=30;
		    /*
		    mjbtn5.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {
		    System.out.println("start select symbol");
		    //int x38=310,y38=510,xwidth38=90,ywidth38=30;
		    int lim4;
		    ms3.setdata3();
		    lim4=ms3.getlim3();
		    mjcb6.removeAllItems();
		    String choice2=(String)mjcb5.getSelectedItem();           	    
		    if(choice2==null){choice2="buy long future";}
		    System.out.println("choice="+choice2);
		    switch(choice2)
		    {
		    case "buy long future":
		    case "sell short future":
		    for(int d=1;d<lim4;d++){
		    if(ms3.getmystr3(d)!=null){
		    mjcb6.addItem(ms3.getmystr3(d).trim());}}
		    break;
		    case "buy call option":
		    case "sell put option":
		    mjcb6.addItem("strike");
		    mjcb6.addItem("high");
		    mjcb6.addItem("low");
		    mjcb6.addItem("current");
		    mjcb6.addItem("change");
		    mjcb6.addItem("volume");
		    mjcb6.addItem("time");
		    mjcb6.addItem("premium");
		    break;
		    default: break;	    	
		    }
		    try{
		    mjcb6.setSelectedIndex(2);
		    }
		    catch(Exception ex6){ex6.getMessage();ex6.getStackTrace();System.out.println("posgresql.jar might be missing from eclipse java build path libraries");}	   
		    //System.out.println("select mjbtn5");
		    System.out.println("stop select symbol");
	        }});
	        */
		    panel.add(mjbtn5, new SpringLayout.Constraints(Spring.constant(x38),Spring.constant(y38),Spring.constant(xwidth38),Spring.constant(ywidth38)));
		    JButton mjbtn6=new JButton("save");
		    int x39=470,y39=260,xwidth39=90,ywidth39=30;//DATE
		    mjbtn6.addActionListener(
	        new ActionListener()
            {
	        public void actionPerformed(ActionEvent e)
	        {    
	        	if(flagu==flag733)
	        	{
	        mtm.setdata(row,2,mtm.getdate());
	        mtm.fireTableCellUpdated(row, 2);
	        	}
	        }          
	        }
	        );
		    panel.add(mjbtn6, new SpringLayout.Constraints(Spring.constant(x39),Spring.constant(y39),Spring.constant(xwidth39),Spring.constant(ywidth39)));
		    JButton mjbtn7=new JButton("save");
		    int x40=470,y40=310,xwidth40=90,ywidth40=30;//DATABASE
		    mjbtn7.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {    
	        	if(flagu==flag733)
	        	{
	        mtm.setdata(row,3,(String)mjcb2.getSelectedItem());
	        mtm.fireTableCellUpdated(row, 3);
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(mjbtn7, new SpringLayout.Constraints(Spring.constant(x40),Spring.constant(y40),Spring.constant(xwidth40),Spring.constant(ywidth40)));
		    int x51=570,y51=310,xwidth51=90,ywidth51=30;
		    // JLabel connectlabel=new JLabel();
	        connectlabel.setText(mfg.getmyflag());         
	        panel.add(connectlabel, new SpringLayout.Constraints(Spring.constant(x51),Spring.constant(y51),Spring.constant(xwidth51),Spring.constant(ywidth51))); 
	        JButton mjbtn8=new JButton("save");
	        int x41=470,y41=360,xwidth41=90,ywidth41=30;//TABLE
	        mjbtn8.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {         
	        	// JComboBox mjcb3=new JComboBox();//TABLE
	        	if(flagu==flag733)
	        	{
	        mtm.setdata(row,4,(String)mjcb3.getSelectedItem());
	        mtm.fireTableCellUpdated(row, 4);
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(mjbtn8, new SpringLayout.Constraints(Spring.constant(x41),Spring.constant(y41),Spring.constant(xwidth41),Spring.constant(ywidth41)));
		    JButton mjbtn9=new JButton("save");
		    int x42=470,y42=410,xwidth42=90,ywidth42=30;//TREND
		    mjbtn9.addActionListener(
	        new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	if(flagu==flag733)
	        	{
		    System.out.println("start trend save ");
		    mtm.setdata(row,5,(String)mjcb4.getSelectedItem());
		    mtm.fireTableCellUpdated(row, 5);         	
		    System.out.println("stop trend save ");
	        	}
		    }          
		    }
		    );
		    panel.add(mjbtn9, new SpringLayout.Constraints(Spring.constant(x42),Spring.constant(y42),Spring.constant(xwidth42),Spring.constant(ywidth42)));
		    JButton mjbtn10=new JButton("save");
		    int x43=470,y43=460,xwidth43=90,ywidth43=30;//OPERATION
		    mjbtn10.addActionListener(
	        new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	if(flagu==flag733)
	        	{
		    System.out.println("save operation");           
		    mtm.setdata(row,6,(String)mjcb5.getSelectedItem());
			mtm.fireTableCellUpdated(row, 6);		
	        	}
		    }          
		    }
		    );
		    panel.add( mjbtn10, new SpringLayout.Constraints(Spring.constant(x43),Spring.constant(y43),Spring.constant(xwidth43),Spring.constant(ywidth43)));
		    JButton mjbtn11=new JButton("save");
		    int x44=470,y44=510,xwidth44=90,ywidth44=30;//SYMBOL
		    mjbtn11.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {      
	        	if(flagu==flag733)
	        	{
	        mtm.setdata(row,7,(String)mjcb6.getSelectedItem());
	        mtm.fireTableCellUpdated(row, 7);
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(mjbtn11, new SpringLayout.Constraints(Spring.constant(x44),Spring.constant(y44),Spring.constant(xwidth44),Spring.constant(ywidth44)));
		    JButton mjbtn12=new JButton("save");
		    int x50=470,y50=560,xwidth50=90,ywidth50=30;//VALUE
		    mjbtn12.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) 
	        {
	        	if(flagu==flag733)
	        	{
	        System.out.println("start save value");
	        String oper=ms6.getmystr6(1);
            String tempstr="";
            String selecteditem="";
            int futurepriceposition=10;
            int callpriceposition=13;
            int putpriceposition=14;
            int strikepriceposition=18;
            int premiumpriceposition=20;
	        switch(oper){
	        case "buy long future":
	        System.out.println("case : buy long future start");
	        tempstr=(String)mjcb8.getSelectedItem();
	        tempstr=tempstr.replace("s","");
		    myfutureprice=Double.parseDouble(tempstr);            	
	        mtm.setdata(row,futurepriceposition,(String)tempstr);
		    mtm.fireTableCellUpdated(row, futurepriceposition);
		    tempstr="";		            	
		    System.out.println("case : buy long future stop");
	        break;
	        case "sell short future":
	        System.out.println("case : sell short future");
	        mtm.setdata(row,futurepriceposition,(String)mjcb8.getSelectedItem());
		    mtm.fireTableCellUpdated(row, futurepriceposition);
	        break;
	        case "buy call option":
	        System.out.println("case : buy call option");
	        mtm.setdata(row,callpriceposition,(String)mjcb8.getSelectedItem());
		    mtm.fireTableCellUpdated(row, callpriceposition);
	        break;
	        case "sell put option":
	        System.out.println("case : sell put option");
	        selecteditem=(String)mjcb8.getSelectedItem();	
	        int index=selecteditem.indexOf('P');
	        selecteditem=selecteditem.substring(index+1);
	        String symbol="";
	        symbol=(String)mjcb6.getSelectedItem();
	        switch(symbol){
	        case "current": 
	        mtm.setdata(row,putpriceposition,(String)selecteditem);
			mtm.fireTableCellUpdated(row,putpriceposition);
			flagcurrent=true;
			tempstr=(String)selecteditem;
			tempstr=tempstr.replace("s","");
			mycurrent=Double.parseDouble(tempstr);
			tempstr="";
	        break;
	        case "strike": 
	        mtm.setdata(row,strikepriceposition,(String)selecteditem);
			mtm.fireTableCellUpdated(row, strikepriceposition);
			flagstrike=true;
			tempstr=(String)selecteditem;
			tempstr=tempstr.replace("P","");
			mystrike=Double.parseDouble(tempstr);
			tempstr="";
	        break;
	        case "premium": 
	        mtm.setdata(row,premiumpriceposition,(String)selecteditem);
			mtm.fireTableCellUpdated(row, premiumpriceposition);
			flagpremium=true;
			tempstr=(String)selecteditem;
			tempstr=tempstr.replace(",","");
			mypremium=Double.parseDouble(tempstr);
			tempstr="";
	        break;
	        default:break;
	        }       		
	        break;
	        default:
	        break;
	        }
	        if((flagcurrent==true)&&(flagstrike==true)&&(flagpremium==true)){
	        buttonupdate.setVisible(true);}
	        System.out.println("stop save value");
	        //mtm.setdata(row,5,(String)mcb2.getSelectedItem());
	        //mtm.fireTableCellUpdated(row, 5);
	        	}
	        }   //       actionPerformed
	        }//ActionListener
	        );
		    panel.add(mjbtn12, new SpringLayout.Constraints(Spring.constant(x50),Spring.constant(y50),Spring.constant(xwidth50),Spring.constant(ywidth50)));
		    // ORDER
		    int x45=610,y45=260,xwidth45=90,ywidth45=30;
		    panel.add(new JButton("order"), new SpringLayout.Constraints(Spring.constant(x45),Spring.constant(y45),Spring.constant(xwidth45),Spring.constant(ywidth45)));
		    int x46=710,y46=260,xwidth46=190,ywidth46=30;
		    // JComboBox mjcb7=new JComboBox();//ORDER
		    //  for(int ii=1;ii<=order;ii++){
		    //      mjcb7.addItem(ii);
		    //      }
		    panel.add(mjcb7, new SpringLayout.Constraints(Spring.constant(x46),Spring.constant(y46),Spring.constant(xwidth46),Spring.constant(ywidth46)));
		    int x47=910,y47=260,xwidth47=90,ywidth47=30;//ORDER
		    JButton orderselectbtn=new JButton("select");
		    orderselectbtn.addActionListener(
			new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	if(flagu==flag733)
	        	{
		    System.out.println("start order select ");
		     selectedorder=(int)mjcb7.getSelectedItem();
		    System.out.println("selectedorder="+selectedorder);
		    // save current ff2tracker table in perm table
		    
		    // save current ff2tracker table in tmp table
		    
		    // select * from tmp table where order = selected item
		    
		    // save result in tmp2 table
		    
		    // display tmp2 table
		    
		    System.out.println("stop order select ");
	        	}
			}          
		    }
		    );
		    panel.add(orderselectbtn, new SpringLayout.Constraints(Spring.constant(x47),Spring.constant(y47),Spring.constant(xwidth47),Spring.constant(ywidth47)));
		    // LINE
		    int x52=610,y52=310,xwidth52=90,ywidth52=30;
		    panel.add(new JButton("line"), new SpringLayout.Constraints(Spring.constant(x52),Spring.constant(y52),Spring.constant(xwidth52),Spring.constant(ywidth52)));
		    int x53=710,y53=310,xwidth53=190,ywidth53=30;  
		   // for(int ii=1;ii<=row;ii++){
			//          mjcb9.addItem(ii);
			//          }
		    panel.add(mjcb9, new SpringLayout.Constraints(Spring.constant(x53),Spring.constant(y53),Spring.constant(xwidth53),Spring.constant(ywidth53)));
		    int x54=910,y54=310,xwidth54=90,ywidth54=30;
		    JButton lineselectbtn=new JButton("select");
		    lineselectbtn.addActionListener(
					new ActionListener()
				    {
				    public void actionPerformed(ActionEvent e) 
				    {
				    	if(flagu==flag733)
			        	{
				    System.out.println("start line select ");
				  //   selectedorder=(int)mjcb7.getSelectedItem();
				//    System.out.println("selectedorder="+selectedorder);
				    
				    
				    System.out.println("stop line select ");
			        	}
					}          
				    }
				    );
		    panel.add(lineselectbtn, new SpringLayout.Constraints(Spring.constant(x54),Spring.constant(y54),Spring.constant(xwidth54),Spring.constant(ywidth54)));
			   
		    add(panel);		    
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setVisible(true);
		}
		catch(Exception e2){e2.getMessage();e2.printStackTrace();}	
	}
	private void creategui() 
	{
		// TODO Auto-generated method stub
		try{
			flagcreategui=true;
			flagcreategui2=false;
			this.setTitle("Finance Databases Tracker");
		    this.setSize(1200, 690);
		    // MyTableModel mtm=new MyTableModel();		  
		    mtm.setdata(0, 0, "hello");
		    JTable table = new JTable(mtm);
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	   
		    table.setFillsViewportHeight(true);
		    JScrollPane scrollPaneTable = new JScrollPane(table);    
		    JPanel panel = new JPanel();
		    panel.setLayout(new GridBagLayout());
		    GridBagConstraints c = new GridBagConstraints();
		    c.gridx = 0;
		    c.gridy = 0;	   
		    panel.add(scrollPaneTable,c);
		    c.gridx = 0;
		    c.gridy = 1;
		    panel.add(new JLabel("date:"), c);
		    c.gridx = 1;
		    c.gridy = 1;	 
		    c.ipadx=114;
		   // panel.add(new JTextField(mtm.getdate()), c);
		    JComboBox mycombo4=new JComboBox();
		    mycombo4.addItem(mtm.getdate());
		    panel.add(mycombo4 , c);
		    JButton printButton = new JButton("   save     ");
	        //printButton.addActionListener(this);
	        printButton.addActionListener(
	        		new ActionListener()
            {
	            public void actionPerformed(ActionEvent e)
	            {
	         
	            	mtm.setdata(row,2,mtm.getdate());
	            	mtm.fireTableCellUpdated(row, 2);
	            }          
	         }
	        );
	        c.gridx=3;
	        c.gridy=1;
	        c.ipadx=6;
	        panel.add(printButton,c);
		    c.gridx = 0;
		    c.gridy = 2;
		    c.ipadx=5;
		    panel.add(new JLabel("  database:"), c);
		    c.gridx = 1;
		    c.gridy = 2;	
		    c.ipadx=4;
		    JComboBox mycombo=new JComboBox();
		    int lim;	   
		    //    MyString ms=new MyString();
		    ms.setdata();	
		    lim=ms.getlim();	
		    mycombo.removeAllItems();
		    for(int a=1;a<lim;a++){
		    mycombo.addItem(ms.getmystr(a).trim());}	
		    mdb.setmydatabase(ms.getmystr(1));
		 
		    panel.add(mycombo , c);
		    JButton connectButton = new JButton("  connect ");	      
	        connectButton.addActionListener(
	        		new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {    
	          
	            	mdb.setmydatabase((String)mycombo.getSelectedItem());
	            	mtm.connect(mdb.getmydatabase());
	            }          
	         }
	        );
	        c.gridx=2;
	        c.gridy=2;
	        panel.add(connectButton,c);
	        //JLabel connectlabel=new JLabel();
	        connectlabel.setText(mfg.getmyflag());     
	        c.gridx = 4;
		    c.gridy = 2;    
	        panel.add(connectlabel, c);  
	        JButton button6 = new JButton("    save     ");      
	        button6.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	         
	            	mtm.setdata(row,3,(String)mycombo.getSelectedItem());
	            	mtm.fireTableCellUpdated(row, 3);
	            }   //       actionPerformed
	         }//ActionListener
	        );
	        c.gridx=3;
	        c.gridy=2;
	        c.ipadx=2;
	        panel.add(button6,c);
		    c.gridx = 0;
		    c.gridy = 3;
		    panel.add(new JLabel("  table:"), c);
		    c.gridx = 1;
		    c.gridy = 3;
		    c.ipadx=17;
		    //JComboBox mycombo2=new JComboBox();		    
		    int lim2;	   
		  //  MyString ms2=new MyString();
		    ms2.setdata2(mdb.getmydatabase());	
		    lim2=ms2.getlim2();	 
		    mcb.removeAllItems();
		    for(int a=1;a<lim2;a++){
		    mcb.addItem(ms2.getmystr2(a).trim());
		   // System.out.println(ms2.getmystr2(a));
		    }	    
		  
		    panel.add(mcb , c);
		  
		    JButton selectButton = new JButton("  select ");	  
	        selectButton.addActionListener(
                 new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	System.out.println("start table select ");
	            	mtb.setmytable((String)mcb.getSelectedItem());
	                System.out.println("table selected item="+mtb.getmytable());
	            	mfg.setmyflag("");
	            	connectlabel.setText(mfg.getmyflag());
	            	mtb.getattributeid(mtb.getmytable());
	            	// MyString ms4=new MyString();
	            	int lim3=ms4.getlim4();
	            	cbb.removeAllItems();
	    		    for(int d=1;d<lim3;d++){
	    		    	if(ms4.getmystr4(d)!=null){
	    		    cbb.addItem(ms4.getmystr4(d).trim());}	}
	    		    System.out.println("stop table select ");
	            }          
	         }
	        );
	        c.gridx=2;
	        c.gridy=3;
	        panel.add(selectButton,c);
	        JButton button5 = new JButton("  save   ");      
	        button5.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	         
	            	mtm.setdata(row,4,(String)mcb.getSelectedItem());
	            	mtm.fireTableCellUpdated(row, 4);
	            }   //       actionPerformed
	         }//ActionListener
	        );
	        c.gridx=3;
	        c.gridy=3;
	        panel.add(button5,c);
	        JButton buttonnextorder = new JButton("nextorder");      
	        buttonnextorder.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	                order=order+1;
	                for(int k=1;k<=order;k++){
	        		    mcb3.addItem(String.valueOf(k));}
	            //	mtm.setdata(row,1,(String)String.valueOf(order));
	           // 	mtm.fireTableCellUpdated(row, 1);
	            }   //       actionPerformed
	         }//ActionListener
	        );
	        c.gridx=4;
	        c.gridy=3;
	        c.ipadx=2;
	        panel.add(buttonnextorder,c);
	        c.gridx = 0;
		    c.gridy = 4;
		    panel.add(new JLabel("trend:"), c);
		    JComboBox mycombo3=new JComboBox();
		    mycombo3.addItem("bullish low price going up");
		    mycombo3.addItem("bearish high price going down");
		    c.gridx = 1;
		    c.gridy = 4;
		    c.ipadx=-54;
		    panel.add(mycombo3, c);
		    c.gridx = 2;
		    c.gridy = 4;
		    c.ipadx=30;
		    JButton button10 = new JButton("select");
		    button10.addActionListener(
	                 new ActionListener()
		        {
		            public void actionPerformed(ActionEvent e) 
		            {
		            	System.out.println("start trend select ");
		            	String item2=(String)mycombo3.getSelectedItem();
		            	System.out.println("trend="+item2);
		            	if(item2.contentEquals("bullish low price going up")){flagbull=true;}
		            	if(item2.contentEquals("bearish high price going down")){flagbear=true;}
		            	System.out.println("flagbull="+flagbull);
		            	System.out.println("flagbear="+flagbear);
		            	  if(flagbull==true){
		            		  System.out.println("flagbull==true");
		      		    	mycombo2.removeAllItems();
		      		    mycombo2.addItem("buy long future");
		      		    mycombo2.addItem("sell put option");}
		            	  /*
		            	  else
		      		    {
		      		    	System.out.println("flagbull==false");
		      		    	mycombo2.removeAllItems();
		      		    	mycombo2.addItem("buy long future");	    
		      			    mycombo2.addItem("sell short future");
		      			    mycombo2.addItem("buy call option");
		      			    mycombo2.addItem("sell put option");
		      		    }
		      		    */
		      		    if(flagbear==true){
		      		    	System.out.println("flagbear==true");
		      		    	mycombo2.removeAllItems();
		      		    mycombo2.addItem("sell short future");
		      		    mycombo2.addItem("buy call option");}
		      		    /*
		      		    else
		      		    {
		      		    	System.out.println("flagbear==false");
		      		    	mycombo2.removeAllItems();
		      		    	mycombo2.addItem("buy long future");	    
		      			    mycombo2.addItem("sell short future");
		      			    mycombo2.addItem("buy call option");
		      			    mycombo2.addItem("sell put option");	
		      		    }
		      		    */
		            	System.out.println("stop trend select ");
		            }          
		         }
		        );
		    panel.add(button10, c);
		    c.gridx = 3;
		    c.gridy = 4;
		    c.ipadx=36;
		    JButton button11 = new JButton("save");
		    button11.addActionListener(
	                 new ActionListener()
		        {
		            public void actionPerformed(ActionEvent e) 
		            {
		            	System.out.println("start trend save ");
		            	mtm.setdata(row,5,(String)mycombo3.getSelectedItem());
		            	mtm.fireTableCellUpdated(row, 5);
		            	
		            	System.out.println("stop trend save ");
		            }          
		         }
		        );
		    panel.add(button11, c);
		    JButton buttontrack = new JButton("track");      
	        buttonnextorder.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	         
	            	//mtm.setdata(row,1,(String)mcb.getSelectedItem());
	            	//mtm.fireTableCellUpdated(row, 1);
	            }   //       actionPerformed
	         }//ActionListener
	        );
	        c.gridx=4;
	        c.gridy=4;
	        panel.add(buttontrack,c);
		    c.gridx = 0;
		    c.gridy = 5;
		    c.ipadx=10;
		    panel.add(new JLabel("operation:"), c);
		   // JComboBox mycombo2=new JComboBox();
		    if(flagbull==true){
		    	mycombo2.removeAllItems();
		    mycombo2.addItem("buy long future");
		    mycombo2.addItem("sell put option");}
		    
		    else
		    {
		    	mycombo2.removeAllItems();
		    	mycombo2.addItem("buy long future");	    
			    mycombo2.addItem("sell short future");
			    mycombo2.addItem("buy call option");
			    mycombo2.addItem("sell put option");
		    }
		    
		    if(flagbear==true){
		    	mycombo2.removeAllItems();
		    mycombo2.addItem("sell short future");
		    mycombo2.addItem("buy call option");}
		    
		    else
		    {
		    	mycombo2.removeAllItems();
		    	mycombo2.addItem("buy long future");	    
			    mycombo2.addItem("sell short future");
			    mycombo2.addItem("buy call option");
			    mycombo2.addItem("sell put option");	
		    }
		    
		   
		    c.gridx = 1;
		    c.gridy = 5;
		    c.ipadx=45;
		    panel.add(mycombo2, c);
		    c.gridx = 2;
		    c.gridy = 5;
		    c.ipadx=30;
		    JButton button8 = new JButton("select");
		    button8.addActionListener(
	                 new ActionListener()
		        {
		            public void actionPerformed(ActionEvent e) 
		            {
		           System.out.println("start select operation");
		           String myitem2=(String) mycombo2.getSelectedItem();
		          // ms5.setmystr5(1,myitem);
     		           ms6.setmystr6(1,myitem2);
     		           
     		          int lim3;
     				    ms3.setdata3();
     				    lim3=ms3.getlim3();
     				    cbb.removeAllItems();
     				    String choice=(String)mycombo2.getSelectedItem();           
     				    System.out.println("choice="+choice);
     				    switch(choice)
     				    {
     				    case "buy long future":
     				    case "sell short future":
     				    	for(int d=1;d<lim3;d++){
     				    	if(ms3.getmystr3(d)!=null){
     				    cbb.addItem(ms3.getmystr3(d).trim());}}
     				       break;
     				    case "buy call option":
     				    case "sell put option":
     				    	cbb.addItem("strike");
     				    	cbb.addItem("high");
     				    	cbb.addItem("low");
     				    	cbb.addItem("current");
     				    	cbb.addItem("change");
     				    	cbb.addItem("volume");
     				    	cbb.addItem("time");
     				    	cbb.addItem("premium");
     				    	break;
     				    default: break;	    	
     				    }
     				    try{
     				    cbb.setSelectedIndex(2);
     				    }
     				    catch(Exception ex6){ex6.getMessage();ex6.getStackTrace();System.out.println("posgresql.jar might be missing from eclipse java build path libraries");}
     				    
     				    
		           System.out.println("stop select operation");
		            }          
		         }
		        );
		    panel.add(button8, c);
		    c.gridx = 3;
		    c.gridy = 5;
		    c.ipadx=36;
		    JButton button9 = new JButton("save");
		    button9.addActionListener(
	                 new ActionListener()
		        {
		            public void actionPerformed(ActionEvent e) 
		            {
		            	System.out.println("save operation");
		            
		            		mtm.setdata(row,6,(String)mycombo2.getSelectedItem());
			            	mtm.fireTableCellUpdated(row, 6);
		            		
		            	
		            }          
		         }
		        );
		    panel.add(button9, c);
		    c.gridx = 0;
		    c.gridy = 6;
		    panel.add(new JLabel("symbol :"), c);
		    System.out.println("start symbol combo");
		    c.gridx = 1;
		    c.gridy = 6;
		    c.ipadx=-1;
	
		  //  JComboBox mycombo=new JComboBox();
		
		  //  JComboBox cbb =new JComboBox();
		    int lim3;
		    ms3.setdata3();
		    lim3=ms3.getlim3();
		    cbb.removeAllItems();
		    String choice=(String)mycombo2.getSelectedItem();           
		    
		    if(choice==null){choice="buy long future";}
		    System.out.println("choice="+choice);
		    switch(choice)
		    {
		    case "buy long future":
		    case "sell short future":
		    	for(int d=1;d<lim3;d++){
		    	if(ms3.getmystr3(d)!=null){
		    cbb.addItem(ms3.getmystr3(d).trim());}}
		       break;
		    case "buy call option":
		    case "sell put option":
		    	cbb.addItem("strike");
		    	cbb.addItem("high");
		    	cbb.addItem("low");
		    	cbb.addItem("current");
		    	cbb.addItem("change");
		    	cbb.addItem("volume");
		    	cbb.addItem("time");
		    	cbb.addItem("premium");
		    	break;
		    default: break;	    	
		    }
		    try{
		    cbb.setSelectedIndex(2);
		    }
		    catch(Exception ex6){ex6.getMessage();ex6.getStackTrace();System.out.println("posgresql.jar might be missing from eclipse java build path libraries");}
		    panel.add(cbb, c);
		    JButton button3 = new JButton("  select ");      
	        button3.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	         System.out.println("start symbol select");
	         String myitem=(String) cbb.getSelectedItem();
	         System.out.println("symbol selected item="+myitem);
	         String mycolumn="",mytablename="",mycolumn2="",doublecolumn="";
	         switch((String) mycombo2.getSelectedItem())
	         {
	         case "buy long future":
	         case "sell short future":
	        	 ms5.setmystr5(1,myitem);
		         ms5.setdata5();
		         int lim5=ms5.getlim5();
	         	mcb2.removeAllItems();
	 		    for(int g=1;g<lim5;g++)
	 		    {
	 		    	if(ms5.getmystr5(g)!=null)
	 		    	{
	 		        mcb2.addItem(ms5.getmystr5(g).trim());
	 		        }	
	 		    }
	        	 break;
	         case "buy call option":
	        	 //select * from ff2plustradeboption1862016 where strike ilike '%c%';
	        	 ms5.setmystr7(1,myitem);
	        	 mycolumn=myitem;
	        	 mytablename=mtb.getmytable();
	        	 ms5.setdata7(mycolumn,mytablename);
	        	 mcb2.removeAllItems();
	        	 int lim7=ms5.getlim7();
	        	 for(int g=1;g<lim7;g++)
		 		    {
		 		    	if(ms5.getmystr7(g)!=null)
		 		    	{
		 		    		//doublecolumn=ms5.getmystr7a(g).trim()+ms5.getmystr7(g).trim();
		 		        mcb2.addItem(ms5.getmystr7(g).trim());
		 		        }	
		 		    }
	        	 break;
	         case "sell put option":
	        	 //select * from ff2plustradeboption1862016 where strike ilike '%p%';
	        	 ms5.setmystr8(1,myitem);
	        	 mycolumn=myitem;
	        	 mycolumn2="strike";
	        	 mytablename=mtb.getmytable();
	        	 ms5.setdata8(mycolumn,mycolumn2,mytablename); 
	        	 mcb2.removeAllItems();
	        	 int lim8=ms5.getlim8();
	        	 for(int g=1;g<lim8;g++)
		 		    {
		 		    	if(ms5.getmystr8(g)!=null)
		 		    	{
		 		    		//c.ipadx=1;
		 		    		doublecolumn=ms5.getmystr8(g).trim()+" "+ms5.getmystr8a(g).trim();
		 		    		if(doublecolumn.length()>20){doublecolumn="";}
		 		        mcb2.addItem(doublecolumn.trim());
		 		        
		 		        }	
		 		    }
	        	 break;
	         default:break;
	         }
	         
	          //  	mtm.setdata(0,1,(String)cbb.getSelectedItem());
	            	//mtm.fireTableCellUpdated(0, 1);
 		   System.out.println("stop symbol select");
	            }   //       actionPerformed
	         }//ActionListener
	        );
	        c.gridx=2;
	        c.gridy=6;
	         c.ipadx=18;
	        panel.add(button3,c);
		    JButton button2 = new JButton("  save   ");      
	        button2.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	         
	            	mtm.setdata(row,7,(String)cbb.getSelectedItem());
	            	mtm.fireTableCellUpdated(row, 7);
	            }   //       actionPerformed
	         }//ActionListener
	        );
	        c.gridx=3;
	        c.gridy=6;
	        c.ipadx=15;
	        panel.add(button2,c);
		    c.gridx = 0;
		    c.gridy = 7;
		    c.ipadx=10;
		    panel.add(new JLabel("value:"), c);
		 //   JComboBox mcb2=new JComboBox();
	
		    int lim5;
		    ms5.setdata5();
		    lim5=ms5.getlim5();
		    mcb2.removeAllItems();
		    for(int f=1;f<=lim5;f++){
		    	if(ms5.getmystr5(f)!=null){
		    	mcb2.addItem(ms5.getmystr5(f).trim());}
		    }
		
		    c.gridx = 1;
		    c.gridy = 7;
		    c.ipadx=123;
		
		    panel.add(mcb2, c);
		    JButton button4 = new JButton("save");      
	        button4.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	System.out.println("start save value");
	            	String oper=ms6.getmystr6(1);
	            	String selecteditem="";
	            	String tempstr="";
	            	switch(oper){
	            	case "buy long future":
	            		System.out.println("case : buy long future");
	            		tempstr=(String)mcb2.getSelectedItem();
	            		tempstr=tempstr.replace("s","");
		            	myfutureprice=Double.parseDouble(tempstr);            	
	            		mtm.setdata(row,8,(String)tempstr);
		            	mtm.fireTableCellUpdated(row, 8);
		            	tempstr="";		            	
	            		break;
	            	case "sell short future":
	            		System.out.println("case : sell short future");
	            		mtm.setdata(row,8,(String)mcb2.getSelectedItem());
		            	mtm.fireTableCellUpdated(row, 8);
	            		break;
	            	case "buy call option":
	            		System.out.println("case : buy call option");
	            		mtm.setdata(row,9,(String)mcb2.getSelectedItem());
		            	mtm.fireTableCellUpdated(row, 9);
	            		break;
	            	case "sell put option":
	            		System.out.println("case : sell put option");
	            		selecteditem=(String)mcb2.getSelectedItem();	
	            		int index=selecteditem.indexOf('P');
	            		selecteditem=selecteditem.substring(index+1);
	            		String symbol="";
	            		symbol=(String)cbb.getSelectedItem();
	            		switch(symbol){
	            	    case "current": 
	            	    	mtm.setdata(row,11,(String)selecteditem);
			            	mtm.fireTableCellUpdated(row, 11);
			                flagcurrent=true;
			                tempstr=(String)selecteditem;
			                tempstr=tempstr.replace("s","");
			            	mycurrent=Double.parseDouble(tempstr);
			            	tempstr="";
	            	    	break;
	            	    case "strike": 
	            	    	mtm.setdata(row,14,(String)selecteditem);
			            	mtm.fireTableCellUpdated(row, 14);
			            	flagstrike=true;
			            	tempstr=(String)selecteditem;
			            	tempstr=tempstr.replace("P","");
			            	mystrike=Double.parseDouble(tempstr);
			            	tempstr="";
	            	    	break;
	            	    case "premium": 
	            	    	mtm.setdata(row,16,(String)selecteditem);
			            	mtm.fireTableCellUpdated(row, 16);
			            	flagpremium=true;
			            	tempstr=(String)selecteditem;
			            	tempstr=tempstr.replace(",","");
			            	mypremium=Double.parseDouble(tempstr);
			            	tempstr="";
	            	    	break;
	            	    default:break;
	            		}       		
	            		break;
	            	default:
	            		break;
	            	}
	            	if((flagcurrent==true)&&(flagstrike==true)&&(flagpremium==true)){
	    		        buttonupdate.setVisible(true);}
	            	System.out.println("stop save value");
	            	//mtm.setdata(row,5,(String)mcb2.getSelectedItem());
	            	//mtm.fireTableCellUpdated(row, 5);
	            }   //       actionPerformed
	         }//ActionListener
	        );
	        c.gridx=3;
	        c.gridy=7;
	        c.ipadx=35;
	        panel.add(button4,c);
	        //JButton buttonupdate = new JButton("update");  
	        if((flagcurrent==false)||(flagstrike==false)||(flagpremium==false)){
	        buttonupdate.setVisible(false);}
	        if((flagcurrent==true)&&(flagstrike==true)&&(flagpremium==true)){
		        buttonupdate.setVisible(true);}
	        buttonupdate.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	//double mystrike=0,myfutureprice=0;
	            	String tempstr="";
	            	double res=0,riskfactor=0,maxloss=0,myprice=0,myvalue=0;
	            	int myposition=13;
	            	if(mystrike>myfutureprice){
	            	    mtm.setdata(row,myposition,(String)"inthemoney");
	            	    mtm.fireTableCellUpdated(row,myposition );
	            	    flaginthemoney=true;
	            	}
	            	if(myfutureprice>mystrike){
	            		mtm.setdata(row,myposition,(String)"outthemoney");
		            	mtm.fireTableCellUpdated(row, myposition);
		            	flagoutthemoney=true;
	            	}	
	            	if(myfutureprice==mystrike){
	            		mtm.setdata(row,myposition,(String)"atthemoney");
		            	mtm.fireTableCellUpdated(row,myposition );
		            	flagatthemoney=true;      	
	            	}	
	            	if(flagoutthemoney==true){
	            		res=myfutureprice-mystrike;
	            		riskfactor=res+mypremium;
	            		maxloss=riskfactor*1120;
	            	}
	            	if(flaginthemoney==true){
	            		res=mystrike-myfutureprice;
	            		riskfactor=mypremium-res;
	            		maxloss=riskfactor*1120;
	            	}
	            	if(flagatthemoney==true){
	            		res=0;
	            		riskfactor=mypremium-res;
	            		maxloss=riskfactor*1120;
	            	}
	            	if(riskfactor>0.89){
	            		flagmaxlossnotallowed=true;
	            	}
	            	myprice=myfutureprice+mycurrent;
	            	tempstr=String.valueOf(myprice);
	            	myposition=15;
	            	mtm.setdata(row,myposition,(String)tempstr);
            	    mtm.fireTableCellUpdated(row,myposition );
            	    tempstr="";
            	    myvalue=myprice*1120;
            	    tempstr=String.valueOf(myvalue);
	            	myposition=18;
	            	mtm.setdata(row,myposition,(String)tempstr);
            	    mtm.fireTableCellUpdated(row,myposition );
            	    tempstr="";
            	    mtm.setdata(row,0,(String)String.valueOf(row+1));
	            	mtm.fireTableCellUpdated(row,0 );
	            	mtm.setdata(row-1,1,(String)String.valueOf(order+1));
	            	mtm.fireTableCellUpdated(row-1,1 );
	            	mtm.setdata(row,1,(String)String.valueOf(order+1));
	            	mtm.fireTableCellUpdated(row,1 );
            	    
	            }   //       actionPerformed
	         }//ActionListener
	        );
	        c.gridx=4;
	        c.gridy=7;
	        c.ipadx=35;
	        panel.add(buttonupdate,c);
	        c.gridx = 0;
		    c.gridy = 8;
		    c.ipadx=1;
		    panel.add(new JLabel("order:"), c);
		   // JComboBox mcb3=new JComboBox();
		    mcb3.removeAllItems();
		    mcb3.addItem("1");
		    c.gridx = 1;
		    c.gridy = 8;
		    c.ipadx=153;
		    panel.add(mcb3, c);
		    JButton buttonselect = new JButton("select");      
	        buttonselect.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	
	            String myitem2=(String) mcb3.getSelectedItem();
	            	
		 		  //  for(int g=1;g<lim5;g++)
		 		 //   {
		 		    //	if(ms5.getmystr5(g)!=null)
		 		   // 	{
		 		  //      mcb3.addItem(ms5.getmystr5(g).trim());
	            	
		 		   //    }	
		 		 //   }
	            	
	            }   //       actionPerformed
	         }//ActionListener
	        );
		    c.gridx=2;
		    c.gridy=8;
		    c.ipadx=30;
		    panel.add(buttonselect,c);
		    JButton button7 = new JButton("next row");      
	        button7.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	
	                row=row+1;
	                mtm.setdata(row-1,0,(String)String.valueOf(row));
	            	mtm.fireTableCellUpdated(row-1,0 );
	            	
	            }   //       actionPerformed
	         }//ActionListener
	        );
		    c.gridx=3;
		    c.gridy=8;
		    c.ipadx=6;
		    panel.add(button7,c);
		    JButton buttonpreviousrow = new JButton("previousrow");      
	        buttonpreviousrow.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	
	                row=row-1;
	             //   mtm.setdata(row-1,0,(String)String.valueOf(row));
	            //	mtm.fireTableCellUpdated(row-1,0 );
	            	
	            }   //       actionPerformed
	         }//ActionListener
	        );
		    c.gridx=4;
		    c.gridy=8;
		    c.ipadx=6;
		    panel.add(buttonpreviousrow,c);
		    
		    
	//	    c.gridx = 0;
	//	    c.gridy = 0;	   
	//	    panel.add(scrollPaneTable,c);
		    c.gridx = 1;
		    c.gridy = 0;		   
		    JButton saveTableButton = new JButton("save table");       
	        saveTableButton.addActionListener(
	        		new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	String tabledata="";
	            	System.out.println("max col count="+mtm.getColumnCount());
	            	int mycol=0;
	            	mycol=mtm.getColumnCount();
	            	System.out.println("max row count="+mtm.getRowCount());
	            	int myrow=0;
	            	for(int i=0;i<mtm.getRowCount();i++){
	            		for(int j=0;j<mtm.getColumnCount();j++){
	            			tabledata=mtm.getdata(i, j);
	            			if((tabledata!=null)&&(j==0)){myrow++;}
	            		}
	            	}
	            	System.out.println("to be saved myrow count="+myrow);
	            	System.out.println("to be saved mycolumn count="+mtm.getColumnCount());
	            	mst.savedata(myrow);
	            	
	            //   statusLabel.setText("Ok Button clicked.");
	            //	mtm.setdata(0,0,mtm.getdate());
	            //	mtm.fireTableCellUpdated(0, 0);
	            }          
	         }
	        );
		    panel.add(saveTableButton,c);
		    c.gridx = 2;
		    c.gridy = 0;	   
		    JButton recallTableButton = new JButton("recall table");        
	        recallTableButton.addActionListener(
	        		new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	int myrowcount=mst.restoredata();
	            	System.out.println("restored row count="+myrowcount);
	            	row=myrowcount;
	            //   statusLabel.setText("Ok Button clicked.");
	            //	mtm.setdata(0,0,mtm.getdate());
	            //	mtm.fireTableCellUpdated(0, 0);
	            }          
	         }
	        );
		    panel.add(recallTableButton,c);
		   
	       
		    add(panel);		    
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setVisible(true);
		}
		catch(Exception e2){e2.getMessage();e2.printStackTrace();}	
	}//creategui
		
	class MyTable
	{
		void setlim(int lim){this.mylim=lim;}
		int getlim(){return this.mylim;}
		private int mylim;
		void setmytable(String table){this.mytable=table;}
		String getmytable(){return this.mytable;}
		private String mytable;
		void getattributeid(String table1)
		{
			try{
				System.out.println("start getattributeid MyTable");
			//String table=mtb.getmytable();
			String databasename=mdb.getmydatabase();	
			System.out.println("databasename ="+databasename);
			if(!databasename.contentEquals("ff2plustradeboption"))
			{
			System.out.println("databasename !=ff2plustradeboption getattributeid MyTable");
			String url    = "jdbc:postgresql://localhost:5432/"+databasename;
     		String username = "postgres";
            String password="postgres";
            Class.forName("org.postgresql.Driver");
             //       System.out.println("1");
     	    Connection conn=DriverManager.getConnection(url,username,password);
     	    //	 System.out.println("2");
     		Statement stat=conn.createStatement();
     		ResultSet result2;
    		String cmd1="";
    		String thevale3="";
    		
    		cmd1="SELECT distinct COUNT(title) FROM "+ table1 ;	// count number of attributeid
    		System.out.println("cmd1="+cmd1);
			result2=stat.executeQuery(cmd1);
    		while(result2.next())
    		{
    			thevale3=result2.getString(1);
    		}	
    		int lim=Integer.parseInt(thevale3);
    		mtb.setlim(lim);
    		// MyString ms4=new MyString();
    		ms4.setlim4(lim);
    		ResultSet result4;
    		String cmd4="";
    		String[] thevale4=new String[lim+1];
    		cmd4="SELECT distinct title FROM "+ table1;	// attributeid 
    		System.out.println("cmd2="+cmd4);
			result4=stat.executeQuery(cmd4);
    	    int k=1;
    		while(result4.next())
    		{
    			thevale4[k]=result4.getString(1);
    			k++;
    		}
    	//	setattributeid(thevale4);
    		for(int c=1;c<=lim;c++)
    		{
    		//	System.out.println(thevale4[c]);
    		//	ms3.setmystr3(c,thevale4[c]);
    			// MyString ms4=new MyString();
    			ms4.setmystr4(c,thevale4[c]);
    		}
  //  		 System.out.println("12");
     		conn.close();
     		stat.close();
			}
			else
			{
			if(databasename.contentEquals("ff2plustradeboption"))
			{
				System.out.println("databasename ==ff2plustradeboption getattributeid MyTable");
				String url    = "jdbc:postgresql://localhost:5432/"+databasename;
	     		String username = "postgres";
	            String password="postgres";
	            Class.forName("org.postgresql.Driver");
	             //       System.out.println("1");
	     	    Connection conn=DriverManager.getConnection(url,username,password);
	     	    //	 System.out.println("2");
	     		Statement stat=conn.createStatement();
	     		ResultSet result2;
	    		String cmd1="";
	    		String thevale3="";
	    		
	    		cmd1="SELECT distinct COUNT(strike) FROM "+ table1 ;	// count number of attributeid/row of strike
	    		System.out.println("cmd3="+cmd1);
				result2=stat.executeQuery(cmd1);
	    		while(result2.next())
	    		{
	    			thevale3=result2.getString(1);
	    		}	
	    		int lim=Integer.parseInt(thevale3);
	    		mtb.setlim(lim);
	    		// MyString ms4=new MyString();
	    		ms4.setlim4(lim);
	    		ResultSet result4;
	    		String cmd4="";
	    		String[] theval1=new String[lim+1];
	    		String[] theval2=new String[lim+1];
	    		String[] theval3=new String[lim+1];
	    		String[] theval4=new String[lim+1];
	    		String[] theval5=new String[lim+1];
	    		String[] theval6=new String[lim+1];
	    		String[] theval7=new String[lim+1];
	    		String[] theval8=new String[lim+1];
	    		cmd4="SELECT distinct * FROM "+ table1;	// attributeid 
	    		System.out.println("cmd4="+cmd4);
				result4=stat.executeQuery(cmd4);
	    	    int k=1;
	    		while(result4.next())
	    		{
	    			theval1[k]=result4.getString(1);//strike
	    			theval2[k]=result4.getString(2);//high
	    			theval3[k]=result4.getString(3);//low
	    			theval4[k]=result4.getString(4);//current
	    			theval5[k]=result4.getString(5);//change
	    			theval6[k]=result4.getString(6);//volume
	    			theval7[k]=result4.getString(7);//time
	    			theval8[k]=result4.getString(8);//premium
	    			k++;
	    		}
	    	//	setattributeid(thevale4);
	    		for(int c=1;c<=lim;c++)
	    		{
	    		//	System.out.println(theval4[c]);
	    		//	ms3.setmystr3(c,thevale4[c]);
	    			// MyString ms4=new MyString();
	    			ms4.setmystr4(c,theval4[c]);//current
	    		}
	  //  		 System.out.println("12");
	     		conn.close();
	     		stat.close();
			}
			}//else
			System.out.println("stop getattributeid MyTable");
			}//try
			 catch(Exception ex1){ex1.getMessage();ex1.getStackTrace(); }
		}//getattributeid()
		
	}//class MyTable
	class MyFlag
	{
		void setmyflag(String flag){this.myflag=flag;}
		String getmyflag(){return this.myflag;}
		private String myflag;
		void setmyresult(String result){this.myresult=result;}
		String getmyresult(){return this.myresult;}
		private String myresult;
	}
	
	
	class MyDataBase
	{
		void setmydatabase(String database){this.database=database;}
		String getmydatabase(){return this.database;}
		private String database;
	}
	
	class MyString
	{
		void setdata8(String col,String col2,String table)
		{
			//sell put option
			//"select "+col+" from "+table+" where strike ilike '%p%'";
			try{
			System.out.println("start setdata8 MyString");
			String databasename;//=database;//mdb.getmydatabase();
			if(mdb.getmydatabase()!=null){databasename=mdb.getmydatabase();}else{databasename="ff2plustrade";}
			System.out.println(databasename);
			String url    = "jdbc:postgresql://localhost:5432/"+databasename;
     		String username = "postgres";
            String password="postgres";
            //    System.out.println("1");
            Class.forName("org.postgresql.Driver");
            //  System.out.println("2");
            Connection conn=DriverManager.getConnection(url,username,password);
            //         System.out.println("3");
            Statement stat=conn.createStatement();
            ResultSet result8;
	    	String cmd8="";
	    	cmd8="select COUNT("+col+") from "+table+" where strike ilike '%p%'";
	    	System.out.println("sell put option setdata8 cmd8="+cmd8);
	    	System.out.println("cmd5="+cmd8);
	    	result8=stat.executeQuery(cmd8);
	    	String thevale8="";
	    	while(result8.next())
    		{
    			thevale8=result8.getString(1);
    		}	
	    	System.out.println("sell put option setdata8 lim8=thevale8="+thevale8);
	    	int lim8=Integer.parseInt(thevale8);
    		ms5.setlim8(lim8);
    		ResultSet result10;
    		String cmd10="";
    		String[] thevale10=new String[lim8+1];
    		String[] thevale11=new String[lim8+1];
    		cmd10="select "+col2+","+col+" from "+table+" where strike ilike '%p%'";
    		//System.out.println(cmd10);
    		System.out.println("cmd6="+cmd10);
    		result10=stat.executeQuery(cmd10);
    		int k=0;
    		while(result10.next())
    		{
    			thevale10[k]=result10.getString(1);
    			thevale11[k]=result10.getString(2);
    			k++;
    		}	
    		for(int c=1;c<=lim8;c++)
    		{
    			//System.out.println(thevale4[c]);
    			ms5.setmystr8(c,thevale10[c]);
    			ms5.setmystr8a(c,thevale11[c]);
    		}
    		conn.close();
     		stat.close();
			System.out.println("stop setdata8 MyString");
			}
			catch(Exception ex9){ex9.printStackTrace();ex9.getMessage();}
		}
		void setdata7(String col,String table)
		{
			try{
			//buy call option
			//"select "+col+" from "+table+" where strike ilike '%c%'";
			System.out.println("start setdata7");
			String databasename;//=database;//mdb.getmydatabase();
			if(mdb.getmydatabase()!=null){databasename=mdb.getmydatabase();}else{databasename="ff2plustrade";}
			System.out.println(databasename);
			String url    = "jdbc:postgresql://localhost:5432/"+databasename;
     		String username = "postgres";
            String password="postgres";
            //    System.out.println("1");
            Class.forName("org.postgresql.Driver");
            //  System.out.println("2");
            Connection conn=DriverManager.getConnection(url,username,password);
            //         System.out.println("3");
            Statement stat=conn.createStatement();
            ResultSet result7;
	        String cmd7="";
	    	cmd7="select COUNT("+col+") from "+table+" where strike ilike '%c%'";
	    	System.out.println("cmd7="+cmd7);
	    	result7=stat.executeQuery(cmd7);
	    	String thevale7="";
	    	while(result7.next())
    		{
    			thevale7=result7.getString(1);
    		}	
	    	int lim7=Integer.parseInt(thevale7);
    		ms5.setlim7(lim7);
    		ResultSet result9;
    		String cmd9="";
    		String[] thevale9=new String[lim7+1];
    		cmd9="select "+col+" from "+table+" where strike ilike '%c%'";
    		System.out.println("cmd8="+cmd9);
    		result9=stat.executeQuery(cmd9);
    		int k=0;
    		while(result9.next())
    		{
    			thevale9[k]=result9.getString(1);
    			k++;
    		}	
    		for(int c=1;c<=lim7;c++)
    		{
    			//System.out.println(thevale4[c]);
    			ms5.setmystr7(c,thevale9[c]);
    		}
    		conn.close();
     		stat.close();
			System.out.println("stop setdata7");
			}
			catch(Exception ex10){ex10.printStackTrace();ex10.getMessage();}
		}
		void setdata5()
		{
			try{
			System.out.println("start setdata5 mystring");
			String databasename;//=database;//mdb.getmydatabase();
			if(mdb.getmydatabase()!=null){databasename=mdb.getmydatabase();}else{databasename="ff2plustrade";}
			System.out.println(databasename);
			String url    = "jdbc:postgresql://localhost:5432/"+databasename;
     		String username = "postgres";
            String password="postgres";
            //    System.out.println("1");
            Class.forName("org.postgresql.Driver");
            //  System.out.println("2");
            Connection conn=DriverManager.getConnection(url,username,password);
            //         System.out.println("3");
            Statement stat=conn.createStatement();
             //    System.out.println("4");
            ResultSet result2;
	        String cmd1="";
	        String thevale3="";
	        String table="";//=mtb.getmytable();	
	        if(mtb.getmytable()!=null){table=mtb.getmytable();}else{table="ff2plustrade2862016";}
	    	System.out.println(table);
	        //    		 System.out.println("5");
	    	cmd1="SELECT COUNT(priorsettle) FROM "+table;	// count number of valuetext
	    	System.out.println("cmd9="+cmd1);
			result2=stat.executeQuery(cmd1);
	        //		 System.out.println("6");
	    	while(result2.next())
	    		{
	    			thevale3=result2.getString(1);
	    		}	
	 //  		 System.out.println("7");
	    		int lim=Integer.parseInt(thevale3);
	    		ms5.setlim5(lim);
	//    		 System.out.println("8");
	    		ResultSet result4;
	    		String cmd4="";
	    		//ms5.get
	    		String[] thevale4=new String[lim+1];
	    		String myvaluetext="";
	    		if(ms5.getmystr5(1)!=null){
	    		System.out.println(ms5.getmystr5(1));myvaluetext=ms5.getmystr5(1);}else {myvaluetext="dt1_SBN17_high";System.out.println(myvaluetext);}
	    		cmd4="SELECT priorsettle FROM "+table+" WHERE title ILIKE '%"+myvaluetext+"%';";	// valuetext  ... "distinct" might have to be omitted
	    //		System.out.println(cmd4);
	    //		 System.out.println("9");
	    		System.out.println("cmd10="+cmd4);
				result4=stat.executeQuery(cmd4);
		//		 System.out.println("10");
	    	    int k=1;
	    		while(result4.next())
	    		{
	    			thevale4[k]=result4.getString(1);
	    			k++;
	    		}
	 //   		 System.out.println("11");
	    		for(int c=1;c<=lim;c++)
	    		{
	    			//System.out.println(thevale4[c]);
	    			ms5.setmystr5(c,thevale4[c]);
	    		}
	    		System.out.println(ms5.getmystr5(1));
	   // 		 System.out.println("12");
	     		conn.close();
	     		stat.close();
			System.out.println("stop setdata5 mystring");
		}
		 catch(Exception ex5){ ex5.getMessage();ex5.getStackTrace();}
		}
		void setdata3()
		{
			try{
			System.out.println("start setdata3 mystring");
			
			String databasename;//=database;//mdb.getmydatabase();
			if(mdb.getmydatabase()!=null){databasename=mdb.getmydatabase();}else{databasename="ff2plustrade";}
			System.out.println(databasename);
			String url    = "jdbc:postgresql://localhost:5432/"+databasename;
     		String username = "postgres";
             String password="postgres";
         //    System.out.println("1");
             Class.forName("org.postgresql.Driver");
       //      System.out.println("2");
             Connection conn=DriverManager.getConnection(url,username,password);
        //     System.out.println("3");
             Statement stat=conn.createStatement();
        //     System.out.println("4");
             ResultSet result2;
	    		String cmd1="";
	    		String thevale3="";
	    		String table="";//=mtb.getmytable();	
	    		 if(mtb.getmytable()!=null){table=mtb.getmytable();}else{table="ff2plustrade2862016";}
	    		 System.out.println(table);
	    //		 System.out.println("5");
	    		cmd1="SELECT distinct COUNT(title) FROM "+table;	// count number of attributeid
	    		System.out.println("cmd11="+cmd1);
				result2=stat.executeQuery(cmd1);
	//			 System.out.println("6");
	    		while(result2.next())
	    		{
	    			thevale3=result2.getString(1);
	    		}	
	  //  		 System.out.println("7");
	    		int lim=Integer.parseInt(thevale3);
	    		ms3.setlim3(lim);
	  //  		 System.out.println("8");
	    		ResultSet result4;
	    		String cmd4="";
	    		String[] thevale4=new String[lim+1];
	    		cmd4="SELECT distinct title FROM "+table;	// attibuteid
	  //  		 System.out.println("9");
	    		System.out.println("cmd12="+cmd4);
				result4=stat.executeQuery(cmd4);
		//		 System.out.println("10");
	    	    int k=1;
	    		while(result4.next())
	    		{
	    			thevale4[k]=result4.getString(1);
	    			k++;
	    		}
	   // 		 System.out.println("11");
	    		for(int c=1;c<=lim;c++)
	    		{
	    		//	System.out.println(thevale4[c]);
	    			ms3.setmystr3(c,thevale4[c]);
	    		}
	  //  		 System.out.println("12");
	     		conn.close();
	     		stat.close();
	    		
			System.out.println("stop setdata3 mystring");
			}
			 catch(Exception ex1){ ex1.getMessage();ex1.getStackTrace();}
		}//setdata3
		void setdata2(String database)
		{
			try{
	        	 System.out.println("start setdata2 mystring");
	        	 String databasename="";
	     		databasename=database;
	     		if(databasename==null){System.out.println("postgresql.jar might not be on eclipse Lib Build Path");}else{
	     		System.out.println(databasename);}
	     		String url    = "jdbc:postgresql://localhost:5432/"+databasename;
	     		String username = "postgres";
	             String password="postgres";
	             Class.forName("org.postgresql.Driver");
	      //       System.out.println("1");
	     		Connection conn=DriverManager.getConnection(url,username,password);
	     	//	 System.out.println("2");
	     		Statement stat=conn.createStatement();
	     		
	     		ResultSet result2;
	    		String cmd1="";
	    		String thevale3="";
	    		cmd1="SELECT COUNT(table_name) FROM information_schema.tables WHERE table_name ILIKE '%ff2%'";	// count number of table
	    		System.out.println("cmd13="+cmd1);
				result2=stat.executeQuery(cmd1);
	    		while(result2.next())
	    		{
	    			thevale3=result2.getString(1);
	    		}	
	    		int lim=Integer.parseInt(thevale3);
	    		ms2.setlim2(lim);
	   
	    		ResultSet result4;
	    		String cmd4="";
	    		String[] thevale4=new String[lim+1];
	    		cmd4="SELECT table_name FROM information_schema.tables WHERE table_name ILIKE '%ff2%' order by table_name";	// database
	    		System.out.println("cmd14="+cmd4);
				result4=stat.executeQuery(cmd4);
	    	    int k=1;
	    		while(result4.next())
	    		{
	    			thevale4[k]=result4.getString(1);
	    			k++;
	    		}

				for(int c=1;c<=lim;c++)
	    		{
	    		//	System.out.println(thevale4[c]);
	    			setmystr2(c,thevale4[c]);
	    		}
	     		conn.close();
	     		stat.close();
	     		System.out.println("stop setdata2 mystring");
	        	 }
	        	 catch(Exception ex1)
			     {
	        		 ex1.getMessage();ex1.getStackTrace();
	        	   //  mfg.setmyresult("nok");
	        	 }
			
		}
		
		void setdata()
		{
			try{
				System.out.println("start setdata  mystring");
				System.out.println("ff2plustrade");
			    String databasename="";   
	    		databasename="ff2plustrade";
	    		String url    = "jdbc:postgresql://localhost:5432/"+databasename;
	    		String username = "postgres";
	    		String password = "postgres"; 
	    		Class.forName("org.postgresql.Driver");
	    		Connection conn=DriverManager.getConnection(url,username,password);
	    		Statement stat=conn.createStatement();    		
	    		ResultSet result2;
	    		String cmd1="";
	    		String thevale3="";
	    		cmd1="SELECT COUNT(datname) FROM pg_database WHERE datname ILIKE '%ff2%'";	// count number of database
	    		System.out.println("cmd15="+cmd1);
				result2=stat.executeQuery(cmd1);
	    		while(result2.next())
	    		{
	    			thevale3=result2.getString(1);
	    		}	    			
	    		ResultSet result4;
	    		String cmd4="";
	    		String[] thevale4=new String[100];
	    		cmd4="SELECT datname FROM pg_database WHERE datname ILIKE '%ff2%'";	// database
	    		System.out.println("cmd16="+cmd4);
				result4=stat.executeQuery(cmd4);
	    	    int k=1;
	    		while(result4.next())
	    		{
	    			thevale4[k]=result4.getString(1);
	    			k++;
	    		}
	    		conn.close();
	    		setlim(k);
	    		//System.out.println(thevale3);
	    		for(int c=1;c<=Integer.valueOf(thevale3);c++)
	    		{
	    		//	System.out.println(thevale4[c]);
	    			ms.setmystr(c,thevale4[c]);
	    		}
	    		System.out.println("stop setdata  mystring");
			}
			catch(Exception ex1){ex1.getMessage();ex1.getStackTrace();}    		
		}
		void setmystr(int a,String str){this.mystr[a]=str;};
		String getmystr(int a){return this.mystr[a];}
		private String[] mystr=new String[5000];
		void setmystr2(int a,String str){this.mystr2[a]=str;};
		String getmystr2(int a){return this.mystr2[a];}
		private String[] mystr2=new String[5000];
		void setmystr3(int a,String str){this.mystr3[a]=str;};
		String getmystr3(int a){return this.mystr3[a];}
		private String[] mystr3=new String[5000];
		void setlim(int a){this.mylim=a;}
		int getlim(){return this.mylim;}
		private int mylim;
		void setlim2(int a){this.mylim2=a;}
		int getlim2(){return this.mylim2;}
		private int mylim2;
		void setlim3(int a){this.mylim3=a;}
		int getlim3(){return this.mylim3;}
		private int mylim3;
		void setlim4(int a){this.mylim4=a;}
		int getlim4(){return this.mylim4;}
		private int mylim4;
		void setmystr4(int a,String str){this.mystr4[a]=str;};
		String getmystr4(int a){return this.mystr4[a];}
		private String[] mystr4=new String[5000];
		void setlim5(int a){this.mylim5=a;}
		int getlim5(){return this.mylim5;}
		private int mylim5;
		void setmystr5(int a,String str){this.mystr5[a]=str;};
		String getmystr5(int a){return this.mystr5[a];}
		private String[] mystr5=new String[5000];
		private String[] mystr6=new String[5000];
		void setmystr6(int a,String str){this.mystr6[a]=str;};
		String getmystr6(int a){return this.mystr6[a];}
		private int mylim6;
		void setlim6(int a){this.mylim6=a;}
		int getlim6(){return this.mylim6;}
		private String[] mystr7=new String[5000];
		void setmystr7(int a,String str){this.mystr7[a]=str;}
		String getmystr7(int a){return this.mystr7[a];}
		private int mylim7;
		void setlim7(int a){this.mylim7=a;}
		int getlim7(){return this.mylim7;}
		private String[] mystr8=new String[5000];
		private String[] mystr8a=new String[5000];
		void setmystr8(int a,String str){this.mystr8[a]=str;}
		void setmystr8a(int a,String str){this.mystr8a[a]=str;}
		String getmystr8(int a){return this.mystr8[a];}
		String getmystr8a(int a){return this.mystr8a[a];}
		private int mylim8;
		void setlim8(int a){this.mylim8=a;}
		int getlim8(){return this.mylim8;}
		
	}//class MyString
	
	class MyTableModel extends AbstractTableModel
	{
		 private String[] columnNames = {"line",
				                         "order",
				                         "date",
				                         "database",
				                         "table",
				                         "trend",
				                         "operation",
				                         "symbol",
				                         "track",
				                         "track time",
                                         "future price",
                                         "future month",
                                         "future year",
                                         "call price",
                                         "put price",
                                         "option month",
                                         "option year",
                                         "inoutthemoney",
                                         "strike",
                                         "price",
                                         "premium",
                                         "ratioriskfactor",
                                         "value",
                                         "profit(loss)",
                                         "*No.",
                                         "Total P/(L)"
		                                 };
		                               
		 private String[][] data = new String[100][100];
		
		 void setdata(int a,int b,String c){this.data[a][b]=c;}
		 String getdata(int a,int b){return (String)this.getValueAt(a,b);}
		 
		 String getdate()
		 {
		    String date="";
			Calendar cal = Calendar.getInstance();
			int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			int Month = cal.get(Calendar.MONTH)+1;
			int Year = cal.get(Calendar.YEAR);
			date=String.valueOf(dayOfMonth)+String.valueOf(Month)+String.valueOf(Year);
		    return date;	
		 }//getdate
		 
         void connect(String database)
         {
        	 try{
        	 System.out.println("start connect MyTableModel");
        	 System.out.println(database);
        	 String databasename="";
     		databasename=database;  		
     		String url    = "jdbc:postgresql://localhost:5432/"+databasename;
     		String username = "postgres";
             String password="postgres";
             Class.forName("org.postgresql.Driver");
       //      System.out.println("1");
     		Connection conn=DriverManager.getConnection(url,username,password);
     	//	 System.out.println("2");
     		Statement stat=conn.createStatement();
     		// System.out.println("3");
     		mfg.setmyresult("ok");//result="ok";
     		System.out.println("result="+mfg.getmyresult());
     	//	System.out.println("4")	;
     		ResultSet result2;
    		String cmd1="";
    		String thevale3="";
    		cmd1="SELECT COUNT(table_name) FROM information_schema.tables WHERE table_name ILIKE '%ff2%'";	// count number of table
    		System.out.println("cmd17="+cmd1);
			result2=stat.executeQuery(cmd1);
    		while(result2.next())
    		{
    			thevale3=result2.getString(1);
    		}	
    		int lim=Integer.parseInt(thevale3); 		
      		
    		ResultSet result4;
    		String cmd4="";
    		String[] thevale4=new String[lim+1];
    		cmd4="SELECT table_name FROM information_schema.tables WHERE table_name ILIKE '%ff2%' order by table_name";	// database
    		System.out.println("cmd18="+cmd4);
			result4=stat.executeQuery(cmd4);
    	    int k=1;
    		while(result4.next())
    		{
    			thevale4[k]=result4.getString(1);
    			k++;
    		}
			for(int c=1;c<=lim;c++)
    		{
    		//	System.out.println(thevale4[c]);
    			ms2.setmystr2(c,thevale4[c]);	
    		}	
     		conn.close();
     		stat.close();
     		mdb.setmydatabase(databasename);//mydatabase=databasename;
     		//mcb.removeAll();
     		if(flagcreategui==true){
     		mcb.removeAllItems();
     		for(int b=1;b<=lim;b++){
     		mcb.addItem(ms2.getmystr2(b).trim());
     	//	System.out.println(ms2.getmystr2(b));
     		}
     		}
     		if(flagcreategui2==true){
     			mjcb3.removeAllItems();
         		for(int b=1;b<=lim;b++){
         			mjcb3.addItem(ms2.getmystr2(b).trim());
         	//	System.out.println(ms2.getmystr2(b));
         		}
     		}
     		System.out.println("stop connect MyTableModel");
        	 }
        	 catch(Exception ex1){ex1.getMessage();ex1.getStackTrace();mfg.setmyresult("nok");}
        	 finally{mfg.setmyflag(mfg.getmyresult());/*System.out.println("myflag="+mfg.getmyflag());*/connectlabel.setText(mfg.getmyflag());}
         }//connect
         
		public int getRowCount() 
		{
			// TODO Auto-generated method stub
			return data.length;
		}	//	getRowCount
		public int getColumnCount()
		{
			// TODO Auto-generated method stub
			return columnNames.length;
		}//getColumnCount
		 public String getColumnName(int col) 
		 {
	            return columnNames[col];
	        }	//	getColumnName
		public Object getValueAt(int row, int col) 
		{
			// TODO Auto-generated method stub
			return  data[row][col];
		}		//getValueAt
	}//class MyTableModel
	class MySaveTable
	{
		void savedata(int therowcount)
		{
			try{
				System.out.println("start savedata mysavetable");		
				// IF NO DATABASE EXIST , CREATES THEM(23) FROM DEFAULT DATABASE , 
				// TO ENABLE CONNECTION TO THEM IN THE FOLLOWING PART (ELSE CAN NOT CONNECT)
				System.out.println("1");
				
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
				databasexistflag=false;
				databasename="ff2tracker";
				String cmd="select datname from pg_database where datname ilike '"+databasename+"';";
				//System.out.println(cmd);
				System.out.println("cmd19="+cmd);
				result1=stat.executeQuery(cmd);
				while(result1.next())
				{
					if( databasename.equalsIgnoreCase(result1.getString(1)) )
					{
						databasexistflag=true;
						System.out.println("databasename="+databasename+" resultfromquery="+result1.getString(1)+" databasexistflag="+databasexistflag);
						
					}
				}
				System.out.println("1.1");
				if(databasexistflag==false)
				{
					String cmd3="CREATE DATABASE "+databasename;
					//System.out.println(cmd3);
					System.out.println("cmd20="+cmd3);
					stat.executeUpdate(cmd3);
				}
				stat.close();
				conn.close();
				System.out.println("2");
				
				 databasename="ff2tracker";
				 url    = "jdbc:postgresql://localhost:5432/"+databasename;
	    		 username = "postgres";
	    		 password = "postgres"; 
	    		Class.forName("org.postgresql.Driver");
	    		 conn=DriverManager.getConnection(url,username,password);
	    		 stat=conn.createStatement();    		
			    String tablename="ff2trackertable";
				// test information_schema table for tablename existence
			    String cmd1="select table_name from information_schema.tables where table_name ILIKE '"+tablename+"';";
			    //System.out.println(cmd1);
			    ResultSet result5;
			    System.out.println("2.001");
			    System.out.println("cmd21="+cmd1);
			    result5=stat.executeQuery(cmd1);
			    String res0="";
			   // System.out.println("2.01");
			    while(result5.next())
			    {
			    	res0=result5.getString(1);
			    }
			   // System.out.println("2.02");
			    boolean tableexistflag=false;
			    if(res0.equalsIgnoreCase(tablename)){tableexistflag=true;}else{tableexistflag=false;}
			    stat.close();
				conn.close();
				System.out.println("2.1");
				
				databasename="ff2tracker";
				 url    = "jdbc:postgresql://localhost:5432/"+databasename;
	    		 username = "postgres";
	    		 password = "postgres"; 
	    		Class.forName("org.postgresql.Driver");
	    		 conn=DriverManager.getConnection(url,username,password);
	    		 stat=conn.createStatement();    		
			    tablename="ff2trackertable";
			    
			    if(tableexistflag==true)
			    {
			    	String cmd4="DROP TABLE "+tablename+";";
			    	//System.out.println(cmd4);
			    	System.out.println("cmd22="+cmd4);
			    	stat.executeUpdate(cmd4);
			    }
			    stat.close();
				conn.close();
				System.out.println("3");
				
			 databasename="ff2tracker";
			 url    = "jdbc:postgresql://localhost:5432/"+databasename;
    		 username = "postgres";
    		 password = "postgres"; 
    		Class.forName("org.postgresql.Driver");
    		 conn=DriverManager.getConnection(url,username,password);
    		 stat=conn.createStatement();    		
		     tablename="ff2trackertable";
		    cmd1="CREATE TABLE IF NOT EXISTS "+tablename+" (line CHAR(50),morder CHAR(50),date CHAR(50),database CHAR(50),ff2table CHAR(50),trend CHAR(50),operation CHAR(50),symbol CHAR(50),track CHAR(50),tracktime CHAR(50),futureprice CHAR(50),futuremonth CHAR(50),futureyear CHAR(50),callprice CHAR(50),putprice CHAR(50),optionmonth CHAR(50),optionyear CHAR(50),inoutthemoney CHAR(50),strike CHAR(50),price CHAR(50),premium CHAR(50),ratio CHAR(50),value CHAR(50),profitloss CHAR(50),no CHAR(50),totalprofitloss CHAR(50));";
		    //System.out.println(cmd1);
		    System.out.println("cmd23="+cmd1);
			stat.executeUpdate(cmd1);
			stat.close();
			conn.close();
			System.out.println("4");
			 databasename="ff2tracker";
			 url    = "jdbc:postgresql://localhost:5432/"+databasename;
    		 username = "postgres";
    		 password = "postgres"; 
    		Class.forName("org.postgresql.Driver");
    		 conn=DriverManager.getConnection(url,username,password);
    		 stat=conn.createStatement();    		
		     tablename="ff2trackertable";
			String rs1="",rs2="",rs3="",rs4="",rs5="",rs6="",rs7="",rs8="",rs9="",rs10="",rs11="",rs12="",rs13="",rs14="",rs15="",rs16="",rs17="",rs18="",rs19="",rs20="",rs21="",rs22="",rs23="",rs24="",rs25="",rs26="";
			System.out.println("therowcount="+therowcount);
			for(int a=0;a<therowcount;a++)
			{

			rs1=mtm.getdata(a, 0);
			if(rs1!=null){rs1=rs1.trim();}else{rs1="";}
			
			rs2=mtm.getdata(a, 1);
			if(rs2!=null){rs2=rs2.trim();}else{rs2="";}
		
			rs3=mtm.getdata(a, 2);
			if(rs3!=null){rs3=rs3.trim();}else{rs3="";}
			
			rs4=mtm.getdata(a, 3);
			if(rs4!=null){rs4=rs4.trim();}else{rs4="";}
			
			rs5=mtm.getdata(a, 4);
			if(rs5!=null){rs5=rs5.trim();}else{rs5="";}
			
			rs6=mtm.getdata(a, 5);
			if(rs6!=null){rs6=rs6.trim();}else{rs6="";}
			
			rs7=mtm.getdata(a, 6);
			if(rs7!=null){rs7=rs7.trim();}else{rs7="";}
			
			rs8=mtm.getdata(a, 7);
			if(rs8!=null){rs8=rs8.trim();}else{rs8="";}
		
			rs9=mtm.getdata(a, 8);
			if(rs9!=null){rs9=rs9.trim();}else{rs9="";}
			
			rs10=mtm.getdata(a,9);
			if(rs10!=null){rs10=rs10.trim();}else{rs10="";}
			
			rs11=mtm.getdata(a, 10);
			if(rs11!=null){rs11=rs11.trim();}else{rs11="";}
			
			rs12=mtm.getdata(a, 11);
			if(rs12!=null){rs12=rs12.trim();}else{rs12="";}
			
			rs13=mtm.getdata(a, 12);
			if(rs13!=null){rs13=rs13.trim();}else{rs13="";}
			
			rs14=mtm.getdata(a, 13);
			if(rs14!=null){rs14=rs14.trim();}else{rs14="";}
			
			rs15=mtm.getdata(a, 14);
			if(rs15!=null){rs15=rs15.trim();}else{rs15="";}
			
			rs16=mtm.getdata(a, 15);
			if(rs16!=null){rs16=rs16.trim();}else{rs16="";}
			
			rs17=mtm.getdata(a, 16);
			if(rs17!=null){rs17=rs17.trim();}else{rs17="";}
			
			rs18=mtm.getdata(a, 17);
			if(rs18!=null){rs18=rs18.trim();}else{rs18="";}
			
			rs19=mtm.getdata(a, 18);
			if(rs19!=null){rs19=rs19.trim();}else{rs19="";}
			
			rs20=mtm.getdata(a, 19);
			if(rs20!=null){rs20=rs20.trim();}else{rs20="";}
			
			rs21=mtm.getdata(a, 20);
			if(rs21!=null){rs21=rs21.trim();}else{rs21="";}
			
			rs22=mtm.getdata(a, 21);
			if(rs22!=null){rs22=rs22.trim();}else{rs22="";}
			
			rs23=mtm.getdata(a, 22);
			if(rs23!=null){rs23=rs23.trim();}else{rs23="";}
			
			rs24=mtm.getdata(a, 23);
			if(rs24!=null){rs24=rs24.trim();}else{rs24="";}
			
			rs25=mtm.getdata(a, 24);
			if(rs25!=null){rs25=rs25.trim();}else{rs25="";}
			
			rs26=mtm.getdata(a, 25);
			if(rs26!=null){rs26=rs26.trim();}else{rs26="";}
			
			String cmd2="INSERT INTO "+tablename+" (line,morder,date,database,ff2table,trend,operation,symbol,track,tracktime,futureprice,futuremonth,futureyear,callprice,putprice,optionmonth,optionyear,inoutthemoney,strike,price,premium,ratio,value,profitloss,no,totalprofitloss) VALUES ('"+rs1+"','"+rs2+"','"+rs3+"','"+rs4+"','"+rs5+"','"+rs6+"','"+rs7+"','"+rs8+"','"+rs9+"','"+rs10+"','"+rs11+"','"+rs12+"','"+rs13+"','"+rs14+"','"+rs15+"','"+rs16+"','"+rs17+"','"+rs18+"','"+rs19+"','"+rs20+"','"+rs21+"','"+rs22+"','"+rs23+"','"+rs24+"','"+rs25+"','"+rs26+"');";
			//System.out.println(cmd2);
			System.out.println("cmd24="+cmd2);
		    stat.executeUpdate(cmd2);
		   
			}
			stat.close();
			conn.close();
			//System.out.println("5");
			System.out.println("stop savedata mysavetable");
			}
			catch(Exception ex3){ex3.getMessage();ex3.getStackTrace();}
		}
		int restoredata()
		{
			System.out.println("start restoredata");
			int rowcount=0;
			try{
			String  databasename="ff2tracker";
			String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
    		String username = "postgres";
    		String  password = "postgres"; 
    		Class.forName("org.postgresql.Driver");
    		Connection  conn=DriverManager.getConnection(url,username,password);
    		Statement stat=conn.createStatement();    		
		    String tablename="ff2trackertable";
			ResultSet result3;
			String cmd5="SELECT * FROM "+tablename;
			//System.out.println(cmd5);
			System.out.println("cmd25="+cmd5);
		    result3=stat.executeQuery(cmd5);
		    int m=0;
			while(result3.next())
			{
			
						mtm.setdata(m,0,result3.getString(1));
			        	mtm.fireTableCellUpdated(m, 0);
						
						mtm.setdata(m,1,result3.getString(2));
			        	mtm.fireTableCellUpdated(m, 1);
					
						mtm.setdata(m,2,result3.getString(3));
			        	mtm.fireTableCellUpdated(m, 2);
						
						mtm.setdata(m,3,result3.getString(4));
			        	mtm.fireTableCellUpdated(m, 3);
						
						mtm.setdata(m,4,result3.getString(5));
			        	mtm.fireTableCellUpdated(m, 4);
					
						mtm.setdata(m,5,result3.getString(6));
			        	mtm.fireTableCellUpdated(m, 5);
						
						mtm.setdata(m,6,result3.getString(7));
			        	mtm.fireTableCellUpdated(m, 6);
					
						mtm.setdata(m,7,result3.getString(8));
			        	mtm.fireTableCellUpdated(m, 7);
						
						mtm.setdata(m,8,result3.getString(9));
			        	mtm.fireTableCellUpdated(m, 8);
				
						mtm.setdata(m,9,result3.getString(10));
			        	mtm.fireTableCellUpdated(m, 9);
						
						mtm.setdata(m,10,result3.getString(11));
			        	mtm.fireTableCellUpdated(m, 10);
						
						mtm.setdata(m,11,result3.getString(12));
			        	mtm.fireTableCellUpdated(m, 11);
					
						mtm.setdata(m,12,result3.getString(13));
			        	mtm.fireTableCellUpdated(m, 12);
			        	
			        	mtm.setdata(m,13,result3.getString(14));
			        	mtm.fireTableCellUpdated(m, 13);
			        	
			        	mtm.setdata(m,14,result3.getString(15));
			        	mtm.fireTableCellUpdated(m, 14);
			        	
			        	mtm.setdata(m,15,result3.getString(16));
			        	mtm.fireTableCellUpdated(m, 15);
			        	
			        	mtm.setdata(m,16,result3.getString(17));
			        	mtm.fireTableCellUpdated(m, 16);
			        	
			        	mtm.setdata(m,17,result3.getString(18));
			        	mtm.fireTableCellUpdated(m, 17);
			        	
			        	mtm.setdata(m,18,result3.getString(19));
			        	mtm.fireTableCellUpdated(m, 18);
			        	
			        	mtm.setdata(m,19,result3.getString(20));
			        	mtm.fireTableCellUpdated(m, 19);
			        	
			        	mtm.setdata(m,20,result3.getString(21));
			        	mtm.fireTableCellUpdated(m, 20);
			        	
			        	mtm.setdata(m,21,result3.getString(22));
			        	mtm.fireTableCellUpdated(m, 21);
			        	
			        	mtm.setdata(m,22,result3.getString(23));
			        	mtm.fireTableCellUpdated(m, 22);
			        	
			        	mtm.setdata(m,23,result3.getString(24));
			        	mtm.fireTableCellUpdated(m, 23);
			        	
			        	mtm.setdata(m,24,result3.getString(25));
			        	mtm.fireTableCellUpdated(m, 24);
			        	
			        	mtm.setdata(m,25,result3.getString(26));
			        	mtm.fireTableCellUpdated(m, 25);
				m++;
			}
			//order=Integer.parseInt(result3.getString(2));
			//row=m;
			rowcount=m;
			result3.close();
			int result4;
			String cmd6="DROP TABLE "+tablename;
			//System.out.println(cmd6);
			System.out.println("cmd26="+cmd6);
		    result4=stat.executeUpdate(cmd6);
			conn.close();
			System.out.println("stop restoredata");
			}
			catch(Exception ex4){ex4.getMessage();ex4.getStackTrace();}
		//	order=
			return rowcount;
		}
	}//MySaveTable
	class MyUpdate
	{
		String getmusymbol(int row)
		{
			System.out.println("MyUpdate getmusymbol row="+row);
			try{
				String  databasename="ff2tracker";
				String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
	    		String username = "postgres";
	    		String  password = "postgres"; 
	    		Class.forName("org.postgresql.Driver");
	    		Connection  conn=DriverManager.getConnection(url,username,password);
	    		Statement stat=conn.createStatement();    		
			    String tablename="ff2trackertable";
			    setmytable(tablename);
				ResultSet result3;
				String cmd7="SELECT symbol FROM "+tablename+" where line = '"+row+"';";
				//System.out.println(cmd7);
				System.out.println("cmd27="+cmd7);
			    result3=stat.executeQuery(cmd7);
			    String res0="";
			    while(result3.next())
			    {
			    	res0=result3.getString(1);
			    }
			    String res1="";
			    if(res0.contains("current"))
			    {
			    	row=row+1;// actually this is strange// should be -1 // must find a way to explain it !!!
			    	System.out.println("MyUpdate getmusymbol :current: row="+row);
			    	String cmd="SELECT symbol FROM "+tablename+" where line = '"+row+"';";
			    	//System.out.println("cmd="+cmd);
			    	System.out.println("cmd28="+cmd);
			    	 result3=stat.executeQuery(cmd);
					  // String res1="";
					    while(result3.next())
					    {
					    	res1=result3.getString(1);
					    }
					    System.out.println("valuetext symbol="+res1);
					    setthissymbol(res1);
			    }
			    else
			    {
			    	 System.out.println("valuetext symbol="+res0);
					    setthissymbol(res0);
			    }
			   
			    stat.close();
			    conn.close();
			}
			catch(Exception e){e.printStackTrace();e.getMessage();}
		    return (String) getthissymbol();
		}
		
		String getmutable()
		{
			return (String)getmytable();
		}
		String getdatabase()
		{
			return (String)getmydatabase();
		}
		String getmyvaluetextsymbol(String database,String table,String symbol)
		{
			try{
				System.out.println("getmyvaluetextsymbol start");
				String symbol2=symbol.trim();
				System.out.println("getmyvaluetextsymbol database="+database+" table="+table.trim()+" symbol="+symbol2);
				String  databasename=database;
				String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
	    		String username = "postgres";
	    		String  password = "postgres"; 
	    		Class.forName("org.postgresql.Driver");
	    		Connection  conn=DriverManager.getConnection(url,username,password);
	    		Statement stat=conn.createStatement();    		
			    String tablename=table;
			  //  setmytable(tablename);
			    
				ResultSet result3;
				//  select valuetext from ff2plustrade1092016 where valuetext ilike '%SBN18%';
				String cmd="SELECT valuetext FROM "+tablename.trim()+" where valuetext ILIKE '%"+symbol2+"%';";//+"%'";//+"%';";
				//System.out.println("cmd="+cmd);
				System.out.println("cmd30="+cmd);
			    result3=stat.executeQuery(cmd);
			    String res0="";
			    while(result3.next())
			    {
			    	res0=result3.getString(1);
			    }
			    stat.close();
			    conn.close();
			    System.out.println("valuetextsymbol="+res0);
			    setmyvaluetextsymbol(res0);
			}
			catch(Exception e){e.printStackTrace();e.getMessage();}
			System.out.println("getmyvaluetextsymbol stop");
			return (String)getmyvaluetextsymbol1();
		}
		String getmyvaluetextsymboloption(String table)
		{
			//select valuetext from ff2plustradeb1092016 where valuetext ilike '%sugar%';
			//return (String) "";
			try{
				System.out.println("getmyvaluetextsymboloption start");
				String symbol2="sugar";
			//	System.out.println("="+database+" table="+table+" symbol="+symbol2);
				String  databasename="ff2plustradeb";
				String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
	    		String username = "postgres";
	    		String  password = "postgres"; 
	    		Class.forName("org.postgresql.Driver");
	    		Connection  conn=DriverManager.getConnection(url,username,password);
	    		Statement stat=conn.createStatement();    		
			    String tablename=table;
			  //  setmytable(tablename);
			    
				ResultSet result3;
				//  select valuetext from ff2plustrade1092016 where valuetext ilike '%SBN18%';
				String cmd="SELECT distinct valuetext FROM "+tablename.trim()+" where valuetext ILIKE '%"+symbol2+"%';";//+"%'";//+"%';";
				//System.out.println("cmd="+cmd);
				System.out.println("cmd31="+cmd);
			    result3=stat.executeQuery(cmd);
			    String[] res0=new String[10];
			    int i=0;
			    while(result3.next())
			    {
			    	res0[i]=result3.getString(1);
			    	i++;
			    }
			    result3.close();
			    stat.close();
			    conn.close();
			    System.out.println("result3.next() lim i ="+i);
			    System.out.println("valuetextsymboloption="+res0[0]);
			    setmyvaluetextsymboloption(res0[0]);
			}
			catch(Exception e){e.printStackTrace();e.getMessage();}
			System.out.println("getmyvaluetextsymboloption stop");
			return (String)getmyvaluetextsymboloption();
			
		}
		public void setthissymbol(String mysymb){this.mysymbol=mysymb;}
		public String getthissymbol(){return this.mysymbol;}
		private String mysymbol;
		private String mytable;
		private String mydatabase;
		private String myvaluetextsymbol;
		private String myvaluetextsymboloption;
		public void setmytable(String mytabl){this.mytable=mytabl;}
		public String getmytable(){return this.mytable;}
		public void setmydatabase(String mydatab){this.mydatabase=mydatab;}
		public String getmydatabase(){return this.mydatabase;}
		public void setmyvaluetextsymbol(String myvaluet){this.myvaluetextsymbol=myvaluet;}
		public String getmyvaluetextsymbol1(){return this.myvaluetextsymbol;}
		public void setmyvaluetextsymboloption(String myvaluetoption){this.myvaluetextsymboloption=myvaluetoption;}
		public String getmyvaluetextsymboloption(){return this.myvaluetextsymboloption;}
	}//MyUpdate
	class buttontracktimerdata
	{   
		Float getmyvalue(int myrow)
		{
			Float myvalue=(float)0;
			
			try{
			String  databasename="ff2tracker";
			String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
    		String username = "postgres";
    		String  password = "postgres"; 
    		Class.forName("org.postgresql.Driver");
    		Connection  conn=DriverManager.getConnection(url,username,password);
    		Statement stat=conn.createStatement();    
    		String tablename="ff2trackertable";
    		ResultSet result3;
    		String cmd="SELECT value FROM "+tablename+" where line ILIKE '%"+myrow+"%';";//
    		//System.out.println("cmd="+cmd);
    		System.out.println("cmd32="+cmd);
    		result3=stat.executeQuery(cmd);
   		    String res0=new String();  
			while(result3.next())
			{
			   res0=result3.getString(1);
			}
			result3.close();
			stat.close();
			conn.close();
			if (res0.trim().isEmpty()){res0="0";}
			myvalue=Float.parseFloat(res0);
			}
			catch(Exception ex){ex.getMessage();ex.printStackTrace();}
			return myvalue;
			//return (float)0.0;
		}
		String optimizing(Float fut)
		{
			System.out.println("optimizing1 ="+fut);
			float thefut=(float)fut;
			System.out.println("optimizing2 ="+thefut);
			int tmpint=(int)thefut;
			System.out.println("optimizing3 ="+tmpint);
			int intpart=Math.round(tmpint);
			System.out.println("optimizing4 intpart ="+intpart);
			Float decimalpart1=fut-intpart;
			int decimalpart=(int)(decimalpart1*100);
			//double decimalpart3=(double)(decimalpart2/(double)100);
			//double decimalpart=(double)decimalpart3;
			System.out.println("optimizing5 decimalpart ="+decimalpart);
			if (decimalpart==0){decimalpart=(int)0.0;}
			if ((decimalpart>0)&&(decimalpart<25))
			{
				if ((decimalpart>0)&&(decimalpart<=12)){decimalpart=(int)0.0;}
				if ((decimalpart>=13)&&(decimalpart<25)){decimalpart=(int)0.25;}
			}
			if (decimalpart==25){decimalpart=(int)25;}
			if ((decimalpart>25)&&(decimalpart<50))
			{
				if ((decimalpart>25)&&(decimalpart<=37)){decimalpart=(int)25;}
				if ((decimalpart>=38)&&(decimalpart<50)){decimalpart=(int)50;}
			}
			if (decimalpart==50){decimalpart=(int)50;}
			if ((decimalpart>50)&&(decimalpart<75))
			{
				if ((decimalpart>50)&&(decimalpart<=62)){decimalpart=(int)50;}
				if ((decimalpart>=63)&&(decimalpart<75)){decimalpart=(int)75;}
			}
			if (decimalpart==75){decimalpart=(int)75;}
			if ((decimalpart>75)&&(decimalpart<100))
			{
				if ((decimalpart>75)&&(decimalpart<=87)){decimalpart=(int)75;}
				if ((decimalpart>=88)&&(decimalpart<100)){decimalpart=(int)100;}
			}
			//Float decimalpart5=Float.parseFloat(new Double(decimalpart).toString());
			Float decimalpart5=Float.parseFloat(new Double(decimalpart/(double)100).toString());
			Float newfut=(Float)(intpart+decimalpart5);
			System.out.println("optimizing6 ="+newfut);
			return String.valueOf(newfut);
		}
		int getlastrow()
		{
			int line=0;
			cst.savet();
			try{
			String  databasename="ff2tracker";
			String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
    		String username = "postgres";
    		String  password = "postgres"; 
    		Class.forName("org.postgresql.Driver");
    		Connection  conn=DriverManager.getConnection(url,username,password);
    		Statement stat=conn.createStatement();    
    		String tablename="ff2trackertable";
    		ResultSet result3;
    		String cmd="SELECT max(line) FROM "+tablename+";";// but this table is erased while in use as a gui, must do a savet first (hopefully that should do it?) !!! solved by :=> cst.savet();
    		//System.out.println("cmd="+cmd);
    		System.out.println("cmd33="+cmd);
    		result3=stat.executeQuery(cmd);
   		    String res0=new String();  
			while(result3.next())
			{
			   res0=result3.getString(1);
			}
			result3.close();
			stat.close();
			conn.close();
			line=Integer.parseInt(res0.trim());
			}
			catch(Exception ex){ex.getMessage();ex.printStackTrace();}
			return line;
		}
		String gettodaysdate()
		{
			
			
			String tabledate="";
			Calendar cal = Calendar.getInstance();
			int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			int Month = cal.get(Calendar.MONTH)+1;
			int Year = cal.get(Calendar.YEAR);
			
			String zero="0";	
			String stringdayofmonth="";
			String stringmonth="";
			if(dayOfMonth<10){stringdayofmonth=zero+String.valueOf(dayOfMonth);}
			if(dayOfMonth>9){stringdayofmonth=String.valueOf(dayOfMonth);}
			if(Month<10){stringmonth=zero+String.valueOf(Month);}
			if(Month>9){stringmonth=String.valueOf(Month);}
			tabledate=stringdayofmonth+stringmonth+String.valueOf(Year);
			
			return (String)tabledate;
		}//gettodaysdate
		String tableadjustday(String table,String day)
		{
			String tmptable1="";
			String tmptable2="";
			int length=table.length();
			//int index =length-(2+2+4);
			tmptable1=table.substring(0,length-8);
			tmptable2=tmptable1+day;
			return tmptable2;
		}//tableadjustday
		
		void storenewdata(myfuture myfu,myoption myop,int lastrow,int order,String day,String symbol,Float futureprice,String futuretable,String futuredatabase,String optiontable,String optiondatabase)
		{
			try{
			System.out.println("storenewdata start");
			//1 request on futuredatabase futuretableday symbol for result on futureprice
			//2 store above result in ff2trackertable gui before doing a savet to insert gui data into ff2trackertable
			//3 request on optiondatabase optiontableday for result on current,strike, premium for seleted futureprice
			//4 store above result
			//5 do same as update
			//6 track calculation
			
			//1
			
			String  databasename=futuredatabase;
			System.out.println("databasename ="+databasename);
			String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
    		String username = "postgres";
    		String  password = "postgres"; 
    		Class.forName("org.postgresql.Driver");
    		Connection  conn=DriverManager.getConnection(url,username,password);
    		Statement stat=conn.createStatement();   
    		System.out.println("futuretable ="+futuretable);
    		String tablename=futuretable;
    		ResultSet result3;
    		String cmd="SELECT valuetext FROM "+tablename+" where attributeid ILIKE '%"+symbol+"%';";
    		//System.out.println("cmd="+cmd);
    		System.out.println("cmd34="+cmd);
    		result3=stat.executeQuery(cmd);
   		    String res0=new String();  
			while(result3.next())
			{
			   res0=result3.getString(1);
			}
			result3.close();
			stat.close();
			conn.close();
			Float newfutureprice=Float.parseFloat(res0);
			myfu.setfutureprice(newfutureprice);
			
			//2
			
			// save row future in gui trackertable
			int theposition=0;//line
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(lastrow+1));
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 
		    theposition=1;//order
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(order));
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 
		    theposition=2;//date
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(day));
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 
		    theposition=3;//database
			mtm.setdata(lastrow+1,theposition,(String)futuredatabase);
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 
		    theposition=4;//table
			mtm.setdata(lastrow+1,theposition,(String)futuretable);
		    mtm.fireTableCellUpdated(lastrow+1, theposition);
		    theposition=5;//trend
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(myfu.gettrend()));
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 
		    theposition=6;//operation
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(myfu.getoperation()));
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 
		    theposition=7;//symbol
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(symbol));
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 
		    theposition=8;//track
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(myfu.gettrack()));
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 
		    theposition=9;//tracktime
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(myfu.gettracktime()));
		    mtm.fireTableCellUpdated(lastrow+1, theposition); 		    
			theposition=10;//future price
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(newfutureprice));
		    mtm.fireTableCellUpdated(lastrow+1, theposition);    
		    // future month and future year will be treated during update
		    // actually does not seem to be the case!!!
		    theposition=11;//future month
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(myfu.myfuturemonth));
		    mtm.fireTableCellUpdated(lastrow+1, theposition);
		    theposition=12;//future year
			mtm.setdata(lastrow+1,theposition,(String)String.valueOf(myfu.myfutureyear));
		    mtm.fireTableCellUpdated(lastrow+1, theposition);
		    
			cst.savet();
			
		    //3
		    //3 request on optiondatabase optiontableday for result on current,strike, premium for selected futureprice
			
		    
		    databasename=optiondatabase;
		    System.out.println("databasename ="+databasename);
			url    = "jdbc:postgresql://localhost:5432/"+databasename;
    		username = "postgres";
    		password = "postgres"; 
    		Class.forName("org.postgresql.Driver");
    		conn=DriverManager.getConnection(url,username,password);
    		stat=conn.createStatement();    
    		tablename=optiontable;
    		String optimizedfutureprice="";
    		System.out.println("newfutureprice ="+newfutureprice);
    		optimizedfutureprice=optimizing(newfutureprice);
    		System.out.println("optimizedfutureprice ="+optimizedfutureprice);
    		cmd="SELECT current,strike,premium FROM "+tablename+" where strike ILIKE '%"+optimizedfutureprice+"%';";
    		//System.out.println("cmd="+cmd);
    		ResultSet result4;
    		System.out.println("cmd35="+cmd);
    		result4=stat.executeQuery(cmd);
   		    String[] res1=new String[5];  
			while(result4.next())
			{
			   res1[0]=result4.getString(1);
			   res1[1]=result4.getString(2);
			   res1[2]=result4.getString(3);
			}
			result4.close();
			stat.close();
			conn.close();
			String tmpstringres10=res1[0].replace("s","");
			Float newcurrent=Float.parseFloat(tmpstringres10);
			myop.setputprice(newcurrent);
			// bearish call price case has to be treated !!!
			String tmpstringres11=res1[1].replace("P","");
			Float newstrike=Float.parseFloat(tmpstringres11);
			myop.setstrike(newstrike);
			String tmpstringres12=res1[2].replace(",","");
			Float newpremium=Float.parseFloat(tmpstringres12);
			myop.setpremium(newpremium);
			
		    //4   
			// save row option in guitrackertable
			
		    theposition=0;//line
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(lastrow+2));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=1;//order
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(order));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=2;//date
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(day));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=3;//database
			mtm.setdata(lastrow+2,theposition,(String)optiondatabase);
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=4;//table
			mtm.setdata(lastrow+2,theposition,(String)optiontable);
		    mtm.fireTableCellUpdated(lastrow+2, theposition);
		    theposition=5;//trend
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.gettrend()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=6;//operation
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getoperation()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=7;//symbol
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getmosymbol()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=8;//track
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.gettrack()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=9;//tracktime
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.gettracktime()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=13;//call price
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getcallprice()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=14;//put price
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getputprice()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=15;//option month
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getoptionmonth()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=16;//option year
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getoptionyear()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=17;//inoutthemoney
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getinoutthemoney()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition);
		    theposition=18;//strike
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getstrike()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=19;//price
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getprice()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=20;//premium
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getpremium()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=21;//ratioriskfactor
			mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getratioriskfactor()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=22;//value
		 	mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getvalue()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=23;//profitloss
		    mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getprofitloss()));
		 	mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    theposition=24;//no
		    mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getno()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		 	theposition=25;//totalpl
		    mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.gettotalpl()));
		    mtm.fireTableCellUpdated(lastrow+2, theposition); 
		    cst.savet();
		    //5
		    //5 do same as update
		    cud.update();   
		    cst.savet();
		    
		    //6
		    //6 track calculation
		    int mylastrow=bttd.getlastrow();
		    int mypreviousrow=mylastrow-2;
		    Float lastvalue=getmyvalue(mylastrow);
		    Float previousvalue=getmyvalue(mypreviousrow);
		    Float profitloss=lastvalue-previousvalue;
		    myop.setprofitloss(profitloss);
		    theposition=23;//profitloss
		    mtm.setdata(lastrow+2,theposition,(String)String.valueOf(myop.getprofitloss()));
		 	mtm.fireTableCellUpdated(lastrow+2, theposition);
		    
			System.out.println("storenewdata stop");
			}
			catch(Exception e){e.printStackTrace();e.getMessage();}	
		}//storenewdata
		void getdatafromrow(int row)
		{
			//select * from ff2trackertable where line = '53';
			try
			{
				System.out.println("getdatafromrow start");
				cst.savet();
				String  databasename="ff2tracker";
				String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
	    		String username = "postgres";
	    		String  password = "postgres"; 
	    		Class.forName("org.postgresql.Driver");
	    		Connection  conn=DriverManager.getConnection(url,username,password);
	    		Statement stat=conn.createStatement();    
	    		String tablename="ff2trackertable";
	    		ResultSet result3;
	    		String myrow=String.valueOf(row);
	    		String cmd="SELECT * FROM "+tablename+" where line = '"+myrow+"';";
	    		//System.out.println("cmd="+cmd);
	    		System.out.println("cmd36="+cmd);
	    		result3=stat.executeQuery(cmd);
	    		 String[] res0=new String[27];
				    int i=0;
				    while(result3.next())
				    {
				    	res0[0]=result3.getString(1);
				    	res0[1]=result3.getString(2);
				    	res0[2]=result3.getString(3);
				    	res0[3]=result3.getString(4);
				    	res0[4]=result3.getString(5);
				    	res0[5]=result3.getString(6);
				    	res0[6]=result3.getString(7);
				    	res0[7]=result3.getString(8);
				    	res0[8]=result3.getString(9);
				    	res0[9]=result3.getString(10);
				    	res0[10]=result3.getString(11);
				    	res0[11]=result3.getString(12);
				    	res0[12]=result3.getString(13);
				    	res0[13]=result3.getString(14);
				    	res0[14]=result3.getString(15);
				    	res0[15]=result3.getString(16);
				    	res0[16]=result3.getString(17);
				    	res0[17]=result3.getString(18);
				    	res0[18]=result3.getString(19);
				    	res0[19]=result3.getString(20);
				    	res0[20]=result3.getString(21);
				    	res0[21]=result3.getString(22);
				    	res0[22]=result3.getString(23);
				    	res0[23]=result3.getString(24);
				    	res0[24]=result3.getString(25);
				    	res0[25]=result3.getString(26);
				    	//System.out.println(res0[i]);
				    	i++;
				    }
				    result3.close();
				    stat.close();
				    conn.close();
				    String tmpstringres00=res0[0].replace('"',' ');
				    setline(Integer.parseInt(tmpstringres00.trim()));
				    String tmpstringres01=res0[1].replace('"',' ');
				    setorder(Integer.parseInt(tmpstringres01.trim()));
				    String tmpstringres02=res0[2].replace('"',' ');
				    setdate(Integer.parseInt(tmpstringres02.trim()));
				    String tmpstringres03=res0[3].replace('"',' ');
				    setdatabase(tmpstringres03.trim());
				    String tmpstringres04=res0[4].replace('"',' ');
				    System.out.println("setbttdtable ="+tmpstringres04.trim());
				  //  if(setmftable){} ?
				 //   if(setmotable){} ?
				    setbttdtable(tmpstringres04.trim());
				    String tmpstringres05=res0[5].replace('"',' ');
				    settrend(tmpstringres05.trim());
				    String tmpstringres06=res0[6].replace('"',' ');
				    setoperation(tmpstringres06.trim());
				    String tmpstringres07=res0[7].replace('"',' ');
				    setbttdsymbol(tmpstringres07.trim());
				    String tmpstringres08=res0[8].replace('"',' ');
				    settrack(tmpstringres08.trim());
				    String tmpstringres09=res0[9].replace('"',' ');
				    settracktime(tmpstringres09.trim());
				    String tmpstringres10=res0[10].replace('"',' ');
				    if(tmpstringres10.trim().isEmpty()){tmpstringres10="0.0";}
				    Float setfutureprice=Float.parseFloat(tmpstringres10.trim());
				    System.out.println("setfutureprice ="+setfutureprice);
				    setfutureprice(setfutureprice);
				    System.out.println("setfutureprice done");
				    String tmpstringres011=res0[11].replace('"',' ');
				    setfuturemonth(tmpstringres011.trim());
				    System.out.println("setfuturemonth done");
				    String tmpstringres012=res0[12].replace('"',' ');
				    if(tmpstringres012.trim().isEmpty()){tmpstringres012="0";}
				    setfutureyear(Integer.parseInt(tmpstringres012.trim()));
				    System.out.println("setfutureyear done");
				    System.out.println("res0[13] ="+res0[13]);
				    String tmpstringres013=res0[13].replace('"',' ');
				    String tmpstringres0131=tmpstringres013.replace('s',' ');
				    if(tmpstringres0131.trim().isEmpty()){tmpstringres0131="0.0";}
				    Float setcallprice=Float.parseFloat(tmpstringres0131.trim());
				    System.out.println("setcallprice ="+setcallprice);
				    setcallprice(setcallprice);
				    System.out.println("setcallprice done");
				    String tmpstringres014=res0[14].replace('"',' ');
				    String tmpstringres0141=tmpstringres014.replace('s',' ');
				    if(tmpstringres0141.trim().isEmpty()){tmpstringres0141="0.0";}
				    setputprice(Float.parseFloat(tmpstringres0141.trim()));
				    System.out.println("setputprice done");
				    String tmpstringres015=res0[15].replace('"',' ');
				    setoptionmonth(tmpstringres015.trim());
				    System.out.println("setoptionmonth done");
				    System.out.println("res0[16] ="+res0[16]);
				    String tmpstringres016=res0[16].replace('"',' ');
				    String tmpstringres0161=tmpstringres016.replace("ch","");
				    String tmpstringres0162=tmpstringres0161.replace("Options","");
				    String tmpstringres0163=tmpstringres0162.replace("Selec.","");
				    if(tmpstringres0163.trim().isEmpty()){tmpstringres0163="0";}
				    setoptionyear(Integer.parseInt(tmpstringres0163.trim()));
				    System.out.println("setoptionyear done");
				    String tmpstringres017=res0[17].replace('"',' ');
				    setinoutthemoney(tmpstringres017.trim());
				    System.out.println("setinoutthemoney done");
				    String tmpstringres018=res0[18].replace('"',' ');
				    String tmpstringres0181=tmpstringres018.replace('P',' ');
				    if(tmpstringres0181.trim().isEmpty()){tmpstringres0181="0.0";}
				    setstrike(Float.parseFloat(tmpstringres0181.trim()));
				    System.out.println("setstrike done");
				    String tmpstringres019=res0[19].replace('"',' ');
				    if(tmpstringres019.trim().isEmpty()){tmpstringres019="0.0";}
				    setprice(Float.parseFloat(tmpstringres019.trim()));
				    System.out.println("setprice done");
				    String tmpstringres020=res0[20].replace('"',' ');
				    String tmpstringres0201=tmpstringres020.replace(",","");
				    if(tmpstringres0201.trim().isEmpty()){tmpstringres0201="0.0";}				    
				    setpremium(Float.parseFloat(tmpstringres0201.trim()));
				    System.out.println("setpremium done");
				    String tmpstringres021=res0[21].replace('"',' ');
				    if(tmpstringres021.trim().isEmpty()){tmpstringres021="0.0";}
				    setratioriskfactor(Float.parseFloat(tmpstringres021.trim()));
				    System.out.println("setratioriskfactor done");
				    String tmpstringres022=res0[22].replace('"',' ');
				    if(tmpstringres022.trim().isEmpty()){tmpstringres022="0.0";}
				    setvalue(Float.parseFloat(tmpstringres022.trim()));
				    System.out.println("setvalue done");
				    String tmpstringres023=res0[23].replace('"',' ');
				    if(tmpstringres023.trim().isEmpty()){tmpstringres023="0.0";}
				    setprofitloss(Float.parseFloat(tmpstringres023.trim()));
				    System.out.println("setprofitloss done");
				    String tmpstringres024=res0[24].replace('"',' ');
				    if(tmpstringres024.trim().isEmpty()){tmpstringres024="0.0";}
				    setno(Float.parseFloat(tmpstringres024.trim()));
				    System.out.println("setno done");
				    String tmpstringres025=res0[25].replace('"',' ');
				    if(tmpstringres025.trim().isEmpty()){tmpstringres025="0.0";}
				    settotalpl(Float.parseFloat(tmpstringres025.trim()));
				    System.out.println("settotalpl done");
				System.out.println("getdatafromrow stop");
			}
			catch(Exception e){e.printStackTrace();e.getMessage();}	
			
		
	}//getdatafromrow
	//line order date database table trend operation symbol track futureprice futuremonth futureyear callprice putprice optionmonth optionyear inouthemoney strike price premium ratioriskfactor value profitloss No totalpl
	private int myline;
	private int myorder;
	private int mydate;
	private String mydatabase;
	private String mytable;
	private String mytrend;
	private String myoperation;
	private String mysymbol;
	private String mytrack;
	private String mytracktime;
	private float myfutureprice2;
	private String myfuturemonth;
	private int myfutureyear;
	private float mycallprice;
	private float myputprice;
	private String myoptionmonth;
	private int myoptionyear;
	private String myinoutthemoney;
	private float mystrike2;
	private float myprice;
	private float mypremium2;
	private float myratioriskfactor;
	private float myvalue;
	private float myprofitloss;
	private float myno;
	private float mytotalpl;
	int getline(){return this.myline;};
	void setline(int line){this.myline=line;};
	int getorder(){return this.myorder;}
	void setorder(int order){this.myorder=order;}
	int getdate(){return this.mydate;};
	void setdate(int date){this.mydate=date;};
	String getdatabase(){return (String)this.mydatabase;};
	void setdatabase(String database){this.mydatabase=database;};
	String getbttdtable(){return this.mytable;};
	void setbttdtable(String table){this.mytable=table;};
	String gettrend(){return this.mytrend;};          
	void settrend(String trend){this.mytrend=trend;};
	String getoperation(){return this.myoperation;};
	void setoperation(String operation){this.myoperation=operation;};
	String getbttdsymbol(){return this.mysymbol;};
	void setbttdsymbol(String symbol){this.mysymbol=symbol;};
	String gettrack(){return this.mytrack;};
	void settrack(String track){this.mytrack=track;};
	String gettracktime(){return this.mytracktime;};
	void settracktime(String tracktime){this.mytracktime=tracktime;};
	float getfutureprice(){return this.myfutureprice2;};
	void setfutureprice(float futureprice){this.myfutureprice2=futureprice;};
	String getfuturemonth(){return this.myfuturemonth;};
	void setfuturemonth(String futuremonth){this.myfuturemonth=futuremonth;};
	int getfutureyear(){return this.myfutureyear;};
	void setfutureyear(int futureyear){this.myfutureyear=futureyear;};
	float getcallprice(){return this.mycallprice;};
	void setcallprice(float callprice){this.mycallprice=callprice;};
	float getputprice(){return this.myputprice;};
	void setputprice(float putprice){this.myputprice=putprice;};
	String getoptionmonth(){return this.myoptionmonth;};
	void setoptionmonth(String optionmonth){this.myoptionmonth=optionmonth;};
	int getoptionyear(){return this.myoptionyear;};
	void setoptionyear(int optionyear){this.myoptionyear=optionyear;};
	String getinoutthemoney(){return this.myinoutthemoney;};
	void setinoutthemoney(String inoutthemoney){this.myinoutthemoney=inoutthemoney;};
	float getstrike(){return this.mystrike2;};
	void setstrike(float strike){this.mystrike2=strike;};
	float getprice(){return this.myprice;};
	void setprice(float price){this.myprice=price;};
	float getpremium(){return this.mypremium2;};
	void setpremium(float premium){this.mypremium2=premium;};
	float getratioriskfactor(){return this.myratioriskfactor;};
	void setratioriskfactor(float ratioriskfactor){this.myratioriskfactor=ratioriskfactor;};
	float getvalue(){return this.myvalue;};
	void setvalue(float value){this.myvalue=value;};
	float getprofitloss(){return this.myprofitloss;};
	void setprofitloss(float profitloss){this.myprofitloss=profitloss;};
	float getno(){return this.myno;};
	void setno(float no){this.myno=no;};
	float gettotalpl(){return this.mytotalpl;};
	void settotalpl(float totalpl){this.mytotalpl=totalpl;};
}//class buttontracktimerdata
	class myfuture
	{
		private int myline;
		private int myorder;
		private int mydate;
		private String mydatabase;
		private String mytable;
		private String mytrend;
		private String myoperation;
		private String mysymbol;
		private String mytrack;
		private String mytracktime;
		private float myfutureprice2;
		private String myfuturemonth;
		private int myfutureyear;
		private float mycallprice;
		private float myputprice;
		private String myoptionmonth;
		private int myoptionyear;
		private String myinoutthemoney;
		private float mystrike2;
		private float myprice;
		private float mypremium2;
		private float myratioriskfactor;
		private float myvalue;
		private float myprofitloss;
		private float myno;
		private float mytotalpl;
		int getline(){return this.myline;};
		void setline(int line){this.myline=line;};
		int getorder(){return this.myorder;}
		void setorder(int order){this.myorder=order;}
		int getdate(){return this.mydate;};
		void setdate(int date){this.mydate=date;};
		String getdatabase(){return (String)this.mydatabase;};
		void setdatabase(String database){this.mydatabase=database;};
		String getmftable(){return this.mytable;};
		void setmftable(String table){this.mytable=table;};
		String gettrend(){return this.mytrend;};          
		void settrend(String trend){this.mytrend=trend;};
		String getoperation(){return this.myoperation;};
		void setoperation(String operation){this.myoperation=operation;};
		String getmfsymbol(){return this.mysymbol;};
		void setmfsymbol(String symbol){this.mysymbol=symbol;};
		String gettrack(){return this.mytrack;};
		void settrack(String track){this.mytrack=track;};
		String gettracktime(){return this.mytracktime;};
		void settracktime(String tracktime){this.mytracktime=tracktime;};
		//trackerdatainput21072016.trackerdatainput21072016.myfuture
		
		float getfutureprice(){return this.myfutureprice2;};
		void setfutureprice(float futureprice){this.myfutureprice2=futureprice;};
		String getfuturemonth(){return this.myfuturemonth;};
		void setfuturemonth(String futuremonth){this.myfuturemonth=futuremonth;};
		int getfutureyear(){return this.myfutureyear;};
		void setfutureyear(int futureyear){this.myfutureyear=futureyear;};
		float getcallprice(){return this.mycallprice;};
		void setcallprice(float callprice){this.mycallprice=callprice;};
		float getputprice(){return this.myputprice;};
		void setputprice(float putprice){this.myputprice=putprice;};
		String getoptionmonth(){return this.myoptionmonth;};
		void setoptionmonth(String optionmonth){this.myoptionmonth=optionmonth;};
		int getoptionyear(){return this.myoptionyear;};
		void setoptionyear(int optionyear){this.myoptionyear=optionyear;};
		String getinoutthemoney(){return this.myinoutthemoney;};
		void setinoutthemoney(String inoutthemoney){this.myinoutthemoney=inoutthemoney;};
		float getstrike(){return this.mystrike2;};
		void setstrike(float strike){this.mystrike2=strike;};
		float getprice(){return this.myprice;};
		void setprice(float price){this.myprice=price;};
		float getpremium(){return this.mypremium2;};
		void setpremium(float premium){this.mypremium2=premium;};
		float getratioriskfactor(){return this.myratioriskfactor;};
		void setratioriskfactor(float ratioriskfactor){this.myratioriskfactor=ratioriskfactor;};
		float getvalue(){return this.myvalue;};
		void setvalue(float value){this.myvalue=value;};
		float getprofitloss(){return this.myprofitloss;};
		void setprofitloss(float profitloss){this.myprofitloss=profitloss;};
		float getno(){return this.myno;};
		void setno(float no){this.myno=no;};
		float gettotalpl(){return this.mytotalpl;};
		void settotalpl(float totalpl){this.mytotalpl=totalpl;};

	}// class myfuture
	class myoption
	{
		private int myline;
		private int myorder;
		private int mydate;
		private String mydatabase;
		private String mytable;
		private String mytrend;
		private String myoperation;
		private String mysymbol;
		private String mytrack;
		private String mytracktime;
		private float myfutureprice2;
		private String myfuturemonth;
		private int myfutureyear;
		private float mycallprice;
		private float myputprice;
		private String myoptionmonth;
		private int myoptionyear;
		private String myinoutthemoney;
		private float mystrike2;
		private float myprice;
		private float mypremium2;
		private float myratioriskfactor;
		private float myvalue;
		private float myprofitloss;
		private float myno;
		private float mytotalpl;
		int getline(){return this.myline;};
		void setline(int line){this.myline=line;};
		int getorder(){return this.myorder;}
		void setorder(int order){this.myorder=order;}
		int getdate(){return this.mydate;};
		void setdate(int date){this.mydate=date;};
		String getdatabase(){return (String)this.mydatabase;};
		void setdatabase(String database){this.mydatabase=database;};
		String getmotable(){return this.mytable;};
		void setmotable(String table){this.mytable=table;};
		String gettrend(){return this.mytrend;};          
		void settrend(String trend){this.mytrend=trend;};
		String getoperation(){return this.myoperation;};
		void setoperation(String operation){this.myoperation=operation;};
		String getmosymbol(){return this.mysymbol;};
		void setmosymbol(String symbol){this.mysymbol=symbol;};
		String gettrack(){return this.mytrack;};
		void settrack(String track){this.mytrack=track;};
		String gettracktime(){return this.mytracktime;};
		void settracktime(String tracktime){this.mytrack=tracktime;};
		float getfutureprice(){return this.myfutureprice2;};
		void setfutureprice(float futureprice){this.myfutureprice2=futureprice;};
		String getfuturemonth(){return this.myfuturemonth;};
		void setfuturemonth(String futuremonth){this.myfuturemonth=futuremonth;};
		int getfutureyear(){return this.myfutureyear;};
		void setfutureyear(int futureyear){this.myfutureyear=futureyear;};
		float getcallprice(){return this.mycallprice;};
		void setcallprice(float callprice){this.mycallprice=callprice;};
		float getputprice(){return this.myputprice;};
		void setputprice(float putprice){this.myputprice=putprice;};
		String getoptionmonth(){return this.myoptionmonth;};
		void setoptionmonth(String optionmonth){this.myoptionmonth=optionmonth;};
		int getoptionyear(){return this.myoptionyear;};
		void setoptionyear(int optionyear){this.myoptionyear=optionyear;};
		String getinoutthemoney(){return this.myinoutthemoney;};
		void setinoutthemoney(String inoutthemoney){this.myinoutthemoney=inoutthemoney;};
		float getstrike(){return this.mystrike2;};
		void setstrike(float strike){this.mystrike2=strike;};
		float getprice(){return this.myprice;};
		void setprice(float price){this.myprice=price;};
		float getpremium(){return this.mypremium2;};
		void setpremium(float premium){this.mypremium2=premium;};
		float getratioriskfactor(){return this.myratioriskfactor;};
		void setratioriskfactor(float ratioriskfactor){this.myratioriskfactor=ratioriskfactor;};
		float getvalue(){return this.myvalue;};
		void setvalue(float value){this.myvalue=value;};
		float getprofitloss(){return this.myprofitloss;};
		void setprofitloss(float profitloss){this.myprofitloss=profitloss;};
		float getno(){return this.myno;};
		void setno(float no){this.myno=no;};
		float gettotalpl(){return this.mytotalpl;};
		void settotalpl(float totalpl){this.mytotalpl=totalpl;};

	}// class myoption
	class csavet
	{
		void savet()
		{
			System.out.println("csavet savet start");
            String tabledata="";
            System.out.println("max col count="+mtm.getColumnCount());
            int mycol=0;
            mycol=mtm.getColumnCount();
            System.out.println("max row count="+mtm.getRowCount());
            int myrow=0;
            for(int i=0;i<mtm.getRowCount();i++){
            for(int j=0;j<mtm.getColumnCount();j++){
            tabledata=mtm.getdata(i, j);
            if((tabledata!=null)&&(j==0)){myrow++;}
            }
            }
            System.out.println("to be saved myrow count="+myrow);
            System.out.println("to be saved mycolumn count="+mtm.getColumnCount());
            mst.savedata(myrow);
	        //row=row+1;
	        //mtm.setdata(row-1,0,(String)String.valueOf(row));
	        //mtm.fireTableCellUpdated(row-1,0 );  
            System.out.println("csavet savet stop");
		}//savet
	}//class csavet
	class cupdate
	{
		void update()
		{
			// should save the table before exit
	        //System.exit(0);
	        //double mystrike=0,myfutureprice=0;
	        System.out.println("start update ");
	        String tempstr="";
            double res=0,riskfactor=0,maxloss=0,myprice=0,myvalue=0;
            int myposition=17;
            if(mystrike>myfutureprice){
            mtm.setdata(row,myposition,(String)"inthemoney");
            mtm.fireTableCellUpdated(row,myposition );
            flaginthemoney=true;
            }
            if(myfutureprice>mystrike){
            mtm.setdata(row,myposition,(String)"outthemoney");
	        mtm.fireTableCellUpdated(row, myposition);
	        flagoutthemoney=true;
            }	
            if(myfutureprice==mystrike){
            mtm.setdata(row,myposition,(String)"atthemoney");
	        mtm.fireTableCellUpdated(row,myposition );
	        flagatthemoney=true;      	
            }	
            if(flagoutthemoney==true){
            res=myfutureprice-mystrike;
            riskfactor=res+mypremium;
            maxloss=riskfactor*1120;
            }
            if(flaginthemoney==true){
            res=mystrike-myfutureprice;
            riskfactor=mypremium-res;
            maxloss=riskfactor*1120;
            }
            if(flagatthemoney==true){
            res=0;
            riskfactor=mypremium-res;
            maxloss=riskfactor*1120;
            }
            if(riskfactor>0.89){
            flagmaxlossnotallowed=true;
            }
            //for(int ii=1;ii<=order;ii++){
    		//    mjcb7.addItem(ii);
    		//    }
            myprice=myfutureprice+mycurrent;
            tempstr=String.valueOf(myprice);
            myposition=19;
            mtm.setdata(row,myposition,(String)tempstr);
        	mtm.fireTableCellUpdated(row,myposition );
        	tempstr="";
        	myvalue=myprice*1120;
        	tempstr=String.valueOf(myvalue);
            myposition=22;
            mtm.setdata(row,myposition,(String)tempstr);
        	mtm.fireTableCellUpdated(row,myposition );
        	tempstr="";
        	mtm.setdata(row,0,(String)String.valueOf(row+1));
            mtm.fireTableCellUpdated(row,0 );
            mtm.setdata(row-1,1,(String)String.valueOf(order+0));
            mtm.fireTableCellUpdated(row-1,1 );
            mtm.setdata(row,1,(String)String.valueOf(order+0));
            mtm.fireTableCellUpdated(row,1 );
            
            // futurmonth=getfuturmonth();
            // get symbole , strip symbol from extra char, search table column valuetext with striped symbol, get string, parse string for year, parse string for month, 
            // String mysymbol=(String)mjcb6.getSelectedItem();
            
            // save table ff2trackertable
            String tabledata="";
            System.out.println("max col count="+mtm.getColumnCount());
            int mycol=0;
            mycol=mtm.getColumnCount();
            System.out.println("max row count="+mtm.getRowCount());
            int myrow=0;
            for(int i=0;i<mtm.getRowCount();i++){
            for(int j=0;j<mtm.getColumnCount();j++){
            tabledata=mtm.getdata(i, j);
            if((tabledata!=null)&&(j==0)){myrow++;}
            }
            }
            System.out.println("to be saved myrow count="+myrow);
            System.out.println("to be saved mycolumn count="+mtm.getColumnCount());
            mst.savedata(myrow);
            
            System.out.println("row="+row);
            //String mysymbol=mu.getmusymbol(row-1);
            String mysymbol=mu.getmusymbol(row);
            System.out.println("mymusymbol1="+mysymbol);
            String mytmp1=mysymbol.replace("dt1_","");
            String mytmp2=mytmp1.replace("_last","");
            String mytmp3=mytmp2.replace("_change","");
            String mytmp4=mytmp3.replace("_high","");
            String mytmp5=mytmp4.replace("_low","");
            String mytmp6=mytmp5.replace("_volume","");
            String mystrippedsymbol=mytmp6.replace("__displaytime","");
            System.out.println("strippedsymbol="+mystrippedsymbol);  
            // String mytable=(String)mjcb3.getSelectedItem();
            //JComboBox mjcb3=new JComboBox();//TABLE
            // which table is requested? the one requested by the update centered around two line numbers
            // thus, first find line numbers = row
            int tableposition=4;
            String mytabletemp2=mtm.getdata(row,tableposition);
            //String mytabletemp=(String)mjcb3.getSelectedItem();//mu.gettable();
            String mytable=mytabletemp2.replace("boption","");
            System.out.println("mytable="+mytable);
            mu.setmydatabase(mdb.getmydatabase());
            String mydatabasetemp=mu.getdatabase();
            String mydatabase=mydatabasetemp.replace("boption","");
            System.out.println("mydatabase="+mydatabase);
            String myvaluetextsymbol=mu.getmyvaluetextsymbol(mydatabase,mytable,mystrippedsymbol);
            System.out.println("myvaluetextsymbol="+myvaluetextsymbol);
            String symbol3=myvaluetextsymbol.replace(mystrippedsymbol.trim(),"");
    		System.out.println("symbol="+symbol3);
    		String symbol4=symbol3.replace("(","");
    		String symbol5=symbol4.replace(")","");
    		System.out.println("symbol date="+symbol5);
    		String symboltmp=symbol5;
    		String symbol6=symbol5.replace("Jan","");
    		String symbol7=symbol6.replace("Feb","");
    		String symbol8=symbol7.replace("Mar","");
    		String symbol9=symbol8.replace("Apr","");
    		String symbol10=symbol9.replace("May","");
    		String symbol11=symbol10.replace("Jun","");
    		String symbol12=symbol11.replace("Jul","");
    		String symbol13=symbol12.replace("Aug","");
    		String symbol14=symbol13.replace("Sep","");
    		String symbol15=symbol14.replace("Oct","");
    		String symbol16=symbol15.replace("Nov","");
    		String symbol17=symbol16.replace("Dec","");
    		System.out.println("parsed symbol year="+symbol17);
    		String symbol18=symboltmp.replace(symbol17.trim(),"");  
    		System.out.println("parsed symbol month="+symbol18);
    		mtm.setdata(row-1,11,(String)symbol18.trim());
            mtm.fireTableCellUpdated(row-1,11 );
            mtm.setdata(row-1,12,(String)symbol17.trim());
            mtm.fireTableCellUpdated(row-1,12 );
            //futuryear=getfuturyear();           
            //optionmonth=getoptionmonth();   
            //select valuetext from ff2plustradeb1092016 where valuetext ilike '%sugar%';
            //optionyear=getoptionyear();
            //ff2plustradeb1092016
           // String mytabletemp3=(String)mjcb3.getSelectedItem();//mu.gettable();
            String mytabletemp31=mtm.getdata(row,4);
            String mytable1=mytabletemp31.replace("option","");
            // String mytable1="";
            String mysymboloption=mu.getmyvaluetextsymboloption(mytable1);
            System.out.println("mysymboloption="+mysymboloption);
            // String symboloptiontmp=mysymboloption;
            String symbol19=mysymboloption.replace("Sugar","");
            String symbol20=symbol19.replace("#11","");
            String symbol21=symbol20.replace(":","");
            String symboloptiontmp2=symbol21;
            System.out.println("symboloptiontmp2="+symboloptiontmp2);
        	String symbol22=symbol21.replace("Jan","");
    		String symbol23=symbol22.replace("Feb","");
    		String symbol24=symbol23.replace("Mar","");
    		String symbol25=symbol24.replace("Apr","");
    		String symbol26=symbol25.replace("May","");
    		String symbol27=symbol26.replace("Jun","");
    		String symbol28=symbol27.replace("Jul","");
    		String symbol29=symbol28.replace("Aug","");
    		String symbol30=symbol29.replace("Sep","");
    		String symbol31=symbol30.replace("Oct","");
    		String symbol32=symbol31.replace("Nov","");
    		String symbol33=symbol32.replace("Dec","");
    		System.out.println("parsed symboloption year="+symbol33);
    		String symbol34=symboloptiontmp2.replace(symbol33.trim(),"");
    		System.out.println("parsed symboloption month="+symbol34);
    		mtm.setdata(row,15,(String)symbol34.trim());
            mtm.fireTableCellUpdated(row,15 );
            mtm.setdata(row,16,(String)symbol33.trim());
            mtm.fireTableCellUpdated(row,16 );
            
            System.out.println("stop update");
		}//update
	}//cupdate
	class cprint
	{
		void print()
		{
			try {
		//	PrintService[] job2=PrinterJob.lookupPrintServices();
		
			PrinterJob prnjob=PrinterJob.getPrinterJob();
			//prnjob.lookupPrintServices();
			//prnjob.printDialog();
			Printable myPrintable=(Printable)null;			
			//PageFormat myPageFormat=prnjob.defaultPage();
			PageFormat myPageFormat=prnjob.pageDialog(prnjob.defaultPage());
			myPageFormat.setOrientation(PageFormat.LANDSCAPE);
		//	Pageable document=null;		
		//	int pageIndex=1;
			//document.getPageFormat(pageIndex);
		//	document.getPrintable(pageIndex);
//			document.getNumberOfPages();
		//	int orientation=HEIGHT;
			
			//myPageFormat.setOrientation(orientation);
		//	myPageFormat.getHeight();
		//	myPageFormat.getWidth();
			prnjob.setPrintable((Printable)myPrintable,(PageFormat) myPageFormat);
		//	prnjob.setPageable(document);
		//PagePreview pp=new PagePreview();
		//	PreviewPage pp=new PreviewPage();
		//	PreviewContainer pc=new PreviewContainer();
		//	ContainerPreview cp=new ContainerPreview();
	//			job.print();
			if(!prnjob.printDialog())
				return;
			prnjob.print();
			} 
			/*
			catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();e.getMessage();
			}
			*/
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();e1.getMessage();
			}
			
		}//print
	}//cprint
	class buttonk
	{
		String ak()
		{
			String res0="";
			try{
			String  databasename="ff2trackerkey";
			String  url    = "jdbc:postgresql://localhost:5432/"+databasename;
    		String username = "postgres";
    		String  password = "postgres"; 
    		Class.forName("org.postgresql.Driver");
    		Connection  conn=DriverManager.getConnection(url,username,password);
    		Statement stat=conn.createStatement();    
    		String tablename="ff2trackerkeytable";
    		ResultSet result3;
    		//String myrow=String.valueOf(row);
    		String cmd="SELECT * FROM "+tablename+";";
    		System.out.println("cmd="+cmd);
    		//System.out.println("cmd37="+cmd);
    		result3=stat.executeQuery(cmd);
    		// String res0="";
			   
			    while(result3.next())
			    {
			    	res0=result3.getString(1);
			    }
			    result3.close();
			    stat.close();
			    conn.close();
			   System.out.println("trackerkeytableres37= "+res0);
			}
			catch(Exception ex1){ex1.getMessage();ex1.getStackTrace();}
			return res0.trim();
		}//getkey
		float myk(String mystring)
		{
			float myres=(float)0.0;
			try{
			
			//String astring=astring1.trim()+""+astring2.trim()+""+astring3.trim()+""+astring4.trim()+""+astring5.trim();
				System.out.println("myk astring8 ="+astring8);
			byte[] decoded = Base64.getDecoder().decode(astring8);
			System.out.println("mystring ="+mystring);
			String astring = astring8;//new String(decoded, "UTF-8");
			System.out.println("myk astring ="+astring);
			mt.type=mystring.equals(astring);
			if (mt.type==flag731){myres=flag732;}
			if (mt.type==flag943){myres=flag944;}
			System.out.println("myres ="+myres);
			
			}
			catch(Exception e1){e1.getMessage();e1.printStackTrace();}
			return (float)myres;
		}//validkey
		void k(float f)
		{
			if(f==flag732){flagu=flag733;}
			if(f==flag944){flagu=flag945;}
			System.out.println("flagu="+flagu);
		}//unblocksoftware
		
	}//buttonkey
	class mytype 
	{
		boolean type;
	}
	
}//class trackerdatainput21072016