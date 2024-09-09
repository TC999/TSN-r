package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class EnumNameMap<T> {
        private final Node<T>[] values;
        private final int valuesMask;

        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        private static final class Node<T> {
            final String key;
            final T value;

            Node(String str, T t3) {
                this.key = str;
                this.value = t3;
            }
        }

        EnumNameMap(Node<T>... nodeArr) {
            Node<T>[] nodeArr2;
            this.values = new Node[MathUtil.findNextPositivePowerOfTwo(nodeArr.length)];
            this.valuesMask = nodeArr2.length - 1;
            for (Node<T> node : nodeArr) {
                int hashCode = hashCode(node.key) & this.valuesMask;
                Node<T>[] nodeArr3 = this.values;
                if (nodeArr3[hashCode] == null) {
                    nodeArr3[hashCode] = node;
                } else {
                    throw new IllegalArgumentException("index " + hashCode + " collision between values: [" + this.values[hashCode].key + ", " + node.key + ']');
                }
            }
        }

        private static int hashCode(String str) {
            return str.hashCode() >>> 6;
        }

        T get(String str) {
            Node<T> node = this.values[hashCode(str) & this.valuesMask];
            if (node == null || !node.key.equals(str)) {
                return null;
            }
            return node.value;
        }
    }

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
            for (int i4 = 0; i4 < trim.length(); i4++) {
                char charAt = trim.charAt(i4);
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
