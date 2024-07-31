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
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class H5Activity extends BaseActivity {

    /* renamed from: k */
    private String f17326k;

    /* renamed from: l */
    private String f17327l;

    /* renamed from: m */
    private SmartWebView f17328m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.H5Activity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4622a extends HttpCallBack {
        C4622a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            H5Activity.this.m57932R().setVisibility(0);
            String string = JsonParse.getString(data, "content");
            HashMap hashMap = new HashMap();
            hashMap.put(BidResponsed.KEY_TOKEN, LoginUser.getLoginUser().getToken());
            hashMap.put("channel", "Android");
            hashMap.put(ConstantHelper.LOG_VS, String.valueOf(H5Activity.this.m41780o0()));
            hashMap.put("type", LoginUser.getLoginUser().getUserType() == 2 ? "1" : "0");
            H5Activity.this.f17328m.getWebView().loadUrl(string, hashMap);
            H5Activity.this.m41782m0(data, string);
        }
    }

    /* renamed from: l0 */
    private void m41783l0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f17327l);
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
        bottomFragment.m41788s0(baseMediaObject);
        beginTransaction.add(C4215R.C4219id.fl_bottom, bottomFragment);
        beginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m41782m0(Map<String, Object> data, String url) {
        UMWeb uMWeb = new UMWeb(url);
        uMWeb.setTitle(this.f17326k);
        String string = JsonParse.getString(data, "indexImg");
        if (TextUtils.isEmpty(string)) {
            string = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.f1669h, string));
        uMWeb.setDescription(JsonParse.getString(data, "synopsis"));
        m41783l0(JsonParse.getString(data, "detailId"), JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), JsonParse.getInt(data, "duration"), JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), uMWeb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public int m41780o0() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learn_h5;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.f17327l = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("title")) {
            this.f17326k = getIntent().getStringExtra("title");
        }
        m41781n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("在线学习");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17328m = (SmartWebView) findViewById(2131232631);
    }

    /* renamed from: n0 */
    public void m41781n0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41617y(LoginUser.getLoginUser().getUserId(), this.f17327l)).setDataListener(new C4622a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }
}
