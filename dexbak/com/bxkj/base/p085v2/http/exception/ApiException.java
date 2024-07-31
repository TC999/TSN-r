package com.bxkj.base.p085v2.http.exception;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiException.kt */
@Metadata(m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m12616d2 = {"Lcom/bxkj/base/v2/http/exception/ApiException;", "Ljava/lang/RuntimeException;", "code", "", "message", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
/* renamed from: com.bxkj.base.v2.http.exception.ApiException */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ApiException extends RuntimeException {
    @Nullable
    private Integer code;
    @Nullable
    private String message;

    public ApiException(@Nullable Integer num, @Nullable String str) {
        this.code = num;
        this.message = str;
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        return this.message;
    }

    public final void setCode(@Nullable Integer num) {
        this.code = num;
    }

    public void setMessage(@Nullable String str) {
        this.message = str;
    }
}
