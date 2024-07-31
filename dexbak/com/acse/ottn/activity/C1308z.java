package com.acse.ottn.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.acse.ottn.activity.z */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1308z extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PicToPicActivity f2214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1308z(PicToPicActivity picToPicActivity) {
        this.f2214a = picToPicActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        str = PicToPicActivity.TAG;
        Log.d(str, "收到广播");
        PicToPicActivity picToPicActivity = this.f2214a;
        picToPicActivity.unregisterReceiver(picToPicActivity.f2138s);
        this.f2214a.finish();
    }
}
