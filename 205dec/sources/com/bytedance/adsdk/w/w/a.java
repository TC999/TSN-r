package com.bytedance.adsdk.w.w;

import com.bytedance.adsdk.w.c.w;
import com.bytedance.adsdk.w.w.xv.c.c;
import com.bytedance.adsdk.w.w.xv.c.d;
import com.bytedance.adsdk.w.w.xv.c.e;
import com.bytedance.adsdk.w.w.xv.c.f;
import com.bytedance.adsdk.w.w.xv.c.g;
import com.bytedance.adsdk.w.w.xv.c.h;
import com.bytedance.adsdk.w.w.xv.c.i;
import com.bytedance.adsdk.w.w.xv.c.j;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final s0.a f26416e;

    /* renamed from: a  reason: collision with root package name */
    private final s0.a f26417a;

    /* renamed from: b  reason: collision with root package name */
    private r0.a f26418b;

    /* renamed from: c  reason: collision with root package name */
    private Deque<r0.a> f26419c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    private String f26420d;

    /* renamed from: com.bytedance.adsdk.w.w.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class C0365a implements s0.a {
        C0365a() {
        }

        public int a(String str, int i4, Deque<r0.a> deque) {
            return i4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class b implements s0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f26421a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s0.a f26422b;

        b(c cVar, s0.a aVar) {
            this.f26421a = cVar;
            this.f26422b = aVar;
        }

        public int a(String str, int i4, Deque<r0.a> deque) {
            return this.f26421a.b(str, i4, deque, this.f26422b);
        }
    }

    static {
        int i4 = 8;
        c[] cVarArr = {new e(), new g(), new d(), new i(), new h(), new com.bytedance.adsdk.w.w.xv.c.a(), new f(), new j(), new com.bytedance.adsdk.w.w.xv.c.b()};
        s0.a c0365a = new C0365a();
        while (i4 > -1) {
            i4--;
            c0365a = new b(cVarArr[i4], c0365a);
        }
        f26416e = c0365a;
    }

    private a(String str, s0.a aVar) {
        this.f26417a = aVar;
        this.f26420d = str;
        try {
            d();
        } catch (Exception e4) {
            throw new w(str, e4);
        }
    }

    public static a a(String str) {
        return new a(str, f26416e);
    }

    private void d() {
        int length = this.f26420d.length();
        int i4 = 0;
        while (i4 < length) {
            int a4 = this.f26417a.a(this.f26420d, i4, this.f26419c);
            if (a4 == i4) {
                throw new IllegalArgumentException("\u65e0\u6cd5\u8bc6\u522b\u7684\u8868\u8fbe\u5f0f\uff0c\u89e3\u6790\u8fc7\u7a0b\u9884\u89c1\u65e0\u6cd5\u8bc6\u522b\u7684\u5b57\u7b26:" + this.f26420d.substring(0, i4));
            }
            i4 = a4;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            r0.a pollFirst = this.f26419c.pollFirst();
            if (pollFirst != null) {
                arrayList.add(0, pollFirst);
            } else {
                this.f26418b = com.bytedance.adsdk.w.w.ux.b.b(arrayList, this.f26420d, i4);
                this.f26419c = null;
                return;
            }
        }
    }

    public <T> T b(Map<String, JSONObject> map) {
        return (T) this.f26418b.c(map);
    }

    public <T> T c(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("default_key", jSONObject);
        return (T) b(hashMap);
    }
}
