package entity;

import component.*;

public class Tile extends Entity{
    
    public Tile(){
        super();
        cName name = new cName();
        cGlyph glyph = new cGlyph();
        cColor color = new cColor();
        name.name = "PLACEHOLDER";
        glyph.glyph = '?';
        color.r = 255;
        color.g = 255;
        color.b = 255;
        addComponent(name);
        addComponent(glyph);
        addComponent(color);
    }
    
}
