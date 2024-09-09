package cn.jpush.android.ac;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ad.f;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.data.JPushConfig;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.PushReceiver;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f3945a = "exception_type";

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Byte> f3946c;

    /* renamed from: f  reason: collision with root package name */
    private static e f3947f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object f3948g;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f3950d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3951e = false;

    /* renamed from: h  reason: collision with root package name */
    private String f3952h = null;

    /* renamed from: b  reason: collision with root package name */
    private List<JThirdPlatFormInterface> f3949b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        String f3964a;

        /* renamed from: b  reason: collision with root package name */
        int f3965b;

        /* renamed from: c  reason: collision with root package name */
        String f3966c;

        /* renamed from: d  reason: collision with root package name */
        byte f3967d;

        a() {
        }

        public String toString() {
            return "ThirdMessage{msgid='" + this.f3964a + "', notiId=" + this.f3965b + ", content='" + this.f3966c + "', platform=" + ((int) this.f3967d) + '}';
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3946c = hashMap;
        f3948g = new Object();
        hashMap.put("cn.jpush.android.thirdpush.meizu.MeizuPushManager", (byte) 3);
        f3946c.put("cn.jpush.android.thirdpush.xiaomi.XMPushManager", (byte) 1);
        f3946c.put("cn.jpush.android.thirdpush.huawei.HWPushManager", (byte) 2);
        f3946c.put("cn.jpush.android.thirdpush.fcm.FCMPushManager", (byte) 8);
        f3946c.put("cn.jpush.android.thridpush.oppo.OPushManager", (byte) 4);
        f3946c.put("cn.jpush.android.thirdpush.vivo.VivoPushManager", (byte) 5);
        f3946c.put("cn.jpush.android.thirdpush.honor.HonorPushManager", (byte) 7);
        f3946c.put(cn.jpush.android.asus.b.class.getName(), (byte) 6);
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a a(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            aVar = new a();
            aVar.f3966c = bundle.getString("data");
            aVar.f3964a = bundle.getString(JThirdPlatFormInterface.KEY_MSG_ID);
            aVar.f3965b = bundle.getInt(JThirdPlatFormInterface.KEY_NOTI_ID, 0);
            aVar.f3967d = bundle.getByte("platform", (byte) -1).byteValue();
        } else {
            aVar = null;
        }
        Logger.d("ThirdPushManager", "parse third messgae:" + aVar);
        return aVar;
    }

    public static e a() {
        if (f3947f == null) {
            synchronized (f3948g) {
                if (f3947f == null) {
                    f3947f = new e();
                }
            }
        }
        return f3947f;
    }

    private void a(Context context, byte b4, String str, boolean z3) {
        Logger.d("ThirdPushManager", "sendUpdateRegIDRequest, WhichPlatform:" + ((int) b4) + ",regID:" + str);
        Sp.set(context, Key.ThirdPush_RegUpload(b4).set(Boolean.FALSE));
        Sp.set(context, Key.ThirdPush_RegID(b4).set(str));
        c.a().a(context, b4, str, z3);
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface) {
        if (jThirdPlatFormInterface == null || !jThirdPlatFormInterface.isNeedClearToken(context)) {
            return;
        }
        byte romType = jThirdPlatFormInterface.getRomType(context);
        Sp.set(context, Key.ThirdPush_RegUpload(romType).set(Boolean.FALSE));
        Sp.set(context, Key.ThirdPush_RegID(romType).set(null));
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface, String str) {
        Logger.d("ThirdPushManager", "sendBroadCastToUploadToken:" + str);
        try {
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction(str);
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", JPushConstants.SDK_TYPE);
            bundle.putByte("platform", jThirdPlatFormInterface == null ? (byte) -1 : jThirdPlatFormInterface.getRomType(context));
            intent.putExtras(bundle);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "send " + str + " failed:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, String str4) {
        cn.jpush.android.data.a aVar = new cn.jpush.android.data.a();
        aVar.setjAppKey(str);
        int f4 = f(context);
        if (f4 == 1) {
            aVar.setXmAppKey(str2);
            aVar.setXmAppId(str3);
        } else if (f4 == 2) {
            aVar.a(str3);
        } else if (f4 == 3) {
            aVar.setMzAppKey(str2);
            aVar.setMzAppId(str3);
        } else if (f4 == 4) {
            aVar.setOppoAppKey(str2);
            aVar.setOppoAppId(str3);
            aVar.setOppoAppSecret(str4);
        } else if (f4 == 5) {
            aVar.c(str2);
            aVar.d(str3);
        } else if (f4 == 7) {
            aVar.b(str3);
        }
        JPushInterface.init(context, aVar);
    }

    private byte b() {
        try {
            String lowerCase = cn.jpush.android.ad.a.c().toLowerCase();
            if (!lowerCase.contains("xiaomi") && !lowerCase.contains("blackshark")) {
                if (lowerCase.contains("huawei")) {
                    return (byte) 2;
                }
                if (lowerCase.contains("meizu")) {
                    return (byte) 3;
                }
                if (!lowerCase.contains("oppo") && !lowerCase.contains("realme") && !lowerCase.contains("oneplus")) {
                    if (lowerCase.contains("vivo")) {
                        return (byte) 5;
                    }
                    return lowerCase.contains("honor") ? (byte) 7 : (byte) 0;
                }
                return (byte) 4;
            }
            return (byte) 1;
        } catch (Throwable unused) {
            return (byte) 0;
        }
    }

    private void b(Context context, byte b4, String str) {
        Logger.ki("ThirdPushManager", "[uploadInService] regid:" + str + ",romtype:" + ((int) b4));
        a(context);
        if (!TextUtils.isEmpty(this.f3952h)) {
            a(context, b4, str, false);
            return;
        }
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
            if (jThirdPlatFormInterface.getRomType(context) == b4) {
                a(context, jThirdPlatFormInterface);
                a(context, b4, str, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, Bundle bundle) {
        try {
            if (cn.jpush.android.m.a.a()) {
                if (context == null) {
                    context = JPushConstants.mApplicationContext;
                }
                if (context == null) {
                    Logger.e("ThirdPushManager", "context was null");
                    return;
                }
                a(context);
                bundle.putString(f3945a, "1");
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "send_exception_stats", bundle);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean k(Context context) {
        Object newInstance;
        Logger.d("ThirdPushManager", "[loadThirdPush]");
        if (!JCoreHelper.isAuth(context)) {
            Logger.w("ThirdPushManager", "user don't auth, so return init");
            return false;
        }
        for (Map.Entry<String, Byte> entry : f3946c.entrySet()) {
            try {
                Class classInPlugin = entry.getValue().byteValue() == 6 ? ActionHelper.getInstance().getClassInPlugin(entry.getKey()) : null;
                if (classInPlugin == null) {
                    classInPlugin = Class.forName(entry.getKey(), false, context.getClassLoader());
                }
                if (classInPlugin != null && (newInstance = classInPlugin.newInstance()) != null && (newInstance instanceof JThirdPlatFormInterface)) {
                    ((JThirdPlatFormInterface) newInstance).init(context);
                    if (((JThirdPlatFormInterface) newInstance).isSupport(context)) {
                        this.f3949b.add((JThirdPlatFormInterface) newInstance);
                    } else {
                        Byte value = entry.getValue();
                        Sp.set(context, Key.ThirdPush_RegID(value.byteValue()).set(null));
                        Sp.set(context, Key.ThirdPush_RegUpload(value.byteValue()).set(Boolean.FALSE));
                    }
                }
            } catch (Throwable th) {
                Byte value2 = entry.getValue();
                Sp.set(context, Key.ThirdPush_RegID(value2.byteValue()).set(null));
                Sp.set(context, Key.ThirdPush_RegUpload(value2.byteValue()).set(Boolean.FALSE));
                if ((th instanceof RuntimeException) && th.getMessage().contains("Please check") && JCoreManager.getDebugMode()) {
                    if (cn.jpush.android.m.a.f4250c >= 238) {
                        JCoreHelper.futureExecutor(context, new f("ThirdPushManager#loadThirdPush") { // from class: cn.jpush.android.ac.e.1
                            @Override // cn.jpush.android.ad.f
                            public void a() {
                                throw new RuntimeException(th);
                            }
                        });
                    } else {
                        new Thread(new Runnable() { // from class: cn.jpush.android.ac.e.2
                            @Override // java.lang.Runnable
                            public void run() {
                                throw new RuntimeException(th);
                            }
                        }).start();
                    }
                }
                Logger.w("ThirdPushManager", "loadThirdPush error:" + th.getMessage());
            }
        }
        if (Build.VERSION.SDK_INT >= 26 && !this.f3949b.isEmpty()) {
            cn.jpush.android.x.a.a(context);
        }
        Logger.d("ThirdPushManager", "third init success, add " + this.f3949b.size() + " third push channel");
        return true;
    }

    private byte l(Context context) {
        try {
            byte b4 = b();
            if (b4 != 0) {
                if (b4 == 2) {
                    return (byte) 66;
                }
                return b4;
            }
            return (byte) 0;
        } catch (Throwable unused) {
            return (byte) 0;
        }
    }

    public synchronized void a(Context context) {
        if (this.f3951e) {
            return;
        }
        if (context == null) {
            return;
        }
        try {
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("loadByJPush", Context.class).invoke(null, context);
        } catch (Throwable unused) {
        }
        this.f3951e = k(context);
    }

    public void a(Context context, byte b4, String str) {
        if (cn.jpush.android.m.a.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            Logger.ii("ThirdPushManager", "uploadRegID regid:" + str);
            a(context);
            Bundle bundle = new Bundle();
            bundle.putString("token", str);
            bundle.putByte("platform", b4);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "third_push_upload_regid", bundle);
        }
    }

    public void a(Context context, int i4) {
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                jThirdPlatFormInterface.clearNotification(context, i4);
            }
        }
    }

    public void a(Context context, int i4, String str) {
        try {
            Logger.dd("ThirdPushManager", "[callBackTokenToUser] platform:" + i4 + ",token:" + str);
            Bundle bundle = new Bundle();
            bundle.putInt("platform", i4);
            bundle.putString("token", str);
            cn.jpush.android.x.b.a(context, 10000, 0, "", bundle);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "callBackTokenToUser failed:" + th.getMessage());
        }
    }

    public void a(Context context, Bundle bundle) {
        if (cn.jpush.android.m.a.a()) {
            if (!JCoreHelper.isAuth(context)) {
                Logger.e("ThirdPushManager", "register user don't auth, so return init");
                return;
            }
            a(context);
            if (cn.jpush.android.cache.a.d(StubApp.getOrigApplicationContext(context.getApplicationContext()))) {
                Logger.d("ThirdPushManager", "push has close");
                return;
            }
            if (bundle != null) {
                try {
                    Serializable serializable = bundle.getSerializable("config");
                    cn.jpush.android.data.a aVar = null;
                    if (serializable instanceof cn.jpush.android.data.a) {
                        aVar = (cn.jpush.android.data.a) serializable;
                    } else if (serializable instanceof JPushConfig) {
                        aVar = new cn.jpush.android.data.a((JPushConfig) serializable);
                    }
                    if (aVar != null) {
                        bundle.putString("MEIZU_APPID", aVar.getMzAppId());
                        bundle.putString("MEIZU_APPKEY", aVar.getMzAppKey());
                        bundle.putString("OPPO_APPKEY", aVar.getOppoAppKey());
                        bundle.putString("OPPO_APPID", aVar.getOppoAppId());
                        bundle.putString("OPPO_APPSECRET", aVar.getOppoAppSecret());
                        bundle.putString("XIAOMI_APPID", aVar.getXmAppId());
                        bundle.putString("XIAOMI_APPKEY", aVar.getXmAppKey());
                        bundle.putString("VIVO_APPKEY", aVar.c());
                        bundle.putString("VIVO_APPID", aVar.d());
                        bundle.putString("HW_APPID", aVar.a());
                        bundle.putString("HONOR_APPID", aVar.b());
                    }
                } catch (Throwable unused) {
                }
            }
            this.f3950d = bundle;
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                try {
                    if (TextUtils.equals(cn.jpush.android.ad.a.c(context), context.getPackageName())) {
                        jThirdPlatFormInterface.register(context, bundle);
                    }
                    if (cn.jpush.android.cache.a.s(context) == 2) {
                        a(context, jThirdPlatFormInterface, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
                    }
                } catch (Throwable th) {
                    Logger.ww("ThirdPushManager", "Third push register failed#", th);
                }
            }
        }
    }

    public void a(Context context, String str) {
        final String d4 = cn.jpush.android.ad.a.d(str);
        final String g4 = cn.jpush.android.cache.a.g(context, d4);
        if (!TextUtils.isEmpty(g4)) {
            cn.jpush.android.cache.a.f(context, 1);
            Logger.d("ThirdPushManager", "use cache config register");
            a(context, g4, cn.jpush.android.cache.a.h(context, d4), cn.jpush.android.cache.a.i(context, d4), cn.jpush.android.cache.a.j(context, d4));
        }
        b.a(context, str, new cn.jpush.android.ac.a() { // from class: cn.jpush.android.ac.e.3
            @Override // cn.jpush.android.ac.a
            public void a() {
                Logger.w("ThirdPushManager", "plugin config request failed");
            }

            @Override // cn.jpush.android.ac.a
            public void a(Context context2, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    Logger.w("ThirdPushManager", "plugin response config is empty");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("j_key");
                    String optString2 = jSONObject.optString("m_key");
                    String optString3 = jSONObject.optString("m_id");
                    String optString4 = jSONObject.optString("m_scrt");
                    cn.jpush.android.cache.a.b(context2, d4, optString);
                    cn.jpush.android.cache.a.c(context2, d4, optString2);
                    cn.jpush.android.cache.a.d(context2, d4, optString3);
                    cn.jpush.android.cache.a.e(context2, d4, optString4);
                    if (TextUtils.isEmpty(g4)) {
                        Logger.d("ThirdPushManager", "start register sdk, use appKey: " + optString);
                        cn.jpush.android.cache.a.f(context2, 2);
                        e.this.a(context2, optString, optString2, optString3, optString4);
                    } else if (!TextUtils.equals(optString, g4)) {
                        Logger.ww("ThirdPushManager", "push appKey change, old: " + g4 + ", new: " + optString);
                    }
                } catch (Throwable th) {
                    Logger.w("ThirdPushManager", "parsing plugin config failed, " + th.getMessage());
                }
            }
        });
    }

    public void a(final Context context, final String str, final Bundle bundle) {
        try {
            Logger.dd("ThirdPushManager", "doAction,action:" + str + ",bundle:" + bundle + ",enable:" + cn.jpush.android.m.a.a());
            if (cn.jpush.android.m.a.a()) {
                JCoreHelper.majorExecutor(context, "ThirdPushManager", new f("ThirdPushManager#doAction") { // from class: cn.jpush.android.ac.e.4
                    @Override // cn.jpush.android.ad.f
                    public void a() {
                        Bundle bundle2;
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED)) {
                                    a a4 = e.this.a(bundle);
                                    if (a4 != null) {
                                        d.a(context, a4.f3966c, a4.f3964a, a4.f3965b, a4.f3967d, 1);
                                    }
                                } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED)) {
                                    a a5 = e.this.a(bundle);
                                    if (a5 != null) {
                                        d.a(context, a5.f3966c, a5.f3964a, a5.f3965b, a5.f3967d, 0);
                                    }
                                } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_UN_SHOW)) {
                                    a a6 = e.this.a(bundle);
                                    if (a6 != null) {
                                        d.a(context, a6.f3966c, a6.f3964a, a6.f3965b, a6.f3967d, 2);
                                    }
                                } else if (!str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW)) {
                                    if (str.equals(JThirdPlatFormInterface.ACTION_REGISTER_TOKEN)) {
                                        Bundle bundle3 = bundle;
                                        if (bundle3 != null) {
                                            e.this.a(context, bundle.getByte("platform", (byte) -1).byteValue(), bundle3.getString("token"));
                                        }
                                    } else if (str.equals(JThirdPlatFormInterface.ACTION_SEND_EXCEPTION) && (bundle2 = bundle) != null) {
                                        e.this.d(context, bundle2);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            Logger.ww("ThirdPushManager", "doAction failed internal:" + th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "doAction failed:" + th.getMessage());
        }
    }

    public byte b(Context context, String str) {
        if (cn.jpush.android.m.a.a()) {
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                byte romType = jThirdPlatFormInterface.getRomType(context);
                if (romType == 1) {
                    int nofiticationID = JThirdPlatFormInterface.getNofiticationID(str, romType);
                    Logger.d("ThirdPushManager", "clearThirdNotificaiton msgid:" + str + ",  romType:" + ((int) romType) + " , notificationId:" + nofiticationID);
                    jThirdPlatFormInterface.clearNotification(context, nofiticationID);
                    return romType;
                }
            }
            return (byte) -1;
        }
        return (byte) -1;
    }

    public void b(Context context) {
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                jThirdPlatFormInterface.resumePush(context);
            }
        }
    }

    public void b(Context context, Bundle bundle) {
        if (context == null) {
            context = JPushConstants.mApplicationContext;
        }
        if (context == null) {
            Logger.e("ThirdPushManager", "context was null");
        } else if (bundle == null) {
            Logger.ww("ThirdPushManager", "bundle is null");
        } else {
            b(context, bundle.getByte("platform", (byte) 0).byteValue(), bundle.getString("token"));
        }
    }

    public void c(Context context) {
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                jThirdPlatFormInterface.clearAllNotification(context);
            }
        }
    }

    public void c(Context context, Bundle bundle) {
        if (!cn.jpush.android.m.a.a()) {
            Logger.dd("ThirdPushManager", "[refreshToken] third disabled");
            return;
        }
        a(context);
        Logger.dd("ThirdPushManager", "[refreshToken] , platFormInterfaceList size: " + this.f3949b.size());
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
            byte romType = jThirdPlatFormInterface.getRomType(context);
            String token = jThirdPlatFormInterface.getToken(context);
            if (!TextUtils.isEmpty(token)) {
                a(context, romType, token);
            } else if (!JCoreHelper.isAuth(context)) {
                Logger.w("ThirdPushManager", "user don't auth, so return init");
                return;
            } else {
                jThirdPlatFormInterface.register(context, this.f3950d);
            }
        }
    }

    public void c(Context context, String str) {
        Logger.d("ThirdPushManager", "uploadThirdTokenFromUser\uff1a" + str);
        if (TextUtils.isEmpty(str)) {
            h(context);
            this.f3952h = null;
            return;
        }
        byte b4 = b();
        Logger.d("ThirdPushManager", "uploadThirdTokenFromUser platform\uff1a" + ((int) b4));
        if (b4 != 0) {
            a(context, b4, str);
            this.f3952h = str;
            Logger.d("ThirdPushManager", "uploadThirdTokenFromUser third_token_from_user\uff1a" + this.f3952h);
        }
    }

    public void d(Context context) {
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                jThirdPlatFormInterface.stopPush(context);
            }
        }
    }

    public byte e(Context context) {
        int i4;
        byte b4 = 0;
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                byte romType = jThirdPlatFormInterface.getRomType(context);
                b4 = (byte) (b4 | romType);
                byte b5 = romType;
                String str = (String) Sp.get(context, Key.ThirdPush_RegID(b5));
                boolean booleanValue = ((Boolean) Sp.get(context, Key.ThirdPush_RegUpload(b5))).booleanValue();
                if (jThirdPlatFormInterface.getRomType(context) == 8) {
                    b4 = (byte) (b4 | 8);
                    if (booleanValue && !TextUtils.isEmpty(str)) {
                        i4 = b4 | 32;
                        b4 = (byte) i4;
                    }
                } else {
                    if (jThirdPlatFormInterface.getRomType(context) == 2) {
                        b4 = (byte) (b4 | 64);
                    }
                    if (!booleanValue || TextUtils.isEmpty(str)) {
                        i4 = b4 | 128;
                        b4 = (byte) i4;
                    }
                }
            }
            Logger.d("ThirdPushManager", "getRomType,romType:" + ((int) b4));
            if (b4 == 0) {
                byte l4 = l(context);
                Logger.d("ThirdPushManager", "getRomTypeByMANUFACTURER,romType:" + ((int) l4));
                return l4;
            }
            return b4;
        }
        return (byte) 0;
    }

    public int f(Context context) {
        byte b4 = 0;
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                byte romType = jThirdPlatFormInterface.getRomType(context);
                if (romType != 8 && romType != 6) {
                    b4 = (byte) (b4 | romType);
                }
            }
            Logger.d("ThirdPushManager", "getManufactureRomType,romType:" + ((int) b4));
            if (b4 == 0) {
                byte b5 = b();
                Logger.d("ThirdPushManager", "getRomTypeByMANUFACTURER,romType:" + ((int) b5));
                return b5;
            }
            return b4;
        }
        return 0;
    }

    public String g(Context context) {
        if (cn.jpush.android.m.a.a()) {
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                if (jThirdPlatFormInterface.getRomType(context) != 8) {
                    return (String) Sp.get(context, Key.ThirdPush_RegID(jThirdPlatFormInterface.getRomType(context)));
                }
            }
            return this.f3952h;
        }
        return null;
    }

    public void h(Context context) {
        try {
            List<JThirdPlatFormInterface> list = this.f3949b;
            if (list != null && !list.isEmpty()) {
                for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
                    a(context, jThirdPlatFormInterface.getRomType(context), null, true);
                }
                return;
            }
            Map<String, Byte> map = f3946c;
            if (map != null) {
                for (Byte b4 : map.values()) {
                    Sp.set(context, Key.ThirdPush_RegUpload(b4.byteValue()).set(Boolean.FALSE));
                    Sp.set(context, Key.ThirdPush_RegID(b4.byteValue()).set(null));
                }
            }
            a(context, b(), null, true);
        } catch (Throwable unused) {
        }
    }

    public void i(Context context) {
        if (cn.jpush.android.m.a.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            a(context);
            Logger.ii("ThirdPushManager", "uploadRegIdAfterLogin");
            a(context, (JThirdPlatFormInterface) null, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
            if (TextUtils.isEmpty(this.f3952h)) {
                return;
            }
            c(context, this.f3952h);
        }
    }

    public void j(Context context) {
        Logger.dd("ThirdPushManager", "reRegisterInPushReceiver");
        a(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3949b) {
            a(context, jThirdPlatFormInterface, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
        }
    }
}
