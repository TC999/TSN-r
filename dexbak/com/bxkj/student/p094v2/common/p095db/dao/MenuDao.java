package com.bxkj.student.p094v2.common.p095db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.MenuDb;

@Dao
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010J#\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0010J\u001b\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H§@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H§@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\rJ\u001b\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H§@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0017J#\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m12616d2 = {"Lcom/bxkj/student/v2/common/db/dao/c;", "", "", "Lc0/b;", "menu", "Lkotlin/f1;", "a", "([Lc0/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "(Lc0/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "mkey", "j", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", RewardPlus.ICON, "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "type", "e", "iconS", "c", "", "i", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "menuType", "g", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", "d", "h", "", "k", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.db.dao.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface MenuDao {
    @Insert(onConflict = 1)
    @Nullable
    /* renamed from: a */
    Object mo39204a(@NotNull MenuDb[] menuDbArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("UPDATE menu SET icon=:icon WHERE mkey=:mkey")
    @Nullable
    /* renamed from: b */
    Object mo39203b(@NotNull String str, @NotNull String str2, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("UPDATE menu SET iconS=:iconS WHERE mkey=:mkey")
    @Nullable
    /* renamed from: c */
    Object mo39202c(@NotNull String str, @NotNull String str2, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("SELECT * FROM menu WHERE type=:menuType Order By cast(sort as INTEGER)")
    @Nullable
    /* renamed from: d */
    Object mo39201d(@NotNull String str, @NotNull InterfaceC14268c<? super List<MenuDb>> interfaceC14268c);

    @Query("UPDATE menu SET type=:type WHERE mkey=:mkey")
    @Nullable
    /* renamed from: e */
    Object mo39200e(@NotNull String str, @NotNull String str2, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Delete
    @Nullable
    /* renamed from: f */
    Object mo39199f(@NotNull MenuDb menuDb, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("DELETE  FROM menu WHERE type=:menuType")
    @Nullable
    /* renamed from: g */
    Object mo39198g(int i, @NotNull InterfaceC14268c<? super Integer> interfaceC14268c);

    @Query("SELECT * FROM menu WHERE isShowIndex='1' Order By cast(homeSort as INTEGER)")
    @Nullable
    /* renamed from: h */
    Object mo39197h(@NotNull InterfaceC14268c<? super List<MenuDb>> interfaceC14268c);

    @Query("SELECT * FROM menu")
    @Nullable
    /* renamed from: i */
    Object mo39196i(@NotNull InterfaceC14268c<? super List<MenuDb>> interfaceC14268c);

    @Query("DELETE FROM menu WHERE mkey=:mkey")
    @Nullable
    /* renamed from: j */
    Object mo39195j(@NotNull String str, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("SELECT * FROM menu WHERE mkey=:mkey")
    @Nullable
    /* renamed from: k */
    Object mo39194k(@NotNull String str, @NotNull InterfaceC14268c<? super List<MenuDb>> interfaceC14268c);
}
