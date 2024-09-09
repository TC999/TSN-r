package com.tencent.bugly;

import com.tencent.bugly.proguard.aa;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BuglyStrategy {

    /* renamed from: c  reason: collision with root package name */
    private String f50691c;

    /* renamed from: d  reason: collision with root package name */
    private String f50692d;

    /* renamed from: e  reason: collision with root package name */
    private String f50693e;

    /* renamed from: f  reason: collision with root package name */
    private long f50694f;

    /* renamed from: g  reason: collision with root package name */
    private String f50695g;

    /* renamed from: h  reason: collision with root package name */
    private String f50696h;

    /* renamed from: i  reason: collision with root package name */
    private String f50697i;

    /* renamed from: u  reason: collision with root package name */
    private a f50709u;

    /* renamed from: j  reason: collision with root package name */
    private boolean f50698j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f50699k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f50700l = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f50701m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f50702n = true;

    /* renamed from: o  reason: collision with root package name */
    private Class<?> f50703o = null;

    /* renamed from: p  reason: collision with root package name */
    private boolean f50704p = true;

    /* renamed from: q  reason: collision with root package name */
    private boolean f50705q = true;

    /* renamed from: r  reason: collision with root package name */
    private boolean f50706r = true;

    /* renamed from: s  reason: collision with root package name */
    private boolean f50707s = true;

    /* renamed from: t  reason: collision with root package name */
    private boolean f50708t = false;

    /* renamed from: a  reason: collision with root package name */
    protected int f50689a = 31;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f50690b = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f50710v = false;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {
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

        public synchronized Map<String, String> onCrashHandleStart(int i4, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i4, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f50692d;
        if (str == null) {
            return aa.b().f50840s;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str = this.f50693e;
        if (str == null) {
            return aa.b().f50824c;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f50694f;
    }

    public synchronized String getAppVersion() {
        String str = this.f50691c;
        if (str == null) {
            return aa.b().f50836o;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.f50689a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f50690b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f50709u;
    }

    public synchronized String getDeviceID() {
        return this.f50696h;
    }

    public synchronized String getDeviceModel() {
        return this.f50697i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f50695g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f50703o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f50704p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f50699k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f50700l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f50698j;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f50701m;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f50702n;
    }

    public boolean isMerged() {
        return this.f50710v;
    }

    public boolean isReplaceOldChannel() {
        return this.f50705q;
    }

    public synchronized boolean isUploadProcess() {
        return this.f50706r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f50707s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f50708t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f50692d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f50693e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j4) {
        this.f50694f = j4;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f50691c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z3) {
        this.f50704p = z3;
        return this;
    }

    public synchronized void setCallBackType(int i4) {
        this.f50689a = i4;
    }

    public synchronized void setCloseErrorCallback(boolean z3) {
        this.f50690b = z3;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f50709u = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f50696h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f50697i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z3) {
        this.f50699k = z3;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z3) {
        this.f50700l = z3;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z3) {
        this.f50698j = z3;
        return this;
    }

    public void setEnableRecordAnrMainStack(boolean z3) {
        this.f50701m = z3;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z3) {
        this.f50702n = z3;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f50695g = str;
        return this;
    }

    @Deprecated
    public void setMerged(boolean z3) {
        this.f50710v = z3;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z3) {
        this.f50708t = z3;
        return this;
    }

    public void setReplaceOldChannel(boolean z3) {
        this.f50705q = z3;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z3) {
        this.f50706r = z3;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z3) {
        this.f50707s = z3;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f50703o = cls;
        return this;
    }
}
