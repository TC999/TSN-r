package com.tencent.bugly;

import com.tencent.bugly.proguard.C12786aa;
import java.util.Map;

/* renamed from: com.tencent.bugly.BuglyStrategy */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BUGLY {

    /* renamed from: c */
    private String f36241c;

    /* renamed from: d */
    private String f36242d;

    /* renamed from: e */
    private String f36243e;

    /* renamed from: f */
    private long f36244f;

    /* renamed from: g */
    private String f36245g;

    /* renamed from: h */
    private String f36246h;

    /* renamed from: i */
    private String f36247i;

    /* renamed from: u */
    private C12768a f36259u;

    /* renamed from: j */
    private boolean f36248j = true;

    /* renamed from: k */
    private boolean f36249k = true;

    /* renamed from: l */
    private boolean f36250l = true;

    /* renamed from: m */
    private boolean f36251m = false;

    /* renamed from: n */
    private boolean f36252n = true;

    /* renamed from: o */
    private Class<?> f36253o = null;

    /* renamed from: p */
    private boolean f36254p = true;

    /* renamed from: q */
    private boolean f36255q = true;

    /* renamed from: r */
    private boolean f36256r = true;

    /* renamed from: s */
    private boolean f36257s = true;

    /* renamed from: t */
    private boolean f36258t = false;

    /* renamed from: a */
    protected int f36239a = 31;

    /* renamed from: b */
    protected boolean f36240b = false;

    /* renamed from: v */
    private boolean f36260v = false;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.BuglyStrategy$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12768a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f36242d;
        if (str == null) {
            return C12786aa.m16005b().f36466s;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str = this.f36243e;
        if (str == null) {
            return C12786aa.m16005b().f36450c;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f36244f;
    }

    public synchronized String getAppVersion() {
        String str = this.f36241c;
        if (str == null) {
            return C12786aa.m16005b().f36462o;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.f36239a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f36240b;
    }

    public synchronized C12768a getCrashHandleCallback() {
        return this.f36259u;
    }

    public synchronized String getDeviceID() {
        return this.f36246h;
    }

    public synchronized String getDeviceModel() {
        return this.f36247i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f36245g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f36253o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f36254p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f36249k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f36250l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f36248j;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f36251m;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f36252n;
    }

    public boolean isMerged() {
        return this.f36260v;
    }

    public boolean isReplaceOldChannel() {
        return this.f36255q;
    }

    public synchronized boolean isUploadProcess() {
        return this.f36256r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f36257s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f36258t;
    }

    public synchronized BUGLY setAppChannel(String str) {
        this.f36242d = str;
        return this;
    }

    public synchronized BUGLY setAppPackageName(String str) {
        this.f36243e = str;
        return this;
    }

    public synchronized BUGLY setAppReportDelay(long j) {
        this.f36244f = j;
        return this;
    }

    public synchronized BUGLY setAppVersion(String str) {
        this.f36241c = str;
        return this;
    }

    public synchronized BUGLY setBuglyLogUpload(boolean z) {
        this.f36254p = z;
        return this;
    }

    public synchronized void setCallBackType(int i) {
        this.f36239a = i;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.f36240b = z;
    }

    public synchronized BUGLY setCrashHandleCallback(C12768a c12768a) {
        this.f36259u = c12768a;
        return this;
    }

    public synchronized BUGLY setDeviceID(String str) {
        this.f36246h = str;
        return this;
    }

    public synchronized BUGLY setDeviceModel(String str) {
        this.f36247i = str;
        return this;
    }

    public synchronized BUGLY setEnableANRCrashMonitor(boolean z) {
        this.f36249k = z;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.f36250l = z;
    }

    public synchronized BUGLY setEnableNativeCrashMonitor(boolean z) {
        this.f36248j = z;
        return this;
    }

    public void setEnableRecordAnrMainStack(boolean z) {
        this.f36251m = z;
    }

    public synchronized BUGLY setEnableUserInfo(boolean z) {
        this.f36252n = z;
        return this;
    }

    public synchronized BUGLY setLibBuglySOFilePath(String str) {
        this.f36245g = str;
        return this;
    }

    @Deprecated
    public void setMerged(boolean z) {
        this.f36260v = z;
    }

    public synchronized BUGLY setRecordUserInfoOnceADay(boolean z) {
        this.f36258t = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.f36255q = z;
    }

    public synchronized BUGLY setUploadProcess(boolean z) {
        this.f36256r = z;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z) {
        this.f36257s = z;
    }

    public synchronized BUGLY setUserInfoActivity(Class<?> cls) {
        this.f36253o = cls;
        return this;
    }
}
