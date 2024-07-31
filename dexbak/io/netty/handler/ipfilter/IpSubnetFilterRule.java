package io.netty.handler.ipfilter;

import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class IpSubnetFilterRule implements IpFilterRule {
    private final IpFilterRule filterRule;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Ip4SubnetFilterRule implements IpFilterRule {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int networkAddress;
        private final IpFilterRuleType ruleType;
        private final int subnetMask;

        private static int ipToInt(Inet4Address inet4Address) {
            byte[] address = inet4Address.getAddress();
            return (address[3] & UByte.f41242c) | ((address[0] & UByte.f41242c) << 24) | ((address[1] & UByte.f41242c) << 16) | ((address[2] & UByte.f41242c) << 8);
        }

        private static int prefixToSubnetMask(int i) {
            return (int) ((-1) & ((-1) << (32 - i)));
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress) {
            return (ipToInt((Inet4Address) inetSocketAddress.getAddress()) & this.subnetMask) == this.networkAddress;
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private Ip4SubnetFilterRule(Inet4Address inet4Address, int i, IpFilterRuleType ipFilterRuleType) {
            if (i >= 0 && i <= 32) {
                int prefixToSubnetMask = prefixToSubnetMask(i);
                this.subnetMask = prefixToSubnetMask;
                this.networkAddress = ipToInt(inet4Address) & prefixToSubnetMask;
                this.ruleType = ipFilterRuleType;
                return;
            }
            throw new IllegalArgumentException(String.format("IPv4 requires the subnet prefix to be in range of [0,32]. The prefix was: %d", Integer.valueOf(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Ip6SubnetFilterRule implements IpFilterRule {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
        private final BigInteger networkAddress;
        private final IpFilterRuleType ruleType;
        private final BigInteger subnetMask;

        private static BigInteger ipToInt(Inet6Address inet6Address) {
            return new BigInteger(inet6Address.getAddress());
        }

        private static BigInteger prefixToSubnetMask(int i) {
            return MINUS_ONE.shiftLeft(128 - i);
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress) {
            return ipToInt((Inet6Address) inetSocketAddress.getAddress()).and(this.subnetMask).equals(this.networkAddress);
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private Ip6SubnetFilterRule(Inet6Address inet6Address, int i, IpFilterRuleType ipFilterRuleType) {
            if (i >= 0 && i <= 128) {
                BigInteger prefixToSubnetMask = prefixToSubnetMask(i);
                this.subnetMask = prefixToSubnetMask;
                this.networkAddress = ipToInt(inet6Address).and(prefixToSubnetMask);
                this.ruleType = ipFilterRuleType;
                return;
            }
            throw new IllegalArgumentException(String.format("IPv6 requires the subnet prefix to be in range of [0,128]. The prefix was: %d", Integer.valueOf(i)));
        }
    }

    public IpSubnetFilterRule(String str, int i, IpFilterRuleType ipFilterRuleType) {
        try {
            this.filterRule = selectFilterRule(InetAddress.getByName(str), i, ipFilterRuleType);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("ipAddress", e);
        }
    }

    private static IpFilterRule selectFilterRule(InetAddress inetAddress, int i, IpFilterRuleType ipFilterRuleType) {
        if (inetAddress != null) {
            if (ipFilterRuleType != null) {
                if (inetAddress instanceof Inet4Address) {
                    return new Ip4SubnetFilterRule((Inet4Address) inetAddress, i, ipFilterRuleType);
                }
                if (inetAddress instanceof Inet6Address) {
                    return new Ip6SubnetFilterRule((Inet6Address) inetAddress, i, ipFilterRuleType);
                }
                throw new IllegalArgumentException("Only IPv4 and IPv6 addresses are supported");
            }
            throw new NullPointerException("ruleType");
        }
        throw new NullPointerException("ipAddress");
    }

    @Override // io.netty.handler.ipfilter.IpFilterRule
    public boolean matches(InetSocketAddress inetSocketAddress) {
        return this.filterRule.matches(inetSocketAddress);
    }

    @Override // io.netty.handler.ipfilter.IpFilterRule
    public IpFilterRuleType ruleType() {
        return this.filterRule.ruleType();
    }

    public IpSubnetFilterRule(InetAddress inetAddress, int i, IpFilterRuleType ipFilterRuleType) {
        this.filterRule = selectFilterRule(inetAddress, i, ipFilterRuleType);
    }
}
