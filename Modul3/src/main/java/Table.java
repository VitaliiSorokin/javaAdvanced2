import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Table {
    private String name;
    private String value;

    @JsonCreator
    public Table(@JsonProperty("name") String name,
                 @JsonProperty("value") String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
