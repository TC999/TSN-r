package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a aTv;
    private com.kwai.adclient.kscommerciallogger.a.b aTw;
    private JSONObject aTx;
    private boolean aTy;
    private boolean isDebug;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class C0725a {
        private static a aTz;

        public static a Oe() {
            if (aTz == null) {
                aTz = new a((byte) 0);
            }
            return aTz;
        }
    }

    /* synthetic */ a(byte b4) {
        this();
    }

    public static a Oe() {
        return C0725a.Oe();
    }

    private void b(@NonNull c cVar) {
        if (this.aTv != null) {
            if (cVar.Oi() != null) {
                String str = cVar.Oi().value;
            }
            if (cVar.Oj() != null) {
                cVar.Oj().getValue();
            }
            cVar.Om();
            b.z(cVar.Ok());
            b.z(cVar.Ol());
        }
    }

    public final JSONObject Of() {
        return this.aTx;
    }

    public final boolean Og() {
        return this.aTy;
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.a.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.a.b bVar, @Nullable JSONObject jSONObject, boolean z3, boolean z4) {
        this.aTv = aVar;
        this.aTw = bVar;
        this.aTx = jSONObject;
        this.isDebug = z3;
        this.aTy = z4;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    private a() {
        this.isDebug = false;
        this.aTy = false;
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.aTw;
        if (bVar != null) {
            bVar.L(cVar.Oh(), cVar.toString());
        }
    }
}
