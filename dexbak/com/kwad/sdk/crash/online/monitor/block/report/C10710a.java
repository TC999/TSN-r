package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.AbstractC10452d;
import com.kwad.sdk.crash.online.monitor.block.p429a.C10701a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.online.monitor.block.report.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10710a extends AbstractC10452d {

    /* renamed from: IP */
    public static int f29658IP = 1;
    private static volatile C10710a aGN;

    private C10710a(Context context) {
        super(new C10701a(context, f29658IP));
    }

    /* renamed from: bw */
    public static C10710a m25063bw(Context context) {
        if (aGN == null) {
            synchronized (C10710a.class) {
                if (aGN == null) {
                    aGN = new C10710a(context);
                }
            }
        }
        return aGN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.AbstractC10452d
    /* renamed from: j */
    public synchronized BlockReportAction mo25062g(@NonNull Cursor cursor) {
        try {
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
            return new BlockReportAction("");
        }
        return new BlockReportAction(new JSONObject(cursor.getString(0)));
    }

    @Override // com.kwad.sdk.core.report.AbstractC10452d
    /* renamed from: EG */
    public final String mo25065EG() {
        return "ksad_block_actions";
    }

    @Override // com.kwad.sdk.core.report.AbstractC10452d
    /* renamed from: EH */
    public final String mo25064EH() {
        return "select aLog from " + mo25065EG();
    }

    @Override // com.kwad.sdk.core.report.AbstractC10452d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }
}
