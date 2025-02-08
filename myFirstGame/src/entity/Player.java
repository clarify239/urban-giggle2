package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyInput;

public class Player extends Entity{
	GamePanel gp;
	KeyInput keyI;
	
	public Player(GamePanel gp, KeyInput keyI) {
		this.gp = gp;
		this.keyI = keyI;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/player/up.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/player/left.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/right.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/down.png"));

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyI.upPressed == true) {
			direction = "up";
			y -=speed;
		}
		if(keyI.downPressed == true) {
			direction = "down";
			y +=speed;
		}
		if(keyI.leftPressed == true) {
			direction = "left";
			x -=speed;
		}
		if(keyI.rightPressed == true) {
			direction = "right";
			x +=speed;
		}
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			image = up;
			break;
		case "down":
			image = down;
			break;
		case "left":
			image = left;
			break;
		case "right":
			image = right;
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}
