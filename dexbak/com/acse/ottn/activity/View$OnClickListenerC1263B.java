package com.acse.ottn.activity;

import android.util.Log;
import android.view.View;

/* renamed from: com.acse.ottn.activity.B */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1263B implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PicToPicActivity f2104a;

    View$OnClickListenerC1263B(PicToPicActivity picToPicActivity) {
        this.f2104a = picToPicActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean m57297h;
        String str;
        m57297h = this.f2104a.m57297h();
        if (m57297h) {
            this.f2104a.m57299f();
            return;
        }
        str = PicToPicActivity.TAG;
        Log.d(str, "无法进入PIP模式");
        this.f2104a.finish();
    }
}
