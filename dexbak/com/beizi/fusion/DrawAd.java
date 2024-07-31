package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.p066d.DrawAdManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrawAd {

    /* renamed from: a */
    private DrawAdManager f10837a;

    public DrawAd(Context context, String str, DrawAdListener drawAdListener, long j) {
        this.f10837a = new DrawAdManager(context, str, drawAdListener, j);
    }

    public void destroy() {
        DrawAdManager drawAdManager = this.f10837a;
        if (drawAdManager != null) {
            drawAdManager.m48645c();
        }
    }

    public void loadAd() {
        DrawAdManager drawAdManager = this.f10837a;
        if (drawAdManager != null) {
            drawAdManager.m48646b();
        }
    }
}
