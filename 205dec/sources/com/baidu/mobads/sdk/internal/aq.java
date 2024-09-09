package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.api.PromoteInstallManager;
import com.stub.StubApp;
import java.io.File;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12404a = x.f13032m;

    /* renamed from: b  reason: collision with root package name */
    private static final String f12405b = "__sdk_remote_dl_no_install";

    /* renamed from: c  reason: collision with root package name */
    private static final long f12406c = 3600000;

    /* renamed from: d  reason: collision with root package name */
    private Context f12407d;

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f12408e;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences.Editor f12409f;

    /* renamed from: g  reason: collision with root package name */
    private au f12410g;

    /* renamed from: h  reason: collision with root package name */
    private PromoteInstallManager.PromoteInstallListener f12411h;

    /* renamed from: i  reason: collision with root package name */
    private int f12412i;

    /* renamed from: j  reason: collision with root package name */
    private long f12413j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final aq f12414a = new aq(null);

        private a() {
        }
    }

    /* synthetic */ aq(ar arVar) {
        this();
    }

    public static aq a(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        a.f12414a.b(context, promoteInstallListener);
        return a.f12414a;
    }

    private void b(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        this.f12407d = context;
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f12405b, 0);
        this.f12408e = sharedPreferences;
        this.f12409f = sharedPreferences.edit();
        this.f12410g = au.a(context, f12404a);
        this.f12411h = promoteInstallListener;
    }

    private aq() {
        this.f12412i = 0;
        this.f12413j = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        r5 = new com.baidu.mobads.sdk.internal.ap(r8, r18.f12407d, r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c0, code lost:
        if (r19 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c2, code lost:
        r0 = new org.json.JSONObject(r8.toString());
        r0.put("install_ts", r9);
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d6, code lost:
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0108, code lost:
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012c, code lost:
        r0 = r18.f12411h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012e, code lost:
        if (r0 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
        r0.onFail("\u6682\u65e0\u53ef\u7528\u7269\u6599\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0133, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.baidu.mobads.sdk.api.IPromoteInstallAdInfo a(boolean r19) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.aq.a(boolean):com.baidu.mobads.sdk.api.IPromoteInstallAdInfo");
    }

    public int b() {
        Object b4 = this.f12410g.b(null, "getInstallPopType", new Object[0]);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return 0;
    }

    private boolean a(JSONObject jSONObject) {
        File file = new File(jSONObject.optString("folder") + jSONObject.optString("filename"));
        return file.exists() && file.length() > 0;
    }

    public boolean a() {
        Object b4 = this.f12410g.b(null, "isInstallPopSwitch", new Object[0]);
        if (b4 instanceof Boolean) {
            return ((Boolean) b4).booleanValue();
        }
        return false;
    }

    public void a(Context context, String str) {
        this.f12410g.b(null, "handleAdInstall", context, str);
    }
}
