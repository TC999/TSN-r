package com.bxkj.base.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface AuthType {
    public static final int DONATION = 5;
    public static final int JOB = 3;
    public static final int LOST = 1;
    public static final int MALL = 0;
    public static final int RUNNER = 4;
    public static final int SECOND_HAND = 2;
}
