package game;

import java.awt.*;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Sword;

//
public class UI
{
    GamePanel gp;
    Font arial_40, arial_80B;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.BOLD,40);
        arial_80B = new Font("Arial", Font.PLAIN,80);
        OBJ_Sword key = new OBJ_Sword();
        keyImage = key.image;
    }

    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2)
    {
        if(gameFinished == true)
        {
            g2.setFont(arial_40);
            g2.setColor(Color.yellow);
            
            String text;
            String endText;
            int textLength;
            int endTextLength;
            int x,x1;
            int y,y1;
            
            text = "CONGRATULATIONS!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenWidth/2 - (gp.tileSize*2);
            g2.drawString(text,x,y);
            
            text = "Your Time is :" + dFormat.format(playTime) + "!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenWidth/2 + (gp.tileSize*2);
            g2.drawString(text,x,y);
            
            text = "Errors :" + gp.player.error;
            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenWidth/2 + (gp.tileSize*2) + (gp.tileSize*2);
            g2.drawString(text,x,y);
            // g2.setFont(arial_80B);
            // g2.setColor(Color.yellow);
            // endText = "CONGRATULATIONS!!";
            // endTextLength = (int)g2.getFontMetrics().getStringBounds(endText,g2).getWidth();
            // x1 = gp.screenWidth/2 - textLength/2;
            // y1 = gp.screenWidth/2 + (gp.tileSize*3);
            // g2.drawString(endText,x1,y1);
            
            gp.gameThread = null;
        }
        else
        {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
            g2.drawString(" x " + gp.player.hasKey,74,65);
            g2.drawString("ERRORS : "  + gp.player.error,74,110);
            
            //TIME
            playTime += (double)1/60;
            g2.drawString("Time:" + dFormat.format(playTime),gp.tileSize*11,65);

            //MESSAGE
            if(messageOn == true)
            {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message,gp.tileSize/2,gp.tileSize*5);

                messageCounter++;

                if(messageCounter > 120)
                {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }

    }
}