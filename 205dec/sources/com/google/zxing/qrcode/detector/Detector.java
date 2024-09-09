package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        return Float.isNaN(sizeOfBlackWhiteBlackRunBothWays) ? sizeOfBlackWhiteBlackRunBothWays2 / 7.0f : Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2) ? sizeOfBlackWhiteBlackRunBothWays / 7.0f : (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f4) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f4) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f4)) / 2) + 7;
        int i4 = round & 3;
        if (i4 != 0) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return round;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            return round - 1;
        }
        return round + 1;
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i4) {
        float x3;
        float y3;
        float f4;
        float f5 = i4 - 3.5f;
        if (resultPoint4 != null) {
            x3 = resultPoint4.getX();
            y3 = resultPoint4.getY();
            f4 = f5 - 3.0f;
        } else {
            x3 = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y3 = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f4 = f5;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f5, 3.5f, f4, f4, 3.5f, f5, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x3, y3, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i4) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i4, i4, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Detector detector;
        boolean z3;
        boolean z4;
        int i13 = 1;
        boolean z5 = Math.abs(i7 - i5) > Math.abs(i6 - i4);
        if (z5) {
            i9 = i4;
            i8 = i5;
            i11 = i6;
            i10 = i7;
        } else {
            i8 = i4;
            i9 = i5;
            i10 = i6;
            i11 = i7;
        }
        int abs = Math.abs(i10 - i8);
        int abs2 = Math.abs(i11 - i9);
        int i14 = (-abs) / 2;
        int i15 = i8 < i10 ? 1 : -1;
        int i16 = i9 < i11 ? 1 : -1;
        int i17 = i10 + i15;
        int i18 = i8;
        int i19 = i9;
        int i20 = 0;
        while (true) {
            if (i18 == i17) {
                i12 = i17;
                break;
            }
            int i21 = z5 ? i19 : i18;
            int i22 = z5 ? i18 : i19;
            if (i20 == i13) {
                detector = this;
                z3 = z5;
                i12 = i17;
                z4 = true;
            } else {
                detector = this;
                z3 = z5;
                i12 = i17;
                z4 = false;
            }
            if (z4 == detector.image.get(i21, i22)) {
                if (i20 == 2) {
                    return MathUtils.distance(i18, i19, i8, i9);
                }
                i20++;
            }
            i14 += abs2;
            if (i14 > 0) {
                if (i19 == i11) {
                    break;
                }
                i19 += i16;
                i14 -= abs;
            }
            i18 += i15;
            i17 = i12;
            z5 = z3;
            i13 = 1;
        }
        if (i20 == 2) {
            return MathUtils.distance(i12, i11, i8, i9);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i4, int i5, int i6, int i7) {
        float f4;
        float f5;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i4, i5, i6, i7);
        int i8 = i4 - (i6 - i4);
        int i9 = 0;
        if (i8 < 0) {
            f4 = i4 / (i4 - i8);
            i8 = 0;
        } else if (i8 >= this.image.getWidth()) {
            f4 = ((this.image.getWidth() - 1) - i4) / (i8 - i4);
            i8 = this.image.getWidth() - 1;
        } else {
            f4 = 1.0f;
        }
        float f6 = i5;
        int i10 = (int) (f6 - ((i7 - i5) * f4));
        if (i10 < 0) {
            f5 = f6 / (i5 - i10);
        } else if (i10 >= this.image.getHeight()) {
            f5 = ((this.image.getHeight() - 1) - i5) / (i10 - i5);
            i9 = this.image.getHeight() - 1;
        } else {
            i9 = i10;
            f5 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i4, i5, (int) (i4 + ((i8 - i4) * f5)), i9)) - 1.0f;
    }

    protected final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect(null);
    }

    protected final AlignmentPattern findAlignmentInRegion(float f4, int i4, int i5, float f5) throws NotFoundException {
        int i6 = (int) (f5 * f4);
        int max = Math.max(0, i4 - i6);
        int min = Math.min(this.image.getWidth() - 1, i4 + i6) - max;
        float f6 = 3.0f * f4;
        if (min >= f6) {
            int max2 = Math.max(0, i5 - i6);
            int min2 = Math.min(this.image.getHeight() - 1, i5 + i6) - max2;
            if (min2 >= f6) {
                return new AlignmentPatternFinder(this.image, max, max2, min, min2, f4, this.resultPointCallback).find();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.image;
    }

    protected final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize >= 1.0f) {
            int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
            Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
            int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
            AlignmentPattern alignmentPattern = null;
            if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                float x3 = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
                float y3 = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
                float f4 = 1.0f - (3.0f / dimensionForVersion);
                int x4 = (int) (topLeft.getX() + ((x3 - topLeft.getX()) * f4));
                int y4 = (int) (topLeft.getY() + (f4 * (y3 - topLeft.getY())));
                for (int i4 = 4; i4 <= 16; i4 <<= 1) {
                    try {
                        alignmentPattern = findAlignmentInRegion(calculateModuleSize, x4, y4, i4);
                        break;
                    } catch (NotFoundException unused) {
                    }
                }
            }
            return new DetectorResult(sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPattern, computeDimension), computeDimension), alignmentPattern == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern});
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.resultPointCallback = resultPointCallback;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback).find(map));
    }
}
