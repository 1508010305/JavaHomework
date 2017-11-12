/**
 * 
 */
package jingchang;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月1日
 * @class   HandleKeyboardEvent.java
 ****************************************
 */
//程序：人物走动
//范例文件：HandleKeyboardEvent.java

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class HandleKeyboardEvent extends Applet 
          implements KeyListener
{
int          ImageWidth,ImageHeight,ImageX,ImageY,AppletWidth,
             AppletHeight,key;
int sx;
Image        character,OffScreen;
Thread       newThread;
Graphics     drawOffScreen; 
MediaTracker MT;

public void init()
{
   addKeyListener(this);              //注册事件处理方法

   setBackground(Color.white);        //设定背景颜色

   AppletWidth  = getSize().width;    //取得Applet的高度
   AppletHeight = getSize().height;   //取得Applet的宽度
   sx = 0;

   //取得图像
   MT           = new MediaTracker(this);
   for(int i=0;i<5;i++)
   {
      character = getImage(getDocumentBase(),"Images/CHARACTER.GIF");
      
      MT.addImage(character,0);
   }
  
   try
   {
      showStatus("图像加载中(Loading Images)...");
      MT.waitForAll();
   }
   catch(InterruptedException E){ }   //没有进行异常处理
   
   //建立次画面
   OffScreen     = createImage(AppletWidth,AppletHeight);
   drawOffScreen = OffScreen.getGraphics();
   
   ImageWidth    = character.getWidth(this) / 3;       //图像的高度
   ImageHeight   = character.getHeight(this) / 4;      //图像的宽度
   ImageX        = (AppletWidth - ImageWidth) / 3; //图像的X坐标
   ImageY        = (AppletHeight - ImageHeight) / 3;     //图像的Y坐标

   drawOffScreen.clearRect(0,0,AppletWidth,AppletHeight);
   drawOffScreen.drawImage(character,ImageX,ImageY,ImageX+72,ImageY+93,
                              0, 0, 24, 31,this);
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

//=====实现KeyListener界面==========================================
public void keyTyped(KeyEvent e)  { }

public void keyPressed(KeyEvent e)
{
   key = e.getKeyCode();

   // 清除次画面
   drawOffScreen.clearRect(0,0,AppletWidth,AppletHeight);
  
   if(key == KeyEvent.VK_RIGHT)
   {
      drawOffScreen.drawImage(character,ImageX,ImageY,ImageX+72,ImageY+93,
                              sx, 31, sx+24, 62,this);
      
      repaint();
      // 人物走动
      ImageX += 2;
      sx += 24;
      if(sx > 48)
          sx = 0;

   }
   else if(key == KeyEvent.VK_LEFT)
   {
      drawOffScreen.drawImage(character,ImageX,ImageY,ImageX+72,ImageY+93,
                              sx, 93, sx+24, 124,this);
      repaint();
      // 人物走动
      ImageX -= 2;
      sx += 24;
      if(sx > 48)
          sx = 0;
   }
   else if(key == KeyEvent.VK_UP)
   {
      drawOffScreen.drawImage(character,ImageX,ImageY,ImageX+72,ImageY+93,
                              sx, 0, sx+24, 31,this);
      repaint();
      // 人物走动
      ImageY -= 2;
      sx += 24;
      if(sx > 48)
          sx = 0;
   }
   else if(key == KeyEvent.VK_DOWN)
   {
      drawOffScreen.drawImage(character,ImageX,ImageY,ImageX+72,ImageY+93,
                              sx, 62, sx+24, 93,this);
      repaint();
      // 人物走动
      ImageY += 2;
      sx += 24;
      if(sx > 48)
          sx = 0;
   }
}

public void keyReleased(KeyEvent e)
{
    sx = 0;
}
}
