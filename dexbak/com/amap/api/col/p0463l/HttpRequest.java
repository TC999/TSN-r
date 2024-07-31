package com.amap.api.col.p0463l;

import com.clj.fastble.BleManager;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.n9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HttpRequest {

    /* renamed from: a */
    public String f4758a;

    /* renamed from: d */
    public byte[] f4761d;

    /* renamed from: b */
    public Map<String, String> f4759b = new HashMap();

    /* renamed from: c */
    boolean f4760c = true;

    /* renamed from: e */
    public int f4762e = BleManager.f22896l;

    /* renamed from: a */
    public static String m54421a() {
        return "lc_" + ((int) HeaderConfig.m54625a());
    }

    /* renamed from: b */
    public static String m54420b() {
        return HeaderConfig.m54619g() + "*" + HeaderConfig.m54613m();
    }
}
