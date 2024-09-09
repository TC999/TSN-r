package io.netty.handler.codec.http.cookie;

import io.netty.handler.codec.http.HttpHeaderDateFormat;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ServerCookieEncoder extends CookieEncoder {
    public static final ServerCookieEncoder STRICT = new ServerCookieEncoder(true);
    public static final ServerCookieEncoder LAX = new ServerCookieEncoder(false);

    private ServerCookieEncoder(boolean z3) {
        super(z3);
    }

    private List<String> dedup(List<String> list, Map<String, Integer> map) {
        boolean[] zArr = new boolean[list.size()];
        for (Integer num : map.values()) {
            zArr[num.intValue()] = true;
        }
        ArrayList arrayList = new ArrayList(map.size());
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (zArr[i4]) {
                arrayList.add(list.get(i4));
            }
        }
        return arrayList;
    }

    public String encode(String str, String str2) {
        return encode(new DefaultCookie(str, str2));
    }

    public String encode(Cookie cookie) {
        String name = ((Cookie) ObjectUtil.checkNotNull(cookie, "cookie")).name();
        String value = cookie.value() != null ? cookie.value() : "";
        validateCookie(name, value);
        StringBuilder stringBuilder = CookieUtil.stringBuilder();
        if (cookie.wrap()) {
            CookieUtil.addQuoted(stringBuilder, name, value);
        } else {
            CookieUtil.add(stringBuilder, name, value);
        }
        if (cookie.maxAge() != Long.MIN_VALUE) {
            CookieUtil.add(stringBuilder, "Max-Age", cookie.maxAge());
            CookieUtil.add(stringBuilder, "Expires", HttpHeaderDateFormat.get().format(new Date((cookie.maxAge() * 1000) + System.currentTimeMillis())));
        }
        if (cookie.path() != null) {
            CookieUtil.add(stringBuilder, "Path", cookie.path());
        }
        if (cookie.domain() != null) {
            CookieUtil.add(stringBuilder, "Domain", cookie.domain());
        }
        if (cookie.isSecure()) {
            CookieUtil.add(stringBuilder, "Secure");
        }
        if (cookie.isHttpOnly()) {
            CookieUtil.add(stringBuilder, "HTTPOnly");
        }
        return CookieUtil.stripTrailingSeparator(stringBuilder);
    }

    public List<String> encode(Cookie... cookieArr) {
        if (((Cookie[]) ObjectUtil.checkNotNull(cookieArr, "cookies")).length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cookieArr.length);
        HashMap hashMap = (!this.strict || cookieArr.length <= 1) ? null : new HashMap();
        boolean z3 = false;
        for (int i4 = 0; i4 < cookieArr.length; i4++) {
            Cookie cookie = cookieArr[i4];
            arrayList.add(encode(cookie));
            if (hashMap != null) {
                z3 |= hashMap.put(cookie.name(), Integer.valueOf(i4)) != null;
            }
        }
        return z3 ? dedup(arrayList, hashMap) : arrayList;
    }

    public List<String> encode(Collection<? extends Cookie> collection) {
        if (((Collection) ObjectUtil.checkNotNull(collection, "cookies")).isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        HashMap hashMap = (!this.strict || collection.size() <= 1) ? null : new HashMap();
        boolean z3 = false;
        int i4 = 0;
        for (Cookie cookie : collection) {
            arrayList.add(encode(cookie));
            if (hashMap != null) {
                int i5 = i4 + 1;
                z3 |= hashMap.put(cookie.name(), Integer.valueOf(i4)) != null;
                i4 = i5;
            }
        }
        return z3 ? dedup(arrayList, hashMap) : arrayList;
    }

    public List<String> encode(Iterable<? extends Cookie> iterable) {
        boolean z3;
        int i4;
        Iterator it = ((Iterable) ObjectUtil.checkNotNull(iterable, "cookies")).iterator();
        if (!it.hasNext()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Cookie cookie = (Cookie) it.next();
        HashMap hashMap = (this.strict && it.hasNext()) ? new HashMap() : null;
        arrayList.add(encode(cookie));
        if (hashMap != null) {
            z3 = hashMap.put(cookie.name(), 0) != null;
            i4 = 1;
        } else {
            z3 = false;
            i4 = 0;
        }
        while (it.hasNext()) {
            Cookie cookie2 = (Cookie) it.next();
            arrayList.add(encode(cookie2));
            if (hashMap != null) {
                int i5 = i4 + 1;
                z3 |= hashMap.put(cookie2.name(), Integer.valueOf(i4)) != null;
                i4 = i5;
            }
        }
        return z3 ? dedup(arrayList, hashMap) : arrayList;
    }
}
