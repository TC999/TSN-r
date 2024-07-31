package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.p066d.NativeFloatManager;
import com.kuaishou.weapon.p205p0.C7282g;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeFloatAd {

    /* renamed from: a */
    private NativeFloatManager f10841a;

    @RequiresPermission(C7282g.f24943a)
    public NativeFloatAd(Context context, String str, NativeFloatAdListener nativeFloatAdListener) {
        NativeFloatManager nativeFloatManager = new NativeFloatManager(context, str, nativeFloatAdListener, 10000L);
        this.f10841a = nativeFloatManager;
        nativeFloatManager.m48751a((ViewGroup) null);
    }

    public void destroy() {
        NativeFloatManager nativeFloatManager = this.f10841a;
        if (nativeFloatManager != null) {
            nativeFloatManager.m48673n();
        }
    }

    @RequiresPermission(C7282g.f24943a)
    public NativeFloatAd(Context context, String str, NativeFloatAdListener nativeFloatAdListener, long j) {
        NativeFloatManager nativeFloatManager = new NativeFloatManager(context, str, nativeFloatAdListener, j);
        this.f10841a = nativeFloatManager;
        nativeFloatManager.m48751a((ViewGroup) null);
    }
}
