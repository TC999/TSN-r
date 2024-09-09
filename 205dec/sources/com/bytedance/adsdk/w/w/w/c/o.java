package com.bytedance.adsdk.w.w.w.c;

import com.bytedance.adsdk.w.w.sr.xv;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class o extends j {

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f26462d = new a();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class a extends ThreadLocal<StringBuilder> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    }

    public o() {
        super(xv.PLUS);
    }

    public Object c(Map<String, JSONObject> map) {
        Object c4;
        Object c5 = this.f26454a.c(map);
        if (c5 == null || (c4 = this.f26455b.c(map)) == null) {
            return null;
        }
        if (!(c5 instanceof String) && !(c4 instanceof String)) {
            return q0.b.e((Number) c5, (Number) c4);
        }
        StringBuilder sb = f26462d.get();
        sb.append(c5);
        sb.append(c4);
        String sb2 = sb.toString();
        sb.setLength(0);
        return sb2;
    }
}
