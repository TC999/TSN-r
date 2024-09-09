package xyz.adscope.common.network.cookie;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import xyz.adscope.common.network.cookie.db.CookieDao;
import xyz.adscope.common.network.cookie.db.Field;
import xyz.adscope.common.network.cookie.db.Where;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DBCookieStore implements CookieStore, Field {

    /* renamed from: a  reason: collision with root package name */
    public Lock f64908a;

    /* renamed from: b  reason: collision with root package name */
    public CookieDao f64909b;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Context f64910a;

        public Builder(Context context) {
            this.f64910a = context;
        }

        public DBCookieStore build() {
            return new DBCookieStore(this);
        }
    }

    public DBCookieStore(Builder builder) {
        this.f64908a = new ReentrantLock();
        this.f64909b = new CookieDao(builder.f64910a);
        Where.Builder newBuilder = Where.newBuilder();
        Where.Options options = Where.Options.EQUAL;
        this.f64909b.delete(newBuilder.add(Field.EXPIRY, options, -1).or(Field.EXPIRY, options, 0).build().toString());
    }

    public static URI a(URI uri) {
        try {
            return new URI("http", uri.getHost(), uri.getPath(), null, null);
        } catch (URISyntaxException unused) {
            return uri;
        }
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public final void a() {
        List<Cookie> list;
        int count = this.f64909b.count();
        if (count <= 888 || (list = this.f64909b.getList(null, null, Integer.toString(count - 888), null)) == null) {
            return;
        }
        this.f64909b.delete(list);
    }

    @Override // xyz.adscope.common.network.cookie.CookieStore
    public void add(URI uri, HttpCookie httpCookie) {
        this.f64908a.lock();
        if (uri != null && httpCookie != null) {
            try {
                this.f64909b.replace(Cookie.toCookie(a(uri).toString(), httpCookie));
                a();
            } finally {
                this.f64908a.unlock();
            }
        }
    }

    @Override // xyz.adscope.common.network.cookie.CookieStore
    public void clear() {
        this.f64908a.lock();
        try {
            this.f64909b.deleteAll();
        } finally {
            this.f64908a.unlock();
        }
    }

    @Override // xyz.adscope.common.network.cookie.CookieStore
    public List<HttpCookie> get(URI uri) {
        this.f64908a.lock();
        try {
            URI a4 = a(uri);
            Where.Builder newBuilder = Where.newBuilder();
            String host = a4.getHost();
            if (!TextUtils.isEmpty(host)) {
                Where.Builder newBuilder2 = Where.newBuilder();
                Where.Options options = Where.Options.EQUAL;
                Where.Builder add = newBuilder2.add(Field.DOMAIN, options, host);
                Where.Builder or = add.or(Field.DOMAIN, options, "." + host);
                int indexOf = host.indexOf(".");
                int lastIndexOf = host.lastIndexOf(".");
                if (indexOf > 0) {
                    if (lastIndexOf > indexOf) {
                        String substring = host.substring(indexOf, host.length());
                        if (!TextUtils.isEmpty(substring)) {
                            or.or(Field.DOMAIN, options, substring);
                        }
                    }
                    int i4 = indexOf + 1;
                    if (lastIndexOf > i4) {
                        String substring2 = host.substring(i4, host.length());
                        if (!TextUtils.isEmpty(substring2)) {
                            or.or(Field.DOMAIN, options, substring2);
                        }
                    }
                }
                newBuilder.set(or.build().toString());
            }
            String path = a4.getPath();
            if (!TextUtils.isEmpty(path)) {
                Where.Builder newBuilder3 = Where.newBuilder();
                Where.Options options2 = Where.Options.EQUAL;
                Where.Builder orNull = newBuilder3.add(Field.PATH, options2, path).or(Field.PATH, options2, TTPathConst.sSeparator).orNull(Field.PATH);
                while (true) {
                    int lastIndexOf2 = path.lastIndexOf(TTPathConst.sSeparator);
                    if (lastIndexOf2 <= 0) {
                        break;
                    }
                    path = path.substring(0, lastIndexOf2);
                    orNull.or(Field.PATH, Where.Options.EQUAL, path);
                }
                orNull.bracket();
                newBuilder.and(orNull.build());
            }
            newBuilder.or(Field.URL, Where.Options.EQUAL, a4.toString());
            List<Cookie> list = this.f64909b.getList(newBuilder.build().toString(), null, null, null);
            ArrayList arrayList = new ArrayList();
            for (Cookie cookie : list) {
                if (!Cookie.isExpired(cookie)) {
                    arrayList.add(Cookie.toHttpCookie(cookie));
                }
            }
            return arrayList;
        } finally {
            this.f64908a.unlock();
        }
    }

    @Override // xyz.adscope.common.network.cookie.CookieStore
    public void remove(HttpCookie httpCookie) {
        this.f64908a.lock();
        try {
            Where.Builder newBuilder = Where.newBuilder();
            Where.Options options = Where.Options.EQUAL;
            Where.Builder add = newBuilder.add(Field.NAME, options, httpCookie.getName());
            String domain = httpCookie.getDomain();
            if (!TextUtils.isEmpty(domain)) {
                add.and(Field.DOMAIN, options, domain);
            }
            String path = httpCookie.getPath();
            if (!TextUtils.isEmpty(path)) {
                if (path.length() > 1 && path.endsWith(TTPathConst.sSeparator)) {
                    path = path.substring(0, path.length() - 1);
                }
                add.and(Field.PATH, options, path);
            }
            this.f64909b.delete(add.build().toString());
        } finally {
            this.f64908a.unlock();
        }
    }
}
