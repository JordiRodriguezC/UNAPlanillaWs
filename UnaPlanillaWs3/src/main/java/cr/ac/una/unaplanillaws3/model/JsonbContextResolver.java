package cr.ac.una.unaplanillaws3.model;

import cr.ac.una.unaplanillaws3.util.LocalDateTimeAdapter;
import cr.ac.una.unaplanillaws3.util.LocalDateTimeAdapter;
import cr.ac.una.unaplanillaws3.util.ZonedDateTimeAdapter;
import cr.ac.una.unaplanillaws3.util.ZonedDateTimeAdapter;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
//import javax.json.bind.config.PropertyNamingStrategy;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonbContextResolver implements ContextResolver<Jsonb> {
    private static Jsonb jsonb;

    public JsonbContextResolver() {
        JsonbConfig config = new JsonbConfig()
                .withAdapters(new LocalDateTimeAdapter(),
                        new ZonedDateTimeAdapter());
                //.withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

        jsonb = JsonbBuilder.create(config);
    }

    @Override
    public Jsonb getContext(Class<?> type) {
        return jsonb;
    }
}
