package com.qq.e.dl.h;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f46894a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f46895b;

    /* renamed from: c  reason: collision with root package name */
    public final String f46896c;

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f46897d;

    /* renamed from: e  reason: collision with root package name */
    public final JSONObject f46898e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, com.qq.e.dl.k.c> f46899f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46900g = false;

    public a(com.qq.e.dl.i.e eVar) {
        JSONObject jSONObject;
        this.f46894a = eVar.f46957a;
        String str = eVar.f46958b;
        if (!TextUtils.isEmpty(eVar.f46959c)) {
            try {
                jSONObject = new JSONObject(eVar.f46959c);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        this.f46895b = jSONObject;
        this.f46896c = eVar.f46961e;
        this.f46897d = eVar.f46962f;
        this.f46898e = eVar.f46963g;
        this.f46899f = eVar.f46960d;
    }

    public void a(String str, Object obj) {
        try {
            this.f46895b.putOpt(str, obj);
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || this.f46899f == null || jSONObject.length() <= 0 || this.f46899f.size() <= 0) {
            return;
        }
        for (Map.Entry<String, com.qq.e.dl.k.c> entry : this.f46899f.entrySet()) {
            Object c4 = (this.f46900g ? entry.getValue() : entry.getValue().a()).c(jSONObject);
            if (c4 != null) {
                a(entry.getKey(), c4);
            }
        }
        this.f46900g = true;
    }
}
