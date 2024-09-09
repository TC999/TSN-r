package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.widget.FlowLayout;
import com.bytedance.sdk.openadsdk.ys.w.w.f;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends BaseAdapter {

    /* renamed from: c  reason: collision with root package name */
    private final List<f> f33150c;

    /* renamed from: w  reason: collision with root package name */
    private final Context f33151w;
    private c xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(int i4, f fVar);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class w {

        /* renamed from: c  reason: collision with root package name */
        TextView f33154c;

        /* renamed from: w  reason: collision with root package name */
        FlowLayout f33155w;

        private w() {
        }
    }

    public sr(Context context, List<f> list) {
        this.f33150c = list == null ? new ArrayList(0) : new ArrayList(list);
        this.f33151w = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : context;
    }

    private TextView w() {
        TextView textView = new TextView(this.f33151w);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.bytedance.sdk.openadsdk.core.dislike.c.sr w3 = com.bytedance.sdk.openadsdk.core.dislike.c.c.w();
        marginLayoutParams.setMargins(0, 0, w3.c(this.f33151w, 8.0f), w3.c(this.f33151w, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int c4 = w3.c(this.f33151w, 21.0f);
        int c5 = w3.c(this.f33151w, 6.0f);
        textView.setPadding(c4, c5, c4, c5);
        Drawable c6 = c(Color.parseColor("#0A161823"));
        ((GradientDrawable) c6).setCornerRadius(w3.c(this.f33151w, 4.0f));
        textView.setBackground(c6);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<f> list = this.f33150c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return this.f33150c.get(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(final int i4, View view, ViewGroup viewGroup) {
        View view2;
        w wVar;
        if (view == null) {
            wVar = new w();
            view2 = com.bytedance.sdk.openadsdk.res.sr.w(this.f33151w);
            wVar.f33154c = (TextView) view2.findViewById(2047279094);
            wVar.f33155w = (FlowLayout) view2.findViewById(2047279093);
            view2.setTag(wVar);
        } else {
            view2 = view;
            wVar = (w) view.getTag();
        }
        f fVar = this.f33150c.get(i4);
        wVar.f33154c.setText(fVar.w());
        if (fVar.f()) {
            wVar.f33155w.removeAllViews();
            List<f> sr = fVar.sr();
            for (int i5 = 0; i5 < sr.size(); i5++) {
                final f fVar2 = sr.get(i5);
                TextView w3 = w();
                w3.setText(fVar2.w());
                w3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.sr.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (sr.this.xv != null) {
                            sr.this.xv.c(i4, fVar2);
                        }
                    }
                });
                wVar.f33155w.addView(w3);
            }
            wVar.f33155w.setVisibility(0);
        } else {
            wVar.f33154c.setBackground(c());
            wVar.f33155w.setVisibility(8);
        }
        return view2;
    }

    private StateListDrawable c() {
        Drawable c4 = c(Color.parseColor("#FDE6E6E6"));
        Drawable c5 = c(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, c4);
        stateListDrawable.addState(new int[0], c5);
        return stateListDrawable;
    }

    private Drawable c(int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i4);
        return gradientDrawable;
    }

    public void c(c cVar) {
        this.xv = cVar;
    }

    public void c(List<f> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f33150c.clear();
        this.f33150c.addAll(list);
        notifyDataSetChanged();
    }
}
