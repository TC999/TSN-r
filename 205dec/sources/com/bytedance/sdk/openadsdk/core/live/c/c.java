package com.bytedance.sdk.openadsdk.core.live.c;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.yu;
import com.bytedance.sdk.openadsdk.core.u.fz;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ys;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements xv {

    /* renamed from: c  reason: collision with root package name */
    protected Bridge f33848c = null;

    /* renamed from: w  reason: collision with root package name */
    protected String f33849w;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a_(me meVar) {
        if (meVar == null) {
            return false;
        }
        return c(meVar.yw(), meVar.kp());
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(Bridge bridge) {
        if (bridge == null) {
            return;
        }
        this.f33848c = new com.bytedance.sdk.openadsdk.ys.c(bridge);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(String str, me meVar, long j4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long w(me meVar) {
        if (meVar == null) {
            return 0L;
        }
        String yw = meVar.yw();
        if (TextUtils.isEmpty(yw)) {
            yw = c(meVar.qu());
        }
        try {
            return Long.parseLong(yw);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public boolean c(String str, int i4) {
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i4) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    protected String c(ys ysVar) {
        Map<String, String> c4;
        if (ysVar != null) {
            String c5 = ysVar.c();
            if (TextUtils.isEmpty(c5)) {
                return null;
            }
            if ((c5.startsWith("snssdk2329") || c5.startsWith("snssdk1128")) && (c4 = yu.c(c5)) != null) {
                return c4.get("room_id");
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(me meVar, String str, Map map) {
        if (map == null) {
            return str;
        }
        try {
            String str2 = (String) map.get("dpa_tag");
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            String ux = fz.ux(meVar, str2);
            if (TextUtils.isEmpty(ux)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(ux);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.putOpt(next, jSONObject2.opt(next));
            }
            return jSONObject.toString();
        } catch (Exception e4) {
            a.xv("TTLiveSDkBridge", e4);
            com.bytedance.sdk.openadsdk.core.fz.a.c().c("getEcomLiveParams", e4);
            return str;
        }
    }
}
