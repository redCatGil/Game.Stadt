package redCat.Churchill.Stadt.GUI;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.Wohngebaeude;
import redCat.Churchill.Stadt.Enumeration.Gebaeude_enum;
import redCat.Churchill.Stadt.Tools.SWTResourceManager;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class WohngebaeudeAnzeige extends Dialog {

	protected Object result;
	protected Shell shlHausAnzeige;
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
	private Text txt11;
	private Text txt12;
	private Text txt13;
	private Text txt14;
	private Text txt15;
	private Text txt16;
	private Text txt17;
	private Text txt18;
	private Text txt19;
	private Text txt20;
	private Text txt21;
	private Button btnVergleich;
	private Text txt22;
	private Text txt23;
	private Text txt24;
	private Text txt25;
	private Text txt26;
	private Text txt40;
	private Text txt41;
	private Text txt42;
	


	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public WohngebaeudeAnzeige(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlHausAnzeige.open();
		shlHausAnzeige.layout();
		Display display = getParent().getDisplay();
		while (!shlHausAnzeige.isDisposed()) {
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
		shlHausAnzeige = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN);
		shlHausAnzeige.setModified(true);
		shlHausAnzeige.setSize(656, 488);
		shlHausAnzeige.setText("Wohngeb\u00E4udeanzeige");
		
		final Combo CB_Aus1 = new Combo(shlHausAnzeige, SWT.NONE);
		CB_Aus1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		CB_Aus1.setBounds(88, 45, 91, 23);
		
		final Combo CB_Aus2 = new Combo(shlHausAnzeige, SWT.NONE);
		CB_Aus2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		CB_Aus2.setBounds(215, 45, 91, 23);
		
		for (Gebaeude_enum gebx : Gebaeude_enum.values()) {
			CB_Aus1.add(gebx.toString());
			CB_Aus2.add(gebx.toString());
		}
		
		Label hl1 = new Label(shlHausAnzeige, SWT.SEPARATOR | SWT.HORIZONTAL);
		hl1.setBounds(23, 77, 629, 1);
		
		Label lb1 = new Label(shlHausAnzeige, SWT.NONE);
		lb1.setBounds(10, 100, 55, 15);
		lb1.setText("Name:");
		
		Label lb2 = new Label(shlHausAnzeige, SWT.NONE);
		lb2.setText("Zeitalter:");
		lb2.setBounds(10, 130, 55, 15);
		
		Label lb3 = new Label(shlHausAnzeige, SWT.NONE);
		lb3.setText("M\u00FCnzen:");
		lb3.setBounds(10, 160, 55, 15);
		
		Label lb4 = new Label(shlHausAnzeige, SWT.NONE);
		lb4.setText("Werkzeug:");
		lb4.setBounds(10, 190, 55, 15);
		
		Label lb5 = new Label(shlHausAnzeige, SWT.NONE);
		lb5.setText("Diamanten:");
		lb5.setBounds(10, 220, 66, 15);
		
		Label lb6 = new Label(shlHausAnzeige, SWT.NONE);
		lb6.setText("L\u00E4nge/Breite:");
		lb6.setBounds(10, 250, 79, 15);
		
		Label lb10 = new Label(shlHausAnzeige, SWT.NONE);
		lb10.setText("Bauzeit:");
		lb10.setBounds(10, 280, 66, 15);
		
		Label lb7 = new Label(shlHausAnzeige, SWT.NONE);
		lb7.setText("Bewohner:");
		lb7.setBounds(10, 310, 66, 15);
		
		Label lb8 = new Label(shlHausAnzeige, SWT.NONE);
		lb8.setText("Einnahmen:");
		lb8.setBounds(10, 340, 66, 15);
		
		Label lb9 = new Label(shlHausAnzeige, SWT.NONE);
		lb9.setText("Zeitraum:");
		lb9.setBounds(10, 370, 66, 15);
		
		Label lb20 = new Label(shlHausAnzeige, SWT.NONE);
		lb20.setBounds(10, 400, 55, 15);
		lb20.setText("Punkte:");
		

		
		txt1 = new Text(shlHausAnzeige, SWT.BORDER);
		txt1.setEditable(false);
		txt1.setBounds(88, 100, 91, 21);
		
		txt2 = new Text(shlHausAnzeige, SWT.BORDER);
		txt2.setEditable(false);
		txt2.setBounds(88, 130, 91, 21);
		
		txt3 = new Text(shlHausAnzeige, SWT.BORDER);
		txt3.setEditable(false);
		txt3.setBounds(88, 160, 91, 21);
		
		txt4 = new Text(shlHausAnzeige, SWT.BORDER);
		txt4.setEditable(false);
		txt4.setBounds(88, 190, 91, 21);
		
		txt5 = new Text(shlHausAnzeige, SWT.BORDER);
		txt5.setEditable(false);
		txt5.setBounds(88, 220, 91, 21);
		
		txt6 = new Text(shlHausAnzeige, SWT.BORDER);
		txt6.setEditable(false);
		txt6.setBounds(88, 250, 91, 21);
				
		txt7 = new Text(shlHausAnzeige, SWT.BORDER);
		txt7.setEditable(false);
		txt7.setBounds(88, 310, 91, 21);
		
		txt8 = new Text(shlHausAnzeige, SWT.BORDER);
		txt8.setEditable(false);
		txt8.setBounds(88, 340, 91, 21);	
		
		txt9 = new Text(shlHausAnzeige, SWT.BORDER);
		txt9.setEditable(false);
		txt9.setBounds(88, 370, 91, 21);
		
		txt10 = new Text(shlHausAnzeige, SWT.BORDER);
		txt10.setEditable(false);
		txt10.setBounds(88, 280, 91, 21);
		
		txt11 = new Text(shlHausAnzeige, SWT.BORDER);
		txt11.setEditable(false);
		txt11.setBounds(215, 100, 91, 21);
		
		txt12 = new Text(shlHausAnzeige, SWT.BORDER);
		txt12.setEditable(false);
		txt12.setBounds(215, 130, 91, 21);
		
		txt13 = new Text(shlHausAnzeige, SWT.BORDER);
		txt13.setEditable(false);
		txt13.setBounds(215, 160, 91, 21);
		
		txt14 = new Text(shlHausAnzeige, SWT.BORDER);
		txt14.setEditable(false);
		txt14.setBounds(215, 190, 91, 21);
		
		txt15 = new Text(shlHausAnzeige, SWT.BORDER);
		txt15.setEditable(false);
		txt15.setBounds(215, 220, 91, 21);
		
		txt16 = new Text(shlHausAnzeige, SWT.BORDER);
		txt16.setEditable(false);
		txt16.setBounds(215, 250, 91, 21);
		
		txt17 = new Text(shlHausAnzeige, SWT.BORDER);
		txt17.setEditable(false);
		txt17.setBounds(215, 280, 91, 21);
		
		txt18 = new Text(shlHausAnzeige, SWT.BORDER);
		txt18.setEditable(false);
		txt18.setBounds(215, 310, 91, 21);
		
		txt19 = new Text(shlHausAnzeige, SWT.BORDER);
		txt19.setEditable(false);
		txt19.setBounds(215, 340, 91, 21);
		
		txt20 = new Text(shlHausAnzeige, SWT.BORDER);
		txt20.setEditable(false);
		txt20.setBounds(215, 370, 91, 21);
		
		txt21 = new Text(shlHausAnzeige, SWT.BORDER);
		txt21.setEditable(false);
		txt21.setBounds(327, 160, 91, 21);
		
		txt22 = new Text(shlHausAnzeige, SWT.BORDER);
		txt22.setEditable(false);
		txt22.setBounds(327, 190, 91, 21);
		
		txt23 = new Text(shlHausAnzeige, SWT.BORDER);
		txt23.setEditable(false);
		txt23.setBounds(327, 220, 91, 21);
		
		txt24 = new Text(shlHausAnzeige, SWT.BORDER);
		txt24.setEditable(false);
		txt24.setBounds(327, 280, 91, 21);
		
		txt25 = new Text(shlHausAnzeige, SWT.BORDER);
		txt25.setEditable(false);
		txt25.setBounds(327, 310, 91, 21);
		
		txt26 = new Text(shlHausAnzeige, SWT.BORDER);
		txt26.setEditable(false);
		txt26.setBounds(327, 340, 91, 21);
		
		txt40 = new Text(shlHausAnzeige, SWT.BORDER);
		txt40.setEditable(false);
		txt40.setBounds(88, 397, 91, 21);
			
		txt41 = new Text(shlHausAnzeige, SWT.BORDER);
		txt41.setEditable(false);
		txt41.setBounds(215, 397, 91, 21);
		
		txt42 = new Text(shlHausAnzeige, SWT.BORDER);
		txt42.setEditable(false);
		txt42.setBounds(327, 397, 91, 21);
		
		
		btnVergleich = new Button(shlHausAnzeige, SWT.NONE);
		btnVergleich.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Wohngebaeude wog1 = Toolbox.WogAuswahl(CB_Aus1.getSelectionIndex());
				Wohngebaeude wog2 = Toolbox.WogAuswahl(CB_Aus2.getSelectionIndex());
				int diff = 0;
				diff = wog1.getMuenzen().intValue() - wog2.getMuenzen().intValue();
				txt21.setText(""+diff);
				diff = wog1.getWerkzeug().intValue() - wog2.getWerkzeug().intValue();
				txt22.setText(""+diff);
				diff = wog1.getDiamanten().intValue() - wog2.getDiamanten().intValue();
				txt23.setText(""+diff);
				diff = wog1.getBewohner().intValue() - wog2.getBewohner().intValue();
				txt25.setText(""+diff);
				diff = wog1.getMuenz_einnahmen().intValue() - wog2.getMuenz_einnahmen().intValue();
				txt26.setText(""+diff);
				double gf1 = 1.0;
				double gf2 = 1.0;
				if (wog1.getDiamanten().intValue() > 0) {
					gf1 = 2.0;
				}
				if (wog2.getDiamanten().intValue() > 0) {
					gf2 = 2.0;
				}
				double ddif = 0.0;
				ddif = wog1.berechnePunkte(gf1).doubleValue() - wog2.berechnePunkte(gf2).doubleValue();
				txt42.setText(""+ddif);
			}
		});
		btnVergleich.setEnabled(false);
		btnVergleich.setBounds(471, 330, 75, 25);
		btnVergleich.setText("vergleichen");
		
		
		CB_Aus1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Auswahl:" + CB_Aus1.getSelectionIndex());
				if (CB_Aus1.getSelectionIndex() > -1) {
					Wohngebaeude wog = Toolbox.WogAuswahl(CB_Aus1.getSelectionIndex());
										txt1.setText(wog.getName());
					txt2.setText(wog.getZeitalter());
					txt3.setText(wog.getMuenzen().toString());
					txt4.setText(wog.getWerkzeug().toString());
					txt5.setText(wog.getDiamanten().toString());
					txt6.setText(wog.getLaenge().toString() + " / " + wog.getBreite().toString());
					txt7.setText(wog.getBewohner().toString());
					txt8.setText(wog.getMuenz_einnahmen().toString());
					txt9.setText("alle ");
//					System.out.println(wog.toString());
					txt9.setText(txt9.getText() + Toolbox.intToTime(wog.getEinnahme_dauer().intValue()));
					txt10.setText(Toolbox.TimeToString(wog.getBauzeit()));	
					double gf = 1.0;
					if (wog.getDiamanten().intValue() > 0) {
						gf = 2.0;
					}
					txt40.setText(wog.berechnePunkte(gf).toString());
				} else {
					txt1.setText("keine Auswahl getroffen!");
				}
				
				if (CB_Aus1.getSelectionIndex() > -1 && CB_Aus2.getSelectionIndex() > -1) {
					btnVergleich.setEnabled(true);
				} else {
					btnVergleich.setEnabled(false);
				}
				
			}
				
		});
	
		CB_Aus2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Auswahl:" + CB_Aus2.getSelectionIndex());
				if (CB_Aus2.getSelectionIndex() > -1) {
					Wohngebaeude wog = Toolbox.WogAuswahl(CB_Aus2.getSelectionIndex());
					txt11.setText(wog.getName());
					txt12.setText(wog.getZeitalter());
					txt13.setText(wog.getMuenzen().toString());
					txt14.setText(wog.getWerkzeug().toString());
					txt15.setText(wog.getDiamanten().toString());
					txt16.setText(wog.getLaenge().toString() + " / " + wog.getBreite().toString());
					txt17.setText(Toolbox.TimeToString(wog.getBauzeit()));
					txt18.setText(wog.getBewohner().toString());
					txt19.setText(wog.getMuenz_einnahmen().toString());
					txt20.setText("alle ");
					txt20.setText(txt20.getText() + Toolbox.intToTime(wog.getEinnahme_dauer().intValue()));
					double gf = 1;
					if (wog.getDiamanten().intValue() > 0) {
						gf = 2;
					}
					txt41.setText(wog.berechnePunkte(gf).toString());
				} else {
					txt11.setText("keine Auswahl getroffen!");
				}
				
				if (CB_Aus1.getSelectionIndex() > -1 && CB_Aus2.getSelectionIndex() > -1) {
					btnVergleich.setEnabled(true);
				} else {
					btnVergleich.setEnabled(false);
				}
			}
				
			
		}); 

		
		
		Button btnBeenden = new Button(shlHausAnzeige, SWT.NONE);
		btnBeenden.setToolTipText("hiermit wird das Fenster geschlossen");
		btnBeenden.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlHausAnzeige.close();
			}
		});
		btnBeenden.setBounds(471, 365, 75, 25);
		btnBeenden.setText("Beenden");
		
		
		
		
		
		
		

	}
}
