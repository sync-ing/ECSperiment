package screen;

import entity.*;
import component.*;
import asciiPanel.*;
import dungeon.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class MainScreen implements Screen{

    //vars
    public static Random RAND; //global RNG
    private Dungeon g; //dungeon
    private int centerX;
    private int centerY;
    private int screenWidth;
    private int screenHeight;
    private long SEED;
    
    public MainScreen(){
        screenWidth = 80;
        screenHeight = 23;
        
        //initialize global RNG
        RAND = new Random();
        SEED = RAND.nextLong();
        RAND.setSeed(SEED);
        System.out.println("Seed: " + SEED + "L");
        
        createDungeon();        
    }
    
    @Override
    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();
   
        displayTiles(terminal, left, top);
        terminal.write('X', centerX - left, centerY - top);
        
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_LEFT: scrollBy(-1, 0); break;
            case KeyEvent.VK_RIGHT: scrollBy( 1, 0); break;
            case KeyEvent.VK_UP: scrollBy( 0,-1); break;
            case KeyEvent.VK_DOWN: scrollBy( 0, 1); break;
        }
        return this;
    }
    
    private void createDungeon(){
        g = new Dungeon(80, 23, 1);
        g.fillDungeon();
    }
    
    //functions for scrolling
    public int getScrollX() {
        return Math.max(0, Math.min(centerX - screenWidth / 2, g.width() - screenWidth));
    }
    public int getScrollY() {
        return Math.max(0, Math.min(centerY - screenHeight / 2, g.height() - screenHeight));
    }
    private void scrollBy(int mx, int my){
        centerX = Math.max(0, Math.min(centerX + mx, g.width() - 1));
        centerY = Math.max(0, Math.min(centerY + my, g.height() - 1));
    }
    
    //displaying the dungeon
    private void displayTiles(AsciiPanel terminal, int left, int top) {
    for (int x = 0; x < screenWidth; x++){
        for (int y = 0; y < screenHeight; y++){
            int wx = x + left;
            int wy = y + top;

            terminal.write(g.glyph(wx, wy), x, y, g.color(wx, wy));
        }
    }
}
    
}
