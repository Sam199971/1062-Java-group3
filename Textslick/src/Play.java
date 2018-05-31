
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{

Animation mychar, movingUp, movingDown, movingLeft, movingRight;
Image worldMap;
boolean quit = false;
int[] duration = {200,200};
float mycharPositionX = 0;
float mycharPositionY = 0;
float shiftX = mycharPositionX + 320;
float shiftY = mycharPositionY + 160;
public Play(int state){
}
public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
worldMap = new Image("res/world.png");
Image[] walkUp = {new Image("res/buckysBack.png"), new Image("res/buckysBack.png")};
Image[] walkDown = {new Image("res/buckysFront.png"), new Image("res/buckysFront.png")};
Image[] walkLeft = {new Image("res/buckysLeft.png"), new Image("res/buckysLeft.png")};
Image[] walkRight = {new Image("res/buckysRight.png"), new Image("res/buckysRight.png")};
movingUp = new Animation(walkUp, duration, false);
movingDown = new Animation(walkDown, duration, false);
movingLeft = new Animation(walkLeft, duration, false);
movingRight = new Animation(walkRight, duration, false);
mychar = movingDown;
}
public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
worldMap.draw(mycharPositionX,mycharPositionY);
mychar.draw(shiftX,shiftY);
g.drawString(" X: "+mycharPositionX+"\n Y: "+mycharPositionY, 400, 20);
if(quit==true){
g.drawString("Resume (R)", 250, 100);
g.drawString("Main Menu (M)", 250, 150);
g.drawString("Quit Game (Q)", 250, 200);
if(quit==false){
g.clear();
}
}
}
public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
Input input = gc.getInput();
if(input.isKeyDown(Input.KEY_UP)){
mychar = movingUp;
mycharPositionY += delta * .1f;
if(mycharPositionY>162){// → 設置限制，當主角向上移動超過背景時不能移動
mycharPositionY -= delta * .1f;
}
}
if(input.isKeyDown(Input.KEY_DOWN)){
mychar = movingDown;
mycharPositionY -= delta * .1f;
if(mycharPositionY<-600){ //→ 設置限制，當主角向下移動超過背景時不能移動
mycharPositionY += delta * .1f;
}
}
if(input.isKeyDown(Input.KEY_LEFT)){
mychar = movingLeft;
mycharPositionX += delta * .1f;
if(mycharPositionX>324){ //→ 設置限制，當主角移動向左超過背景時不能移動
mycharPositionX -= delta * .1f;
}
}
if(input.isKeyDown(Input.KEY_RIGHT)){
mychar = movingRight;
mycharPositionX -= delta * .1f;
if(mycharPositionX<-840){// → 設置限制，當主角移動向右超過背景時不能移動
mycharPositionX += delta * .1f;
}
}
}
public int getID(){
return 1;
}
}