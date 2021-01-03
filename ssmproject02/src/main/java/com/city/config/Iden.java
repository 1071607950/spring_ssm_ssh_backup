package com.city.config;

import com.baidu.aip.ocr.AipOcr;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Iden {
    public static final String APP_ID="20169357";
    public static final String API_KEY="9tfs2bo4kzoexU74WbEGCEO1";
    public static final String SECRET_KEY="HvOvi2fz5nb34PkrkgnG8jyBUR9aLbMq";

    public static void main(String[] args) {
        Iden.sample("a2.jpg");
    }

    public static List sample(String imgName){
        List list = new ArrayList();

        AipOcr client=new AipOcr(APP_ID,API_KEY,SECRET_KEY);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");

        // 参数为本地图片路径
        String image = "D:\\workspace\\images\\"+imgName;
        JSONObject res = client.basicAccurateGeneral(image, options);
        JSONArray array = res.getJSONArray("words_result");
        for (Object o:array){
            JSONObject jsonObject = (JSONObject) o;
            list.add(jsonObject.get("words"));
        }
        return list;
    }
}
