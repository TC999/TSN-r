package com.beizi.p051ad;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import androidx.annotation.RequiresPermission;
import com.beizi.p051ad.internal.nativead.NativeAdRequestImpl;
import com.beizi.p051ad.internal.network.AdRequestImpl;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.lance.p062a.ExpandTouchAreaUtil;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.ProbabilityUtil;
import com.kuaishou.weapon.p205p0.C7282g;
import java.util.List;

/* renamed from: com.beizi.ad.UnifiedCustomAd */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class UnifiedCustomAd implements AdLifeControl {

    /* renamed from: a */
    private int f9384a;

    /* renamed from: b */
    private int f9385b;

    /* renamed from: c */
    private final NativeAdRequestImpl f9386c;

    /* renamed from: d */
    private List<Pair<String, Integer>> f9387d;

    /* renamed from: e */
    private View f9388e;

    @RequiresPermission(C7282g.f24943a)
    public UnifiedCustomAd(Context context, String str, NativeAdListener nativeAdListener) {
        NativeAdRequestImpl nativeAdRequestImpl = new NativeAdRequestImpl(context, str, 1);
        this.f9386c = nativeAdRequestImpl;
        nativeAdRequestImpl.m49396a(nativeAdListener);
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void cancel() {
        NativeAdRequestImpl nativeAdRequestImpl = this.f9386c;
        if (nativeAdRequestImpl != null) {
            nativeAdRequestImpl.f10291a.m49539a();
            this.f9386c.cancel(true);
        }
    }

    public String getAdId() {
        NativeAdRequestImpl nativeAdRequestImpl = this.f9386c;
        if (nativeAdRequestImpl == null) {
            return null;
        }
        return nativeAdRequestImpl.m49379e();
    }

    public NativeAdListener getAdListener() {
        return this.f9386c.m49378f();
    }

    public int getAdOptimizePercent() {
        return this.f9384a;
    }

    public int getAdOptimizeSize() {
        return this.f9385b;
    }

    public String getAdUnitId() {
        return this.f9386c.m49386c();
    }

    public List<Pair<String, Integer>> getOrderOptimizeList() {
        return this.f9387d;
    }

    public String getPrice() {
        NativeAdRequestImpl nativeAdRequestImpl = this.f9386c;
        if (nativeAdRequestImpl == null) {
            return null;
        }
        return nativeAdRequestImpl.m49382d();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getValidOptimizePercent() {
        /*
            r6 = this;
            com.beizi.ad.internal.nativead.b r0 = r6.f9386c
            r1 = -1
            if (r0 == 0) goto L39
            java.lang.String r0 = r0.m49375i()
            if (r0 == 0) goto L39
            com.beizi.ad.internal.nativead.b r0 = r6.f9386c
            java.lang.String r0 = r0.m49375i()
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r2 = r6.f9387d
            if (r2 == 0) goto L39
            java.util.Iterator r2 = r2.iterator()
            r3 = -1
        L1a:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r2.next()
            android.util.Pair r4 = (android.util.Pair) r4
            java.lang.Object r5 = r4.first
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L1a
            java.lang.Object r3 = r4.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L1a
        L39:
            r3 = -1
        L3a:
            if (r3 != r1) goto L3e
            int r3 = r6.f9384a
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.UnifiedCustomAd.getValidOptimizePercent():int");
    }

    public void loadAd() {
        this.f9386c.m49393a((AdRequestImpl.C2918a) null);
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onDestoryLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onResumeLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onStopLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void openAdInNativeBrowser(boolean z) {
        this.f9386c.m49391a(z);
    }

    public void optimizeClickArea(int i, View view, View view2, String str) {
        int validOptimizePercent = getValidOptimizePercent();
        boolean m49039a = ProbabilityUtil.m49039a(validOptimizePercent);
        LogUtil.m49044c("BeiZisAd", "percent = " + validOptimizePercent + ",isPass = " + m49039a);
        if (m49039a) {
            this.f9388e = ExpandTouchAreaUtil.m49065a(i, view, view2, str);
        }
    }

    public void setAdOptimizePercent(int i) {
        this.f9384a = i;
    }

    public void setAdOptimizeSize(int i) {
        this.f9385b = i;
    }

    public void setAdUnitId(String str) {
        this.f9386c.m49392a(str);
    }

    public void setCloseMarketDialog(boolean z) {
        NativeAdRequestImpl nativeAdRequestImpl = this.f9386c;
        if (nativeAdRequestImpl != null) {
            nativeAdRequestImpl.m49387b(z);
        }
    }

    public void setOrderOptimizeList(List<Pair<String, Integer>> list) {
        this.f9387d = list;
    }

    public void setTouchAreaNormal() {
        View view = this.f9388e;
        if (view != null) {
            ViewUtil.removeChildFromParent(view);
        }
    }
}
