package app;

import iu.Form;
import control.AccountControl;
import control.PixControl;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class App {

    private Form form;
    private AccountControl accountControl;
    private PixControl pixControl;
    private String accountData;

    public App() {
        form = new Form();
        accountControl = new AccountControl();
        pixControl = new PixControl();
    }

    public void run() {

    }

    public boolean accountConnect() {
        accountData = accountControl.connectAccount(form.connectForm());
    }

}
