package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.NetworkUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdEventV3 extends AdEvent {

    /* renamed from: c */
    private static final SimpleDateFormat f620c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public AdEventV3(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    /* renamed from: b */
    public static AdEventV3 m59297b(Context context, AdEventModel adEventModel, JSONObject jSONObject) {
        return new AdEventV3(UUID.randomUUID().toString(), m59296d(context, adEventModel, jSONObject));
    }

    /* renamed from: d */
    private static JSONObject m59296d(Context context, AdEventModel adEventModel, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("event", adEventModel.f576a);
            jSONObject2.putOpt("nt", Integer.valueOf(NetworkUtils.m59169b(context)));
            jSONObject2.putOpt("datetime", f620c.format(new Date()));
            jSONObject2.putOpt("params", AdEvent.m59443a(context, adEventModel, jSONObject));
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEvent
    public String toString() {
        return "AdEventV3{localId='" + this.f560a + "', event=" + this.f561b + '}';
    }
}
