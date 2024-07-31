package com.bxkj.student.life.info;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.C4215R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.PrintStream;
import java.util.Map;
import java.util.regex.Pattern;
import p635q.InfoApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class InfoDetailActivity extends BaseActivity {

    /* renamed from: k */
    private String f18012k;

    /* renamed from: l */
    private String f18013l;

    /* renamed from: m */
    private CoordinatorLayout f18014m;

    /* renamed from: n */
    private FloatingActionButton f18015n;

    /* renamed from: o */
    private SmartWebView f18016o;

    /* renamed from: p */
    private LinearLayout f18017p;

    /* renamed from: q */
    private LinearLayout f18018q;

    /* renamed from: r */
    private LinearLayout f18019r;

    /* renamed from: s */
    private LinearLayout f18020s;

    /* renamed from: t */
    private String f18021t;

    /* renamed from: u */
    private String f18022u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.info.InfoDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4881a extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f18023a;

        /* renamed from: b */
        final /* synthetic */ View f18024b;

        C4881a(final View val$view) {
            this.f18024b = val$view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f18023a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (this.f18023a) {
                return;
            }
            this.f18024b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f18024b.setVisibility(0);
            this.f18023a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.info.InfoDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4882b extends HttpCallBack {
        C4882b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoDetailActivity.this.f18014m.setVisibility(0);
            String string = JsonParse.getString(data, "html5Url");
            InfoDetailActivity.this.f18016o.m57493j(string);
            InfoDetailActivity.this.f18016o.setTag(string);
        }
    }

    /* renamed from: com.bxkj.student.life.info.InfoDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4883c implements ShareBoardlistener {

        /* renamed from: com.bxkj.student.life.info.InfoDetailActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4884a implements UMShareListener {
            C4884a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1669h, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t) {
                t.printStackTrace();
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1669h, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1669h, " 分享成功啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        C4883c() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb(InfoDetailActivity.this.f18016o.getTag().toString());
            uMWeb.setTitle(InfoDetailActivity.this.f18013l);
            uMWeb.setThumb(new UMImage(((BaseActivity) InfoDetailActivity.this).f1669h, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription("校园生活如此简单");
            new ShareAction(InfoDetailActivity.this).setPlatform(share_media).setCallback(new C4884a()).withMedia(uMWeb).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.info.InfoDetailActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4885d implements UMShareListener {
        C4885d() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1669h, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t) {
            t.printStackTrace();
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1669h, " 分享失败啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1669h, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* renamed from: s0 */
    private void m41120s0(final View view) {
        view.animate().cancel();
        view.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(new FastOutLinearInInterpolator()).setListener(new C4881a(view));
    }

    /* renamed from: u0 */
    private void m41118u0() {
        Http.with(this.f1669h).setObservable(((InfoApiService) Http.getApiService(InfoApiService.class)).m2301d(this.f18012k)).setDataListener(new C4882b());
    }

    /* renamed from: v0 */
    private void m41117v0() {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new C4883c()).open();
    }

    /* renamed from: w0 */
    private void m41116w0(SHARE_MEDIA platform) {
        UMWeb uMWeb = new UMWeb(this.f18016o.getTag().toString());
        uMWeb.setTitle(this.f18013l);
        if (TextUtils.isEmpty(this.f18022u)) {
            this.f18022u = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.f1669h, this.f18022u));
        uMWeb.setDescription("校园生活如此简单");
        new ShareAction(this).setPlatform(platform).setCallback(new C4885d()).withMedia(uMWeb).share();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18017p.setOnClickListener(this);
        this.f18018q.setOnClickListener(this);
        this.f18019r.setOnClickListener(this);
        this.f18020s.setOnClickListener(this);
        this.f18015n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_info_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("infoId")) {
            this.f18012k = getIntent().getStringExtra("infoId");
        }
        if (getIntent().hasExtra("imageUrl")) {
            this.f18022u = getIntent().getStringExtra("imageUrl");
        }
        if (getIntent().hasExtra("inforTitle")) {
            this.f18013l = getIntent().getStringExtra("inforTitle");
        }
        m41118u0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("资讯详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18016o = (SmartWebView) findViewById(2131232694);
        this.f18014m = (CoordinatorLayout) findViewById(C4215R.C4219id.cl_root);
        this.f18017p = (LinearLayout) findViewById(2131232234);
        this.f18018q = (LinearLayout) findViewById(2131232204);
        this.f18019r = (LinearLayout) findViewById(2131232213);
        this.f18020s = (LinearLayout) findViewById(2131232215);
        this.f18015n = (FloatingActionButton) findViewById(C4215R.C4219id.fb_go_top);
        this.f18014m.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case C4215R.C4219id.fb_go_top /* 2131231292 */:
                m41120s0(this.f18015n);
                return;
            case 2131232204:
                m41116w0(SHARE_MEDIA.WEIXIN_CIRCLE);
                return;
            case 2131232213:
                m41116w0(SHARE_MEDIA.QQ);
                return;
            case 2131232215:
                m41116w0(SHARE_MEDIA.QZONE);
                return;
            case 2131232234:
                m41116w0(SHARE_MEDIA.WEIXIN);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SmartWebView smartWebView = this.f18016o;
        if (smartWebView != null) {
            ViewParent parent = smartWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.f18016o);
            }
            try {
                this.f18016o.getWebView().stopLoading();
                this.f18016o.getWebView().clearHistory();
                this.f18016o.getWebView().clearView();
                this.f18016o.removeAllViews();
                this.f18016o.getWebView().destroy();
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    /* renamed from: t0 */
    public String m41119t0(String inputString) {
        String str;
        try {
            str = Pattern.compile("<[^>]+>", 2).matcher(Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>", 2).matcher(Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>", 2).matcher(inputString).replaceAll("")).replaceAll("")).replaceAll("");
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("Html2Text: " + e.getMessage());
            str = "";
        }
        return str.replaceAll("[ ]+", " ").replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
    }
}
