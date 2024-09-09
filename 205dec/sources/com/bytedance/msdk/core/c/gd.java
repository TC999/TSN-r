package com.bytedance.msdk.core.c;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.core.k.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends com.bytedance.msdk.adapter.c {

    /* renamed from: f  reason: collision with root package name */
    private String f27842f;

    /* renamed from: r  reason: collision with root package name */
    private c f27843r;

    public gd(String str) {
        this.f27842f = str;
    }

    public static b c(Context context, com.bytedance.msdk.adapter.c cVar, Map<String, Object> map, String str) {
        HashMap hashMap = null;
        if (cVar == null || cVar.getAdLinkInfo() == null || cVar.getAdLinkInfo().s() == null) {
            return null;
        }
        b a4 = b.a();
        com.bytedance.msdk.api.c.w adLinkInfo = cVar.getAdLinkInfo();
        com.bytedance.sdk.openadsdk.mediation.c.w.c s3 = adLinkInfo.s();
        b e4 = b.k(adLinkInfo.wx()).i(15, s3.fp()).e(13, s3.t()).e(7, s3.ev()).e(8, s3.gd()).e(16, s3.ia()).e(20, s3.u()).j(11, s3.a()).e(17, adLinkInfo.fp());
        b a5 = b.a();
        if (s3.c() != null) {
            HashMap hashMap2 = new HashMap();
            if (s3.c().f() != null) {
                hashMap2.putAll(s3.c().f());
            }
            if (cVar.getWaterFallConfig() != null) {
                hashMap2.put("waterfall_config", cVar.getWaterFallConfig());
            }
            hashMap2.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.ux.c.c.p().f()));
            com.bytedance.msdk.core.sr.c.c(cVar.getAdLinkInfo(), cVar.getWaterFallConfig(), hashMap2);
            a5.j(8444, s3.c().xv()).j(8445, s3.c().c()).j(8446, s3.c().w()).d(8447, s3.c().sr()).j(8448, s3.c().ux()).h(8449, hashMap2).j(8450, s3.c().r()).i(8451, s3.c().ev()).j(8454, s3.c().gd()).d(8455, s3.c().k()).d(8456, s3.c().a()).h(8044, hashMap2);
        } else {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.ux.c.c.p().f()));
            a5.h(8449, hashMap3);
        }
        c(a5, s3);
        e4.h(8443, a5.l());
        a4.h(8090, b.k(adLinkInfo.wx()).h(8089, e4.l()).l());
        a4.i(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, cVar.getAdSlotId());
        a4.i(4, cVar.getAdapterRit());
        a4.i(8003, cVar.getAdNetWorkName());
        a4.e(17, adLinkInfo.fp());
        if (adLinkInfo.yu() != null) {
            HashMap hashMap4 = new HashMap();
            for (Map.Entry<String, Object> entry : adLinkInfo.yu().entrySet()) {
                Object value = entry.getValue();
                hashMap4.put(entry.getKey(), value == null ? null : value.toString());
            }
            hashMap = hashMap4;
        }
        if (hashMap != null) {
            a4.h(8013, hashMap);
        }
        if (map != null) {
            a4.e(8096, map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT) != null ? ((Integer) map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue() : 3000);
        }
        Object obj = map.get("contentUrl");
        if (obj instanceof String) {
            a4.i(8083, (String) obj);
        }
        Object obj2 = map.get("testDevices");
        if (obj2 instanceof String) {
            a4.i(8084, (String) obj2);
        }
        Object obj3 = map.get("tt_ad_origin_type");
        if (obj3 != null) {
            int intValue = ((Integer) obj3).intValue();
            if (intValue == 1 || intValue == 3) {
                a4.j(8033, true);
            }
            a4.e(8085, intValue);
        }
        Object obj4 = map.get("tt_ad_sub_type");
        if (obj4 != null) {
            a4.e(8094, ((Integer) obj4).intValue());
        }
        Object obj5 = map.get("render_control");
        if (obj5 instanceof Integer) {
            a4.e(8553, ((Integer) obj5).intValue());
        }
        return a4;
    }

    @Override // com.bytedance.msdk.adapter.c
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getAdNetWorkName() {
        p pVar = this.f26925w;
        return pVar != null ? pVar.t() : "";
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getBiddingToken(Context context, String str, com.bytedance.msdk.api.c.w wVar) {
        if (this.f27843r == null || wVar == null || wVar.s() == null) {
            return null;
        }
        return this.f27843r.c(context, str, com.bytedance.msdk.core.s.c.c(wVar.s().c().f()));
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getSdkVersion() {
        com.bytedance.msdk.adapter.c.xv c4 = com.bytedance.msdk.sr.w.w.c().c(getAdNetWorkName());
        if (c4 != null) {
            return c4.w();
        }
        return null;
    }

    @Override // com.bytedance.msdk.adapter.c
    public final void loadAd(Context context, Map<String, Object> map) {
        b c4 = c(context, this, map, getAdNetWorkName());
        if (c4 != null) {
            this.f27843r = new c(this.xv.fz(), getmSubAdType(), this);
            c4.i(8429, this.f26913c);
            c4.i(8430, getClientReqId());
            c4.h(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.f27843r);
            c4.i(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, this.f27842f);
            com.bytedance.msdk.sr.w.c.c(context, getAdNetWorkName());
            Bridge f4 = com.bytedance.msdk.core.bk.c.c().f();
            if (f4 != null) {
                if (com.bytedance.sdk.gromore.init.c.c() >= 5900) {
                    b a4 = b.a();
                    a4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.adapter.sr.c.c(context));
                    a4.h(8424, c4.l());
                    f4.call(8106, a4.l(), Void.class);
                    return;
                }
                c4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.adapter.sr.c.c(context));
                f4.call(8106, c4.l(), Void.class);
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "load ad class loader is null ");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class c implements Bridge {

        /* renamed from: c  reason: collision with root package name */
        private com.bytedance.msdk.adapter.c f27844c;
        private Bridge sr;

        /* renamed from: w  reason: collision with root package name */
        private int f27845w;
        private int xv;

        public c(int i4, int i5, com.bytedance.msdk.adapter.c cVar) {
            this.f27845w = i4;
            this.xv = i5;
            this.f27844c = cVar;
        }

        public String c(Context context, String str, Object obj) {
            if (this.sr != null) {
                b a4 = b.a();
                a4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
                a4.i(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, str);
                a4.h(8044, obj);
                this.sr.call(8139, a4.l(), Void.class);
                return null;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
            if (i4 == 8108) {
                this.f27844c.notifyAdFailed(new com.bytedance.msdk.api.c(valueSet.intValue(8014), valueSet.stringValue(8015)));
            } else if (i4 == 8112) {
                Bridge bridge = (Bridge) valueSet.objectValue(8303, Bridge.class);
                int intValue = valueSet.intValue(8014);
                String stringValue = valueSet.stringValue(8015);
                if (bridge instanceof com.bytedance.msdk.c.ux) {
                    this.f27844c.notifyAdVideoCache((com.bytedance.msdk.c.ux) bridge, new com.bytedance.msdk.api.c(intValue, stringValue));
                }
            } else if (i4 == 8107) {
                List list = (List) valueSet.objectValue(8303, List.class);
                if (list.size() > 0 && !(list.get(0) instanceof ux)) {
                    if (list.get(0) instanceof com.bytedance.msdk.c.ux) {
                        this.f27844c.notifyAdLoaded((com.bytedance.msdk.c.ux) list.get(0));
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (obj instanceof com.bytedance.msdk.c.ux) {
                            arrayList.add((com.bytedance.msdk.c.ux) obj);
                        }
                    }
                    this.f27844c.notifyAdLoaded(arrayList);
                }
            } else if (i4 == 8127) {
                return (T) c();
            } else {
                if (i4 == 8110) {
                    return (T) Boolean.valueOf(this.f27844c.isClientBidding());
                }
                if (i4 == 8136) {
                    return (T) Boolean.valueOf(this.f27844c.isServerBidding());
                }
                if (i4 == 8141) {
                    return (T) Boolean.valueOf(this.f27844c.isMultiBidding());
                }
                if (i4 == 8137) {
                    return (T) this.f27844c.getAdm();
                }
                if (i4 == 8138) {
                    this.sr = (Bridge) valueSet.objectValue(8043, Bridge.class);
                } else if (i4 == 8210) {
                    return (T) Boolean.valueOf(this.f27844c.hasNotifyFail());
                }
            }
            return (T) com.bytedance.msdk.core.s.c.c(cls);
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        private com.bytedance.msdk.c.ux c() {
            switch (this.f27845w) {
                case 1:
                    return new com.bytedance.msdk.core.c.c(this.f27844c);
                case 2:
                    return new sr(this.f27844c);
                case 3:
                    return new ev(this.f27844c);
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                case 9:
                    return new ux(this.f27844c);
                case 7:
                    int i4 = this.xv;
                    if (i4 == 6) {
                        return new r(this.f27844c);
                    }
                    if (i4 == 7) {
                        return new xv(this.f27844c);
                    }
                    return new r(this.f27844c);
                case 8:
                    return new xv(this.f27844c);
                case 10:
                    int i5 = this.xv;
                    if (i5 == 1) {
                        return new sr(this.f27844c);
                    }
                    if (i5 == 2) {
                        return new xv(this.f27844c);
                    }
                    return null;
            }
        }
    }

    private static void c(b bVar, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar) {
        if (bVar == null || cVar == null) {
            return;
        }
        if (cVar.c() != null && !TextUtils.isEmpty(cVar.c().t()) && cVar.c().ys() != 0) {
            bVar.i(8452, cVar.c().t());
            bVar.e(8453, cVar.c().ys());
        } else if (TextUtils.isEmpty(cVar.n()) || cVar.ck() == 0) {
        } else {
            bVar.i(8452, cVar.n());
            bVar.e(8453, cVar.ck());
        }
    }
}
