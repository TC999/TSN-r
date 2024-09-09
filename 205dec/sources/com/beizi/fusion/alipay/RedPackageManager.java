package com.beizi.fusion.alipay;

import android.app.Activity;
import com.beizi.fusion.alipay.inter.ResultListener;
import com.beizi.fusion.alipay.inter.UserInfoListener;
import com.beizi.fusion.alipay.inter.WelfareListener;
import com.beizi.fusion.b.b;
import com.beizi.fusion.b.c;
import com.beizi.fusion.g.af;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class RedPackageManager {
    public static final String APP_ORDER_ID_KEY = "app_order_id_key";
    public static final String APP_USERID_KEY = "app_user_id_key";
    private static String TAG = "RedPackageManager";
    public static final String TRANS_AMOUNT_KEY = "trans_amount_key";
    private static RedPackageManager instance;

    public static RedPackageManager getInstance() {
        if (instance == null) {
            synchronized (RedPackageManager.class) {
                if (instance == null) {
                    instance = new RedPackageManager();
                }
            }
        }
        return instance;
    }

    public void authAliPayWithParams(final Activity activity, Map<String, String> map, final UserInfoListener userInfoListener) {
        af.b(TAG, "authAliPayWithParams execute");
        com.beizi.ad.alipay.RedPackageManager.getInstance().authAliPayWithParams(activity, map, new com.beizi.ad.alipay.inter.UserInfoListener() { // from class: com.beizi.fusion.alipay.RedPackageManager.3
            @Override // com.beizi.ad.alipay.inter.BaseListener
            public void failCallback(int i4, String str) {
                UserInfoListener userInfoListener2 = userInfoListener;
                if (userInfoListener2 != null) {
                    userInfoListener2.failCallback(i4, str);
                    c.a(activity).a(new b(com.beizi.fusion.d.b.f14592b, "", "600.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                }
            }

            @Override // com.beizi.ad.alipay.inter.BaseListener
            public void successCallBack(Map<String, Object> map2) {
                UserInfoListener userInfoListener2 = userInfoListener;
                if (userInfoListener2 != null) {
                    userInfoListener2.successCallBack(map2);
                    c.a(activity).a(new b(com.beizi.fusion.d.b.f14592b, "", "600.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                }
            }
        });
    }

    public void authInfo(Map<String, String> map, final UserInfoListener userInfoListener) {
        af.b(TAG, "authInfo execute");
        com.beizi.ad.alipay.RedPackageManager.getInstance().authInfo(map, new com.beizi.ad.alipay.inter.UserInfoListener() { // from class: com.beizi.fusion.alipay.RedPackageManager.2
            @Override // com.beizi.ad.alipay.inter.BaseListener
            public void failCallback(int i4, String str) {
                UserInfoListener userInfoListener2 = userInfoListener;
                if (userInfoListener2 != null) {
                    userInfoListener2.failCallback(i4, str);
                }
            }

            @Override // com.beizi.ad.alipay.inter.BaseListener
            public void successCallBack(Map<String, Object> map2) {
                UserInfoListener userInfoListener2 = userInfoListener;
                if (userInfoListener2 != null) {
                    userInfoListener2.successCallBack(map2);
                }
            }
        });
    }

    public void rtaUser(final ResultListener resultListener) {
        af.b(TAG, "rtaUser execute");
        com.beizi.ad.alipay.RedPackageManager.getInstance().rtaUser(new com.beizi.ad.alipay.inter.ResultListener() { // from class: com.beizi.fusion.alipay.RedPackageManager.1
            @Override // com.beizi.ad.alipay.inter.ResultListener
            public void onFail(int i4, String str) {
                ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    resultListener2.onFail(i4, str);
                }
            }

            @Override // com.beizi.ad.alipay.inter.ResultListener
            public void onSuccess(boolean z3) {
                ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    resultListener2.onSuccess(z3);
                }
            }
        });
    }

    public void welfareAliPayWithParams(Map<String, String> map, final WelfareListener welfareListener) {
        af.b(TAG, "welfareAliPayWithParams execute");
        com.beizi.ad.alipay.RedPackageManager.getInstance().welfareAliPayWithParams(map, new com.beizi.ad.alipay.inter.WelfareListener() { // from class: com.beizi.fusion.alipay.RedPackageManager.4
            @Override // com.beizi.ad.alipay.inter.BaseListener
            public void failCallback(int i4, String str) {
                WelfareListener welfareListener2 = welfareListener;
                if (welfareListener2 != null) {
                    welfareListener2.failCallback(i4, str);
                }
            }

            @Override // com.beizi.ad.alipay.inter.BaseListener
            public void successCallBack(Map<String, Object> map2) {
                WelfareListener welfareListener2 = welfareListener;
                if (welfareListener2 != null) {
                    welfareListener2.successCallBack(map2);
                }
            }
        });
    }
}
