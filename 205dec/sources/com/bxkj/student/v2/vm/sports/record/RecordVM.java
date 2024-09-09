package com.bxkj.student.v2.vm.sports.record;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.orhanobut.logger.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.q;
import kotlin.text.x;
import l1.l;
import l1.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RecordVM.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b?\u0010@JR\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000225\u0010\r\u001a1\u0012'\u0012%\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J[\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u000225\u0010\r\u001a1\u0012'\u0012%\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015J3\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072#\u0010\u001a\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f0\u0004R0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R.\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*0\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006A"}, d2 = {"Lcom/bxkj/student/v2/vm/sports/record/RecordVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "datePageIndex", "Lkotlin/Function1;", "", "", "", "", "Lkotlin/ParameterName;", "name", "recordList", "Lkotlin/f1;", "resultList", "C", "(ILl1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "date", "Lkotlin/Pair;", "", "y", "status", "Lkotlin/Function0;", "requestFinish", "D", "identify", "msg", "success", "K", "h", "Ljava/util/Map;", "E", "()Ljava/util/Map;", "J", "(Ljava/util/Map;)V", "recordMap", "i", "Ljava/lang/String;", "z", "()Ljava/lang/String;", "H", "(Ljava/lang/String;)V", "defaultDate", "", "j", "A", "I", "expandMap", "Lcom/bxkj/student/v2/repository/sports/b;", "k", "Lkotlin/o;", "F", "()Lcom/bxkj/student/v2/repository/sports/b;", "recordRepository", "Lcom/bxkj/student/v2/repository/sports/g;", "l", "G", "()Lcom/bxkj/student/v2/repository/sports/g;", "sportsRepository", "Lcom/bxkj/student/v2/repository/face/c;", "m", "B", "()Lcom/bxkj/student/v2/repository/face/c;", "faceDetectRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class RecordVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private Map<String, Object> f24674h = new LinkedHashMap();
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private String f24675i = "";
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private Map<String, Boolean> f24676j = new LinkedHashMap();
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final o f24677k = q.c(f.f24708a);
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final o f24678l = q.c(g.f24709a);
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final o f24679m = q.c(a.f24680a);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/face/c;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends Lambda implements l1.a<com.bxkj.student.v2.repository.face.c> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f24680a = new a();

        a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.face.c invoke() {
            return new com.bxkj.student.v2.repository.face.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordVM.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM", f = "RecordVM.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED}, m = "getLocalRecord", n = {"this", "resultList", "current"}, s = {"L$0", "L$1", "L$2"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        Object f24681a;

        /* renamed from: b  reason: collision with root package name */
        Object f24682b;

        /* renamed from: c  reason: collision with root package name */
        Object f24683c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f24684d;

        /* renamed from: f  reason: collision with root package name */
        int f24686f;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f24684d = obj;
            this.f24686f |= Integer.MIN_VALUE;
            return RecordVM.this.C(0, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$1", f = "RecordVM.kt", i = {1, 1, 2, 2, 2}, l = {44, 75, 105}, m = "invokeSuspend", n = {"recordList", "list", "recordList", "list", "it"}, s = {"L$3", "L$4", "L$3", "L$4", "L$6"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24687a;

        /* renamed from: b  reason: collision with root package name */
        Object f24688b;

        /* renamed from: c  reason: collision with root package name */
        Object f24689c;

        /* renamed from: d  reason: collision with root package name */
        Object f24690d;

        /* renamed from: e  reason: collision with root package name */
        Object f24691e;

        /* renamed from: f  reason: collision with root package name */
        Object f24692f;

        /* renamed from: g  reason: collision with root package name */
        Object f24693g;

        /* renamed from: h  reason: collision with root package name */
        int f24694h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f24696j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ int f24697k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ l<List<Map<String, Object>>, f1> f24698l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24699m;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: Comparisons.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$d", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int g4;
                com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                g4 = kotlin.comparisons.b.g(Long.valueOf(lVar.o((Map) t4, "startTime")), Long.valueOf(lVar.o((Map) t3, "startTime")));
                return g4;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(String str, int i4, l<? super List<Map<String, Object>>, f1> lVar, l1.a<f1> aVar, kotlin.coroutines.c<? super c> cVar) {
            super(1, cVar);
            this.f24696j = str;
            this.f24697k = i4;
            this.f24698l = lVar;
            this.f24699m = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new c(this.f24696j, this.f24697k, this.f24698l, this.f24699m, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:123:0x02b1  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x02c9  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x0322  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x032f  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x03c1  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x03d4  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x03d8  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x03dd  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01b9  */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List, T] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x0316 -> B:131:0x031e). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r33) {
            /*
                Method dump skipped, instructions count: 1025
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordVM.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$2", f = "RecordVM.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends SuspendLambda implements p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24700a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24701b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24702c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecordVM f24703d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f24704e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l<List<Map<String, Object>>, f1> f24705f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(String str, RecordVM recordVM, int i4, l<? super List<Map<String, Object>>, f1> lVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f24702c = str;
            this.f24703d = recordVM;
            this.f24704e = i4;
            this.f24705f = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f24702c, this.f24703d, this.f24704e, this.f24705f, cVar);
            dVar.f24701b = obj;
            return dVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((d) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24700a;
            boolean z3 = false;
            if (i4 == 0) {
                d0.n(obj);
                if (com.bxkj.base.v2.common.ext.e.a((Exception) this.f24701b)) {
                    j.d("\u670d\u52a1\u5668\u6302\u4e86\uff0c\u83b7\u53d6\u672c\u5730\u8dd1\u6b65\u8bb0\u5f55", new Object[0]);
                    if (!f0.g(this.f24702c, "0") && !f0.g(this.f24702c, "-1")) {
                        this.f24705f.invoke(new ArrayList());
                    } else {
                        RecordVM recordVM = this.f24703d;
                        int i5 = this.f24704e;
                        l<List<Map<String, Object>>, f1> lVar = this.f24705f;
                        this.f24700a = 1;
                        if (recordVM.C(i5, lVar, this) == h4) {
                            return h4;
                        }
                    }
                }
                return kotlin.coroutines.jvm.internal.a.a(z3);
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            z3 = true;
            return kotlin.coroutines.jvm.internal.a.a(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$3", f = "RecordVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24706a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24707b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(l1.a<f1> aVar, kotlin.coroutines.c<? super e> cVar) {
            super(1, cVar);
            this.f24707b = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new e(this.f24707b, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((e) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24706a == 0) {
                d0.n(obj);
                this.f24707b.invoke();
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class f extends Lambda implements l1.a<com.bxkj.student.v2.repository.sports.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f24708a = new f();

        f() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.sports.b invoke() {
            return new com.bxkj.student.v2.repository.sports.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class g extends Lambda implements l1.a<com.bxkj.student.v2.repository.sports.g> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f24709a = new g();

        g() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.sports.g invoke() {
            return new com.bxkj.student.v2.repository.sports.g();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$uploadV3$1", f = "RecordVM.kt", i = {1, 2, 2, 3, 3, 5}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 257, MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY}, m = "invokeSuspend", n = {"it", "it", "faceFile", "it", "faceFile", "commitV3"}, s = {"L$4", "L$4", "L$6", "L$4", "L$6", "L$2"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class h extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24710a;

        /* renamed from: b  reason: collision with root package name */
        Object f24711b;

        /* renamed from: c  reason: collision with root package name */
        Object f24712c;

        /* renamed from: d  reason: collision with root package name */
        Object f24713d;

        /* renamed from: e  reason: collision with root package name */
        Object f24714e;

        /* renamed from: f  reason: collision with root package name */
        Object f24715f;

        /* renamed from: g  reason: collision with root package name */
        Object f24716g;

        /* renamed from: h  reason: collision with root package name */
        int f24717h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f24719j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ l<String, f1> f24720k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(String str, l<? super String, f1> lVar, kotlin.coroutines.c<? super h> cVar) {
            super(1, cVar);
            this.f24719j = str;
            this.f24720k = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new h(this.f24719j, this.f24720k, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((h) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0192 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0260  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0263  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x02bf  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x02c2  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x02c6  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x02c9  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0333 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0334  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0355 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0356  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0359  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x012b -> B:53:0x019e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0190 -> B:52:0x0193). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r47) {
            /*
                Method dump skipped, instructions count: 888
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordVM.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.face.c B() {
        return (com.bxkj.student.v2.repository.face.c) this.f24679m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object C(int r12, l1.l<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>, kotlin.f1> r13, kotlin.coroutines.c<? super kotlin.f1> r14) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordVM.C(int, l1.l, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.b F() {
        return (com.bxkj.student.v2.repository.sports.b) this.f24677k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.g G() {
        return (com.bxkj.student.v2.repository.sports.g) this.f24678l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Long, Long> y(String str) {
        List T4;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        T4 = x.T4(str, new String[]{"-"}, false, 0, 6, null);
        calendar.set(1, Integer.parseInt((String) T4.get(0)));
        calendar.set(2, Integer.parseInt((String) T4.get(1)) - 1);
        calendar.set(5, 1);
        String format = simpleDateFormat.format(calendar.getTime());
        f0.o(format, "dateFormat.format(cal.time)");
        String substring = format.substring(0, 10);
        f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        String C = f0.C(substring, " 00:00:00");
        calendar.set(5, calendar.getActualMaximum(5));
        String format2 = simpleDateFormat.format(calendar.getTime());
        f0.o(format2, "dateFormat.format(cal.time)");
        String substring2 = format2.substring(0, 10);
        f0.o(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return new Pair<>(Long.valueOf(simpleDateFormat.parse(C).getTime()), Long.valueOf(simpleDateFormat.parse(f0.C(substring2, " 23:59:59")).getTime()));
    }

    @NotNull
    public final Map<String, Boolean> A() {
        return this.f24676j;
    }

    public final void D(@NotNull String status, int i4, @NotNull l<? super List<Map<String, Object>>, f1> resultList, @NotNull l1.a<f1> requestFinish) {
        f0.p(status, "status");
        f0.p(resultList, "resultList");
        f0.p(requestFinish, "requestFinish");
        BaseViewModel.j(this, new c(status, i4, resultList, requestFinish, null), null, new d(status, this, i4, resultList, null), null, new e(requestFinish, null), null, null, null, 234, null);
    }

    @NotNull
    public final Map<String, Object> E() {
        return this.f24674h;
    }

    public final void H(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f24675i = str;
    }

    public final void I(@NotNull Map<String, Boolean> map) {
        f0.p(map, "<set-?>");
        this.f24676j = map;
    }

    public final void J(@NotNull Map<String, Object> map) {
        f0.p(map, "<set-?>");
        this.f24674h = map;
    }

    public final void K(@NotNull String identify, @NotNull l<? super String, f1> success) {
        f0.p(identify, "identify");
        f0.p(success, "success");
        BaseViewModel.j(this, new h(identify, success, null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final String z() {
        return this.f24675i;
    }
}
