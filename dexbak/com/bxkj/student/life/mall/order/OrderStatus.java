package com.bxkj.student.life.mall.order;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface OrderStatus {
    public static final int AFTER_SALES = 7;
    public static final int CANCEL = 5;
    public static final int CLOSE = 6;
    public static final int COMPLETE = 4;
    public static final int WAIT_ACCEPT = 3;
    public static final int WAIT_DELIVEDER = 2;
    public static final int WAIT_PAY = 1;
}
