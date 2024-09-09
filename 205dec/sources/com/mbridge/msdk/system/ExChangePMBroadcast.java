package com.mbridge.msdk.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ExChangePMBroadcast extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        if (context == null || intent == null) {
            return;
        }
        try {
            str = intent.getAction();
        } catch (Exception unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || !str.equals("mbridge_action_exchange_pm")) {
            return;
        }
        try {
            str2 = intent.getExtras().getString("pm-sender");
        } catch (Exception unused2) {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, context.getPackageName())) {
            return;
        }
        try {
            abortBroadcast();
        } catch (Exception unused3) {
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("pm-receiver", context.getPackageName());
            Intent intent2 = new Intent("mbridge_action_exchange_pm_receiver");
            intent2.putExtras(bundle);
            context.sendOrderedBroadcast(intent2, null);
        } catch (Exception unused4) {
        }
    }
}
