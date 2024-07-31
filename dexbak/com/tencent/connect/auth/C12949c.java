package com.tencent.connect.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.stub.StubApp;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.p561a.C12926a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13050b;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.util.Map;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.auth.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12949c {

    /* renamed from: a */
    private AuthAgent f37067a;

    /* renamed from: b */
    private QQToken f37068b;

    private C12949c(String str, Context context) {
        SLog.m15127i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f37068b = new QQToken(str);
        this.f37067a = new AuthAgent(this.f37068b);
        C12926a.m15466c(context, this.f37068b);
        m15384a(context, Constants.SDK_VERSION);
        SLog.m15127i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    /* renamed from: a */
    public static void m15384a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("bcb3903995", str);
        edit.apply();
    }

    /* renamed from: b */
    public int m15377b(Activity activity, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.QQAuth", "reAuth()");
        return this.f37067a.m15460a(activity, str, iUiListener, true, null, false);
    }

    /* renamed from: c */
    public boolean m15375c() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSessionValid(), result = ");
        sb.append(this.f37068b.isSessionValid() ? "true" : "false");
        SLog.m15127i("openSDK_LOG.QQAuth", sb.toString());
        return this.f37068b.isSessionValid();
    }

    /* renamed from: b */
    public QQToken m15378b() {
        return this.f37068b;
    }

    /* renamed from: b */
    public void m15376b(Context context, String str) {
        SLog.m15127i("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.f37068b.setOpenId(str);
        C12926a.m15465d(context, this.f37068b);
        SLog.m15127i("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    /* renamed from: a */
    public static C12949c m15380a(String str, Context context) {
        C13061g.m15026a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        SLog.m15127i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        C12949c c12949c = new C12949c(str, context);
        SLog.m15127i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        return c12949c;
    }

    /* renamed from: a */
    public int m15388a(Activity activity, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.QQAuth", "login()");
        return m15387a(activity, str, iUiListener, "");
    }

    /* renamed from: a */
    public int m15386a(Activity activity, String str, IUiListener iUiListener, boolean z) {
        SLog.m15127i("openSDK_LOG.QQAuth", "login()");
        return m15391a(activity, null, str, iUiListener, "", z);
    }

    /* renamed from: a */
    public int m15389a(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.m15127i("openSDK_LOG.QQAuth", "login--params");
        return m15390a(activity, (Fragment) null, C13071m.m14950a(map, Constants.KEY_SCOPE, "all"), iUiListener, "", C13071m.m14949a(map, Constants.KEY_QRCODE, false), map);
    }

    /* renamed from: a */
    public int m15387a(Activity activity, String str, IUiListener iUiListener, String str2) {
        SLog.m15127i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return m15392a(activity, (Fragment) null, str, iUiListener, str2);
    }

    /* renamed from: a */
    public int m15383a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        FragmentActivity activity = fragment.getActivity();
        SLog.m15127i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return m15392a(activity, fragment, str, iUiListener, str2);
    }

    /* renamed from: a */
    public int m15382a(Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        FragmentActivity activity = fragment.getActivity();
        SLog.m15127i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return m15391a(activity, fragment, str, iUiListener, str2, z);
    }

    /* renamed from: a */
    private int m15392a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        return m15391a(activity, fragment, str, iUiListener, str2, false);
    }

    /* renamed from: a */
    private int m15391a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        return m15390a(activity, fragment, str, iUiListener, str2, z, (Map<String, Object>) null);
    }

    /* renamed from: a */
    private int m15390a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z, Map<String, Object> map) {
        try {
            String m15000a = C13066k.m15000a(activity);
            if (m15000a != null) {
                String m15051a = C13050b.m15051a(new File(m15000a));
                if (!TextUtils.isEmpty(m15051a)) {
                    SLog.m15123v("openSDK_LOG.QQAuth", "-->login channelId: " + m15051a);
                    return m15385a(activity, str, iUiListener, z, m15051a, m15051a, "");
                }
            }
        } catch (Throwable th) {
            SLog.m15128e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
        }
        SLog.m15131d("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.f37067a.doLogin(activity, str, iUiListener, false, fragment, z, map);
    }

    @Deprecated
    /* renamed from: a */
    public int m15385a(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        SLog.m15127i("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = "null";
        }
        if (str3.equals("")) {
            str3 = "null";
        }
        if (str4.equals("")) {
            str4 = "null";
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.f37067a.m15460a(activity, str, iUiListener, false, null, z);
    }

    /* renamed from: a */
    public void m15393a() {
        this.f37067a.m15455a((IUiListener) null);
    }

    /* renamed from: a */
    public void m15381a(IUiListener iUiListener) {
        this.f37067a.m15451b(iUiListener);
    }

    /* renamed from: a */
    public void m15379a(String str, String str2) {
        SLog.m15127i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.f37068b.setAccessToken(str, str2);
    }
}
