package com.qq.e.dl.l.j;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f47120a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47121b;

    /* renamed from: c  reason: collision with root package name */
    public final JSONObject f47122c;

    /* renamed from: d  reason: collision with root package name */
    public final String f47123d;

    /* renamed from: e  reason: collision with root package name */
    public final String f47124e;

    /* renamed from: f  reason: collision with root package name */
    public final JSONObject f47125f;

    /* renamed from: g  reason: collision with root package name */
    public final JSONObject f47126g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f47127h;

    /* renamed from: i  reason: collision with root package name */
    public final String f47128i;

    /* renamed from: j  reason: collision with root package name */
    public final String f47129j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, com.qq.e.dl.k.c> f47130k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f47131l;

    /* renamed from: m  reason: collision with root package name */
    private int f47132m;

    public c(int i4, String str) {
        this.f47131l = false;
        this.f47132m = 0;
        this.f47120a = i4;
        this.f47121b = str;
        this.f47123d = null;
        this.f47122c = new JSONObject();
        this.f47130k = null;
        this.f47124e = null;
        this.f47125f = null;
        this.f47126g = null;
        this.f47127h = false;
        this.f47128i = null;
        this.f47129j = null;
    }

    public void a(String str, Object obj) {
        try {
            this.f47122c.putOpt(str, obj);
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || this.f47130k == null || jSONObject.length() <= 0 || this.f47130k.size() <= 0) {
            return;
        }
        for (Map.Entry<String, com.qq.e.dl.k.c> entry : this.f47130k.entrySet()) {
            Object c4 = (this.f47131l ? entry.getValue() : entry.getValue().a()).c(jSONObject);
            if (c4 != null) {
                a(entry.getKey(), c4);
            }
        }
        this.f47131l = true;
    }

    public int a() {
        return this.f47132m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4) {
        this.f47132m = i4;
    }

    public c(com.qq.e.dl.i.c cVar) {
        JSONObject jSONObject;
        this.f47131l = false;
        this.f47132m = 0;
        this.f47120a = cVar.f46934a;
        this.f47121b = cVar.f46935b;
        this.f47123d = cVar.f46936c;
        if (!TextUtils.isEmpty(cVar.f46937d)) {
            try {
                jSONObject = new JSONObject(cVar.f46937d);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        this.f47122c = jSONObject;
        this.f47130k = cVar.f46938e;
        this.f47124e = cVar.f46939f;
        this.f47125f = cVar.f46940g;
        this.f47126g = cVar.f46941h;
        this.f47127h = cVar.f46942i;
        this.f47128i = cVar.f46943j;
        this.f47129j = cVar.f46944k;
    }
}
