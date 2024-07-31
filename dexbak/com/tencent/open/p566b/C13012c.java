package com.tencent.open.p566b;

import android.os.Bundle;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13012c implements Serializable {

    /* renamed from: a */
    public final HashMap<String, String> f37303a;

    public C13012c(Bundle bundle) {
        this.f37303a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f37303a.put(str, bundle.getString(str));
            }
        }
    }

    public String toString() {
        return "BaseData{time=" + this.f37303a.get(RtspHeaders.Values.TIME) + ", name=" + this.f37303a.get("interface_name") + '}';
    }

    public C13012c(HashMap<String, String> hashMap) {
        this.f37303a = new HashMap<>(hashMap);
    }
}
