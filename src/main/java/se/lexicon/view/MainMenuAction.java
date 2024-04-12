package se.lexicon.view;

public enum MainMenuAction {
    DISPLAY,
    REGISTER,
    RESERVE,
    DISPLAY_AND_VACATE,
    EXIT;

    public static MainMenuAction getAction(int operationCode) {
        switch (operationCode) {
            case 1:
                return DISPLAY;
            case 2:
                return REGISTER;
            case 3:
                return RESERVE;
            case 4:
                return DISPLAY_AND_VACATE;
            case 0:
                return EXIT;
            default:
                throw new IllegalArgumentException("Invalid operation code: " + operationCode);
        }
    }
}
