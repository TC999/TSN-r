package com.bxkj.base.user;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface UserPreferenceMode {
    public static final int CARD = 1;
    public static final int CODE = 3;
    public static final int FACE = 4;
    public static final int ID_CARD = 2;
    public static final int INPUT = 0;
}
