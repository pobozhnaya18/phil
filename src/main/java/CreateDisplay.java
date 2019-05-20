
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Класс для создания окна
 *

 *
 */
public class CreateDisplay {
    private Display display;
    private Shell shell;
    private GridLayout gridLayout = new GridLayout();

    private Label LabelForInformation;
    private MessageBox messegeBox;
    private Label labelNumberDebaters;
    private Text textNumberDebaters;
    private Button buttonArgue;
    private Label labelForNonification;

    public CreateDisplay() {
        display = new Display();
    }

    /**
     * Создает окно
     */
    public void CreateWindow() {
        shell = new Shell(display);
        shell.setText("Философы");
        shell.setSize(400, 150);
        shell.setLayout(gridLayout);

        gridLayout.numColumns = 2;

        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.horizontalSpan = 2;

        LabelForInformation = new Label(shell, SWT.PUSH);
        LabelForInformation.setText("Введите количество философов.");
        LabelForInformation.setLayoutData(gridData);

        GridData gridData1 = new GridData();
        gridData1.horizontalSpan = 1;
        gridData1.horizontalAlignment = GridData.BEGINNING;

        labelNumberDebaters = new Label(shell, SWT.FILL);
        labelNumberDebaters.setText("Количество философов: ");
        labelNumberDebaters.setLayoutData(gridData1);

        textNumberDebaters = new Text(shell, SWT.BEGINNING);
        textNumberDebaters.setLayoutData(gridData1);

        gridData1.horizontalSpan = 1;
        gridData1.horizontalAlignment = GridData.BEGINNING;

        GridData gridDataForButton = new GridData();
        gridDataForButton.horizontalSpan = 2;
        gridDataForButton.horizontalAlignment = GridData.BEGINNING;

        buttonArgue = new Button(shell, SWT.CENTER);
        buttonArgue.setText("Обедать");
        buttonArgue.setLayoutData(gridDataForButton);

        GridData gridData3 = new GridData();
        gridData1.horizontalSpan = 1;
        gridData1.horizontalAlignment = GridData.BEGINNING;

        labelForNonification = new Label(shell, SWT.FILL);
        labelForNonification.setText("          			        ");
        labelForNonification.setLayoutData(gridData3);

        /**
         * Событие при нажатии на кнопку "Обедать"
         */
        buttonArgue.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                int numberPhilosophers;
                if (textNumberDebaters.getText().isEmpty()) {
                    messegeBox = new MessageBox(shell, SWT.ERROR | SWT.OK);
                    messegeBox.setText("Error!");
                    messegeBox.setMessage("Введите количество философов!");
                    messegeBox.open();
                    return;
                } else {
                    numberPhilosophers = Integer.parseInt(textNumberDebaters.getText());
                }
                //здесь создаем главный поток
                MainThread MT = new MainThread(numberPhilosophers);
                MT.CreatePhilosopher();
                labelForNonification.setText(MT.returnNotification());
                //labelForNonification.getParent().layout(false);
            }
        });

        shell.open();
        while (!shell.isDisposed()) {
            // process the next event, wait when none available
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }

}