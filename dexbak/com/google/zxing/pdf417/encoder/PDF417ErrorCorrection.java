package com.google.zxing.pdf417.encoder;

import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import cn.bluemobi.dylan.http.BuildConfig;
import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.umeng.commonsdk.stateless.UMSLNetWorkSender;
import okhttp3.internal.http.StatusLine;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, TTAdConstant.STYLE_SIZE_RADIO_9_16, 232, 755, 599, 524, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 295, 116, 442, 428, 295, 42, Opcodes.ARETURN, 65}, new int[]{361, 575, 922, 525, Opcodes.ARETURN, 586, 640, 321, 536, 742, 677, 742, 687, 284, Opcodes.INSTANCEOF, 517, UMSLNetWorkSender.f38894a, 494, Optimizer.OPTIMIZATION_STANDARD, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, 593, 800, 571, GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 803, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 231, 390, 685, 330, 63, TTAdConstant.IMAGE_LIST_SIZE_CODE}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, FrameMetricsAggregator.EVERY_DURATION, FontStyle.WEIGHT_NORMAL, 672, 762, 283, Opcodes.INVOKESTATIC, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, 605, Opcodes.IFLE, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, FontStyle.WEIGHT_NORMAL, 925, 749, TTAdConstant.VIDEO_COVER_URL_CODE, 822, 93, 217, AdEventType.VIDEO_CLICKED, PDF417Common.MAX_CODEWORDS_IN_BARCODE, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, Opcodes.INSTANCEOF, 219, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, 186, 236, 287, Opcodes.CHECKCAST, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, BitmapUtils.ROTATE270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, BuildConfig.VERSION_CODE, 726, 600, 269, 375, 898, 845, 454, 354, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_START_TOAST, 814, 587, 804, 34, AdEventType.VIDEO_LOADING, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, AdEventType.VIDEO_PAUSE, 82, 586, 708, 250, 905, 786, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, PredefinedCaptureConfigurations.f24404n, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, AdEventType.VIDEO_PAUSE, 796, 605, 540, 913, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, 700, 799, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 439, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 592, 668, 353, 859, 370, 694, 325, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 216, 257, 284, 549, AdEventType.VIDEO_INIT, 884, 315, 70, 329, 793, 490, 274, 877, Opcodes.IF_ICMPGE, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, FrameMetricsAggregator.EVERY_DURATION, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 538, 906, 90, 2, 290, 743, Opcodes.IFNONNULL, 655, 903, 329, 49, IMediaPlayer.MEDIA_INFO_METADATA_UPDATE, 580, 355, 588, Opcodes.NEWARRAY, 462, 10, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 628, GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 479, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_START_TOAST, 739, 71, Optimizer.OPTIMIZATION_STANDARD, 318, 374, 601, Opcodes.CHECKCAST, 605, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 673, 687, 234, 722, 384, Opcodes.RETURN, 752, 607, 640, 455, Opcodes.INSTANCEOF, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, StatusLine.HTTP_MISDIRECTED_REQUEST, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, 180, 791, 893, 754, 605, 383, 228, 749, 760, AdEventType.VIDEO_PRELOAD_ERROR, 54, 297, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 54, 834, 299, 922, 191, 910, 532, 609, 829, 189, 20, Opcodes.GOTO, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, 307, Opcodes.IF_ICMPEQ, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, AdEventType.VIDEO_ERROR, TTAdConstant.IMAGE_LIST_CODE, 574, 118, 498, 285, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, Opcodes.INSTANCEOF, 352, 781, 846, 75, 327, 520, 435, 543, 203, TTAdConstant.STYLE_SIZE_RADIO_2_3, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, TTAdConstant.INTERACTION_TYPE_CODE, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, AdEventType.VIDEO_PAUSE, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, InputDeviceCompat.SOURCE_DPAD, Opcodes.CHECKCAST, 516, 258, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 518, 794, 395, 768, 848, 51, 610, 384, 168, 190, 826, 328, 596, 786, 303, 570, 381, TTAdConstant.VIDEO_COVER_URL_CODE, 641, 156, 237, 151, 429, 531, AdEventType.VIDEO_ERROR, 676, 710, 89, 168, AdEventType.COMPLAIN_SUCCESS, 402, 40, 708, 575, Opcodes.IF_ICMPGE, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION, 729, 771, 95, 248, 361, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT, 452, Opcodes.GOTO, 342, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 173, 35, 463, 651, 51, 699, 591, 452, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, 911, 283, 711, 472, 420, 245, 288, 594, 394, FrameMetricsAggregator.EVERY_DURATION, 327, 589, 777, 699, 688, 43, TTAdConstant.INTERACTION_TYPE_CODE, 842, 383, 721, 521, 560, 644, 714, 559, 62, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, 873, 663, 713, Opcodes.IF_ICMPEQ, 672, 729, 624, 59, Opcodes.INSTANCEOF, TTAdConstant.LIVE_FEED_URL_CODE, Opcodes.IFLE, AdEventType.VIDEO_INIT, 563, 564, 343, 693, 109, 608, 563, 365, 181, 772, 677, 310, 248, 353, 708, TTAdConstant.IMAGE_LIST_SIZE_CODE, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, Opcodes.INVOKESTATIC, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, 305, 441, AdEventType.VIDEO_ERROR, 300, 892, 827, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 537, 381, 662, InputDeviceCompat.SOURCE_DPAD, 56, 252, 341, BuildConfig.VERSION_CODE, 797, 838, 837, PredefinedCaptureConfigurations.f24404n, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, AdEventType.VIDEO_READY, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, Opcodes.IF_ICMPGE, 498, 308, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, UMSLNetWorkSender.f38894a, 610, 296, Opcodes.INVOKESPECIAL, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, PredefinedCaptureConfigurations.f24404n, 742, 330, 5, 39, 923, 311, 424, BuildConfig.VERSION_CODE, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, 486, 721, 610, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 646, TTAdConstant.IMAGE_CODE, 877, 669, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 919, 45, 780, 407, 164, 332, 899, Opcodes.IF_ACMPEQ, 726, 600, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, AdEventType.COMPLAIN_SUCCESS, 282, 738, 675, TTAdConstant.IMAGE_LIST_SIZE_CODE, 389, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 31, 121, 303, Optimizer.OPTIMIZATION_STANDARD}};

    private PDF417ErrorCorrection() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            if (cArr[i4] != 0) {
                cArr[i4] = (char) (929 - cArr[i4]);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getErrorCorrectionCodewordCount(int i) {
        if (i < 0 || i > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i + 1);
    }

    static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i > 0) {
            if (i <= 40) {
                return 2;
            }
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
        throw new IllegalArgumentException("n must be > 0");
    }
}
