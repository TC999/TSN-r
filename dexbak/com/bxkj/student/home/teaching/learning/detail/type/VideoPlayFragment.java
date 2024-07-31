package com.bxkj.student.home.teaching.learning.detail.type;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.URLEncodeUtils;
import com.bxkj.student.C4215R;
import com.devlin_n.floatWindowPermission.FloatWindowManager;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.tencent.connect.share.QzonePublish;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoPlayFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f17472h;

    /* renamed from: i */
    private TextView f17473i;

    /* renamed from: j */
    private TextView f17474j;

    /* renamed from: k */
    private SmartWebView f17475k;

    /* renamed from: l */
    private IjkVideoView f17476l;

    /* renamed from: m */
    private StandardVideoController f17477m;

    /* renamed from: O */
    private void m41644O(String videoPath) {
        StandardVideoController standardVideoController = new StandardVideoController(this.f1678e);
        this.f17477m = standardVideoController;
        standardVideoController.setCanFast(false);
        this.f17476l.m35730S().m35728U().m35711f0(URLEncodeUtils.m44136a(videoPath)).m35709g0(this.f17477m).start();
    }

    /* renamed from: N */
    public void m41645N() {
        StandardVideoController standardVideoController = this.f17477m;
        if (standardVideoController != null) {
            standardVideoController.m35778c();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    public void mo39444e() {
        if (getArguments().containsKey(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)) {
            m41644O(getArguments().getString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("标题：");
        if (getArguments().containsKey("title")) {
            sb.append(getArguments().getString("title"));
        }
        this.f17472h.setText(sb.toString());
        if (getArguments().containsKey("synopsis")) {
            this.f17474j.setText(getArguments().getString("synopsis"));
        }
        if (getArguments().containsKey("pv")) {
            String string = getArguments().getString("pv");
            TextView textView = this.f17473i;
            textView.setText("播放量：" + string);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f17472h = (TextView) m57916c(C4215R.C4219id.tv_video_title);
        this.f17475k = (SmartWebView) m57916c(2131232631);
        this.f17476l = (IjkVideoView) m57916c(C4215R.C4219id.player);
        this.f17473i = (TextView) m57916c(C4215R.C4219id.tv_play_num);
        this.f17474j = (TextView) m57916c(C4215R.C4219id.tv_video_introduction);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.ac_learning_video_player_detail;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (FloatWindowManager.m35819f().m35822c(this.f1678e)) {
                this.f17476l.mo35716d();
            } else {
                Toast.makeText(this.f1678e, "权限授予失败，无法开启悬浮窗", 0).show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f17476l.m35721a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f17476l.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f17476l.mo35708h();
    }
}
