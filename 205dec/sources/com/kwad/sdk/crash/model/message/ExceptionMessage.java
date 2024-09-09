package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.utils.i;
import com.kwad.sdk.crash.utils.j;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class ExceptionMessage implements b, Serializable {
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

    public static final String getSdkCrashVersionName(String str, int i4) {
        return str + "-" + i4;
    }

    public static final String getSdkVersionNameSuffix(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? "" : "-car" : "-pct" : "-ec" : "-ct" : "-ad";
    }

    private void setIsForeground() {
        try {
            com.kwad.sdk.core.c.b.DD();
            this.mIsAppOnForeground = com.kwad.sdk.core.c.b.isAppOnForeground() ? "Foreground" : "Background";
        } catch (Exception unused) {
        }
    }

    public String getReportMsg() {
        return "UUID=" + this.mLogUUID + ",crashTime=" + i.ax(this.mCurrentTimeStamp) + ",customMsg=" + this.mCustomMsg;
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

    @Override // com.kwad.sdk.core.b
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

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "mCrashDetail", this.mCrashDetail);
        t.putValue(jSONObject, "mMemoryInfo", this.mMemoryInfo);
        t.putValue(jSONObject, "mDiskInfo", this.mDiskInfo);
        t.putValue(jSONObject, "mProcessName", this.mProcessName);
        t.putValue(jSONObject, "mCrashType", this.mCrashType);
        t.putValue(jSONObject, "mThreadName", this.mThreadName);
        setIsForeground();
        t.putValue(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
        t.putValue(jSONObject, "mLogUUID", this.mLogUUID);
        t.putValue(jSONObject, "mVirtualApp", this.mVirtualApp);
        t.putValue(jSONObject, "mCustomMsg", this.mCustomMsg);
        t.putValue(jSONObject, "mThreadOverflow", this.mThreadOverflow);
        t.putValue(jSONObject, "mFdOverflow", this.mFdOverflow);
        t.putValue(jSONObject, "mTaskId", this.mTaskId);
        t.putValue(jSONObject, "mErrorMessage", this.mErrorMessage);
        t.putValue(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
        t.putValue(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
        t.putValue(jSONObject, "mPid", this.mPid);
        t.putValue(jSONObject, "mTid", this.mTid);
        t.putValue(jSONObject, "mVersionCode", this.mVersionCode);
        t.putValue(jSONObject, "mVersionConflict", this.mVersionConflict);
        t.putValue(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
        t.putValue(jSONObject, "mJNIError", this.mJNIError);
        t.putValue(jSONObject, "mGCInfo", this.mGCInfo);
        t.putValue(jSONObject, "mLockInfo", this.mLockInfo);
        t.putValue(jSONObject, "mMonitorInfo", this.mMonitorInfo);
        t.putValue(jSONObject, "mSlowLooper", this.mSlowLooper);
        t.putValue(jSONObject, "mSlowOperation", this.mSlowOperation);
        t.putValue(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
        t.putValue(jSONObject, "mAbi", this.mAbi);
        t.putValue(jSONObject, "mDumpsys", this.mDumpsys);
        t.putValue(jSONObject, "mCrashSource", this.mCrashSource);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\u5f02\u5e38\u72b6\u6001\u6c47\u603b:\nUUID: ");
            sb.append(this.mLogUUID);
            sb.append("\nCPU\u67b6\u6784: ");
            sb.append(this.mAbi);
            sb.append("\n\u5f02\u5e38\u8fdb\u7a0b: ");
            sb.append(this.mProcessName);
            sb.append(" (");
            sb.append(this.mPid);
            sb.append(")\n");
            sb.append("\u5f02\u5e38\u7ebf\u7a0b: ");
            sb.append(this.mThreadName);
            sb.append(" (");
            sb.append(this.mTid);
            sb.append(")\n");
            sb.append("\u5f02\u5e38\u7c7b\u578b: ");
            sb.append(this.mCrashType);
            sb.append("\n\u5e94\u7528\u591a\u5f00\u73af\u5883: ");
            sb.append(this.mVirtualApp);
            sb.append("\nTaskId: ");
            sb.append(this.mTaskId);
            sb.append("\nmTid: ");
            sb.append(this.mTid);
            sb.append("\n\u81ea\u5b9a\u4e49\u4fe1\u606f: ");
            sb.append(this.mCustomMsg);
            sb.append("\n\u524d\u540e\u53f0\u72b6\u6001: ");
            sb.append(this.mIsAppOnForeground);
            sb.append("\n\u5f02\u5e38\u53d1\u751f\u65f6\u95f4: ");
            sb.append(i.ax(this.mCurrentTimeStamp));
            sb.append("\n\u7248\u672c\u53f7: ");
            sb.append(this.mVersionCode);
            sb.append("\n\u5347\u7ea7\u524d\u7248\u672c\u53f7: ");
            sb.append(this.mAppVersionBeforeLastUpload);
            sb.append("\n\u4f7f\u7528\u65f6\u957f: ");
            sb.append(j.ay(this.mUsageTimeMills));
            sb.append("\n\u5f02\u5e38\u8be6\u60c5: \n");
            if (this instanceof JavaExceptionMessage) {
                sb.append(this.mCrashDetail.replace("##", "\n\t").replace("#", "\n"));
            } else {
                sb.append(this.mCrashDetail);
            }
            sb.append("\n\u78c1\u76d8\u8be6\u60c5: \n");
            sb.append(this.mDiskInfo);
            sb.append("\n");
            if (!TextUtils.isEmpty(this.mErrorMessage)) {
                sb.append("\u5f02\u5e38\u4e0a\u62a5Debug: \n");
                sb.append(this.mErrorMessage);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                sb.append("BuildConfig\u4fe1\u606f: \n");
                sb.append(this.mBuildConfigInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mJNIError)) {
                sb.append("JNI\u5f02\u5e38: \n");
                sb.append(this.mJNIError);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mGCInfo)) {
                sb.append("GC\u8017\u65f6: \n");
                sb.append(this.mGCInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mLockInfo)) {
                sb.append("\u9501\u8017\u65f6(dvm_lock_sample): \n");
                sb.append(this.mLockInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                sb.append("\u9501\u8017\u65f6(monitor): \n");
                sb.append(this.mMonitorInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowLooper)) {
                sb.append("Looper\u8017\u65f6: \n");
                sb.append(this.mSlowLooper);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowOperation)) {
                sb.append("AMS\u8c03\u5ea6\u8017\u65f6: \n");
                sb.append(this.mSlowOperation);
                sb.append("\n");
            }
            sb.append("\u5185\u5b58\u8be6\u60c5: \n");
            sb.append(this.mMemoryInfo);
            sb.append("\n");
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
        return sb.substring(0);
    }
}
