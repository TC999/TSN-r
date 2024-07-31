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
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.detail.type.H5Fragment;
import com.bxkj.student.home.teaching.learning.detail.type.MusicPlayFragment;
import com.bxkj.student.home.teaching.learning.detail.type.PdfFragment;
import com.bxkj.student.home.teaching.learning.detail.type.VideoPlayFragment;
import com.tencent.connect.share.QzonePublish;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LearnDetailActivity extends BaseActivity {

    /* renamed from: k */
    private FrameLayout f17286k;

    /* renamed from: l */
    private FrameLayout f17287l;

    /* renamed from: m */
    private FrameLayout f17288m;

    /* renamed from: n */
    private String f17289n;

    /* renamed from: o */
    private String f17290o;

    /* renamed from: p */
    private BottomFragment f17291p;

    /* renamed from: q */
    private Fragment f17292q;

    /* renamed from: r */
    private boolean f17293r = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.LearnDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4615a extends HttpCallBack {
        C4615a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnDetailActivity.this.m57932R().setVisibility(0);
            LearnDetailActivity.this.m41829p0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public void m41826s0(Map<String, Object> data) {
        UMWeb uMWeb = new UMWeb(JsonParse.getString(data, "content"));
        uMWeb.setTitle(this.f17289n);
        String string = JsonParse.getString(data, "indexImg");
        if (TextUtils.isEmpty(string)) {
            string = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.f1669h, string));
        uMWeb.setDescription(JsonParse.getString(data, "synopsis"));
        m41830o0(JsonParse.getString(data, "detailId"), JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), JsonParse.getInt(data, "duration"), JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), JsonParse.getInt(data, "integral"), uMWeb);
    }

    /* renamed from: o0 */
    private void m41830o0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, int integral, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.f17291p = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f17290o);
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
        this.f17291p.setArguments(bundle);
        this.f17291p.m41838v0(baseMediaObject);
        beginTransaction.add(C4215R.C4219id.fl_bottom, this.f17291p);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public void m41829p0(final Map<String, Object> data) {
        m41828q0(data);
        int i = JsonParse.getInt(data, "type");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f17290o);
        if (i == 1) {
            this.f17292q = new H5Fragment();
            bundle.putString("url", JsonParse.getString(data, "content"));
        } else if (i == 2) {
            this.f17292q = new VideoPlayFragment();
            bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, JsonParse.getString(data, "content"));
            bundle.putString("title", this.f17289n);
            bundle.putString("pv", JsonParse.getString(data, "pv"));
        } else if (i == 3) {
            this.f17292q = new PdfFragment();
            bundle.putString("url", JsonParse.getString(data, "content"));
        } else if (i == 4) {
            this.f17292q = new MusicPlayFragment();
            bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, JsonParse.getString(data, "content"));
            bundle.putString("title", this.f17289n);
            bundle.putString("pv", JsonParse.getString(data, "pv"));
        } else {
            this.f17292q = new H5Fragment();
        }
        this.f17292q.setArguments(bundle);
        beginTransaction.add(C4215R.C4219id.fl_content, this.f17292q);
        beginTransaction.commitAllowingStateLoss();
        Fragment fragment = this.f17292q;
        if (fragment instanceof PdfFragment) {
            ((PdfFragment) fragment).m41651a0(new PdfFragment.InterfaceC4672b() { // from class: com.bxkj.student.home.teaching.learning.detail.z
                @Override // com.bxkj.student.home.teaching.learning.detail.type.PdfFragment.InterfaceC4672b
                public final void onSuccess() {
                    LearnDetailActivity.this.m41826s0(data);
                }
            });
        } else {
            m41826s0(data);
        }
    }

    /* renamed from: q0 */
    private void m41828q0(Map<String, Object> data) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        TopTipsFragment topTipsFragment = new TopTipsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("duration", JsonParse.getString(data, "duration"));
        bundle.putString("integral", JsonParse.getString(data, "integral"));
        topTipsFragment.setArguments(bundle);
        beginTransaction.add(C4215R.C4219id.fl_top, topTipsFragment);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m41824u0() {
        BottomFragment bottomFragment = this.f17291p;
        if (bottomFragment != null) {
            bottomFragment.m41839u0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m41823v0() {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learn_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.f17290o = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("title")) {
            this.f17289n = getIntent().getStringExtra("title");
        }
        m41827r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("在线学习详情");
        m57927Z(new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.learning.detail.w
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                LearnDetailActivity.this.m41825t0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17286k = (FrameLayout) findViewById(C4215R.C4219id.fl_top);
        this.f17287l = (FrameLayout) findViewById(C4215R.C4219id.fl_content);
        this.f17288m = (FrameLayout) findViewById(C4215R.C4219id.fl_bottom);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void m41825t0() {
        Fragment fragment;
        if (getResources().getConfiguration().orientation == 2 && (fragment = this.f17292q) != null && (fragment instanceof VideoPlayFragment)) {
            ((VideoPlayFragment) fragment).m41645N();
        } else if (this.f17293r) {
            BottomFragment bottomFragment = this.f17291p;
            if (bottomFragment != null) {
                bottomFragment.m41839u0(true);
            }
            new iOSTwoButtonDialog(this.f1669h).setMessage("正在学习,如果离开将不积分,确定离开？").setLeftButtonText("继续学习").setRightButtonText("确定离开").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.x
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                public final void buttonLeftOnClick() {
                    LearnDetailActivity.this.m41824u0();
                }
            }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.y
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    LearnDetailActivity.this.m41823v0();
                }
            }).show();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: r0 */
    public void m41827r0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41617y(LoginUser.getLoginUser().getUserId(), this.f17290o)).setDataListener(new C4615a());
    }

    /* renamed from: w0 */
    public void m41822w0(boolean isTimeCountDown) {
        this.f17293r = isTimeCountDown;
    }
}
