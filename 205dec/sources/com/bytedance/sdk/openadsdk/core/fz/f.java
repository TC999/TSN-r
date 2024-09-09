package com.bytedance.sdk.openadsdk.core.fz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.openadsdk.core.gd;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements com.bytedance.sdk.component.r.c.f {

    /* renamed from: c  reason: collision with root package name */
    public static final f f33675c = new f();

    /* renamed from: w  reason: collision with root package name */
    private volatile SQLiteDatabase f33676w;

    @Override // com.bytedance.sdk.component.r.c.f
    public SQLiteDatabase c(Context context) {
        if (this.f33676w == null) {
            synchronized (f.class) {
                if (this.f33676w == null) {
                    gd.xv c4 = com.bytedance.sdk.openadsdk.core.ev.c(ls.getContext()).c();
                    c4.c();
                    this.f33676w = c4.w();
                }
            }
        }
        return this.f33676w;
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String c() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String f() {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String sr() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String ux() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String w() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String xv() {
        return null;
    }
}
