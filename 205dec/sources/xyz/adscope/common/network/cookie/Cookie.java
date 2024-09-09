package xyz.adscope.common.network.cookie;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.Serializable;
import java.net.HttpCookie;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Cookie implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public String f64895b;

    /* renamed from: c  reason: collision with root package name */
    public String f64896c;

    /* renamed from: d  reason: collision with root package name */
    public String f64897d;

    /* renamed from: e  reason: collision with root package name */
    public String f64898e;

    /* renamed from: f  reason: collision with root package name */
    public String f64899f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64900g;

    /* renamed from: h  reason: collision with root package name */
    public String f64901h;

    /* renamed from: i  reason: collision with root package name */
    public long f64902i;

    /* renamed from: j  reason: collision with root package name */
    public String f64903j;

    /* renamed from: k  reason: collision with root package name */
    public String f64904k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f64905l;

    /* renamed from: a  reason: collision with root package name */
    public long f64894a = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f64906m = 1;

    public static boolean isExpired(Cookie cookie) {
        long j4 = cookie.f64902i;
        return j4 != -1 && j4 < System.currentTimeMillis();
    }

    public static Cookie toCookie(String str, HttpCookie httpCookie) {
        long j4;
        String path;
        Cookie cookie = new Cookie();
        cookie.setUrl(str);
        cookie.setName(httpCookie.getName());
        cookie.setValue(httpCookie.getValue());
        cookie.setComment(httpCookie.getComment());
        cookie.setCommentURL(httpCookie.getCommentURL());
        cookie.setDiscard(httpCookie.getDiscard());
        cookie.setDomain(httpCookie.getDomain());
        long maxAge = httpCookie.getMaxAge();
        int i4 = (maxAge > 0L ? 1 : (maxAge == 0L ? 0 : -1));
        if (i4 > 0) {
            j4 = (maxAge * 1000) + System.currentTimeMillis();
            if (j4 < 0) {
                j4 = System.currentTimeMillis() + 3153600000000L;
            }
        } else if (i4 >= 0) {
            cookie.setExpiry(0L);
            path = httpCookie.getPath();
            if (!TextUtils.isEmpty(path) && path.length() > 1 && path.endsWith(TTPathConst.sSeparator)) {
                path = path.substring(0, path.length() - 1);
            }
            cookie.setPath(path);
            cookie.setPortList(httpCookie.getPortlist());
            cookie.setSecure(httpCookie.getSecure());
            cookie.setVersion(httpCookie.getVersion());
            return cookie;
        } else {
            j4 = -1;
        }
        cookie.setExpiry(j4);
        path = httpCookie.getPath();
        if (!TextUtils.isEmpty(path)) {
            path = path.substring(0, path.length() - 1);
        }
        cookie.setPath(path);
        cookie.setPortList(httpCookie.getPortlist());
        cookie.setSecure(httpCookie.getSecure());
        cookie.setVersion(httpCookie.getVersion());
        return cookie;
    }

    public static HttpCookie toHttpCookie(Cookie cookie) {
        HttpCookie httpCookie = new HttpCookie(cookie.f64896c, cookie.f64897d);
        httpCookie.setComment(cookie.f64898e);
        httpCookie.setCommentURL(cookie.f64899f);
        httpCookie.setDiscard(cookie.f64900g);
        httpCookie.setDomain(cookie.f64901h);
        long j4 = cookie.f64902i;
        if (j4 != 0) {
            if (j4 < 0) {
                httpCookie.setMaxAge(-1L);
                httpCookie.setPath(cookie.f64903j);
                httpCookie.setPortlist(cookie.f64904k);
                httpCookie.setSecure(cookie.f64905l);
                httpCookie.setVersion(cookie.f64906m);
                return httpCookie;
            }
            long currentTimeMillis = j4 - System.currentTimeMillis();
            r3 = (currentTimeMillis > 0 ? currentTimeMillis : 0L) / 1000;
        }
        httpCookie.setMaxAge(r3);
        httpCookie.setPath(cookie.f64903j);
        httpCookie.setPortlist(cookie.f64904k);
        httpCookie.setSecure(cookie.f64905l);
        httpCookie.setVersion(cookie.f64906m);
        return httpCookie;
    }

    public String getComment() {
        return this.f64898e;
    }

    public String getCommentURL() {
        return this.f64899f;
    }

    public String getDomain() {
        return this.f64901h;
    }

    public long getExpiry() {
        return this.f64902i;
    }

    public long getId() {
        return this.f64894a;
    }

    public String getName() {
        return this.f64896c;
    }

    public String getPath() {
        return this.f64903j;
    }

    public String getPortList() {
        return this.f64904k;
    }

    public String getUrl() {
        return this.f64895b;
    }

    public String getValue() {
        return this.f64897d;
    }

    public int getVersion() {
        return this.f64906m;
    }

    public boolean isDiscard() {
        return this.f64900g;
    }

    public boolean isSecure() {
        return this.f64905l;
    }

    public void setComment(String str) {
        this.f64898e = str;
    }

    public void setCommentURL(String str) {
        this.f64899f = str;
    }

    public void setDiscard(boolean z3) {
        this.f64900g = z3;
    }

    public void setDomain(String str) {
        this.f64901h = str;
    }

    public void setExpiry(long j4) {
        this.f64902i = j4;
    }

    public void setId(long j4) {
        this.f64894a = j4;
    }

    public void setName(String str) {
        this.f64896c = str;
    }

    public void setPath(String str) {
        this.f64903j = str;
    }

    public void setPortList(String str) {
        this.f64904k = str;
    }

    public void setSecure(boolean z3) {
        this.f64905l = z3;
    }

    public void setUrl(String str) {
        this.f64895b = str;
    }

    public void setValue(String str) {
        this.f64897d = str;
    }

    public void setVersion(int i4) {
        this.f64906m = i4;
    }
}
