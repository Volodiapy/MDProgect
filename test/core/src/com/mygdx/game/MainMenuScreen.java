package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

public class MainMenuScreen implements Screen, ForMyScreens{
    final Drop game;
    //TextureAtlas atlas;// = new TextureAtlas(Gdx.files.internal("atlas.atlas"));
    final private TextureAtlas.AtlasRegion fontexture, buttonstarttexture, buttondialogtexture, exitteture, uphealthtexture, upmanatexture, upattacktexture, updeftexture, upcontroltexture;
    final private BitmapFont thealth = new BitmapFont(), tmana = new BitmapFont(), tattack = new BitmapFont(), tdef = new BitmapFont(), tcontrol = new BitmapFont(), tcoin = new BitmapFont();
    final private Rectangle fon, buttonstart, buttondialog, uphealth, upmana, upattack, updef, upcontrol, exit;
    final private SpriteBatch fonsprite, buttonstartsprite, buttodialogsprite, uphealthsprite, upmanasprite, upattacksprite, updefsprite, upcontrolsprite, exitsprite;
    //OrthographicCamera camera;
    Vector3 touchPos = new Vector3();

    String sendtorender = "";
    int s = 1;
    //Label lb;
    private long time;
    public MainMenuScreen(Drop gam) {
        this.game = gam;
        //atlas = new TextureAtlas(Gdx.files.internal("atlas.atlas"));
        //camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);


        fontexture =  atlas.findRegion("startsklep");
        buttonstarttexture =  atlas.findRegion("startbutton");
        buttondialogtexture =  atlas.findRegion("darkball1");
        uphealthtexture = atlas.findRegion("plus");
        upmanatexture = atlas.findRegion("plus");
        upattacktexture = atlas.findRegion("plus");
        updeftexture = atlas.findRegion("plus");
        upcontroltexture = atlas.findRegion("plus");
        exitteture = atlas.findRegion("plus");

        thealth.setColor(Color.RED);
        tmana.setColor(Color.BLUE);
        tattack.setColor(Color.CORAL);
        tdef.setColor(Color.OLIVE);
        tcontrol.setColor(Color.PINK);
        tcoin.setColor(Color.YELLOW);

        fonsprite = new SpriteBatch();
        fonsprite.setProjectionMatrix(camera.combined);
        buttonstartsprite = new SpriteBatch();
        buttonstartsprite.setProjectionMatrix(camera.combined);
        buttodialogsprite = new SpriteBatch();
        buttodialogsprite.setProjectionMatrix(camera.combined);
        uphealthsprite = new SpriteBatch();
        uphealthsprite.setProjectionMatrix(camera.combined);
        upmanasprite = new SpriteBatch();
        upmanasprite.setProjectionMatrix(camera.combined);
        upattacksprite = new SpriteBatch();
        upattacksprite.setProjectionMatrix(camera.combined);
        updefsprite = new SpriteBatch();
        updefsprite.setProjectionMatrix(camera.combined);
        upcontrolsprite = new SpriteBatch();
        upcontrolsprite.setProjectionMatrix(camera.combined);
        exitsprite = new SpriteBatch();
        exitsprite.setProjectionMatrix(camera.combined);

        //lb = new Label(this, "Брабаппп  вваА", 50, 100, 120, 20, 255, 255, 255,1, 25, 25);

        fon = new Rectangle();
        fon.x = 0;
        fon.y = 0;
        fon.width = 800;
        fon.height = 480;

        buttonstart = new Rectangle();
        buttonstart.x = fon.width/2 + 25;
        buttonstart.y = fon.height/2 - 50;
        buttonstart.width = 200;
        buttonstart.height = 100;

        buttondialog = new Rectangle();
        buttondialog.x = 100;
        buttondialog.y = 300;
        buttondialog.width = 50;
        buttondialog.height = 50;

        uphealth = new Rectangle();
        uphealth.x = 350;
        uphealth.y = 350;
        uphealth.width = 25;
        uphealth.height = 25;

        upmana = new Rectangle();
        upmana.x = 400;
        upmana.y = 350;
        upmana.width = 25;
        upmana.height = 25;

        upattack = new Rectangle();
        upattack.x = 450;
        upattack.y = 350;
        upattack.width = 25;
        upattack.height = 25;

        updef = new Rectangle();
        updef.x = 500;
        updef.y = 350;
        updef.width = 25;
        updef.height = 25;

        upcontrol = new Rectangle();
        upcontrol.x = 550;
        upcontrol.y = 350;
        upcontrol.width = 25;
        upcontrol.height = 25;

        exit = new Rectangle();
        exit.x = 0;
        exit.y = 430;
        exit.width = 50;
        exit.height = 50;
    }

    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void render(float delta) {
        camera.update();

        fonsprite.begin();
        fonsprite.draw(fontexture, fon.x, fon.y, fon.width,fon.height);
        tcoin.draw(fonsprite, String.valueOf(game.coin), 300, 375);
        fonsprite.end();
        buttonstartsprite.begin();
        buttonstartsprite.draw(buttonstarttexture, buttonstart.x, buttonstart.y, buttonstart.width,buttonstart.height);
        buttonstartsprite.end();
        buttodialogsprite.begin();
        buttodialogsprite.draw(buttondialogtexture, buttondialog.x, buttondialog.y, buttondialog.width,buttondialog.height);
        buttodialogsprite.end();
        uphealthsprite.begin();
        uphealthsprite.draw(uphealthtexture, uphealth.x, uphealth.y, uphealth.width,uphealth.height);
        thealth.draw(uphealthsprite, String.valueOf(game.maxhealth), uphealth.x + uphealth.width + 5, uphealth.y + uphealth.height);
        uphealthsprite.end();
        upmanasprite.begin();
        upmanasprite.draw(upmanatexture, upmana.x, upmana.y, upmana.width,upmana.height);
        tmana.draw(upmanasprite, String.valueOf(game.maxmana), upmana.x + upmana.width + 5, upmana.y + upmana.height);
        upmanasprite.end();
        upattacksprite.begin();
        upattacksprite.draw(upattacktexture, upattack.x, upattack.y, upattack.width,upattack.height);
        tattack.draw(upattacksprite, String.valueOf(game.modattack), upattack.x + upattack.width + 5, upattack.y + upattack.height);
        upattacksprite.end();
        updefsprite.begin();
        updefsprite.draw(updeftexture, updef.x, updef.y, updef.width,updef.height);
        tdef.draw(updefsprite, String.valueOf(game.moddef), updef.x + updef.width + 5, updef.y + updef.height);
        updefsprite.end();
        upcontrolsprite.begin();
        upcontrolsprite.draw(upcontroltexture, upcontrol.x, upcontrol.y, upcontrol.width,upcontrol.height);
        tcontrol.draw(upcontrolsprite, String.valueOf(game.modcontrol), upcontrol.x + upcontrol.width + 5, upcontrol.y + upcontrol.height);
        upcontrolsprite.end();
        exitsprite.begin();
        exitsprite.draw(exitteture, exit.x, exit.y, exit.width, exit.height);
        exitsprite.end();
        //lb.rend();
        if(Gdx.input.isTouched()){
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if(buttonstart.contains(touchPos.x, touchPos.y)){
                game.setScreen(new GameScreen(game, this));

            }
            if(buttondialog.contains(touchPos.x, touchPos.y)){
                if ((TimeUtils.nanoTime() - time) > 400000000){
                    time = TimeUtils.nanoTime();
                    sendtorender = "";
                    s += 1;

                }

            }
            if(uphealth.contains(touchPos.x, touchPos.y)){
                if(game.coin >= game.maxhealth/5){
                    game.coin -= game.maxhealth/5;
                }
            }
            if(upmana.contains(touchPos.x, touchPos.y)){
                if(game.coin >= game.maxmana/5){
                    game.coin -= game.maxmana/5;
                }
            }
            if(upattack.contains(touchPos.x, touchPos.y)){
                if(game.coin >= (game.modattack+1)* 5){
                    game.coin -= (game.modattack+1)* 5;
                }
            }
            if(updef.contains(touchPos.x, touchPos.y)){
                if(game.coin >= (game.moddef+1)* 5){
                    game.coin -= (game.moddef+1)* 5;
                }
            }
            if(upcontrol.contains(touchPos.x, touchPos.y)){
                if(game.coin >= (game.modcontrol+1)* 5){
                    game.coin -= (game.modcontrol+1)* 5;
                }
            }
            if(exit.contains(touchPos.x, touchPos.y)){
                dispose();
                Gdx.app.exit();
            }

        }
        System.gc();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void resume() {
        System.out.println("resume");
    }

    @Override
    public void hide() {
        System.out.println("hide");
    }

    @Override
    public void dispose() {
        fonsprite.dispose();
        buttonstartsprite.dispose();
        buttodialogsprite.dispose();
        uphealthsprite.dispose();
        upmanasprite.dispose();
        upattacksprite.dispose();
        updefsprite.dispose();
        upcontrolsprite.dispose();
        exitsprite.dispose();
        thealth.dispose();
        tmana.dispose();
        tattack.dispose();
        tdef.dispose();
        tcontrol.dispose();
        tcoin.dispose();
        //lb.disp();

    }


}
