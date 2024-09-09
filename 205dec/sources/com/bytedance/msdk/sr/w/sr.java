package com.bytedance.msdk.sr.w;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterConfiguration;
import com.bytedance.msdk.adapter.pangle_csjm.PluginInitConfig;
import com.bytedance.msdk.api.sr.bk;
import com.bytedance.msdk.api.sr.fp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements Bridge, com.bytedance.msdk.adapter.c.xv {

    /* renamed from: c  reason: collision with root package name */
    private xv f28427c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.xv f28428f;
    private List<com.bytedance.msdk.adapter.c.w> sr = new CopyOnWriteArrayList();
    private Bridge ux;

    /* renamed from: w  reason: collision with root package name */
    private Bridge f28429w;
    private String xv;

    public sr() {
        xv c4 = xv.c(com.bytedance.msdk.core.w.k().up());
        this.f28427c = c4;
        this.f28429w = c4.c();
    }

    private void ev() {
        for (com.bytedance.msdk.adapter.c.w wVar : this.sr) {
            wVar.c();
        }
        this.sr.clear();
    }

    private int r() {
        PluginInitConfig w3 = com.bytedance.msdk.core.w.k().w();
        if (w3 != null) {
            return w3.getAgeGroup();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.adapter.c.c
    public void c(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull com.bytedance.msdk.adapter.c.w wVar) {
        if (!this.sr.contains(wVar)) {
            this.sr.add(wVar);
        }
        b a4 = b.a();
        ux.c(a4);
        a4.i(3, (String) map.get("app_id"));
        a4.j(8550, com.bytedance.msdk.core.w.k().n());
        a4.i(8, com.bytedance.msdk.core.w.k().i());
        a4.i(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold, (String) map.get("app_key"));
        String str = (String) map.get("adn_name");
        this.xv = str;
        a4.i(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, c(str));
        a4.i(8003, (String) map.get("adn_name"));
        a4.i(8410, "3.3.63.1");
        a4.i(8411, com.bytedance.msdk.c.sr.xv());
        a4.i(8412, "17.2.0.57");
        a4.i(8413, "9.35.0");
        a4.i(8414, "4.570.1440.1");
        a4.i(8415, "2.11.0.3.18");
        a4.i(8417, "4.16.0.0");
        a4.i(8418, "4.3.0.24");
        a4.i(8416, "16.6.57.0");
        a4.e(7, r());
        a4.h(8425, map);
        a4.h(8300, this);
        if (TextUtils.equals(this.xv, "pangle")) {
            PangleAdapterConfiguration pangleAdapterConfiguration = new PangleAdapterConfiguration();
            b a5 = b.a();
            a5.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
            a5.h(8424, a4.l());
            pangleAdapterConfiguration.call(8240, a5.l(), null);
            this.ux = pangleAdapterConfiguration;
            return;
        }
        this.f28429w.call(AVMDLDataLoader.KeyIsLiveLoaderEnable, a4.l(), Void.class);
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public void c(fp fpVar) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8122) {
            this.ux = (Bridge) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, Bridge.class);
            ev();
            return null;
        } else if (i4 == 8123) {
            Result result = (Result) valueSet.objectValue(8022, Result.class);
            if (result != null) {
                c(new com.bytedance.msdk.api.c(result.code(), result.message()));
                return null;
            }
            return null;
        } else if (i4 != 8212) {
            if (i4 == 8266) {
                this.ux = (Bridge) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, Bridge.class);
                return null;
            }
            return null;
        } else if (this.f28428f != null) {
            this.f28428f.c(valueSet.intValue(8095));
            return null;
        } else {
            return null;
        }
    }

    public String f() {
        Bridge bridge = this.ux;
        return bridge != null ? (String) bridge.call(8105, null, String.class) : "";
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public void sr() {
        try {
            String xv = com.bytedance.sdk.gromore.init.c.xv();
            if (xv.length() == 7) {
                String f4 = f();
                if (c(f4, xv.substring(0, 5)) != 0) {
                    if (!TextUtils.isEmpty(c())) {
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", ux() + "\u7248\u672c\u53f7\uff1a" + w() + " , " + ux() + "Adapter\u7248\u672c\u53f7\uff1a" + c() + " , \u805a\u5408\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e" + f4 + ".x \uff0c\u5f53\u524d\u662f" + xv);
                    } else {
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", ux() + "\u7248\u672c\u53f7\uff1a" + w() + " , ***" + ux() + "Adapter\u672a\u63a5\u5165\uff0c\u8bf7\u68c0\u67e5***, \u805a\u5408\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e" + f4 + ".x \uff0c\u5f53\u524d\u662f" + xv);
                    }
                } else if (!TextUtils.isEmpty(c())) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_SDK_Init", ux() + "\u7248\u672c\u53f7\uff1a" + w() + " , " + ux() + "Adapter\u7248\u672c\u53f7\uff1a" + c() + " , \u805a\u5408\u7248\u672c\u6b63\u5e38 \uff0c\u8981\u6c42\u7b49\u4e8e" + f4 + ".x \uff0c\u5f53\u524d\u662f" + xv);
                } else {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", ux() + "\u7248\u672c\u53f7\uff1a" + w() + " , ***" + ux() + "Adapter\u672a\u63a5\u5165\uff0c\u8bf7\u68c0\u67e5***, \u805a\u5408\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e" + f4 + ".x \uff0c\u5f53\u524d\u662f" + xv);
                }
            } else {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "\u805a\u5408\u7248\u672c\u53f7\u4e0d\u5408\u6cd5\uff0c\u5f53\u524d\u7248\u672c\u53f7\u4e3a\uff1a" + xv + "\uff0c\u8bf7\u68c0\u6d4b\u7248\u672c\u53f7");
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public String ux() {
        return this.xv;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public Map<String, Object> w(Context context, Map<String, Object> map) {
        b a4 = b.a();
        a4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        a4.h(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map);
        return (Map) this.ux.call(AVMDLDataLoader.KeyIsLiveGetLoaderType, a4.l(), Map.class);
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public String xv() {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public String w() {
        Bridge bridge = this.ux;
        return bridge != null ? (String) bridge.call(8104, null, String.class) : "";
    }

    public static String c(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1128782217:
                if (str.equals("klevin")) {
                    c4 = 0;
                    break;
                }
                break;
            case -902468465:
                if (str.equals("sigmob")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3432:
                if (str.equals("ks")) {
                    c4 = 2;
                    break;
                }
                break;
            case 102199:
                if (str.equals("gdt")) {
                    c4 = 3;
                    break;
                }
                break;
            case 92668925:
                if (str.equals("admob")) {
                    c4 = 4;
                    break;
                }
                break;
            case 93498907:
                if (str.equals("baidu")) {
                    c4 = 5;
                    break;
                }
                break;
            case 111433589:
                if (str.equals("unity")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1126045977:
                if (str.equals("mintegral")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "com.bytedance.msdk.adapter.klevin.KlevinAdapterConfiguration";
            case 1:
                return "com.bytedance.msdk.adapter.sigmob.SigmobAdapterConfiguration";
            case 2:
                return "com.bytedance.msdk.adapter.ks.KsAdapterConfiguration";
            case 3:
                return "com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration";
            case 4:
                return "com.bytedance.msdk.adapter.admob.AdmobAdapterConfiguration";
            case 5:
                return "com.bytedance.msdk.adapter.baidu.BaiduAdapterConfiguration";
            case 6:
                return "com.bytedance.msdk.adapter.unity.UnityAdapterConfiguration";
            case 7:
                return "com.bytedance.msdk.adapter.mintegral.MintegralAdapterConfiguration";
            default:
                return null;
        }
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public String c() {
        Bridge bridge = this.ux;
        return bridge != null ? (String) bridge.call(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, null, String.class) : "";
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public String c(Context context, Map<String, Object> map) {
        b a4 = b.a();
        a4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        a4.h(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map);
        return (String) this.ux.call(8102, a4.l(), String.class);
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public void c(Map<String, Object> map) {
        if (this.ux != null) {
            b a4 = b.a();
            a4.h(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map);
            this.ux.call(8242, a4.l(), Void.class);
        }
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public int c(com.bytedance.msdk.api.sr.xv xvVar) {
        Bridge bridge = this.ux;
        if (bridge != null) {
            this.f28428f = xvVar;
            return ((Integer) bridge.call(8126, null, Integer.class)).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.adapter.c.xv
    public void c(bk bkVar, ValueSet valueSet) {
        if (this.ux == null || bkVar == null) {
            return;
        }
        b a4 = b.a();
        a4.h(8517, valueSet);
        this.ux.call(8124, a4.l(), Void.class);
    }

    private void c(com.bytedance.msdk.api.c cVar) {
        for (com.bytedance.msdk.adapter.c.w wVar : this.sr) {
            wVar.c(cVar);
        }
        this.sr.clear();
    }

    public static int c(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i4 = 0; i4 < min; i4++) {
            if (split[i4].length() != split2[i4].length()) {
                return split[i4].length() > split2[i4].length() ? 1 : -1;
            }
            int compareTo = split[i4].compareTo(split2[i4]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (split.length == split2.length) {
            return 0;
        }
        return split.length > split2.length ? 1 : -1;
    }
}
