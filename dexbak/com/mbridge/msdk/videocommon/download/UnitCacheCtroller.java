package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameOptimizedController;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.UnitSetting;
import com.mbridge.msdk.videocommon.listener.VideoDownloadListener;
import com.mbridge.msdk.videocommon.p515d.RewardSetting;
import com.mbridge.msdk.videocommon.p515d.RewardSettingManager;
import com.mbridge.msdk.videocommon.p515d.RewardUnitSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* renamed from: com.mbridge.msdk.videocommon.download.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class UnitCacheCtroller {

    /* renamed from: e */
    private VideoDownloadListener f32337e;

    /* renamed from: f */
    private ConcurrentHashMap<String, VideoDownloadListener> f32338f;

    /* renamed from: j */
    private ExecutorService f32342j;

    /* renamed from: l */
    private String f32344l;

    /* renamed from: m */
    private RewardUnitSetting f32345m;

    /* renamed from: o */
    private int f32347o;

    /* renamed from: c */
    private List<CampaignEx> f32335c = new ArrayList();

    /* renamed from: d */
    private boolean f32336d = true;

    /* renamed from: g */
    private DownLoadTaskSelfProgressListener f32339g = new DownLoadTaskSelfProgressListener() { // from class: com.mbridge.msdk.videocommon.download.d.1
        @Override // com.mbridge.msdk.videocommon.download.DownLoadTaskSelfProgressListener
        /* renamed from: a */
        public final void mo20642a(long j, int i) {
            if (i == 5 || i == 4) {
                UnitCacheCtroller.this.f32336d = true;
                UnitCacheCtroller.this.m20670a();
            }
            if (i == 2) {
                UnitCacheCtroller.this.f32336d = true;
            }
        }
    };

    /* renamed from: h */
    private CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> f32340h = new CopyOnWriteArrayList<>();

    /* renamed from: k */
    private long f32343k = 3600;

    /* renamed from: n */
    private int f32346n = 2;

    /* renamed from: a */
    UnitSetting f32333a = null;

    /* renamed from: b */
    UnitSetting f32334b = null;

    /* renamed from: i */
    private Context f32341i = MBSDKContext.m22865f().m22861j();

    public UnitCacheCtroller(Context context, List<CampaignEx> list, ExecutorService executorService, String str, int i) {
        this.f32347o = 1;
        List<CampaignEx> list2 = this.f32335c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.f32342j = executorService;
        this.f32344l = str;
        this.f32347o = i;
        m20649b(this.f32335c);
    }

    /* renamed from: d */
    private void m20646d() {
        CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> copyOnWriteArrayList;
        if (SameOptimizedController.m21727a().m21724a("u_n_c_e_d", true) || (copyOnWriteArrayList = this.f32340h) == null) {
            return;
        }
        try {
            synchronized (copyOnWriteArrayList) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (i < this.f32340h.size()) {
                    Map<String, CampaignDownLoadTask> map = this.f32340h.get(i);
                    for (Map.Entry<String, CampaignDownLoadTask> entry : map.entrySet()) {
                        CampaignDownLoadTask value = entry.getValue();
                        if (value != null) {
                            if (currentTimeMillis - value.m20718c() > this.f32343k * 1000 && value.m20707f() == 1) {
                                value.m20720b("download timeout");
                                value.m20744a(this.f32346n);
                                value.m20692m();
                                this.f32340h.remove(map);
                                i--;
                            }
                            if (value.m20707f() != 1 && value.m20707f() != 5 && value.m20707f() != 0) {
                                value.m20692m();
                                this.f32340h.remove(map);
                                i--;
                            }
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m20644e() {
        CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> copyOnWriteArrayList = this.f32340h;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i = 0;
                    while (i < this.f32340h.size()) {
                        Map<String, CampaignDownLoadTask> map = this.f32340h.get(i);
                        for (Map.Entry<String, CampaignDownLoadTask> entry : map.entrySet()) {
                            CampaignDownLoadTask value = entry.getValue();
                            if (value != null && value.m20704g() != null && value.m20727b()) {
                                value.m20694l();
                                this.f32340h.remove(map);
                                i--;
                            }
                        }
                        i++;
                    }
                }
            } catch (Throwable unused) {
                SameLogTool.m21733d("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    /* renamed from: c */
    public final CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> m20648c() {
        return this.f32340h;
    }

    /* renamed from: b */
    private void m20649b(List<CampaignEx> list) {
        CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> copyOnWriteArrayList;
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        m20644e();
        m20646d();
        int i = this.f32347o;
        if (i != 1) {
            if (i != 287) {
                if (i == 298) {
                    UnitSetting m23242f = SettingManager.m23261a().m23242f(MBSDKContext.m22865f().m22860k(), this.f32344l);
                    this.f32334b = m23242f;
                    if (m23242f == null) {
                        this.f32334b = SettingManager.m23261a().m23246d(MBSDKContext.m22865f().m22860k(), this.f32344l);
                    }
                    UnitSetting unitSetting = this.f32334b;
                    if (unitSetting != null) {
                        this.f32343k = unitSetting.m23188i();
                        this.f32346n = this.f32334b.m23186k();
                    }
                } else if (i != 94) {
                    if (i == 95) {
                        try {
                            if (!TextUtils.isEmpty(this.f32344l)) {
                                UnitSetting m23244e = SettingManager.m23261a().m23244e(MBSDKContext.m22865f().m22860k(), this.f32344l);
                                if (m23244e == null) {
                                    m23244e = UnitSetting.m23194e(this.f32344l);
                                }
                                if (m23244e != null) {
                                    this.f32343k = m23244e.m23188i();
                                    this.f32346n = m23244e.m23186k();
                                }
                            }
                        } catch (Exception unused) {
                            SameLogTool.m21733d("UnitCacheCtroller", "make sure your had put feeds jar into your project");
                            return;
                        }
                    }
                }
            }
            try {
                RewardSetting m20827b = RewardSettingManager.m20835a().m20827b();
                if (m20827b == null) {
                    RewardSettingManager.m20835a().m20823c();
                }
                if (m20827b != null) {
                    this.f32343k = m20827b.m20841f();
                }
                if (!TextUtils.isEmpty(this.f32344l)) {
                    this.f32345m = RewardSettingManager.m20835a().m20832a(MBSDKContext.m22865f().m22860k(), this.f32344l);
                }
                RewardUnitSetting rewardUnitSetting = this.f32345m;
                if (rewardUnitSetting != null) {
                    this.f32346n = rewardUnitSetting.m20753w();
                }
            } catch (Exception unused2) {
                SameLogTool.m21733d("UnitCacheCtroller", "make sure your had put reward jar into your project");
                return;
            }
        } else {
            try {
                if (!TextUtils.isEmpty(this.f32344l)) {
                    UnitSetting m23244e2 = SettingManager.m23261a().m23244e(MBSDKContext.m22865f().m22860k(), this.f32344l);
                    this.f32333a = m23244e2;
                    if (m23244e2 == null) {
                        this.f32333a = UnitSetting.m23196d(this.f32344l);
                    }
                    UnitSetting unitSetting2 = this.f32333a;
                    if (unitSetting2 != null) {
                        this.f32343k = unitSetting2.m23188i();
                        this.f32346n = this.f32333a.m23186k();
                    }
                }
            } catch (Exception unused3) {
                SameLogTool.m21733d("UnitCacheCtroller", "make sure your had put feeds jar into your project");
                return;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            CampaignEx campaignEx = list.get(i2);
            if (campaignEx != null) {
                int i3 = this.f32347o;
                String str = (i3 != 94 && i3 != 287) ? campaignEx.getId() + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken() : campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                if ((m20647c(campaignEx) || !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) && (copyOnWriteArrayList = this.f32340h) != null) {
                    synchronized (copyOnWriteArrayList) {
                        int i4 = 0;
                        while (true) {
                            try {
                                if (i4 >= this.f32340h.size()) {
                                    z = false;
                                    break;
                                }
                                Map<String, CampaignDownLoadTask> map = this.f32340h.get(i4);
                                if (map != null && map.containsKey(str)) {
                                    CampaignDownLoadTask campaignDownLoadTask = map.get(str);
                                    campaignDownLoadTask.m20739a(campaignEx);
                                    campaignDownLoadTask.m20744a(this.f32346n);
                                    campaignDownLoadTask.m20728a(false);
                                    map.remove(str);
                                    map.put(str, campaignDownLoadTask);
                                    this.f32340h.set(i4, map);
                                    z = true;
                                    break;
                                }
                                i4++;
                            } catch (Throwable unused4) {
                            }
                        }
                        if (!z) {
                            CampaignDownLoadTask campaignDownLoadTask2 = new CampaignDownLoadTask(this.f32341i, campaignEx, this.f32344l, this.f32346n);
                            campaignDownLoadTask2.m20744a(this.f32346n);
                            campaignDownLoadTask2.m20712d(this.f32347o);
                            HashMap hashMap = new HashMap();
                            hashMap.put(str, campaignDownLoadTask2);
                            this.f32340h.add(hashMap);
                        }
                    }
                }
            }
        }
        List<CampaignEx> list2 = this.f32335c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.f32335c.clear();
    }

    /* renamed from: c */
    private boolean m20647c(CampaignEx campaignEx) {
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

    /* renamed from: a */
    public final void m20662a(VideoDownloadListener videoDownloadListener) {
        this.f32337e = videoDownloadListener;
    }

    /* renamed from: a */
    public final void m20658a(String str, VideoDownloadListener videoDownloadListener) {
        if (this.f32338f == null) {
            this.f32338f = new ConcurrentHashMap<>();
        }
        this.f32338f.put(str, videoDownloadListener);
    }

    /* renamed from: a */
    public final void m20657a(List<CampaignEx> list) {
        List<CampaignEx> list2 = this.f32335c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        m20649b(this.f32335c);
    }

    /* renamed from: a */
    public final void m20667a(CampaignEx campaignEx) {
        List<CampaignEx> list = this.f32335c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        m20649b(this.f32335c);
    }

    /* renamed from: a */
    public final List<CampaignDownLoadTask> m20660a(String str, int i, boolean z, List<CampaignEx> list, boolean z2) {
        Iterator<Map.Entry<String, CampaignDownLoadTask>> it;
        Iterator<Map.Entry<String, CampaignDownLoadTask>> it2;
        boolean z3 = z;
        boolean z4 = z2;
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> copyOnWriteArrayList = this.f32340h;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    while (i2 < this.f32340h.size()) {
                        Map<String, CampaignDownLoadTask> map = this.f32340h.get(i2);
                        Iterator<Map.Entry<String, CampaignDownLoadTask>> it3 = map.entrySet().iterator();
                        while (it3.hasNext()) {
                            CampaignDownLoadTask value = it3.next().getValue();
                            if (value != null && value.m20704g() != null) {
                                CampaignEx m20704g = value.m20704g();
                                boolean z5 = false;
                                for (CampaignEx campaignEx : list) {
                                    if (m20704g == null || campaignEx == null || TextUtils.isEmpty(m20704g.getRequestId()) || TextUtils.isEmpty(campaignEx.getRequestId())) {
                                        it2 = it3;
                                    } else {
                                        it2 = it3;
                                        if (m20704g.getId().equals(campaignEx.getId()) && m20704g.getRequestId().equals(campaignEx.getRequestId())) {
                                            z5 = true;
                                        }
                                    }
                                    it3 = it2;
                                }
                                it = it3;
                                if (!z5) {
                                    SameLogTool.m21736b("UnitCacheCtroller", "UnitCache isReady ==== Campaign isAvailable = " + z5);
                                } else if ((z3 && !m20704g.isBidCampaign()) || (!z3 && m20704g.isBidCampaign())) {
                                    SameLogTool.m21736b("UnitCacheCtroller", "UnitCache isReady ==== isBidCampaign = " + z3 + " campaign.isBidCampaign() = " + m20704g.isBidCampaign());
                                } else {
                                    String str2 = m20704g.getendcard_url();
                                    String videoUrlEncode = m20704g.getVideoUrlEncode();
                                    String m22634e = m20704g.getRewardTemplateMode() != null ? m20704g.getRewardTemplateMode().m22634e() : "";
                                    m20704g.getRewardTemplateMode();
                                    if (i == 94 || i == 287) {
                                        if (!TextUtils.isEmpty(m22634e) && !m22634e.contains(CampaignEx.KEY_IS_CMPT_ENTRY) && !m20669a(i, m20704g, m22634e)) {
                                            SameLogTool.m21736b("UnitCacheCtroller", "UnitCache isReady ====  templateZipDownload check false continue");
                                        } else if (m20650b(str2, m20704g)) {
                                            if (value.m20727b()) {
                                                value.m20694l();
                                                SameLogTool.m21736b("UnitCacheCtroller", "isready endcard下载完 但是offer展示过 continue");
                                            } else if (StringUtils.m21957a(videoUrlEncode)) {
                                                SameLogTool.m21736b("UnitCacheCtroller", "endcard为基准 endcard和图片下载完成 videourl为空不用下载 return task");
                                                arrayList.add(value);
                                            } else if (m20665a(value, m20653b(m20704g), z4)) {
                                                SameLogTool.m21736b("UnitCacheCtroller", "endcard为基准 endcard 图片 和 videourl 下载完成 return task");
                                                arrayList.add(value);
                                            }
                                        }
                                    }
                                    boolean isEmpty = TextUtils.isEmpty(value.m20696k());
                                    int m20707f = value.m20707f();
                                    SameLogTool.m21738a("UnitCacheCtroller", "isready unit state:" + m20707f);
                                    if (m20707f == 5) {
                                        if (value.m20727b()) {
                                            value.m20694l();
                                            this.f32340h.remove(map);
                                            i2--;
                                            SameLogTool.m21736b("UnitCacheCtroller", "isready state == DownLoadConstant.DOWNLOAD_DONE 但是offer展示过 continue");
                                            z3 = z;
                                            z4 = z2;
                                            it3 = it;
                                        } else {
                                            if (!isEmpty) {
                                                value.m20743a(0, 0);
                                                if (i == 95) {
                                                    SameLogTool.m21736b("UnitCacheCtroller", "isready ==========done but isEffectivePath:" + isEmpty + " is feed" + i);
                                                    arrayList.add(value);
                                                } else {
                                                    SameLogTool.m21736b("UnitCacheCtroller", "isready !isEffectivePath continue");
                                                }
                                            } else if (m20659a(str2, m20704g)) {
                                                SameLogTool.m21736b("UnitCacheCtroller", "isready videourl为基准 state＝done endcard 图片 和 videourl 下载完成 return task");
                                                arrayList.add(value);
                                            } else {
                                                SameLogTool.m21736b("UnitCacheCtroller", "isready done but continue");
                                                return null;
                                            }
                                            z4 = z2;
                                        }
                                    } else {
                                        if (!SameOptimizedController.m21727a().m21724a("u_n_c_e_d", true)) {
                                            long m20718c = value.m20718c();
                                            if (value.m20707f() == 1 && currentTimeMillis - m20718c > this.f32343k * 1000) {
                                                value.m20720b("download timeout");
                                                value.m20692m();
                                                this.f32340h.remove(map);
                                                i2--;
                                                if (i == 1 || i == 94) {
                                                    SameLogTool.m21736b("UnitCacheCtroller", "isready download !timeout continue");
                                                    z3 = z;
                                                    z4 = z2;
                                                    it3 = it;
                                                }
                                            }
                                            if (m20707f == 4 || m20707f == 2) {
                                                this.f32340h.remove(map);
                                                value.m20692m();
                                                i2--;
                                                SameLogTool.m21736b("UnitCacheCtroller", "isready stop continue");
                                                z3 = z;
                                                z4 = z2;
                                                it3 = it;
                                            }
                                        }
                                        if (m20707f == 1) {
                                            if (value.m20727b()) {
                                                SameLogTool.m21736b("UnitCacheCtroller", "isready run 已经被展示过 continue");
                                                z4 = z2;
                                            } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                z4 = z2;
                                                if (m20665a(value, m20653b(m20704g), z4) && m20659a(str2, m20704g)) {
                                                    SameLogTool.m21736b("UnitCacheCtroller", "isready  IS_DOWANLOAD_FINSH_PLAY is :" + MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY);
                                                    arrayList.add(value);
                                                }
                                                if ((i != 94 || i == 287) && m20665a(value, m20653b(m20704g), z4) && m20659a(str2, m20704g)) {
                                                    arrayList.add(value);
                                                }
                                            }
                                        }
                                        z4 = z2;
                                        if (i != 94) {
                                        }
                                        arrayList.add(value);
                                    }
                                }
                                z3 = z;
                                it3 = it;
                            }
                            it = it3;
                            SameLogTool.m21736b("UnitCacheCtroller", "UnitCache isReady ==== task 或者 campaign为空 continue");
                            z3 = z;
                            it3 = it;
                        }
                        i2++;
                        z3 = z;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    private int m20643e(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f32334b == null) {
                    this.f32334b = SettingManager.m23261a().m23248c(MBSDKContext.m22865f().m22860k(), this.f32344l);
                }
                return this.f32334b.m23193f();
            } else if (campaignEx.getAdType() == 42) {
                return m20645d(null);
            } else {
                if (this.f32345m == null) {
                    this.f32345m = RewardSettingManager.m20835a().m20829a(MBSDKContext.m22865f().m22860k(), this.f32344l, false);
                }
                return this.f32345m.m20763r();
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("UnitCacheCtroller", th.getMessage(), th);
            return 100;
        }
    }

    public UnitCacheCtroller(Context context, CampaignEx campaignEx, ExecutorService executorService, String str, int i) {
        this.f32347o = 1;
        List<CampaignEx> list = this.f32335c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        this.f32342j = executorService;
        this.f32344l = str;
        this.f32347o = i;
        m20649b(this.f32335c);
    }

    /* renamed from: d */
    private int m20645d(CampaignEx campaignEx) {
        try {
            UnitSetting unitSetting = this.f32333a;
            if (unitSetting != null) {
                return unitSetting.m23193f();
            }
            return 100;
        } catch (Exception unused) {
            return 100;
        }
    }

    /* renamed from: b */
    private int m20653b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (campaignEx.getReady_rate() != -1) {
                int ready_rate = campaignEx.getReady_rate();
                SameLogTool.m21738a("UnitCacheCtroller", "ready_rate(campaign): " + ready_rate);
                return ready_rate;
            }
            int m20643e = m20643e(campaignEx);
            SameLogTool.m21738a("UnitCacheCtroller", "ready_rate(reward_unit_setting): " + m20643e);
            return m20643e;
        }
        return -1;
    }

    /* renamed from: b */
    private boolean m20650b(String str, CampaignEx campaignEx) {
        if (!campaignEx.isMraid() && !TextUtils.isEmpty(str)) {
            if (campaignEx.getLoadTimeoutState() != 1 || m20647c(campaignEx)) {
                if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                    SameLogTool.m21736b("UnitCacheCtroller", "Is not check endCard download status : " + str);
                    return true;
                } else if (StringUtils.m21956b(H5DownLoadManager.getInstance().getH5ResAddress(str))) {
                    SameLogTool.m21736b("UnitCacheCtroller", "endcard zip 下载完成 return true endcardUrl:" + str);
                    return true;
                } else if (StringUtils.m21956b(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str))) {
                    SameLogTool.m21736b("UnitCacheCtroller", "endcard url 源码 下载完成 return true endcardUrl:" + str);
                    return true;
                } else {
                    SameLogTool.m21736b("UnitCacheCtroller", "checkEndcardZipOrSourceDownLoad endcardUrl return false endcardUrl:" + str);
                    return false;
                }
            }
            return true;
        }
        SameLogTool.m21736b("UnitCacheCtroller", "Campaign is Mraid, do not need download endcardurl or Campaign load timeout");
        return true;
    }

    /* renamed from: b */
    public final CampaignDownLoadTask m20654b(int i, boolean z) {
        try {
            return m20668a(i, z);
        } catch (Throwable th) {
            SameLogTool.m21735b("UnitCacheCtroller", th.getMessage(), th);
            return null;
        }
    }

    /* renamed from: b */
    public final void m20655b() {
        CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> copyOnWriteArrayList = this.f32340h;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    Iterator<Map<String, CampaignDownLoadTask>> it = this.f32340h.iterator();
                    while (it.hasNext()) {
                        Map<String, CampaignDownLoadTask> next = it.next();
                        if (next != null) {
                            for (Map.Entry<String, CampaignDownLoadTask> entry : next.entrySet()) {
                                CampaignDownLoadTask value = entry.getValue();
                                if (value != null && value.m20707f() == 1) {
                                    SameLogTool.m21736b("UnitCacheCtroller", "暂停所有下载");
                                    value.m20720b("playing and stop download");
                                    value.m20692m();
                                    this.f32340h.remove(next);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.mbridge.msdk.videocommon.download.CampaignDownLoadTask m20668a(int r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.UnitCacheCtroller.m20668a(int, boolean):com.mbridge.msdk.videocommon.download.a");
    }

    /* renamed from: b */
    public final void m20651b(String str) {
        CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> copyOnWriteArrayList;
        try {
            synchronized (this.f32340h) {
                if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.f32340h) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<Map<String, CampaignDownLoadTask>> it = this.f32340h.iterator();
                    while (it.hasNext()) {
                        Map<String, CampaignDownLoadTask> next = it.next();
                        if (next != null) {
                            for (Map.Entry<String, CampaignDownLoadTask> entry : next.entrySet()) {
                                if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                    this.f32340h.remove(next);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static boolean m20666a(CampaignDownLoadTask campaignDownLoadTask, int i) {
        long m20702h = campaignDownLoadTask.m20702h();
        long m20710e = campaignDownLoadTask.m20710e();
        if (TextUtils.isEmpty(campaignDownLoadTask.m20745a())) {
            SameLogTool.m21738a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i == 0) {
            if (campaignDownLoadTask.m20704g() != null && !TextUtils.isEmpty(campaignDownLoadTask.m20704g().getVideoUrlEncode())) {
                return true;
            }
        } else if (m20710e > 0 && m20702h * 100 >= m20710e * i) {
            if (i != 100 || campaignDownLoadTask.m20707f() == 5) {
                return true;
            }
            campaignDownLoadTask.m20692m();
            return false;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m20665a(CampaignDownLoadTask campaignDownLoadTask, int i, boolean z) {
        long m20702h = campaignDownLoadTask.m20702h();
        long m20710e = campaignDownLoadTask.m20710e();
        if (TextUtils.isEmpty(campaignDownLoadTask.m20745a())) {
            SameLogTool.m21738a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx m20704g = campaignDownLoadTask.m20704g();
        if (m20704g != null) {
            if (m20704g.getRsIgnoreCheckRule() != null && m20704g.getRsIgnoreCheckRule().size() > 0 && m20704g.getRsIgnoreCheckRule().contains(0)) {
                SameLogTool.m21736b("UnitCacheCtroller", "Is not check video download status");
                if (campaignDownLoadTask.m20688o()) {
                    SameLogTool.m21736b("UnitCacheCtroller", "video file download failed and check ready rate return true");
                    return true;
                }
                return campaignDownLoadTask.m20686p();
            } else if (m20704g.getIsTimeoutCheckVideoStatus() == 1 && m20704g.getVideoCheckType() == 1) {
                return true;
            } else {
                if (z && m20704g.getVideoCheckType() == 1) {
                    if (i == 0) {
                        return true;
                    }
                    if ((m20710e != 0 || m20702h != 0) && m20702h >= (i / 100) * m20710e) {
                        m20704g.setIsTimeoutCheckVideoStatus(1);
                        return true;
                    }
                }
            }
        }
        return m20666a(campaignDownLoadTask, i);
    }

    /* renamed from: a */
    private boolean m20659a(String str, CampaignEx campaignEx) {
        try {
        } catch (Throwable th) {
            SameLogTool.m21735b("UnitCacheCtroller", th.getMessage(), th);
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
            SameLogTool.m21736b("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } else if (!campaignEx.isDynamicView() || SameTool.m21973j(str)) {
            if (StringUtils.m21957a(str)) {
                SameLogTool.m21736b("UnitCacheCtroller", "checkEndcardDownload endcardUrl is null return true");
                return true;
            }
            if (m20650b(str, campaignEx)) {
                SameLogTool.m21736b("UnitCacheCtroller", "checkEndcardDownload endcardUrl done return true");
                return true;
            }
            SameLogTool.m21736b("UnitCacheCtroller", "checkEndcardDownload endcardUrl return false");
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    private boolean m20669a(int i, CampaignEx campaignEx, String str) {
        SameLogTool.m21738a("UnitCacheCtroller", "check template " + str);
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
            SameLogTool.m21736b("UnitCacheCtroller", "Is not check template download status");
            return true;
        }
        if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0) {
            SameLogTool.m21738a("UnitCacheCtroller", "check template 下载情况：" + H5DownLoadManager.getInstance().getH5ResAddress(str));
            if (H5DownLoadManager.getInstance().getH5ResAddress(str) == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final CampaignDownLoadTask m20661a(String str) {
        CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> copyOnWriteArrayList = this.f32340h;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                Iterator<Map<String, CampaignDownLoadTask>> it = this.f32340h.iterator();
                while (it.hasNext()) {
                    Map<String, CampaignDownLoadTask> next = it.next();
                    if (next != null && next.containsKey(str)) {
                        return next.get(str);
                    }
                }
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m20656a(CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, CampaignDownLoadTask>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map<String, CampaignDownLoadTask> next = it.next();
                if (next != null) {
                    for (Map.Entry<String, CampaignDownLoadTask> entry : next.entrySet()) {
                        if (entry.getValue().m20707f() == 1) {
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m20670a() {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.UnitCacheCtroller.m20670a():void");
    }
}
