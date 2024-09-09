package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.d.p;
import com.bykv.vk.component.ttvideo.ILivePlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NativeFloatAd {

    /* renamed from: a  reason: collision with root package name */
    private p f14406a;

    @RequiresPermission("android.permission.INTERNET")
    public NativeFloatAd(Context context, String str, NativeFloatAdListener nativeFloatAdListener) {
        p pVar = new p(context, str, nativeFloatAdListener, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        this.f14406a = pVar;
        pVar.a((ViewGroup) null);
    }

    public void destroy() {
        p pVar = this.f14406a;
        if (pVar != null) {
            pVar.n();
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public NativeFloatAd(Context context, String str, NativeFloatAdListener nativeFloatAdListener, long j4) {
        p pVar = new p(context, str, nativeFloatAdListener, j4);
        this.f14406a = pVar;
        pVar.a((ViewGroup) null);
    }
}
