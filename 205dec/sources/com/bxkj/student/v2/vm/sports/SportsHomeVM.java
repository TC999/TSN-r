package com.bxkj.student.v2.vm.sports;

import android.app.Activity;
import androidx.collection.ArrayMap;
import androidx.lifecycle.MutableLiveData;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.http.exception.ApiException;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.data.c;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.utils.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.snail.antifake.jni.EmulatorDetectUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.v0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SportsHomeVM.kt */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DJ\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00062\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0006J\u001c\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0006\u0010\u0017\u001a\u00020\u0006R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR6\u0010%\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R6\u0010)\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R6\u0010-\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R6\u00101\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R6\u00105\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010 \u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R6\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010 \u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R0\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120:0\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010 \u001a\u0004\b<\u0010\"\"\u0004\b=\u0010$R0\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120:0\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010 \u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$\u00a8\u0006E"}, d2 = {"Lcom/bxkj/student/v2/vm/sports/SportsHomeVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "", "", "sportsResult", "Lkotlin/f1;", "T", "it", "", "sportType", "S", "E", "G", "C", "identity", "F", "K", "Lc0/c;", "sportsDb", "Lkotlin/Function0;", "canContinue", "L", "J", "Lcom/bxkj/student/v2/repository/sports/e;", "h", "Lkotlin/o;", "D", "()Lcom/bxkj/student/v2/repository/sports/e;", "sportsHomeRepository", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "z", "()Landroidx/lifecycle/MutableLiveData;", "P", "(Landroidx/lifecycle/MutableLiveData;)V", "menuList", "j", "A", "Q", "morningRecordMap", "k", "H", "U", "sunshineRecordMap", "l", "y", "O", "freedomRecordMap", "m", "x", "N", "exercise_sit_RecordMap", "n", "B", "R", "sportSetMap", "", "o", "I", "V", "uploadFailList", "p", "w", "M", "exceptionList", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SportsHomeVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.o f24487h = kotlin.q.c(m.f24538a);
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24488i = new MutableLiveData<>();
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24489j = new MutableLiveData<>();
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24490k = new MutableLiveData<>();
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24491l = new MutableLiveData<>();
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24492m = new MutableLiveData<>();
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24493n = new MutableLiveData<>();
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private MutableLiveData<List<c0.c>> f24494o = new MutableLiveData<>();
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private MutableLiveData<List<c0.c>> f24495p = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportSetV2$1", f = "SportsHomeVM.kt", i = {0, 1}, l = {132, 136}, m = "invokeSuspend", n = {"originAesKey", "resultJson"}, s = {"L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24496a;

        /* renamed from: b  reason: collision with root package name */
        Object f24497b;

        /* renamed from: c  reason: collision with root package name */
        int f24498c;

        /* renamed from: d  reason: collision with root package name */
        int f24499d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f24500e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ SportsHomeVM f24501f;

        /* compiled from: SportsHomeVM.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lc0/c;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        static final class C0323a extends Lambda implements d2.l<c0.c, String> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0323a f24502a = new C0323a();

            C0323a() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final String invoke(@Nullable c0.c cVar) {
                StringBuilder sb = new StringBuilder();
                sb.append((Object) (cVar == null ? null : cVar.I()));
                sb.append("\u5f00\u59cb\u65f6\u95f4");
                sb.append(com.bxkj.base.v2.common.utils.e.a(cVar == null ? null : cVar.Q()));
                sb.append("\u786e\u8ba4\u6b21\u6570");
                sb.append(cVar != null ? Integer.valueOf(cVar.A()) : null);
                return sb.toString();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, SportsHomeVM sportsHomeVM, kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
            this.f24500e = i4;
            this.f24501f = sportsHomeVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f24500e, this.f24501f, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            String str;
            int i4;
            SportsHomeVM sportsHomeVM;
            String resultJson;
            int i5;
            SportsHomeVM sportsHomeVM2;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i6 = this.f24499d;
            if (i6 == 0) {
                d0.n(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.putAll(u.a.f64412a.a());
                linkedHashMap.put("runType", kotlin.coroutines.jvm.internal.a.f(this.f24500e));
                String[] b4 = u.b.b(JSON.toJSONString(linkedHashMap));
                str = b4[0];
                String key = b4[1];
                String data = b4[2];
                com.bxkj.student.v2.repository.sports.e D = this.f24501f.D();
                f0.o(key, "key");
                f0.o(data, "data");
                this.f24496a = str;
                this.f24499d = 1;
                obj = D.g(key, data, this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i5 = this.f24498c;
                resultJson = (String) this.f24497b;
                sportsHomeVM2 = (SportsHomeVM) this.f24496a;
                d0.n(obj);
                i4 = i5;
                sportsHomeVM = sportsHomeVM2;
                sportsHomeVM.S(v0.J0(com.bxkj.base.v2.common.utils.l.f18624a.A(resultJson)), i4);
                return f1.f55527a;
            } else {
                str = (String) this.f24496a;
                d0.n(obj);
            }
            String str2 = (String) obj;
            if (str2 != null) {
                i4 = this.f24500e;
                sportsHomeVM = this.f24501f;
                resultJson = u.b.a(str, str2);
                com.orhanobut.logger.j.h(resultJson);
                com.bxkj.student.v2.common.db.dao.g m4 = AppDatabase.f23168a.a().m();
                if (m4 != null) {
                    String t3 = com.bxkj.base.v2.data.a.b.a().t();
                    String valueOf = String.valueOf(i4);
                    f0.o(resultJson, "resultJson");
                    c0.d dVar = new c0.d(t3, valueOf, resultJson);
                    this.f24496a = sportsHomeVM;
                    this.f24497b = resultJson;
                    this.f24498c = i4;
                    this.f24499d = 2;
                    if (m4.insert(dVar, this) == h4) {
                        return h4;
                    }
                    i5 = i4;
                    sportsHomeVM2 = sportsHomeVM;
                    i4 = i5;
                    sportsHomeVM = sportsHomeVM2;
                }
                sportsHomeVM.S(v0.J0(com.bxkj.base.v2.common.utils.l.f18624a.A(resultJson)), i4);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportSetV2$2", f = "SportsHomeVM.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends SuspendLambda implements l1.p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24503a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24504b;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f24506d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i4, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f24506d = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            b bVar = new b(this.f24506d, cVar);
            bVar.f24504b = obj;
            return bVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((b) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r5.f24503a
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L19
                if (r1 != r4) goto L11
                kotlin.d0.n(r6)
                goto L49
            L11:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L19:
                kotlin.d0.n(r6)
                java.lang.Object r6 = r5.f24504b
                java.lang.Exception r6 = (java.lang.Exception) r6
                boolean r6 = com.bxkj.base.v2.common.ext.e.a(r6)
                if (r6 == 0) goto L93
                java.lang.Object[] r6 = new java.lang.Object[r2]
                java.lang.String r1 = "\u79bb\u7ebf\u8dd1\u6b65"
                com.orhanobut.logger.j.d(r1, r6)
                com.bxkj.student.v2.common.db.AppDatabase$b r6 = com.bxkj.student.v2.common.db.AppDatabase.f23168a
                com.bxkj.student.v2.common.db.AppDatabase r6 = r6.a()
                com.bxkj.student.v2.common.db.dao.g r6 = r6.m()
                if (r6 != 0) goto L3a
                goto L85
            L3a:
                int r1 = r5.f24506d
                java.lang.String r1 = java.lang.String.valueOf(r1)
                r5.f24503a = r4
                java.lang.Object r6 = r6.b(r1, r5)
                if (r6 != r0) goto L49
                return r0
            L49:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 != 0) goto L4e
                goto L85
            L4e:
                int r0 = r6.length()
                if (r0 <= 0) goto L55
                r2 = 1
            L55:
                if (r2 == 0) goto L58
                goto L59
            L58:
                r6 = r3
            L59:
                if (r6 != 0) goto L5c
                goto L85
            L5c:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r0 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                int r1 = r5.f24506d
                com.bxkj.base.v2.common.utils.l r2 = com.bxkj.base.v2.common.utils.l.f18624a
                java.util.Map r6 = r2.A(r6)
                java.util.Map r6 = kotlin.collections.v0.J0(r6)
                java.util.UUID r2 = java.util.UUID.randomUUID()
                java.lang.String r2 = r2.toString()
                java.lang.String r3 = "identify"
                r6.put(r3, r2)
                java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.a.a(r4)
                java.lang.String r3 = "serverUnavailable"
                r6.put(r3, r2)
                com.bxkj.student.v2.vm.sports.SportsHomeVM.u(r0, r6, r1)
                kotlin.f1 r3 = kotlin.f1.f55527a
            L85:
                if (r3 != 0) goto L92
                com.bxkj.student.v2.vm.sports.SportsHomeVM r6 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                androidx.lifecycle.MutableLiveData r6 = r6.f()
                java.lang.String r0 = "\u670d\u52a1\u5668\u7ef4\u62a4\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8fdb\u884c\u8dd1\u6b65"
                r6.postValue(r0)
            L92:
                r2 = 1
            L93:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.a.a(r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsMenu$1", f = "SportsHomeVM.kt", i = {1}, l = {54, 56}, m = "invokeSuspend", n = {"sportsResult"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24507a;

        /* renamed from: b  reason: collision with root package name */
        Object f24508b;

        /* renamed from: c  reason: collision with root package name */
        int f24509c;

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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            Map map;
            SportsHomeVM sportsHomeVM;
            SportsHomeVM sportsHomeVM2;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24509c;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.e D = SportsHomeVM.this.D();
                this.f24509c = 1;
                obj = D.f(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sportsHomeVM2 = (SportsHomeVM) this.f24508b;
                map = (Map) this.f24507a;
                d0.n(obj);
                sportsHomeVM = sportsHomeVM2;
                sportsHomeVM.T(map);
                return f1.f55527a;
            } else {
                d0.n(obj);
            }
            map = (Map) obj;
            if (map != null) {
                sportsHomeVM = SportsHomeVM.this;
                com.bxkj.student.v2.common.db.dao.g m4 = AppDatabase.f23168a.a().m();
                if (m4 != null) {
                    String t3 = com.bxkj.base.v2.data.a.b.a().t();
                    String jSONString = JSON.toJSONString(map);
                    f0.o(jSONString, "toJSONString(it)");
                    c0.d dVar = new c0.d(t3, "-1", jSONString);
                    this.f24507a = map;
                    this.f24508b = sportsHomeVM;
                    this.f24509c = 2;
                    if (m4.insert(dVar, this) == h4) {
                        return h4;
                    }
                    sportsHomeVM2 = sportsHomeVM;
                    sportsHomeVM = sportsHomeVM2;
                }
                sportsHomeVM.T(map);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsMenu$2", f = "SportsHomeVM.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends SuspendLambda implements l1.p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24511a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24512b;

        d(kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            d dVar = new d(cVar);
            dVar.f24512b = obj;
            return dVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((d) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r5.f24511a
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L19
                if (r1 != r4) goto L11
                kotlin.d0.n(r6)
                goto L45
            L11:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L19:
                kotlin.d0.n(r6)
                java.lang.Object r6 = r5.f24512b
                java.lang.Exception r6 = (java.lang.Exception) r6
                boolean r6 = com.bxkj.base.v2.common.ext.e.a(r6)
                if (r6 == 0) goto L77
                java.lang.Object[] r6 = new java.lang.Object[r2]
                java.lang.String r1 = "\u79bb\u7ebf\u8dd1\u6b65\u83b7\u53d6\u8dd1\u6b65\u603b\u8bb0\u5f55\u6570"
                com.orhanobut.logger.j.d(r1, r6)
                com.bxkj.student.v2.common.db.AppDatabase$b r6 = com.bxkj.student.v2.common.db.AppDatabase.f23168a
                com.bxkj.student.v2.common.db.AppDatabase r6 = r6.a()
                com.bxkj.student.v2.common.db.dao.g r6 = r6.m()
                if (r6 != 0) goto L3a
                goto L69
            L3a:
                r5.f24511a = r4
                java.lang.String r1 = "-1"
                java.lang.Object r6 = r6.b(r1, r5)
                if (r6 != r0) goto L45
                return r0
            L45:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 != 0) goto L4a
                goto L69
            L4a:
                int r0 = r6.length()
                if (r0 <= 0) goto L51
                r2 = 1
            L51:
                if (r2 == 0) goto L54
                goto L55
            L54:
                r6 = r3
            L55:
                if (r6 != 0) goto L58
                goto L69
            L58:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r0 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                com.bxkj.base.v2.common.utils.l r1 = com.bxkj.base.v2.common.utils.l.f18624a
                java.util.Map r6 = r1.A(r6)
                java.util.Map r6 = kotlin.collections.v0.J0(r6)
                com.bxkj.student.v2.vm.sports.SportsHomeVM.v(r0, r6)
                kotlin.f1 r3 = kotlin.f1.f55527a
            L69:
                if (r3 != 0) goto L76
                com.bxkj.student.v2.vm.sports.SportsHomeVM r6 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                androidx.lifecycle.MutableLiveData r6 = r6.f()
                java.lang.String r0 = "\u670d\u52a1\u5668\u7ef4\u62a4\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8fdb\u884c\u8dd1\u6b65"
                r6.postValue(r0)
            L76:
                r2 = 1
            L77:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.a.a(r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsStartTime$1", f = "SportsHomeVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24514a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24516c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, kotlin.coroutines.c<? super e> cVar) {
            super(1, cVar);
            this.f24516c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new e(this.f24516c, cVar);
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
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24514a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.e D = SportsHomeVM.this.D();
                String str = this.f24516c;
                this.f24514a = 1;
                if (D.h(str, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsStartTime$2", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class f extends SuspendLambda implements l1.p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24517a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24518b;

        f(kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            f fVar = new f(cVar);
            fVar.f24518b = obj;
            return fVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((f) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24517a == 0) {
                d0.n(obj);
                return kotlin.coroutines.jvm.internal.a.a(com.bxkj.base.v2.common.ext.e.a((Exception) this.f24518b));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getVirtualList$1", f = "SportsHomeVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class g extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24519a;

        g(kotlin.coroutines.c<? super g> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new g(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((g) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24519a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.e D = SportsHomeVM.this.D();
                this.f24519a = 1;
                obj = D.j(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            List<Map<String, ? extends Object>> list = (List) obj;
            if (list != null) {
                for (Map<String, ? extends Object> map : list) {
                    String t3 = com.bxkj.base.v2.common.utils.l.f18624a.t(map, "packageName");
                    com.bxkj.student.run.app.utils.n.f22883a.a().put(t3, t3);
                }
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$queryLocalSports$1", f = "SportsHomeVM.kt", i = {}, l = {222, 226, 232}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class h extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24521a;

        /* renamed from: b  reason: collision with root package name */
        int f24522b;

        h(kotlin.coroutines.c<? super h> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new h(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((h) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r8.f24522b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L29
                if (r1 == r4) goto L25
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r1 = r8.f24521a
                java.util.Iterator r1 = (java.util.Iterator) r1
                kotlin.d0.n(r9)
                goto L7f
            L19:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L21:
                kotlin.d0.n(r9)
                goto L6c
            L25:
                kotlin.d0.n(r9)
                goto L45
            L29:
                kotlin.d0.n(r9)
                com.bxkj.student.v2.vm.sports.SportsHomeVM r9 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                com.bxkj.student.v2.repository.sports.e r9 = com.bxkj.student.v2.vm.sports.SportsHomeVM.t(r9)
                com.bxkj.base.v2.data.a$b r1 = com.bxkj.base.v2.data.a.b
                com.bxkj.base.v2.data.a r1 = r1.a()
                java.lang.String r1 = r1.u()
                r8.f24522b = r4
                java.lang.Object r9 = r9.i(r1, r8)
                if (r9 != r0) goto L45
                return r0
            L45:
                java.util.List r9 = (java.util.List) r9
                if (r9 != 0) goto L4a
                goto L53
            L4a:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r1 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                androidx.lifecycle.MutableLiveData r1 = r1.I()
                r1.postValue(r9)
            L53:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r9 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                com.bxkj.student.v2.repository.sports.e r9 = com.bxkj.student.v2.vm.sports.SportsHomeVM.t(r9)
                com.bxkj.base.v2.data.a$b r1 = com.bxkj.base.v2.data.a.b
                com.bxkj.base.v2.data.a r1 = r1.a()
                java.lang.String r1 = r1.u()
                r8.f24522b = r3
                java.lang.Object r9 = r9.c(r1, r8)
                if (r9 != r0) goto L6c
                return r0
            L6c:
                java.util.List r9 = (java.util.List) r9
                if (r9 != 0) goto L71
                goto Lca
            L71:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r1 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                androidx.lifecycle.MutableLiveData r1 = r1.w()
                r1.postValue(r9)
                java.util.Iterator r9 = r9.iterator()
                r1 = r9
            L7f:
                r9 = r8
            L80:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto Lca
                java.lang.Object r3 = r1.next()
                c0.c r3 = (c0.c) r3
                if (r3 != 0) goto L8f
                goto L80
            L8f:
                java.lang.String r5 = r3.G()
                int r5 = r5.length()
                if (r5 <= 0) goto L9b
                r5 = 1
                goto L9c
            L9b:
                r5 = 0
            L9c:
                r6 = 0
                if (r5 == 0) goto La0
                goto La1
            La0:
                r3 = r6
            La1:
                if (r3 != 0) goto La4
                goto L80
            La4:
                java.lang.String r5 = r3.Q()
                java.lang.String r7 = "0"
                boolean r5 = kotlin.jvm.internal.f0.g(r5, r7)
                if (r5 == 0) goto Lb1
                r6 = r3
            Lb1:
                if (r6 != 0) goto Lb4
                goto L80
            Lb4:
                com.bxkj.student.v2.repository.sports.g r3 = new com.bxkj.student.v2.repository.sports.g
                r3.<init>()
                java.lang.String r5 = r6.G()
                r9.f24521a = r1
                r9.f24522b = r2
                java.lang.String r6 = "2"
                java.lang.Object r3 = r3.h(r6, r5, r9)
                if (r3 != r0) goto L80
                return r0
            Lca:
                kotlin.f1 r9 = kotlin.f1.f55527a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$1", f = "SportsHomeVM.kt", i = {}, l = {256, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class i extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24524a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c0.c f24526c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayMap<String, Object> f24527d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24528e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(c0.c cVar, ArrayMap<String, Object> arrayMap, l1.a<f1> aVar, kotlin.coroutines.c<? super i> cVar2) {
            super(1, cVar2);
            this.f24526c = cVar;
            this.f24527d = arrayMap;
            this.f24528e = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new i(this.f24526c, this.f24527d, this.f24528e, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((i) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24524a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.e D = SportsHomeVM.this.D();
                String G = this.f24526c.G();
                this.f24524a = 1;
                if (D.a(G, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d0.n(obj);
                this.f24528e.invoke();
                return f1.f55527a;
            } else {
                d0.n(obj);
            }
            SportsHomeVM sportsHomeVM = SportsHomeVM.this;
            ArrayMap<String, Object> sportsSetMap = this.f24527d;
            f0.o(sportsSetMap, "sportsSetMap");
            sportsHomeVM.S(sportsSetMap, Integer.parseInt(this.f24526c.M()));
            com.bxkj.student.v2.repository.sports.g gVar = new com.bxkj.student.v2.repository.sports.g();
            String G2 = this.f24526c.G();
            this.f24524a = 2;
            if (gVar.h("0", G2, this) == h4) {
                return h4;
            }
            this.f24528e.invoke();
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/bxkj/base/v2/http/exception/ApiException;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$2", f = "SportsHomeVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class j extends SuspendLambda implements l1.p<ApiException, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24529a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0.c f24530b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(c0.c cVar, kotlin.coroutines.c<? super j> cVar2) {
            super(2, cVar2);
            this.f24530b = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new j(this.f24530b, cVar);
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull ApiException apiException, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((j) create(apiException, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24529a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.g gVar = new com.bxkj.student.v2.repository.sports.g();
                String G = this.f24530b.G();
                this.f24529a = 1;
                if (gVar.h("3", G, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return kotlin.coroutines.jvm.internal.a.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$3", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class k extends SuspendLambda implements l1.p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24531a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24532b;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayMap<String, Object> f24534d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c0.c f24535e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24536f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(ArrayMap<String, Object> arrayMap, c0.c cVar, l1.a<f1> aVar, kotlin.coroutines.c<? super k> cVar2) {
            super(2, cVar2);
            this.f24534d = arrayMap;
            this.f24535e = cVar;
            this.f24536f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            k kVar = new k(this.f24534d, this.f24535e, this.f24536f, cVar);
            kVar.f24532b = obj;
            return kVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((k) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24531a == 0) {
                d0.n(obj);
                boolean z3 = false;
                if (com.bxkj.base.v2.common.ext.e.a((Exception) this.f24532b)) {
                    com.orhanobut.logger.j.d("\u79bb\u7ebf\u8dd1\u6b65\u76f4\u63a5\u6ca1\u529e\u6cd5\u9a8c\u8bc1\u8d85\u65f6\u65f6\u95f4", new Object[0]);
                    SportsHomeVM sportsHomeVM = SportsHomeVM.this;
                    ArrayMap<String, Object> sportsSetMap = this.f24534d;
                    f0.o(sportsSetMap, "sportsSetMap");
                    sportsHomeVM.S(sportsSetMap, Integer.parseInt(this.f24535e.M()));
                    this.f24536f.invoke();
                    z3 = true;
                }
                return kotlin.coroutines.jvm.internal.a.a(z3);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class l extends Lambda implements l1.l<iOSOneButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final l f24537a = new l();

        l() {
            super(1);
        }

        public final void a(@NotNull iOSOneButtonDialog it) {
            f0.p(it, "it");
            com.bxkj.student.v2.ui.sports.safe.b.f23945a.c();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
            a(iosonebuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/e;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class m extends Lambda implements l1.a<com.bxkj.student.v2.repository.sports.e> {

        /* renamed from: a  reason: collision with root package name */
        public static final m f24538a = new m();

        m() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.sports.e invoke() {
            return new com.bxkj.student.v2.repository.sports.e();
        }
    }

    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$3", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class n extends SuspendLambda implements d2.p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24539a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24540b;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayMap<String, Object> f24542d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c0.c f24543e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ d2.a<f1> f24544f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(ArrayMap<String, Object> arrayMap, c0.c cVar, d2.a<f1> aVar, kotlin.coroutines.c<? super n> cVar2) {
            super(2, cVar2);
            this.f24542d = arrayMap;
            this.f24543e = cVar;
            this.f24544f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            n nVar = new n(this.f24542d, this.f24543e, this.f24544f, cVar);
            nVar.f24540b = obj;
            return nVar;
        }

        @Override // d2.p
        @Nullable
        /* renamed from: e */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((n) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24539a == 0) {
                d0.n(obj);
                boolean z3 = false;
                if (com.bxkj.base.v2.common.ext.e.a((Exception) this.f24540b)) {
                    com.orhanobut.logger.j.d("\u79bb\u7ebf\u8dd1\u6b65\u76f4\u63a5\u6ca1\u529e\u6cd5\u9a8c\u8bc1\u8d85\u65f6\u65f6\u95f4", new Object[0]);
                    SportsHomeVM sportsHomeVM = SportsHomeVM.this;
                    ArrayMap<String, Object> sportsSetMap = this.f24542d;
                    f0.o(sportsSetMap, "sportsSetMap");
                    SportsHomeVM.v(sportsHomeVM, sportsSetMap, Integer.parseInt(this.f24543e.O()));
                    this.f24544f.invoke();
                    z3 = true;
                }
                return kotlin.coroutines.jvm.internal.a.a(z3);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class o extends Lambda implements d2.l<iOSOneButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final o f24545a = new o();

        o() {
            super(1);
        }

        public final void a(@NotNull iOSOneButtonDialog it) {
            f0.p(it, "it");
            com.bxkj.student.v2.ui.sports.safe.b.f23945a.c();
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
            a(iosonebuttondialog);
            return f1.f55527a;
        }
    }

    /* compiled from: SportsHomeVM.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM", f = "SportsHomeVM.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 405}, m = "silentUploadV3", n = {"this", "sportsDb", "this", "sportsDb", "faceFile", "this", "sportsDb", "faceFile", "this", "sportsDb"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class p extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        Object f24546a;

        /* renamed from: b  reason: collision with root package name */
        Object f24547b;

        /* renamed from: c  reason: collision with root package name */
        Object f24548c;

        /* renamed from: d  reason: collision with root package name */
        Object f24549d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f24550e;

        /* renamed from: g  reason: collision with root package name */
        int f24552g;

        p(kotlin.coroutines.c<? super p> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f24550e = obj;
            this.f24552g |= Integer.MIN_VALUE;
            return SportsHomeVM.this.b0(null, this);
        }
    }

    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/e;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class q extends Lambda implements d2.a<com.bxkj.student.v2.repository.sports.e> {

        /* renamed from: a  reason: collision with root package name */
        public static final q f24553a = new q();

        q() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.sports.e invoke() {
            return new com.bxkj.student.v2.repository.sports.e();
        }
    }

    /* compiled from: SportsHomeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class r extends Lambda implements d2.a<com.bxkj.student.v2.repository.sports.g> {

        /* renamed from: a  reason: collision with root package name */
        public static final r f24554a = new r();

        r() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.sports.g invoke() {
            return new com.bxkj.student.v2.repository.sports.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.e D() {
        return (com.bxkj.student.v2.repository.sports.e) this.f24487h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(Map<String, Object> map, int i4) {
        h.a aVar = com.bxkj.student.v2.common.utils.h.f23357a;
        c.a aVar2 = com.bxkj.student.v2.common.data.c.a;
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        aVar.v(aVar2.h(lVar.g(map, "limitSpeed", aVar.k())));
        aVar.z(lVar.g(map, "startStride", aVar.o()));
        aVar.r(lVar.g(map, "avgStride", aVar.f()));
        aVar.x(lVar.g(map, "endStride", aVar.m()));
        aVar.u(lVar.l(map, "startLimitStepFrequency", aVar.j()));
        aVar.y(lVar.l(map, "startStepFrequency", aVar.n()));
        aVar.w(lVar.l(map, "endStepFrequency", aVar.l()));
        aVar.t(lVar.l(map, "endLimitStepFrequency", aVar.i()));
        aVar.A(lVar.l(map, "stepCheckDistance", aVar.q()));
        com.orhanobut.logger.j.d(" DriftUtils.maxSpeed=" + aVar.k() + "\n DriftUtils.minStride=" + aVar.o() + "\n DriftUtils.avgStride=" + aVar.f() + "\n DriftUtils.maxStride=" + aVar.m() + "\n DriftUtils.limitMinStep=" + aVar.j() + "\n DriftUtils.minStep=" + aVar.n() + "\n DriftUtils.maxStep=" + aVar.l() + "\n DriftUtils.limitMaxStep=" + aVar.i() + "", new Object[0]);
        map.put("runType", Integer.valueOf(i4));
        com.bxkj.student.v2.ui.sports.safe.b bVar = com.bxkj.student.v2.ui.sports.safe.b.f23945a;
        bVar.d(lVar.u(map, "developTips", bVar.a()));
        if (lVar.l(map, "isCheckDevelop", 1) == 1 && bVar.b()) {
            com.bxkj.student.v2.common.data.b.a.b0(true);
            Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
            if (a4 == null) {
                return;
            }
            ContextExtKt.n(a4, bVar.a(), l.f24537a);
            return;
        }
        Map<String, Object> map2 = lVar.d(map, "userOpenDevelop") ^ true ? map : null;
        if (map2 != null) {
            map2.put("userOpenDevelop", Boolean.valueOf(com.bxkj.student.v2.common.data.b.a.B()));
        }
        this.f24493n.postValue(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(Map<String, Object> map) {
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        Map<String, Object> J0 = v0.J0(lVar.q(v0.J0(map), "morningRun"));
        this.f24489j.postValue(J0);
        Map<String, Object> J02 = v0.J0(lVar.q(v0.J0(map), "sunRun"));
        this.f24490k.postValue(J02);
        Map<String, Object> J03 = v0.J0(lVar.q(v0.J0(map), "freedomRun"));
        this.f24491l.postValue(J03);
        this.f24492m.postValue(v0.J0(lVar.q(v0.J0(map), "exerciseSite")));
        if (f0.g("0", J0.get("isShow")) && f0.g("0", J02.get("isShow")) && f0.g("0", J03.get("isShow"))) {
            f().postValue("\u7cfb\u7edf\u672a\u5f00\u653e\u8dd1\u6b65\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458");
        }
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> A() {
        return this.f24489j;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> B() {
        return this.f24493n;
    }

    public final void C(int i4) {
        TsnSecret tsnSecret = TsnSecret.f16433a;
        BaseApp b4 = BaseApp.b();
        f0.o(b4, "getApp()");
        if (!tsnSecret.checkSignature(b4)) {
            f().postValue("\u7cfb\u7edf\u5185\u90e8\u9519\u8bef\uff0c\u9519\u8bef\u7801\u30101001\u3011");
        } else if (com.bxkj.student.v2.common.utils.l.f23373a.d()) {
            f().postValue("\u7cfb\u7edf\u5185\u90e8\u9519\u8bef\uff0c\u9519\u8bef\u7801\u30101002\u3011");
        } else if (EmulatorDetectUtil.b(App.n())) {
            f().postValue("\u7cfb\u7edf\u68c0\u67e5\u5230\u5f53\u524d\u8fd0\u884c\u73af\u5883\u4e3a\u6a21\u62df\u5668\uff0c\u8bf7\u4f7f\u7528\u771f\u673a\u8fdb\u884c\u8dd1\u6b65");
        } else {
            BaseViewModel.j(this, new a(i4, this, null), null, new b(i4, null), null, null, null, null, null, 250, null);
        }
    }

    public final void E() {
        BaseViewModel.j(this, new c(null), null, new d(null), null, null, null, null, null, 250, null);
    }

    public final void F(@NotNull String identity) {
        f0.p(identity, "identity");
        BaseViewModel.j(this, new e(identity, null), null, new f(null), null, null, null, null, null, 250, null);
    }

    @Nullable
    public final Map<String, Object> G(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 5) {
                        return this.f24488i.getValue();
                    }
                    return this.f24492m.getValue();
                }
                return this.f24489j.getValue();
            }
            return this.f24490k.getValue();
        }
        return this.f24491l.getValue();
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> H() {
        return this.f24490k;
    }

    @NotNull
    public final MutableLiveData<List<c0.c>> I() {
        return this.f24494o;
    }

    public final void J() {
        BaseViewModel.l(this, new g(null), null, null, null, null, null, 62, null);
    }

    public final void K() {
        BaseViewModel.j(this, new h(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void L(@NotNull c0.c sportsDb, @NotNull l1.a<f1> canContinue) {
        f0.p(sportsDb, "sportsDb");
        f0.p(canContinue, "canContinue");
        ArrayMap<String, Object> sportsSetMap = JsonParse.jsonToMap(sportsDb.L());
        f0.o(sportsSetMap, "sportsSetMap");
        sportsSetMap.put("isFromLocalToContinue", Boolean.TRUE);
        if (com.bxkj.base.v2.common.utils.l.f18624a.d(sportsSetMap, "serverUnavailable")) {
            com.orhanobut.logger.j.d("\u5982\u679c\u5f00\u59cb\u8dd1\u6b65\u7684\u65f6\u5019\u670d\u52a1\u5668\u4e0d\u53ef\u7528\uff0c\u6062\u590d\u8dd1\u6b65\u7684\u65f6\u5019\u76f4\u63a5\u6062\u590d\u8dd1\u6b65", new Object[0]);
            S(sportsSetMap, Integer.parseInt(sportsDb.M()));
            canContinue.invoke();
            return;
        }
        BaseViewModel.j(this, new i(sportsDb, sportsSetMap, canContinue, null), new j(sportsDb, null), new k(sportsSetMap, sportsDb, canContinue, null), null, null, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, null);
    }

    public final void M(@NotNull MutableLiveData<List<c0.c>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24495p = mutableLiveData;
    }

    public final void N(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24492m = mutableLiveData;
    }

    public final void O(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24491l = mutableLiveData;
    }

    public final void P(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24488i = mutableLiveData;
    }

    public final void Q(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24489j = mutableLiveData;
    }

    public final void R(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24493n = mutableLiveData;
    }

    public final void U(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24490k = mutableLiveData;
    }

    public final void V(@NotNull MutableLiveData<List<c0.c>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24494o = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<List<c0.c>> w() {
        return this.f24495p;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> x() {
        return this.f24492m;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> y() {
        return this.f24491l;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> z() {
        return this.f24488i;
    }
}
