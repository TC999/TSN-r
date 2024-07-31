package com.bxkj.student.personal.login;

import android.app.Activity;
import android.content.Intent;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.MainActivity;
import com.bxkj.student.main.MyFragment;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.analytics.MobclickAgent;
import java.util.Map;

/* renamed from: com.bxkj.student.personal.login.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LoginUtils {
    /* renamed from: a */
    public static void m40421a() {
        LoginUser.getLoginUser().getOpenId();
    }

    /* renamed from: b */
    public static void m40420b(Activity mActivity, Map<String, Object> data) {
        LoginUser.getLoginUser().setTempUserId("");
        LoginUser.getLoginUser().setTempUserNumber("");
        LoginUser.getLoginUser().setTempUserName("");
        LoginUser.getLoginUser().setTempUserPhone("");
        LoginUser.getLoginUser().setLastLoginTime(System.currentTimeMillis());
        LoginUser.getLoginUser().setUserId(JsonParse.getString(data, "id"));
        LoginUser.getLoginUser().setRealName(JsonParse.getString(data, "name").trim());
        LoginUser.getLoginUser().setAccount(JsonParse.getString(data, "userNum"));
        LoginUser.getLoginUser().setPhone(JsonParse.getString(data, "phone"));
        LoginUser.getLoginUser().setSex(JsonParse.getString(data, "sex"));
        LoginUser.getLoginUser().setToken(JsonParse.getString(data, BidResponsed.KEY_TOKEN));
        LoginUser.getLoginUser().setLogin(true);
        MobclickAgent.onProfileSignIn(LoginUser.getLoginUser().getUserId());
        mActivity.startActivity(new Intent(mActivity, MainActivity.class));
        MainActivity mainActivity = (MainActivity) AppManager.m57776n().getActivity(MainActivity.class);
        if (mainActivity != null) {
            mainActivity.m42964v0();
            mainActivity.m42960z0();
            MyFragment myFragment = (MyFragment) AppManager.m57776n().m57775o(MyFragment.class);
            if (myFragment != null) {
                myFragment.m40623Z();
                myFragment.m40622a0();
            }
        }
        m40421a();
        mActivity.finish();
    }

    /* renamed from: c */
    public static void m40419c() {
        LoginUser.getLoginUser().setLogin(false);
        LoginUser.getLoginUser().setAuthorizationInMall(false);
        LoginUser.getLoginUser().setAuthorizationInLost(false);
        LoginUser.getLoginUser().setAuthorizationInSecondHand(false);
        LoginUser.getLoginUser().setAuthorizationInJob(false);
        LoginUser.getLoginUser().setHeadImageUrl("");
        LoginUser.getLoginUser().setUserId("");
        LoginUser.getLoginUser().setToken("");
        LoginUser.getLoginUser().setTempUserId("");
        LoginUser.getLoginUser().setTempUserNumber("");
        LoginUser.getLoginUser().setTempUserName("");
        LoginUser.getLoginUser().setTempUserPhone("");
        LoginUser.getLoginUser().setHeadImageUrl("");
        LoginUser.getLoginUser().setKeepToken("");
        AppManager.m57776n().m57778l();
    }
}
