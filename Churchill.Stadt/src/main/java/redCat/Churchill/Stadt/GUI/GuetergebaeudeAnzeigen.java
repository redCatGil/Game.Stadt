package redCat.Churchill.Stadt.GUI;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;


import redCat.Churchill.Stadt.Bauwerke.impl.Guetergebaeude;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Enumeration.Gueter_enum;
import redCat.Churchill.Stadt.Tools.SWTResourceManager;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class GuetergebaeudeAnzeigen extends Dialog {

	protected Object result;
	protected Shell shlAnzeigeVonGtergebuden;
	private Text txt_Name;
	private Text txt_Zeitalter;
	private Text txt_Muenzen;
	private Text txt_Werkzeug;
	private Text txt_Laenge;
	private Text txt_Bauzeit;
	private Text txt_Personen;
	private Text txt_4hName;
	private Text txt_8hName;
	private Text txt_1tName;
	private Text txt_2tName;
	private Text txt_4hErtrag;
	private Text txt_8hErtrag;
	private Text txt_1tErtrag;
	private Text txt_2tErtrag;
	private Label lb_txt1;
	private Label lb_muenzen;
	private Label lb_Werkzeug;
	private Text txt_4hMuenzen;
	private Text txt_4hWZ;
	private Text txt_8hMuenzen;
	private Text txt_8hWZ;
	private Text txt_1tMuenzen;
	private Text txt_1tWZ;
	private Text txt_2tMuenzen;
	private Text txt_2tWZ;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public GuetergebaeudeAnzeigen(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlAnzeigeVonGtergebuden.open();
		shlAnzeigeVonGtergebuden.layout();
		Display display = getParent().getDisplay();
		while (!shlAnzeigeVonGtergebuden.isDisposed()) {
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
		shlAnzeigeVonGtergebuden = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX);
		shlAnzeigeVonGtergebuden.setSize(899, 564);
		shlAnzeigeVonGtergebuden.setText("Anzeige von Gütergebäuden");
		
		final Combo cbGueter1 = new Combo(shlAnzeigeVonGtergebuden, SWT.NONE);
		cbGueter1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cbGueter1.getSelectionIndex() > -1 ) {
					System.out.println("Index: " + cbGueter1.getSelectionIndex());
					Guetergebaeude gut = Toolbox.GueterAuswahl(cbGueter1.getSelectionIndex());
					System.out.println("Name:" + gut.getName());
					txt_Name.setText(gut.getName());
					txt_Zeitalter.setText(gut.getZeitalter());
					txt_Muenzen.setText(gut.getMuenzen().toString());
					txt_Werkzeug.setText(gut.getWerkzeug().toString());
					txt_Laenge.setText(gut.getLaenge().toString() + "x" + gut.getBreite().intValue() );
					txt_Bauzeit.setText(Toolbox.TimeToString(gut.getBauzeit()));
					txt_Personen.setText(gut.getPersonen().toString());
					txt_4hName.setText(gut.getIn4StundenName());
					txt_8hName.setText(gut.getIn8StundenName());
					txt_1tName.setText(gut.getIn1TagName());
					txt_2tName.setText(gut.getIn2TagenName());
					txt_4hErtrag.setText(gut.getIn4StundenMenge().toString() + " " + gut.getProdukt());
					txt_8hErtrag.setText(gut.getIn8StundenMenge().toString() + " " + gut.getProdukt());
					txt_1tErtrag.setText(gut.getIn1TagMenge().toString() + " " + gut.getProdukt());
					txt_2tErtrag.setText(gut.getIn2TagenMenge().toString() + " " + gut.getProdukt());
					txt_4hMuenzen.setText(gut.getIn4StundenMuenzen().toString());
					txt_8hMuenzen.setText(gut.getIn8StundenMuenzen().toString());
					txt_1tMuenzen.setText(gut.getIn1TagMuenzen().toString());
					txt_2tMuenzen.setText(gut.getIn2TagenMuenzen().toString());
					txt_4hWZ.setText(gut.getIn4StundenWZ().toString());
					txt_8hWZ.setText(gut.getIn8StundenWZ().toString());
					txt_1tWZ.setText(gut.getIn1TagWZ().toString());
					txt_2tWZ.setText(gut.getIn2TagenWZ().toString());
				}
			}
		});
		cbGueter1.setForeground(SWTResourceManager.getColor(255, 0, 0));
		cbGueter1.setBounds(111, 26, 91, 23);
		
		Button button = new Button(shlAnzeigeVonGtergebuden, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAnzeigeVonGtergebuden.close();
			}
		});
		button.setToolTipText("hiermit wird das Fenster geschlossen");
		button.setText("Beenden");
		button.setBounds(382, 500, 75, 25);
		
		Label label = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		label.setText("Name:");
		label.setBounds(31, 59, 55, 18);
		
		txt_Name = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_Name.setEditable(false);
		txt_Name.setBounds(112, 56, 91, 21);
		
		Label label_1 = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		label_1.setText("Zeitalter:");
		label_1.setBounds(31, 89, 55, 15);
		
		txt_Zeitalter = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_Zeitalter.setEditable(false);
		txt_Zeitalter.setBounds(112, 86, 91, 21);
		
		Label label_2 = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		label_2.setText("Münzen:");
		label_2.setBounds(31, 119, 55, 15);
		
		txt_Muenzen = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_Muenzen.setEditable(false);
		txt_Muenzen.setBounds(112, 116, 91, 21);
		
		Label label_3 = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		label_3.setText("Werkzeug:");
		label_3.setBounds(31, 149, 55, 15);
		
		txt_Werkzeug = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_Werkzeug.setEditable(false);
		txt_Werkzeug.setBounds(112, 146, 91, 21);
		
		Label label_4 = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		label_4.setText("Länge/Breite:");
		label_4.setBounds(31, 186, 74, 15);
		
		txt_Laenge = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_Laenge.setEditable(false);
		txt_Laenge.setBounds(111, 183, 91, 21);
		
		Label label_5 = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		label_5.setText("Bauzeit:");
		label_5.setBounds(31, 220, 55, 15);
		
		txt_Bauzeit = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_Bauzeit.setEditable(false);
		txt_Bauzeit.setBounds(111, 217, 91, 21);
		
		Label label_6 = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		label_6.setText("Personen:");
		label_6.setBounds(31, 257, 55, 15);
		
		txt_Personen = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_Personen.setEditable(false);
		txt_Personen.setBounds(111, 254, 91, 21);
		
		Label lblStunden = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		lblStunden.setText("4 Stunden");
		lblStunden.setBounds(147, 317, 55, 18);
		
		Label lblStunden_1 = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		lblStunden_1.setText("8 Stunden");
		lblStunden_1.setBounds(319, 317, 55, 18);
		
		Label lblTag = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		lblTag.setText("1 Tag");
		lblTag.setBounds(507, 317, 55, 18);
		
		Label lblTage = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		lblTage.setText("2 Tage");
		lblTage.setBounds(687, 317, 55, 18);
		
		Label lb_Name2 = new Label(shlAnzeigeVonGtergebuden, SWT.NONE);
		lb_Name2.setText("Produktionsname");
		lb_Name2.setBounds(10, 344, 95, 18);
		
		txt_4hName = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_4hName.setEditable(false);
		txt_4hName.setBounds(111, 341, 145, 21);
		
		txt_8hName = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_8hName.setEditable(false);
		txt_8hName.setBounds(279, 341, 145, 21);
		
		txt_1tName = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_1tName.setEditable(false);
		txt_1tName.setBounds(455, 341, 145, 21);
		
		txt_2tName = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_2tName.setEditable(false);
		txt_2tName.setBounds(635, 341, 145, 21);
		
		Label lb_Ertrag = new Label(shlAnzeigeVonGtergebuden, SWT.RIGHT);
		lb_Ertrag.setText("Ertrag");
		lb_Ertrag.setBounds(10, 376, 95, 18);
		
		txt_4hErtrag = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_4hErtrag.setEditable(false);
		txt_4hErtrag.setBounds(111, 373, 145, 21);
		
		txt_8hErtrag = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_8hErtrag.setEditable(false);
		txt_8hErtrag.setBounds(279, 376, 145, 21);
		
		txt_1tErtrag = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_1tErtrag.setEditable(false);
		txt_1tErtrag.setBounds(455, 373, 145, 21);
		
		txt_2tErtrag = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_2tErtrag.setEditable(false);
		txt_2tErtrag.setBounds(635, 373, 145, 21);
		
		lb_txt1 = new Label(shlAnzeigeVonGtergebuden, SWT.RIGHT);
		lb_txt1.setText("Kosten");
		lb_txt1.setBounds(10, 411, 95, 18);
		
		lb_muenzen = new Label(shlAnzeigeVonGtergebuden, SWT.RIGHT);
		lb_muenzen.setText("Münzen");
		lb_muenzen.setBounds(10, 427, 95, 18);
		
		lb_Werkzeug = new Label(shlAnzeigeVonGtergebuden, SWT.RIGHT);
		lb_Werkzeug.setText("Werkzeug");
		lb_Werkzeug.setBounds(10, 454, 95, 18);
		
		txt_4hMuenzen = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_4hMuenzen.setEditable(false);
		txt_4hMuenzen.setBounds(111, 424, 145, 21);
		
		txt_4hWZ = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_4hWZ.setEditable(false);
		txt_4hWZ.setBounds(111, 454, 145, 21);
		
		txt_8hMuenzen = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_8hMuenzen.setEditable(false);
		txt_8hMuenzen.setBounds(279, 424, 145, 21);
		
		txt_8hWZ = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_8hWZ.setEditable(false);
		txt_8hWZ.setBounds(279, 454, 145, 21);
		
		txt_1tMuenzen = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_1tMuenzen.setEditable(false);
		txt_1tMuenzen.setBounds(455, 424, 145, 21);
		
		txt_1tWZ = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_1tWZ.setEditable(false);
		txt_1tWZ.setBounds(455, 454, 145, 21);
		
		txt_2tMuenzen = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_2tMuenzen.setEditable(false);
		txt_2tMuenzen.setBounds(635, 427, 145, 21);
		
		txt_2tWZ = new Text(shlAnzeigeVonGtergebuden, SWT.BORDER);
		txt_2tWZ.setEditable(false);
		txt_2tWZ.setBounds(635, 454, 145, 21);
		
		for (Gueter_enum gueter : Gueter_enum.values()) {
			cbGueter1.add(gueter.toString());
			
		} 

	}
}
