package com.bxkj.student.v2.common.data;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.App;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.data.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SmoothingFilter.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/bxkj/student/v2/common/data/b;", "", "Lcom/bxkj/student/v2/common/data/PointData;", "lastPoint", "newPoint", "a", "", "b", "D", "alpha", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f23125a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static double f23126b = 0.2d;

    /* compiled from: SportsDataAgent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n"}, d2 = {"Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends Lambda implements l1.a<MutableLiveData<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f23127a = new a();

        a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final MutableLiveData<Integer> invoke() {
            return new MutableLiveData<>(0);
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n"}, d2 = {"Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class C0287b extends Lambda implements l1.a<MutableLiveData<Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0287b f23128a = new C0287b();

        C0287b() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final MutableLiveData<Boolean> invoke() {
            return new MutableLiveData<>(Boolean.TRUE);
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "Lcom/bxkj/student/v2/common/data/PointData;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class c extends Lambda implements l1.a<List<PointData>> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f23129a = new c();

        c() {
            super(0);
        }

        @NotNull
        public final List<PointData> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, d2 = {"", "", "", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class d extends Lambda implements l1.a<List<Map<String, ? extends Object>>> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f23130a = new d();

        d() {
            super(0);
        }

        @NotNull
        public final List<Map<String, Object>> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, d2 = {"", "", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class e extends Lambda implements l1.a<Map<String, Object>> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f23131a = new e();

        e() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final Map<String, Object> invoke() {
            return new LinkedHashMap();
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class f extends Lambda implements l1.a<List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f23132a = new f();

        f() {
            super(0);
        }

        @NotNull
        public final List<Integer> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b)\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\u0002R)\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\"\u0010=\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010C\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010>\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010>\u001a\u0004\bF\u0010@\"\u0004\bG\u0010BR\"\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0017\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010O\u001a\u0004\bT\u0010Q\"\u0004\bU\u0010SR$\u0010V\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010W\u001a\u0004\b\\\u0010Y\"\u0004\b]\u0010[R!\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00150^8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010'\u001a\u0004\b`\u0010aR/\u0010f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010c0^8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010'\u001a\u0004\be\u0010aR!\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0^8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010'\u001a\u0004\bh\u0010aR\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\bj\u0010I\"\u0004\bk\u0010KR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010]\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010p\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010O\u001a\u0004\bq\u0010Q\"\u0004\br\u0010SR\"\u0010s\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010\u001a\u001a\u0004\bt\u00107\"\u0004\bu\u00109R\"\u0010v\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010]\u001a\u0004\bw\u0010m\"\u0004\bx\u0010oR\"\u0010y\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010\u0017\u001a\u0004\bz\u0010I\"\u0004\b{\u0010KR+\u0010\u0081\u0001\u001a\u0010\u0012\f\u0012\n }*\u0004\u0018\u00010\u00040\u00040|8FX\u0086\u0084\u0002\u00a2\u0006\r\n\u0004\b~\u0010'\u001a\u0005\b\u007f\u0010\u0080\u0001R-\u0010\u0084\u0001\u001a\u0010\u0012\f\u0012\n }*\u0004\u0018\u00010\n0\n0|8FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0082\u0001\u0010'\u001a\u0006\b\u0083\u0001\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010]R\u0018\u0010\u0086\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010]R\u0018\u0010\u0087\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010OR\u0018\u0010\u0088\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010]R\u001d\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100^8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u00a8\u0006\u008d\u0001"}, d2 = {"Lcom/bxkj/student/v2/common/data/b$g;", "", "Lkotlin/f1;", "f0", "", "isPause", "R", "T", "Y", "", "", "j", "", "gpsStatusString", "gpsStatusImage", "G", "Lcom/amap/api/maps/model/LatLng;", "firstMapLocation", "F", "startPoint", "J", "Lcom/bxkj/student/v2/common/data/PointData;", "newPoint", "I", "Lcom/amap/api/location/AMapLocation;", "aMapLocation", "D", "newLocationPoint", "H", "L", "E", "stepCount", "K", "location", CampaignEx.JSON_KEY_AD_Q, "a", "b", "", "sportsSetMap$delegate", "Lkotlin/o;", "v", "()Ljava/util/Map;", "sportsSetMap", "", "startTime", "x", "()J", "h0", "(J)V", "countTime", "d", "N", "", "distance", "f", "()D", "P", "(D)V", "gpsDistance", "l", "U", "avgSpeed", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "M", "(Ljava/lang/String;)V", "pace", "t", "c0", "o", "X", "n", "()I", "W", "(I)V", "gpsStatusCode", "m", "V", "Lcom/amap/api/maps/model/LatLng;", "k", "()Lcom/amap/api/maps/model/LatLng;", "S", "(Lcom/amap/api/maps/model/LatLng;)V", "w", "g0", "currentPoint", "Lcom/bxkj/student/v2/common/data/PointData;", "e", "()Lcom/bxkj/student/v2/common/data/PointData;", "O", "(Lcom/bxkj/student/v2/common/data/PointData;)V", "r", "Z", "", "latLngList$delegate", "p", "()Ljava/util/List;", "latLngList", "", "okPointList$delegate", "s", "okPointList", "stepCountList$delegate", "z", "stepCountList", "y", "i0", "C", "()Z", "d0", "(Z)V", "pauseLatLng", "u", "e0", "faceCheckingDistance", "g", "Q", "isOpenDevelopInStart", "B", "b0", "isOpenDevelop", "A", "a0", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "faceLiveDistanceIn$delegate", "i", "()Landroidx/lifecycle/MutableLiveData;", "faceLiveDistanceIn", "faceLiveCount$delegate", "h", "faceLiveCount", "facePause", "geoFencePause", "last", "mockLocationPause", "mostAccuracyLatLngList", "Ljava/util/List;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(u uVar) {
            this();
        }

        private final void f0() {
            d0(b.h() || b.j() || b.q());
        }

        public final int A() {
            return b.B();
        }

        public final boolean B() {
            return b.C();
        }

        public final boolean C() {
            return b.D();
        }

        public final void D(@NotNull AMapLocation aMapLocation) {
            f0.p(aMapLocation, "aMapLocation");
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".run"));
            intent.putExtra("aMapLocation", aMapLocation);
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void E() {
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".faceOutPause"));
            intent.putExtra(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, true);
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void F(@Nullable LatLng latLng) {
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".run"));
            intent.putExtra("firstMapLocation", latLng);
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void G(@NotNull String gpsStatusString, int i4) {
            f0.p(gpsStatusString, "gpsStatusString");
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".run"));
            intent.putExtra("gpsStatusString", gpsStatusString);
            intent.putExtra("gpsStatusImage", i4);
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void H(@NotNull LatLng newLocationPoint) {
            f0.p(newLocationPoint, "newLocationPoint");
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".run"));
            intent.putExtra("newLocationPoint", newLocationPoint);
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void I(@NotNull PointData newPoint) {
            f0.p(newPoint, "newPoint");
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".run"));
            intent.putExtra("newPoint", newPoint);
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void J(@Nullable LatLng latLng) {
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".run"));
            intent.putExtra("startPoint", latLng);
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void K(int i4) {
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".run"));
            intent.putExtra("stepCount", i4);
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void L() {
            Intent intent = new Intent();
            intent.setAction(f0.C(App.n().getPackageName(), ".run"));
            intent.putExtra("countTime", d());
            intent.putExtra("distance", f());
            intent.putExtra("avgSpeed", c());
            intent.putExtra("pace", t());
            BaseApp.b().sendBroadcast(intent, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST");
        }

        public final void M(@NotNull String str) {
            f0.p(str, "<set-?>");
            b.E(str);
        }

        public final void N(long j4) {
            b.F(j4);
        }

        public final void O(@Nullable PointData pointData) {
            b.G(pointData);
        }

        public final void P(double d4) {
            b.H(d4);
        }

        public final void Q(double d4) {
            b.I(d4);
        }

        public final void R(boolean z3) {
            b.J(z3);
            f0();
        }

        public final void S(@Nullable LatLng latLng) {
            b.K(latLng);
        }

        public final void T(boolean z3) {
            b.L(z3);
            f0();
        }

        public final void U(double d4) {
            b.M(d4);
        }

        public final void V(int i4) {
            b.N(i4);
        }

        public final void W(int i4) {
            b.O(i4);
        }

        public final void X(@NotNull String str) {
            f0.p(str, "<set-?>");
            b.P(str);
        }

        public final void Y(boolean z3) {
            b.R(z3);
            f0();
        }

        public final void Z(@Nullable PointData pointData) {
            b.S(pointData);
        }

        public final int a() {
            l lVar = l.f18624a;
            int l4 = lVar.l(v(), "endQualifiedTime", -1);
            double f4 = lVar.f(v(), "totalRange");
            c.a aVar = com.bxkj.student.v2.common.data.c.a;
            double e4 = i.e(f());
            double d4 = 1000;
            Double.isNaN(d4);
            return aVar.c(f4, l4, e4 * d4);
        }

        public final void a0(int i4) {
            b.T(i4);
        }

        public final void b() {
            h0(0L);
            N(0L);
            P(0.0d);
            U(0.0d);
            M("0");
            c0("0");
            X("GPS\u4fe1\u53f7\u672a\u77e5\uff0c\u6b63\u5728\u641c\u5bfb\u00b7\u00b7\u00b7");
            W(2131558607);
            S(null);
            g0(null);
            Z(null);
            O(null);
            p().clear();
            z().clear();
            s().clear();
            i0(0);
            h().setValue(0);
            i().setValue(Boolean.TRUE);
            T(false);
            R(false);
            d0(false);
            Q(0.0d);
            e0(null);
            b.r().clear();
            a0(0);
        }

        public final void b0(boolean z3) {
            b.U(z3);
        }

        @NotNull
        public final String c() {
            return b.a();
        }

        public final void c0(@NotNull String str) {
            f0.p(str, "<set-?>");
            b.V(str);
        }

        public final long d() {
            return b.b();
        }

        public final void d0(boolean z3) {
            b.W(z3);
        }

        @Nullable
        public final PointData e() {
            return b.c();
        }

        public final void e0(@Nullable LatLng latLng) {
            b.X(latLng);
        }

        public final double f() {
            return b.d();
        }

        public final double g() {
            return b.e();
        }

        public final void g0(@Nullable LatLng latLng) {
            b.Y(latLng);
        }

        @NotNull
        public final MutableLiveData<Integer> h() {
            return (MutableLiveData) b.f().getValue();
        }

        public final void h0(long j4) {
            b.Z(j4);
        }

        @NotNull
        public final MutableLiveData<Boolean> i() {
            return (MutableLiveData) b.g().getValue();
        }

        public final void i0(int i4) {
            b.a0(i4);
        }

        @NotNull
        public final List<Integer> j() {
            long j4 = 60;
            long d4 = d() / j4;
            long d5 = d() % j4;
            int i4 = 0;
            long j5 = d4 + (d5 == 0 ? 0 : 1);
            ArrayList arrayList = new ArrayList(z());
            for (Number number : z()) {
                i4 += number.intValue();
            }
            int y3 = y() - i4;
            if (arrayList.size() < j5) {
                arrayList.add(Integer.valueOf(y3));
            } else if (arrayList.size() == 0) {
                arrayList.add(Integer.valueOf(y3));
            } else {
                arrayList.set(arrayList.size() - 1, Integer.valueOf(((Number) arrayList.get(arrayList.size() - 1)).intValue() + y3));
            }
            return arrayList;
        }

        @Nullable
        public final LatLng k() {
            return b.i();
        }

        public final double l() {
            return b.k();
        }

        public final int m() {
            return b.l();
        }

        public final int n() {
            return b.m();
        }

        @NotNull
        public final String o() {
            return b.n();
        }

        @NotNull
        public final List<PointData> p() {
            return (List) b.p().getValue();
        }

        public final boolean q(@NotNull AMapLocation location) {
            f0.p(location, "location");
            if (location.getTrustedLevel() != 1) {
                return false;
            }
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            if (AMapUtils.calculateLineDistance(b.o(), latLng) > 10.0f) {
                b.Q(latLng);
                b.r().clear();
                return false;
            }
            b.r().add(latLng);
            b.Q(latLng);
            if (b.r().size() >= 5) {
                b.r().clear();
                return true;
            }
            return false;
        }

        @Nullable
        public final PointData r() {
            return b.s();
        }

        @NotNull
        public final List<Map<String, Object>> s() {
            return (List) b.t().getValue();
        }

        @NotNull
        public final String t() {
            return b.u();
        }

        @Nullable
        public final LatLng u() {
            return b.v();
        }

        @NotNull
        public final Map<String, Object> v() {
            return (Map) b.w().getValue();
        }

        @Nullable
        public final LatLng w() {
            return b.x();
        }

        public final long x() {
            return b.y();
        }

        public final int y() {
            return b.z();
        }

        @NotNull
        public final List<Integer> z() {
            return (List) b.A().getValue();
        }
    }

    private b() {
    }

    @NotNull
    public final PointData a(@NotNull PointData lastPoint, @NotNull PointData newPoint) {
        f0.p(lastPoint, "lastPoint");
        f0.p(newPoint, "newPoint");
        double a4 = f23126b * newPoint.getA();
        double d4 = 1;
        double d5 = f23126b;
        Double.isNaN(d4);
        newPoint.setA(a4 + ((d4 - d5) * lastPoint.getA()));
        double o4 = f23126b * newPoint.getO();
        double d6 = f23126b;
        Double.isNaN(d4);
        newPoint.setO(o4 + ((d4 - d6) * lastPoint.getO()));
        return newPoint;
    }
}
