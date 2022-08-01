import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OnlineMedia
{
    public static void main(String[] args)
    {


        //creating an order
        Order order = new Order();

        //Populating the order
        DigitalVideoDisc disc1 = new DigitalVideoDisc("MovieTitle", Category.movie, 5000, "directorName", 5);
        List<DigitalVideoDisc> diskList = new ArrayList<>();
        diskList.add(disc1);
        diskList.add(disc1);
        diskList.add(disc1);
        diskList.add(disc1);
        order.addOrders(diskList);
        //saving the data

        //using property files
        DataFromProperties.setProperties(disc1); //saves only one disk
        DataFromProperties.setPropertyList(diskList); //saves a list of disks
        //using json files
        try
        {
            DataFromJson.addOrder(order);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }


        //Reading from files
        //Json
        try
        {
            Order order1 = DataFromJson.getOrder();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        //Setting and getting a single object from the Properties file
        DataFromProperties.setProperties(disc1);
        DigitalVideoDisc disc = DataFromProperties.getProperties();
        System.out.println(disc.getTitle());

        List<DigitalVideoDisc> a = new ArrayList<>();
        a.add(disc1);
        a.add(disc1);
        a.add(disc1);
        a.add(disc1);
        //Setting and getting a list of object from the property file
        DataFromProperties.setPropertyList(a);
        List<DigitalVideoDisc> listDisc = DataFromProperties.getPropertyList();
        System.out.println(listDisc);



    }

    public static void propertyFiles()
    {

    }

    public static void jsonFiles()
    {

    }
}
