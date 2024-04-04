public class KontoType {

    private String name;
    private String description;
    private String conditions;

    public KontoType(String name, String description, String conditions) {
        this.name = name;
        this.description = description;
        this.conditions = conditions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
