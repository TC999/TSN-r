package com.qq.e.comm.plugin.r0.p;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.n2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends LinearLayout implements com.qq.e.comm.plugin.r0.p.b {

    /* renamed from: f  reason: collision with root package name */
    private static final String f45848f = d.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private TextView f45849c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.r0.p.a f45850d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45851e;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d1.a(d.f45848f, "onClick");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n2.a(d.this);
        }
    }

    public d(Context context) {
        super(context);
        setVisibility(8);
        setOnClickListener(new a());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f1.a(context, 20));
        gradientDrawable.setColor(Color.parseColor("#9A000000"));
        setBackgroundDrawable(gradientDrawable);
        d();
        c();
        this.f45850d = new com.qq.e.comm.plugin.r0.p.c(this);
    }

    private void c() {
        TextView textView = new TextView(getContext());
        textView.setText("\u4e0d\u7528\u4e86");
        textView.setTextSize(2, 12.0f);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#CCFFFFFF"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(1, Color.parseColor("#80FFFFFF"));
        gradientDrawable.setCornerRadius(f1.a(getContext(), 20));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setOnClickListener(new b());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f1.a(getContext(), 60), f1.a(getContext(), 25));
        layoutParams.topMargin = f1.a(getContext(), 15);
        layoutParams.rightMargin = f1.a(getContext(), 12);
        layoutParams.leftMargin = f1.a(getContext(), 12);
        addView(textView, layoutParams);
    }

    private void d() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, f1.a(getContext(), 80));
        layoutParams.leftMargin = f1.a(getContext(), 16);
        layoutParams.topMargin = f1.a(getContext(), 10);
        layoutParams.bottomMargin = f1.a(getContext(), 4);
        layoutParams.weight = 1.0f;
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(getContext());
        this.f45849c = textView;
        textView.setTextColor(-1);
        this.f45849c.setTextSize(2, 14.0f);
        this.f45849c.setMaxLines(1);
        this.f45849c.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(this.f45849c);
        TextView textView2 = new TextView(getContext());
        textView2.setTextColor(Color.parseColor("#99FFFFFF"));
        textView2.setTextSize(2, 12.0f);
        textView2.setText("\u53ef\u83b7\u53d6\u66f4\u591a\u7cbe\u5f69\u5185\u5bb9");
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(textView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        d1.a(f45848f, "onCancelClicked");
        this.f45850d.a();
    }

    @Override // com.qq.e.comm.plugin.r0.p.b
    public void destroy() {
        post(new c());
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        if (getVisibility() != 0) {
            String str = f45848f;
            d1.a(str, "onWindowVisibilityChanged: " + i4 + ", \u4f46\u5f53\u524d View \u4e0d\u53ef\u89c1");
            return;
        }
        String str2 = f45848f;
        d1.a(str2, "onWindowVisibilityChanged: " + i4);
        this.f45850d.a(i4 == 0);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        if (i4 == 0 && !this.f45851e) {
            d1.b(f45848f, "\u8bbe\u7f6e View \u53ef\u89c1\u5931\u8d25\uff0c\u53ef\u80fd\u662f\u89c6\u9891\u65f6\u957f\u592a\u77ed\uff0c\u6216\u4e0d\u662f\u5e94\u7528\u7c7b\u5e7f\u544a\uff0c\u6216\u5f53\u524d\u5e94\u7528\u6b63\u5728\u4e0b\u8f7d\u4e2d");
            return;
        }
        super.setVisibility(i4);
        String str = f45848f;
        d1.a(str, "setVisibility: " + i4);
        com.qq.e.comm.plugin.r0.p.a aVar = this.f45850d;
        if (aVar == null || i4 != 0) {
            return;
        }
        aVar.a(i4 == 0);
    }

    public void a(e eVar) {
        this.f45850d.a(eVar);
    }

    @Override // com.qq.e.comm.plugin.r0.p.b
    public void a() {
        this.f45851e = true;
    }

    @Override // com.qq.e.comm.plugin.r0.p.b
    public void a(String str) {
        this.f45849c.setText(str);
    }
}
