package x_Old;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

//Ferienwohnung klasse Frame
@SuppressWarnings("serial")
public class FerienwohnungGUI extends JFrame implements ActionListener {

	// Objekte deklarieren

	// Menü
	JMenuBar menuBar, bearbeiten, hilfe;

	JMenu fileMenu;
	JMenu bearbeiten2;
	JMenu hilfe2;

	// Menüpunke
	JMenuItem openItem, mntmPrint, closeItem, neuItem;
	// bearbeiten
	JMenuItem kopie, auschneiden, loeschen, past, wahl;

	// hilfe
	JMenuItem appErk;

	// button
	JButton button, button2, button3, a1, a2, a3, c1, c2, c3, g1, g2, g3, nbtn, nbtn2, nbtn3, nbtn4, weiterButton,
			btnAppErkaelrung, b1, b2, reset, beenden, info, datenschuetz, angemeldet, abmelden, infoFeldsbtn,
			btnKontakt, btnPrint, btnPrint2, bCancel, bcancel2, bcancel3, neUser, adPreis, page, adminquad, gruen,
			orginal;// Taste

	// RadioButton

	JRadioButton radioButton1, radioButton2;
	ButtonGroup buttonGroup;

	// Label
	JLabel label, label2, label3, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, label4, label5, label6, label7,
			label12, label13, preis, preis2, preis3, preis4, preis5, preis6, quad1, quad2, quad3, datum1, datum2,
			datum3, Zahlmethode;//
	JLabel lbl, quadrat1, quadrat2, quadrat3, lbl2, lbl3, lbl4, lnepreis, lnepreis2, lnepreis3, lneuqu, lneuqu2,
			lneuqu3, textvN, b17, b18, lblBenutzerDaten;

	// text Area
	JTextArea area, area2;

	// Textfields
	JTextField vorname, nachname, Adresse, statbuergerschaft, adminName, passwort, preisTEXT, preisTEXT2, preisTEXT3,
			qTEXT4, qTEXT5, qTEXT6;

	// CheckBox

	// Service
	JCheckBox checkBox = new JCheckBox("Frühstück");
	JCheckBox checkBox1 = new JCheckBox("Sauna");
	JCheckBox checkBox2 = new JCheckBox("Service");
	JCheckBox checkBox3 = new JCheckBox("All-Inclusive");

	// Zahlungmethode
	JCheckBox checkBox4 = new JCheckBox("PayPal");
	JCheckBox checkBox5 = new JCheckBox("EC-Karte");
	JCheckBox checkBox6 = new JCheckBox("Bar");
	JCheckBox checkBox7 = new JCheckBox("Rechnung");

	List<String[]> buchungen = new ArrayList<>();// list array für benutzer input

	// Bilder
	private ImageIcon image;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;
	private ImageIcon image6;
	private ImageIcon image7;
	private ImageIcon image8;
	private ImageIcon image9;
	private ImageIcon image10;
	private ImageIcon image11;
	private ImageIcon image17;
	private ImageIcon image18;

	// table und Scroll deklarieren
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	JScrollPane tableScroller = new JScrollPane(table);

	// Kalnder deklaration
	@SuppressWarnings("rawtypes")
	JComboBox monate1, monate2, monate3, tage1, tage2, tage3, jahr1, jahr2, jahr3;

	// ScrollPane
	JScrollPane scrollPane;
	JScrollPane scrollPane_1;

	// admin Passwort
	String benutz = "admin";
	String passw = "admin";
	// Admin Preis andren
	String adminPreis;
	String adminQuad;
	private JPanel Verwaltung;
	private JPanel panel;
	private JPanel panel_1;

	// _______________________________________________________________________________________________________________________

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FerienwohnungGUI() {
		// frame bild
		setForeground(Color.BLUE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("b4.gif"));

		// Frame Thema
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");// nimbus thema

		} catch (Exception e) {
			System.err.println("Look and feel not set.");
		}

