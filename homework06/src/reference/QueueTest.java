package reference;

import java.util.Random;
import java.util.UUID;

/**
 * @ Author     ：yanbin
 * @ Date       ：Created in 10:23 2018/8/29
 * @ Description：this is a class and created by yanbin
 * @ Modified By：yanbin
 * @Version: 1.0
 */
public class QueueTest {

    public static void main(String[] args) {
        Manager manager=new Manager();//初始化队列管理器
       new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i = 0; i <100 ; i++) {
                   Integer type=0;
                    if(i%2==0){
                        type=1;
                    }
                    Customer customer=new Customer();
                    customer.setType(type);
                   customer.setNumber(new Integer(i).toString());
                       manager.publish(customer);

               }
           }
       }).start();
        NormalWindow normalWindow1=new NormalWindow();
        normalWindow1.setWinType(1);
        NormalWindow normalWindow2=new NormalWindow();
        normalWindow2.setWinType(0);
        manager.addWindow(normalWindow1);
        manager.addWindow(normalWindow2);
      new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               for (int i = 0; i <200; i++) {
                 Customer vip=  manager.getVips().get(0).getQueue(manager.getVips().get(0).getWinType());
                   if(vip!=null){
                       System.out.println("您即将为"+vip.getNumber()+"办理业务，该客户为"+(vip.getType()==1?"VIP":"普通"));
                       System.out.println("正在办理........");
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println("办理成功！请继续叫号");
                   }else{
                       System.out.println("暂无客户办理VIP业务，你可以去睡觉了");
                   }

                   Customer normal=  manager.getNormals().get(0).getQueue(manager.getNormals().get(0).getWinType());
                   if(normal!=null){
                       System.out.println("您即将为"+normal.getNumber()+"办理业务，该客户为"+(normal.getType()==1?"VIP":"普通"));
                       System.out.println("正在办理........");
                       try {
                           Thread.sleep(2000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println("办理成功！请继续叫号");
                   }else{
                       System.out.println("暂无普通客户办理业务，你可以去吸烟了");
                   }
               }
           }
       }).start();

    }
}
