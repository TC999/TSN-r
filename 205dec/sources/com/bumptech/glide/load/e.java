package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Option.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class e<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final b<Object> f16854e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final T f16855a;

    /* renamed from: b  reason: collision with root package name */
    private final b<T> f16856b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16857c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f16858d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Option.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Option.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b<T> {
        void update(@NonNull byte[] bArr, @NonNull T t3, @NonNull MessageDigest messageDigest);
    }

    private e(@NonNull String str, @Nullable T t3, @NonNull b<T> bVar) {
        this.f16857c = j.b(str);
        this.f16855a = t3;
        this.f16856b = (b) j.d(bVar);
    }

    @NonNull
    public static <T> e<T> a(@NonNull String str, @NonNull b<T> bVar) {
        return new e<>(str, null, bVar);
    }

    @NonNull
    public static <T> e<T> b(@NonNull String str, @Nullable T t3, @NonNull b<T> bVar) {
        return new e<>(str, t3, bVar);
    }

    @NonNull
    private static <T> b<T> c() {
        return (b<T>) f16854e;
    }

    @NonNull
    private byte[] e() {
        if (this.f16858d == null) {
            this.f16858d = this.f16857c.getBytes(c.f16793b);
        }
        return this.f16858d;
    }

    @NonNull
    public static <T> e<T> f(@NonNull String str) {
        return new e<>(str, null, c());
    }

    @NonNull
    public static <T> e<T> g(@NonNull String str, @NonNull T t3) {
        return new e<>(str, t3, c());
    }

    @Nullable
    public T d() {
        return this.f16855a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f16857c.equals(((e) obj).f16857c);
        }
        return false;
    }

    public int hashCode() {
        return this.f16857c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f16857c + "'}";
    }

    public void update(@NonNull T t3, @NonNull MessageDigest messageDigest) {
        this.f16856b.update(e(), t3, messageDigest);
    }
}
