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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.a0;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CircleDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private String f19487k = "https://tsncs.boxkj.com/resources/upload/learn/20200227221615_883.mp4";

    /* renamed from: l  reason: collision with root package name */
    private TextView f19488l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19489m;

    /* renamed from: n  reason: collision with root package name */
    private Button f19490n;

    /* renamed from: o  reason: collision with root package name */
    private ImageView f19491o;

    /* renamed from: p  reason: collision with root package name */
    private Button f19492p;

    /* renamed from: q  reason: collision with root package name */
    private IjkVideoView f19493q;

    /* renamed from: r  reason: collision with root package name */
    private String f19494r;

    /* renamed from: s  reason: collision with root package name */
    private CountDownTimer f19495s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Map map, View view) {
            CircleDetailActivity.this.D0(JsonParse.getString(map, "sysStudentName"), JsonParse.getString(map, "learnQuestionImage"));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(final Map<String, Object> data) {
            CircleDetailActivity.this.R().setVisibility(0);
            TextView textView = CircleDetailActivity.this.f19488l;
            textView.setText("\u7968\u6570\uff1a" + JsonParse.getString(data, "votesTotalNumber"));
            TextView textView2 = CircleDetailActivity.this.f19489m;
            textView2.setText("\u6392\u540d\uff1a" + JsonParse.getString(data, "rank"));
            CircleDetailActivity.this.z0(JsonParse.getString(data, "works"));
            CircleDetailActivity.this.A0(JsonParse.getInt(data, "isVote"), JsonParse.getBoolean(data, "voteFlag"), JsonParse.getLong(data, "countDown"));
            CircleDetailActivity.this.f19492p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.circle.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleDetailActivity.a.this.b(data, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends CountDownTimer {
        c(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CircleDetailActivity.this.A0(1, false, 0L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            CircleDetailActivity.this.B0(millisUntilFinished);
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
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).f1656h, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t3) {
            t3.printStackTrace();
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).f1656h, " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).f1656h, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int isVote, boolean voteFlag, long millisUntilFinished) {
        if (isVote == 0) {
            this.f19490n.setEnabled(false);
            this.f19490n.setBackground(ContextCompat.getDrawable(this.f1656h, 2131165382));
            if (millisUntilFinished <= 0) {
                this.f19490n.setText("\u6295\u7968\u672a\u5f00\u59cb");
                return;
            }
            B0(millisUntilFinished);
            C0(millisUntilFinished);
        } else if (isVote != 1) {
            this.f19490n.setEnabled(false);
            this.f19490n.setBackground(ContextCompat.getDrawable(this.f1656h, 2131165382));
            this.f19490n.setText("\u6295\u7968\u5df2\u7ed3\u675f");
        } else if (voteFlag) {
            this.f19490n.setVisibility(8);
            this.f19491o.setVisibility(0);
        } else {
            this.f19490n.setVisibility(0);
            this.f19491o.setVisibility(8);
            this.f19490n.setEnabled(true);
            this.f19490n.setBackground(ContextCompat.getDrawable(this.f1656h, 2131165392));
            this.f19490n.setText("\u6295\u7968");
            this.f19490n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.circle.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleDetailActivity.this.x0(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(long millisUntilFinished) {
        int floor = (int) Math.floor(millisUntilFinished / 86400000);
        double d4 = millisUntilFinished % 86400000;
        Double.isNaN(d4);
        int floor2 = (int) Math.floor(d4 / 3600000.0d);
        Double.isNaN(d4);
        double d5 = d4 % 3600000.0d;
        int floor3 = (int) Math.floor(d5 / 60000.0d);
        int floor4 = (int) Math.floor((d5 % 60000.0d) / 1000.0d);
        StringBuilder sb = new StringBuilder();
        sb.append("\u8ddd\u79bb\u6295\u7968\u5f00\u59cb\u8fd8\u6709");
        if (floor > 0) {
            if (floor < 10) {
                sb.append("0");
            }
            sb.append(floor);
            sb.append("\u5929");
        }
        if (floor2 > 0) {
            if (floor2 < 10) {
                sb.append("0");
            }
            sb.append(floor2);
            sb.append("\u65f6");
        }
        if (floor3 > 0) {
            if (floor3 < 10) {
                sb.append("0");
            }
            sb.append(floor3);
            sb.append("\u5206");
        }
        if (floor4 < 10) {
            sb.append("0");
        }
        sb.append(floor4);
        sb.append("\u79d2");
        this.f19490n.setText(sb);
    }

    private void C0(long time) {
        B0(time);
        c cVar = new c(time, 1000L);
        this.f19495s = cVar;
        cVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(final String name, final String learnQuestionImage) {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.circle.b
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                CircleDetailActivity.this.y0(name, learnQuestionImage, snsPlatform, share_media);
            }
        }).open();
    }

    private void E0() {
        Http.with(this.f1656h).hideSuccessMessage().setObservable(((w.a) Http.getApiService(w.a.class)).W0(this.f19494r, 0, 1)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).Z0(this.f19494r)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(String str, String str2, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
        uMWeb.setTitle("\u8bf7\u4e3a" + str + "\u6295\u4e0a\u4e00\u7968");
        uMWeb.setThumb(new UMImage(this.f1656h, str2));
        uMWeb.setDescription("2020\u5e74\u5b66\u751f\u201c\u9f50\u6297\u75ab\uff0c\u4e91\u953b\u70bc\u201d\u5c45\u5bb6\u953b\u70bc\u6a21\u8303\u8bc4\u6bd4\u6d3b\u52a8");
        new ShareAction(this).setPlatform(share_media).setCallback(new d()).withMedia(uMWeb).share();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String videoPath) {
        this.f19493q.U().S().f0(a0.a(videoPath)).g0(new StandardVideoController(this)).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427381;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("learnSelectionWorkId")) {
            this.f19494r = getIntent().getStringExtra("learnSelectionWorkId");
            w0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u53c2\u4e0e\u6295\u7968");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19493q = (IjkVideoView) findViewById(2131232455);
        this.f19488l = (TextView) findViewById(2131233050);
        this.f19489m = (TextView) findViewById(2131233116);
        this.f19490n = (Button) findViewById(2131231018);
        this.f19491o = (ImageView) findViewById(2131231425);
        this.f19492p = (Button) findViewById(2131231009);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.f1656h).onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f19493q.a0();
        CountDownTimer countDownTimer = this.f19495s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f19493q.pause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f19493q.h();
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
            CircleDetailActivity.this.w0();
            CircleFragment circleFragment = (CircleFragment) cn.bluemobi.dylan.base.utils.a.n().o(CircleFragment.class);
            if (circleFragment != null) {
                circleFragment.j0();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            new iOSOneButtonDialog(((BaseActivity) CircleDetailActivity.this).f1656h).setMessage(msg).show();
        }
    }
}
