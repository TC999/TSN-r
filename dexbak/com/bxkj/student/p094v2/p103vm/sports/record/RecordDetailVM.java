package com.bxkj.student.p094v2.p103vm.sports.record;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.p094v2.common.data.SportsDataAnalysis;
import com.bxkj.student.p094v2.common.utils.C5543h;
import com.bxkj.student.p094v2.repository.sports.RecordDetailRepository;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import com.tencent.bugly.BUGLY;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.dns.DnsRecord;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._Collections;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.math.C14376d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: RecordDetailVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J(\u0010\u000e\u001a\u00020\u00062 \u0010\r\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f\u0012\u0004\u0012\u00020\u00060\u000bR6\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015¨\u0006,"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "", "", "map", "Lkotlin/f1;", "I", "x", IAdInterListener.AdReqParam.WIDTH, "u", "Lkotlin/Function1;", "", "success", "B", "Landroidx/lifecycle/MutableLiveData;", "h", "Landroidx/lifecycle/MutableLiveData;", "v", "()Landroidx/lifecycle/MutableLiveData;", "D", "(Landroidx/lifecycle/MutableLiveData;)V", "detailDataMap", "i", "Ljava/lang/String;", UMCommonContent.f37777aG, "()Ljava/lang/String;", "F", "(Ljava/lang/String;)V", "exerciseRecordId", "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "G", "identify", "k", "C", "H", "status", C7304t.f25048d, "y", ExifInterface.LONGITUDE_EAST, "exceptionDialogMsg", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RecordDetailVM extends BaseViewModel {
    @Nullable

    /* renamed from: i */
    private String f21200i;
    @Nullable

    /* renamed from: j */
    private String f21201j;
    @Nullable

    /* renamed from: k */
    private String f21202k;
    @NotNull

    /* renamed from: h */
    private MutableLiveData<Map<String, Object>> f21199h = new MutableLiveData<>();
    @NotNull

    /* renamed from: l */
    private MutableLiveData<String> f21203l = new MutableLiveData<>(null);

    /* compiled from: RecordDetailVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetail$1", m8638f = "RecordDetailVM.kt", m8637i = {}, m8636l = {217, 246}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5903a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f21204a;

        /* renamed from: b */
        int f21205b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5904a extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            public static final C5904a f21207a = new C5904a();

            C5904a() {
                super(1);
            }

            /* renamed from: a */
            public final void m37975a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37975a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5905b extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            public static final C5905b f21208a = new C5905b();

            C5905b() {
                super(1);
            }

            /* renamed from: a */
            public final void m37974a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37974a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5906c extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            public static final C5906c f21209a = new C5906c();

            C5906c() {
                super(1);
            }

            /* renamed from: a */
            public final void m37973a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37973a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$d */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5907d extends Lambda implements InterfaceC15280l<Integer, Unit> {

            /* renamed from: a */
            public static final C5907d f21210a = new C5907d();

            C5907d() {
                super(1);
            }

            /* renamed from: a */
            public final void m37972a(int i) {
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                m37972a(num.intValue());
                return Unit.f41048a;
            }
        }

        C5903a(InterfaceC14268c<? super C5903a> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5903a(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5903a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x013c  */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 356
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM.C5903a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: RecordDetailVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailLocal$1", m8638f = "RecordDetailVM.kt", m8637i = {}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5908b extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21211a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5909a extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f21213a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5909a(Map<String, Object> map) {
                super(1);
                this.f21213a = map;
            }

            /* renamed from: a */
            public final void m37970a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
                this.f21213a.put("paceMinute", it);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37970a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5910b extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f21214a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5910b(Map<String, Object> map) {
                super(1);
                this.f21214a = map;
            }

            /* renamed from: a */
            public final void m37969a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
                this.f21214a.put("paceKm", it);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37969a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$b$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5911c extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f21215a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5911c(Map<String, Object> map) {
                super(1);
                this.f21215a = map;
            }

            /* renamed from: a */
            public final void m37968a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
                this.f21215a.put("distanceMinute", it);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37968a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$b$d */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5912d extends Lambda implements InterfaceC15280l<Integer, Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f21216a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5912d(Map<String, Object> map) {
                super(1);
                this.f21216a = map;
            }

            /* renamed from: a */
            public final void m37967a(int i) {
                this.f21216a.put("exceptionStepDistanceCount", Integer.valueOf(i));
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                m37967a(num.intValue());
                return Unit.f41048a;
            }
        }

        C5908b(InterfaceC14268c<? super C5908b> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5908b(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5908b) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01fb  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 574
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM.C5908b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: RecordDetailVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailOnline$1", m8638f = "RecordDetailVM.kt", m8637i = {}, m8636l = {37}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5913c extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21217a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5914a extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f21219a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5914a(Map<String, Object> map) {
                super(1);
                this.f21219a = map;
            }

            /* renamed from: a */
            public final void m37965a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
                this.f21219a.put("paceMinute", it);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37965a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5915b extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f21220a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5915b(Map<String, Object> map) {
                super(1);
                this.f21220a = map;
            }

            /* renamed from: a */
            public final void m37964a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
                this.f21220a.put("paceKm", it);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37964a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5916c extends Lambda implements InterfaceC15280l<List<Double>, Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f21221a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5916c(Map<String, Object> map) {
                super(1);
                this.f21221a = map;
            }

            /* renamed from: a */
            public final void m37963a(@NotNull List<Double> it) {
                C14342f0.m8184p(it, "it");
                this.f21221a.put("distanceMinute", it);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(List<Double> list) {
                m37963a(list);
                return Unit.f41048a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$d */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5917d extends Lambda implements InterfaceC15280l<Integer, Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f21222a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5917d(Map<String, Object> map) {
                super(1);
                this.f21222a = map;
            }

            /* renamed from: a */
            public final void m37962a(int i) {
                this.f21222a.put("exceptionStepDistanceCount", Integer.valueOf(i));
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                m37962a(num.intValue());
                return Unit.f41048a;
            }
        }

        C5913c(InterfaceC14268c<? super C5913c> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5913c(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5913c) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r10.f21217a
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.C14294d0.m8596n(r11)
                goto L32
            Lf:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L17:
                kotlin.C14294d0.m8596n(r11)
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM r11 = com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM.this
                java.lang.String r11 = r11.m37977z()
                if (r11 != 0) goto L24
                r11 = 0
                goto L34
            L24:
                com.bxkj.student.v2.repository.sports.a r1 = new com.bxkj.student.v2.repository.sports.a
                r1.<init>()
                r10.f21217a = r2
                java.lang.Object r11 = r1.m38982c(r11, r10)
                if (r11 != r0) goto L32
                return r0
            L32:
                java.util.Map r11 = (java.util.Map) r11
            L34:
                if (r11 != 0) goto L37
                goto L7c
            L37:
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM r0 = com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM.this
                com.bxkj.student.v2.common.utils.h$a r1 = com.bxkj.student.p094v2.common.utils.C5543h.f20113a
                com.bxkj.student.v2.common.data.c$a r2 = com.bxkj.student.p094v2.common.data.SportsDataAnalysis.f19931a
                com.bxkj.base.v2.common.utils.l r3 = com.bxkj.base.p085v2.common.utils.JsonGet.f15134a
                double r4 = r1.m39092k()
                java.lang.String r6 = "limitSpeed"
                double r4 = r3.m43773g(r11, r6, r4)
                double r4 = r2.m39238h(r4)
                r1.m39081v(r4)
                double r4 = r1.m39090m()
                java.lang.String r1 = "limitStride"
                double r4 = r3.m43773g(r11, r1, r4)
                java.lang.String r1 = "gitudeLatitude"
                java.util.List r1 = r3.m43766n(r11, r1)
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$a r6 = new com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$a
                r6.<init>(r11)
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$b r7 = new com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$b
                r7.<init>(r11)
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$c r8 = new com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$c
                r8.<init>(r11)
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$d r9 = new com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$d
                r9.<init>(r11)
                r3 = r4
                r5 = r1
                r2.m39244b(r3, r5, r6, r7, r8, r9)
                com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM.m37983t(r0, r11)
            L7c:
                kotlin.f1 r11 = kotlin.Unit.f41048a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.record.RecordDetailVM.C5913c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordDetailVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getSportsAppeal$1", m8638f = "RecordDetailVM.kt", m8637i = {}, m8636l = {262}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5918d extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21223a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<Map<String, ? extends Object>, Unit> f21224b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5918d(InterfaceC15280l<? super Map<String, ? extends Object>, Unit> interfaceC15280l, InterfaceC14268c<? super C5918d> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21224b = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5918d(this.f21224b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5918d) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21223a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                RecordDetailRepository recordDetailRepository = new RecordDetailRepository();
                this.f21223a = 1;
                obj = recordDetailRepository.m38983b(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (map != null) {
                this.f21224b.invoke(map);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public final void m37984I(Map<String, Object> map) {
        Object obj;
        Double m12155Y3;
        String m39241e;
        Double m12155Y32;
        Double m12245G3;
        int m12076p5;
        double m12030z1;
        Object obj2;
        int m7914G0;
        boolean z;
        boolean z2;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        JsonGet jsonGet = JsonGet.f15134a;
        map.put("app_format_sportRange", decimalFormat.format(jsonGet.m43774f(map, "sportRange")));
        map.put("app_format_sportTime", FormatUtils.m39630g(jsonGet.m43765o(map, "sportTime")));
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = jsonGet.m43772h(map, "paceMinute").iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue <= Utils.DOUBLE_EPSILON || doubleValue >= 3.0d) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        Double d = (Double) obj;
        if (d != null) {
            d.doubleValue();
            sb.append("配速");
        }
        JsonGet jsonGet2 = JsonGet.f15134a;
        List<Integer> m43767m = jsonGet2.m43767m(map, "stepNumbers");
        if (!(!m43767m.isEmpty())) {
            m43767m = null;
        }
        if (m43767m != null) {
            m12076p5 = _Collections.m12076p5(m43767m);
            map.put("stepCount", String.valueOf(m12076p5));
            m12030z1 = _Collections.m12030z1(m43767m);
            map.put("stepMinute", Double.valueOf(Math.floor(m12030z1)));
            if (m12076p5 != 0) {
                double m43774f = jsonGet2.m43774f(map, "sportRange");
                double d2 = (double) BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH;
                Double.isNaN(d2);
                double d3 = m43774f * d2;
                double d4 = m12076p5;
                Double.isNaN(d4);
                map.put("stepDistance", String.valueOf((int) (d3 / d4)));
            }
            Iterator<T> it2 = m43767m.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (((Number) obj2).intValue() > JsonGet.f15134a.m43768l(map, "limitStepFrequency", C5543h.f20113a.m39094i())) {
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
            Integer num = (Integer) obj2;
            if (num != null) {
                num.intValue();
                if ((sb.length() > 0 ? this : null) != null) {
                    sb.append("、");
                }
                sb.append("步频");
            }
            JsonGet jsonGet3 = JsonGet.f15134a;
            int m43769k = jsonGet3.m43769k(map, "stepDistance");
            double m43773g = jsonGet3.m43773g(map, "limitStride", C5543h.f20113a.m39090m());
            double d5 = 100;
            Double.isNaN(d5);
            m7914G0 = C14376d.m7914G0(m43773g * d5);
            if ((m43769k > m7914G0 ? this : null) != null) {
                if ((sb.length() > 0 ? this : null) != null) {
                    sb.append("、");
                }
                sb.append("步幅");
            }
        }
        if ((sb.length() > 0 ? this : null) != null) {
            map.put("exceptionData", C14342f0.m8216C(sb.toString(), "数据异常，可以替祖国拿金牌了。但这样可能会导致您的成绩无效！请规范跑步！"));
            C11792j.m20469d(C14342f0.m8216C("exceptionData=", JsonGet.f15134a.m43760t(map, "exceptionData")), new Object[0]);
            Unit unit = Unit.f41048a;
        }
        JsonGet jsonGet4 = JsonGet.f15134a;
        map.put("app_format_avgspeed", decimalFormat.format(jsonGet4.m43774f(map, "avgspeed")));
        m12155Y3 = _Collections.m12155Y3(jsonGet4.m43772h(map, "paceKm"));
        if (m12155Y3 == null) {
            m39241e = "-";
        } else {
            m39241e = SportsDataAnalysis.f19931a.m39241e(m12155Y3.doubleValue());
            Unit unit2 = Unit.f41048a;
        }
        map.put("bestPaceKm", m39241e);
        List<Double> m43772h = jsonGet4.m43772h(map, "paceMinute");
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : m43772h) {
            if (!(((Number) obj3).doubleValue() == Utils.DOUBLE_EPSILON)) {
                arrayList.add(obj3);
            }
        }
        m12155Y32 = _Collections.m12155Y3(arrayList);
        if (m12155Y32 != null) {
            map.put("fastSpeed", Double.valueOf(SportsDataAnalysis.f19931a.m39239g(m12155Y32.doubleValue())));
            Unit unit3 = Unit.f41048a;
        }
        List<Double> m43772h2 = JsonGet.f15134a.m43772h(map, "paceMinute");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj4 : m43772h2) {
            if (!(((Number) obj4).doubleValue() == Utils.DOUBLE_EPSILON)) {
                arrayList2.add(obj4);
            }
        }
        m12245G3 = _Collections.m12245G3(arrayList2);
        if (m12245G3 != null) {
            map.put("slowSpeed", Double.valueOf(SportsDataAnalysis.f19931a.m39239g(m12245G3.doubleValue())));
            Unit unit4 = Unit.f41048a;
        }
        this.f21199h.postValue(map);
    }

    @Nullable
    /* renamed from: A */
    public final String m37992A() {
        return this.f21201j;
    }

    /* renamed from: B */
    public final void m37991B(@NotNull InterfaceC15280l<? super Map<String, ? extends Object>, Unit> success) {
        C14342f0.m8184p(success, "success");
        BaseViewModel.m43949j(this, new C5918d(success, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @Nullable
    /* renamed from: C */
    public final String m37990C() {
        return this.f21202k;
    }

    /* renamed from: D */
    public final void m37989D(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21199h = mutableLiveData;
    }

    /* renamed from: E */
    public final void m37988E(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21203l = mutableLiveData;
    }

    /* renamed from: F */
    public final void m37987F(@Nullable String str) {
        this.f21200i = str;
    }

    /* renamed from: G */
    public final void m37986G(@Nullable String str) {
        this.f21201j = str;
    }

    /* renamed from: H */
    public final void m37985H(@Nullable String str) {
        this.f21202k = str;
    }

    /* renamed from: u */
    public final void m37982u() {
        BaseViewModel.m43949j(this, new C5903a(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: v */
    public final MutableLiveData<Map<String, Object>> m37981v() {
        return this.f21199h;
    }

    /* renamed from: w */
    public final void m37980w() {
        BaseViewModel.m43949j(this, new C5908b(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: x */
    public final void m37979x() {
        BaseViewModel.m43949j(this, new C5913c(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: y */
    public final MutableLiveData<String> m37978y() {
        return this.f21203l;
    }

    @Nullable
    /* renamed from: z */
    public final String m37977z() {
        return this.f21200i;
    }
}
