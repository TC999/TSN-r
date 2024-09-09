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
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.player.BackgroundPlayService;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class StatusView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f36996a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f36997b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f36998c;

    /* renamed from: d  reason: collision with root package name */
    private float f36999d;

    /* renamed from: e  reason: collision with root package name */
    private float f37000e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StubApp.getOrigApplicationContext(StatusView.this.getContext().getApplicationContext()).stopService(new Intent(StatusView.this.getContext(), BackgroundPlayService.class));
        }
    }

    public StatusView(Context context) {
        this(context, null);
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_status_view, this);
        this.f36996a = (TextView) inflate.findViewById(R.id.message);
        this.f36997b = (TextView) inflate.findViewById(R.id.status_btn);
        this.f36998c = (ImageView) inflate.findViewById(R.id.btn_close);
        setBackgroundResource(17170444);
        setClickable(true);
        if (c1.a.c) {
            this.f36998c.setVisibility(0);
            this.f36998c.setOnClickListener(new a());
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        TextView textView = this.f36997b;
        if (textView != null) {
            textView.setText(str);
            this.f36997b.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f36999d = motionEvent.getX();
            this.f37000e = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f36999d);
            float abs2 = Math.abs(motionEvent.getY() - this.f37000e);
            if (abs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || abs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setMessage(String str) {
        TextView textView = this.f36996a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public StatusView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
