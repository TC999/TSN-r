package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class q extends d {
    private static volatile q ayU;
    private o ayV;

    private q(Context context) {
        super(new p(context, p.IP));
        this.ayV = new i();
    }

    public static q bf(Context context) {
        if (ayU == null) {
            synchronized (q.class) {
                if (ayU == null) {
                    ayU = new q(context);
                }
            }
        }
        return ayU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: h */
    public synchronized n g(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yS()) {
            return this.ayV.Z(string2, string);
        }
        return this.ayV.Z(string2, string);
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String EG() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String EH() {
        return "select aLog, actionId from " + EG();
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String getTag() {
        return "ReportActionDBManager";
    }
}
