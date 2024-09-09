package com.bytedance.pangle.log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f28833a;

    /* renamed from: b  reason: collision with root package name */
    private String f28834b;

    /* renamed from: c  reason: collision with root package name */
    private String f28835c;

    /* renamed from: d  reason: collision with root package name */
    private long f28836d;

    /* renamed from: e  reason: collision with root package name */
    private long f28837e;

    private a(String str, String str2, String str3) {
        this.f28833a = str;
        this.f28834b = str2;
        this.f28835c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f28837e = currentTimeMillis;
        this.f28836d = currentTimeMillis;
        String str4 = this.f28833a;
        ZeusLogger.i(str4, this.f28834b + String.format(" watcher[%s]-start", str3));
    }

    public static a a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    public final long a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f28837e;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f28836d;
        String str2 = this.f28833a;
        ZeusLogger.i(str2, this.f28834b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f28835c, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }

    public final long a() {
        return System.currentTimeMillis() - this.f28836d;
    }
}
