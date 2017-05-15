package entity;

import component.Component;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

// TODO:

// > Turn components List into HashMap
// > Get rid of the Component name fields

public abstract class Entity {
    
    //ID of the entity
    public UUID id;
    //List
    public List<Component> components;
    //Constructor
    public Entity(){
        //each entity object gets a unique identifier
        this.id = UUID.randomUUID();
        this.components = new ArrayList<Component>();
    }
    
    /**
     * Adds component zo list of entity<br>
     * Tasks:<br>
     * 1. Check if Component already exists in entity<br>
     * 2. a) if component already exists, don't add the component<br>
     * 2. b) if component doesn't exist, add the component to the list<br>
     * @param c Component to be added
     */
    public void addComponent(Component c){
        Component temp = null;
        for(Component comp : components){
            if(comp.getClass() == c.getClass())
                temp = comp;
        }
        if(temp == null)
            components.add(c);
    }
    
    /**
     * Get a specific component back, for getting it's data<br>
     * Tasks:<br>
     * 1. Check if component of superclass exists<br>
     * 2. a) throw error if it doesnt exist (temp == null)<br>
     * 2. b) return component<br>
     * @param c Class of component to be returned
     * @return Returns the component of said class
    **/
    public <T> T getComponent(Class<T> c){
        T temp = null;
        List<T> templist = (List<T>) components;
        for(T comp : templist){
            if(c == comp.getClass())
                temp = (T) comp;
        }
        if(temp == null)
            throw new IllegalArgumentException("GET Error: Entity"+this.id.toString()+" doesn*t have the component: "+c);
        return temp;
    }

    /**
     * Check if Entity has component<br>
     * Tasks:<br>
     * 1. Cycle through list and check for component<br>
     * 2. a) throw false if no<br>
     * 2. b) throw true if yes<br>
     * @param c Component has to be checked
    **/
    public boolean hasComponent(Class c){
        Component temp = null;
        for(Component comp : components){
            if(comp.getClass() == c)
                temp = comp;
        }
        return temp != null;
    }
    
    /**
     * Add value to a component<br>
     * Tasks:<br>
     * 1. Cycle through Components<br>
     * 2. a) if component exists, delete it from the components list<br>
     * 2. b) throw exception if component doesnt exist<br>
     * @param c class of component to be deleted
    **/
    public void deleteComponent(Class c){
        for(Component comp : components){
            if(comp.getClass() == c){
                components.remove(comp);
                return;
            }
        }
        throw new IllegalArgumentException("DELETE error: Entity "+this.id+" doesnt have a component of class "+c);
    }
}
