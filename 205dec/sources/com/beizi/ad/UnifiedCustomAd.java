package com.beizi.ad;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import androidx.annotation.RequiresPermission;
import com.beizi.ad.internal.network.a;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.lance.a.g;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.o;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class UnifiedCustomAd implements AdLifeControl {

    /* renamed from: a  reason: collision with root package name */
    private int f13100a;

    /* renamed from: b  reason: collision with root package name */
    private int f13101b;

    /* renamed from: c  reason: collision with root package name */
    private final com.beizi.ad.internal.nativead.b f13102c;

    /* renamed from: d  reason: collision with root package name */
    private List<Pair<String, Integer>> f13103d;

    /* renamed from: e  reason: collision with root package name */
    private View f13104e;

    @RequiresPermission("android.permission.INTERNET")
    public UnifiedCustomAd(Context context, String str, NativeAdListener nativeAdListener) {
        com.beizi.ad.internal.nativead.b bVar = new com.beizi.ad.internal.nativead.b(context, str, 1);
        this.f13102c = bVar;
        bVar.a(nativeAdListener);
    }

    @Override // com.beizi.ad.AdLifeControl
    public void cancel() {
        com.beizi.ad.internal.nativead.b bVar = this.f13102c;
        if (bVar != null) {
            bVar.f13932a.a();
            this.f13102c.cancel(true);
        }
    }

    public String getAdId() {
        com.beizi.ad.internal.nativead.b bVar = this.f13102c;
        if (bVar == null) {
            return null;
        }
        return bVar.e();
    }

    public NativeAdListener getAdListener() {
        return this.f13102c.f();
    }

    public int getAdOptimizePercent() {
        return this.f13100a;
    }

    public int getAdOptimizeSize() {
        return this.f13101b;
    }

    public String getAdUnitId() {
        return this.f13102c.c();
    }

    public List<Pair<String, Integer>> getOrderOptimizeList() {
        return this.f13103d;
    }

    public String getPrice() {
        com.beizi.ad.internal.nativead.b bVar = this.f13102c;
        if (bVar == null) {
            return null;
        }
        return bVar.d();
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
            com.beizi.ad.internal.nativead.b r0 = r6.f13102c
            r1 = -1
            if (r0 == 0) goto L39
            java.lang.String r0 = r0.i()
            if (r0 == 0) goto L39
            com.beizi.ad.internal.nativead.b r0 = r6.f13102c
            java.lang.String r0 = r0.i()
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r2 = r6.f13103d
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
            int r3 = r6.f13100a
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.UnifiedCustomAd.getValidOptimizePercent():int");
    }

    public boolean isDownloadApp() {
        com.beizi.ad.internal.nativead.b bVar = this.f13102c;
        if (bVar == null) {
            return false;
        }
        return bVar.j();
    }

    public void loadAd() {
        this.f13102c.a((a.C0126a) null);
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onDestoryLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onResumeLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onStopLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void openAdInNativeBrowser(boolean z3) {
        this.f13102c.a(z3);
    }

    public void optimizeClickArea(int i4, View view, View view2, String str) {
        int validOptimizePercent = getValidOptimizePercent();
        boolean a4 = o.a(validOptimizePercent);
        l.c("BeiZisAd", "percent = " + validOptimizePercent + ",isPass = " + a4);
        if (a4) {
            this.f13104e = g.a(i4, view, view2, str);
        }
    }

    public void setAdOptimizePercent(int i4) {
        this.f13100a = i4;
    }

    public void setAdOptimizeSize(int i4) {
        this.f13101b = i4;
    }

    public void setAdUnitId(String str) {
        this.f13102c.a(str);
    }

    public void setCloseMarketDialog(boolean z3) {
        com.beizi.ad.internal.nativead.b bVar = this.f13102c;
        if (bVar != null) {
            bVar.b(z3);
        }
    }

    public void setOrderOptimizeList(List<Pair<String, Integer>> list) {
        this.f13103d = list;
    }

    public void setTouchAreaNormal() {
        View view = this.f13104e;
        if (view != null) {
            ViewUtil.removeChildFromParent(view);
        }
    }
}
