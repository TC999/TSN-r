package cn.jiguang.s;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.ag.i;
import cn.jiguang.ah.c;
import cn.jiguang.android.BuildConfig;
import cn.jiguang.ao.e;
import cn.jiguang.t.d;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static Object a(Context context, String str, Bundle bundle, Object obj) {
        char c4 = '\uffff';
        try {
            switch (str.hashCode()) {
                case -1915886140:
                    if (str.equals("getWifiMac")) {
                        c4 = '\n';
                        break;
                    }
                    break;
                case -1897779038:
                    if (str.equals("getResolution")) {
                        c4 = 17;
                        break;
                    }
                    break;
                case -1714850613:
                    if (str.equals("teleony_getNetworkOperator")) {
                        c4 = 22;
                        break;
                    }
                    break;
                case -1651545240:
                    if (str.equals("getUserWakeEnable")) {
                        c4 = 29;
                        break;
                    }
                    break;
                case -1556160744:
                    if (str.equals("getLocalWakeState")) {
                        c4 = 28;
                        break;
                    }
                    break;
                case -1538966972:
                    if (str.equals("teleony_clearCache")) {
                        c4 = 21;
                        break;
                    }
                    break;
                case -1406619289:
                    if (str.equals("writeJson")) {
                        c4 = '#';
                        break;
                    }
                    break;
                case -1404199686:
                    if (str.equals("sentry_getOperatingSystem")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case -867827810:
                    if (str.equals("readJson")) {
                        c4 = '$';
                        break;
                    }
                    break;
                case -770363721:
                    if (str.equals("getExternalSdPath")) {
                        c4 = 19;
                        break;
                    }
                    break;
                case -715322427:
                    if (str.equals("teleony_getCurrentNetType")) {
                        c4 = 23;
                        break;
                    }
                    break;
                case -564813279:
                    if (str.equals("isReportEnable")) {
                        c4 = 26;
                        break;
                    }
                    break;
                case -500196025:
                    if (str.equals("readString")) {
                        c4 = '\"';
                        break;
                    }
                    break;
                case -342837689:
                    if (str.equals("getManufacturer")) {
                        c4 = '\f';
                        break;
                    }
                    break;
                case -315336475:
                    if (str.equals("setLastBusinessTime")) {
                        c4 = 31;
                        break;
                    }
                    break;
                case -75445954:
                    if (str.equals("getImei")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case -75445520:
                    if (str.equals("getImsi")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case 355855900:
                    if (str.equals("getBaseBand")) {
                        c4 = 14;
                        break;
                    }
                    break;
                case 431172070:
                    if (str.equals("dy_getDInfo")) {
                        c4 = 20;
                        break;
                    }
                    break;
                case 483103770:
                    if (str.equals("getDeviceInfo")) {
                        c4 = 25;
                        break;
                    }
                    break;
                case 579484703:
                    if (str.equals("checkDeviceRooted")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 688591589:
                    if (str.equals("versionCode")) {
                        c4 = '%';
                        break;
                    }
                    break;
                case 695623497:
                    if (str.equals("getOsVersionName")) {
                        c4 = 15;
                        break;
                    }
                    break;
                case 737268134:
                    if (str.equals("getWifiSsid")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 790175978:
                    if (str.equals("getSerial")) {
                        c4 = 18;
                        break;
                    }
                    break;
                case 974799639:
                    if (str.equals("getWifiInfoList")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1081009335:
                    if (str.equals("checkManifestLocInfo")) {
                        c4 = '&';
                        break;
                    }
                    break;
                case 1122095412:
                    if (str.equals("getAndroidId")) {
                        c4 = 11;
                        break;
                    }
                    break;
                case 1141266261:
                    if (str.equals("getWifiMacFromWifiMgr")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 1228391385:
                    if (str.equals("getLastBusinessTime")) {
                        c4 = 30;
                        break;
                    }
                    break;
                case 1364785682:
                    if (str.equals("getWifiBssid")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 1388985359:
                    if (str.equals("teleony_getIntNetType")) {
                        c4 = 24;
                        break;
                    }
                    break;
                case 1412235472:
                    if (str.equals("writeString")) {
                        c4 = '!';
                        break;
                    }
                    break;
                case 1551167234:
                    if (str.equals("updateWakeCount")) {
                        c4 = ' ';
                        break;
                    }
                    break;
                case 1714085202:
                    if (str.equals("getNetworkType")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 1716587524:
                    if (str.equals("isCanCollect")) {
                        c4 = '\'';
                        break;
                    }
                    break;
                case 1798653732:
                    if (str.equals("setLocalWakeState")) {
                        c4 = 27;
                        break;
                    }
                    break;
                case 1924827372:
                    if (str.equals("sentry_getDevice")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 1949823441:
                    if (str.equals("getBrand")) {
                        c4 = 16;
                        break;
                    }
                    break;
                case 1959895411:
                    if (str.equals("getModel")) {
                        c4 = '\r';
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    return cn.jiguang.ag.a.a(context, false);
                case 1:
                    return d.a(context, 10, false);
                case 2:
                    return cn.jiguang.ag.a.b(context, false);
                case 3:
                    return cn.jiguang.ag.a.a(context, "", false);
                case 4:
                    return Boolean.valueOf(cn.jiguang.ag.a.h(context));
                case 5:
                    return i.a(context);
                case 6:
                    return cn.jiguang.an.d.a(context);
                case 7:
                    return cn.jiguang.an.d.b(context);
                case '\b':
                    return cn.jiguang.ag.a.c(context, bundle.getString("defaultImei"));
                case '\t':
                    return cn.jiguang.ag.a.d(context, bundle.getString("defaultImsi"));
                case '\n':
                    return cn.jiguang.ag.a.a(context, bundle.getString("defaultString"), false);
                case 11:
                    return cn.jiguang.ag.a.g(context);
                case '\f':
                    return cn.jiguang.ag.a.t(context);
                case '\r':
                    return cn.jiguang.ag.a.p(context);
                case 14:
                    return cn.jiguang.ag.a.q(context);
                case 15:
                    return cn.jiguang.ag.a.v(context);
                case 16:
                    return cn.jiguang.ag.a.r(context);
                case 17:
                    return cn.jiguang.ag.a.c(context);
                case 18:
                    return "";
                case 19:
                    return cn.jiguang.ag.a.d(context);
                case 20:
                    return cn.jiguang.aj.a.a(context);
                case 21:
                    i.a();
                    return null;
                case 22:
                    return i.a(context, false);
                case 23:
                    return (bundle == null || !bundle.containsKey("networkType")) ? i.d(context) : i.a(context, bundle.getInt("networkType"));
                case 24:
                    return Integer.valueOf(i.b(context));
                case 25:
                    return cn.jiguang.al.a.a(context).a();
                case 26:
                    return Boolean.valueOf(c.d(context, bundle.getString("tag")));
                case 27:
                    c.o(context, bundle.getString("wakeLocalState"));
                    return null;
                case 28:
                    return c.c(context);
                case 29:
                    return Boolean.valueOf(c.b(context));
                case 30:
                    return Long.valueOf(c.f(context, bundle.getString("tag")));
                case 31:
                    c.e(context, bundle.getString("tag"));
                    return null;
                case ' ':
                    c.a(context);
                    return null;
                case '!':
                    return Boolean.valueOf(e.a(context, bundle.getString("fileName"), bundle.getString("content")));
                case '\"':
                    return e.c(context, bundle.getString("fileName"));
                case '#':
                    return Boolean.valueOf(e.a(context, bundle.getString("fileName"), (JSONObject) obj));
                case '$':
                    return e.a(context, bundle.getString("fileName"));
                case '%':
                    return Integer.valueOf((int) BuildConfig.VERSION_CODE);
                case '&':
                    cn.jiguang.ao.b.a(context);
                    return null;
                case '\'':
                    return Boolean.valueOf(cn.jiguang.ar.a.a().b(bundle.getInt("configID"), bundle.getBoolean("isFromJCore")));
                default:
                    return null;
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JCoreToJPortrait", "onEvent:" + th);
            return null;
        }
    }
}
