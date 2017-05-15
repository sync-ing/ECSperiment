package entity;

import component.*;

public class Player extends Entity {
    
    public Player(){
        super();
        cName name = new cName();
        cPosition position = new cPosition();
        cGlyph glyph = new cGlyph();
        cColor color = new cColor();
        name.name = "Player";
        position.x = 0;
        position.y = 0;
        glyph.glyph = '@';
        color.r = 255;
        color.g = 255;
        color.b = 255;
        addComponent(name);
        addComponent(position);
        addComponent(glyph);
    }
    
}
