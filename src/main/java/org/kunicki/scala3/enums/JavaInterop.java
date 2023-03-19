package org.kunicki.scala3.enums;

import org.kunicki.scala3.enums.Direction;

public class JavaInterop {

    public static void main(String[] args) {
        System.out.println(Direction.N instanceof Enum);

        for (var d : Direction.values()) {
            System.out.println(String.format("%s: %d (%d)",
                d.name(), d.bearing(), d.compassPoint()
            ));
        }
    }
}
