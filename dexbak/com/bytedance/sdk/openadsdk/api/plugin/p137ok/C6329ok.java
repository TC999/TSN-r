package com.bytedance.sdk.openadsdk.api.plugin.p137ok;

import android.text.TextUtils;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.clj.fastble.BleManager;

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6329ok implements Bridge {

    /* renamed from: ok */
    private static volatile C6329ok f22453ok;

    /* renamed from: ok */
    public static C6329ok m36578ok() {
        if (f22453ok == null) {
            synchronized (C6329ok.class) {
                if (f22453ok == null) {
                    f22453ok = new C6329ok();
                }
            }
        }
        return f22453ok;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T call(int r2, com.bykv.p110vk.openvk.api.proto.ValueSet r3, java.lang.Class<T> r4) {
        /*
            r1 = this;
            r4 = 0
            r0 = 0
            switch(r2) {
                case 4: goto La0;
                case 5: goto L91;
                case 6: goto L82;
                case 7: goto L73;
                case 8: goto L5d;
                default: goto L5;
            }
        L5:
            switch(r2) {
                case 100: goto L53;
                case 101: goto L43;
                case 102: goto L33;
                case 103: goto L23;
                case 104: goto L73;
                case 105: goto L82;
                case 106: goto L9;
                default: goto L8;
            }
        L8:
            goto L22
        L9:
            if (r3 == 0) goto L14
            java.lang.Class<com.bytedance.sdk.openadsdk.TTPluginListener> r2 = com.bytedance.sdk.openadsdk.TTPluginListener.class
            java.lang.Object r2 = r3.objectValue(r0, r2)
            com.bytedance.sdk.openadsdk.TTPluginListener r2 = (com.bytedance.sdk.openadsdk.TTPluginListener) r2
            goto L15
        L14:
            r2 = r4
        L15:
            if (r2 == 0) goto L22
            android.content.Context r3 = com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()
            com.bytedance.sdk.openadsdk.api.plugin.s r3 = com.bytedance.sdk.openadsdk.api.plugin.C6330s.m36562ok(r3)
            r3.m36573a(r2)
        L22:
            return r4
        L23:
            com.bytedance.pangle.plugin.Plugin r2 = r1.m36577ok(r3)
            if (r2 == 0) goto L32
            int r2 = r2.getVersion()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L32:
            return r4
        L33:
            com.bytedance.pangle.plugin.Plugin r2 = r1.m36577ok(r3)
            if (r2 == 0) goto L42
            int r2 = r2.getInternalVersionCode()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L42:
            return r4
        L43:
            com.bytedance.pangle.plugin.Plugin r2 = r1.m36577ok(r3)
            if (r2 == 0) goto L52
            int r2 = r2.getApiVersionCode()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L52:
            return r4
        L53:
            if (r3 == 0) goto L5c
            java.lang.String r2 = r3.stringValue(r0)
            com.bytedance.pangle.Zeus.unInstallPlugin(r2)
        L5c:
            return r4
        L5d:
            if (r3 == 0) goto L68
            java.lang.String r2 = r3.stringValue(r0)
            java.lang.String r2 = com.bytedance.sdk.openadsdk.api.plugin.C6330s.m36552ok(r2)
            goto L6a
        L68:
            java.lang.String r2 = ""
        L6a:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L72
            java.lang.String r2 = "0.0.0.0"
        L72:
            return r2
        L73:
            if (r3 == 0) goto L7d
            java.lang.String r2 = r3.stringValue(r0)
            boolean r0 = com.bytedance.pangle.Zeus.isPluginLoaded(r2)
        L7d:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            return r2
        L82:
            if (r3 == 0) goto L8c
            java.lang.String r2 = r3.stringValue(r0)
            boolean r0 = com.bytedance.pangle.Zeus.isPluginInstalled(r2)
        L8c:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            return r2
        L91:
            if (r3 == 0) goto L9b
            java.lang.String r2 = r3.stringValue(r0)
            boolean r0 = com.bytedance.pangle.Zeus.loadPlugin(r2)
        L9b:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            return r2
        La0:
            if (r3 == 0) goto Lac
            java.lang.String r2 = r3.stringValue(r0)
            com.bytedance.pangle.plugin.Plugin r2 = com.bytedance.pangle.Zeus.getPlugin(r2)
            com.bytedance.pangle.PluginClassLoader r4 = r2.mClassLoader
        Lac:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.p137ok.C6329ok.call(int, com.bykv.vk.openvk.api.proto.ValueSet, java.lang.Class):java.lang.Object");
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.m37925b().m37921f(BleManager.f22896l, 4).m37926a();
    }

    /* renamed from: ok */
    private Plugin m36577ok(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String stringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(stringValue)) {
            return null;
        }
        return Zeus.getPlugin(stringValue);
    }
}
