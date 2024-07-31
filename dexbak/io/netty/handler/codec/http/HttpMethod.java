package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpMethod implements Comparable<HttpMethod> {
    public static final HttpMethod CONNECT;
    public static final HttpMethod DELETE;
    public static final HttpMethod GET;
    public static final HttpMethod HEAD;
    public static final HttpMethod OPTIONS;
    public static final HttpMethod PATCH;
    public static final HttpMethod POST;
    public static final HttpMethod PUT;
    public static final HttpMethod TRACE;
    private static final Map<String, HttpMethod> methodMap;
    private final AsciiString name;

    static {
        HttpMethod httpMethod = new HttpMethod("OPTIONS");
        OPTIONS = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("GET");
        GET = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("HEAD");
        HEAD = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod("POST");
        POST = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod("PUT");
        PUT = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("PATCH");
        PATCH = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("DELETE");
        DELETE = httpMethod7;
        HttpMethod httpMethod8 = new HttpMethod("TRACE");
        TRACE = httpMethod8;
        HttpMethod httpMethod9 = new HttpMethod("CONNECT");
        CONNECT = httpMethod9;
        HashMap hashMap = new HashMap();
        methodMap = hashMap;
        hashMap.put(httpMethod.toString(), httpMethod);
        hashMap.put(httpMethod2.toString(), httpMethod2);
        hashMap.put(httpMethod3.toString(), httpMethod3);
        hashMap.put(httpMethod4.toString(), httpMethod4);
        hashMap.put(httpMethod5.toString(), httpMethod5);
        hashMap.put(httpMethod6.toString(), httpMethod6);
        hashMap.put(httpMethod7.toString(), httpMethod7);
        hashMap.put(httpMethod8.toString(), httpMethod8);
        hashMap.put(httpMethod9.toString(), httpMethod9);
    }

    public HttpMethod(String str) {
        String trim = ((String) ObjectUtil.checkNotNull(str, "name")).trim();
        if (!trim.isEmpty()) {
            for (int i = 0; i < trim.length(); i++) {
                char charAt = trim.charAt(i);
                if (Character.isISOControl(charAt) || Character.isWhitespace(charAt)) {
                    throw new IllegalArgumentException("invalid character in name");
                }
            }
            this.name = new AsciiString(trim);
            return;
        }
        throw new IllegalArgumentException("empty name");
    }

    public static HttpMethod valueOf(String str) {
        HttpMethod httpMethod = methodMap.get(str);
        return httpMethod != null ? httpMethod : new HttpMethod(str);
    }

    public AsciiString asciiName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HttpMethod) {
            return name().equals(((HttpMethod) obj).name());
        }
        return false;
    }

    public int hashCode() {
        return name().hashCode();
    }

    public String name() {
        return this.name.toString();
    }

    public String toString() {
        return this.name.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpMethod httpMethod) {
        return name().compareTo(httpMethod.name());
    }
}
