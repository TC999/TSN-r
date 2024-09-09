package com.bxkj.student.v2.ui.sports.v3.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.student.App;
import com.bxkj.student.run.app.utils.d0;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.c;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.orhanobut.logger.j;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: V3PassPoint2Observer.kt */
@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020\"\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0007J\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\u0002H\u0007R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010/R(\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010/R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00102R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00102R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00106\u00a8\u0006:"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f1;", "k", "", "", "", "", "list", "c", "currentPoint", "", "f", "remark", "l", "", "currentSort", "e", "onCreate", "j", "d", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "g", "()Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "b", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "i", "()Lcom/bxkj/student/v2/vm/sports/SportsVM;", "mViewModel", "Lcom/amap/api/maps/MapView;", "Lcom/amap/api/maps/MapView;", "h", "()Lcom/amap/api/maps/MapView;", "mMapView", "Lcom/amap/api/maps/AMap;", "Lcom/amap/api/maps/AMap;", "aMap", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "fenceLatLngBoundsBuilder", "", "Lcom/amap/api/maps/model/Marker;", "Ljava/util/List;", "markerList", "pointList", "Z", "isSequencePoint", "isRegister", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mGeoFenceReceiver", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/bxkj/student/v2/vm/sports/SportsVM;Lcom/amap/api/maps/MapView;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class V3PassPoint2Observer implements LifecycleObserver {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FragmentActivity f24245a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SportsVM f24246b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final MapView f24247c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final AMap f24248d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds.Builder f24249e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final List<Marker> f24250f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private List<Map<String, Object>> f24251g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24252h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24253i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final BroadcastReceiver f24254j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3PassPoint2Observer.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements b.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<File> f24256b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24257c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3PassPoint2Observer.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer$a$a", "Ltop/zibin/luban/d;", "Lkotlin/f1;", "onStart", "Ljava/io/File;", "file", "onSuccess", "", "e", "onError", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0321a implements top.zibin.luban.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ File f24258a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ V3PassPoint2Observer f24259b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f24260c;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* compiled from: V3PassPoint2Observer.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            static final class C0322a extends Lambda implements l1.a<f1> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ File f24261a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ V3PassPoint2Observer f24262b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0322a(File file, V3PassPoint2Observer v3PassPoint2Observer) {
                    super(0);
                    this.f24261a = file;
                    this.f24262b = v3PassPoint2Observer;
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m82invoke();
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m82invoke() {
                    File file = this.f24261a;
                    if (!file.exists()) {
                        file = null;
                    }
                    if (file != null) {
                        this.f24261a.delete();
                    }
                    ContextExtKt.q(this.f24262b.g(), "\u6253\u5361\u8bc6\u522b\u62cd\u7167\u56fe\u7247\u5df2\u4e0a\u4f20\u6210\u529f\uff01");
                }
            }

            C0321a(File file, V3PassPoint2Observer v3PassPoint2Observer, String str) {
                this.f24258a = file;
                this.f24259b = v3PassPoint2Observer;
                this.f24260c = str;
            }

            @Override // top.zibin.luban.d
            public void onError(@Nullable Throwable th) {
            }

            @Override // top.zibin.luban.d
            public void onStart() {
            }

            @Override // top.zibin.luban.d
            public void onSuccess(@NotNull File file) {
                f0.p(file, "file");
                File file2 = this.f24258a;
                if (!file2.exists()) {
                    file2 = null;
                }
                if (file2 != null) {
                    this.f24258a.delete();
                }
                this.f24259b.i().D(l.f18624a.t(this.f24259b.i().B(), "identify"), this.f24260c, file, new C0322a(file, this.f24259b));
            }
        }

        a(Ref.ObjectRef<File> objectRef, String str) {
            this.f24256b = objectRef;
            this.f24257c = str;
        }

        @Override // m.b.a
        public void a(int i4, @Nullable Intent intent) {
            if (i4 == -1) {
                if (V3PassPoint2Observer.this.j()) {
                    File file = new File(this.f24256b.element.getPath());
                    top.zibin.luban.c.k(V3PassPoint2Observer.this.g()).f(file).h(new C0321a(file, V3PassPoint2Observer.this, this.f24257c)).e();
                    return;
                }
                ContextExtKt.r(V3PassPoint2Observer.this.g(), "\u672a\u627e\u5230\u5b58\u50a8\u5361\uff0c\u65e0\u6cd5\u5b58\u50a8\u7167\u7247\uff01");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            l lVar = l.f18624a;
            g4 = kotlin.comparisons.b.g(Integer.valueOf(lVar.k((Map) t3, "sort")), Integer.valueOf(lVar.k((Map) t4, "sort")));
            return g4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3PassPoint2Observer.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends Lambda implements l1.l<iOSOneButtonDialog, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24264b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3PassPoint2Observer.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a extends Lambda implements l1.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3PassPoint2Observer f24265a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f24266b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(V3PassPoint2Observer v3PassPoint2Observer, String str) {
                super(0);
                this.f24265a = v3PassPoint2Observer;
                this.f24266b = str;
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m83invoke();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m83invoke() {
                this.f24265a.d(this.f24266b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.f24264b = str;
        }

        public final void a(@NotNull iOSOneButtonDialog it) {
            f0.p(it, "it");
            com.bxkj.base.v2.common.ext.g.c(V3PassPoint2Observer.this.g(), "\u6253\u5361\u70b9\u8bf7\u62cd\u7167", new a(V3PassPoint2Observer.this, this.f24264b));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
            a(iosonebuttondialog);
            return f1.f55527a;
        }
    }

    public V3PassPoint2Observer(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull MapView mMapView) {
        f0.p(mActivity, "mActivity");
        f0.p(mViewModel, "mViewModel");
        f0.p(mMapView, "mMapView");
        this.f24245a = mActivity;
        this.f24246b = mViewModel;
        this.f24247c = mMapView;
        AMap map = mMapView.getMap();
        f0.o(map, "mMapView.map");
        this.f24248d = map;
        this.f24250f = new ArrayList();
        this.f24251g = new ArrayList();
        this.f24254j = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$mGeoFenceReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                List list;
                List<Map<String, ? extends Object>> list2;
                List list3;
                boolean f4;
                f0.p(context, "context");
                f0.p(intent, "intent");
                list = V3PassPoint2Observer.this.f24251g;
                if (list.isEmpty()) {
                    V3PassPoint2Observer.this.onDestroy();
                } else if (intent.hasExtra("newLocationPoint")) {
                    LatLng latLng = (LatLng) intent.getParcelableExtra("newLocationPoint");
                    ArrayList arrayList = new ArrayList();
                    list2 = V3PassPoint2Observer.this.f24251g;
                    V3PassPoint2Observer v3PassPoint2Observer = V3PassPoint2Observer.this;
                    for (Map<String, ? extends Object> map2 : list2) {
                        l lVar = l.f18624a;
                        if (AMapUtils.calculateLineDistance(new LatLng(lVar.f(map2, "latitude"), lVar.f(map2, "longitude")), latLng) <= lVar.i(map2, "okRadius")) {
                            f4 = v3PassPoint2Observer.f(map2);
                            if (f4) {
                                arrayList.add(map2);
                            }
                        }
                    }
                    list3 = V3PassPoint2Observer.this.f24251g;
                    if (list3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    }
                    t0.a(list3).removeAll(arrayList);
                }
            }
        };
    }

    private final void c(List<? extends Map<String, ? extends Object>> list) {
        String str;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            m mVar = m.a;
            LatLng latLng = new LatLng(mVar.f(map, "latitude"), mVar.f(map, "longitude"));
            String t3 = this.f24252h ? mVar.t(map, "sort") : "\u7ecf";
            if (this.f24252h) {
                str = '\u7b2c' + mVar.t(map, "sort") + '\u4e2a';
            } else {
                str = "";
            }
            Marker marker = this.f24248d.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.e.f23349a.b(t3))).zIndex(9.0f).title("\u4f60\u8fd8\u672a\u901a\u8fc7" + str + "\u5fc5\u7ecf\u70b9\uff1a" + mVar.t(map, "content")).draggable(false));
            marker.setObject(mVar.t(map, "id"));
            List<Marker> list2 = this.f24250f;
            f0.o(marker, "marker");
            list2.add(marker);
            this.f24249e = LatLngBounds.builder().include(latLng);
        }
        AMap aMap = this.f24248d;
        LatLngBounds.Builder builder = this.f24249e;
        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder == null ? null : builder.build(), u.a(10.0f, this.f24245a)), 2000L, null);
        this.f24245a.registerReceiver(this.f24254j, new IntentFilter(f0.C(App.n().getPackageName(), ".run")), "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST", null);
        this.f24253i = true;
    }

    private final void e(int i4) {
        Object obj;
        boolean z3;
        Iterator<T> it = this.f24251g.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (m.a.k((Map) obj, "sort") == i4 + 1) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        Map<String, ? extends Object> map = (Map) obj;
        PointData e4 = com.bxkj.student.v2.common.data.c.f23133a.e();
        if (e4 == null || map == null) {
            return;
        }
        LatLng latLng = new LatLng(e4.getA(), e4.getO());
        m mVar = m.a;
        if ((AMapUtils.calculateLineDistance(new LatLng(mVar.f(map, "latitude"), mVar.f(map, "longitude")), latLng) <= mVar.i(map, "okRadius") ? map : null) == null) {
            return;
        }
        f(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(Map<String, ? extends Object> map) {
        Object obj;
        Object obj2;
        String str;
        List<Integer> Q;
        Object obj3;
        boolean z3;
        String t3 = m.a.t(map, "id");
        Iterator<T> it = com.bxkj.student.v2.common.data.c.f23133a.s().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (f0.g(m.a.t((Map) obj, "id"), t3)) {
                break;
            }
        }
        if (((Map) obj) != null) {
            return false;
        }
        if (this.f24252h) {
            int k4 = m.a.k(map, "sort");
            Iterator<T> it2 = com.bxkj.student.v2.common.data.c.f23133a.s().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it2.next();
                if (m.a.k((Map) obj3, "sort") == k4 - 1) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    break;
                }
            }
            Map map2 = (Map) obj3;
            if (k4 > 1 && map2 == null) {
                return false;
            }
        }
        Iterator<T> it3 = this.f24250f.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            Object object = ((Marker) obj2).getObject();
            if (f0.g(t3, object == null ? null : object.toString())) {
                break;
            }
        }
        Marker marker = (Marker) obj2;
        if (marker == null) {
            return false;
        }
        this.f24250f.remove(marker);
        marker.setVisible(false);
        marker.remove();
        marker.destroy();
        h().postInvalidate();
        String t4 = this.f24252h ? m.a.t(map, "sort") : "\u221a";
        if (this.f24252h) {
            str = '\u7b2c' + m.a.t(map, "sort") + '\u4e2a';
        } else {
            str = "";
        }
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.e.f23349a.c(t4));
        m mVar = m.a;
        double f4 = mVar.f(map, "latitude");
        double f5 = mVar.f(map, "longitude");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String t5 = mVar.t(map, "content");
        String t6 = mVar.t(map, "sort");
        MarkerOptions draggable = new MarkerOptions().position(new LatLng(f4, f5)).icon(fromBitmap).zIndex(10.0f).title("\u4f60\u5df2\u7ecf\u901a\u8fc7" + str + "\u5fc5\u7ecf\u70b9:" + t5).draggable(false);
        HashMap hashMap = new HashMap();
        hashMap.put("id", t3);
        String format = simpleDateFormat.format(new Date());
        f0.o(format, "simpleDateFormat.format(Date())");
        hashMap.put("time", format);
        hashMap.put("content", t5);
        hashMap.put("latitude", Double.valueOf(f4));
        hashMap.put("longitude", Double.valueOf(f5));
        hashMap.put("sort", t6);
        j.d(draggable.getTitle(), new Object[0]);
        this.f24248d.addMarker(draggable);
        d0 e4 = d0.e();
        FragmentActivity g4 = g();
        Q = CollectionsKt__CollectionsKt.Q(2131755097);
        e4.n(g4, Q);
        com.bxkj.student.v2.common.data.c.f23133a.s().add(hashMap);
        FragmentActivity g5 = g();
        String title = draggable.getTitle();
        f0.o(title, "endOptions.title");
        ContextExtKt.q(g5, title);
        if ((f0.g(mVar.t(i().D(), "takePicture"), "1") ? this : null) != null) {
            l(t5);
        }
        if (this.f24252h) {
            e(mVar.k(map, "sort"));
            return true;
        }
        return true;
    }

    private final void k() {
        String str;
        Object obj;
        c.g gVar = com.bxkj.student.v2.common.data.c.f23133a;
        j.d(f0.C("\u6062\u590d\u5df2\u7ecf\u8fc7\u7684\u5fc5\u7ecf\u70b9", gVar.s()), new Object[0]);
        Iterator<T> it = gVar.s().iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String t3 = this.f24252h ? m.a.t(map, "sort") : "\u221a";
            if (this.f24252h) {
                str = '\u7b2c' + m.a.t(map, "sort") + '\u4e2a';
            } else {
                str = "";
            }
            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.e.f23349a.c(t3));
            m mVar = m.a;
            this.f24248d.addMarker(new MarkerOptions().position(new LatLng(mVar.f(map, "latitude"), mVar.f(map, "longitude"))).icon(fromBitmap).zIndex(10.0f).title("\u4f60\u5df2\u7ecf\u901a\u8fc7" + str + "\u5fc5\u7ecf\u70b9:" + mVar.t(map, "content")).draggable(false));
            Iterator<T> it2 = this.f24251g.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                m mVar2 = m.a;
                if (f0.g(mVar2.t((Map) obj, "id"), mVar2.t(map, "id"))) {
                    break;
                }
            }
            Map map2 = (Map) obj;
            if (map2 != null) {
                this.f24251g.remove(map2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [d2.l, com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$c] */
    private final void l(String str) {
        ContextExtKt.n(this.f24245a, "\u60a8\u5df2\u7ecf\u8fc7\u6253\u5361\u70b9\u8bf7\u62cd\u7167", (d2.l) new c(str));
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.io.File] */
    public final void d(@NotNull String remark) {
        Uri uriForFile;
        f0.p(remark, "remark");
        if (j()) {
            File externalCacheDir = f0.g("mounted", Environment.getExternalStorageState()) ? this.f24245a.getExternalCacheDir() : null;
            if ((externalCacheDir == null ? this : null) != null) {
                externalCacheDir = g().getCacheDir();
            }
            if (externalCacheDir != null) {
                File file = externalCacheDir.exists() ^ true ? externalCacheDir : null;
                if (file != null) {
                    file.mkdirs();
                }
            }
            File file2 = new File(externalCacheDir, "avatar");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? file3 = new File(file2, System.currentTimeMillis() + "_temp_photo.jpg");
            objectRef.element = file3;
            if (Build.VERSION.SDK_INT < 24) {
                File file4 = (File) file3;
                uriForFile = Uri.fromFile(file3);
                f0.o(uriForFile, "{\n                Uri.fr\u2026e(tempFile)\n            }");
            } else {
                File file5 = (File) file3;
                uriForFile = FileProvider.getUriForFile(this.f24245a, "com.bxkj.student.provider", file3);
                f0.o(uriForFile, "{\n                FilePr\u2026          )\n            }");
            }
            Intent intent = new Intent();
            intent.putExtra("output", uriForFile);
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.addFlags(1);
            intent.addCategory("android.intent.category.DEFAULT");
            new m.b(this.f24245a).startActivityForResult(intent).c(new a(objectRef, remark));
            return;
        }
        Toast.makeText(this.f24245a, "\u672a\u627e\u5230\u5b58\u50a8\u5361\uff0c\u65e0\u6cd5\u62cd\u7167\uff01", 0).show();
    }

    @NotNull
    public final FragmentActivity g() {
        return this.f24245a;
    }

    @NotNull
    public final MapView h() {
        return this.f24247c;
    }

    @NotNull
    public final SportsVM i() {
        return this.f24246b;
    }

    public final boolean j() {
        return f0.g(Environment.getExternalStorageState(), "mounted");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        List<Map<String, Object>> J5;
        List<? extends Map<String, ? extends Object>> f5;
        Object obj;
        m mVar = m.a;
        J5 = kotlin.collections.f0.J5(mVar.n(this.f24246b.D(), "list"));
        this.f24251g = J5;
        this.f24252h = f0.g("1", mVar.t(this.f24246b.D(), "isSequencePoint"));
        List<Map<String, Object>> list = this.f24251g;
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list == null) {
            return;
        }
        k();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            Map map = (Map) obj2;
            Iterator<T> it = com.bxkj.student.v2.common.data.c.f23133a.s().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                m mVar2 = m.a;
                if (f0.g(mVar2.t((Map) obj, "id"), mVar2.t(map, "id"))) {
                    break;
                }
            }
            if (obj == null) {
                arrayList.add(obj2);
            }
        }
        f5 = kotlin.collections.f0.f5(arrayList, new b());
        c(f5);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f24254j;
        if (!this.f24253i) {
            broadcastReceiver = null;
        }
        if (broadcastReceiver == null) {
            return;
        }
        this.f24253i = false;
        g().unregisterReceiver(broadcastReceiver);
    }
}
