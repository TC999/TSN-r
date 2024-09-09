package com.iab.omid.library.mmadbridge.adsession;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Owner f37673a;

    /* renamed from: b  reason: collision with root package name */
    private final Owner f37674b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37675c;

    /* renamed from: d  reason: collision with root package name */
    private final CreativeType f37676d;

    /* renamed from: e  reason: collision with root package name */
    private final ImpressionType f37677e;

    private c(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z3) {
        this.f37676d = creativeType;
        this.f37677e = impressionType;
        this.f37673a = owner;
        if (owner2 == null) {
            this.f37674b = Owner.NONE;
        } else {
            this.f37674b = owner2;
        }
        this.f37675c = z3;
    }

    public static c a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z3) {
        com.iab.omid.library.mmadbridge.d.e.d(creativeType, "CreativeType is null");
        com.iab.omid.library.mmadbridge.d.e.d(impressionType, "ImpressionType is null");
        com.iab.omid.library.mmadbridge.d.e.d(owner, "Impression owner is null");
        com.iab.omid.library.mmadbridge.d.e.b(owner, creativeType, impressionType);
        return new c(creativeType, impressionType, owner, owner2, z3);
    }

    public boolean b() {
        return Owner.NATIVE == this.f37673a;
    }

    public boolean c() {
        return Owner.NATIVE == this.f37674b;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "impressionOwner", this.f37673a);
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "mediaEventsOwner", this.f37674b);
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "creativeType", this.f37676d);
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "impressionType", this.f37677e);
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f37675c));
        return jSONObject;
    }
}
