package com.bytedance.sdk.component.r.w.c.c.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.bytedance.sdk.component.r.c.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements f {

    /* renamed from: c  reason: collision with root package name */
    public static final w f30055c = new w();

    /* renamed from: w  reason: collision with root package name */
    private volatile SQLiteDatabase f30056w;

    @Override // com.bytedance.sdk.component.r.c.f
    public SQLiteDatabase c(Context context) {
        if (this.f30056w == null) {
            synchronized (this) {
                if (this.f30056w == null) {
                    this.f30056w = new c(context, this).getWritableDatabase();
                    Log.d("log_default", "---------------DB CREATE  SUCCESS------------");
                }
            }
        }
        return this.f30056w;
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
