package com.google.zxing.maxicode.decoder;

import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import cn.bluemobi.dylan.http.BuildConfig;
import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.baidu.idl.face.platform.utils.FileUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.common.BitMatrix;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.umeng.commonsdk.stateless.UMSLNetWorkSender;
import com.umeng.socialize.bean.HandlerRequestCode;
import io.netty.handler.codec.dns.DnsRecord;
import okhttp3.internal.http.StatusLine;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class BitMatrixParser {
    private static final int[][] BITNR = {new int[]{121, 120, 127, 126, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, 144, 151, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, 157, 156, Opcodes.IF_ICMPGT, Opcodes.IF_ICMPGE, Opcodes.RET, 168, 175, 174, 181, 180, 187, 186, Opcodes.INSTANCEOF, Opcodes.CHECKCAST, Opcodes.IFNONNULL, Opcodes.IFNULL, -2, -2}, new int[]{123, 122, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, 128, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 140, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH, 153, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION, Opcodes.IF_ICMPEQ, Opcodes.IFLE, Opcodes.IF_ACMPEQ, 164, 171, 170, Opcodes.RETURN, Opcodes.ARETURN, Opcodes.INVOKESPECIAL, Opcodes.INVOKEVIRTUAL, 189, Opcodes.NEWARRAY, 195, 194, 201, 200, 816, -3}, new int[]{TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_WIFI, 124, 131, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_START_TOAST, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 149, 148, 155, Opcodes.IFNE, Opcodes.IF_ICMPLT, 160, Opcodes.GOTO, 166, 173, 172, 179, Opcodes.GETSTATIC, Opcodes.INVOKEINTERFACE, Opcodes.INVOKESTATIC, 191, 190, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, BitmapUtils.ROTATE270, 265, 264, 259, 258, 253, 252, 247, 246, 241, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 235, 234, 229, 228, 223, 222, 217, 216, AdEventType.VIDEO_LOADING, AdEventType.VIDEO_READY, AdEventType.VIDEO_STOP, AdEventType.VIDEO_PAUSE, 819, -3}, new int[]{285, 284, 279, 278, UMSLNetWorkSender.f38894a, 272, 267, 266, 261, 260, 255, DnsRecord.CLASS_NONE, 249, 248, 243, BuildConfig.VERSION_CODE, 237, 236, 231, 230, 225, 224, 219, 218, AdEventType.VIDEO_PRELOAD_ERROR, AdEventType.VIDEO_PRELOADED, AdEventType.VIDEO_ERROR, AdEventType.VIDEO_COMPLETE, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, Optimizer.OPTIMIZATION_STANDARD, 262, 257, 256, 251, 250, 245, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 239, 238, 233, 232, 227, 226, 221, 220, 215, 214, AdEventType.VIDEO_INIT, AdEventType.VIDEO_CLICKED, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, 306, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, 308, 315, 314, 321, GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 327, 326, AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, AdEventType.COMPLAIN_SUCCESS, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{TTAdConstant.IMAGE_LIST_CODE, TTAdConstant.INTERACTION_TYPE_CODE, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{TTAdConstant.IMAGE_CODE, TTAdConstant.IMAGE_LIST_SIZE_CODE, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{TTAdConstant.VIDEO_INFO_CODE, TTAdConstant.IMAGE_URL_CODE, 407, 406, 401, FontStyle.WEIGHT_NORMAL, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{TTAdConstant.VIDEO_COVER_URL_CODE, TTAdConstant.VIDEO_URL_CODE, StatusLine.HTTP_MISDIRECTED_REQUEST, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{TTAdConstant.LIVE_FEED_URL_CODE, TTAdConstant.LIVE_AD_CODE, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{419, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, FileUtils.S_IRWXU, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, FrameMetricsAggregator.EVERY_DURATION, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, InputDeviceCompat.SOURCE_DPAD, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, TTAdConstant.STYLE_SIZE_RADIO_9_16, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, PredefinedCaptureConfigurations.f24404n, 715, 714, 709, 708, IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH, IMediaPlayer.MEDIA_INFO_BUFFERING_END, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, TTAdConstant.STYLE_SIZE_RADIO_2_3, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, IMediaPlayer.MEDIA_INFO_BUFFERING_START, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, HandlerRequestCode.SINA_SHARE_REQUEST_CODE, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, IMediaPlayer.MEDIA_INFO_METADATA_UPDATE, 809, 808, 815, 814, 863, 862}};
    private final BitMatrix bitMatrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) {
        this.bitMatrix = bitMatrix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() {
        byte[] bArr = new byte[144];
        int height = this.bitMatrix.getHeight();
        int width = this.bitMatrix.getWidth();
        for (int i = 0; i < height; i++) {
            int[] iArr = BITNR[i];
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.bitMatrix.get(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
            }
        }
        return bArr;
    }
}
