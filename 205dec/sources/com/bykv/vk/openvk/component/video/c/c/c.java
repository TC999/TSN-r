package com.bykv.vk.openvk.component.video.c.c;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bykv.vk.openvk.component.video.c.c.c.w;
import com.bykv.vk.openvk.component.video.c.c.c.xv;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends MediaDataSource {

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f24972c = new ConcurrentHashMap<>();
    private final Context sr;
    private final sr ux;

    /* renamed from: w  reason: collision with root package name */
    private final xv f24973w;
    private long xv = -2147483648L;

    public c(Context context, sr srVar) {
        this.sr = context;
        this.ux = srVar;
        this.f24973w = new w(context, srVar);
    }

    public sr c() {
        return this.ux;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.bykv.vk.openvk.component.video.api.f.xv.w("SdkMediaDataSource", "close: ", this.ux.fp());
        xv xvVar = this.f24973w;
        if (xvVar != null) {
            xvVar.w();
        }
        f24972c.remove(this.ux.ia());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.xv == -2147483648L) {
            if (this.sr == null || TextUtils.isEmpty(this.ux.fp())) {
                return -1L;
            }
            this.xv = this.f24973w.xv();
            com.bykv.vk.openvk.component.video.api.f.xv.w("SdkMediaDataSource", "getSize: " + this.xv);
        }
        return this.xv;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j4, byte[] bArr, int i4, int i5) throws IOException {
        int c4 = this.f24973w.c(j4, bArr, i4, i5);
        com.bykv.vk.openvk.component.video.api.f.xv.w("SdkMediaDataSource", "readAt: position = " + j4 + "  buffer.length =" + bArr.length + "  offset = " + i4 + " size =" + c4 + "  current = " + Thread.currentThread());
        return c4;
    }

    public static c c(Context context, sr srVar) {
        c cVar = new c(context, srVar);
        f24972c.put(srVar.ia(), cVar);
        return cVar;
    }
}
