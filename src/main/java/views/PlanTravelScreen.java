package views;

import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PlanTravelScreen extends JFrame {
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanTravelScreen frame = new PlanTravelScreen();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PlanTravelScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		ButtonGroup group3 = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 720);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel labelFrom = new JLabel("Stay From");
		labelFrom.setBounds(30, 40, 100, 30);
		panel.add(labelFrom);
		
		
		JButton plusButton1 = new JButton("+");
		plusButton1.setBounds(0, 390, 41, 23);
		panel.add(plusButton1);
		
		JButton plusButton2 = new JButton("+");
		plusButton2.setBounds(375, 0, 41, 23);
		panel.add(plusButton2);
		
		JButton plusButton3 = new JButton("+");
		plusButton3.setBounds(651, 390, 41, 23);
		panel.add(plusButton3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 425, 769, 211);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(61, 0, 167, 211);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(330, 0, 167, 211);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(602, 0, 167, 211);
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(122, 0, 668, 94);
		panel.add(panel_4_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(56, 50, 46, 14);
		panel_4_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("u\u017Cytkownik");
		lblNewLabel.setBounds(536, 11, 110, 26);
		panel_4_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Zam\u00F3wienie nr.");
		lblNewLabel_1.setBounds(202, 38, 199, 45);
		panel_4_1.add(lblNewLabel_1);

	}
}
