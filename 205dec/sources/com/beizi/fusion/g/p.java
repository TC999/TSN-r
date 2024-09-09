package com.beizi.fusion.g;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.beizi.ad.internal.view.complaint.ComplaintDialog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ComplaintViewUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private TextView f14959a;

    /* renamed from: b  reason: collision with root package name */
    private a f14960b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ComplaintViewUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(String str);
    }

    public void a(Context context, ViewGroup viewGroup, String str) {
        try {
            a(context, str);
            TextView textView = this.f14959a;
            if (textView != null) {
                viewGroup.addView(textView);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(Context context, String str) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            this.f14959a = textView;
            textView.setText("\u6295\u8bc9");
            this.f14959a.setTextColor(Color.parseColor("#FFFFFF"));
            at.a(this.f14959a, "#99000000", 0, "", 30);
            if ("1".equals(str)) {
                this.f14959a.setTextSize(2, 13.0f);
                this.f14959a.setPadding(aw.a(context, 12.0f), aw.a(context, 1.0f), aw.a(context, 12.0f), aw.a(context, 1.0f));
                layoutParams.leftMargin = 18;
                layoutParams.topMargin = 18;
            } else if ("2".equals(str)) {
                this.f14959a.setTextSize(2, 13.0f);
                this.f14959a.setPadding(aw.a(context, 12.0f), aw.a(context, 1.0f), aw.a(context, 12.0f), aw.a(context, 1.0f));
                layoutParams.leftMargin = aw.a(context, 16.0f);
                layoutParams.topMargin = aw.a(context, 16.0f);
            } else if ("3".equals(str)) {
                this.f14959a.setTextSize(2, 10.0f);
                this.f14959a.setPadding(aw.a(context, 11.0f), aw.a(context, 1.0f), aw.a(context, 11.0f), aw.a(context, 1.0f));
                layoutParams.leftMargin = 16;
                layoutParams.topMargin = 16;
            }
            this.f14959a.setLayoutParams(layoutParams);
            a();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a() {
        try {
            this.f14959a.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.g.p.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        Context context = p.this.f14959a.getContext();
                        View rootView = p.this.f14959a.getRootView();
                        if (rootView != null) {
                            context = rootView.getContext();
                        }
                        ComplaintDialog.Builder builder = new ComplaintDialog.Builder(context);
                        builder.setDialogItemCallback(new ComplaintDialog.DialogItemCallback() { // from class: com.beizi.fusion.g.p.1.1
                            @Override // com.beizi.ad.internal.view.complaint.ComplaintDialog.DialogItemCallback
                            public void onDialogCloseClick() {
                            }

                            @Override // com.beizi.ad.internal.view.complaint.ComplaintDialog.DialogItemCallback
                            public void onDialogItemClick(String str) {
                                if (p.this.f14960b != null) {
                                    p.this.f14960b.a(str);
                                }
                            }
                        });
                        builder.create().show();
                    } catch (Exception e4) {
                        af.c("BeiZis", "e \uff1a" + e4);
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.f14960b = aVar;
    }
}
