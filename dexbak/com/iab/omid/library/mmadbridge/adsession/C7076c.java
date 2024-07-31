package com.iab.omid.library.mmadbridge.adsession;

import com.iab.omid.library.mmadbridge.p204d.C7101b;
import com.iab.omid.library.mmadbridge.p204d.C7105e;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7076c {

    /* renamed from: a */
    private final Owner f24191a;

    /* renamed from: b */
    private final Owner f24192b;

    /* renamed from: c */
    private final boolean f24193c;

    /* renamed from: d */
    private final CreativeType f24194d;

    /* renamed from: e */
    private final ImpressionType f24195e;

    private C7076c(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        this.f24194d = creativeType;
        this.f24195e = impressionType;
        this.f24191a = owner;
        if (owner2 == null) {
            this.f24192b = Owner.NONE;
        } else {
            this.f24192b = owner2;
        }
        this.f24193c = z;
    }

    /* renamed from: a */
    public static C7076c m34834a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        C7105e.m34671d(creativeType, "CreativeType is null");
        C7105e.m34671d(impressionType, "ImpressionType is null");
        C7105e.m34671d(owner, "Impression owner is null");
        C7105e.m34673b(owner, creativeType, impressionType);
        return new C7076c(creativeType, impressionType, owner, owner2, z);
    }

    /* renamed from: b */
    public boolean m34833b() {
        return Owner.NATIVE == this.f24191a;
    }

    /* renamed from: c */
    public boolean m34832c() {
        return Owner.NATIVE == this.f24192b;
    }

    /* renamed from: d */
    public JSONObject m34831d() {
        JSONObject jSONObject = new JSONObject();
        C7101b.m34688h(jSONObject, "impressionOwner", this.f24191a);
        C7101b.m34688h(jSONObject, "mediaEventsOwner", this.f24192b);
        C7101b.m34688h(jSONObject, "creativeType", this.f24194d);
        C7101b.m34688h(jSONObject, "impressionType", this.f24195e);
        C7101b.m34688h(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f24193c));
        return jSONObject;
    }
}
