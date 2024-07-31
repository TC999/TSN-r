package com.beizi.fusion.p071f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdLifeControl;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.FreqUtil;
import com.beizi.fusion.p072g.StringUtil;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.f.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdStrategy {
    /* renamed from: a */
    public static List<AdSpacesBean.ForwardBean> m48528a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, String str) {
        String content;
        ArrayList arrayList = new ArrayList();
        if (componentBean == null || list == null || list.size() == 0 || (content = componentBean.getContent()) == null) {
            return arrayList;
        }
        char c = 65535;
        switch (content.hashCode()) {
            case -938285885:
                if (content.equals("random")) {
                    c = 0;
                    break;
                }
                break;
            case 3135262:
                if (content.equals(CommonNetImpl.FAIL)) {
                    c = 1;
                    break;
                }
                break;
            case 3529469:
                if (content.equals(TTLogUtil.TAG_EVENT_SHOW)) {
                    c = 2;
                    break;
                }
                break;
            case 94750088:
                if (content.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                    c = 3;
                    break;
                }
                break;
            case 1095692943:
                if (content.equals("request")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                m48529a(componentBean, arrayList);
                break;
            case 1:
                m48527a(componentBean, list, str, arrayList, "280.500");
                break;
            case 2:
                m48527a(componentBean, list, str, arrayList, "280.300");
                break;
            case 3:
                m48527a(componentBean, list, str, arrayList, "290.300");
                break;
            case 4:
                m48527a(componentBean, list, str, arrayList, "200.000");
                break;
        }
        return arrayList;
    }

    /* renamed from: b */
    private static boolean m48521b(List<AdSpacesBean.RulesBean> list, int i) {
        boolean z;
        if (list == null) {
            return false;
        }
        if (list.size() == 0) {
            C3116af.m48494c("BeiZis", "enter rulesBeanList.size() == 0");
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (m48526a(list.get(i2), i)) {
                return true;
            }
        }
        return z;
    }

    /* renamed from: c */
    private static String m48520c(String str) {
        C3116af.m48496a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return StringUtil.m48307b().equals(str) ? "BEIZI" : str;
    }

    /* renamed from: b */
    public static String m48522b(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtil.m48307b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) {
            return "6666";
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2130632690:
                if (str.equals("INMOBI")) {
                    c = 0;
                    break;
                }
                break;
            case -2114267227:
                if (str.equals("JADYUN")) {
                    c = 1;
                    break;
                }
                break;
            case -1935975824:
                if (str.equals("FinalLink")) {
                    c = 2;
                    break;
                }
                break;
            case -416293903:
                if (str.equals("ADSCOPE")) {
                    c = 3;
                    break;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    c = 4;
                    break;
                }
                break;
            case 67034:
                if (str.equals("CSJ")) {
                    c = 5;
                    break;
                }
                break;
            case 70423:
                if (str.equals("GDT")) {
                    c = 6;
                    break;
                }
                break;
            case 76672:
                if (str.equals("MTG")) {
                    c = 7;
                    break;
                }
                break;
            case 62961147:
                if (str.equals("BAIDU")) {
                    c = '\b';
                    break;
                }
                break;
            case 615517703:
                if (str.equals("GDT_NST")) {
                    c = '\t';
                    break;
                }
                break;
            case 1780672330:
                if (str.equals("CSJ_NST")) {
                    c = '\n';
                    break;
                }
                break;
            case 1921014029:
                if (str.equals("KUAISHOU")) {
                    c = 11;
                    break;
                }
                break;
            case 2141820391:
                if (str.equals("HUAWEI")) {
                    c = '\f';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "1011";
            case 1:
                return "1021";
            case 2:
                return "6668";
            case 3:
                return "8888";
            case 4:
                return "1022";
            case 5:
                return "1013";
            case 6:
                return "1012";
            case 7:
                return "1023";
            case '\b':
                return "1018";
            case '\t':
                return "1016";
            case '\n':
                return "1017";
            case 11:
                return "1019";
            case '\f':
                return "1020";
            default:
                return null;
        }
    }

    /* renamed from: a */
    private static void m48527a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, String str, List<AdSpacesBean.ForwardBean> list2, String str2) {
        C3116af.m48494c("BeiZis", "enter handleSpaceStrategyByEvent eventCode = " + str2);
        List<AdSpacesBean.ForwardBean> forward = componentBean.getForward();
        if (forward == null || forward.size() <= 0) {
            return;
        }
        int m48163a = FreqUtil.m48163a(str, str2);
        if (!str2.equalsIgnoreCase("200.000")) {
            m48163a++;
        }
        for (int i = 0; i < forward.size(); i++) {
            AdSpacesBean.ForwardBean forwardBean = forward.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                AdSpacesBean.BuyerBean buyerBean = list.get(i2);
                if (buyerBean.getId() != null && buyerBean.getId().equalsIgnoreCase(forwardBean.getBuyerId()) && buyerBean.getBuyerSpaceUuId() != null && buyerBean.getBuyerSpaceUuId().equalsIgnoreCase(forwardBean.getBuyerSpaceUuId())) {
                    C3116af.m48494c("BeiZis", forwardBean.getBuyerId() + " handleSpaceRequestStrategy buyerBean match");
                    if (m48521b(forwardBean.getRules(), m48163a)) {
                        C3116af.m48494c("BeiZis", forwardBean.getBuyerId() + " enter rulesMatch");
                        list2.add(forwardBean);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected static void m48529a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.ForwardBean> list) {
        List<AdSpacesBean.ForwardBean> forward = componentBean.getForward();
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        C3116af.m48496a("BeiZis", "AdForward random:" + random);
        if (forward == null || forward.size() <= 0) {
            return;
        }
        int size = forward.size();
        for (int i = 0; i < size; i++) {
            AdSpacesBean.ForwardBean forwardBean = forward.get(i);
            List<AdSpacesBean.RulesBean> rules = forwardBean.getRules();
            if (rules != null && rules.size() > 0) {
                int size2 = rules.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Integer[] results = rules.get(i2).getResults();
                    if (results != null && results.length >= 2) {
                        int intValue = results[0].intValue();
                        int intValue2 = results[1].intValue();
                        if (intValue <= random && random <= intValue2) {
                            list.add(forwardBean);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m48526a(AdSpacesBean.RulesBean rulesBean, int i) {
        boolean z = false;
        if (rulesBean == null) {
            return false;
        }
        try {
            String formula = rulesBean.getFormula();
            String replace = formula.replace("x", i + "");
            int m48517a = PolandNotation.m48517a(replace);
            Integer[] results = rulesBean.getResults();
            C3116af.m48494c("BeiZis", "formulaOrig = " + replace + ",isOneRuleMatch holderNum = " + i);
            if (results != null && results.length >= 2) {
                C3116af.m48494c("BeiZis", "formulaResult = " + m48517a + ",results[0] = " + results[0] + ",results[1] = " + results[1]);
                if (m48517a >= results[0].intValue() && m48517a <= results[1].intValue()) {
                    z = true;
                }
            }
            return rulesBean.getRules() != null ? z & m48521b(rulesBean.getRules(), i) : z;
        } catch (Exception unused) {
            C3116af.m48494c("BeiZis", "execute formula error!");
            return z;
        }
    }

    /* renamed from: a */
    public static void m48531a(Context context, long j, AdSpacesBean.FilterBean filterBean, ObserverAdStatus observerAdStatus, String str, String str2, String str3, AdLifeControl adLifeControl) {
        boolean z;
        boolean z2;
        if (observerAdStatus != null) {
            C3116af.m48496a("BeiZis", "channel = " + str2 + ",observer.mPlatformFilterStatus.getStatus() = " + observerAdStatus.f10960c.m48971a() + ",observer.mChannelFilterStatus.getStatus(channelId) = " + observerAdStatus.f10962e.m48969a(str2));
        }
        boolean z3 = true;
        boolean z4 = !TextUtils.isEmpty(str2);
        if (observerAdStatus == null || !(observerAdStatus.f10960c.m48971a() == 1 || observerAdStatus.f10962e.m48969a(str2) == 2)) {
            if (observerAdStatus != null) {
                if (z4) {
                    observerAdStatus.f10962e.m48968a(str2, -2);
                    return;
                } else {
                    observerAdStatus.f10960c.m48970a(-2);
                    return;
                }
            } else if (adLifeControl == null || z4) {
                return;
            } else {
                adLifeControl.mo48728a("status not PlatformFilterStatus.kPlatformFilterStatusBegin");
                return;
            }
        }
        boolean z5 = false;
        if (filterBean != null) {
            List<String> privilege = filterBean.getPrivilege();
            boolean m48530a = (privilege == null || privilege.size() <= 0) ? true : m48530a(context, privilege);
            z2 = j > ((long) filterBean.getMinAdLoadTime());
            try {
                z3 = FreqUtil.m48160a(filterBean.getFrequency(), str, m48520c(str2), str3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            z = z3;
            z3 = m48530a;
        } else {
            if (z4) {
                observerAdStatus.f10962e.m48968a(str2, 3);
            } else {
                observerAdStatus.f10960c.m48970a(2);
            }
            z = true;
            z5 = true;
            z2 = true;
        }
        if (!z3) {
            if (z4) {
                observerAdStatus.f10962e.m48968a(str2, 5);
            } else {
                observerAdStatus.f10960c.m48970a(4);
            }
        }
        if (!z2) {
            if (z4) {
                observerAdStatus.f10962e.m48968a(str2, 6);
            } else {
                observerAdStatus.f10960c.m48970a(5);
            }
        }
        if (!z) {
            if (z4) {
                observerAdStatus.f10962e.m48968a(str2, 7);
            } else {
                observerAdStatus.f10960c.m48970a(6);
            }
        }
        if (!z5 && z3 && z2 && z) {
            if (z4) {
                observerAdStatus.f10962e.m48968a(str2, 3);
            } else {
                observerAdStatus.f10960c.m48970a(2);
            }
        }
    }

    /* renamed from: a */
    public static int m48525a(String str) {
        String m48522b;
        if (str == null || (m48522b = m48522b(str)) == null) {
            return -1;
        }
        return Integer.parseInt(m48522b);
    }

    /* renamed from: a */
    private static boolean m48530a(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        for (String str : list) {
            if (-1 == packageManager.checkPermission(str, packageName)) {
                Log.d("lance", "required permission not granted . permission = " + str);
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static AdSpacesBean.BuyerBean m48524a(String str, List<AdSpacesBean.BuyerBean> list, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("buyerBeans != null ? ");
        sb.append(list != null);
        C3116af.m48494c("BeiZis", sb.toString());
        if (list != null) {
            C3116af.m48494c("BeiZis", "buyerBeans.size() = " + list.size());
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            AdSpacesBean.BuyerBean buyerBean = list.get(i);
            C3116af.m48494c("BeiZis", "AdBuyer buyerBean.getUuid() = " + buyerBean.getBuyerSpaceUuId());
            if (buyerBean.getId() != null && buyerBean.getId().equals(str) && str2 != null && str2.equalsIgnoreCase(buyerBean.getBuyerSpaceUuId())) {
                return buyerBean;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m48523a(List<AdSpacesBean.BuyerBean.RenderRulesBean> list, int i) {
        Integer[] results;
        if (list == null) {
            return null;
        }
        try {
            if (list.size() == 0) {
                return null;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                AdSpacesBean.BuyerBean.RenderRulesBean renderRulesBean = list.get(i2);
                if (renderRulesBean != null && (results = renderRulesBean.getResults()) != null && results.length >= 2 && i >= results[0].intValue() && i <= results[1].intValue()) {
                    String type = renderRulesBean.getType();
                    C3116af.m48494c("BeiZis", "type = " + type + ";holderNum:" + i);
                    return type;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
