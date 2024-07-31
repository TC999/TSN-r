package com.mbridge.msdk.widget.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.widget.custom.baseview.MBButton;
import com.mbridge.msdk.widget.custom.p516a.RenderEngine;
import com.mbridge.msdk.widget.custom.p517b.InflaterUtil;

/* renamed from: com.mbridge.msdk.widget.custom.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MBridgeCustomRender {

    /* renamed from: a */
    private DownloadMessageDialog f32483a;

    /* renamed from: b */
    private Context f32484b;

    /* renamed from: c */
    private final CustomViewMessageWrap f32485c;

    /* renamed from: d */
    private final CustomViewRenderListener f32486d;

    /* renamed from: e */
    private RenderEngine f32487e;

    public MBridgeCustomRender(DownloadMessageDialog downloadMessageDialog, Context context, CustomViewMessageWrap customViewMessageWrap, CustomViewRenderListener customViewRenderListener) {
        this.f32483a = downloadMessageDialog;
        this.f32484b = context;
        this.f32485c = customViewMessageWrap;
        this.f32486d = customViewRenderListener;
    }

    /* renamed from: a */
    public final View m20581a(int i, int i2) throws Exception {
        View m20567a = InflaterUtil.m20568a(this.f32484b).m20567a(this.f32485c.getLayoutFilePath());
        RenderEngine renderEngine = new RenderEngine(this.f32485c, this.f32486d, this.f32483a, i, i2);
        this.f32487e = renderEngine;
        renderEngine.m20588a((ViewGroup) m20567a);
        return m20567a;
    }

    /* renamed from: a */
    public final MBButton m20582a() {
        RenderEngine renderEngine = this.f32487e;
        if (renderEngine != null) {
            return renderEngine.m20589a();
        }
        return null;
    }
}
