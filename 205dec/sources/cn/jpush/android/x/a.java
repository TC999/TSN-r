package cn.jpush.android.x;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: cn.jpush.android.x.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class C0073a {

        /* renamed from: a  reason: collision with root package name */
        public String f4518a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f4519b;

        /* renamed from: c  reason: collision with root package name */
        public int f4520c;

        /* renamed from: d  reason: collision with root package name */
        public int f4521d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4522e;

        /* renamed from: f  reason: collision with root package name */
        public int f4523f;

        /* renamed from: g  reason: collision with root package name */
        public String f4524g;

        /* renamed from: h  reason: collision with root package name */
        public Uri f4525h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f4526i;

        public C0073a(String str, CharSequence charSequence, int i4, int i5, String str2, int i6) {
            this.f4518a = str;
            this.f4519b = charSequence;
            this.f4520c = i4;
            this.f4523f = i5;
            this.f4524g = str2;
            this.f4521d = i6;
            this.f4522e = -1 != i6;
        }
    }

    public static int a(int i4) {
        if (i4 != -2) {
            if (i4 != -1) {
                return (i4 == 1 || i4 == 2) ? 4 : 3;
            }
            return 2;
        }
        return 1;
    }

    private static String a(Context context, int i4) {
        boolean z3;
        String str;
        String str2 = i4 != -2 ? i4 != -1 ? (i4 == 1 || i4 == 2) ? "HIGH" : "DEFAULT" : "LOW" : "MIN";
        String str3 = "";
        try {
            String str4 = "jg_channel_name_p_" + str2.toLowerCase();
            int identifier = context.getResources().getIdentifier(str4, "string", context.getPackageName());
            if (identifier != 0) {
                str3 = context.getResources().getString(identifier);
                str = "found " + str3 + " from resource by name:" + str4;
            } else {
                str = "not found string value from resource by name:" + str4;
            }
            Logger.dd("ChannelHelper", str);
        } catch (Throwable th) {
            Logger.ww("ChannelHelper", "get resource channel ID failed:" + th.getMessage());
        }
        if (TextUtils.isEmpty(str3)) {
            try {
                z3 = Locale.getDefault().getLanguage().contains("zh");
            } catch (Throwable th2) {
                Logger.ww("ChannelHelper", "get language failed:" + th2.getMessage());
                z3 = true;
            }
            if (i4 == -2 || i4 == -1) {
                return z3 ? "\u4e0d\u91cd\u8981" : "LOW";
            } else if (i4 == 1 || i4 == 2) {
                return z3 ? "\u91cd\u8981" : "HIGH";
            } else {
                return z3 ? "\u666e\u901a" : "NORMAL";
            }
        }
        return str3;
    }

    private static String a(Context context, int i4, int i5) {
        int a4 = a(i4);
        String str = "JPush_" + a4 + "_" + i5;
        String a5 = a(context, i4);
        Logger.d("ChannelHelper", "channelId:" + str + ",channelName:" + a5 + ",importance:" + a4);
        return a(context, str, a5, a4, i5, null, false) ? str : "";
    }

    private static String a(C0073a c0073a) {
        String str = "JPush_" + c0073a.f4521d + "_" + c0073a.f4523f;
        if (c0073a.f4525h != null) {
            return str + "_" + c0073a.f4524g;
        }
        return str;
    }

    public static void a(Context context) {
        a(context, -1, 0);
        a(context, 0, 7);
    }

    public static void a(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i4, int i5, String str2, int i6) {
        C0073a c0073a = new C0073a(str, charSequence, i4, i5, str2, i6);
        a(context, c0073a);
        b.a(context, builder, c0073a);
    }

    public static void a(Context context, Notification notification, String str, CharSequence charSequence, int i4, int i5, String str2, int i6) {
        C0073a c0073a = new C0073a(str, charSequence, i4, i5, str2, i6);
        a(context, c0073a);
        b.a(notification, c0073a);
    }

    public static void a(Context context, C0073a c0073a) {
        NotificationChannel b4;
        NotificationChannel b5;
        if (b.c(context)) {
            Logger.d("ChannelHelper", "in silence push time,change defaults to 0");
            c0073a.f4518a = "";
            c0073a.f4523f = 0;
            c0073a.f4524g = null;
        } else if (Build.VERSION.SDK_INT >= 26 && (b4 = b(context, c0073a)) != null) {
            c0073a.f4518a = b4.getId();
            c0073a.f4519b = b4.getName();
            int importance = b4.getImportance();
            c0073a.f4521d = importance;
            c0073a.f4520c = b(importance);
            Uri sound = b4.getSound();
            c0073a.f4525h = sound;
            if (sound != null) {
                c0073a.f4524g = sound.getPath();
            }
            c0073a.f4526i = true;
            return;
        }
        int i4 = c0073a.f4520c;
        if (i4 == -2 || i4 == -1) {
            c0073a.f4523f = 0;
            c0073a.f4524g = null;
        } else if (i4 >= 0 && c0073a.f4523f == 0 && TextUtils.isEmpty(c0073a.f4524g)) {
            c0073a.f4520c = -1;
        }
        c0073a.f4523f &= 7;
        if (c0073a.f4520c == 2) {
            c0073a.f4520c = 1;
        }
        int a4 = a(c0073a.f4520c);
        c0073a.f4521d = a4;
        c0073a.f4520c = b(a4);
        Uri a5 = b.a(context, c0073a.f4524g);
        c0073a.f4525h = a5;
        if (a5 != null) {
            c0073a.f4523f &= -2;
        } else {
            c0073a.f4524g = null;
        }
        if (TextUtils.isEmpty(c0073a.f4518a)) {
            c0073a.f4518a = a(c0073a);
            if (Build.VERSION.SDK_INT >= 26 && (b5 = b(context, c0073a)) != null) {
                c0073a.f4518a = b5.getId();
                c0073a.f4519b = b5.getName();
                c0073a.f4526i = true;
                return;
            }
        }
        if (TextUtils.isEmpty(c0073a.f4519b)) {
            c0073a.f4519b = ("KG_channel_normal".equals(c0073a.f4518a) && "com.tencent.karaoke".equals(context.getPackageName())) ? "\u666e\u901a_K\u6b4c" : a(context, c0073a.f4520c);
        }
        Logger.d("ChannelHelper", "create channelId:" + c0073a.f4518a + ",channelName:" + ((Object) c0073a.f4519b) + ",soundUri:" + c0073a.f4525h + ",importance:" + c0073a.f4521d + ", hasImportance:" + c0073a.f4522e);
        c0073a.f4526i = a(context, c0073a.f4518a, c0073a.f4519b, c0073a.f4521d, c0073a.f4523f, c0073a.f4525h, c0073a.f4522e);
    }

    private static boolean a(Context context, String str, CharSequence charSequence, int i4, int i5, Uri uri, boolean z3) {
        if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26) {
            Logger.d("ChannelHelper", "sdkversion < 26, no need use notificationChannel!");
            return false;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager == null) {
                Logger.ee("ChannelHelper", "NotificationManager is null!");
                return false;
            }
            Logger.dd("ChannelHelper", "prepare NotificationChannel, channelId=" + str + "");
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel != null) {
                notificationChannel.setName(charSequence);
                if (z3) {
                    notificationChannel.setImportance(i4);
                    Logger.dd("ChannelHelper", "prepare NotificationChannel, channelId: " + str + "set importance:" + i4);
                }
                notificationManager.createNotificationChannel(notificationChannel);
                return true;
            }
            NotificationChannel notificationChannel2 = new NotificationChannel(str, charSequence, i4);
            if (Build.VERSION.SDK_INT < 28 || notificationManager.getNotificationChannelGroup("JIGUANG_CHANNEL_GROUP") == null) {
                notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("JIGUANG_CHANNEL_GROUP", cn.jpush.android.ad.a.b(context)));
            }
            notificationChannel2.setGroup("JIGUANG_CHANNEL_GROUP");
            notificationChannel2.enableLights((i5 & 4) != 0);
            notificationChannel2.enableVibration((i5 & 2) != 0);
            if (uri != null) {
                notificationChannel2.setSound(uri, null);
            } else {
                if (!((i5 & 1) != 0)) {
                    notificationChannel2.setSound(null, null);
                }
            }
            notificationManager.createNotificationChannel(notificationChannel2);
            return true;
        } catch (Throwable th) {
            Logger.ee("ChannelHelper", "new NotificationChannel fail:" + th);
            return false;
        }
    }

    public static int b(int i4) {
        if (i4 == 0 || i4 == 1) {
            return -2;
        }
        if (i4 != 2) {
            return (i4 == 4 || i4 == 5) ? 1 : 0;
        }
        return -1;
    }

    private static NotificationChannel b(Context context, C0073a c0073a) {
        try {
        } catch (Throwable th) {
            Logger.e("ChannelHelper", "config channelID error,will use sdk default channel ID:" + th);
        }
        if (Build.VERSION.SDK_INT >= 26 && c0073a != null) {
            String str = c0073a.f4518a;
            if (!TextUtils.isEmpty(str)) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
                if (notificationChannel != null) {
                    if (c0073a.f4522e) {
                        int a4 = a(c0073a.f4520c);
                        notificationChannel.setImportance(a4);
                        Logger.dd("ChannelHelper", "channel has created: " + str + ",set importance:" + a4);
                    }
                    Logger.dd("ChannelHelper", "channel has created: " + str);
                    return notificationChannel;
                }
                Logger.dd("ChannelHelper", "not found channed id from user set,will use sdk default channel ID");
            }
            return null;
        }
        return null;
    }
}
