package com.bytedance.sdk.openadsdk.core.live.w;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.n;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.live.c.f;
import com.bytedance.sdk.openadsdk.core.live.xv;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    final f f33858c;

    public c(f fVar) {
        this.f33858c = fVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r1.equals("getBiddingToken") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object c(com.bykv.vk.openvk.api.proto.ValueSet r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r6.stringValue(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            if (r2 == 0) goto Ld
            return r3
        Ld:
            r1.hashCode()
            r2 = -1
            int r4 = r1.hashCode()
            switch(r4) {
                case -955478604: goto L30;
                case 1186389324: goto L25;
                case 1388496268: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = -1
            goto L39
        L1a:
            java.lang.String r0 = "onAuthCallback"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L23
            goto L18
        L23:
            r0 = 2
            goto L39
        L25:
            java.lang.String r0 = "getPanglePluginVersion"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2e
            goto L18
        L2e:
            r0 = 1
            goto L39
        L30:
            java.lang.String r4 = "getBiddingToken"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L39
            goto L18
        L39:
            switch(r0) {
                case 0: goto L48;
                case 1: goto L41;
                case 2: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L40
        L3d:
            r5.xv(r6)
        L40:
            return r3
        L41:
            r6 = 6106(0x17da, float:8.556E-42)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        L48:
            java.lang.Object r6 = r5.w(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.w.c.c(com.bykv.vk.openvk.api.proto.ValueSet):java.lang.Object");
    }

    private Integer sr(ValueSet valueSet) {
        String livePluginVersion = TTLiveCommerceHelper.getInstance().getLivePluginVersion();
        if (livePluginVersion == null) {
            return null;
        }
        if (livePluginVersion.replaceAll(".", "").startsWith("2112")) {
            Object[] arrayValue = valueSet.arrayValue(1, Object[].class);
            if (arrayValue == null || arrayValue.length == 0) {
                return null;
            }
            return (Integer) arrayValue[0];
        }
        Map map = (Map) valueSet.objectValue(1, Map.class);
        if (map == null || map.size() == 0) {
            return null;
        }
        return Integer.valueOf((String) map.get("adType"));
    }

    private Object w(ValueSet valueSet) {
        try {
            Integer sr = sr(valueSet);
            if (sr == null) {
                return null;
            }
            return ls.c().c(n.c(sr.intValue()));
        } catch (Throwable th) {
            a.sr("TTLiveSDkBridge", "invokeGetBiddingToken failed:" + th.getMessage());
            return null;
        }
    }

    private void xv(ValueSet valueSet) {
        try {
            Map map = (Map) valueSet.objectValue(1, Map.class);
            this.f33858c.c(Integer.valueOf((String) map.get("is_auth")).intValue() != 0, (String) map.get("open_uid"));
        } catch (Exception e4) {
            a.xv("LiveServiceBridge", e4);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (valueSet == null) {
            return null;
        }
        if (i4 != 0) {
            if (i4 == 1) {
                new xv().logEvent(valueSet.booleanValue(0), valueSet.stringValue(1), valueSet.stringValue(2), (Map) valueSet.objectValue(3, Map.class));
            } else if (i4 == 2) {
                this.f33858c.c(valueSet.intValue(0), valueSet.stringValue(1));
            } else if (i4 == 3) {
                int intValue = valueSet.intValue(0);
                if (1000 == intValue) {
                    this.f33858c.c(1, (String) null);
                    this.f33858c.c();
                } else if (1001 == intValue) {
                    this.f33858c.c(-2, valueSet.stringValue(1));
                }
            }
            return null;
        }
        return (T) c(valueSet);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
