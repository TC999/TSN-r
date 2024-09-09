package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.core.u.ok;
import com.bytedance.sdk.openadsdk.core.z;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ck<T> {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(boolean z3, long j4, long j5);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface sr {
        void c(int i4, String str);

        void c(z.xv xvVar);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface ux {
        void c(int i4, String str);

        void c(z.sr srVar);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar);

        void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface xv<T> {
        void c(int i4, String str);

        void c(T t3);
    }

    com.bytedance.sdk.component.adexpress.c.xv.c c(int i4);

    com.bytedance.sdk.openadsdk.core.u.xv c(com.bytedance.sdk.openadsdk.core.u.me meVar, String str);

    String c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar);

    String c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, boolean z3, int i4);

    void c(long j4, xv xvVar);

    void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, List<com.bytedance.sdk.openadsdk.ys.w.w.f> list);

    void c(com.bytedance.sdk.openadsdk.core.u.me meVar, JSONObject jSONObject);

    void c(ok okVar, String str, String str2, xv xvVar, int i4, long j4);

    void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4, w wVar2);

    void c(String str);

    void c(String str, String str2, c cVar);

    void c(JSONObject jSONObject, sr srVar);

    void c(JSONObject jSONObject, ux uxVar);

    void c(JSONObject jSONObject, xv<com.bytedance.sdk.component.ev.w> xvVar);

    void w(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4, w wVar2);

    void xv(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4, w wVar2);
}
