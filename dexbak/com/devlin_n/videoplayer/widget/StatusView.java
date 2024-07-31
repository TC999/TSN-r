package com.devlin_n.videoplayer.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.C6596R;
import com.devlin_n.videoplayer.player.BackgroundPlayService;
import com.stub.StubApp;
import p601i0.C13583a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StatusView extends LinearLayout {

    /* renamed from: a */
    private TextView f23400a;

    /* renamed from: b */
    private TextView f23401b;

    /* renamed from: c */
    private ImageView f23402c;

    /* renamed from: d */
    private float f23403d;

    /* renamed from: e */
    private float f23404e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.devlin_n.videoplayer.widget.StatusView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC6630a implements View.OnClickListener {
        View$OnClickListenerC6630a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StubApp.getOrigApplicationContext(StatusView.this.getContext().getApplicationContext()).stopService(new Intent(StatusView.this.getContext(), BackgroundPlayService.class));
        }
    }

    public StatusView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m35666a() {
        View inflate = LayoutInflater.from(getContext()).inflate(C6596R.C6600layout.layout_status_view, this);
        this.f23400a = (TextView) inflate.findViewById(C6596R.C6599id.message);
        this.f23401b = (TextView) inflate.findViewById(C6596R.C6599id.status_btn);
        this.f23402c = (ImageView) inflate.findViewById(C6596R.C6599id.btn_close);
        setBackgroundResource(17170444);
        setClickable(true);
        if (C13583a.f40164c) {
            this.f23402c.setVisibility(0);
            this.f23402c.setOnClickListener(new View$OnClickListenerC6630a());
        }
    }

    /* renamed from: b */
    public void m35665b(String str, View.OnClickListener onClickListener) {
        TextView textView = this.f23401b;
        if (textView != null) {
            textView.setText(str);
            this.f23401b.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f23403d = motionEvent.getX();
            this.f23404e = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f23403d);
            float abs2 = Math.abs(motionEvent.getY() - this.f23404e);
            if (abs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || abs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setMessage(String str) {
        TextView textView = this.f23400a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public StatusView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m35666a();
    }
}
