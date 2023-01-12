package unwx;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

@CompiledJson(onUnknown = CompiledJson.Behavior.FAIL)
public record SerializableRecord(
        @CustomAnnotation
        @JsonAttribute(name = SIMPLE_FIELD)
        String simpleField,

        @CustomAnnotation
        @JsonAttribute(name = ENUM, converter = SerializableEnumConverter.class)
        SerializableEnum serializableEnum
) {
    private static final String SIMPLE_FIELD = "simple_field";
    private static final String ENUM = "enum";
}
