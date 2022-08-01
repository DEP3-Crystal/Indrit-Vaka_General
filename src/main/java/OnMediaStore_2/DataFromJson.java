package OnMediaStore_2;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataFromJson
{
    /**
     * this method returns a list of disk stored in a json file
     * and throws an IOException if the file can't be found
     * @return returns a list of disk stored in a json file
     * @throws IOException
     */
    public static Order getOrder() throws IOException
    {
        Order order;

        ObjectMapper mapper = new ObjectMapper();

        order =  mapper.readValue(new File("data/discs.json"), Order.class);

        return order;
    }
    class disks{
        List<DigitalVideoDisc> discs;
    }
    /**
     * This method gets a list of disks and adds them to a json File (data/discs.json)
     * @param order the list disks to be added into the file
     * @throws IOException if it doesn't find the file
     * */
    public static void addOrder(Order order) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new FileWriter("data/discs.json"),order );
    }
}
