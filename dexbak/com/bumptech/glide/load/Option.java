package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.C3770j;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Option<T> {

    /* renamed from: e */
    private static final InterfaceC3572b<Object> f13531e = new C3571a();

    /* renamed from: a */
    private final T f13532a;

    /* renamed from: b */
    private final InterfaceC3572b<T> f13533b;

    /* renamed from: c */
    private final String f13534c;

    /* renamed from: d */
    private volatile byte[] f13535d;

    /* compiled from: Option.java */
    /* renamed from: com.bumptech.glide.load.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3571a implements InterfaceC3572b<Object> {
        C3571a() {
        }

        @Override // com.bumptech.glide.load.Option.InterfaceC3572b
        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option.java */
    /* renamed from: com.bumptech.glide.load.e$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3572b<T> {
        void update(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private Option(@NonNull String str, @Nullable T t, @NonNull InterfaceC3572b<T> interfaceC3572b) {
        this.f13534c = C3770j.m44394b(str);
        this.f13532a = t;
        this.f13533b = (InterfaceC3572b) C3770j.m44392d(interfaceC3572b);
    }

    @NonNull
    /* renamed from: a */
    public static <T> Option<T> m45437a(@NonNull String str, @NonNull InterfaceC3572b<T> interfaceC3572b) {
        return new Option<>(str, null, interfaceC3572b);
    }

    @NonNull
    /* renamed from: b */
    public static <T> Option<T> m45436b(@NonNull String str, @Nullable T t, @NonNull InterfaceC3572b<T> interfaceC3572b) {
        return new Option<>(str, t, interfaceC3572b);
    }

    @NonNull
    /* renamed from: c */
    private static <T> InterfaceC3572b<T> m45435c() {
        return (InterfaceC3572b<T>) f13531e;
    }

    @NonNull
    /* renamed from: e */
    private byte[] m45433e() {
        if (this.f13535d == null) {
            this.f13535d = this.f13534c.getBytes(Key.f13470b);
        }
        return this.f13535d;
    }

    @NonNull
    /* renamed from: f */
    public static <T> Option<T> m45432f(@NonNull String str) {
        return new Option<>(str, null, m45435c());
    }

    @NonNull
    /* renamed from: g */
    public static <T> Option<T> m45431g(@NonNull String str, @NonNull T t) {
        return new Option<>(str, t, m45435c());
    }

    @Nullable
    /* renamed from: d */
    public T m45434d() {
        return this.f13532a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f13534c.equals(((Option) obj).f13534c);
        }
        return false;
    }

    public int hashCode() {
        return this.f13534c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f13534c + "'}";
    }

    public void update(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f13533b.update(m45433e(), t, messageDigest);
    }
}
