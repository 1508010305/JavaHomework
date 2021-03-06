/**
 * 
 */
package jingchang;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月1日
 * @class   UseMyCursor.java
 ****************************************
 */
//程序：使用自订光标
//范例文件：UseMyCursor.java

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class UseMyCursor extends Applet 
          implements MouseListener,MouseMotionListener
{
int      AppletWidth,AppletHeight,drawX,drawY;
Image        MyCursor1,MyCursor2;
Cursor       myCursor1,myCursor2;
Toolkit      TK;
MediaTracker MT;
Image    OffScreen;
Graphics drawOffScreen;

public void init()
{
   addMouseListener(this);            //注册事件处理方法
   addMouseMotionListener(this);   

   TK        = getToolkit();          //取得Toolkit

   //取得自订光标图像
   MyCursor1 = getImage(getDocumentBase(),"Images/hammer1.gif");
   MyCursor2 = getImage(getDocumentBase(),"Images/hammer2.gif");
   MT        = new MediaTracker(this); 
   MT.addImage(MyCursor1,0);
   MT.addImage(MyCursor2,0);

   AppletWidth   = getSize().width;   //取得Applet的高度
   AppletHeight  = getSize().height;  //取得Applet的宽度

   OffScreen     = createImage(AppletWidth,AppletHeight);
   drawOffScreen = OffScreen.getGraphics();

   try
   {
      MT.waitForAll();
   }
   catch(InterruptedException E){ }   //没有进行异常处理    

   //建立新游标
   try
   {
      myCursor1 = TK.createCustomCursor(MyCursor1,new Point(0,0),"hammer1"); 
      myCursor2 = TK.createCustomCursor(MyCursor2,new Point(0,0),"hammer2");   
   }
   catch(IndexOutOfBoundsException E){ }

   setCursor(myCursor1);              //设定使用新光标
}

public void update(Graphics g)        //update()方法
{
   paint(g);                          //只单纯调用paint()方法
}

public void paint(Graphics g)
{
   //将次画面贴到主画面中
   g.drawImage(OffScreen,0,0,this);
}


//=====实现MouseListener界面=======================================

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

public void mousePressed(MouseEvent e)     //鼠标按键被按下
{
   setCursor(myCursor2);
   //如果是左键产生的mousePressed事件的话
   if((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0)
   {
      drawX = e.getX();
      drawY = e.getY();
      drawOffScreen.drawOval(drawX+20,drawY+30,1,1);
      drawOffScreen.drawOval(drawX+15,drawY+25,10,10);
      drawOffScreen.drawOval(drawX+10,drawY+20,20,20);
      repaint();
   }
}

public void mouseExited(MouseEvent e){ }   //鼠标离开Component
  
 public void mouseEntered(MouseEvent e){ }  //鼠标进入Component
 
 public void mouseReleased(MouseEvent e)    //鼠标按键放开
 {
    setCursor(myCursor1);
 }

 //=====实现MouseMotionListener界面================================
 public void mouseMoved(MouseEvent e)       //鼠标移动时
 {
    drawX = e.getX();
    drawY = e.getY();
    showStatus("(" + e.getX() + "," + e.getY() + ")");
 }  

 public void mouseDragged(MouseEvent e){ }  //鼠标拖曳时 
}
                                                                                     
