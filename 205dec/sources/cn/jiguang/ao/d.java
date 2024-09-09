package cn.jiguang.ao;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ah.a;
import cn.jpush.android.service.PushReceiver;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.embedapplog.GameReportHelper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f2329a = ".permission.JPUSH_MESSAGE";

    /* renamed from: b  reason: collision with root package name */
    private static long f2330b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f2331c;

    public static Object a(final Context context, String str, final Object obj) {
        char c4;
        String action;
        String str2;
        String str3;
        try {
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JCommonActionHelper", "onEvent throwable:" + th.getMessage());
        }
        if (context == null) {
            cn.jiguang.w.a.f("JCommonActionHelper", "context is null,give up continue");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            cn.jiguang.w.a.f("JCommonActionHelper", "action is null,give up continue");
            return null;
        } else {
            if (TextUtils.isEmpty(a.C0049a.f2213b)) {
                a.C0049a.f2213b = cn.jiguang.ag.a.t(context);
            }
            cn.jiguang.ar.a.a().a(context);
            char c5 = 5;
            char c6 = 0;
            switch (str.hashCode()) {
                case -1677912609:
                    if (str.equals("get_installed_pkg_list")) {
                        c4 = '\f';
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case -835320015:
                    if (str.equals("get_all_ids")) {
                        c4 = '\b';
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case -24181482:
                    if (str.equals("get_loc_info")) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 385278662:
                    if (str.equals("periodtask")) {
                        c4 = 0;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 781805572:
                    if (str.equals("deviceinfo")) {
                        c4 = 5;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 805881853:
                    if (str.equals("getwakeenable")) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1207373895:
                    if (str.equals("user_present")) {
                        c4 = 11;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1282759650:
                    if (str.equals("on_logged")) {
                        c4 = 7;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1563305729:
                    if (str.equals("getnewbox")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1567409176:
                    if (str.equals("filter_pkg_list")) {
                        c4 = 4;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1660517635:
                    if (str.equals("on_register")) {
                        c4 = 6;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1947980230:
                    if (str.equals("service_create")) {
                        c4 = '\t';
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1976348689:
                    if (str.equals("get_imei")) {
                        c4 = '\n';
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1979938307:
                    if (str.equals("uid_switch")) {
                        c4 = '\r';
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    c4 = '\uffff';
                    break;
            }
            switch (c4) {
                case 0:
                    cn.jiguang.w.a.b("JCommonActionHelper", "action period task..");
                    cn.jiguang.ax.c.a().a(context, new cn.jiguang.ax.b() { // from class: cn.jiguang.ao.d.1
                        @Override // cn.jiguang.ax.b
                        public void a() {
                            cn.jiguang.w.a.b("JCommonActionHelper", "data config is prepare finished");
                            d.b(context);
                            d.b(context, obj);
                        }
                    });
                    cn.jiguang.ab.a.a().b(context);
                    break;
                case 1:
                    cn.jiguang.ar.a.a().b(context);
                    return (cn.jiguang.ar.a.a().a(1500) && cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) ? cn.jiguang.t.a.a().d(context) : "";
                case 2:
                    return cn.jiguang.ac.a.b(context);
                case 3:
                    if (cn.jiguang.ar.a.a().e(1029)) {
                        return cn.jiguang.bb.a.f(context);
                    }
                    return null;
                case 4:
                    return cn.jiguang.ac.a.a(context, obj);
                case 5:
                    cn.jiguang.ar.a.a().b(context);
                    if (cn.jiguang.ar.a.a().a(1000)) {
                        return cn.jiguang.ay.b.d().d(context);
                    }
                    return null;
                case 6:
                    if (cn.jiguang.ar.a.a().a(1000)) {
                        cn.jiguang.ay.b.d().a(context, cn.jiguang.ar.a.a().b(1000));
                    }
                    cn.jiguang.ac.a.a(context, GameReportHelper.REGISTER);
                    cn.jiguang.v.g.a().a(context, cn.jiguang.t.a.a().b(true));
                    break;
                case 7:
                    cn.jiguang.w.a.b("JCommonActionHelper", "action on logged...");
                    new cn.jiguang.ay.h().b(context, 0);
                    break;
                case '\b':
                    if (cn.jiguang.ar.a.a().e(2010)) {
                        return cn.jiguang.bd.a.a(context);
                    }
                    return null;
                case '\t':
                    cn.jiguang.w.a.b("JCommonActionHelper", "action service  create..");
                    cn.jiguang.ax.c.a().a(context, 5);
                    cn.jiguang.ab.a.a().a(context);
                    str3 = CampaignEx.JSON_NATIVE_VIDEO_START;
                    cn.jiguang.ac.a.a(context, str3);
                    break;
                case '\n':
                    cn.jiguang.ax.c.a().a(context, 1);
                    return cn.jiguang.ar.a.a().e(2004) ? cn.jiguang.bb.c.a(context, "") : "";
                case 11:
                    str3 = "screen";
                    cn.jiguang.ac.a.a(context, str3);
                    break;
                case '\f':
                    return cn.jiguang.common.n.d.a(context, false, obj);
                case '\r':
                    return Boolean.valueOf(cn.jiguang.ar.a.a().a(2300));
            }
            Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
            if (bundle != null) {
                switch (str.hashCode()) {
                    case -1921540966:
                        if (str.equals("foreground_state_change")) {
                            c5 = '\n';
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case -1485564867:
                        if (str.equals("notification_state")) {
                            c5 = 7;
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case -955011762:
                        if (str.equals("init_local_ctrl")) {
                            c5 = 0;
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case -955005568:
                        if (str.equals("lbsenable")) {
                            c5 = 1;
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case -691876648:
                        if (str.equals("set_ctrl_url")) {
                            c5 = 3;
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case -504314929:
                        if (str.equals("open_log")) {
                            c5 = '\t';
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case -50423372:
                        if (str.equals("GET_ANDROID_ID")) {
                            c5 = '\f';
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case 98618:
                        if (str.equals("cmd")) {
                            c5 = 4;
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case 38214203:
                        if (str.equals("SYNC_COLLECT_CONFIG")) {
                            c5 = 11;
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case 112894784:
                        if (str.equals("waked")) {
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case 1196294537:
                        if (str.equals("action_net_changed")) {
                            c5 = '\r';
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case 1391522972:
                        if (str.equals("lbsforenry")) {
                            c5 = 2;
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case 1995819041:
                        if (str.equals("set_wake_enable")) {
                            c5 = '\b';
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    case 2063320150:
                        if (str.equals("set_sdktype_info")) {
                            c5 = 6;
                            break;
                        }
                        c5 = '\uffff';
                        break;
                    default:
                        c5 = '\uffff';
                        break;
                }
                switch (c5) {
                    case 1:
                        if (cn.jiguang.ar.a.a().a(1500)) {
                            boolean z3 = bundle.getBoolean("enable");
                            cn.jiguang.w.a.b("JCommonActionHelper", "[setLBSEnable] " + z3);
                            cn.jiguang.ah.c.b(context, "JLocation", z3);
                            break;
                        }
                        break;
                    case 3:
                        cn.jiguang.af.b.a(a(bundle.getString("test_wake_controll_url")));
                        cn.jiguang.ax.c.a(a(bundle.getString("test_all_cfg_url")));
                        cn.jiguang.v.f.a(a(bundle.getString("test_lv2_url")));
                        cn.jiguang.ab.a.f2032a = bundle.getString("test_uaid_url");
                        cn.jiguang.ay.e.f2490a = bundle.getString("test_ipv6_url");
                        break;
                    case 4:
                        a(context, bundle);
                        break;
                    case 5:
                        int i4 = bundle.getInt("type", -1);
                        if (!TextUtils.isEmpty(bundle.getString("from_package"))) {
                            if (i4 != -1) {
                                cn.jiguang.af.g.a(context, bundle, i4);
                                break;
                            } else {
                                str2 = "[waked]wrong waked type";
                            }
                        } else {
                            str2 = "[waked]empty packageName waked from ";
                        }
                        cn.jiguang.w.a.f("JCommonActionHelper", str2);
                        break;
                    case 6:
                        new cn.jiguang.aa.a().a(context, bundle);
                        break;
                    case 7:
                        if (cn.jiguang.ar.a.a().a(1800)) {
                            cn.jiguang.x.a.a(context, bundle.getInt("scence"));
                            break;
                        }
                        break;
                    case '\b':
                        cn.jiguang.ah.c.a(context, bundle.getBoolean("enable"));
                        break;
                    case '\t':
                        cn.jiguang.s.b.a(context, new JSONObject(cn.jiguang.ap.b.b(bundle.getString("aes"), a.C0049a.f2223l)));
                        break;
                    case '\n':
                        cn.jiguang.af.f.a().a(context, bundle.getBoolean("foreground"));
                        break;
                    case 11:
                        cn.jiguang.ar.c.a().a(bundle);
                        break;
                    case '\f':
                        if (bundle.getInt("s_a_id") == 2000) {
                            cn.jiguang.ag.a.c(context, true);
                            break;
                        }
                        break;
                    case '\r':
                        if (bundle.getBoolean("connected")) {
                            cn.jiguang.ag.a.a(context, true);
                            cn.jiguang.ag.a.b(context, true);
                            break;
                        }
                        break;
                }
            }
            Intent intent = obj instanceof Intent ? (Intent) obj : null;
            if (intent != null) {
                if (str.hashCode() == 1563192504 && str.equals("get_receiver")) {
                    if (c6 == 0 && (action = intent.getAction()) != null && (("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) && cn.jiguang.ar.a.a().e(1101))) {
                        cn.jiguang.as.c.d().a(context, intent);
                    }
                }
                c6 = '\uffff';
                if (c6 == 0) {
                    cn.jiguang.as.c.d().a(context, intent);
                }
            }
            return null;
        }
    }

    private static LinkedList<String> a(String str) {
        String[] split;
        try {
            LinkedList<String> linkedList = new LinkedList<>();
            if (str != null && str.length() > 0) {
                for (String str2 : str.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        linkedList.add(str2);
                    }
                }
            }
            return linkedList;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONObject a(Bundle bundle) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bundle.getByteArray("RESPONSE_BODY"));
            f2330b = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            cn.jiguang.w.a.b("JCommonActionHelper", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e4) {
            cn.jiguang.w.a.f("JCommonActionHelper", "parseBundle2Json exception:" + e4.getMessage());
            return null;
        }
    }

    private static void a(Context context, int i4) {
        long a4 = f.a();
        String a5 = cn.jiguang.bb.a.a(context, i4);
        byte[] a6 = f.a(f2330b, a5);
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", 25);
        bundle.putInt("ver", 1);
        bundle.putLong("rid", a4);
        bundle.putLong("timeout", 0L);
        bundle.putByteArray("body", a6);
        if (!TextUtils.isEmpty(a5)) {
            cn.jiguang.w.a.b("JCommonActionHelper", "tcp report deviceInfo:" + a5);
        }
        cn.jiguang.ah.d.a(context, bundle);
    }

    private static void a(Context context, Bundle bundle) {
        cn.jiguang.ah.b d4;
        cn.jiguang.ah.b a4;
        JSONObject a5 = a(bundle);
        if (a5 == null) {
            return;
        }
        int optInt = a5.optInt("cmd");
        a(context, optInt);
        if (optInt != 4) {
            if (optInt != 5) {
                if (optInt != 9) {
                    if (optInt == 50) {
                        cn.jiguang.ac.b.a(context, a5);
                        return;
                    } else if (optInt == 52) {
                        if (cn.jiguang.ar.a.a().a(1600)) {
                            a4 = cn.jiguang.au.a.d();
                            a4.b(context, a5);
                            return;
                        }
                        return;
                    } else if (optInt == 70) {
                        cn.jiguang.ac.a.a(context);
                        return;
                    } else if (optInt != 74) {
                        if (optInt == 79) {
                            cn.jiguang.v.g.a().a(context, 0);
                            return;
                        } else if (optInt == 82) {
                            cn.jiguang.s.b.a(context, a5);
                            return;
                        } else if (optInt != 44) {
                            if (optInt != 45) {
                                if (optInt == 54) {
                                    if (cn.jiguang.ar.a.a().e(1102)) {
                                        cn.jiguang.as.f.d().a(context, a5);
                                        return;
                                    }
                                    return;
                                } else if (optInt == 55 && cn.jiguang.ar.a.a().e(2200)) {
                                    cn.jiguang.ah.d.a(context, a5);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } else if (!cn.jiguang.ar.a.a().e(1102)) {
                            return;
                        } else {
                            d4 = cn.jiguang.as.f.d();
                        }
                    } else if (!cn.jiguang.ar.a.a().e(1103)) {
                        return;
                    } else {
                        d4 = cn.jiguang.as.g.d();
                    }
                } else if (!cn.jiguang.ar.a.a().e(1300)) {
                    return;
                } else {
                    d4 = cn.jiguang.as.d.d();
                }
            }
            if (cn.jiguang.ar.a.a().h(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) {
                cn.jiguang.t.a.a().a(true);
                a4 = cn.jiguang.t.a.a();
                a4.b(context, a5);
                return;
            }
            return;
        } else if (!cn.jiguang.ar.a.a().h(1100)) {
            return;
        } else {
            cn.jiguang.as.b.d().a(true);
            d4 = cn.jiguang.as.b.d();
        }
        d4.f(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Object obj) {
        return ((obj instanceof Bundle) && ((Bundle) obj).getBoolean("login")) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context) {
        try {
            if (f2331c != null) {
                return;
            }
            boolean k4 = cn.jiguang.h.a.k(context);
            boolean l4 = cn.jiguang.h.a.l(context);
            boolean a4 = cn.jiguang.ar.c.a().a(1101);
            boolean z3 = false;
            boolean a5 = cn.jiguang.ar.a.a().a(1101, false);
            cn.jiguang.w.a.b("JCommonActionHelper", "registerPushReceiver isFuture=" + l4);
            cn.jiguang.w.a.b("JCommonActionHelper", "registerPushReceiver enableAutoWakeup=" + k4);
            cn.jiguang.w.a.b("JCommonActionHelper", "registerPushReceiver containEnableDatas=" + a4);
            cn.jiguang.w.a.b("JCommonActionHelper", "registerPushReceiver configEnable=" + a5);
            if ((k4 || a4) && a5) {
                z3 = true;
            }
            cn.jiguang.w.a.b("JCommonActionHelper", "registerPushReceiver enable=" + z3);
            f2331c = Boolean.TRUE;
            if (l4 && z3) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addDataScheme("package");
                cn.jiguang.ap.a.a(context, new PushReceiver(), intentFilter, context.getPackageName() + f2329a, null);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(final android.content.Context r4, final java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ao.d.b(android.content.Context, java.lang.Object):void");
    }
}
