package cn.jiguang.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.android.IDataShare;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bk.f;
import cn.jiguang.bk.g;
import cn.jiguang.bq.d;
import cn.jiguang.bx.e;
import cn.jiguang.by.c;
import cn.jiguang.f.h;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreHelperAction;
import cn.jpush.android.service.DataShare;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends JCoreHelperAction {

    /* renamed from: a  reason: collision with root package name */
    public static List<Integer> f3194a;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f3195c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3197d = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3196b = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Callable<Map<String, String>> {

        /* renamed from: b  reason: collision with root package name */
        private Context f3199b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f3200c;

        public a(Context context, Integer num) {
            this.f3199b = context;
            this.f3200c = num;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Map<String, String> call() {
            return cn.jiguang.dy.b.c(this.f3199b, this.f3200c.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.jiguang.c.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0058b extends cn.jiguang.cm.b {

        /* renamed from: b  reason: collision with root package name */
        private Context f3202b;

        /* renamed from: c  reason: collision with root package name */
        private Intent f3203c;

        /* renamed from: d  reason: collision with root package name */
        private String f3204d;

        public C0058b(Context context, Intent intent, String str) {
            this.f3202b = context;
            this.f3204d = str;
            this.f3203c = intent;
            this.f3462h = "JCoreHelper#PushReceiverAction";
        }

        @Override // cn.jiguang.cm.b
        public void a() {
            try {
                ActionManager.getInstance().handleMessage(this.f3202b, this.f3204d, this.f3203c);
                b.this.a(this.f3202b, this.f3203c);
            } catch (Throwable th) {
                d.l("JCoreHelper", "[PushReceiverAction failed:]" + th.getMessage());
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f3194a = arrayList;
        arrayList.add(18);
        f3194a.add(13);
        f3194a.add(52);
        f3194a.add(98);
        f3194a.add(7);
        f3194a.add(111);
        f3194a.add(99);
        f3194a.add(104);
        f3194a.add(119);
        f3194a.add(120);
        f3194a.add(121);
        f3194a.add(123);
        f3195c = new String[]{"JDevice", "JWakeCmd", "JWake", "JCommon", "JArp", "JLocation"};
    }

    private static PackageInfo a(Context context, Object... objArr) {
        Object obj;
        if (context == null || objArr == null) {
            return null;
        }
        int i4 = 0;
        String str = "";
        if (objArr.length == 1) {
            if (objArr[0] instanceof String) {
                str = (String) objArr[0];
            } else if (objArr[0] instanceof Integer) {
                obj = objArr[0];
                i4 = ((Integer) obj).intValue();
            }
        } else if (objArr.length > 1 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
            str = (String) objArr[0];
            obj = objArr[1];
            i4 = ((Integer) obj).intValue();
        }
        return !TextUtils.isEmpty(str) ? cn.jiguang.f.a.b(context, str, i4) : cn.jiguang.f.a.a(context, i4);
    }

    private static Bundle a(Context context, int i4, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            if (i4 == 4096) {
                if (bundle != null) {
                    a(context, cn.jiguang.bk.a.a(bundle, "arg1"));
                }
                return bundle2;
            } else if (i4 == 4098) {
                JCoreManager.init(context);
                return bundle2;
            } else {
                switch (i4) {
                    case 36864:
                        a(bundle);
                        return null;
                    case 36865:
                        if (JCoreManager.isInternal()) {
                            JConstants.testAndroidQ();
                        }
                        return null;
                    default:
                        return null;
                }
            }
        } catch (Throwable th) {
            d.l("JCoreHelper", "si e:" + th);
            return null;
        }
    }

    private Boolean a(int i4) {
        if (!f3194a.contains(Integer.valueOf(i4))) {
            if (f.a()) {
                if (i4 == 82) {
                    return Boolean.TRUE;
                }
                return null;
            } else if (g.a()) {
                return null;
            }
        }
        return Boolean.FALSE;
    }

    public static Object a(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 94, null, null, new Object[0]);
            if (onEvent instanceof Bundle) {
                return new JSONObject(((Bundle) onEvent).getString("de_inf"));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private Object a(Context context, String str, int i4) {
        boolean b4 = cn.jiguang.bk.d.b(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isServiceProcess", b4);
        if (b4) {
            Object a4 = e.a(context, "deviceinfo", null);
            if (a4 instanceof JSONObject) {
                bundle.putString("de_inf", a4.toString());
                return bundle;
            }
            return bundle;
        }
        IDataShare dataShare = DataShare.getInstance(cn.jiguang.bk.d.a(context));
        if (dataShare != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("cmd_event_bundle_cmd", i4);
            if (str != null) {
                bundle2.putString("cmd_event_bundle_sdk_type", str);
            }
            return dataShare.execute("INTERNAL_API", "cmd_event_bundle", bundle2);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Intent intent) {
        Method declaredMethod;
        Boolean bool;
        boolean z3;
        Bundle extras;
        d.c("JCoreHelper", "[handleReceiverIntent]:" + intent.getAction());
        e.a(context, "get_receiver", intent);
        String action = intent.getAction();
        if (action == null) {
            d.i("JCoreHelper", "onReceive empty action");
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            d.f("JCoreHelper", "onReceiveandroid.intent.action.USER_PRESENT");
            cn.jiguang.a.a.a(context, true, 0L);
            a(context, JConstants.SDK_TYPE, "user_present", (Bundle) null);
        } else if (action.equals("android.intent.action.SCREEN_ON")) {
            cn.jiguang.a.a.a(context, false, 0L);
        } else if (action.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo == null) {
                d.i("JCoreHelper", "Not found networkInfo");
                return;
            }
            d.c("JCoreHelper", "Connection state changed to - " + networkInfo.toString());
            if (2 == networkInfo.getType() || 3 == networkInfo.getType()) {
                d.c("JCoreHelper", "MMS or SUPL network state change, to do nothing!");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            Bundle extras2 = intent.getExtras();
            if (extras2 == null) {
                extras2 = new Bundle();
            }
            if (booleanExtra) {
                d.c("JCoreHelper", "No any network is connected");
                extras2.putBoolean("connected", false);
            } else {
                try {
                    if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                        d.c("JCoreHelper", "Network is connected.");
                        extras2.putBoolean("connected", true);
                    } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                        d.c("JCoreHelper", "Network is disconnected.");
                        extras2.putBoolean("connected", false);
                    } else {
                        d.c("JCoreHelper", "other network state - " + networkInfo.getState() + ". Do nothing.");
                    }
                } catch (Throwable unused) {
                    extras2.putBoolean("connected", cn.jiguang.f.a.e(context));
                }
            }
            cn.jiguang.a.a.a(context, "tcp_a15", extras2);
        } else if (!action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") && !action.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
            if (!action.equals("noti_open_proxy")) {
                if (!cn.jiguang.cf.b.f3377e.equals(action) || (extras = intent.getExtras()) == null) {
                    return;
                }
                cn.jiguang.cf.b.a().b(extras.getString("data"));
            } else if (intent.getBooleanExtra("debug_notification", false)) {
                String stringExtra = intent.getStringExtra("toastText");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                Toast makeText = Toast.makeText(context, stringExtra, 0);
                try {
                    View view = makeText.getView();
                    if (view instanceof LinearLayout) {
                        View childAt = ((LinearLayout) view).getChildAt(0);
                        if (childAt instanceof TextView) {
                            TextView textView = (TextView) childAt;
                            if (!cn.jiguang.f.g.a(stringExtra)) {
                                textView.setText(stringExtra);
                            }
                            textView.setTextSize(13.0f);
                        }
                    }
                } catch (Exception unused2) {
                }
                makeText.show();
            }
        } else {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                try {
                    Class<?> cls = Class.forName("android.os.PowerManager");
                    if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                        Method declaredMethod2 = cls.getDeclaredMethod("isDeviceIdleMode", new Class[0]);
                        if (declaredMethod2 != null) {
                            bool = (Boolean) declaredMethod2.invoke(powerManager, new Object[0]);
                            z3 = bool.booleanValue();
                        }
                        z3 = true;
                    } else {
                        if (action.equals("android.os.action.POWER_SAVE_MODE_CHANGED") && (declaredMethod = cls.getDeclaredMethod("isPowerSaveMode", new Class[0])) != null) {
                            bool = (Boolean) declaredMethod.invoke(powerManager, new Object[0]);
                            z3 = bool.booleanValue();
                        }
                        z3 = true;
                    }
                    if (z3) {
                        return;
                    }
                    d.c("JCoreHelper", "doze or powersave mode exit.");
                    cn.jiguang.a.a.a(context, true, 0L);
                } catch (Throwable th) {
                    d.l("JCoreHelper", "handle DEVICE_IDLE_MODE_CHANGED or POWER_SAVE_MODE_CHANGED fail:" + th);
                }
            }
        }
    }

    private static void a(Context context, Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            try {
                d.c("JCoreHelper", "setSDKConfigs");
                int i4 = 86400;
                try {
                    int i5 = bundle.getInt("heartbeat_interval", JConstants.DEFAULT_HEARTBEAT_INTERVAL);
                    if (i5 < 30) {
                        i5 = 30;
                    } else if (i5 > 86400) {
                        i5 = 86400;
                    }
                    JConstants.DEFAULT_HEARTBEAT_INTERVAL = i5;
                    d.c("JCoreHelper", "set heartbeat interval=" + i5);
                } catch (Throwable unused) {
                }
                try {
                    int i6 = bundle.getInt("alarm_delay", JConstants.DEFAULT_ALARM_DELAY);
                    if (i6 <= 86400) {
                        i4 = i6;
                    }
                    int i7 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
                    if (i4 < i7 + 5) {
                        i4 = i7 + 5;
                    }
                    JConstants.DEFAULT_ALARM_DELAY = i4;
                    d.c("JCoreHelper", "set alarm delay=" + i4);
                } catch (Throwable unused2) {
                }
                byte b4 = (byte) bundle.getInt("tcp_algorithm", -1);
                if (b4 >= 0) {
                    JConstants.tcpAlgorithm = b4;
                    d.c("JCoreHelper", "set tcp algorithm=" + ((int) b4));
                }
                if (bundle.containsKey("tcp_report")) {
                    cn.jiguang.bs.f.f2867d = bundle.getBoolean("tcp_report");
                }
                if (bundle.containsKey("plugin_report_switch")) {
                    context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("plugin_report_switch", bundle.getBoolean("plugin_report_switch")).apply();
                }
                if (bundle.containsKey("plugin_multi_switch")) {
                    context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("plugin_multi_switch", bundle.getBoolean("plugin_multi_switch")).apply();
                }
                int i8 = bundle.getInt("ipv_config", -1);
                c.a(i8);
                if (i8 != 2 && i8 != 3) {
                    if (i8 == 0 || i8 == 1) {
                        cn.jiguang.bs.f.f2872i = true;
                        return;
                    }
                    return;
                }
                cn.jiguang.bs.f.f2872i = false;
            } catch (Throwable unused3) {
            }
        }
    }

    public static void a(Context context, String str) {
        cn.jiguang.bk.a.a(context, str);
    }

    public static void a(Context context, String str, int i4, int i5, int i6) {
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putInt("custom", i4);
        bundle.putInt("dynamic", i5);
        bundle.putInt("sdk_v", i6);
        e.a(context, "set_sdktype_info", bundle);
    }

    public static void a(Context context, String str, Bundle bundle) {
        cn.jiguang.a.a.a(context, str, bundle);
    }

    private static void a(Context context, String str, Bundle bundle, String str2) {
        if (bundle != null) {
            bundle.putString("sdk_type", str);
            cn.jiguang.a.a.a(context, str2, bundle);
        }
    }

    public static void a(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        d.d("JCoreHelper", "runActionWithService action:" + str2);
        bundle.putString("sdk_type", str);
        bundle.putString("internal_action", str2);
        cn.jiguang.a.a.a(context, "a3", bundle);
    }

    public static void a(Context context, boolean z3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_auth", z3);
            a(context, "set_auth", bundle);
        } catch (Throwable th) {
            d.j("JCoreHelper", "sendSaveAuth error:" + th);
        }
    }

    public static void a(Bundle bundle) {
    }

    private static void a(String str, String str2, boolean z3, int i4, String str3, Throwable th) {
        cn.jiguang.bq.b.a(str, str2, z3, i4, str3, th);
    }

    private Object b(Context context, String str, int i4) {
        boolean b4 = cn.jiguang.bk.d.b(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isServiceProcess", b4);
        if (b4) {
            Object a4 = e.a(context, "get_loc_info", null);
            if (a4 instanceof Bundle) {
                Bundle bundle2 = (Bundle) a4;
                bundle2.putBoolean("isServiceProcess", true);
                return bundle2;
            }
            return bundle;
        }
        IDataShare dataShare = DataShare.getInstance(cn.jiguang.bk.d.a(context));
        if (dataShare != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("cmd_event_bundle_cmd", i4);
            if (str != null) {
                bundle3.putString("cmd_event_bundle_sdk_type", str);
            }
            return dataShare.execute("INTERNAL_API", "cmd_event_bundle", bundle3);
        }
        return bundle;
    }

    private static void b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sdk_type", str);
        cn.jiguang.a.a.a(context, "tcp_a8", bundle);
    }

    public static Pair<String, Long> c(Context context) {
        return cn.jiguang.bk.a.d(context);
    }

    private static void c(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sdk_type", str);
        cn.jiguang.a.a.a(context, "tcp_a9", bundle);
    }

    private static void c(Context context, String str, Bundle bundle) {
        if (bundle != null) {
            try {
                boolean z3 = bundle.getBoolean("sdk_banned");
                d.c("JCoreHelper", "[handleSdkBannedStatusChanged] sdk banned: " + z3);
                if (z3) {
                    b(context, str);
                    cn.jiguang.cb.b.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType);
                } else {
                    c(context, str);
                }
            } catch (Throwable th) {
                d.i("JCoreHelper", "network change handler error, " + th.getMessage());
            }
        }
    }

    private static void d(Context context, String str, Bundle bundle) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (bundle != null) {
            try {
                d.c("JCoreHelper", "[handleConnectionChanged] connected: " + bundle.getBoolean("connected"));
            } catch (Throwable th) {
                d.i("JCoreHelper", "network change handler error, " + th.getMessage());
                return;
            }
        }
        h.a();
        Intent intent = new Intent();
        intent.setAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            intent.putExtra("networkInfo", activeNetworkInfo);
            d.c("JCoreHelper", "networkInfo, available: " + activeNetworkInfo.isAvailable() + ", type: " + activeNetworkInfo.getType());
        }
        ActionManager.getInstance().handleMessage(context, str, intent);
        e.a(context, "action_net_changed", bundle);
        cn.jiguang.a.a.a(context, "tcp_a15", bundle);
    }

    public void a(Context context, boolean z3, int i4) {
        d.c("JCoreHelper", "changeForegroudStat:" + z3 + ", userActiveType:" + i4);
        this.f3196b = z3;
        cn.jiguang.bt.b.f2891a = z3;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", this.f3196b);
        bundle.putInt("user_type", i4);
        cn.jiguang.a.a.a(context, "a4", bundle);
        if (this.f3196b) {
            cn.jiguang.bm.e.a(context, 3);
            return;
        }
        this.f3197d = true;
        cn.jiguang.bm.e.a(context);
    }

    public void b(Context context, String str, Bundle bundle) {
        cn.jiguang.a.a.b(context, str, bundle);
    }

    public boolean b(Context context) {
        try {
            Bundle a4 = cn.jiguang.bk.e.a().a(context, "INTERNAL_API", "isTcpLoggedIn", null, cn.jiguang.bk.d.a(context));
            return (a4 == null || !a4.containsKey("state")) ? cn.jiguang.bx.h.a().d() : a4.getBoolean("state");
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Bundle directHandle(Context context, String str, String str2, Bundle bundle) {
        return cn.jiguang.bk.e.a().b(context, str, str2, bundle);
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Object onCommonMethod(Context context, String str, Object obj) {
        return e.a(context, str, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x02ef A[Catch: all -> 0x0a45, TryCatch #4 {all -> 0x0a45, blocks: (B:3:0x0010, B:5:0x001a, B:11:0x004b, B:13:0x004e, B:15:0x0057, B:17:0x0063, B:19:0x0070, B:20:0x0079, B:23:0x0084, B:25:0x0087, B:27:0x008d, B:29:0x009c, B:31:0x009f, B:33:0x00a5, B:34:0x00b2, B:36:0x00be, B:37:0x00c3, B:39:0x00d2, B:40:0x00da, B:48:0x0100, B:50:0x0106, B:52:0x010b, B:54:0x010e, B:56:0x0114, B:58:0x0123, B:60:0x0126, B:62:0x012c, B:64:0x013b, B:65:0x0144, B:67:0x014e, B:68:0x0157, B:70:0x0160, B:72:0x0163, B:74:0x0167, B:76:0x016c, B:78:0x0173, B:80:0x017b, B:82:0x0180, B:84:0x0185, B:86:0x018e, B:89:0x019b, B:91:0x019e, B:93:0x01a4, B:94:0x01c9, B:96:0x01d2, B:99:0x01d9, B:101:0x01dd, B:103:0x01e3, B:105:0x01ea, B:106:0x01fb, B:108:0x01fe, B:110:0x0203, B:113:0x020a, B:115:0x020d, B:117:0x0213, B:118:0x021f, B:122:0x0227, B:124:0x022b, B:126:0x0231, B:128:0x0237, B:129:0x024b, B:131:0x024e, B:132:0x0253, B:134:0x025a, B:136:0x025e, B:138:0x0264, B:140:0x026a, B:143:0x027d, B:145:0x0280, B:147:0x0286, B:149:0x0291, B:151:0x0294, B:153:0x029a, B:154:0x029e, B:156:0x02a5, B:158:0x02a8, B:160:0x02ae, B:162:0x02b9, B:164:0x02bc, B:166:0x02c2, B:167:0x02c6, B:169:0x02cd, B:171:0x02d0, B:173:0x02d6, B:175:0x02ef, B:177:0x02f9, B:179:0x02fd, B:181:0x0303, B:183:0x030a, B:185:0x0311, B:186:0x0335, B:187:0x033e, B:189:0x0349, B:191:0x034d, B:193:0x0353, B:47:0x00fb, B:196:0x035d, B:197:0x036e, B:199:0x0373, B:202:0x037e, B:204:0x0381, B:206:0x0387, B:208:0x038d, B:218:0x03dd, B:219:0x03ef, B:220:0x03f4, B:221:0x03f8, B:210:0x03b0, B:212:0x03b6, B:216:0x03d7, B:222:0x03fd, B:226:0x0409, B:228:0x040d, B:230:0x0413, B:233:0x041b, B:235:0x042e, B:237:0x0432, B:239:0x0438, B:241:0x043e, B:244:0x0446, B:246:0x0460, B:249:0x0469, B:251:0x046d, B:254:0x0489, B:256:0x048c, B:258:0x049b, B:260:0x049f, B:263:0x04e0, B:265:0x04e3, B:267:0x04e9, B:269:0x04f3, B:271:0x04f7, B:273:0x04fd, B:274:0x0501, B:277:0x050d, B:278:0x0512, B:281:0x051d, B:283:0x0520, B:285:0x0526, B:286:0x055a, B:288:0x0564, B:290:0x0568, B:291:0x0571, B:293:0x0579, B:295:0x057d, B:296:0x0586, B:298:0x058e, B:299:0x0597, B:302:0x059f, B:304:0x05a2, B:306:0x05a8, B:307:0x05b9, B:310:0x05c3, B:312:0x05c6, B:314:0x05cc, B:315:0x05dd, B:318:0x05e7, B:320:0x05ea, B:322:0x05f0, B:323:0x05fd, B:326:0x0607, B:328:0x060a, B:330:0x0610, B:331:0x061d, B:333:0x0624, B:335:0x0628, B:336:0x0659, B:338:0x0666, B:340:0x066d, B:342:0x0671, B:344:0x0677, B:346:0x0699, B:348:0x069c, B:349:0x06a1, B:351:0x06aa, B:353:0x06b3, B:356:0x06ba, B:358:0x06be, B:360:0x06c4, B:362:0x06ca, B:363:0x06f7, B:366:0x06fe, B:368:0x0701, B:370:0x0707, B:373:0x0712, B:375:0x0716, B:377:0x071c, B:379:0x0722, B:382:0x0735, B:384:0x0739, B:386:0x073f, B:388:0x0745, B:390:0x075d, B:392:0x0761, B:393:0x0766, B:395:0x076f, B:397:0x0772, B:399:0x0778, B:401:0x0787, B:403:0x078a, B:405:0x0790, B:407:0x079b, B:409:0x079f, B:411:0x07a5, B:413:0x07ac, B:415:0x07b3, B:416:0x0802, B:419:0x0809, B:421:0x080c, B:423:0x0812, B:425:0x0822, B:427:0x0825, B:429:0x082b, B:433:0x083e, B:437:0x0846, B:439:0x084e, B:441:0x0862, B:443:0x0865, B:445:0x086b, B:446:0x087f, B:461:0x08af, B:463:0x08b2, B:465:0x08b8, B:450:0x088b, B:452:0x088f, B:454:0x0895, B:456:0x0899, B:458:0x089f, B:466:0x08cb, B:469:0x08d4, B:471:0x08d7, B:473:0x08dd, B:474:0x08f7, B:478:0x0909, B:479:0x091a, B:481:0x0923, B:484:0x092e, B:486:0x0931, B:488:0x0937, B:490:0x0948, B:493:0x0953, B:495:0x0957, B:497:0x095b, B:499:0x0961, B:501:0x096a, B:505:0x0999, B:507:0x099d, B:509:0x09a3, B:511:0x09b2, B:513:0x09b5, B:516:0x09be, B:518:0x09c1, B:520:0x09c7, B:522:0x09cd, B:525:0x09da, B:528:0x09e4, B:530:0x09e7, B:532:0x09ed, B:534:0x09f3, B:542:0x0a0d, B:537:0x09fe, B:543:0x0a13, B:544:0x0a17, B:545:0x0a1b, B:547:0x0a20, B:549:0x0a25, B:551:0x0a2a, B:553:0x0a2f, B:555:0x0a34, B:556:0x0a38, B:557:0x0a3c, B:558:0x0a40, B:42:0x00df), top: B:570:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:633:? A[RETURN, SYNTHETIC] */
    @Override // cn.jiguang.internal.JCoreHelperAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object onEvent(android.content.Context r24, java.lang.String r25, int r26, java.lang.String r27, android.os.Bundle r28, java.lang.Object... r29) {
        /*
            Method dump skipped, instructions count: 2912
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.c.b.onEvent(android.content.Context, java.lang.String, int, java.lang.String, android.os.Bundle, java.lang.Object[]):java.lang.Object");
    }
}
