package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, String> f51703a;

    public c(Bundle bundle) {
        this.f51703a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f51703a.put(str, bundle.getString(str));
            }
        }
    }

    public String toString() {
        return "BaseData{time=" + this.f51703a.get("time") + ", name=" + this.f51703a.get("interface_name") + '}';
    }

    public c(HashMap<String, String> hashMap) {
        this.f51703a = new HashMap<>(hashMap);
    }
}
