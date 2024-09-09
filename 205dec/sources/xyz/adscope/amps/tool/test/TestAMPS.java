package xyz.adscope.amps.tool.test;

import xyz.adscope.amps.tool.AMPSSecurityUtil;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TestAMPS {
    public static void ampsEntry() {
        String compressEncrypt = AMPSSecurityUtil.compressEncrypt("{\"device\":{\"type\":\"100\", \"name\":\"M2004J7AC\", \"said\":\"f8cce1b65b4046fd9fcf58eab8d459b5\", \"os\":\"2\", \"country\":\"CN\", \"zone\":\"GMT+08:00\", \"lang\":\"zh\", \"lmt\":\"0\", \"contype\":\"1\", \"carrier\":\"UNKNOW\", \"osv\":\"10\", \"idfa\":\"null\", \"oaid\":\"\", \"gaid\":\"\", \"model\":\"null\", \"w\":\"393\", \"h\":\"800\", \"make\":\"M2004J7AC\", \"brand\":\"Redmi\", \"bootMark\":\"5514e651-ce54-4b06-840d-7ba69f02dbee\", \"cidfa\":\"null\", \"coaid\":\"\", \"cgaid\":\"\", \"updateMark\":\"1262305837.140000000\", \"fileMark\":\"1609769817000\", \"sysUpdateMark\":\"\", \"harddiskSize\":\"50676314112\", \"physicalMemory\":\"5652197376\", \"hwModel\":\"null\", \"ext\":\"null\"}, \"app\":{\"appId\":123, \"name\":\"null\", \"bundleid\":\"com.example.adscopesdk\", \"version\":\"1.0\", \"install\":\"1682663507999\", \"update\":\"1683167868801\", \"ext\":\"null\"}, \"user\":{\"id\":\"null\", \"customData\":\"\", \"ext\":\"null\"}, \"ext\":\"null\", \"time\":null, \"sdk\":{\"version\":\"5.0.0.0\", \"sdkArray\":null, \"ext\":\"null\"}}");
        LogUtil.i(CommonConstants.TAG, "encrypt : " + compressEncrypt);
        String decryptUncompress = AMPSSecurityUtil.decryptUncompress(compressEncrypt);
        LogUtil.i(CommonConstants.TAG, "convertStr : " + decryptUncompress);
    }
}
