package GUI5.cw3;

public class Parser {
    static float parse(String[] params, int index, float defaultValue) {

        float returnValue;
        try {
            returnValue = Float.parseFloat(params[index]) / 255;
            if (returnValue < 0 || returnValue > 1) {
                throw new Exception("returnValue Exception - out of border");
            }
            return returnValue;

        } catch (Exception e) {
            return defaultValue;
        }
    }
}
