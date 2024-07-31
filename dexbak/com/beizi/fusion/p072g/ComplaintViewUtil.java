package com.beizi.fusion.p072g;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.beizi.p051ad.internal.view.complaint.ComplaintDialog;

/* renamed from: com.beizi.fusion.g.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ComplaintViewUtil {

    /* renamed from: a */
    private TextView f11404a;

    /* renamed from: b */
    private InterfaceC3161a f11405b;

    /* compiled from: ComplaintViewUtil.java */
    /* renamed from: com.beizi.fusion.g.p$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3161a {
        /* renamed from: a */
        void mo46797a(String str);
    }

    /* renamed from: a */
    public void m48231a(Context context, ViewGroup viewGroup, String str) {
        try {
            m48230a(context, str);
            TextView textView = this.f11404a;
            if (textView != null) {
                viewGroup.addView(textView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m48230a(Context context, String str) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            this.f11404a = textView;
            textView.setText("投诉");
            this.f11404a.setTextColor(Color.parseColor("#FFFFFF"));
            ShapeUtil.m48318a(this.f11404a, "#99000000", 0, "", 30);
            if ("1".equals(str)) {
                this.f11404a.setTextSize(2, 13.0f);
                this.f11404a.setPadding(C3138av.m48304a(context, 12.0f), C3138av.m48304a(context, 1.0f), C3138av.m48304a(context, 12.0f), C3138av.m48304a(context, 1.0f));
                layoutParams.leftMargin = 18;
                layoutParams.topMargin = 18;
            } else if ("2".equals(str)) {
                this.f11404a.setTextSize(2, 13.0f);
                this.f11404a.setPadding(C3138av.m48304a(context, 12.0f), C3138av.m48304a(context, 1.0f), C3138av.m48304a(context, 12.0f), C3138av.m48304a(context, 1.0f));
                layoutParams.leftMargin = C3138av.m48304a(context, 16.0f);
                layoutParams.topMargin = C3138av.m48304a(context, 16.0f);
            } else if ("3".equals(str)) {
                this.f11404a.setTextSize(2, 10.0f);
                this.f11404a.setPadding(C3138av.m48304a(context, 11.0f), C3138av.m48304a(context, 1.0f), C3138av.m48304a(context, 11.0f), C3138av.m48304a(context, 1.0f));
                layoutParams.leftMargin = 16;
                layoutParams.topMargin = 16;
            }
            this.f11404a.setLayoutParams(layoutParams);
            m48232a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48232a() {
        try {
            this.f11404a.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.g.p.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        ComplaintDialog.Builder builder = new ComplaintDialog.Builder(view.getContext());
                        builder.setDialogItemCallback(new ComplaintDialog.DialogItemCallback() { // from class: com.beizi.fusion.g.p.1.1
                            @Override // com.beizi.p051ad.internal.view.complaint.ComplaintDialog.DialogItemCallback
                            public void onDialogCloseClick() {
                            }

                            @Override // com.beizi.p051ad.internal.view.complaint.ComplaintDialog.DialogItemCallback
                            public void onDialogItemClick(String str) {
                                if (ComplaintViewUtil.this.f11405b != null) {
                                    ComplaintViewUtil.this.f11405b.mo46797a(str);
                                }
                            }
                        });
                        builder.create().show();
                    } catch (Exception e) {
                        C3116af.m48494c("BeiZis", "e ：" + e);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48229a(InterfaceC3161a interfaceC3161a) {
        this.f11405b = interfaceC3161a;
    }
}
