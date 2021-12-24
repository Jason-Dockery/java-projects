// Created by: Jason Dockery
// Finished program: 11/30/2019

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class InvGUI extends JFrame implements ActionListener, MouseListener{

	private InvItem[] items;
	private JPanel jpBase, jp1, jp2, jp3;
	private JLabel jl1, jl2, jl3, jl4;
	private JTextField jtf1, jtf2, jtf3, jtf4;
	private JButton jb1, jb2, jb3, jb4, jb5;
	
	public static void main(String[] args) {
		InvGUI ig = new InvGUI();
	}
	
	InvGUI() {

		items = new InvItem[0];
				// Base Panel
		setSize(600, 400);
		setTitle("InvGUI");
		jpBase = new JPanel(); add(jpBase); 
		jpBase.setLayout(new GridLayout(3,1));
		jpBase.addMouseListener(this);
				// First JPanel
		jp1 = new JPanel(); jpBase.add(jp1); 
		jp1.setLayout(new GridLayout(2,3));
		jp1.setBackground(Color.WHITE);
		jp1.addMouseListener(this);
				// First JLabel		
		jl1 = new JLabel("item id"); jp1.add(jl1); 
		jl1.setForeground(new Color(255,0,0));		
				// Second JLabel	
		jl2 = new JLabel("item name"); jp1.add(jl2);
		jl2.setForeground(new Color(255,0,0));
				// Third JLabel	
		jl3 = new JLabel("item quantity"); jp1.add(jl3);
		jl3.setForeground(new Color(255,0,0));
				// First JTextfield
		jtf1 = new JTextField(10); jp1.add(jtf1); jtf1.setEditable(true);
		jtf1.addActionListener(this);
				// Second JTextfield
		jtf2 = new JTextField(10); jp1.add(jtf2); jtf2.setEditable(true);
		jtf2.addActionListener(this);
				// Third JTextfield
		jtf3 = new JTextField(10); jp1.add(jtf3); jtf3.setEditable(true);
		jtf3.addActionListener(this);
				// Second JPanel
		jp2 = new JPanel(); jpBase.add(jp2);
		jp2.setLayout(new FlowLayout());
		jp2.setBackground(Color.WHITE);
		jp2.addMouseListener(this);
				// Fourth JLabel
		jl4 = new JLabel("filepath:"); jp2.add(jl4);
		jl4.setForeground(new Color(255,0,0));
				// Fourth JTextfield
		jtf4 = new JTextField(30); jp2.add(jtf4); jtf4.setEditable(true); jtf4.setText("invdata.dat");
		jtf4.addActionListener(this);
				// Third JPanel
		jp3 = new JPanel(); jpBase.add(jp3); 
		jp3.setLayout(new FlowLayout());
		jp3.setBackground(Color.WHITE);
		jp3.addMouseListener(this);
				// First JButton
		jb1 = new JButton("load file"); jp3.add(jb1); 
		jb1.addActionListener(this);
		jb1.setForeground(new Color(0,255,0));
		jb1.setBackground(new Color(255,255,255));
				// Second JButton
		jb2 = new JButton("save file"); jp3.add(jb2); 
		jb2.addActionListener(this);
		jb2.setForeground(new Color(0,255,0));
		jb2.setBackground(new Color(255,255,255));
				// Third JButton
		jb3 = new JButton("add item"); jp3.add(jb3); 
		jb3.addActionListener(this);
		jb3.setForeground(new Color(0,255,0));
		jb3.setBackground(new Color(255,255,255));
				// Fourth JButton
		jb4 = new JButton("clear item"); jp3.add(jb4); 
		jb4.addActionListener(this);
		jb4.setForeground(new Color(0,255,0));
		jb4.setBackground(new Color(255,255,255));
				// Fifth JButton
		jb5 = new JButton("display"); jp3.add(jb5); 
		jb5.addActionListener(this);
		jb5.setForeground(new Color(0,255,0));
		jb5.setBackground(new Color(255,255,255));
				// Final JComponents 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	 void loadFile(){
		try{
			File f = new File(jtf4.getText());
			System.out.println(jtf4.getText());
			FileInputStream fsi = new FileInputStream(f);
			ObjectInputStream osi = new ObjectInputStream(fsi);
			long [] l = (long[])osi.readObject();
			String [] n = (String[])osi.readObject();
			int [] q = (int[])osi.readObject();
			osi.close();
			fsi.close();
			items = new InvItem[l.length];
			for(int i = 0; i<l.length; i++){
				items[i] = new InvItem(l[i],n[i],q[i]);
			}
		}
		catch(Exception ie){
			//System.out.println("unspecified I/O exception");
			ie.printStackTrace();
		}
//		catch(ClassNotFoundException ce){
//			System.out.println("No class found for InvGUI present");
//		}
	}
	 void saveFile() {
		 
		try {
			
			long[] i = new long[items.length];
			String[] w = new String[items.length];
			int[] r = new int[items.length];
			for(int a = 0; a < items.length; a++){
				i[a] = items[a].getId();
				w[a] = items[a].getName();
				r[a] = items[a].getQuantity();
				}
			File f = new File(jtf4.getText());
			System.out.println("saving to " + f.getName());
			FileOutputStream fso = new FileOutputStream(f);
			ObjectOutputStream oso = new ObjectOutputStream(fso);
			oso.writeObject(i);
			oso.writeObject(w);
			oso.writeObject(r);
			oso.close();
			fso.close();
		}
		catch(IOException e) {
			System.out.println("unspecified I/O exception during object save");
		}

			}
	 @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1){
			if(jtf4.getText()==""){
				return;
			}else{
			InvGUI g2 = new InvGUI();
			g2.loadFile();
			}
		}
		if(e.getSource() == jb2){
			if(jtf4.getText()==""){
				return;
			}else{
			InvGUI g2 = new InvGUI();
			g2.saveFile();
			}
		}
		if(e.getSource() == jb3){
			InvItem[] items2;
			items2 = new InvItem[items.length+1];
			for(int u = 0; u < items.length-1; u++){
				items2[u] = items[u];
			}
			items = items2;
			long v = Long.parseLong(jtf1.getText()); 
			String t = jtf2.getText();
			int z = Integer.parseInt(jtf3.getText());
			InvItem items3;
			items3 = new InvItem(v,t,z);
			items[items.length-1] = items3;
		}
		
		if(e.getSource() == jb4){
				for(int i = 0; i<items.length; i++){
					if(items[i].id == Long.parseLong(jtf1.getText())){
						for(int l = i; l<items.length-1; l++){
							items[l] = items[i+1];
						}
						InvItem[] items1 = new InvItem[items.length-1];
						for(int u = 0; u < items.length-1; u++){
							items1[u] = items[u];
						}
						items = items1;
						break;
					}
			}
		}
		if(e.getSource() == jb5){
			for (int i = 0; i < items.length; i++) {
				System.out.println(i + "\t" + items[i].getId() +"\t" + items[i].getName() +"\t" + items[i].getQuantity());
			}		
		}	
	}

	class InvItem implements Serializable {
	private long id;
	private String name;
	private int quantity;
	
	InvItem(long id, String name, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
	long getId() {
		return id;
	}
	
	String getName() {
		return name;
	}
	
	int getQuantity() {
		return quantity;
	}
	
	void setId(long id) {
		this.id = id;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}}		
