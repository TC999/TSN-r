package com.bxkj.base.v2.common.utils;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LocationObserver.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J#\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/base/v2/common/utils/m;", "", "", "latitude", "longitude", "Lkotlin/f1;", "a", "", "errorCode", "", "errorMessage", "b", "(Ljava/lang/Integer;Ljava/lang/String;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface m {

    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"com/bxkj/base/v2/common/utils/m$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class a extends TypeToken<List<? extends List<? extends Map<String, ? extends Object>>>> {
        a() {
        }
    }

    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"com/bxkj/base/v2/common/utils/m$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b extends TypeToken<List<? extends Map<String, ? extends Object>>> {
        b() {
        }
    }

    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"com/bxkj/base/v2/common/utils/m$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class c extends TypeToken<Map<String, ? extends Object>> {
        c() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: JsonGet.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0002"}, d2 = {"com/bxkj/base/v2/common/utils/m$d", "Lcom/google/gson/reflect/TypeToken;", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class d<T> extends TypeToken<T> {
    }

    void a(double d4, double d5);

    void b(@Nullable Integer num, @Nullable String str);
}
