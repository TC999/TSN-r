package com.bxkj.student.p094v2.common.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.Tools;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.bxkj.student.run.app.utils.FormatUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b(\u0010)J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0018\u0010'\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\"¨\u0006*"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/g;", "", "", "Lcom/bxkj/student/v2/common/data/PointData;", "latLngTimeSpeedList", "Lkotlin/f1;", "a", "Lcom/amap/api/maps/model/LatLng;", "newLatLng", "lastLatLng", "", "speed", "", "isPause", "b", "Landroid/content/Context;", "Landroid/content/Context;", "d", "()Landroid/content/Context;", "mContext", "Lcom/amap/api/maps/AMap;", "Lcom/amap/api/maps/AMap;", "c", "()Lcom/amap/api/maps/AMap;", "aMap", "", "", "Ljava/util/List;", "colorList", "Lcom/amap/api/maps/model/PolylineOptions;", "Lcom/amap/api/maps/model/PolylineOptions;", "polylineOptions", "Lcom/amap/api/maps/model/Polyline;", "e", "Lcom/amap/api/maps/model/Polyline;", "polyline", "f", "polylineOptionsDotted", "g", "polylineDotted", "<init>", "(Landroid/content/Context;Lcom/amap/api/maps/AMap;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class DrawMapLineManager {
    @NotNull

    /* renamed from: a */
    private final Context f20106a;
    @Nullable

    /* renamed from: b */
    private final AMap f20107b;
    @NotNull

    /* renamed from: c */
    private List<Integer> f20108c;
    @Nullable

    /* renamed from: d */
    private PolylineOptions f20109d;
    @Nullable

    /* renamed from: e */
    private Polyline f20110e;
    @Nullable

    /* renamed from: f */
    private PolylineOptions f20111f;
    @Nullable

    /* renamed from: g */
    private Polyline f20112g;

    public DrawMapLineManager(@NotNull Context mContext, @Nullable AMap aMap) {
        C14342f0.m8184p(mContext, "mContext");
        this.f20106a = mContext;
        this.f20107b = aMap;
        this.f20108c = new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m39130a(@org.jetbrains.annotations.Nullable java.util.List<? extends com.bxkj.student.p094v2.common.data.PointData> r17) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.common.utils.DrawMapLineManager.m39130a(java.util.List):void");
    }

    /* renamed from: b */
    public final void m39129b(@NotNull LatLng newLatLng, @NotNull LatLng lastLatLng, float f, boolean z) {
        C14342f0.m8184p(newLatLng, "newLatLng");
        C14342f0.m8184p(lastLatLng, "lastLatLng");
        PolylineOptions polylineOptions = null;
        PolylineOptions polylineOptions2 = null;
        if (z) {
            Polyline polyline = this.f20112g;
            if (polyline != null) {
                if (polyline == null) {
                    return;
                }
                PolylineOptions polylineOptions3 = this.f20111f;
                if (polylineOptions3 != null) {
                    polylineOptions3.add(newLatLng);
                    polylineOptions3.width(Tools.m57620a(8.0f, m39127d()));
                    polylineOptions3.setDottedLine(true);
                    polylineOptions3.color(ContextCompat.getColor(m39127d(), 2131034173));
                    polylineOptions3.zIndex(Tools.m57620a(5.0f, m39127d()));
                    Unit unit = Unit.f41048a;
                    polylineOptions2 = polylineOptions3;
                }
                polyline.setOptions(polylineOptions2);
                return;
            }
            this.f20109d = null;
            this.f20110e = null;
            this.f20108c = new ArrayList();
            PolylineOptions polylineOptions4 = new PolylineOptions();
            polylineOptions4.add(lastLatLng, newLatLng);
            polylineOptions4.width(Tools.m57620a(8.0f, m39127d()));
            polylineOptions4.setDottedLine(true);
            polylineOptions4.color(ContextCompat.getColor(m39127d(), 2131034173));
            polylineOptions4.zIndex(Tools.m57620a(5.0f, m39127d()));
            Unit unit2 = Unit.f41048a;
            this.f20111f = polylineOptions4;
            AMap aMap = this.f20107b;
            this.f20112g = aMap != null ? aMap.addPolyline(polylineOptions4) : null;
            return;
        }
        this.f20108c.add(Integer.valueOf(FormatUtils.m39618s(this.f20106a, f)));
        Polyline polyline2 = this.f20110e;
        if (polyline2 == null) {
            this.f20111f = null;
            this.f20112g = null;
            PolylineOptions polylineOptions5 = new PolylineOptions();
            polylineOptions5.add(lastLatLng, newLatLng);
            polylineOptions5.width(Tools.m57620a(6.0f, m39127d()));
            polylineOptions5.colorValues(this.f20108c);
            polylineOptions5.zIndex(Tools.m57620a(5.0f, m39127d()));
            Unit unit3 = Unit.f41048a;
            this.f20109d = polylineOptions5;
            AMap aMap2 = this.f20107b;
            this.f20110e = aMap2 != null ? aMap2.addPolyline(polylineOptions5) : null;
        } else if (polyline2 == null) {
        } else {
            PolylineOptions polylineOptions6 = this.f20109d;
            if (polylineOptions6 != null) {
                polylineOptions6.add(newLatLng);
                polylineOptions6.width(Tools.m57620a(6.0f, m39127d()));
                polylineOptions6.colorValues(this.f20108c);
                polylineOptions6.useGradient(true);
                polylineOptions6.zIndex(Tools.m57620a(5.0f, m39127d()));
                polylineOptions6.color(FormatUtils.m39618s(m39127d(), f));
                Unit unit4 = Unit.f41048a;
                polylineOptions = polylineOptions6;
            }
            polyline2.setOptions(polylineOptions);
        }
    }

    @Nullable
    /* renamed from: c */
    public final AMap m39128c() {
        return this.f20107b;
    }

    @NotNull
    /* renamed from: d */
    public final Context m39127d() {
        return this.f20106a;
    }
}
