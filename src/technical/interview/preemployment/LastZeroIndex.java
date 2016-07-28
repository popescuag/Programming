package technical.interview.preemployment;

public class LastZeroIndex {
  public int findIdx(byte[] byteArray) {
    if (byteArray == null || byteArray.length == 0) {
      throw new IllegalArgumentException("Byte array cannot be null or empty");
    }
    int idx = byteArray.length - 1;
    for (; idx > 0 && byteArray[idx] == 0; idx--);
    return idx;
  }
}
