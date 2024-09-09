package cn.jpush.android.ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    private static String f3987c;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f3988d = {84, 85, 108, 72, 90, 107, 49, 66, 77, 69, 100, 68, 85, 51, 70, 72, 85, 48, 108, 105, 77, 48, 82, 82, 82, 85, 74, 66, 85, 86, 86, 66, 81, 84, 82, 72, 84, 107, 70, 69, 81, 48, 74, 112, 85, 85, 116, 67, 90, 49, 70, 68, 99, 108, 108, 108, 81, 122, 78, 81, 90, 69, 120, 122, 89, 88, 90, 77, 90, 106, 104, 69, 90, 84, 108, 71, 89, 122, 81, 51, 78, 50, 104, 78, 83, 119, 112, 110, 100, 108, 90, 68, 78, 72, 104, 85, 99, 50, 53, 89, 87, 71, 86, 78, 99, 85, 104, 111, 87, 85, 120, 68, 98, 88, 108, 77, 82, 72, 85, 51, 81, 122, 90, 82, 78, 70, 107, 120, 77, 71, 82, 49, 100, 106, 100, 76, 98, 108, 112, 105, 99, 105, 116, 110, 98, 51, 100, 90, 82, 87, 81, 53, 85, 122, 82, 78, 77, 48, 108, 72, 98, 122, 100, 110, 90, 106, 66, 118, 99, 85, 112, 117, 67, 107, 120, 77, 100, 107, 90, 54, 83, 69, 116, 54, 90, 70, 74, 106, 99, 87, 115, 49, 99, 88, 112, 117, 89, 87, 57, 118, 90, 50, 120, 68, 81, 122, 65, 48, 82, 109, 104, 74, 97, 108, 74, 80, 87, 72, 104, 50, 81, 108, 90, 54, 79, 71, 100, 66, 98, 51, 90, 104, 90, 107, 53, 90, 99, 109, 120, 76, 78, 109, 104, 105, 90, 85, 82, 79, 84, 107, 49, 78, 84, 50, 57, 73, 83, 108, 65, 75, 82, 50, 100, 112, 85, 71, 82, 87, 97, 50, 70, 109, 89, 108, 82, 107, 81, 108, 78, 89, 97, 110, 112, 51, 83, 85, 82, 66, 85, 85, 70, 67};

    /* renamed from: e  reason: collision with root package name */
    private static final String f3989e = d.b(new byte[]{68, 66, 113, 15, 87, 103, 120, 116, 31, 112, 82, 75, 69, 32, 96, 65, 125, 108, Byte.MAX_VALUE, Byte.MAX_VALUE, 87});
    private int A;

    /* renamed from: a  reason: collision with root package name */
    private Context f3990a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3991b;

    /* renamed from: f  reason: collision with root package name */
    private final String f3992f;

    /* renamed from: g  reason: collision with root package name */
    private final String f3993g;

    /* renamed from: h  reason: collision with root package name */
    private final String f3994h;

    /* renamed from: i  reason: collision with root package name */
    private final String f3995i;

    /* renamed from: j  reason: collision with root package name */
    private final String f3996j;

    /* renamed from: k  reason: collision with root package name */
    private final String f3997k;

    /* renamed from: l  reason: collision with root package name */
    private final String f3998l;

    /* renamed from: m  reason: collision with root package name */
    private final String f3999m;

    /* renamed from: n  reason: collision with root package name */
    private final String f4000n;

    /* renamed from: o  reason: collision with root package name */
    private final String f4001o;

    /* renamed from: p  reason: collision with root package name */
    private final String f4002p;

    /* renamed from: q  reason: collision with root package name */
    private final String f4003q;

    /* renamed from: r  reason: collision with root package name */
    private final String f4004r;

    /* renamed from: s  reason: collision with root package name */
    private final String f4005s;

    /* renamed from: t  reason: collision with root package name */
    private final String f4006t;

    /* renamed from: u  reason: collision with root package name */
    private final int f4007u;

    /* renamed from: v  reason: collision with root package name */
    private final int f4008v;

    /* renamed from: w  reason: collision with root package name */
    private final int f4009w;

    /* renamed from: x  reason: collision with root package name */
    private final int f4010x;

    /* renamed from: y  reason: collision with root package name */
    private final int f4011y;

    /* renamed from: z  reason: collision with root package name */
    private final int f4012z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final g f4013a = new g();
    }

    private g() {
        this.f3991b = "JPUSH_JUMP";
        this.f3992f = JThirdPlatFormInterface.KEY_MSG_ID;
        this.f3993g = JThirdPlatFormInterface.KEY_ROM_TYPE;
        this.f3994h = "n_title";
        this.f3995i = "n_content";
        this.f3996j = "m_content";
        this.f3997k = "n_extras";
        this.f3998l = "n_intent";
        this.f3999m = "n_url";
        this.f4000n = "n_ssl";
        this.f4001o = "n_fail_handle_type";
        this.f4002p = "n_fail_handle_url";
        this.f4003q = "n_package_name";
        this.f4004r = "notification_id";
        this.f4005s = "_j_data_";
        this.f4006t = "n_type";
        this.f4007u = 1;
        this.f4008v = 2;
        this.f4009w = 3;
        this.f4010x = 1;
        this.f4011y = 2;
        this.f4012z = 3;
        this.A = 0;
    }

    private Intent a(String str) {
        return cn.jpush.android.ad.a.a(str, Build.VERSION.SDK_INT >= 22 ? 4 : 0);
    }

    public static g a() {
        return a.f4013a;
    }

    private String a(byte b4) {
        switch (b4) {
            case 1:
                return "xiaomi";
            case 2:
                return "huawei";
            case 3:
                return "meizu";
            case 4:
                return "oppo";
            case 5:
                return "vivo";
            case 6:
                return "asus";
            case 7:
                return "HONOR";
            case 8:
                return "fcm";
            default:
                return "jpush";
        }
    }

    private String a(Intent intent) {
        String str;
        if (intent.getData() != null) {
            str = intent.getData().toString();
            Logger.d("JumpManager", "\u534e\u4e3a\uff1a" + str);
            this.A = 1;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str) && intent.getExtras() != null) {
            str = intent.getExtras().getString("JMessageExtra");
            Logger.d("JumpManager", "fcm\u3001oppo\u3001vivo\u3001\u534e\u7855\u3001\u5c0f\u7c73\u3001HONOR\uff1a" + str);
            this.A = 2;
        }
        if (!TextUtils.isEmpty(str) || intent.getExtras() == null) {
            return str;
        }
        String string = intent.getExtras().getString("asus_data");
        Logger.d("JumpManager", "asus_data\uff1a" + string);
        this.A = 3;
        return string;
    }

    private void a(int i4, String str, Intent intent) {
        if (i4 == 1) {
            intent.setData(Uri.parse(str));
        } else if (i4 != 2) {
            if (i4 != 3) {
                return;
            }
            intent.putExtra("asus_data", str);
        }
        intent.putExtra("JMessageExtra", str);
    }

    private void a(Context context, Intent intent, int i4, String str) {
        intent.setFlags(268435456);
        if (i4 == 1) {
            i4 = 2;
        }
        if (i4 != -1 && !TextUtils.isEmpty(str)) {
            a(i4, str, intent);
        }
        b(context, intent);
        context.startActivity(intent);
    }

    private void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            String optString2 = jSONObject.optString("n_title");
            String optString3 = jSONObject.optString("n_content");
            String optString4 = jSONObject.optString("n_extras");
            JSONArray optJSONArray = jSONObject.optJSONArray("n_target_event");
            cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
            dVar.f4144u = optString2;
            dVar.f4127d = optString;
            dVar.f4147x = optString3;
            dVar.F = optString4;
            dVar.f4145v = optJSONArray;
            cn.jpush.android.k.a.a(context, dVar);
        } catch (Throwable unused) {
        }
    }

    private void a(Context context, JSONObject jSONObject, byte b4) {
        Log.d("JumpManager", "whichPushSDK=" + ((int) b4) + " jsonObject=" + jSONObject);
        Bundle bundle = new Bundle();
        bundle.putByte("platform", b4);
        bundle.putString("data", jSONObject.toString());
        JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED, bundle);
    }

    private boolean a(int i4, int i5, String str, String str2, String str3) {
        if (i4 == 1) {
            return str.contains("android.intent.action.MAIN") ? a(this.f3990a, i5, str2) : a(this.f3990a, i5, str, str2);
        } else if (i4 != 2) {
            if (i4 != 3) {
                return false;
            }
            return a(this.f3990a, i5, str2);
        } else {
            return a(this.f3990a, i5, str, str3, str2);
        }
    }

    private boolean a(Context context, int i4, String str) {
        Intent f4 = cn.jpush.android.ad.a.f(context);
        if (f4 != null) {
            try {
                a(i4, str, f4);
                context.startActivity(f4);
                return true;
            } catch (Throwable th) {
                Logger.ww("JumpManager", "start main intent error:" + th.getMessage());
                return false;
            }
        }
        return false;
    }

    private boolean a(Context context, int i4, String str, String str2) {
        try {
            Intent a4 = a(str);
            a4.setFlags(268435456);
            a4.setPackage(this.f3990a.getPackageName());
            a(i4, str2, a4);
            context.startActivity(a4);
            return true;
        } catch (Throwable th) {
            Logger.ww("JumpManager", "jumpIntent Throwable:" + th.getMessage());
            return false;
        }
    }

    private boolean a(Context context, String str, String str2, int i4) {
        b(context);
        Logger.d("JumpManager", "checkConfig url=" + str + " ssl=" + str2);
        StringBuilder sb = new StringBuilder();
        sb.append("checkConfig user jump Config=");
        sb.append(f3987c);
        Logger.d("JumpManager", sb.toString());
        try {
            String d4 = cn.jpush.android.ad.a.d(str);
            Logger.d("JumpManager", "checkConfig url hash=" + d4);
            String c4 = c(str2);
            Logger.d("JumpManager", "checkConfig decodeData=" + c4);
            if (TextUtils.isEmpty(c4) || TextUtils.isEmpty(d4) || !c4.equalsIgnoreCase(d4)) {
                Logger.dd("JumpManager", "checkConfig fail, so return");
                return false;
            }
            return a(new String(Base64.decode(str.getBytes(), 2)), i4);
        } catch (Throwable th) {
            Logger.dd("JumpManager", "checkConfig Throwable=" + th);
            return false;
        }
    }

    private boolean a(cn.jpush.android.d.d dVar, Intent intent, boolean z3) {
        int i4;
        try {
            String str = dVar.f4132i;
            Logger.d("JumpManager", "handleOriginalMessage msg content is= " + String.valueOf(str));
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("n_intent");
            Logger.d("JumpManager", "handleOriginalMessage n_intent=" + optJSONObject2);
            if (optJSONObject2 == null && !z3) {
                cn.jpush.android.x.b.a(this.f3990a, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, intent);
                Logger.d("JumpManager", "handleOriginalMessage n_intent is null, sendToUserReceiver");
                return false;
            }
            int optInt = optJSONObject2.optInt("n_type");
            String optString = optJSONObject2.optString("n_url");
            Logger.d("JumpManager", "handleOriginalMessage url=" + optString);
            Logger.d("JumpManager", "handleOriginalMessage jumpType=" + optInt);
            if (!a(optString, optInt)) {
                Logger.e("JumpManager", "illegal jump,so return");
                cn.jpush.android.helper.c.a(dVar.f4127d, 1107L, this.f3990a);
                return false;
            }
            String optString2 = optJSONObject2.optString("n_package_name", "");
            if (optInt == 0 && !TextUtils.isEmpty(optString)) {
                optInt = optString.startsWith("intent") ? 1 : 2;
            }
            if (optInt != 3 && TextUtils.isEmpty(optString) && !z3) {
                cn.jpush.android.x.b.a(this.f3990a, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, intent);
                Logger.d("JumpManager", "handleOriginalMessage url is null, sendToUserReceiver");
                return false;
            }
            if (cn.jpush.android.cache.a.p(this.f3990a) && !z3) {
                cn.jpush.android.x.b.a(this.f3990a, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, intent);
                Logger.d("JumpManager", "notification callback enable, sendToUserReceiver");
            }
            Logger.d("JumpManager", "handleOriginalMessage targetPkgName=" + optString2);
            optJSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, dVar.f4127d);
            optJSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, "0");
            optJSONObject.put("notification_id", cn.jpush.android.x.b.a(dVar));
            optJSONObject.put("_j_data_", jSONObject.optString("_j_data_"));
            optJSONObject.remove("n_intent");
            String jSONObject2 = optJSONObject.toString();
            Logger.d("JumpManager", "handleOriginalMessage extraData=" + jSONObject2);
            boolean a4 = a(optInt, 2, optString, jSONObject2, optString2);
            if (a4 || !z3) {
                StringBuilder sb = new StringBuilder();
                sb.append("handleOriginalMessage jump ");
                sb.append(a4 ? "success" : "fail");
                Logger.d("JumpManager", sb.toString());
                return a4;
            }
            int optInt2 = optJSONObject2.optInt("n_fail_handle_type", 3);
            String optString3 = optJSONObject2.optString("n_fail_handle_url", "");
            if (optInt2 == 0) {
                i4 = 3;
            } else if (optInt2 != 1) {
                i4 = 2;
                if (optInt2 != 2) {
                    i4 = optInt2;
                }
            } else {
                i4 = 2;
            }
            Logger.d("JumpManager", "handleOriginalMessage inapp jump  failed use failedJumpUrl= " + optString3 + " failedJumpType=" + i4);
            return a(i4, 2, optString3, jSONObject2, optString2);
        } catch (Throwable th) {
            Logger.d("JumpManager", "handleOriginalMessage throwable " + th);
            return false;
        }
    }

    private boolean a(String str, int i4) {
        if (i4 == 2) {
            return true;
        }
        if (f3987c == null) {
            Logger.dd("JumpManager", "jumpConfig is null goto get config");
            c(this.f3990a);
        }
        String str2 = f3987c;
        if (str2 == null) {
            Logger.dd("JumpManager", "jumpConfig is null,return true");
            return true;
        }
        try {
            String[] split = str2.split(TTPathConst.sSeparator);
            Logger.d("JumpManager", "jumpConfig =" + Arrays.toString(split));
            String b4 = b(str);
            Logger.d("JumpManager", " origin className=" + b4);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(b4) && str3.equals(b4)) {
                    Logger.d("JumpManager", " match user config className");
                    return true;
                }
            }
        } catch (Throwable th) {
            Logger.dd("JumpManager", "jumpConfig Throwable=" + th);
        }
        return false;
    }

    private String b() {
        return new String(Base64.decode(f3988d, 2));
    }

    private String b(String str) {
        try {
            Intent a4 = a(str);
            a4.setPackage(this.f3990a.getPackageName());
            return this.f3990a.getPackageManager().resolveActivity(a4, 0).activityInfo.name;
        } catch (Throwable unused) {
            return "";
        }
    }

    private void b(Context context) {
        if (this.f3990a == null) {
            this.f3990a = context;
        }
    }

    private void b(Context context, Intent intent) {
        if ("com.mt.mtxx.mtxx".equals(context.getPackageName())) {
            intent.putExtra("infoProvider", "JPush");
        }
    }

    private boolean b(Context context, int i4, String str, String str2) {
        String str3;
        Intent a4;
        if (TextUtils.isEmpty(str)) {
            Logger.d("JumpManager", "jumpWebUrl link uri is empty");
            return false;
        }
        Logger.d("JumpManager", "jumpWebUrl:" + str);
        try {
            if (cn.jpush.android.ad.a.c(context, "com.android.browser")) {
                Logger.d("JumpManager", "start android default browser ");
                a4 = new Intent();
                a4.setAction("android.intent.action.VIEW");
                a4.setData(Uri.parse(str));
                a4.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            } else {
                Logger.d("JumpManager", "start browser by android ");
                a4 = cn.jpush.android.ad.a.a(str, 0);
            }
            a(context, a4, i4, str2);
            return true;
        } catch (ActivityNotFoundException e4) {
            try {
                a(context, cn.jpush.android.ad.a.a(str, 0), i4, str2);
                return true;
            } catch (Throwable unused) {
                str3 = "start ActivityNotFoundException  fail=" + e4;
                Logger.d("JumpManager", str3);
                return false;
            }
        } catch (Throwable th) {
            str3 = "start uri fail=" + th;
            Logger.d("JumpManager", str3);
            return false;
        }
    }

    private boolean b(Context context, int i4, String str, String str2, String str3) {
        try {
            Intent a4 = a(str);
            a4.setFlags(268435456);
            if (!TextUtils.isEmpty(str2)) {
                a4.setPackage(str2);
            }
            if (context.getPackageManager().resolveActivity(a4, 0) == null) {
                Logger.d("JumpManager", "deeplink is wrong, " + str);
                return false;
            }
            if (i4 == 1) {
                i4 = 2;
            }
            if (i4 != -1 && !TextUtils.isEmpty(str3)) {
                a(i4, str3, a4);
            }
            b(context, a4);
            context.startActivity(a4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return l.b(str, b(), f3989e);
        } catch (Throwable th) {
            Logger.dd("JumpManager", "checkJumpConfig rsa=" + th);
            return "";
        }
    }

    private void c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle != null) {
                f3987c = bundle.getString("JPUSH_JUMP");
                Logger.d("JumpManager", "getJumpConfig config =" + f3987c);
            }
        } catch (Throwable th) {
            Logger.d("JumpManager", "getJumpConfig =" + th.getMessage());
        }
    }

    public void a(Context context) {
        Logger.d("JumpManager", " init config");
        this.f3990a = context;
        c(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v10, types: [boolean] */
    public void a(Context context, Intent intent) {
        String str;
        b(context);
        Logger.d("JumpManager", "third user click notification");
        try {
            String a4 = a(intent);
            Logger.d("JumpManager", "handleThirdNotificationClick msg content is= " + String.valueOf(a4));
            if (TextUtils.isEmpty(a4)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a4);
            if (jSONObject.has("o-l-l")) {
                Bundle bundle = new Bundle();
                bundle.putString("aes", jSONObject.optString("aes"));
                JCoreHelper.openLog(context, bundle);
                return;
            }
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            byte optInt = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
            Logger.d("JumpManager", "\u901a\u9053\uff1a" + a(optInt));
            boolean has = jSONObject.has(JThirdPlatFormInterface.KEY_MSG_ID);
            boolean has2 = jSONObject.has(JThirdPlatFormInterface.KEY_ROM_TYPE);
            str = jSONObject.has("n_title");
            boolean has3 = jSONObject.has("n_content");
            Logger.d("JumpManager", "hasMsgid:" + has);
            Logger.d("JumpManager", "hasWhich:" + has2);
            Logger.d("JumpManager", "hasTitle:" + ((boolean) str));
            Logger.d("JumpManager", "hasContent:" + has3);
            try {
                if (has && has2 && str != 0 && has3) {
                    a(context, jSONObject);
                    cn.jpush.android.helper.c.a(context, optString, optInt, a4);
                    JSONObject optJSONObject = jSONObject.optJSONObject("n_intent");
                    jSONObject.remove("n_intent");
                    if (optJSONObject == null) {
                        Logger.d("JumpManager", "handleThirdNotificationClick n_intent is null,sendToUserReceiver");
                        a(context, jSONObject, optInt);
                        return;
                    }
                    String optString2 = optJSONObject.optString("n_url", "");
                    String optString3 = optJSONObject.optString("n_ssl", "");
                    int optInt2 = optJSONObject.optInt("n_type", 1);
                    Logger.d("JumpManager", "n_url:" + optString2);
                    Logger.d("JumpManager", "n_ssl:" + optString3);
                    Logger.d("JumpManager", "n_type:" + optInt2);
                    if (optInt2 != 3 && TextUtils.isEmpty(optString2)) {
                        Logger.d("JumpManager", "handleThirdNotificationClick url is null,sendToUserReceiver");
                        a(context, jSONObject, optInt);
                        return;
                    }
                    if (cn.jpush.android.cache.a.p(this.f3990a)) {
                        Logger.d("JumpManager", "notification callback enable, sendToUserReceiver");
                        a(context, jSONObject, optInt);
                    }
                    String str2 = new String(Base64.decode(optString2, 0));
                    if (!TextUtils.isEmpty(optString2) && !a(context, optString2, optString3, optInt2)) {
                        Logger.e("JumpManager", "illegal jump,so return url_intent=" + str2);
                        cn.jpush.android.helper.c.a(optString, "", optInt, 1107L, context, a4, null);
                        return;
                    }
                    Logger.d("JumpManager", "url_intent:" + str2);
                    String jSONObject2 = jSONObject.toString();
                    Logger.d("JumpManager", "extraData:" + jSONObject2);
                    a(optInt2, this.A, str2, jSONObject2, "");
                    return;
                }
                Logger.d("JumpManager", "\u53c2\u6570\u7f3a\u5931");
            } catch (Throwable th) {
                th = th;
                Logger.w(str, "handleThirdNotificationClick  error : " + th.getMessage());
            }
        } catch (Throwable th2) {
            th = th2;
            str = "JumpManager";
        }
    }

    public void a(Context context, cn.jpush.android.d.d dVar) {
        b(context);
        try {
            Logger.d("JumpManager", "Notification to InApp click notification");
            cn.jpush.android.helper.c.a(dVar.f4127d, 1601L, context);
            cn.jpush.android.k.a.a(context, dVar);
            cn.jpush.android.x.b.a(this.f3990a, JPushInterface.ACTION_IN_APP_MSG_CLICK, dVar, (Intent) null, (String) null);
            cn.jpush.android.helper.c.a(dVar.f4127d, a(dVar, (Intent) null, true) ? 1605L : 1606L, context);
        } catch (Throwable th) {
            Logger.w("JumpManager", "handleNotificationToInAppClick  error : " + th.getMessage());
        }
    }

    public void a(Context context, cn.jpush.android.d.d dVar, Intent intent) {
        b(context);
        try {
            Logger.d("JumpManager", "JG user click notification");
            if (dVar.f4136m != 1) {
                byte b4 = dVar.ah;
                if (b4 == 0) {
                    cn.jpush.android.helper.c.a(dVar.f4127d, 1000L, context);
                } else {
                    cn.jpush.android.helper.c.a(context, dVar.f4127d, b4, (String) null);
                }
            }
            cn.jpush.android.k.a.a(context, dVar);
            a(dVar, intent, false);
        } catch (Throwable th) {
            Logger.w("JumpManager", "handleNotificationClick  error : " + th.getMessage());
        }
    }

    public boolean a(Context context, int i4, String str, String str2, String str3) {
        boolean b4;
        if (TextUtils.isEmpty(str)) {
            Logger.d("JumpManager", "jumpDeepLink link uri is empty");
            return false;
        }
        try {
            Logger.d("JumpManager", "jumpDeepLink url:" + str);
            if (str.startsWith("http")) {
                b4 = b(context, i4, str, str3);
            } else {
                Logger.d("JumpManager", "jumpDeepLink intent:" + str);
                b4 = b(context, i4, str, str2, str3);
            }
            return b4;
        } catch (Throwable th) {
            Logger.d("JumpManager", "jumpDeepLink start fail uri error:" + th.getMessage());
            return false;
        }
    }
}
