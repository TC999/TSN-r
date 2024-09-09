package io.netty.handler.codec.dns;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import io.netty.util.collection.IntObjectHashMap;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DnsRecordType implements Comparable<DnsRecordType> {
    public static final DnsRecordType A;
    public static final DnsRecordType AAAA;
    public static final DnsRecordType AFSDB;
    public static final DnsRecordType ANY;
    public static final DnsRecordType APL;
    public static final DnsRecordType AXFR;
    private static final Map<String, DnsRecordType> BY_NAME;
    private static final IntObjectHashMap<DnsRecordType> BY_TYPE;
    public static final DnsRecordType CAA;
    public static final DnsRecordType CERT;
    public static final DnsRecordType CNAME;
    public static final DnsRecordType DHCID;
    public static final DnsRecordType DLV;
    public static final DnsRecordType DNAME;
    public static final DnsRecordType DNSKEY;
    public static final DnsRecordType DS;
    private static final String EXPECTED;
    public static final DnsRecordType HIP;
    public static final DnsRecordType IPSECKEY;
    public static final DnsRecordType IXFR;
    public static final DnsRecordType KEY;
    public static final DnsRecordType KX;
    public static final DnsRecordType LOC;
    public static final DnsRecordType MX;
    public static final DnsRecordType NAPTR;
    public static final DnsRecordType NS;
    public static final DnsRecordType NSEC;
    public static final DnsRecordType NSEC3;
    public static final DnsRecordType NSEC3PARAM;
    public static final DnsRecordType OPT;
    public static final DnsRecordType PTR;
    public static final DnsRecordType RP;
    public static final DnsRecordType RRSIG;
    public static final DnsRecordType SIG;
    public static final DnsRecordType SOA;
    public static final DnsRecordType SPF;
    public static final DnsRecordType SRV;
    public static final DnsRecordType SSHFP;
    public static final DnsRecordType TA;
    public static final DnsRecordType TKEY;
    public static final DnsRecordType TLSA;
    public static final DnsRecordType TSIG;
    public static final DnsRecordType TXT;
    private final int intValue;
    private final String name;
    private String text;

    static {
        DnsRecordType dnsRecordType = new DnsRecordType(1, "A");
        A = dnsRecordType;
        DnsRecordType dnsRecordType2 = new DnsRecordType(2, "NS");
        NS = dnsRecordType2;
        DnsRecordType dnsRecordType3 = new DnsRecordType(5, "CNAME");
        CNAME = dnsRecordType3;
        DnsRecordType dnsRecordType4 = new DnsRecordType(6, "SOA");
        SOA = dnsRecordType4;
        DnsRecordType dnsRecordType5 = new DnsRecordType(12, "PTR");
        PTR = dnsRecordType5;
        DnsRecordType dnsRecordType6 = new DnsRecordType(15, "MX");
        MX = dnsRecordType6;
        DnsRecordType dnsRecordType7 = new DnsRecordType(16, "TXT");
        TXT = dnsRecordType7;
        DnsRecordType dnsRecordType8 = new DnsRecordType(17, "RP");
        RP = dnsRecordType8;
        DnsRecordType dnsRecordType9 = new DnsRecordType(18, "AFSDB");
        AFSDB = dnsRecordType9;
        DnsRecordType dnsRecordType10 = new DnsRecordType(24, "SIG");
        SIG = dnsRecordType10;
        DnsRecordType dnsRecordType11 = new DnsRecordType(25, "KEY");
        KEY = dnsRecordType11;
        DnsRecordType dnsRecordType12 = new DnsRecordType(28, "AAAA");
        AAAA = dnsRecordType12;
        DnsRecordType dnsRecordType13 = new DnsRecordType(29, "LOC");
        LOC = dnsRecordType13;
        DnsRecordType dnsRecordType14 = new DnsRecordType(33, "SRV");
        SRV = dnsRecordType14;
        DnsRecordType dnsRecordType15 = new DnsRecordType(35, "NAPTR");
        NAPTR = dnsRecordType15;
        DnsRecordType dnsRecordType16 = new DnsRecordType(36, "KX");
        KX = dnsRecordType16;
        DnsRecordType dnsRecordType17 = new DnsRecordType(37, "CERT");
        CERT = dnsRecordType17;
        DnsRecordType dnsRecordType18 = new DnsRecordType(39, "DNAME");
        DNAME = dnsRecordType18;
        DnsRecordType dnsRecordType19 = new DnsRecordType(41, "OPT");
        OPT = dnsRecordType19;
        DnsRecordType dnsRecordType20 = new DnsRecordType(42, "APL");
        APL = dnsRecordType20;
        DnsRecordType dnsRecordType21 = new DnsRecordType(43, "DS");
        DS = dnsRecordType21;
        DnsRecordType dnsRecordType22 = new DnsRecordType(44, "SSHFP");
        SSHFP = dnsRecordType22;
        DnsRecordType dnsRecordType23 = new DnsRecordType(45, "IPSECKEY");
        IPSECKEY = dnsRecordType23;
        DnsRecordType dnsRecordType24 = new DnsRecordType(46, "RRSIG");
        RRSIG = dnsRecordType24;
        DnsRecordType dnsRecordType25 = new DnsRecordType(47, "NSEC");
        NSEC = dnsRecordType25;
        DnsRecordType dnsRecordType26 = new DnsRecordType(48, "DNSKEY");
        DNSKEY = dnsRecordType26;
        DnsRecordType dnsRecordType27 = new DnsRecordType(49, "DHCID");
        DHCID = dnsRecordType27;
        DnsRecordType dnsRecordType28 = new DnsRecordType(50, "NSEC3");
        NSEC3 = dnsRecordType28;
        DnsRecordType dnsRecordType29 = new DnsRecordType(51, "NSEC3PARAM");
        NSEC3PARAM = dnsRecordType29;
        DnsRecordType dnsRecordType30 = new DnsRecordType(52, "TLSA");
        TLSA = dnsRecordType30;
        DnsRecordType dnsRecordType31 = new DnsRecordType(55, "HIP");
        HIP = dnsRecordType31;
        DnsRecordType dnsRecordType32 = new DnsRecordType(99, "SPF");
        SPF = dnsRecordType32;
        DnsRecordType dnsRecordType33 = new DnsRecordType(MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, "TKEY");
        TKEY = dnsRecordType33;
        DnsRecordType dnsRecordType34 = new DnsRecordType(250, "TSIG");
        TSIG = dnsRecordType34;
        DnsRecordType dnsRecordType35 = new DnsRecordType(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, "IXFR");
        IXFR = dnsRecordType35;
        DnsRecordType dnsRecordType36 = new DnsRecordType(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, "AXFR");
        AXFR = dnsRecordType36;
        DnsRecordType dnsRecordType37 = new DnsRecordType(255, "ANY");
        ANY = dnsRecordType37;
        DnsRecordType dnsRecordType38 = new DnsRecordType(257, "CAA");
        CAA = dnsRecordType38;
        DnsRecordType dnsRecordType39 = new DnsRecordType(32768, "TA");
        TA = dnsRecordType39;
        DnsRecordType dnsRecordType40 = new DnsRecordType(32769, "DLV");
        DLV = dnsRecordType40;
        BY_NAME = new HashMap();
        BY_TYPE = new IntObjectHashMap<>();
        DnsRecordType[] dnsRecordTypeArr = {dnsRecordType, dnsRecordType2, dnsRecordType3, dnsRecordType4, dnsRecordType5, dnsRecordType6, dnsRecordType7, dnsRecordType8, dnsRecordType9, dnsRecordType10, dnsRecordType11, dnsRecordType12, dnsRecordType13, dnsRecordType14, dnsRecordType15, dnsRecordType16, dnsRecordType17, dnsRecordType18, dnsRecordType19, dnsRecordType20, dnsRecordType21, dnsRecordType22, dnsRecordType23, dnsRecordType24, dnsRecordType25, dnsRecordType26, dnsRecordType27, dnsRecordType28, dnsRecordType29, dnsRecordType30, dnsRecordType31, dnsRecordType32, dnsRecordType33, dnsRecordType34, dnsRecordType35, dnsRecordType36, dnsRecordType37, dnsRecordType38, dnsRecordType39, dnsRecordType40};
        StringBuilder sb = new StringBuilder(512);
        sb.append(" (expected: ");
        for (int i4 = 0; i4 < 40; i4++) {
            DnsRecordType dnsRecordType41 = dnsRecordTypeArr[i4];
            BY_NAME.put(dnsRecordType41.name(), dnsRecordType41);
            BY_TYPE.put(dnsRecordType41.intValue(), (int) dnsRecordType41);
            sb.append(dnsRecordType41.name());
            sb.append('(');
            sb.append(dnsRecordType41.intValue());
            sb.append("), ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(')');
        EXPECTED = sb.toString();
    }

    private DnsRecordType(int i4) {
        this(i4, "UNKNOWN");
    }

    public static DnsRecordType valueOf(int i4) {
        DnsRecordType dnsRecordType = BY_TYPE.get(i4);
        return dnsRecordType == null ? new DnsRecordType(i4) : dnsRecordType;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DnsRecordType) && ((DnsRecordType) obj).intValue == this.intValue;
    }

    public int hashCode() {
        return this.intValue;
    }

    public int intValue() {
        return this.intValue;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        String str = this.text;
        if (str == null) {
            String str2 = this.name + '(' + intValue() + ')';
            this.text = str2;
            return str2;
        }
        return str;
    }

    public DnsRecordType(int i4, String str) {
        if ((65535 & i4) == i4) {
            this.intValue = i4;
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("intValue: " + i4 + " (expected: 0 ~ 65535)");
    }

    @Override // java.lang.Comparable
    public int compareTo(DnsRecordType dnsRecordType) {
        return intValue() - dnsRecordType.intValue();
    }

    public static DnsRecordType valueOf(String str) {
        DnsRecordType dnsRecordType = BY_NAME.get(str);
        if (dnsRecordType != null) {
            return dnsRecordType;
        }
        throw new IllegalArgumentException("name: " + str + EXPECTED);
    }
}
