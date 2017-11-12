/**
 * 
 */
package jingchang;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��1��
 * @class   HandleMouseEvent.java
 ****************************************
 */
//���򣺴�������¼�
//�����ļ���HandleMouseEvent.java

import java.awt.*;
import java.applet.*;
import java.awt.event.*;   //Ϊ�˴����¼�

//����Runnable֮�⣬��ʵ����MouseListener��MouseMotionListener
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
   addMouseListener(this);            //ע���¼�������
   addMouseMotionListener(this);   

   setBackground(Color.white);         //�趨������ɫ
 
   AppletWidth  = getSize().width;    //ȡ��Applet�ĸ߶�
   AppletHeight = getSize().height;   //ȡ��Applet�Ŀ��
   clickCount   = 0;                  //mouseClick�¼������Ĵ���
   
   //ȡ������ͼ��
   hammer1      = getImage(getDocumentBase(),"IMAGES\\HAMMER1.GIF");
   hammer2      = getImage(getDocumentBase(),"IMAGES\\HAMMER2.GIF");

   MT           = new MediaTracker(this); 
   MT.addImage(hammer1,0);
   MT.addImage(hammer2,0);
   
   try
   {
      showStatus("ͼ�������(Loading Images)...");
      MT.waitForAll();
   }
   catch(InterruptedException E){ }   //û�н����쳣����
   
   hammerWidth   = hammer1.getWidth(this);   //ȡ������ͼ����
   hammerHeight  = hammer1.getHeight(this);  //ȡ������ͼ��߶�
   currentHammer = hammer1;                  //ʹ������ͼ��1
   showHammer    = false;                    //�Ȳ���ʾ����

   //�����λ���
   OffScreen     = createImage(AppletWidth,AppletHeight);
   drawOffScreen = OffScreen.getGraphics();
}

public void start()                   //start()����  
{
   newThread = new Thread(this);      //�������������߳�
   newThread.start();
}

public void stop()                    //stop()����
{
   newThread = null;                  //���߳���Ϊnull
}

public void paint(Graphics g)
{
   //����λ���
   drawOffScreen.clearRect(0,0,AppletWidth,AppletHeight);

   //��������ͼ��
   if(showHammer)
      drawOffScreen.drawImage(currentHammer,hammerX,hammerY,this);

   //���λ���������������
   g.drawImage(OffScreen,0,0,this);
}

public void update(Graphics g)        //update()����
{
   paint(g);                          //ֻ��������paint()����
}

public void run()
{  
   while(newThread != null)           //����ѭ��
   {  
      repaint();                      //���»���ͼ��

      try
      {
         Thread.sleep(80);            //��ͣ����ִ��80����
      }
      catch(InterruptedException E){ }//û�н����쳣����
   }
}

//=====ʵ��MouseListener����========================================
public void mouseExited(MouseEvent e)      //����뿪Component
{
   if(showHammer) showHammer = false;      //����������
}

public void mouseClicked(MouseEvent e)     //��갴�������º�ſ�
{
   showStatus("�Ӷ�����" + (++clickCount) + "��");
}

public void mouseEntered(MouseEvent e)     //������Component
{
   if(!showHammer) showHammer = true;      //��������
}

public void mousePressed(MouseEvent e)     //��갴��������
{
   currentHammer = hammer2;                //��������ͼ��2
}

public void mouseReleased(MouseEvent e)    //��갴���ſ�
{
   currentHammer = hammer1;                //��������ͼ��1
}

//=====ʵ��MouseMotionListener����==================================
public void mouseMoved(MouseEvent e)       //����ƶ�ʱ
{
   //�趨����ͼ�������
   hammerX = e.getX() - (hammerWidth / 2);
   hammerY = e.getY() - (hammerHeight / 2);

   //�����߽�ʱ��״̬
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

public void mouseDragged(MouseEvent e)     //�����ҷʱ 
{
   //�趨����ͼ�������
   hammerX = e.getX() - (hammerWidth / 2);
   hammerY = e.getY() - (hammerHeight / 2);

   //�����߽�ʱ��״̬
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
                                        
