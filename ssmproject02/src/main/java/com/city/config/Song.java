package com.city.config;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Song {
    public static final String APP_ID="20169357";
    public static final String API_KEY="9tfs2bo4kzoexU74WbEGCEO1";
    public static final String SECRET_KEY="HvOvi2fz5nb34PkrkgnG8jyBUR9aLbMq";

    public static void main(String[] args) {
        Song.song("你好","sound1");
    }

    public static void song(String text,String filename) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 设置可选参数
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "4");
        options.put("pit", "7");
        options.put("per", "4");
        options.put("vol","15");
        // 调用接口
        TtsResponse res = client.synthesis(text, "zh", 1, options);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, "D:\\workspace\\images\\"+filename+".mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }
    }
}
