package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.C6596R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FloatController extends BaseVideoController implements View.OnClickListener {

    /* renamed from: v */
    private ProgressBar f23226v;

    /* renamed from: w */
    private ImageView f23227w;

    public FloatController(@NonNull Context context) {
        super(context);
    }

    /* renamed from: l */
    private void m35774l(int i) {
        if (this.f23211o == 6) {
            return;
        }
        if (!this.f23199c) {
            this.f23227w.setVisibility(0);
        }
        this.f23199c = true;
        removeCallbacks(this.f23213q);
        if (i != 0) {
            postDelayed(this.f23213q, i);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: d */
    public void mo35761d() {
        if (this.f23211o != 6 && this.f23199c) {
            this.f23227w.setVisibility(8);
            this.f23199c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: e */
    public void mo35760e() {
        super.mo35760e();
        setOnClickListener(this);
        this.f23197a.findViewById(C6596R.C6599id.btn_close).setOnClickListener(this);
        this.f23226v = (ProgressBar) this.f23197a.findViewById(C6596R.C6599id.loading);
        ImageView imageView = (ImageView) this.f23197a.findViewById(C6596R.C6599id.start_play);
        this.f23227w = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: g */
    public void mo35758g() {
        m35774l(this.f23203g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return C6596R.C6600layout.layout_float_controller;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C6596R.C6599id.btn_close) {
            this.f23198b.mo35708h();
        } else if (id == C6596R.C6599id.start_play) {
            m35779b();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i) {
        super.setPlayState(i);
        switch (i) {
            case 0:
                this.f23227w.setSelected(false);
                this.f23227w.setVisibility(0);
                this.f23226v.setVisibility(8);
                return;
            case 1:
                this.f23227w.setVisibility(8);
                this.f23226v.setVisibility(0);
                return;
            case 2:
                this.f23227w.setVisibility(8);
                this.f23226v.setVisibility(8);
                return;
            case 3:
                this.f23227w.setSelected(true);
                this.f23227w.setVisibility(8);
                this.f23226v.setVisibility(8);
                mo35761d();
                return;
            case 4:
                this.f23227w.setSelected(false);
                this.f23227w.setVisibility(0);
                this.f23226v.setVisibility(8);
                m35774l(0);
                return;
            case 5:
                m35774l(0);
                return;
            case 6:
                this.f23227w.setVisibility(8);
                this.f23226v.setVisibility(0);
                return;
            case 7:
                this.f23227w.setVisibility(8);
                this.f23226v.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public FloatController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
