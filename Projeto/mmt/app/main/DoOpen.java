package mmt.app.main;

import mmt.core.TicketOffice;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import java.io.FileNotFoundException;
import java.io.IOException;

//FIXME import other classes if necessary

/**
 * §3.1.1. Open existing document.
 */
public class DoOpen extends Command<TicketOffice> {

    private Input<String> _filename;

  /**
   * @param receiver
   */
  public DoOpen(TicketOffice receiver) {
    super(Label.OPEN, receiver);
    _filename = _form.addStringInput(Message.saveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    try {
      //FIXME implement command
      _receiver.load(_filename.toString());

    } catch (FileNotFoundException fnfe) {
      _display.popup(Message.fileNotFound());
    } catch (ClassNotFoundException | IOException e) {
      // shouldn't happen in a controlled test setup
      e.printStackTrace();
    }
  }

}
