package com.bxkj.base.user;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface UserPreferenceMode {
    public static final int CARD = 1;
    public static final int CODE = 3;
    public static final int FACE = 4;
    public static final int ID_CARD = 2;
    public static final int INPUT = 0;
}
