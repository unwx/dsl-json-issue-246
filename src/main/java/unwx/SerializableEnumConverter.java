package unwx;

import com.dslplatform.json.JsonReader;
import com.dslplatform.json.JsonWriter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SerializableEnumConverter {
    private static final Map<String, SerializableEnum> stringToEnumMap = new ConcurrentHashMap<>();
    private static final Map<SerializableEnum, String> enumToStringMap = new ConcurrentHashMap<>();

    static {
        final String yes = "yes";
        final String no = "no";

        stringToEnumMap.put(yes, SerializableEnum.YES);
        stringToEnumMap.put(no, SerializableEnum.NO);

        enumToStringMap.put(SerializableEnum.YES, yes);
        enumToStringMap.put(SerializableEnum.NO, no);
    }

    public static final JsonReader.ReadObject<SerializableEnum> JSON_READER = reader -> {
        if (reader.wasNull()) return null;
        final String value = reader.readSimpleString();

        final SerializableEnum v = stringToEnumMap.get(value);
        if (v == null) {
            throw reader.newParseError("error description...");
        }

        return v;
    };

    public static final JsonWriter.WriteObject<SerializableEnum> JSON_WRITER = (writer, value) -> {
        if (value == null) {
            writer.writeNull();
        } else {
            writer.writeString(enumToStringMap.get(value));
        }
    };
}
