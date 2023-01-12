package unwx;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

@CompiledJson(onUnknown = CompiledJson.Behavior.FAIL)
public class SerializableClass {
    private static final String SIMPLE_FIELD = "simple_field";
    private static final String ENUM = "enum";

    @CustomAnnotation
    @JsonAttribute(name = SIMPLE_FIELD)
    private final String simpleField;

    @CustomAnnotation
    @JsonAttribute(name = ENUM, converter = SerializableEnumConverter.class)
    private final SerializableEnum serializableEnum;

    public SerializableClass(final String simpleField,
                             final SerializableEnum serializableEnum) {
        this.simpleField = simpleField;
        this.serializableEnum = serializableEnum;
    }

    public String simpleField() {
        return simpleField;
    }

    public SerializableEnum serializableEnum() {
        return serializableEnum;
    }
}
