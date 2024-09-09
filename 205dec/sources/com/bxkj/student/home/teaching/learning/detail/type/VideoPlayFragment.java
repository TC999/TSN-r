package com.bxkj.student.home.teaching.learning.detail.type;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.a0;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class VideoPlayFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20815h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f20816i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20817j;

    /* renamed from: k  reason: collision with root package name */
    private SmartWebView f20818k;

    /* renamed from: l  reason: collision with root package name */
    private IjkVideoView f20819l;

    /* renamed from: m  reason: collision with root package name */
    private StandardVideoController f20820m;

    private void O(String videoPath) {
        StandardVideoController standardVideoController = new StandardVideoController(this.f1665e);
        this.f20820m = standardVideoController;
        standardVideoController.setCanFast(false);
        this.f20819l.S().U().f0(a0.a(videoPath)).g0(this.f20820m).start();
    }

    public void N() {
        StandardVideoController standardVideoController = this.f20820m;
        if (standardVideoController != null) {
            standardVideoController.c();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        if (getArguments().containsKey("videoPath")) {
            O(getArguments().getString("videoPath"));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\u6807\u9898\uff1a");
        if (getArguments().containsKey("title")) {
            sb.append(getArguments().getString("title"));
        }
        this.f20815h.setText(sb.toString());
        if (getArguments().containsKey("synopsis")) {
            this.f20817j.setText(getArguments().getString("synopsis"));
        }
        if (getArguments().containsKey("pv")) {
            String string = getArguments().getString("pv");
            TextView textView = this.f20816i;
            textView.setText("\u64ad\u653e\u91cf\uff1a" + string);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20815h = (TextView) c(2131233225);
        this.f20818k = (SmartWebView) c(2131232631);
        this.f20819l = (IjkVideoView) c(2131232455);
        this.f20816i = (TextView) c(2131233096);
        this.f20817j = (TextView) c(2131233224);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427427;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (com.devlin_n.floatWindowPermission.b.f().c(this.f1665e)) {
                this.f20819l.d();
            } else {
                Toast.makeText(this.f1665e, "\u6743\u9650\u6388\u4e88\u5931\u8d25\uff0c\u65e0\u6cd5\u5f00\u542f\u60ac\u6d6e\u7a97", 0).show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f20819l.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f20819l.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f20819l.h();
    }
}
