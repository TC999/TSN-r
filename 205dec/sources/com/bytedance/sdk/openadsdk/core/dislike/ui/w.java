package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.widget.TTDislikeCommentLayout;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends Dialog {

    /* renamed from: c  reason: collision with root package name */
    private TTDislikeCommentLayout f33156c;
    private com.bytedance.sdk.openadsdk.core.dislike.w.w sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.w.c f33157w;
    private com.bytedance.sdk.openadsdk.core.dislike.xv.w xv;

    public w(Context context, com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.xv = wVar;
    }

    private void sr() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        xv();
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.w.w wVar = this.sr;
        if (wVar != null) {
            wVar.w();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.sr.xv(getContext()));
        TTDislikeCommentLayout tTDislikeCommentLayout = (TTDislikeCommentLayout) findViewById(2047279092);
        this.f33156c = tTDislikeCommentLayout;
        c(tTDislikeCommentLayout);
        sr();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        w();
        com.bytedance.sdk.openadsdk.core.dislike.w.w wVar = this.sr;
        if (wVar != null) {
            wVar.c();
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    private void c(View view) {
        final EditText editText = (EditText) view.findViewById(2047279087);
        c(editText);
        final TextView textView = (TextView) view.findViewById(2047279088);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String obj = editText.getText().toString();
                if (obj.length() <= 0 || obj.isEmpty()) {
                    return;
                }
                if (w.this.f33157w == null || !w.this.f33157w.c(obj, w.this)) {
                    com.bytedance.sdk.openadsdk.core.dislike.xv.xv xvVar = new com.bytedance.sdk.openadsdk.core.dislike.xv.xv("0:00", obj);
                    com.bytedance.sdk.openadsdk.core.dislike.c.c.c().c(w.this.xv, xvVar);
                    w.this.sr.c(0, xvVar);
                    w.this.dismiss();
                }
            }
        });
        ((ImageView) view.findViewById(2047279090)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.w.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                w.this.dismiss();
            }
        });
        final TextView textView2 = (TextView) findViewById(2047279086);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.w.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                int round = Math.round(charSequence.length());
                textView2.setText(round + "");
                if (round > 0) {
                    textView.setTextColor(-16777216);
                    textView.setClickable(true);
                    return;
                }
                textView.setTextColor(-7829368);
                textView.setClickable(false);
            }
        });
    }

    public void w() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.f33156c;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f33156c.getWindowToken(), 0);
        }
        editText.clearFocus();
    }

    public void xv() {
        EditText editText;
        InputMethodManager inputMethodManager;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.f33156c;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null || (inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.f33156c.getWindowToken(), 0);
    }

    public static void c(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.w.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i4, int i5, Spanned spanned, int i6, int i7) {
                while (i4 < i5) {
                    int type = Character.getType(charSequence.charAt(i4));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i4++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }

    public void c(com.bytedance.sdk.openadsdk.core.dislike.w.c cVar) {
        this.f33157w = cVar;
    }

    public void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        if (wVar == null) {
            return;
        }
        this.xv = wVar;
    }

    public void c() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.f33156c;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null) {
            return;
        }
        editText.setText((CharSequence) null);
    }

    public void c(com.bytedance.sdk.openadsdk.core.dislike.w.w wVar) {
        this.sr = wVar;
    }
}
