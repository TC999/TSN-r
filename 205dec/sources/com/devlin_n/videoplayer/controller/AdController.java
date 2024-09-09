package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b1.a;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.controller.BaseVideoController;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class AdController extends BaseVideoController implements View.OnClickListener {
    protected ImageView A;

    /* renamed from: v  reason: collision with root package name */
    protected TextView f36858v;

    /* renamed from: w  reason: collision with root package name */
    protected TextView f36859w;

    /* renamed from: x  reason: collision with root package name */
    protected ImageView f36860x;

    /* renamed from: y  reason: collision with root package name */
    protected ImageView f36861y;

    /* renamed from: z  reason: collision with root package name */
    protected ImageView f36862z;

    public AdController(@NonNull Context context) {
        super(context);
    }

    private void l() {
        this.f36864b.h();
        if (this.f36864b.isMute()) {
            this.f36861y.setImageResource(R.drawable.ic_action_volume_up);
        } else {
            this.f36861y.setImageResource(R.drawable.ic_action_volume_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void e() {
        super.e();
        this.f36858v = (TextView) this.f36863a.findViewById(R.id.ad_time);
        TextView textView = (TextView) this.f36863a.findViewById(R.id.ad_detail);
        this.f36859w = textView;
        textView.setText("\u4e86\u89e3\u8be6\u60c5>");
        ImageView imageView = (ImageView) this.f36863a.findViewById(R.id.back);
        this.f36860x = imageView;
        imageView.setVisibility(8);
        this.f36861y = (ImageView) this.f36863a.findViewById(R.id.iv_volume);
        this.f36862z = (ImageView) this.f36863a.findViewById(R.id.fullscreen);
        ImageView imageView2 = (ImageView) this.f36863a.findViewById(R.id.iv_play);
        this.A = imageView2;
        imageView2.setOnClickListener(this);
        this.f36858v.setOnClickListener(this);
        this.f36859w.setOnClickListener(this);
        this.f36860x.setOnClickListener(this);
        this.f36861y.setOnClickListener(this);
        this.f36862z.setOnClickListener(this);
        this.f36865c = true;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int f() {
        BaseVideoController.d dVar = this.f36864b;
        if (dVar == null) {
            return 0;
        }
        int currentPosition = dVar.getCurrentPosition();
        int duration = this.f36864b.getDuration();
        TextView textView = this.f36858v;
        if (textView != null) {
            textView.setText(String.format("%s | \u8df3\u8fc7", Integer.valueOf((duration - currentPosition) / 1000)));
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return R.layout.layout_ad_controller;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if ((id == R.id.back) | (id == R.id.fullscreen)) {
            c();
        } else if (id == R.id.iv_volume) {
            l();
        } else if (id == R.id.ad_detail) {
            a aVar = this.f36876n;
            if (aVar != null) {
                aVar.onAdClick();
            }
        } else if (id == R.id.ad_time) {
            this.f36864b.a();
        } else if (id == R.id.iv_play) {
            b();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() == 0 && (aVar = this.f36876n) != null) {
            aVar.onAdClick();
            return false;
        }
        return false;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i4) {
        super.setPlayState(i4);
        if (i4 == 3) {
            post(this.f36878p);
            this.A.setSelected(true);
        } else if (i4 != 4) {
        } else {
            this.A.setSelected(false);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayerState(int i4) {
        super.setPlayerState(i4);
        if (i4 == 10) {
            this.f36860x.setVisibility(8);
        } else if (i4 != 11) {
        } else {
            this.f36860x.setVisibility(0);
        }
    }

    public AdController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
