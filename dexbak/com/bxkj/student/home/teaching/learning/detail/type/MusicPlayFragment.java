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
import com.devlin_n.videoplayer.controller.StandardMusicController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.tencent.connect.share.QzonePublish;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MusicPlayFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f17451h;

    /* renamed from: i */
    private TextView f17452i;

    /* renamed from: j */
    private TextView f17453j;

    /* renamed from: k */
    private SmartWebView f17454k;

    /* renamed from: l */
    private IjkVideoView f17455l;

    /* renamed from: m */
    private String f17456m = "";

    /* renamed from: N */
    private void m41665N(String videoPath) {
        StandardMusicController standardMusicController = new StandardMusicController(this.f1678e);
        standardMusicController.m35762q();
        IjkVideoView m35728U = this.f17455l.m35730S().m35728U();
        m35728U.m35713e0("正在播放音频：" + this.f17456m).m35711f0(URLEncodeUtils.m44136a(videoPath)).m35709g0(standardMusicController).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    public void mo39444e() {
        if (getArguments().containsKey("title")) {
            this.f17456m = getArguments().getString("title");
        }
        if (getArguments().containsKey(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)) {
            m41665N(getArguments().getString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH));
        }
        this.f17451h.setText("标题：" + this.f17456m);
        if (getArguments().containsKey("synopsis")) {
            this.f17453j.setText(getArguments().getString("synopsis"));
        }
        if (getArguments().containsKey("pv")) {
            String string = getArguments().getString("pv");
            TextView textView = this.f17452i;
            textView.setText("播放量：" + string);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f17451h = (TextView) m57916c(C4215R.C4219id.tv_video_title);
        this.f17454k = (SmartWebView) m57916c(2131232631);
        this.f17455l = (IjkVideoView) m57916c(C4215R.C4219id.player);
        this.f17452i = (TextView) m57916c(C4215R.C4219id.tv_play_num);
        this.f17453j = (TextView) m57916c(C4215R.C4219id.tv_video_introduction);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_learning_music_player_detail;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (FloatWindowManager.m35819f().m35822c(this.f1678e)) {
                this.f17455l.mo35716d();
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
        this.f17455l.m35721a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f17455l.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f17455l.mo35708h();
    }
}
