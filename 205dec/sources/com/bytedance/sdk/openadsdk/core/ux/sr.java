package com.bytedance.sdk.openadsdk.core.ux;

import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    private static sr ux = new sr();

    /* renamed from: c  reason: collision with root package name */
    private me f35103c;
    private volatile com.bytedance.sdk.component.c sr;

    /* renamed from: w  reason: collision with root package name */
    private int f35104w;
    private int xv;

    public static sr c() {
        return ux;
    }

    private boolean w() {
        this.sr = LogAdapter.sAdapter;
        return this.sr != null;
    }

    private String xv() {
        me meVar = this.f35103c;
        return meVar != null ? com.bytedance.sdk.component.utils.c.c(meVar.mo()).toString() : "";
    }

    public sr c(me meVar) {
        if (w()) {
            this.f35103c = meVar;
        }
        return this;
    }

    public sr w(int i4) {
        if (w()) {
            this.xv = i4;
        }
        return this;
    }

    public sr c(int i4) {
        if (w()) {
            this.f35104w = i4;
        }
        return this;
    }

    public void c(Thread thread, Throwable th) {
        String str;
        if (w()) {
            if (thread != null) {
                str = thread.getName() + "-" + thread.getId();
            } else {
                str = "";
            }
            this.sr.xv(str, "-------fatal----------");
            this.sr.xv(str, "last show rit:" + this.xv);
            this.sr.xv(str, "last show adtype:" + this.f35104w);
            this.sr.xv(str, xv());
            this.sr.c(str, th);
            this.sr.xv(str, "-------finish----------");
            LogAdapter.sAdapter.c().flush();
        }
    }
}
