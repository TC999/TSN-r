package io.netty.handler.codec;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface ValueConverter<T> {
    T convertBoolean(boolean z3);

    T convertByte(byte b4);

    T convertChar(char c4);

    T convertDouble(double d4);

    T convertFloat(float f4);

    T convertInt(int i4);

    T convertLong(long j4);

    T convertObject(Object obj);

    T convertShort(short s3);

    T convertTimeMillis(long j4);

    boolean convertToBoolean(T t3);

    byte convertToByte(T t3);

    char convertToChar(T t3);

    double convertToDouble(T t3);

    float convertToFloat(T t3);

    int convertToInt(T t3);

    long convertToLong(T t3);

    short convertToShort(T t3);

    long convertToTimeMillis(T t3);
}
