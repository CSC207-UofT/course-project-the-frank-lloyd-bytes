package interfaces;

public interface OnOptionSelection {

    /**
     * This interface connects with UCheckQuestionnaireActivity. The USER selects an radio button on UI.
     *
     * @param isNo boolean value to pass in interface whether an option has been selection in UI.
     * @param position integer position of where in UI the selection has been made.
     */
    void onSelection(boolean isNo, int position);
}
