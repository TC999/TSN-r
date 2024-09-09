package com.bxkj.student.home.teaching.learning.detail.backup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class H5Activity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private String f20670k;

    /* renamed from: l  reason: collision with root package name */
    private String f20671l;

    /* renamed from: m  reason: collision with root package name */
    private SmartWebView f20672m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            H5Activity.this.R().setVisibility(0);
            String string = JsonParse.getString(data, "content");
            HashMap hashMap = new HashMap();
            hashMap.put("token", LoginUser.getLoginUser().getToken());
            hashMap.put("channel", "Android");
            hashMap.put("version", String.valueOf(H5Activity.this.o0()));
            hashMap.put("type", LoginUser.getLoginUser().getUserType() == 2 ? "1" : "0");
            H5Activity.this.f20672m.getWebView().loadUrl(string, hashMap);
            H5Activity.this.m0(data, string);
        }
    }

    private void l0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f20671l);
        bundle.putString("detailId", detailId);
        bundle.putInt("isLike", isLike);
        bundle.putInt("isCollection", isCollection);
        bundle.putInt("duration", duration);
        bundle.putInt("popTime", popTime);
        bundle.putInt("hasQuestion", hasQuestion);
        bundle.putInt("isComplete", isComplete);
        bundle.putInt("isOk", isOk);
        bundle.putInt("opreateFlag", opreateFlag);
        bundle.putInt("valType", valType);
        bottomFragment.setArguments(bundle);
        bottomFragment.s0(baseMediaObject);
        beginTransaction.add(2131231304, bottomFragment);
        beginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Map<String, Object> data, String url) {
        UMWeb uMWeb = new UMWeb(url);
        uMWeb.setTitle(this.f20670k);
        String string = JsonParse.getString(data, "indexImg");
        if (TextUtils.isEmpty(string)) {
            string = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.f1656h, string));
        uMWeb.setDescription(JsonParse.getString(data, "synopsis"));
        l0(JsonParse.getString(data, "detailId"), JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), JsonParse.getInt(data, "duration"), JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), uMWeb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o0() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427422;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.f20671l = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("title")) {
            this.f20670k = getIntent().getStringExtra("title");
        }
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5728\u7ebf\u5b66\u4e60");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20672m = (SmartWebView) findViewById(2131232631);
    }

    public void n0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).y(LoginUser.getLoginUser().getUserId(), this.f20671l)).setDataListener(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }
}
