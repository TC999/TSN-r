package com.amap.api.col.p0463l;

import android.text.TextUtils;
import java.util.Vector;

/* renamed from: com.amap.api.col.3l.c5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LogMemCacher {

    /* renamed from: d */
    private static int f3734d = 100;

    /* renamed from: e */
    private static int f3735e = 10000;

    /* renamed from: a */
    private Vector<AMapLogEntity> f3736a;

    /* renamed from: b */
    private int f3737b;

    /* renamed from: c */
    private int f3738c;

    public LogMemCacher() {
        this.f3738c = 0;
        this.f3737b = 10;
        this.f3736a = new Vector<>();
    }

    /* renamed from: a */
    public final Vector<AMapLogEntity> m55470a() {
        return this.f3736a;
    }

    /* renamed from: b */
    public final synchronized void m55469b(AMapLogEntity aMapLogEntity) {
        if (aMapLogEntity != null) {
            if (!TextUtils.isEmpty(aMapLogEntity.m53326g())) {
                this.f3736a.add(aMapLogEntity);
                this.f3738c += aMapLogEntity.m53326g().getBytes().length;
            }
        }
    }

    /* renamed from: c */
    public final synchronized boolean m55468c(String str) {
        if (str == null) {
            return false;
        }
        if (this.f3736a.size() >= this.f3737b) {
            return true;
        }
        return this.f3738c + str.getBytes().length > f3735e;
    }

    /* renamed from: d */
    public final synchronized void m55467d() {
        this.f3736a.clear();
        this.f3738c = 0;
    }

    public LogMemCacher(byte b) {
        this.f3737b = f3734d;
        this.f3738c = 0;
        this.f3736a = new Vector<>();
    }
}
