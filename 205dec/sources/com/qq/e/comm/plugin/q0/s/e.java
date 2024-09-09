package com.qq.e.comm.plugin.q0.s;

import com.qq.e.comm.plugin.util.d1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f45544a;

    /* renamed from: b  reason: collision with root package name */
    private String f45545b;

    /* renamed from: c  reason: collision with root package name */
    private a f45546c;

    /* renamed from: d  reason: collision with root package name */
    private int f45547d;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        public static final a f45548c = new a("OK", 0);

        /* renamed from: d  reason: collision with root package name */
        public static final a f45549d = new a("ERROR", 1);

        /* renamed from: e  reason: collision with root package name */
        public static final a f45550e = new a("HANDLER_NOT_FOUND_EXCEPTION", 2);

        /* renamed from: f  reason: collision with root package name */
        public static final a f45551f = new a("JSON_PARSE_EXCEPTION", 3);

        private a(String str, int i4) {
        }
    }

    public e(d dVar, a aVar, String str) {
        this.f45547d = 0;
        this.f45544a = dVar.b();
        this.f45546c = aVar;
        this.f45545b = str;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callbackid", this.f45544a);
            jSONObject.put("status", this.f45546c.ordinal());
            jSONObject.put("data", this.f45545b);
            jSONObject.put("keep", this.f45547d);
        } catch (JSONException e4) {
            d1.a("Exception while sendingJSResponse", e4);
        }
        return "bridge.callback(" + jSONObject.toString() + ");";
    }

    public e(d dVar, a aVar, String str, int i4) {
        this(dVar, aVar, str);
        this.f45547d = i4;
    }

    public e(d dVar, a aVar, JSONObject jSONObject) {
        this(dVar, aVar, jSONObject != null ? jSONObject.toString() : "");
    }

    public e(d dVar, a aVar, JSONObject jSONObject, int i4) {
        this(dVar, aVar, jSONObject != null ? jSONObject.toString() : "");
        this.f45547d = i4;
    }
}
