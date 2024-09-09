package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class FloatController extends BaseVideoController implements View.OnClickListener {

    /* renamed from: v  reason: collision with root package name */
    private ProgressBar f36892v;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f36893w;

    public FloatController(@NonNull Context context) {
        super(context);
    }

    private void l(int i4) {
        if (this.f36877o == 6) {
            return;
        }
        if (!this.f36865c) {
            this.f36893w.setVisibility(0);
        }
        this.f36865c = true;
        removeCallbacks(this.f36879q);
        if (i4 != 0) {
            postDelayed(this.f36879q, i4);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void d() {
        if (this.f36877o != 6 && this.f36865c) {
            this.f36893w.setVisibility(8);
            this.f36865c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void e() {
        super.e();
        setOnClickListener(this);
        this.f36863a.findViewById(R.id.btn_close).setOnClickListener(this);
        this.f36892v = (ProgressBar) this.f36863a.findViewById(R.id.loading);
        ImageView imageView = (ImageView) this.f36863a.findViewById(R.id.start_play);
        this.f36893w = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void g() {
        l(this.f36869g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return R.layout.layout_float_controller;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_close) {
            this.f36864b.g();
        } else if (id == R.id.start_play) {
            b();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i4) {
        super.setPlayState(i4);
        switch (i4) {
            case 0:
                this.f36893w.setSelected(false);
                this.f36893w.setVisibility(0);
                this.f36892v.setVisibility(8);
                return;
            case 1:
                this.f36893w.setVisibility(8);
                this.f36892v.setVisibility(0);
                return;
            case 2:
                this.f36893w.setVisibility(8);
                this.f36892v.setVisibility(8);
                return;
            case 3:
                this.f36893w.setSelected(true);
                this.f36893w.setVisibility(8);
                this.f36892v.setVisibility(8);
                d();
                return;
            case 4:
                this.f36893w.setSelected(false);
                this.f36893w.setVisibility(0);
                this.f36892v.setVisibility(8);
                l(0);
                return;
            case 5:
                l(0);
                return;
            case 6:
                this.f36893w.setVisibility(8);
                this.f36892v.setVisibility(0);
                return;
            case 7:
                this.f36893w.setVisibility(8);
                this.f36892v.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public FloatController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
