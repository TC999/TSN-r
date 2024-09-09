package cn.jiguang.ap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i4 = Build.VERSION.SDK_INT;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        return i4 >= 33 ? origApplicationContext.registerReceiver(broadcastReceiver, intentFilter, 2) : origApplicationContext.registerReceiver(broadcastReceiver, intentFilter);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return Build.VERSION.SDK_INT >= 33 ? StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(broadcastReceiver, intentFilter, str, handler, 2) : StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }
}
