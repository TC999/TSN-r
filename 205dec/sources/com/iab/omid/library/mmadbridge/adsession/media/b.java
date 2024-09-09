package com.iab.omid.library.mmadbridge.adsession.media;

import com.iab.omid.library.mmadbridge.d.c;
import com.iab.omid.library.mmadbridge.d.e;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f37704a;

    /* renamed from: b  reason: collision with root package name */
    private final Float f37705b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37706c;

    /* renamed from: d  reason: collision with root package name */
    private final Position f37707d;

    private b(boolean z3, Float f4, boolean z4, Position position) {
        this.f37704a = z3;
        this.f37705b = f4;
        this.f37706c = z4;
        this.f37707d = position;
    }

    public static b b(boolean z3, Position position) {
        e.d(position, "Position is null");
        return new b(false, null, z3, position);
    }

    public static b c(float f4, boolean z3, Position position) {
        e.d(position, "Position is null");
        return new b(true, Float.valueOf(f4), z3, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f37704a);
            if (this.f37704a) {
                jSONObject.put("skipOffset", this.f37705b);
            }
            jSONObject.put("autoPlay", this.f37706c);
            jSONObject.put("position", this.f37707d);
        } catch (JSONException e4) {
            c.b("VastProperties: JSON error", e4);
        }
        return jSONObject;
    }

    public Position d() {
        return this.f37707d;
    }

    public Float e() {
        return this.f37705b;
    }

    public boolean f() {
        return this.f37706c;
    }

    public boolean g() {
        return this.f37704a;
    }
}
