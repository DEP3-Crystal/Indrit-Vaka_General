package OnMediaStore_2;

import java.util.ArrayList;
import java.util.List;

public class OnlineMedia
{
    public static void main(String[] args)
    {

        DigitalVideoDisc disc1 = new DigitalVideoDisc("MovieTitle", Category.movie, 5000, "directorName", 5);
        //Setting and getting a single object from the Properties file
        DataFromProperties.setProperties(disc1);
        DigitalVideoDisc disc = DataFromProperties.getProperties();
        System.out.println(disc.getTitle());

        List<DigitalVideoDisc> a  = new ArrayList<>();
        a.add(disc1);
        a.add(disc1);
        a.add(disc1);
        a.add(disc1);
        //Setting and getting a list of object from the property file
        DataFromProperties.setPropertyList(a);
        List<DigitalVideoDisc> listDisc = DataFromProperties.getPropertyList();
        System.out.println(listDisc);
    }
}
