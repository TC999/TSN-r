package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;

/* renamed from: com.kwad.sdk.core.report.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10469q extends AbstractC10452d {
    private static volatile C10469q ayU;
    private InterfaceC10467o ayV;

    private C10469q(Context context) {
        super(new C10468p(context, C10468p.f29574IP));
        this.ayV = new C10459i();
    }

    /* renamed from: bf */
    public static C10469q m26011bf(Context context) {
        if (ayU == null) {
            synchronized (C10469q.class) {
                if (ayU == null) {
                    ayU = new C10469q(context);
                }
            }
        }
        return ayU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.AbstractC10452d
    /* renamed from: h */
    public synchronized C10464n mo25062g(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24305yS()) {
            return this.ayV.mo26012Z(string2, string);
        }
        return this.ayV.mo26012Z(string2, string);
    }

    @Override // com.kwad.sdk.core.report.AbstractC10452d
    /* renamed from: EG */
    protected final String mo25065EG() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.AbstractC10452d
    /* renamed from: EH */
    protected final String mo25064EH() {
        return "select aLog, actionId from " + mo25065EG();
    }

    @Override // com.kwad.sdk.core.report.AbstractC10452d
    protected final String getTag() {
        return "ReportActionDBManager";
    }
}
