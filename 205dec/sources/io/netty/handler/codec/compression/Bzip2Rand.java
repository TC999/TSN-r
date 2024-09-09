package io.netty.handler.codec.compression;

import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2Rand {
    private static final int[] RNUMS = {MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 720, 127, 481, 931, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, 233, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 985, 724, 205, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 863, 491, 741, 242, 949, 214, 733, 859, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS, 708, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 574, 73, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, 730, TTVideoEngine.PLAYER_OPTION_OUTPUT_LOG, 419, 436, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 496, 867, 210, 399, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 480, 51, 878, 465, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 169, TTAdConstant.VALUE_CLICK_AREA_OTHER, 675, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 697, 867, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_THREAD_PRIORITY, 862, 687, 507, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 482, 129, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, 591, 733, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DNS_START_TIME, 150, 238, 59, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, 684, 877, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME, 169, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE, 105, 170, MediaPlayer.MEDIA_PLAYER_OPTION_MOOV_POS, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, 932, 727, 476, 693, 425, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 73, 122, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 442, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES, 695, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 445, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, 909, 545, 703, 919, 874, 474, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 500, 594, MediaPlayer.MEDIA_PLAYER_OPTION_BARRAGE_MASKURL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, 801, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 162, 819, 984, 589, 513, 495, 799, 161, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, 958, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 400, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500, 867, 600, 782, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 596, 414, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 682, 485, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_PRIMARIES, MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, 98, MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS, 163, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, 666, 933, 424, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE, 870, 227, 730, 475, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 263, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 686, 600, 224, 469, 68, 770, 919, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_SWITCH, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 206, 184, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_TIMEOUT, 795, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_500, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES, 404, 758, 839, 887, 715, 67, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, 204, 918, 873, 777, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 951, 160, 578, 722, 79, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, 96, 409, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 934, 970, 447, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS, 859, 672, 112, 785, MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS, 863, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, 350, 139, 93, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, 99, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 908, MediaPlayer.MEDIA_PLAYER_OPTION_BUFS_WHEN_BUFFER_START, 772, 154, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, 580, 184, 79, MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME, 742, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 762, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DNS_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 81, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME, 789, 125, 411, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 938, 300, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 78, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 128, 250, 170, 774, 972, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 999, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TOTAL_CACHED_LEN, 495, 78, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT, 126, 857, 956, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 580, 124, 737, 594, 701, MediaPlayer.MEDIA_PLAYER_OPTION_BARRAGE_MASKURL, 669, 112, 134, 694, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 992, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 743, 168, 974, 944, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 748, 52, 600, 747, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 182, 862, 81, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STATS_REPORT_INTERVAL, 988, 739, 511, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, 897, 955, 664, 981, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 113, 974, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 893, 228, 433, 837, MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION, 240, 102, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 51, 686, 754, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_INITED_TIME, 760, 493, 403, 415, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, 687, 700, 946, 670, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVREAGE_BITRATE_DIFF, 738, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, 760, 799, 887, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, 978, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 576, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_PATH_INFO, MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME, 502, 894, 679, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 440, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 879, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 572, 640, 724, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION, 56, 204, 700, 707, 151, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME, 449, 797, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 791, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 945, 679, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 59, 87, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 663, 412, 693, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS, MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP, 134, 108, 571, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_START_TIME, 212, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE, 304, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 97, 430, 751, 497, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 983, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME, 928, 140, 206, 73, 263, 980, 736, 876, 478, 430, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 170, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, 692, 829, 82, 855, 953, 676, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 970, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 750, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, 150, 790, MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AUDIO_DEVICE_TYPE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME, 592, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEIDA_PLAYER_OPTION_NATIVE_RENDER_ROTATION_ADAPT, MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO, 82, 896, 831, 547, MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, 524, 462, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 465, 502, 56, 661, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 976, 991, MediaPlayer.MEDIA_PLAYER_OPTION_BACKGROUND_STATUS, TTAdConstant.VALUE_CLICK_AREA_OTHER, 905, 758, 745, 193, 768, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, MediaPlayer.MEDIA_PLAYER_OPTION_MDAT_POS, 933, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AUDIO_DEVICE_TYPE, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 979, 792, 961, 61, 688, 793, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS, 986, 403, 106, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, 905, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, MediaPlayer.MEDIA_PLAYER_OPTION_LATENCYTIME, 466, 434, MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS, 210, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 919, 135, 780, 773, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, 707, 100, MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME, 958, 165, 504, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE, 176, 193, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 857, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 203, 50, 668, 108, MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS, 990, MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 510, 357, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME, 858, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, 936, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN};

    private Bzip2Rand() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int rNums(int i4) {
        return RNUMS[i4];
    }
}
