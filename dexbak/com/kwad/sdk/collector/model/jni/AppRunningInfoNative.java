package com.kwad.sdk.collector.model.jni;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.C9809c;
import com.kwad.sdk.collector.model.InterfaceC9808b;
import com.kwad.sdk.utils.C11126t;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AppRunningInfoNative extends NativeObject implements InterfaceC9808b<AppRunningInfoNative> {
    private static SimpleDateFormat anE = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    public AppRunningInfoNative(long j, String str, String str2) {
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: AD */
    public AppRunningInfoNative clone() {
        AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
        C9809c.m27732a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return appRunningInfoNative;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(AppRunningInfoNative appRunningInfoNative) {
        if (appRunningInfoNative == null) {
            return 1;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) - C9809c.m27727c(appRunningInfoNative);
        if (appRunningInfoGetLastRunningTime == 0) {
            return 0;
        }
        return appRunningInfoGetLastRunningTime > 0 ? 1 : -1;
    }

    /* renamed from: ab */
    private static String m27722ab(long j) {
        return anE.format(new Date(j));
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteAppRunningInfo(j);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppRunningInfoNative appRunningInfoNative = (AppRunningInfoNative) obj;
        long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (appRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(appRunningInfoNative)) {
            return false;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
        String appRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
        String appRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
        if (appRunningInfoGetGranularity == 0) {
            appRunningInfoGetGranularity = 1;
        }
        if (appRunningInfoGetLastRunningTime / appRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / appRunningInfoGetGranularity && appRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
            return appRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
        }
        return false;
    }

    public int hashCode() {
        long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (appRunningInfoGetGranularity == 0) {
            appRunningInfoGetGranularity = 1;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) / appRunningInfoGetGranularity;
        return (((AppStatusNative.appRunningInfoGetName(this).hashCode() * 31) + AppStatusNative.appRunningInfoGetPackageName(this).hashCode()) * 31) + ((int) (appRunningInfoGetLastRunningTime ^ (appRunningInfoGetLastRunningTime >>> 32)));
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
        C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, AppStatusNative.appRunningInfoGetPackageName(this));
        C11126t.putValue(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + C9809c.m27729b(this) + "', lastRunningTime=" + m27722ab(C9809c.m27727c(this)) + '}';
    }

    public AppRunningInfoNative(long j) {
        this.mPtr = j;
    }
}
