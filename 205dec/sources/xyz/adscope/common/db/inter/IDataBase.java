package xyz.adscope.common.db.inter;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IDataBase<T> {
    int delete(T t3);

    Long insert(T t3);

    List<T> query(T t3);

    List<T> query(T t3, String str, String str2);

    int update(T t3, T t4);
}
