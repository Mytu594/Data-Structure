package reference;

import Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @ Author     锛歽anbin
 * @ Date       锛欳reated in 10:13 2018/8/29
 * @ Description锛歵his is a class and created by yanbin
 * @ Modified By锛歽anbin
 * @Version: 1.0
 */

public class QueueController {

    /**
     * 瀹㈡埛鍙栧彿
     */
    @RequestMapping("getNumber")
    @ResponseBody
    public String getNumber(){
        UUID number= UUID.randomUUID();
        Customer customer=new Customer();
        return "";
    }

    /**
     * 宸ヤ綔浜哄憳鍙彿
     */
    @RequestMapping("work")
    @ResponseBody
    public String work(){

        return "";
    }
}
