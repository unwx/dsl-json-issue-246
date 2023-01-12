package unwx;

import com.dslplatform.json.DslJson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class App {
    public static void main(final String[] args) throws IOException {
        final DslJson<SerializableRecord> classDslJson = new DslJson<>();
        final SerializableRecord c = new SerializableRecord(
                "simple field value",
                SerializableEnum.NO
        );

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        classDslJson.serialize(c, stream);

        System.out.println(stream);
        System.out.println(c);
    }
}
