package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: UnitCacheCtroller.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class d {

    /* renamed from: e  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f41048e;

    /* renamed from: f  reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f41049f;

    /* renamed from: j  reason: collision with root package name */
    private ExecutorService f41053j;

    /* renamed from: l  reason: collision with root package name */
    private String f41055l;

    /* renamed from: m  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f41056m;

    /* renamed from: o  reason: collision with root package name */
    private int f41058o;

    /* renamed from: c  reason: collision with root package name */
    private List<CampaignEx> f41046c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f41047d = true;

    /* renamed from: g  reason: collision with root package name */
    private c f41050g = new c() { // from class: com.mbridge.msdk.videocommon.download.d.1
        @Override // com.mbridge.msdk.videocommon.download.c
        public final void a(long j4, int i4) {
            if (i4 == 5 || i4 == 4) {
                d.this.f41047d = true;
                d.this.a();
            }
            if (i4 == 2) {
                d.this.f41047d = true;
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private CopyOnWriteArrayList<Map<String, a>> f41051h = new CopyOnWriteArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private long f41054k = 3600;

    /* renamed from: n  reason: collision with root package name */
    private int f41057n = 2;

    /* renamed from: a  reason: collision with root package name */
    com.mbridge.msdk.c.d f41044a = null;

    /* renamed from: b  reason: collision with root package name */
    com.mbridge.msdk.c.d f41045b = null;

    /* renamed from: i  reason: collision with root package name */
    private Context f41052i = com.mbridge.msdk.foundation.controller.a.f().j();

    public d(Context context, List<CampaignEx> list, ExecutorService executorService, String str, int i4) {
        this.f41058o = 1;
        List<CampaignEx> list2 = this.f41046c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.f41053j = executorService;
        this.f41055l = str;
        this.f41058o = i4;
        b(this.f41046c);
    }

    private void d() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if (z.a().a("u_n_c_e_d", true) || (copyOnWriteArrayList = this.f41051h) == null) {
            return;
        }
        try {
            synchronized (copyOnWriteArrayList) {
                long currentTimeMillis = System.currentTimeMillis();
                int i4 = 0;
                while (i4 < this.f41051h.size()) {
                    Map<String, a> map = this.f41051h.get(i4);
                    for (Map.Entry<String, a> entry : map.entrySet()) {
                        a value = entry.getValue();
                        if (value != null) {
                            if (currentTimeMillis - value.c() > this.f41054k * 1000 && value.f() == 1) {
                                value.b("download timeout");
                                value.a(this.f41057n);
                                value.m();
                                this.f41051h.remove(map);
                                i4--;
                            }
                            if (value.f() != 1 && value.f() != 5 && value.f() != 0) {
                                value.m();
                                this.f41051h.remove(map);
                                i4--;
                            }
                        }
                    }
                    i4++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f41051h;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i4 = 0;
                    while (i4 < this.f41051h.size()) {
                        Map<String, a> map = this.f41051h.get(i4);
                        for (Map.Entry<String, a> entry : map.entrySet()) {
                            a value = entry.getValue();
                            if (value != null && value.g() != null && value.b()) {
                                value.l();
                                this.f41051h.remove(map);
                                i4--;
                            }
                        }
                        i4++;
                    }
                }
            } catch (Throwable unused) {
                x.d("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, a>> c() {
        return this.f41051h;
    }

    private void b(List<CampaignEx> list) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        boolean z3;
        if (list == null || list.size() == 0) {
            return;
        }
        e();
        d();
        int i4 = this.f41058o;
        if (i4 != 1) {
            if (i4 != 287) {
                if (i4 == 298) {
                    com.mbridge.msdk.c.d f4 = com.mbridge.msdk.c.b.a().f(com.mbridge.msdk.foundation.controller.a.f().k(), this.f41055l);
                    this.f41045b = f4;
                    if (f4 == null) {
                        this.f41045b = com.mbridge.msdk.c.b.a().d(com.mbridge.msdk.foundation.controller.a.f().k(), this.f41055l);
                    }
                    com.mbridge.msdk.c.d dVar = this.f41045b;
                    if (dVar != null) {
                        this.f41054k = dVar.i();
                        this.f41057n = this.f41045b.k();
                    }
                } else if (i4 != 94) {
                    if (i4 == 95) {
                        try {
                            if (!TextUtils.isEmpty(this.f41055l)) {
                                com.mbridge.msdk.c.d e4 = com.mbridge.msdk.c.b.a().e(com.mbridge.msdk.foundation.controller.a.f().k(), this.f41055l);
                                if (e4 == null) {
                                    e4 = com.mbridge.msdk.c.d.e(this.f41055l);
                                }
                                if (e4 != null) {
                                    this.f41054k = e4.i();
                                    this.f41057n = e4.k();
                                }
                            }
                        } catch (Exception unused) {
                            x.d("UnitCacheCtroller", "make sure your had put feeds jar into your project");
                            return;
                        }
                    }
                }
            }
            try {
                com.mbridge.msdk.videocommon.d.a b4 = com.mbridge.msdk.videocommon.d.b.a().b();
                if (b4 == null) {
                    com.mbridge.msdk.videocommon.d.b.a().c();
                }
                if (b4 != null) {
                    this.f41054k = b4.f();
                }
                if (!TextUtils.isEmpty(this.f41055l)) {
                    this.f41056m = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.f().k(), this.f41055l);
                }
                com.mbridge.msdk.videocommon.d.c cVar = this.f41056m;
                if (cVar != null) {
                    this.f41057n = cVar.w();
                }
            } catch (Exception unused2) {
                x.d("UnitCacheCtroller", "make sure your had put reward jar into your project");
                return;
            }
        } else {
            try {
                if (!TextUtils.isEmpty(this.f41055l)) {
                    com.mbridge.msdk.c.d e5 = com.mbridge.msdk.c.b.a().e(com.mbridge.msdk.foundation.controller.a.f().k(), this.f41055l);
                    this.f41044a = e5;
                    if (e5 == null) {
                        this.f41044a = com.mbridge.msdk.c.d.d(this.f41055l);
                    }
                    com.mbridge.msdk.c.d dVar2 = this.f41044a;
                    if (dVar2 != null) {
                        this.f41054k = dVar2.i();
                        this.f41057n = this.f41044a.k();
                    }
                }
            } catch (Exception unused3) {
                x.d("UnitCacheCtroller", "make sure your had put feeds jar into your project");
                return;
            }
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            CampaignEx campaignEx = list.get(i5);
            if (campaignEx != null) {
                int i6 = this.f41058o;
                String str = (i6 != 94 && i6 != 287) ? campaignEx.getId() + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken() : campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                if ((c(campaignEx) || !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) && (copyOnWriteArrayList = this.f41051h) != null) {
                    synchronized (copyOnWriteArrayList) {
                        int i7 = 0;
                        while (true) {
                            try {
                                if (i7 >= this.f41051h.size()) {
                                    z3 = false;
                                    break;
                                }
                                Map<String, a> map = this.f41051h.get(i7);
                                if (map != null && map.containsKey(str)) {
                                    a aVar = map.get(str);
                                    aVar.a(campaignEx);
                                    aVar.a(this.f41057n);
                                    aVar.a(false);
                                    map.remove(str);
                                    map.put(str, aVar);
                                    this.f41051h.set(i7, map);
                                    z3 = true;
                                    break;
                                }
                                i7++;
                            } catch (Throwable unused4) {
                            }
                        }
                        if (!z3) {
                            a aVar2 = new a(this.f41052i, campaignEx, this.f41055l, this.f41057n);
                            aVar2.a(this.f41057n);
                            aVar2.d(this.f41058o);
                            HashMap hashMap = new HashMap();
                            hashMap.put(str, aVar2);
                            this.f41051h.add(hashMap);
                        }
                    }
                }
            }
        }
        List<CampaignEx> list2 = this.f41046c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.f41046c.clear();
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getPlayable_ads_without_video() == 2;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f41048e = aVar;
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.f41049f == null) {
            this.f41049f = new ConcurrentHashMap<>();
        }
        this.f41049f.put(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        List<CampaignEx> list2 = this.f41046c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        b(this.f41046c);
    }

    public final void a(CampaignEx campaignEx) {
        List<CampaignEx> list = this.f41046c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        b(this.f41046c);
    }

    public final List<a> a(String str, int i4, boolean z3, List<CampaignEx> list, boolean z4) {
        Iterator<Map.Entry<String, a>> it;
        Iterator<Map.Entry<String, a>> it2;
        boolean z5 = z3;
        boolean z6 = z4;
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f41051h;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i5 = 0;
                    while (i5 < this.f41051h.size()) {
                        Map<String, a> map = this.f41051h.get(i5);
                        Iterator<Map.Entry<String, a>> it3 = map.entrySet().iterator();
                        while (it3.hasNext()) {
                            a value = it3.next().getValue();
                            if (value != null && value.g() != null) {
                                CampaignEx g4 = value.g();
                                boolean z7 = false;
                                for (CampaignEx campaignEx : list) {
                                    if (g4 == null || campaignEx == null || TextUtils.isEmpty(g4.getRequestId()) || TextUtils.isEmpty(campaignEx.getRequestId())) {
                                        it2 = it3;
                                    } else {
                                        it2 = it3;
                                        if (g4.getId().equals(campaignEx.getId()) && g4.getRequestId().equals(campaignEx.getRequestId())) {
                                            z7 = true;
                                        }
                                    }
                                    it3 = it2;
                                }
                                it = it3;
                                if (!z7) {
                                    x.b("UnitCacheCtroller", "UnitCache isReady ==== Campaign isAvailable = " + z7);
                                } else if ((z5 && !g4.isBidCampaign()) || (!z5 && g4.isBidCampaign())) {
                                    x.b("UnitCacheCtroller", "UnitCache isReady ==== isBidCampaign = " + z5 + " campaign.isBidCampaign() = " + g4.isBidCampaign());
                                } else {
                                    String str2 = g4.getendcard_url();
                                    String videoUrlEncode = g4.getVideoUrlEncode();
                                    String e4 = g4.getRewardTemplateMode() != null ? g4.getRewardTemplateMode().e() : "";
                                    g4.getRewardTemplateMode();
                                    if (i4 == 94 || i4 == 287) {
                                        if (!TextUtils.isEmpty(e4) && !e4.contains(CampaignEx.KEY_IS_CMPT_ENTRY) && !a(i4, g4, e4)) {
                                            x.b("UnitCacheCtroller", "UnitCache isReady ====  templateZipDownload check false continue");
                                        } else if (b(str2, g4)) {
                                            if (value.b()) {
                                                value.l();
                                                x.b("UnitCacheCtroller", "isready endcard\u4e0b\u8f7d\u5b8c \u4f46\u662foffer\u5c55\u793a\u8fc7 continue");
                                            } else if (ag.a(videoUrlEncode)) {
                                                x.b("UnitCacheCtroller", "endcard\u4e3a\u57fa\u51c6 endcard\u548c\u56fe\u7247\u4e0b\u8f7d\u5b8c\u6210 videourl\u4e3a\u7a7a\u4e0d\u7528\u4e0b\u8f7d return task");
                                                arrayList.add(value);
                                            } else if (a(value, b(g4), z6)) {
                                                x.b("UnitCacheCtroller", "endcard\u4e3a\u57fa\u51c6 endcard \u56fe\u7247 \u548c videourl \u4e0b\u8f7d\u5b8c\u6210 return task");
                                                arrayList.add(value);
                                            }
                                        }
                                    }
                                    boolean isEmpty = TextUtils.isEmpty(value.k());
                                    int f4 = value.f();
                                    x.a("UnitCacheCtroller", "isready unit state:" + f4);
                                    if (f4 == 5) {
                                        if (value.b()) {
                                            value.l();
                                            this.f41051h.remove(map);
                                            i5--;
                                            x.b("UnitCacheCtroller", "isready state == DownLoadConstant.DOWNLOAD_DONE \u4f46\u662foffer\u5c55\u793a\u8fc7 continue");
                                            z5 = z3;
                                            z6 = z4;
                                            it3 = it;
                                        } else {
                                            if (!isEmpty) {
                                                value.a(0, 0);
                                                if (i4 == 95) {
                                                    x.b("UnitCacheCtroller", "isready ==========done but isEffectivePath:" + isEmpty + " is feed" + i4);
                                                    arrayList.add(value);
                                                } else {
                                                    x.b("UnitCacheCtroller", "isready !isEffectivePath continue");
                                                }
                                            } else if (a(str2, g4)) {
                                                x.b("UnitCacheCtroller", "isready videourl\u4e3a\u57fa\u51c6 state\uff1ddone endcard \u56fe\u7247 \u548c videourl \u4e0b\u8f7d\u5b8c\u6210 return task");
                                                arrayList.add(value);
                                            } else {
                                                x.b("UnitCacheCtroller", "isready done but continue");
                                                return null;
                                            }
                                            z6 = z4;
                                        }
                                    } else {
                                        if (!z.a().a("u_n_c_e_d", true)) {
                                            long c4 = value.c();
                                            if (value.f() == 1 && currentTimeMillis - c4 > this.f41054k * 1000) {
                                                value.b("download timeout");
                                                value.m();
                                                this.f41051h.remove(map);
                                                i5--;
                                                if (i4 == 1 || i4 == 94) {
                                                    x.b("UnitCacheCtroller", "isready download !timeout continue");
                                                    z5 = z3;
                                                    z6 = z4;
                                                    it3 = it;
                                                }
                                            }
                                            if (f4 == 4 || f4 == 2) {
                                                this.f41051h.remove(map);
                                                value.m();
                                                i5--;
                                                x.b("UnitCacheCtroller", "isready stop continue");
                                                z5 = z3;
                                                z6 = z4;
                                                it3 = it;
                                            }
                                        }
                                        if (f4 == 1) {
                                            if (value.b()) {
                                                x.b("UnitCacheCtroller", "isready run \u5df2\u7ecf\u88ab\u5c55\u793a\u8fc7 continue");
                                                z6 = z4;
                                            } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                z6 = z4;
                                                if (a(value, b(g4), z6) && a(str2, g4)) {
                                                    x.b("UnitCacheCtroller", "isready  IS_DOWANLOAD_FINSH_PLAY is :" + MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY);
                                                    arrayList.add(value);
                                                }
                                                if ((i4 != 94 || i4 == 287) && a(value, b(g4), z6) && a(str2, g4)) {
                                                    arrayList.add(value);
                                                }
                                            }
                                        }
                                        z6 = z4;
                                        if (i4 != 94) {
                                        }
                                        arrayList.add(value);
                                    }
                                }
                                z5 = z3;
                                it3 = it;
                            }
                            it = it3;
                            x.b("UnitCacheCtroller", "UnitCache isReady ==== task \u6216\u8005 campaign\u4e3a\u7a7a continue");
                            z5 = z3;
                            it3 = it;
                        }
                        i5++;
                        z5 = z3;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private int e(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f41045b == null) {
                    this.f41045b = com.mbridge.msdk.c.b.a().c(com.mbridge.msdk.foundation.controller.a.f().k(), this.f41055l);
                }
                return this.f41045b.f();
            } else if (campaignEx.getAdType() == 42) {
                return d(null);
            } else {
                if (this.f41056m == null) {
                    this.f41056m = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.f().k(), this.f41055l, false);
                }
                return this.f41056m.r();
            }
        } catch (Throwable th) {
            x.b("UnitCacheCtroller", th.getMessage(), th);
            return 100;
        }
    }

    public d(Context context, CampaignEx campaignEx, ExecutorService executorService, String str, int i4) {
        this.f41058o = 1;
        List<CampaignEx> list = this.f41046c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        this.f41053j = executorService;
        this.f41055l = str;
        this.f41058o = i4;
        b(this.f41046c);
    }

    private int d(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.c.d dVar = this.f41044a;
            if (dVar != null) {
                return dVar.f();
            }
            return 100;
        } catch (Exception unused) {
            return 100;
        }
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (campaignEx.getReady_rate() != -1) {
                int ready_rate = campaignEx.getReady_rate();
                x.a("UnitCacheCtroller", "ready_rate(campaign): " + ready_rate);
                return ready_rate;
            }
            int e4 = e(campaignEx);
            x.a("UnitCacheCtroller", "ready_rate(reward_unit_setting): " + e4);
            return e4;
        }
        return -1;
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (!campaignEx.isMraid() && !TextUtils.isEmpty(str)) {
            if (campaignEx.getLoadTimeoutState() != 1 || c(campaignEx)) {
                if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                    x.b("UnitCacheCtroller", "Is not check endCard download status : " + str);
                    return true;
                } else if (ag.b(H5DownLoadManager.getInstance().getH5ResAddress(str))) {
                    x.b("UnitCacheCtroller", "endcard zip \u4e0b\u8f7d\u5b8c\u6210 return true endcardUrl:" + str);
                    return true;
                } else if (ag.b(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str))) {
                    x.b("UnitCacheCtroller", "endcard url \u6e90\u7801 \u4e0b\u8f7d\u5b8c\u6210 return true endcardUrl:" + str);
                    return true;
                } else {
                    x.b("UnitCacheCtroller", "checkEndcardZipOrSourceDownLoad endcardUrl return false endcardUrl:" + str);
                    return false;
                }
            }
            return true;
        }
        x.b("UnitCacheCtroller", "Campaign is Mraid, do not need download endcardurl or Campaign load timeout");
        return true;
    }

    public final a b(int i4, boolean z3) {
        try {
            return a(i4, z3);
        } catch (Throwable th) {
            x.b("UnitCacheCtroller", th.getMessage(), th);
            return null;
        }
    }

    public final void b() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f41051h;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    Iterator<Map<String, a>> it = this.f41051h.iterator();
                    while (it.hasNext()) {
                        Map<String, a> next = it.next();
                        if (next != null) {
                            for (Map.Entry<String, a> entry : next.entrySet()) {
                                a value = entry.getValue();
                                if (value != null && value.f() == 1) {
                                    x.b("UnitCacheCtroller", "\u6682\u505c\u6240\u6709\u4e0b\u8f7d");
                                    value.b("playing and stop download");
                                    value.m();
                                    this.f41051h.remove(next);
                                    return;
                                }
                            }
                            continue;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x02aa A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #0 {Exception -> 0x0389, blocks: (B:5:0x002e, B:9:0x003a, B:22:0x0086, B:23:0x008b, B:25:0x0093, B:26:0x00a3, B:28:0x00a9, B:30:0x00b7, B:33:0x00bf, B:34:0x00c8, B:36:0x00ce, B:41:0x00e8, B:45:0x0105, B:50:0x0113, B:48:0x010d, B:51:0x0136, B:53:0x0146, B:54:0x014e, B:80:0x01b1, B:82:0x01d9, B:88:0x01ea, B:90:0x01f0, B:93:0x020e, B:95:0x0216, B:98:0x0238, B:99:0x0244, B:101:0x024a, B:104:0x0253, B:109:0x025e, B:111:0x026b, B:113:0x0275, B:115:0x0282, B:119:0x029a, B:121:0x02a4, B:123:0x02aa, B:125:0x02b0, B:126:0x02bc, B:129:0x02d6, B:135:0x02e9, B:138:0x02ff, B:140:0x0305, B:141:0x0310, B:143:0x0314, B:145:0x031e, B:147:0x0324, B:150:0x033e, B:153:0x0348, B:155:0x0352, B:58:0x0159, B:60:0x015f, B:62:0x0167, B:64:0x016f, B:65:0x0177, B:67:0x017d, B:69:0x0183, B:70:0x018f, B:72:0x0195, B:75:0x019e, B:77:0x01a8, B:160:0x035d, B:163:0x036e, B:13:0x0048, B:15:0x0054, B:21:0x006c, B:164:0x037d, B:19:0x005e), top: B:178:0x002e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02d6 A[Catch: all -> 0x0387, Exception -> 0x0389, TRY_ENTER, TryCatch #0 {Exception -> 0x0389, blocks: (B:5:0x002e, B:9:0x003a, B:22:0x0086, B:23:0x008b, B:25:0x0093, B:26:0x00a3, B:28:0x00a9, B:30:0x00b7, B:33:0x00bf, B:34:0x00c8, B:36:0x00ce, B:41:0x00e8, B:45:0x0105, B:50:0x0113, B:48:0x010d, B:51:0x0136, B:53:0x0146, B:54:0x014e, B:80:0x01b1, B:82:0x01d9, B:88:0x01ea, B:90:0x01f0, B:93:0x020e, B:95:0x0216, B:98:0x0238, B:99:0x0244, B:101:0x024a, B:104:0x0253, B:109:0x025e, B:111:0x026b, B:113:0x0275, B:115:0x0282, B:119:0x029a, B:121:0x02a4, B:123:0x02aa, B:125:0x02b0, B:126:0x02bc, B:129:0x02d6, B:135:0x02e9, B:138:0x02ff, B:140:0x0305, B:141:0x0310, B:143:0x0314, B:145:0x031e, B:147:0x0324, B:150:0x033e, B:153:0x0348, B:155:0x0352, B:58:0x0159, B:60:0x015f, B:62:0x0167, B:64:0x016f, B:65:0x0177, B:67:0x017d, B:69:0x0183, B:70:0x018f, B:72:0x0195, B:75:0x019e, B:77:0x01a8, B:160:0x035d, B:163:0x036e, B:13:0x0048, B:15:0x0054, B:21:0x006c, B:164:0x037d, B:19:0x005e), top: B:178:0x002e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093 A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #0 {Exception -> 0x0389, blocks: (B:5:0x002e, B:9:0x003a, B:22:0x0086, B:23:0x008b, B:25:0x0093, B:26:0x00a3, B:28:0x00a9, B:30:0x00b7, B:33:0x00bf, B:34:0x00c8, B:36:0x00ce, B:41:0x00e8, B:45:0x0105, B:50:0x0113, B:48:0x010d, B:51:0x0136, B:53:0x0146, B:54:0x014e, B:80:0x01b1, B:82:0x01d9, B:88:0x01ea, B:90:0x01f0, B:93:0x020e, B:95:0x0216, B:98:0x0238, B:99:0x0244, B:101:0x024a, B:104:0x0253, B:109:0x025e, B:111:0x026b, B:113:0x0275, B:115:0x0282, B:119:0x029a, B:121:0x02a4, B:123:0x02aa, B:125:0x02b0, B:126:0x02bc, B:129:0x02d6, B:135:0x02e9, B:138:0x02ff, B:140:0x0305, B:141:0x0310, B:143:0x0314, B:145:0x031e, B:147:0x0324, B:150:0x033e, B:153:0x0348, B:155:0x0352, B:58:0x0159, B:60:0x015f, B:62:0x0167, B:64:0x016f, B:65:0x0177, B:67:0x017d, B:69:0x0183, B:70:0x018f, B:72:0x0195, B:75:0x019e, B:77:0x01a8, B:160:0x035d, B:163:0x036e, B:13:0x0048, B:15:0x0054, B:21:0x006c, B:164:0x037d, B:19:0x005e), top: B:178:0x002e, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.mbridge.msdk.videocommon.download.a a(int r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.d.a(int, boolean):com.mbridge.msdk.videocommon.download.a");
    }

    public final void b(String str) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        try {
            synchronized (this.f41051h) {
                if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.f41051h) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<Map<String, a>> it = this.f41051h.iterator();
                    while (it.hasNext()) {
                        Map<String, a> next = it.next();
                        if (next != null) {
                            for (Map.Entry<String, a> entry : next.entrySet()) {
                                if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                    this.f41051h.remove(next);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean a(a aVar, int i4) {
        long h4 = aVar.h();
        long e4 = aVar.e();
        if (TextUtils.isEmpty(aVar.a())) {
            x.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i4 == 0) {
            if (aVar.g() != null && !TextUtils.isEmpty(aVar.g().getVideoUrlEncode())) {
                return true;
            }
        } else if (e4 > 0 && h4 * 100 >= e4 * i4) {
            if (i4 != 100 || aVar.f() == 5) {
                return true;
            }
            aVar.m();
            return false;
        }
        return false;
    }

    private static boolean a(a aVar, int i4, boolean z3) {
        long h4 = aVar.h();
        long e4 = aVar.e();
        if (TextUtils.isEmpty(aVar.a())) {
            x.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx g4 = aVar.g();
        if (g4 != null) {
            if (g4.getRsIgnoreCheckRule() != null && g4.getRsIgnoreCheckRule().size() > 0 && g4.getRsIgnoreCheckRule().contains(0)) {
                x.b("UnitCacheCtroller", "Is not check video download status");
                if (aVar.o()) {
                    x.b("UnitCacheCtroller", "video file download failed and check ready rate return true");
                    return true;
                }
                return aVar.p();
            } else if (g4.getIsTimeoutCheckVideoStatus() == 1 && g4.getVideoCheckType() == 1) {
                return true;
            } else {
                if (z3 && g4.getVideoCheckType() == 1) {
                    if (i4 == 0) {
                        return true;
                    }
                    if ((e4 != 0 || h4 != 0) && h4 >= (i4 / 100) * e4) {
                        g4.setIsTimeoutCheckVideoStatus(1);
                        return true;
                    }
                }
            }
        }
        return a(aVar, i4);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
        } catch (Throwable th) {
            x.b("UnitCacheCtroller", th.getMessage(), th);
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
            x.b("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } else if (!campaignEx.isDynamicView() || ac.j(str)) {
            if (ag.a(str)) {
                x.b("UnitCacheCtroller", "checkEndcardDownload endcardUrl is null return true");
                return true;
            }
            if (b(str, campaignEx)) {
                x.b("UnitCacheCtroller", "checkEndcardDownload endcardUrl done return true");
                return true;
            }
            x.b("UnitCacheCtroller", "checkEndcardDownload endcardUrl return false");
            return false;
        } else {
            return true;
        }
    }

    private boolean a(int i4, CampaignEx campaignEx, String str) {
        x.a("UnitCacheCtroller", "check template " + str);
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
            x.b("UnitCacheCtroller", "Is not check template download status");
            return true;
        }
        if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0) {
            x.a("UnitCacheCtroller", "check template \u4e0b\u8f7d\u60c5\u51b5\uff1a" + H5DownLoadManager.getInstance().getH5ResAddress(str));
            if (H5DownLoadManager.getInstance().getH5ResAddress(str) == null) {
                return false;
            }
        }
        return true;
    }

    public final a a(String str) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f41051h;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                Iterator<Map<String, a>> it = this.f41051h.iterator();
                while (it.hasNext()) {
                    Map<String, a> next = it.next();
                    if (next != null && next.containsKey(str)) {
                        return next.get(str);
                    }
                }
                return null;
            }
        }
        return null;
    }

    private boolean a(CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map<String, a> next = it.next();
                if (next != null) {
                    for (Map.Entry<String, a> entry : next.entrySet()) {
                        if (entry.getValue().f() == 1) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0032 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc A[Catch: all -> 0x01d9, TryCatch #0 {, blocks: (B:5:0x000a, B:7:0x0013, B:8:0x0015, B:9:0x001b, B:11:0x0021, B:14:0x002a, B:15:0x0032, B:17:0x0038, B:20:0x0047, B:23:0x004e, B:25:0x0054, B:26:0x0056, B:29:0x0062, B:30:0x0072, B:32:0x0082, B:34:0x0086, B:35:0x008e, B:36:0x0092, B:42:0x00a6, B:44:0x00aa, B:45:0x00be, B:47:0x00c2, B:49:0x00c8, B:51:0x00cc, B:53:0x00d0, B:54:0x00e4, B:56:0x00e8, B:68:0x0116, B:70:0x011b, B:72:0x0121, B:74:0x0154, B:76:0x0158, B:79:0x0160, B:80:0x0167, B:82:0x016b, B:84:0x0171, B:86:0x017f, B:90:0x018b, B:94:0x0194, B:96:0x019f, B:98:0x01a3, B:101:0x01a7, B:104:0x01ad, B:106:0x01b8, B:110:0x01c0, B:111:0x01c5, B:117:0x01d2, B:116:0x01cf, B:57:0x00ed, B:59:0x00f1, B:63:0x0106, B:64:0x010c, B:66:0x0110, B:118:0x01d7), top: B:124:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011b A[Catch: all -> 0x01d9, TryCatch #0 {, blocks: (B:5:0x000a, B:7:0x0013, B:8:0x0015, B:9:0x001b, B:11:0x0021, B:14:0x002a, B:15:0x0032, B:17:0x0038, B:20:0x0047, B:23:0x004e, B:25:0x0054, B:26:0x0056, B:29:0x0062, B:30:0x0072, B:32:0x0082, B:34:0x0086, B:35:0x008e, B:36:0x0092, B:42:0x00a6, B:44:0x00aa, B:45:0x00be, B:47:0x00c2, B:49:0x00c8, B:51:0x00cc, B:53:0x00d0, B:54:0x00e4, B:56:0x00e8, B:68:0x0116, B:70:0x011b, B:72:0x0121, B:74:0x0154, B:76:0x0158, B:79:0x0160, B:80:0x0167, B:82:0x016b, B:84:0x0171, B:86:0x017f, B:90:0x018b, B:94:0x0194, B:96:0x019f, B:98:0x01a3, B:101:0x01a7, B:104:0x01ad, B:106:0x01b8, B:110:0x01c0, B:111:0x01c5, B:117:0x01d2, B:116:0x01cf, B:57:0x00ed, B:59:0x00f1, B:63:0x0106, B:64:0x010c, B:66:0x0110, B:118:0x01d7), top: B:124:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0154 A[Catch: all -> 0x01d9, TryCatch #0 {, blocks: (B:5:0x000a, B:7:0x0013, B:8:0x0015, B:9:0x001b, B:11:0x0021, B:14:0x002a, B:15:0x0032, B:17:0x0038, B:20:0x0047, B:23:0x004e, B:25:0x0054, B:26:0x0056, B:29:0x0062, B:30:0x0072, B:32:0x0082, B:34:0x0086, B:35:0x008e, B:36:0x0092, B:42:0x00a6, B:44:0x00aa, B:45:0x00be, B:47:0x00c2, B:49:0x00c8, B:51:0x00cc, B:53:0x00d0, B:54:0x00e4, B:56:0x00e8, B:68:0x0116, B:70:0x011b, B:72:0x0121, B:74:0x0154, B:76:0x0158, B:79:0x0160, B:80:0x0167, B:82:0x016b, B:84:0x0171, B:86:0x017f, B:90:0x018b, B:94:0x0194, B:96:0x019f, B:98:0x01a3, B:101:0x01a7, B:104:0x01ad, B:106:0x01b8, B:110:0x01c0, B:111:0x01c5, B:117:0x01d2, B:116:0x01cf, B:57:0x00ed, B:59:0x00f1, B:63:0x0106, B:64:0x010c, B:66:0x0110, B:118:0x01d7), top: B:124:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.d.a():void");
    }
}
