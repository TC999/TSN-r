package com.mbridge.msdk.videocommon.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.c;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: VideoCampaignCache.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40935a = "com.mbridge.msdk.videocommon.a.a";

    /* renamed from: b  reason: collision with root package name */
    private static a f40936b;

    /* renamed from: c  reason: collision with root package name */
    private f f40937c;

    private a() {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 != null) {
                this.f40937c = f.a(i.a(j4));
            } else {
                x.d(f40935a, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static a a() {
        if (f40936b == null) {
            synchronized (a.class) {
                if (f40936b == null) {
                    f40936b = new a();
                }
            }
        }
        return f40936b;
    }

    public final int b(String str, int i4, boolean z3, String str2) {
        List<CampaignEx> a4;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            if (z3) {
                a4 = this.f40937c.a(str, 0, 0, i4, str2);
            } else {
                a4 = this.f40937c.a(str, 0, 0, i4, false);
            }
            if (a4 != null) {
                for (CampaignEx campaignEx : a4) {
                    if (campaignEx != null && campaignEx.getReadyState() == 0) {
                        arrayList.add(campaignEx);
                    }
                }
                return arrayList.size();
            }
            return 0;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public final List<CampaignEx> c(String str, int i4, boolean z3, String str2) {
        long W;
        List<CampaignEx> a4;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 != null) {
                W = b4.W();
            } else {
                W = b.a().b().W();
            }
            long j4 = W * 1000;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z3) {
                a4 = this.f40937c.a(str, 0, 0, i4, str2);
            } else {
                a4 = this.f40937c.a(str, 0, 0, i4, false);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (a4 != null) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    for (CampaignEx campaignEx : a4) {
                        if (campaignEx != null && campaignEx.getReadyState() == 0) {
                            long plctb = campaignEx.getPlctb() * 1000;
                            long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                            if ((plctb <= 0 && j4 >= timestamp) || (plctb > 0 && plctb >= timestamp)) {
                                arrayList2.add(campaignEx);
                            }
                        }
                    }
                    return arrayList2;
                } catch (Exception e4) {
                    e = e4;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return null;
        } catch (Exception e5) {
            e = e5;
        }
    }

    public final List<CampaignEx> a(String str, int i4) {
        List<CampaignEx> a4;
        ArrayList arrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (a4 = this.f40937c.a(str, 0, 0, i4)) == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx campaignEx : a4) {
                    if (campaignEx != null) {
                        arrayList2.add(campaignEx);
                    }
                }
                return arrayList2;
            } catch (Exception e4) {
                e = e4;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public final List<CampaignEx> b(String str, int i4, boolean z3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f40937c.a(str, 0, 0, i4, z3);
        } catch (Exception e4) {
            x.d(f40935a, e4.getLocalizedMessage());
            return null;
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2, int i4) {
        f fVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || TextUtils.isEmpty(str2) || (fVar = this.f40937c) == null) {
            return;
        }
        fVar.a(str, list, str2, i4);
    }

    public final void b(String str) {
        ConcurrentHashMap<String, c> g4;
        try {
            if (TextUtils.isEmpty(str) || (g4 = this.f40937c.g(str)) == null || g4.size() <= 0) {
                return;
            }
            com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = b.a().b();
            }
            long W = b4 != null ? b4.W() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            for (c cVar : g4.values()) {
                if (cVar != null) {
                    long d4 = cVar.d();
                    if (d4 <= 0) {
                        d4 = W;
                    }
                    if (cVar.e() + (d4 * 1000) < currentTimeMillis && !TextUtils.isEmpty(cVar.a())) {
                        x.d("HBOPTIMIZE", "\u4e0d\u5728\u6709\u6548\u671f\u8303\u56f4\u5185 \u5220\u9664" + cVar.a());
                        b(str, cVar.a());
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void a(String str, List<CampaignEx> list) {
        f fVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (fVar = this.f40937c) == null) {
            return;
        }
        fVar.b(str, list);
    }

    public final void a(String str, String str2) {
        if (this.f40937c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f40937c.f(str, str2);
    }

    public final synchronized void c(String str, int i4) {
        int aS;
        try {
            com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = b.a().b();
            }
            aS = b4.aS();
        } catch (Exception e4) {
            x.d(f40935a, e4.getMessage());
        }
        if (aS == 0) {
            return;
        }
        boolean z3 = true;
        List<CampaignEx> b5 = this.f40937c.b(str, i4, aS == 2);
        if (b5 != null && b5.size() > 0) {
            for (CampaignEx campaignEx : b5) {
                String requestIdNotice = campaignEx.getRequestIdNotice();
                String id = campaignEx.getId();
                String campaignUnitId = campaignEx.getCampaignUnitId();
                String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
                com.mbridge.msdk.videocommon.a.b(campaignUnitId + "_" + id + "_" + requestIdNotice + "_" + cMPTEntryUrl);
            }
        }
        f fVar = this.f40937c;
        if (aS != 2) {
            z3 = false;
        }
        fVar.a(str, i4, z3);
    }

    public final List<CampaignEx> a(String str, int i4, boolean z3) {
        return a(str, i4, z3, "");
    }

    public final List<CampaignEx> a(String str, int i4, boolean z3, String str2) {
        List<CampaignEx> a4;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.videocommon.d.a b4 = com.mbridge.msdk.videocommon.d.b.a().b();
            long e4 = b4 != null ? b4.e() : 0L;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z3) {
                a4 = this.f40937c.a(str, 0, 0, i4, str2);
            } else {
                a4 = this.f40937c.a(str, 0, 0, i4, false);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (a4 != null) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    for (CampaignEx campaignEx : a4) {
                        if (campaignEx != null && (campaignEx.getReadyState() == 0 || campaignEx.getLoadTimeoutState() == 1)) {
                            long plct = campaignEx.getPlct() * 1000;
                            long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                            if ((plct > 0 && plct >= timestamp) || (plct <= 0 && e4 >= timestamp)) {
                                arrayList2.add(campaignEx);
                            }
                        }
                    }
                    return arrayList2;
                } catch (Exception e5) {
                    e = e5;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
        }
    }

    public final void b(String str, int i4) {
        int size;
        try {
            List<c> f4 = this.f40937c.f(str);
            if (f4 == null || f4.size() <= 0 || (size = f4.size() - i4) <= 0) {
                return;
            }
            for (int i5 = 0; i5 < size; i5++) {
                b(str, f4.get(i5).a());
                d.d(str, f4.get(i5).a());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.d.a b4 = com.mbridge.msdk.videocommon.d.b.a().b();
            long e4 = b4 != null ? b4.e() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            if (list.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    for (CampaignEx campaignEx : list) {
                        if (campaignEx != null) {
                            long plct = campaignEx.getPlct() * 1000;
                            long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                            if ((plct > 0 && plct >= timestamp) || (plct <= 0 && e4 >= timestamp)) {
                                arrayList2.add(campaignEx);
                            }
                        }
                    }
                    return arrayList2;
                } catch (Exception e5) {
                    e = e5;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
        }
    }

    public final synchronized void b(String str, String str2) {
        try {
            this.f40937c.c(str2, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final List<c> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f40937c.f(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (campaignEx.isBidCampaign()) {
                    d.d(str, campaignEx.getRequestId());
                }
                this.f40937c.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getId())) {
                    return;
                }
                this.f40937c.b(campaignEx.getId(), campaignEx.getRequestId());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str2) || list == null || list.size() <= 0) {
                return;
            }
            this.f40937c.a(list, str, str2, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final synchronized void a(long j4, String str) {
        try {
            this.f40937c.a(j4, str);
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(f40935a, e4.getMessage());
        }
    }
}
