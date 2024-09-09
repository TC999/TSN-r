package com.jg.ids.meizu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class MeiZuReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (context != null && intent != null) {
            try {
                int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
                if (intExtra != 1 ? intExtra != 2 || ((stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList")) != null && stringArrayListExtra.contains(context.getPackageName())) : TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                    String stringExtra = intent.getStringExtra("openIdType");
                    if ("aaid".equals(stringExtra)) {
                        a.a().a(2);
                    } else if ("vaid".equals(stringExtra)) {
                        a.a().a(1);
                    } else if (AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY.equals(stringExtra)) {
                        a.a().a(0);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
