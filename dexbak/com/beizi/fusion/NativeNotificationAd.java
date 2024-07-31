package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.p066d.NativeNotificationManager;
import com.kuaishou.weapon.p205p0.C7282g;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeNotificationAd {

    /* renamed from: a */
    private NativeNotificationManager f10842a;

    @RequiresPermission(C7282g.f24943a)
    public NativeNotificationAd(Context context, String str, NativeNotificationAdListener nativeNotificationAdListener) {
        NativeNotificationManager nativeNotificationManager = new NativeNotificationManager(context, str, nativeNotificationAdListener, 10000L);
        this.f10842a = nativeNotificationManager;
        nativeNotificationManager.m48751a((ViewGroup) null);
    }

    public void destroy() {
        NativeNotificationManager nativeNotificationManager = this.f10842a;
        if (nativeNotificationManager != null) {
            nativeNotificationManager.m48673n();
        }
    }

    @RequiresPermission(C7282g.f24943a)
    public NativeNotificationAd(Context context, String str, NativeNotificationAdListener nativeNotificationAdListener, long j) {
        NativeNotificationManager nativeNotificationManager = new NativeNotificationManager(context, str, nativeNotificationAdListener, j);
        this.f10842a = nativeNotificationManager;
        nativeNotificationManager.m48751a((ViewGroup) null);
    }
}
