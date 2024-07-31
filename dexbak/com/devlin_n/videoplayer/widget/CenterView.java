package com.devlin_n.videoplayer.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.devlin_n.videoplayer.C6596R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CenterView extends LinearLayout {

    /* renamed from: a */
    private ImageView f23385a;

    /* renamed from: b */
    private TextView f23386b;

    /* renamed from: c */
    private ProgressBar f23387c;

    public CenterView(Context context) {
        super(context);
        m35670a();
    }

    /* renamed from: a */
    private void m35670a() {
        setGravity(17);
        View inflate = LayoutInflater.from(getContext()).inflate(C6596R.C6600layout.layout_center_window, this);
        this.f23385a = (ImageView) inflate.findViewById(C6596R.C6599id.iv_icon);
        this.f23386b = (TextView) inflate.findViewById(C6596R.C6599id.tv_percent);
        this.f23387c = (ProgressBar) inflate.findViewById(C6596R.C6599id.pro_percent);
    }

    public void setIcon(int i) {
        ImageView imageView = this.f23385a;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setProPercent(int i) {
        ProgressBar progressBar = this.f23387c;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
    }

    public void setProVisibility(int i) {
        ProgressBar progressBar = this.f23387c;
        if (progressBar != null) {
            progressBar.setVisibility(i);
        }
    }

    public void setTextView(String str) {
        TextView textView = this.f23386b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), C6596R.anim.anim_alpha_out));
        }
    }
}
