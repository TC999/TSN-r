package com.bxkj.base.v2.http.result;

import com.bxkj.base.v2.http.exception.ApiException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ApiResult.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\bJ\r\u0010\u000f\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u00c2\u0003\u00a2\u0006\u0002\u0010\u0010J8\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0006H\u00d6\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/bxkj/base/v2/http/result/ApiResult;", "T", "", "code", "", "msg", "", "data", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Ljava/lang/Object;", "getMsg", "()Ljava/lang/String;", "apiData", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)Lcom/bxkj/base/v2/http/result/ApiResult;", "equals", "", "other", "hashCode", "toString", "base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ApiResult<T> {
    @Nullable
    private final Integer code;
    @Nullable
    private final T data;
    @Nullable
    private final String msg;

    public ApiResult(@Nullable Integer num, @Nullable String str, @Nullable T t3) {
        this.code = num;
        this.msg = str;
        this.data = t3;
    }

    private final T component3() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResult copy$default(ApiResult apiResult, Integer num, String str, Object obj, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            num = apiResult.code;
        }
        if ((i4 & 2) != 0) {
            str = apiResult.msg;
        }
        if ((i4 & 4) != 0) {
            obj = apiResult.data;
        }
        return apiResult.copy(num, str, obj);
    }

    @Nullable
    public final T apiData() {
        Integer num = this.code;
        if (num != null && num.intValue() == 0) {
            return this.data;
        }
        throw new ApiException(this.code, this.msg);
    }

    @Nullable
    public final Integer component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.msg;
    }

    @NotNull
    public final ApiResult<T> copy(@Nullable Integer num, @Nullable String str, @Nullable T t3) {
        return new ApiResult<>(num, str, t3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApiResult) {
            ApiResult apiResult = (ApiResult) obj;
            return f0.g(this.code, apiResult.code) && f0.g(this.msg, apiResult.msg) && f0.g(this.data, apiResult.data);
        }
        return false;
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        Integer num = this.code;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t3 = this.data;
        return hashCode2 + (t3 != null ? t3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ApiResult(code=" + this.code + ", msg=" + ((Object) this.msg) + ", data=" + this.data + ')';
    }
}
