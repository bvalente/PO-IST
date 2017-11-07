package editor.core;

import java.util.Comparator;

public class LineComparator implements Comparator<Line>{

    public int compare(Line l1, Line l2){
        Point o1 = l1._origin;
        Point o2 = l2._origin;

        return ( o1.getX() * o1.getY() - o2.getX() * o2.getY());

    }

}
