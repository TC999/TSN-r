package com.mbridge.msdk.p465e;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.LoopEntity;
import com.mbridge.msdk.foundation.p472db.CampaignDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.UnitIDDao;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.reward.adapter.d;
import com.mbridge.msdk.videocommon.p515d.RewardSetting;
import com.mbridge.msdk.videocommon.p515d.RewardSettingManager;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.mbridge.msdk.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class LoopTimer {

    /* renamed from: a */
    private long f30176a;

    /* renamed from: b */
    private boolean f30177b;

    /* renamed from: c */
    private LinkedList<LoopEntity> f30178c;

    /* renamed from: d */
    private LinkedList<LoopEntity> f30179d;

    /* renamed from: e */
    private int f30180e;

    /* renamed from: f */
    private int f30181f;

    /* renamed from: g */
    private CampaignDao f30182g;

    /* renamed from: h */
    private RewardSetting f30183h;

    /* renamed from: i */
    private UnitIDDao f30184i;

    /* renamed from: j */
    private CommonSDKDBHelper f30185j;

    /* renamed from: k */
    private Handler f30186k;

    /* compiled from: LoopTimer.java */
    /* renamed from: com.mbridge.msdk.e.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11244a {

        /* renamed from: a */
        static LoopTimer f30190a = new LoopTimer();
    }

    /* renamed from: c */
    static /* synthetic */ void m22960c(LoopTimer loopTimer) {
        try {
            LinkedList<LoopEntity> linkedList = loopTimer.f30178c;
            if (linkedList != null && linkedList.size() > 0 && loopTimer.f30180e < loopTimer.f30178c.size()) {
                LoopEntity loopEntity = loopTimer.f30178c.get(loopTimer.f30180e);
                loopTimer.f30180e++;
                if (loopTimer.m22965a(loopEntity)) {
                    loopTimer.m22963a(loopEntity.m22519b(), loopEntity.m22520a(), false);
                }
            } else {
                LinkedList<LoopEntity> linkedList2 = loopTimer.f30179d;
                if (linkedList2 != null && linkedList2.size() > 0 && loopTimer.f30181f < loopTimer.f30179d.size()) {
                    LoopEntity loopEntity2 = loopTimer.f30179d.get(loopTimer.f30181f);
                    loopTimer.f30181f++;
                    if (loopTimer.m22965a(loopEntity2)) {
                        loopTimer.m22963a(loopEntity2.m22519b(), loopEntity2.m22520a(), true);
                    }
                }
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("LoopTimer", th.getMessage(), th);
        }
    }

    private LoopTimer() {
        this.f30177b = false;
        this.f30178c = new LinkedList<>();
        this.f30179d = new LinkedList<>();
        this.f30180e = 0;
        this.f30181f = 0;
        this.f30186k = new Handler() { // from class: com.mbridge.msdk.e.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                synchronized (LoopTimer.this) {
                    int i = message.what;
                    if (i != 1) {
                        if (i == 2) {
                            LoopTimer.m22960c(LoopTimer.this);
                        }
                    } else if (LoopTimer.this.f30177b) {
                    } else {
                        LoopTimer loopTimer = LoopTimer.this;
                        LoopTimer.m22966a(loopTimer, loopTimer.f30176a);
                        sendMessageDelayed(obtainMessage(1), LoopTimer.this.f30176a);
                    }
                }
            }
        };
    }

    /* renamed from: a */
    private boolean m22965a(LoopEntity loopEntity) {
        boolean z = false;
        if (loopEntity == null || TextUtils.isEmpty(loopEntity.m22520a())) {
            return false;
        }
        String m22520a = loopEntity.m22520a();
        try {
            if (this.f30182g != null) {
                RewardSetting rewardSetting = this.f30183h;
                int m22755a = this.f30182g.m22755a(m22520a, rewardSetting != null ? rewardSetting.m20843e() : 0L);
                if (m22755a != -1) {
                    if (m22755a != 1) {
                    }
                } else if (!TextUtils.isEmpty(m22520a)) {
                    LinkedList<LoopEntity> linkedList = this.f30178c;
                    if (linkedList != null && linkedList.contains(m22520a)) {
                        this.f30178c.remove(m22520a);
                    } else {
                        LinkedList<LoopEntity> linkedList2 = this.f30179d;
                        if (linkedList2 != null && linkedList2.contains(m22520a)) {
                            this.f30179d.remove(m22520a);
                        }
                    }
                    UnitIDDao unitIDDao = this.f30184i;
                    if (unitIDDao != null) {
                        unitIDDao.m22666a(m22520a);
                    }
                }
                try {
                    Handler handler = this.f30186k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th) {
                    th = th;
                    SameLogTool.m21735b("LoopTimer", th.getMessage(), th);
                    return z;
                }
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    /* renamed from: b */
    public final void m22961b(String str, String str2) {
        if (this.f30179d.contains(str2)) {
            return;
        }
        this.f30179d.add(new LoopEntity(str, str2, 287));
        UnitIDDao unitIDDao = this.f30184i;
        if (unitIDDao != null) {
            unitIDDao.m22665a(str, str2, 287);
        }
    }

    /* renamed from: a */
    private void m22963a(String str, String str2, boolean z) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                return;
            }
            final d dVar = new d(m22861j, str, str2);
            dVar.a(z);
            dVar.a(new b() { // from class: com.mbridge.msdk.e.a.2
                /* renamed from: a */
                public final void m22958a() {
                }

                /* renamed from: a */
                public final void m22957a(String str3) {
                    LoopTimer.this.f30186k.sendMessage(LoopTimer.this.f30186k.obtainMessage(2));
                    dVar.a((b) null);
                }

                /* renamed from: b */
                public final void m22956b(String str3) {
                    LoopTimer.this.f30186k.sendMessage(LoopTimer.this.f30186k.obtainMessage(2));
                    dVar.a((b) null);
                }
            });
            dVar.a(1, 8000, false);
        } catch (Exception e) {
            SameLogTool.m21735b("LoopTimer", e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public final void m22964a(String str, String str2) {
        if (this.f30178c.contains(str2)) {
            return;
        }
        this.f30178c.add(new LoopEntity(str, str2, 94));
        UnitIDDao unitIDDao = this.f30184i;
        if (unitIDDao != null) {
            unitIDDao.m22665a(str, str2, 94);
        }
    }

    /* renamed from: a */
    public final void m22968a(long j) {
        if (this.f30185j == null) {
            this.f30185j = CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j());
        }
        if (this.f30184i == null) {
            this.f30184i = UnitIDDao.m22667a(this.f30185j);
        }
        List<LoopEntity> m22668a = this.f30184i.m22668a(287);
        if (m22668a != null) {
            this.f30179d.addAll(m22668a);
            for (LoopEntity loopEntity : m22668a) {
                m22961b(loopEntity.m22519b(), loopEntity.m22520a());
            }
        }
        List<LoopEntity> m22668a2 = this.f30184i.m22668a(94);
        if (m22668a2 != null) {
            this.f30178c.addAll(m22668a2);
            for (LoopEntity loopEntity2 : m22668a2) {
                m22964a(loopEntity2.m22519b(), loopEntity2.m22520a());
            }
        }
        if (this.f30182g == null) {
            this.f30182g = CampaignDao.m22767a(this.f30185j);
        }
        if (this.f30183h == null) {
            this.f30183h = RewardSettingManager.m20835a().m20827b();
        }
        this.f30176a = j;
        this.f30177b = false;
        Handler handler = this.f30186k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f30176a);
    }

    /* renamed from: a */
    static /* synthetic */ void m22966a(LoopTimer loopTimer, long j) {
        LinkedList<LoopEntity> linkedList = loopTimer.f30178c;
        if (linkedList == null || linkedList.size() <= 0 || loopTimer.f30180e == 0 || loopTimer.f30178c.size() <= loopTimer.f30180e) {
            LinkedList<LoopEntity> linkedList2 = loopTimer.f30179d;
            if (linkedList2 == null || linkedList2.size() <= 0 || loopTimer.f30181f == 0 || loopTimer.f30179d.size() == loopTimer.f30181f) {
                loopTimer.f30181f = 0;
                loopTimer.f30180e = 0;
                Handler handler = loopTimer.f30186k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }
}
