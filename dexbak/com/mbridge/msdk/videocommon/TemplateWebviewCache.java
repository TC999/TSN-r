package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.mbridge.msdk.videocommon.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class TemplateWebviewCache {

    /* renamed from: a */
    private static ConcurrentHashMap<String, C11721a> f32175a = new ConcurrentHashMap<>();

    /* renamed from: b */
    private static ConcurrentHashMap<String, C11721a> f32176b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private static ConcurrentHashMap<String, C11721a> f32177c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private static ConcurrentHashMap<String, C11721a> f32178d = new ConcurrentHashMap<>();

    /* renamed from: e */
    private static ConcurrentHashMap<String, C11721a> f32179e = new ConcurrentHashMap<>();

    /* renamed from: f */
    private static ConcurrentHashMap<String, C11721a> f32180f = new ConcurrentHashMap<>();

    /* renamed from: g */
    private static ConcurrentHashMap<String, C11721a> f32181g = new ConcurrentHashMap<>();

    /* renamed from: h */
    private static ConcurrentHashMap<String, C11721a> f32182h = new ConcurrentHashMap<>();

    /* renamed from: i */
    private static ConcurrentHashMap<String, C11721a> f32183i = new ConcurrentHashMap<>();

    /* renamed from: j */
    private static ConcurrentHashMap<String, C11721a> f32184j = new ConcurrentHashMap<>();

    /* compiled from: TemplateWebviewCache.java */
    /* renamed from: com.mbridge.msdk.videocommon.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11721a {

        /* renamed from: a */
        private WindVaneWebView f32185a;

        /* renamed from: b */
        private boolean f32186b;

        /* renamed from: a */
        public final WindVaneWebView m20905a() {
            return this.f32185a;
        }

        /* renamed from: b */
        public final String m20888b() {
            WindVaneWebView windVaneWebView = this.f32185a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        /* renamed from: c */
        public final boolean m20882c() {
            return this.f32186b;
        }

        /* renamed from: a */
        public final void m20900a(WindVaneWebView windVaneWebView) {
            this.f32185a = windVaneWebView;
        }

        /* renamed from: a */
        public final void m20898a(String str) {
            WindVaneWebView windVaneWebView = this.f32185a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        /* renamed from: a */
        public final void m20889a(boolean z) {
            this.f32186b = z;
        }
    }

    /* renamed from: a */
    public static C11721a m20913a(String str) {
        if (f32181g.containsKey(str)) {
            return f32181g.get(str);
        }
        if (f32182h.containsKey(str)) {
            return f32182h.get(str);
        }
        if (f32183i.containsKey(str)) {
            return f32183i.get(str);
        }
        if (f32184j.containsKey(str)) {
            return f32184j.get(str);
        }
        return null;
    }

    /* renamed from: b */
    public static void m20909b(String str) {
        if (f32181g.containsKey(str)) {
            f32181g.remove(str);
        }
        if (f32183i.containsKey(str)) {
            f32183i.remove(str);
        }
        if (f32182h.containsKey(str)) {
            f32182h.remove(str);
        }
        if (f32184j.containsKey(str)) {
            f32184j.remove(str);
        }
    }

    /* renamed from: c */
    public static void m20908c(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : f32181g.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    f32181g.remove(str2);
                }
            }
        } else {
            f32181g.clear();
        }
        f32182h.clear();
    }

    /* renamed from: d */
    public static void m20907d(String str) {
        for (Map.Entry<String, C11721a> entry : f32181g.entrySet()) {
            if (entry.getKey().contains(str)) {
                f32181g.remove(entry.getKey());
            }
        }
    }

    /* renamed from: e */
    public static void m20906e(String str) {
        for (Map.Entry<String, C11721a> entry : f32182h.entrySet()) {
            if (entry.getKey().contains(str)) {
                f32182h.remove(entry.getKey());
            }
        }
    }

    /* renamed from: a */
    public static void m20912a(String str, C11721a c11721a, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                f32182h.put(str, c11721a);
            } else {
                f32181g.put(str, c11721a);
            }
        } else if (z2) {
            f32184j.put(str, c11721a);
        } else {
            f32183i.put(str, c11721a);
        }
    }

    /* renamed from: b */
    public static void m20911b(int i, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i == 94) {
                if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C11721a> concurrentHashMap = f32176b;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C11721a> concurrentHashMap2 = f32179e;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(requestIdNotice);
                }
            } else if (i != 287) {
                if (i != 288) {
                    ConcurrentHashMap<String, C11721a> concurrentHashMap3 = f32175a;
                    if (concurrentHashMap3 != null) {
                        concurrentHashMap3.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C11721a> concurrentHashMap4 = f32178d;
                if (concurrentHashMap4 != null) {
                    concurrentHashMap4.remove(requestIdNotice);
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C11721a> concurrentHashMap5 = f32177c;
                if (concurrentHashMap5 != null) {
                    concurrentHashMap5.remove(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C11721a> concurrentHashMap6 = f32180f;
                if (concurrentHashMap6 != null) {
                    concurrentHashMap6.remove(requestIdNotice);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m20916a() {
        f32183i.clear();
        f32184j.clear();
    }

    /* renamed from: a */
    public static C11721a m20915a(int i, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i != 94) {
                if (i != 287) {
                    if (i != 288) {
                        ConcurrentHashMap<String, C11721a> concurrentHashMap = f32175a;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return f32175a.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C11721a> concurrentHashMap2 = f32178d;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return f32178d.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C11721a> concurrentHashMap3 = f32177c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return f32177c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C11721a> concurrentHashMap4 = f32180f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f32180f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C11721a> concurrentHashMap5 = f32176b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f32176b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C11721a> concurrentHashMap6 = f32179e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return f32179e.get(requestIdNotice);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    public static void m20910b(int i, String str, C11721a c11721a) {
        try {
            if (i == 94) {
                if (f32179e == null) {
                    f32179e = new ConcurrentHashMap<>();
                }
                f32179e.put(str, c11721a);
            } else if (i == 287) {
                if (f32180f == null) {
                    f32180f = new ConcurrentHashMap<>();
                }
                f32180f.put(str, c11721a);
            } else if (i != 288) {
                if (f32175a == null) {
                    f32175a = new ConcurrentHashMap<>();
                }
                f32175a.put(str, c11721a);
            } else {
                if (f32178d == null) {
                    f32178d = new ConcurrentHashMap<>();
                }
                f32178d.put(str, c11721a);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m20914a(int i, String str, C11721a c11721a) {
        try {
            if (i == 94) {
                if (f32176b == null) {
                    f32176b = new ConcurrentHashMap<>();
                }
                f32176b.put(str, c11721a);
            } else if (i != 287) {
            } else {
                if (f32177c == null) {
                    f32177c = new ConcurrentHashMap<>();
                }
                f32177c.put(str, c11721a);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
