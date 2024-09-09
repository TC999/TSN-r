package com.beizi.fusion.d.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.d.a.c;
import com.beizi.fusion.g.ab;
import com.beizi.fusion.g.ad;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.d;
import com.beizi.fusion.g.l;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BidS2SRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0134a f14512a;

    /* renamed from: b  reason: collision with root package name */
    private String f14513b = "1002";

    /* renamed from: c  reason: collision with root package name */
    private String f14514c = "\u4e0d\u51fa\u4ef7";

    /* renamed from: d  reason: collision with root package name */
    private String f14515d = "1003";

    /* renamed from: e  reason: collision with root package name */
    private String f14516e = "\u7f51\u7edc\u9519\u8bef";

    /* renamed from: f  reason: collision with root package name */
    private String f14517f = "1004";

    /* renamed from: g  reason: collision with root package name */
    private String f14518g = "\u672a\u627e\u5230\u6e20\u9053buyer";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BidS2SRequest.java */
    /* renamed from: com.beizi.fusion.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface InterfaceC0134a {
        void a();

        void a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str, double d4);

        void a(String str, int i4);

        void a(String str, String str2, String str3, int i4);
    }

    public a(InterfaceC0134a interfaceC0134a) {
        this.f14512a = interfaceC0134a;
    }

    public void a(final Context context, final String str, final String str2, final List<AdSpacesBean.ForwardBean> list, final List<AdSpacesBean.BuyerBean> list2, final int i4) {
        if (this.f14512a == null) {
            return;
        }
        if (context != null && i4 > 0 && !list.isEmpty() && !list2.isEmpty()) {
            for (AdSpacesBean.ForwardBean forwardBean : list) {
                AdSpacesBean.BuyerBean a4 = com.beizi.fusion.f.b.a(forwardBean.getBuyerId(), list2, forwardBean.getBuyerSpaceUuId());
                if (a4 != null && AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(a4.getBidType())) {
                    this.f14512a.a(a4.getBuyerSpaceUuId(), 18);
                }
            }
            l.a().execute(new Runnable() { // from class: com.beizi.fusion.d.a.a.1
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
                        com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = com.beizi.fusion.f.b.a(r2, r3, r8)
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
                        java.lang.String r3 = com.beizi.fusion.d.k.c(r3, r8)
                        android.content.Context r8 = r4
                        java.lang.String r9 = r2.getAppId()
                        java.lang.String r10 = r2.getSpaceId()
                        java.lang.String r8 = com.beizi.fusion.d.k.a(r8, r9, r10)
                        goto L83
                    L68:
                        java.lang.String r8 = r2.getId()
                        java.lang.String r9 = "KUAISHOU"
                        boolean r8 = r9.equalsIgnoreCase(r8)
                        if (r8 == 0) goto L82
                        android.content.Context r8 = r4
                        java.lang.String r9 = r2.getAppId()
                        java.lang.String r8 = com.beizi.fusion.d.n.b(r8, r9)
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
                        int r10 = com.beizi.fusion.f.b.a(r10)
                        r9.append(r10)
                        java.lang.String r10 = ""
                        r9.append(r10)
                        java.lang.String r9 = r9.toString()
                        r1.a(r9)
                        java.lang.String r9 = r2.getId()
                        r1.b(r9)
                        java.lang.String r9 = r2.getAppId()
                        r1.c(r9)
                        java.lang.String r2 = r2.getSpaceId()
                        r1.d(r2)
                        r1.e(r3)
                        boolean r2 = android.text.TextUtils.isEmpty(r8)
                        if (r2 != 0) goto Ld8
                        r1.f(r8)
                    Ld8:
                        r7.add(r1)
                        goto L1a
                    Ldd:
                        boolean r0 = r6.isEmpty()
                        if (r0 == 0) goto Lf4
                        java.lang.String r0 = "BeiZis"
                        java.lang.String r1 = "S2S\u7ade\u4ef7\u5931\u8d25--token or buyerId is null"
                        com.beizi.fusion.g.af.c(r0, r1)
                        com.beizi.fusion.d.a.a r0 = com.beizi.fusion.d.a.a.this
                        com.beizi.fusion.d.a.a$a r0 = com.beizi.fusion.d.a.a.a(r0)
                        r0.a()
                        return
                    Lf4:
                        com.beizi.fusion.d.a.a r0 = com.beizi.fusion.d.a.a.this
                        android.content.Context r1 = r4
                        java.lang.String r2 = r5
                        java.lang.String r3 = r6
                        int r8 = r7
                        com.beizi.fusion.d.a.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.d.a.a.AnonymousClass1.run():void");
                }
            });
            return;
        }
        this.f14512a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, List<AdSpacesBean.ForwardBean> list, List<AdSpacesBean.BuyerBean> list2, List<String> list3, List<b.k> list4, int i4) {
        try {
            boolean equals = "1".equals(str);
            String a4 = av.a();
            String a5 = ab.a(context, ab.a(context, a4, str2, equals, list3, list4, i4), a4);
            if (TextUtils.isEmpty(a5)) {
                af.c("BeiZis", "S2S\u7ade\u4ef7\u5931\u8d25-- response is null");
                a(this.f14515d, this.f14516e, list3);
                return;
            }
            JSONObject jSONObject = new JSONObject(d.b(ad.a(), a5));
            af.c("BeiZis", "S2S\u7ade\u4ef7\u7ed3\u679c--response is " + jSONObject.toString());
            int optInt = jSONObject.optInt("code");
            if (optInt != 200) {
                af.c("BeiZis", "S2S\u7ade\u4ef7\u5931\u8d25--response code is " + optInt);
                a(this.f14515d, this.f14516e, list3);
                return;
            }
            String optString = jSONObject.optString("data");
            if (!TextUtils.isEmpty(optString) && !optString.equals("null")) {
                a(list, list2, optString, list3);
                return;
            }
            af.c("BeiZis", "S2S\u7ade\u4ef7\u5931\u8d25--data is null");
            a(this.f14515d, this.f14516e, list3);
        } catch (Exception e4) {
            e4.printStackTrace();
            this.f14512a.a();
            af.c("BeiZis", "S2S\u7ade\u4ef7\u5931\u8d25--\u6570\u636e\u5f02\u5e38");
        }
    }

    private void a(List<AdSpacesBean.ForwardBean> list, List<AdSpacesBean.BuyerBean> list2, String str, List<String> list3) {
        c.b c4;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c a4 = c.a(str);
            if (a4 != null && a4.a() != null && a4.a().size() != 0) {
                String str2 = null;
                final AdSpacesBean.ForwardBean forwardBean = null;
                for (AdSpacesBean.ForwardBean forwardBean2 : list) {
                    Iterator<c.C0136c> it = a4.a().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (forwardBean2.getBuyerId().equals(it.next().a())) {
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
                    Iterator<c.C0136c> it2 = a4.a().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (buyerBean2.getId().equals(it2.next().a())) {
                                buyerBean = buyerBean2;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (forwardBean != null && buyerBean != null) {
                    List<c.a> b4 = a4.a().get(0).b();
                    if (b4 == null || b4.size() <= 0) {
                        return;
                    }
                    final double parseDouble = Double.parseDouble(b4.get(0).a());
                    if (AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT.equalsIgnoreCase(buyerBean.getId())) {
                        c.d b5 = b4.get(0).b();
                        if (b5 != null && !TextUtils.isEmpty(b5.a())) {
                            str2 = b5.a();
                        }
                    } else if ("KUAISHOU".equalsIgnoreCase(buyerBean.getId()) && (c4 = a4.a().get(0).c()) != null && !TextUtils.isEmpty(c4.a())) {
                        str2 = c4.a();
                    }
                    final String str3 = str2;
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.fusion.d.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.f14512a.a(forwardBean, buyerBean, str3, parseDouble);
                        }
                    });
                    return;
                }
                af.c("BeiZis", "S2S\u7ade\u4ef7\u5931\u8d25--tempBuyerBean is null");
                a(this.f14517f, this.f14518g, list3);
                return;
            }
            af.c("BeiZis", "S2S\u7ade\u4ef7\u5931\u8d25--\u4e0d\u51fa\u4ef7");
            a(this.f14513b, this.f14514c, list3);
        } catch (Exception e4) {
            e4.printStackTrace();
            this.f14512a.a();
        }
    }

    private void a(String str, String str2, List<String> list) {
        Log.e("BeiZis", "S2S\u7ade\u4ef7\u5931\u8d25\uff0cerrorCode\uff1a" + str);
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        for (String str3 : list) {
            this.f14512a.a(str, str2, str3, 21);
        }
    }
}
