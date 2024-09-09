package com.bxkj.student.home.teaching.learning.detail;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.learning.detail.type.H5Fragment;
import com.bxkj.student.home.teaching.learning.detail.type.MusicPlayFragment;
import com.bxkj.student.home.teaching.learning.detail.type.PdfFragment;
import com.bxkj.student.home.teaching.learning.detail.type.VideoPlayFragment;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LearnDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f20634k;

    /* renamed from: l  reason: collision with root package name */
    private FrameLayout f20635l;

    /* renamed from: m  reason: collision with root package name */
    private FrameLayout f20636m;

    /* renamed from: n  reason: collision with root package name */
    private String f20637n;

    /* renamed from: o  reason: collision with root package name */
    private String f20638o;

    /* renamed from: p  reason: collision with root package name */
    private BottomFragment f20639p;

    /* renamed from: q  reason: collision with root package name */
    private Fragment f20640q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f20641r = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnDetailActivity.this.R().setVisibility(0);
            LearnDetailActivity.this.p0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public void s0(Map<String, Object> data) {
        UMWeb uMWeb = new UMWeb(JsonParse.getString(data, "content"));
        uMWeb.setTitle(this.f20637n);
        String string = JsonParse.getString(data, "indexImg");
        if (TextUtils.isEmpty(string)) {
            string = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.f1656h, string));
        uMWeb.setDescription(JsonParse.getString(data, "synopsis"));
        o0(JsonParse.getString(data, "detailId"), JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), JsonParse.getInt(data, "duration"), JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), JsonParse.getInt(data, "integral"), uMWeb);
    }

    private void o0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, int integral, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.f20639p = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f20638o);
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
        bundle.putInt("integral", integral);
        this.f20639p.setArguments(bundle);
        this.f20639p.v0(baseMediaObject);
        beginTransaction.add(2131231304, this.f20639p);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(final Map<String, Object> data) {
        q0(data);
        int i4 = JsonParse.getInt(data, "type");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f20638o);
        if (i4 == 1) {
            this.f20640q = new H5Fragment();
            bundle.putString("url", JsonParse.getString(data, "content"));
        } else if (i4 == 2) {
            this.f20640q = new VideoPlayFragment();
            bundle.putString("videoPath", JsonParse.getString(data, "content"));
            bundle.putString("title", this.f20637n);
            bundle.putString("pv", JsonParse.getString(data, "pv"));
        } else if (i4 == 3) {
            this.f20640q = new PdfFragment();
            bundle.putString("url", JsonParse.getString(data, "content"));
        } else if (i4 == 4) {
            this.f20640q = new MusicPlayFragment();
            bundle.putString("videoPath", JsonParse.getString(data, "content"));
            bundle.putString("title", this.f20637n);
            bundle.putString("pv", JsonParse.getString(data, "pv"));
        } else {
            this.f20640q = new H5Fragment();
        }
        this.f20640q.setArguments(bundle);
        beginTransaction.add(2131231307, this.f20640q);
        beginTransaction.commitAllowingStateLoss();
        Fragment fragment = this.f20640q;
        if (fragment instanceof PdfFragment) {
            ((PdfFragment) fragment).a0(new PdfFragment.b() { // from class: com.bxkj.student.home.teaching.learning.detail.z
                @Override // com.bxkj.student.home.teaching.learning.detail.type.PdfFragment.b
                public final void onSuccess() {
                    LearnDetailActivity.this.s0(data);
                }
            });
        } else {
            s0(data);
        }
    }

    private void q0(Map<String, Object> data) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        TopTipsFragment topTipsFragment = new TopTipsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("duration", JsonParse.getString(data, "duration"));
        bundle.putString("integral", JsonParse.getString(data, "integral"));
        topTipsFragment.setArguments(bundle);
        beginTransaction.add(2131231312, topTipsFragment);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0() {
        BottomFragment bottomFragment = this.f20639p;
        if (bottomFragment != null) {
            bottomFragment.u0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0() {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427421;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.f20638o = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("title")) {
            this.f20637n = getIntent().getStringExtra("title");
        }
        r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5728\u7ebf\u5b66\u4e60\u8be6\u60c5");
        Z(new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.detail.w
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                LearnDetailActivity.this.t0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20634k = (FrameLayout) findViewById(2131231312);
        this.f20635l = (FrameLayout) findViewById(2131231307);
        this.f20636m = (FrameLayout) findViewById(2131231304);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void t0() {
        Fragment fragment;
        if (getResources().getConfiguration().orientation == 2 && (fragment = this.f20640q) != null && (fragment instanceof VideoPlayFragment)) {
            ((VideoPlayFragment) fragment).N();
        } else if (this.f20641r) {
            BottomFragment bottomFragment = this.f20639p;
            if (bottomFragment != null) {
                bottomFragment.u0(true);
            }
            new iOSTwoButtonDialog(this.f1656h).setMessage("\u6b63\u5728\u5b66\u4e60,\u5982\u679c\u79bb\u5f00\u5c06\u4e0d\u79ef\u5206,\u786e\u5b9a\u79bb\u5f00\uff1f").setLeftButtonText("\u7ee7\u7eed\u5b66\u4e60").setRightButtonText("\u786e\u5b9a\u79bb\u5f00").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.x
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                public final void buttonLeftOnClick() {
                    LearnDetailActivity.this.u0();
                }
            }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.y
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    LearnDetailActivity.this.v0();
                }
            }).show();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void r0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).y(LoginUser.getLoginUser().getUserId(), this.f20638o)).setDataListener(new a());
    }

    public void w0(boolean isTimeCountDown) {
        this.f20641r = isTimeCountDown;
    }
}
