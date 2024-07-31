package com.mbridge.msdk.videocommon.p512a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.BidCacheBean;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.p474a.StaticDataPoll;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.videocommon.TemplateWebviewCache;
import com.mbridge.msdk.videocommon.p515d.RewardSetting;
import com.mbridge.msdk.videocommon.p515d.RewardSettingManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.mbridge.msdk.videocommon.a.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class VideoCampaignCache {

    /* renamed from: a */
    private static final String f32187a = "com.mbridge.msdk.videocommon.a.a";

    /* renamed from: b */
    private static VideoCampaignCache f32188b;

    /* renamed from: c */
    private CampaignDao f32189c;

    private VideoCampaignCache() {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j != null) {
                this.f32189c = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(m22861j));
            } else {
                SameLogTool.m21733d(f32187a, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static VideoCampaignCache m20904a() {
        if (f32188b == null) {
            synchronized (VideoCampaignCache.class) {
                if (f32188b == null) {
                    f32188b = new VideoCampaignCache();
                }
            }
        }
        return f32188b;
    }

    /* renamed from: b */
    public final int m20884b(String str, int i, boolean z, String str2) {
        List<CampaignEx> m22759a;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                m22759a = this.f32189c.m22760a(str, 0, 0, i, str2);
            } else {
                m22759a = this.f32189c.m22759a(str, 0, 0, i, false);
            }
            if (m22759a != null) {
                for (CampaignEx campaignEx : m22759a) {
                    if (campaignEx != null && campaignEx.getReadyState() == 0) {
                        arrayList.add(campaignEx);
                    }
                }
                return arrayList.size();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: c */
    public final List<CampaignEx> m20880c(String str, int i, boolean z, String str2) {
        long m23408W;
        List<CampaignEx> m22759a;
        ArrayList arrayList = null;
        try {
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b != null) {
                m23408W = m23252b.m23408W();
            } else {
                m23408W = SettingManager.m23261a().m23253b().m23408W();
            }
            long j = m23408W * 1000;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                m22759a = this.f32189c.m22760a(str, 0, 0, i, str2);
            } else {
                m22759a = this.f32189c.m22759a(str, 0, 0, i, false);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (m22759a != null) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    for (CampaignEx campaignEx : m22759a) {
                        if (campaignEx != null && campaignEx.getReadyState() == 0) {
                            long plctb = campaignEx.getPlctb() * 1000;
                            long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                            if ((plctb <= 0 && j >= timestamp) || (plctb > 0 && plctb >= timestamp)) {
                                arrayList2.add(campaignEx);
                            }
                        }
                    }
                    return arrayList2;
                } catch (Exception e) {
                    e = e;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: a */
    public final List<CampaignEx> m20897a(String str, int i) {
        List<CampaignEx> m22761a;
        ArrayList arrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (m22761a = this.f32189c.m22761a(str, 0, 0, i)) == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx campaignEx : m22761a) {
                    if (campaignEx != null) {
                        arrayList2.add(campaignEx);
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: b */
    public final List<CampaignEx> m20885b(String str, int i, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f32189c.m22759a(str, 0, 0, i, z);
        } catch (Exception e) {
            SameLogTool.m21733d(f32187a, e.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: a */
    public final void m20891a(String str, List<CampaignEx> list, String str2, int i) {
        CampaignDao campaignDao;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || TextUtils.isEmpty(str2) || (campaignDao = this.f32189c) == null) {
            return;
        }
        campaignDao.m22749a(str, list, str2, i);
    }

    /* renamed from: b */
    public final void m20887b(String str) {
        ConcurrentHashMap<String, BidCacheBean> m22729g;
        try {
            if (TextUtils.isEmpty(str) || (m22729g = this.f32189c.m22729g(str)) == null || m22729g.size() <= 0) {
                return;
            }
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            long m23408W = m23252b != null ? m23252b.m23408W() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            for (BidCacheBean bidCacheBean : m22729g.values()) {
                if (bidCacheBean != null) {
                    long m22610d = bidCacheBean.m22610d();
                    if (m22610d <= 0) {
                        m22610d = m23408W;
                    }
                    if (bidCacheBean.m22609e() + (m22610d * 1000) < currentTimeMillis && !TextUtils.isEmpty(bidCacheBean.m22622a())) {
                        SameLogTool.m21733d("HBOPTIMIZE", "不在有效期范围内 删除" + bidCacheBean.m22622a());
                        m20883b(str, bidCacheBean.m22622a());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m20892a(String str, List<CampaignEx> list) {
        CampaignDao campaignDao;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (campaignDao = this.f32189c) == null) {
            return;
        }
        campaignDao.m22739b(str, list);
    }

    /* renamed from: a */
    public final void m20894a(String str, String str2) {
        if (this.f32189c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f32189c.m22730f(str, str2);
    }

    /* renamed from: c */
    public final synchronized void m20881c(String str, int i) {
        int m23379aS;
        try {
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            m23379aS = m23252b.m23379aS();
        } catch (Exception e) {
            SameLogTool.m21733d(f32187a, e.getMessage());
        }
        if (m23379aS == 0) {
            return;
        }
        boolean z = true;
        List<CampaignEx> m22741b = this.f32189c.m22741b(str, i, m23379aS == 2);
        if (m22741b != null && m22741b.size() > 0) {
            for (CampaignEx campaignEx : m22741b) {
                String requestIdNotice = campaignEx.getRequestIdNotice();
                String id = campaignEx.getId();
                String campaignUnitId = campaignEx.getCampaignUnitId();
                String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
                TemplateWebviewCache.m20909b(campaignUnitId + "_" + id + "_" + requestIdNotice + "_" + cMPTEntryUrl);
            }
        }
        CampaignDao campaignDao = this.f32189c;
        if (m23379aS != 2) {
            z = false;
        }
        campaignDao.m22756a(str, i, z);
    }

    /* renamed from: a */
    public final List<CampaignEx> m20896a(String str, int i, boolean z) {
        return m20895a(str, i, z, "");
    }

    /* renamed from: a */
    public final List<CampaignEx> m20895a(String str, int i, boolean z, String str2) {
        List<CampaignEx> m22759a;
        ArrayList arrayList = null;
        try {
            RewardSetting m20827b = RewardSettingManager.m20835a().m20827b();
            long m20843e = m20827b != null ? m20827b.m20843e() : 0L;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                m22759a = this.f32189c.m22760a(str, 0, 0, i, str2);
            } else {
                m22759a = this.f32189c.m22759a(str, 0, 0, i, false);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (m22759a != null) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    for (CampaignEx campaignEx : m22759a) {
                        if (campaignEx != null && (campaignEx.getReadyState() == 0 || campaignEx.getLoadTimeoutState() == 1)) {
                            long plct = campaignEx.getPlct() * 1000;
                            long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                            if ((plct > 0 && plct >= timestamp) || (plct <= 0 && m20843e >= timestamp)) {
                                arrayList2.add(campaignEx);
                            }
                        }
                    }
                    return arrayList2;
                } catch (Exception e) {
                    e = e;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: b */
    public final void m20886b(String str, int i) {
        int size;
        try {
            List<BidCacheBean> m22731f = this.f32189c.m22731f(str);
            if (m22731f == null || m22731f.size() <= 0 || (size = m22731f.size() - i) <= 0) {
                return;
            }
            for (int i2 = 0; i2 < size; i2++) {
                m20883b(str, m22731f.get(i2).m22622a());
                StaticDataPoll.m22365d(str, m22731f.get(i2).m22622a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final List<CampaignEx> m20890a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            RewardSetting m20827b = RewardSettingManager.m20835a().m20827b();
            long m20843e = m20827b != null ? m20827b.m20843e() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            if (list.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    for (CampaignEx campaignEx : list) {
                        if (campaignEx != null) {
                            long plct = campaignEx.getPlct() * 1000;
                            long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                            if ((plct > 0 && plct >= timestamp) || (plct <= 0 && m20843e >= timestamp)) {
                                arrayList2.add(campaignEx);
                            }
                        }
                    }
                    return arrayList2;
                } catch (Exception e) {
                    e = e;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: b */
    public final synchronized void m20883b(String str, String str2) {
        try {
            this.f32189c.m22736c(str2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final List<BidCacheBean> m20899a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f32189c.m22731f(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final void m20901a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (campaignEx.isBidCampaign()) {
                    StaticDataPoll.m22365d(str, campaignEx.getRequestId());
                }
                this.f32189c.m22751a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m20902a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getId())) {
                    return;
                }
                this.f32189c.m22740b(campaignEx.getId(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m20893a(String str, String str2, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str2) || list == null || list.size() <= 0) {
                return;
            }
            this.f32189c.m22745a(list, str, str2, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final synchronized void m20903a(long j, String str) {
        try {
            this.f32189c.m22769a(j, str);
        } catch (Exception e) {
            e.printStackTrace();
            SameLogTool.m21733d(f32187a, e.getMessage());
        }
    }
}
