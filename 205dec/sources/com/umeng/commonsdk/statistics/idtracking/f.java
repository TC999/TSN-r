package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ImeiTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53633a = "imei";

    /* renamed from: b  reason: collision with root package name */
    private Context f53634b;

    public f(Context context) {
        super("imei");
        this.f53634b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f53634b);
    }
}
