package cn.jiguang.bx;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JPushInterface;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, JDispatchAction> f3080a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f3081b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f3082c = new Object();

    private b() {
        f3080a = ActionManager.getDispatchActionMap();
        cn.jiguang.bq.d.c("DispatchActionManager", "actiom map :" + f3080a);
        cn.jiguang.bq.d.c("DispatchActionManager", "actiom map size :" + f3080a.size());
        a(JConstants.SDK_TYPE, cn.jiguang.c.a.class.getCanonicalName());
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        return (Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8) + Integer.parseInt(split[2]);
    }

    public static b a() {
        if (f3081b == null) {
            synchronized (f3082c) {
                if (f3081b == null) {
                    f3081b = new b();
                }
            }
        }
        return f3081b;
    }

    private void b(Context context, int i4, int i5, String str) {
        Intent intent = null;
        try {
            if (i4 == 0 && i5 == 0) {
                intent = new Intent(JPushInterface.ACTION_REGISTRATION_ID);
                intent.putExtra(JPushInterface.EXTRA_REGISTRATION_ID, str);
            } else if (i4 == -1 || i4 == 1) {
                intent = new Intent(JPushInterface.ACTION_CONNECTION_CHANGE);
                if (i4 == -1) {
                    intent.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                } else {
                    intent.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, true);
                }
            }
            if (intent != null) {
                String packageName = context.getPackageName();
                intent.addCategory(packageName);
                intent.setPackage(packageName);
                cn.jiguang.f.a.a(context, intent);
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("DispatchActionManager", "sendToOldPushUser failed:" + th.getMessage());
        }
    }

    public byte a(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 24, "platformtype");
                if (beforLogin instanceof Byte) {
                    return ((Byte) beforLogin).byteValue();
                }
            }
        }
        return (byte) 0;
    }

    public Object a(Context context, String str, int i4) {
        String str2;
        if (JConstants.SDK_VERSION_INT <= 284) {
            return null;
        }
        JDispatchAction jDispatchAction = f3080a.get(str);
        if (jDispatchAction != null) {
            Object dataByCmd = jDispatchAction.getDataByCmd(context, i4);
            if (dataByCmd != null) {
                return dataByCmd;
            }
            str2 = str + " sdk action data:" + dataByCmd + ", actionType: " + i4;
        } else {
            str2 = str + " sdk action is null";
        }
        cn.jiguang.bq.d.a("DispatchActionManager", str2);
        return null;
    }

    public void a(Context context, int i4, int i5, String str) {
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                value.onEvent(context, entry.getKey(), i4, i5, str);
            }
        }
        b(context, i4, i5, str);
    }

    public void a(Context context, cn.jiguang.bz.c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            cn.jiguang.bq.d.i("DispatchActionManager", "Action - dispatchMessage unexcepted - head was null");
            return;
        }
        d a4 = j.a().a(cVar.f3172e);
        if (a4 == null) {
            for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && value.isSupportedCMD(entry.getKey(), cVar.f3170c)) {
                    value.dispatchMessage(context, entry.getKey(), cVar.f3170c, cVar.f3169b, cVar.f3172e, -1L, byteBuffer);
                }
            }
            return;
        }
        cn.jiguang.bq.d.c("DispatchActionManager", "dispacth msg with reuqest :" + a4);
        JDispatchAction jDispatchAction = f3080a.get(a4.f3085c);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchMessage(context, a4.f3085c, cVar.f3170c, cVar.f3169b, cVar.f3172e, a4.f3084b, byteBuffer);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("rid", cVar.f3172e);
        h.a().a(context, "tcp_a7", bundle);
    }

    public void a(Context context, String str, long j4, int i4) {
        if (!TextUtils.isEmpty(str) && str.equals(JConstants.SDK_TYPE)) {
            if (i4 == 26) {
                k.a().b(context, j4);
                return;
            } else if (i4 == 30 || i4 == 32) {
                cn.jiguang.e.a.b().a(context, i4);
                return;
            } else {
                return;
            }
        }
        JDispatchAction jDispatchAction = f3080a.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchTimeOutMessage(context, str, j4, i4);
            return;
        }
        cn.jiguang.bq.d.i("DispatchActionManager", "not found dispatch action by sdktype:" + str);
    }

    public void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            cn.jiguang.bq.d.j("DispatchActionManager", "run action bundle is null");
        } else if (TextUtils.isEmpty(str)) {
            cn.jiguang.bq.d.j("DispatchActionManager", "run action sdktype is empty");
        } else {
            if (JConstants.SDK_TYPE.contains(str)) {
                str = JConstants.SDK_TYPE;
            }
            JDispatchAction jDispatchAction = f3080a.get(str);
            if (jDispatchAction != null) {
                jDispatchAction.onActionRun(context, str, bundle.getString("internal_action"), bundle);
                return;
            }
            cn.jiguang.bq.d.j("DispatchActionManager", "dispacth action is null by sdktype:" + str);
        }
    }

    public void a(String str, String str2) {
        cn.jiguang.bq.d.c("DispatchActionManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (f3080a.containsKey(str)) {
            cn.jiguang.bq.d.c("DispatchActionManager", "has same type action");
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JDispatchAction) {
                f3080a.put(str, (JDispatchAction) newInstance);
                cn.jiguang.bq.d.c("DispatchActionManager", "action init:" + newInstance.getClass().getName());
            } else {
                cn.jiguang.bq.d.i("DispatchActionManager", "this action is not a JDispatchAction,please check and extends JDispatchAction");
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.j("DispatchActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public boolean a(int i4) {
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                try {
                    cn.jiguang.bq.d.d("DispatchActionManager", "isAllowAction actionType:" + i4 + ",sdktype:" + entry.getKey() + ",action:" + value.checkAction(entry.getKey(), i4));
                    if (!value.checkAction(entry.getKey(), i4)) {
                        return false;
                    }
                } catch (Throwable th) {
                    cn.jiguang.bq.d.i("DispatchActionManager", "isAllowAction error:" + th.getMessage());
                }
            }
        }
        return true;
    }

    public String b(int i4) {
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && value.getRegPriority(entry.getKey()) == i4) {
                return value.getSdkVersion(entry.getKey());
            }
        }
        return "";
    }

    public String b(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 24, "platformregid");
                if (beforLogin instanceof String) {
                    return (String) beforLogin;
                }
            }
        }
        return "";
    }

    public String b(String str, String str2) {
        String str3;
        JDispatchAction jDispatchAction = f3080a.get(str);
        if (jDispatchAction != null) {
            String sdkVersion = jDispatchAction.getSdkVersion(str);
            if (!TextUtils.isEmpty(sdkVersion)) {
                return sdkVersion;
            }
            str3 = str + " sdk action sdkversion:" + sdkVersion;
        } else {
            str3 = str + " sdk action is null";
        }
        cn.jiguang.bq.d.a("DispatchActionManager", str3);
        return str2;
    }

    public short b() {
        short regFlag;
        short s3 = 0;
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (regFlag = value.getRegFlag(entry.getKey())) != 0) {
                s3 = (short) (s3 | regFlag);
            }
        }
        return s3;
    }

    public short c() {
        short loginFlag;
        short s3 = 0;
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (loginFlag = value.getLoginFlag(entry.getKey())) != 0) {
                s3 = (short) (s3 | loginFlag);
            }
        }
        return s3;
    }

    public Map<Integer, Bundle> d() {
        int i4;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            Bundle pInfo = entry.getValue().getPInfo(entry.getKey());
            if (pInfo != null && (i4 = pInfo.getInt("pid", 0)) > 0) {
                hashMap.put(Integer.valueOf(i4), pInfo);
            }
        }
        return hashMap;
    }

    public String e() {
        StringBuilder sb;
        JDispatchAction value;
        short s3 = 3;
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            short regPriority = entry.getValue().getRegPriority(entry.getKey());
            if (s3 < regPriority) {
                s3 = regPriority;
            }
        }
        cn.jiguang.bq.d.c("DispatchActionManager", "max reg priority:" + ((int) s3));
        String str = "";
        for (int i4 = 0; i4 <= s3; i4++) {
            if (i4 == 3) {
                sb = new StringBuilder();
                sb.append(str);
                str = cn.jiguang.a.a.f2010b;
            } else {
                Iterator<Map.Entry<String, JDispatchAction>> it = f3080a.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, JDispatchAction> next = it.next();
                    if (next.getValue().getRegPriority(next.getKey()) == i4) {
                        str = str + value.getSdkVersion(next.getKey());
                        break;
                    }
                }
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append("|");
            str = sb.toString();
        }
        return str.substring(0, str.length() - 1);
    }

    public String f() {
        JDispatchAction value;
        String str = a(cn.jiguang.a.a.f2010b) + "|";
        short s3 = 0;
        for (Map.Entry<String, JDispatchAction> entry : f3080a.entrySet()) {
            short logPriority = entry.getValue().getLogPriority(entry.getKey());
            if (s3 < logPriority) {
                s3 = logPriority;
            }
        }
        cn.jiguang.bq.d.c("DispatchActionManager", "max login priority:" + ((int) s3));
        for (int i4 = 1; i4 <= s3; i4++) {
            Iterator<Map.Entry<String, JDispatchAction>> it = f3080a.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, JDispatchAction> next = it.next();
                    if (next.getValue().getLogPriority(next.getKey()) == i4) {
                        str = str + a(value.getSdkVersion(next.getKey()));
                        break;
                    }
                }
            }
            str = str + "|";
        }
        return str.substring(0, str.length() - 1);
    }
}
