package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia extends AlertDialog {

    /* renamed from: c  reason: collision with root package name */
    private Context f35430c;
    private c sr;

    /* renamed from: w  reason: collision with root package name */
    private String f35431w;
    private boolean xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(String str);

        void w(String str);
    }

    public ia(Context context, String str) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.f35430c = context;
        this.f35431w = str;
        this.xv = TextUtils.isEmpty(str);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        c cVar = this.sr;
        if (cVar == null) {
            return;
        }
        cVar.w(this.f35431w);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        if (this.f35430c == null) {
            this.f35430c = ls.getContext();
        }
        c();
    }

    private void c() {
        setContentView(w());
    }

    private View w() {
        LinearLayout linearLayout = new LinearLayout(this.f35430c);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-16777216);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.f35430c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("\u60a8\u8981\u8bbf\u95ee\u7684\u7f51\u7ad9\u5b58\u5728\u98ce\u9669");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int ux = xk.ux(this.f35430c, 10.0f) * 2;
        TextView textView2 = new TextView(this.f35430c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = ux;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("\u7ee7\u7eed\u8bbf\u95ee\u53ef\u80fd\u5bfc\u81f4\u4e2a\u4eba\u9690\u79c1\u6cc4\u6f0f\u3001\u8d26\u53f7\u88ab\u76d7\u7528\u7b49\u5371\u5bb3");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int ux2 = xk.ux(this.f35430c, 25.0f);
        int ux3 = xk.ux(this.f35430c, 8.0f);
        if (!this.xv) {
            Button button = new Button(this.f35430c);
            button.setBackgroundColor(-7829368);
            button.setText("\u7ee7\u7eed\u8bbf\u95ee");
            button.setTextColor(-1);
            button.setPadding(ux2, ux3, ux2, ux3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(xk.ux(this.f35430c, 230.0f), -2);
            layoutParams4.topMargin = ux;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ia.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ia.this.dismiss();
                    if (ia.this.sr == null) {
                        return;
                    }
                    ia.this.sr.c(ia.this.f35431w);
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.f35430c);
        button2.setBackgroundColor(-65536);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(xk.ux(this.f35430c, 230.0f), -2);
        layoutParams5.topMargin = ux;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("\u8fd4\u56de\u5b89\u5168\u94fe\u63a5");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(ux2, ux3, ux2, ux3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ia.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ia.this.dismiss();
                if (ia.this.sr == null) {
                    return;
                }
                ia.this.sr.w(ia.this.f35431w);
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public void c(c cVar) {
        this.sr = cVar;
    }
}
