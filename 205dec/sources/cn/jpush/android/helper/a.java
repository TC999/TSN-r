package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4209a;

    /* renamed from: b  reason: collision with root package name */
    private static a f4210b;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f4211d;

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f4212c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.jpush.android.helper.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0069a extends cn.jpush.android.ad.f {

        /* renamed from: b  reason: collision with root package name */
        private Context f4214b;

        /* renamed from: c  reason: collision with root package name */
        private JPushMessageReceiver f4215c;

        /* renamed from: d  reason: collision with root package name */
        private Intent f4216d;

        public C0069a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
            this.f4214b = context;
            this.f4215c = jPushMessageReceiver;
            this.f4216d = intent;
            this.f3984e = "JMessageReceiverHelper#MessageReceiverRunable";
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            a.b(this.f4214b, this.f4215c, this.f4216d);
        }
    }

    private a() {
        b();
    }

    public static a a() {
        if (f4210b == null) {
            synchronized (a.class) {
                if (f4210b == null) {
                    f4210b = new a();
                }
            }
        }
        return f4210b;
    }

    public static void a(Context context, Intent intent) {
        String str;
        if (context == null) {
            return;
        }
        try {
            String packageName = context.getPackageName();
            if (JPushConstants.isForeGround == 0) {
                Logger.d("JMessageReceiverHelper", "foreground no need provider,use sendBroadcast");
                str = packageName + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX;
            } else if (a(context)) {
                Logger.d("JMessageReceiverHelper", "send by provider intent=" + intent);
                context.getContentResolver().call(Uri.parse("content://" + (packageName + ".jiguang.InitProvider") + TTPathConst.sSeparator), "null", "null", cn.jpush.android.ad.a.a(intent));
                return;
            } else {
                Logger.d("JMessageReceiverHelper", "no support provider ,use sendBroadcast");
                str = packageName + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX;
            }
            context.sendBroadcast(intent, str);
        } catch (Throwable th) {
            Logger.d("JMessageReceiverHelper", "send Throwable: " + th);
        }
    }

    public static void a(Context context, CustomMessage customMessage) {
        if (context == null || customMessage == null) {
            Logger.dd("JMessageReceiverHelper", "Send custom message to app failed, param is invalid!");
            return;
        }
        Logger.dd("JMessageReceiverHelper", "not found user push message,use old action to user");
        Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
        intent.putExtra(JPushInterface.EXTRA_APP_KEY, customMessage.senderId);
        intent.putExtra(JPushInterface.EXTRA_MESSAGE, customMessage.message);
        intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, customMessage.contentType);
        intent.putExtra(JPushInterface.EXTRA_TITLE, customMessage.title);
        intent.putExtra(JPushInterface.EXTRA_EXTRA, customMessage.extra);
        intent.putExtra(JPushInterface.EXTRA_MSG_ID, customMessage.messageId);
        if (JPushConstants.SDK_VERSION_CODE >= 387) {
            intent.putExtra(JPushInterface.EXTRA_TYPE_PLATFORM, customMessage.platform);
        }
        intent.addCategory(customMessage.appId);
        intent.setPackage(context.getPackageName());
        Locale locale = Locale.ENGLISH;
        context.sendBroadcast(intent, String.format(locale, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
        Logger.i("JMessageReceiverHelper", "Send broadcast to app: " + String.format(locale, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:9:0x0019, B:11:0x0056, B:12:0x005d, B:14:0x0065, B:15:0x006c, B:17:0x0071, B:19:0x0079, B:20:0x007d, B:31:0x00a5, B:33:0x00a9, B:34:0x00bf, B:36:0x00c7, B:37:0x00ce, B:39:0x00d6, B:40:0x00dd, B:42:0x00e5, B:43:0x00ec, B:45:0x00f4, B:46:0x00fb, B:48:0x00ff, B:52:0x0106, B:54:0x010a, B:56:0x0110, B:57:0x011d, B:59:0x0121, B:61:0x0127, B:62:0x0138, B:64:0x013e, B:66:0x014c, B:67:0x0151, B:69:0x015b, B:70:0x015e, B:71:0x0162, B:72:0x016b, B:73:0x0174, B:21:0x0081, B:23:0x0086, B:25:0x008e, B:26:0x0093, B:28:0x0098, B:30:0x00a0), top: B:80:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:9:0x0019, B:11:0x0056, B:12:0x005d, B:14:0x0065, B:15:0x006c, B:17:0x0071, B:19:0x0079, B:20:0x007d, B:31:0x00a5, B:33:0x00a9, B:34:0x00bf, B:36:0x00c7, B:37:0x00ce, B:39:0x00d6, B:40:0x00dd, B:42:0x00e5, B:43:0x00ec, B:45:0x00f4, B:46:0x00fb, B:48:0x00ff, B:52:0x0106, B:54:0x010a, B:56:0x0110, B:57:0x011d, B:59:0x0121, B:61:0x0127, B:62:0x0138, B:64:0x013e, B:66:0x014c, B:67:0x0151, B:69:0x015b, B:70:0x015e, B:71:0x0162, B:72:0x016b, B:73:0x0174, B:21:0x0081, B:23:0x0086, B:25:0x008e, B:26:0x0093, B:28:0x0098, B:30:0x00a0), top: B:80:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:9:0x0019, B:11:0x0056, B:12:0x005d, B:14:0x0065, B:15:0x006c, B:17:0x0071, B:19:0x0079, B:20:0x007d, B:31:0x00a5, B:33:0x00a9, B:34:0x00bf, B:36:0x00c7, B:37:0x00ce, B:39:0x00d6, B:40:0x00dd, B:42:0x00e5, B:43:0x00ec, B:45:0x00f4, B:46:0x00fb, B:48:0x00ff, B:52:0x0106, B:54:0x010a, B:56:0x0110, B:57:0x011d, B:59:0x0121, B:61:0x0127, B:62:0x0138, B:64:0x013e, B:66:0x014c, B:67:0x0151, B:69:0x015b, B:70:0x015e, B:71:0x0162, B:72:0x016b, B:73:0x0174, B:21:0x0081, B:23:0x0086, B:25:0x008e, B:26:0x0093, B:28:0x0098, B:30:0x00a0), top: B:80:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:9:0x0019, B:11:0x0056, B:12:0x005d, B:14:0x0065, B:15:0x006c, B:17:0x0071, B:19:0x0079, B:20:0x007d, B:31:0x00a5, B:33:0x00a9, B:34:0x00bf, B:36:0x00c7, B:37:0x00ce, B:39:0x00d6, B:40:0x00dd, B:42:0x00e5, B:43:0x00ec, B:45:0x00f4, B:46:0x00fb, B:48:0x00ff, B:52:0x0106, B:54:0x010a, B:56:0x0110, B:57:0x011d, B:59:0x0121, B:61:0x0127, B:62:0x0138, B:64:0x013e, B:66:0x014c, B:67:0x0151, B:69:0x015b, B:70:0x015e, B:71:0x0162, B:72:0x016b, B:73:0x0174, B:21:0x0081, B:23:0x0086, B:25:0x008e, B:26:0x0093, B:28:0x0098, B:30:0x00a0), top: B:80:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:9:0x0019, B:11:0x0056, B:12:0x005d, B:14:0x0065, B:15:0x006c, B:17:0x0071, B:19:0x0079, B:20:0x007d, B:31:0x00a5, B:33:0x00a9, B:34:0x00bf, B:36:0x00c7, B:37:0x00ce, B:39:0x00d6, B:40:0x00dd, B:42:0x00e5, B:43:0x00ec, B:45:0x00f4, B:46:0x00fb, B:48:0x00ff, B:52:0x0106, B:54:0x010a, B:56:0x0110, B:57:0x011d, B:59:0x0121, B:61:0x0127, B:62:0x0138, B:64:0x013e, B:66:0x014c, B:67:0x0151, B:69:0x015b, B:70:0x015e, B:71:0x0162, B:72:0x016b, B:73:0x0174, B:21:0x0081, B:23:0x0086, B:25:0x008e, B:26:0x0093, B:28:0x0098, B:30:0x00a0), top: B:80:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ff A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:9:0x0019, B:11:0x0056, B:12:0x005d, B:14:0x0065, B:15:0x006c, B:17:0x0071, B:19:0x0079, B:20:0x007d, B:31:0x00a5, B:33:0x00a9, B:34:0x00bf, B:36:0x00c7, B:37:0x00ce, B:39:0x00d6, B:40:0x00dd, B:42:0x00e5, B:43:0x00ec, B:45:0x00f4, B:46:0x00fb, B:48:0x00ff, B:52:0x0106, B:54:0x010a, B:56:0x0110, B:57:0x011d, B:59:0x0121, B:61:0x0127, B:62:0x0138, B:64:0x013e, B:66:0x014c, B:67:0x0151, B:69:0x015b, B:70:0x015e, B:71:0x0162, B:72:0x016b, B:73:0x0174, B:21:0x0081, B:23:0x0086, B:25:0x008e, B:26:0x0093, B:28:0x0098, B:30:0x00a0), top: B:80:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r8, cn.jpush.android.api.NotificationMessage r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.helper.a.a(android.content.Context, cn.jpush.android.api.NotificationMessage, java.lang.String):void");
    }

    public static void a(JPushMessageReceiver jPushMessageReceiver, Context context, Intent intent) {
        CmdMessage cmdMessage;
        try {
            int intExtra = intent.getIntExtra("code", -2);
            int intExtra2 = intent.getIntExtra("cmd", -2);
            String stringExtra = intent.getStringExtra("message");
            Logger.d("JMessageReceiverHelper", "[callCmdMessage] code:" + intExtra + ",cmd:" + intExtra2 + ",message:" + stringExtra);
            Bundle extras = intent.getExtras();
            if (intExtra2 == -1) {
                jPushMessageReceiver.onConnected(context, false);
                return;
            }
            if (intExtra2 == 0) {
                if (intExtra == 0) {
                    jPushMessageReceiver.onRegister(context, stringExtra);
                    return;
                }
                cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
            } else if (intExtra2 == 1) {
                jPushMessageReceiver.onConnected(context, true);
                if (f4209a) {
                    return;
                }
                f4209a = true;
                Bundle bundle = new Bundle();
                bundle.putInt("cmd", 2008);
                bundle.putInt("code", 0);
                bundle.putString("message", "success");
                cmdMessage = new CmdMessage(2008, 0, stringExtra, bundle);
            } else if (intExtra2 == 2001) {
                return;
            } else {
                if (intExtra2 != 2009 && intExtra2 != 10000) {
                    switch (intExtra2) {
                        case 2003:
                        case 2004:
                        case 2005:
                        case 2006:
                        case 2007:
                            break;
                        default:
                            switch (intExtra2) {
                                case 100001:
                                case 100002:
                                case 100003:
                                case 100004:
                                case 100005:
                                    break;
                                default:
                                    Logger.dd("JMessageReceiverHelper", "unkown cmd:" + intExtra2);
                                    return;
                            }
                    }
                }
                cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
            }
            jPushMessageReceiver.onCommandResult(context, cmdMessage);
        } catch (Throwable th) {
            Logger.e("JMessageReceiverHelper", "callCmdMessage failed:" + th.getMessage());
        }
    }

    private static boolean a(Context context) {
        try {
        } catch (Throwable th) {
            f4211d = Boolean.FALSE;
            Logger.d("JMessageReceiverHelper", "throwable=" + th);
        }
        if (cn.jpush.android.m.a.f4250c < 470) {
            Logger.d("JMessageReceiverHelper", "jcore < 470");
            return false;
        }
        Boolean bool = f4211d;
        if (bool != null) {
            return bool.booleanValue();
        }
        ComponentInfo a4 = cn.jpush.android.ad.a.a(context, context.getPackageName(), Class.forName("cn.jpush.android.service.InitProvider"));
        if (a4 != null) {
            f4211d = Boolean.valueOf(context.getPackageName().equals(a4.processName));
            Logger.d("JMessageReceiverHelper", "isSupportProvider info=" + f4211d);
        } else {
            Logger.d("JMessageReceiverHelper", "ComponentInfo is null");
            f4211d = Boolean.FALSE;
        }
        return f4211d.booleanValue();
    }

    private void b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
        this.f4212c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void b(Context context, Intent intent) {
        try {
            Logger.i("JMessageReceiverHelper", "Click notification action with extra: " + intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA));
            Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
            intent2.putExtras(intent.getExtras());
            intent2.addCategory(context.getPackageName());
            intent2.setPackage(context.getPackageName());
            context.sendBroadcast(intent2, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("JMessageReceiverHelper", "Click notification sendBroadcast :" + th.getMessage());
        }
    }

    public static void b(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        try {
            if (intent == null) {
                Logger.w("JMessageReceiverHelper", "intent  was null");
            } else if (jPushMessageReceiver == null && (jPushMessageReceiver = JPushConstants.getPushMessageReceiver(context)) == null) {
                Logger.w("JMessageReceiverHelper", "jPushMessageReceiver  was null");
            } else {
                JPushMessageReceiver jPushMessageReceiver2 = jPushMessageReceiver;
                String action = intent.getAction();
                Logger.d("JMessageReceiverHelper", "do receiver action :" + action);
                if (action == null) {
                    Logger.w("JMessageReceiverHelper", "Unexpected error, action is null");
                } else if (action.equals("tag_alias_message")) {
                    int intExtra = intent.getIntExtra("message_type", -1);
                    JPushMessage jPushMessage = null;
                    if (1 == intExtra || 2 == intExtra || 3 == intExtra) {
                        jPushMessage = cn.jpush.android.ab.d.a().a(context, intent);
                    }
                    Logger.d("JMessageReceiverHelper", "messageType:" + intExtra + ",jPushMessage:" + jPushMessage);
                    if (jPushMessage == null) {
                        Logger.w("JMessageReceiverHelper", "parse tagalias message failed");
                    } else if (intExtra == 1) {
                        if (jPushMessage.isTagCheckOperator()) {
                            jPushMessageReceiver2.onCheckTagOperatorResult(context, jPushMessage);
                        } else {
                            jPushMessageReceiver2.onTagOperatorResult(context, jPushMessage);
                        }
                    } else if (intExtra == 2) {
                        jPushMessageReceiver2.onAliasOperatorResult(context, jPushMessage);
                    } else if (intExtra == 3) {
                        jPushMessageReceiver2.onPropertyOperatorResult(context, jPushMessage);
                    } else {
                        Logger.w("JMessageReceiverHelper", "unsupport message type");
                    }
                } else if (action.equals("mobile_result")) {
                    jPushMessageReceiver2.onMobileNumberOperatorResult(context, d.a().a(context, intent));
                } else if (action.equals(cn.jpush.android.ad.a.e(context, "custom_msg"))) {
                    jPushMessageReceiver2.onMessage(context, cn.jpush.android.d.b.a(intent));
                } else if (action.equals(cn.jpush.android.ad.a.e(context, "cmd_msg"))) {
                    a(jPushMessageReceiver2, context, intent);
                } else if (action.equals("cn.jpush.android.intent.NOTIFICATION_ARRIVED")) {
                    jPushMessageReceiver2.onNotifyMessageArrived(context, cn.jpush.android.x.b.c(context, intent));
                } else if (action.equals("cn.jpush.android.intent.NOTIFICATION_UN_SHOW")) {
                    try {
                        jPushMessageReceiver2.onNotifyMessageUnShow(context, cn.jpush.android.x.b.c(context, intent));
                    } catch (Throwable unused) {
                    }
                } else if (action.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
                    jPushMessageReceiver2.onNotifyMessageOpened(context, cn.jpush.android.x.b.c(context, intent));
                } else if (action.equals("cn.jpush.android.intent.NOTIFICATION_DISMISS")) {
                    jPushMessageReceiver2.onNotifyMessageDismiss(context, cn.jpush.android.x.b.c(context, intent));
                } else if (action.equals(JPushInterface.ACTION_IN_APP_MSG_SHOW)) {
                    jPushMessageReceiver2.onInAppMessageShow(context, cn.jpush.android.x.b.c(context, intent));
                } else if (action.equals(JPushInterface.ACTION_IN_APP_MSG_CLICK)) {
                    jPushMessageReceiver2.onInAppMessageClick(context, cn.jpush.android.x.b.c(context, intent));
                } else if (JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION_PROXY.equals(intent.getAction())) {
                    Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
                    if (intent.getExtras() != null) {
                        intent2.putExtras(intent.getExtras());
                    }
                    jPushMessageReceiver2.onMultiActionClicked(context, intent2);
                } else if ("on_noti_settings_check".equals(action)) {
                    jPushMessageReceiver2.onNotificationSettingsCheck(context, intent.getBooleanExtra("isOn", false), intent.getIntExtra("source", 0));
                } else {
                    String str = "";
                    if ("cn.jpush.android.intent.GEO_RECEIVED".equals(action)) {
                        String stringExtra = intent.getStringExtra("geo");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            str = stringExtra;
                        }
                        jPushMessageReceiver2.onGeofenceReceived(context, str);
                    } else if ("cn.jpush.android.intent.GEO_REGION".equals(action)) {
                        jPushMessageReceiver2.onGeofenceRegion(context, intent.getStringExtra("geo"), intent.getDoubleExtra("geoLng", 200.0d), intent.getDoubleExtra("geoLat", 200.0d));
                    } else if ("cn.jpush.android.intent.NOTIFY_INAPP_MESSAGE_ARRIVED".equals(action)) {
                        cn.jpush.android.d.d b4 = cn.jpush.android.x.b.b(context, intent);
                        Logger.d("JMessageReceiverHelper", "notify inapp received by receiver");
                        if (b4 != null) {
                            cn.jpush.android.q.a.a().a(context, b4, 1001);
                        }
                    } else if ("check_can_show_message".equals(action)) {
                        cn.jpush.android.d.d b5 = cn.jpush.android.x.b.b(context, intent);
                        if (b5 != null) {
                            cn.jpush.android.q.a.a().a(context, b5, 1006);
                        }
                    } else if ("handle_message_failed".equals(action)) {
                        cn.jpush.android.d.d b6 = cn.jpush.android.x.b.b(context, intent);
                        if (b6 != null) {
                            cn.jpush.android.q.a.a().a(context, b6, 1007);
                        }
                    } else if (!"cn.jpush.android.intent.NOTIFY_INAPP_MESSAGE_CANCEL".equals(action)) {
                        Logger.d("JMessageReceiverHelper", "unsupport action type, action: " + action);
                    } else {
                        cn.jpush.android.d.d b7 = cn.jpush.android.x.b.b(context, intent);
                        if (b7 != null) {
                            cn.jpush.android.q.a.a().a(context, b7, 1004);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("notify inapp cancel cmd, cancel messageId: ");
                        if (b7 != null) {
                            str = b7.f4127d;
                        }
                        sb.append(str);
                        Logger.dd("JMessageReceiverHelper", sb.toString());
                    }
                }
            }
        } catch (Throwable th) {
            Logger.ww("JMessageReceiverHelper", "MessageReceiver run failed:" + th.getMessage());
        }
    }

    public void a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        if (context == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = this.f4212c;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            b();
        }
        this.f4212c.execute(new C0069a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jPushMessageReceiver, intent));
    }
}
