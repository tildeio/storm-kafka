package storm.kafka.trident;

public class OptionalOffset {
  private final long value;

  private final String error;

  public OptionalOffset(long value) {
    this.value = value;
    this.error = null;
  }

  public OptionalOffset(String error) {
    this.value = -5;
    this.error = error;
  }

  public boolean isValid() {
    return error == null;
  }

  public long getValue() {
    if (isValid())
      return value;

    throw new IllegalStateException(error);
  }

  public String getError() {
    return error;
  }
}
