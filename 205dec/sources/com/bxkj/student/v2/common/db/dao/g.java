package com.bxkj.student.v2.common.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SportsSetDao.kt */
@Dao
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/bxkj/student/v2/common/db/dao/g;", "", "Lc0/d;", "sportsSetDb", "Lkotlin/f1;", "insert", "(Lc0/d;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "userId", "type", "", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface g {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsSetDao.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: SportsSetDao.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.bxkj.student.v2.common.db.dao.SportsSetDao$DefaultImpls", f = "SportsSetDao.kt", i = {}, l = {21}, m = "getSportsSet", n = {}, s = {})
        /* renamed from: com.bxkj.student.v2.common.db.dao.g$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class C0292a extends ContinuationImpl {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f23308a;

            /* renamed from: b  reason: collision with root package name */
            int f23309b;

            C0292a(kotlin.coroutines.c<? super C0292a> cVar) {
                super(cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f23308a = obj;
                this.f23309b |= Integer.MIN_VALUE;
                return a.a(null, null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object a(@org.jetbrains.annotations.NotNull com.bxkj.student.v2.common.db.dao.g r4, @org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.String> r6) {
            /*
                boolean r0 = r6 instanceof com.bxkj.student.v2.common.db.dao.g.a.C0292a
                if (r0 == 0) goto L13
                r0 = r6
                com.bxkj.student.v2.common.db.dao.g$a$a r0 = (com.bxkj.student.v2.common.db.dao.g.a.C0292a) r0
                int r1 = r0.f23309b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f23309b = r1
                goto L18
            L13:
                com.bxkj.student.v2.common.db.dao.g$a$a r0 = new com.bxkj.student.v2.common.db.dao.g$a$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f23308a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
                int r2 = r0.f23309b
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.d0.n(r6)
                goto L47
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                kotlin.d0.n(r6)
                com.bxkj.base.v2.data.a$b r6 = com.bxkj.base.v2.data.a.f18673h
                com.bxkj.base.v2.data.a r6 = r6.a()
                java.lang.String r6 = r6.B()
                r0.f23309b = r3
                java.lang.Object r6 = r4.a(r6, r5, r0)
                if (r6 != r1) goto L47
                return r1
            L47:
                java.util.List r6 = (java.util.List) r6
                java.lang.String r4 = ""
                if (r6 != 0) goto L4e
                goto L5f
            L4e:
                java.lang.Object r5 = kotlin.collections.w.r2(r6)
                c0.d r5 = (c0.d) r5
                if (r5 != 0) goto L57
                goto L5f
            L57:
                java.lang.String r5 = r5.f()
                if (r5 != 0) goto L5e
                goto L5f
            L5e:
                r4 = r5
            L5f:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.db.dao.g.a.a(com.bxkj.student.v2.common.db.dao.g, java.lang.String, kotlin.coroutines.c):java.lang.Object");
        }
    }

    @Query("SELECT * FROM sports_set WHERE userId = :userId AND type =:type")
    @Nullable
    Object a(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.c<? super List<c0.d>> cVar);

    @Nullable
    Object b(@NotNull String str, @NotNull kotlin.coroutines.c<? super String> cVar);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull c0.d dVar, @NotNull kotlin.coroutines.c<? super f1> cVar);
}
