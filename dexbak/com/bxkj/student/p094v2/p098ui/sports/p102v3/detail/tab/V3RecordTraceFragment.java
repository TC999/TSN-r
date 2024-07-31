package com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.FmV3SportsTraceBinding;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bxkj.student.p094v2.common.utils.C5541e;
import com.bxkj.student.p094v2.common.utils.DrawMapLineManager;
import com.bxkj.student.p094v2.common.utils.SportsType;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.tab.V3RecordTraceFragment;
import com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM;
import com.bxkj.student.run.app.utils.PathSmoothToolOrigin;
import com.bxkj.student.run.app.utils.RecordPathAnimUtil;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.MBridgeConstans;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UContent;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.C14236x;
import kotlin.collections.C14239y0;
import kotlin.collections._Collections;
import kotlin.comparisons.Comparisons;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.C14361s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3RecordTraceFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b=\u0010>J*\u0010\n\u001a\u00020\t2 \u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u00040\u0004H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002JD\u0010\u0010\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010\u0012\u001a\u00020\t2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004H\u0002J@\u0010\u0013\u001a\u00020\t2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u00042\u001a\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u0019\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\tH\u0016J\u0006\u0010*\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020+R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001f\u0010:\u001a\n 5*\u0004\u0018\u000104048\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010<¨\u0006?"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/FmV3SportsTraceBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "", "", "", "", "it", "Lkotlin/f1;", "m", ExifInterface.LATITUDE_SOUTH, "pointList", "okPointList", "", "isSequencePoint", "H", "list", ExifInterface.GPS_DIRECTION_TRUE, "D", "", "size", "N", "Lcom/amap/api/maps/model/LatLng;", "latLngs", "Q", "Landroid/graphics/Bitmap;", "bitmap", "X", "src", "watermark", "P", ExifInterface.LONGITUDE_EAST, "p", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "outState", "onSaveInstanceState", "onResume", "onPause", "onDestroyView", ExifInterface.LONGITUDE_WEST, "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "O", "Lcom/amap/api/maps/AMap;", "j", "Lcom/amap/api/maps/AMap;", "aMap", "k", "Landroid/os/Bundle;", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "kotlin.jvm.PlatformType", C7304t.f25048d, "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "R", "()Lcom/amap/api/maps/model/LatLngBounds$Builder;", "latLngBoundsBuilder", "", "Ljava/util/List;", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RecordTraceFragment extends BaseFragment<FmV3SportsTraceBinding, RecordDetailVM> {
    @Nullable

    /* renamed from: j */
    private AMap f20689j;
    @Nullable

    /* renamed from: k */
    private Bundle f20690k;

    /* renamed from: l */
    private final LatLngBounds.Builder f20691l = LatLngBounds.builder();
    @NotNull

    /* renamed from: m */
    private List<LatLng> f20692m = new ArrayList();

    /* compiled from: Comparisons.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5767a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            JsonGet jsonGet = JsonGet.f15134a;
            m8803g = Comparisons.m8803g(Integer.valueOf(jsonGet.m43769k((Map) t, "sort")), Integer.valueOf(jsonGet.m43769k((Map) t2, "sort")));
            return m8803g;
        }
    }

    /* compiled from: V3RecordTraceFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment$b", "Lcom/amap/api/maps/AMap$OnCameraChangeListener;", "Lcom/amap/api/maps/model/CameraPosition;", "cameraPosition", "Lkotlin/f1;", "onCameraChange", "onCameraChangeFinish", "", "a", "Z", "isDrawFinish", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5768b implements AMap.OnCameraChangeListener {

        /* renamed from: a */
        private boolean f20693a;

        /* renamed from: c */
        final /* synthetic */ List<Map<String, Object>> f20695c;

        /* JADX WARN: Multi-variable type inference failed */
        C5768b(List<? extends Map<String, ? extends Object>> list) {
            this.f20695c = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static final void m38388b(V3RecordTraceFragment this$0, List finalList) {
            C14342f0.m8184p(this$0, "this$0");
            C14342f0.m8184p(finalList, "$finalList");
            this$0.mo43920M().map.setForeground(new ColorDrawable(ContextCompat.getColor(this$0.mo43926C(), 2131034508)));
            this$0.mo43920M().rpv.m39702e();
            this$0.mo43920M().rpv.setVisibility(8);
            this$0.m38412D(finalList, new ArrayList());
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChange(@NotNull CameraPosition cameraPosition) {
            C14342f0.m8184p(cameraPosition, "cameraPosition");
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChangeFinish(@NotNull CameraPosition cameraPosition) {
            C14342f0.m8184p(cameraPosition, "cameraPosition");
            if (this.f20693a) {
                return;
            }
            int i = 1;
            this.f20693a = true;
            RecordPathAnimUtil recordPathAnimUtil = new RecordPathAnimUtil();
            int size = V3RecordTraceFragment.this.f20692m.size();
            if (1 < size) {
                while (true) {
                    int i2 = i + 1;
                    AMap aMap = V3RecordTraceFragment.this.f20689j;
                    C14342f0.m8187m(aMap);
                    Point screenLocation = aMap.getProjection().toScreenLocation((LatLng) V3RecordTraceFragment.this.f20692m.get(i - 1));
                    AMap aMap2 = V3RecordTraceFragment.this.f20689j;
                    C14342f0.m8187m(aMap2);
                    Point screenLocation2 = aMap2.getProjection().toScreenLocation((LatLng) V3RecordTraceFragment.this.f20692m.get(i));
                    int color = ContextCompat.getColor(V3RecordTraceFragment.this.mo43926C(), 2131034489);
                    recordPathAnimUtil.m39554a(screenLocation, screenLocation2, color, color);
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            V3RecordTraceFragment.this.mo43920M().rpv.setPath(recordPathAnimUtil);
            RecordPathView recordPathView = V3RecordTraceFragment.this.mo43920M().rpv;
            final V3RecordTraceFragment v3RecordTraceFragment = V3RecordTraceFragment.this;
            final List<Map<String, Object>> list = this.f20695c;
            recordPathView.setOnAnimEnd(new RecordPathView.InterfaceC5375d() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.i
                @Override // com.bxkj.student.run.app.utils.RecordPathView.InterfaceC5375d
                /* renamed from: a */
                public final void mo38387a() {
                    V3RecordTraceFragment.C5768b.m38388b(V3RecordTraceFragment.this, list);
                }
            });
        }
    }

    /* compiled from: JsonGet.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, m12616d2 = {"com/bxkj/base/v2/common/utils/l$d", "Lcom/google/gson/reflect/TypeToken;", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5769c extends TypeToken<List<? extends List<? extends Map<String, ? extends Object>>>> {
    }

    /* compiled from: V3RecordTraceFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment$d", "Lcom/amap/api/maps/AMap$OnMapScreenShotListener;", "Landroid/graphics/Bitmap;", "bitmap", "Lkotlin/f1;", "onMapScreenShot", "", "i", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5770d implements AMap.OnMapScreenShotListener {
        C5770d() {
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(@NotNull Bitmap bitmap) {
            C14342f0.m8184p(bitmap, "bitmap");
            V3RecordTraceFragment v3RecordTraceFragment = V3RecordTraceFragment.this;
            MaterialCardView materialCardView = v3RecordTraceFragment.mo43920M().cardBottom;
            C14342f0.m8185o(materialCardView, "mDataBinding.cardBottom");
            Bitmap m38408P = v3RecordTraceFragment.m38408P(bitmap, v3RecordTraceFragment.m38409O(materialCardView));
            if (m38408P != null) {
                V3RecordTraceFragment.this.m38400X(m38408P);
            }
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(@NotNull Bitmap bitmap, int i) {
            C14342f0.m8184p(bitmap, "bitmap");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public final void m38412D(List<? extends Map<String, ? extends Object>> list, List<? extends Map<String, ? extends Object>> list2) {
        int m8957Y;
        m8957Y = C14236x.m8957Y(list, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            Map map = (Map) it.next();
            arrayList.add(new PointData(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o"), JsonParse.getLong(map, UMCommonContent.f37782aL), JsonParse.getFloat(map, "s"), JsonParse.getBoolean(map, "i"), JsonParse.getInt(map, C7304t.f25048d), JsonParse.getLong(map, "c"), JsonParse.getInt(map, "e")));
        }
        new DrawMapLineManager(mo43926C(), this.f20689j).m39130a(arrayList);
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(C4215R.mipmap.ic_marker_end);
        MarkerOptions markerOptions = new MarkerOptions();
        List<LatLng> list3 = this.f20692m;
        MarkerOptions draggable = markerOptions.position(list3.get(list3.size() - 1)).icon(fromResource).zIndex(9.0f).draggable(true);
        AMap aMap = this.f20689j;
        C14342f0.m8187m(aMap);
        aMap.addMarker(draggable);
    }

    /* renamed from: H */
    private final void m38411H(List<? extends Map<String, ? extends Object>> list, List<? extends Map<String, ? extends Object>> list2, int i) {
        List m12115h5;
        m12115h5 = _Collections.m12115h5(list, new C5767a());
        Iterator it = m12115h5.iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Map<String, ? extends Object> map = (Map) it.next();
            LatLngBounds.Builder m38406R = m38406R();
            JsonGet jsonGet = JsonGet.f15134a;
            m38406R.include(new LatLng(jsonGet.m43774f(map, "latitude"), jsonGet.m43774f(map, "longitude")));
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                JsonGet jsonGet2 = JsonGet.f15134a;
                if (C14342f0.m8193g(jsonGet2.m43760t((Map) next, "id"), jsonGet2.m43760t(map, "id"))) {
                    obj = next;
                    break;
                }
            }
            Map<String, ? extends Object> map2 = (Map) obj;
            String str = "";
            if (map2 == null) {
                JsonGet jsonGet3 = JsonGet.f15134a;
                LatLng latLng = new LatLng(jsonGet3.m43774f(map, "latitude"), jsonGet3.m43774f(map, "longitude"));
                String m43760t = i == 1 ? jsonGet3.m43760t(map, "sort") : "经";
                if (i == 1) {
                    str = (char) 31532 + jsonGet3.m43760t(map, "sort") + (char) 20010;
                }
                MarkerOptions draggable = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(C5541e.f20105a.m39137a(m43760t))).zIndex(9.0f).title("你未通过" + str + "必经点：" + jsonGet3.m43760t(map, "content")).draggable(false);
                AMap aMap = this.f20689j;
                if (aMap != null) {
                    aMap.addMarker(draggable);
                }
            } else {
                String m43760t2 = i == 1 ? JsonGet.f15134a.m43760t(map2, "sort") : "√";
                if (i == 1) {
                    str = (char) 31532 + JsonGet.f15134a.m43760t(map2, "sort") + (char) 20010;
                }
                BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(C5541e.f20105a.m39136b(m43760t2));
                JsonGet jsonGet4 = JsonGet.f15134a;
                MarkerOptions draggable2 = new MarkerOptions().position(new LatLng(jsonGet4.m43774f(map2, "latitude"), jsonGet4.m43774f(map2, "longitude"))).icon(fromBitmap).zIndex(9.0f).title("你已经通过" + str + "必经点:" + jsonGet4.m43760t(map2, "content")).draggable(false);
                AMap aMap2 = this.f20689j;
                if (aMap2 != null) {
                    aMap2.addMarker(draggable2);
                }
            }
        }
        AMap aMap3 = this.f20689j;
        if (aMap3 == null) {
            return;
        }
        aMap3.animateCamera(CameraUpdateFactory.newLatLngBounds(this.f20691l.build(), Tools.m57620a(50.0f, mo43926C())), 2000L, null);
    }

    /* renamed from: N */
    private final String m38410N(long j) {
        long j2 = 1024;
        long j3 = j2 * 1024;
        long j4 = j2 * j3;
        if (j >= j4) {
            C14361s0 c14361s0 = C14361s0.f41190a;
            String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / ((float) j4))}, 1));
            C14342f0.m8185o(format, "java.lang.String.format(format, *args)");
            return format;
        } else if (j >= j3) {
            float f = ((float) j) / ((float) j3);
            C14361s0 c14361s02 = C14361s0.f41190a;
            String format2 = String.format(f > 100.0f ? "%.0f MB" : "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            C14342f0.m8185o(format2, "java.lang.String.format(format, *args)");
            return format2;
        } else if (j >= 1024) {
            float f2 = ((float) j) / ((float) 1024);
            C14361s0 c14361s03 = C14361s0.f41190a;
            String format3 = String.format(f2 > 100.0f ? "%.0f KB" : "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
            C14342f0.m8185o(format3, "java.lang.String.format(format, *args)");
            return format3;
        } else {
            C14361s0 c14361s04 = C14361s0.f41190a;
            String format4 = String.format("%d B", Arrays.copyOf(new Object[]{Long.valueOf(j)}, 1));
            C14342f0.m8185o(format4, "java.lang.String.format(format, *args)");
            return format4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public final Bitmap m38408P(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, bitmap2.getHeight() + height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(255, 224, 224, 224);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, (width - width2) - Tools.m57620a(10.0f, mo43926C()), height, (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setTextSize(Tools.m57620a(20.0f, mo43926C()));
        String str = getString(2131820604) + '-' + SportsType.f20137a.m39060d(JsonGet.f15134a.m43769k(mo43920M().getDataMap(), "sportType"));
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, Tools.m57620a(20.0f, mo43926C()), Tools.m57620a(20.0f, mo43926C()), paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    /* renamed from: Q */
    private final void m38407Q(List<LatLng> list) {
        AMap aMap = this.f20689j;
        if (aMap == null) {
            return;
        }
        aMap.addPolyline(new PolylineOptions().addAll(list).width(Tools.m57620a(6.0f, mo43926C())).setDottedLine(true).color(ContextCompat.getColor(mo43926C(), 2131034173)).zIndex(Tools.m57620a(5.0f, mo43926C())));
    }

    /* renamed from: S */
    private final void m38405S() {
        List<Marker> mapScreenMarkers;
        AMap aMap = this.f20689j;
        if (aMap == null || (mapScreenMarkers = aMap.getMapScreenMarkers()) == null) {
            return;
        }
        for (Marker marker : mapScreenMarkers) {
            if (marker != null) {
                if (!marker.isInfoWindowShown()) {
                    marker = null;
                }
                if (marker != null) {
                    marker.hideInfoWindow();
                }
            }
        }
    }

    /* renamed from: T */
    private final void m38404T(List<? extends Map<String, ? extends Object>> list) {
        int m8957Y;
        List<LatLng> m12218L5;
        m8957Y = C14236x.m8957Y(list, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            arrayList.add(new LatLng(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o")));
        }
        m12218L5 = _Collections.m12218L5(arrayList);
        this.f20692m = m12218L5;
        if (m12218L5.isEmpty()) {
            return;
        }
        if (this.f20692m.size() > 2) {
            PathSmoothToolOrigin pathSmoothToolOrigin = new PathSmoothToolOrigin();
            pathSmoothToolOrigin.m39557p(1);
            List<LatLng> m39562k = pathSmoothToolOrigin.m39562k(this.f20692m);
            if (m39562k != null && m39562k.size() > 0) {
                this.f20692m = m39562k;
            }
            C11792j.m20469d("优化前latLngs=" + list.size() + "优化后latLngs=" + this.f20692m.size(), new Object[0]);
        }
        if (this.f20692m.size() == 1) {
            List<LatLng> list2 = this.f20692m;
            list2.add(list2.get(0));
        }
        MarkerOptions draggable = new MarkerOptions().position(this.f20692m.get(0)).icon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.ic_marker_start)).zIndex(9.0f).draggable(true);
        AMap aMap = this.f20689j;
        C14342f0.m8187m(aMap);
        Marker addMarker = aMap.addMarker(draggable);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(1000L);
        addMarker.setAnimation(scaleAnimation);
        addMarker.startAnimation();
        AMap aMap2 = this.f20689j;
        C14342f0.m8187m(aMap2);
        aMap2.setOnCameraChangeListener(new C5768b(list));
        for (LatLng latLng : this.f20692m) {
            this.f20691l.include(latLng).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public static final void m38403U(final V3RecordTraceFragment this$0, Map it) {
        Map<String, Object> m8915J0;
        Object obj;
        C14342f0.m8184p(this$0, "this$0");
        List<Integer> m43767m = JsonGet.f15134a.m43767m(it, "stepNumbers");
        int size = m43767m.size() - 1;
        int i = 0;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                i2 += m43767m.get(i).intValue();
                if (i3 > size) {
                    break;
                }
                i = i3;
            }
            i = i2;
        }
        C14342f0.m8185o(it, "it");
        m8915J0 = C14239y0.m8915J0(it);
        m8915J0.put("stepCount", String.valueOf(i));
        this$0.mo43920M().setDataMap(m8915J0);
        JsonGet jsonGet = JsonGet.f15134a;
        List<Map<String, Object>> m43766n = jsonGet.m43766n(it, "pointList");
        List<Map<String, Object>> m43766n2 = jsonGet.m43766n(it, "okPointList");
        int m43769k = jsonGet.m43769k(it, "isSequencePoint");
        List<Map<String, Object>> list = JsonParse.getList(it, "gitudeLatitude");
        C14342f0.m8185o(list, "getList(it, \"gitudeLatitude\")");
        this$0.m38404T(list);
        this$0.m38411H(m43766n, m43766n2, m43769k);
        try {
            obj = new Gson().fromJson(jsonGet.m43760t(it, "geofence"), new C5769c().getType());
        } catch (Exception unused) {
            obj = null;
        }
        List<? extends List<? extends Map<String, ? extends Object>>> list2 = (List) obj;
        if (list2 != null) {
            this$0.m38390m(list2);
        }
        AMap aMap = this$0.f20689j;
        if (aMap == null) {
            return;
        }
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.g
            @Override // com.amap.api.maps.AMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                V3RecordTraceFragment.m38402V(V3RecordTraceFragment.this, latLng);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public static final void m38402V(V3RecordTraceFragment this$0, LatLng latLng) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38405S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public final void m38400X(final Bitmap bitmap) {
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.h
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                V3RecordTraceFragment.m38399Y(V3RecordTraceFragment.this, bitmap, snsPlatform, share_media);
            }
        }).open();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public static final void m38399Y(V3RecordTraceFragment this$0, Bitmap bitmap, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8184p(bitmap, "$bitmap");
        new ShareAction(this$0.getActivity()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment$umShare$1$1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(@NotNull SHARE_MEDIA platform) {
                C14342f0.m8184p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t) {
                C14342f0.m8184p(platform, "platform");
                C14342f0.m8184p(t, "t");
                t.printStackTrace();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(@NotNull SHARE_MEDIA platform) {
                C14342f0.m8184p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(@NotNull SHARE_MEDIA share_media2) {
                C14342f0.m8184p(share_media2, "share_media");
            }
        }).withMedia(new UMImage(this$0.mo43926C(), bitmap)).share();
    }

    /* renamed from: m */
    private final void m38390m(List<? extends List<? extends Map<String, ? extends Object>>> list) {
        int m8957Y;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<Map<String, ? extends Object>> list2 = (List) it.next();
            m8957Y = C14236x.m8957Y(list2, 10);
            ArrayList arrayList = new ArrayList(m8957Y);
            for (Map<String, ? extends Object> map : list2) {
                JsonGet jsonGet = JsonGet.f15134a;
                arrayList.add(new LatLng(Double.parseDouble(jsonGet.m43760t(map, UContent.f38072C)), Double.parseDouble(jsonGet.m43760t(map, UContent.f38073D))));
            }
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.addAll(arrayList);
            polygonOptions.fillColor(mo43912w().getResources().getColor(C4215R.C4217color.fill));
            polygonOptions.strokeColor(mo43912w().getResources().getColor(C4215R.C4217color.stroke));
            polygonOptions.strokeWidth(4.0f);
            AMap aMap = this.f20689j;
            if (aMap != null) {
                aMap.addPolygon(polygonOptions);
            }
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        FragmentActivity requireActivity = requireActivity();
        C14342f0.m8185o(requireActivity, "requireActivity()");
        m43975d(requireActivity);
        this.f20689j = mo43920M().map.getMap();
        mo43920M().map.onCreate(this.f20690k);
        mo43920M().map.setForeground(new ColorDrawable(ContextCompat.getColor(mo43926C(), 2131034470)));
    }

    @NotNull
    /* renamed from: O */
    public final Bitmap m38409O(@NotNull View view) {
        C14342f0.m8184p(view, "view");
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        C14342f0.m8185o(drawingCache, "view.drawingCache");
        return drawingCache;
    }

    /* renamed from: R */
    public final LatLngBounds.Builder m38406R() {
        return this.f20691l;
    }

    /* renamed from: W */
    public final void m38401W() {
        AMap aMap = this.f20689j;
        if (aMap == null) {
            return;
        }
        aMap.getMapScreenShot(new C5770d());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f20690k = bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        mo43920M().map.onDestroy();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        mo43920M().map.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        mo43920M().map.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        C14342f0.m8184p(outState, "outState");
        super.onSaveInstanceState(outState);
        mo43920M().map.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(RecordDetailVM.class);
        C14342f0.m8185o(viewModel, "ViewModelProvider(requir…cordDetailVM::class.java)");
        mo43919a((BaseViewModel) viewModel);
        mo43911x().m37981v().observe(requireActivity(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3RecordTraceFragment.m38403U(V3RecordTraceFragment.this, (Map) obj);
            }
        });
    }
}
