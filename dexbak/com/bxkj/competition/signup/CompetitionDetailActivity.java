package com.bxkj.competition.signup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.orhanobut.logger.C11792j;
import com.p518qq.p519e.comm.constants.Constants;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p635q.MainApiService;
import p640rx.Subscriber;
import p640rx.android.schedulers.AndroidSchedulers;
import p640rx.schedulers.Schedulers;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CompetitionDetailActivity extends BaseActivity {

    /* renamed from: A */
    private LinearLayout f15551A;

    /* renamed from: B */
    private LinearLayout f15552B;

    /* renamed from: C */
    private LinearLayout f15553C;

    /* renamed from: D */
    private LinearLayout f15554D;

    /* renamed from: E */
    private String f15555E;

    /* renamed from: F */
    private CountDownTimer f15556F;

    /* renamed from: G */
    private String f15557G;

    /* renamed from: H */
    private Map<String, Object> f15558H;

    /* renamed from: k */
    private RelativeLayout f15559k;

    /* renamed from: l */
    private CycleViewPager f15560l;

    /* renamed from: m */
    private TextView f15561m;

    /* renamed from: n */
    private TextView f15562n;

    /* renamed from: o */
    private TextView f15563o;

    /* renamed from: p */
    private TextView f15564p;

    /* renamed from: q */
    private TextView f15565q;

    /* renamed from: r */
    private TextView f15566r;

    /* renamed from: s */
    private TextView f15567s;

    /* renamed from: t */
    private TextView f15568t;

    /* renamed from: u */
    private TextView f15569u;

    /* renamed from: v */
    private TextView f15570v;

    /* renamed from: w */
    private CheckBox f15571w;

    /* renamed from: x */
    private SmartWebView f15572x;

    /* renamed from: y */
    private LinearLayout f15573y;

    /* renamed from: z */
    private LinearLayout f15574z;

    /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4090a implements iOSTwoButtonDialog.RightButtonOnClick {
        C4090a() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + CompetitionDetailActivity.this.f15568t.getText().toString().trim()));
            intent.setFlags(268435456);
            CompetitionDetailActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4091b extends HttpCallBack {
        C4091b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionDetailActivity.this.m43241z0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4092c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f15577a;

        View$OnClickListenerC4092c(final String val$url) {
            this.f15577a = val$url;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            CompetitionDetailActivity.this.startActivity(new Intent(((BaseActivity) CompetitionDetailActivity.this).f1669h, H5DetailActivity.class).putExtra("title", "赛事规程协议").putExtra("url", this.f15577a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4093d implements BaseActivity.InterfaceC1107c {

        /* renamed from: a */
        final /* synthetic */ String f15579a;

        /* renamed from: b */
        final /* synthetic */ String f15580b;

        /* renamed from: c */
        final /* synthetic */ String f15581c;

        C4093d(final String val$majorImg, final String val$url, final String val$name) {
            this.f15579a = val$majorImg;
            this.f15580b = val$url;
            this.f15581c = val$name;
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            CompetitionDetailActivity competitionDetailActivity = CompetitionDetailActivity.this;
            competitionDetailActivity.m43259C0(this.f15579a, competitionDetailActivity.getString(C4017R.C4025string.wanzhuan_app), this.f15580b, this.f15581c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CountDownTimerC4094e extends CountDownTimer {

        /* renamed from: a */
        final /* synthetic */ boolean f15583a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CountDownTimerC4094e(long x0, long x1, final boolean val$isStart) {
            super(x0, x1);
            this.f15583a = val$isStart;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (this.f15583a) {
                CompetitionDetailActivity.this.f15570v.setEnabled(true);
                CompetitionDetailActivity.this.f15570v.setBackgroundColor(CompetitionDetailActivity.this.getResources().getColor(C4017R.C4019color.themeColor));
                CompetitionDetailActivity.this.f15570v.setText("报名参赛");
                return;
            }
            CompetitionDetailActivity.this.f15570v.setText("报名已结束");
            CompetitionDetailActivity.this.f15566r.setText("报名已结束");
            CompetitionDetailActivity.this.f15570v.setEnabled(false);
            CompetitionDetailActivity.this.f15570v.setBackgroundColor(CompetitionDetailActivity.this.getResources().getColor(C4017R.C4019color.app_title4));
            CompetitionDetailActivity.this.f15567s.setVisibility(8);
            CompetitionDetailActivity.this.f15574z.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            CompetitionDetailActivity.this.m43261A0(millisUntilFinished);
        }
    }

    /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4095f implements CycleViewPager.ImageCycleViewListener {

        /* renamed from: a */
        final /* synthetic */ List f15585a;

        /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$f$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4096a extends Subscriber<ResponseBody> {
            C4096a() {
            }

            @Override // p640rx.Observer
            /* renamed from: F */
            public void onNext(ResponseBody responseBody) {
                C11792j.m20469d("onNext=" + responseBody.toString(), new Object[0]);
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                C11792j.m20469d("onCompleted", new Object[0]);
            }

            @Override // p640rx.Observer
            public void onError(Throwable e) {
                e.printStackTrace();
                C11792j.m20469d("Throwable", new Object[0]);
            }
        }

        C4095f(final List val$ads) {
            this.f15585a = val$ads;
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            List list = this.f15585a;
            if (list == null || list.size() <= position) {
                return;
            }
            Intent intent = new Intent(((BaseActivity) CompetitionDetailActivity.this).f1669h, H5DetailActivity.class);
            intent.putExtra("url", JsonParse.getString((Map) this.f15585a.get(position), Constants.KEYS.EXPOSED_CLICK_URL_KEY));
            intent.putExtra("title", JsonParse.getString((Map) this.f15585a.get(position), "advertiesTitle"));
            CompetitionDetailActivity.this.startActivity(intent);
            ((MainApiService) Http.getApiService(MainApiService.class)).m2261p(JsonParse.getString((Map) this.f15585a.get(0), "id"), LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId()).m1511v5(Schedulers.m475e()).m1833H3(AndroidSchedulers.m1982b()).m1551q5(new C4096a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4097g implements ShareBoardlistener {

        /* renamed from: a */
        final /* synthetic */ String f15588a;

        /* renamed from: b */
        final /* synthetic */ String f15589b;

        /* renamed from: c */
        final /* synthetic */ String f15590c;

        /* renamed from: d */
        final /* synthetic */ String f15591d;

        /* renamed from: com.bxkj.competition.signup.CompetitionDetailActivity$g$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4098a implements UMShareListener {
            C4098a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).f1669h, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t) {
                t.printStackTrace();
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).f1669h, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).f1669h, " 分享成功啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        C4097g(final String val$content, final String val$imgUrl, final String val$title, final String val$url) {
            this.f15588a = val$content;
            this.f15589b = val$imgUrl;
            this.f15590c = val$title;
            this.f15591d = val$url;
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb(this.f15588a);
            uMWeb.setTitle(this.f15589b);
            uMWeb.setThumb(new UMImage(((BaseActivity) CompetitionDetailActivity.this).f1669h, this.f15590c));
            uMWeb.setDescription(this.f15591d);
            new ShareAction(CompetitionDetailActivity.this).setPlatform(share_media).setCallback(new C4098a()).withMedia(uMWeb).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public void m43261A0(long millisUntilFinished) {
        double d = millisUntilFinished % 86400000;
        Double.isNaN(d);
        Double.isNaN(d);
        double d2 = d % 3600000.0d;
        this.f15567s.setText(((int) Math.floor(millisUntilFinished / 86400000)) + "天 " + ((int) Math.floor(d / 3600000.0d)) + "时 " + ((int) Math.floor(d2 / 60000.0d)) + " 分" + ((int) Math.floor((d2 % 60000.0d) / 1000.0d)) + " 秒");
    }

    /* renamed from: B0 */
    private void m43260B0(long time, final boolean isStart) {
        m43261A0(time);
        CountDownTimerC4094e countDownTimerC4094e = new CountDownTimerC4094e(time, 1000L, isStart);
        this.f15556F = countDownTimerC4094e;
        countDownTimerC4094e.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public void m43259C0(final String title, final String content, final String url, final String imgUrl) {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new C4097g(url, title, imgUrl, content)).open();
    }

    /* renamed from: w0 */
    private void m43244w0() {
        Intent intent;
        if (!this.f15571w.isChecked()) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请同意赛事规程协议").show();
            return;
        }
        if (JsonParse.getInt(this.f15558H, "signupType") == 0) {
            intent = new Intent(this.f1669h, FreeProjectListActivity.class);
        } else {
            intent = new Intent(this.f1669h, CostProjectListActivity.class);
        }
        startActivity(intent.putExtra("competitionId", this.f15555E));
    }

    /* renamed from: x0 */
    private void m43243x0() {
        Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43448i(this.f15555E)).setDataListener(new C4091b());
    }

    /* renamed from: y0 */
    private void m43242y0(final List<Map<String, Object>> ads) {
        ArrayList arrayList = new ArrayList();
        if (ads != null && ads.size() != 0) {
            for (Map<String, Object> map : ads) {
                arrayList.add(JsonParse.getString(map, "advertiesUrl"));
            }
        } else {
            arrayList.add("http://www.boxkj.com/resources/upload/photo/15fffd1a-12db-42d9-aeda-f94e179d277d.jpg");
            arrayList.add("http://www.boxkj.com/resources/upload/photo/f95cc0e8-4cdd-4011-a573-1070b7d76a0b.jpg");
            arrayList.add("http://www.boxkj.com/resources/upload/photo/6b63fa83-98c8-48ef-91b2-ce9c6d37e8ce.jpg");
        }
        this.f15560l.setIndicators(C4017R.C4020drawable.dot_focus_blue, C4017R.C4020drawable.dot_normal_blue);
        this.f15560l.setData(arrayList, new C4095f(ads));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public void m43241z0(Map<String, Object> data) {
        this.f15558H = data;
        this.f15559k.setVisibility(0);
        String string = JsonParse.getString(data, "name");
        this.f15561m.setText(string);
        TextView textView = this.f15562n;
        textView.setText("竞赛地点：" + JsonParse.getString(data, "address"));
        TextView textView2 = this.f15563o;
        textView2.setText("竞赛时间：" + JsonParse.getString(data, "startDate"));
        TextView textView3 = this.f15564p;
        textView3.setText("报名开始时间：" + JsonParse.getString(data, "signupBeginTime"));
        TextView textView4 = this.f15565q;
        textView4.setText("报名结束时间：" + JsonParse.getString(data, "signupEndTime"));
        List<String> list = JsonParse.getList(data, "sideImg", String.class);
        this.f15560l.setIndicators(C4017R.C4020drawable.dot_focus_blue, C4017R.C4020drawable.dot_normal_blue);
        this.f15560l.setData(list, null);
        String string2 = JsonParse.getString(data, "content");
        this.f15572x.m57493j(string2);
        this.f15569u.setOnClickListener(new View$OnClickListenerC4092c(string2));
        String string3 = JsonParse.getString(data, "majorImg");
        try {
            if (!getApplication().getPackageName().equalsIgnoreCase("com.bxkj.teacher")) {
                m57924c0("分享", C4017R.mipmap.share, new C4093d(string, string2, string3));
                invalidateOptionsMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f15557G)) {
            String string4 = JsonParse.getString(data, "timeStatus");
            if ("1".equals(string4)) {
                this.f15566r.setText("距离报名开始还有");
                this.f15570v.setText("报名未开始");
                this.f15570v.setEnabled(false);
                this.f15570v.setBackgroundColor(getResources().getColor(C4017R.C4019color.app_title4));
                this.f15574z.setVisibility(8);
                m43260B0(Long.valueOf(JsonParse.getLong(data, "timeValue")).longValue(), true);
                return;
            } else if ("2".equals(string4)) {
                this.f15566r.setText("距离报名结束还有");
                m43260B0(Long.valueOf(JsonParse.getLong(data, "timeValue")).longValue(), true);
                return;
            } else if ("3".equals(string4)) {
                this.f15570v.setText("报名已结束");
                this.f15566r.setText("报名已结束");
                this.f15570v.setEnabled(false);
                this.f15570v.setBackgroundColor(getResources().getColor(C4017R.C4019color.app_title4));
                this.f15567s.setVisibility(8);
                this.f15574z.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        this.f15573y.setVisibility(8);
        this.f15571w.setChecked(true);
        this.f15571w.setClickable(false);
        this.f15570v.setText("查看我报名的项目");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15568t.setOnClickListener(this);
        this.f15570v.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_competition_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f15555E = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra(com.tencent.connect.common.Constants.FROM)) {
            this.f15557G = getIntent().getStringExtra(com.tencent.connect.common.Constants.FROM);
        }
        m43243x0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15559k = (RelativeLayout) findViewById(C4017R.C4021id.rl_root);
        this.f15560l = (CycleViewPager) findViewById(C4017R.C4021id.f15341cy);
        this.f15561m = (TextView) findViewById(C4017R.C4021id.tv_title);
        this.f15562n = (TextView) findViewById(C4017R.C4021id.tv_address);
        this.f15566r = (TextView) findViewById(C4017R.C4021id.tv_status);
        this.f15567s = (TextView) findViewById(C4017R.C4021id.tv_time);
        this.f15563o = (TextView) findViewById(C4017R.C4021id.tv_start_time);
        this.f15564p = (TextView) findViewById(C4017R.C4021id.tv_apply_time);
        this.f15565q = (TextView) findViewById(C4017R.C4021id.tv_apply_end_time);
        this.f15568t = (TextView) findViewById(C4017R.C4021id.tv_phone);
        this.f15570v = (TextView) findViewById(C4017R.C4021id.tv_ok);
        this.f15572x = (SmartWebView) findViewById(C4017R.C4021id.swv);
        this.f15573y = (LinearLayout) findViewById(C4017R.C4021id.ll_time);
        this.f15574z = (LinearLayout) findViewById(C4017R.C4021id.ll_xy);
        this.f15569u = (TextView) findViewById(C4017R.C4021id.tv_xy);
        this.f15551A = (LinearLayout) findViewById(C4017R.C4021id.ll_wechat);
        this.f15552B = (LinearLayout) findViewById(C4017R.C4021id.ll_moments);
        this.f15553C = (LinearLayout) findViewById(C4017R.C4021id.ll_qq);
        this.f15554D = (LinearLayout) findViewById(C4017R.C4021id.ll_qzone);
        this.f15571w = (CheckBox) findViewById(C4017R.C4021id.cb_agree);
        this.f15559k.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();
        if (id == C4017R.C4021id.tv_phone) {
            new iOSTwoButtonDialog(this.f1669h).setTitle("提示").setMessage(getString(C4017R.C4025string.you_sure_call_phone)).setRightButtonOnClickListener(new C4090a()).show();
        } else if (id == C4017R.C4021id.tv_ok) {
            String trim = this.f15570v.getText().toString().trim();
            if (trim.equals("报名参赛")) {
                m43244w0();
            } else if (trim.equals("查看我报名的项目")) {
                if (JsonParse.getString(this.f15558H, "signupType").equals("0")) {
                    intent = new Intent(this.f1669h, FreeProjectListActivity.class);
                } else {
                    intent = new Intent(this.f1669h, CostProjectListActivity.class);
                }
                startActivity(intent.putExtra("competitionId", this.f15555E).putExtra(com.tencent.connect.common.Constants.FROM, "my"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f15556F;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }
}
