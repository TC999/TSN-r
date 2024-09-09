package cn.jpush.android.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ab.b;
import cn.jpush.android.ac.c;
import cn.jpush.android.ad.g;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.b.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushAction;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.local.JPushResponse;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.x.f;
import cn.jpush.android.z.e;
import com.stub.StubApp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends JPushAction {

    /* renamed from: e  reason: collision with root package name */
    private static int f4229e = 1000;

    /* renamed from: f  reason: collision with root package name */
    private static int f4230f = 1001;

    /* renamed from: a  reason: collision with root package name */
    private Boolean f4231a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f4232b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4233c;

    /* renamed from: d  reason: collision with root package name */
    private cn.jpush.android.s.a f4234d = new cn.jpush.android.s.a();

    private static JSONObject a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(byteBuffer.array());
            wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            Logger.d("JPushActionImpl", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e4) {
            Logger.w("JPushActionImpl", "parseBundle2Json exception:" + e4.getMessage());
            return null;
        }
    }

    private static void a(Context context, int i4, long j4) {
        if (i4 != 10) {
            if (i4 == 37) {
                d.a(context).a(j4, JPushInterface.ErrorCode.TIMEOUT, null);
                return;
            } else if (i4 != 38) {
                switch (i4) {
                    case 26:
                        cn.jpush.android.helper.d.a().a(context, j4, JPushInterface.ErrorCode.TIMEOUT);
                        return;
                    case 27:
                        c.a().b(context, j4);
                        return;
                    case 28:
                    case 29:
                        break;
                    default:
                        return;
                }
            }
        }
        b.a(context, cn.jpush.android.ab.c.a().a(j4), JPushInterface.ErrorCode.TIMEOUT, j4);
    }

    private static void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setMaxNotificationNum] bundle is bull");
            return;
        }
        int i4 = bundle.getInt("num");
        Logger.dd("JPushActionImpl", "action:setMaxNotificationNum :" + i4);
        int b4 = f.b();
        Logger.v("JPushActionImpl", "number in queue: " + b4);
        if (i4 < b4) {
            int i5 = b4 - i4;
            Logger.v("JPushActionImpl", "decreaseNotification:" + i5);
            cn.jpush.android.x.b.c(context, i5);
        }
        cn.jpush.android.cache.a.c(context, i4);
    }

    private void a(Context context, Bundle bundle, String str) {
        String str2;
        boolean z3;
        boolean z4 = bundle.getBoolean("enable", true);
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if ("enable_smart_push".equals(str)) {
            z3 = cn.jpush.android.cache.a.q(context) ^ z4;
            cn.jpush.android.cache.a.g(context, z4);
            boolean o4 = cn.jpush.android.cache.a.o(context);
            boolean n4 = cn.jpush.android.cache.a.n(context);
            Logger.e("JPushActionImpl", "ACTION_ENABLE_SMART_PUSH");
            if (z4 || o4) {
                arrayList.add(Integer.valueOf(f4230f));
            } else {
                arrayList2.add(Integer.valueOf(f4230f));
            }
            if (z4 || n4) {
                arrayList.add(Integer.valueOf(f4229e));
            } else {
                arrayList2.add(Integer.valueOf(f4229e));
            }
            str2 = "smartp";
        } else if ("enable_geo_push".equals(str)) {
            z3 = cn.jpush.android.cache.a.n(context) ^ z4;
            cn.jpush.android.cache.a.d(context, z4);
            Logger.e("JPushActionImpl", "ACTION_ENABLE_GEO_PUSH");
            boolean q3 = cn.jpush.android.cache.a.q(context);
            if (z4 || q3) {
                arrayList.add(Integer.valueOf(f4229e));
            } else {
                arrayList2.add(Integer.valueOf(f4229e));
            }
            str2 = "geo";
        } else if ("enable_link_push".equals(str)) {
            z3 = cn.jpush.android.cache.a.o(context) ^ z4;
            cn.jpush.android.cache.a.e(context, z4);
            Logger.e("JPushActionImpl", "ACTION_ENABLE_LINK_PUSH");
            boolean q4 = cn.jpush.android.cache.a.q(context);
            if (z4 || q4) {
                arrayList.add(Integer.valueOf(f4230f));
            } else {
                arrayList2.add(Integer.valueOf(f4230f));
            }
            str2 = "link";
        } else {
            str2 = "";
            z3 = false;
        }
        if (z3 && !TextUtils.isEmpty(str2)) {
            Logger.e("JPushActionImpl", "PushEnable report ");
            cn.jpush.android.helper.c.a(context, z4, str2);
        }
        Logger.e("JPushActionImpl", "enable=" + arrayList);
        Logger.e("JPushActionImpl", "disable=" + arrayList2);
        if (arrayList.size() == 0 && arrayList2.size() == 0) {
            return;
        }
        bundle.putIntegerArrayList("enable_c_c", arrayList);
        bundle.putIntegerArrayList("disable_c_c", arrayList2);
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 111, null, bundle, new Object[0]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(Context context, JPushResponse jPushResponse) {
        Logger.dd("JPushActionImpl", "action:handleMsg:" + jPushResponse);
        if (jPushResponse == null) {
            return;
        }
        int cmd = jPushResponse.getCmd();
        if (cmd == 3) {
            cn.jpush.android.z.c cVar = new cn.jpush.android.z.c(jPushResponse);
            if (cn.jpush.android.cache.a.d(context)) {
                Logger.d("JPushActionImpl", "JPush was stoped");
                if (cVar.a() != 20) {
                    return;
                }
            }
            cn.jpush.android.d.b.a(context, cVar);
            return;
        }
        if (cmd != 10 && cmd != 40) {
            switch (cmd) {
                case 25:
                    JSONObject a4 = a(jPushResponse.getBody());
                    if (a4 != null) {
                        switch (a4.optInt("cmd")) {
                            case 56:
                                d.a(context).a(a4);
                                return;
                            case 57:
                                return;
                            case 58:
                            default:
                                Logger.d("JPushActionImpl", "Unknown command for ctrl");
                                return;
                            case 59:
                                a(context, a4);
                                return;
                            case 60:
                                cn.jpush.android.x.b.a(context, 2, true);
                                return;
                        }
                    }
                    return;
                case 26:
                    cn.jpush.android.z.a aVar = new cn.jpush.android.z.a(jPushResponse);
                    cn.jpush.android.helper.d.a().a(context, aVar.getRquestId(), aVar.a());
                    return;
                case 27:
                    cn.jpush.android.z.a aVar2 = new cn.jpush.android.z.a(jPushResponse);
                    if (aVar2.a() == 0) {
                        c.a().a(context, jPushResponse.getRquestId());
                        return;
                    } else {
                        c.a().a(context, jPushResponse.getRquestId(), aVar2.a());
                        return;
                    }
                case 28:
                case 29:
                    break;
                default:
                    switch (cmd) {
                        case 36:
                            d.a(context).a(new cn.jpush.android.n.b(jPushResponse));
                            return;
                        case 37:
                            d.a(context).a(jPushResponse.getRquestId(), 0, new cn.jpush.android.n.d(jPushResponse));
                            return;
                        case 38:
                            break;
                        default:
                            Logger.w("JPushActionImpl", "Unknown command for parsing inbound. Union AD cmd: " + jPushResponse.getCmd());
                            return;
                    }
            }
        }
        e eVar = new e(jPushResponse);
        int cmd2 = jPushResponse.getCmd();
        b.a(context, eVar.a(), cmd2 != 28 ? cmd2 != 38 ? cmd2 != 40 ? 2 : 4 : 3 : 1, jPushResponse.getRquestId(), eVar.f4562a);
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.getJSONObject("content").optString("ids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Logger.d("JPushActionImpl", "dealCancelNotification ids=" + optString);
            String[] split = optString.split(",");
            LinkedList linkedList = new LinkedList();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    if (cn.jpush.android.x.d.a(context, str)) {
                        int a4 = cn.jpush.android.x.b.a(str, 0);
                        Logger.d("JPushActionImpl", "message id:" + str + " is in local history ,try cancel notificationID : " + a4);
                        if (cn.jpush.android.x.b.a(context, a4)) {
                            cn.jpush.android.x.b.d(context, a4);
                            cn.jpush.android.helper.c.a(split.length == 2 ? split[1] : str, 1068L, context);
                        }
                    } else if (cn.jpush.android.x.d.a(context, str, null)) {
                        Logger.d("JPushActionImpl", "dealCancelNotification , do nothing ");
                    } else {
                        byte b4 = cn.jpush.android.ac.e.a().b(context, str);
                        Logger.d("JPushActionImpl", "message id:" + str + " may be ospush channel,try cancel by sdkType: " + ((int) b4));
                        if (b4 != -1) {
                            cn.jpush.android.helper.c.a(str, "", b4, 1069L, context);
                        }
                    }
                    linkedList.add(str);
                }
            }
            cn.jpush.android.q.a.a().a(context, optString);
            cn.jpush.android.x.d.a(context, linkedList);
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "dealCancelNotification e:" + th);
        }
    }

    private boolean a(Context context) {
        Boolean bool = this.f4231a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            Logger.ww("JPushActionImpl", "context is null");
            return false;
        }
        this.f4233c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        Boolean valueOf = Boolean.valueOf(cn.jpush.android.ad.a.g(context));
        this.f4231a = valueOf;
        return valueOf.booleanValue();
    }

    private void b(Context context) {
        Logger.d("JPushActionImpl", "serviceInit...");
        try {
            if (this.f4232b != null) {
                return;
            }
            this.f4232b = Boolean.TRUE;
            int i4 = 2;
            if (JPushConstants.SUPPORT_DY && JConstants.SDK_VERSION_INT >= 220) {
                JCoreHelper.updateDy(context, 2);
            }
            int i5 = 1;
            cn.jpush.android.x.b.a(context, 0, true);
            g.a().a(context);
            c(context);
            Logger.d("JPushActionImpl", "google:false");
            int i6 = !TextUtils.isEmpty(JPushConstants.SDK_NAME) ? 2 : 0;
            if (JConstants.SDK_VERSION_INT < 220) {
                i5 = 0;
            }
            if (cn.jpush.android.m.a.f4248a == JPushConstants.SDK_VERSION_CODE) {
                i4 = i5;
            }
            Logger.d("JPushActionImpl", "custom:" + i6 + ",dynamic:" + i4);
            cn.jpush.android.x.e.a().a(context, null);
            JCoreHelper.reportSdkType(context, "push", i6, i4, cn.jpush.android.m.a.f4248a);
            if (JPushConstants.canGetLbsInBackGround(context)) {
                d.a(context).a();
            }
            cn.jpush.android.p.b.a().a(context);
            cn.jpush.android.ab.a.a(context);
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setSilenceTime] bundle is bull");
            return;
        }
        String string = bundle.getString("time");
        Logger.dd("JPushActionImpl", "action:setSilenceTime pushTime:" + string);
        cn.jpush.android.cache.a.c(context, string);
    }

    private void c(Context context) {
        try {
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("update", Context.class).invoke(null, context);
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setPushTime] bundle is bull");
            return;
        }
        cn.jpush.android.cache.a.b(context, true);
        String string = bundle.getString("time");
        if (!Pattern.compile("([0-6]{0,7})_((([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3]))|(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])-)+(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])))").matcher(string).matches()) {
            Logger.ee("JPushActionImpl", "Invalid time format - " + string);
            return;
        }
        String g4 = cn.jpush.android.cache.a.g(context);
        if (string.equals(g4)) {
            Logger.dd("JPushActionImpl", "Already SetPushTime, give up - " + g4);
            return;
        }
        Logger.dd("JPushActionImpl", "action:setPushTime pushTime:" + string);
        cn.jpush.android.cache.a.b(context, string);
    }

    @Override // cn.jpush.android.local.JPushAction
    public Object beforLogin(Context context, String str, int i4, String str2) {
        String str3;
        a(context);
        if (context == null) {
            str3 = "context was null";
        } else if (!TextUtils.isEmpty(str2)) {
            if ("platformtype".equals(str2)) {
                if (i4 >= 16) {
                    return Byte.valueOf(cn.jpush.android.ac.e.a().e(context));
                }
            } else if ("platformregid".equals(str2)) {
                return cn.jpush.android.ac.e.a().g(context);
            }
            return null;
        } else {
            str3 = " filed name was empty";
        }
        Logger.e("JPushActionImpl", str3);
        return null;
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPopWinActivity(Context context) {
        return new cn.jpush.android.ui.b();
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPushActivity(Context context) {
        return new cn.jpush.android.ui.c();
    }

    @Override // cn.jpush.android.local.JPushAction
    public String getSdkVersion(String str) {
        return cn.jpush.android.m.a.f4249b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:226:0x050f, code lost:
        if (r0 == 2001) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0511, code lost:
        if (r0 == 0) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0513, code lost:
        if (r0 != 2002) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x07c6, code lost:
        a(r9, r13, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:?, code lost:
        return null;
     */
    @Override // cn.jpush.android.local.JPushAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handleAction(android.content.Context r18, java.lang.String r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 2021
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.l.a.handleAction(android.content.Context, java.lang.String, java.lang.Object):java.lang.Object");
    }

    @Override // cn.jpush.android.local.JPushAction
    public void handleNotificationIntent(Context context, Intent intent) {
        if (cn.jpush.android.x.b.a(context, intent)) {
            cn.jpush.android.d.d b4 = cn.jpush.android.x.b.b(context, intent);
            Logger.i("JPushActionImpl", "handleNotificationIntent:" + b4);
            if (b4 == null) {
                g.a().a(context, intent);
                Logger.i("JPushActionImpl", "handleNotificationIntent handleOpenClick");
            } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
                g.a().a(context, b4, intent);
            } else {
                cn.jpush.android.x.b.a(context, intent.getAction(), b4, intent);
            }
        }
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onActivityLifeCallback(final Activity activity, final String str) {
        JCoreHelper.futureExecutor(null, new Runnable() { // from class: cn.jpush.android.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str2 = str;
                    char c4 = '\uffff';
                    switch (str2.hashCode()) {
                        case -1897185151:
                            if (str2.equals("started")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case -1884319283:
                            if (str2.equals("stopped")) {
                                c4 = 3;
                                break;
                            }
                            break;
                        case -995321554:
                            if (str2.equals("paused")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case 1097547223:
                            if (str2.equals("resumed")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 1986762265:
                            if (str2.equals("destroyed")) {
                                c4 = 4;
                                break;
                            }
                            break;
                    }
                    if (c4 == 0) {
                        a.this.f4234d.b(activity);
                    } else if (c4 == 1) {
                        a.this.f4234d.c(activity);
                    } else if (c4 == 2) {
                        a.this.f4234d.d(activity);
                    } else if (c4 == 3) {
                        a.this.f4234d.e(activity);
                    } else if (c4 != 4) {
                    } else {
                        a.this.f4234d.f(activity);
                    }
                } catch (Throwable th) {
                    Logger.w("JPushActionImpl", "onActivityLifeCallback failed. " + th.getMessage());
                }
            }
        });
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_IN_APP_MSG_CLICK);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onInAppMessageShow(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_IN_APP_MSG_SHOW);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        cn.jpush.android.helper.a.a().a(context, jPushMessageReceiver, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onJPushMessageReceive(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            cn.jpush.android.helper.a.a().a(context, JPushConstants.getPushMessageReceiver(context), cn.jpush.android.ad.a.a(bundle));
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMessage(Context context, CustomMessage customMessage) {
        cn.jpush.android.helper.a.a(context, customMessage);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMultiAction(Context context, Intent intent) {
        cn.jpush.android.helper.a.b(context, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_RECEIVED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_OPENED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onTagAliasResponse(Context context, long j4, int i4, Intent intent) {
        cn.jpush.android.ab.d.a().a(StubApp.getOrigApplicationContext(context.getApplicationContext()), j4, i4, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void setAliasAndTags(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        b.a(context, str, set, callBackParams);
    }
}
