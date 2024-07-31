package com.bxkj.student.common.utils.video;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.util.URLEncodeUtils;
import com.bxkj.student.C4215R;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.tencent.connect.share.QzonePublish;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OnLinePlayVideoActivity extends BaseActivity {

    /* renamed from: k */
    private IjkVideoView f16252k;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_play_video;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)) {
            String stringExtra = getIntent().getStringExtra(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            this.f16252k.m35728U().m35730S().m35711f0(URLEncodeUtils.m44136a(stringExtra)).m35709g0(new StandardVideoController(this)).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("播放视频");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16252k = (IjkVideoView) findViewById(C4215R.C4219id.player);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f16252k.m35724Y()) {
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
        this.f16252k.m35721a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f16252k.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f16252k.mo35708h();
    }
}
