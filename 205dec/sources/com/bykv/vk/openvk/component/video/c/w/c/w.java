package com.bykv.vk.openvk.component.video.c.w.c;

import android.content.Context;
import com.bykv.vk.openvk.component.video.c.w.sr;
import com.bykv.vk.openvk.component.video.c.w.ux;
import com.bytedance.sdk.component.gd.p;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {

    /* renamed from: c  reason: collision with root package name */
    public final File f25055c;

    public void c() {
        com.bykv.vk.openvk.component.video.c.xv.c.c(new p("clear") { // from class: com.bykv.vk.openvk.component.video.c.w.c.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.w();
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.c.c
    public File sr(String str) {
        return ux(str);
    }

    File ux(String str) {
        return new File(this.f25055c, str);
    }

    public void w() {
        sr.xv().sr();
        Context context = ux.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.c.w.w.xv.c(context).c(1);
        }
        for (File file : this.f25055c.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.c.c
    public File xv(String str) {
        return ux(str);
    }
}
