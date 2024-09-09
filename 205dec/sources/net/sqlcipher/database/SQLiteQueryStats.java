package net.sqlcipher.database;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SQLiteQueryStats {
    long largestIndividualRowSize;
    long totalQueryResultSize;

    public SQLiteQueryStats(long j4, long j5) {
        this.totalQueryResultSize = j4;
        this.largestIndividualRowSize = j5;
    }

    public long getLargestIndividualRowSize() {
        return this.largestIndividualRowSize;
    }

    public long getTotalQueryResultSize() {
        return this.totalQueryResultSize;
    }
}
