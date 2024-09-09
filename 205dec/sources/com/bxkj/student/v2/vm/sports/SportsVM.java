package com.bxkj.student.v2.vm.sports;

import com.alibaba.fastjson.JSON;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.q;
import kotlin.text.w;
import l1.p;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SportsVM.kt */
@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J`\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fJ$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\n0\u0011J,\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\fJ,\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u0014\u0010\u001b\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fR0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "isValid", "isException", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msg", "id", "Lkotlin/f1;", "success", "Lkotlin/Function0;", "fail", "w", "F", "identify", "Lkotlin/Function1;", "Lc0/c;", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "E", "remark", "Ljava/io/File;", "cameraFile", "result", "C", "D", "x", "", "", "h", "Ljava/util/Map;", "B", "()Ljava/util/Map;", "G", "(Ljava/util/Map;)V", "sportsSetMap", "Lcom/bxkj/student/v2/repository/sports/b;", "i", "Lkotlin/o;", "z", "()Lcom/bxkj/student/v2/repository/sports/b;", "recordRepository", "Lcom/bxkj/student/v2/repository/sports/g;", "j", "A", "()Lcom/bxkj/student/v2/repository/sports/g;", "sportsRepository", "Lcom/bxkj/student/v2/repository/face/c;", "k", "y", "()Lcom/bxkj/student/v2/repository/face/c;", "faceDetectRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SportsVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private Map<String, Object> f24555h = new LinkedHashMap();
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.o f24556i = q.c(g.f24598a);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final kotlin.o f24557j = q.c(k.f24611a);
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.o f24558k = q.c(d.f24585a);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$commitV3$1", f = "SportsVM.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 5}, l = {60, 64, 68, 75, 80, 120}, m = "invokeSuspend", n = {"uploadType", "sportsType", "uploadType", "sportsType", "uploadType", "faceFile", "sportsType", "uploadType", "faceFile", "sportsType", "commitV3"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$4", "I$0", "L$0", "L$4", "I$0", "L$0"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24559a;

        /* renamed from: b  reason: collision with root package name */
        Object f24560b;

        /* renamed from: c  reason: collision with root package name */
        Object f24561c;

        /* renamed from: d  reason: collision with root package name */
        Object f24562d;

        /* renamed from: e  reason: collision with root package name */
        Object f24563e;

        /* renamed from: f  reason: collision with root package name */
        Object f24564f;

        /* renamed from: g  reason: collision with root package name */
        int f24565g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f24567i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ long f24568j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ long f24569k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ long f24570l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ List<Map<String, Object>> f24571m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ p<String, String, f1> f24572n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(String str, long j4, long j5, long j6, List<? extends Map<String, ? extends Object>> list, p<? super String, ? super String, f1> pVar, kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
            this.f24567i = str;
            this.f24568j = j4;
            this.f24569k = j5;
            this.f24570l = j6;
            this.f24571m = list;
            this.f24572n = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f24567i, this.f24568j, this.f24569k, this.f24570l, this.f24571m, this.f24572n, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00dc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0169 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01fa  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x02b7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x02cd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x02ce  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x02d1  */
        /* JADX WARN: Type inference failed for: r7v12, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0167 -> B:53:0x016a). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r42) {
            /*
                Method dump skipped, instructions count: 756
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsVM.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$commitV3$2", f = "SportsVM.kt", i = {0}, l = {125}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends SuspendLambda implements p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24573a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24574b;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24576d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f24577e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f24578f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f24579g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24580h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, long j4, String str3, l1.a<f1> aVar, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f24576d = str;
            this.f24577e = str2;
            this.f24578f = j4;
            this.f24579g = str3;
            this.f24580h = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            b bVar = new b(this.f24576d, this.f24577e, this.f24578f, this.f24579g, this.f24580h, cVar);
            bVar.f24574b = obj;
            return bVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((b) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            Exception exc;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24573a;
            if (i4 == 0) {
                d0.n(obj);
                Exception exc2 = (Exception) this.f24574b;
                com.bxkj.student.v2.repository.sports.g A = SportsVM.this.A();
                String str = this.f24576d;
                String str2 = this.f24577e;
                String valueOf = String.valueOf(this.f24578f);
                String str3 = this.f24579g;
                this.f24574b = exc2;
                this.f24573a = 1;
                if (A.g(str, str2, valueOf, str3, this) == h4) {
                    return h4;
                }
                exc = exc2;
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                exc = (Exception) this.f24574b;
                d0.n(obj);
            }
            this.f24580h.invoke();
            com.orhanobut.logger.j.d("\u79bb\u7ebf\u8dd1\u6b65\uff0c\u4fdd\u5b58\u8dd1\u6b65\u8bb0\u5f55\uff01", new Object[0]);
            return kotlin.coroutines.jvm.internal.a.a(com.bxkj.base.v2.common.ext.e.a(exc));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$deleteThisRecorder$1", f = "SportsVM.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 255}, m = "invokeSuspend", n = {"identify", "identify"}, s = {"L$0", "L$0"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class c extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24581a;

        /* renamed from: b  reason: collision with root package name */
        int f24582b;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24584d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(l1.a<f1> aVar, kotlin.coroutines.c<? super c> cVar) {
            super(1, cVar);
            this.f24584d = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new c(this.f24584d, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a7 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r6.f24582b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.d0.n(r7)
                goto La8
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.f24581a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.d0.n(r7)
                goto L62
            L26:
                java.lang.Object r1 = r6.f24581a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.d0.n(r7)
                goto L51
            L2e:
                kotlin.d0.n(r7)
                com.bxkj.base.v2.common.utils.l r7 = com.bxkj.base.v2.common.utils.l.f18624a
                com.bxkj.student.v2.common.data.b$g r1 = com.bxkj.student.v2.common.data.b.a
                java.util.Map r1 = r1.v()
                java.lang.String r5 = "identify"
                java.lang.String r7 = r7.t(r1, r5)
                com.bxkj.student.v2.vm.sports.SportsVM r1 = com.bxkj.student.v2.vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.g r1 = com.bxkj.student.v2.vm.sports.SportsVM.v(r1)
                r6.f24581a = r7
                r6.f24582b = r4
                java.lang.Object r1 = r1.c(r7, r6)
                if (r1 != r0) goto L50
                return r0
            L50:
                r1 = r7
            L51:
                com.bxkj.student.v2.vm.sports.SportsVM r7 = com.bxkj.student.v2.vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.b r7 = com.bxkj.student.v2.vm.sports.SportsVM.u(r7)
                r6.f24581a = r1
                r6.f24582b = r3
                java.lang.Object r7 = r7.b(r1, r6)
                if (r7 != r0) goto L62
                return r0
            L62:
                java.util.List r7 = (java.util.List) r7
                r3 = 0
                if (r7 != 0) goto L68
                goto L97
            L68:
                java.util.Iterator r7 = r7.iterator()
            L6c:
                boolean r4 = r7.hasNext()
                if (r4 == 0) goto L97
                java.lang.Object r4 = r7.next()
                c0.a r4 = (c0.a) r4
                if (r4 != 0) goto L7b
                goto L6c
            L7b:
                java.io.File r5 = new java.io.File
                java.lang.String r4 = r4.g()
                r5.<init>(r4)
                boolean r4 = r5.exists()
                if (r4 == 0) goto L8b
                goto L8c
            L8b:
                r5 = r3
            L8c:
                if (r5 != 0) goto L8f
                goto L6c
            L8f:
                boolean r4 = r5.delete()
                kotlin.coroutines.jvm.internal.a.a(r4)
                goto L6c
            L97:
                com.bxkj.student.v2.vm.sports.SportsVM r7 = com.bxkj.student.v2.vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.b r7 = com.bxkj.student.v2.vm.sports.SportsVM.u(r7)
                r6.f24581a = r3
                r6.f24582b = r2
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto La8
                return r0
            La8:
                l1.a<kotlin.f1> r7 = r6.f24584d
                r7.invoke()
                kotlin.f1 r7 = kotlin.f1.f55527a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsVM.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/face/c;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class d extends Lambda implements l1.a<com.bxkj.student.v2.repository.face.c> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f24585a = new d();

        d() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.face.c invoke() {
            return new com.bxkj.student.v2.repository.face.c();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$passPointCamera$1", f = "SportsVM.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class e extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24586a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24588c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24589d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ File f24590e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24591f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, String str2, File file, l1.a<f1> aVar, kotlin.coroutines.c<? super e> cVar) {
            super(1, cVar);
            this.f24588c = str;
            this.f24589d = str2;
            this.f24590e = file;
            this.f24591f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new e(this.f24588c, this.f24589d, this.f24590e, this.f24591f, cVar);
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
            int i4 = this.f24586a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.g A = SportsVM.this.A();
                RequestBody.Companion companion = RequestBody.Companion;
                MediaType.Companion companion2 = MediaType.Companion;
                RequestBody create = companion.create(companion2.parse("multipart/form-data"), this.f24588c);
                RequestBody create2 = companion.create(companion2.parse("multipart/form-data"), this.f24589d);
                RequestBody create3 = companion.create(companion2.parse("image/png"), this.f24590e);
                this.f24586a = 1;
                if (A.e(create, create2, create3, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24591f.invoke();
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$passPointCameraV2$1", f = "SportsVM.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class f extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24592a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24594c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24595d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ File f24596e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24597f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, String str2, File file, l1.a<f1> aVar, kotlin.coroutines.c<? super f> cVar) {
            super(1, cVar);
            this.f24594c = str;
            this.f24595d = str2;
            this.f24596e = file;
            this.f24597f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new f(this.f24594c, this.f24595d, this.f24596e, this.f24597f, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((f) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24592a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.g A = SportsVM.this.A();
                String str = this.f24594c;
                String str2 = this.f24595d;
                RequestBody create = RequestBody.Companion.create(MediaType.Companion.parse("image/png"), this.f24596e);
                this.f24592a = 1;
                if (A.f(str, str2, create, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24597f.invoke();
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class g extends Lambda implements l1.a<com.bxkj.student.v2.repository.sports.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f24598a = new g();

        g() {
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
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeLocalData$1", f = "SportsVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class h extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24599a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24601c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<c0.c> f24602d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, Ref.ObjectRef<c0.c> objectRef, kotlin.coroutines.c<? super h> cVar) {
            super(1, cVar);
            this.f24601c = str;
            this.f24602d = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new h(this.f24601c, this.f24602d, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((h) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Type inference failed for: r11v9, types: [T, java.lang.Object, c0.c] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            boolean K1;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24599a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.g A = SportsVM.this.A();
                String str = this.f24601c;
                this.f24599a = 1;
                obj = A.d(str, this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            List list = (List) obj;
            if (list != null) {
                if (!(!list.isEmpty())) {
                    list = null;
                }
                if (list != null) {
                    Ref.ObjectRef<c0.c> objectRef = this.f24602d;
                    int i5 = 0;
                    ?? r11 = (c0.c) list.get(0);
                    if (r11 != 0) {
                        objectRef.element = r11;
                        com.orhanobut.logger.j.d(f0.C("\u4ece\u6570\u636e\u5e93\u6062\u590d\u7684\u6570\u636e", r11), new Object[0]);
                        b.g gVar = com.bxkj.student.v2.common.data.b.a;
                        gVar.s().clear();
                        List<Map<String, Object>> s3 = gVar.s();
                        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                        s3.addAll(v.L5(lVar.z(r11.J())));
                        gVar.h0(Long.parseLong(r11.O()));
                        gVar.N(Long.parseLong(r11.z()));
                        gVar.P(Double.parseDouble(r11.A()));
                        gVar.a0(Integer.parseInt(r11.U()));
                        gVar.U(r11.F().length() == 0 ? 0.0d : Double.parseDouble(r11.F()));
                        String a4 = com.bxkj.student.run.app.utils.i.a(Double.parseDouble(r11.A()), Long.parseLong(r11.z()));
                        f0.o(a4, "calAvgSpeed(\n           \u2026                        )");
                        gVar.M(a4);
                        gVar.Q(Double.parseDouble(r11.D()));
                        String K = r11.K();
                        K1 = w.K1(K, "null", true);
                        if (!(!K1)) {
                            K = null;
                        }
                        if (K != null) {
                            if (!(K.length() > 0)) {
                                K = null;
                            }
                            if (K != null) {
                                Map<String, Object> A2 = lVar.A(K);
                                gVar.e0(new LatLng(lVar.f(A2, "latitude"), lVar.f(A2, "longitude")));
                            }
                        }
                        String b4 = com.bxkj.student.run.app.utils.i.b(Double.parseDouble(r11.A()), Long.parseLong(r11.z()));
                        f0.o(b4, "calPace(it.distance.toDo\u2026), it.countTime.toLong())");
                        gVar.c0(b4);
                        gVar.h().setValue(kotlin.coroutines.jvm.internal.a.f(Integer.parseInt(r11.E())));
                        gVar.i().setValue(kotlin.coroutines.jvm.internal.a.a(Boolean.parseBoolean(r11.T())));
                        gVar.L();
                        List latLngList = JSON.parseArray(r11.H(), PointData.class);
                        gVar.p().clear();
                        List<PointData> p3 = gVar.p();
                        f0.o(latLngList, "latLngList");
                        p3.addAll(latLngList);
                        List list2 = latLngList.size() > 0 ? latLngList : null;
                        if (list2 != null) {
                            PointData pointData = (PointData) list2.get(list2.size() - 1);
                            if (pointData != null) {
                                pointData.setI(true);
                            }
                            LatLng latLng = new LatLng(((PointData) latLngList.get(0)).getA(), ((PointData) latLngList.get(0)).getO());
                            gVar.g0(latLng);
                            gVar.J(latLng);
                        }
                        List stepCountList = JSON.parseArray(r11.P(), Integer.TYPE);
                        gVar.z().clear();
                        List<Integer> z3 = gVar.z();
                        f0.o(stepCountList, "stepCountList");
                        z3.addAll(stepCountList);
                        List<Integer> list3 = stepCountList.size() > 0 ? stepCountList : null;
                        if (list3 != null) {
                            for (Integer step : list3) {
                                f0.o(step, "step");
                                i5 += step.intValue();
                            }
                            b.g gVar2 = com.bxkj.student.v2.common.data.b.a;
                            gVar2.i0(i5);
                            gVar2.K(i5);
                        }
                    }
                }
            }
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeLocalData$2", f = "SportsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class i extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24603a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.l<c0.c, f1> f24604b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<c0.c> f24605c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        i(l1.l<? super c0.c, f1> lVar, Ref.ObjectRef<c0.c> objectRef, kotlin.coroutines.c<? super i> cVar) {
            super(1, cVar);
            this.f24604b = lVar;
            this.f24605c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new i(this.f24604b, this.f24605c, cVar);
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
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24603a == 0) {
                d0.n(obj);
                this.f24604b.invoke(this.f24605c.element);
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$saveToLocal$1", f = "SportsVM.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class j extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24606a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24608c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24609d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24610e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, String str2, l1.a<f1> aVar, kotlin.coroutines.c<? super j> cVar) {
            super(1, cVar);
            this.f24608c = str;
            this.f24609d = str2;
            this.f24610e = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new j(this.f24608c, this.f24609d, this.f24610e, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((j) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24606a;
            if (i4 == 0) {
                d0.n(obj);
                String t3 = com.bxkj.base.v2.common.utils.l.f18624a.t(SportsVM.this.B(), "identify");
                long currentTimeMillis = System.currentTimeMillis();
                com.bxkj.student.v2.repository.sports.g A = SportsVM.this.A();
                String str = this.f24608c;
                String str2 = this.f24609d;
                String valueOf = String.valueOf(currentTimeMillis);
                this.f24606a = 1;
                if (A.g(str, str2, valueOf, t3, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24610e.invoke();
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class k extends Lambda implements l1.a<com.bxkj.student.v2.repository.sports.g> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f24611a = new k();

        k() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.sports.g invoke() {
            return new com.bxkj.student.v2.repository.sports.g();
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeLocalData$2", f = "SportsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class l extends SuspendLambda implements d2.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24612a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d2.l<c0.c, f1> f24613b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<c0.c> f24614c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        l(d2.l<? super c0.c, f1> lVar, Ref.ObjectRef<c0.c> objectRef, kotlin.coroutines.c<? super l> cVar) {
            super(1, cVar);
            this.f24613b = lVar;
            this.f24614c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new l(this.f24613b, this.f24614c, cVar);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: e */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((l) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24612a == 0) {
                d0.n(obj);
                this.f24613b.invoke(this.f24614c.element);
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$saveToLocal$1", f = "SportsVM.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class m extends SuspendLambda implements d2.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24615a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24617c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24618d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d2.a<f1> f24619e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, String str2, d2.a<f1> aVar, kotlin.coroutines.c<? super m> cVar) {
            super(1, cVar);
            this.f24617c = str;
            this.f24618d = str2;
            this.f24619e = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new m(this.f24617c, this.f24618d, this.f24619e, cVar);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: e */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((m) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24615a;
            if (i4 == 0) {
                d0.n(obj);
                String t3 = com.bxkj.base.v2.common.utils.m.a.t(SportsVM.this.D(), "identify");
                long currentTimeMillis = System.currentTimeMillis();
                com.bxkj.student.v2.repository.sports.g w3 = SportsVM.w(SportsVM.this);
                String str = this.f24617c;
                String str2 = this.f24618d;
                String valueOf = String.valueOf(currentTimeMillis);
                this.f24615a = 1;
                if (w3.g(str, str2, valueOf, t3, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24619e.invoke();
            return f1.f55527a;
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/e;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class n extends Lambda implements d2.a<com.bxkj.student.v2.repository.sports.e> {

        /* renamed from: a  reason: collision with root package name */
        public static final n f24620a = new n();

        n() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.sports.e invoke() {
            return new com.bxkj.student.v2.repository.sports.e();
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class o extends Lambda implements d2.a<com.bxkj.student.v2.repository.sports.g> {

        /* renamed from: a  reason: collision with root package name */
        public static final o f24621a = new o();

        o() {
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
    public final com.bxkj.student.v2.repository.sports.g A() {
        return (com.bxkj.student.v2.repository.sports.g) this.f24557j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.face.c y() {
        return (com.bxkj.student.v2.repository.face.c) this.f24558k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.b z() {
        return (com.bxkj.student.v2.repository.sports.b) this.f24556i.getValue();
    }

    @NotNull
    public final Map<String, Object> B() {
        return this.f24555h;
    }

    public final void C(@NotNull String identify, @NotNull String remark, @NotNull File cameraFile, @NotNull l1.a<f1> result) {
        f0.p(identify, "identify");
        f0.p(remark, "remark");
        f0.p(cameraFile, "cameraFile");
        f0.p(result, "result");
        BaseViewModel.j(this, new e(identify, remark, cameraFile, result, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void D(@NotNull String identify, @NotNull String remark, @NotNull File cameraFile, @NotNull l1.a<f1> result) {
        f0.p(identify, "identify");
        f0.p(remark, "remark");
        f0.p(cameraFile, "cameraFile");
        f0.p(result, "result");
        BaseViewModel.j(this, new f(identify, remark, cameraFile, result, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void E(@NotNull String identify, @NotNull l1.l<? super c0.c, f1> complete) {
        f0.p(identify, "identify");
        f0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.l(this, new h(identify, objectRef, null), null, null, null, new i(complete, objectRef, null), null, 46, null);
    }

    public final void F(@NotNull String isValid, @NotNull String isException, @NotNull l1.a<f1> success) {
        f0.p(isValid, "isValid");
        f0.p(isException, "isException");
        f0.p(success, "success");
        BaseViewModel.l(this, new j(isException, isValid, success, null), null, null, null, null, null, 62, null);
    }

    public final void G(@NotNull Map<String, Object> map) {
        f0.p(map, "<set-?>");
        this.f24555h = map;
    }

    public final void w(@NotNull String isValid, @NotNull String isException, @NotNull p<? super String, ? super String, f1> success, @NotNull l1.a<f1> fail) {
        f0.p(isValid, "isValid");
        f0.p(isException, "isException");
        f0.p(success, "success");
        f0.p(fail, "fail");
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        Map<String, ? extends Object> map = this.f24555h;
        String uuid = UUID.randomUUID().toString();
        f0.o(uuid, "randomUUID().toString()");
        String u3 = lVar.u(map, "identify", uuid);
        b.g gVar = com.bxkj.student.v2.common.data.b.a;
        long x3 = gVar.x();
        long currentTimeMillis = System.currentTimeMillis();
        long d4 = gVar.d();
        List<Map<String, Object>> n4 = lVar.n(this.f24555h, "list");
        com.orhanobut.logger.j.d(f0.C("sportsSetMap=", this.f24555h), new Object[0]);
        com.orhanobut.logger.j.d("\u590d\u6838\u8ddd\u79bb=" + ((Object) com.bxkj.student.run.app.utils.i.c(gVar.f())) + "\n\u8f68\u8ff9\u8ddd\u79bb=" + ((Object) com.bxkj.student.run.app.utils.i.c(gVar.l())), new Object[0]);
        BaseViewModel.j(this, new a(u3, x3, currentTimeMillis, d4, n4, success, null), null, new b(isException, isValid, currentTimeMillis, u3, fail, null), null, null, null, null, null, 250, null);
    }

    public final void x(@NotNull l1.a<f1> success) {
        f0.p(success, "success");
        BaseViewModel.j(this, new c(success, null), null, null, null, null, null, null, null, 254, null);
    }
}
