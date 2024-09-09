package com.bytedance.msdk.ux.ux;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.ux.f;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements com.bytedance.msdk.ux.xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f28458c;
    private int xv = -1;
    private long sr = -1;
    private int ux = -1;

    /* renamed from: w  reason: collision with root package name */
    private wv f28459w = f.w();

    private xv() {
    }

    public static xv c() {
        if (f28458c == null) {
            synchronized (xv.class) {
                if (f28458c == null) {
                    f28458c = new xv();
                }
            }
        }
        return f28458c;
    }

    private synchronized JSONObject w() {
        String w3 = this.f28459w.w("app_common_config");
        if (TextUtils.isEmpty(w3)) {
            return null;
        }
        if (!w3.startsWith("[") && !w3.startsWith("{")) {
            w3 = com.bytedance.msdk.f.c.w(w3, com.bytedance.msdk.f.w.c());
        }
        if (TextUtils.isEmpty(w3)) {
            return new JSONObject(w3);
        }
        return null;
    }

    @Override // com.bytedance.msdk.ux.xv
    public int f() {
        JSONObject w3;
        int i4 = this.ux;
        if (i4 == -1) {
            if (this.f28459w == null || (w3 = w()) == null) {
                return 0;
            }
            c(w3);
            return this.ux;
        }
        return i4;
    }

    @Override // com.bytedance.msdk.ux.xv
    public synchronized int sr() {
        JSONObject w3;
        int i4 = this.xv;
        if (i4 == -1) {
            if (this.f28459w == null || (w3 = w()) == null) {
                return 100;
            }
            c(w3);
            return this.xv;
        }
        return i4;
    }

    @Override // com.bytedance.msdk.ux.xv
    public synchronized long ux() {
        JSONObject w3;
        long j4 = this.sr;
        if (j4 == -1) {
            if (this.f28459w == null || (w3 = w()) == null) {
                return PolicyConfig.THREAD_BLOCK_TIMEOUT;
            }
            c(w3);
            return this.sr;
        }
        return j4;
    }

    private synchronized void c(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("event_batch_size", 100);
        this.xv = optInt;
        if (optInt <= 0 || optInt > 1000) {
            this.xv = 100;
        }
        long optLong = jSONObject.optLong("event_routine_interval", PolicyConfig.THREAD_BLOCK_TIMEOUT);
        this.sr = optLong;
        if (optLong < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || optLong > 300000) {
            this.sr = PolicyConfig.THREAD_BLOCK_TIMEOUT;
        }
        int optInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
        this.ux = optInt2;
        if (optInt2 != 0 && optInt2 != 1) {
            this.ux = 0;
        }
        com.bytedance.msdk.core.ux.w.w.c().c(jSONObject.optInt("pre_fetch_count", 20));
    }

    @Override // com.bytedance.msdk.ux.xv
    public synchronized void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            c(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                this.f28459w.c("app_common_config", jSONObject2);
            }
        }
    }
}
