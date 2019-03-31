package user.search.sort;

public class SortCondition {
    private SortComplexityType sortComplexityType;
    private SortOrderDirection sortOrderDirection;
    private SortUserField[] sortUserField;

    public SortCondition(SortComplexityType sortComplexityType, SortOrderDirection sortOrderDirection, SortUserField... sortUserField) {
        this.sortComplexityType = sortComplexityType;
        this.sortOrderDirection = sortOrderDirection;
        this.sortUserField = sortUserField;
    }

    public SortComplexityType getSortComplexityType() {
        return sortComplexityType;
    }

    public SortOrderDirection getSortOrderDirection() {
        return sortOrderDirection;
    }

    public SortUserField[] getSortUserField() {
        return sortUserField;
    }


}
