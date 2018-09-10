package redCat.Churchill.Stadt.GUI;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import redCat.Churchill.Stadt.Bauwerke.impl.Produktionsgebaeude;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Enumeration.Produktions_enum;
import redCat.Churchill.Stadt.Tools.SWT_Tools;


public class ProduktionsgebaeudeAnzeige extends Dialog {

	protected Object result;
	protected Shell shlProduktionsgebaeudeAnzeige;
	private Text txtName1;
	private Text txtZA1;
	private Text txtMuenzen1;
	private Text txtWerkzeug1;
	private Text txtDias1;
	private Text txtLen1;
	private Text txtBauzeit1;
	private Text txtPersonen1;
	private Text txt5m;
	private Text txt15m;
	private Text txt1h;
	private Text txt4h;
	private Text txt8h;
	private Text txt1t;
	private Text txtPunkte;
	private Text txtQuotient;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ProduktionsgebaeudeAnzeige(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlProduktionsgebaeudeAnzeige.open();
		shlProduktionsgebaeudeAnzeige.layout();
		Display display = getParent().getDisplay();
		while (!shlProduktionsgebaeudeAnzeige.isDisposed()) {
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
		shlProduktionsgebaeudeAnzeige = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN);
		shlProduktionsgebaeudeAnzeige.setModified(true);
		shlProduktionsgebaeudeAnzeige.setSize(611, 685);
		shlProduktionsgebaeudeAnzeige.setText("Anzeige von Produktionsgeb\u00E4uden");
		
		//Comboboxen definieren und mit enum-Werten füllen
		final Combo cbProduktion1 = new Combo(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		
		for (Produktions_enum prod_staette : Produktions_enum.values()) {
			cbProduktion1.add(prod_staette.toString());
		} 
		
		//Beendenbutton definieren und mit Close Fenster schlie�en
		Button btnBeenden = new Button(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		btnBeenden.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlProduktionsgebaeudeAnzeige.close();
			}
		});
		btnBeenden.setToolTipText("hiermit wird das Fenster geschlossen");
		btnBeenden.setText("Beenden");
		btnBeenden.setBounds(520, 621, 75, 25);
		
