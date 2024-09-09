package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface Writer {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5) throws WriterException;

    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) throws WriterException;
}
