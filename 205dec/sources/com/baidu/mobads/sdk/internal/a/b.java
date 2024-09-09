package com.baidu.mobads.sdk.internal.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {
    public int a(Object[] objArr, int i4, int i5) {
        return (objArr == null || objArr.length <= i4 || !(objArr[i4] instanceof Integer)) ? i5 : ((Integer) objArr[i4]).intValue();
    }

    public Object a(Object[] objArr, int i4, Object obj) {
        Object obj2;
        return (objArr == null || objArr.length <= i4 || (obj2 = objArr[i4]) == null) ? obj : obj2;
    }
}
