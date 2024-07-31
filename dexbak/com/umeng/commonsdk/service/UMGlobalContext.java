package com.umeng.commonsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMGlobalContext {
    private static final String TAG = "UMGlobalContext";
    private String mAppVersion;
    private String mAppkey;
    private Context mApplicationContext;
    private String mChannel;
    private String mProcessName;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.umeng.commonsdk.service.UMGlobalContext$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13236a {

        /* renamed from: a */
        private static final UMGlobalContext f38880a = new UMGlobalContext();

        private C13236a() {
        }
    }

    public static Context getAppContext(Context context) {
        if (C13236a.f38880a.mApplicationContext == null && context != null) {
            C13236a.f38880a.mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C13236a.f38880a.mApplicationContext;
    }

    public static UMGlobalContext getInstance(Context context) {
        if (C13236a.f38880a.mApplicationContext == null && context != null) {
            C13236a.f38880a.mApplicationContext = context;
        }
        return C13236a.f38880a;
    }

    public String getAppVersion() {
        if (TextUtils.isEmpty(this.mAppVersion)) {
            this.mAppVersion = UMUtils.getAppVersionName(this.mApplicationContext);
        }
        return this.mAppVersion;
    }

    public String getAppkey() {
        if (TextUtils.isEmpty(this.mAppkey)) {
            this.mAppkey = UMConfigure.sAppkey;
        }
        return this.mAppkey;
    }

    public String getChannel() {
        if (TextUtils.isEmpty(this.mChannel)) {
            this.mChannel = UMConfigure.sChannel;
        }
        return this.mChannel;
    }

    public String getProcessName(Context context) {
        if (TextUtils.isEmpty(this.mProcessName)) {
            if (context != null) {
                Context context2 = C13236a.f38880a.mApplicationContext;
                if (context2 != null) {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context2);
                } else {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context);
                }
            } else {
                this.mProcessName = UMFrUtils.getCurrentProcessName(C13236a.f38880a.mApplicationContext);
            }
        }
        return this.mProcessName;
    }

    public boolean isMainProcess(Context context) {
        return UMUtils.isMainProgress(context);
    }

    public String toString() {
        if (C13236a.f38880a.mApplicationContext != null) {
            StringBuilder sb = new StringBuilder("[");
            sb.append("appkey:" + this.mAppkey + ",");
            sb.append("channel:" + this.mChannel + ",");
            sb.append("procName:" + this.mProcessName + "]");
            return sb.toString();
        }
        return "uninitialized.";
    }

    private UMGlobalContext() {
        this.mProcessName = "";
    }

    public static Context getAppContext() {
        return C13236a.f38880a.mApplicationContext;
    }
}
