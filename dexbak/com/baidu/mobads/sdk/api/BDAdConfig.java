package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.C2580aa;
import com.baidu.mobads.sdk.internal.C2607aw;
import com.baidu.mobads.sdk.internal.C2613ba;
import com.baidu.mobads.sdk.internal.C2670cp;
import com.baidu.mobads.sdk.internal.C2682d;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDAdConfig {
    private Context mAppContext;
    private String mAppName;
    private String mAppsid;
    private BDAdInitListener mBDAdInitListener;
    private String mChannelId;
    private boolean mCloseShake;
    private JSONObject mConfigObj;
    private boolean mDebug;
    private JSONObject mDialogParams;
    private JSONObject mExtraParams;
    private boolean mHttps;
    private boolean mLpMultiProcess;
    private boolean mMtjSwitch;
    private boolean mSplashLog;
    private boolean mUseActivityDialog;
    private int mVideoCacheCapacityMb;
    private String mWXAPPid;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface BDAdInitListener {
        void fail();

        void success();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Builder {
        private String mAppName;
        private String mAppsid;
        private BDAdInitListener mBDAdInitListener;
        private String mChannelId;
        private JSONObject mDialogParams;
        private JSONObject mExtraParams;
        private boolean mLpSupportMultiProcess;
        private int mVideoCacheCapacityMb;
        private String mWXAPPid;
        private boolean mHttps = true;
        private boolean mUseActivityDialog = true;
        private boolean mMtjSwitch = true;
        private boolean mCloseShake = false;
        private boolean mDebug = false;
        private boolean mSplashLog = false;

        public BDAdConfig build(Context context) {
            return new BDAdConfig(context, this);
        }

        public Builder putExtraParam(String str, String str2) {
            if (this.mExtraParams == null) {
                this.mExtraParams = new JSONObject();
            }
            try {
                this.mExtraParams.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return this;
        }

        public Builder setAppName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder setAppsid(String str) {
            this.mAppsid = str;
            return this;
        }

        public Builder setBDAdInitListener(BDAdInitListener bDAdInitListener) {
            this.mBDAdInitListener = bDAdInitListener;
            return this;
        }

        public Builder setChannelId(String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setCloseShake(boolean z) {
            this.mCloseShake = z;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.mDebug = z;
            return this;
        }

        public Builder setDialogParams(BDDialogParams bDDialogParams) {
            this.mDialogParams = bDDialogParams.toJson();
            return this;
        }

        public Builder setHttps(boolean z) {
            this.mHttps = z;
            return this;
        }

        public Builder setLpMultiProcess(boolean z) {
            this.mLpSupportMultiProcess = z;
            return this;
        }

        public Builder setMtjSwitch(boolean z) {
            this.mMtjSwitch = z;
            return this;
        }

        public Builder setSplashLog(boolean z) {
            this.mSplashLog = z;
            return this;
        }

        public Builder setVideoCacheCapacityMb(int i) {
            this.mVideoCacheCapacityMb = i;
            return this;
        }

        public Builder setWXAppid(String str) {
            this.mWXAPPid = str;
            return this;
        }

        @Deprecated
        public Builder useActivityDialog(Boolean bool) {
            this.mUseActivityDialog = bool.booleanValue();
            return this;
        }
    }

    public static void clearMemoryCache() {
        try {
            C2580aa.m51057a().m51049c().onTaskDistribute(C2613ba.f8642c, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void initConfig() {
        try {
            if (this.mConfigObj == null) {
                this.mConfigObj = new JSONObject();
            }
            JSONObject jSONObject = this.mConfigObj;
            jSONObject.put("https", "" + this.mHttps);
            this.mConfigObj.put("appName", this.mAppName);
            JSONObject jSONObject2 = this.mConfigObj;
            jSONObject2.put("videoCacheSize", "" + this.mVideoCacheCapacityMb);
            this.mConfigObj.put("appsid", this.mAppsid);
            this.mConfigObj.put(URLPackage.KEY_CHANNEL_ID, this.mChannelId);
            JSONObject jSONObject3 = this.mConfigObj;
            jSONObject3.put("lpMultiProcess", "" + this.mLpMultiProcess);
            JSONObject jSONObject4 = this.mConfigObj;
            jSONObject4.put("useActivityDialog", "" + this.mUseActivityDialog);
            this.mConfigObj.put("dialog_params", this.mDialogParams);
            this.mConfigObj.put("mtj_switch", this.mMtjSwitch);
            this.mConfigObj.put("sp_shake", this.mCloseShake);
            this.mConfigObj.put("sdk_debug", this.mDebug);
            this.mConfigObj.put("splashLog", this.mSplashLog);
            this.mConfigObj.put("extras", this.mExtraParams);
            if (!TextUtils.isEmpty(this.mWXAPPid)) {
                this.mConfigObj.put("wxAppid", this.mWXAPPid);
            }
            C2670cp.m50608a().m50602a(this.mLpMultiProcess);
            C2670cp.m50608a().m50599b(this.mHttps);
            C2607aw.m50927a(this.mDebug);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void init() {
        initConfig();
        JSONObject jSONObject = this.mConfigObj;
        if (jSONObject != null) {
            try {
                jSONObject.put("gmss", C2682d.m50568a());
                this.mConfigObj.put("toss", C2682d.m50567b());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        C2580aa.m51057a().m51056a(this.mAppContext, new C2580aa.InterfaceC2581a() { // from class: com.baidu.mobads.sdk.api.BDAdConfig.1
            @Override // com.baidu.mobads.sdk.internal.C2580aa.InterfaceC2581a
            public void onFailure() {
                if (BDAdConfig.this.mBDAdInitListener != null) {
                    BDAdConfig.this.mBDAdInitListener.fail();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.C2580aa.InterfaceC2581a
            public void onSuccess() {
                IXAdContainerFactory m51049c = C2580aa.m51057a().m51049c();
                if (m51049c != null) {
                    m51049c.initConfig(BDAdConfig.this.mConfigObj);
                    m51049c.onTaskDistribute(C2613ba.f8640a, MobadsPermissionSettings.getPermissionInfo());
                }
                if (BDAdConfig.this.mBDAdInitListener != null) {
                    BDAdConfig.this.mBDAdInitListener.success();
                }
            }
        });
    }

    public void preInit() {
        try {
            initConfig();
            C2580aa.m51057a().m51056a(this.mAppContext, new C2580aa.InterfaceC2581a() { // from class: com.baidu.mobads.sdk.api.BDAdConfig.2
                @Override // com.baidu.mobads.sdk.internal.C2580aa.InterfaceC2581a
                public void onFailure() {
                    if (BDAdConfig.this.mBDAdInitListener != null) {
                        BDAdConfig.this.mBDAdInitListener.fail();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.C2580aa.InterfaceC2581a
                public void onSuccess() {
                    C2580aa.m51057a().m51049c();
                    if (BDAdConfig.this.mBDAdInitListener != null) {
                        BDAdConfig.this.mBDAdInitListener.success();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private BDAdConfig(Context context, Builder builder) {
        this.mUseActivityDialog = true;
        this.mDebug = false;
        this.mSplashLog = false;
        this.mHttps = builder.mHttps;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
        this.mUseActivityDialog = builder.mUseActivityDialog;
        this.mDialogParams = builder.mDialogParams;
        this.mMtjSwitch = builder.mMtjSwitch;
        this.mCloseShake = builder.mCloseShake;
        this.mDebug = builder.mDebug;
        this.mWXAPPid = builder.mWXAPPid;
        this.mBDAdInitListener = builder.mBDAdInitListener;
        this.mSplashLog = builder.mSplashLog;
        this.mExtraParams = builder.mExtraParams;
    }
}
