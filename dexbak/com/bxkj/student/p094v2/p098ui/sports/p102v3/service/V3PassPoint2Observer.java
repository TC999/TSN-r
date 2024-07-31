package com.bxkj.student.p094v2.p098ui.sports.p102v3.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.utils.Tools;
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
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.App;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.data.SportsPermission;
import com.bxkj.student.p094v2.common.utils.C5541e;
import com.bxkj.student.p094v2.p103vm.sports.SportsVM;
import com.bxkj.student.run.app.utils.VoiceSpeaker;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import io.netty.handler.codec.rtsp.RtspHeaders;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections._Collections;
import kotlin.comparisons.Comparisons;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p618m.StartActivityForResult;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/* compiled from: V3PassPoint2Observer.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020\"¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0007J\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\u0002H\u0007R\u0017\u0010\u001b\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010/R(\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010/R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00102R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00102R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00106¨\u0006:"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f1;", "k", "", "", "", "", "list", "c", "currentPoint", "", "f", "remark", C7304t.f25048d, "", "currentSort", "e", "onCreate", "j", "d", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "g", "()Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "b", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "i", "()Lcom/bxkj/student/v2/vm/sports/SportsVM;", "mViewModel", "Lcom/amap/api/maps/MapView;", "Lcom/amap/api/maps/MapView;", "h", "()Lcom/amap/api/maps/MapView;", "mMapView", "Lcom/amap/api/maps/AMap;", "Lcom/amap/api/maps/AMap;", "aMap", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "fenceLatLngBoundsBuilder", "", "Lcom/amap/api/maps/model/Marker;", "Ljava/util/List;", "markerList", "pointList", "Z", "isSequencePoint", "isRegister", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mGeoFenceReceiver", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/bxkj/student/v2/vm/sports/SportsVM;Lcom/amap/api/maps/MapView;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class V3PassPoint2Observer implements LifecycleObserver {
    @NotNull

    /* renamed from: a */
    private final FragmentActivity f20826a;
    @NotNull

    /* renamed from: b */
    private final SportsVM f20827b;
    @NotNull

    /* renamed from: c */
    private final MapView f20828c;
    @NotNull

    /* renamed from: d */
    private final AMap f20829d;
    @Nullable

    /* renamed from: e */
    private LatLngBounds.Builder f20830e;
    @NotNull

    /* renamed from: f */
    private final List<Marker> f20831f;
    @NotNull

    /* renamed from: g */
    private List<Map<String, Object>> f20832g;

    /* renamed from: h */
    private boolean f20833h;

    /* renamed from: i */
    private boolean f20834i;
    @NotNull

    /* renamed from: j */
    private final BroadcastReceiver f20835j;

    /* compiled from: V3PassPoint2Observer.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5814a implements StartActivityForResult.InterfaceC15293a {

        /* renamed from: b */
        final /* synthetic */ Ref.ObjectRef<File> f20837b;

        /* renamed from: c */
        final /* synthetic */ String f20838c;

        /* compiled from: V3PassPoint2Observer.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer$a$a", "Ltop/zibin/luban/d;", "Lkotlin/f1;", "onStart", "Ljava/io/File;", IDataSource.f43973c, "onSuccess", "", "e", "onError", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5815a implements OnCompressListener {

            /* renamed from: a */
            final /* synthetic */ File f20839a;

            /* renamed from: b */
            final /* synthetic */ V3PassPoint2Observer f20840b;

            /* renamed from: c */
            final /* synthetic */ String f20841c;

            /* compiled from: V3PassPoint2Observer.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$a$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            static final class C5816a extends Lambda implements InterfaceC15269a<Unit> {

                /* renamed from: a */
                final /* synthetic */ File f20842a;

                /* renamed from: b */
                final /* synthetic */ V3PassPoint2Observer f20843b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C5816a(File file, V3PassPoint2Observer v3PassPoint2Observer) {
                    super(0);
                    this.f20842a = file;
                    this.f20843b = v3PassPoint2Observer;
                }

                @Override // p617l1.InterfaceC15269a
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    File file = this.f20842a;
                    if (!file.exists()) {
                        file = null;
                    }
                    if (file != null) {
                        this.f20842a.delete();
                    }
                    ContextExt.m43847q(this.f20843b.m38279g(), "打卡识别拍照图片已上传成功！");
                }
            }

            C5815a(File file, V3PassPoint2Observer v3PassPoint2Observer, String str) {
                this.f20839a = file;
                this.f20840b = v3PassPoint2Observer;
                this.f20841c = str;
            }

            @Override // top.zibin.luban.OnCompressListener
            public void onError(@Nullable Throwable th) {
            }

            @Override // top.zibin.luban.OnCompressListener
            public void onStart() {
            }

            @Override // top.zibin.luban.OnCompressListener
            public void onSuccess(@NotNull File file) {
                C14342f0.m8184p(file, "file");
                File file2 = this.f20839a;
                if (!file2.exists()) {
                    file2 = null;
                }
                if (file2 != null) {
                    this.f20839a.delete();
                }
                this.f20840b.m38277i().m38033D(JsonGet.f15134a.m43760t(this.f20840b.m38277i().m38035B(), "identify"), this.f20841c, file, new C5816a(file, this.f20840b));
            }
        }

        C5814a(Ref.ObjectRef<File> objectRef, String str) {
            this.f20837b = objectRef;
            this.f20838c = str;
        }

        @Override // p618m.StartActivityForResult.InterfaceC15293a
        /* renamed from: a */
        public void mo3459a(int i, @Nullable Intent intent) {
            if (i == -1) {
                if (V3PassPoint2Observer.this.m38276j()) {
                    File file = new File(this.f20837b.element.getPath());
                    Luban.m288k(V3PassPoint2Observer.this.m38279g()).m282f(file).m280h(new C5815a(file, V3PassPoint2Observer.this, this.f20838c)).m283e();
                    return;
                }
                ContextExt.m43846r(V3PassPoint2Observer.this.m38279g(), "未找到存储卡，无法存储照片！");
            }
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5817b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            JsonGet jsonGet = JsonGet.f15134a;
            m8803g = Comparisons.m8803g(Integer.valueOf(jsonGet.m43769k((Map) t, "sort")), Integer.valueOf(jsonGet.m43769k((Map) t2, "sort")));
            return m8803g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3PassPoint2Observer.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5818c extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {

        /* renamed from: b */
        final /* synthetic */ String f20845b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: V3PassPoint2Observer.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5819a extends Lambda implements InterfaceC15269a<Unit> {

            /* renamed from: a */
            final /* synthetic */ V3PassPoint2Observer f20846a;

            /* renamed from: b */
            final /* synthetic */ String f20847b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5819a(V3PassPoint2Observer v3PassPoint2Observer, String str) {
                super(0);
                this.f20846a = v3PassPoint2Observer;
                this.f20847b = str;
            }

            @Override // p617l1.InterfaceC15269a
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.f20846a.m38282d(this.f20847b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5818c(String str) {
            super(1);
            this.f20845b = str;
        }

        /* renamed from: a */
        public final void m38273a(@NotNull iOSOneButtonDialog it) {
            C14342f0.m8184p(it, "it");
            PermissionExt.m43841c(V3PassPoint2Observer.this.m38279g(), "打卡点请拍照", new C5819a(V3PassPoint2Observer.this, this.f20845b));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
            m38273a(iosonebuttondialog);
            return Unit.f41048a;
        }
    }

    public V3PassPoint2Observer(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull MapView mMapView) {
        C14342f0.m8184p(mActivity, "mActivity");
        C14342f0.m8184p(mViewModel, "mViewModel");
        C14342f0.m8184p(mMapView, "mMapView");
        this.f20826a = mActivity;
        this.f20827b = mViewModel;
        this.f20828c = mMapView;
        AMap map = mMapView.getMap();
        C14342f0.m8185o(map, "mMapView.map");
        this.f20829d = map;
        this.f20831f = new ArrayList();
        this.f20832g = new ArrayList();
        this.f20835j = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$mGeoFenceReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                List list;
                List<Map<String, ? extends Object>> list2;
                List list3;
                boolean m38280f;
                C14342f0.m8184p(context, "context");
                C14342f0.m8184p(intent, "intent");
                list = V3PassPoint2Observer.this.f20832g;
                if (list.isEmpty()) {
                    V3PassPoint2Observer.this.onDestroy();
                } else if (intent.hasExtra("newLocationPoint")) {
                    LatLng latLng = (LatLng) intent.getParcelableExtra("newLocationPoint");
                    ArrayList arrayList = new ArrayList();
                    list2 = V3PassPoint2Observer.this.f20832g;
                    V3PassPoint2Observer v3PassPoint2Observer = V3PassPoint2Observer.this;
                    for (Map<String, ? extends Object> map2 : list2) {
                        JsonGet jsonGet = JsonGet.f15134a;
                        if (AMapUtils.calculateLineDistance(new LatLng(jsonGet.m43774f(map2, "latitude"), jsonGet.m43774f(map2, "longitude")), latLng) <= jsonGet.m43771i(map2, "okRadius")) {
                            m38280f = v3PassPoint2Observer.m38280f(map2);
                            if (m38280f) {
                                arrayList.add(map2);
                            }
                        }
                    }
                    list3 = V3PassPoint2Observer.this.f20832g;
                    if (list3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    }
                    TypeIntrinsics.m8026a(list3).removeAll(arrayList);
                }
            }
        };
    }

    /* renamed from: c */
    private final void m38283c(List<? extends Map<String, ? extends Object>> list) {
        for (Map<String, ? extends Object> map : list) {
            JsonGet jsonGet = JsonGet.f15134a;
            LatLng latLng = new LatLng(jsonGet.m43774f(map, "latitude"), jsonGet.m43774f(map, "longitude"));
            Marker marker = this.f20829d.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(C5541e.f20105a.m39137a(this.f20833h ? jsonGet.m43760t(map, "sort") : "经"))).zIndex(9.0f).title("你还未通过" + (this.f20833h ? (char) 31532 + jsonGet.m43760t(map, "sort") + (char) 20010 : "") + "必经点：" + jsonGet.m43760t(map, "content")).draggable(false));
            marker.setObject(jsonGet.m43760t(map, "id"));
            List<Marker> list2 = this.f20831f;
            C14342f0.m8185o(marker, "marker");
            list2.add(marker);
            this.f20830e = LatLngBounds.builder().include(latLng);
        }
        AMap aMap = this.f20829d;
        LatLngBounds.Builder builder = this.f20830e;
        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder == null ? null : builder.build(), Tools.m57620a(10.0f, this.f20826a)), 2000L, null);
        this.f20826a.registerReceiver(this.f20835j, new IntentFilter(C14342f0.m8216C(App.m43006n().getPackageName(), ".run")), SportsPermission.f19933b, null);
        this.f20834i = true;
    }

    /* renamed from: e */
    private final void m38281e(int i) {
        Object obj;
        boolean z;
        Iterator<T> it = this.f20832g.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (JsonGet.f15134a.m43769k((Map) obj, "sort") == i + 1) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Map<String, ? extends Object> map = (Map) obj;
        PointData m39272e = SportsDataAgent.f19899a.m39272e();
        if (m39272e == null || map == null) {
            return;
        }
        LatLng latLng = new LatLng(m39272e.getA(), m39272e.getO());
        JsonGet jsonGet = JsonGet.f15134a;
        if ((AMapUtils.calculateLineDistance(new LatLng(jsonGet.m43774f(map, "latitude"), jsonGet.m43774f(map, "longitude")), latLng) <= jsonGet.m43771i(map, "okRadius") ? map : null) == null) {
            return;
        }
        m38280f(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public final boolean m38280f(Map<String, ? extends Object> map) {
        Object obj;
        Object obj2;
        String str;
        List<Integer> m12467P;
        Object obj3;
        boolean z;
        String m43760t = JsonGet.f15134a.m43760t(map, "id");
        Iterator<T> it = SportsDataAgent.f19899a.m39253s().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (C14342f0.m8193g(JsonGet.f15134a.m43760t((Map) obj, "id"), m43760t)) {
                break;
            }
        }
        if (((Map) obj) != null) {
            return false;
        }
        if (this.f20833h) {
            int m43769k = JsonGet.f15134a.m43769k(map, "sort");
            Iterator<T> it2 = SportsDataAgent.f19899a.m39253s().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it2.next();
                if (JsonGet.f15134a.m43769k((Map) obj3, "sort") == m43769k - 1) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            Map map2 = (Map) obj3;
            if (m43769k > 1 && map2 == null) {
                return false;
            }
        }
        Iterator<T> it3 = this.f20831f.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            Object object = ((Marker) obj2).getObject();
            if (C14342f0.m8193g(m43760t, object == null ? null : object.toString())) {
                break;
            }
        }
        Marker marker = (Marker) obj2;
        if (marker == null) {
            return false;
        }
        this.f20831f.remove(marker);
        marker.setVisible(false);
        marker.remove();
        marker.destroy();
        m38278h().postInvalidate();
        String m43760t2 = this.f20833h ? JsonGet.f15134a.m43760t(map, "sort") : "√";
        if (this.f20833h) {
            str = (char) 31532 + JsonGet.f15134a.m43760t(map, "sort") + (char) 20010;
        } else {
            str = "";
        }
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(C5541e.f20105a.m39136b(m43760t2));
        JsonGet jsonGet = JsonGet.f15134a;
        double m43774f = jsonGet.m43774f(map, "latitude");
        double m43774f2 = jsonGet.m43774f(map, "longitude");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String m43760t3 = jsonGet.m43760t(map, "content");
        String m43760t4 = jsonGet.m43760t(map, "sort");
        MarkerOptions draggable = new MarkerOptions().position(new LatLng(m43774f, m43774f2)).icon(fromBitmap).zIndex(10.0f).title("你已经通过" + str + "必经点:" + m43760t3).draggable(false);
        HashMap hashMap = new HashMap();
        hashMap.put("id", m43760t);
        String format = simpleDateFormat.format(new Date());
        C14342f0.m8185o(format, "simpleDateFormat.format(Date())");
        hashMap.put(RtspHeaders.Values.TIME, format);
        hashMap.put("content", m43760t3);
        hashMap.put("latitude", Double.valueOf(m43774f));
        hashMap.put("longitude", Double.valueOf(m43774f2));
        hashMap.put("sort", m43760t4);
        C11792j.m20469d(draggable.getTitle(), new Object[0]);
        this.f20829d.addMarker(draggable);
        VoiceSpeaker m39665e = VoiceSpeaker.m39665e();
        FragmentActivity m38279g = m38279g();
        m12467P = CollectionsKt__CollectionsKt.m12467P(Integer.valueOf((int) C4215R.raw.pass_asses));
        m39665e.m39656n(m38279g, m12467P);
        SportsDataAgent.f19899a.m39253s().add(hashMap);
        FragmentActivity m38279g2 = m38279g();
        String title = draggable.getTitle();
        C14342f0.m8185o(title, "endOptions.title");
        ContextExt.m43847q(m38279g2, title);
        if ((C14342f0.m8193g(jsonGet.m43760t(m38277i().m38035B(), "takePicture"), "1") ? this : null) != null) {
            m38274l(m43760t3);
        }
        if (this.f20833h) {
            m38281e(jsonGet.m43769k(map, "sort"));
            return true;
        }
        return true;
    }

    /* renamed from: k */
    private final void m38275k() {
        String str;
        Object obj;
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        C11792j.m20469d(C14342f0.m8216C("恢复已经过的必经点", c5481g.m39253s()), new Object[0]);
        Iterator<T> it = c5481g.m39253s().iterator();
        while (it.hasNext()) {
            Map<String, ? extends Object> map = (Map) it.next();
            String m43760t = this.f20833h ? JsonGet.f15134a.m43760t(map, "sort") : "√";
            if (this.f20833h) {
                str = (char) 31532 + JsonGet.f15134a.m43760t(map, "sort") + (char) 20010;
            } else {
                str = "";
            }
            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(C5541e.f20105a.m39136b(m43760t));
            JsonGet jsonGet = JsonGet.f15134a;
            this.f20829d.addMarker(new MarkerOptions().position(new LatLng(jsonGet.m43774f(map, "latitude"), jsonGet.m43774f(map, "longitude"))).icon(fromBitmap).zIndex(10.0f).title("你已经通过" + str + "必经点:" + jsonGet.m43760t(map, "content")).draggable(false));
            Iterator<T> it2 = this.f20832g.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                JsonGet jsonGet2 = JsonGet.f15134a;
                if (C14342f0.m8193g(jsonGet2.m43760t((Map) obj, "id"), jsonGet2.m43760t(map, "id"))) {
                    break;
                }
            }
            Map map2 = (Map) obj;
            if (map2 != null) {
                this.f20832g.remove(map2);
            }
        }
    }

    /* renamed from: l */
    private final void m38274l(String str) {
        ContextExt.m43850n(this.f20826a, "您已经过打卡点请拍照", new C5818c(str));
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.io.File] */
    /* renamed from: d */
    public final void m38282d(@NotNull String remark) {
        Uri uriForFile;
        C14342f0.m8184p(remark, "remark");
        if (m38276j()) {
            File externalCacheDir = C14342f0.m8193g("mounted", Environment.getExternalStorageState()) ? this.f20826a.getExternalCacheDir() : null;
            if ((externalCacheDir == null ? this : null) != null) {
                externalCacheDir = m38279g().getCacheDir();
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
                C14342f0.m8185o(uriForFile, "{\n                Uri.fr…e(tempFile)\n            }");
            } else {
                File file5 = (File) file3;
                uriForFile = FileProvider.getUriForFile(this.f20826a, "com.bxkj.student.provider", file3);
                C14342f0.m8185o(uriForFile, "{\n                FilePr…          )\n            }");
            }
            Intent intent = new Intent();
            intent.putExtra("output", uriForFile);
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.addFlags(1);
            intent.addCategory("android.intent.category.DEFAULT");
            new StartActivityForResult(this.f20826a).startActivityForResult(intent).m3460c(new C5814a(objectRef, remark));
            return;
        }
        Toast.makeText(this.f20826a, "未找到存储卡，无法拍照！", 0).show();
    }

    @NotNull
    /* renamed from: g */
    public final FragmentActivity m38279g() {
        return this.f20826a;
    }

    @NotNull
    /* renamed from: h */
    public final MapView m38278h() {
        return this.f20828c;
    }

    @NotNull
    /* renamed from: i */
    public final SportsVM m38277i() {
        return this.f20827b;
    }

    /* renamed from: j */
    public final boolean m38276j() {
        return C14342f0.m8193g(Environment.getExternalStorageState(), "mounted");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        List<Map<String, Object>> m12218L5;
        List<? extends Map<String, ? extends Object>> m12115h5;
        Object obj;
        JsonGet jsonGet = JsonGet.f15134a;
        m12218L5 = _Collections.m12218L5(jsonGet.m43766n(this.f20827b.m38035B(), "list"));
        this.f20832g = m12218L5;
        this.f20833h = C14342f0.m8193g("1", jsonGet.m43760t(this.f20827b.m38035B(), "isSequencePoint"));
        List<Map<String, Object>> list = this.f20832g;
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list == null) {
            return;
        }
        m38275k();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            Map<String, ? extends Object> map = (Map) obj2;
            Iterator<T> it = SportsDataAgent.f19899a.m39253s().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                JsonGet jsonGet2 = JsonGet.f15134a;
                if (C14342f0.m8193g(jsonGet2.m43760t((Map) obj, "id"), jsonGet2.m43760t(map, "id"))) {
                    break;
                }
            }
            if (obj == null) {
                arrayList.add(obj2);
            }
        }
        m12115h5 = _Collections.m12115h5(arrayList, new C5817b());
        m38283c(m12115h5);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f20835j;
        if (!this.f20834i) {
            broadcastReceiver = null;
        }
        if (broadcastReceiver == null) {
            return;
        }
        this.f20834i = false;
        m38279g().unregisterReceiver(broadcastReceiver);
    }
}
