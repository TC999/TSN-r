package com.umeng.commonsdk.statistics.idtracking;

import android.annotation.TargetApi;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SerialTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53642a = "serial";

    public i() {
        super("serial");
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    @TargetApi(9)
    public String f() {
        return DeviceConfig.getSerial();
    }
}
