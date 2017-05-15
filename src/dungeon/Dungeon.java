package dungeon;

import entity.*;
import component.*;
import java.util.ArrayList;
import screen.*;
import static screen.MainScreen.RAND;

public class Dungeon {

    //Vars
    private Entity[][] dungeon;
    private ArrayList<Entity> creatures;
    private ArrayList<Entity> rooms;
    private final int HEIGHT;
    private final int WIDTH;
    private final int ROOMS;
    public int height(){return HEIGHT;};
    public int width(){return WIDTH;};
    public int rooms(){return ROOMS;};
    
    //useful functions
    
    /**
     * Returns the character of the given tile
     * @param x
     * @param y
     * @return Returns component 
     */
    public char glyph(int x, int y){return dungeon[x][y].getComponent(cGlyph.class).glyph;}
    public cColor color(int x, int y){return dungeon[x][y].getComponent(cColor.class);}
    public Entity entity(int x, int y){return dungeon[x][y];}
    
    /**
     * Create new Dungeon level
     * @param w width of the dungeon
     * @param h height of the dungeon
     * @param r total number of rooms
     */
    public Dungeon(int w, int h, int r){
        this.HEIGHT = h;
        this.WIDTH = w;
        this.ROOMS = r;
        this.dungeon = new Entity[w][h];
    }
    
    public void fillDungeon(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Tile floor = new Tile();
                floor.getComponent(cGlyph.class).glyph = '.';
                floor.getComponent(cName.class).name = "Floor";
                dungeon[x][y] = floor;
            }
        }
    }
    
    /**
     * Creates a single room
     */
    public void createRoom(){
        int w = randBetween(5, 10);
        int h = randBetween(5, 8);
        int x = randBetween(0, WIDTH);
        int y = randBetween(0, HEIGHT);
        Room room = new Room(x, y, w, h);
    }
    
    public void drawRoom(){
        
    }

    /**
     * Little function to return a random number between two numbers
     * @param min number minimum
     * @param max number maximum
     * @return Returns a random number
     */
    public static int randBetween(int min, int max) {
        return RAND.nextInt((max - min) + 1) + min;
    }
    
}
