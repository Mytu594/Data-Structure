package reference;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ Author     ：yanbin
 * @ Date       ：Created in 8:48 2018/8/29
 * @ Description：普通窗口
 * @ Modified By：yanbin
 * @Version: 1.0
 */
public class NormalWindow  extends ParentWindow{
    private Integer winType;//窗口类型  0 普通 1  VIP
    //普通客户队列
    private static BlockingQueue<Customer> normalsCus=new ArrayBlockingQueue<Customer>(20,true);
    //VIP客户队列
    private static BlockingQueue<Customer> VipsCus=new ArrayBlockingQueue<Customer>(20,true);
    public void updateQueue(BlockingQueue<Customer> temps,Integer type){
        if(type==1){
            VipsCus=temps;
        }else{
            normalsCus=temps;
        }

    }

    public Integer getWinType() {
        return winType;
    }

    public void setWinType(Integer winType) {
        this.winType = winType;
    }

    public  Customer getQueue(Integer type){
        Customer customer=null;
        if(type==1){
            if(VipsCus!=null&&VipsCus.size()>0){
                customer=VipsCus.poll();
            }else{
                System.out.println("VIP窗口暂无客户挂号");
            }
             if(customer==null){
                 System.out.println("VIP队列为空");
             }
        }else{
            if(normalsCus!=null&&normalsCus.size()>0){
                customer= normalsCus.poll();
            }else{
                System.out.println("普通窗口暂无客户挂号");
            }
            if(customer==null){
                System.out.println("普通队列为空");
            }
        }
        return  customer;
    }
}
