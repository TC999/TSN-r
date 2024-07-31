package com.bxkj.student.circle;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.URLEncodeUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.circle.CircleDetailActivity;
import com.bxkj.student.main.CircleFragment;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CircleDetailActivity extends BaseActivity {

    /* renamed from: k */
    private String f16091k = "https://tsncs.boxkj.com/resources/upload/learn/20200227221615_883.mp4";

    /* renamed from: l */
    private TextView f16092l;

    /* renamed from: m */
    private TextView f16093m;

    /* renamed from: n */
    private Button f16094n;

    /* renamed from: o */
    private ImageView f16095o;

    /* renamed from: p */
    private Button f16096p;

    /* renamed from: q */
    private IjkVideoView f16097q;

    /* renamed from: r */
    private String f16098r;

    /* renamed from: s */
    private CountDownTimer f16099s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.circle.CircleDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4230a extends HttpCallBack {
        C4230a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m42935b(Map map, View view) {
            CircleDetailActivity.this.m42956D0(JsonParse.getString(map, "sysStudentName"), JsonParse.getString(map, "learnQuestionImage"));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(final Map<String, Object> data) {
            CircleDetailActivity.this.m57932R().setVisibility(0);
            TextView textView = CircleDetailActivity.this.f16092l;
            textView.setText("票数：" + JsonParse.getString(data, "votesTotalNumber"));
            TextView textView2 = CircleDetailActivity.this.f16093m;
            textView2.setText("排名：" + JsonParse.getString(data, "rank"));
            CircleDetailActivity.this.m42937z0(JsonParse.getString(data, "works"));
            CircleDetailActivity.this.m42959A0(JsonParse.getInt(data, "isVote"), JsonParse.getBoolean(data, "voteFlag"), JsonParse.getLong(data, "countDown"));
            CircleDetailActivity.this.f16096p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.circle.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleDetailActivity.C4230a.this.m42935b(data, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.circle.CircleDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CountDownTimerC4232c extends CountDownTimer {
        CountDownTimerC4232c(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CircleDetailActivity.this.m42959A0(1, false, 0L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            CircleDetailActivity.this.m42958B0(millisUntilFinished);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.circle.CircleDetailActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4233d implements UMShareListener {
        C4233d() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).f1669h, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t) {
            t.printStackTrace();
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).f1669h, " 分享失败啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).f1669h, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public void m42959A0(int isVote, boolean voteFlag, long millisUntilFinished) {
        if (isVote == 0) {
            this.f16094n.setEnabled(false);
            this.f16094n.setBackground(ContextCompat.getDrawable(this.f1669h, 2131165382));
            if (millisUntilFinished <= 0) {
                this.f16094n.setText("投票未开始");
                return;
            }
            m42958B0(millisUntilFinished);
            m42957C0(millisUntilFinished);
        } else if (isVote != 1) {
            this.f16094n.setEnabled(false);
            this.f16094n.setBackground(ContextCompat.getDrawable(this.f1669h, 2131165382));
            this.f16094n.setText("投票已结束");
        } else if (voteFlag) {
            this.f16094n.setVisibility(8);
            this.f16095o.setVisibility(0);
        } else {
            this.f16094n.setVisibility(0);
            this.f16095o.setVisibility(8);
            this.f16094n.setEnabled(true);
            this.f16094n.setBackground(ContextCompat.getDrawable(this.f1669h, 2131165392));
            this.f16094n.setText("投票");
            this.f16094n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.circle.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleDetailActivity.this.m42939x0(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public void m42958B0(long millisUntilFinished) {
        int floor = (int) Math.floor(millisUntilFinished / 86400000);
        double d = millisUntilFinished % 86400000;
        Double.isNaN(d);
        int floor2 = (int) Math.floor(d / 3600000.0d);
        Double.isNaN(d);
        double d2 = d % 3600000.0d;
        int floor3 = (int) Math.floor(d2 / 60000.0d);
        int floor4 = (int) Math.floor((d2 % 60000.0d) / 1000.0d);
        StringBuilder sb = new StringBuilder();
        sb.append("距离投票开始还有");
        if (floor > 0) {
            if (floor < 10) {
                sb.append("0");
            }
            sb.append(floor);
            sb.append("天");
        }
        if (floor2 > 0) {
            if (floor2 < 10) {
                sb.append("0");
            }
            sb.append(floor2);
            sb.append("时");
        }
        if (floor3 > 0) {
            if (floor3 < 10) {
                sb.append("0");
            }
            sb.append(floor3);
            sb.append("分");
        }
        if (floor4 < 10) {
            sb.append("0");
        }
        sb.append(floor4);
        sb.append("秒");
        this.f16094n.setText(sb);
    }

    /* renamed from: C0 */
    private void m42957C0(long time) {
        m42958B0(time);
        CountDownTimerC4232c countDownTimerC4232c = new CountDownTimerC4232c(time, 1000L);
        this.f16099s = countDownTimerC4232c;
        countDownTimerC4232c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public void m42956D0(final String name, final String learnQuestionImage) {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.circle.b
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                CircleDetailActivity.this.m42938y0(name, learnQuestionImage, snsPlatform, share_media);
            }
        }).open();
    }

    /* renamed from: E0 */
    private void m42955E0() {
        Http.with(this.f1669h).hideSuccessMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m136W0(this.f16098r, 0, 1)).setDataListener(new C4231b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public void m42940w0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m130Z0(this.f16098r)).setDataListener(new C4230a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void m42939x0(View view) {
        m42955E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void m42938y0(String str, String str2, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
        uMWeb.setTitle("请为" + str + "投上一票");
        uMWeb.setThumb(new UMImage(this.f1669h, str2));
        uMWeb.setDescription("2020年学生“齐抗疫，云锻炼”居家锻炼模范评比活动");
        new ShareAction(this).setPlatform(share_media).setCallback(new C4233d()).withMedia(uMWeb).share();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public void m42937z0(String videoPath) {
        this.f16097q.m35728U().m35730S().m35711f0(URLEncodeUtils.m44136a(videoPath)).m35709g0(new StandardVideoController(this)).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_circle_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("learnSelectionWorkId")) {
            this.f16098r = getIntent().getStringExtra("learnSelectionWorkId");
            m42940w0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("参与投票");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16097q = (IjkVideoView) findViewById(C4215R.C4219id.player);
        this.f16092l = (TextView) findViewById(2131233050);
        this.f16093m = (TextView) findViewById(2131233116);
        this.f16094n = (Button) findViewById(C4215R.C4219id.bt_vote);
        this.f16095o = (ImageView) findViewById(C4215R.C4219id.iv_has_vote);
        this.f16096p = (Button) findViewById(C4215R.C4219id.bt_share);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.f1669h).onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f16097q.m35721a0();
        CountDownTimer countDownTimer = this.f16099s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f16097q.pause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f16097q.mo35708h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.circle.CircleDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4231b extends HttpCallBack {
        C4231b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CircleDetailActivity.this.m42940w0();
            CircleFragment circleFragment = (CircleFragment) AppManager.m57776n().m57775o(CircleFragment.class);
            if (circleFragment != null) {
                circleFragment.m40674j0();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            new iOSOneButtonDialog(((BaseActivity) CircleDetailActivity.this).f1669h).setMessage(msg).show();
        }
    }
}
