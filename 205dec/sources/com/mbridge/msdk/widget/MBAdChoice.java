package com.mbridge.msdk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.ab;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBAdChoice extends MBImageView {

    /* renamed from: a  reason: collision with root package name */
    private static String f41070a = "MBAdChoice";

    /* renamed from: b  reason: collision with root package name */
    private String f41071b;

    /* renamed from: c  reason: collision with root package name */
    private String f41072c;

    /* renamed from: d  reason: collision with root package name */
    private String f41073d;

    /* renamed from: e  reason: collision with root package name */
    private Context f41074e;

    public MBAdChoice(Context context) {
        super(context);
        this.f41071b = "";
        this.f41072c = "";
        this.f41073d = "";
        this.f41074e = context;
        b();
    }

    private void b() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (TextUtils.isEmpty(this.f41073d)) {
            return true;
        }
        ab.b(this.f41074e, this.f41073d, null);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (android.text.TextUtils.isEmpty(r4.ay()) == false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCampaign(com.mbridge.msdk.out.Campaign r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.mbridge.msdk.foundation.entity.CampaignEx
            if (r0 == 0) goto L93
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L40
            com.mbridge.msdk.foundation.entity.CampaignEx$a r2 = r4.getAdchoice()
            if (r2 == 0) goto L40
            com.mbridge.msdk.foundation.entity.CampaignEx$a r2 = r4.getAdchoice()
            java.lang.String r2 = r2.e()
            r3.f41071b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L40
            com.mbridge.msdk.foundation.entity.CampaignEx$a r2 = r4.getAdchoice()
            java.lang.String r2 = r2.d()
            r3.f41073d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L40
            com.mbridge.msdk.foundation.entity.CampaignEx$a r4 = r4.getAdchoice()
            java.lang.String r4 = r4.f()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L40
            r4 = 1
            goto L41
        L40:
            r4 = 0
        L41:
            if (r4 != 0) goto L7a
            com.mbridge.msdk.c.b r4 = com.mbridge.msdk.c.b.a()
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.f()
            java.lang.String r2 = r2.k()
            com.mbridge.msdk.c.a r4 = r4.b(r2)
            if (r4 == 0) goto L78
            java.lang.String r2 = r4.ax()
            r3.f41071b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L78
            java.lang.String r2 = r4.az()
            r3.f41073d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L78
            java.lang.String r4 = r4.ay()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L78
            goto L79
        L78:
            r0 = 0
        L79:
            r4 = r0
        L7a:
            java.lang.String r0 = r3.f41071b
            r3.setImageUrl(r0)
            if (r4 == 0) goto L93
            android.content.Context r4 = r3.f41074e
            if (r4 == 0) goto L93
            com.mbridge.msdk.foundation.same.c.b r4 = com.mbridge.msdk.foundation.same.c.b.a(r4)
            java.lang.String r0 = r3.f41071b
            com.mbridge.msdk.widget.MBAdChoice$1 r1 = new com.mbridge.msdk.widget.MBAdChoice$1
            r1.<init>()
            r4.a(r0, r1)
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.widget.MBAdChoice.setCampaign(com.mbridge.msdk.out.Campaign):void");
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41071b = "";
        this.f41072c = "";
        this.f41073d = "";
        this.f41074e = context;
        b();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f41071b = "";
        this.f41072c = "";
        this.f41073d = "";
        this.f41074e = context;
        b();
    }
}
