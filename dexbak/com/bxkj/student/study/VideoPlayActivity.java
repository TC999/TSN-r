package com.bxkj.student.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.URLEncodeUtils;
import com.bxkj.student.C4215R;
import com.devlin_n.floatWindowPermission.FloatWindowManager;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.stub.StubApp;
import com.tencent.connect.share.QzonePublish;
import java.util.Map;
import p635q.MainApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoPlayActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f19873k;

    /* renamed from: l */
    private TextView f19874l;

    /* renamed from: m */
    private SmartWebView f19875m;

    /* renamed from: n */
    private IjkVideoView f19876n;

    /* renamed from: o */
    private String f19877o = "https://media.w3.org/2010/05/sintel/trailer.mp4";

    /* renamed from: p */
    private String f19878p;

    /* renamed from: q */
    private String f19879q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.study.VideoPlayActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5473a extends HttpCallBack {
        C5473a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoPlayActivity.this.f19873k.setText("标题：" + JsonParse.getString(data, "title"));
            VideoPlayActivity.this.f19875m.m57495h(JsonParse.getString(data, "memo"));
            VideoPlayActivity.this.f19877o = JsonParse.getString(data, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            TextView textView = VideoPlayActivity.this.f19874l;
            textView.setText("播放量：" + JsonParse.getString(data, "playNum"));
            VideoPlayActivity.this.m39365o0();
        }
    }

    static {
        StubApp.interface11(12256);
    }

    /* renamed from: n0 */
    private void m39366n0() {
        Http.with(this.f1669h).setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2268i(this.f19878p)).setDataListener(new C5473a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void m39365o0() {
        this.f19876n.m35728U().m35730S().m35711f0(URLEncodeUtils.m44136a(this.f19877o)).m35709g0(new StandardVideoController(this)).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_video_player_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("videoName")) {
            String stringExtra = getIntent().getStringExtra("videoName");
            this.f19879q = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("videoId")) {
            this.f19878p = getIntent().getStringExtra("videoId");
        }
        m39366n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle(this.f19879q);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19873k = (TextView) findViewById(C4215R.C4219id.tv_video_title);
        this.f19875m = (SmartWebView) findViewById(2131232631);
        this.f19876n = (IjkVideoView) findViewById(C4215R.C4219id.player);
        this.f19874l = (TextView) findViewById(C4215R.C4219id.tv_play_num);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (FloatWindowManager.m35819f().m35822c(this)) {
                this.f19876n.mo35716d();
            } else {
                Toast.makeText(this.f1669h, "权限授予失败，无法开启悬浮窗", 0).show();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f19876n.m35724Y()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f19876n.m35721a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f19876n.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f19876n.mo35708h();
    }
}
