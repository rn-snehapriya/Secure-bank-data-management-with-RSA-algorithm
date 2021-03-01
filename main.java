package mysql3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
class Welcome
{
    public Welcome() {
		Font f1 = new Font("Comic Sans MS",Font.BOLD | Font.ITALIC , 26);
		Font f2 = new Font("Segoe UI Emoji",Font.BOLD  , 26);
		Font f3 = new Font("Lucida Sans Unicode",Font.BOLD , 26);
		Font f4 = new Font("Tahoma",Font.PLAIN , 26);
                String sneha="priya";
		JFrame f = new JFrame("Welcome");
		ImageIcon img = new ImageIcon("C:\\Users\\HP\\Desktop\\Internet-Banking-master\\itbanklogo.PNG");
		f.setIconImage(img.getImage());
		JButton l1 = new JButton();
		l1.setIcon(img);
		f.add(l1);

		f.getContentPane().add(l1,BorderLayout.CENTER);
		f.setSize(1000, 800);
		f.setVisible(true);
		
		l1.setBackground(Color.white);
		
		l1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				Login l = new Login();
			}
		});
	}
}
class Login extends JFrame
{
    String user,pass;
    public Login() {
		Font f1 = new Font("Comic Sans MS",Font.BOLD | Font.ITALIC , 13);
		Font f2 = new Font("Segoe UI Emoji",Font.BOLD  , 13);
		Font f3 = new Font("Lucida Sans Unicode",Font.BOLD , 13);
		Font f4 = new Font("Tahoma",Font.PLAIN , 13);

		JFrame f=new JFrame("Login / SignUp");
		JLabel l1=new JLabel("Username :");
		JLabel l2=new JLabel("Password :");
		JTextField tf1=new JTextField();
		JPasswordField pf=new JPasswordField();
		JButton b1=new JButton("Login");
		//JButton b2=new JButton("Signup");
		JButton b3 = new JButton("Exit");
		l1.setBounds(40,10,100,30);
		l1.setForeground(Color.blue);
		l1.setFont(f1);
		l2.setBounds(40,50,100,30);
		l2.setForeground(Color.blue);
		l2.setFont(f1);
		tf1.setBounds(150,10,150,30);
		tf1.setFont(f4);
		tf1.setToolTipText("Enter username.");
		pf.setBounds(150,50,150,30);
		pf.setToolTipText("Enter password.");
		b1.setBounds(70,90,250,30);
		//b2.setBounds(220,90,100,30);
		b3.setBounds(140,140,100,30);
		b1.setFont(f2);
		//b2.setFont(f2);
		b3.setFont(f2);
		b1.setMnemonic('l');
		//b2.setMnemonic('s');
		b3.setMnemonic('x');
		f.setSize(400,220);
		f.setLayout(null);
		f.setVisible(true);
		f.add(l1);
		f.add(l2);
		f.add(tf1);
		f.add(pf);
		f.add(b1);
		//f.add(b2);
		f.add(b3);
		
		f.getContentPane().setBackground(Color.pink);
		b1.addActionListener(new ActionListener()  {
                        public void display(int disp[]) 
                        {
                            char convert[]=new char[disp.length];
                            for(int l=0;l<disp.length;l++)
                            {
                                convert[l]=(char)disp[l];
                                System.out.print(convert[l]);
                            }
                        } 
			public void actionPerformed(ActionEvent e) {
				
				user=tf1.getText();
				pass=pf.getText();
                                String sneha="sneha";
                                try
                                {
                                     Connection con;
                                    ResultSet rs;
                                    Statement t;
                                    //System.out.println(user+"    "+pass);
 //System.out.println("statement 1");
 Class.forName("com.mysql.jdbc.Driver");
 //System.out.println("statement 2");
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcard?zeroDateTimeBehavior=convertToNull","root",""); 
 //System.out.println("statement 3");
 t=con.createStatement();
 //System.out.println("statement 4");
 t.executeUpdate("insert into smartcard values('"+user+"','"+pass+"','sneha','sneha','sneha','sneha','sneha')");
 // insert into smartcard values(""+-------------------);
// System.out.println("statement 5"); 
                                }
                                catch(Exception io)
                                {
                                    io.printStackTrace();
                                }
                                // 
                                
                                String key;
                                int s[]=new int[256];
                                int k[]=new int[256];
                                key="A";
                                char ptextc[]=pass.toCharArray();
                                char keyc[]=key.toCharArray();
                                int cipher[]=new int[pass.length()];
                                int decrypt[]=new int[pass.length()];
                                int ptexti[]=new int[pass.length()];
                                int keyi[]=new int[key.length()];
                                for(int i=0;i<pass.length();i++)
                                {
                                    ptexti[i]=(int)ptextc[i];
                                }
                                for(int i=0;i<key.length();i++)
                                {
                                    keyi[i]=(int)keyc[i];
                                }
                                for(int i=0;i<255;i++)
                                {
                                    s[i]=i;
                                    k[i]=keyi[i%key.length()];
                                }
                                int j=0,temp;
                                for(int i=0;i<255;i++)
                                {
                                    j=(j+s[i]+k[i])%256;
                                    temp=s[i];
                                    s[i]=s[j];
                                    s[j]=temp;
                                }
                                int i=0;
                                j=0;
                                int z=0;
                                for(int l=0;l<pass.length();l++)
                                {
                                    i=(l+1)%256;
                                    j=(j+s[i])%256;
                                    temp=s[i];
                                    s[i]=s[j];
                                    s[j]=temp;
                                    z=s[(s[i]+s[j])%256];
                                    cipher[l]=z^ptexti[l];
                                    decrypt[l]=z^cipher[l];
                                }
                                System.out.print("\n\nENCRYPTED Password:\t\t");
                                display(cipher);
                                System.out.print("\n\nDECRYPTED Password:\t\t");
                                display(decrypt);
                                f.setVisible(false);
                                Transfer tr = new Transfer(user, pass);
                               //String sneha="sneha";
                                try
                                {
                                     Connection con;
                                    ResultSet rs;
                                    Statement t;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 Scanner input = new Scanner(System.in);
 Class.forName("com.mysql.jdbc.Driver");
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcard?zeroDateTimeBehavior=convertToNull","root",""); 
 t=con.createStatement();
 t.executeUpdate("update smartcard set EncryptedPassword='"+cipher+"' where Username='"+user+"'");
                                    
                                }
                                catch(Exception io)
                                {
                                    
                                }
				}
		});

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				System.exit(0);
			}
		});
		b1.setBackground(Color.green);
		//b2.setBackground(Color.orange);
		b3.setBackground(Color.red);
	}
}
class Transfer extends JFrame {
	String s1,s2,s3,s4;
        int cipher1[], decrypt[], ciphera[],decrypta[];
	public Transfer(String user, String pass) {
                String u=user;
                String p=pass;
                
		Font f1 = new Font("Comic Sans MS",Font.BOLD | Font.ITALIC , 13);
		Font f2 = new Font("Segoe UI Emoji",Font.BOLD  , 13);
		Font f3 = new Font("Lucida Sans Unicode",Font.BOLD , 13);
		Font f4 = new Font("Tahoma",Font.PLAIN , 13);

		JFrame f = new JFrame("Transfer");
		JLabel l2 = new JLabel("Beneficiary account no.: ");
		JLabel l3 = new JLabel("Beneficiary CIF no.: ");
		JLabel l4 = new JLabel("Amount : ");
		JLabel l5 = new JLabel("* Please cross check the details of benificiary!!! *");
		l5.setForeground(Color.red);
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		JTextField tf3 = new JTextField();
		
		
		
		
		JPasswordField pf = new JPasswordField();
		//l1.setBounds(10,10,250,20);
		tf1.setBounds(250,10,250,20);
		l2.setBounds(10,40,250,20);
		pf.setBounds(250,40,250,20);
		l3.setBounds(10,70,250,20);
		tf2.setBounds(250,70,250,20);
		l4.setBounds(10,100,250,20);
		tf3.setBounds(250,100,250,20);
		l5.setBounds(80,130,450,20);
		
		//f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(pf);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		//f.add(tf4);
		//tf4.setVisible(false);
		
		JButton b1 = new JButton("Submit");
		JButton b2 = new JButton("Logout");

		b1.setBounds(220,200,100,20);
		b2.setBounds(220,240,100,20);
		f.setVisible(true);
		f.setLayout(null);
		f.add(b1);
		f.add(b2);
		b1.setBackground(Color.green);
		b2.setBackground(Color.PINK);
		b1.setFont(f2);
		b2.setFont(f2);
		//l1.setFont(f1);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f3);
		tf1.setFont(f4);
		tf2.setFont(f4);
		tf3.setFont(f4);
		//tf4.setFont(f4);
		f.setSize(550,350);
		f.getContentPane().setBackground(Color.orange);
		
		b1.addActionListener(new ActionListener() {
                        public void display(int disp[])
                        {
                            char convert[]=new char[disp.length];
                            for(int l=0;l<disp.length;l++)
                            {
                                convert[l]=(char)disp[l];
                                System.out.print(convert[l]);
                            }
                        } 
			public void actionPerformed(ActionEvent e) {

				s1= tf1.getText();
				s3 = pf.getText();
				s4 = tf3.getText();
				int temp1=0;
                                String key1;
                                int ss[]=new int[256];
                                int kk[]=new int[256];
                                key1="A";
                                char ptextc1[]=s1.toCharArray();
                                char keyc1[]=key1.toCharArray();
                                int cipher1[]=new int[s1.length()];
                                int decrypt1[]=new int[s1.length()];
                                int ptexti1[]=new int[s1.length()];
                                int keyi1[]=new int[key1.length()];
                                for(int i=0;i<s1.length();i++)
                                {
                                    ptexti1[i]=(int)ptextc1[i];
                                }
                                for(int i=0;i<key1.length();i++)
                                {
                                    keyi1[i]=(int)keyc1[i];
                                }
                                for(int i=0;i<255;i++)
                                {
                                    ss[i]=i;
                                    kk[i]=keyi1[i%key1.length()];
                                }
                                int j=0;
                                for(int i=0;i<255;i++)
                                {
                                    j=(j+ss[i]+kk[i])%256;
                                    temp1=ss[i];
                                    ss[i]=ss[j];
                                    ss[j]=temp1;
                                }
                                int i=0;
                                j=0;
                                int z=0;
                                for(int l=0;l<s1.length();l++)
                                {
                                    i=(l+1)%256;
                                    j=(j+ss[i])%256;
                                    temp1=ss[i];
                                    ss[i]=ss[j];
                                    ss[j]=temp1;
                                    z=ss[(ss[i]+ss[j])%256];
                                    cipher1[l]=z^ptexti1[l];
                                    decrypt1[l]=z^cipher1[l];
                                }
                                System.out.print("\n\nENCRYPTED Account number:\t\t");
                                display(cipher1);
                                try
                                {
                                     Connection con;
                                    ResultSet rs;
                                    Statement t;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 Scanner input = new Scanner(System.in);
 Class.forName("com.mysql.jdbc.Driver");
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcard?zeroDateTimeBehavior=convertToNull","root",""); 
 t=con.createStatement();
 t.executeUpdate("update smartcard set EncryptedAccountNumber='"+cipher1+"' where Username='"+u+"'");
                                    
                                }
                                catch(Exception io)
                                {
                                    
                                }
                                
                                
String key;
int temp;
 int s[]=new int[256];
 int k[]=new int[256];
 int sa[]=new int[256];
 int ka[]=new int[256];
 key="A";
 char ptextc[]=s1.toCharArray();
 char keyc[]=key.toCharArray();
 int cipher[]=new int[s1.length()];
 int decrypt[]=new int[s1.length()];
 int ptexti[]=new int[s1.length()];
 int keyi[]=new int[key.length()];
 char ptextca[]=s3.toCharArray();
 char keyca[]=key.toCharArray();
 int ciphera[]=new int[s3.length()];
 int decrypta[]=new int[s3.length()];
 int ptextia[]=new int[s3.length()];
 int keyia[]=new int[key.length()];
 for(i=0;i<s1.length();i++)
 {
 ptexti[i]=(int)ptextc[i];
 }
 for(i=0;i<s3.length();i++)
 {
 ptextia[i]=(int)ptextca[i];
 }
 for(i=0;i<key.length();i++)
 {
 keyi[i]=(int)keyc[i];
 }
 for(i=0;i<key.length();i++)
 {
 keyia[i]=(int)keyca[i];
 }
 for(i=0;i<255;i++)
 {
 s[i]=i;
 k[i]=keyi[i%key.length()];
 }
 for(i=0;i<255;i++)
 {
 sa[i]=i;
 ka[i]=keyia[i%key.length()];
 }
 j=0;
 
for(i=0;i<255;i++)
 {
 j=(j+s[i]+k[i])%256;
 temp=s[i];
 s[i]=s[j];
 s[j]=temp;
 }
 for(i=0;i<255;i++)
 {
 j=(j+sa[i]+ka[i])%256;
 temp=sa[i];
 sa[i]=sa[j];
 sa[j]=temp;
 }
 i=0;
 j=0;
 z=0;
 for(int l=0;l<s1.length();l++)
 {
 i=(l+1)%256;
 j=(j+s[i])%256;
 temp=s[i];
 s[i]=s[j];
 s[j]=temp;
 z=s[(s[i]+s[j])%256];
 cipher[l]=z^ptexti[l];
 decrypt[l]=z^cipher[l];
 }
 for(int l=0;l<s3.length();l++)
 {
 i=(l+1)%256;
 
j=(j+s[i])%256;
 temp=sa[i];
 sa[i]=sa[j];
 sa[j]=temp;
 z=s[(s[i]+s[j])%256];
 ciphera[l]=z^ptextia[l];
 decrypta[l]=z^ciphera[l];
 }
 //System.out.println("\n\nENCRYPTED ACC no:\t\t"+cipher);
 //display(cipher);
 //System.out.print("\n\nENCRYPTED Acc no:\t\t");

 System.out.print("\n\nDECRYPTED Acc no:\t\t");
 display(decrypt);
 System.out.print("\n\nENCRYPTED CIF no:\t\t");
 display(ciphera);
 System.out.print("\n\nDECRYPTED CIF no:\t\t");
 display(decrypta);
 System.out.println();
try
                                {
                                     Connection con;
                                    ResultSet rs;
                                    Statement t;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 Scanner input = new Scanner(System.in);
 Class.forName("com.mysql.jdbc.Driver");
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcard?zeroDateTimeBehavior=convertToNull","root",""); 
 t=con.createStatement();
 t.executeUpdate("update smartcard set DecryptedAccountNumber='"+s1+"' where Username='"+u+"'");
 t.executeUpdate("update smartcard set EncryptedCIFNumber='"+ciphera+"' where Username='"+u+"'");
 t.executeUpdate("update smartcard set DecryptedCIFNumber='"+s3+"' where Username='"+u+"'");
                                    
                                }
                                catch(Exception io)
                                {
                                    
                                }

//
 //
 f.setVisible(false);
Message h=new Message();
			}	
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				Welcome h=new Welcome();
			}
		});
	}
}
class Message extends JFrame{
	public Message() {
		Font f1 = new Font("Comic Sans MS",Font.BOLD | Font.ITALIC , 13);
		Font f2 = new Font("Segoe UI Emoji",Font.BOLD  , 13);
		Font f3 = new Font("Lucida Sans Unicode",Font.BOLD , 13);
		Font f4 = new Font("Tahoma",Font.PLAIN , 13);

		JFrame f = new JFrame("Success") ;
		
		JLabel l1 = new JLabel("Funds have been successfully transferred!");
		l1.setForeground(Color.blue);
		JButton b1 = new JButton("Log Out");
		b1.setBackground(Color.GREEN);
		f.setVisible(true);
		f.setSize(350,150);
		f.setLayout(null);
		l1.setBounds(30,10,300,20);
		b1.setBounds(110,50,90,20);
		f.add(l1);
		f.add(b1);
		b1.setFont(f2);
		l1.setFont(f3);
		f.getContentPane().setBackground(Color.green);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
                                System.exit(0);
				
			}
		});
	}
}
public class Mysql3
{
 public static void main(String[] args) throws Exception
 {
      Connection con;
       ResultSet rs;
       Statement t;
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 Scanner input = new Scanner(System.in);
 Class.forName("com.mysql.jdbc.Driver");
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcard?zeroDateTimeBehavior=convertToNull","root",""); 
 t=con.createStatement();
     Welcome w=new Welcome();
     
        
 }
}
