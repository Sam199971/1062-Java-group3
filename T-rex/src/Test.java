import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;
 
 
public class Test extends JFrame implements KeyListener{
 
    JLabel jb;
    JPanel jp;
    int x=200,y=200;
    int increment=10;
    public static void main(String[] args) {
        // TODO Auto-generated method stub   
        Test ts=new Test();
    }
    public Test()
    {
 
        jb=new JLabel("java 程序设计");
        //jb.addActionListener(this);
        jp=new JPanel();
        jb.setLocation(x, y);
        jp.add(jb);
        this.add(jp);
        this.setSize(500,500);
        this.setVisible(true);
        this.addKeyListener(this);//没有添加事件监听器
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
 
        // TODO Auto-generated method stub
        switch(e.getKeyCode())  
        {   
            case KeyEvent.VK_LEFT:  
                x-=increment;//这里要同时更改标签的横纵坐标
                break ;  
            case KeyEvent.VK_RIGHT:  
                x+=increment;
                break ;  
 
            case KeyEvent.VK_UP:  
                y-=increment;
                break;  
 
            case KeyEvent.VK_DOWN:  
                y+=increment;
                break;  
        }
        jb.setLocation(x,y);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
}