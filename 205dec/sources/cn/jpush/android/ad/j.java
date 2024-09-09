package cn.jpush.android.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j {
    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (Build.VERSION.SDK_INT >= 33) {
            StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(broadcastReceiver, intentFilter, str, handler, 2);
        } else {
            StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
    }
}
