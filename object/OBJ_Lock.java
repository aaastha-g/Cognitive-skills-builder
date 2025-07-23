package object;

import java.io.*;
import javax.imageio.ImageIO;
public class OBJ_Lock extends SuperObject
{
    public OBJ_Lock()
    {
        name = "Lock";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/lock.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}
