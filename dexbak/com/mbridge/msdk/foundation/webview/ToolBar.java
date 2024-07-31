package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameTool;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ToolBar extends LinearLayout {
    public ToolBar(Context context) {
        super(context);
        m21709a();
    }

    /* renamed from: a */
    private void m21709a() {
        setOrientation(0);
        try {
            int m22001b = SameTool.m22001b(getContext(), 10.0f);
            setPadding(0, m22001b, 0, m22001b);
        } catch (Exception unused) {
        }
        try {
            ImageView imageView = (ImageView) m21708b();
            imageView.setTag("backward");
            imageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_cm_backward", "drawable", MBSDKContext.m22865f().m22869d())));
            addView(imageView);
        } catch (Exception unused2) {
        }
        try {
            ImageView imageView2 = (ImageView) m21708b();
            imageView2.setTag("forward");
            imageView2.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_cm_forward", "drawable", MBSDKContext.m22865f().m22869d())));
            addView(imageView2);
        } catch (Exception unused3) {
        }
        try {
            ImageView imageView3 = (ImageView) m21708b();
            imageView3.setTag("refresh");
            imageView3.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_cm_refresh", "drawable", MBSDKContext.m22865f().m22869d())));
            addView(imageView3);
        } catch (Exception unused4) {
        }
        try {
            ImageView imageView4 = (ImageView) m21708b();
            imageView4.setTag("exits");
            imageView4.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_cm_exits", "drawable", MBSDKContext.m22865f().m22869d())));
            addView(imageView4);
        } catch (Exception unused5) {
        }
    }

    /* renamed from: b */
    private View m21708b() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(true);
        return imageView;
    }

    public View getItem(String str) {
        return findViewWithTag(str);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setOnClickListener(onClickListener);
        }
    }

    public ToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21709a();
    }
}
