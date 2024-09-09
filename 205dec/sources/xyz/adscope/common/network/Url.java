package xyz.adscope.common.network;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import xyz.adscope.common.network.Params;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Url {

    /* renamed from: a  reason: collision with root package name */
    public final String f64846a;

    /* renamed from: b  reason: collision with root package name */
    public final String f64847b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64848c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64849d;

    /* renamed from: e  reason: collision with root package name */
    public final String f64850e;

    /* renamed from: f  reason: collision with root package name */
    public final String f64851f;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f64852a;

        /* renamed from: b  reason: collision with root package name */
        public String f64853b;

        /* renamed from: c  reason: collision with root package name */
        public int f64854c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f64855d;

        /* renamed from: e  reason: collision with root package name */
        public Params.Builder f64856e;

        /* renamed from: f  reason: collision with root package name */
        public String f64857f;

        public Builder(String str) {
            URI create = URI.create(str);
            this.f64852a = create.getScheme();
            this.f64853b = create.getHost();
            this.f64854c = Url.b(create.getPort());
            this.f64855d = Url.c(create.getPath());
            this.f64856e = Url.d(create.getQuery()).builder();
            this.f64857f = create.getFragment();
        }

        public Builder addPath(char c4) {
            return addPath(String.valueOf(c4));
        }

        public Builder addPath(double d4) {
            return addPath(Double.toString(d4));
        }

        public Builder addPath(float f4) {
            return addPath(Float.toString(f4));
        }

        public Builder addPath(int i4) {
            return addPath(Integer.toString(i4));
        }

        public Builder addPath(long j4) {
            return addPath(Long.toString(j4));
        }

        public Builder addPath(String str) {
            this.f64855d.add(str);
            return this;
        }

        public Builder addPath(boolean z3) {
            return addPath(Boolean.toString(z3));
        }

        public Builder addQuery(String str, char c4) {
            return addQuery(str, String.valueOf(c4));
        }

        public Builder addQuery(String str, double d4) {
            return addQuery(str, Double.toString(d4));
        }

        public Builder addQuery(String str, float f4) {
            return addQuery(str, Float.toString(f4));
        }

        public Builder addQuery(String str, int i4) {
            return addQuery(str, Integer.toString(i4));
        }

        public Builder addQuery(String str, long j4) {
            return addQuery(str, Long.toString(j4));
        }

        public Builder addQuery(String str, String str2) {
            this.f64856e.add(str, str2);
            return this;
        }

        public Builder addQuery(String str, List<String> list) {
            for (String str2 : list) {
                addQuery(str, str2);
            }
            return this;
        }

        public Builder addQuery(String str, short s3) {
            return addQuery(str, Integer.toString(s3));
        }

        public Builder addQuery(String str, boolean z3) {
            return addQuery(str, Boolean.toString(z3));
        }

        public Builder addQuery(Params params) {
            for (Map.Entry<String, List<Object>> entry : params.entrySet()) {
                String key = entry.getKey();
                for (Object obj : entry.getValue()) {
                    if (obj instanceof CharSequence) {
                        addQuery(key, obj.toString());
                    }
                }
            }
            return this;
        }

        public Url build() {
            return new Url(this);
        }

        public Builder clearPath() {
            this.f64855d.clear();
            return this;
        }

        public Builder clearQuery() {
            this.f64856e.clear();
            return this;
        }

        public Builder removeQuery(String str) {
            this.f64856e.remove(str);
            return this;
        }

        public Builder setFragment(String str) {
            this.f64857f = str;
            return this;
        }

        public Builder setHost(String str) {
            this.f64853b = str;
            return this;
        }

        public Builder setPath(String str) {
            this.f64855d = Url.c(str);
            return this;
        }

        public Builder setPort(int i4) {
            this.f64854c = i4;
            return this;
        }

        public Builder setQuery(String str) {
            this.f64856e = Url.d(str).builder();
            return this;
        }

        public Builder setQuery(Params params) {
            this.f64856e = params.builder();
            return this;
        }

        public Builder setScheme(String str) {
            this.f64852a = str;
            return this;
        }
    }

    public Url(Builder builder) {
        this.f64846a = builder.f64852a;
        this.f64847b = builder.f64853b;
        this.f64848c = builder.f64854c;
        this.f64849d = a((List<String>) builder.f64855d, false);
        this.f64850e = builder.f64856e.build().toString(false);
        this.f64851f = builder.f64857f;
    }

    public static String a(String str, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Object[] objArr = new Object[1];
        if (z3) {
            str = Uri.encode(str);
        }
        objArr[0] = str;
        return String.format("#%s", objArr);
    }

    public static String a(List<String> list, boolean z3) {
        if (list.isEmpty()) {
            return TTPathConst.sSeparator;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(TTPathConst.sSeparator);
            if (z3) {
                str = Uri.encode(str);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static String a(Params params, boolean z3) {
        String params2 = params.toString(z3);
        return TextUtils.isEmpty(params2) ? "" : String.format("?%s", params2);
    }

    public static int b(int i4) {
        if (i4 > 0) {
            return i4;
        }
        return 80;
    }

    public static String c(int i4) {
        return (i4 <= 0 || i4 == 80) ? "" : String.format(Locale.getDefault(), ":%d", Integer.valueOf(i4));
    }

    public static List<String> c(String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            while (str.startsWith(TTPathConst.sSeparator)) {
                str = str.substring(1);
            }
            while (str.endsWith(TTPathConst.sSeparator)) {
                str = str.substring(0, str.length() - 1);
            }
            Collections.addAll(linkedList, str.split(TTPathConst.sSeparator));
        }
        return linkedList;
    }

    public static Params d(String str) {
        String[] split;
        String str2;
        Params.Builder newBuilder = Params.newBuilder();
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("?")) {
                str = str.substring(1);
            }
            for (String str3 : str.split("&")) {
                int indexOf = str3.indexOf("=");
                str2 = "";
                if (indexOf > 0) {
                    String substring = str3.substring(0, indexOf);
                    str2 = indexOf < str3.length() - 1 ? str3.substring(indexOf + 1) : "";
                    str3 = substring;
                }
                newBuilder.add(str3, str2);
            }
        }
        return newBuilder.build();
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public Builder builder() {
        return newBuilder(toString());
    }

    public List<String> copyPath() {
        return c(this.f64849d);
    }

    @Deprecated
    public Params copyQuery() {
        return getParams();
    }

    public String getFragment() {
        return this.f64851f;
    }

    public String getHost() {
        return this.f64847b;
    }

    public Params getParams() {
        return d(this.f64850e);
    }

    public String getPath() {
        return this.f64849d;
    }

    public int getPort() {
        return this.f64848c;
    }

    public String getQuery() {
        return this.f64850e;
    }

    public String getScheme() {
        return this.f64846a;
    }

    public Url location(String str) {
        List<String> c4;
        List<String> c5;
        String str2;
        Builder path;
        Builder fragment;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (URLUtil.isNetworkUrl(str)) {
            fragment = newBuilder(str);
        } else {
            URI create = URI.create(str);
            if (str.startsWith(TTPathConst.sSeparator)) {
                path = builder().setPath(create.getPath());
            } else {
                if (str.contains("../")) {
                    List<String> c6 = c(getPath());
                    List<String> c7 = c(create.getPath());
                    int lastIndexOf = c7.lastIndexOf("..");
                    c5 = c7.subList(lastIndexOf + 1, c7.size());
                    if (c6.isEmpty()) {
                        str2 = TextUtils.join(TTPathConst.sSeparator, c5);
                        path = builder().setPath(str2);
                    } else {
                        c4 = c6.subList(0, (c6.size() - lastIndexOf) - 2);
                    }
                } else {
                    c4 = c(getPath());
                    c5 = c(create.getPath());
                }
                c4.addAll(c5);
                str2 = TextUtils.join(TTPathConst.sSeparator, c4);
                path = builder().setPath(str2);
            }
            fragment = path.setQuery(create.getQuery()).setFragment(create.getFragment());
        }
        return fragment.build();
    }

    public String toString() {
        return toString(false);
    }

    public String toString(boolean z3) {
        String a4 = a(c(this.f64849d), z3);
        String a5 = a(d(this.f64850e), z3);
        String a6 = a(this.f64851f, z3);
        return this.f64846a + "://" + this.f64847b + c(this.f64848c) + a4 + a5 + a6;
    }
}
