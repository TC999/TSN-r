package com.kwad.components.p208ad.reward.p260l;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.utils.C11126t;
import java.util.Observable;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.l.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8008b extends Observable implements InterfaceC8013c, InterfaceC9914b {

    /* renamed from: xC */
    private boolean f26714xC = false;

    /* renamed from: xD */
    protected String f26715xD;

    /* renamed from: xE */
    protected String f26716xE;

    /* renamed from: jw */
    private boolean m31880jw() {
        return this.f26714xC;
    }

    /* renamed from: jx */
    private void m31879jx() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.f26714xC));
    }

    public boolean isCompleted() {
        return m31880jw();
    }

    /* renamed from: js */
    public final void m31882js() {
        if (this.f26714xC) {
            return;
        }
        this.f26714xC = true;
        m31879jx();
    }

    /* renamed from: jt */
    public final void m31881jt() {
        if (this.f26714xC) {
            this.f26714xC = false;
            m31879jx();
        }
    }

    @Override // com.kwad.components.p208ad.reward.p260l.InterfaceC8013c
    /* renamed from: ju */
    public final String mo31868ju() {
        return this.f26715xD;
    }

    @Override // com.kwad.components.p208ad.reward.p260l.InterfaceC8013c
    /* renamed from: jv */
    public final String mo31867jv() {
        return this.f26716xE;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f26714xC = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "selfCompleted", this.f26714xC);
        return jSONObject;
    }
}
