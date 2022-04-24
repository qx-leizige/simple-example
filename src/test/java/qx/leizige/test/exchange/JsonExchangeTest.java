package qx.leizige.test.exchange;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import qx.leizige.exchange.JsonExchange;
import qx.leizige.test.BaseTest;

import java.util.HashMap;
import java.util.Map;

public class JsonExchangeTest extends BaseTest {

    private static String sourceJson = "{" +
            "A:\"V-A\","+
            "B:[" +
            "{B1:\"V-B11\",B2:\"V-B21\"},"+
            "{ B1:\"V-B12\",B2:\"V-B22\"}],"+
            "C:[" +
            "{C1:[{C11:\"V-C111\",C12:\"V-C121\"},{C11:\"V-C112\",C12:\"V-C122\"}]},"+
            "{C1:[{C11:\"V-C211\",C12:\"V-C221\"},{C11:\"V-C212\",C12:\"V-C222\"}]}]"+
            "}";

    @Test
    public void test(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","A");
        map.put("b[1].b1","B[].B1");
        //层级合并
        map.put("c.c1","C.C1.C11");
        //部分层级合并
        map.put("d.d1[1].d12","C.C1[].C11");
        //层级重组
        map.put("e[2].e1[1].e12","C[].C1[].C11");
        JSONObject jobj = JSON.parseObject(sourceJson);
        System.out.println(JsonExchange.exchangeJson(jobj,map).toJSONString());

    }


}
