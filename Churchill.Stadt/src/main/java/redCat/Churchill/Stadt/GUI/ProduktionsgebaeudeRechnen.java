package redCat.Churchill.Stadt.GUI;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

import redCat.Churchill.Stadt.Bauwerke.impl.Produktionsgebaeude;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Enumeration.Produktions_enum;
import redCat.Churchill.Stadt.Tools.SWTResourceManager;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class ProduktionsgebaeudeRechnen extends Dialog {

	protected Object result;
	protected Shell shlProdRechnen;
	private Text txtFaktor;
	private Text txto1;
	private Text txto2;
	private Text txto3;
	private Text txto4;
	private Text txto5;
	private Text txto6;
	private Text txtm1;
	private Text txtm2;
	private Text txtm3;
	private Text txtm4;
	private Text txtm5;
	private Text txtm6;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ProduktionsgebaeudeRechnen(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlProdRechnen.open();
		shlProdRechnen.layout();
		Display display = getParent().getDisplay();
		while (!shlProdRechnen.isDisposed()) {
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
		shlProdRechnen = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN);
		shlProdRechnen.setSize(668, 506);
		shlProdRechnen.setText("Berechnungen für Produktionsgebäude");
		
		Button btnBeenden = new Button(shlProdRechnen, SWT.NONE);
		btnBeenden.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlProdRechnen.close();
			}
		});
		btnBeenden.setText("Beenden");
		btnBeenden.setBounds(577, 442, 75, 25);
		
		final Combo cbProdGeb = new Combo(shlProdRechnen, SWT.NONE);
		cbProdGeb.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cbProdGeb.getSelectionIndex() > -1) {
					Produktionsgebaeude prod = Toolbox.ProdAuswahl(cbProdGeb.getSelectionIndex());
					txto1.setText(prod.getIn_5_Minuten().toString());
					txto2.setText(prod.getIn_15_Minuten().toString());
					txto3.setText(prod.getIn_1_Stunde().toString());
					txto4.setText(prod.getIn_4_Stunden().toString());
					txto5.setText(prod.getIn_8_Stunden().toString());
					txto6.setText(prod.getIn_1_Tag().toString());
					txtFaktor.setEditable(true);
				}
			}
		});
		
		cbProdGeb.setForeground(SWTResourceManager.getColor(255, 0, 0));
		cbProdGeb.setBounds(252, 10, 91, 23);
		
		for (Produktions_enum prod_staette : Produktions_enum.values()) {
			cbProdGeb.add(prod_staette.toString());
		} 
		
		Label lbProduktionen = new Label(shlProdRechnen, SWT.NONE);
		lbProduktionen.setAlignment(SWT.CENTER);
		lbProduktionen.setBounds(32, 52, 194, 15);
		lbProduktionen.setText("orginäre Produktionen");
		
		Label lbProduktionen2 = new Label(shlProdRechnen, SWT.NONE);
		lbProduktionen2.setText("modifizierte Produktionen");
		lbProduktionen2.setAlignment(SWT.CENTER);
		lbProduktionen2.setBounds(279, 52, 194, 15);
		
		txtFaktor = new Text(shlProdRechnen, SWT.BORDER);
		txtFaktor.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (cbProdGeb.getSelectionIndex() > -1) {
					Produktionsgebaeude prod = Toolbox.ProdAuswahl(cbProdGeb.getSelectionIndex());
					try {
						txtm1.setText(prod.berechneProduktion(prod.getIn_5_Minuten(), new Integer(txtFaktor.getText())).toString());
						txtm2.setText(prod.berechneProduktion(prod.getIn_15_Minuten(), new Integer(txtFaktor.getText())).toString());
						txtm3.setText(prod.berechneProduktion(prod.getIn_1_Stunde(), new Integer(txtFaktor.getText())).toString());
						txtm4.setText(prod.berechneProduktion(prod.getIn_4_Stunden(), new Integer(txtFaktor.getText())).toString());
						txtm5.setText(prod.berechneProduktion(prod.getIn_8_Stunden(), new Integer(txtFaktor.getText())).toString());
						txtm6.setText(prod.berechneProduktion(prod.getIn_1_Tag(), new Integer(txtFaktor.getText())).toString());
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
				}
			}
		});
		txtFaktor.setEditable(false);
		txtFaktor.setBounds(479, 46, 76, 21);
		
		Label lbo1 = new Label(shlProdRechnen, SWT.NONE);
		lbo1.setText("in 5 Minuten:");
		lbo1.setBounds(32, 90, 75, 15);
		
		Label lbo2 = new Label(shlProdRechnen, SWT.NONE);
		lbo2.setText("in 15 Minuten:");
		lbo2.setBounds(32, 120, 75, 15);
		
		Label lbo3 = new Label(shlProdRechnen, SWT.NONE);
		lbo3.setText("in 1 Stunde:");
		lbo3.setBounds(32, 150, 75, 15);
		
		Label lbo4 = new Label(shlProdRechnen, SWT.NONE);
		lbo4.setText("in 4 Stunden:");
		lbo4.setBounds(32, 180, 79, 15);
		
		Label lbo5 = new Label(shlProdRechnen, SWT.NONE);
		lbo5.setText("in 8 Stunden:");
		lbo5.setBounds(32, 210, 75, 15);
		
		Label lbo6 = new Label(shlProdRechnen, SWT.NONE);
		lbo6.setText("in 1 Tag:");
		lbo6.setBounds(32, 240, 75, 15);
		
		txto1 = new Text(shlProdRechnen, SWT.BORDER);
		txto1.setEditable(false);
		txto1.setBounds(112, 90, 130, 21);
		
		txto2 = new Text(shlProdRechnen, SWT.BORDER);
		txto2.setEditable(false);
		txto2.setBounds(112, 120, 130, 21);
		
		txto3 = new Text(shlProdRechnen, SWT.BORDER);
		txto3.setEditable(false);
		txto3.setBounds(112, 150, 130, 21);
		
		txto4 = new Text(shlProdRechnen, SWT.BORDER);
		txto4.setEditable(false);
		txto4.setBounds(112, 180, 130, 21);
		
		txto5 = new Text(shlProdRechnen, SWT.BORDER);
		txto5.setEditable(false);
		txto5.setBounds(112, 210, 130, 21);
		
		txto6 = new Text(shlProdRechnen, SWT.BORDER);
		txto6.setEditable(false);
		txto6.setBounds(112, 240, 130, 21);
		
		Label lbm1 = new Label(shlProdRechnen, SWT.NONE);
		lbm1.setText("in 5 Minuten:");
		lbm1.setBounds(304, 84, 75, 15);
		
		Label lbm2 = new Label(shlProdRechnen, SWT.NONE);
		lbm2.setText("in 15 Minuten:");
		lbm2.setBounds(304, 114, 75, 15);
		
		Label lbm3 = new Label(shlProdRechnen, SWT.NONE);
		lbm3.setText("in 1 Stunde:");
		lbm3.setBounds(304, 144, 75, 15);
		
		Label lbm4 = new Label(shlProdRechnen, SWT.NONE);
		lbm4.setText("in 4 Stunden:");
		lbm4.setBounds(304, 174, 79, 15);
		
		Label lbm5 = new Label(shlProdRechnen, SWT.NONE);
		lbm5.setText("in 8 Stunden:");
		lbm5.setBounds(304, 204, 75, 15);
		
		Label lbm6 = new Label(shlProdRechnen, SWT.NONE);
		lbm6.setText("in 1 Tag:");
		lbm6.setBounds(304, 234, 75, 15);
		
		txtm1 = new Text(shlProdRechnen, SWT.BORDER);
		txtm1.setEditable(false);
		txtm1.setBounds(384, 84, 130, 21);
		
		txtm2 = new Text(shlProdRechnen, SWT.BORDER);
		txtm2.setEditable(false);
		txtm2.setBounds(384, 114, 130, 21);
		
		txtm3 = new Text(shlProdRechnen, SWT.BORDER);
		txtm3.setEditable(false);
		txtm3.setBounds(384, 144, 130, 21);
		
		txtm4 = new Text(shlProdRechnen, SWT.BORDER);
		txtm4.setEditable(false);
		txtm4.setBounds(384, 174, 130, 21);
		
		txtm5 = new Text(shlProdRechnen, SWT.BORDER);
		txtm5.setEditable(false);
		txtm5.setBounds(384, 204, 130, 21);
		
		txtm6 = new Text(shlProdRechnen, SWT.BORDER);
		txtm6.setEditable(false);
		txtm6.setBounds(384, 234, 130, 21);

	}
}
