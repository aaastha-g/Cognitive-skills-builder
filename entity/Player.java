package entity;

import java.awt.Color;
import game.GamePanel;
import game.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class Player extends Entity
{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY ;
    public int hasKey = 0;
    public int error = 0;

    public Player(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;

        screenX = (gp.screenWidth/2) - (gp.tileSize/2);
        screenY = (gp.screenHeight/2) - (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues(); 
        getPlayerImage();
    }

    public void setDefaultValues()
    {
        worldX=gp.tileSize * 16;
        worldY=gp.tileSize * 16;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage()
    {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
        }
        catch(IOException e)
        {

        }
    }

    public void update()
    {
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
        {
            if(keyH.upPressed == true)
            {
                direction = "up";
            }
            else if(keyH.downPressed == true)
            {
                direction = "down";
            }
            else if(keyH.leftPressed == true)
            {
                direction = "left";
            }
            else if(keyH.rightPressed == true)
            {
                direction = "right";
            }
            
            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);
            
            //IF COLLISION
            if(collisionOn == false)
            {
                switch(direction)
                {
                    case "up" :
                        {
                           worldY -= speed; 
                        }
                    break;
                    case "down" :
                        {
                            worldY += speed;
                        }
                    break;
                    case "left" :
                        {
                            worldX -= speed;
                        }
                    break;
                    case "right" :
                        {
                            worldX += speed;
                        }
                    break;
                }
            }
            spriteCounter++;
            if(spriteCounter > 12)
            {
                if(spriteNum ==1)
                {
                    spriteNum = 2;
                }
                else if(spriteNum == 2)
                {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(int i)
    {
        if(i != 999)
        {
            String objectName = gp.obj[i].name;
            
            switch(objectName)
            {
                case "Sword":
                    gp.playSE(2);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got a Sword!");
                    break;
                case "Lock":
                    if(hasKey>0)
                    {
                        gp.playSE(1);
                        gp.obj[i] = null;
                        gp.ui.showMessage("You opened the door");
                        hasKey--;
                    }
                    else
                    {
                        gp.ui.showMessage("You need a Sword!");
                    }
                    break;
                case "Boost":
                    gp.playSE(2);
                    speed += 2;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Speed up!");
                    break;
                case "Portal":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(3);
                    break;
                case "Error":
                    error++;
                    gp.obj[i] = null;
            }
        }
    }
    public void draw(Graphics2D g2)
    {
        // g2.setColor(Color.white);
        // g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;

        switch(direction)
        {
            case "up":
                {
                    if(spriteNum == 1)
                    {
                        image = up1;
                    }
                    if(spriteNum == 2)
                    {
                        image = up2;
                    }
                    break;
                }
            case "down" :
                {
                    if(spriteNum == 1)
                    {
                        image = down1;
                    }
                    if(spriteNum == 2)
                    {
                        image = down2;
                    }
                    break;
                }
            case "left" :
                {
                    if(spriteNum == 1)
                    {
                        image = left1;
                    }
                    if(spriteNum == 2)
                    {
                        image = left2;
                    }
                    break;
                }
            case "right" :
                {
                    if(spriteNum == 1)
                    {
                        image = right1;
                    }
                    if(spriteNum == 2)
                    {
                        image = right2;
                    }
                    break;
                }
        }
        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }
}