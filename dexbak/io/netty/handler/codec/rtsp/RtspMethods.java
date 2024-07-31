package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpMethod;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class RtspMethods {
    public static final HttpMethod ANNOUNCE;
    public static final HttpMethod DESCRIBE;
    public static final HttpMethod GET_PARAMETER;
    public static final HttpMethod OPTIONS;
    public static final HttpMethod PAUSE;
    public static final HttpMethod PLAY;
    public static final HttpMethod RECORD;
    public static final HttpMethod REDIRECT;
    public static final HttpMethod SETUP;
    public static final HttpMethod SET_PARAMETER;
    public static final HttpMethod TEARDOWN;
    private static final Map<String, HttpMethod> methodMap;

    static {
        HttpMethod httpMethod = HttpMethod.OPTIONS;
        OPTIONS = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("DESCRIBE");
        DESCRIBE = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("ANNOUNCE");
        ANNOUNCE = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod("SETUP");
        SETUP = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod("PLAY");
        PLAY = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("PAUSE");
        PAUSE = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("TEARDOWN");
        TEARDOWN = httpMethod7;
        HttpMethod httpMethod8 = new HttpMethod("GET_PARAMETER");
        GET_PARAMETER = httpMethod8;
        HttpMethod httpMethod9 = new HttpMethod("SET_PARAMETER");
        SET_PARAMETER = httpMethod9;
        HttpMethod httpMethod10 = new HttpMethod("REDIRECT");
        REDIRECT = httpMethod10;
        HttpMethod httpMethod11 = new HttpMethod("RECORD");
        RECORD = httpMethod11;
        HashMap hashMap = new HashMap();
        methodMap = hashMap;
        hashMap.put(httpMethod2.toString(), httpMethod2);
        hashMap.put(httpMethod3.toString(), httpMethod3);
        hashMap.put(httpMethod8.toString(), httpMethod8);
        hashMap.put(httpMethod.toString(), httpMethod);
        hashMap.put(httpMethod6.toString(), httpMethod6);
        hashMap.put(httpMethod5.toString(), httpMethod5);
        hashMap.put(httpMethod11.toString(), httpMethod11);
        hashMap.put(httpMethod10.toString(), httpMethod10);
        hashMap.put(httpMethod4.toString(), httpMethod4);
        hashMap.put(httpMethod9.toString(), httpMethod9);
        hashMap.put(httpMethod7.toString(), httpMethod7);
    }

    private RtspMethods() {
    }

    public static HttpMethod valueOf(String str) {
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            if (!upperCase.isEmpty()) {
                HttpMethod httpMethod = methodMap.get(upperCase);
                return httpMethod != null ? httpMethod : new HttpMethod(upperCase);
            }
            throw new IllegalArgumentException("empty name");
        }
        throw new NullPointerException("name");
    }
}
