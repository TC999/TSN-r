package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.stub.StubApp;
import com.umeng.commonsdk.statistics.common.MLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class StatTracer implements b {
    private static final String KEY_CLIENT_REQUEST_FAILED = "failed_requests ";
    private static final String KEY_CLIENT_REQUEST_LATENCY = "last_request_spent_ms";
    private static final String KEY_CLIENT_REQUEST_SUCCESS = "successful_request";
    private static final String KEY_CLIENT_REQUEST_TIME = "last_request_time";
    private static final String KEY_FIRST_ACTIVATE_TIME = "first_activate_time";
    private static final String KEY_LAST_REQ = "last_req";
    private static Context mContext;
    private final int MAX_REQUEST_LIMIT;
    private long firstActivateTime;
    private long lastRequestTime;
    public int mFailedRequest;
    private int mLastRequestLatency;
    public long mLastSuccessfulRequestTime;
    public int mSuccessfulRequest;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final StatTracer f53645a = new StatTracer();

        private a() {
        }
    }

    public static StatTracer getInstance(Context context) {
        if (mContext == null) {
            if (context != null) {
                mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            } else {
                MLog.e("inside StatTracer. please check context. context must not be null!");
            }
        }
        return a.f53645a;
    }

    private void init() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(mContext);
        this.mSuccessfulRequest = sharedPreferences.getInt("successful_request", 0);
        this.mFailedRequest = sharedPreferences.getInt("failed_requests ", 0);
        this.mLastRequestLatency = sharedPreferences.getInt("last_request_spent_ms", 0);
        this.mLastSuccessfulRequestTime = sharedPreferences.getLong("last_request_time", 0L);
        this.lastRequestTime = sharedPreferences.getLong("last_req", 0L);
    }

    public long getFirstActivateTime() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(mContext);
        long j4 = PreferenceWrapper.getDefault(mContext).getLong("first_activate_time", 0L);
        this.firstActivateTime = j4;
        if (j4 == 0) {
            this.firstActivateTime = System.currentTimeMillis();
            sharedPreferences.edit().putLong("first_activate_time", this.firstActivateTime).commit();
        }
        return this.firstActivateTime;
    }

    public long getLastReqTime() {
        return this.lastRequestTime;
    }

    public int getLastRequestLatency() {
        int i4 = this.mLastRequestLatency;
        if (i4 > 3600000) {
            return 3600000;
        }
        return i4;
    }

    public boolean isFirstRequest() {
        return this.mLastSuccessfulRequestTime == 0;
    }

    public void logFailedRequest() {
        this.mFailedRequest++;
    }

    public void logRequestEnd() {
        this.mLastRequestLatency = (int) (System.currentTimeMillis() - this.lastRequestTime);
    }

    public void logRequestStart() {
        this.lastRequestTime = System.currentTimeMillis();
    }

    public void logSuccessfulRequest(boolean z3) {
        this.mSuccessfulRequest++;
        if (z3) {
            this.mLastSuccessfulRequestTime = this.lastRequestTime;
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.b
    public void onRequestEnd() {
        logRequestEnd();
    }

    @Override // com.umeng.commonsdk.statistics.internal.b
    public void onRequestFailed() {
        logFailedRequest();
    }

    @Override // com.umeng.commonsdk.statistics.internal.b
    public void onRequestStart() {
        logRequestStart();
    }

    @Override // com.umeng.commonsdk.statistics.internal.b
    public void onRequestSucceed(boolean z3) {
        logSuccessfulRequest(z3);
    }

    public void saveSate() {
        PreferenceWrapper.getDefault(mContext).edit().putInt("successful_request", this.mSuccessfulRequest).putInt("failed_requests ", this.mFailedRequest).putInt("last_request_spent_ms", this.mLastRequestLatency).putLong("last_req", this.lastRequestTime).putLong("last_request_time", this.mLastSuccessfulRequestTime).commit();
    }

    private StatTracer() {
        this.MAX_REQUEST_LIMIT = 3600000;
        this.lastRequestTime = 0L;
        this.firstActivateTime = 0L;
        init();
    }
}
