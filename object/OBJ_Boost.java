package object;


import java.io.*;
import javax.imageio.ImageIO;
public class OBJ_Boost extends SuperObject
{
    public OBJ_Boost()
    {
        name = "Boost";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/boost.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
