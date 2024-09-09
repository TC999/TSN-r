package com.bytedance.msdk.xv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk implements com.bytedance.sdk.component.r.c.f {

    /* renamed from: c  reason: collision with root package name */
    public static final bk f28469c = new bk();

    /* renamed from: w  reason: collision with root package name */
    private volatile SQLiteDatabase f28470w;

    @Override // com.bytedance.sdk.component.r.c.f
    public SQLiteDatabase c(Context context) {
        if (this.f28470w == null) {
            synchronized (this) {
                if (this.f28470w == null) {
                    this.f28470w = com.bytedance.msdk.xv.c.r.c(context).c().c();
                    com.bytedance.msdk.adapter.sr.xv.c("---------------DB CREATE  SUCCESS new------------");
                }
            }
        }
        return this.f28470w;
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String c() {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String f() {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String sr() {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String ux() {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String w() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.r.c.f
    public String xv() {
        return "adevent_applog";
    }
}
