package com.life.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class LifeGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	Life l;
	int bw;
	int bh;
	int lh;
	int lw;
	double time;

	@Override
	public void create() {
		lh = 100;
		lw = 100;
		
		time = 0.2;
		
		l = new Life(lh, lw);
		l.initRandom();
		bw = Gdx.graphics.getWidth() / lw;
		bh = Gdx.graphics.getHeight() / lh;

		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();

		Gdx.graphics.setContinuousRendering(false);
		Timer.schedule(new Task(){
            @Override
            public void run() {
                l.step();
                Gdx.graphics.requestRendering();
            }
        }
        , (float) time        //    (delay)
        , (float) time     //    (seconds)
    );
		
	
	
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(0, 0, 0, 0);
		
		float w = 0,h = 0;
		for(int i = 0; i<l.getBoard().length;i++){
			for(int j = 0; j< l.getBoard().length; j++){
				if(l.getBoard()[i][j] == 1){
					shapeRenderer.rect(w,h,bw,bh);
					
				}
				w += bw;
				//System.out.println(w);
			}
			h += bh;
			w = 0;
		}
		
		shapeRenderer.end();

	}

}
