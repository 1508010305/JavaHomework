/**
 * 
 */
package jingchang;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��1��
 * @class   HandleKeyboardEvent.java
 ****************************************
 */
//���������߶�
//�����ļ���HandleKeyboardEvent.java

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
   addKeyListener(this);              //ע���¼�������

   setBackground(Color.white);        //�趨������ɫ

   AppletWidth  = getSize().width;    //ȡ��Applet�ĸ߶�
   AppletHeight = getSize().height;   //ȡ��Applet�Ŀ��
   sx = 0;

   //ȡ��ͼ��
   MT           = new MediaTracker(this);
   for(int i=0;i<5;i++)
   {
      character = getImage(getDocumentBase(),"Images/CHARACTER.GIF");
      
      MT.addImage(character,0);
   }
  
   try
   {
      showStatus("ͼ�������(Loading Images)...");
      MT.waitForAll();
   }
   catch(InterruptedException E){ }   //û�н����쳣����
   
   //�����λ���
   OffScreen     = createImage(AppletWidth,AppletHeight);
   drawOffScreen = OffScreen.getGraphics();
   
   ImageWidth    = character.getWidth(this) / 3;       //ͼ��ĸ߶�
   ImageHeight   = character.getHeight(this) / 4;      //ͼ��Ŀ��
   ImageX        = (AppletWidth - ImageWidth) / 3; //ͼ���X����
   ImageY        = (AppletHeight - ImageHeight) / 3;     //ͼ���Y����

   drawOffScreen.clearRect(0,0,AppletWidth,AppletHeight);
   drawOffScreen.drawImage(character,ImageX,ImageY,ImageX+72,ImageY+93,
                              0, 0, 24, 31,this);
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

//=====ʵ��KeyListener����==========================================
public void keyTyped(KeyEvent e)  { }

public void keyPressed(KeyEvent e)
{
   key = e.getKeyCode();

   // ����λ���
   drawOffScreen.clearRect(0,0,AppletWidth,AppletHeight);
  
   if(key == KeyEvent.VK_RIGHT)
   {
      drawOffScreen.drawImage(character,ImageX,ImageY,ImageX+72,ImageY+93,
                              sx, 31, sx+24, 62,this);
      
      repaint();
      // �����߶�
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
      // �����߶�
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
      // �����߶�
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
      // �����߶�
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
