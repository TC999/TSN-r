package com.mbridge.msdk.videocommon.p515d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.videocommon.p513b.AdUnitInfo;
import com.mbridge.msdk.videocommon.p513b.Reward;
import com.mbridge.msdk.videocommon.p514c.RewardSettingController;
import com.mbridge.msdk.videocommon.p514c.RewardSettingResponseHandler;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.videocommon.d.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RewardSettingManager {

    /* renamed from: d */
    private static volatile RewardSettingManager f32220d;

    /* renamed from: c */
    private volatile boolean f32221c = false;

    /* renamed from: e */
    private CopyOnWriteArrayList<String> f32222e = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    private static ConcurrentHashMap<String, RewardUnitSetting> f32219b = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static RewardSetting f32218a = null;

    private RewardSettingManager() {
    }

    /* renamed from: a */
    public static RewardSettingManager m20835a() {
        if (f32220d == null) {
            synchronized (RewardSettingManager.class) {
                if (f32220d == null) {
                    f32220d = new RewardSettingManager();
                }
            }
        }
        return f32220d;
    }

    /* renamed from: d */
    private void m20820d(String str, String str2) {
        if (this.f32221c) {
            return;
        }
        this.f32221c = true;
        new RewardSettingController().m20863a(MBSDKContext.m22865f().m22861j(), str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.mbridge.msdk.videocommon.p515d.RewardSetting m20827b() {
        /*
            r8 = this;
            com.mbridge.msdk.videocommon.d.a r0 = com.mbridge.msdk.videocommon.p515d.RewardSettingManager.f32218a
            if (r0 != 0) goto La3
            com.mbridge.msdk.foundation.a.a.a r0 = com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager.m22949a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "reward_"
            r1.append(r2)
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()
            java.lang.String r2 = r2.m22860k()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.m22944b(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L8c
            com.mbridge.msdk.videocommon.d.a r0 = com.mbridge.msdk.videocommon.p515d.RewardSetting.m20852a(r0)
            java.lang.String r1 = "RewardSettingManager"
            if (r0 == 0) goto L6b
            long r2 = r0.m20847c()
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r0.m20839h()
            long r6 = r6 + r2
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 <= 0) goto L6b
            boolean r2 = com.mbridge.msdk.foundation.tools.SameLogTool.f31161c
            if (r2 == 0) goto L69
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "app setting nexttime is not ready  [settingNextRequestTime= "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = " currentTime = "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = "]"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.mbridge.msdk.foundation.tools.SameLogTool.m21736b(r1, r2)
        L69:
            r1 = 0
            goto L71
        L6b:
            java.lang.String r2 = "app setting timeout or not exists"
            com.mbridge.msdk.foundation.tools.SameLogTool.m21736b(r1, r2)
            r1 = 1
        L71:
            if (r1 != 0) goto L74
            return r0
        L74:
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()
            java.lang.String r0 = r0.m22860k()
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()
            java.lang.String r1 = r1.m22859l()
            r8.m20820d(r0, r1)
            com.mbridge.msdk.videocommon.d.a r0 = r8.m20823c()
            return r0
        L8c:
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()
            java.lang.String r0 = r0.m22860k()
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()
            java.lang.String r1 = r1.m22859l()
            r8.m20820d(r0, r1)
            com.mbridge.msdk.videocommon.d.a r0 = r8.m20823c()
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.p515d.RewardSettingManager.m20827b():com.mbridge.msdk.videocommon.d.a");
    }

    /* renamed from: c */
    public final RewardSetting m20823c() {
        RewardSetting rewardSetting = new RewardSetting();
        HashMap hashMap = new HashMap(5);
        hashMap.put("1", 1000);
        hashMap.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, 1000);
        hashMap.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, 1000);
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put("1", new Reward("Virtual Item", 1));
        rewardSetting.m20851a(hashMap);
        rewardSetting.m20848b(hashMap2);
        rewardSetting.m20853a(43200L);
        rewardSetting.m20849b(5400L);
        rewardSetting.m20846c(3600L);
        rewardSetting.m20844d(3600L);
        rewardSetting.m20842e(5L);
        rewardSetting.m20854a(1);
        return rewardSetting;
    }

    /* renamed from: a */
    public final void m20833a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f32222e.remove(str);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public final void m20830a(String str, String str2, String str3, RewardSettingResponseHandler rewardSettingResponseHandler) {
        if (!TextUtils.isEmpty(str3) && !this.f32222e.contains(str3)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f32222e.add(str3);
            }
            new RewardSettingController().m20862a(MBSDKContext.m22865f().m22861j(), str, str2, str3, rewardSettingResponseHandler);
            return;
        }
        SameLogTool.m21738a("test_reward_unit_setting", "unitID: " + str3 + " is requesting");
    }

    /* renamed from: a */
    public final RewardUnitSetting m20832a(String str, String str2) {
        RewardUnitSetting rewardUnitSetting;
        String str3 = "reward_" + str + "_" + str2;
        if (f32219b.containsKey(str3)) {
            boolean z = false;
            try {
                rewardUnitSetting = f32219b.get(str3);
                try {
                    z = m20834a(rewardUnitSetting);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                rewardUnitSetting = null;
            }
            if (z) {
                m20830a(str, MBSDKContext.m22865f().m22859l(), str2, null);
            }
            return rewardUnitSetting;
        }
        RewardUnitSetting m20794c = RewardUnitSetting.m20794c(SharedPerferenceManager.m22949a().m22944b(str3));
        if (m20834a(m20794c)) {
            m20830a(str, MBSDKContext.m22865f().m22859l(), str2, null);
            return null;
        }
        f32219b.put(str3, m20794c);
        return m20794c;
    }

    /* renamed from: b */
    public final void m20826b(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m20835a().m20829a(MBSDKContext.m22865f().m22860k(), str, false);
        final String str2 = RewardUnitSetting.f32227a;
        if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            C11385e.m22074a(m22861j, str2, str, 2, "alert url is exception ,url:" + str2);
            return;
        }
        H5DownLoadManager.getInstance().downloadH5Res(str2, new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.videocommon.d.b.1
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str3, String str4) {
                C11385e.m22074a(MBSDKContext.m22865f().m22861j(), str2, str, 2, str4);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str3) {
                C11385e.m22074a(MBSDKContext.m22865f().m22861j(), str2, str, 1, "");
            }
        });
    }

    /* renamed from: c */
    public static boolean m20822c(String str) {
        JSONArray optJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (optJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String optString = optJSONArray.optJSONObject(0).optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (optJSONArray.length() > 0) {
                    if (!TextUtils.isEmpty(optString)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public final void m20825b(String str, String str2) {
        SharedPerferenceManager.m22949a().m22945a("reward_" + str, str2);
        f32218a = RewardSetting.m20852a(str2);
    }

    /* renamed from: c */
    public final RewardUnitSetting m20821c(String str, String str2) {
        String str3 = "reward_" + str + "_" + str2;
        if (f32219b.containsKey(str3)) {
            return f32219b.get(str3);
        }
        return RewardUnitSetting.m20794c(SharedPerferenceManager.m22949a().m22944b(str3));
    }

    /* renamed from: a */
    public final RewardUnitSetting m20829a(String str, String str2, boolean z) {
        RewardUnitSetting rewardUnitSetting;
        String str3 = "reward_" + str + "_" + str2;
        if (f32219b.containsKey(str3)) {
            boolean z2 = false;
            try {
                rewardUnitSetting = f32219b.get(str3);
                try {
                    z2 = m20834a(rewardUnitSetting);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                rewardUnitSetting = null;
            }
            if (z2) {
                m20830a(str, MBSDKContext.m22865f().m22859l(), str2, null);
            }
            return rewardUnitSetting;
        }
        RewardUnitSetting m20794c = RewardUnitSetting.m20794c(SharedPerferenceManager.m22949a().m22944b(str3));
        if (!m20834a(m20794c)) {
            f32219b.put(str3, m20794c);
            return m20794c;
        } else if (m20794c == null) {
            m20830a(str, MBSDKContext.m22865f().m22859l(), str2, null);
            return m20824b(z);
        } else {
            return m20794c;
        }
    }

    /* renamed from: b */
    private static RewardUnitSetting m20824b(boolean z) {
        RewardUnitSetting rewardUnitSetting = new RewardUnitSetting();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AdUnitInfo(1, 15, null));
            rewardUnitSetting.m20802a((List<AdUnitInfo>) arrayList);
            rewardUnitSetting.m20770n(1);
            rewardUnitSetting.m20772m(1);
            rewardUnitSetting.m20768o(1);
            rewardUnitSetting.m20760s(1);
            rewardUnitSetting.m20806a(1.0d);
            rewardUnitSetting.m20799b(1.0d);
            rewardUnitSetting.m20758t(2);
            rewardUnitSetting.m20766p(2);
            rewardUnitSetting.m20764q(1);
            rewardUnitSetting.m20762r(1);
            rewardUnitSetting.m20780i(3);
            rewardUnitSetting.m20778j(80);
            rewardUnitSetting.m20776k(100);
            rewardUnitSetting.m20774l(0);
            rewardUnitSetting.m20782h(2);
            rewardUnitSetting.m20786f(-1);
            rewardUnitSetting.m20750x(70);
            rewardUnitSetting.m20789e(2);
            if (z) {
                rewardUnitSetting.m20792d(5);
            } else {
                rewardUnitSetting.m20792d(-1);
            }
            rewardUnitSetting.m20795c(0);
            rewardUnitSetting.m20798b(0);
            rewardUnitSetting.m20784g(1);
            rewardUnitSetting.m20756u(1);
            rewardUnitSetting.m20805a(0);
            rewardUnitSetting.m20752w(3);
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            arrayList2.add(4);
            arrayList2.add(6);
            rewardUnitSetting.m20803a(arrayList2);
            rewardUnitSetting.m20748y(1);
            rewardUnitSetting.m20746z(1);
            rewardUnitSetting.m20818A(60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rewardUnitSetting;
    }

    /* renamed from: a */
    private final boolean m20834a(RewardUnitSetting rewardUnitSetting) {
        RewardSetting m20827b = m20827b();
        if (m20827b == null || rewardUnitSetting == null) {
            return true;
        }
        long m20845d = m20827b.m20845d();
        long currentTimeMillis = System.currentTimeMillis();
        long m20751x = rewardUnitSetting.m20751x() + m20845d;
        if (m20751x > currentTimeMillis) {
            if (SameLogTool.f31161c) {
                SameLogTool.m21736b("RewardSettingManager", "unit setting  nexttime is not ready  [settingNextRequestTime= " + m20751x + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final void m20831a(String str, String str2, String str3) {
        String str4 = "reward_" + str + "_" + str2;
        SharedPerferenceManager.m22949a().m22945a(str4, str3);
        f32219b.put(str4, RewardUnitSetting.m20794c(str3));
    }

    /* renamed from: a */
    public final void m20828a(boolean z) {
        this.f32221c = z;
    }
}
