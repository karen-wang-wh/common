package com.karen.util;

import static com.resvent.util.ByteUtil.getBytes;
import static com.resvent.util.ByteUtil.getInt;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wangkailun
 */
public class NetUtil {
  public static int getAddress(String host) {
    try {
      InetAddress address = InetAddress.getByName(host);
      return getInt(address.getAddress(), 0);
    } catch (UnknownHostException e) {
      throw new IllegalArgumentException("unKnown host");
    }
  }

  public static String getHostAddress(byte[] rawIp) {
    try {
      InetAddress address = InetAddress.getByAddress(rawIp);
      return address.getHostAddress();
    } catch (UnknownHostException e) {
      throw new IllegalArgumentException("unKnown host");
    }
  }

  public static String getHostAddress(int rawIp) {
    return getHostAddress(getBytes(rawIp));
  }

}
