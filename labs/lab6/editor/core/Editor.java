package editor.core;
import java.util.LinkedList;

/**
 * Form editor: allows the creation and manipulation of graphical forms such as
 * squares, circles, and lines. Forms can be created, moved, and deleted.
 *
 * @author Programação com Objectos
 * @version 3.1
 */

public class Editor {

    /**
     * Give each form an unique identifier.
     */
    private int _nextId;

    /**
    * Uses a LinkedList.
    */
    private LinkedList<Form> _lista;

    //construtor
    public Editor(){
      _nextId = 0;
      _lista = new LinkedList<Form>();
    }
    /**
     * Add a form.
     *
     * @param the form to add.
     *
     * @return the added form's id.
     */
    public final int addForm(Form f) {
    	int id = ++_nextId;
      f._id = id;
      _lista.add(f);

    	return id;
    }

    /**
     * Remove a given form (by id).
     *
     * @param id the identifier of the form to be removed.
     */
    public void remove(int id) {

      for(Form i : _lista){
        if (i._id == id){
          _lista.remove(i);
        }
      }
    }

    public void First(Form f){
      offerFirst(f);
    }
    public void Last(Form f){
      offerLast(f);
    }


}
