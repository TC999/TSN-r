package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.sr.w;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.sr;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.ux;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.xv;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.EnumSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends xv {
    public c(Context context, ViewGroup viewGroup, me meVar, String str, boolean z3, boolean z4, boolean z5) {
        super(context, viewGroup, meVar, str, z3, z4, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xv
    protected ux c(Context context, EnumSet<w.c> enumSet) {
        View layoutVideoDetail;
        if (this.f35108a) {
            layoutVideoDetail = c(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.f35108a) {
            return new ux(context, view, true, enumSet, this.f35110f, this, bw(), null);
        }
        return new sr(context, view, true, enumSet, this.f35110f, this, false);
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387713);
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387904);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387630);
        layoutParams2.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams2);
        tTProgressBar.setIndeterminateDrawable(i.xv(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        return relativeLayout;
    }
}
