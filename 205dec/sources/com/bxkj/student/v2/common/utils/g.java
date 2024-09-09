package com.bxkj.student.v2.common.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.u;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: DrawMapLineManager.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b(\u0010)J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0018\u0010'\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/bxkj/student/v2/common/utils/g;", "", "", "Lcom/bxkj/student/v2/common/data/PointData;", "latLngTimeSpeedList", "Lkotlin/f1;", "a", "Lcom/amap/api/maps/model/LatLng;", "newLatLng", "lastLatLng", "", "speed", "", "isPause", "b", "Landroid/content/Context;", "Landroid/content/Context;", "d", "()Landroid/content/Context;", "mContext", "Lcom/amap/api/maps/AMap;", "Lcom/amap/api/maps/AMap;", "c", "()Lcom/amap/api/maps/AMap;", "aMap", "", "", "Ljava/util/List;", "colorList", "Lcom/amap/api/maps/model/PolylineOptions;", "Lcom/amap/api/maps/model/PolylineOptions;", "polylineOptions", "Lcom/amap/api/maps/model/Polyline;", "e", "Lcom/amap/api/maps/model/Polyline;", "polyline", "f", "polylineOptionsDotted", "g", "polylineDotted", "<init>", "(Landroid/content/Context;Lcom/amap/api/maps/AMap;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f23350a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final AMap f23351b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f23352c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private PolylineOptions f23353d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Polyline f23354e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private PolylineOptions f23355f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Polyline f23356g;

    public g(@NotNull Context mContext, @Nullable AMap aMap) {
        f0.p(mContext, "mContext");
        this.f23350a = mContext;
        this.f23351b = aMap;
        this.f23352c = new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@org.jetbrains.annotations.Nullable java.util.List<? extends com.bxkj.student.v2.common.data.PointData> r17) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.utils.g.a(java.util.List):void");
    }

    public final void b(@NotNull LatLng newLatLng, @NotNull LatLng lastLatLng, float f4, boolean z3) {
        f0.p(newLatLng, "newLatLng");
        f0.p(lastLatLng, "lastLatLng");
        PolylineOptions polylineOptions = null;
        PolylineOptions polylineOptions2 = null;
        if (z3) {
            Polyline polyline = this.f23356g;
            if (polyline != null) {
                if (polyline == null) {
                    return;
                }
                PolylineOptions polylineOptions3 = this.f23355f;
                if (polylineOptions3 != null) {
                    polylineOptions3.add(newLatLng);
                    polylineOptions3.width(u.a(8.0f, d()));
                    polylineOptions3.setDottedLine(true);
                    polylineOptions3.color(ContextCompat.getColor(d(), 2131034177));
                    polylineOptions3.zIndex(u.a(5.0f, d()));
                    f1 f1Var = f1.f55527a;
                    polylineOptions2 = polylineOptions3;
                }
                polyline.setOptions(polylineOptions2);
                return;
            }
            this.f23353d = null;
            this.f23354e = null;
            this.f23352c = new ArrayList();
            PolylineOptions polylineOptions4 = new PolylineOptions();
            polylineOptions4.add(lastLatLng, newLatLng);
            polylineOptions4.width(u.a(8.0f, d()));
            polylineOptions4.setDottedLine(true);
            polylineOptions4.color(ContextCompat.getColor(d(), 2131034177));
            polylineOptions4.zIndex(u.a(5.0f, d()));
            f1 f1Var2 = f1.f55527a;
            this.f23355f = polylineOptions4;
            AMap aMap = this.f23351b;
            this.f23356g = aMap != null ? aMap.addPolyline(polylineOptions4) : null;
            return;
        }
        this.f23352c.add(Integer.valueOf(com.bxkj.student.run.app.utils.i.s(this.f23350a, f4)));
        Polyline polyline2 = this.f23354e;
        if (polyline2 == null) {
            this.f23355f = null;
            this.f23356g = null;
            PolylineOptions polylineOptions5 = new PolylineOptions();
            polylineOptions5.add(lastLatLng, newLatLng);
            polylineOptions5.width(u.a(6.0f, d()));
            polylineOptions5.colorValues(this.f23352c);
            polylineOptions5.zIndex(u.a(5.0f, d()));
            f1 f1Var3 = f1.f55527a;
            this.f23353d = polylineOptions5;
            AMap aMap2 = this.f23351b;
            this.f23354e = aMap2 != null ? aMap2.addPolyline(polylineOptions5) : null;
        } else if (polyline2 == null) {
        } else {
            PolylineOptions polylineOptions6 = this.f23353d;
            if (polylineOptions6 != null) {
                polylineOptions6.add(newLatLng);
                polylineOptions6.width(u.a(6.0f, d()));
                polylineOptions6.colorValues(this.f23352c);
                polylineOptions6.useGradient(true);
                polylineOptions6.zIndex(u.a(5.0f, d()));
                polylineOptions6.color(com.bxkj.student.run.app.utils.i.s(d(), f4));
                f1 f1Var4 = f1.f55527a;
                polylineOptions = polylineOptions6;
            }
            polyline2.setOptions(polylineOptions);
        }
    }

    @Nullable
    public final AMap c() {
        return this.f23351b;
    }

    @NotNull
    public final Context d() {
        return this.f23350a;
    }
}
