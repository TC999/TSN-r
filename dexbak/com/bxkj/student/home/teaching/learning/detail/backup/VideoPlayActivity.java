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
import com.bxkj.base.util.URLEncodeUtils;
import com.bxkj.base.view.TimeView;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.devlin_n.floatWindowPermission.FloatWindowManager;
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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoPlayActivity extends BaseActivity {

    /* renamed from: k */
    private ProgressBar f17330k;

    /* renamed from: l */
    private TimeView f17331l;

    /* renamed from: m */
    private TextView f17332m;

    /* renamed from: n */
    private TextView f17333n;

    /* renamed from: o */
    private TextView f17334o;

    /* renamed from: p */
    private SmartWebView f17335p;

    /* renamed from: q */
    private IjkVideoView f17336q;

    /* renamed from: s */
    private String f17338s;

    /* renamed from: t */
    private String f17339t;

    /* renamed from: u */
    private Timer f17340u;

    /* renamed from: v */
    private TimerTask f17341v;

    /* renamed from: w */
    private String f17342w;

    /* renamed from: x */
    private CountDownTimer f17343x;

    /* renamed from: r */
    private String f17337r = "http://xttp.xidian.edu.cn:1221/Upload/69045f62-a3eb-4c05-a1c0-7e1d92c05565.flv";

    /* renamed from: y */
    private int f17344y = 120000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.VideoPlayActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4623a extends HttpCallBack {
        C4623a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoPlayActivity.this.m57932R().setVisibility(0);
            StringBuilder sb = new StringBuilder();
            sb.append("标题：");
            String string = JsonParse.getString(data, "title");
            sb.append(string);
            VideoPlayActivity.this.f17332m.setText(sb.toString());
            String string2 = JsonParse.getString(data, "synopsis");
            VideoPlayActivity.this.f17334o.setText(string2);
            VideoPlayActivity.this.f17337r = JsonParse.getString(data, "content");
            TextView textView = VideoPlayActivity.this.f17333n;
            textView.setText("播放量：" + JsonParse.getString(data, "pv"));
            VideoPlayActivity.this.f17342w = JsonParse.getString(data, "detailId");
            VideoPlayActivity.this.m41764x0();
            int i = JsonParse.getInt(data, "duration");
            String string3 = JsonParse.getString(data, "indexImg");
            if (TextUtils.isEmpty(string3)) {
                string3 = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
            }
            UMVideo uMVideo = new UMVideo(VideoPlayActivity.this.f17337r);
            uMVideo.setTitle(string);
            uMVideo.setThumb(new UMImage(((BaseActivity) VideoPlayActivity.this).f1669h, string3));
            uMVideo.setDescription(string2);
            VideoPlayActivity videoPlayActivity = VideoPlayActivity.this;
            videoPlayActivity.m41766v0(videoPlayActivity.f17342w, JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), i, JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), uMVideo);
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.VideoPlayActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CountDownTimerC4624b extends CountDownTimer {
        CountDownTimerC4624b(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            VideoPlayActivity.this.f17331l.m43513i(VideoPlayActivity.this.f17344y / 1000, VideoPlayActivity.this.f17344y / 1000);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            int i = ((int) (VideoPlayActivity.this.f17344y - millisUntilFinished)) / 1000;
            VideoPlayActivity.this.f17331l.m43513i(VideoPlayActivity.this.f17344y / 1000, i);
            VideoPlayActivity.this.f17330k.setProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public void m41766v0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f17338s);
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
    /* renamed from: x0 */
    public void m41764x0() {
        StandardVideoController standardVideoController = new StandardVideoController(this);
        standardVideoController.setCanFast(false);
        this.f17336q.m35730S().m35728U().m35711f0(URLEncodeUtils.m44136a(this.f17337r)).m35709g0(standardVideoController).start();
    }

    /* renamed from: y0 */
    private void m41763y0() {
        this.f17330k.setVisibility(0);
        this.f17331l.setVisibility(0);
        this.f17330k.setMax(this.f17344y / 1000);
        new SimpleDateFormat("HH:mm:ss").setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        CountDownTimerC4624b countDownTimerC4624b = new CountDownTimerC4624b(this.f17344y, 1000L);
        this.f17343x = countDownTimerC4624b;
        countDownTimerC4624b.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learning_video_player_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("title")) {
            String stringExtra = getIntent().getStringExtra("title");
            this.f17339t = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("id")) {
            this.f17338s = getIntent().getStringExtra("id");
        }
        m41765w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle(this.f17339t);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17330k = (ProgressBar) findViewById(C4215R.C4219id.f16004pb);
        this.f17331l = (TimeView) findViewById(C4215R.C4219id.cdtv);
        this.f17332m = (TextView) findViewById(C4215R.C4219id.tv_video_title);
        this.f17335p = (SmartWebView) findViewById(2131232631);
        this.f17336q = (IjkVideoView) findViewById(C4215R.C4219id.player);
        this.f17333n = (TextView) findViewById(C4215R.C4219id.tv_play_num);
        this.f17334o = (TextView) findViewById(C4215R.C4219id.tv_video_introduction);
        m57932R().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (FloatWindowManager.m35819f().m35822c(this)) {
                this.f17336q.mo35716d();
            } else {
                Toast.makeText(this.f1669h, "权限授予失败，无法开启悬浮窗", 0).show();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f17336q.m35724Y()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f17336q.m35721a0();
        TimerTask timerTask = this.f17341v;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.f17340u;
        if (timer != null) {
            timer.cancel();
        }
        CountDownTimer countDownTimer = this.f17343x;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f17336q.pause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f17336q.mo35708h();
    }

    /* renamed from: w0 */
    public void m41765w0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41617y(LoginUser.getLoginUser().getUserId(), this.f17338s)).setDataListener(new C4623a());
    }
}
