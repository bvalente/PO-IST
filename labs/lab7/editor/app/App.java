package editor.app;

import editor.core.Editor;

public class App {

    public static void main (String[] args) {
        Editor edt =  new Editor();

        MainMenu menu = new MainMenu(edt);
        menu.open();

        pt.tecnico.po.ui.Dialog.IO.close();
    }
}
