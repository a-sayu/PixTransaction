package app;

import iu.Form;

public class Main {

    public static void main(String[] args) {
        Form form = new Form();
        if (form.initializeAtt()) {
            form.initializeApp();
        }
    }
}
