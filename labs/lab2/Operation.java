

public class Operation {
   
    static public int add (int v1, int v2) {
        int  res = v1 + v2;

        return res;
    }  

    static public int times (int v1, int v2) {
        int  res = v1 * v2;

        return res;
    }

    static public void main(String argv[]) {
        int  x = 0;

        System.out.println(add(2, x));
    }
}
