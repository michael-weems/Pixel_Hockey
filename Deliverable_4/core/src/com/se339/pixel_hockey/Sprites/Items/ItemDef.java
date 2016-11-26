package com.se339.pixel_hockey.Sprites.Items;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by se339.pixel_hockey on 9/24/15.
 */
public class ItemDef {
    public Vector2 position;
    public Class<?> type;

    public ItemDef(Vector2 position, Class<?> type){
        this.position = position;
        this.type = type;
    }
}
