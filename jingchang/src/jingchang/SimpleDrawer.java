/**
 * 
 */
package jingchang;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��1��
 * @class   SimpleDrawer.java
 ****************************************
 */
//���򣺼򵥵Ļ�ͼ��Ϸ
//�����ļ���SimpleDrawer.java

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
   addMouseListener(this);            //ע���¼�������
   addMouseMotionListener(this);   

   setBackground(Color.white);        //�趨����Ϊ��ɫ

   AppletWidth   = getSize().width;   //ȡ��Applet�ĸ߶�
   AppletHeight  = getSize().height;  //ȡ��Applet�Ŀ��

   drawCursor    = new Cursor(Cursor.CROSSHAIR_CURSOR);
   eraseCursor   = new Cursor(Cursor.HAND_CURSOR);

   //�����λ���
   OffScreen     = createImage(AppletWidth,AppletHeight);
   drawOffScreen = OffScreen.getGraphics();

   showStatus("�뿪ʼ��ͼ...");
}

public void paint(Graphics g)
{
   //���λ���������������
   g.drawImage(OffScreen,0,0,this);
}

public void update(Graphics g)        //update()����
{
   paint(g);                          //ֻ��������paint()����
}

//=====ʵ��MouseListener����=======================================
public void mouseExited(MouseEvent e)      //����뿪Component
{
   showStatus("��ͼ��������...");
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
   setCursor(drawCursor);
   showStatus("�뿪ʼ��ͼ...");
}

public void mousePressed(MouseEvent e)     //��갴��������
{
   //��������������mousePressed�¼��Ļ�
   if((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0)
   {
      //����һ�������߶ȸ�Ϊ1��ʵ�ľ���
      drawX = e.getX();
      drawY = e.getY();
      drawOffScreen.fillRect(drawX,drawY,1,1);
      repaint();
   }
}

public void mouseReleased(MouseEvent e)    //��갴���ſ�
{
   showStatus("����" + e.getClickCount() + "��");  
}

//=====ʵ��MouseMotionListener����=================================
public void mouseMoved(MouseEvent e)       //����ƶ�ʱ
{
   if(e.isShiftDown())                     //�����ϰ���shift��
   {
      setCursor(eraseCursor);        

      //��Ϊ��Ƥ���Ĺ���
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

public void mouseDragged(MouseEvent e)     //�����ҷʱ 
{
   //����ǰ��������ҷ�Ļ�
   if((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0)
   {
      //���ƴ�����
      drawOffScreen.fillRect(drawX-3,drawY-3,6,6);
      drawX = e.getX();
      drawY = e.getY();
      repaint();
   }
}
}
