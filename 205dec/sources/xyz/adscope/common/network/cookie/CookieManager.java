package xyz.adscope.common.network.cookie;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CookieManager {

    /* renamed from: a  reason: collision with root package name */
    public CookieStore f64907a;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class CookiePathComparator implements Comparator<HttpCookie> {
        public CookiePathComparator() {
        }

        @Override // java.util.Comparator
        public int compare(HttpCookie httpCookie, HttpCookie httpCookie2) {
            if (httpCookie == httpCookie2) {
                return 0;
            }
            if (httpCookie == null) {
                return -1;
            }
            if (httpCookie2 == null) {
                return 1;
            }
            if (httpCookie.getName().equals(httpCookie2.getName())) {
                String b4 = CookieManager.b(httpCookie.getPath());
                String b5 = CookieManager.b(httpCookie2.getPath());
                if (b4.startsWith(b5)) {
                    return -1;
                }
                return b5.startsWith(b4) ? 1 : 0;
            }
            return 0;
        }
    }

    public CookieManager(CookieStore cookieStore) {
        this.f64907a = cookieStore;
    }

    public static int a(URI uri) {
        int port = uri.getPort();
        return port == -1 ? "https".equals(uri.getScheme()) ? 443 : 80 : port;
    }

    public static boolean a(String str, int i4) {
        if (str.contains(",")) {
            String[] split = str.split(",");
            String num = Integer.toString(i4);
            for (String str2 : split) {
                if (str2.equals(num)) {
                    return true;
                }
            }
            return false;
        }
        return str.equalsIgnoreCase(Integer.toString(i4));
    }

    public static boolean a(URI uri, HttpCookie httpCookie) {
        return b(uri.getPath()).startsWith(b(httpCookie.getPath()));
    }

    public static String b(String str) {
        if (str == null) {
            str = "";
        }
        if (str.endsWith(TTPathConst.sSeparator)) {
            return str;
        }
        return str + TTPathConst.sSeparator;
    }

    public final String a(List<HttpCookie> list) {
        Collections.sort(list, new CookiePathComparator());
        StringBuilder sb = new StringBuilder();
        int i4 = 1;
        for (HttpCookie httpCookie : list) {
            if (httpCookie.getVersion() < i4) {
                i4 = httpCookie.getVersion();
            }
        }
        if (i4 == 1) {
            sb.append("$Version=\"1\"; ");
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (i5 != 0) {
                sb.append("; ");
            }
            sb.append(list.get(i5).toString());
        }
        return sb.toString();
    }

    public void add(URI uri, List<String> list) {
        for (String str : list) {
            for (HttpCookie httpCookie : HttpCookie.parse(str)) {
                if (httpCookie.getPath() == null) {
                    httpCookie.setPath(b(uri.getPath()));
                } else if (!a(uri, httpCookie)) {
                }
                if (httpCookie.getDomain() == null) {
                    httpCookie.setDomain(uri.getHost());
                }
                String portlist = httpCookie.getPortlist();
                int a4 = a(uri);
                if (TextUtils.isEmpty(portlist) || a(portlist, a4)) {
                    this.f64907a.add(uri, httpCookie);
                }
            }
        }
    }

    public List<String> get(URI uri) {
        boolean equalsIgnoreCase = "https".equalsIgnoreCase(uri.getScheme());
        ArrayList arrayList = new ArrayList();
        for (HttpCookie httpCookie : this.f64907a.get(uri)) {
            if (a(uri, httpCookie) && (equalsIgnoreCase || !httpCookie.getSecure())) {
                String portlist = httpCookie.getPortlist();
                int a4 = a(uri);
                if (TextUtils.isEmpty(portlist) || a(portlist, a4)) {
                    arrayList.add(httpCookie);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(a(arrayList));
        return arrayList2;
    }
}
