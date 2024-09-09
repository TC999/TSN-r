package com.acse.ottn.activity;

import android.util.Log;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class B implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PicToPicActivity f4659a;

    B(PicToPicActivity picToPicActivity) {
        this.f4659a = picToPicActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4659a.g()) {
            this.f4659a.d();
            return;
        }
        Log.d(PicToPicActivity.f4676u, "\u65e0\u6cd5\u8fdb\u5165PIP\u6a21\u5f0f");
        this.f4659a.finish();
    }
}
