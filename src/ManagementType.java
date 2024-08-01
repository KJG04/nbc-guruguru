import java.util.Arrays;

public enum ManagementType {
    MANAGEMENT_STUDENT(1, "수강생 관리"),
    MANAGEMENT_SCORE(2, "점수 관리"),
    MANAGEMENT_EXIT(3, "종료");

    private final int id;
    private final String description;

    ManagementType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static ManagementType getManagementTypeById(int id) throws IllegalArgumentException {
        ManagementType[] values = ManagementType.values();
        return Arrays.stream(ManagementType.values()).filter(v -> v.id == id).findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("[getManagementTypeById] id는 %s 이여야 합니다. 하지만 id: %d", Arrays.toString(Arrays.stream(values).map(v -> v.id).toArray(Integer[]::new)), id)));
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
