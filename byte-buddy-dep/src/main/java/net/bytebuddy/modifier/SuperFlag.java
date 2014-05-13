package net.bytebuddy.modifier;

import net.bytebuddy.instrumentation.ModifierContributor;
import org.objectweb.asm.Opcodes;

/**
 * Determines if the super flag should be set for a given type. This is done by the Java compiler
 * for all recent Java versions and the flag is ignored for all byte code version other then version 1.1. This flag
 * should normally always be set.
 */
public enum SuperFlag implements ModifierContributor.ForType {

    /**
     * Modifier for enabling virtual super method dispatch. This flag should always be set when
     * specifying a type modifier manually.
     */
    DEFINED(Opcodes.ACC_SUPER),

    /**
     * Modifier for disabling virtual super method dispatch. This flag is however ignored for any byte code version
     * other then 1.1.
     */
    UNDEFINED(EMPTY_MASK);

    private final int mask;

    private SuperFlag(int mask) {
        this.mask = mask;
    }

    @Override
    public int getMask() {
        return mask;
    }
}