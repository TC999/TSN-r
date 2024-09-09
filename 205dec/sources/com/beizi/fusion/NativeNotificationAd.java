package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.d.q;
import com.bykv.vk.component.ttvideo.ILivePlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NativeNotificationAd {

    /* renamed from: a  reason: collision with root package name */
    private q f14407a;

    @RequiresPermission("android.permission.INTERNET")
    public NativeNotificationAd(Context context, String str, NativeNotificationAdListener nativeNotificationAdListener) {
        q qVar = new q(context, str, nativeNotificationAdListener, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        this.f14407a = qVar;
        qVar.a((ViewGroup) null);
    }

    public void destroy() {
        q qVar = this.f14407a;
        if (qVar != null) {
            qVar.n();
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public NativeNotificationAd(Context context, String str, NativeNotificationAdListener nativeNotificationAdListener, long j4) {
        q qVar = new q(context, str, nativeNotificationAdListener, j4);
        this.f14407a = qVar;
        qVar.a((ViewGroup) null);
    }
}
