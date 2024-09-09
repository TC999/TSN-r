package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.d.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DrawAd {

    /* renamed from: a  reason: collision with root package name */
    private i f14402a;

    public DrawAd(Context context, String str, DrawAdListener drawAdListener, long j4) {
        this.f14402a = new i(context, str, drawAdListener, j4);
    }

    public void destroy() {
        i iVar = this.f14402a;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void loadAd() {
        i iVar = this.f14402a;
        if (iVar != null) {
            iVar.b();
        }
    }
}
