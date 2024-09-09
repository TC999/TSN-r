package cn.jpush.android.api;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.x.a;
import cn.jpush.android.x.b;
import cn.jpush.android.x.g;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DefaultPushNotificationBuilder implements PushNotificationBuilder {
    public static final int NOTI_STYLE_BIG_PICTURE = 3;
    public static final int NOTI_STYLE_BIG_TEXT = 1;
    public static final int NOTI_STYLE_INBOX = 2;
    private static final String TAG = "DefaultPushNotificationBuilder";
    protected Context context;
    private NotificationMessage notificationMessage;

    RemoteViews buildContentView(String str, String str2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0169  */
    @Override // cn.jpush.android.api.PushNotificationBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.app.Notification buildNotification(android.content.Context r4, cn.jpush.android.api.NotificationMessage r5) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.DefaultPushNotificationBuilder.buildNotification(android.content.Context, cn.jpush.android.api.NotificationMessage):android.app.Notification");
    }

    @Override // cn.jpush.android.api.PushNotificationBuilder
    public Notification buildNotification(Map<String, String> map) {
        String str;
        int i4;
        Context context = this.context;
        if (context == null) {
            Logger.w(TAG, "Can't find valid context when build notification.");
            return null;
        }
        try {
            str = context.getApplicationInfo().loadLabel(this.context.getPackageManager()).toString();
        } catch (Throwable unused) {
            str = null;
        }
        if (map.containsKey(JPushInterface.EXTRA_MSG_ID)) {
            map.get(JPushInterface.EXTRA_MSG_ID);
        }
        String str2 = map.containsKey(JPushInterface.EXTRA_ALERT) ? map.get(JPushInterface.EXTRA_ALERT) : "";
        if (TextUtils.isEmpty(str2)) {
            Logger.ww(TAG, "No notification content to show. Give up.");
            return null;
        }
        if (map.containsKey(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON)) {
            map.get(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON);
        }
        String str3 = map.containsKey(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON) ? map.get(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON) : "";
        if (map.containsKey(JPushInterface.EXTRA_NOTIFICATION_TITLE)) {
            str = map.get(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        }
        String str4 = map.containsKey(JPushInterface.EXTRA_BIG_TEXT) ? map.get(JPushInterface.EXTRA_BIG_TEXT) : "";
        String str5 = map.containsKey(JPushInterface.EXTRA_INBOX) ? map.get(JPushInterface.EXTRA_INBOX) : "";
        int parseInt = map.containsKey(JPushInterface.EXTRA_NOTI_PRIORITY) ? Integer.parseInt(map.get(JPushInterface.EXTRA_NOTI_PRIORITY)) : 0;
        int parseInt2 = map.containsKey(JPushInterface.EXTRA_NOTI_IMPORTANCE) ? Integer.parseInt(map.get(JPushInterface.EXTRA_NOTI_IMPORTANCE)) : -1;
        String str6 = map.containsKey(JPushInterface.EXTRA_NOTI_CATEGORY) ? map.get(JPushInterface.EXTRA_NOTI_CATEGORY) : "";
        String str7 = map.containsKey(JPushInterface.EXTRA_BIG_PIC_PATH) ? map.get(JPushInterface.EXTRA_BIG_PIC_PATH) : "";
        int parseInt3 = map.containsKey(JPushInterface.EXTRA_ALERT_TYPE) ? Integer.parseInt(map.get(JPushInterface.EXTRA_ALERT_TYPE)) : -1;
        int i5 = (parseInt3 < -1 || parseInt3 > 7) ? -1 : parseInt3;
        RemoteViews buildContentView = buildContentView(str2, str);
        int i6 = Build.VERSION.SDK_INT;
        Notification.Builder builder = new Notification.Builder(this.context);
        builder.setContentTitle(str).setContentText(str2).setTicker(str2);
        int a4 = g.a(this.context);
        if (a4 != 0) {
            Logger.dd(TAG, "setSmallIcon with resId:" + a4);
        } else {
            Logger.ww(TAG, "not found small icon in your app,will setSmallIcon with android.R.color.transparent ");
            a4 = 17170445;
        }
        builder.setSmallIcon(a4);
        Object b4 = b.b(this.context, str3);
        if (i6 >= 23) {
            if (b4 instanceof Icon) {
                builder.setLargeIcon((Icon) b4);
            } else if (b4 instanceof Bitmap) {
                builder.setLargeIcon((Bitmap) b4);
            }
        }
        builder.setShowWhen(true);
        Context context2 = this.context;
        NotificationMessage notificationMessage = this.notificationMessage;
        int i7 = i5;
        String str8 = str7;
        a.a(context2, builder, notificationMessage != null ? notificationMessage.notificationChannelId : "", "", parseInt, i7, (String) null, parseInt2);
        if (buildContentView == null) {
            if (!TextUtils.isEmpty(str4)) {
                Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                bigTextStyle.bigText(str4);
                builder.setStyle(bigTextStyle);
            }
            if (!TextUtils.isEmpty(str5)) {
                Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                try {
                    TreeMap treeMap = new TreeMap();
                    JSONObject jSONObject = new JSONObject(str5);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        treeMap.put(next, jSONObject.optString(next));
                    }
                    for (String str9 : treeMap.values()) {
                        inboxStyle.addLine(str9);
                    }
                    inboxStyle.setSummaryText(" + " + jSONObject.length() + " new messages");
                } catch (Throwable th) {
                    Logger.ee(TAG, "Set inbox style error: " + th.getMessage());
                }
                builder.setStyle(inboxStyle);
            }
            if (!TextUtils.isEmpty(str8)) {
                Logger.i(TAG, "Set notification BPS with picture path:" + str8);
                try {
                    Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                    bigPictureStyle.bigPicture(BitmapFactory.decodeFile(str8));
                    builder.setStyle(bigPictureStyle);
                } catch (Throwable unused2) {
                    Logger.ww(TAG, "Create big picture style failed.");
                }
            }
        }
        if (parseInt != 0) {
            if (parseInt != 1) {
                int i8 = 2;
                if (parseInt != 2) {
                    if (parseInt == -1) {
                        builder.setPriority(-1);
                    } else {
                        i8 = -2;
                        i4 = parseInt != -2 ? 0 : 1;
                    }
                }
                builder.setPriority(i8);
            }
            builder.setPriority(i4);
        }
        if (!TextUtils.isEmpty(str6) && Build.VERSION.SDK_INT >= 21) {
            builder.setCategory(str6);
        }
        if (buildContentView != null) {
            builder.setContent(buildContentView);
            if (this.context.getApplicationInfo().targetSdkVersion >= 31 && Build.VERSION.SDK_INT >= 24) {
                builder.setCustomBigContentView(buildContentView);
            }
        } else {
            Logger.i(TAG, " Use default notification view! ");
        }
        builder.setDefaults(i7);
        return getNotification(builder);
    }

    @Override // cn.jpush.android.api.PushNotificationBuilder
    public String getDeveloperArg0() {
        return null;
    }

    Notification getNotification(Notification.Builder builder) {
        try {
            return builder.build();
        } catch (Throwable th) {
            Logger.ww(TAG, "Build notification error:", th);
            return null;
        }
    }

    void resetNotificationParams(Notification notification) {
    }

    public String toString() {
        return "";
    }
}
