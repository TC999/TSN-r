package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MemoryInfo implements b, Serializable {
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

    @Override // com.kwad.sdk.core.b
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
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    String optString = optJSONArray.optString(i4);
                    if (optString != null && !optString.isEmpty()) {
                        this.mFds.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mJavaThreads");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i5);
                    if (optJSONObject != null) {
                        ThreadInfo threadInfo = new ThreadInfo();
                        threadInfo.parseJson(optJSONObject);
                        this.mJavaThreads.add(threadInfo);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("mNativeThreads");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i6);
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
            for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i7);
                if (optJSONObject3 != null) {
                    ThreadInfo threadInfo3 = new ThreadInfo();
                    threadInfo3.parseJson(optJSONObject3);
                    this.mAllThreads.add(threadInfo3);
                }
            }
        } catch (Exception e4) {
            c.printStackTraceOnly(e4);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "mTotalMB", this.mTotalMB);
        t.putValue(jSONObject, "mAvailableMB", this.mAvailableMB);
        t.putValue(jSONObject, "mJavaHeapLimitMB", this.mJavaHeapLimitMB);
        t.putValue(jSONObject, "mJavaHeapMB", this.mJavaHeapMB);
        t.putValue(jSONObject, "mVssMB", this.mVssMB);
        t.putValue(jSONObject, "mRssMB", this.mRssMB);
        t.putValue(jSONObject, "mPssMB", this.mPssMB);
        t.putValue(jSONObject, "mThreadsCount", this.mThreadsCount);
        t.putValue(jSONObject, "mFdCount", this.mFdCount);
        t.putValue(jSONObject, "mFds", this.mFds);
        t.putValue(jSONObject, "mJavaThreads", this.mJavaThreads);
        t.putValue(jSONObject, "mNativeThreads", this.mNativeThreads);
        t.putValue(jSONObject, "mAllThreads", this.mAllThreads);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\u603bRAM\u5bb9\u91cf: ");
        sb.append(this.mTotalMB);
        sb.append(" (MB)\n\t\u5269\u4f59RAM\u5bb9\u91cf: ");
        sb.append(this.mAvailableMB);
        sb.append(" (MB)\n\t\u672c\u8fdb\u7a0bJava\u5806\u4e0a\u9650: ");
        sb.append(this.mJavaHeapLimitMB);
        sb.append(" (MB)\n\t\u672c\u8fdb\u7a0bJava\u5806\u5df2\u4f7f\u7528: ");
        sb.append(this.mJavaHeapMB);
        sb.append(" (MB)\n\t\u865a\u62df\u5730\u5740\u7a7a\u95f4\u5df2\u4f7f\u7528Vss: ");
        sb.append(this.mVssMB);
        sb.append(" (MB)\n\t\u5b9e\u9645\u7a7a\u95f4\u4f7f\u7528\u91cf(\u5305\u542b\u5171\u4eab\u5e93) Rss: ");
        sb.append(this.mRssMB);
        sb.append(" (MB)\n\t\u5b9e\u9645\u7a7a\u95f4\u4f7f\u7528\u91cf(\u5171\u4eab\u5e93\u5df2\u7ecf\u5747\u644a)(\u9ad8\u5185\u5b58\u6740\u8fdb\u7a0b\u7684\u4f9d\u636e\uff09Pss: ");
        sb.append(this.mPssMB);
        sb.append(" (MB)\n\t\u6253\u5f00\u6587\u4ef6\u63cf\u8ff0\u7b26\u6570: ");
        sb.append(this.mFdCount);
        sb.append("\n");
        if (this.mFds.size() > 0) {
            sb.append("\t\u6587\u4ef6\u63cf\u8ff0\u7b26\u8be6\u60c5: \n");
            for (String str : this.mFds) {
                sb.append("\t");
                sb.append(str);
                sb.append("\n");
            }
        }
        sb.append("\t\u6b63\u5728\u8fd0\u884c\u7ebf\u7a0b\u6570: ");
        sb.append(this.mThreadsCount);
        sb.append("\tJava: ");
        sb.append(this.mJavaThreads.size());
        sb.append("\tNative: ");
        sb.append(this.mThreadsCount - this.mJavaThreads.size());
        sb.append("\n\n");
        if (this.mAllThreads.size() > 0) {
            sb.append("\t\u5168\u90e8\u7ebf\u7a0b\u540d: \n");
            for (ThreadInfo threadInfo : this.mAllThreads) {
                sb.append("\t");
                sb.append(threadInfo.mName);
                sb.append("\n");
            }
        }
        if (this.mJavaThreads.size() > 0) {
            sb.append("Java\u7ebf\u7a0b\u5806\u6808: \n");
            for (ThreadInfo threadInfo2 : this.mJavaThreads) {
                sb.append(threadInfo2.mName);
                sb.append("\n");
                sb.append(threadInfo2.mTrace.replace("#", "\n"));
                sb.append("\n");
            }
        }
        if (this.mNativeThreads.size() > 0) {
            sb.append("\tNative\u7ebf\u7a0b\u5806\u6808: \n");
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
        } catch (JSONException e4) {
            c.printStackTraceOnly(e4);
        }
    }
}
