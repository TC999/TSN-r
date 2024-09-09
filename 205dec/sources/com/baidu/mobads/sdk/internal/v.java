package com.baidu.mobads.sdk.internal;

import java.util.Observer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface v {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        NONE(-1, "\u672a\u5f00\u59cb"),
        INITING(0, "\u4e0b\u8f7d\u51c6\u5907\u4e2d"),
        DOWNLOADING(1, "\u6b63\u5728\u4e0b\u8f7d"),
        CANCELLED(2, "\u5df2\u53d6\u6d88\u4e0b\u8f7d"),
        COMPLETED(3, "\u4e0b\u8f7d\u5b8c\u6210"),
        ERROR(4, "\u4e0b\u8f7d\u5931\u8d25"),
        COMPLETE_BUT_FILE_REMOVED(5, "\u4e0b\u8f7d\u5b8c\u4f46\u6587\u4ef6\u5f02\u5e38"),
        PAUSED(6, "\u5df2\u6682\u505c\u4e0b\u8f7d");
        

        /* renamed from: i  reason: collision with root package name */
        private int f12918i;

        /* renamed from: j  reason: collision with root package name */
        private String f12919j;

        a(int i4, String str) {
            this.f12918i = i4;
            this.f12919j = str;
        }

        public int b() {
            return this.f12918i;
        }

        public String c() {
            return this.f12919j;
        }
    }

    void a();

    void a(boolean z3);

    void addObserver(Observer observer);

    void b();

    void c();

    void d();

    String e();

    String f();

    String g();

    String h();

    String i();

    int j();

    float k();

    a l();

    void m();

    boolean n();
}
