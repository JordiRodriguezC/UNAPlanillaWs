package cr.ac.una.unaplanillaws3.util;

import javax.json.bind.adapter.JsonbAdapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> implements JsonbAdapter<ZonedDateTime, String> {

    @Override
    public ZonedDateTime unmarshal(String v) {
        if (v == null) {
            return null;
        }
        ZonedDateTime result = ZonedDateTime.parse(v, DateTimeFormatter.ISO_DATE_TIME);
        return result;
    }

    @Override
    public String marshal(ZonedDateTime v) {
        if (v == null) {
            return null;
        }
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(v);
    }

    @Override
    public String adaptToJson(ZonedDateTime obj) throws Exception {
        return marshal(obj);
    }

    @Override
    public ZonedDateTime adaptFromJson(String obj) throws Exception {
        return unmarshal(obj);
    }
}
