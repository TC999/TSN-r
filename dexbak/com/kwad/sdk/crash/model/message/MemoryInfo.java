package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11126t;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MemoryInfo implements InterfaceC9914b, Serializable {
    private static final long serialVersionUID = -4944913077323984734L;
    public int mAvailableMB;
    public int mFdCount;
    public int mJavaHeapLimitMB;
    public int mJavaHeapMB;
    public int mPssMB;
    public int mRssMB;
    public int mThreadsCount;
    public int mTotalMB;
    public int mVssMB;
    public List<String> mFds = new ArrayList();
    public List<ThreadInfo> mJavaThreads = new ArrayList();
    public List<ThreadInfo> mNativeThreads = new ArrayList();
    public List<ThreadInfo> mAllThreads = new ArrayList();

    public MemoryInfo() {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mTotalMB = jSONObject.optInt("mTotalMB");
        this.mAvailableMB = jSONObject.optInt("mAvailableMB");
        this.mJavaHeapLimitMB = jSONObject.optInt("mJavaHeapLimitMB");
        this.mJavaHeapMB = jSONObject.optInt("mJavaHeapMB");
        this.mVssMB = jSONObject.optInt("mVssMB");
        this.mRssMB = jSONObject.optInt("mRssMB");
        this.mPssMB = jSONObject.optInt("mPssMB");
        this.mThreadsCount = jSONObject.optInt("mThreadsCount");
        this.mFdCount = jSONObject.optInt("mFdCount");
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("mFds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (optString != null && !optString.isEmpty()) {
                        this.mFds.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mJavaThreads");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject != null) {
                        ThreadInfo threadInfo = new ThreadInfo();
                        threadInfo.parseJson(optJSONObject);
                        this.mJavaThreads.add(threadInfo);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("mNativeThreads");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        ThreadInfo threadInfo2 = new ThreadInfo();
                        threadInfo2.parseJson(optJSONObject2);
                        this.mNativeThreads.add(threadInfo2);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("mAllThreads");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i4);
                if (optJSONObject3 != null) {
                    ThreadInfo threadInfo3 = new ThreadInfo();
                    threadInfo3.parseJson(optJSONObject3);
                    this.mAllThreads.add(threadInfo3);
                }
            }
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "mTotalMB", this.mTotalMB);
        C11126t.putValue(jSONObject, "mAvailableMB", this.mAvailableMB);
        C11126t.putValue(jSONObject, "mJavaHeapLimitMB", this.mJavaHeapLimitMB);
        C11126t.putValue(jSONObject, "mJavaHeapMB", this.mJavaHeapMB);
        C11126t.putValue(jSONObject, "mVssMB", this.mVssMB);
        C11126t.putValue(jSONObject, "mRssMB", this.mRssMB);
        C11126t.putValue(jSONObject, "mPssMB", this.mPssMB);
        C11126t.putValue(jSONObject, "mThreadsCount", this.mThreadsCount);
        C11126t.putValue(jSONObject, "mFdCount", this.mFdCount);
        C11126t.putValue(jSONObject, "mFds", this.mFds);
        C11126t.putValue(jSONObject, "mJavaThreads", this.mJavaThreads);
        C11126t.putValue(jSONObject, "mNativeThreads", this.mNativeThreads);
        C11126t.putValue(jSONObject, "mAllThreads", this.mAllThreads);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t总RAM容量: ");
        sb.append(this.mTotalMB);
        sb.append(" (MB)\n\t剩余RAM容量: ");
        sb.append(this.mAvailableMB);
        sb.append(" (MB)\n\t本进程Java堆上限: ");
        sb.append(this.mJavaHeapLimitMB);
        sb.append(" (MB)\n\t本进程Java堆已使用: ");
        sb.append(this.mJavaHeapMB);
        sb.append(" (MB)\n\t虚拟地址空间已使用Vss: ");
        sb.append(this.mVssMB);
        sb.append(" (MB)\n\t实际空间使用量(包含共享库) Rss: ");
        sb.append(this.mRssMB);
        sb.append(" (MB)\n\t实际空间使用量(共享库已经均摊)(高内存杀进程的依据）Pss: ");
        sb.append(this.mPssMB);
        sb.append(" (MB)\n\t打开文件描述符数: ");
        sb.append(this.mFdCount);
        sb.append(ShellAdbUtils.f33810d);
        if (this.mFds.size() > 0) {
            sb.append("\t文件描述符详情: \n");
            for (String str : this.mFds) {
                sb.append("\t");
                sb.append(str);
                sb.append(ShellAdbUtils.f33810d);
            }
        }
        sb.append("\t正在运行线程数: ");
        sb.append(this.mThreadsCount);
        sb.append("\tJava: ");
        sb.append(this.mJavaThreads.size());
        sb.append("\tNative: ");
        sb.append(this.mThreadsCount - this.mJavaThreads.size());
        sb.append("\n\n");
        if (this.mAllThreads.size() > 0) {
            sb.append("\t全部线程名: \n");
            for (ThreadInfo threadInfo : this.mAllThreads) {
                sb.append("\t");
                sb.append(threadInfo.mName);
                sb.append(ShellAdbUtils.f33810d);
            }
        }
        if (this.mJavaThreads.size() > 0) {
            sb.append("Java线程堆栈: \n");
            for (ThreadInfo threadInfo2 : this.mJavaThreads) {
                sb.append(threadInfo2.mName);
                sb.append(ShellAdbUtils.f33810d);
                sb.append(threadInfo2.mTrace.replace("#", ShellAdbUtils.f33810d));
                sb.append(ShellAdbUtils.f33810d);
            }
        }
        if (this.mNativeThreads.size() > 0) {
            sb.append("\tNative线程堆栈: \n");
            for (ThreadInfo threadInfo3 : this.mNativeThreads) {
                sb.append("\t");
                sb.append(threadInfo3.mName);
                sb.append("\t(tid=");
                sb.append(threadInfo3.mTid);
                sb.append(", index=");
                sb.append(threadInfo3.mIndex);
                sb.append("):\n");
                sb.append(threadInfo3.mTrace);
            }
        }
        return sb.substring(0);
    }

    public MemoryInfo(String str) {
        try {
            if (TextUtils.isEmpty(str) || "Unknown".equals(str)) {
                return;
            }
            parseJson(new JSONObject(str));
        } catch (JSONException e) {
            C10331c.printStackTraceOnly(e);
        }
    }
}
