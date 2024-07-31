package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10748i;
import com.kwad.sdk.crash.utils.C10749j;
import com.kwad.sdk.utils.C11126t;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class ExceptionMessage implements InterfaceC9914b, Serializable {
    private static final long serialVersionUID = -5338556142957298914L;
    public long mCurrentTimeStamp;
    public int mPid;
    public int mTid;
    public long mUsageTimeMills;
    public String mCrashDetail = "Unknown";
    public String mMemoryInfo = "Unknown";
    public String mDiskInfo = "Unknown";
    public String mProcessName = "Unknown";
    public int mExceptionType = 0;
    public String mCrashType = getTypeCommon();
    public String mThreadName = "Unknown";
    public String mIsAppOnForeground = "Unknown";
    public String mLogUUID = "Unknown";
    public String mVirtualApp = "Unknown";
    public String mCustomMsg = "Unknown";
    public String mThreadOverflow = "Unknown";
    public String mFdOverflow = "Unknown";
    public String mTaskId = "Unknown";
    public String mErrorMessage = "";
    public String mVersionCode = "Unknown";
    public boolean mVersionConflict = false;
    public String mAppVersionBeforeLastUpload = "Unknown";
    public String mJNIError = "";
    public String mGCInfo = "";
    public String mLockInfo = "";
    public String mMonitorInfo = "";
    public String mSlowLooper = "";
    public String mSlowOperation = "";
    public String mBuildConfigInfo = "";
    public String mAbi = "Unknown";
    public String mDumpsys = "";
    public int mCrashSource = 0;

    public static final String getSdkCrashVersionName(String str, int i) {
        return str + "-" + i;
    }

    public static final String getSdkVersionNameSuffix(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "-car" : "-pct" : "-ec" : "-ct" : "-ad";
    }

    private void setIsForeground() {
        try {
            C10232b.m26625DD();
            this.mIsAppOnForeground = C10232b.isAppOnForeground() ? "Foreground" : "Background";
        } catch (Exception unused) {
        }
    }

    public String getReportMsg() {
        return "UUID=" + this.mLogUUID + ",crashTime=" + C10748i.m24938ax(this.mCurrentTimeStamp) + ",customMsg=" + this.mCustomMsg;
    }

    public final String getTypeCommon() {
        return getTypePrefix() + "COMMON";
    }

    public final String getTypeFdOOM() {
        return getTypePrefix() + "FD_OOM";
    }

    public final String getTypeHeapOOM() {
        return getTypePrefix() + "HEAP_OOM";
    }

    protected abstract String getTypePrefix();

    public final String getTypeThreadOOM() {
        return getTypePrefix() + "THREAD_OOM";
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mCrashDetail = jSONObject.optString("mCrashDetail");
        this.mMemoryInfo = jSONObject.optString("mMemoryInfo");
        this.mDiskInfo = jSONObject.optString("mDiskInfo");
        this.mProcessName = jSONObject.optString("mProcessName");
        this.mCrashType = jSONObject.optString("mCrashType");
        this.mThreadName = jSONObject.optString("mThreadName");
        this.mIsAppOnForeground = jSONObject.optString("mIsAppOnForeground");
        this.mLogUUID = jSONObject.optString("mLogUUID");
        this.mVirtualApp = jSONObject.optString("mVirtualApp");
        this.mCustomMsg = jSONObject.optString("mCustomMsg");
        this.mThreadOverflow = jSONObject.optString("mThreadOverflow");
        this.mFdOverflow = jSONObject.optString("mFdOverflow");
        this.mTaskId = jSONObject.optString("mTaskId");
        this.mErrorMessage = jSONObject.optString("mErrorMessage");
        this.mCurrentTimeStamp = jSONObject.optLong("mCurrentTimeStamp");
        this.mUsageTimeMills = jSONObject.optLong("mUsageTimeMills");
        this.mPid = jSONObject.optInt("mPid");
        this.mTid = jSONObject.optInt("mTid");
        this.mVersionCode = jSONObject.optString("mVersionCode");
        this.mVersionConflict = jSONObject.optBoolean("mVersionConflict");
        this.mAppVersionBeforeLastUpload = jSONObject.optString("mAppVersionBeforeLastUpload");
        this.mJNIError = jSONObject.optString("mJNIError");
        this.mGCInfo = jSONObject.optString("mGCInfo");
        this.mLockInfo = jSONObject.optString("mLockInfo");
        this.mMonitorInfo = jSONObject.optString("mMonitorInfo");
        this.mSlowLooper = jSONObject.optString("mSlowLooper");
        this.mSlowOperation = jSONObject.optString("mSlowOperation");
        this.mBuildConfigInfo = jSONObject.optString("mBuildConfigInfo");
        this.mAbi = jSONObject.optString("mAbi");
        this.mDumpsys = jSONObject.optString("mDumpsys");
        this.mCrashSource = jSONObject.optInt("mCrashSource");
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "mCrashDetail", this.mCrashDetail);
        C11126t.putValue(jSONObject, "mMemoryInfo", this.mMemoryInfo);
        C11126t.putValue(jSONObject, "mDiskInfo", this.mDiskInfo);
        C11126t.putValue(jSONObject, "mProcessName", this.mProcessName);
        C11126t.putValue(jSONObject, "mCrashType", this.mCrashType);
        C11126t.putValue(jSONObject, "mThreadName", this.mThreadName);
        setIsForeground();
        C11126t.putValue(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
        C11126t.putValue(jSONObject, "mLogUUID", this.mLogUUID);
        C11126t.putValue(jSONObject, "mVirtualApp", this.mVirtualApp);
        C11126t.putValue(jSONObject, "mCustomMsg", this.mCustomMsg);
        C11126t.putValue(jSONObject, "mThreadOverflow", this.mThreadOverflow);
        C11126t.putValue(jSONObject, "mFdOverflow", this.mFdOverflow);
        C11126t.putValue(jSONObject, "mTaskId", this.mTaskId);
        C11126t.putValue(jSONObject, "mErrorMessage", this.mErrorMessage);
        C11126t.putValue(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
        C11126t.putValue(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
        C11126t.putValue(jSONObject, "mPid", this.mPid);
        C11126t.putValue(jSONObject, "mTid", this.mTid);
        C11126t.putValue(jSONObject, "mVersionCode", this.mVersionCode);
        C11126t.putValue(jSONObject, "mVersionConflict", this.mVersionConflict);
        C11126t.putValue(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
        C11126t.putValue(jSONObject, "mJNIError", this.mJNIError);
        C11126t.putValue(jSONObject, "mGCInfo", this.mGCInfo);
        C11126t.putValue(jSONObject, "mLockInfo", this.mLockInfo);
        C11126t.putValue(jSONObject, "mMonitorInfo", this.mMonitorInfo);
        C11126t.putValue(jSONObject, "mSlowLooper", this.mSlowLooper);
        C11126t.putValue(jSONObject, "mSlowOperation", this.mSlowOperation);
        C11126t.putValue(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
        C11126t.putValue(jSONObject, "mAbi", this.mAbi);
        C11126t.putValue(jSONObject, "mDumpsys", this.mDumpsys);
        C11126t.putValue(jSONObject, "mCrashSource", this.mCrashSource);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("异常状态汇总:\nUUID: ");
            sb.append(this.mLogUUID);
            sb.append("\nCPU架构: ");
            sb.append(this.mAbi);
            sb.append("\n异常进程: ");
            sb.append(this.mProcessName);
            sb.append(" (");
            sb.append(this.mPid);
            sb.append(")\n");
            sb.append("异常线程: ");
            sb.append(this.mThreadName);
            sb.append(" (");
            sb.append(this.mTid);
            sb.append(")\n");
            sb.append("异常类型: ");
            sb.append(this.mCrashType);
            sb.append("\n应用多开环境: ");
            sb.append(this.mVirtualApp);
            sb.append("\nTaskId: ");
            sb.append(this.mTaskId);
            sb.append("\nmTid: ");
            sb.append(this.mTid);
            sb.append("\n自定义信息: ");
            sb.append(this.mCustomMsg);
            sb.append("\n前后台状态: ");
            sb.append(this.mIsAppOnForeground);
            sb.append("\n异常发生时间: ");
            sb.append(C10748i.m24938ax(this.mCurrentTimeStamp));
            sb.append("\n版本号: ");
            sb.append(this.mVersionCode);
            sb.append("\n升级前版本号: ");
            sb.append(this.mAppVersionBeforeLastUpload);
            sb.append("\n使用时长: ");
            sb.append(C10749j.m24937ay(this.mUsageTimeMills));
            sb.append("\n异常详情: \n");
            if (this instanceof JavaExceptionMessage) {
                sb.append(this.mCrashDetail.replace("##", "\n\t").replace("#", ShellAdbUtils.f33810d));
            } else {
                sb.append(this.mCrashDetail);
            }
            sb.append("\n磁盘详情: \n");
            sb.append(this.mDiskInfo);
            sb.append(ShellAdbUtils.f33810d);
            if (!TextUtils.isEmpty(this.mErrorMessage)) {
                sb.append("异常上报Debug: \n");
                sb.append(this.mErrorMessage);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                sb.append("BuildConfig信息: \n");
                sb.append(this.mBuildConfigInfo);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mJNIError)) {
                sb.append("JNI异常: \n");
                sb.append(this.mJNIError);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mGCInfo)) {
                sb.append("GC耗时: \n");
                sb.append(this.mGCInfo);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mLockInfo)) {
                sb.append("锁耗时(dvm_lock_sample): \n");
                sb.append(this.mLockInfo);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                sb.append("锁耗时(monitor): \n");
                sb.append(this.mMonitorInfo);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mSlowLooper)) {
                sb.append("Looper耗时: \n");
                sb.append(this.mSlowLooper);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mSlowOperation)) {
                sb.append("AMS调度耗时: \n");
                sb.append(this.mSlowOperation);
                sb.append(ShellAdbUtils.f33810d);
            }
            sb.append("内存详情: \n");
            sb.append(this.mMemoryInfo);
            sb.append(ShellAdbUtils.f33810d);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        return sb.substring(0);
    }
}
