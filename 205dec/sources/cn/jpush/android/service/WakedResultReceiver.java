package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class WakedResultReceiver extends BroadcastReceiver {
    public static final String CONTEXT_KEY = "1";
    public static final String WAKE_TYPE_KEY = "2";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
    }

    public void onWake(int i4) {
    }

    public void onWake(Context context, int i4) {
    }

    public final void onWakeMap(Map map) {
        try {
            Object obj = map.get("2");
            int intValue = obj != null ? ((Integer) obj).intValue() : -1;
            onWake(intValue);
            Object obj2 = map.get("1");
            onWake(obj2 != null ? (Context) obj2 : null, intValue);
        } catch (Throwable unused) {
        }
    }
}
