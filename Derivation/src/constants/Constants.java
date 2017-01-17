package constants;

import core.Constant;
import core.IDerivable;
/**
 * Constants and regexes used throughout the program.
 * @author luka
 *
 */
public class Constants {
    public static enum Types {
        FUNCTION, LEFTPAR, RIGHTPAR, PLUSMINUS, MULTDIV, POWER, NUMBER, VARIABLE
    };

    public static final IDerivable ZERO = new Constant(0);
    public static final IDerivable ONE = new Constant(1);
    public static final IDerivable PI = new Constant(Math.PI);
    public static final IDerivable PIHALF = new Constant(Math.PI / 2);
    public static final String NUMBERS = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
    public static final String FUNCTIONS = "sin|cos|exp|ln|sqrt";

}
