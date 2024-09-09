package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LazyHeaders.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f17295c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f17296d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LazyHeaders.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a {

        /* renamed from: d  reason: collision with root package name */
        private static final String f17297d = "User-Agent";

        /* renamed from: e  reason: collision with root package name */
        private static final String f17298e;

        /* renamed from: f  reason: collision with root package name */
        private static final Map<String, List<i>> f17299f;

        /* renamed from: a  reason: collision with root package name */
        private boolean f17300a = true;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, List<i>> f17301b = f17299f;

        /* renamed from: c  reason: collision with root package name */
        private boolean f17302c = true;

        static {
            String g4 = g();
            f17298e = g4;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(g4)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(g4)));
            }
            f17299f = Collections.unmodifiableMap(hashMap);
        }

        private Map<String, List<i>> d() {
            HashMap hashMap = new HashMap(this.f17301b.size());
            for (Map.Entry<String, List<i>> entry : this.f17301b.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }

        private void e() {
            if (this.f17300a) {
                this.f17300a = false;
                this.f17301b = d();
            }
        }

        private List<i> f(String str) {
            List<i> list = this.f17301b.get(str);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                this.f17301b.put(str, arrayList);
                return arrayList;
            }
            return list;
        }

        @VisibleForTesting
        static String g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = property.charAt(i4);
                if ((charAt > 31 || charAt == '\t') && charAt < '\u007f') {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public a a(@NonNull String str, @NonNull i iVar) {
            if (this.f17302c && "User-Agent".equalsIgnoreCase(str)) {
                return h(str, iVar);
            }
            e();
            f(str).add(iVar);
            return this;
        }

        public a b(@NonNull String str, @NonNull String str2) {
            return a(str, new b(str2));
        }

        public j c() {
            this.f17300a = true;
            return new j(this.f17301b);
        }

        public a h(@NonNull String str, @Nullable i iVar) {
            e();
            if (iVar == null) {
                this.f17301b.remove(str);
            } else {
                List<i> f4 = f(str);
                f4.clear();
                f4.add(iVar);
            }
            if (this.f17302c && "User-Agent".equalsIgnoreCase(str)) {
                this.f17302c = false;
            }
            return this;
        }

        public a i(@NonNull String str, @Nullable String str2) {
            return h(str, str2 == null ? null : new b(str2));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LazyHeaders.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static final class b implements i {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f17303a;

        b(@NonNull String str) {
            this.f17303a = str;
        }

        @Override // com.bumptech.glide.load.model.i
        public String a() {
            return this.f17303a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f17303a.equals(((b) obj).f17303a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17303a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f17303a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f17295c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            String a4 = list.get(i4).a();
            if (!TextUtils.isEmpty(a4)) {
                sb.append(a4);
                if (i4 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f17295c.entrySet()) {
            String a4 = a(entry.getValue());
            if (!TextUtils.isEmpty(a4)) {
                hashMap.put(entry.getKey(), a4);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f17295c.equals(((j) obj).f17295c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.h
    public Map<String, String> getHeaders() {
        if (this.f17296d == null) {
            synchronized (this) {
                if (this.f17296d == null) {
                    this.f17296d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f17296d;
    }

    public int hashCode() {
        return this.f17295c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f17295c + '}';
    }
}
