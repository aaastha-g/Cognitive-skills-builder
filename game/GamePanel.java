package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;
import object.SuperObject;

public class GamePanel extends JPanel implements Runnable
{
    //TILE GRIDS
    final int originalTileSize = 16;
    final int scale  = 3;
    public final int tileSize = originalTileSize  * scale;
    
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    //WORLD MAP SETTINGS
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;
    
    //FPS
    int FPS = 60;
    
    //OBJECT CREATION
    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound se = new Sound();
    public UI ui = new UI(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    
    //ENTITY AND OBJECT
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[40]; 

    //POSTION
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    //PANEL SETUP
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    //FOR SOUND AND SETTING THE OBJECTS ON PANEL
    public void setupGame()
    {
        aSetter.setObject();
        
        playMusic(0);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    //THE GAME LOOP START S 3D
    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null)
        {
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta>=1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000)
            {
                //System.out.println("FPS : " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update()
    {
        player.update();
    }

    //THIS IS FOR PAITING THE PANEL...FOR FILLING THE PANEL WITH TILES,PLAYER,UI AND OBJECTS
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //TILE
        tileM.draw(g2);
        //OBJECT 
        for(int i=0;i<obj.length;i++)
        {
            if(obj[i] != null)
            {
                obj[i].draw(g2,this);
            }
        }
        //PLAYER
        player.draw(g2);
        
        ui.draw(g2);
        g2.dispose();
    }
    
    //3 METHODS TO PLAY,STOP, AND KEEP MUSIC IN LOOP
    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();
        music.loop();
    }
    
    public void stopMusic()
    {
        music.stop();
    }
    
    public void playSE(int i)
    {
        se.setFile(i);
        se.play();
    }
}

