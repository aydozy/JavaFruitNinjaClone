package com.aydanilozyurek.fruitninja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Fruit {

    public static float radius = 60f;

    public enum Type{
        REGULAR,EXTRA,ENEMY,LIFE
    }

    Type type;
    Vector2 pos, velocity;
    public boolean living =  true;

    Fruit(Vector2 pos,Vector2 velocity){
        this.pos=pos;
        this.velocity=velocity;
        type=Type.REGULAR;
    }

    public boolean clicked(Vector2 click){

        if(pos.dst2(click) <= radius * radius + 1){
            return true;
        }
        return false;
    }

    public final Vector2 getPos(){
        return pos;
    }

    public boolean outOfScreen(){
        return (pos.y < -2f * radius);
    }

    public void update(float deltaTime){
        velocity.y -= deltaTime * (Gdx.graphics.getHeight() * 0.2f);
        velocity.x -= deltaTime * Math.signum(velocity.x) * 5f;
        pos.mulAdd(velocity,deltaTime);
    }



}
