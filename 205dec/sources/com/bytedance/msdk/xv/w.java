package com.bytedance.msdk.xv;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f28581c;

    /* renamed from: w  reason: collision with root package name */
    private List<c> f28582w = new CopyOnWriteArrayList();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private sr f28583c;

        /* renamed from: w  reason: collision with root package name */
        private JSONObject f28584w;

        public c(sr srVar, JSONObject jSONObject) {
            this.f28583c = srVar;
            this.f28584w = jSONObject;
        }

        public sr c() {
            return this.f28583c;
        }

        public JSONObject w() {
            return this.f28584w;
        }
    }

    private w() {
    }

    public static w c() {
        if (f28581c == null) {
            synchronized (w.class) {
                if (f28581c == null) {
                    f28581c = new w();
                }
            }
        }
        return f28581c;
    }

    public List<c> w() {
        return this.f28582w;
    }

    public void xv() {
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u6e05\u7a7a\u57cb\u70b9\u8f85\u52a9\u6a21\u5757");
        List<c> list = this.f28582w;
        if (list != null) {
            list.clear();
        }
    }

    public void c(sr srVar, JSONObject jSONObject) {
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u4fdd\u5b58\u5230\u57cb\u70b9\u8f85\u52a9\u6a21\u5757");
        this.f28582w.add(new c(srVar, jSONObject));
    }
}
