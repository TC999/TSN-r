package com.bykv.vk.component.ttvideo.mediakit.net;

import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.ia;
import com.bytedance.sdk.component.w.c.p;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.component.w.c.w;
import com.bytedance.sdk.component.w.c.xv;
import com.bytedance.sdk.component.w.c.ys;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final p JSON = p.c("application/json");
    private static a mClient;
    private w mCall;

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        w wVar = this.mCall;
        if (wVar == null || wVar.xv()) {
            return;
        }
        this.mCall.w();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                a.c w3 = new a().w();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                mClient = w3.c(10L, timeUnit).xv(10L, timeUnit).w(10L, timeUnit).c();
            }
        }
        t.c c4 = new t.c().c(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                c4.c(str2, map.get(str2));
            }
        }
        w c5 = mClient.c(c4.w());
        this.mCall = c5;
        c5.c(new xv() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.bytedance.sdk.component.w.c.xv
            public void onFailure(w wVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.w.c.xv
            public void onResponse(w wVar, fp fpVar) {
                ia iaVar;
                Throwable th;
                JSONObject jSONObject;
                try {
                    iaVar = fpVar.f();
                } catch (Throwable th2) {
                    iaVar = null;
                    th = th2;
                }
                try {
                    try {
                        jSONObject = new JSONObject(iaVar.w());
                        e = null;
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        jSONObject = null;
                    }
                    if (e == null && !fpVar.sr()) {
                        e = new Exception("http fail");
                        fpVar.xv();
                    }
                    if (iaVar != null) {
                        try {
                            iaVar.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (iaVar != null) {
                        try {
                            iaVar.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i4, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                a.c w3 = new a().w();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                mClient = w3.c(10L, timeUnit).xv(10L, timeUnit).w(10L, timeUnit).c();
            }
        }
        t.c c4 = new t.c().c(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                c4.w(str2, map.get(str2));
            }
        }
        if (i4 == 1) {
            c4.c(ys.c(JSON, String.valueOf(jSONObject)));
        }
        w c5 = mClient.c(c4.w());
        this.mCall = c5;
        c5.c(new xv() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.bytedance.sdk.component.w.c.xv
            public void onFailure(w wVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.w.c.xv
            public void onResponse(w wVar, fp fpVar) throws IOException {
                ia iaVar;
                Throwable th;
                String exc;
                JSONObject jSONObject2;
                try {
                    iaVar = fpVar.f();
                } catch (Throwable th2) {
                    iaVar = null;
                    th = th2;
                }
                try {
                    try {
                        jSONObject2 = new JSONObject(iaVar.w());
                        exc = null;
                    } catch (Exception e4) {
                        exc = e4.toString();
                        e4.printStackTrace();
                        jSONObject2 = null;
                    }
                    if (!fpVar.sr()) {
                        exc = fpVar.ux();
                        fpVar.xv();
                    }
                    if (iaVar != null) {
                        try {
                            iaVar.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (exc == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, exc));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (iaVar != null) {
                        try {
                            iaVar.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        });
    }
}
