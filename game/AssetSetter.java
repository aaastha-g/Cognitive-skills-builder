package game;
import object.OBJ_Sword;
import object.OBJ_Lock;
import object.OBJ_Portal;
import object.OBJ_Boost;
import object.OBJ_Error;
public class AssetSetter
{
    GamePanel gp;
    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }
    
    //THE ASSESTS OR THE OBJECTS ARE PLACED FROM THIS
    public void setObject()
    {
         //DONE
        gp.obj[0] = new OBJ_Sword();
        gp.obj[0].worldX = 52*gp.tileSize;
        gp.obj[0].worldY = 26*gp.tileSize;
        
        gp.obj[4] = new OBJ_Portal();
        gp.obj[4].worldX = 58*gp.tileSize;
        gp.obj[4].worldY = 23*gp.tileSize;
        
        gp.obj[3] = new OBJ_Lock();
        gp.obj[3].worldX = 54*gp.tileSize;
        gp.obj[3].worldY = 23*gp.tileSize;
        
        gp.obj[5] = new OBJ_Boost();
        gp.obj[5].worldX = 16*gp.tileSize;
        gp.obj[5].worldY = 42*gp.tileSize;
        
        gp.obj[1] = new OBJ_Sword();
        gp.obj[1].worldX = 39*gp.tileSize;
        gp.obj[1].worldY = 37*gp.tileSize;
        
        gp.obj[6] = new OBJ_Lock();
        gp.obj[6].worldX = 47*gp.tileSize;
        gp.obj[6].worldY = 38*gp.tileSize;
        
        gp.obj[2] = new OBJ_Sword();
        gp.obj[2].worldX = 19*gp.tileSize;
        gp.obj[2].worldY = 21*gp.tileSize;
        
        gp.obj[7] = new OBJ_Lock();
        gp.obj[7].worldX = 30*gp.tileSize;
        gp.obj[7].worldY = 24*gp.tileSize;
        
        gp.obj[9] = new OBJ_Error();
        gp.obj[9].worldX = 22*gp.tileSize;
        gp.obj[9].worldY = 21*gp.tileSize;
        
        gp.obj[10] = new OBJ_Error();
        gp.obj[10].worldX = 57*gp.tileSize;
        gp.obj[10].worldY = 38*gp.tileSize;
        
        gp.obj[11] = new OBJ_Error();
        gp.obj[11].worldX = 40*gp.tileSize;
        gp.obj[11].worldY = 36*gp.tileSize;
        
        gp.obj[12] = new OBJ_Error();
        gp.obj[12].worldX = 40*gp.tileSize;
        gp.obj[12].worldY = 36*gp.tileSize;
    }
}