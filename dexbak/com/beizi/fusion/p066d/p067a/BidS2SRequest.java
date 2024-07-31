package com.beizi.fusion.p066d.p067a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.p067a.BidS2SRequestModel;
import com.beizi.fusion.p066d.p067a.BidS2SResponseModel;
import com.beizi.fusion.p071f.AdStrategy;
import com.beizi.fusion.p072g.AesUtils;
import com.beizi.fusion.p072g.C3112ad;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3156l;
import com.beizi.fusion.p072g.HttpUtil;
import com.beizi.fusion.p072g.StringUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.beizi.fusion.d.a.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BidS2SRequest {

    /* renamed from: a */
    private InterfaceC3057a f10973a;

    /* renamed from: b */
    private String f10974b = "1002";

    /* renamed from: c */
    private String f10975c = "不出价";

    /* renamed from: d */
    private String f10976d = "1003";

    /* renamed from: e */
    private String f10977e = "网络错误";

    /* renamed from: f */
    private String f10978f = "1004";

    /* renamed from: g */
    private String f10979g = "未找到渠道buyer";

    /* compiled from: BidS2SRequest.java */
    /* renamed from: com.beizi.fusion.d.a.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3057a {
        /* renamed from: a */
        void mo48660a();

        /* renamed from: a */
        void mo48659a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str, double d);

        /* renamed from: a */
        void mo48658a(String str, int i);

        /* renamed from: a */
        void mo48657a(String str, String str2, String str3, int i);
    }

    public BidS2SRequest(InterfaceC3057a interfaceC3057a) {
        this.f10973a = interfaceC3057a;
    }

    /* renamed from: a */
    public void m48853a(final Context context, final String str, final String str2, final List<AdSpacesBean.ForwardBean> list, final List<AdSpacesBean.BuyerBean> list2, final int i) {
        if (this.f10973a == null) {
            return;
        }
        if (context != null && i > 0 && !list.isEmpty() && !list2.isEmpty()) {
            for (AdSpacesBean.ForwardBean forwardBean : list) {
                AdSpacesBean.BuyerBean m48524a = AdStrategy.m48524a(forwardBean.getBuyerId(), list2, forwardBean.getBuyerSpaceUuId());
                if (m48524a != null && "S2S".equalsIgnoreCase(m48524a.getBidType())) {
                    this.f10973a.mo48658a(m48524a.getBuyerSpaceUuId(), 18);
                }
            }
            C3156l.m48242a().execute(new Runnable() { // from class: com.beizi.fusion.d.a.a.1
                /* JADX WARN: Removed duplicated region for block: B:28:0x0089 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:31:0x001a A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        r12 = this;
                        java.util.ArrayList r6 = new java.util.ArrayList
                        r6.<init>()
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r4.<init>()
                        java.util.ArrayList r5 = new java.util.ArrayList
                        r5.<init>()
                        java.util.ArrayList r7 = new java.util.ArrayList
                        r7.<init>()
                        java.util.List r0 = r2
                        java.util.Iterator r0 = r0.iterator()
                    L1a:
                        boolean r1 = r0.hasNext()
                        if (r1 == 0) goto Ldd
                        java.lang.Object r1 = r0.next()
                        com.beizi.fusion.model.AdSpacesBean$ForwardBean r1 = (com.beizi.fusion.model.AdSpacesBean.ForwardBean) r1
                        java.lang.String r2 = r1.getBuyerId()
                        java.util.List r3 = r3
                        java.lang.String r8 = r1.getBuyerSpaceUuId()
                        com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = com.beizi.fusion.p071f.AdStrategy.m48524a(r2, r3, r8)
                        r3 = 0
                        if (r2 == 0) goto L82
                        java.lang.String r8 = r2.getBidType()
                        java.lang.String r9 = "S2S"
                        boolean r8 = r9.equalsIgnoreCase(r8)
                        if (r8 == 0) goto L82
                        java.lang.String r8 = r2.getId()
                        java.lang.String r9 = "GDT"
                        boolean r8 = r9.equalsIgnoreCase(r8)
                        if (r8 == 0) goto L68
                        android.content.Context r3 = r4
                        java.lang.String r8 = r2.getAppId()
                        java.lang.String r3 = com.beizi.fusion.p066d.GDTAdManagerHolder.m48633c(r3, r8)
                        android.content.Context r8 = r4
                        java.lang.String r9 = r2.getAppId()
                        java.lang.String r10 = r2.getSpaceId()
                        java.lang.String r8 = com.beizi.fusion.p066d.GDTAdManagerHolder.m48637a(r8, r9, r10)
                        goto L83
                    L68:
                        java.lang.String r8 = r2.getId()
                        java.lang.String r9 = "KUAISHOU"
                        boolean r8 = r9.equalsIgnoreCase(r8)
                        if (r8 == 0) goto L82
                        android.content.Context r8 = r4
                        java.lang.String r9 = r2.getAppId()
                        java.lang.String r8 = com.beizi.fusion.p066d.KsAdManagerHolder.m48621b(r8, r9)
                        r11 = r8
                        r8 = r3
                        r3 = r11
                        goto L83
                    L82:
                        r8 = r3
                    L83:
                        boolean r9 = android.text.TextUtils.isEmpty(r3)
                        if (r9 != 0) goto L1a
                        java.lang.String r9 = r2.getBuyerSpaceUuId()
                        r6.add(r9)
                        r4.add(r1)
                        r5.add(r2)
                        com.beizi.fusion.d.a.b$k r1 = new com.beizi.fusion.d.a.b$k
                        r1.<init>()
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder
                        r9.<init>()
                        java.lang.String r10 = r2.getId()
                        int r10 = com.beizi.fusion.p071f.AdStrategy.m48525a(r10)
                        r9.append(r10)
                        java.lang.String r10 = ""
                        r9.append(r10)
                        java.lang.String r9 = r9.toString()
                        r1.m48801a(r9)
                        java.lang.String r9 = r2.getId()
                        r1.m48800b(r9)
                        java.lang.String r9 = r2.getAppId()
                        r1.m48799c(r9)
                        java.lang.String r2 = r2.getSpaceId()
                        r1.m48798d(r2)
                        r1.m48797e(r3)
                        boolean r2 = android.text.TextUtils.isEmpty(r8)
                        if (r2 != 0) goto Ld8
                        r1.m48796f(r8)
                    Ld8:
                        r7.add(r1)
                        goto L1a
                    Ldd:
                        boolean r0 = r6.isEmpty()
                        if (r0 == 0) goto Lf4
                        java.lang.String r0 = "BeiZis"
                        java.lang.String r1 = "S2S竞价失败--token or buyerId is null"
                        com.beizi.fusion.p072g.C3116af.m48494c(r0, r1)
                        com.beizi.fusion.d.a.a r0 = com.beizi.fusion.p066d.p067a.BidS2SRequest.this
                        com.beizi.fusion.d.a.a$a r0 = com.beizi.fusion.p066d.p067a.BidS2SRequest.m48851a(r0)
                        r0.mo48660a()
                        return
                    Lf4:
                        com.beizi.fusion.d.a.a r0 = com.beizi.fusion.p066d.p067a.BidS2SRequest.this
                        android.content.Context r1 = r4
                        java.lang.String r2 = r5
                        java.lang.String r3 = r6
                        int r8 = r7
                        com.beizi.fusion.p066d.p067a.BidS2SRequest.m48850a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p066d.p067a.BidS2SRequest.RunnableC30551.run():void");
                }
            });
            return;
        }
        this.f10973a.mo48660a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48852a(Context context, String str, String str2, List<AdSpacesBean.ForwardBean> list, List<AdSpacesBean.BuyerBean> list2, List<String> list3, List<BidS2SRequestModel.C3068k> list4, int i) {
        try {
            boolean equals = "1".equals(str);
            String m48312a = StringUtil.m48312a();
            String m48512a = HttpUtil.m48512a(context, HttpUtil.m48510a(context, m48312a, str2, equals, list3, list4, i), m48312a);
            if (TextUtils.isEmpty(m48512a)) {
                C3116af.m48494c("BeiZis", "S2S竞价失败-- response is null");
                m48849a(this.f10976d, this.f10977e, list3);
                return;
            }
            JSONObject jSONObject = new JSONObject(AesUtils.m48269b(C3112ad.m48504a(), m48512a));
            C3116af.m48494c("BeiZis", "S2S竞价结果--response is " + jSONObject.toString());
            int optInt = jSONObject.optInt("code");
            if (optInt != 200) {
                C3116af.m48494c("BeiZis", "S2S竞价失败--response code is " + optInt);
                m48849a(this.f10976d, this.f10977e, list3);
                return;
            }
            String optString = jSONObject.optString("data");
            if (!TextUtils.isEmpty(optString) && !optString.equals("null")) {
                m48848a(list, list2, optString, list3);
                return;
            }
            C3116af.m48494c("BeiZis", "S2S竞价失败--data is null");
            m48849a(this.f10976d, this.f10977e, list3);
        } catch (Exception e) {
            e.printStackTrace();
            this.f10973a.mo48660a();
            C3116af.m48494c("BeiZis", "S2S竞价失败--数据异常");
        }
    }

    /* renamed from: a */
    private void m48848a(List<AdSpacesBean.ForwardBean> list, List<AdSpacesBean.BuyerBean> list2, String str, List<String> list3) {
        BidS2SResponseModel.C3070b m48788c;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            BidS2SResponseModel m48794a = BidS2SResponseModel.m48794a(str);
            if (m48794a != null && m48794a.m48795a() != null && m48794a.m48795a().size() != 0) {
                String str2 = null;
                final AdSpacesBean.ForwardBean forwardBean = null;
                for (AdSpacesBean.ForwardBean forwardBean2 : list) {
                    Iterator<BidS2SResponseModel.C3071c> it = m48794a.m48795a().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (forwardBean2.getBuyerId().equals(it.next().m48790a())) {
                                forwardBean = forwardBean2;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                final AdSpacesBean.BuyerBean buyerBean = null;
                for (AdSpacesBean.BuyerBean buyerBean2 : list2) {
                    Iterator<BidS2SResponseModel.C3071c> it2 = m48794a.m48795a().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (buyerBean2.getId().equals(it2.next().m48790a())) {
                                buyerBean = buyerBean2;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (forwardBean != null && buyerBean != null) {
                    List<BidS2SResponseModel.C3069a> m48789b = m48794a.m48795a().get(0).m48789b();
                    if (m48789b == null || m48789b.size() <= 0) {
                        return;
                    }
                    final double parseDouble = Double.parseDouble(m48789b.get(0).m48793a());
                    if ("GDT".equalsIgnoreCase(buyerBean.getId())) {
                        BidS2SResponseModel.C3072d m48792b = m48789b.get(0).m48792b();
                        if (m48792b != null && !TextUtils.isEmpty(m48792b.m48787a())) {
                            str2 = m48792b.m48787a();
                        }
                    } else if ("KUAISHOU".equalsIgnoreCase(buyerBean.getId()) && (m48788c = m48794a.m48795a().get(0).m48788c()) != null && !TextUtils.isEmpty(m48788c.m48791a())) {
                        str2 = m48788c.m48791a();
                    }
                    final String str3 = str2;
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.fusion.d.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BidS2SRequest.this.f10973a.mo48659a(forwardBean, buyerBean, str3, parseDouble);
                        }
                    });
                    return;
                }
                C3116af.m48494c("BeiZis", "S2S竞价失败--tempBuyerBean is null");
                m48849a(this.f10978f, this.f10979g, list3);
                return;
            }
            C3116af.m48494c("BeiZis", "S2S竞价失败--不出价");
            m48849a(this.f10974b, this.f10975c, list3);
        } catch (Exception e) {
            e.printStackTrace();
            this.f10973a.mo48660a();
        }
    }

    /* renamed from: a */
    private void m48849a(String str, String str2, List<String> list) {
        Log.e("BeiZis", "S2S竞价失败，errorCode：" + str);
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        for (String str3 : list) {
            this.f10973a.mo48657a(str, str2, str3, 21);
        }
    }
}
