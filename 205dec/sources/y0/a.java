package y0;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static InterfaceC1337a f65064a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f65065b;

    /* renamed from: y0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC1337a {
        boolean c();

        boolean w();

        boolean xv();
    }

    private static Uri a(String str, String str2, int i4, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i4 > 0) {
                sb.append(':');
                sb.append(i4);
            }
        }
        if (str3 == null || !str3.startsWith(TTPathConst.sSeparator)) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return Uri.parse(sb.toString());
    }

    private static String b(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static String c(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || f65064a == null || f65065b) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri parse = Uri.parse(str);
            e(parse, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            f(linkedHashMap, linkedList, "device_id");
            f(linkedHashMap, linkedList, "device_type");
            f(linkedHashMap, linkedList, "device_brand");
            f(linkedHashMap, linkedList, "uuid");
            f(linkedHashMap, linkedList, "openudid");
            String d4 = d(linkedList, false, "UTF-8");
            if (TextUtils.isEmpty(d4)) {
                return str;
            }
            byte[] bytes = d4.getBytes();
            byte[] a4 = TTEncryptUtils.a(bytes, bytes.length);
            if (a4 == null) {
                return str;
            }
            String encodeToString = Base64.encodeToString(a4, 2);
            LinkedList linkedList2 = new LinkedList();
            if (f65064a.c()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(encodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (f65064a.w() && list != null) {
                list.add(new Pair<>("X-SS-QUERIES", b(encodeToString, "UTF-8")));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return a(parse.getScheme(), parse.getHost(), parse.getPort(), parse.getPath(), d(linkedList2, true, "UTF-8"), parse.getFragment()).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private static String d(List<Pair<String, List<String>>> list, boolean z3, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            Object obj = pair.first;
            String str2 = (String) obj;
            if (z3) {
                str2 = b((String) obj, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String str3 : list2) {
                    if (z3) {
                        str3 = str3 != null ? b(str3, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                }
            }
        }
        return sb.toString();
    }

    public static void e(Uri uri, Map<String, List<String>> map) throws IOException {
        String[] split;
        if (uri == null) {
            throw new IOException("parseUrl url is null !!!");
        }
        if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str : query.split("&")) {
                        int indexOf = str.indexOf("=");
                        if (indexOf >= 0) {
                            String decode = URLDecoder.decode(str.substring(0, indexOf), "UTF-8");
                            List<String> list = map.get(decode);
                            if (list == null) {
                                list = new LinkedList<>();
                            }
                            list.add(URLDecoder.decode(str.substring(indexOf + 1), "UTF-8"));
                            map.put(decode, list);
                        } else {
                            String decode2 = URLDecoder.decode(str, "UTF-8");
                            List<String> list2 = map.get(decode2);
                            if (list2 == null) {
                                list2 = new LinkedList<>();
                            }
                            list2.add("");
                            map.put(decode2, list2);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                throw new IOException("parseUrl url is null !!!");
            }
        }
    }

    private static boolean f(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (f65064a.xv()) {
            return true;
        }
        map.remove(str);
        return true;
    }
}
