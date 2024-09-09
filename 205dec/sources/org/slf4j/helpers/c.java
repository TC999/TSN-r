package org.slf4j.helpers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FormattingTuple.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static c f61745d = new c(null);

    /* renamed from: a  reason: collision with root package name */
    private String f61746a;

    /* renamed from: b  reason: collision with root package name */
    private Throwable f61747b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f61748c;

    public c(String str) {
        this(str, null, null);
    }

    public Object[] a() {
        return this.f61748c;
    }

    public String b() {
        return this.f61746a;
    }

    public Throwable c() {
        return this.f61747b;
    }

    public c(String str, Object[] objArr, Throwable th) {
        this.f61746a = str;
        this.f61747b = th;
        this.f61748c = objArr;
    }
}
