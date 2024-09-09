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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class InfoDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private String f21350k;

    /* renamed from: l  reason: collision with root package name */
    private String f21351l;

    /* renamed from: m  reason: collision with root package name */
    private CoordinatorLayout f21352m;

    /* renamed from: n  reason: collision with root package name */
    private FloatingActionButton f21353n;

    /* renamed from: o  reason: collision with root package name */
    private SmartWebView f21354o;

    /* renamed from: p  reason: collision with root package name */
    private LinearLayout f21355p;

    /* renamed from: q  reason: collision with root package name */
    private LinearLayout f21356q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f21357r;

    /* renamed from: s  reason: collision with root package name */
    private LinearLayout f21358s;

    /* renamed from: t  reason: collision with root package name */
    private String f21359t;

    /* renamed from: u  reason: collision with root package name */
    private String f21360u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f21361a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f21362b;

        a(final View val$view) {
            this.f21362b = val$view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f21361a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (this.f21361a) {
                return;
            }
            this.f21362b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f21362b.setVisibility(0);
            this.f21361a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoDetailActivity.this.f21352m.setVisibility(0);
            String string = JsonParse.getString(data, "html5Url");
            InfoDetailActivity.this.f21354o.j(string);
            InfoDetailActivity.this.f21354o.setTag(string);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements ShareBoardlistener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1656h, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t3) {
                t3.printStackTrace();
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1656h, " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1656h, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        c() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb(InfoDetailActivity.this.f21354o.getTag().toString());
            uMWeb.setTitle(InfoDetailActivity.this.f21351l);
            uMWeb.setThumb(new UMImage(((BaseActivity) InfoDetailActivity.this).f1656h, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription("\u6821\u56ed\u751f\u6d3b\u5982\u6b64\u7b80\u5355");
            new ShareAction(InfoDetailActivity.this).setPlatform(share_media).setCallback(new a()).withMedia(uMWeb).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements UMShareListener {
        d() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1656h, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t3) {
            t3.printStackTrace();
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1656h, " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).f1656h, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    private void s0(final View view) {
        view.animate().cancel();
        view.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(new FastOutLinearInInterpolator()).setListener(new a(view));
    }

    private void u0() {
        Http.with(this.f1656h).setObservable(((q.c) Http.getApiService(q.c.class)).d(this.f21350k)).setDataListener(new b());
    }

    private void v0() {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new c()).open();
    }

    private void w0(SHARE_MEDIA platform) {
        UMWeb uMWeb = new UMWeb(this.f21354o.getTag().toString());
        uMWeb.setTitle(this.f21351l);
        if (TextUtils.isEmpty(this.f21360u)) {
            this.f21360u = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.f1656h, this.f21360u));
        uMWeb.setDescription("\u6821\u56ed\u751f\u6d3b\u5982\u6b64\u7b80\u5355");
        new ShareAction(this).setPlatform(platform).setCallback(new d()).withMedia(uMWeb).share();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21355p.setOnClickListener(this);
        this.f21356q.setOnClickListener(this);
        this.f21357r.setOnClickListener(this);
        this.f21358s.setOnClickListener(this);
        this.f21353n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427412;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("infoId")) {
            this.f21350k = getIntent().getStringExtra("infoId");
        }
        if (getIntent().hasExtra("imageUrl")) {
            this.f21360u = getIntent().getStringExtra("imageUrl");
        }
        if (getIntent().hasExtra("inforTitle")) {
            this.f21351l = getIntent().getStringExtra("inforTitle");
        }
        u0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8d44\u8baf\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21354o = (SmartWebView) findViewById(2131232694);
        this.f21352m = (CoordinatorLayout) findViewById(2131231114);
        this.f21355p = (LinearLayout) findViewById(2131232234);
        this.f21356q = (LinearLayout) findViewById(2131232204);
        this.f21357r = (LinearLayout) findViewById(2131232213);
        this.f21358s = (LinearLayout) findViewById(2131232215);
        this.f21353n = (FloatingActionButton) findViewById(2131231292);
        this.f21352m.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131231292:
                s0(this.f21353n);
                return;
            case 2131232204:
                w0(SHARE_MEDIA.WEIXIN_CIRCLE);
                return;
            case 2131232213:
                w0(SHARE_MEDIA.QQ);
                return;
            case 2131232215:
                w0(SHARE_MEDIA.QZONE);
                return;
            case 2131232234:
                w0(SHARE_MEDIA.WEIXIN);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SmartWebView smartWebView = this.f21354o;
        if (smartWebView != null) {
            ViewParent parent = smartWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.f21354o);
            }
            try {
                this.f21354o.getWebView().stopLoading();
                this.f21354o.getWebView().clearHistory();
                this.f21354o.getWebView().clearView();
                this.f21354o.removeAllViews();
                this.f21354o.getWebView().destroy();
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    public String t0(String inputString) {
        String str;
        try {
            str = Pattern.compile("<[^>]+>", 2).matcher(Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>", 2).matcher(Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>", 2).matcher(inputString).replaceAll("")).replaceAll("")).replaceAll("");
        } catch (Exception e4) {
            PrintStream printStream = System.err;
            printStream.println("Html2Text: " + e4.getMessage());
            str = "";
        }
        return str.replaceAll("[ ]+", " ").replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
    }
}
