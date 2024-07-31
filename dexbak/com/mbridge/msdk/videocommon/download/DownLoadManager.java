package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.UnitSetting;
import com.mbridge.msdk.videocommon.listener.VideoDownloadListener;
import com.mbridge.msdk.videocommon.p515d.RewardSettingManager;
import com.mbridge.msdk.videocommon.p515d.RewardUnitSetting;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.mbridge.msdk.videocommon.download.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownLoadManager {

    /* renamed from: a */
    private static DownLoadManager f32326a;

    /* renamed from: b */
    private ThreadPoolExecutor f32327b;

    /* renamed from: c */
    private boolean f32328c = false;

    /* renamed from: d */
    private ConcurrentHashMap<String, UnitCacheCtroller> f32329d = new ConcurrentHashMap<>();

    /* renamed from: e */
    private Map<String, List<Map<String, CampaignDownLoadTask>>> f32330e;

    /* renamed from: f */
    private Map<String, List<CampaignEx>> f32331f;

    /* renamed from: g */
    private Map<String, List<CampaignDownLoadTask>> f32332g;

    private DownLoadManager() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.f32327b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static DownLoadManager getInstance() {
        if (f32326a == null) {
            synchronized (DownLoadManager.class) {
                if (f32326a == null) {
                    f32326a = new DownLoadManager();
                }
            }
        }
        return f32326a;
    }

    /* renamed from: a */
    public final CampaignDownLoadTask m20676a(String str, String str2) {
        UnitCacheCtroller m20671c = m20671c(str);
        if (m20671c != null) {
            return m20671c.m20661a(str2);
        }
        return null;
    }

    /* renamed from: b */
    public final List<CampaignDownLoadTask> m20674b(String str) {
        Map<String, List<CampaignDownLoadTask>> map = this.f32332g;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f32332g.get(str);
    }

    /* renamed from: c */
    public final UnitCacheCtroller m20671c(String str) {
        ConcurrentHashMap<String, UnitCacheCtroller> concurrentHashMap = this.f32329d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f32329d.get(str);
    }

    public UnitCacheCtroller createUnitCache(Context context, String str, List<CampaignEx> list, int i, VideoDownloadListener videoDownloadListener) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return null;
        }
        if (this.f32329d.containsKey(str)) {
            UnitCacheCtroller unitCacheCtroller = this.f32329d.get(str);
            if (i != 94 && i != 287) {
                unitCacheCtroller.m20662a(videoDownloadListener);
            } else {
                unitCacheCtroller.m20658a(list.get(0).getRequestId(), videoDownloadListener);
            }
            unitCacheCtroller.m20657a(list);
            return unitCacheCtroller;
        }
        UnitCacheCtroller unitCacheCtroller2 = new UnitCacheCtroller(context, list, this.f32327b, str, i);
        if (videoDownloadListener != null) {
            unitCacheCtroller2.m20662a(videoDownloadListener);
        }
        this.f32329d.put(str, unitCacheCtroller2);
        return unitCacheCtroller2;
    }

    public void load(String str) {
        UnitCacheCtroller m20671c = m20671c(str);
        if (m20671c != null) {
            m20671c.m20670a();
        }
    }

    /* renamed from: a */
    public final List<CampaignEx> m20677a(String str) {
        Map<String, List<CampaignEx>> map = this.f32331f;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f32331f.get(str);
    }

    /* renamed from: b */
    public final int m20673b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, CampaignDownLoadTask>> m20648c;
        CampaignDownLoadTask value;
        CampaignEx m20704g;
        ConcurrentHashMap<String, UnitCacheCtroller> concurrentHashMap = this.f32329d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, UnitCacheCtroller> entry : concurrentHashMap.entrySet()) {
                UnitCacheCtroller value2 = entry.getValue();
                if (value2 != null && (m20648c = value2.m20648c()) != null) {
                    int size = m20648c.size();
                    for (int i = 0; i < size; i++) {
                        Map<String, CampaignDownLoadTask> map = m20648c.get(i);
                        if (map != null) {
                            Iterator<Map.Entry<String, CampaignDownLoadTask>> it = map.entrySet().iterator();
                            if (it.hasNext() && (value = it.next().getValue()) != null && (m20704g = value.m20704g()) != null) {
                                String videoUrlEncode = m20704g.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return value.m20707f();
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

    /* renamed from: a */
    public final boolean m20680a(int i, String str, boolean z) {
        try {
            UnitCacheCtroller m20671c = m20671c(str);
            if (m20671c != null) {
                return m20671c.m20668a(i, z) != null;
            }
            return false;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m20679a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list) {
        return m20678a(i, str, z, i2, z2, i3, list, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01b5, code lost:
        if (r3.containsKey(r16) == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b7, code lost:
        r14.f32332g.remove(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bc, code lost:
        r3 = r14.f32331f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01be, code lost:
        if (r3 != null) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c0, code lost:
        r14.f32331f = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01cc, code lost:
        if (r3.containsKey(r16) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ce, code lost:
        r14.f32331f.remove(r16);
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
        r8 = r6.m20704g();
        r7.put(r8.getId() + r8.getVideoUrlEncode() + r8.getBidToken(), r6);
        r3.add(r7);
        r4.add(r8);
        r5.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x022e, code lost:
        r14.f32330e.put(r16, r3);
        r14.f32331f.put(r16, r4);
        r14.f32332g.put(r16, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0127, code lost:
        if (r5.size() >= r18) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0189, code lost:
        if (r4.size() > 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x018e, code lost:
        r3 = r14.f32330e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0190, code lost:
        if (r3 != null) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0192, code lost:
        r14.f32330e = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x019e, code lost:
        if (r3.containsKey(r16) == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a0, code lost:
        r14.f32330e.remove(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01a5, code lost:
        r3 = r14.f32332g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a7, code lost:
        if (r3 != null) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a9, code lost:
        r14.f32332g = new java.util.HashMap();
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m20678a(int r15, java.lang.String r16, boolean r17, int r18, boolean r19, int r20, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.DownLoadManager.m20678a(int, java.lang.String, boolean, int, boolean, int, java.util.List, boolean):boolean");
    }

    public UnitCacheCtroller createUnitCache(Context context, String str, CampaignEx campaignEx, int i, VideoDownloadListener videoDownloadListener) {
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.f32329d.containsKey(str)) {
            UnitCacheCtroller unitCacheCtroller = this.f32329d.get(str);
            if (i != 94 && i != 287) {
                unitCacheCtroller.m20662a(videoDownloadListener);
            } else {
                unitCacheCtroller.m20658a(campaignEx.getRequestId(), videoDownloadListener);
            }
            unitCacheCtroller.m20667a(campaignEx);
            return unitCacheCtroller;
        }
        UnitCacheCtroller unitCacheCtroller2 = new UnitCacheCtroller(context, campaignEx, this.f32327b, str, i);
        if (videoDownloadListener != null) {
            unitCacheCtroller2.m20662a(videoDownloadListener);
        }
        this.f32329d.put(str, unitCacheCtroller2);
        return unitCacheCtroller2;
    }

    /* renamed from: b */
    public final void m20672b(boolean z) {
        if (z) {
            if (this.f32328c) {
                return;
            }
        } else {
            this.f32328c = false;
        }
        ConcurrentHashMap<String, UnitCacheCtroller> concurrentHashMap = this.f32329d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, UnitCacheCtroller> entry : concurrentHashMap.entrySet()) {
                entry.getValue().m20670a();
            }
        }
    }

    /* renamed from: a */
    public final void m20675a(boolean z) {
        this.f32328c = z;
        ConcurrentHashMap<String, UnitCacheCtroller> concurrentHashMap = this.f32329d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, UnitCacheCtroller> entry : concurrentHashMap.entrySet()) {
                UnitCacheCtroller value = entry.getValue();
                if (value != null) {
                    value.m20655b();
                }
            }
        }
    }

    /* renamed from: a */
    public final void m20681a() {
        ConcurrentHashMap<String, UnitCacheCtroller> concurrentHashMap = this.f32329d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, UnitCacheCtroller> entry : concurrentHashMap.entrySet()) {
                UnitCacheCtroller value = entry.getValue();
                String key = entry.getKey();
                try {
                    RewardUnitSetting m20832a = RewardSettingManager.m20835a().m20832a(MBSDKContext.m22865f().m22860k(), key);
                    if (m20832a != null) {
                        if (m20832a.m20753w() == 2) {
                            value.m20655b();
                        } else {
                            value.m20670a();
                        }
                    }
                } catch (Exception e) {
                    SameLogTool.m21733d("DownLoadManager", e.getMessage());
                    try {
                        if (!TextUtils.isEmpty(key)) {
                            UnitSetting m23244e = SettingManager.m23261a().m23244e(MBSDKContext.m22865f().m22860k(), key);
                            if (m23244e == null) {
                                m23244e = UnitSetting.m23194e(key);
                            }
                            if (m23244e.m23186k() == 2) {
                                value.m20655b();
                            } else {
                                value.m20670a();
                            }
                        }
                    } catch (Exception e2) {
                        SameLogTool.m21733d("DownLoadManager", e2.getMessage());
                    }
                }
            }
        }
    }
}
