/**
 * 
 */
package jingchang;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月1日
 * @class   HandleMouseEvent.java
 ****************************************
 */
//程序：处理鼠标事件
//范例文件：HandleMouseEvent.java

import java.awt.*;
import java.applet.*;
import java.awt.event.*;   //为了处理事件

//除了Runnable之外，还实现了MouseListener及MouseMotionListener
public class HandleMouseEvent extends Applet 
          implements Runnable,MouseListener,MouseMotionListener
{
int          AppletWidth,AppletHeight,hammerX,hammerY,
             hammerWidth,hammerHeight,clickCount;
Image        hammer1,hammer2,OffScreen,currentHammer;
Thread       newThread;
boolean      showHammer;
Graphics     drawOffScreen;
MediaTracker MT;

public void init()
{  
   addMouseListener(this);            //注册事件处理方法
   addMouseMotionListener(this);   

   setBackground(Color.white);         //设定背景颜色
 
   AppletWidth  = getSize().width;    //取得Applet的高度
   AppletHeight = getSize().height;   //取得Applet的宽度
   clickCount   = 0;                  //mouseClick事件发生的次数
   
   //取得铁锤图像
   hammer1      = getImage(getDocumentBase(),"IMAGES\\HAMMER1.GIF");
   hammer2      = getImage(getDocumentBase(),"IMAGES\\HAMMER2.GIF");

   MT           = new MediaTracker(this); 
   MT.addImage(hammer1,0);
   MT.addImage(hammer2,0);
   
   try
   {
      showStatus("图像加载中(Loading Images)...");
      MT.waitForAll();
   }
   catch(InterruptedException E){ }   //没有进行异常处理
   
   hammerWidth   = hammer1.getWidth(this);   //取得铁锤图像宽度
   hammerHeight  = hammer1.getHeight(this);  //取得铁锤图像高度
   currentHammer = hammer1;                  //使用铁锤图像1
   showHammer    = false;                    //先不显示铁锤

   //建立次画面
   OffScreen     = createImage(AppletWidth,AppletHeight);
   drawOffScreen = OffScreen.getGraphics();
}

public void start()                   //start()方法  
{
   newThread = new Thread(this);      //建立与启动新线程
   newThread.start();
}

public void stop()                    //stop()方法
{
   newThread = null;                  //将线程设为null
}

public void paint(Graphics g)
{
   //清除次画面
   drawOffScreen.clearRect(0,0,AppletWidth,AppletHeight);

   //绘制铁锤图像
   if(showHammer)
      drawOffScreen.drawImage(currentHammer,hammerX,hammerY,this);

   //将次画面贴到主画面中
   g.drawImage(OffScreen,0,0,this);
}

public void update(Graphics g)        //update()方法
{
   paint(g);                          //只单纯调用paint()方法
}

public void run()
{  
   while(newThread != null)           //动画循环
   {  
      repaint();                      //重新绘制图像

      try
      {
         Thread.sleep(80);            //暂停程序执行80毫秒
      }
      catch(InterruptedException E){ }//没有进行异常处理
   }
}

//=====实现MouseListener界面========================================
public void mouseExited(MouseEvent e)      //鼠标离开Component
{
   if(showHammer) showHammer = false;      //不绘制铁锤
}

public void mouseClicked(MouseEvent e)     //鼠标按键被按下后放开
{
   showStatus("挥动铁锤" + (++clickCount) + "次");
}

public void mouseEntered(MouseEvent e)     //鼠标进入Component
{
   if(!showHammer) showHammer = true;      //绘制铁锤
}

public void mousePressed(MouseEvent e)     //鼠标按键被按下
{
   currentHammer = hammer2;                //绘制铁锤图像2
}

public void mouseReleased(MouseEvent e)    //鼠标按键放开
{
   currentHammer = hammer1;                //绘制铁锤图像1
}

//=====实现MouseMotionListener界面==================================
public void mouseMoved(MouseEvent e)       //鼠标移动时
{
   //设定铁锤图像的坐标
   hammerX = e.getX() - (hammerWidth / 2);
   hammerY = e.getY() - (hammerHeight / 2);

   //碰到边界时的状态
   if(hammerX <= 0) 
      hammerX = 0;
   if(hammerX >= (AppletWidth - hammerWidth))
      hammerX = AppletWidth - hammerWidth;
   if(hammerY <= 0)
      hammerY = 0;
   if(hammerY >= (AppletHeight - hammerHeight))
      hammerY = AppletHeight - hammerHeight;

   showStatus("(" + hammerX + "," + hammerY + ")");
}  

public void mouseDragged(MouseEvent e)     //鼠标拖曳时 
{
   //设定铁锤图像的坐标
   hammerX = e.getX() - (hammerWidth / 2);
   hammerY = e.getY() - (hammerHeight / 2);

   //碰到边界时的状态
   if(hammerX <= 0) 
      hammerX = 0;
   if(hammerX >= (AppletWidth - hammerWidth))
      hammerX = AppletWidth - hammerWidth;
   if(hammerY <= 0)
      hammerY = 0;
   if(hammerY >= (AppletHeight - hammerHeight))
      hammerY = AppletHeight - hammerHeight;

   showStatus("(" + hammerX + "," + hammerY + ")");
}
}
                                        
