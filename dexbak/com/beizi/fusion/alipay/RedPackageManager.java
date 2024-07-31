package com.beizi.fusion.alipay;

import android.app.Activity;
import com.beizi.fusion.alipay.inter.ResultListener;
import com.beizi.fusion.alipay.inter.UserInfoListener;
import com.beizi.fusion.alipay.inter.WelfareListener;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p072g.C3116af;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        C3116af.m48495b(TAG, "authAliPayWithParams execute");
        com.beizi.p051ad.alipay.RedPackageManager.getInstance().authAliPayWithParams(activity, map, new com.beizi.p051ad.alipay.inter.UserInfoListener() { // from class: com.beizi.fusion.alipay.RedPackageManager.3
            @Override // com.beizi.p051ad.alipay.inter.BaseListener
            public void failCallback(int i, String str) {
                UserInfoListener userInfoListener2 = userInfoListener;
                if (userInfoListener2 != null) {
                    userInfoListener2.failCallback(i, str);
                    EventCar.m48869a(activity).m48868a(new EventBean(AdManager.f11053b, "", "600.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                }
            }

            @Override // com.beizi.p051ad.alipay.inter.BaseListener
            public void successCallBack(Map<String, Object> map2) {
                UserInfoListener userInfoListener2 = userInfoListener;
                if (userInfoListener2 != null) {
                    userInfoListener2.successCallBack(map2);
                    EventCar.m48869a(activity).m48868a(new EventBean(AdManager.f11053b, "", "600.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                }
            }
        });
    }

    public void authInfo(Map<String, String> map, final UserInfoListener userInfoListener) {
        C3116af.m48495b(TAG, "authInfo execute");
        com.beizi.p051ad.alipay.RedPackageManager.getInstance().authInfo(map, new com.beizi.p051ad.alipay.inter.UserInfoListener() { // from class: com.beizi.fusion.alipay.RedPackageManager.2
            @Override // com.beizi.p051ad.alipay.inter.BaseListener
            public void failCallback(int i, String str) {
                UserInfoListener userInfoListener2 = userInfoListener;
                if (userInfoListener2 != null) {
                    userInfoListener2.failCallback(i, str);
                }
            }

            @Override // com.beizi.p051ad.alipay.inter.BaseListener
            public void successCallBack(Map<String, Object> map2) {
                UserInfoListener userInfoListener2 = userInfoListener;
                if (userInfoListener2 != null) {
                    userInfoListener2.successCallBack(map2);
                }
            }
        });
    }

    public void rtaUser(final ResultListener resultListener) {
        C3116af.m48495b(TAG, "rtaUser execute");
        com.beizi.p051ad.alipay.RedPackageManager.getInstance().rtaUser(new com.beizi.p051ad.alipay.inter.ResultListener() { // from class: com.beizi.fusion.alipay.RedPackageManager.1
            @Override // com.beizi.p051ad.alipay.inter.ResultListener
            public void onFail(int i, String str) {
                ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    resultListener2.onFail(i, str);
                }
            }

            @Override // com.beizi.p051ad.alipay.inter.ResultListener
            public void onSuccess(boolean z) {
                ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    resultListener2.onSuccess(z);
                }
            }
        });
    }

    public void welfareAliPayWithParams(Map<String, String> map, final WelfareListener welfareListener) {
        C3116af.m48495b(TAG, "welfareAliPayWithParams execute");
        com.beizi.p051ad.alipay.RedPackageManager.getInstance().welfareAliPayWithParams(map, new com.beizi.p051ad.alipay.inter.WelfareListener() { // from class: com.beizi.fusion.alipay.RedPackageManager.4
            @Override // com.beizi.p051ad.alipay.inter.BaseListener
            public void failCallback(int i, String str) {
                WelfareListener welfareListener2 = welfareListener;
                if (welfareListener2 != null) {
                    welfareListener2.failCallback(i, str);
                }
            }

            @Override // com.beizi.p051ad.alipay.inter.BaseListener
            public void successCallBack(Map<String, Object> map2) {
                WelfareListener welfareListener2 = welfareListener;
                if (welfareListener2 != null) {
                    welfareListener2.successCallBack(map2);
                }
            }
        });
    }
}
