package com.mbridge.msdk.foundation.same.p474a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.BidCacheBean;
import com.mbridge.msdk.foundation.entity.BidTokenRuleBean;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.p477d.DisplayInfo;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class StaticDataPoll {

    /* renamed from: a */
    public static Map<String, Long> f30610a = new HashMap();

    /* renamed from: b */
    public static Map<String, List<DisplayInfo>> f30611b = new HashMap();

    /* renamed from: c */
    public static Map<String, List<DisplayInfo>> f30612c = new HashMap();

    /* renamed from: d */
    public static Map<String, List<DisplayInfo>> f30613d = new HashMap();

    /* renamed from: e */
    public static Map<String, List<DisplayInfo>> f30614e = new HashMap();

    /* renamed from: f */
    public static Map<String, List<DisplayInfo>> f30615f = new HashMap();

    /* renamed from: g */
    public static Map<String, List<DisplayInfo>> f30616g = new HashMap();

    /* renamed from: h */
    public static Map<String, List<DisplayInfo>> f30617h = new HashMap();

    /* renamed from: i */
    public static Map<String, List<DisplayInfo>> f30618i = new HashMap();

    /* renamed from: j */
    public static Map<String, List<DisplayInfo>> f30619j = new HashMap();

    /* renamed from: k */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, BidCacheBean>> f30620k = null;

    /* renamed from: l */
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f30621l = null;

    /* renamed from: m */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f30622m = null;

    /* renamed from: n */
    private static final String f30623n = "d";

    /* renamed from: a */
    public static void m22375a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<DisplayInfo>> m22366d = m22366d(str2);
        if (campaignEx == null || m22366d == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(campaignEx.getId())) {
                return;
            }
            DisplayInfo displayInfo = new DisplayInfo(campaignEx.getId(), campaignEx.getRequestIdNotice());
            if (m22366d.containsKey(str)) {
                List<DisplayInfo> list = m22366d.get(str);
                if (list != null && list.size() == 20) {
                    list.remove(0);
                }
                if (list != null) {
                    list.add(displayInfo);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(displayInfo);
            m22366d.put(str, arrayList);
        } catch (Throwable th) {
            SameLogTool.m21735b(f30623n, th.getMessage(), th);
        }
    }

    /* renamed from: b */
    public static String m22370b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        return (TextUtils.isEmpty(str) || (concurrentHashMap = f30621l) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f30621l.get(str)) == null || copyOnWriteArrayList.size() <= 0) ? "" : copyOnWriteArrayList.get(0);
    }

    /* renamed from: c */
    public static void m22367c(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f30622m;
            if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str) || (concurrentHashMap = f30622m.get(str2)) == null || !concurrentHashMap.containsKey(str2)) {
                return;
            }
            concurrentHashMap.remove(str2);
        } catch (Exception e) {
            SameLogTool.m21738a(f30623n, e.getMessage());
        }
    }

    /* renamed from: d */
    public static void m22365d(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, BidCacheBean>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f30620k) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            f30620k.remove(str);
            return;
        }
        ConcurrentHashMap<String, BidCacheBean> concurrentHashMap2 = f30620k.get(str);
        if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str2)) {
            return;
        }
        concurrentHashMap2.remove(str2);
    }

    /* renamed from: b */
    public static BidTokenRuleBean m22369b(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        BidTokenRuleBean bidTokenRuleBean = new BidTokenRuleBean();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return bidTokenRuleBean;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f30622m;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = f30622m.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                bidTokenRuleBean.m22604b(1);
                bidTokenRuleBean.m22601c(concurrentHashMap.get(str2));
            }
        } catch (Exception e) {
            SameLogTool.m21738a(f30623n, e.getMessage());
        }
        return bidTokenRuleBean;
    }

    /* renamed from: c */
    public static ConcurrentHashMap<String, BidCacheBean> m22368c(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, BidCacheBean>> concurrentHashMap = f30620k;
        if (concurrentHashMap == null) {
            CampaignDao m22767a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
            if (m22767a != null) {
                m22767a.m22732e(str, "");
                f30620k = new ConcurrentHashMap<>();
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return f30620k.get(str);
        }
        return null;
    }

    /* renamed from: d */
    private static Map<String, List<DisplayInfo>> m22366d(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1611837702:
                if (str.equals("videofeeds")) {
                    c = 0;
                    break;
                }
                break;
            case -1396342996:
                if (str.equals("banner")) {
                    c = 1;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals("native")) {
                    c = 2;
                    break;
                }
                break;
            case -934326481:
                if (str.equals("reward")) {
                    c = 3;
                    break;
                }
                break;
            case -895866265:
                if (str.equals(MediationConstant.RIT_TYPE_SPLASH)) {
                    c = 4;
                    break;
                }
                break;
            case 538816457:
                if (str.equals("h5_native")) {
                    c = 5;
                    break;
                }
                break;
            case 604727084:
                if (str.equals(MediationConstant.RIT_TYPE_INTERSTITIAL)) {
                    c = 6;
                    break;
                }
                break;
            case 1844104930:
                if (str.equals("interactive")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return f30615f;
            case 1:
                return f30617h;
            case 2:
                return f30612c;
            case 3:
                return f30613d;
            case 4:
                return f30618i;
            case 5:
                return f30619j;
            case 6:
                return f30616g;
            case 7:
                return f30614e;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static String m22374a(String str, String str2) {
        Map<String, List<DisplayInfo>> m22366d;
        List<DisplayInfo> list;
        JSONArray jSONArray = new JSONArray();
        if (TextUtils.isEmpty(str2)) {
            m22366d = null;
            if (f30612c.containsKey(str)) {
                m22366d = f30612c;
            } else if (f30613d.containsKey(str)) {
                m22366d = f30613d;
            } else if (f30614e.containsKey(str)) {
                m22366d = f30614e;
            } else if (f30615f.containsKey(str)) {
                m22366d = f30615f;
            } else if (f30616g.containsKey(str)) {
                m22366d = f30616g;
            } else if (f30617h.containsKey(str)) {
                m22366d = f30617h;
            } else if (f30618i.containsKey(str)) {
                m22366d = f30618i;
            } else if (f30619j.containsKey(str)) {
                m22366d = f30619j;
            }
        } else {
            m22366d = m22366d(str2);
        }
        if (m22366d != null) {
            try {
                if (StringUtils.m21956b(str) && m22366d.containsKey(str) && (list = m22366d.get(str)) != null && list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", list.get(i).m22319a());
                        jSONObject.put("1", list.get(i).m22318b());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    /* renamed from: a */
    public static void m22373a(String str, String str2, int i) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f30621l == null) {
            f30621l = new ConcurrentHashMap<>();
        }
        try {
            if (f30621l.containsKey(str)) {
                copyOnWriteArrayList = f30621l.get(str);
                copyOnWriteArrayList.add(str2);
            } else {
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                copyOnWriteArrayList2.add(str2);
                f30621l.put(str, copyOnWriteArrayList2);
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
            int size = copyOnWriteArrayList.size() - i;
            if (size >= 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    copyOnWriteArrayList.remove(i2);
                }
            }
        } catch (Exception e) {
            SameLogTool.m21738a(f30623n, e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m22376a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f30621l) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f30621l.get(str)) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        copyOnWriteArrayList.remove(0);
    }

    /* renamed from: a */
    public static void m22372a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            if (f30622m == null) {
                f30622m = new ConcurrentHashMap<>();
            }
            if (f30622m.containsKey(str)) {
                if (f30622m.get(str) == null) {
                    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                    concurrentHashMap.put(str2, str3);
                    f30622m.put(str, concurrentHashMap);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap2.put(str2, str3);
            f30622m.put(str, concurrentHashMap2);
        } catch (Exception e) {
            SameLogTool.m21738a(f30623n, e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m22371a(String str, String str2, String str3, long j, long j2, long j3) {
        if (f30620k == null) {
            f30620k = new ConcurrentHashMap<>();
        }
        try {
            if (f30620k.containsKey(str)) {
                ConcurrentHashMap<String, BidCacheBean> concurrentHashMap = f30620k.get(str);
                if (concurrentHashMap != null) {
                    BidCacheBean bidCacheBean = concurrentHashMap.get(str2);
                    if (bidCacheBean == null) {
                        BidCacheBean bidCacheBean2 = new BidCacheBean();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        bidCacheBean2.m22618a(arrayList);
                        bidCacheBean2.m22620a(j);
                        bidCacheBean2.m22615b(j2);
                        bidCacheBean2.m22611c(j3);
                        concurrentHashMap.put(str2, bidCacheBean2);
                        return;
                    } else if (bidCacheBean.m22613c() != null) {
                        bidCacheBean.m22620a(j);
                        bidCacheBean.m22615b(j2);
                        bidCacheBean.m22611c(j3);
                        bidCacheBean.m22613c().add(str3);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str3);
            ConcurrentHashMap<String, BidCacheBean> concurrentHashMap2 = new ConcurrentHashMap<>();
            BidCacheBean bidCacheBean3 = new BidCacheBean();
            bidCacheBean3.m22618a(arrayList2);
            bidCacheBean3.m22620a(j);
            bidCacheBean3.m22615b(j2);
            bidCacheBean3.m22611c(j3);
            concurrentHashMap2.put(str2, bidCacheBean3);
            f30620k.put(str, concurrentHashMap2);
        } catch (Throwable th) {
            SameLogTool.m21733d(f30623n, th.getMessage());
        }
    }
}
