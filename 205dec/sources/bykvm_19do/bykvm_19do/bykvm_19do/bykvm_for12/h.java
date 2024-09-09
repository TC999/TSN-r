package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.n;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: AdEventV3.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    private static final SimpleDateFormat f613c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public h(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    public static h b(Context context, d dVar, JSONObject jSONObject) {
        return new h(UUID.randomUUID().toString(), d(context, dVar, jSONObject));
    }

    private static JSONObject d(Context context, d dVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("event", dVar.f569a);
            jSONObject2.putOpt("nt", Integer.valueOf(n.b(context)));
            jSONObject2.putOpt("datetime", f613c.format(new Date()));
            jSONObject2.putOpt(EventMonitor.V3_PARAMS, a.a(context, dVar, jSONObject));
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a
    public String toString() {
        return "AdEventV3{localId='" + this.f553a + "', event=" + this.f554b + '}';
    }
}
