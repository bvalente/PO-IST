package editor.app;

import editor.core.Editor;

public class App {

    public static void main (String[] args) {
        Editor editor = new Editor();  // Create main Entity
        MainMenu mainMenu = new MainMenu(editor); // Create menu with Entity
        mainMenu.open(); // Open the menu

        pt.tecnico.po.ui.Dialog.IO.close();
    }
}
