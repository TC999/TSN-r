package com.bxkj.student.p094v2.p098ui.sports.p102v3.service;

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
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceClient;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonOptions;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3ThreeTwoOneActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3NotificationManager;
import com.bxkj.student.p094v2.p103vm.sports.SportsVM;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.utils.VoiceSpeaker;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UContent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C14236x;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3GeoFenceObserver.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u001c¢\u0006\u0004\b8\u00109J*\u0010\b\u001a\u00020\u00072 \u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0007J\b\u0010\r\u001a\u00020\u0007H\u0007R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010#R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010*R\u001a\u0010/\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00101R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00106¨\u0006:"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3GeoFenceObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "", "", "", "it", "Lkotlin/f1;", "d", "", "isIn", "k", "onCreate", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "h", "()Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "b", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "i", "()Lcom/bxkj/student/v2/vm/sports/SportsVM;", "j", "(Lcom/bxkj/student/v2/vm/sports/SportsVM;)V", "mViewModel", "Lcom/amap/api/maps/AMap;", "c", "Lcom/amap/api/maps/AMap;", "f", "()Lcom/amap/api/maps/AMap;", "aMap", "Lcom/amap/api/fence/GeoFenceClient;", "Lcom/amap/api/fence/GeoFenceClient;", "mGeoFenceClientBounds", "", "e", "Ljava/util/Map;", "geoFenceStatusMap", "Landroid/content/Intent;", "Landroid/content/Intent;", "registerReceiverIntentDounds", "g", "Ljava/lang/String;", "()Ljava/lang/String;", "GEOFENCE_BROADCAST_BOUNDS_ACTION", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mGeoFenceBoundsReceiver", "Z", "lastIsOut", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "fenceDialog", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/bxkj/student/v2/vm/sports/SportsVM;Lcom/amap/api/maps/AMap;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3GeoFenceObserver */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class V3GeoFenceObserver implements LifecycleObserver {
    @NotNull

    /* renamed from: a */
    private final FragmentActivity f20761a;
    @NotNull

    /* renamed from: b */
    private SportsVM f20762b;
    @NotNull

    /* renamed from: c */
    private final AMap f20763c;
    @Nullable

    /* renamed from: d */
    private GeoFenceClient f20764d;
    @NotNull

    /* renamed from: e */
    private final Map<String, Boolean> f20765e;
    @Nullable

    /* renamed from: f */
    private Intent f20766f;
    @NotNull

    /* renamed from: g */
    private final String f20767g;
    @NotNull

    /* renamed from: h */
    private final BroadcastReceiver f20768h;

    /* renamed from: i */
    private boolean f20769i;
    @Nullable

    /* renamed from: j */
    private iOSOneButtonDialog f20770j;

    public V3GeoFenceObserver(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull AMap aMap) {
        C14342f0.m8184p(mActivity, "mActivity");
        C14342f0.m8184p(mViewModel, "mViewModel");
        C14342f0.m8184p(aMap, "aMap");
        this.f20761a = mActivity;
        this.f20762b = mViewModel;
        this.f20763c = aMap;
        this.f20765e = new LinkedHashMap();
        this.f20767g = RunningActivity.f18944M0;
        this.f20768h = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3GeoFenceObserver$mGeoFenceBoundsReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Map map;
                Map map2;
                Map map3;
                C14342f0.m8184p(context, "context");
                C14342f0.m8184p(intent, "intent");
                if (C14342f0.m8193g(intent.getAction(), V3GeoFenceObserver.this.m38335g())) {
                    Bundle extras = intent.getExtras();
                    Integer valueOf = extras == null ? null : Integer.valueOf(extras.getInt("event"));
                    String string = extras != null ? extras.getString(GeoFence.BUNDLE_KEY_CUSTOMID) : null;
                    if (string == null) {
                        return;
                    }
                    V3GeoFenceObserver v3GeoFenceObserver = V3GeoFenceObserver.this;
                    map = v3GeoFenceObserver.f20765e;
                    boolean z = false;
                    map.put(string, Boolean.valueOf(valueOf != null && valueOf.intValue() == 1));
                    map2 = v3GeoFenceObserver.f20765e;
                    for (String str : map2.keySet()) {
                        map3 = v3GeoFenceObserver.f20765e;
                        if (C14342f0.m8193g(map3.get(str), Boolean.TRUE)) {
                            z = true;
                        }
                    }
                    v3GeoFenceObserver.m38331k(z);
                }
            }
        };
    }

    /* renamed from: d */
    private final void m38338d(List<? extends List<? extends Map<String, ? extends Object>>> list) {
        int m8957Y;
        int m8957Y2;
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            List<Map<String, ? extends Object>> list2 = (List) obj;
            GeoFenceClient geoFenceClient = this.f20764d;
            if (geoFenceClient != null) {
                m8957Y2 = C14236x.m8957Y(list2, 10);
                ArrayList arrayList = new ArrayList(m8957Y2);
                for (Map<String, ? extends Object> map : list2) {
                    JsonGet jsonGet = JsonGet.f15134a;
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(new DPoint(Double.parseDouble(jsonGet.m43760t(map, UContent.f38072C)), Double.parseDouble(jsonGet.m43760t(map, UContent.f38073D))));
                    arrayList = arrayList2;
                }
                geoFenceClient.addGeoFence(arrayList, C14342f0.m8216C("runGeoFenceId", Integer.valueOf(i)));
            }
            this.f20765e.put(C14342f0.m8216C("runGeoFenceId", Integer.valueOf(i)), Boolean.TRUE);
            m8957Y = C14236x.m8957Y(list2, 10);
            ArrayList arrayList3 = new ArrayList(m8957Y);
            for (Map<String, ? extends Object> map2 : list2) {
                JsonGet jsonGet2 = JsonGet.f15134a;
                arrayList3.add(new LatLng(Double.parseDouble(jsonGet2.m43760t(map2, UContent.f38072C)), Double.parseDouble(jsonGet2.m43760t(map2, UContent.f38073D))));
            }
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.addAll(arrayList3);
            polygonOptions.fillColor(ContextCompat.getColor(m38334h(), C4215R.C4217color.fill));
            polygonOptions.strokeColor(ContextCompat.getColor(m38334h(), C4215R.C4217color.stroke));
            polygonOptions.strokeWidth(4.0f);
            m38336f().addPolygon(polygonOptions);
            i = i2;
        }
        C5820a c5820a = new GeoFenceListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.a
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list3, int i3, String str) {
                V3GeoFenceObserver.m38337e(list3, i3, str);
            }
        };
        GeoFenceClient geoFenceClient2 = this.f20764d;
        if (geoFenceClient2 != null) {
            geoFenceClient2.setGeoFenceListener(c5820a);
        }
        GeoFenceClient geoFenceClient3 = this.f20764d;
        if (geoFenceClient3 != null) {
            geoFenceClient3.createPendingIntent(this.f20767g);
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(this.f20767g);
        this.f20766f = this.f20761a.registerReceiver(this.f20768h, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static final void m38337e(List list, int i, String str) {
        if (i == 0) {
            C11792j.m20469d("添加跑步范围围栏成功!!", new Object[0]);
        } else {
            C11792j.m20469d("添加跑步范围围栏失败!!", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public final void m38331k(boolean z) {
        List<Integer> m12467P;
        List<Integer> m12467P2;
        iOSOneButtonDialog iosonebuttondialog = null;
        if (z && this.f20769i) {
            C11792j.m20469d("ActionStatus=在地理围栏里面", new Object[0]);
            SportsDataAgent.f19899a.m39287T(false);
            VoiceSpeaker m39665e = VoiceSpeaker.m39665e();
            FragmentActivity fragmentActivity = this.f20761a;
            m12467P2 = CollectionsKt__CollectionsKt.m12467P(Integer.valueOf((int) C4215R.raw.geofence_in));
            m39665e.m39656n(fragmentActivity, m12467P2);
            iOSOneButtonDialog iosonebuttondialog2 = this.f20770j;
            if (iosonebuttondialog2 != null) {
                if (!iosonebuttondialog2.isShowing()) {
                    Activity m57773q = AppManager.m57776n().m57773q();
                    if (m57773q != null) {
                        if (m57773q instanceof V3ThreeTwoOneActivity) {
                            Activity m57772r = AppManager.m57776n().m57772r();
                            if (m57772r != null) {
                                iosonebuttondialog = ContextExt.m43851m(m57772r, "您已进入跑步规定区域，跑步已恢复，请继续进行跑步！");
                            }
                        } else {
                            iosonebuttondialog = ContextExt.m43851m(m57773q, "您已进入跑步规定区域，跑步已恢复，请继续进行跑步！");
                        }
                        this.f20770j = iosonebuttondialog;
                    }
                    V3NotificationManager.C5826a.m38267f(V3NotificationManager.f20856a, m38334h(), "您已进入跑步规定区域，跑步已恢复，请继续进行跑步！", false, 4, null);
                } else {
                    iosonebuttondialog2.dismiss();
                }
            }
        } else if (!z && !this.f20769i) {
            C11792j.m20469d("ActionStatus=在地理围栏外面", new Object[0]);
            SportsDataAgent.f19899a.m39287T(true);
            VoiceSpeaker m39665e2 = VoiceSpeaker.m39665e();
            FragmentActivity fragmentActivity2 = this.f20761a;
            m12467P = CollectionsKt__CollectionsKt.m12467P(Integer.valueOf((int) C4215R.raw.geofence_out));
            m39665e2.m39656n(fragmentActivity2, m12467P);
            Object systemService = this.f20761a.getSystemService("vibrator");
            if (systemService != null) {
                ((Vibrator) systemService).vibrate(2000L);
                iOSOneButtonDialog iosonebuttondialog3 = this.f20770j;
                if (iosonebuttondialog3 != null) {
                    iosonebuttondialog3.dismiss();
                }
                Activity m57773q2 = AppManager.m57776n().m57773q();
                if (m57773q2 != null) {
                    if (m57773q2 instanceof V3ThreeTwoOneActivity) {
                        Activity m57772r2 = AppManager.m57776n().m57772r();
                        if (m57772r2 != null) {
                            iosonebuttondialog = ContextExt.m43851m(m57772r2, "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！");
                        }
                    } else {
                        iosonebuttondialog = ContextExt.m43851m(m57773q2, "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！");
                    }
                    this.f20770j = iosonebuttondialog;
                }
                V3NotificationManager.C5826a.m38267f(V3NotificationManager.f20856a, this.f20761a, "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！", false, 4, null);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
            }
        }
        this.f20769i = !z;
    }

    @NotNull
    /* renamed from: f */
    public final AMap m38336f() {
        return this.f20763c;
    }

    @NotNull
    /* renamed from: g */
    public final String m38335g() {
        return this.f20767g;
    }

    @NotNull
    /* renamed from: h */
    public final FragmentActivity m38334h() {
        return this.f20761a;
    }

    @NotNull
    /* renamed from: i */
    public final SportsVM m38333i() {
        return this.f20762b;
    }

    /* renamed from: j */
    public final void m38332j(@NotNull SportsVM sportsVM) {
        C14342f0.m8184p(sportsVM, "<set-?>");
        this.f20762b = sportsVM;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        GeoFenceClient geoFenceClient = new GeoFenceClient(this.f20761a);
        geoFenceClient.setActivateAction(3);
        Unit unit = Unit.f41048a;
        this.f20764d = geoFenceClient;
        C11792j.m20469d(C14342f0.m8216C("V3GeoFenceObserver->mViewModel.sportsSetMap=", this.f20762b.m38035B()), new Object[0]);
        if (this.f20762b.m38035B().containsKey("geofence")) {
            JsonGet jsonGet = JsonGet.f15134a;
            m38338d(jsonGet.m43755y(jsonGet.m43760t(this.f20762b.m38035B(), "geofence")));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        GeoFenceClient geoFenceClient = this.f20764d;
        if (geoFenceClient != null) {
            C14342f0.m8187m(geoFenceClient);
            geoFenceClient.removeGeoFence();
        }
        if (this.f20766f != null) {
            this.f20761a.unregisterReceiver(this.f20768h);
        }
    }
}
