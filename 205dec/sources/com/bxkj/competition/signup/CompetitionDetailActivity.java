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
import com.bxkj.competition.R;
import com.orhanobut.logger.j;
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
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CompetitionDetailActivity extends BaseActivity {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private String E;
    private CountDownTimer F;
    private String G;
    private Map<String, Object> H;

    /* renamed from: k  reason: collision with root package name */
    private RelativeLayout f19095k;

    /* renamed from: l  reason: collision with root package name */
    private CycleViewPager f19096l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19097m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19098n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f19099o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f19100p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f19101q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f19102r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f19103s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f19104t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f19105u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f19106v;

    /* renamed from: w  reason: collision with root package name */
    private CheckBox f19107w;

    /* renamed from: x  reason: collision with root package name */
    private SmartWebView f19108x;

    /* renamed from: y  reason: collision with root package name */
    private LinearLayout f19109y;

    /* renamed from: z  reason: collision with root package name */
    private LinearLayout f19110z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements iOSTwoButtonDialog.RightButtonOnClick {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + CompetitionDetailActivity.this.f19104t.getText().toString().trim()));
            intent.setFlags(268435456);
            CompetitionDetailActivity.this.startActivity(intent);
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
            CompetitionDetailActivity.this.z0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19113a;

        c(final String val$url) {
            this.f19113a = val$url;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            CompetitionDetailActivity.this.startActivity(new Intent(((BaseActivity) CompetitionDetailActivity.this).f1656h, H5DetailActivity.class).putExtra("title", "\u8d5b\u4e8b\u89c4\u7a0b\u534f\u8bae").putExtra("url", this.f19113a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements BaseActivity.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19115a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19116b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19117c;

        d(final String val$majorImg, final String val$url, final String val$name) {
            this.f19115a = val$majorImg;
            this.f19116b = val$url;
            this.f19117c = val$name;
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            CompetitionDetailActivity competitionDetailActivity = CompetitionDetailActivity.this;
            competitionDetailActivity.C0(this.f19115a, competitionDetailActivity.getString(R.string.wanzhuan_app), this.f19116b, this.f19117c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f19119a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long x02, long x12, final boolean val$isStart) {
            super(x02, x12);
            this.f19119a = val$isStart;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (this.f19119a) {
                CompetitionDetailActivity.this.f19106v.setEnabled(true);
                CompetitionDetailActivity.this.f19106v.setBackgroundColor(CompetitionDetailActivity.this.getResources().getColor(R.color.themeColor));
                CompetitionDetailActivity.this.f19106v.setText("\u62a5\u540d\u53c2\u8d5b");
                return;
            }
            CompetitionDetailActivity.this.f19106v.setText("\u62a5\u540d\u5df2\u7ed3\u675f");
            CompetitionDetailActivity.this.f19102r.setText("\u62a5\u540d\u5df2\u7ed3\u675f");
            CompetitionDetailActivity.this.f19106v.setEnabled(false);
            CompetitionDetailActivity.this.f19106v.setBackgroundColor(CompetitionDetailActivity.this.getResources().getColor(R.color.app_title4));
            CompetitionDetailActivity.this.f19103s.setVisibility(8);
            CompetitionDetailActivity.this.f19110z.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            CompetitionDetailActivity.this.A0(millisUntilFinished);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f implements CycleViewPager.ImageCycleViewListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f19121a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends l<ResponseBody> {
            a() {
            }

            @Override // rx.f
            /* renamed from: F */
            public void onNext(ResponseBody responseBody) {
                j.d("onNext=" + responseBody.toString(), new Object[0]);
            }

            @Override // rx.f
            public void onCompleted() {
                j.d("onCompleted", new Object[0]);
            }

            @Override // rx.f
            public void onError(Throwable e4) {
                e4.printStackTrace();
                j.d("Throwable", new Object[0]);
            }
        }

        f(final List val$ads) {
            this.f19121a = val$ads;
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            List list = this.f19121a;
            if (list == null || list.size() <= position) {
                return;
            }
            Intent intent = new Intent(((BaseActivity) CompetitionDetailActivity.this).f1656h, H5DetailActivity.class);
            intent.putExtra("url", JsonParse.getString((Map) this.f19121a.get(position), "clickUrl"));
            intent.putExtra("title", JsonParse.getString((Map) this.f19121a.get(position), "advertiesTitle"));
            CompetitionDetailActivity.this.startActivity(intent);
            ((q.f) Http.getApiService(q.f.class)).p(JsonParse.getString((Map) this.f19121a.get(0), "id"), LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId()).v5(rx.schedulers.c.e()).H3(rx.android.schedulers.a.b()).q5(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g implements ShareBoardlistener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19125b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19126c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f19127d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).f1656h, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t3) {
                t3.printStackTrace();
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).f1656h, " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).f1656h, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        g(final String val$content, final String val$imgUrl, final String val$title, final String val$url) {
            this.f19124a = val$content;
            this.f19125b = val$imgUrl;
            this.f19126c = val$title;
            this.f19127d = val$url;
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb(this.f19124a);
            uMWeb.setTitle(this.f19125b);
            uMWeb.setThumb(new UMImage(((BaseActivity) CompetitionDetailActivity.this).f1656h, this.f19126c));
            uMWeb.setDescription(this.f19127d);
            new ShareAction(CompetitionDetailActivity.this).setPlatform(share_media).setCallback(new a()).withMedia(uMWeb).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(long millisUntilFinished) {
        double d4 = millisUntilFinished % 86400000;
        Double.isNaN(d4);
        Double.isNaN(d4);
        double d5 = d4 % 3600000.0d;
        this.f19103s.setText(((int) Math.floor(millisUntilFinished / 86400000)) + "\u5929 " + ((int) Math.floor(d4 / 3600000.0d)) + "\u65f6 " + ((int) Math.floor(d5 / 60000.0d)) + " \u5206" + ((int) Math.floor((d5 % 60000.0d) / 1000.0d)) + " \u79d2");
    }

    private void B0(long time, final boolean isStart) {
        A0(time);
        e eVar = new e(time, 1000L, isStart);
        this.F = eVar;
        eVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(final String title, final String content, final String url, final String imgUrl) {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new g(url, title, imgUrl, content)).open();
    }

    private void w0() {
        Intent intent;
        if (!this.f19107w.isChecked()) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u540c\u610f\u8d5b\u4e8b\u89c4\u7a0b\u534f\u8bae").show();
            return;
        }
        if (JsonParse.getInt(this.H, "signupType") == 0) {
            intent = new Intent(this.f1656h, FreeProjectListActivity.class);
        } else {
            intent = new Intent(this.f1656h, CostProjectListActivity.class);
        }
        startActivity(intent.putExtra("competitionId", this.E));
    }

    private void x0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).i(this.E)).setDataListener(new b());
    }

    private void y0(final List<Map<String, Object>> ads) {
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
        this.f19096l.setIndicators(R.drawable.dot_focus_blue, R.drawable.dot_normal_blue);
        this.f19096l.setData(arrayList, new f(ads));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(Map<String, Object> data) {
        this.H = data;
        this.f19095k.setVisibility(0);
        String string = JsonParse.getString(data, "name");
        this.f19097m.setText(string);
        TextView textView = this.f19098n;
        textView.setText("\u7ade\u8d5b\u5730\u70b9\uff1a" + JsonParse.getString(data, "address"));
        TextView textView2 = this.f19099o;
        textView2.setText("\u7ade\u8d5b\u65f6\u95f4\uff1a" + JsonParse.getString(data, "startDate"));
        TextView textView3 = this.f19100p;
        textView3.setText("\u62a5\u540d\u5f00\u59cb\u65f6\u95f4\uff1a" + JsonParse.getString(data, "signupBeginTime"));
        TextView textView4 = this.f19101q;
        textView4.setText("\u62a5\u540d\u7ed3\u675f\u65f6\u95f4\uff1a" + JsonParse.getString(data, "signupEndTime"));
        List<String> list = JsonParse.getList(data, "sideImg", String.class);
        this.f19096l.setIndicators(R.drawable.dot_focus_blue, R.drawable.dot_normal_blue);
        this.f19096l.setData(list, null);
        String string2 = JsonParse.getString(data, "content");
        this.f19108x.j(string2);
        this.f19105u.setOnClickListener(new c(string2));
        String string3 = JsonParse.getString(data, "majorImg");
        try {
            if (!getApplication().getPackageName().equalsIgnoreCase("com.bxkj.teacher")) {
                c0("\u5206\u4eab", R.mipmap.share, new d(string, string2, string3));
                invalidateOptionsMenu();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (TextUtils.isEmpty(this.G)) {
            String string4 = JsonParse.getString(data, "timeStatus");
            if ("1".equals(string4)) {
                this.f19102r.setText("\u8ddd\u79bb\u62a5\u540d\u5f00\u59cb\u8fd8\u6709");
                this.f19106v.setText("\u62a5\u540d\u672a\u5f00\u59cb");
                this.f19106v.setEnabled(false);
                this.f19106v.setBackgroundColor(getResources().getColor(R.color.app_title4));
                this.f19110z.setVisibility(8);
                B0(Long.valueOf(JsonParse.getLong(data, "timeValue")).longValue(), true);
                return;
            } else if ("2".equals(string4)) {
                this.f19102r.setText("\u8ddd\u79bb\u62a5\u540d\u7ed3\u675f\u8fd8\u6709");
                B0(Long.valueOf(JsonParse.getLong(data, "timeValue")).longValue(), true);
                return;
            } else if ("3".equals(string4)) {
                this.f19106v.setText("\u62a5\u540d\u5df2\u7ed3\u675f");
                this.f19102r.setText("\u62a5\u540d\u5df2\u7ed3\u675f");
                this.f19106v.setEnabled(false);
                this.f19106v.setBackgroundColor(getResources().getColor(R.color.app_title4));
                this.f19103s.setVisibility(8);
                this.f19110z.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        this.f19109y.setVisibility(8);
        this.f19107w.setChecked(true);
        this.f19107w.setClickable(false);
        this.f19106v.setText("\u67e5\u770b\u6211\u62a5\u540d\u7684\u9879\u76ee");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19104t.setOnClickListener(this);
        this.f19106v.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_competition_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.E = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("from")) {
            this.G = getIntent().getStringExtra("from");
        }
        x0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19095k = (RelativeLayout) findViewById(R.id.rl_root);
        this.f19096l = (CycleViewPager) findViewById(R.id.cy);
        this.f19097m = (TextView) findViewById(R.id.tv_title);
        this.f19098n = (TextView) findViewById(R.id.tv_address);
        this.f19102r = (TextView) findViewById(R.id.tv_status);
        this.f19103s = (TextView) findViewById(R.id.tv_time);
        this.f19099o = (TextView) findViewById(R.id.tv_start_time);
        this.f19100p = (TextView) findViewById(R.id.tv_apply_time);
        this.f19101q = (TextView) findViewById(R.id.tv_apply_end_time);
        this.f19104t = (TextView) findViewById(R.id.tv_phone);
        this.f19106v = (TextView) findViewById(R.id.tv_ok);
        this.f19108x = (SmartWebView) findViewById(R.id.swv);
        this.f19109y = (LinearLayout) findViewById(R.id.ll_time);
        this.f19110z = (LinearLayout) findViewById(R.id.ll_xy);
        this.f19105u = (TextView) findViewById(R.id.tv_xy);
        this.A = (LinearLayout) findViewById(R.id.ll_wechat);
        this.B = (LinearLayout) findViewById(R.id.ll_moments);
        this.C = (LinearLayout) findViewById(R.id.ll_qq);
        this.D = (LinearLayout) findViewById(R.id.ll_qzone);
        this.f19107w = (CheckBox) findViewById(R.id.cb_agree);
        this.f19095k.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intent intent;
        int id = v3.getId();
        if (id == R.id.tv_phone) {
            new iOSTwoButtonDialog(this.f1656h).setTitle("\u63d0\u793a").setMessage(getString(R.string.you_sure_call_phone)).setRightButtonOnClickListener(new a()).show();
        } else if (id == R.id.tv_ok) {
            String trim = this.f19106v.getText().toString().trim();
            if (trim.equals("\u62a5\u540d\u53c2\u8d5b")) {
                w0();
            } else if (trim.equals("\u67e5\u770b\u6211\u62a5\u540d\u7684\u9879\u76ee")) {
                if (JsonParse.getString(this.H, "signupType").equals("0")) {
                    intent = new Intent(this.f1656h, FreeProjectListActivity.class);
                } else {
                    intent = new Intent(this.f1656h, CostProjectListActivity.class);
                }
                startActivity(intent.putExtra("competitionId", this.E).putExtra("from", "my"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.F;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }
}