		// Frame Feature
		this.setTitle("Ferienwohnung"); // name
		this.setSize(1280, 750); // Size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close
		this.setVisible(true); // Visiblty
		this.setResizable(true); // REsizblity
		getContentPane().setLayout(null); // Layout Manger Postion
		this.getContentPane().setBackground(Color.LIGHT_GRAY); // hINTERGRUNDS FARBE
		this.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 24));// Schriftart und die Grosse
		FerienwohnungGUI.setDefaultLookAndFeelDecorated(true);// Decuration look and feel
		JFrame.setDefaultLookAndFeelDecorated(true);// Decuration look and feel
		JDialog.setDefaultLookAndFeelDecorated(true);

		// Allg. Überschrift
		JLabel lblFierenwohnungApp = new JLabel("Buchungsplattform");
		lblFierenwohnungApp.setForeground(new Color(128, 128, 0));
		lblFierenwohnungApp.setFont(new Font("Blackadder ITC", Font.ITALIC, 58));
		lblFierenwohnungApp.setBounds(476, 20, 452, 60);
		getContentPane().add(lblFierenwohnungApp);

		// ________________________________________________________________________________________________________________________

		// Lists
		// Menüleiste wird erzeugt
		menuBar = new JMenuBar();
		menuBar.setSize(40, 13);
		menuBar.setLocation(2, 0);
		menuBar.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		// bearbeiten
		bearbeiten = new JMenuBar();
		bearbeiten.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		bearbeiten.setSize(70, 13);
		bearbeiten.setLocation(42, 0);

		// hilfe
		hilfe = new JMenuBar();
		hilfe.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		hilfe.setSize(40, 13);
		hilfe.setLocation(112, 0);
		// Menü "Datei" wird erzeugt
		fileMenu = new JMenu("Datei");
		fileMenu.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		bearbeiten2 = new JMenu("Bearbeiten");
		hilfe2 = new JMenu("Hilfe");

		// Menüpunkte werden erzeugt
		openItem = new JMenuItem("Öffnen");
		openItem.setBackground(new Color(204, 0, 0));
		mntmPrint = new JMenuItem("Drucken");
		closeItem = new JMenuItem("Schließen");
		kopie = new JMenuItem("Kopiern");
		kopie.setEnabled(true);
		neuItem = new JMenuItem("Neuen Benutzer erstellen");
		auschneiden = new JMenuItem("Auschneiden");
		auschneiden.setEnabled(true);
		loeschen = new JMenuItem("Löschen");
		loeschen.setEnabled(false);
		appErk = new JMenuItem("Erklärung");

		// Menüpunkte werden dem Datei-Menü hinzugefügt
		fileMenu.add(openItem);
		fileMenu.add(mntmPrint);
		fileMenu.add(neuItem);
		fileMenu.add(closeItem);

		bearbeiten2.add(kopie);
		bearbeiten2.add(auschneiden);
		bearbeiten2.add(loeschen);
		hilfe2.add(appErk);

		// Datei-Menü wird der Menüleiste hinzugefügt
		menuBar.add(fileMenu);
		bearbeiten.add(bearbeiten2);

		past = new JMenuItem("paste");
		bearbeiten2.add(past);

		wahl = new JMenuItem("alles wahlen");
		bearbeiten2.add(wahl);
		hilfe.add(hilfe2);

		// Menüleiste wird dem JFrame hinzugefügt
		getContentPane().add(menuBar);
		getContentPane().add(bearbeiten);
		getContentPane().add(hilfe);

		// ______________________________________________________________________________________________________________________________________
		// Image & Logo
		image = new ImageIcon("b1.jpg");// bild wohnung 1
		image2 = new ImageIcon("b2.jpg");// bild wohnung 2
		image3 = new ImageIcon("b3.jpg");// bild wohnung 3
		image4 = new ImageIcon("b4.png");// Logo
		image17 = new ImageIcon("b17.png");// Logo
		image18 = new ImageIcon("b18.png");// Logo
		image5 = new ImageIcon("b5.jpg");// bild wohnung 1
		image6 = new ImageIcon("b6.jpg");// bild wohnung 2
		image7 = new ImageIcon("b7.jpg");// bild wohnung 3
		image8 = new ImageIcon("b8.jpg");// Logo
		image9 = new ImageIcon("b9.jpg");// bild wohnung 1
		image10 = new ImageIcon("b10.jpg");// bild wohnung 2
		image11 = new ImageIcon("b13.jpg");// bild wohnung 3

		// bilder label
		b17 = new JLabel(image17);
		b18 = new JLabel(image18);
		lbl4 = new JLabel(image4);
		b11 = new JLabel(image11);
		b12 = new JLabel(image11);
		b13 = new JLabel(image11);
		b14 = new JLabel(image11);
		b15 = new JLabel(image11);

		// bilder Position
		lbl4.setBounds(1050, 10, 70, 70);
		b17.setBounds(1050, 10, 70, 70);
		b18.setBounds(1050, 10, 70, 70);
		b12.setBounds(300, 72, 65, 30);// location
		b13.setBounds(300, 113, 65, 30);// location
		b14.setBounds(300, 151, 65, 30);// location
		b15.setBounds(300, 193, 65, 30);// location

		neUser = new JButton("Neuen Benutzer anlegen"); // new benutzer Button
		neUser.setForeground(SystemColor.desktop);// farbe
		neUser.setBackground(UIManager.getColor("ToolBar.dockingForeground"));// farbe
		neUser.setEnabled(true);
		infoFeldsbtn = new JButton("Buchung");// buchung Button
		infoFeldsbtn.setBackground(UIManager.getColor("ToolBar.dockingForeground"));// farbe

		neUser.setBounds(4, 49, 130, 20);// nue benutzer Position
		infoFeldsbtn.setBounds(320, 600, 90, 30);// buchung Position
		infoFeldsbtn.setVisible(false);// Visiblty
		label4 = new JLabel("Vorname*        :");// vornme label
		label4.setToolTipText("Pflichtfeld");// tiptextvornme label
		label4.setBounds(10, 77, 90, 20);// location
		label5 = new JLabel("Nachname*     :");// nachname label
		label5.setBounds(10, 118, 105, 20);// location label
		label5.setVerticalAlignment(JLabel.TOP);
		label5.setToolTipText("Pflichtfeld");// tipText
		label6 = new JLabel("Adresse*         :");// Adresse label
		label6.setToolTipText("Pflichtfeld");
		label6.setBounds(10, 157, 90, 20);// location
		label7 = new JLabel("Staatsbürgerschaft:");// staatbürgershaft label
		label7.setBounds(10, 198, 120, 20);// location

		// chekbox früchtuck, service, sauna,alles Positionen
		checkBox.setToolTipText("5€ extra, sofern Sie Frühstück wünschen");// tiptext
		checkBox.setBounds(10, 325, 90, 20);
		checkBox1.setToolTipText("5€ extra, sofern Sie Saunazugang wünschen");
		checkBox1.setBounds(102, 325, 70, 20);
		checkBox2.setToolTipText("5€ extra, sofern Sie Service wünschen");
		checkBox2.setBounds(200, 325, 70, 20);
		checkBox3.setToolTipText("5€ extra, sofern Sie All-Inclusive wünschen");
		checkBox3.setBounds(295, 325, 70, 20);

		// chekbox zahlung methode
		Zahlmethode = new JLabel("Zahlungsmethode ");
		Zahlmethode.setFont(new Font("Calibri", Font.PLAIN, 14));
		Zahlmethode.setBounds(10, 270, 120, 20);
		Zahlmethode.setForeground(Color.BLUE);// Farbe der Verwaltung abteilung

		getContentPane().add(Zahlmethode);
		getContentPane().add(checkBox7);
		// checkbox postition
		checkBox4.setBounds(10, 297, 70, 20);
		checkBox5.setBounds(102, 297, 80, 20);
		checkBox6.setBounds(295, 297, 70, 20);
		checkBox7.setBounds(200, 297, 90, 20);
		// checkbox hintergründfarbe

		checkBox7.setBackground(Color.LIGHT_GRAY);
		checkBox4.setBackground(Color.LIGHT_GRAY);
		checkBox5.setBackground(Color.LIGHT_GRAY);
		checkBox6.setBackground(Color.LIGHT_GRAY);

		// chekbox background Farbe
		checkBox.setBackground(Color.LIGHT_GRAY);
		checkBox1.setBackground(Color.LIGHT_GRAY);
		checkBox2.setBackground(Color.LIGHT_GRAY);
		checkBox3.setBackground(Color.LIGHT_GRAY);

		// Button
		radioButton1 = new JRadioButton("Stimme zu");// stimmt zu button
		radioButton1.setEnabled(false);// am anfang Stimmt zu nicht verfügbar
		radioButton1.setToolTipText("Sie sollen Stimme zu wahlen, damit Sie die buchung Button sehen");
		radioButton2 = new JRadioButton("Stimme nicht zu");// stimmt nicht zu

		// Stimmt zu un nicht Postition
		radioButton1.setBounds(150, 230, 100, 20);
		radioButton2.setBounds(150, 250, 120, 20);

		// damit ein radionButton ausgewahlt
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);

		// Radionbutton hintergründ
		radioButton1.setBackground(Color.LIGHT_GRAY);
		radioButton2.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(infoFeldsbtn);

		// fussbutton
		datenschuetz = new JButton("Datenschutz");// datenschuetz
		datenschuetz.setBackground(UIManager.getColor("ToolBar.dockingForeground"));// datenschuetzfarbe hintergründ
		datenschuetz.setBounds(570, 600, 130, 30);// Position
		info = new JButton("Info");// info Button
		info.setBackground(UIManager.getColor("ToolBar.dockingForeground")); // info hintergründ
		info.setBounds(710, 600, 80, 30);// Position
		reset = new JButton("Reset");// reset Button
		reset.setBackground(UIManager.getColor("ToolBar.dockingForeground")); // reset hintergründ
		reset.setBounds(800, 600, 90, 30);// location
		beenden = new JButton("Beenden");// beende Button
		beenden.setBackground(UIManager.getColor("ToolBar.dockingForeground"));// beenden hintergründ
		beenden.setBounds(900, 600, 90, 30);// location
		btnAppErkaelrung = new JButton("Allgemeine Erklärung");// Erklärung button
		btnAppErkaelrung.setBackground(UIManager.getColor("ToolBar.dockingForeground"));// app erklärung hintergründ
		btnAppErkaelrung.setBounds(420, 600, 140, 30);// app erklärung postion
		btnAppErkaelrung.setVisible(true);// app erklärung button visiblty

		// eingabe btn
		nbtn = new JButton("O.K");// vorname
		nbtn.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		nbtn.setBounds(300, 72, 65, 30);// location
		nbtn2 = new JButton("O.K");// nachname
		nbtn2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		nbtn2.setBounds(300, 113, 65, 30);// location
		nbtn3 = new JButton("O.K");// adresse
		nbtn3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		nbtn3.setBounds(300, 151, 65, 30);// location
		nbtn4 = new JButton("O.K");// Staat
		nbtn4.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		nbtn4.setBounds(300, 193, 65, 30);// location

		// print und kontakt us
		btnKontakt = new JButton("Kontaktieren Sie uns");// kontakt uns button
		btnKontakt.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnKontakt.setBounds(280, 600, 130, 30);// location
		btnPrint = new JButton("Rechnung drucken");// rechnung Drucken button
		btnPrint.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnPrint.setBounds(1000, 600, 200, 30);// location
		btnPrint2 = new JButton("Buchung drucken");// buchung Drucken button
		btnPrint2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnPrint2.setBounds(1000, 600, 200, 30);// location
		btnPrint2.setVisible(false);// visiblty

		// button hinfügung
		getContentPane().add(btnKontakt);
		getContentPane().add(btnPrint);
		getContentPane().add(btnPrint2);
		getContentPane().add(nbtn);
		getContentPane().add(nbtn2);
		getContentPane().add(nbtn3);
		getContentPane().add(nbtn4);

		// benutzer daten label
		lblBenutzerDaten = new JLabel("Benutzerdaten");
		lblBenutzerDaten.setForeground(Color.BLUE);
		lblBenutzerDaten.setBounds(15, 20, 107, 30);
		getContentPane().add(lblBenutzerDaten);
		lblBenutzerDaten.setFont(new Font("Calibri", Font.ITALIC, 14));// schrifft Artder Verwaltung abteilung

		// Info BOXes
		// vorname textbox
		vorname = new JTextField("vorname");
		vorname.setBounds(150, 72, 140, 30);// location
		// nachname textbox
		nachname = new JTextField("nachname");
		nachname.setBounds(150, 110, 140, 30);// location
		// adresse textbox
		Adresse = new JTextField("Adresse");
		Adresse.setBounds(150, 152, 140, 30);// location
		// statbuergerschaft textbox
		statbuergerschaft = new JTextField("Staatsbürgerschaft");
		statbuergerschaft.setBounds(150, 193, 140, 30);

		// Verwaltung panel
		Verwaltung = new JPanel();
		Verwaltung.setBorder(new TitledBorder(null, "Verwaltung", TitledBorder.LEADING, TitledBorder.TOP,
				(new Font("Calibri", Font.ITALIC, 14)), (Color.BLUE)));// title schrift art farbe und grosse
		Verwaltung.setBounds(8, 477, 262, 153);// position
		getContentPane().add(Verwaltung);
		Verwaltung.setLayout(null);// layout
		Verwaltung.setBackground(Color.LIGHT_GRAY);// Farbe
		abmelden = new JButton("Abmelden");// abmeldung button
		abmelden.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		abmelden.setBounds(6, 79, 100, 30);
		Verwaltung.add(abmelden);// abmeldung button

		angemeldet = new JButton("angemeldet");// angemeldet button
		angemeldet.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		angemeldet.setBounds(116, 79, 110, 30);
		Verwaltung.add(angemeldet);
		label13 = new JLabel("Passwort");// pass label
		label13.setBounds(10, 48, 85, 30);
		Verwaltung.add(label13);
		label13.setBackground(Color.GRAY);
		label12 = new JLabel("Admin");// admin name label
		label12.setBounds(10, 16, 80, 30);
		Verwaltung.add(label12);
		label12.setBackground(Color.GRAY);

		// Verwaltung abteilung
		adminName = new JTextField("Admin");// admin name textfeld
		adminName.setBounds(102, 16, 150, 30);
		Verwaltung.add(adminName);
		passwort = new JPasswordField("Passwort");// admin passwort textfeld
		passwort.setBounds(102, 48, 150, 30);
		Verwaltung.add(passwort);
		weiterButton = new JButton("Anmelden");// anmeldung button
		weiterButton.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		weiterButton.setBounds(126, 79, 100, 30);
		Verwaltung.add(weiterButton);

		panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBackground(Color.LIGHT_GRAY);
		// panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
		// "Willkommen!", TitledBorder.LEADING, TitledBorder.TOP, (new Font("Calibri",
		// Font.ITALIC, 14)),((Color.BLUE))));
		panel.setBounds(375, 76, 620, 422);
		getContentPane().add(panel);
		panel.setLayout(null);

		button = new JButton("Buchen");// buchung Button
		button.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		button.setBounds(60, 350, 100, 30);
		panel.add(button);
		button.setToolTipText("Buchung der Wohnung Nr. 1");

		bCancel = new JButton("stornieren ");// stornieren Button
		bCancel.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		bCancel.setBounds(60, 350, 100, 30);
		panel.add(bCancel);
		button2 = new JButton("Buchen");// buchung Button
		button2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		button2.setBounds(260, 350, 100, 30);
		panel.add(button2);
		button2.setToolTipText("Buchung der Wohnung Nr. 2");
		bcancel2 = new JButton("stornieren");// stornieren Button
		bcancel2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		bcancel2.setBounds(260, 350, 100, 30);
		panel.add(bcancel2);
		button3 = new JButton("Buchen");// buchung Button
		button3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		button3.setBounds(460, 350, 100, 30);
		panel.add(button3);
		button3.setToolTipText("Buchung der Wohnung Nr. 3");
		bcancel3 = new JButton("stornieren");// stornieren Button
		bcancel3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		bcancel3.setBounds(460, 350, 100, 30);
		panel.add(bcancel3);

		// Kalnder

		datum1 = new JLabel("Datum");
		datum1.setBounds(6, 305, 40, 10);
		panel.add(datum1);

		// Monate
		monate1 = new JComboBox();
		monate1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		monate1.setBounds(45, 300, 52, 22);
		panel.add(monate1);
		monate1.setModel(new DefaultComboBoxModel(
				new String[] { "Jan", "Feb", "Mar", "Apri", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez" }));

		// Tage
		tage1 = new JComboBox();
		tage1.setBounds(96, 300, 40, 22);
		panel.add(tage1);
		tage1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		tage1.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		jahr1 = new JComboBox();
		jahr1.setBounds(136, 300, 60, 22);
		panel.add(jahr1);
		jahr1.setModel(
				new DefaultComboBoxModel(new String[] { "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
		jahr1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		// Preis Label
		preis = new JLabel("Preis");
		preis.setBounds(6, 270, 50, 20);
		panel.add(preis);

		// Hinweise über die Änderung des Preis
		preis.setVerticalAlignment(JLabel.TOP);
		preis.setToolTipText("Damit Sie den Preis ändern Können, brauchen Sie Verwaltung Berichtigung");

		quadrat1 = new JLabel("Quadratmeter");
		quadrat1.setBounds(6, 240, 70, 24);
		panel.add(quadrat1);

		// Quadrat Label

		// Hinweise über die Änderung der Quadratmeteranzahl der Wohnung
		quadrat1.setVerticalAlignment(JLabel.TOP);
		quadrat1.setToolTipText("Damit Sie die Quadratmeteranzahl ändern können, brauchen Sie Verwaltung Berichtigung");

		lnepreis = new JLabel();// neuer Preis
		lnepreis.setBounds(60, 267, 67, 24);
		panel.add(lnepreis);
		lnepreis.setBackground(Color.LIGHT_GRAY);

		preis4 = new JLabel("20 € Np.P");
		preis4.setBounds(60, 267, 90, 24);
		panel.add(preis4);

		// Preis text boxe
		preisTEXT = new JTextField("20");
		preisTEXT.setBounds(61, 267, 90, 24);
		panel.add(preisTEXT);

		// nue Quadrat und Preis

		lneuqu = new JLabel();// neu quadrat
		lneuqu.setBounds(60, 234, 90, 24);
		panel.add(lneuqu);
		lneuqu.setBackground(Color.LIGHT_GRAY);

		quad1 = new JLabel("15Qm");
		quad1.setBounds(60, 235, 90, 24);
		panel.add(quad1);

		// Schreib box Quadrat
		qTEXT4 = new JTextField("15 qm");
		qTEXT4.setBounds(60, 235, 90, 24);
		panel.add(qTEXT4);
		datum2 = new JLabel("Datum");
		datum2.setBounds(210, 305, 40, 10);
		panel.add(datum2);

		monate2 = new JComboBox();
		monate2.setBounds(245, 300, 52, 22);
		panel.add(monate2);
		monate2.setModel(new DefaultComboBoxModel(
				new String[] { "Jan", "Feb", "Mar", "Apri", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez" }));
		preis2 = new JLabel("Preis");
		monate2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		preis2.setBounds(210, 270, 50, 20);
		panel.add(preis2);
		preis2.setVerticalAlignment(JLabel.TOP);
		preis2.setToolTipText("Um den Preis ändern zu können, müssen Sie als Administrator angemeldet sein!");
		quadrat2 = new JLabel("Quadratmeter");
		quadrat2.setBounds(210, 240, 70, 20);
		panel.add(quadrat2);
		quadrat2.setVerticalAlignment(JLabel.TOP);
		quadrat2.setToolTipText("Um die Quadratmeteranzahl ändern zu können, müssen Sie als Administrator angemeldet sein!");

		tage2 = new JComboBox();
		tage2.setBounds(296, 300, 40, 22);
		panel.add(tage2);
		tage2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		tage2.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		jahr2 = new JComboBox();
		jahr2.setBounds(336, 300, 60, 22);
		jahr2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		panel.add(jahr2);
		jahr2.setModel(
				new DefaultComboBoxModel(new String[] { "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
		datum3 = new JLabel("Datum");
		datum3.setBounds(410, 305, 40, 10);
		panel.add(datum3);

		monate3 = new JComboBox();
		monate3.setBounds(445, 300, 52, 22);
		monate3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		panel.add(monate3);
		monate3.setModel(new DefaultComboBoxModel(
				new String[] { "Jan", "Feb", "Mar", "Apri", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez" }));

		tage3 = new JComboBox();
		tage3.setBounds(496, 300, 40, 22);
		panel.add(tage3);
		tage3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		tage3.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		jahr3 = new JComboBox();
		jahr3.setBounds(536, 300, 60, 22);
		panel.add(jahr3);
		jahr3.setModel(
				new DefaultComboBoxModel(new String[] { "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
		jahr3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));

		lnepreis2 = new JLabel();// neu Preis
		lnepreis2.setBounds(260, 267, 90, 24);
		panel.add(lnepreis2);
		lnepreis2.setBackground(Color.LIGHT_GRAY);

		lneuqu2 = new JLabel();// neu quadrat
		lneuqu2.setBounds(260, 235, 90, 24);
		panel.add(lneuqu2);
		lneuqu2.setBackground(Color.LIGHT_GRAY);
		preis5 = new JLabel("20 € Np.P");
		preis5.setBounds(260, 267, 90, 24);
		panel.add(preis5);
		preisTEXT2 = new JTextField("20");
		preisTEXT2.setBounds(260, 267, 90, 24);
		panel.add(preisTEXT2);
		quad2 = new JLabel("15Qm");
		quad2.setBounds(260, 235, 90, 24);
		panel.add(quad2);
		qTEXT5 = new JTextField("15 qm");
		qTEXT5.setBounds(260, 235, 90, 24);
		panel.add(qTEXT5);
		preis3 = new JLabel("Preis");
		preis3.setBounds(410, 270, 50, 24);
		panel.add(preis3);
		preis3.setVerticalAlignment(JLabel.TOP);
		preis3.setToolTipText("Um den Preis ändern zu können, müssen Sie als Administrator angemeldet sein!");
		quadrat3 = new JLabel("Quadrat");
		quadrat3.setBounds(410, 240, 70, 24);
		panel.add(quadrat3);
		quadrat3.setVerticalAlignment(JLabel.TOP);
		quadrat3.setToolTipText("Um die Quadratmeteranzahl ändern zu können, müssen Sie als Administrator angemeldet sein!");

		lnepreis3 = new JLabel();// neu Preis
		lnepreis3.setBounds(460, 267, 90, 24);
		panel.add(lnepreis3);
		lnepreis3.setBackground(Color.LIGHT_GRAY);
		preis6 = new JLabel("20 € Np.P");
		preis6.setBounds(460, 267, 90, 24);
		panel.add(preis6);

		lneuqu3 = new JLabel();// neu quadrat
		lneuqu3.setBounds(460, 235, 90, 24);
		panel.add(lneuqu3);
		lneuqu3.setBackground(Color.LIGHT_GRAY);
		preisTEXT3 = new JTextField("20");
		preisTEXT3.setBounds(460, 267, 90, 24);
		panel.add(preisTEXT3);
		quad3 = new JLabel("15Qm");
		quad3.setBounds(460, 235, 90, 24);
		panel.add(quad3);
		qTEXT6 = new JTextField("15 qm");
		qTEXT6.setBounds(460, 235, 90, 24);
		panel.add(qTEXT6);
		adPreis = new JButton("ÄndP");
		adPreis.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		adPreis.setBounds(574, 270, 40, 20);
		panel.add(adPreis);
		adPreis.setToolTipText("Der Preis \u00E4ndern");
		adminquad = new JButton("ch");
		adminquad.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		adminquad.setBounds(574, 240, 40, 20);
		panel.add(adminquad);
		adminquad.setToolTipText("Die Quadrat \u00E4ndern");
		// ____________________________________________________________________________________________________________________
		// Button

		// weiter & Zurück bilder tausche

		a1 = new JButton("1");
		a1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		a1.setBounds(60, 200, 10, 10);
		panel.add(a1);
		a2 = new JButton("2");
		a2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		a2.setBounds(75, 200, 10, 10);
		panel.add(a2);
		a3 = new JButton("3");
		a3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		a3.setBounds(90, 200, 10, 10);
		panel.add(a3);
		c1 = new JButton("1");
		c1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		c1.setBounds(260, 200, 10, 10);
		panel.add(c1);
		c2 = new JButton("2");
		c2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		c2.setBounds(275, 200, 10, 10);
		panel.add(c2);
		c3 = new JButton("3");
		c3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		c3.setBounds(290, 200, 10, 10);
		panel.add(c3);
		g1 = new JButton("1");
		g1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		g1.setBounds(460, 200, 10, 10);
		panel.add(g1);
		g2 = new JButton("2");
		g2.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		g2.setBounds(490, 200, 10, 10);
		panel.add(g2);
		g3 = new JButton("3");
		g3.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		g3.setBounds(475, 200, 10, 10);
		panel.add(g3);
		b5 = new JLabel(image5);
		b5.setBounds(27, 45, 150, 150);
		panel.add(b5);
		b5.setToolTipText(
				"damit Sie die andre Bilder sehen brauchen Sie auf den kleinen  button unter die Bilder klicken");
		b6 = new JLabel(image6);
		b6.setBounds(27, 45, 150, 150);
		panel.add(b6);
		lbl = new JLabel(image);
		lbl.setBounds(27, 45, 150, 150);
		panel.add(lbl);
		b7 = new JLabel(image7);
		b7.setBounds(227, 45, 150, 150);
		panel.add(b7);
		b7.setToolTipText(
				"damit Sie die andre Bilder sehen brauchen Sie auf den kleinen  button unter die Bilder klicken");
		b8 = new JLabel(image8);
		b8.setBounds(227, 45, 150, 150);
		panel.add(b8);
		lbl2 = new JLabel(image2);
		lbl2.setBounds(227, 45, 150, 150);
		panel.add(lbl2);
		b9 = new JLabel(image9);
		b9.setBounds(427, 45, 150, 150);
		panel.add(b9);
		b9.setToolTipText(
				"damit Sie die andre Bilder sehen brauchen Sie auf den kleinen  button unter die Bilder klicken");
		b10 = new JLabel(image10);
		b10.setBounds(427, 45, 150, 150);
		panel.add(b10);
		lbl3 = new JLabel(image3);
		lbl3.setBounds(427, 45, 150, 150);
		panel.add(lbl3);
		label3 = new JLabel("Wohnung Nr3");
		label3.setBounds(460, 20, 100, 30);
		panel.add(label3);
		label3.setToolTipText("3Bilder sind verfügbar");

		// __________________________________________________________________________________________________________________________________
		// Label

		// Label, name grosse , Postionen, Hinfügen wohnung Nr 1,2,3
		label = new JLabel("Wohnung Nr1");
		label.setBounds(60, 20, 100, 28);
		panel.add(label);
		label.setToolTipText("3Bilder sind verfügbar");
		label2 = new JLabel("Wohnung Nr2");
		label2.setBounds(260, 20, 100, 30);
		panel.add(label2);
		label2.setToolTipText("3Bilder sind verfügbar");

		// Visiblty
		b17.setVisible(false);
		b18.setVisible(false);
		b11.setVisible(false);// Visiblty
		b12.setVisible(false);
		b13.setVisible(false);
		b14.setVisible(false);
		adminquad.setVisible(false);// Visiblty
		adPreis.setVisible(false);// Visiblty
		adPreis.addActionListener(this);
		qTEXT6.setVisible(false);// Visiblty
		quad3.setVisible(true);// Visiblty
		preisTEXT3.setVisible(false);// Visiblty
		preis6.setVisible(true);// Visiblty
		qTEXT5.setVisible(false);// Visiblty
		quad2.setVisible(true);// Visiblty
		preisTEXT2.setVisible(false);// Visiblty
		preis5.setVisible(true);// Visiblty
		qTEXT4.setVisible(false);// Visiblty
		quad1.setVisible(true);// Visiblty
		preisTEXT.setVisible(false);// Visiblty
		preis4.setVisible(true);// Visiblty
		bcancel3.setVisible(false);
		button3.setVisible(false);
		bcancel2.setVisible(false);
		button2.setVisible(false);
		bCancel.setVisible(false);
		button.setVisible(false);
		lbl3.setVisible(true);
		b10.setVisible(false);// Visiblty
		b9.setVisible(false);// Visiblty
		lbl2.setVisible(true);
		b8.setVisible(false);// Visiblty
		b7.setVisible(false);// Visiblty
		lbl.setVisible(true);
		b6.setVisible(false);// Visiblty
		b5.setVisible(false);// Visiblty
		radioButton1.setEnabled(false);

		// die objekte hinfügen

		getContentPane().add(neUser);
		getContentPane().add(b12);
		getContentPane().add(b13);
		getContentPane().add(b14);
		getContentPane().add(b15);
		getContentPane().add(info);
		getContentPane().add(reset);
		getContentPane().add(beenden);
		getContentPane().add(checkBox);
		getContentPane().add(checkBox1);
		getContentPane().add(checkBox2);
		getContentPane().add(checkBox3);
		getContentPane().add(checkBox4);
		getContentPane().add(checkBox5);
		getContentPane().add(checkBox6);
		getContentPane().add(datenschuetz);
		getContentPane().add(label4);
		getContentPane().add(label5);
		getContentPane().add(label6);
		getContentPane().add(label7);
		getContentPane().add(radioButton1);
		getContentPane().add(radioButton2);
		getContentPane().add(nachname);
		getContentPane().add(Adresse);
		getContentPane().add(statbuergerschaft);
		getContentPane().add(lbl4);
		getContentPane().add(b17);
		getContentPane().add(b18);
		getContentPane().add(vorname);
		getContentPane().add(b12);
		getContentPane().add(b13);
		getContentPane().add(b14);
		getContentPane().add(b15);
		getContentPane().add(btnAppErkaelrung);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 350, 350, 100);
		getContentPane().add(scrollPane);

		// Schreibung Box für wünsche
		area = new JTextArea("Wünsche....", 180, 600);
		scrollPane.setColumnHeaderView(area);
		area.setBackground(Color.WHITE);// Hintergrunds farbe
		area.setForeground(Color.BLUE);// schrifft farbe
		area.setLineWrap(true);
		area.setWrapStyleWord(true);

		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setViewportView(scrollBar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 323, 350, 22);
		getContentPane().add(separator_1);

		page = new JButton("page");
		page.setToolTipText("page");
		page.setForeground(new Color(184, 134, 11));
		page.setBackground(new Color(222, 184, 135));
		page.setBounds(580, 509, 10, 13);
		getContentPane().add(page);

		gruen = new JButton("darkGray");
		gruen.setToolTipText("Grün");
		gruen.setForeground(new Color(72, 209, 204));
		gruen.setBackground(new Color(0, 206, 209));
		gruen.setBounds(560, 509, 10, 13);
		getContentPane().add(gruen);

		orginal = new JButton("orginal");
		orginal.setForeground(Color.LIGHT_GRAY);
		orginal.setBounds(600, 509, 10, 13);
		getContentPane().add(orginal);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null));
		scrollPane_1.setBounds(1000, 73, 200, 440);
		getContentPane().add(scrollPane_1);

		// schreibung Box für die Buchung
		area2 = new JTextArea("Ihre Buchung wird hier angezeigt....");
		scrollPane_1.setViewportView(area2);
		area2.setBackground(Color.WHITE);// Hintergrunds farbe
		area2.setForeground(Color.BLUE);// schrifft farbe
		area2.setLineWrap(true);
		area2.setWrapStyleWord(true);

		panel_1 = new JPanel();
		scrollPane_1.setColumnHeaderView(panel_1);
		panel_1.setLayout(null);

		// Zu ACtion Listener hinfügen
		orginal.addActionListener(this);
		page.addActionListener(this);
		info.addActionListener(this);
		vorname.addActionListener(this);
		nachname.addActionListener(this);
		Adresse.addActionListener(this);
		statbuergerschaft.addActionListener(this);
		reset.addActionListener(this);
		radioButton1.addActionListener(this);
		radioButton2.addActionListener(this);
		checkBox.addActionListener(this);
		checkBox1.addActionListener(this);
		checkBox2.addActionListener(this);
		checkBox3.addActionListener(this);
		datenschuetz.addActionListener(this);
		beenden.addActionListener(this);
		btnAppErkaelrung.addActionListener(this);
		nbtn.addActionListener(this);
		nbtn2.addActionListener(this);
		nbtn3.addActionListener(this);
		nbtn4.addActionListener(this);
		btnPrint.addActionListener(this);
		btnPrint2.addActionListener(this);
		infoFeldsbtn.addActionListener(this);
		neUser.addActionListener(this);
		mntmPrint.addActionListener(this);
		closeItem.addActionListener(this);
		kopie.addActionListener(this);
		appErk.addActionListener(this);
		loeschen.addActionListener(this);
		auschneiden.addActionListener(this);
		neuItem.addActionListener(this);
		btnKontakt.addActionListener(this);
		gruen.addActionListener(this);
		g3.addActionListener(this);
		g2.addActionListener(this);
		g1.addActionListener(this);
		c3.addActionListener(this);
		c2.addActionListener(this);
		c1.addActionListener(this);
		a3.addActionListener(this);
		a2.addActionListener(this);
		adminquad.addActionListener(this);
		a1.addActionListener(this);
		qTEXT4.addActionListener(this);
		preisTEXT2.addActionListener(this);
		preisTEXT3.addActionListener(this);
		qTEXT6.addActionListener(this);
		qTEXT5.addActionListener(this);
		preisTEXT.addActionListener(this);
		monate1.addActionListener(this);
		bcancel3.addActionListener(this);
		button3.addActionListener(this);
		bcancel2.addActionListener(this);
		button2.addActionListener(this);
		bCancel.addActionListener(this);
		button.addActionListener(this);

		weiterButton.addActionListener(this);
		passwort.addActionListener(this);
		adminName.addActionListener(this);
		angemeldet.setVisible(false);// Visiblty
		angemeldet.addActionListener(this);
		abmelden.setVisible(false);
		abmelden.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.bCancel) {
			area2.setText("Sie haben die Wohnung Nr. 1 storniert, Ihre Daten lauten: " + " Vorname lautet : "
					+ vorname.getText() + "  Nachname lautet :  " + nachname.getText() + "  Adresse lautet:  "
					+ Adresse.getText() + "  Der Preis für eine Nacht beträgt  " + preisTEXT.getText() + " euro");
			String[] currentBuchung = { vorname.getText(), nachname.getText(), Adresse.getText() };
			buchungen.remove(currentBuchung);
			bCancel.setVisible(false);
			button.setVisible(true);
			nbtn.setVisible(true);
			nbtn2.setVisible(true);
			nbtn3.setVisible(true);
			nbtn4.setVisible(true);
			button.setVisible(true);
			button2.setVisible(true);
			button3.setVisible(true);

		}
		if (e.getSource() == this.bcancel2) {
			area2.setText("Sie haben die Wohnung Nr. 2 storniert, Ihre Daten lauten: " + " Vorname lautet : "
					+ vorname.getText() + "  Nachname lautet  " + nachname.getText() + "  Adresse lautet  "
					+ Adresse.getText() + "  Der Preis für eine Nacht ist  " + preisTEXT2.getText() + " euro");
			String[] currentBuchung = { vorname.getText(), nachname.getText(), Adresse.getText() };
			buchungen.remove(currentBuchung);
			bcancel2.setVisible(false);
			button2.setVisible(true);
			nbtn.setVisible(true);
			nbtn2.setVisible(true);
			nbtn3.setVisible(true);
			nbtn4.setVisible(true);
			button.setVisible(true);
			button2.setVisible(true);
			button3.setVisible(true);

		}
		if (e.getSource() == this.bcancel3) {
			area2.setText("Sie haben die Wohnung Nr. 3 storniert, Ihre Daten lauten: ------------- " + " Vorname lautet : "
					+ vorname.getText() + "----------------  Nachname lautet  " + nachname.getText() + "  Adresse lautet  "
					+ Adresse.getText() + "-----------------  Der Preis für eine Nacht ist  " + preisTEXT3.getText()
					+ " euro");
			String[] currentBuchung = { vorname.getText(), nachname.getText(), Adresse.getText() };
			buchungen.remove(currentBuchung);
			bcancel3.setVisible(false);
			button3.setVisible(true);
			nbtn.setVisible(true);
			nbtn2.setVisible(true);
			nbtn3.setVisible(true);
			nbtn4.setVisible(true);
			button.setVisible(true);
			button2.setVisible(true);
			button3.setVisible(true);

		}

		if (e.getSource() == this.button) {

			area2.setText("Sie haben die Wohnung Nr. 1 gebucht ihre Daten lauten:  ------------------------------ "
					+ "   Vorname lautet : " + vorname.getText() + "------------------------------     Nachname lautet  "
					+ nachname.getText() + "  Adresse lautet :    " + Adresse.getText() + "           am "
					+ tage1.getSelectedItem() + "." + monate1.getSelectedItem() + "." + jahr1.getSelectedItem()
					+ "-----------------------   Der Preis für eine Nacht beträgt  " + preisTEXT.getText() + " euro");
			String[] currentBuchung = { vorname.getText(), nachname.getText(), Adresse.getText() };
			buchungen.add(currentBuchung);
			bCancel.setVisible(true);
			button.setVisible(false);
			button2.setVisible(false);
			button3.setVisible(false);
			area2.setEditable(false);

		}

		if (e.getSource() == this.button2) {
			area2.setText("Sie haben die Wohnung Nr. 2 gebucht ihre Daten lauten: " + " Vorname lautet : "
					+ vorname.getText() + "  Nachname lautet  " + nachname.getText() + "  Adresse lautet : "
					+ Adresse.getText() + " am " + tage2.getSelectedItem() + "." + monate2.getSelectedItem() + "."
					+ jahr2.getSelectedItem() + "  Der Preis für eine Nacht beträgt  " + preisTEXT2.getText() + " euro");
			String[] currentBuchung = { vorname.getText(), nachname.getText(), Adresse.getText() };
			buchungen.add(currentBuchung);
			bcancel2.setVisible(true);
			button2.setVisible(false);
			area2.setEditable(false);
			button.setVisible(false);
			button3.setVisible(false);
			if (tage2.getItemCount() > 0) {
				tage2.removeItemAt(tage2.getSelectedIndex());
			}
		}

		if (e.getSource() == this.button3) {
			area2.setText("Sie haben die Wohnung Nr. 3 gebucht ihre Daten lauten: " + " Vorname lautet : "
					+ vorname.getText() + "  Nachname lautet  " + nachname.getText() + "  Adresse lautet :  "
					+ Adresse.getText() + " am " + tage3.getSelectedItem() + "." + monate3.getSelectedItem() + "."
					+ jahr3.getSelectedItem() + "  Der Preis für eine Nacht beträgt  " + preisTEXT3.getText() + " euro");
			String[] currentBuchung = { vorname.getText(), nachname.getText(), Adresse.getText() };
			buchungen.add(currentBuchung);
			bcancel3.setVisible(true);
			area2.setEditable(false);
			button3.setVisible(false);
			button.setVisible(false);
			button2.setVisible(false);

			if (tage3.getItemCount() > 0) {
				tage3.removeItemAt(tage3.getSelectedIndex());
			}

		}

		if (e.getSource() == this.reset) {
			int confirmed3 = JOptionPane.showConfirmDialog(null, "Wollen Sie ihre Buchung ändern?", "Reset",
					JOptionPane.YES_NO_OPTION);
			if (confirmed3 == JOptionPane.YES_OPTION) {
				area2.setText(("Ihre Buchung wird hier angezeigt.... "));
				area.setText(("Wünsche.... "));
				nbtn.setVisible(true);
				nbtn2.setVisible(true);
				nbtn3.setVisible(true);
				nbtn4.setVisible(true);
				radioButton1.setEnabled(false);
				vorname.setEditable(true);
				Adresse.setEditable(true);
				nachname.setEditable(true);
				statbuergerschaft.setEditable(true);

			} else {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}

		}

		if (e.getSource() == this.info) {
			JOptionPane.showMessageDialog(null, "Diese App wurde von Studenten der HWR-Berlin erstellt. ");

		}

		if (e.getSource() == this.datenschuetz) {
			JOptionPane.showMessageDialog(null,
					"Ihre Daten werden nach Beendigung des Programms DSGVO-konform verarbeitet.");

		}

		if (e.getSource() == this.btnAppErkaelrung) {
			JOptionPane.showMessageDialog(null, "Mithilfe dieses Projekts können Sie eine Ferienwohnung buchen. ");

		}

		if (e.getSource() == this.checkBox) {
			area.setText(("Sie haben die Wohnung und Frühstück ausgewahlt: "));
		} else if (e.getSource() == this.checkBox1) {
			area.setText(("Sie haben die Wohnung und Sauna ausgewahlt: "));
		} else if (e.getSource() == this.checkBox2) {
			area.setText(("Sie haben die Wohnung und Service ausgewahlt: "));
		} else if (e.getSource() == this.checkBox3) {
			area.setText(("Sie haben die Wohnung und All-Inclusive ausgewahlt: "));
		}

		if (e.getSource() == this.abmelden) {
			String neuPreis = preisTEXT.getText();
			lnepreis.setText(neuPreis + "€");
			lnepreis.setVisible(true);
			lnepreis.setVisible(true);
			String neuPreis2 = preisTEXT2.getText();
			lnepreis2.setText(neuPreis2 + "€");
			lnepreis2.setVisible(true);
			String neuPreis3 = preisTEXT3.getText();
			lnepreis3.setText(neuPreis3 + "€");
			lnepreis3.setVisible(true);
			String neuquad1 = qTEXT4.getText();
			lneuqu.setText(neuquad1);
			lneuqu.setVisible(true);
			String neuquad2 = preisTEXT2.getText();
			lneuqu2.setText(neuquad2 + "qm");
			lneuqu2.setVisible(true);
			String neuquad3 = preisTEXT3.getText();
			lneuqu3.setText(neuquad3 + "qm");
			lneuqu3.setVisible(true);

			checkBox.setEnabled(true);
			checkBox1.setEnabled(true);
			checkBox2.setEnabled(true);
			checkBox3.setEnabled(true);

			// Zahlungmethode
			checkBox4.setEnabled(true);
			checkBox5.setEnabled(true);
			checkBox6.setEnabled(true);
			checkBox7.setEnabled(true);

			btnPrint2.setEnabled(false);

			neUser.setEnabled(true);
			neuItem.setEnabled(true);
			area.setText(("Sie sind als normaler Benutzer angemeldet."));
			btnPrint.setVisible(true);
			vorname.setEditable(true);
			Adresse.setEditable(true);
			nachname.setEditable(true);
			statbuergerschaft.setEditable(true);
			radioButton1.setEnabled(true);
			radioButton2.setEnabled(true);
			nbtn.setVisible(true);
			nbtn2.setVisible(true);
			nbtn3.setVisible(true);
			nbtn4.setVisible(true);
			table.setVisible(false);
			area2.setVisible(true);
			scrollPane_1.setVisible(true);
			adminName.setEditable(true);
			passwort.setEditable(true);

			adPreis.setVisible(false);
			adminquad.setVisible(false);

			preisTEXT.setVisible(false);
			preisTEXT2.setVisible(false);// Visiblty
			preisTEXT3.setVisible(false);// Visiblty

			qTEXT4.setVisible(false);// Visiblty
			qTEXT5.setVisible(false);// Visiblty
			qTEXT6.setVisible(false);// Visiblty
			infoFeldsbtn.setVisible(false);// Visiblty

			quad1.setVisible(false);// Visiblty
			quad2.setVisible(false);// Visiblty
			quad3.setVisible(false);// Visiblty
			area2.setVisible(true);// Visiblty
			// scrollPane_2.setVisible(false);
			table.setVisible(false);
			abmelden.setVisible(false);
			angemeldet.setVisible(false);// Visiblty
			weiterButton.setVisible(true);// Visiblty
			abmelden.setVisible(false);// Visiblty
			btnKontakt.setVisible(true);
			reset.setEnabled(true);

		}

		if (e.getSource() == this.radioButton1) {
			button.setVisible(true);
			button2.setVisible(true);
			button3.setVisible(true);

		} else if (e.getSource() == this.radioButton2) {
			button.setVisible(false);
			button2.setVisible(false);
			button3.setVisible(false);

		}

		if (e.getSource() == this.a1) {
			lbl.setVisible(true);// Visiblty
			b5.setVisible(false);// Visiblty
			b6.setVisible(false);// Visiblty

		} else if (e.getSource() == this.a2) {
			lbl.setVisible(false);// Visiblty
			b5.setVisible(true);// Visiblty
			b6.setVisible(false);// Visiblty
		} else if (e.getSource() == this.a3) {
			lbl.setVisible(false);// Visiblty
			b5.setVisible(false);// Visiblty
			b6.setVisible(true);// Visiblty
		}
		if (e.getSource() == this.c1) {

			lbl2.setVisible(true);// Visiblty
			b7.setVisible(false);// Visiblty
			b8.setVisible(false);// Visiblty

		} else if (e.getSource() == this.c2) {
			lbl2.setVisible(false);// Visiblty
			b7.setVisible(true);// Visiblty
			b8.setVisible(false);// Visiblty

		} else if (e.getSource() == this.c3) {
			lbl2.setVisible(false);// Visiblty
			b7.setVisible(false);// Visiblty
			b8.setVisible(true);// Visiblty
		}
		if (e.getSource() == this.g1) {

			lbl3.setVisible(true);// Visiblty
			b9.setVisible(false);// Visiblty
			b10.setVisible(false);// Visiblty

		} else if (e.getSource() == this.g2) {
			lbl3.setVisible(false);// Visiblty
			b9.setVisible(true);// Visiblty
			b10.setVisible(false);// Visiblty

		} else if (e.getSource() == this.g3) {
			lbl3.setVisible(false);// Visiblty
			b9.setVisible(false);// Visiblty
			b10.setVisible(true);// Visiblty

		}
		if (e.getSource() == this.nbtn) {

			vorname.setEditable(false);

			nbtn.setVisible(false);
			b12.setVisible(true);

		}
		if (e.getSource() == this.nbtn2) {
			nbtn2.setVisible(false);
			nachname.setEditable(false);
			b13.setVisible(true);

		}
		if (e.getSource() == this.nbtn3) {
			Adresse.setEditable(false);

			nbtn3.setVisible(false);
			b14.setVisible(true);

		}
		if (e.getSource() == this.nbtn4) {
			nbtn4.setVisible(false);
			statbuergerschaft.setEditable(false);

			b15.setVisible(true);

		}

		if (e.getSource() == this.btnPrint) {
			try {
				area2.print();
			} catch (PrinterException ex) {
				ex.printStackTrace();
			}
		}

		if (e.getSource() == qTEXT4.getInputContext()) {
			quadrat1 = new JLabel();
			quad1.setVisible(false);
		}

		if (e.getSource() == this.neUser) {
			vorname.setEditable(true);
			Adresse.setEditable(true);
			nachname.setEditable(true);
			statbuergerschaft.setEditable(true);
			nbtn.setVisible(true);
			nbtn2.setVisible(true);
			nbtn3.setVisible(true);
			nbtn4.setVisible(true);
			radioButton2.setSelected(true);

			bCancel.setVisible(false);
			bcancel2.setVisible(false);
			bcancel3.setVisible(false);
			radioButton1.setEnabled(false);

			area.setText((" Wünsche..."));
			area2.setText(("Ihre Buchung wird hier angezeigt..."));
			button.setVisible(false);
			button2.setVisible(false);
			button3.setVisible(false);

		}
		if (e.getSource() != this.nbtn4
				|| e.getSource() != this.nbtn2 && e.getSource() != this.nbtn3 && e.getSource() != this.nbtn) {
			radioButton1.setEnabled(true);

			if (e.getSource() == this.radioButton1) {
				button.setVisible(true);
				button2.setVisible(true);
				button3.setVisible(true);

			} else if (e.getSource() == this.radioButton2) {
				button.setVisible(false);
				button2.setVisible(false);
				button3.setVisible(false);

			}

		}
		if (e.getSource() == bCancel == false) {

		}

		if (e.getSource() == neuItem) {
			vorname.setEditable(true);
			Adresse.setEditable(true);
			nachname.setEditable(true);
			statbuergerschaft.setEditable(true);
			nbtn.setVisible(true);
			nbtn2.setVisible(true);
			nbtn3.setVisible(true);
			nbtn4.setVisible(true);
			radioButton2.setSelected(true);

			bCancel.setVisible(false);
			bcancel2.setVisible(false);
			bcancel3.setVisible(false);
			button.setVisible(false);
			button2.setVisible(false);
			button3.setVisible(false);
			radioButton1.setEnabled(false);

			area.setText((" Wünsche..."));
			area2.setText(("Ihre Buchung wird hier angezeigt..."));
		}

		if (e.getSource() == this.mntmPrint) {
			try {
				area2.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == this.closeItem) {
			int confirmed = JOptionPane.showConfirmDialog(null, "Wollen Sie das Program beenden?", "Beenden",
					JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION) {
				System.exit(-1);

			} else {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			}
		}
		if (e.getSource() == this.kopie) {
			area2.copy();
		}
		if (e.getSource() == this.appErk) {
			JOptionPane.showMessageDialog(null, "Mithilfe dieses Projekts können Sie Ferienwohnungen buchen. ");

		}
		if (e.getSource() == this.loeschen) {

		}
		if (e.getSource() == this.auschneiden) {
			area2.cut();

		}
		if (e.getSource() == this.wahl) {
			area2.selectAll();
		}
		if (e.getSource() == this.past) {
			area.paste();

		}

		if (e.getSource() == this.infoFeldsbtn) {
			model.addColumn("Vorname");
			model.addColumn("Nachname");
			model.addColumn("Adresse");
			radioButton1.setEnabled(false);

			tableScroller.setBounds(1000, 73, 200, 440);
			getContentPane().add(tableScroller);
			tableScroller.setVisible(true);
			for (String[] b : buchungen) {
				model.addRow(b);
			}

		}
		if (e.getSource() == this.weiterButton) {// anmelden Button
			String ad = adminName.getText();
			String pass = passwort.getText();

			if (benutz.equals(ad) && passw.equals(pass)) {// Passwort überprüfen
				radioButton1.setEnabled(false);
				bCancel.setVisible(false);
				bcancel2.setVisible(false);
				bcancel3.setVisible(false);

				button.setVisible(false);
				button2.setVisible(false);
				button3.setVisible(false);
				checkBox.setEnabled(false);
				checkBox1.setEnabled(false);
				checkBox2.setEnabled(false);
				checkBox3.setEnabled(false);

				// Zahlungmethode
				checkBox4.setEnabled(false);
				checkBox5.setEnabled(false);
				checkBox6.setEnabled(false);
				checkBox7.setEnabled(false);

				neUser.setEnabled(false);
				neuItem.setEnabled(false);
				radioButton1.setEnabled(false);

				JOptionPane.showMessageDialog(null, "Sie haben sich als Admin angemeldet");// Message für den Admin
				adminName.setEditable(false);
				passwort.setEditable(false);
				nbtn.setVisible(false);
				nbtn2.setVisible(false);
				nbtn3.setVisible(false);
				nbtn4.setVisible(false);
				vorname.setEditable(false);
				Adresse.setEditable(false);
				nachname.setEditable(false);
				statbuergerschaft.setEditable(false);
				radioButton1.setEnabled(false);
				radioButton2.setEnabled(false);
				btnPrint2.setVisible(true);
				btnPrint2.setEnabled(true);
				radioButton2.setSelected(true);
				b11.setVisible(false);
				b12.setVisible(false);
				b13.setVisible(false);
				b14.setVisible(false);
				b15.setVisible(false);
				reset.setEnabled(false);

				angemeldet.setVisible(true);// Visiblty
				weiterButton.setVisible(false);// Visiblty
				area.setText(
						("Sie sind als Admin angemeldet"));// Message
																																					// für
																																					// admin
				abmelden.setVisible(true);// Visiblty
				btnKontakt.setVisible(false);

				preis4.setVisible(false);// Visiblty
				preis5.setVisible(false);// Visiblty
				preis6.setVisible(false);// Visiblty

				preisTEXT.setVisible(true);// Visiblty
				preisTEXT2.setVisible(true);// Visiblty
				preisTEXT3.setVisible(true);// Visiblty

				qTEXT4.setVisible(true);// Visiblty
				qTEXT5.setVisible(true);// Visiblty
				qTEXT6.setVisible(true);// Visiblty
				infoFeldsbtn.setVisible(true);// Visiblty

				quad1.setVisible(false);// Visiblty
				quad2.setVisible(false);// Visiblty
				quad3.setVisible(false);// Visiblty

				adPreis.setVisible(true);// Visiblty
				adminquad.setVisible(true);// Visiblty
				area2.setVisible(false);// Visiblty
				scrollPane_1.setVisible(false);
				btnPrint.setVisible(false);
				lnepreis.setVisible(false);// Visiblty
				lnepreis2.setVisible(false);// Visiblty
				lnepreis3.setVisible(false);// Visiblty

				lneuqu.setVisible(false);// Visiblty
				lneuqu2.setVisible(false);// Visiblty
				lneuqu3.setVisible(false);// Visiblty

			} else {// wenn das Passwort falsch ist
				JOptionPane.showMessageDialog(null, "Falscher Benutzername bzw. Passwort");

			}

		}

		if (e.getSource() == this.btnPrint2) {
			radioButton1.setEnabled(false);

			try {
				table.print();
			} catch (PrinterException ex) {
				ex.printStackTrace();
			}
		}
		// wenn der Admin den preis ändren will
		if (e.getSource() == this.adPreis) {
			radioButton1.setEnabled(false);

			String neuPreis = preisTEXT.getText();
			lnepreis.setText(neuPreis + "€");
			preis4.setVisible(false);// Visiblty
			preisTEXT.setVisible(false);
			adPreis.setVisible(false);
			lnepreis.setVisible(true);
			String neuPreis2 = preisTEXT2.getText();
			lnepreis2.setText(neuPreis2 + "€");
			preis5.setVisible(false);// Visiblty
			preisTEXT2.setVisible(false);
			lnepreis2.setVisible(true);
			String neuPreis3 = preisTEXT3.getText();
			lnepreis3.setText(neuPreis3 + "€");
			preis6.setVisible(false);// Visiblty
			preisTEXT3.setVisible(false);
			lnepreis3.setVisible(true);

			if (e.getSource() == this.abmelden) {
				lnepreis.setVisible(true);
				lnepreis2.setVisible(true);
				lnepreis3.setVisible(true);

			}

		}
		// wenn der Admin die Qudrat ändren will
		if (e.getSource() == this.adminquad) {

			String neuquad1 = qTEXT4.getText();
			lneuqu.setText(neuquad1 + "qm");
			quad1.setVisible(false);// Visiblty
			qTEXT4.setVisible(false);
			adminquad.setVisible(false);
			lneuqu.setVisible(true);
			String neuquad2 = preisTEXT2.getText();
			lneuqu2.setText(neuquad2 + "qm");
			quad2.setVisible(false);// Visiblty
			qTEXT5.setVisible(false);
			lneuqu2.setVisible(true);
			String neuquad3 = preisTEXT3.getText();
			lneuqu3.setText(neuquad3 + "qm");
			quad3.setVisible(false);// Visiblty
			qTEXT6.setVisible(false);
			lneuqu3.setVisible(true);

			if (e.getSource() == this.abmelden) {
				lneuqu.setVisible(true);
				lneuqu2.setVisible(true);
				lneuqu3.setVisible(true);

			}
		}

		if (e.getSource() == this.btnKontakt) {
			JOptionPane.showMessageDialog(null, "lrnzkell@gmail.com");
			radioButton1.setEnabled(false);

		}

		if (e.getSource() == this.beenden) {
			int confirmed2 = JOptionPane.showConfirmDialog(null, "Wollen Sie das Program beenden?", "EXIT",
					JOptionPane.YES_NO_OPTION);
			if (confirmed2 == JOptionPane.YES_OPTION) {

				System.exit(-1);

			} else {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			}
		}

		if (e.getSource() == this.page) {
			this.getContentPane().setBackground(new Color(210, 180, 140));
			radioButton1.setBackground(new Color(210, 180, 140));
			radioButton2.setBackground(new Color(210, 180, 140));
			checkBox7.setBackground(new Color(210, 180, 140));
			checkBox4.setBackground(new Color(210, 180, 140));
			checkBox5.setBackground(new Color(210, 180, 140));
			checkBox6.setBackground(new Color(210, 180, 140));

			// chekbox background Farbe
			checkBox.setBackground(new Color(210, 180, 140));
			checkBox1.setBackground(new Color(210, 180, 140));
			checkBox2.setBackground(new Color(210, 180, 140));
			checkBox3.setBackground(new Color(210, 180, 140));
			menuBar.setBackground(new Color(210, 180, 140));
			bearbeiten.setBackground(new Color(210, 180, 140));
			hilfe.setBackground(new Color(210, 180, 140));
			fileMenu.setBackground(new Color(210, 180, 140));
			bearbeiten2.setBackground(new Color(210, 180, 140));
			hilfe2.setBackground(new Color(210, 180, 140));
			b17.setVisible(false);
			b18.setVisible(true);
			lbl4.setVisible(false);
			Verwaltung.setBackground(new Color(210, 180, 140));
			panel.setBackground(new Color(210, 180, 140));

		}

		if (e.getSource() == this.gruen) {
			this.getContentPane().setBackground(new Color(153, 204, 204));
			radioButton1.setBackground(new Color(153, 204, 204));
			radioButton2.setBackground(new Color(153, 204, 204));
			checkBox7.setBackground(new Color(153, 204, 204));
			checkBox4.setBackground(new Color(153, 204, 204));
			checkBox5.setBackground(new Color(153, 204, 204));
			checkBox6.setBackground(new Color(153, 204, 204));

			// chekbox background Farbe
			checkBox.setBackground(new Color(153, 204, 204));
			checkBox1.setBackground(new Color(153, 204, 204));
			checkBox2.setBackground(new Color(153, 204, 204));
			checkBox3.setBackground(new Color(153, 204, 204));
			menuBar.setBackground(new Color(153, 204, 204));
			bearbeiten.setBackground(new Color(153, 204, 204));
			hilfe.setBackground(new Color(153, 204, 204));
			fileMenu.setBackground(new Color(153, 204, 204));
			bearbeiten2.setBackground(new Color(153, 204, 204));
			hilfe2.setBackground(new Color(153, 204, 204));
			image4 = new ImageIcon("b17.png");// Logo
			b17.setVisible(true);
			b18.setVisible(false);
			lbl4.setVisible(false);
			Verwaltung.setBackground(new Color(153, 204, 204));
			panel.setBackground(new Color(153, 204, 204));
			this.getContentPane().setBackground(new Color(153, 204, 204));
			radioButton1.setEnabled(false);

		}
		if (e.getSource() == this.orginal) {
			radioButton1.setEnabled(false);

			this.getContentPane().setBackground(Color.LIGHT_GRAY);
			radioButton1.setBackground(Color.LIGHT_GRAY);
			radioButton2.setBackground(Color.LIGHT_GRAY);
			checkBox7.setBackground(Color.LIGHT_GRAY);
			checkBox4.setBackground(Color.LIGHT_GRAY);
			checkBox5.setBackground(Color.LIGHT_GRAY);
			checkBox6.setBackground(Color.LIGHT_GRAY);

			// chekbox background Farbe
			checkBox.setBackground(Color.LIGHT_GRAY);
			checkBox1.setBackground(Color.LIGHT_GRAY);
			checkBox2.setBackground(Color.LIGHT_GRAY);
			checkBox3.setBackground(Color.LIGHT_GRAY);
			menuBar.setBackground(Color.LIGHT_GRAY);
			bearbeiten.setBackground(Color.LIGHT_GRAY);
			hilfe.setBackground(Color.LIGHT_GRAY);
			fileMenu.setBackground(Color.LIGHT_GRAY);
			bearbeiten2.setBackground(Color.LIGHT_GRAY);
			hilfe2.setBackground(Color.LIGHT_GRAY);
			Verwaltung.setBackground(Color.LIGHT_GRAY);
			panel.setBackground(Color.LIGHT_GRAY);

			b17.setVisible(false);
			b18.setVisible(false);
			lbl4.setVisible(true);
		}

	}
}
