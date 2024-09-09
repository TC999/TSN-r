package com.bytedance.sdk.component.r.w.c.c.w;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends f {
    public sr(Context context, com.bytedance.sdk.component.r.w.sr.w.c cVar, com.bytedance.sdk.component.r.c.ux uxVar) {
        super(context, cVar, uxVar);
    }

    public static String w(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0 , " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0)";
    }

    public static String xv(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0";
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.f, com.bytedance.sdk.component.r.w.c.c.w.w
    public String c() {
        com.bytedance.sdk.component.r.c.f w3 = ((f) this).f30060w.w();
        if (w3 != null) {
            return w3.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.f
    public byte w() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.f
    public byte xv() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.f, com.bytedance.sdk.component.r.w.c.c
    public boolean c(com.bytedance.sdk.component.r.c.w wVar) {
        return com.bytedance.sdk.component.r.w.xv.c.c(wVar);
    }
}
