package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.C6596R;
import com.devlin_n.videoplayer.controller.BaseVideoController;
import p597h0.ControllerListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdController extends BaseVideoController implements View.OnClickListener {

    /* renamed from: A */
    protected ImageView f23191A;

    /* renamed from: v */
    protected TextView f23192v;

    /* renamed from: w */
    protected TextView f23193w;

    /* renamed from: x */
    protected ImageView f23194x;

    /* renamed from: y */
    protected ImageView f23195y;

    /* renamed from: z */
    protected ImageView f23196z;

    public AdController(@NonNull Context context) {
        super(context);
    }

    /* renamed from: l */
    private void m35781l() {
        this.f23198b.mo35706i();
        if (this.f23198b.mo35710g()) {
            this.f23195y.setImageResource(C6596R.C6598drawable.ic_action_volume_up);
        } else {
            this.f23195y.setImageResource(C6596R.C6598drawable.ic_action_volume_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: e */
    public void mo35760e() {
        super.mo35760e();
        this.f23192v = (TextView) this.f23197a.findViewById(C6596R.C6599id.ad_time);
        TextView textView = (TextView) this.f23197a.findViewById(C6596R.C6599id.ad_detail);
        this.f23193w = textView;
        textView.setText("了解详情>");
        ImageView imageView = (ImageView) this.f23197a.findViewById(C6596R.C6599id.back);
        this.f23194x = imageView;
        imageView.setVisibility(8);
        this.f23195y = (ImageView) this.f23197a.findViewById(C6596R.C6599id.iv_volume);
        this.f23196z = (ImageView) this.f23197a.findViewById(C6596R.C6599id.fullscreen);
        ImageView imageView2 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.iv_play);
        this.f23191A = imageView2;
        imageView2.setOnClickListener(this);
        this.f23192v.setOnClickListener(this);
        this.f23193w.setOnClickListener(this);
        this.f23194x.setOnClickListener(this);
        this.f23195y.setOnClickListener(this);
        this.f23196z.setOnClickListener(this);
        this.f23199c = true;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: f */
    protected int mo35759f() {
        BaseVideoController.InterfaceC6607d interfaceC6607d = this.f23198b;
        if (interfaceC6607d == null) {
            return 0;
        }
        int currentPosition = interfaceC6607d.getCurrentPosition();
        int duration = this.f23198b.getDuration();
        TextView textView = this.f23192v;
        if (textView != null) {
            textView.setText(String.format("%s | 跳过", Integer.valueOf((duration - currentPosition) / 1000)));
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return C6596R.C6600layout.layout_ad_controller;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if ((id == C6596R.C6599id.back) | (id == C6596R.C6599id.fullscreen)) {
            m35778c();
        } else if (id == C6596R.C6599id.iv_volume) {
            m35781l();
        } else if (id == C6596R.C6599id.ad_detail) {
            ControllerListener controllerListener = this.f23210n;
            if (controllerListener != null) {
                controllerListener.onAdClick();
            }
        } else if (id == C6596R.C6599id.ad_time) {
            this.f23198b.mo35722a();
        } else if (id == C6596R.C6599id.iv_play) {
            m35779b();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ControllerListener controllerListener;
        if (motionEvent.getAction() == 0 && (controllerListener = this.f23210n) != null) {
            controllerListener.onAdClick();
            return false;
        }
        return false;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i) {
        super.setPlayState(i);
        if (i == 3) {
            post(this.f23212p);
            this.f23191A.setSelected(true);
        } else if (i != 4) {
        } else {
            this.f23191A.setSelected(false);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayerState(int i) {
        super.setPlayerState(i);
        if (i == 10) {
            this.f23194x.setVisibility(8);
        } else if (i != 11) {
        } else {
            this.f23194x.setVisibility(0);
        }
    }

    public AdController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
