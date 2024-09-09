package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    private static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit != null && bottomRightOnBit != null) {
            float moduleSize = moduleSize(topLeftOnBit, bitMatrix);
            int i4 = topLeftOnBit[1];
            int i5 = bottomRightOnBit[1];
            int i6 = topLeftOnBit[0];
            int i7 = bottomRightOnBit[0];
            if (i6 < i7 && i4 < i5) {
                int i8 = i5 - i4;
                if (i8 != i7 - i6 && (i7 = i6 + i8) >= bitMatrix.getWidth()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int round = Math.round(((i7 - i6) + 1) / moduleSize);
                int round2 = Math.round((i8 + 1) / moduleSize);
                if (round <= 0 || round2 <= 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (round2 == round) {
                    int i9 = (int) (moduleSize / 2.0f);
                    int i10 = i4 + i9;
                    int i11 = i6 + i9;
                    int i12 = (((int) ((round - 1) * moduleSize)) + i11) - i7;
                    if (i12 > 0) {
                        if (i12 > i9) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i11 -= i12;
                    }
                    int i13 = (((int) ((round2 - 1) * moduleSize)) + i10) - i5;
                    if (i13 > 0) {
                        if (i13 > i9) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i10 -= i13;
                    }
                    BitMatrix bitMatrix2 = new BitMatrix(round, round2);
                    for (int i14 = 0; i14 < round2; i14++) {
                        int i15 = ((int) (i14 * moduleSize)) + i10;
                        for (int i16 = 0; i16 < round; i16++) {
                            if (bitMatrix.get(((int) (i16 * moduleSize)) + i11, i15)) {
                                bitMatrix2.set(i16, i14);
                            }
                        }
                    }
                    return bitMatrix2;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i4 = iArr[0];
        boolean z3 = true;
        int i5 = iArr[1];
        int i6 = 0;
        while (i4 < width && i5 < height) {
            if (z3 != bitMatrix.get(i4, i5)) {
                i6++;
                if (i6 == 5) {
                    break;
                }
                z3 = !z3;
            }
            i4++;
            i5++;
        }
        if (i4 != width && i5 != height) {
            return (i4 - iArr[0]) / 7.0f;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Decoder getDecoder() {
        return this.decoder;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        ResultPoint[] points;
        DecoderResult decoderResult;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            decoderResult = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            points = NO_POINTS;
        } else {
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            DecoderResult decode = this.decoder.decode(detect.getBits(), map);
            points = detect.getPoints();
            decoderResult = decode;
        }
        if (decoderResult.getOther() instanceof QRCodeDecoderMetaData) {
            ((QRCodeDecoderMetaData) decoderResult.getOther()).applyMirroredCorrection(points);
        }
        Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), points, BarcodeFormat.QR_CODE);
        List<byte[]> byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decoderResult.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decoderResult.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResult.getStructuredAppendSequenceNumber()));
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResult.getStructuredAppendParity()));
        }
        return result;
    }
}
