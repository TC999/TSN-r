package com.mbridge.msdk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.SameSDKTool;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBAdChoice extends MBImageView {

    /* renamed from: a */
    private static String f32359a = "MBAdChoice";

    /* renamed from: b */
    private String f32360b;

    /* renamed from: c */
    private String f32361c;

    /* renamed from: d */
    private String f32362d;

    /* renamed from: e */
    private Context f32363e;

    public MBAdChoice(Context context) {
        super(context);
        this.f32360b = "";
        this.f32361c = "";
        this.f32362d = "";
        this.f32363e = context;
        m20636b();
    }

    /* renamed from: b */
    private void m20636b() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (TextUtils.isEmpty(this.f32362d)) {
            return true;
        }
        SameSDKTool.m22029b(this.f32363e, this.f32362d, null);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (android.text.TextUtils.isEmpty(r4.m23347ay()) == false) goto L23;
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
            java.lang.String r2 = r2.m22643e()
            r3.f32360b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L40
            com.mbridge.msdk.foundation.entity.CampaignEx$a r2 = r4.getAdchoice()
            java.lang.String r2 = r2.m22644d()
            r3.f32362d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L40
            com.mbridge.msdk.foundation.entity.CampaignEx$a r4 = r4.getAdchoice()
            java.lang.String r4 = r4.m22642f()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L40
            r4 = 1
            goto L41
        L40:
            r4 = 0
        L41:
            if (r4 != 0) goto L7a
            com.mbridge.msdk.c.b r4 = com.mbridge.msdk.p457c.SettingManager.m23261a()
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()
            java.lang.String r2 = r2.m22860k()
            com.mbridge.msdk.c.a r4 = r4.m23252b(r2)
            if (r4 == 0) goto L78
            java.lang.String r2 = r4.m23348ax()
            r3.f32360b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L78
            java.lang.String r2 = r4.m23346az()
            r3.f32362d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L78
            java.lang.String r4 = r4.m23347ay()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L78
            goto L79
        L78:
            r0 = 0
        L79:
            r4 = r0
        L7a:
            java.lang.String r0 = r3.f32360b
            r3.setImageUrl(r0)
            if (r4 == 0) goto L93
            android.content.Context r4 = r3.f32363e
            if (r4 == 0) goto L93
            com.mbridge.msdk.foundation.same.c.b r4 = com.mbridge.msdk.foundation.same.p476c.CommonImageLoader.m22343a(r4)
            java.lang.String r0 = r3.f32360b
            com.mbridge.msdk.widget.MBAdChoice$1 r1 = new com.mbridge.msdk.widget.MBAdChoice$1
            r1.<init>()
            r4.m22339a(r0, r1)
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.widget.MBAdChoice.setCampaign(com.mbridge.msdk.out.Campaign):void");
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32360b = "";
        this.f32361c = "";
        this.f32362d = "";
        this.f32363e = context;
        m20636b();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32360b = "";
        this.f32361c = "";
        this.f32362d = "";
        this.f32363e = context;
        m20636b();
    }
}
