package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DownLoadManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f41037a;

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f41038b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41039c = false;

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<String, d> f41040d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Map<String, List<Map<String, a>>> f41041e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, List<CampaignEx>> f41042f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, List<a>> f41043g;

    private b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.f41038b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static b getInstance() {
        if (f41037a == null) {
            synchronized (b.class) {
                if (f41037a == null) {
                    f41037a = new b();
                }
            }
        }
        return f41037a;
    }

    public final a a(String str, String str2) {
        d c4 = c(str);
        if (c4 != null) {
            return c4.a(str2);
        }
        return null;
    }

    public final List<a> b(String str) {
        Map<String, List<a>> map = this.f41043g;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f41043g.get(str);
    }

    public final d c(String str) {
        ConcurrentHashMap<String, d> concurrentHashMap = this.f41040d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f41040d.get(str);
    }

    public d createUnitCache(Context context, String str, List<CampaignEx> list, int i4, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return null;
        }
        if (this.f41040d.containsKey(str)) {
            d dVar = this.f41040d.get(str);
            if (i4 != 94 && i4 != 287) {
                dVar.a(aVar);
            } else {
                dVar.a(list.get(0).getRequestId(), aVar);
            }
            dVar.a(list);
            return dVar;
        }
        d dVar2 = new d(context, list, this.f41038b, str, i4);
        if (aVar != null) {
            dVar2.a(aVar);
        }
        this.f41040d.put(str, dVar2);
        return dVar2;
    }

    public void load(String str) {
        d c4 = c(str);
        if (c4 != null) {
            c4.a();
        }
    }

    public final List<CampaignEx> a(String str) {
        Map<String, List<CampaignEx>> map = this.f41042f;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f41042f.get(str);
    }

    public final int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> c4;
        a value;
        CampaignEx g4;
        ConcurrentHashMap<String, d> concurrentHashMap = this.f41040d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, d> entry : concurrentHashMap.entrySet()) {
                d value2 = entry.getValue();
                if (value2 != null && (c4 = value2.c()) != null) {
                    int size = c4.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        Map<String, a> map = c4.get(i4);
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                            if (it.hasNext() && (value = it.next().getValue()) != null && (g4 = value.g()) != null) {
                                String videoUrlEncode = g4.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return value.f();
                                }
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return 0;
    }

    public final boolean a(int i4, String str, boolean z3) {
        try {
            d c4 = c(str);
            if (c4 != null) {
                return c4.a(i4, z3) != null;
            }
            return false;
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public final boolean a(int i4, String str, boolean z3, int i5, boolean z4, int i6, List<CampaignEx> list) {
        return a(i4, str, z3, i5, z4, i6, list, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01b5, code lost:
        if (r3.containsKey(r16) == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b7, code lost:
        r14.f41043g.remove(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bc, code lost:
        r3 = r14.f41042f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01be, code lost:
        if (r3 != null) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c0, code lost:
        r14.f41042f = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01cc, code lost:
        if (r3.containsKey(r16) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ce, code lost:
        r14.f41042f.remove(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01d3, code lost:
        if (r2 == null) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01d9, code lost:
        if (r2.size() <= 0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01db, code lost:
        r3 = new java.util.ArrayList();
        r4 = new java.util.ArrayList();
        r5 = new java.util.ArrayList();
        r2 = r2.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01f2, code lost:
        if (r2.hasNext() == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01f4, code lost:
        r6 = r2.next();
        r7 = new java.util.concurrent.ConcurrentHashMap();
        r8 = r6.g();
        r7.put(r8.getId() + r8.getVideoUrlEncode() + r8.getBidToken(), r6);
        r3.add(r7);
        r4.add(r8);
        r5.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x022e, code lost:
        r14.f41041e.put(r16, r3);
        r14.f41042f.put(r16, r4);
        r14.f41043g.put(r16, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0127, code lost:
        if (r5.size() >= r18) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0189, code lost:
        if (r4.size() > 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x018e, code lost:
        r3 = r14.f41041e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0190, code lost:
        if (r3 != null) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0192, code lost:
        r14.f41041e = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x019e, code lost:
        if (r3.containsKey(r16) == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a0, code lost:
        r14.f41041e.remove(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01a5, code lost:
        r3 = r14.f41043g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a7, code lost:
        if (r3 != null) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a9, code lost:
        r14.f41043g = new java.util.HashMap();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int r15, java.lang.String r16, boolean r17, int r18, boolean r19, int r20, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.b.a(int, java.lang.String, boolean, int, boolean, int, java.util.List, boolean):boolean");
    }

    public d createUnitCache(Context context, String str, CampaignEx campaignEx, int i4, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.f41040d.containsKey(str)) {
            d dVar = this.f41040d.get(str);
            if (i4 != 94 && i4 != 287) {
                dVar.a(aVar);
            } else {
                dVar.a(campaignEx.getRequestId(), aVar);
            }
            dVar.a(campaignEx);
            return dVar;
        }
        d dVar2 = new d(context, campaignEx, this.f41038b, str, i4);
        if (aVar != null) {
            dVar2.a(aVar);
        }
        this.f41040d.put(str, dVar2);
        return dVar2;
    }

    public final void b(boolean z3) {
        if (z3) {
            if (this.f41039c) {
                return;
            }
        } else {
            this.f41039c = false;
        }
        ConcurrentHashMap<String, d> concurrentHashMap = this.f41040d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, d> entry : concurrentHashMap.entrySet()) {
                entry.getValue().a();
            }
        }
    }

    public final void a(boolean z3) {
        this.f41039c = z3;
        ConcurrentHashMap<String, d> concurrentHashMap = this.f41040d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, d> entry : concurrentHashMap.entrySet()) {
                d value = entry.getValue();
                if (value != null) {
                    value.b();
                }
            }
        }
    }

    public final void a() {
        ConcurrentHashMap<String, d> concurrentHashMap = this.f41040d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, d> entry : concurrentHashMap.entrySet()) {
                d value = entry.getValue();
                String key = entry.getKey();
                try {
                    com.mbridge.msdk.videocommon.d.c a4 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.f().k(), key);
                    if (a4 != null) {
                        if (a4.w() == 2) {
                            value.b();
                        } else {
                            value.a();
                        }
                    }
                } catch (Exception e4) {
                    x.d("DownLoadManager", e4.getMessage());
                    try {
                        if (!TextUtils.isEmpty(key)) {
                            com.mbridge.msdk.c.d e5 = com.mbridge.msdk.c.b.a().e(com.mbridge.msdk.foundation.controller.a.f().k(), key);
                            if (e5 == null) {
                                e5 = com.mbridge.msdk.c.d.e(key);
                            }
                            if (e5.k() == 2) {
                                value.b();
                            } else {
                                value.a();
                            }
                        }
                    } catch (Exception e6) {
                        x.d("DownLoadManager", e6.getMessage());
                    }
                }
            }
        }
    }
}
