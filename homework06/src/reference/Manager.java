package reference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ Author     ：yanbin
 * @ Date       ：Created in 8:51 2018/8/29
 * @ Description：this is a class and created by yanbin
 * @ Modified By：yanbin
 * @Version: 1.0
 */
public class Manager {
    //普通窗口
    private  List<NormalWindow> normals=new ArrayList<NormalWindow>();
    //VIP窗口
    private  List<NormalWindow> vips=new ArrayList<NormalWindow>();
    //普通客户队列
    private  BlockingQueue<Customer> normalsCus=new ArrayBlockingQueue<Customer>(20,true);
    //VIP客户队列
    private  BlockingQueue<Customer> VipsCus=new ArrayBlockingQueue<Customer>(20,true);

    public  List<NormalWindow> getNormals() {
        return normals;
    }

    public  List<NormalWindow> getVips() {
        return vips;
    }

    public  BlockingQueue<Customer> getNormalsCus() {
        return normalsCus;
    }

    public  BlockingQueue<Customer> getVipsCus() {
        return VipsCus;
    }

    /**
     * 服务端要发布，需要有人订阅   这里是订阅方法
     */
    public void addWindow(NormalWindow normalWindow){
        System.out.println((normalWindow.getWinType()==1?"VIP":"普通")+"窗口启动了");
        if(normalWindow.getWinType()==1){//VIP窗口
            vips.add(normalWindow);
    }else{
            normals.add(normalWindow);
        }
    }
    /**
     * 有订阅 就要有退订
     */
    public void deleteWindow(NormalWindow normalWindow){
        if(normalWindow.getWinType()==1){
          Integer index= vips.indexOf(normalWindow);
          if(index>=0){
              vips.remove(normalWindow);
          }
        }else{
            Integer index= normals.indexOf(normalWindow);
            if(index>=0){
                normals.remove(normalWindow);
            }
        }

    }

    /**
     * 客户挂号 服务端进行分发，分发给谁呢？
     */
    public  void publish(Customer customer){
        System.out.println("客户取号了，号码为："+customer.getNumber()+"，客户类型为："+(customer.getType()==1?"VIP":"普通")+"客户");
        if(customer.getType()==1){//VIP 客户
            try {
                VipsCus.put(customer);
            } catch (InterruptedException e) {
                System.out.println("队列中已满，请稍等");
            }
            notifyWindow(vips,1);
        }else{//普通客户
            try {
                normalsCus.put(customer);
            } catch (InterruptedException e) {
                System.out.println("队列中已满，请稍等");
            }
            notifyWindow(normals,0);
        }

    }
    /**
     * 消息发布
     */
    public  void notifyWindow(List<NormalWindow> windows,Integer type){
        BlockingQueue<Customer> tempQueue=null;
        tempQueue=type==1?VipsCus:normalsCus;
        if(windows!=null&&windows.size()>0){
            for (int i = 0; i <windows.size() ; i++) {
                windows.get(i).updateQueue(tempQueue,type);
            }
        }


    }
}
