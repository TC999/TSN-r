package com.bxkj.student.personal.login;

import android.app.Activity;
import android.content.Intent;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.MainActivity;
import com.bxkj.student.main.MyFragment;
import com.umeng.analytics.MobclickAgent;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LoginUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class c {
    public static void a() {
        LoginUser.getLoginUser().getOpenId();
    }

    public static void b(Activity mActivity, Map<String, Object> data) {
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
        LoginUser.getLoginUser().setToken(JsonParse.getString(data, "token"));
        LoginUser.getLoginUser().setLogin(true);
        MobclickAgent.onProfileSignIn(LoginUser.getLoginUser().getUserId());
        mActivity.startActivity(new Intent(mActivity, MainActivity.class));
        MainActivity mainActivity = (MainActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MainActivity.class);
        if (mainActivity != null) {
            mainActivity.v0();
            mainActivity.z0();
            MyFragment myFragment = (MyFragment) cn.bluemobi.dylan.base.utils.a.n().o(MyFragment.class);
            if (myFragment != null) {
                myFragment.Z();
                myFragment.a0();
            }
        }
        a();
        mActivity.finish();
    }

    public static void c() {
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
        cn.bluemobi.dylan.base.utils.a.n().l();
    }
}
