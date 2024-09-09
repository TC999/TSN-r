package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.beizi.fusion.d.v;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class UnifiedCustomAd {

    /* renamed from: a  reason: collision with root package name */
    private v f14416a;

    public UnifiedCustomAd(Context context, String str, NativeAdListener nativeAdListener, long j4, int i4) {
        this.f14416a = new v(context, str, nativeAdListener, j4, i4);
    }

    public void destroy() {
        v vVar = this.f14416a;
        if (vVar != null) {
            vVar.B();
        }
    }

    public boolean isLoaded() {
        v vVar = this.f14416a;
        if (vVar != null) {
            return vVar.c();
        }
        return false;
    }

    public void loadAd() {
        v vVar = this.f14416a;
        if (vVar != null) {
            vVar.b();
        }
    }

    public void resume() {
        v vVar = this.f14416a;
        if (vVar != null) {
            vVar.C();
        }
    }

    public void showAd(@NonNull Activity activity) {
        v vVar = this.f14416a;
        if (vVar != null) {
            vVar.a(activity);
        }
    }
}
