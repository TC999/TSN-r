package com.amap.api.col.p0463l;

import java.util.List;

/* renamed from: com.amap.api.col.3l.f8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class UploadBufferBuilder extends AbstractBuilder {

    /* renamed from: c */
    private static UploadBufferBuilder f4167c = new UploadBufferBuilder();

    private UploadBufferBuilder() {
        super(5120);
    }

    /* renamed from: b */
    private static String m55021b(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: d */
    public static UploadBufferBuilder m55019d() {
        return f4167c;
    }

    /* renamed from: c */
    public final byte[] m55020c(byte[] bArr, byte[] bArr2, List<? extends CollectionData> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            m55446a();
            int m54462c = RootTUploadData.m54462c(this.f3746a, bArr);
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                CollectionData collectionData = list.get(i);
                iArr[i] = TData.m54025b(this.f3746a, (byte) collectionData.m54650a(), TData.m54024c(this.f3746a, collectionData.m54649b()));
            }
            this.f3746a.m53683w(RootTUploadData.m54463b(this.f3746a, m54462c, bArr2 != null ? RootTUploadData.m54459f(this.f3746a, bArr2) : 0, RootTUploadData.m54461d(this.f3746a, iArr)));
            return this.f3746a.m53680z();
        } catch (Throwable th) {
            ALLog.m54456a(th);
            return null;
        }
    }

    /* renamed from: e */
    public final byte[] m55018e() {
        super.m55446a();
        try {
            this.f3746a.m53683w(THeader.m54568b(this.f3746a, HeaderConfig.m54625a(), this.f3746a.mo53704b(HeaderConfig.m54613m()), this.f3746a.mo53704b(HeaderConfig.m54619g()), (byte) HeaderConfig.m54632A(), this.f3746a.mo53704b(HeaderConfig.m54607s()), this.f3746a.mo53704b(HeaderConfig.m54609q()), this.f3746a.mo53704b(m55021b(HeaderConfig.m54611o())), this.f3746a.mo53704b(m55021b(HeaderConfig.m54605u())), AmapWifi.m54648a(HeaderConfig.m54630C()), this.f3746a.mo53704b(HeaderConfig.m54601y()), this.f3746a.mo53704b(HeaderConfig.m54603w()), this.f3746a.mo53704b(HeaderConfig.m54617i()), this.f3746a.mo53704b(HeaderConfig.m54615k())));
            return this.f3746a.m53680z();
        } catch (Exception e) {
            ALLog.m54456a(e);
            return null;
        }
    }
}
