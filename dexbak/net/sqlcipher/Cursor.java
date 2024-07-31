package net.sqlcipher;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Cursor extends android.database.Cursor {
    public static final int FIELD_TYPE_BLOB = 4;
    public static final int FIELD_TYPE_FLOAT = 2;
    public static final int FIELD_TYPE_INTEGER = 1;
    public static final int FIELD_TYPE_NULL = 0;
    public static final int FIELD_TYPE_STRING = 3;

    @Override // net.sqlcipher.Cursor
    int getType(int i);
}
