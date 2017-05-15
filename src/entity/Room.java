package entity;

import component.*;

public class Room extends Entity {
    
    public Room(int x, int y, int w, int h){
        cPosition position = new cPosition();
        cDimension dimension = new cDimension();
        position.x = x;
        position.y = y;
        dimension.w = w;
        dimension.h = h;
    }
}
