package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.entity.InstallApp;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.tools.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class InstallAppManager {

    /* renamed from: b */
    private static InstallAppManager f31089b;

    /* renamed from: a */
    private Context f31090a;

    /* renamed from: c */
    private SharedPreferences f31091c;

    /* renamed from: d */
    private boolean f31092d;

    /* renamed from: e */
    private FastKV f31093e = null;

    private InstallAppManager(Context context) {
        this.f31092d = false;
        this.f31090a = context;
        this.f31092d = SDKController.m22827a().m22818d();
    }

    /* renamed from: a */
    public static InstallAppManager m21846a(Context context) {
        if (f31089b == null) {
            synchronized (InstallAppManager.class) {
                if (f31089b == null) {
                    f31089b = new InstallAppManager(context);
                }
            }
        }
        return f31089b;
    }

    /* renamed from: a */
    public final CopyOnWriteArraySet<InstallApp> m21845a(String str) {
        CopyOnWriteArraySet<InstallApp> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        String str2 = null;
        if (this.f31092d && this.f31093e == null) {
            try {
                this.f31093e = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "installed").build();
            } catch (Exception unused) {
                this.f31093e = null;
            }
        }
        FastKV fastKV = this.f31093e;
        int i = 0;
        if (fastKV != null) {
            try {
                str2 = fastKV.getString(str + "_installed", "");
            } catch (Exception unused2) {
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONArray jSONArray = new JSONArray(str2);
                    while (i < jSONArray.length()) {
                        InstallApp installApp = new InstallApp();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        installApp.m22541a(jSONObject.optString("campaignId"));
                        installApp.m22538b(jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME));
                        copyOnWriteArraySet.add(installApp);
                        i++;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Context context = this.f31090a;
            if (context != null) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("installed", 0);
                    this.f31091c = sharedPreferences;
                    if (sharedPreferences != null) {
                        String string = sharedPreferences.getString(str + "_installed", "");
                        if (!TextUtils.isEmpty(string)) {
                            JSONArray jSONArray2 = new JSONArray(string);
                            while (i < jSONArray2.length()) {
                                InstallApp installApp2 = new InstallApp();
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                                installApp2.m22541a(jSONObject2.optString("campaignId"));
                                installApp2.m22538b(jSONObject2.optString(TTDownloadField.TT_PACKAGE_NAME));
                                copyOnWriteArraySet.add(installApp2);
                                i++;
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return copyOnWriteArraySet;
    }

    /* renamed from: a */
    public final void m21844a(Set<InstallApp> set) {
        SharedPreferences.Editor edit;
        if (set == null || set.size() < 0) {
            return;
        }
        if (this.f31092d && this.f31093e == null) {
            try {
                this.f31093e = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "installed").build();
            } catch (Exception unused) {
                this.f31093e = null;
            }
        }
        if (this.f31093e != null) {
            try {
                String m22540a = InstallApp.m22540a(set);
                try {
                    FastKV fastKV = this.f31093e;
                    fastKV.putString(MBSDKContext.m22865f().m22860k() + "_installed", m22540a);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            String m22540a2 = InstallApp.m22540a(set);
            Context context = this.f31090a;
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("installed", 0);
                this.f31091c = sharedPreferences;
                if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                    return;
                }
                edit.putString(MBSDKContext.m22865f().m22860k() + "_installed", m22540a2);
                edit.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
