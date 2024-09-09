package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ByQuadrantReader implements Reader {
    private final Reader delegate;

    public ByQuadrantReader(Reader reader) {
        this.delegate = reader;
    }

    private static void makeAbsolute(ResultPoint[] resultPointArr, int i4, int i5) {
        if (resultPointArr != null) {
            for (int i6 = 0; i6 < resultPointArr.length; i6++) {
                ResultPoint resultPoint = resultPointArr[i6];
                resultPointArr[i6] = new ResultPoint(resultPoint.getX() + i4, resultPoint.getY() + i5);
            }
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.delegate.reset();
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int width = binaryBitmap.getWidth() / 2;
        int height = binaryBitmap.getHeight() / 2;
        try {
            try {
                try {
                    try {
                        return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), map);
                    } catch (NotFoundException unused) {
                        Result decode = this.delegate.decode(binaryBitmap.crop(width, 0, width, height), map);
                        makeAbsolute(decode.getResultPoints(), width, 0);
                        return decode;
                    }
                } catch (NotFoundException unused2) {
                    Result decode2 = this.delegate.decode(binaryBitmap.crop(0, height, width, height), map);
                    makeAbsolute(decode2.getResultPoints(), 0, height);
                    return decode2;
                }
            } catch (NotFoundException unused3) {
                Result decode3 = this.delegate.decode(binaryBitmap.crop(width, height, width, height), map);
                makeAbsolute(decode3.getResultPoints(), width, height);
                return decode3;
            }
        } catch (NotFoundException unused4) {
            int i4 = width / 2;
            int i5 = height / 2;
            Result decode4 = this.delegate.decode(binaryBitmap.crop(i4, i5, width, height), map);
            makeAbsolute(decode4.getResultPoints(), i4, i5);
            return decode4;
        }
    }
}
