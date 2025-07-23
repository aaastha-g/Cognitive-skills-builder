package object;
import java.io.*;
import javax.imageio.ImageIO;
public class OBJ_Sword extends SuperObject
{
    public OBJ_Sword()
    {
        name = "Sword";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/sword.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
