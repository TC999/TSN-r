package com.mbridge.msdk.widget.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.widget.custom.a.d;
import com.mbridge.msdk.widget.custom.b.c;
import com.mbridge.msdk.widget.custom.baseview.MBButton;

/* compiled from: MBridgeCustomRender.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private DownloadMessageDialog f41172a;

    /* renamed from: b  reason: collision with root package name */
    private Context f41173b;

    /* renamed from: c  reason: collision with root package name */
    private final CustomViewMessageWrap f41174c;

    /* renamed from: d  reason: collision with root package name */
    private final a f41175d;

    /* renamed from: e  reason: collision with root package name */
    private d f41176e;

    public b(DownloadMessageDialog downloadMessageDialog, Context context, CustomViewMessageWrap customViewMessageWrap, a aVar) {
        this.f41172a = downloadMessageDialog;
        this.f41173b = context;
        this.f41174c = customViewMessageWrap;
        this.f41175d = aVar;
    }

    public final View a(int i4, int i5) throws Exception {
        View a4 = c.a(this.f41173b).a(this.f41174c.getLayoutFilePath());
        d dVar = new d(this.f41174c, this.f41175d, this.f41172a, i4, i5);
        this.f41176e = dVar;
        dVar.a((ViewGroup) a4);
        return a4;
    }

    public final MBButton a() {
        d dVar = this.f41176e;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }
}
