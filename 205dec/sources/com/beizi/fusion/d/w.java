package com.beizi.fusion.d;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.ad.BeiZi;
import com.beizi.ad.BeiZiAdSdkController;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.g.ak;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdPlusConfig;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: selfAdManagerHolder.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14684a;

    public static void a(Context context, String str) {
        try {
            b(StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void b(final Context context, String str) {
        if (f14684a) {
            return;
        }
        try {
            a(context);
            BeiZi.init(context, str, new BeiZiAdSdkController() { // from class: com.beizi.fusion.d.w.1
                @Override // com.beizi.ad.BeiZiAdSdkController
                public String getDevOaid() {
                    try {
                        if (RequestInfo.getInstance(context).getDevInfo() != null) {
                            String oaid = RequestInfo.getInstance(context).getDevInfo().getOaid();
                            if (!TextUtils.isEmpty(oaid)) {
                                return oaid;
                            }
                            String customOaid = RequestInfo.getInstance(context).getCustomOaid();
                            if (!TextUtils.isEmpty(customOaid)) {
                                return customOaid;
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    return super.getDevOaid();
                }

                @Override // com.beizi.ad.BeiZiAdSdkController
                public boolean isCanUseGaid() {
                    if (BeiZis.getCustomController() != null) {
                        return !ak.a() && BeiZis.getCustomController().isCanUseGaid();
                    }
                    return super.isCanUseGaid();
                }

                @Override // com.beizi.ad.BeiZiAdSdkController
                public boolean isCanUseLocation() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseLocation();
                    }
                    return super.isCanUseLocation();
                }

                @Override // com.beizi.ad.BeiZiAdSdkController
                public boolean isCanUseOaid() {
                    if (BeiZis.getCustomController() != null) {
                        return !ak.a() && BeiZis.getCustomController().isCanUseOaid();
                    }
                    return super.isCanUseOaid();
                }

                @Override // com.beizi.ad.BeiZiAdSdkController
                public boolean isCanUsePhoneState() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUsePhoneState();
                    }
                    return super.isCanUsePhoneState();
                }

                @Override // com.beizi.ad.BeiZiAdSdkController
                public boolean isCanUseWifiState() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseWifiState();
                    }
                    return super.isCanUseWifiState();
                }
            });
            f14684a = true;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void a(Context context) {
        String a4;
        try {
            if (aw.a("com.beizi.ad.BeiZi")) {
                AdPlusConfig adPlusConfig = ResponseInfo.getInstance(context).getAdPlusConfig();
                if (adPlusConfig != null) {
                    List<String> h5RedirectBlackList = adPlusConfig.getH5RedirectBlackList();
                    if (h5RedirectBlackList == null || h5RedirectBlackList.size() <= 0) {
                        h5RedirectBlackList = new ArrayList<>();
                        h5RedirectBlackList.add("market://");
                    }
                    BeiZi.setH5RedirectBlackList(h5RedirectBlackList);
                }
                if (adPlusConfig != null && !TextUtils.isEmpty(adPlusConfig.getAdUrl()) && adPlusConfig.getAdUrl().startsWith("http")) {
                    a4 = adPlusConfig.getAdUrl();
                } else {
                    a4 = com.beizi.fusion.g.f.a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGswL2pzb24=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3NkazAvanNvbg==");
                    if (TextUtils.isEmpty(a4)) {
                        return;
                    }
                }
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                BeiZi.setAdRequestUrl(a4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
