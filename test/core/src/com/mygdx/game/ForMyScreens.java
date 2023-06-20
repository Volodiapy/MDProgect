package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public interface ForMyScreens {
    public OrthographicCamera camera = new OrthographicCamera();
    public TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("atlas.atlas"));;
}
