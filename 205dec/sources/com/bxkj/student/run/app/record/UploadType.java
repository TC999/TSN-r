package com.bxkj.student.run.app.record;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface UploadType {
    public static final int EXCEPTION = 2;
    public static final int EXIT = 1;
    public static final int KEEP = 4;
    public static final int NORMAL = 0;
    public static final int TIME_OUT = 3;
}
