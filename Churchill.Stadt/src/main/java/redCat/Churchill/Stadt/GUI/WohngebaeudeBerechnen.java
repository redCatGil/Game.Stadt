package redCat.Churchill.Stadt.GUI;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import redCat.Churchill.Stadt.Bauwerke.api.Wohngebaeude_api;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.Wohngebaeude;
import redCat.Churchill.Stadt.Enumeration.Gebaeude_enum;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Scale;


public class WohngebaeudeBerechnen extends Dialog {

	protected Object result;
	protected Shell shlHausRechnen;
	private Text txt1;
	private Text txt2;
	private Text txt3;
	private Text txt4;
	private Text txt5;
	private Text txt6;
	private Text txt7;
	private Text txt8;
	private Text txt9;
	private Text txt10;
	private Text txtAnzahl;
	private Text txtMuenzen;
	private Text txtWerkzeug;
	private Text txtDiamanten;
	private Text txtBewohner;
	private Text txtEinnahmen;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;
	private Text text_15;
	private Scale scaleAnzahl;
	private final int SCALEMIN = 1;
	private final int SCALEMAX = 10;
	private Text txtPAnzahl;
	private Label lbHaeuser;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public WohngebaeudeBerechnen(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlHausRechnen.open();
		shlHausRechnen.layout();
		Display display = getParent().getDisplay();
		while (!shlHausRechnen.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlHausRechnen = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN);
		shlHausRechnen.setSize(665, 545);
		shlHausRechnen.setText("Berechnungen f\u00FCr Wohnh\u00E4user");
		
		final Combo cbAus = new Combo(shlHausRechnen, SWT.NONE);
		cbAus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (cbAus.getSelectionIndex() > -1) {
					Wohngebaeude wog = Toolbox.WogAuswahl(cbAus.getSelectionIndex());
					txt1.setText(wog.getName());
					txt2.setText(wog.getZeitalter());
					txt3.setText(wog.getMuenzen().toString());
					txt4.setText(wog.getWerkzeug().toString());
					txt5.setText(wog.getDiamanten().toString());
					txt6.setText(wog.getLaenge().toString() + " / " + wog.getBreite().toString());
					txt8.setText(wog.getBewohner().toString());
					txt9.setText(wog.getMuenz_einnahmen().toString());
					txt10.setText("alle ");
//					System.out.println(wog.toString());
					txt10.setText(txt10.getText() + Toolbox.intToTime(wog.getEinnahme_dauer().intValue()));
					txt7.setText(Toolbox.TimeToString(wog.getBauzeit()));	
					//wenn ein Objekt ausgew�hlt wurde, wird die Eingabe aktiviert: txtAnzahl und scaleAnzahl werden eingabef�hig
					scaleAnzahl.setEnabled(true);
					txtAnzahl.setEditable(true);
					txtPAnzahl.setEditable(true);
					
				}
			}
		});
		cbAus.setBounds(107, 26, 91, 23);	
		
		for (Gebaeude_enum gebx : Gebaeude_enum.values()) {
			cbAus.add(gebx.toString());		
		}
		
		Button btnBeenden = new Button(shlHausRechnen, SWT.NONE);
		btnBeenden.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shlHausRechnen.close();
			}
		});
		btnBeenden.setBounds(560, 461, 75, 25);
		btnBeenden.setText("Beenden");
		
		Label lb1 = new Label(shlHausRechnen, SWT.NONE);
		lb1.setText("Name:");
		lb1.setBounds(29, 72, 55, 15);
		
		txt1 = new Text(shlHausRechnen, SWT.BORDER);
		txt1.setEditable(false);
		txt1.setBounds(107, 72, 91, 21);
		
		Label lb2 = new Label(shlHausRechnen, SWT.NONE);
		lb2.setText("Zeitalter:");
		lb2.setBounds(29, 102, 55, 15);
		
		txt2 = new Text(shlHausRechnen, SWT.BORDER);
		txt2.setEditable(false);
		txt2.setBounds(107, 102, 91, 21);
		
		Label lb3 = new Label(shlHausRechnen, SWT.NONE);
		lb3.setText("M\u00FCnzen:");
		lb3.setBounds(29, 132, 55, 15);
		
		txt3 = new Text(shlHausRechnen, SWT.BORDER);
		txt3.setEditable(false);
		txt3.setBounds(107, 132, 91, 21);
		
		Label lb4 = new Label(shlHausRechnen, SWT.NONE);
		lb4.setText("Werkzeug:");
		lb4.setBounds(29, 162, 55, 15);
		
		txt4 = new Text(shlHausRechnen, SWT.BORDER);
		txt4.setEditable(false);
		txt4.setBounds(107, 162, 91, 21);
		
		Label lb5 = new Label(shlHausRechnen, SWT.NONE);
		lb5.setText("Diamanten:");
		lb5.setBounds(29, 192, 66, 15);
		
		txt5 = new Text(shlHausRechnen, SWT.BORDER);
		txt5.setEditable(false);
		txt5.setBounds(107, 192, 91, 21);
		
		Label lb6 = new Label(shlHausRechnen, SWT.NONE);
		lb6.setText("L\u00E4nge/Breite:");
		lb6.setBounds(29, 222, 79, 15);
		
		txt6 = new Text(shlHausRechnen, SWT.BORDER);
		txt6.setEditable(false);
		txt6.setBounds(107, 222, 91, 21);
		
		Label lb7 = new Label(shlHausRechnen, SWT.NONE);
		lb7.setText("Bauzeit:");
		lb7.setBounds(29, 252, 66, 15);
		
		txt7 = new Text(shlHausRechnen, SWT.BORDER);
		txt7.setEditable(false);
		txt7.setBounds(107, 252, 91, 21);
		
		Label lb8 = new Label(shlHausRechnen, SWT.NONE);
		lb8.setText("Bewohner:");
		lb8.setBounds(29, 282, 66, 15);
		
		txt8 = new Text(shlHausRechnen, SWT.BORDER);
		txt8.setEditable(false);
		txt8.setBounds(107, 282, 91, 21);
		
		Label lb9 = new Label(shlHausRechnen, SWT.NONE);
		lb9.setText("Einnahmen:");
		lb9.setBounds(29, 312, 66, 15);
		
		txt9 = new Text(shlHausRechnen, SWT.BORDER);
		txt9.setEditable(false);
		txt9.setBounds(107, 312, 91, 21);
		
		Label lb10 = new Label(shlHausRechnen, SWT.NONE);
		lb10.setText("Zeitraum:");
		lb10.setBounds(29, 342, 66, 15);
		
		txt10 = new Text(shlHausRechnen, SWT.BORDER);
		txt10.setEditable(false);
		txt10.setBounds(107, 342, 91, 21);
		
		Label lbUeber1 = new Label(shlHausRechnen, SWT.NONE);
		lbUeber1.setBounds(29, 26, 55, 15);
		lbUeber1.setText("Objekt:");
		
		Label lbUeber2 = new Label(shlHausRechnen, SWT.NONE);
		lbUeber2.setBounds(238, 26, 131, 15);
		lbUeber2.setText("Baukosten berechnen");
		
		Label lblAnzahl = new Label(shlHausRechnen, SWT.NONE);
		lblAnzahl.setBounds(238, 72, 48, 15);
		lblAnzahl.setText("Anzahl:");
		
		
		
		txtMuenzen = new Text(shlHausRechnen, SWT.BORDER);
		txtMuenzen.setEditable(false);
		txtMuenzen.setBounds(292, 129, 91, 21);
		
		txtWerkzeug = new Text(shlHausRechnen, SWT.BORDER);
		txtWerkzeug.setEditable(false);
		txtWerkzeug.setBounds(292, 159, 91, 21);
		
		txtDiamanten = new Text(shlHausRechnen, SWT.BORDER);
		txtDiamanten.setEditable(false);
		txtDiamanten.setBounds(292, 189, 91, 21);
		
		txtBewohner = new Text(shlHausRechnen, SWT.BORDER);
		txtBewohner.setEditable(false);
		txtBewohner.setBounds(292, 276, 91, 21);
		
		txtEinnahmen = new Text(shlHausRechnen, SWT.BORDER);
		txtEinnahmen.setEditable(false);
		txtEinnahmen.setBounds(292, 309, 91, 21);
		
		txtAnzahl = new Text(shlHausRechnen, SWT.BORDER);
		txtAnzahl.setEditable(false);
		txtAnzahl.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (cbAus.getSelectionIndex() > -1) {
					try {
						int anzahl = new Integer(txtAnzahl.getText()).intValue();
						//die eingegebene Anzahl muss SCALEMIN <= Eingabe <= SCALEMAX sein
						//ist die eingegeben Anzahl kleiner, wird sie auf SCALEMIN gesetzt
						if (anzahl < SCALEMIN) {
							anzahl = SCALEMIN;
							txtAnzahl.setText(""+anzahl);
						}
						//ist die eingegebene Anzahl gr��er, wird sie auf SCALEMAX gesetzt
						if (anzahl > SCALEMAX) {
							anzahl = SCALEMAX;
							txtAnzahl.setText(""+anzahl);
						}
						//eingegebne Anzahl auf die Scala �bertragen
						scaleAnzahl.setSelection(anzahl);
						int wert;
						//M�nzkosten berechnen
						wert = new Integer(txt3.getText()).intValue();
						txtMuenzen.setText(""+anzahl*wert);
						//Werkzeugkosten berechnen
						wert = new Integer(txt4.getText()).intValue();
						txtWerkzeug.setText(""+anzahl*wert);
						//Diamantenkosten berechnen
						wert = new Integer(txt5.getText()).intValue();
						txtDiamanten.setText(""+anzahl*wert);
						//Personenzuwachs berechnen
						wert = new Integer(txt8.getText()).intValue();
						txtBewohner.setText(""+anzahl*wert);
						//Einnahmezuwachs berechnen
						wert = new Integer(txt9.getText()).intValue();
						txtEinnahmen.setText(""+anzahl*wert);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						txtMuenzen.setText("NaN");
					}
				}
				
			}
		});
		txtAnzahl.setText("1");
		txtAnzahl.setBounds(292, 69, 26, 21);
		
		
		
		Shell shell = new Shell(shlHausRechnen, SWT.DIALOG_TRIM | SWT.MIN);
		shell.setText("Berechnungen f\u00FCr Wohnh\u00E4user");
		shell.setBounds(92, -248, 665, 545);
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(107, 26, 91, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("Beenden");
		button.setBounds(560, 461, 75, 25);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Name:");
		label.setBounds(29, 72, 55, 15);
		
		text = new Text(shell, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(107, 72, 91, 21);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Zeitalter:");
		label_1.setBounds(29, 102, 55, 15);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setEditable(false);
		text_1.setBounds(107, 102, 91, 21);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("M\u00FCnzen:");
		label_2.setBounds(29, 132, 55, 15);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setEditable(false);
		text_2.setBounds(107, 132, 91, 21);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("Werkzeug:");
		label_3.setBounds(29, 162, 55, 15);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setEditable(false);
		text_3.setBounds(107, 162, 91, 21);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("Diamanten:");
		label_4.setBounds(29, 192, 66, 15);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setEditable(false);
		text_4.setBounds(107, 192, 91, 21);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("L\u00E4nge/Breite:");
		label_5.setBounds(29, 222, 79, 15);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setEditable(false);
		text_5.setBounds(107, 222, 91, 21);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setText("Bauzeit:");
		label_6.setBounds(29, 252, 66, 15);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setEditable(false);
		text_6.setBounds(107, 252, 91, 21);
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setText("Bewohner:");
		label_7.setBounds(29, 282, 66, 15);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setEditable(false);
		text_7.setBounds(107, 282, 91, 21);
		
		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setText("Einnahmen:");
		label_8.setBounds(29, 312, 66, 15);
		
		text_8 = new Text(shell, SWT.BORDER);
		text_8.setEditable(false);
		text_8.setBounds(107, 312, 91, 21);
		
		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setText("Zeitraum:");
		label_9.setBounds(29, 342, 66, 15);
		
		text_9 = new Text(shell, SWT.BORDER);
		text_9.setEditable(false);
		text_9.setBounds(107, 342, 91, 21);
		
		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setText("Objekt:");
		label_10.setBounds(29, 26, 55, 15);
		
		Label label_11 = new Label(shell, SWT.NONE);
		label_11.setText("Baukosten berechnen");
		label_11.setBounds(238, 26, 131, 15);
		
		Label label_12 = new Label(shell, SWT.NONE);
		label_12.setText("Anzahl:");
		label_12.setBounds(238, 72, 48, 15);
		
		text_10 = new Text(shell, SWT.BORDER);
		text_10.setText("1");
		text_10.setBounds(292, 69, 26, 21);
		
		text_11 = new Text(shell, SWT.BORDER);
		text_11.setEditable(false);
		text_11.setBounds(292, 129, 91, 21);
		
		text_12 = new Text(shell, SWT.BORDER);
		text_12.setEditable(false);
		text_12.setBounds(292, 159, 91, 21);
		
		text_13 = new Text(shell, SWT.BORDER);
		text_13.setEditable(false);
		text_13.setBounds(292, 189, 91, 21);
		
		text_14 = new Text(shell, SWT.BORDER);
		text_14.setEditable(false);
		text_14.setBounds(292, 276, 91, 21);
		
		text_15 = new Text(shell, SWT.BORDER);
		text_15.setEditable(false);
		text_15.setBounds(292, 309, 91, 21);
		
		Label lbUeber3 = new Label(shlHausRechnen, SWT.NONE);
		lbUeber3.setText("weitere Auswirkungen");
		lbUeber3.setBounds(238, 241, 131, 15);
		
		scaleAnzahl = new Scale(shlHausRechnen, SWT.NONE);
		scaleAnzahl.setEnabled(false);
		scaleAnzahl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtAnzahl.setText(""+scaleAnzahl.getSelection());
			}
		});
		
		scaleAnzahl.setMaximum(SCALEMAX);
		scaleAnzahl.setMinimum(SCALEMIN);
		scaleAnzahl.setBounds(419, 72, 170, 42);
		
		Label lbPersonenanzahl = new Label(shlHausRechnen, SWT.NONE);
		lbPersonenanzahl.setBounds(29, 427, 147, 15);
		lbPersonenanzahl.setText("ben\u00F6tigte Personenanzahl:");
		
		txtPAnzahl = new Text(shlHausRechnen, SWT.BORDER);
		txtPAnzahl.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (cbAus.getSelectionIndex() > -1) {
					try {
						int zahl = new Integer(txtPAnzahl.getText()).intValue();
						Wohngebaeude_api wog = Toolbox.WogAuswahl(cbAus.getSelectionIndex());
						double dif = zahl / wog.getBewohner().doubleValue();
						if (dif % 1 > 0) {
							dif = dif + 1;
						}
						System.out.println("dif: " + dif);
						int anzahlHaus = new Double(dif).intValue();
						System.out.println("anzahlHaus:" + anzahlHaus);
						lbHaeuser.setText("ben\u00F6tigte H\u00E4user: " + anzahlHaus);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
				}
			}
		});
		txtPAnzahl.setEnabled(true);
		txtPAnzahl.setEditable(false);
		txtPAnzahl.setText("");
		txtPAnzahl.setBounds(182, 427, 79, 21);
		
		lbHaeuser = new Label(shlHausRechnen, SWT.NONE);
		lbHaeuser.setText("x");
		lbHaeuser.setBounds(292, 427, 131, 15);
		

	}
}
