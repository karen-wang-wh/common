package com.karen.util;

import java.util.Objects;

/**
 * @author wangkailun
 */
public class HexUtil {
  private static final String HEX_STR = "0123456789ABCDEF";

  public static byte[] fromHex(final String hex) {
    if (Objects.isNull(hex)) {
      return new byte[0];

    } else {
      String src = hex.toUpperCase();
      int len = src.length() >> 1;
      byte[] bytes = new byte[len];

      //字节高四位
      byte high = 0;
      //字节低四位
      byte low = 0;

      for (int i = 0; i < len; i++) {
        //右移四位得到高位
        high = (byte) ((hexInt(src.charAt(i << 1))) << 4);
        low = (byte) hexInt(src.charAt((i << 1) + 1));
        //高地位做或运算
        bytes[i] = (byte) (high | low);
      }
      return bytes;
    }
  }

  public static String toHex(final byte[] bytes) {
    if (Objects.isNull(bytes)) {
      return "";
    } else {
      StringBuilder sb = new StringBuilder();
      for (byte b : bytes) {
        int div = b >> 4;
        int rem = b & 0x0f;
        sb.append(hexChar(div)).append(hexChar(rem));
      }
      return sb.toString();
    }
  }

  public static int hexInt(char c) {
    return HEX_STR.indexOf(c);
  }

  public static char hexChar(int b) {
    return HEX_STR.charAt(b);
  }
}
