package hibernateexample;

import java.util.List;

/**
 * Aaron Foote
 */
public class RunBikeHibernate {

    public static void main(String[] args) {

         DataBaseTest b = DataBaseTest.getInstance();

        List<Bikes> c = b.getBikes();
        for (Bikes i : c) {
            System.out.println(i);
        }

        System.out.println(b.getBikes(1));
    }


}//end RunBikeHibernate
