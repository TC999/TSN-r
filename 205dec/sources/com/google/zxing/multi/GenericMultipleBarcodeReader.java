package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i4, int i5, int i6) {
        boolean z3;
        float f4;
        float f5;
        int i7;
        int i8;
        int i9;
        int i10;
        if (i6 > 4) {
            return;
        }
        try {
            Result decode = this.delegate.decode(binaryBitmap, map);
            Iterator<Result> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getText().equals(decode.getText())) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3) {
                list.add(translateResultPoints(decode, i4, i5));
            }
            ResultPoint[] resultPoints = decode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f6 = width;
            float f7 = height;
            float f8 = 0.0f;
            float f9 = 0.0f;
            for (ResultPoint resultPoint : resultPoints) {
                if (resultPoint != null) {
                    float x3 = resultPoint.getX();
                    float y3 = resultPoint.getY();
                    if (x3 < f6) {
                        f6 = x3;
                    }
                    if (y3 < f7) {
                        f7 = y3;
                    }
                    if (x3 > f8) {
                        f8 = x3;
                    }
                    if (y3 > f9) {
                        f9 = y3;
                    }
                }
            }
            if (f6 > 100.0f) {
                f4 = f8;
                f5 = f7;
                i7 = height;
                i8 = width;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f6, height), map, list, i4, i5, i6 + 1);
            } else {
                f4 = f8;
                f5 = f7;
                i7 = height;
                i8 = width;
            }
            if (f5 > 100.0f) {
                int i11 = (int) f5;
                i9 = i8;
                doDecodeMultiple(binaryBitmap.crop(0, 0, i9, i11), map, list, i4, i5, i6 + 1);
            } else {
                i9 = i8;
            }
            float f10 = f4;
            if (f10 < i9 - 100) {
                int i12 = (int) f10;
                i10 = i7;
                doDecodeMultiple(binaryBitmap.crop(i12, 0, i9 - i12, i10), map, list, i4 + i12, i5, i6 + 1);
            } else {
                i10 = i7;
            }
            if (f9 < i10 - 100) {
                int i13 = (int) f9;
                doDecodeMultiple(binaryBitmap.crop(0, i13, i9, i10 - i13), map, list, i4, i5 + i13, i6 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    private static Result translateResultPoints(Result result, int i4, int i5) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i6 = 0; i6 < resultPoints.length; i6++) {
            ResultPoint resultPoint = resultPoints[i6];
            if (resultPoint != null) {
                resultPointArr[i6] = new ResultPoint(resultPoint.getX() + i4, resultPoint.getY() + i5);
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
