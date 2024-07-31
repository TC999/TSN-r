package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.adclient.kscommerciallogger.model.C11162c;
import com.kwai.adclient.kscommerciallogger.p453a.InterfaceC11157a;
import com.kwai.adclient.kscommerciallogger.p453a.InterfaceC11158b;
import org.json.JSONObject;

/* renamed from: com.kwai.adclient.kscommerciallogger.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11155a {
    private InterfaceC11157a aTv;
    private InterfaceC11158b aTw;
    private JSONObject aTx;
    private boolean aTy;
    private boolean isDebug;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C11156a {
        private static C11155a aTz;

        /* renamed from: Oe */
        public static C11155a m23519Oe() {
            if (aTz == null) {
                aTz = new C11155a((byte) 0);
            }
            return aTz;
        }
    }

    /* synthetic */ C11155a(byte b) {
        this();
    }

    /* renamed from: Oe */
    public static C11155a m23525Oe() {
        return C11156a.m23519Oe();
    }

    /* renamed from: b */
    private void m23520b(@NonNull C11162c c11162c) {
        if (this.aTv != null) {
            if (c11162c.m23514Oi() != null) {
                String str = c11162c.m23514Oi().value;
            }
            if (c11162c.m23513Oj() != null) {
                c11162c.m23513Oj().getValue();
            }
            c11162c.m23510Om();
            C11159b.m23516z(c11162c.m23512Ok());
            C11159b.m23516z(c11162c.m23511Ol());
        }
    }

    /* renamed from: Of */
    public final JSONObject m23524Of() {
        return this.aTx;
    }

    /* renamed from: Og */
    public final boolean m23523Og() {
        return this.aTy;
    }

    /* renamed from: a */
    public final void m23522a(@NonNull InterfaceC11157a interfaceC11157a, @NonNull InterfaceC11158b interfaceC11158b, @Nullable JSONObject jSONObject, boolean z, boolean z2) {
        this.aTv = interfaceC11157a;
        this.aTw = interfaceC11158b;
        this.aTx = jSONObject;
        this.isDebug = z;
        this.aTy = z2;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    private C11155a() {
        this.isDebug = false;
        this.aTy = false;
    }

    /* renamed from: a */
    public final void m23521a(C11162c c11162c) {
        if (c11162c == null) {
            return;
        }
        m23520b(c11162c);
        InterfaceC11158b interfaceC11158b = this.aTw;
        if (interfaceC11158b != null) {
            interfaceC11158b.mo23518L(c11162c.m23515Oh(), c11162c.toString());
        }
    }
}
