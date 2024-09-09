package com.bxkj.student.home.teaching.learning.detail.backup;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentTransaction;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.a0;
import com.bxkj.base.view.TimeView;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class VideoPlayActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private ProgressBar f20674k;

    /* renamed from: l  reason: collision with root package name */
    private TimeView f20675l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20676m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20677n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20678o;

    /* renamed from: p  reason: collision with root package name */
    private SmartWebView f20679p;

    /* renamed from: q  reason: collision with root package name */
    private IjkVideoView f20680q;

    /* renamed from: s  reason: collision with root package name */
    private String f20682s;

    /* renamed from: t  reason: collision with root package name */
    private String f20683t;

    /* renamed from: u  reason: collision with root package name */
    private Timer f20684u;

    /* renamed from: v  reason: collision with root package name */
    private TimerTask f20685v;

    /* renamed from: w  reason: collision with root package name */
    private String f20686w;

    /* renamed from: x  reason: collision with root package name */
    private CountDownTimer f20687x;

    /* renamed from: r  reason: collision with root package name */
    private String f20681r = "http://xttp.xidian.edu.cn:1221/Upload/69045f62-a3eb-4c05-a1c0-7e1d92c05565.flv";

    /* renamed from: y  reason: collision with root package name */
    private int f20688y = 120000;

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
            VideoPlayActivity.this.R().setVisibility(0);
            StringBuilder sb = new StringBuilder();
            sb.append("\u6807\u9898\uff1a");
            String string = JsonParse.getString(data, "title");
            sb.append(string);
            VideoPlayActivity.this.f20676m.setText(sb.toString());
            String string2 = JsonParse.getString(data, "synopsis");
            VideoPlayActivity.this.f20678o.setText(string2);
            VideoPlayActivity.this.f20681r = JsonParse.getString(data, "content");
            TextView textView = VideoPlayActivity.this.f20677n;
            textView.setText("\u64ad\u653e\u91cf\uff1a" + JsonParse.getString(data, "pv"));
            VideoPlayActivity.this.f20686w = JsonParse.getString(data, "detailId");
            VideoPlayActivity.this.x0();
            int i4 = JsonParse.getInt(data, "duration");
            String string3 = JsonParse.getString(data, "indexImg");
            if (TextUtils.isEmpty(string3)) {
                string3 = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
            }
            UMVideo uMVideo = new UMVideo(VideoPlayActivity.this.f20681r);
            uMVideo.setTitle(string);
            uMVideo.setThumb(new UMImage(((BaseActivity) VideoPlayActivity.this).f1656h, string3));
            uMVideo.setDescription(string2);
            VideoPlayActivity videoPlayActivity = VideoPlayActivity.this;
            videoPlayActivity.v0(videoPlayActivity.f20686w, JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), i4, JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), uMVideo);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CountDownTimer {
        b(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            VideoPlayActivity.this.f20675l.i(VideoPlayActivity.this.f20688y / 1000, VideoPlayActivity.this.f20688y / 1000);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            int i4 = ((int) (VideoPlayActivity.this.f20688y - millisUntilFinished)) / 1000;
            VideoPlayActivity.this.f20675l.i(VideoPlayActivity.this.f20688y / 1000, i4);
            VideoPlayActivity.this.f20674k.setProgress(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f20682s);
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
    public void x0() {
        StandardVideoController standardVideoController = new StandardVideoController(this);
        standardVideoController.setCanFast(false);
        this.f20680q.S().U().f0(a0.a(this.f20681r)).g0(standardVideoController).start();
    }

    private void y0() {
        this.f20674k.setVisibility(0);
        this.f20675l.setVisibility(0);
        this.f20674k.setMax(this.f20688y / 1000);
        new SimpleDateFormat("HH:mm:ss").setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        b bVar = new b(this.f20688y, 1000L);
        this.f20687x = bVar;
        bVar.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427427;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("title")) {
            String stringExtra = getIntent().getStringExtra("title");
            this.f20683t = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("id")) {
            this.f20682s = getIntent().getStringExtra("id");
        }
        w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle(this.f20683t);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20674k = (ProgressBar) findViewById(2131232444);
        this.f20675l = (TimeView) findViewById(2131231089);
        this.f20676m = (TextView) findViewById(2131233225);
        this.f20679p = (SmartWebView) findViewById(2131232631);
        this.f20680q = (IjkVideoView) findViewById(2131232455);
        this.f20677n = (TextView) findViewById(2131233096);
        this.f20678o = (TextView) findViewById(2131233224);
        R().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (com.devlin_n.floatWindowPermission.b.f().c(this)) {
                this.f20680q.d();
            } else {
                Toast.makeText(this.f1656h, "\u6743\u9650\u6388\u4e88\u5931\u8d25\uff0c\u65e0\u6cd5\u5f00\u542f\u60ac\u6d6e\u7a97", 0).show();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f20680q.Y()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f20680q.a0();
        TimerTask timerTask = this.f20685v;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.f20684u;
        if (timer != null) {
            timer.cancel();
        }
        CountDownTimer countDownTimer = this.f20687x;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f20680q.pause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f20680q.h();
    }

    public void w0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).y(LoginUser.getLoginUser().getUserId(), this.f20682s)).setDataListener(new a());
    }
}
