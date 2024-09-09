package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.amap.api.fence.GeoFenceClient;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonOptions;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.student.run.app.utils.d0;
import com.bxkj.student.v2.ui.sports.v3.V3ThreeTwoOneActivity;
import com.bxkj.student.v2.ui.sports.v3.service.g;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.orhanobut.logger.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: V3GeoFenceObserver.kt */
@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b8\u00109J*\u0010\b\u001a\u00020\u00072 \u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0007J\b\u0010\r\u001a\u00020\u0007H\u0007R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010#R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010*R\u001a\u0010/\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00101R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00106\u00a8\u0006:"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3GeoFenceObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "", "", "", "it", "Lkotlin/f1;", "d", "", "isIn", "k", "onCreate", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "h", "()Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "b", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "i", "()Lcom/bxkj/student/v2/vm/sports/SportsVM;", "j", "(Lcom/bxkj/student/v2/vm/sports/SportsVM;)V", "mViewModel", "Lcom/amap/api/maps/AMap;", "c", "Lcom/amap/api/maps/AMap;", "f", "()Lcom/amap/api/maps/AMap;", "aMap", "Lcom/amap/api/fence/GeoFenceClient;", "Lcom/amap/api/fence/GeoFenceClient;", "mGeoFenceClientBounds", "", "e", "Ljava/util/Map;", "geoFenceStatusMap", "Landroid/content/Intent;", "Landroid/content/Intent;", "registerReceiverIntentDounds", "g", "Ljava/lang/String;", "()Ljava/lang/String;", "GEOFENCE_BROADCAST_BOUNDS_ACTION", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mGeoFenceBoundsReceiver", "Z", "lastIsOut", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "fenceDialog", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/bxkj/student/v2/vm/sports/SportsVM;Lcom/amap/api/maps/AMap;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class V3GeoFenceObserver implements LifecycleObserver {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FragmentActivity f24180a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private SportsVM f24181b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final AMap f24182c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private GeoFenceClient f24183d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Boolean> f24184e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Intent f24185f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final String f24186g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final BroadcastReceiver f24187h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24188i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private iOSOneButtonDialog f24189j;

    public V3GeoFenceObserver(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull AMap aMap) {
        f0.p(mActivity, "mActivity");
        f0.p(mViewModel, "mViewModel");
        f0.p(aMap, "aMap");
        this.f24180a = mActivity;
        this.f24181b = mViewModel;
        this.f24182c = aMap;
        this.f24184e = new LinkedHashMap();
        this.f24186g = "com.location.apis.geofenceBounds.broadcast";
        this.f24187h = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3GeoFenceObserver$mGeoFenceBoundsReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Map map;
                Map map2;
                Map map3;
                f0.p(context, "context");
                f0.p(intent, "intent");
                if (f0.g(intent.getAction(), V3GeoFenceObserver.this.g())) {
                    Bundle extras = intent.getExtras();
                    Integer valueOf = extras == null ? null : Integer.valueOf(extras.getInt("event"));
                    String string = extras != null ? extras.getString("customId") : null;
                    if (string == null) {
                        return;
                    }
                    V3GeoFenceObserver v3GeoFenceObserver = V3GeoFenceObserver.this;
                    map = v3GeoFenceObserver.f24184e;
                    boolean z3 = false;
                    map.put(string, Boolean.valueOf(valueOf != null && valueOf.intValue() == 1));
                    map2 = v3GeoFenceObserver.f24184e;
                    for (String str : map2.keySet()) {
                        map3 = v3GeoFenceObserver.f24184e;
                        if (f0.g(map3.get(str), Boolean.TRUE)) {
                            z3 = true;
                        }
                    }
                    v3GeoFenceObserver.k(z3);
                }
            }
        };
    }

    private final void d(List<? extends List<? extends Map<String, ? extends Object>>> list) {
        int Z;
        int Z2;
        int i4 = 0;
        for (Object obj : list) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            List<Map> list2 = (List) obj;
            GeoFenceClient geoFenceClient = this.f24183d;
            if (geoFenceClient != null) {
                Z2 = y.Z(list2, 10);
                ArrayList arrayList = new ArrayList(Z2);
                for (Map map : list2) {
                    m mVar = m.a;
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(new DPoint(Double.parseDouble(mVar.t(map, "lat")), Double.parseDouble(mVar.t(map, "lng"))));
                    arrayList = arrayList2;
                }
                geoFenceClient.addGeoFence(arrayList, f0.C("runGeoFenceId", Integer.valueOf(i4)));
            }
            this.f24184e.put(f0.C("runGeoFenceId", Integer.valueOf(i4)), Boolean.TRUE);
            Z = y.Z(list2, 10);
            ArrayList arrayList3 = new ArrayList(Z);
            for (Map map2 : list2) {
                m mVar2 = m.a;
                arrayList3.add(new LatLng(Double.parseDouble(mVar2.t(map2, "lat")), Double.parseDouble(mVar2.t(map2, "lng"))));
            }
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.addAll(arrayList3);
            polygonOptions.fillColor(ContextCompat.getColor(h(), 2131034260));
            polygonOptions.strokeColor(ContextCompat.getColor(h(), 2131034446));
            polygonOptions.strokeWidth(4.0f);
            f().addPolygon(polygonOptions);
            i4 = i5;
        }
        a aVar = new GeoFenceListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.a
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list3, int i6, String str) {
                V3GeoFenceObserver.e(list3, i6, str);
            }
        };
        GeoFenceClient geoFenceClient2 = this.f24183d;
        if (geoFenceClient2 != null) {
            geoFenceClient2.setGeoFenceListener(aVar);
        }
        GeoFenceClient geoFenceClient3 = this.f24183d;
        if (geoFenceClient3 != null) {
            geoFenceClient3.createPendingIntent(this.f24186g);
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(this.f24186g);
        this.f24185f = this.f24180a.registerReceiver(this.f24187h, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(List list, int i4, String str) {
        if (i4 == 0) {
            j.d("\u6dfb\u52a0\u8dd1\u6b65\u8303\u56f4\u56f4\u680f\u6210\u529f!!", new Object[0]);
        } else {
            j.d("\u6dfb\u52a0\u8dd1\u6b65\u8303\u56f4\u56f4\u680f\u5931\u8d25!!", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(boolean z3) {
        List<Integer> Q;
        List<Integer> Q2;
        iOSOneButtonDialog iosonebuttondialog = null;
        if (z3 && this.f24188i) {
            j.d("ActionStatus=\u5728\u5730\u7406\u56f4\u680f\u91cc\u9762", new Object[0]);
            com.bxkj.student.v2.common.data.c.f23133a.T(false);
            d0 e4 = d0.e();
            FragmentActivity fragmentActivity = this.f24180a;
            Q2 = CollectionsKt__CollectionsKt.Q(2131755021);
            e4.n(fragmentActivity, Q2);
            iOSOneButtonDialog iosonebuttondialog2 = this.f24189j;
            if (iosonebuttondialog2 != null) {
                if (!iosonebuttondialog2.isShowing()) {
                    Activity q3 = cn.bluemobi.dylan.base.utils.a.n().q();
                    if (q3 != null) {
                        if (q3 instanceof V3ThreeTwoOneActivity) {
                            Activity r3 = cn.bluemobi.dylan.base.utils.a.n().r();
                            if (r3 != null) {
                                iosonebuttondialog = ContextExtKt.m(r3, "\u60a8\u5df2\u8fdb\u5165\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6062\u590d\uff0c\u8bf7\u7ee7\u7eed\u8fdb\u884c\u8dd1\u6b65\uff01");
                            }
                        } else {
                            iosonebuttondialog = ContextExtKt.m(q3, "\u60a8\u5df2\u8fdb\u5165\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6062\u590d\uff0c\u8bf7\u7ee7\u7eed\u8fdb\u884c\u8dd1\u6b65\uff01");
                        }
                        this.f24189j = iosonebuttondialog;
                    }
                    g.a.f(g.f24275a, h(), "\u60a8\u5df2\u8fdb\u5165\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6062\u590d\uff0c\u8bf7\u7ee7\u7eed\u8fdb\u884c\u8dd1\u6b65\uff01", false, 4, null);
                } else {
                    iosonebuttondialog2.dismiss();
                }
            }
        } else if (!z3 && !this.f24188i) {
            j.d("ActionStatus=\u5728\u5730\u7406\u56f4\u680f\u5916\u9762", new Object[0]);
            com.bxkj.student.v2.common.data.c.f23133a.T(true);
            d0 e5 = d0.e();
            FragmentActivity fragmentActivity2 = this.f24180a;
            Q = CollectionsKt__CollectionsKt.Q(2131755022);
            e5.n(fragmentActivity2, Q);
            Object systemService = this.f24180a.getSystemService("vibrator");
            if (systemService != null) {
                ((Vibrator) systemService).vibrate(2000L);
                iOSOneButtonDialog iosonebuttondialog3 = this.f24189j;
                if (iosonebuttondialog3 != null) {
                    iosonebuttondialog3.dismiss();
                }
                Activity q4 = cn.bluemobi.dylan.base.utils.a.n().q();
                if (q4 != null) {
                    if (q4 instanceof V3ThreeTwoOneActivity) {
                        Activity r4 = cn.bluemobi.dylan.base.utils.a.n().r();
                        if (r4 != null) {
                            iosonebuttondialog = ContextExtKt.m(r4, "\u60a8\u5df2\u504f\u79bb\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728\u89c4\u5b9a\u533a\u57df\u5185\u8fdb\u884c\u8dd1\u6b65\uff01");
                        }
                    } else {
                        iosonebuttondialog = ContextExtKt.m(q4, "\u60a8\u5df2\u504f\u79bb\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728\u89c4\u5b9a\u533a\u57df\u5185\u8fdb\u884c\u8dd1\u6b65\uff01");
                    }
                    this.f24189j = iosonebuttondialog;
                }
                g.a.f(g.f24275a, this.f24180a, "\u60a8\u5df2\u504f\u79bb\u8dd1\u6b65\u89c4\u5b9a\u533a\u57df\uff0c\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728\u89c4\u5b9a\u533a\u57df\u5185\u8fdb\u884c\u8dd1\u6b65\uff01", false, 4, null);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
            }
        }
        this.f24188i = !z3;
    }

    @NotNull
    public final AMap f() {
        return this.f24182c;
    }

    @NotNull
    public final String g() {
        return this.f24186g;
    }

    @NotNull
    public final FragmentActivity h() {
        return this.f24180a;
    }

    @NotNull
    public final SportsVM i() {
        return this.f24181b;
    }

    public final void j(@NotNull SportsVM sportsVM) {
        f0.p(sportsVM, "<set-?>");
        this.f24181b = sportsVM;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        GeoFenceClient geoFenceClient = new GeoFenceClient(this.f24180a);
        geoFenceClient.setActivateAction(3);
        f1 f1Var = f1.f55527a;
        this.f24183d = geoFenceClient;
        j.d(f0.C("V3GeoFenceObserver->mViewModel.sportsSetMap=", this.f24181b.D()), new Object[0]);
        if (this.f24181b.D().containsKey("geofence")) {
            m mVar = m.a;
            d(mVar.y(mVar.t(this.f24181b.D(), "geofence")));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        GeoFenceClient geoFenceClient = this.f24183d;
        if (geoFenceClient != null) {
            f0.m(geoFenceClient);
            geoFenceClient.removeGeoFence();
        }
        if (this.f24185f != null) {
            this.f24180a.unregisterReceiver(this.f24187h);
        }
    }
}
