package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.by */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface IDownloadListener {

    /* compiled from: IDownloadListener.java */
    /* renamed from: com.amap.api.col.3l.by$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1754a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        

        /* renamed from: f */
        private int f3707f;

        EnumC1754a(int i) {
            this.f3707f = i;
        }
    }

    /* renamed from: a */
    void mo55528a(long j, long j2);

    /* renamed from: a */
    void mo55527a(EnumC1754a enumC1754a);

    /* renamed from: m */
    void mo55526m();

    /* renamed from: n */
    void mo55525n();

    /* renamed from: o */
    void mo55524o();
}
