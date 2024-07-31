package com.mbridge.msdk.mbjscommon.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ActionBar extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private WebView f31426a;

    /* renamed from: com.mbridge.msdk.mbjscommon.base.ActionBar$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11483a {
        /* renamed from: a */
        View m21530a();

        /* renamed from: a */
        void m21529a(View view, WebView webView);
    }

    public ActionBar(Context context) {
        super(context);
    }

    public void addAction(InterfaceC11483a interfaceC11483a) {
        addAction(interfaceC11483a, getChildCount());
    }

    public int getActionCount() {
        return getChildCount();
    }

    public WebView getWebView() {
        return this.f31426a;
    }

    public View newActionItem() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(frameLayout);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof InterfaceC11483a) {
            ((InterfaceC11483a) tag).m21529a(view, this.f31426a);
        }
    }

    public boolean removeAction(InterfaceC11483a interfaceC11483a) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                Object tag = childAt.getTag();
                if ((tag instanceof InterfaceC11483a) && tag.equals(interfaceC11483a)) {
                    removeView(childAt);
                    return true;
                }
            }
        }
        return false;
    }

    public void removeActionAt(int i) {
        if (i < 0 || i >= getChildCount()) {
            return;
        }
        removeViewAt(i);
    }

    public void removeAllActions() {
        removeAllViews();
    }

    public void setWebView(WebView webView) {
        this.f31426a = webView;
    }

    public ActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addAction(InterfaceC11483a interfaceC11483a, int i) {
        View view;
        View m21530a = interfaceC11483a.m21530a();
        if (m21530a != null) {
            view = newActionItem();
            ((ViewGroup) ((ViewGroup) view).getChildAt(0)).addView(m21530a);
            m21530a.setTag(interfaceC11483a);
            m21530a.setOnClickListener(this);
        } else {
            view = null;
        }
        addView(view, i);
    }
}
