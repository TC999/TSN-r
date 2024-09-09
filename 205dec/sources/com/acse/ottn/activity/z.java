package com.acse.ottn.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class z extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PicToPicActivity f4765a;

    z(PicToPicActivity picToPicActivity) {
        this.f4765a = picToPicActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d(PicToPicActivity.f4676u, "\u6536\u5230\u5e7f\u64ad");
        PicToPicActivity picToPicActivity = this.f4765a;
        picToPicActivity.unregisterReceiver(picToPicActivity.s);
        this.f4765a.finish();
    }
}
