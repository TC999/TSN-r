package cn.jpush.android.x;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import cn.jpush.android.ad.l;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.PushNotificationBuilder;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import cn.jpush.android.x.a;
import cn.jpush.android.x.e;
import com.acse.ottn.f3;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;
import java.util.zip.Adler32;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f4527a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class a extends cn.jpush.android.ad.f {

        /* renamed from: a  reason: collision with root package name */
        private Context f4528a;

        /* renamed from: b  reason: collision with root package name */
        private cn.jpush.android.d.d f4529b;

        public a(Context context, cn.jpush.android.d.d dVar) {
            this.f4528a = context;
            this.f4529b = dVar;
            this.f3984e = "NotificationHelper#NotifyAction";
        }

        public static void a(Context context, cn.jpush.android.d.d dVar) {
            b.g(context, dVar);
            int i4 = dVar.ac;
            if (i4 != 0 && i4 != 4) {
                b.f(context, dVar);
                return;
            }
            cn.jpush.android.helper.c.a(dVar.f4127d, 995L, context);
            b.b(context, dVar);
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                long b4 = cn.jpush.android.ad.b.b(this.f4529b.au);
                long b5 = cn.jpush.android.ad.b.b(this.f4529b.av);
                if (b4 > 0 && b4 == b5) {
                    Logger.ww("NotificationHelper", "the beginTime == endTime,not deal this notification");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (b5 > 0) {
                    if (b5 < b4) {
                        Logger.e("NotificationHelper", "illegal argument, endTime earlier than beginTime");
                        return;
                    } else if (b5 < currentTimeMillis) {
                        Logger.w("NotificationHelper", this.f4529b.f4127d + " already end");
                        cn.jpush.android.helper.c.a(this.f4529b.f4127d, 1034L, this.f4528a);
                        return;
                    }
                }
                if (b4 >= currentTimeMillis) {
                    e.a().a(this.f4528a, new e.a(b4, this.f4529b, false));
                    cn.jpush.android.helper.c.a(this.f4529b.f4127d, 1035L, this.f4528a);
                    return;
                }
                a(this.f4528a, this.f4529b);
                if (b5 > 0) {
                    e.a().a(this.f4528a, new e.a(b5, b.a(this.f4529b)));
                }
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "run NotifyAction failed:" + th.getMessage());
            }
        }
    }

    private static int a(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return i4 != 2 ? 1 : 32;
            }
            return 16;
        }
        return 1;
    }

    public static int a(cn.jpush.android.d.d dVar) {
        return a(TextUtils.isEmpty(dVar.f4131h) ? dVar.f4127d : dVar.f4131h, 0);
    }

    public static int a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "action:getNotificationID - empty messageId");
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            Logger.w("NotificationHelper", "Ths msgId is not a integer");
            Adler32 adler32 = new Adler32();
            adler32.update(str.getBytes());
            int value = (int) adler32.getValue();
            return value < 0 ? Math.abs(value) : value;
        }
    }

    private static Notification a(Notification.Builder builder) {
        try {
            return builder.build();
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "Build notification error:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.Notification a(android.content.Context r8, cn.jpush.android.d.d r9, cn.jpush.android.x.c r10, cn.jpush.android.x.c r11) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.a(android.content.Context, cn.jpush.android.d.d, cn.jpush.android.x.c, cn.jpush.android.x.c):android.app.Notification");
    }

    public static Intent a(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PushActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        if (!cn.jpush.android.ad.a.i(context)) {
            intent.addFlags(32768);
        }
        return intent;
    }

    @TargetApi(23)
    private static Icon a(String str) {
        try {
            if (new File(str).exists()) {
                return Icon.createWithFilePath(str);
            }
            Logger.w("NotificationHelper", "icon file doesn't exist, path=" + str);
            return null;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "createIcon err:" + th);
            return null;
        }
    }

    public static Uri a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (context.getResources().getIdentifier(str, "raw", context.getPackageName()) == 0) {
                Logger.d("NotificationHelper", "not found sound=" + str);
                return null;
            }
            Uri parse = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("found sound uri=");
            sb.append(parse);
            Logger.d("NotificationHelper", sb.toString());
            return parse;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "find sound e:" + th);
            return null;
        }
    }

    private static PushNotificationBuilder a(Context context, NotificationMessage notificationMessage) {
        try {
            Class<?> cls = Class.forName("cn.jpush.android.support.JPushSupport");
            return (PushNotificationBuilder) cls.getDeclaredMethod("getNotificationBuilder", Context.class, NotificationMessage.class).invoke(cls, context, notificationMessage);
        } catch (Throwable unused) {
            return null;
        }
    }

    @TargetApi(11)
    public static c a(Context context, String str, int i4) {
        c cVar = new c();
        Object b4 = b(context, str, i4);
        if (b4 == null) {
            cVar.a(973L);
            return cVar;
        }
        if (Build.VERSION.SDK_INT >= 23 && (b4 instanceof Icon)) {
            cVar.a(102);
            cVar.a(b4);
        } else if (!(b4 instanceof Bitmap)) {
            cVar.a(973L);
            return cVar;
        } else {
            cVar.a(100);
            cVar.a((Bitmap) b4);
        }
        return cVar;
    }

    @TargetApi(11)
    public static c a(Context context, String str, String str2, String str3, String str4, String str5) {
        Icon a4;
        c cVar = new c();
        String str6 = "";
        int i4 = 0;
        try {
            if (TextUtils.isEmpty(str3)) {
                Logger.d("NotificationHelper", "[buildSmallIcon] smallIcon is empty");
            } else if (cn.jpush.android.ad.a.c(str3)) {
                str6 = d(JPushConstants.mApplicationContext, str3, 307200);
            } else {
                i4 = JPushConstants.mApplicationContext.getResources().getIdentifier(str3, "drawable", JPushConstants.mApplicationContext.getPackageName());
            }
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "load small icon failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(str6)) {
            try {
                Bitmap decodeFile = cn.jpush.android.ad.c.a(str6) ? BitmapFactory.decodeFile(str6) : null;
                if (decodeFile != null) {
                    Logger.d("NotificationHelper", "set small icon with path bitmap:" + decodeFile);
                    cVar.a(100);
                    cVar.a(decodeFile);
                    return cVar;
                }
                Logger.d("NotificationHelper", "not set small icon by bitmap");
                if (Build.VERSION.SDK_INT >= 23 && (a4 = a(str6)) != null) {
                    Logger.d("NotificationHelper", "set small icon success by path:" + str6);
                    cVar.a(102);
                    cVar.a(a4);
                    return cVar;
                }
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with sdcard path");
            }
        }
        if (i4 != 0) {
            cVar.a(101);
            cVar.b(i4);
            Logger.d("NotificationHelper", "set small icon success by resId:" + i4 + ",resName:" + str3);
            return cVar;
        } else if (TextUtils.isEmpty(str2) || str2.equals(context.getPackageName())) {
            int a5 = g.a(context);
            if (a5 == 0) {
                cVar.a(972L);
                return cVar;
            }
            cVar.a(101);
            cVar.b(a5);
            Logger.d("NotificationHelper", "set small icon success by mine icon resId:" + a5);
            return cVar;
        } else {
            try {
                if (!cn.jpush.android.ad.a.a(context, str2, str5)) {
                    Logger.w("NotificationHelper", "targetApp \uff1a" + str2 + " is not install,will give up notify the msg");
                    cVar.a(993L);
                    return cVar;
                }
                Bitmap c4 = c(context, str2);
                if (c4 == null) {
                    Logger.w("NotificationHelper", "not found targetApp small icon bitmap,will give up notify the msg");
                    cVar.a(972L);
                    return cVar;
                }
                cVar.a(100);
                cVar.a(c4);
                Logger.d("NotificationHelper", "set small icon success by targetAppBitmap");
                return cVar;
            } catch (Throwable th2) {
                Logger.w("NotificationHelper", "set small icon by targetApp icon bitmap failed:" + th2.getMessage());
                cVar.a(972L);
                return cVar;
            }
        }
    }

    private static String a(Context context, String str, String str2) {
        if (!cn.jpush.android.ad.a.a(str, false)) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String str3 = cn.jpush.android.ad.c.c(context, str2) + (str2 + cn.jpush.android.ad.a.b(str));
        Logger.i("NotificationHelper", "Big picture notification resource path: " + str3);
        byte[] a4 = cn.jpush.android.w.b.a(context, str, "notify_img", 5, 5000L, 4);
        return (a4 == null || !cn.jpush.android.ad.c.a(str3, a4)) ? "" : str3;
    }

    public static void a(Notification notification, Context context, String str, String str2, PendingIntent pendingIntent) {
        try {
            Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, str2, pendingIntent);
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, a.C0073a c0073a) {
    }

    public static void a(Context context) {
        while (true) {
            Integer valueOf = Integer.valueOf(f.a());
            if (valueOf.intValue() == 0) {
                return;
            }
            d(context, valueOf.intValue());
        }
    }

    public static void a(Context context, int i4, int i5, String str) {
        a(context, i4, i5, str, (Bundle) null);
    }

    public static void a(Context context, int i4, int i5, String str, Bundle bundle) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(context, messageReceiverClass);
            intent.setAction(cn.jpush.android.ad.a.e(context, "cmd_msg"));
            intent.putExtra("cmd", i4);
            intent.putExtra("code", i5);
            intent.putExtra("message", str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (JPushConstants.getPushMessageReceiver(context) != null) {
                cn.jpush.android.helper.a.a(JPushConstants.getPushMessageReceiver(context), context, intent);
            } else {
                cn.jpush.android.helper.a.a(context, intent);
            }
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "sendCmdMsgToUser failed:" + th.getMessage());
        }
    }

    public static void a(Context context, int i4, boolean z3) {
        try {
            boolean z4 = true;
            if (d(context) != 1) {
                z4 = false;
            }
            Logger.d("NotificationHelper", "[checkNotificationSettings] new state:" + z4 + ",last state:" + f4527a + ",soucre:" + i4 + ",isFocre:" + z3);
            if (!z4) {
                Logger.kd("NotificationHelper", "notification trigger is off, will not show notification");
            }
            Boolean bool = f4527a;
            if (bool != null && z4 == bool.booleanValue() && !z3) {
                Logger.d("NotificationHelper", "[checkNotificationSettings] no change");
                return;
            }
            f4527a = Boolean.valueOf(z4);
            JPushMessageReceiver pushMessageReceiver = JPushConstants.getPushMessageReceiver(context);
            if (pushMessageReceiver != null) {
                pushMessageReceiver.onNotificationSettingsCheck(context, f4527a.booleanValue(), i4);
            } else {
                Intent intent = new Intent(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
                intent.setAction("on_noti_settings_check");
                intent.putExtra("isOn", f4527a);
                intent.putExtra("source", i4);
                cn.jpush.android.helper.a.a(context, intent);
            }
            cn.jpush.android.aa.a.a().a(context, "on_check");
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "checkNotificationSettings e:" + th);
        }
    }

    public static void a(Context context, Notification.Builder builder, a.C0073a c0073a) {
        if (c0073a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && c0073a.f4526i) {
                    Logger.d("NotificationHelper", "setChannelId =" + c0073a.f4518a);
                    d(context, c0073a.f4518a);
                    builder.setChannelId(c0073a.f4518a);
                }
                builder.setPriority(c0073a.f4520c);
                builder.setDefaults(c0073a.f4523f);
                builder.setSound(c0073a.f4525h);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, cn.jpush.android.d.d dVar) {
        Logger.d("NotificationHelper", "[processMessage] pushEntity:" + dVar);
        if (dVar.ad == 0) {
            JCoreHelper.majorExecutor(context, JPushConstants.SDK_TYPE, new a(context, dVar));
            return;
        }
        Logger.d("NotificationHelper", "Unexpected: unknown show  mode - " + dVar.ad);
    }

    public static void a(Context context, Integer num, Notification notification) {
        if (num == null) {
            return;
        }
        Key<Integer> BadgeCurNum = Key.BadgeCurNum();
        int intValue = ((Integer) Sp.get(context, BadgeCurNum)).intValue();
        if (intValue < 0) {
            intValue = 0;
        }
        if (num.intValue() != 0) {
            if (num.intValue() + intValue < 0) {
                num = Integer.valueOf(-intValue);
            }
            intValue += num.intValue();
            Sp.set(context, BadgeCurNum.set(Integer.valueOf(intValue)));
        }
        Logger.d("NotificationHelper", "curNum\uff1a" + intValue + ",addNum:" + num);
        a(context, notification, num.intValue(), intValue);
    }

    public static void a(Context context, String str, cn.jpush.android.d.d dVar, Intent intent) {
        a(context, str, dVar, intent, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0109 A[Catch: all -> 0x010d, TRY_LEAVE, TryCatch #0 {all -> 0x010d, blocks: (B:3:0x0004, B:5:0x0013, B:7:0x0019, B:9:0x0023, B:10:0x0026, B:12:0x002b, B:14:0x0031, B:15:0x0034, B:16:0x0055, B:19:0x005d, B:21:0x0065, B:48:0x0103, B:50:0x0109, B:22:0x0073, B:24:0x007a, B:25:0x007e, B:27:0x0086, B:28:0x008c, B:30:0x0094, B:31:0x009c, B:33:0x00a2, B:34:0x00aa, B:36:0x00b2, B:37:0x00ba, B:39:0x00c2, B:40:0x00ca, B:42:0x00d2, B:43:0x00da, B:45:0x00e2, B:46:0x00ea, B:47:0x00ee), top: B:55:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r4, java.lang.String r5, cn.jpush.android.d.d r6, android.content.Intent r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.a(android.content.Context, java.lang.String, cn.jpush.android.d.d, android.content.Intent, java.lang.String):void");
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod(f3.f5657f, String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                Logger.i("NotificationHelper", "get EMUI version is:" + str);
                return cn.jpush.android.ad.a.a(str.toLowerCase().replace("emotionui_", ""), "8.0") >= 0;
            }
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " getEmuiVersion wrong error:" + th);
        }
        return false;
    }

    private static boolean a(Notification notification, int i4) {
        if (notification != null) {
            try {
                Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i4));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, int i4) {
        String str;
        boolean z3 = false;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                StatusBarNotification[] activeNotifications = ((NotificationManager) context.getSystemService("notification")).getActiveNotifications();
                Logger.d("NotificationHelper", "active size:" + activeNotifications.length);
                int length = activeNotifications.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    } else if (activeNotifications[i5].getId() == i4) {
                        z3 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            if (z3) {
                str = "show  notification success:" + i4;
            } else {
                str = "show  notification maybe failed:" + i4;
            }
            Logger.dd("NotificationHelper", str);
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "[checkNotficationShow] failed:" + th.getMessage());
        }
        return z3;
    }

    @TargetApi(11)
    private static boolean a(Context context, Notification.Builder builder, c cVar, c cVar2) {
        boolean z3;
        boolean z4;
        int a4 = cVar.a();
        if (a4 != 102 || Build.VERSION.SDK_INT < 23) {
            z3 = false;
        } else {
            builder.setSmallIcon((Icon) cVar.b());
            z3 = true;
        }
        if (!z3 && a4 == 100 && Build.VERSION.SDK_INT >= 23) {
            builder.setSmallIcon(Icon.createWithBitmap(cVar.c()));
            z3 = true;
        }
        if (!z3 && a4 == 101) {
            try {
                context.getResources().getDrawable(cVar.d());
                z4 = true;
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with local app");
                z4 = false;
            }
            if (z4) {
                Logger.d("NotificationHelper", "set small icon by local resId:" + cVar.d());
                builder.setSmallIcon(Integer.valueOf(cVar.d()).intValue());
                z3 = true;
            }
        }
        if (z3) {
            int a5 = cVar2.a();
            if (a5 == 102) {
                if (Build.VERSION.SDK_INT >= 23) {
                    builder.setLargeIcon((Icon) cVar2.b());
                }
            } else if (a5 == 100) {
                builder.setLargeIcon(cVar2.c());
            } else {
                Logger.d("NotificationHelper", "not set large icon");
            }
            return true;
        }
        return false;
    }

    public static boolean a(Context context, Notification notification, int i4, int i5) {
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase("xiaomi")) {
            return a(notification, i4);
        }
        if (a()) {
            if (i5 == 0 || i4 != 0) {
                return g(context, i5);
            }
            return false;
        } else if (cn.jpush.android.ad.a.b()) {
            if (i5 == 0 || i4 != 0) {
                return f(context, i5);
            }
            return false;
        } else if (!str.equalsIgnoreCase("HONOR")) {
            Logger.d("NotificationHelper", "not support");
            return false;
        } else if (i5 == 0 || i4 != 0) {
            return e(context, i5);
        } else {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent) {
        String stringExtra;
        JSONObject jSONObject;
        String str = "";
        try {
            stringExtra = intent.getStringExtra("msg_data");
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(stringExtra)) {
            return true;
        }
        Logger.d("NotificationHelper", "handleOriginalMessage string=" + stringExtra);
        JSONObject jSONObject2 = new JSONObject(stringExtra);
        Logger.d("NotificationHelper", "handleOriginalMessage json=" + jSONObject2);
        String str2 = jSONObject2.optString("messageId");
        try {
            Logger.d("NotificationHelper", "handleOriginalMessage msgID=" + str2);
            String optString = jSONObject2.optString("originalMessage");
            Logger.d("NotificationHelper", "handleOriginalMessage originalMessage=" + optString);
            jSONObject = new JSONObject(optString);
            Logger.d("NotificationHelper", "handleOriginalMessage jsonObject=" + jSONObject);
        } catch (Throwable unused2) {
            str = str2;
            str2 = str;
            Logger.d("NotificationHelper", "handleOriginalMessage check fail drop it");
            cn.jpush.android.helper.c.a(str2, 1107L, context);
            return false;
        }
        if (1 == jSONObject.optInt("notificaion_type")) {
            Logger.d("NotificationHelper", "handleOriginalMessage local notification return true");
            return true;
        }
        String optString2 = jSONObject.optString("n_ssl");
        Logger.d("NotificationHelper", "handleOriginalMessage server ssl=" + optString2);
        String a4 = l.a(JCoreHelper.getUid(context) + str2);
        if (!TextUtils.isEmpty(a4)) {
            a4 = a4.toLowerCase().replace(":", "");
        }
        Logger.d("NotificationHelper", "handleOriginalMessage local ssl=" + a4);
        if (TextUtils.equals(a4, optString2)) {
            Logger.d("NotificationHelper", "handleOriginalMessage check success");
            return true;
        }
        Logger.d("NotificationHelper", "handleOriginalMessage check fail drop it");
        cn.jpush.android.helper.c.a(str2, 1107L, context);
        return false;
    }

    public static boolean a(Context context, String str, cn.jpush.android.d.d dVar, NotificationMessage notificationMessage) {
        try {
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "check display foreground failed:" + th.getMessage());
        }
        if (Class.forName(str).getMethod("onNotifyMessageUnShow", Context.class, NotificationMessage.class) == null) {
            Logger.dd("NotificationHelper", "not found onNotifyMessageUnShow method");
            return false;
        }
        if (!TextUtils.isEmpty(dVar.I)) {
            if (dVar.I.equals("0")) {
                if (cn.jpush.android.ad.a.i(context)) {
                    Logger.dd("NotificationHelper", "displayForeground...");
                    a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
                    cn.jpush.android.helper.c.a(dVar.f4127d, 1060L, context);
                    return true;
                }
            } else if (!((JPushMessageReceiver) Class.forName(str).newInstance()).isNeedShowNotification(context, notificationMessage, cn.jpush.android.ad.a.c(context))) {
                Logger.dd("NotificationHelper", "need not show notication by user");
                a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
                cn.jpush.android.helper.c.a(dVar.f4127d, 1061L, context);
                return true;
            }
        }
        return false;
    }

    public static Intent b(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PopWinActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    public static cn.jpush.android.d.d b(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("msg_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return cn.jpush.android.d.d.b(stringExtra);
    }

    public static Object b(Context context, String str) {
        return b(context, str, 307200);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009e A[Catch: all -> 0x00eb, TryCatch #1 {all -> 0x00eb, blocks: (B:17:0x0055, B:18:0x006e, B:27:0x009e, B:30:0x00a6, B:31:0x00bb, B:41:0x00e4, B:32:0x00bf, B:34:0x00c5, B:36:0x00cb, B:19:0x0072, B:21:0x0078, B:23:0x0083), top: B:50:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object b(android.content.Context r6, java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.b(android.content.Context, java.lang.String, int):java.lang.Object");
    }

    public static void b(Context context, int i4) {
        int a4;
        if (!f.b(i4)) {
            f.a(i4);
        }
        int i5 = cn.jpush.android.cache.a.i(context);
        Logger.d("NotificationHelper", "queueSize:" + f.b() + ", max num:" + i5);
        if (f.b() <= i5 || (a4 = f.a()) == 0) {
            return;
        }
        d(context, a4);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa A[Catch: all -> 0x01c0, TryCatch #4 {all -> 0x01c0, blocks: (B:42:0x00dd, B:46:0x00ec, B:48:0x00f0, B:51:0x00fe, B:53:0x0123, B:54:0x0125, B:56:0x0134, B:57:0x0136, B:59:0x0140, B:61:0x0179, B:64:0x017f, B:72:0x01b8, B:74:0x01bc, B:65:0x0183, B:67:0x0187, B:69:0x0190, B:70:0x019c, B:71:0x01a4, B:60:0x0174, B:49:0x00f5, B:50:0x00fa), top: B:87:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0123 A[Catch: all -> 0x01c0, TryCatch #4 {all -> 0x01c0, blocks: (B:42:0x00dd, B:46:0x00ec, B:48:0x00f0, B:51:0x00fe, B:53:0x0123, B:54:0x0125, B:56:0x0134, B:57:0x0136, B:59:0x0140, B:61:0x0179, B:64:0x017f, B:72:0x01b8, B:74:0x01bc, B:65:0x0183, B:67:0x0187, B:69:0x0190, B:70:0x019c, B:71:0x01a4, B:60:0x0174, B:49:0x00f5, B:50:0x00fa), top: B:87:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0134 A[Catch: all -> 0x01c0, TryCatch #4 {all -> 0x01c0, blocks: (B:42:0x00dd, B:46:0x00ec, B:48:0x00f0, B:51:0x00fe, B:53:0x0123, B:54:0x0125, B:56:0x0134, B:57:0x0136, B:59:0x0140, B:61:0x0179, B:64:0x017f, B:72:0x01b8, B:74:0x01bc, B:65:0x0183, B:67:0x0187, B:69:0x0190, B:70:0x019c, B:71:0x01a4, B:60:0x0174, B:49:0x00f5, B:50:0x00fa), top: B:87:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0140 A[Catch: all -> 0x01c0, TryCatch #4 {all -> 0x01c0, blocks: (B:42:0x00dd, B:46:0x00ec, B:48:0x00f0, B:51:0x00fe, B:53:0x0123, B:54:0x0125, B:56:0x0134, B:57:0x0136, B:59:0x0140, B:61:0x0179, B:64:0x017f, B:72:0x01b8, B:74:0x01bc, B:65:0x0183, B:67:0x0187, B:69:0x0190, B:70:0x019c, B:71:0x01a4, B:60:0x0174, B:49:0x00f5, B:50:0x00fa), top: B:87:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0174 A[Catch: all -> 0x01c0, TryCatch #4 {all -> 0x01c0, blocks: (B:42:0x00dd, B:46:0x00ec, B:48:0x00f0, B:51:0x00fe, B:53:0x0123, B:54:0x0125, B:56:0x0134, B:57:0x0136, B:59:0x0140, B:61:0x0179, B:64:0x017f, B:72:0x01b8, B:74:0x01bc, B:65:0x0183, B:67:0x0187, B:69:0x0190, B:70:0x019c, B:71:0x01a4, B:60:0x0174, B:49:0x00f5, B:50:0x00fa), top: B:87:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0183 A[Catch: all -> 0x01c0, TryCatch #4 {all -> 0x01c0, blocks: (B:42:0x00dd, B:46:0x00ec, B:48:0x00f0, B:51:0x00fe, B:53:0x0123, B:54:0x0125, B:56:0x0134, B:57:0x0136, B:59:0x0140, B:61:0x0179, B:64:0x017f, B:72:0x01b8, B:74:0x01bc, B:65:0x0183, B:67:0x0187, B:69:0x0190, B:70:0x019c, B:71:0x01a4, B:60:0x0174, B:49:0x00f5, B:50:0x00fa), top: B:87:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bc A[Catch: all -> 0x01c0, TRY_LEAVE, TryCatch #4 {all -> 0x01c0, blocks: (B:42:0x00dd, B:46:0x00ec, B:48:0x00f0, B:51:0x00fe, B:53:0x0123, B:54:0x0125, B:56:0x0134, B:57:0x0136, B:59:0x0140, B:61:0x0179, B:64:0x017f, B:72:0x01b8, B:74:0x01bc, B:65:0x0183, B:67:0x0187, B:69:0x0190, B:70:0x019c, B:71:0x01a4, B:60:0x0174, B:49:0x00f5, B:50:0x00fa), top: B:87:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r17, cn.jpush.android.d.d r18) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.b(android.content.Context, cn.jpush.android.d.d):void");
    }

    public static boolean b(Context context) {
        try {
            if (!cn.jpush.android.cache.a.f(context)) {
                Logger.ii("NotificationHelper", "Notification was disabled by JPushInterface.setPushTime !");
                return false;
            }
            String g4 = cn.jpush.android.cache.a.g(context);
            if (TextUtils.isEmpty(g4)) {
                Logger.i("NotificationHelper", "no time limited");
                return true;
            }
            Logger.i("NotificationHelper", "push time is \uff1a" + g4);
            String[] split = g4.split("_");
            String str = split[0];
            String str2 = split[1];
            char[] charArray = str.toCharArray();
            String[] split2 = str2.split("\\^");
            Calendar calendar = Calendar.getInstance();
            int i4 = calendar.get(7);
            int i5 = calendar.get(11);
            for (char c4 : charArray) {
                if (i4 == Integer.valueOf(String.valueOf(c4)).intValue() + 1) {
                    int intValue = Integer.valueOf(split2[0]).intValue();
                    int intValue2 = Integer.valueOf(split2[1]).intValue();
                    if (i5 >= intValue && i5 <= intValue2) {
                        return true;
                    }
                }
            }
            Logger.ii("NotificationHelper", "Current time is out of the push time - " + g4);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private static Intent c(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, JNotifyActivity.class);
        intent.setFlags(8388608);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    public static synchronized Bitmap c(Context context, String str) {
        synchronized (b.class) {
            try {
                PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
                Drawable applicationIcon = packageManager.getApplicationIcon(packageManager.getApplicationInfo(str, 0));
                if (applicationIcon != null) {
                    if (Build.VERSION.SDK_INT < 26 || !(applicationIcon instanceof AdaptiveIconDrawable)) {
                        return ((BitmapDrawable) applicationIcon).getBitmap();
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    applicationIcon.draw(canvas);
                    Logger.d("NotificationHelper", "adaptive-icon to bitmap");
                    return createBitmap;
                }
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "getTargetAppBitmap failed:" + th.getMessage());
            }
            return null;
        }
    }

    public static NotificationMessage c(Context context, Intent intent) {
        cn.jpush.android.d.d b4 = b(context, intent);
        NotificationMessage notificationMessage = new NotificationMessage();
        if (b4 != null) {
            notificationMessage = b4.b();
        }
        if (TextUtils.isEmpty(notificationMessage.appkey)) {
            notificationMessage.appkey = JCoreHelper.getAppKey(context);
        }
        return notificationMessage;
    }

    public static String c(Context context, String str, int i4) {
        if (!cn.jpush.android.ad.a.a(str, false)) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String d4 = cn.jpush.android.ad.a.d(str);
        if (TextUtils.isEmpty(d4)) {
            d4 = UUID.randomUUID().toString();
        }
        String str2 = cn.jpush.android.ad.c.c(context, "noti_res") + (d4 + cn.jpush.android.ad.a.b(str));
        Logger.i("NotificationHelper", "picture notification resource path: " + str2);
        if (!new File(str2).exists()) {
            byte[] a4 = cn.jpush.android.w.b.a(context, str, "notify_img", 2, i4);
            return (a4 == null || !cn.jpush.android.ad.c.a(str2, a4)) ? "" : str2;
        }
        Logger.d("NotificationHelper", "need not download again with same url:" + str);
        return str2;
    }

    public static void c(Context context, int i4) {
        if (i4 <= 0) {
            return;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            Integer valueOf = Integer.valueOf(f.a());
            if (valueOf.intValue() != 0) {
                d(context, valueOf.intValue());
            }
        }
    }

    public static void c(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            d(context, a(dVar));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
        if (r8 <= 23) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
        if (r8 < r6) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
        if (r7 >= r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
        if (r7 <= r2) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.c(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static int d(Context context) {
        StringBuilder sb;
        String str;
        if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
            Logger.ww("NotificationHelper", "sdk is banned, call failed");
            return 0;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                    Logger.d("NotificationHelper", "from NotificationManager enable=" + areNotificationsEnabled);
                    return areNotificationsEnabled ? 1 : 0;
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                str = "isNotificationEnabled e:";
            }
        } else if (i4 < 19) {
            Logger.d("NotificationHelper", "below 19 return true");
            return 1;
        } else {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
                int i5 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                ?? r12 = ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i5), packageName)).intValue() == 0 ? 1 : 0;
                Logger.d("NotificationHelper", "from AppOpsManager enable=" + ((boolean) r12));
                return r12;
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
                str = "appOps check e:";
            }
        }
        sb.append(str);
        sb.append(th);
        Logger.w("NotificationHelper", sb.toString());
        return -1;
    }

    private static String d(Context context, String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE)) {
            String c4 = c(context, str, i4);
            if (TextUtils.isEmpty(c4)) {
                Logger.ww("NotificationHelper", "Get network picture failed.");
                return null;
            }
            return c4;
        }
        return null;
    }

    public static void d(Context context, int i4) {
        try {
            Logger.d("NotificationHelper", "action:cleanNotification - notificationId:" + i4);
            ((NotificationManager) context.getSystemService("notification")).cancel(i4);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "cancelNotification failed:" + th.getMessage());
        }
    }

    private static boolean d(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str)) {
                return true;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
            if (notificationChannel != null && notificationChannel.getImportance() != 0) {
                Logger.dd("NotificationHelper", str + " channel is opened,will use it");
                return true;
            }
            Logger.ww("NotificationHelper", str + " channel maybe closed,please check it");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean e(Context context) {
        String str;
        ApplicationInfo applicationInfo;
        try {
            if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
                Logger.ww("NotificationHelper", "sdk is banned, call failed");
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 26) {
                if (i4 >= 21) {
                    intent.putExtra("app_package", context.getPackageName());
                    str = "app_uid";
                    applicationInfo = context.getApplicationInfo();
                }
                intent.setFlags(268435456);
                context.startActivity(intent);
                return true;
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            str = "android.provider.extra.CHANNEL_ID";
            applicationInfo = context.getApplicationInfo();
            intent.putExtra(str, applicationInfo.uid);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean e(Context context, int i4) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
            if (TextUtils.isEmpty(contentResolver.getType(parse))) {
                parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                if (TextUtils.isEmpty(contentResolver.getType(parse))) {
                    Logger.e("NotificationHelper", " setHonorBadge fail, uri is null");
                    return false;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString("class", h(context));
            bundle.putInt("badgenumber", i4);
            contentResolver.call(parse, "change_badge", (String) null, bundle);
            return true;
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " setHonorBadge wrong error:" + th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, cn.jpush.android.d.d dVar) {
        String str;
        boolean z3;
        String str2 = dVar.f4127d;
        String str3 = dVar.Y;
        str = "";
        if (TextUtils.isEmpty(str3)) {
            Logger.w("NotificationHelper", "Show url is Empty! Give up to download!");
            z3 = false;
        } else {
            String a4 = cn.jpush.android.w.b.a(context, str3, "rich", 5, 5000L);
            boolean isEmpty = TextUtils.isEmpty(a4);
            str = isEmpty ? "" : a4;
            z3 = !isEmpty;
        }
        String c4 = cn.jpush.android.ad.c.c(context, str2);
        if (!z3) {
            Logger.w("NotificationHelper", "NOTE: failed to download html page. Give up this.");
            cn.jpush.android.helper.c.a(str2, 1014L, context);
            cn.jpush.android.helper.c.a(str2, 1021L, (String) null, context);
            return;
        }
        String str4 = c4 + str2 + ".html";
        String substring = str3.substring(0, str3.lastIndexOf(TTPathConst.sSeparator) + 1);
        if (dVar.ae.isEmpty()) {
            dVar.aa = dVar.Y;
        } else if (!h.a(dVar.ae, context, substring, str2, true)) {
            Logger.d("NotificationHelper", "Loads rich push resources failed, webView will open url!");
            cn.jpush.android.helper.c.a(str2, 1014L, context);
            b(context, dVar);
            return;
        } else {
            Logger.d("NotificationHelper", "Loads rich push resources succeed, webView will open cache!");
            if (!cn.jpush.android.ad.c.b(str4, str.replaceAll("img src=\"" + substring, "img src=\"" + c4))) {
                cn.jpush.android.helper.c.a(str2, 1014L, context);
                return;
            }
            dVar.aa = "file://" + str4;
            cn.jpush.android.helper.c.a(str2, 995L, context);
        }
        b(context, dVar);
    }

    public static boolean f(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"WrongConstant"})
    private static boolean f(Context context, int i4) {
        try {
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("className", h(context));
            intent.putExtra("notificationNum", i4);
            intent.addFlags(16777216);
            context.sendBroadcast(intent);
            return true;
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " setVivoBadge wrong error:" + th);
            return false;
        }
    }

    private static String g(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                resolveActivity = packageManager.resolveActivity(intent, 0);
            }
            if (resolveActivity != null) {
                return resolveActivity.activityInfo.name;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, cn.jpush.android.d.d dVar) {
        String a4;
        String str;
        String str2 = dVar.A;
        dVar.A = "";
        if (dVar.f4148y != 3 || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.startsWith(JPushConstants.HTTP_PRE) || str2.startsWith(JPushConstants.HTTPS_PRE)) {
            a4 = a(context, str2, dVar.f4127d);
            if (TextUtils.isEmpty(a4)) {
                str = "Get network picture failed, show basic notification only.";
                Logger.ww("NotificationHelper", str);
                return;
            }
            dVar.A = a4;
        }
        a4 = cn.jpush.android.ad.c.e(context, str2);
        if (TextUtils.isEmpty(a4)) {
            str = "Get developer picture failed, show basic notification only.";
            Logger.ww("NotificationHelper", str);
            return;
        }
        dVar.A = a4;
    }

    private static boolean g(Context context, int i4) {
        try {
            Logger.d("NotificationHelper", "\u3010setEMUIBadge\u3011number\uff1a" + i4);
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString("class", h(context));
            bundle.putInt("badgenumber", i4);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
            return true;
        } catch (Exception e4) {
            Logger.e("NotificationHelper", "e: " + e4);
            return false;
        }
    }

    private static String h(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null && launchIntentForPackage.getComponent() != null) {
                return launchIntentForPackage.getComponent().getClassName();
            }
        } catch (Throwable unused) {
        }
        return g(context);
    }
}
