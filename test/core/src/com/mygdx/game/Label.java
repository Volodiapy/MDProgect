package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Label{
    private float lx;
    private float ly;
    private float lwidth;
    private float lheight;
    private float color1;
    private float color2;
    private float color3;
    private float color4;
    private float bwidth;
    private float bheight;
    private String[] text;
    SpriteBatch[] words;
    TextureAtlas.AtlasRegion[] texturewords;
    ForMyScreens gm;
    public Label(ForMyScreens game, String txt, float posx, float posy, float poswidth, float posheight, float col1, float col2, float col3, float col4, float posbwidth, float posbheight){
        gm = game;
        lx = posx;
        ly = posy;
        lwidth = poswidth;
        lheight = posheight;
        color1 = col1;
        color2 = col2;
        color3 = col3;
        color4 = col4;
        bwidth = posbwidth;
        bheight = posbheight;
        text = txt.split("");
        words = new SpriteBatch[text.length];
        texturewords = new TextureAtlas.AtlasRegion[text.length];
        for (int i =0; i < text.length; i++){
//                SpriteBatch newsprite = new SpriteBatch();
//                newsprite.setProjectionMatrix(camera.combined);
            words[i] = new SpriteBatch();
            words[i].setProjectionMatrix(gm.camera.combined);
            words[i].setColor(color1, color2, color3, color4);

            switch (text[i]) {
                case "а":
                    texturewords[i] = gm.atlas.findRegion("plus");
                    break;
                case "б":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "в":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "г":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "д":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "е":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "ё":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ж":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "з":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "и":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "й":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "к":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "л":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "м":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "н":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "о":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "п":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "р":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "с":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "т":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "у":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ф":
                    texturewords[i] = gm.atlas.findRegion("darkball1");
                    break;
                case "х":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ц":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ч":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ш":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "щ":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ъ":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ы":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ь":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "э":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "ю":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "я":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case ",":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case ".":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case "(":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                case ")":
                    texturewords[i] = gm.atlas.findRegion("darkball2");
                    break;
                default:
                    texturewords[i] = gm.atlas.findRegion("pustota");
                    break;
            }

        }
    }
    public void rend(){
        float lychange = 0;
        float lxchange = 0;
        for (int i =0; i < words.length; i++){
            lxchange += bwidth;
            words[i].begin();
            words[i].draw(texturewords[i], lx+lxchange, ly+lychange, bwidth, bheight);
            words[i].end();
            if (lx+ lxchange >= lwidth){
                lychange -= bheight;
                lxchange = 0;

            }
        }
    }
    public void disp(){
        for (int i =0; i < words.length; i++){
            words[i].dispose();
        }
    }
}
