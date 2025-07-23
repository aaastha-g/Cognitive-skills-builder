package object;


import java.io.*;
import javax.imageio.ImageIO;
public class OBJ_Error extends SuperObject
{
    public OBJ_Error()
    {
        name = "Error";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/space2.png"));
                                    //Map edit karne k baad....change this to moon.png
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
