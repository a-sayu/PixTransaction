package catalog;

import java.util.ArrayList;
import log.Logger;
import log.logType;
import model.Account;
import model.Pix;

/**
 *
 * @author Abigail S. N. - @a-sayu
 *
 */
public class PixCatalog {

    private ArrayList<Pix> pixRecords;
    private Logger log;

    public PixCatalog() {
        log = Logger.getInstance();
        pixRecords = new ArrayList<>();
    }

    public boolean addPix(Pix pix) {
        if (pix.getPayer().debitBalance(pix.getValue())) {
            pix.getPayee().creditBalance(pix.getValue());
            if (pixRecords.add(pix)) {
                log.log(logType.INFO, "= Pix ="
                        + " Data do Pix: " + pix.getPaymentDate()
                        + " Pagador: " + pix.getPayer().getHolder()
                        + " Recebedor: " + pix.getPayee().getHolder()
                        + " Chave Pix: " + pix.getPayee().getPixKey()
                        + " Valor do Pix: " + pix.getValue()
                        + " foi criado e adicionada ao catalgo.");
                return true;
            } else {
                pix.getPayee().debitBalance(pix.getValue());
                pix.getPayer().creditBalance(pix.getValue());
            }
        }
        log.log(logType.ERROR, "= Pix =\n"
                + " Data do Pix: " + pix.getPaymentDate()
                + " Pagador: " + pix.getPayer().getHolder()
                + " Recebedor: " + pix.getPayee().getHolder()
                + " Chave Pix: " + pix.getPayee().getPixKey()
                + " Valor do Pix: " + pix.getValue()
                + " nao foi adicionada ao catalogo");
        return false;
    }

    public void showAllPayments() {
        System.out.println("\n\nPAYMENTS=================================");
        for (Pix pix : pixRecords) {
            pix.toString();
        }
    }

    public void showAllPaymentsFromAccount(Account account) {
        System.out.println("\n\nPAYMENTS=================================");
        for (Pix pix : pixRecords) {
            if (pix.getPayer().equals(account) || pix.getPayee().equals(account)) {
                pix.toString();
            }
        }
    }
}
