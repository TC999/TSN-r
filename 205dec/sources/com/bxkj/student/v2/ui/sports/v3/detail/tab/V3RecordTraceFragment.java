package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.utils.u;
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
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.databinding.FmV3SportsTraceBinding;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.bxkj.student.run.app.utils.p;
import com.bxkj.student.run.app.utils.q;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.utils.o;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.MBridgeConstans;
import com.orhanobut.logger.j;
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
import kotlin.collections.v;
import kotlin.collections.v0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3RecordTraceFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b=\u0010>J*\u0010\n\u001a\u00020\t2 \u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u00040\u0004H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002JD\u0010\u0010\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010\u0012\u001a\u00020\t2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004H\u0002J@\u0010\u0013\u001a\u00020\t2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u00042\u001a\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u0019\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\tH\u0016J\u0006\u0010*\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020+R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001f\u0010:\u001a\n 5*\u0004\u0018\u000104048\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010<\u00a8\u0006?"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/FmV3SportsTraceBinding;", "Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "", "", "", "", "it", "Lkotlin/f1;", "m", "S", "pointList", "okPointList", "", "isSequencePoint", "H", "list", "T", "D", "", "size", "N", "Lcom/amap/api/maps/model/LatLng;", "latLngs", "Q", "Landroid/graphics/Bitmap;", "bitmap", "X", "src", "watermark", "P", "E", "p", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "outState", "onSaveInstanceState", "onResume", "onPause", "onDestroyView", "W", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "O", "Lcom/amap/api/maps/AMap;", "j", "Lcom/amap/api/maps/AMap;", "aMap", "k", "Landroid/os/Bundle;", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "kotlin.jvm.PlatformType", "l", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "R", "()Lcom/amap/api/maps/model/LatLngBounds$Builder;", "latLngBoundsBuilder", "", "Ljava/util/List;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3RecordTraceFragment extends BaseFragment<FmV3SportsTraceBinding, RecordDetailVM> {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private AMap f24108j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Bundle f24109k;

    /* renamed from: l  reason: collision with root package name */
    private final LatLngBounds.Builder f24110l = LatLngBounds.builder();
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private List<LatLng> f24111m = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            l lVar = l.f18624a;
            g4 = kotlin.comparisons.b.g(Integer.valueOf(lVar.k((Map) t3, "sort")), Integer.valueOf(lVar.k((Map) t4, "sort")));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordTraceFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment$b", "Lcom/amap/api/maps/AMap$OnCameraChangeListener;", "Lcom/amap/api/maps/model/CameraPosition;", "cameraPosition", "Lkotlin/f1;", "onCameraChange", "onCameraChangeFinish", "", "a", "Z", "isDrawFinish", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b implements AMap.OnCameraChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f24112a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List<Map<String, Object>> f24114c;

        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends Map<String, ? extends Object>> list) {
            this.f24114c = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(V3RecordTraceFragment this$0, List finalList) {
            f0.p(this$0, "this$0");
            f0.p(finalList, "$finalList");
            this$0.M().map.setForeground(new ColorDrawable(ContextCompat.getColor(this$0.C(), 2131034508)));
            this$0.M().rpv.e();
            this$0.M().rpv.setVisibility(8);
            this$0.D(finalList, new ArrayList());
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChange(@NotNull CameraPosition cameraPosition) {
            f0.p(cameraPosition, "cameraPosition");
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChangeFinish(@NotNull CameraPosition cameraPosition) {
            f0.p(cameraPosition, "cameraPosition");
            if (this.f24112a) {
                return;
            }
            int i4 = 1;
            this.f24112a = true;
            q qVar = new q();
            int size = V3RecordTraceFragment.this.f24111m.size();
            if (1 < size) {
                while (true) {
                    int i5 = i4 + 1;
                    AMap aMap = V3RecordTraceFragment.this.f24108j;
                    f0.m(aMap);
                    Point screenLocation = aMap.getProjection().toScreenLocation((LatLng) V3RecordTraceFragment.this.f24111m.get(i4 - 1));
                    AMap aMap2 = V3RecordTraceFragment.this.f24108j;
                    f0.m(aMap2);
                    Point screenLocation2 = aMap2.getProjection().toScreenLocation((LatLng) V3RecordTraceFragment.this.f24111m.get(i4));
                    int color = ContextCompat.getColor(V3RecordTraceFragment.this.C(), 2131034489);
                    qVar.a(screenLocation, screenLocation2, color, color);
                    if (i5 >= size) {
                        break;
                    }
                    i4 = i5;
                }
            }
            V3RecordTraceFragment.this.M().rpv.setPath(qVar);
            RecordPathView recordPathView = V3RecordTraceFragment.this.M().rpv;
            final V3RecordTraceFragment v3RecordTraceFragment = V3RecordTraceFragment.this;
            final List<Map<String, Object>> list = this.f24114c;
            recordPathView.setOnAnimEnd(new RecordPathView.d() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.i
                @Override // com.bxkj.student.run.app.utils.RecordPathView.d
                public final void a() {
                    V3RecordTraceFragment.b.b(V3RecordTraceFragment.this, list);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0002\u00b8\u0006\u0000"}, d2 = {"com/bxkj/base/v2/common/utils/l$d", "Lcom/google/gson/reflect/TypeToken;", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends TypeToken<List<? extends List<? extends Map<String, ? extends Object>>>> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3RecordTraceFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment$d", "Lcom/amap/api/maps/AMap$OnMapScreenShotListener;", "Landroid/graphics/Bitmap;", "bitmap", "Lkotlin/f1;", "onMapScreenShot", "", "i", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d implements AMap.OnMapScreenShotListener {
        d() {
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(@NotNull Bitmap bitmap) {
            f0.p(bitmap, "bitmap");
            V3RecordTraceFragment v3RecordTraceFragment = V3RecordTraceFragment.this;
            MaterialCardView materialCardView = v3RecordTraceFragment.M().cardBottom;
            f0.o(materialCardView, "mDataBinding.cardBottom");
            Bitmap P = v3RecordTraceFragment.P(bitmap, v3RecordTraceFragment.O(materialCardView));
            if (P != null) {
                V3RecordTraceFragment.this.X(P);
            }
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(@NotNull Bitmap bitmap, int i4) {
            f0.p(bitmap, "bitmap");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(List<? extends Map<String, ? extends Object>> list, List<? extends Map<String, ? extends Object>> list2) {
        ArrayList arrayList = new ArrayList(v.Y(list, 10));
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            Map map = (Map) it.next();
            arrayList.add(new PointData(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o"), JsonParse.getLong(map, "t"), JsonParse.getFloat(map, "s"), JsonParse.getBoolean(map, "i"), JsonParse.getInt(map, "l"), JsonParse.getLong(map, "c"), JsonParse.getInt(map, "e")));
        }
        new com.bxkj.student.v2.common.utils.g(C(), this.f24108j).a(arrayList);
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(2131558609);
        MarkerOptions markerOptions = new MarkerOptions();
        List<LatLng> list3 = this.f24111m;
        MarkerOptions draggable = markerOptions.position(list3.get(list3.size() - 1)).icon(fromResource).zIndex(9.0f).draggable(true);
        AMap aMap = this.f24108j;
        f0.m(aMap);
        aMap.addMarker(draggable);
    }

    private final void H(List<? extends Map<String, ? extends Object>> list, List<? extends Map<String, ? extends Object>> list2, int i4) {
        Iterator it = v.h5(list, new a()).iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Map<String, ? extends Object> map = (Map) it.next();
            LatLngBounds.Builder R = R();
            l lVar = l.f18624a;
            R.include(new LatLng(lVar.f(map, "latitude"), lVar.f(map, "longitude")));
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                l lVar2 = l.f18624a;
                if (f0.g(lVar2.t((Map) next, "id"), lVar2.t(map, "id"))) {
                    obj = next;
                    break;
                }
            }
            Map<String, ? extends Object> map2 = (Map) obj;
            String str = "";
            if (map2 == null) {
                l lVar3 = l.f18624a;
                LatLng latLng = new LatLng(lVar3.f(map, "latitude"), lVar3.f(map, "longitude"));
                String t3 = i4 == 1 ? lVar3.t(map, "sort") : "\u7ecf";
                if (i4 == 1) {
                    str = '\u7b2c' + lVar3.t(map, "sort") + '\u4e2a';
                }
                MarkerOptions draggable = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.e.f23349a.a(t3))).zIndex(9.0f).title("\u4f60\u672a\u901a\u8fc7" + str + "\u5fc5\u7ecf\u70b9\uff1a" + lVar3.t(map, "content")).draggable(false);
                AMap aMap = this.f24108j;
                if (aMap != null) {
                    aMap.addMarker(draggable);
                }
            } else {
                String t4 = i4 == 1 ? l.f18624a.t(map2, "sort") : "\u221a";
                if (i4 == 1) {
                    str = '\u7b2c' + l.f18624a.t(map2, "sort") + '\u4e2a';
                }
                BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.e.f23349a.b(t4));
                l lVar4 = l.f18624a;
                MarkerOptions draggable2 = new MarkerOptions().position(new LatLng(lVar4.f(map2, "latitude"), lVar4.f(map2, "longitude"))).icon(fromBitmap).zIndex(9.0f).title("\u4f60\u5df2\u7ecf\u901a\u8fc7" + str + "\u5fc5\u7ecf\u70b9:" + lVar4.t(map2, "content")).draggable(false);
                AMap aMap2 = this.f24108j;
                if (aMap2 != null) {
                    aMap2.addMarker(draggable2);
                }
            }
        }
        AMap aMap3 = this.f24108j;
        if (aMap3 == null) {
            return;
        }
        aMap3.animateCamera(CameraUpdateFactory.newLatLngBounds(this.f24110l.build(), u.a(50.0f, C())), 2000L, null);
    }

    private final String N(long j4) {
        long j5 = 1024;
        long j6 = j5 * 1024;
        long j7 = j5 * j6;
        if (j4 >= j7) {
            s0 s0Var = s0.f55680a;
            String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Float.valueOf(((float) j4) / ((float) j7))}, 1));
            f0.o(format, "java.lang.String.format(format, *args)");
            return format;
        } else if (j4 >= j6) {
            float f4 = ((float) j4) / ((float) j6);
            s0 s0Var2 = s0.f55680a;
            String format2 = String.format(f4 > 100.0f ? "%.0f MB" : "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(f4)}, 1));
            f0.o(format2, "java.lang.String.format(format, *args)");
            return format2;
        } else if (j4 >= 1024) {
            float f5 = ((float) j4) / ((float) 1024);
            s0 s0Var3 = s0.f55680a;
            String format3 = String.format(f5 > 100.0f ? "%.0f KB" : "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(f5)}, 1));
            f0.o(format3, "java.lang.String.format(format, *args)");
            return format3;
        } else {
            s0 s0Var4 = s0.f55680a;
            String format4 = String.format("%d B", Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
            f0.o(format4, "java.lang.String.format(format, *args)");
            return format4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap P(Bitmap bitmap, Bitmap bitmap2) {
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
        canvas.drawBitmap(bitmap2, (width - width2) - u.a(10.0f, C()), height, (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setTextSize(u.a(20.0f, C()));
        String str = getString(2131820604) + '-' + o.a.d(l.f18624a.k(M().getDataMap(), "sportType"));
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, u.a(20.0f, C()), u.a(20.0f, C()), paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private final void Q(List<LatLng> list) {
        AMap aMap = this.f24108j;
        if (aMap == null) {
            return;
        }
        aMap.addPolyline(new PolylineOptions().addAll(list).width(u.a(6.0f, C())).setDottedLine(true).color(ContextCompat.getColor(C(), 2131034173)).zIndex(u.a(5.0f, C())));
    }

    private final void S() {
        List<Marker> mapScreenMarkers;
        AMap aMap = this.f24108j;
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

    private final void T(List<? extends Map<String, ? extends Object>> list) {
        ArrayList arrayList = new ArrayList(v.Y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            arrayList.add(new LatLng(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o")));
        }
        List<LatLng> L5 = v.L5(arrayList);
        this.f24111m = L5;
        if (L5.isEmpty()) {
            return;
        }
        if (this.f24111m.size() > 2) {
            p pVar = new p();
            pVar.p(1);
            List<LatLng> k4 = pVar.k(this.f24111m);
            if (k4 != null && k4.size() > 0) {
                this.f24111m = k4;
            }
            j.d("\u4f18\u5316\u524dlatLngs=" + list.size() + "\u4f18\u5316\u540elatLngs=" + this.f24111m.size(), new Object[0]);
        }
        if (this.f24111m.size() == 1) {
            List<LatLng> list2 = this.f24111m;
            list2.add(list2.get(0));
        }
        MarkerOptions draggable = new MarkerOptions().position(this.f24111m.get(0)).icon(BitmapDescriptorFactory.fromResource(2131558610)).zIndex(9.0f).draggable(true);
        AMap aMap = this.f24108j;
        f0.m(aMap);
        Marker addMarker = aMap.addMarker(draggable);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(1000L);
        addMarker.setAnimation(scaleAnimation);
        addMarker.startAnimation();
        AMap aMap2 = this.f24108j;
        f0.m(aMap2);
        aMap2.setOnCameraChangeListener(new b(list));
        for (LatLng latLng : this.f24111m) {
            this.f24110l.include(latLng).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(final V3RecordTraceFragment this$0, Map it) {
        Object obj;
        f0.p(this$0, "this$0");
        List<Integer> m4 = l.f18624a.m(it, "stepNumbers");
        int size = m4.size() - 1;
        int i4 = 0;
        if (size >= 0) {
            int i5 = 0;
            while (true) {
                int i6 = i4 + 1;
                i5 += m4.get(i4).intValue();
                if (i6 > size) {
                    break;
                }
                i4 = i6;
            }
            i4 = i5;
        }
        f0.o(it, "it");
        Map<String, Object> J0 = v0.J0(it);
        J0.put("stepCount", String.valueOf(i4));
        this$0.M().setDataMap(J0);
        l lVar = l.f18624a;
        List<Map<String, Object>> n4 = lVar.n(it, "pointList");
        List<Map<String, Object>> n5 = lVar.n(it, "okPointList");
        int k4 = lVar.k(it, "isSequencePoint");
        List<Map<String, Object>> list = JsonParse.getList(it, "gitudeLatitude");
        f0.o(list, "getList(it, \"gitudeLatitude\")");
        this$0.T(list);
        this$0.H(n4, n5, k4);
        try {
            obj = new Gson().fromJson(lVar.t(it, "geofence"), new c().getType());
        } catch (Exception unused) {
            obj = null;
        }
        List<? extends List<? extends Map<String, ? extends Object>>> list2 = (List) obj;
        if (list2 != null) {
            this$0.m(list2);
        }
        AMap aMap = this$0.f24108j;
        if (aMap == null) {
            return;
        }
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.g
            @Override // com.amap.api.maps.AMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                V3RecordTraceFragment.V(V3RecordTraceFragment.this, latLng);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(V3RecordTraceFragment this$0, LatLng latLng) {
        f0.p(this$0, "this$0");
        this$0.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(final Bitmap bitmap) {
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.h
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                V3RecordTraceFragment.Y(V3RecordTraceFragment.this, bitmap, snsPlatform, share_media);
            }
        }).open();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(V3RecordTraceFragment this$0, Bitmap bitmap, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        f0.p(this$0, "this$0");
        f0.p(bitmap, "$bitmap");
        new ShareAction(this$0.getActivity()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment$umShare$1$1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(@NotNull SHARE_MEDIA platform) {
                f0.p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t3) {
                f0.p(platform, "platform");
                f0.p(t3, "t");
                t3.printStackTrace();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(@NotNull SHARE_MEDIA platform) {
                f0.p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(@NotNull SHARE_MEDIA share_media2) {
                f0.p(share_media2, "share_media");
            }
        }).withMedia(new UMImage(this$0.C(), bitmap)).share();
    }

    private final void m(List<? extends List<? extends Map<String, ? extends Object>>> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<Map<String, ? extends Object>> list2 = (List) it.next();
            ArrayList arrayList = new ArrayList(v.Y(list2, 10));
            for (Map<String, ? extends Object> map : list2) {
                l lVar = l.f18624a;
                arrayList.add(new LatLng(Double.parseDouble(lVar.t(map, "lat")), Double.parseDouble(lVar.t(map, "lng"))));
            }
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.addAll(arrayList);
            polygonOptions.fillColor(w().getResources().getColor(2131034256));
            polygonOptions.strokeColor(w().getResources().getColor(2131034478));
            polygonOptions.strokeWidth(4.0f);
            AMap aMap = this.f24108j;
            if (aMap != null) {
                aMap.addPolygon(polygonOptions);
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        FragmentActivity requireActivity = requireActivity();
        f0.o(requireActivity, "requireActivity()");
        d(requireActivity);
        this.f24108j = M().map.getMap();
        M().map.onCreate(this.f24109k);
        M().map.setForeground(new ColorDrawable(ContextCompat.getColor(C(), 2131034470)));
    }

    @NotNull
    public final Bitmap O(@NotNull View view) {
        f0.p(view, "view");
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        f0.o(drawingCache, "view.drawingCache");
        return drawingCache;
    }

    public final LatLngBounds.Builder R() {
        return this.f24110l;
    }

    public final void W() {
        AMap aMap = this.f24108j;
        if (aMap == null) {
            return;
        }
        aMap.getMapScreenShot(new d());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f24109k = bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        M().map.onDestroy();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        M().map.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M().map.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        f0.p(outState, "outState");
        super.onSaveInstanceState(outState);
        M().map.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(RecordDetailVM.class);
        f0.o(viewModel, "ViewModelProvider(requir\u2026cordDetailVM::class.java)");
        a((BaseViewModel) viewModel);
        x().v().observe(requireActivity(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3RecordTraceFragment.U(V3RecordTraceFragment.this, (Map) obj);
            }
        });
    }
}
