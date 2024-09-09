package com.google.zxing.oned;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class EANManufacturerOrgSupport {
    private final List<int[]> ranges = new ArrayList();
    private final List<String> countryIdentifiers = new ArrayList();

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private synchronized void initIfNeeded() {
        if (this.ranges.isEmpty()) {
            add(new int[]{0, 19}, "US/CA");
            add(new int[]{30, 39}, "US");
            add(new int[]{60, 139}, "US/CA");
            add(new int[]{300, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL}, "FR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER}, "BG");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400}, "SI");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500}, "HR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500}, "BA");
            add(new int[]{400, 440}, "DE");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME}, "JP");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE, 469}, "RU");
            add(new int[]{471}, "TW");
            add(new int[]{474}, "EE");
            add(new int[]{475}, "LV");
            add(new int[]{476}, "AZ");
            add(new int[]{477}, "LT");
            add(new int[]{478}, "UZ");
            add(new int[]{479}, "LK");
            add(new int[]{480}, "PH");
            add(new int[]{481}, "BY");
            add(new int[]{482}, "UA");
            add(new int[]{484}, "MD");
            add(new int[]{485}, "AM");
            add(new int[]{486}, "GE");
            add(new int[]{487}, "KZ");
            add(new int[]{489}, "HK");
            add(new int[]{490, 499}, "JP");
            add(new int[]{500, 509}, "GB");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX}, "GR");
            add(new int[]{528}, "LB");
            add(new int[]{529}, "CY");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE}, "MK");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD}, "MT");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DUMMY_VOICE_SLEEP}, "IE");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, 549}, "BE/LU");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ}, "PT");
            add(new int[]{569}, "IS");
            add(new int[]{570, 579}, "DK");
            add(new int[]{590}, "PL");
            add(new int[]{594}, "RO");
            add(new int[]{599}, "HU");
            add(new int[]{600, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE}, "ZA");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN}, "GH");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_MDAT_POS}, "BH");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_BUFS_WHEN_BUFFER_START}, "MU");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE}, "MA");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK}, "DZ");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH}, "KE");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB}, "CI");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID}, "TN");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME}, "SY");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DNS_START_TIME}, "EG");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME}, "LY");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME}, "JO");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME}, "IR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME}, "KW");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME}, "SA");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME}, "AE");
            add(new int[]{640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME}, "FI");
            add(new int[]{690, 695}, "CN");
            add(new int[]{700, 709}, "NO");
            add(new int[]{729}, "IL");
            add(new int[]{730, 739}, "SE");
            add(new int[]{740}, "GT");
            add(new int[]{741}, "SV");
            add(new int[]{742}, "HN");
            add(new int[]{743}, "NI");
            add(new int[]{744}, "CR");
            add(new int[]{745}, "PA");
            add(new int[]{746}, "DO");
            add(new int[]{750}, "MX");
            add(new int[]{754, 755}, "CA");
            add(new int[]{759}, "VE");
            add(new int[]{760, 769}, "CH");
            add(new int[]{770}, "CO");
            add(new int[]{773}, "UY");
            add(new int[]{775}, "PE");
            add(new int[]{777}, "BO");
            add(new int[]{779}, "AR");
            add(new int[]{780}, "CL");
            add(new int[]{784}, "PY");
            add(new int[]{785}, "PE");
            add(new int[]{786}, "EC");
            add(new int[]{789, 790}, "BR");
            add(new int[]{800, 839}, "IT");
            add(new int[]{840, 849}, "ES");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME}, "CU");
            add(new int[]{858}, "SK");
            add(new int[]{859}, "CZ");
            add(new int[]{860}, "YU");
            add(new int[]{865}, "MN");
            add(new int[]{867}, "KP");
            add(new int[]{868, TTAdConstant.VALUE_CLICK_AREA_OTHER}, "TR");
            add(new int[]{870, 879}, "NL");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE}, "KR");
            add(new int[]{885}, "TH");
            add(new int[]{888}, "SG");
            add(new int[]{890}, "IN");
            add(new int[]{893}, "VN");
            add(new int[]{896}, "PK");
            add(new int[]{899}, "ID");
            add(new int[]{900, 919}, "AT");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, 939}, "AU");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS, 949}, "AZ");
            add(new int[]{955}, "MY");
            add(new int[]{958}, "MO");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lookupCountryIdentifier(String str) {
        int[] iArr;
        int i4;
        initIfNeeded();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        for (int i5 = 0; i5 < size && parseInt >= (i4 = (iArr = this.ranges.get(i5))[0]); i5++) {
            if (iArr.length != 1) {
                i4 = iArr[1];
            }
            if (parseInt <= i4) {
                return this.countryIdentifiers.get(i5);
            }
        }
        return null;
    }
}
