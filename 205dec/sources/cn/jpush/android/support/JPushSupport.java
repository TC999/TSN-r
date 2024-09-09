package cn.jpush.android.support;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.MultiActionsNotificationBuilder;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.PushNotificationBuilder;
import cn.jpush.android.cache.a;
import cn.jpush.android.helper.Logger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JPushSupport {

    /* renamed from: a  reason: collision with root package name */
    private static final Integer f4352a = 0;

    public static PushNotificationBuilder getNotificationBuilder(Context context, NotificationMessage notificationMessage) {
        try {
            int i4 = notificationMessage.notificationBuilderId;
            if (i4 < 1) {
                i4 = f4352a.intValue();
            }
            String d4 = a.d(context, i4 + "");
            if (TextUtils.isEmpty(d4)) {
                Logger.d("JPushSupport", "not found custom notification");
                return null;
            }
            Logger.ii("JPushSupport", "get customBuilder:" + d4);
            if (!d4.startsWith("basic") && !d4.startsWith("custom")) {
                return MultiActionsNotificationBuilder.parseFromPreference(context, d4);
            }
            return BasicPushNotificationBuilder.parseFromPreference(context, d4);
        } catch (Throwable th) {
            Logger.ww("JPushSupport", "getNotification failed:" + th.getMessage());
            return null;
        }
    }
}
