package com.bxkj.student.v2.vm.sports.record;

import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.utils.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.orhanobut.logger.j;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l1.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RecordDetailVM.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J(\u0010\u000e\u001a\u00020\u00062 \u0010\r\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f\u0012\u0004\u0012\u00020\u00060\u000bR6\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f0\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015\u00a8\u0006,"}, d2 = {"Lcom/bxkj/student/v2/vm/sports/record/RecordDetailVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "", "", "map", "Lkotlin/f1;", "I", "x", "w", "u", "Lkotlin/Function1;", "", "success", "B", "Landroidx/lifecycle/MutableLiveData;", "h", "Landroidx/lifecycle/MutableLiveData;", "v", "()Landroidx/lifecycle/MutableLiveData;", "D", "(Landroidx/lifecycle/MutableLiveData;)V", "detailDataMap", "i", "Ljava/lang/String;", "z", "()Ljava/lang/String;", "F", "(Ljava/lang/String;)V", "exerciseRecordId", "j", "A", "G", "identify", "k", "C", "H", "status", "l", "y", "E", "exceptionDialogMsg", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class RecordDetailVM extends BaseViewModel {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f24647i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private String f24648j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private String f24649k;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24646h = new MutableLiveData<>();
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private MutableLiveData<String> f24650l = new MutableLiveData<>(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordDetailVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetail$1", f = "RecordDetailVM.kt", i = {}, l = {217, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24651a;

        /* renamed from: b  reason: collision with root package name */
        int f24652b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0324a extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0324a f24654a = new C0324a();

            C0324a() {
                super(1);
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class b extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            public static final b f24655a = new b();

            b() {
                super(1);
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class c extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            public static final c f24656a = new c();

            c() {
                super(1);
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class d extends Lambda implements l<Integer, f1> {

            /* renamed from: a  reason: collision with root package name */
            public static final d f24657a = new d();

            d() {
                super(1);
            }

            public final void a(int i4) {
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(Integer num) {
                a(num.intValue());
                return f1.f55527a;
            }
        }

        a(kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordDetailVM.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordDetailVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailLocal$1", f = "RecordDetailVM.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24658a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24660a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Map<String, Object> map) {
                super(1);
                this.f24660a = map;
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
                this.f24660a.put("paceMinute", it);
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0325b extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24661a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0325b(Map<String, Object> map) {
                super(1);
                this.f24661a = map;
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
                this.f24661a.put("paceKm", it);
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class c extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24662a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(Map<String, Object> map) {
                super(1);
                this.f24662a = map;
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
                this.f24662a.put("distanceMinute", it);
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class d extends Lambda implements l<Integer, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24663a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(Map<String, Object> map) {
                super(1);
                this.f24663a = map;
            }

            public final void a(int i4) {
                this.f24663a.put("exceptionStepDistanceCount", Integer.valueOf(i4));
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(Integer num) {
                a(num.intValue());
                return f1.f55527a;
            }
        }

        b(kotlin.coroutines.c<? super b> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new b(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(cVar)).invokeSuspend(f1.f55527a);
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordDetailVM.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordDetailVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailOnline$1", f = "RecordDetailVM.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class c extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24664a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24666a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Map<String, Object> map) {
                super(1);
                this.f24666a = map;
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
                this.f24666a.put("paceMinute", it);
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class b extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24667a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Map<String, Object> map) {
                super(1);
                this.f24667a = map;
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
                this.f24667a.put("paceKm", it);
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0326c extends Lambda implements l<List<Double>, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24668a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0326c(Map<String, Object> map) {
                super(1);
                this.f24668a = map;
            }

            public final void a(@NotNull List<Double> it) {
                f0.p(it, "it");
                this.f24668a.put("distanceMinute", it);
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(List<Double> list) {
                a(list);
                return f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: RecordDetailVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class d extends Lambda implements l<Integer, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24669a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(Map<String, Object> map) {
                super(1);
                this.f24669a = map;
            }

            public final void a(int i4) {
                this.f24669a.put("exceptionStepDistanceCount", Integer.valueOf(i4));
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(Integer num) {
                a(num.intValue());
                return f1.f55527a;
            }
        }

        c(kotlin.coroutines.c<? super c> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new c(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(cVar)).invokeSuspend(f1.f55527a);
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
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r10.f24664a
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.d0.n(r11)
                goto L32
            Lf:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L17:
                kotlin.d0.n(r11)
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM r11 = com.bxkj.student.v2.vm.sports.record.RecordDetailVM.this
                java.lang.String r11 = r11.z()
                if (r11 != 0) goto L24
                r11 = 0
                goto L34
            L24:
                com.bxkj.student.v2.repository.sports.a r1 = new com.bxkj.student.v2.repository.sports.a
                r1.<init>()
                r10.f24664a = r2
                java.lang.Object r11 = r1.c(r11, r10)
                if (r11 != r0) goto L32
                return r0
            L32:
                java.util.Map r11 = (java.util.Map) r11
            L34:
                if (r11 != 0) goto L37
                goto L7c
            L37:
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM r0 = com.bxkj.student.v2.vm.sports.record.RecordDetailVM.this
                com.bxkj.student.v2.common.utils.h$a r1 = com.bxkj.student.v2.common.utils.h.f23357a
                com.bxkj.student.v2.common.data.c$a r2 = com.bxkj.student.v2.common.data.c.a
                com.bxkj.base.v2.common.utils.l r3 = com.bxkj.base.v2.common.utils.l.f18624a
                double r4 = r1.k()
                java.lang.String r6 = "limitSpeed"
                double r4 = r3.g(r11, r6, r4)
                double r4 = r2.h(r4)
                r1.v(r4)
                double r4 = r1.m()
                java.lang.String r1 = "limitStride"
                double r4 = r3.g(r11, r1, r4)
                java.lang.String r1 = "gitudeLatitude"
                java.util.List r1 = r3.n(r11, r1)
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
                r2.b(r3, r5, r6, r7, r8, r9)
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM.t(r0, r11)
            L7c:
                kotlin.f1 r11 = kotlin.f1.f55527a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordDetailVM.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordDetailVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getSportsAppeal$1", f = "RecordDetailVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24670a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l<Map<String, ? extends Object>, f1> f24671b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(l<? super Map<String, ? extends Object>, f1> lVar, kotlin.coroutines.c<? super d> cVar) {
            super(1, cVar);
            this.f24671b = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new d(this.f24671b, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24670a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.a aVar = new com.bxkj.student.v2.repository.sports.a();
                this.f24670a = 1;
                obj = aVar.b(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (map != null) {
                this.f24671b.invoke(map);
            }
            return f1.f55527a;
        }
    }

    /* compiled from: RecordDetailVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getSportsAppeal$1", f = "RecordDetailVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class e extends SuspendLambda implements d2.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24672a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d2.l<Map<String, ? extends Object>, f1> f24673b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(d2.l<? super Map<String, ? extends Object>, f1> lVar, kotlin.coroutines.c<? super e> cVar) {
            super(1, cVar);
            this.f24673b = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new e(this.f24673b, cVar);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: e */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((e) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24672a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.a aVar = new com.bxkj.student.v2.repository.sports.a();
                this.f24672a = 1;
                obj = aVar.c(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (map != null) {
                this.f24673b.invoke(map);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(Map<String, Object> map) {
        Object obj;
        String e4;
        Object obj2;
        boolean z3;
        boolean z4;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        map.put("app_format_sportRange", decimalFormat.format(lVar.f(map, "sportRange")));
        map.put("app_format_sportTime", i.g(lVar.o(map, "sportTime")));
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = lVar.h(map, "paceMinute").iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue <= 0.0d || doubleValue >= 3.0d) {
                z4 = false;
                continue;
            } else {
                z4 = true;
                continue;
            }
            if (z4) {
                break;
            }
        }
        Double d4 = (Double) obj;
        if (d4 != null) {
            d4.doubleValue();
            sb.append("\u914d\u901f");
        }
        com.bxkj.base.v2.common.utils.l lVar2 = com.bxkj.base.v2.common.utils.l.f18624a;
        List<Integer> m4 = lVar2.m(map, "stepNumbers");
        if (!(!m4.isEmpty())) {
            m4 = null;
        }
        if (m4 != null) {
            int p5 = v.p5(m4);
            map.put("stepCount", String.valueOf(p5));
            map.put("stepMinute", Double.valueOf(Math.floor(v.z1(m4))));
            if (p5 != 0) {
                double f4 = lVar2.f(map, "sportRange");
                double d5 = 100000;
                Double.isNaN(d5);
                double d6 = f4 * d5;
                double d7 = p5;
                Double.isNaN(d7);
                map.put("stepDistance", String.valueOf((int) (d6 / d7)));
            }
            Iterator<T> it2 = m4.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (((Number) obj2).intValue() > com.bxkj.base.v2.common.utils.l.f18624a.l(map, "limitStepFrequency", h.f23357a.i())) {
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
            Integer num = (Integer) obj2;
            if (num != null) {
                num.intValue();
                if ((sb.length() > 0 ? this : null) != null) {
                    sb.append("\u3001");
                }
                sb.append("\u6b65\u9891");
            }
            com.bxkj.base.v2.common.utils.l lVar3 = com.bxkj.base.v2.common.utils.l.f18624a;
            int k4 = lVar3.k(map, "stepDistance");
            double g4 = lVar3.g(map, "limitStride", h.f23357a.m());
            double d8 = 100;
            Double.isNaN(d8);
            if ((k4 > kotlin.math.b.G0(g4 * d8) ? this : null) != null) {
                if ((sb.length() > 0 ? this : null) != null) {
                    sb.append("\u3001");
                }
                sb.append("\u6b65\u5e45");
            }
        }
        if ((sb.length() > 0 ? this : null) != null) {
            map.put("exceptionData", f0.C(sb.toString(), "\u6570\u636e\u5f02\u5e38\uff0c\u53ef\u4ee5\u66ff\u7956\u56fd\u62ff\u91d1\u724c\u4e86\u3002\u4f46\u8fd9\u6837\u53ef\u80fd\u4f1a\u5bfc\u81f4\u60a8\u7684\u6210\u7ee9\u65e0\u6548\uff01\u8bf7\u89c4\u8303\u8dd1\u6b65\uff01"));
            j.d(f0.C("exceptionData=", com.bxkj.base.v2.common.utils.l.f18624a.t(map, "exceptionData")), new Object[0]);
            f1 f1Var = f1.f55527a;
        }
        com.bxkj.base.v2.common.utils.l lVar4 = com.bxkj.base.v2.common.utils.l.f18624a;
        map.put("app_format_avgspeed", decimalFormat.format(lVar4.f(map, "avgspeed")));
        Double Y3 = v.Y3(lVar4.h(map, "paceKm"));
        if (Y3 == null) {
            e4 = "-";
        } else {
            e4 = com.bxkj.student.v2.common.data.c.a.e(Y3.doubleValue());
            f1 f1Var2 = f1.f55527a;
        }
        map.put("bestPaceKm", e4);
        List<Double> h4 = lVar4.h(map, "paceMinute");
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : h4) {
            if (!(((Number) obj3).doubleValue() == 0.0d)) {
                arrayList.add(obj3);
            }
        }
        Double Y32 = v.Y3(arrayList);
        if (Y32 != null) {
            map.put("fastSpeed", Double.valueOf(com.bxkj.student.v2.common.data.c.a.g(Y32.doubleValue())));
            f1 f1Var3 = f1.f55527a;
        }
        List<Double> h5 = com.bxkj.base.v2.common.utils.l.f18624a.h(map, "paceMinute");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj4 : h5) {
            if (!(((Number) obj4).doubleValue() == 0.0d)) {
                arrayList2.add(obj4);
            }
        }
        Double G3 = v.G3(arrayList2);
        if (G3 != null) {
            map.put("slowSpeed", Double.valueOf(com.bxkj.student.v2.common.data.c.a.g(G3.doubleValue())));
            f1 f1Var4 = f1.f55527a;
        }
        this.f24646h.postValue(map);
    }

    @Nullable
    public final String A() {
        return this.f24648j;
    }

    public final void B(@NotNull l<? super Map<String, ? extends Object>, f1> success) {
        f0.p(success, "success");
        BaseViewModel.j(this, new d(success, null), null, null, null, null, null, null, null, 254, null);
    }

    @Nullable
    public final String C() {
        return this.f24649k;
    }

    public final void D(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24646h = mutableLiveData;
    }

    public final void E(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24650l = mutableLiveData;
    }

    public final void F(@Nullable String str) {
        this.f24647i = str;
    }

    public final void G(@Nullable String str) {
        this.f24648j = str;
    }

    public final void H(@Nullable String str) {
        this.f24649k = str;
    }

    public final void u() {
        BaseViewModel.j(this, new a(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> v() {
        return this.f24646h;
    }

    public final void w() {
        BaseViewModel.j(this, new b(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void x() {
        BaseViewModel.j(this, new c(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<String> y() {
        return this.f24650l;
    }

    @Nullable
    public final String z() {
        return this.f24647i;
    }
}
