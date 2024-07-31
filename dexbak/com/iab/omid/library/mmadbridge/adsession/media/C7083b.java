package com.iab.omid.library.mmadbridge.adsession.media;

import com.iab.omid.library.mmadbridge.p204d.C7103c;
import com.iab.omid.library.mmadbridge.p204d.C7105e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.media.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7083b {

    /* renamed from: a */
    private final boolean f24222a;

    /* renamed from: b */
    private final Float f24223b;

    /* renamed from: c */
    private final boolean f24224c;

    /* renamed from: d */
    private final Position f24225d;

    private C7083b(boolean z, Float f, boolean z2, Position position) {
        this.f24222a = z;
        this.f24223b = f;
        this.f24224c = z2;
        this.f24225d = position;
    }

    /* renamed from: b */
    public static C7083b m34764b(boolean z, Position position) {
        C7105e.m34671d(position, "Position is null");
        return new C7083b(false, null, z, position);
    }

    /* renamed from: c */
    public static C7083b m34763c(float f, boolean z, Position position) {
        C7105e.m34671d(position, "Position is null");
        return new C7083b(true, Float.valueOf(f), z, position);
    }

    /* renamed from: a */
    public JSONObject m34765a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f24222a);
            if (this.f24222a) {
                jSONObject.put("skipOffset", this.f24223b);
            }
            jSONObject.put("autoPlay", this.f24224c);
            jSONObject.put("position", this.f24225d);
        } catch (JSONException e) {
            C7103c.m34676b("VastProperties: JSON error", e);
        }
        return jSONObject;
    }

    /* renamed from: d */
    public Position m34762d() {
        return this.f24225d;
    }

    /* renamed from: e */
    public Float m34761e() {
        return this.f24223b;
    }

    /* renamed from: f */
    public boolean m34760f() {
        return this.f24224c;
    }

    /* renamed from: g */
    public boolean m34759g() {
        return this.f24222a;
    }
}
