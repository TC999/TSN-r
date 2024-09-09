package com.bytedance.sdk.openadsdk.core.ls;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class r implements EventListener {
    private void c(Result result) {
        if (result != null) {
            try {
                ValueSet values = result.values();
                if (values != null) {
                    String stringValue = values.stringValue(6);
                    JSONObject jSONObject = (JSONObject) values.objectValue(7, JSONObject.class);
                    jSONObject.put("label", stringValue);
                    com.bytedance.sdk.component.r.w.sr.c.c cVar = new com.bytedance.sdk.component.r.w.sr.c.c(UUID.randomUUID().toString(), jSONObject);
                    cVar.c((byte) 0);
                    cVar.w((byte) 2);
                    com.bytedance.sdk.component.r.w.c.c(cVar, "csj");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ValueSet c(int i4, Result result) {
        return null;
    }

    protected ValueSet c(int i4, ev evVar) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ValueSet c(int i4, sr srVar) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i4, Result result) {
        com.bytedance.sdk.component.utils.a.w("pitaya_ext_plugin", "listenerType:" + i4);
        if (i4 != 1) {
            if (i4 != 6) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        switch (i4) {
                            case 8:
                                return c(i4, new ev(result, i4));
                            case 9:
                                return c(i4, result);
                            case 10:
                                c(result);
                                return null;
                            default:
                                return null;
                        }
                    }
                    return w(i4);
                }
                return w(i4, result);
            }
            return c(i4, new sr(result, i4));
        }
        return c(i4);
    }

    public ValueSet w(int i4) {
        return b.a().i(32, String.valueOf(wv.ux())).l();
    }

    public ValueSet w(int i4, Result result) {
        JSONObject b4 = ls.w().b();
        if (b4 != null) {
            return b.a().h(33, b4).l();
        }
        return null;
    }

    public ValueSet c(int i4) {
        return b.a().i(31, i.xv()).l();
    }
}
