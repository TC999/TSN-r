package com.bxkj.student;

import cn.bluemobi.dylan.http.HttpJsonKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/h;", "Lcn/bluemobi/dylan/http/HttpJsonKey;", "", "getCode", "getData", "getMsg", "", "getSuccessCode", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class NewHttpJsonKey implements HttpJsonKey {
    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    @NotNull
    public String getCode() {
        return "code";
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    @NotNull
    public String getData() {
        return "data";
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    @NotNull
    public String getMsg() {
        return "message";
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    public int getSuccessCode() {
        return 0;
    }
}
