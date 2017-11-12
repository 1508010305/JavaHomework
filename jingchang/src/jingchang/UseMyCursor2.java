/**
 * 
 */
package jingchang;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��1��
 * @class   UseMyCursor2.java
 ****************************************
 */
//���򣺼�������
//�����ļ���UseMyCursor2.java

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class UseMyCursor2 extends Applet 
          implements MouseListener,MouseMotionListener
{
int      AppletWidth,AppletHeight,drawX,drawY;
Image        MyCursor1,MyCursor2;
Cursor       myCursor1,myCursor2;
Toolkit      TK;
MediaTracker MT;
Image    OffScreen;
Graphics drawOffScreen;

AudioClip    A1,A2,A3;

public void init()
{
   //A1����������ʱ������,A2�������ƶ�ʱ������,
//A3����������Appletʱ������
   A1        = getAudioClip(getDocumentBase(),"Audio/audio1.au");
   A2        = getAudioClip(getDocumentBase(),"Audio/audio2.au");
   A3        = getAudioClip(getDocumentBase(),"Audio/audio3.au");

   addMouseListener(this);            //ע���¼�������
   addMouseMotionListener(this);   

   TK        = getToolkit();          //ȡ��Toolkit

   //ȡ���Զ����ͼ��
   MyCursor1 = getImage(getDocumentBase(),"Images/hammer1.gif");
   MyCursor2 = getImage(getDocumentBase(),"Images/hammer2.gif");
   MT        = new MediaTracker(this); 
   MT.addImage(MyCursor1,0);
   MT.addImage(MyCursor2,0);

   AppletWidth   = getSize().width;   //ȡ��Applet�ĸ߶�
   AppletHeight  = getSize().height;  //ȡ��Applet�Ŀ��

   OffScreen     = createImage(AppletWidth,AppletHeight);
   drawOffScreen = OffScreen.getGraphics();

   try
   {
      MT.waitForAll();
   }
   catch(InterruptedException E){ }   //û�н����쳣����    

   //�������α�
   try
   {
      myCursor1 = TK.createCustomCursor(MyCursor1,new Point(0,0),"HAMMER1"); 
      myCursor2 = TK.createCustomCursor(MyCursor2,new Point(0,0),"HAMMER2");   
   }
   catch(IndexOutOfBoundsException E){ }

   setCursor(myCursor1);              //�趨ʹ���¹��
}

public void update(Graphics g)        //update()����
{
   paint(g);                          //ֻ��������paint()����
}

public void paint(Graphics g)
{
   //���λ���������������
   g.drawImage(OffScreen,0,0,this);
}

//=====ʵ��MouseListener����=======================================
public void mouseExited(MouseEvent e)      //����뿪Component
{
   A3.stop();    //ֹͣ����
}

public void mouseClicked(MouseEvent e)     //��갴�������º�ſ�
{
   //������Ҽ�������mouseClicked�¼��Ļ�
   if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
   {
      //����λ���
      drawOffScreen.setColor(getBackground());
      drawOffScreen.fillRect(0,0,AppletWidth,AppletHeight);
      drawOffScreen.setColor(getForeground());
      repaint();
   }  
}

public void mouseEntered(MouseEvent e)     //������Component
{
   A3.loop();    //ѭ������
}

public void mousePressed(MouseEvent e)     //��갴��������
{
   setCursor(myCursor2);
   //��������������mousePressed�¼��Ļ�
   if((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0)
   {
      drawX = e.getX();
      drawY = e.getY();
      drawOffScreen.drawOval(drawX+20,drawY+30,1,1);
      drawOffScreen.drawOval(drawX+15,drawY+25,10,10);
      drawOffScreen.drawOval(drawX+10,drawY+20,20,20);
      repaint();
   }
   A1.play();    //����
}

public void mouseReleased(MouseEvent e)    //��갴���ſ�
{
   setCursor(myCursor1);
}

//=====ʵ��MouseMotionListener����=================================
public void mouseMoved(MouseEvent e)       //����ƶ�ʱ
{
   A2.play();    //����
   showStatus("(" + e.getX() + "," + e.getY() + ")");
}  

public void mouseDragged(MouseEvent e){ }  //�����ҷʱ 
}
                                                                                 