		//Combobox-Listener1
		cbProduktion1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Auswahl: " + cbProduktion1.getSelectionIndex());
				if (cbProduktion1.getSelectionIndex() > -1) {
					Produktionsgebaeude prod = Toolbox.ProdAuswahl(cbProduktion1.getSelectionIndex());
					double gf = 1.0;
					txtName1.setText(prod.getName());
					txtZA1.setText(prod.getZeitalter());
					txtMuenzen1.setText(prod.getMuenzen().toString());
					txtWerkzeug1.setText(prod.getWerkzeug().toString());
					txtDias1.setText(prod.getDiamanten().toString());
					txtLen1.setText(prod.getLaenge().toString() + "x" + prod.getBreite());
					txtBauzeit1.setText(Toolbox.TimeToString(prod.getBauzeit()));
					txtPersonen1.setText(prod.getPersonen().toString());
					txt5m.setText(prod.getIn_5_Minuten() + " - " + prod.getName_5_min());
					txt15m.setText(prod.getIn_15_Minuten().toString() + " - " + prod.getName_15_min());
					txt1h.setText(prod.getIn_1_Stunde().toString() + " - " + prod.getName_1_h());
					txt4h.setText(prod.getIn_4_Stunden().toString() + " - " + prod.getName_4_h());
					txt8h.setText(prod.getIn_8_Stunden().toString() + " - " + prod.getName_8_h());
					txt1t.setText(prod.getIn_1_Tag().toString() + " - " + prod.getName_1_t());
					if (prod.getGebaeude_art().equalsIgnoreCase("diamant")) {
						gf = 2.0;
					}
					txtPunkte.setText("" + prod.berechnePunkte(gf));
					txtQuotient.setText(prod.berechneWZQuotient().toString());
				}
			}
		});
		cbProduktion1.setForeground(SWT_Tools.getColor(SWT.COLOR_RED));
		cbProduktion1.setBounds(90, 22, 91, 23);
		
		Label lb1 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb1.setText("Name:");
		lb1.setBounds(10, 74, 55, 15);
		
		Label lb2 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb2.setText("Zeitalter:");
		lb2.setBounds(10, 104, 55, 15);
		
		Label lb3 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb3.setText("M\u00FCnzen:");
		lb3.setBounds(10, 134, 55, 15);
		
		Label lb4 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb4.setText("Werkzeug:");
		lb4.setBounds(10, 164, 55, 15);
		
		Label lb5 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb5.setText("Diamanten:");
		lb5.setBounds(10, 194, 66, 15);
		
		Label lb6 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb6.setText("L\u00E4nge/Breite:");
		lb6.setBounds(10, 224, 79, 15);
		
		Label lb7 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb7.setText("Bauzeit:");
		lb7.setBounds(10, 254, 66, 15);
		
		Label lb8 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb8.setText("Personen:");
		lb8.setBounds(10, 284, 66, 15);
		
		Label lblProduktionszeiten = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lblProduktionszeiten.setAlignment(SWT.CENTER);
		lblProduktionszeiten.setText("Produktionszeiten");
		lblProduktionszeiten.setBounds(10, 317, 228, 15);
		
		Label lb9 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb9.setText("in 5 Minuten:");
		lb9.setBounds(10, 347, 75, 15);
		
		Label lb10 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb10.setText("in 15 Minuten:");
		lb10.setBounds(10, 377, 75, 15);
		
		Label lb11 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb11.setText("in 1 Stunde:");
		lb11.setBounds(10, 407, 75, 15);
		
		Label lb12 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb12.setText("in 4 Stunden:");
		lb12.setBounds(10, 437, 79, 15);
		
		Label lb13 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb13.setText("in 8 Stunden:");
		lb13.setBounds(10, 467, 75, 15);
		
		Label lb14 = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lb14.setText("in 1 Tag:");
		lb14.setBounds(10, 497, 75, 15);
		
		txtName1 = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtName1.setEditable(false);
		txtName1.setBounds(90, 74, 91, 21);
		
		txtZA1 = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtZA1.setEditable(false);
		txtZA1.setBounds(90, 104, 91, 21);
		
		txtMuenzen1 = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtMuenzen1.setEditable(false);
		txtMuenzen1.setBounds(90, 134, 91, 21);
		
		txtWerkzeug1 = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtWerkzeug1.setEditable(false);
		txtWerkzeug1.setBounds(90, 164, 91, 21);
		
		txtDias1 = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtDias1.setEditable(false);
		txtDias1.setBounds(90, 194, 91, 21);
		
		txtLen1 = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtLen1.setEditable(false);
		txtLen1.setBounds(90, 224, 91, 21);
		
		txtBauzeit1 = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtBauzeit1.setEditable(false);
		txtBauzeit1.setBounds(90, 254, 91, 21);
		
		txtPersonen1 = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtPersonen1.setEditable(false);
		txtPersonen1.setBounds(90, 284, 91, 21);
		
		txt5m = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txt5m.setEditable(false);
		txt5m.setBounds(90, 347, 130, 21);
		
		txt15m = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txt15m.setEditable(false);
		txt15m.setBounds(90, 377, 130, 21);
		
		txt1h = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txt1h.setEditable(false);
		txt1h.setBounds(90, 407, 130, 21);
		
		txt4h = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txt4h.setEditable(false);
		txt4h.setBounds(90, 437, 130, 21);
		
		txt8h = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txt8h.setEditable(false);
		txt8h.setBounds(90, 467, 130, 21);
		
		txt1t = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txt1t.setEditable(false);
		txt1t.setBounds(90, 497, 130, 21);
		
		Label lbStatistik = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lbStatistik.setText("Statistik");
		lbStatistik.setAlignment(SWT.CENTER);
		lbStatistik.setBounds(10, 551, 228, 15);
		
		Label lbPunkte = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lbPunkte.setText("Punkte:");
		lbPunkte.setBounds(10, 581, 75, 15);
		
		txtPunkte = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtPunkte.setEditable(false);
		txtPunkte.setBounds(90, 575, 130, 21);
		
		Label lbQuotien = new Label(shlProduktionsgebaeudeAnzeige, SWT.NONE);
		lbQuotien.setText("WZ-Quotient:");
		lbQuotien.setBounds(10, 614, 75, 15);
		
		txtQuotient = new Text(shlProduktionsgebaeudeAnzeige, SWT.BORDER);
		txtQuotient.setEditable(false);
		txtQuotient.setBounds(90, 608, 130, 21);

	}

}
