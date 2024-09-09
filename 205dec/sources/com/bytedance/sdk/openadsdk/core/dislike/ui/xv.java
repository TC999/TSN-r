package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.dislike.ui.sr;
import com.bytedance.sdk.openadsdk.widget.TTDislikeLayout;
import com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView;
import com.bytedance.sdk.openadsdk.ys.w.w.f;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends Dialog {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.w.xv f33163c;
    private boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private TTDislikeLayout f33164w;
    private final com.bytedance.sdk.openadsdk.core.dislike.xv.w xv;

    public xv(Context context, com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        super(context);
        this.sr = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.xv = wVar;
    }

    private void xv() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.f33164w = tTDislikeLayout;
        c(tTDislikeLayout);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.w.xv xvVar = this.f33163c;
        if (xvVar == null || this.sr) {
            return;
        }
        xvVar.xv();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        setContentView(com.bytedance.sdk.openadsdk.res.sr.c(getContext()), c());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        w();
        xv();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.sr = false;
            com.bytedance.sdk.openadsdk.core.dislike.w.xv xvVar = this.f33163c;
            if (xvVar != null) {
                xvVar.w();
            }
        } catch (Exception unused) {
        }
    }

    private void w() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.dislike.w.xv xvVar) {
        this.f33163c = xvVar;
    }

    public ViewGroup.LayoutParams c() {
        return new ViewGroup.LayoutParams(com.bytedance.sdk.openadsdk.core.dislike.c.c.w().c(getContext(), 345.0f), -2);
    }

    public void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        TTDislikeLayout tTDislikeLayout;
        if (wVar == null || (tTDislikeLayout = this.f33164w) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        sr srVar = (sr) tTDislikeScrollListView.getAdapter();
        if (srVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.c.w(wVar));
            srVar.c(wVar.c());
        }
    }

    private void c(View view) {
        if (view == null) {
            return;
        }
        ((TextView) view.findViewById(2047279095)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xv.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (xv.this.f33163c != null) {
                    xv.this.f33163c.c();
                }
                xv.this.dismiss();
            }
        });
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xv.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i4, long j4) {
                try {
                    if (xv.this.f33163c != null) {
                        xv.this.f33163c.c(i4, xv.this.xv.c().get(i4));
                        xv.this.sr = true;
                    }
                    xv.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar = this.xv;
        sr srVar = new sr(getContext(), wVar == null ? new ArrayList<>(0) : wVar.c());
        srVar.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xv.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.sr.c
            public void c(int i4, f fVar) {
                if (xv.this.f33163c != null) {
                    xv.this.f33163c.c(i4, fVar);
                    xv.this.sr = true;
                }
                xv.this.dismiss();
                com.bytedance.sdk.openadsdk.core.dislike.c.c.c().c(xv.this.xv, fVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) srVar);
        com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar2 = this.xv;
        if (wVar2 != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.c.w(wVar2));
        }
    }
}
