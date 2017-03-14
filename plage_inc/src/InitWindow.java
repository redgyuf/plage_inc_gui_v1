import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import game.GameTable;

import org.eclipse.swt.widgets.Text;

public class InitWindow {

	private GameTable gameTable;
	
	protected Shell shell;
	private Text text;
	private Text text_1;
	
	String player1;
	String player2;
	String[] players = new String[2];
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InitWindow window = new InitWindow();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void close(){
		shell.close();
	}

	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Plague Inc.");
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(36, 54, 364, 2);
		
		Label currentPlayer = new Label(shell, SWT.NONE);
		currentPlayer.setBounds(138, 10, 55, 15);
		
		CLabel lblPlagueIncKrtya = new CLabel(shell, SWT.NONE);
		lblPlagueIncKrtya.setBounds(148, 27, 127, 21);
		lblPlagueIncKrtya.setText("Plague Inc. kártya játék");
		
		Label lblEgyesJtkosNeve = new Label(shell, SWT.NONE);
		lblEgyesJtkosNeve.setBounds(73, 77, 101, 15);
		lblEgyesJtkosNeve.setText("Egyes játékos neve:");
		
		Label lblKettesJtkosNeve = new Label(shell, SWT.NONE);
		lblKettesJtkosNeve.setText("Kettes játékos neve:");
		lblKettesJtkosNeve.setBounds(263, 77, 115, 15);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(73, 98, 101, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(263, 98, 101, 21);
		
		
		
		Button btnJtkKezdse = new Button(shell, SWT.NONE);
		btnJtkKezdse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				player1 = text.getText();
				player2 = text_1.getText();
				players[0] = player1;
				players[1] = player2;
				Main2.continues();
				close();
			}
			
		});		
		
		
		btnJtkKezdse.setBounds(171, 181, 94, 25);
		btnJtkKezdse.setText("Játék kezdése!");

	}

	public String[] getPlayers(){
		return players;
	}
}
