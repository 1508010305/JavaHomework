/**
 * 
 */
package jingchang;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月1日
 * @class   SimpleDrawer.java
 ****************************************
 */
//程序：简单的绘图游戏
//范例文件：SimpleDrawer.java

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class SimpleDrawer extends Applet 
          implements MouseListener,MouseMotionListener
{
int      AppletWidth,AppletHeight,drawX,drawY;
Image    OffScreen;
Cursor   drawCursor,eraseCursor;
Graphics drawOffScreen;
   
public void init()
{
   addMouseListener(this);            //注册事件处理方法
   addMouseMotionListener(this);   

   setBackground(Color.white);        //设定背景为白色

   AppletWidth   = getSize().width;   //取得Applet的高度
   AppletHeight  = getSize().height;  //取得Applet的宽度

   drawCursor    = new Cursor(Cursor.CROSSHAIR_CURSOR);
   eraseCursor   = new Cursor(Cursor.HAND_CURSOR);

   //建立次画面
   OffScreen     = createImage(AppletWidth,AppletHeight);
   drawOffScreen = OffScreen.getGraphics();

   showStatus("请开始绘图...");
}

public void paint(Graphics g)
{
   //将次画面贴到主画面中
   g.drawImage(OffScreen,0,0,this);
}

public void update(Graphics g)        //update()方法
{
   paint(g);                          //只单纯调用paint()方法
}

//=====实现MouseListener界面=======================================
public void mouseExited(MouseEvent e)      //鼠标离开Component
{
   showStatus("绘图动作结束...");
}

public void mouseClicked(MouseEvent e)     //鼠标按键被按下后放开
{
   //如果是右键产生的mouseClicked事件的话
   if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
   {
      //清除次画面
      drawOffScreen.setColor(getBackground());
      drawOffScreen.fillRect(0,0,AppletWidth,AppletHeight);
      drawOffScreen.setColor(getForeground());
      repaint();
   }   
}

public void mouseEntered(MouseEvent e)     //鼠标进入Component
{
   setCursor(drawCursor);
   showStatus("请开始绘图...");
}

public void mousePressed(MouseEvent e)     //鼠标按键被按下
{
   //如果是左键产生的mousePressed事件的话
   if((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0)
   {
      //绘制一个宽度与高度各为1的实心矩形
      drawX = e.getX();
      drawY = e.getY();
      drawOffScreen.fillRect(drawX,drawY,1,1);
      repaint();
   }
}

public void mouseReleased(MouseEvent e)    //鼠标按键放开
{
   showStatus("按下" + e.getClickCount() + "次");  
}

//=====实现MouseMotionListener界面=================================
public void mouseMoved(MouseEvent e)       //鼠标移动时
{
   if(e.isShiftDown())                     //如果配合按下shift键
   {
      setCursor(eraseCursor);        

      //此为橡皮擦的功能
      drawX = e.getX();
      drawY = e.getY();
      drawOffScreen.setColor(getBackground());
      drawOffScreen.fillRect(drawX - 5,drawY - 5,10,10);
      drawOffScreen.setColor(getForeground());
      repaint();
  }
  else
     setCursor(drawCursor);
}  

public void mouseDragged(MouseEvent e)     //鼠标拖曳时 
{
   //如果是按下左键拖曳的话
   if((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0)
   {
      //绘制粗线条
      drawOffScreen.fillRect(drawX-3,drawY-3,6,6);
      drawX = e.getX();
      drawY = e.getY();
      repaint();
   }
}
}
