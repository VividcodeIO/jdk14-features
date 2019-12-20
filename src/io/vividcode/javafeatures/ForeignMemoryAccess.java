package io.vividcode.javafeatures;

import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemoryLayout.PathElement;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.SequenceLayout;

public class ForeignMemoryAccess {

  public static void main(String[] args) {
    MemoryLayout pointLayout = MemoryLayout.ofStruct(
        MemoryLayout.ofValueBits(32, ByteOrder.BIG_ENDIAN).withName("x"),
        MemoryLayout.ofValueBits(32, ByteOrder.BIG_ENDIAN).withName("y")
    );
    long numberOfPoints = 100;
    SequenceLayout pointsLayout = MemoryLayout.ofSequence(numberOfPoints, pointLayout);
    VarHandle xHandle = pointsLayout.varHandle(int.class, PathElement.sequenceElement(),PathElement.groupElement("x"));
    VarHandle yHandle = pointsLayout.varHandle(int.class, PathElement.sequenceElement(),PathElement.groupElement("y"));
    try (MemorySegment memorySegment = MemorySegment.allocateNative(pointsLayout)) {
      MemoryAddress base = memorySegment.baseAddress();
      for (int i = 0; i < numberOfPoints; i++) {
        xHandle.set(base, (long)i, i);
        yHandle.set(base, (long)i, i + 1);
      }
      ByteBuffer byteBuffer = memorySegment.asByteBuffer().order(ByteOrder.BIG_ENDIAN);
      while(byteBuffer.hasRemaining()) {
        int x = byteBuffer.getInt();
        int y = byteBuffer.getInt();
        System.out.println("[%3d, %3d]".formatted(x, y));
      }
    }
  }
}
