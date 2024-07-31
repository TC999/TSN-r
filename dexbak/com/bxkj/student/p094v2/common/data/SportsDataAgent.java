package com.bxkj.student.p094v2.common.data;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.App;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.data.SportsDataAnalysis;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C14387q;
import kotlin.InterfaceC14378o;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m12616d2 = {"Lcom/bxkj/student/v2/common/data/b;", "", "<init>", "()V", "a", "g", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.data.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsDataAgent {

    /* renamed from: A */
    private static int f19894A;
    @NotNull

    /* renamed from: B */
    private static final InterfaceC14378o<MutableLiveData<Boolean>> f19895B;
    @NotNull

    /* renamed from: C */
    private static final InterfaceC14378o<MutableLiveData<Integer>> f19896C;
    @NotNull

    /* renamed from: D */
    private static final List<LatLng> f19897D;
    @NotNull

    /* renamed from: E */
    private static LatLng f19898E;
    @NotNull

    /* renamed from: a */
    public static final C5481g f19899a = new C5481g(null);
    @NotNull

    /* renamed from: b */
    private static final InterfaceC14378o<Map<String, Object>> f19900b;

    /* renamed from: c */
    private static long f19901c;

    /* renamed from: d */
    private static long f19902d;

    /* renamed from: e */
    private static double f19903e;

    /* renamed from: f */
    private static double f19904f;
    @NotNull

    /* renamed from: g */
    private static String f19905g;
    @NotNull

    /* renamed from: h */
    private static String f19906h;
    @NotNull

    /* renamed from: i */
    private static String f19907i;

    /* renamed from: j */
    private static int f19908j;

    /* renamed from: k */
    private static int f19909k;
    @Nullable

    /* renamed from: l */
    private static LatLng f19910l;
    @Nullable

    /* renamed from: m */
    private static LatLng f19911m;
    @Nullable

    /* renamed from: n */
    private static PointData f19912n;
    @Nullable

    /* renamed from: o */
    private static PointData f19913o;
    @NotNull

    /* renamed from: p */
    private static final InterfaceC14378o<List<PointData>> f19914p;
    @NotNull

    /* renamed from: q */
    private static final InterfaceC14378o<List<Map<String, Object>>> f19915q;
    @NotNull

    /* renamed from: r */
    private static final InterfaceC14378o<List<Integer>> f19916r;

    /* renamed from: s */
    private static int f19917s;

    /* renamed from: t */
    private static boolean f19918t;

    /* renamed from: u */
    private static boolean f19919u;

    /* renamed from: v */
    private static boolean f19920v;

    /* renamed from: w */
    private static boolean f19921w;
    @Nullable

    /* renamed from: x */
    private static LatLng f19922x;

    /* renamed from: y */
    private static double f19923y;

    /* renamed from: z */
    private static boolean f19924z;

    /* compiled from: SportsDataAgent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n"}, m12616d2 = {"Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5475a extends Lambda implements InterfaceC15269a<MutableLiveData<Integer>> {

        /* renamed from: a */
        public static final C5475a f19925a = new C5475a();

        C5475a() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final MutableLiveData<Integer> invoke() {
            return new MutableLiveData<>(0);
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n"}, m12616d2 = {"Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.b$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5476b extends Lambda implements InterfaceC15269a<MutableLiveData<Boolean>> {

        /* renamed from: a */
        public static final C5476b f19926a = new C5476b();

        C5476b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final MutableLiveData<Boolean> invoke() {
            return new MutableLiveData<>(Boolean.TRUE);
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "Lcom/bxkj/student/v2/common/data/PointData;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.b$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5477c extends Lambda implements InterfaceC15269a<List<PointData>> {

        /* renamed from: a */
        public static final C5477c f19927a = new C5477c();

        C5477c() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        public final List<PointData> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, m12616d2 = {"", "", "", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.b$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5478d extends Lambda implements InterfaceC15269a<List<Map<String, ? extends Object>>> {

        /* renamed from: a */
        public static final C5478d f19928a = new C5478d();

        C5478d() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        public final List<Map<String, ? extends Object>> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, m12616d2 = {"", "", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.b$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5479e extends Lambda implements InterfaceC15269a<Map<String, Object>> {

        /* renamed from: a */
        public static final C5479e f19929a = new C5479e();

        C5479e() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final Map<String, Object> invoke() {
            return new LinkedHashMap();
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.b$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5480f extends Lambda implements InterfaceC15269a<List<Integer>> {

        /* renamed from: a */
        public static final C5480f f19930a = new C5480f();

        C5480f() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        public final List<Integer> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: SportsDataAgent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b)\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\u0002R)\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\"\u0010=\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010C\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010>\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010>\u001a\u0004\bF\u0010@\"\u0004\bG\u0010BR\"\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0017\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010O\u001a\u0004\bT\u0010Q\"\u0004\bU\u0010SR$\u0010V\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010W\u001a\u0004\b\\\u0010Y\"\u0004\b]\u0010[R!\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00150^8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010'\u001a\u0004\b`\u0010aR/\u0010f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010c0^8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010'\u001a\u0004\be\u0010aR!\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0^8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bg\u0010'\u001a\u0004\bh\u0010aR\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\bj\u0010I\"\u0004\bk\u0010KR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010]\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010p\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010O\u001a\u0004\bq\u0010Q\"\u0004\br\u0010SR\"\u0010s\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010\u001a\u001a\u0004\bt\u00107\"\u0004\bu\u00109R\"\u0010v\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010]\u001a\u0004\bw\u0010m\"\u0004\bx\u0010oR\"\u0010y\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010\u0017\u001a\u0004\bz\u0010I\"\u0004\b{\u0010KR+\u0010\u0081\u0001\u001a\u0010\u0012\f\u0012\n }*\u0004\u0018\u00010\u00040\u00040|8FX\u0086\u0084\u0002¢\u0006\r\n\u0004\b~\u0010'\u001a\u0005\b\u007f\u0010\u0080\u0001R-\u0010\u0084\u0001\u001a\u0010\u0012\f\u0012\n }*\u0004\u0018\u00010\n0\n0|8FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0001\u0010'\u001a\u0006\b\u0083\u0001\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010]R\u0018\u0010\u0086\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010]R\u0018\u0010\u0087\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010OR\u0018\u0010\u0088\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010]R\u001d\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100^8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008d\u0001"}, m12616d2 = {"Lcom/bxkj/student/v2/common/data/b$g;", "", "Lkotlin/f1;", "f0", "", "isPause", "R", ExifInterface.GPS_DIRECTION_TRUE, "Y", "", "", "j", "", "gpsStatusString", "gpsStatusImage", "G", "Lcom/amap/api/maps/model/LatLng;", "firstMapLocation", "F", "startPoint", "J", "Lcom/bxkj/student/v2/common/data/PointData;", "newPoint", "I", "Lcom/amap/api/location/AMapLocation;", "aMapLocation", "D", "newLocationPoint", "H", "L", ExifInterface.LONGITUDE_EAST, "stepCount", "K", SocializeConstants.KEY_LOCATION, CampaignEx.JSON_KEY_AD_Q, "a", "b", "", "sportsSetMap$delegate", "Lkotlin/o;", "v", "()Ljava/util/Map;", "sportsSetMap", "", AnalyticsConfig.RTD_START_TIME, "x", "()J", "h0", "(J)V", "countTime", "d", "N", "", "distance", "f", "()D", "P", "(D)V", "gpsDistance", C7304t.f25048d, "U", "avgSpeed", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "M", "(Ljava/lang/String;)V", "pace", UMCommonContent.f37782aL, "c0", "o", "X", "n", "()I", ExifInterface.LONGITUDE_WEST, "(I)V", "gpsStatusCode", "m", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/amap/api/maps/model/LatLng;", "k", "()Lcom/amap/api/maps/model/LatLng;", ExifInterface.LATITUDE_SOUTH, "(Lcom/amap/api/maps/model/LatLng;)V", IAdInterListener.AdReqParam.WIDTH, "g0", "currentPoint", "Lcom/bxkj/student/v2/common/data/PointData;", "e", "()Lcom/bxkj/student/v2/common/data/PointData;", "O", "(Lcom/bxkj/student/v2/common/data/PointData;)V", "r", "Z", "", "latLngList$delegate", "p", "()Ljava/util/List;", "latLngList", "", "okPointList$delegate", "s", "okPointList", "stepCountList$delegate", UMCommonContent.f37777aG, "stepCountList", "y", "i0", "C", "()Z", "d0", "(Z)V", "pauseLatLng", "u", "e0", "faceCheckingDistance", "g", "Q", "isOpenDevelopInStart", "B", "b0", "isOpenDevelop", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a0", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "faceLiveDistanceIn$delegate", "i", "()Landroidx/lifecycle/MutableLiveData;", "faceLiveDistanceIn", "faceLiveCount$delegate", "h", "faceLiveCount", "facePause", "geoFencePause", "last", "mockLocationPause", "mostAccuracyLatLngList", "Ljava/util/List;", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.b$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5481g {
        private C5481g() {
        }

        public /* synthetic */ C5481g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: f0 */
        private final void m39269f0() {
            m39273d0(SportsDataAgent.f19919u || SportsDataAgent.f19920v || SportsDataAgent.f19921w);
        }

        /* renamed from: A */
        public final int m39306A() {
            return SportsDataAgent.f19894A;
        }

        /* renamed from: B */
        public final boolean m39305B() {
            return SportsDataAgent.f19924z;
        }

        /* renamed from: C */
        public final boolean m39304C() {
            return SportsDataAgent.f19918t;
        }

        /* renamed from: D */
        public final void m39303D(@NotNull AMapLocation aMapLocation) {
            C14342f0.m8184p(aMapLocation, "aMapLocation");
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
            intent.putExtra("aMapLocation", aMapLocation);
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: E */
        public final void m39302E() {
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".faceOutPause"));
            intent.putExtra(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, true);
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: F */
        public final void m39301F(@Nullable LatLng latLng) {
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
            intent.putExtra("firstMapLocation", latLng);
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: G */
        public final void m39300G(@NotNull String gpsStatusString, int i) {
            C14342f0.m8184p(gpsStatusString, "gpsStatusString");
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
            intent.putExtra("gpsStatusString", gpsStatusString);
            intent.putExtra("gpsStatusImage", i);
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: H */
        public final void m39299H(@NotNull LatLng newLocationPoint) {
            C14342f0.m8184p(newLocationPoint, "newLocationPoint");
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
            intent.putExtra("newLocationPoint", newLocationPoint);
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: I */
        public final void m39298I(@NotNull PointData newPoint) {
            C14342f0.m8184p(newPoint, "newPoint");
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
            intent.putExtra("newPoint", newPoint);
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: J */
        public final void m39297J(@Nullable LatLng latLng) {
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
            intent.putExtra("startPoint", latLng);
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: K */
        public final void m39296K(int i) {
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
            intent.putExtra("stepCount", i);
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: L */
        public final void m39295L() {
            Intent intent = new Intent();
            intent.setAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
            intent.putExtra("countTime", m39274d());
            intent.putExtra("distance", m39270f());
            intent.putExtra("avgSpeed", m39276c());
            intent.putExtra("pace", m39252t());
            BaseApp.m44341b().sendBroadcast(intent, SportsPermission.f19933b);
        }

        /* renamed from: M */
        public final void m39294M(@NotNull String str) {
            C14342f0.m8184p(str, "<set-?>");
            SportsDataAgent.f19905g = str;
        }

        /* renamed from: N */
        public final void m39293N(long j) {
            SportsDataAgent.f19902d = j;
        }

        /* renamed from: O */
        public final void m39292O(@Nullable PointData pointData) {
            SportsDataAgent.f19912n = pointData;
        }

        /* renamed from: P */
        public final void m39291P(double d) {
            SportsDataAgent.f19903e = d;
        }

        /* renamed from: Q */
        public final void m39290Q(double d) {
            SportsDataAgent.f19923y = d;
        }

        /* renamed from: R */
        public final void m39289R(boolean z) {
            SportsDataAgent.f19919u = z;
            m39269f0();
        }

        /* renamed from: S */
        public final void m39288S(@Nullable LatLng latLng) {
            SportsDataAgent.f19910l = latLng;
        }

        /* renamed from: T */
        public final void m39287T(boolean z) {
            SportsDataAgent.f19920v = z;
            m39269f0();
        }

        /* renamed from: U */
        public final void m39286U(double d) {
            SportsDataAgent.f19904f = d;
        }

        /* renamed from: V */
        public final void m39285V(int i) {
            SportsDataAgent.f19909k = i;
        }

        /* renamed from: W */
        public final void m39284W(int i) {
            SportsDataAgent.f19908j = i;
        }

        /* renamed from: X */
        public final void m39283X(@NotNull String str) {
            C14342f0.m8184p(str, "<set-?>");
            SportsDataAgent.f19907i = str;
        }

        /* renamed from: Y */
        public final void m39282Y(boolean z) {
            SportsDataAgent.f19921w = z;
            m39269f0();
        }

        /* renamed from: Z */
        public final void m39281Z(@Nullable PointData pointData) {
            SportsDataAgent.f19913o = pointData;
        }

        /* renamed from: a */
        public final int m39280a() {
            JsonGet jsonGet = JsonGet.f15134a;
            int m43768l = jsonGet.m43768l(m39250v(), "endQualifiedTime", -1);
            double m43774f = jsonGet.m43774f(m39250v(), "totalRange");
            SportsDataAnalysis.C5482a c5482a = SportsDataAnalysis.f19931a;
            double m39632e = FormatUtils.m39632e(m39270f());
            double d = 1000;
            Double.isNaN(d);
            return c5482a.m39243c(m43774f, m43768l, m39632e * d);
        }

        /* renamed from: a0 */
        public final void m39279a0(int i) {
            SportsDataAgent.f19894A = i;
        }

        /* renamed from: b */
        public final void m39278b() {
            m39265h0(0L);
            m39293N(0L);
            m39291P(Utils.DOUBLE_EPSILON);
            m39286U(Utils.DOUBLE_EPSILON);
            m39294M("0");
            m39275c0("0");
            m39283X("GPS信号未知，正在搜寻···");
            m39284W(C4215R.mipmap.ic_gps_unknow);
            m39288S(null);
            m39267g0(null);
            m39281Z(null);
            m39292O(null);
            m39256p().clear();
            m39246z().clear();
            m39253s().clear();
            m39263i0(0);
            m39266h().setValue(0);
            m39264i().setValue(Boolean.TRUE);
            m39287T(false);
            m39289R(false);
            m39273d0(false);
            m39290Q(Utils.DOUBLE_EPSILON);
            m39271e0(null);
            SportsDataAgent.f19897D.clear();
            m39279a0(0);
        }

        /* renamed from: b0 */
        public final void m39277b0(boolean z) {
            SportsDataAgent.f19924z = z;
        }

        @NotNull
        /* renamed from: c */
        public final String m39276c() {
            return SportsDataAgent.f19905g;
        }

        /* renamed from: c0 */
        public final void m39275c0(@NotNull String str) {
            C14342f0.m8184p(str, "<set-?>");
            SportsDataAgent.f19906h = str;
        }

        /* renamed from: d */
        public final long m39274d() {
            return SportsDataAgent.f19902d;
        }

        /* renamed from: d0 */
        public final void m39273d0(boolean z) {
            SportsDataAgent.f19918t = z;
        }

        @Nullable
        /* renamed from: e */
        public final PointData m39272e() {
            return SportsDataAgent.f19912n;
        }

        /* renamed from: e0 */
        public final void m39271e0(@Nullable LatLng latLng) {
            SportsDataAgent.f19922x = latLng;
        }

        /* renamed from: f */
        public final double m39270f() {
            return SportsDataAgent.f19903e;
        }

        /* renamed from: g */
        public final double m39268g() {
            return SportsDataAgent.f19923y;
        }

        /* renamed from: g0 */
        public final void m39267g0(@Nullable LatLng latLng) {
            SportsDataAgent.f19911m = latLng;
        }

        @NotNull
        /* renamed from: h */
        public final MutableLiveData<Integer> m39266h() {
            return (MutableLiveData) SportsDataAgent.f19896C.getValue();
        }

        /* renamed from: h0 */
        public final void m39265h0(long j) {
            SportsDataAgent.f19901c = j;
        }

        @NotNull
        /* renamed from: i */
        public final MutableLiveData<Boolean> m39264i() {
            return (MutableLiveData) SportsDataAgent.f19895B.getValue();
        }

        /* renamed from: i0 */
        public final void m39263i0(int i) {
            SportsDataAgent.f19917s = i;
        }

        @NotNull
        /* renamed from: j */
        public final List<Integer> m39262j() {
            long j = 60;
            long m39274d = m39274d() / j;
            long m39274d2 = m39274d() % j;
            int i = 0;
            long j2 = m39274d + (m39274d2 == 0 ? 0 : 1);
            ArrayList arrayList = new ArrayList(m39246z());
            for (Number number : m39246z()) {
                i += number.intValue();
            }
            int m39247y = m39247y() - i;
            if (arrayList.size() < j2) {
                arrayList.add(Integer.valueOf(m39247y));
            } else if (arrayList.size() == 0) {
                arrayList.add(Integer.valueOf(m39247y));
            } else {
                arrayList.set(arrayList.size() - 1, Integer.valueOf(((Number) arrayList.get(arrayList.size() - 1)).intValue() + m39247y));
            }
            return arrayList;
        }

        @Nullable
        /* renamed from: k */
        public final LatLng m39261k() {
            return SportsDataAgent.f19910l;
        }

        /* renamed from: l */
        public final double m39260l() {
            return SportsDataAgent.f19904f;
        }

        /* renamed from: m */
        public final int m39259m() {
            return SportsDataAgent.f19909k;
        }

        /* renamed from: n */
        public final int m39258n() {
            return SportsDataAgent.f19908j;
        }

        @NotNull
        /* renamed from: o */
        public final String m39257o() {
            return SportsDataAgent.f19907i;
        }

        @NotNull
        /* renamed from: p */
        public final List<PointData> m39256p() {
            return (List) SportsDataAgent.f19914p.getValue();
        }

        /* renamed from: q */
        public final boolean m39255q(@NotNull AMapLocation location) {
            C14342f0.m8184p(location, "location");
            if (location.getTrustedLevel() != 1) {
                return false;
            }
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            if (AMapUtils.calculateLineDistance(SportsDataAgent.f19898E, latLng) > 10.0f) {
                SportsDataAgent.f19898E = latLng;
                SportsDataAgent.f19897D.clear();
                return false;
            }
            SportsDataAgent.f19897D.add(latLng);
            SportsDataAgent.f19898E = latLng;
            if (SportsDataAgent.f19897D.size() >= 5) {
                SportsDataAgent.f19897D.clear();
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: r */
        public final PointData m39254r() {
            return SportsDataAgent.f19913o;
        }

        @NotNull
        /* renamed from: s */
        public final List<Map<String, Object>> m39253s() {
            return (List) SportsDataAgent.f19915q.getValue();
        }

        @NotNull
        /* renamed from: t */
        public final String m39252t() {
            return SportsDataAgent.f19906h;
        }

        @Nullable
        /* renamed from: u */
        public final LatLng m39251u() {
            return SportsDataAgent.f19922x;
        }

        @NotNull
        /* renamed from: v */
        public final Map<String, Object> m39250v() {
            return (Map) SportsDataAgent.f19900b.getValue();
        }

        @Nullable
        /* renamed from: w */
        public final LatLng m39249w() {
            return SportsDataAgent.f19911m;
        }

        /* renamed from: x */
        public final long m39248x() {
            return SportsDataAgent.f19901c;
        }

        /* renamed from: y */
        public final int m39247y() {
            return SportsDataAgent.f19917s;
        }

        @NotNull
        /* renamed from: z */
        public final List<Integer> m39246z() {
            return (List) SportsDataAgent.f19916r.getValue();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        f19900b = C14387q.m7727b(lazyThreadSafetyMode, C5479e.f19929a);
        f19905g = "0";
        f19906h = "0";
        f19907i = "GPS信号未知，正在搜寻···";
        f19908j = C4215R.mipmap.ic_gps_unknow;
        f19909k = -1;
        f19914p = C14387q.m7727b(lazyThreadSafetyMode, C5477c.f19927a);
        f19915q = C14387q.m7727b(lazyThreadSafetyMode, C5478d.f19928a);
        f19916r = C14387q.m7727b(lazyThreadSafetyMode, C5480f.f19930a);
        f19895B = C14387q.m7727b(lazyThreadSafetyMode, C5476b.f19926a);
        f19896C = C14387q.m7727b(lazyThreadSafetyMode, C5475a.f19925a);
        f19897D = new ArrayList();
        f19898E = new LatLng(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);
    }

    private SportsDataAgent() {
    }
}
