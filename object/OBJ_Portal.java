package object;
import java.io.*;
import javax.imageio.ImageIO;
public class OBJ_Portal extends SuperObject
{
    public OBJ_Portal()
    {
        name = "Portal";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/portal.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
