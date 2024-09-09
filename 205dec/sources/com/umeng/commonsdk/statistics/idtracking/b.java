package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: AndroidIdTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53615a = "android_id";

    /* renamed from: b  reason: collision with root package name */
    private Context f53616b;

    public b(Context context) {
        super("android_id");
        this.f53616b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getAndroidId(this.f53616b);
    }
}
