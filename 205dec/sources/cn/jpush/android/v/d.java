package cn.jpush.android.v;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {
    public static void a(Context context) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "clear_local_notify", new Bundle());
    }

    public static void a(Context context, long j4) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("local_notify_ID", Long.valueOf(j4));
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "rm_local_notify", bundle);
    }

    public static void a(Context context, JPushLocalNotification jPushLocalNotification) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("local_notify", jPushLocalNotification);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "add_local_notify", bundle);
    }
}
