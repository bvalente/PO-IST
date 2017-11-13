/* $Id: DialogException.java,v 1.2 2017/09/05 16:28:29 david Exp $ */
package editor.core;

import pt.tecnico.po.ui.DialogException;

/**
 * This class represents events in unsuccessful operations.
 */
public class NoSuchFormException extends DialogException {

  /**
   * Serial number for serialization.
   */
  static final long serialVersionUID = 200610291601L;

  /**
   * This method is made abstract so that meaningful descriptive messages are
   * provided by each subclass, instead of using the general implementation.
   *
   * @see java.lang.Throwable#getMessage()
   */
  @Override
  public String getMessage(){
      
  }

  /**
   * Subclasses are not allowed to redefine this method.
   *
   * @see java.lang.Throwable#toString()
   */
  @Override
  public final String toString() {
    return ErrorMessages.invalidOperation(getMessage());
  }

}