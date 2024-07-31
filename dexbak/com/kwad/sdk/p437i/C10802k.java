package com.kwad.sdk.p437i;

import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.i.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10802k implements InterfaceC10788b {
    public JSONObject aJt = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    public C10802k(String str, String str2, C10799i c10799i) {
        JSONObject m24859IY = C10796h.m24844Jc().m24840Jg().m24859IY();
        Iterator<String> keys = m24859IY.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            C10789c.m24866a(m24859IY, next, m24859IY.opt(next));
        }
        C10789c.putValue(this.aJt, "customKey", str);
        C10789c.putValue(this.aJt, "customValue", str2);
        C10789c.putValue(this.aJt, CampaignEx.JSON_KEY_TIMESTAMP, c10799i.aJq);
        C10789c.putValue(this.aJt, "actionId", this.actionId);
    }

    @Override // com.kwad.sdk.p437i.InterfaceC10788b
    public final JSONObject toJson() {
        return this.aJt;
    }

    @NonNull
    public final String toString() {
        return this.aJt.toString();
    }
}
