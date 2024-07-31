package net.sqlcipher.database;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SQLiteQueryStats {
    long largestIndividualRowSize;
    long totalQueryResultSize;

    public SQLiteQueryStats(long j, long j2) {
        this.totalQueryResultSize = j;
        this.largestIndividualRowSize = j2;
    }

    public long getLargestIndividualRowSize() {
        return this.largestIndividualRowSize;
    }

    public long getTotalQueryResultSize() {
        return this.totalQueryResultSize;
    }
}
