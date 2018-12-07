package redCat.Churchill.Stadt.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.SWT;


import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;

public class BauwerkAnzeige {

	protected Shell shlBauwerksanzeige;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BauwerkAnzeige window = new BauwerkAnzeige();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlBauwerksanzeige.open();
		shlBauwerksanzeige.layout();
		while (!shlBauwerksanzeige.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBauwerksanzeige = new Shell();
		shlBauwerksanzeige.setSize(700, 484);
		shlBauwerksanzeige.setText("Bauwerksanzeige");
		
		Label hl1 = new Label(shlBauwerksanzeige, SWT.SEPARATOR | SWT.HORIZONTAL);
		hl1.setBounds(23, 77, 629, 1);
		
		Menu menu = new Menu(shlBauwerksanzeige, SWT.BAR);
		menu.setLocation(new Point(0, 0));
		shlBauwerksanzeige.setMenuBar(menu);
		
		MenuItem mDatei = new MenuItem(menu, SWT.CASCADE);
		mDatei.setText("Datei");
		
		Menu menu_1 = new Menu(mDatei);
		mDatei.setMenu(menu_1);
		
		MenuItem mntmLaden = new MenuItem(menu_1, SWT.NONE);
		mntmLaden.setText("Laden");
		
		MenuItem umBeenden = new MenuItem(menu_1, SWT.NONE);
		umBeenden.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Beenden ausgew�hlt");
				shlBauwerksanzeige.close();
			}
		});
		umBeenden.setText("Beenden");
		
		MenuItem mHaus = new MenuItem(menu, SWT.CASCADE);
		mHaus.setText("Wohnhaus");
		
		Menu menu_2 = new Menu(mHaus);
		mHaus.setMenu(menu_2);
		
		MenuItem umHAnzeige = new MenuItem(menu_2, SWT.NONE);
		umHAnzeige.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					WohngebaeudeAnzeige windowHaus = new WohngebaeudeAnzeige(shlBauwerksanzeige, SWT.APPLICATION_MODAL);
					windowHaus.open();	
			}
		});
		umHAnzeige.setText("Anzeigen");
		
		MenuItem umHBerechnen = new MenuItem(menu_2, SWT.NONE);
		umHBerechnen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				WohngebaeudeBerechnen windowHausRechnen = new WohngebaeudeBerechnen(shlBauwerksanzeige, SWT.APPLICATION_MODAL);
				windowHausRechnen.open();
			}
		});
		umHBerechnen.setText("Berechnen");
		
		MenuItem mProduktion = new MenuItem(menu, SWT.CASCADE);
		mProduktion.setText("Produktion");
		
		Menu menu_3 = new Menu(mProduktion);
		mProduktion.setMenu(menu_3);
		
		MenuItem mntmAnzeige = new MenuItem(menu_3, SWT.NONE);
		mntmAnzeige.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProduktionsgebaeudeAnzeige windowProdAnzeige = new ProduktionsgebaeudeAnzeige(shlBauwerksanzeige, SWT.APPLICATION_MODAL);
				windowProdAnzeige.open();
				//hier muss der Aufruf rein
			}
		});
		mntmAnzeige.setText("Anzeige");
		
		MenuItem mntmBerechnen = new MenuItem(menu_3, SWT.NONE);
		mntmBerechnen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProduktionsgebaeudeRechnen windowProdRechnen = new ProduktionsgebaeudeRechnen(shlBauwerksanzeige, SWT.APPLICATION_MODAL);
				windowProdRechnen.open();
			}
		});
		mntmBerechnen.setText("Berechnen");
		
		MenuItem mGueter = new MenuItem(menu, SWT.CASCADE);
		mGueter.setText("Güter");
		
		Menu menu_4 = new Menu(mGueter);
		mGueter.setMenu(menu_4);
		
		MenuItem mntmGueterAnzeige = new MenuItem(menu_4, SWT.NONE);
		mntmGueterAnzeige.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GuetergebaeudeAnzeigen windowGeuterAnzeigen = new GuetergebaeudeAnzeigen(shlBauwerksanzeige, SWT.APPLICATION_MODAL);
				windowGeuterAnzeigen.open();
			}
		});
		mntmGueterAnzeige.setText("Anzeigen");
		
		ExpandBar expandBar = new ExpandBar(shlBauwerksanzeige, SWT.NONE);
		expandBar.setBounds(10, 131, 526, 132);
		
		ExpandItem xBI1 = new ExpandItem(expandBar, SWT.NONE);
		xBI1.setExpanded(true);
		xBI1.setText("eins");
		
		Label lblNewLabel = new Label(expandBar, SWT.NONE);
		xBI1.setControl(lblNewLabel);
		lblNewLabel.setText("New Label");
		xBI1.setHeight(xBI1.getControl().computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		
		 
	}
}
