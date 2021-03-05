package com.karen.util;

import io.netty.buffer.ByteBuf;
import java.nio.charset.StandardCharsets;

public class ByteUtil {

  public static byte getByte(byte b) {
    return b;
  }

  public static short getUnsignedByte(byte b) {
    return (short) (b & 0xff);
  }

  public static byte getByte(byte[] bytes, int index) {
    return bytes[index];
  }

  public static short getUnsignedByte(byte[] bytes, int index) {
    return (short) (getByte(bytes, index) & 0xff);
  }

  public static short getShort(byte[] bytes, int index) {
    return (short) ((bytes[index] & 0xff) << 8 | (bytes[index + 1] & 0xff));

  }
  public static short getShortLE(byte[] bytes, int index) {
    return (short) ((bytes[index + 1] & 0xff) << 8 | (bytes[index] & 0xff));
  }

  /**
   *
   * @param bytes 原始数据
   * @param index start index
   * @return long
   */
  public static int getUnsignedShort(byte[] bytes, int index) {
    return getShort(bytes, index) & 0xffff;
  }

  /**
   *
   * @param bytes 原始数据
   * @param index start index
   * @return long
   */
  public static int getUnsignedShortLE(byte[] bytes, int index) {
    return getShortLE(bytes, index) & 0xffff;
  }

  public static int getInt(byte[] bytes, int i) {
    return (bytes[i] & 0xff) << 24
        | (bytes[i + 1] & 0xff) << 16
        | (bytes[i + 2] & 0xff)<< 8
        | (bytes[i + 3] & 0xff);
  }

  public static int getIntLE(byte[] bytes, int i) {
    return (bytes[i + 3] & 0xff) << 24
        | (bytes[i + 2] & 0xff) << 16
        | (bytes[i + 1] & 0xff) << 8
        | (bytes[i] & 0xff);
  }

  /**
   *
   * @param bytes 原始数据
   * @param index start index
   * @return long
   */
  public static long getUnsignedInt(byte[] bytes, int index) {
    return getInt(bytes, index) & 0xffffffffL;
  }

  /**
   *
   * @param bytes 原始数据
   * @param index start index
   * @return long
   */
  public static long getUnsignedIntLE(byte[] bytes, int index) {
    return getIntLE(bytes, index) & 0xffffffffL;
  }

  public static void writeString(ByteBuf buffer, CharSequence charSequence, int length) {
    if (charSequence.length() > length) {
      throw new IllegalArgumentException();
    }
    int index = buffer.writerIndex();
    buffer.writeCharSequence(charSequence, StandardCharsets.UTF_8);
    buffer.writerIndex(index + length);
  }

  public static String readString(ByteBuf buffer, int length) {
    return buffer.readCharSequence(length, StandardCharsets.UTF_8).toString().trim();
  }

  public static byte[] getBytes(int i) {
    final byte[] bytes = new byte[Integer.BYTES];
    bytes[0] = (byte) ((i >> 24) & 0x0f);
    bytes[1] = (byte) ((i >> 16) & 0x0f);
    bytes[2] = (byte) ((i >> 8) & 0x0f);
    bytes[3] = (byte) (i & 0x0f);
    return bytes;
  }

  public static byte[] getBytesLE(int i) {
    final byte[] bytes = new byte[Integer.BYTES];
    bytes[3] = (byte) ((i >> 24) & 0x0f);
    bytes[2] = (byte) ((i >> 16) & 0x0f);
    bytes[1] = (byte) ((i >> 8) & 0x0f);
    bytes[0] = (byte) (i & 0x0f);
    return bytes;
  }

  public static byte[] getBytes(short s) {
    final byte[] bytes = new byte[Short.BYTES];
    bytes[0] = (byte) ((s >> 8) & 0x0f);
    bytes[1] = (byte) (s & 0x0f);
    return bytes;
  }

  public static byte[] getBytesLE(short s) {
    final byte[] bytes = new byte[Short.BYTES];
    bytes[1] = (byte) ((s >> 8) & 0x0f);
    bytes[0] = (byte) (s & 0x0f);
    return bytes;
  }

}
