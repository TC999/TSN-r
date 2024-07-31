package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.model.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LazyHeaders implements InterfaceC3670h {

    /* renamed from: c */
    private final Map<String, List<LazyHeaderFactory>> f13978c;

    /* renamed from: d */
    private volatile Map<String, String> f13979d;

    /* compiled from: LazyHeaders.java */
    /* renamed from: com.bumptech.glide.load.model.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3672a {

        /* renamed from: d */
        private static final String f13980d = "User-Agent";

        /* renamed from: e */
        private static final String f13981e;

        /* renamed from: f */
        private static final Map<String, List<LazyHeaderFactory>> f13982f;

        /* renamed from: a */
        private boolean f13983a = true;

        /* renamed from: b */
        private Map<String, List<LazyHeaderFactory>> f13984b = f13982f;

        /* renamed from: c */
        private boolean f13985c = true;

        static {
            String m45079g = m45079g();
            f13981e = m45079g;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(m45079g)) {
                hashMap.put("User-Agent", Collections.singletonList(new C3673b(m45079g)));
            }
            f13982f = Collections.unmodifiableMap(hashMap);
        }

        /* renamed from: d */
        private Map<String, List<LazyHeaderFactory>> m45082d() {
            HashMap hashMap = new HashMap(this.f13984b.size());
            for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.f13984b.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }

        /* renamed from: e */
        private void m45081e() {
            if (this.f13983a) {
                this.f13983a = false;
                this.f13984b = m45082d();
            }
        }

        /* renamed from: f */
        private List<LazyHeaderFactory> m45080f(String str) {
            List<LazyHeaderFactory> list = this.f13984b.get(str);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                this.f13984b.put(str, arrayList);
                return arrayList;
            }
            return list;
        }

        @VisibleForTesting
        /* renamed from: g */
        static String m45079g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        /* renamed from: a */
        public C3672a m45085a(@NonNull String str, @NonNull LazyHeaderFactory lazyHeaderFactory) {
            if (this.f13985c && "User-Agent".equalsIgnoreCase(str)) {
                return m45078h(str, lazyHeaderFactory);
            }
            m45081e();
            m45080f(str).add(lazyHeaderFactory);
            return this;
        }

        /* renamed from: b */
        public C3672a m45084b(@NonNull String str, @NonNull String str2) {
            return m45085a(str, new C3673b(str2));
        }

        /* renamed from: c */
        public LazyHeaders m45083c() {
            this.f13983a = true;
            return new LazyHeaders(this.f13984b);
        }

        /* renamed from: h */
        public C3672a m45078h(@NonNull String str, @Nullable LazyHeaderFactory lazyHeaderFactory) {
            m45081e();
            if (lazyHeaderFactory == null) {
                this.f13984b.remove(str);
            } else {
                List<LazyHeaderFactory> m45080f = m45080f(str);
                m45080f.clear();
                m45080f.add(lazyHeaderFactory);
            }
            if (this.f13985c && "User-Agent".equalsIgnoreCase(str)) {
                this.f13985c = false;
            }
            return this;
        }

        /* renamed from: i */
        public C3672a m45077i(@NonNull String str, @Nullable String str2) {
            return m45078h(str, str2 == null ? null : new C3673b(str2));
        }
    }

    /* compiled from: LazyHeaders.java */
    /* renamed from: com.bumptech.glide.load.model.j$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static final class C3673b implements LazyHeaderFactory {
        @NonNull

        /* renamed from: a */
        private final String f13986a;

        C3673b(@NonNull String str) {
            this.f13986a = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        /* renamed from: a */
        public String mo45076a() {
            return this.f13986a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3673b) {
                return this.f13986a.equals(((C3673b) obj).f13986a);
            }
            return false;
        }

        public int hashCode() {
            return this.f13986a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f13986a + "'}";
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f13978c = Collections.unmodifiableMap(map);
    }

    @NonNull
    /* renamed from: a */
    private String m45087a(@NonNull List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String mo45076a = list.get(i).mo45076a();
            if (!TextUtils.isEmpty(mo45076a)) {
                sb.append(mo45076a);
                if (i != list.size() - 1) {
                    sb.append(StringUtil.COMMA);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private Map<String, String> m45086b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.f13978c.entrySet()) {
            String m45087a = m45087a(entry.getValue());
            if (!TextUtils.isEmpty(m45087a)) {
                hashMap.put(entry.getKey(), m45087a);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f13978c.equals(((LazyHeaders) obj).f13978c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC3670h
    public Map<String, String> getHeaders() {
        if (this.f13979d == null) {
            synchronized (this) {
                if (this.f13979d == null) {
                    this.f13979d = Collections.unmodifiableMap(m45086b());
                }
            }
        }
        return this.f13979d;
    }

    public int hashCode() {
        return this.f13978c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f13978c + '}';
    }
}
