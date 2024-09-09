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
public final class NativeAd implements AdLifeControl {

    /* renamed from: a  reason: collision with root package name */
    private int f13082a;

    /* renamed from: b  reason: collision with root package name */
    private int f13083b;

    /* renamed from: c  reason: collision with root package name */
    private String f13084c;

    /* renamed from: d  reason: collision with root package name */
    private int f13085d;

    /* renamed from: e  reason: collision with root package name */
    private String f13086e;

    /* renamed from: f  reason: collision with root package name */
    private List<Pair<String, Integer>> f13087f;

    /* renamed from: g  reason: collision with root package name */
    private final com.beizi.ad.internal.nativead.b f13088g;

    /* renamed from: h  reason: collision with root package name */
    private View f13089h;

    @RequiresPermission("android.permission.INTERNET")
    public NativeAd(Context context, String str, int i4, NativeAdListener nativeAdListener) {
        com.beizi.ad.internal.nativead.b bVar = new com.beizi.ad.internal.nativead.b(context, str, i4);
        this.f13088g = bVar;
        bVar.a(nativeAdListener);
    }

    @Override // com.beizi.ad.AdLifeControl
    public void cancel() {
        com.beizi.ad.internal.nativead.b bVar = this.f13088g;
        if (bVar != null) {
            bVar.f13932a.a();
            this.f13088g.cancel(true);
        }
    }

    public String getAdId() {
        com.beizi.ad.internal.nativead.b bVar = this.f13088g;
        if (bVar == null) {
            return null;
        }
        return bVar.e();
    }

    public NativeAdListener getAdListener() {
        return this.f13088g.f();
    }

    public int getAdOptimizePercent() {
        return this.f13082a;
    }

    public int getAdOptimizeSize() {
        return this.f13083b;
    }

    public String getAdUnitId() {
        return this.f13088g.c();
    }

    public String getDirection() {
        return this.f13086e;
    }

    public List<Pair<String, Integer>> getOrderOptimizeList() {
        return this.f13087f;
    }

    public String getPrice() {
        com.beizi.ad.internal.nativead.b bVar = this.f13088g;
        if (bVar == null) {
            return null;
        }
        return bVar.d();
    }

    public String getScrollDistance() {
        return this.f13084c;
    }

    public int getScrollDistancePercent() {
        return this.f13085d;
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
            com.beizi.ad.internal.nativead.b r0 = r6.f13088g
            r1 = -1
            if (r0 == 0) goto L39
            java.lang.String r0 = r0.i()
            if (r0 == 0) goto L39
            com.beizi.ad.internal.nativead.b r0 = r6.f13088g
            java.lang.String r0 = r0.i()
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r2 = r6.f13087f
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
            int r3 = r6.f13082a
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.NativeAd.getValidOptimizePercent():int");
    }

    public boolean isDownloadApp() {
        com.beizi.ad.internal.nativead.b bVar = this.f13088g;
        if (bVar == null) {
            return false;
        }
        return bVar.j();
    }

    public void loadAd() {
        this.f13088g.a((a.C0126a) null);
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
        this.f13088g.a(z3);
    }

    public void optimizeClickArea(int i4, View view, View view2, String str) {
        int validOptimizePercent = getValidOptimizePercent();
        boolean a4 = o.a(validOptimizePercent);
        l.c("BeiZisAd", "percent = " + validOptimizePercent + ",isPass = " + a4);
        if (a4) {
            this.f13089h = g.a(i4, view, view2, str);
        }
    }

    public void setAdOptimizePercent(int i4) {
        this.f13082a = i4;
    }

    public void setAdOptimizeSize(int i4) {
        this.f13083b = i4;
    }

    public void setAdUnitId(String str) {
        this.f13088g.a(str);
    }

    public void setCloseMarketDialog(boolean z3) {
        com.beizi.ad.internal.nativead.b bVar = this.f13088g;
        if (bVar != null) {
            bVar.b(z3);
        }
    }

    public void setDirection(String str) {
        this.f13086e = str;
    }

    public void setOrderOptimizeList(List<Pair<String, Integer>> list) {
        this.f13087f = list;
    }

    public void setScrollDistance(String str) {
        this.f13084c = str;
    }

    public void setScrollDistancePercent(int i4) {
        this.f13085d = i4;
    }

    public void setTouchAreaNormal() {
        View view = this.f13089h;
        if (view != null) {
            ViewUtil.removeChildFromParent(view);
        }
    }

    @Deprecated
    public void shouldLoadIcon(boolean z3) {
        this.f13088g.d(z3);
    }

    @Deprecated
    public void shouldLoadImage(boolean z3) {
        this.f13088g.c(z3);
    }
}
