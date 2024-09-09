package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TemplateWebviewCache.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40923a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40924b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40925c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40926d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40927e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40928f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40929g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40930h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40931i = new ConcurrentHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0767a> f40932j = new ConcurrentHashMap<>();

    /* compiled from: TemplateWebviewCache.java */
    /* renamed from: com.mbridge.msdk.videocommon.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C0767a {

        /* renamed from: a  reason: collision with root package name */
        private WindVaneWebView f40933a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f40934b;

        public final WindVaneWebView a() {
            return this.f40933a;
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.f40933a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.f40934b;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.f40933a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.f40933a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final void a(boolean z3) {
            this.f40934b = z3;
        }
    }

    public static C0767a a(String str) {
        if (f40929g.containsKey(str)) {
            return f40929g.get(str);
        }
        if (f40930h.containsKey(str)) {
            return f40930h.get(str);
        }
        if (f40931i.containsKey(str)) {
            return f40931i.get(str);
        }
        if (f40932j.containsKey(str)) {
            return f40932j.get(str);
        }
        return null;
    }

    public static void b(String str) {
        if (f40929g.containsKey(str)) {
            f40929g.remove(str);
        }
        if (f40931i.containsKey(str)) {
            f40931i.remove(str);
        }
        if (f40930h.containsKey(str)) {
            f40930h.remove(str);
        }
        if (f40932j.containsKey(str)) {
            f40932j.remove(str);
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : f40929g.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    f40929g.remove(str2);
                }
            }
        } else {
            f40929g.clear();
        }
        f40930h.clear();
    }

    public static void d(String str) {
        for (Map.Entry<String, C0767a> entry : f40929g.entrySet()) {
            if (entry.getKey().contains(str)) {
                f40929g.remove(entry.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry<String, C0767a> entry : f40930h.entrySet()) {
            if (entry.getKey().contains(str)) {
                f40930h.remove(entry.getKey());
            }
        }
    }

    public static void a(String str, C0767a c0767a, boolean z3, boolean z4) {
        if (z3) {
            if (z4) {
                f40930h.put(str, c0767a);
            } else {
                f40929g.put(str, c0767a);
            }
        } else if (z4) {
            f40932j.put(str, c0767a);
        } else {
            f40931i.put(str, c0767a);
        }
    }

    public static void b(int i4, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i4 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i4 == 94) {
                if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0767a> concurrentHashMap = f40924b;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0767a> concurrentHashMap2 = f40927e;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(requestIdNotice);
                }
            } else if (i4 != 287) {
                if (i4 != 288) {
                    ConcurrentHashMap<String, C0767a> concurrentHashMap3 = f40923a;
                    if (concurrentHashMap3 != null) {
                        concurrentHashMap3.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0767a> concurrentHashMap4 = f40926d;
                if (concurrentHashMap4 != null) {
                    concurrentHashMap4.remove(requestIdNotice);
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0767a> concurrentHashMap5 = f40925c;
                if (concurrentHashMap5 != null) {
                    concurrentHashMap5.remove(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0767a> concurrentHashMap6 = f40928f;
                if (concurrentHashMap6 != null) {
                    concurrentHashMap6.remove(requestIdNotice);
                }
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void a() {
        f40931i.clear();
        f40932j.clear();
    }

    public static C0767a a(int i4, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i4 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i4 != 94) {
                if (i4 != 287) {
                    if (i4 != 288) {
                        ConcurrentHashMap<String, C0767a> concurrentHashMap = f40923a;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return f40923a.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0767a> concurrentHashMap2 = f40926d;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return f40926d.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0767a> concurrentHashMap3 = f40925c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return f40925c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0767a> concurrentHashMap4 = f40928f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f40928f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0767a> concurrentHashMap5 = f40924b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f40924b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0767a> concurrentHashMap6 = f40927e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return f40927e.get(requestIdNotice);
                }
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public static void b(int i4, String str, C0767a c0767a) {
        try {
            if (i4 == 94) {
                if (f40927e == null) {
                    f40927e = new ConcurrentHashMap<>();
                }
                f40927e.put(str, c0767a);
            } else if (i4 == 287) {
                if (f40928f == null) {
                    f40928f = new ConcurrentHashMap<>();
                }
                f40928f.put(str, c0767a);
            } else if (i4 != 288) {
                if (f40923a == null) {
                    f40923a = new ConcurrentHashMap<>();
                }
                f40923a.put(str, c0767a);
            } else {
                if (f40926d == null) {
                    f40926d = new ConcurrentHashMap<>();
                }
                f40926d.put(str, c0767a);
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void a(int i4, String str, C0767a c0767a) {
        try {
            if (i4 == 94) {
                if (f40924b == null) {
                    f40924b = new ConcurrentHashMap<>();
                }
                f40924b.put(str, c0767a);
            } else if (i4 != 287) {
            } else {
                if (f40925c == null) {
                    f40925c = new ConcurrentHashMap<>();
                }
                f40925c.put(str, c0767a);
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }
}
