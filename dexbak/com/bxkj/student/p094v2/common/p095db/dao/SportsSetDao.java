package com.bxkj.student.p094v2.common.p095db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsSetDb;

@Dao
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m12616d2 = {"Lcom/bxkj/student/v2/common/db/dao/g;", "", "Lc0/d;", "sportsSetDb", "Lkotlin/f1;", "insert", "(Lc0/d;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "userId", "type", "", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.db.dao.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface SportsSetDao {

    /* compiled from: SportsSetDao.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* renamed from: com.bxkj.student.v2.common.db.dao.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5531a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SportsSetDao.kt */
        @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
        @DebugMetadata(m8639c = "com.bxkj.student.v2.common.db.dao.SportsSetDao$DefaultImpls", m8638f = "SportsSetDao.kt", m8637i = {}, m8636l = {21}, m8635m = "getSportsSet", m8634n = {}, m8633s = {})
        /* renamed from: com.bxkj.student.v2.common.db.dao.g$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5532a extends ContinuationImpl {

            /* renamed from: a */
            /* synthetic */ Object f20063a;

            /* renamed from: b */
            int f20064b;

            C5532a(InterfaceC14268c<? super C5532a> interfaceC14268c) {
                super(interfaceC14268c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f20063a = obj;
                this.f20064b |= Integer.MIN_VALUE;
                return C5531a.m39161a(null, null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object m39161a(@org.jetbrains.annotations.NotNull com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao r4, @org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.lang.String> r6) {
            /*
                boolean r0 = r6 instanceof com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao.C5531a.C5532a
                if (r0 == 0) goto L13
                r0 = r6
                com.bxkj.student.v2.common.db.dao.g$a$a r0 = (com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao.C5531a.C5532a) r0
                int r1 = r0.f20064b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f20064b = r1
                goto L18
            L13:
                com.bxkj.student.v2.common.db.dao.g$a$a r0 = new com.bxkj.student.v2.common.db.dao.g$a$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f20063a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r2 = r0.f20064b
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.C14294d0.m8596n(r6)
                goto L47
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                kotlin.C14294d0.m8596n(r6)
                com.bxkj.base.v2.data.a$b r6 = com.bxkj.base.p085v2.data.LoggedInUser.f15182b
                com.bxkj.base.v2.data.a r6 = r6.m43634a()
                java.lang.String r6 = r6.m43642t()
                r0.f20064b = r3
                java.lang.Object r6 = r4.mo39160a(r6, r5, r0)
                if (r6 != r1) goto L47
                return r1
            L47:
                java.util.List r6 = (java.util.List) r6
                java.lang.String r4 = ""
                if (r6 != 0) goto L4e
                goto L5f
            L4e:
                java.lang.Object r5 = kotlin.collections.C14233v.m8987t2(r6)
                c0.d r5 = (p027c0.SportsSetDb) r5
                if (r5 != 0) goto L57
                goto L5f
            L57:
                java.lang.String r5 = r5.m58056f()
                if (r5 != 0) goto L5e
                goto L5f
            L5e:
                r4 = r5
            L5f:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao.C5531a.m39161a(com.bxkj.student.v2.common.db.dao.g, java.lang.String, kotlin.coroutines.c):java.lang.Object");
        }
    }

    @Query("SELECT * FROM sports_set WHERE userId = :userId AND type =:type")
    @Nullable
    /* renamed from: a */
    Object mo39160a(@NotNull String str, @NotNull String str2, @NotNull InterfaceC14268c<? super List<SportsSetDb>> interfaceC14268c);

    @Nullable
    /* renamed from: b */
    Object mo39159b(@NotNull String str, @NotNull InterfaceC14268c<? super String> interfaceC14268c);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull SportsSetDb sportsSetDb, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);
}
