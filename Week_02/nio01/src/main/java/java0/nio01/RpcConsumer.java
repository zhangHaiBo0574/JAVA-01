package java0.nio01;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RpcConsumer {
    public static void main(String[] args) throws Exception{
      //  HttpOutboundHandler http = new HttpOutboundHandler("http://localhost:8801/");


        //初始化参数列表和返回值取值列表
       /* Map<String, String> paramMap = new LinkedHashMap<String, String>() {{
        }};
        List<String> returnParamList = new ArrayList<String>() {{
           // add("Content");
        }};        //调用工具类
        Map<String, String> ret = RpcHttpUtil.invokeHttp(                "http://localhost:8801/",
                RpcHttpUtil.GET, paramMap, returnParamList);
        System.out.println(returnParamList);*/

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8801");

        httpGet.addHeader("Accept","text/html, application/xhtml+xml, */*");
        httpGet.addHeader("Accept-Language","zh-CN,en-US;q=0.5");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
        httpGet.addHeader("Accept-Encoding","gzip, deflate");
        httpGet.addHeader("Host","localhost:8801");
        httpGet.addHeader("Connection","Keep-Alive");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        InputStream inputStream = httpResponse.getEntity().getContent();
        System.err.println("从服务器端获取的内容为：" + EntityUtils.toString(httpResponse.getEntity()));

    }
}
