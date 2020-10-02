import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.net.*;
import javax.sql.*;

public class organizarnumeros
{

public static TextField tfnom,tfnum;
public static Frame frame,frameintro,frameerror;
public static Label lpass,lpassden,lnum,lmn,lnm,ljic;	
public static Button blim,bmasnum,borg,bsalir,bres,baceptar;
public static JPasswordField pass;
public static String spass,snum,snumorg,sto,ston;
public static double [] arreglo =  new double [50];
public static double [] arregloorg =  new double [50];
public static String [] sarregloorg =  new String [50];

public static int i,j,x,m;
public static TextArea taorg,taorg2;
public static double ban,num,max=-999999999;
public void igutest(){
blim= new Button ("Acceder");
blim.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e ){process();}});
lpass= new Label (" Introduce la Clave ");
lpassden= new Label ("..............................");
pass= new javax.swing.JPasswordField(5);	
bsalir= new Button ("Salir");
bsalir.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e ){error();}});

frame= new Frame("Acceso"); 
frame.add(lpass);
frame.add(pass);
frame.add(blim);
frame.add(lpassden);
frame.add(bsalir);

frame.reshape(450,100,200,130);
frame.setLayout(new FlowLayout());
frame.show();	
}

public void process(){
	spass=pass.getText();
	if(spass.equals("1234")){	lpassden.setText("Acceso valido");
	organizarnumeros t=new organizarnumeros();
	t.iguintronum();	}
	else
	{
		lpassden.setText("Error Visita la web");
		organizarnumeros t=new organizarnumeros();
		t.error();
	}
	
}

public void iguintronum()
{
tfnum= new TextField(8);
bmasnum= new Button ("Agregar");
bmasnum.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e ){adicionarnum();}});
lnum= new Label ("Introducir numero");
lmn= new Label ("De mayor a menor");
lnm= new Label ("De menor a mayor");
borg= new Button ("Organizar");
borg.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e ){organizar();}});
bsalir= new Button ("Salir");
bsalir.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e ){error();}});
bres= new Button ("Resetear");
bres.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e ){reset();}});
taorg= new TextArea (2,20);
taorg2= new TextArea (2,20);

frameintro= new Frame("Introducir numeros");

frameintro.add(lnum);	
frameintro.add(tfnum);

frameintro.add(bmasnum);
frameintro.add(borg);
frameintro.add(lmn);
frameintro.add(taorg);
frameintro.add(lnm);
frameintro.add(taorg2);
frameintro.add(bsalir);
frameintro.add(bres);
frameintro.reshape(450,230,200,350);
frameintro.setLayout(new FlowLayout());
frameintro.show();
}

public void adicionarnum()
{
try
{
	
snum=tfnum.getText();
num=Double.parseDouble(snum);
arreglo[m]=num;


tfnum.setText("");


m++;
}
catch (Exception e){}	
}




public void organizar()
{
try
{



for(i=0;i<m;i++)	
{

	for(j=0;j<m;j++)	
	{
		
		if(max<=arreglo[j])
		{
			arregloorg[i]=arreglo[j];
			max=arreglo[j];	
			x=j;
		}	
	}
max=-999999999;
arreglo[x]=-999999999;
}

for(i=0;i<m;i++)	
{	
//sarregloorg[i]=Integer.toString(arregloorg[i]);
snumorg=Double.toString(arregloorg[i]);
sto=sto+"    "+snumorg;
ston=snumorg+"    "+ston;
}

//taorg.setText(sarregloorg[0]);
taorg.setText(sto);
taorg2.setText(ston);



}
catch (Exception e){}	
}

public void reset()
{
try
{
taorg.setText("");	
taorg2.setText("");	
tfnum.setText("");
x=0;
m=0;
sto=null;
ston=null;
		
}	
catch (Exception e){}
}

public void error()
{
	ljic= new Label("Adios");
	baceptar= new Button("Aceptar");
	baceptar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e ){salir();}});
	frameerror= new Frame ("BY JIC");
	frameerror.add(ljic);
	frameerror.add(baceptar);
	frameerror.reshape(425,230,255,100);
frameerror.setLayout(new FlowLayout());
frameerror.show();
}

public void salir()
{
	System.exit(0);
}
 public static void main (String [] args)
 {
 	organizarnumeros t=new organizarnumeros();
 	t.igutest();
 }
	
	
	
}