package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: IDownloadListener.java */
/* renamed from: com.amap.api.col.3l.by  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface by {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: IDownloadListener.java */
    /* renamed from: com.amap.api.col.3l.by$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        

        /* renamed from: f  reason: collision with root package name */
        private int f7289f;

        a(int i4) {
            this.f7289f = i4;
        }
    }

    void a(long j4, long j5);

    void d();

    void e(a aVar);

    void m();

    void n();
}
