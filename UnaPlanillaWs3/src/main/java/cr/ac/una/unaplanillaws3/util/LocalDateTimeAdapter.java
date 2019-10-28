/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanillaws3.util;

import java.time.Instant;
import javax.json.bind.adapter.JsonbAdapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> implements JsonbAdapter<LocalDateTime, String> {

    private static final Logger LOG = Logger.getLogger(LocalDateTimeAdapter.class.getName());

    @Override
    public LocalDateTime unmarshal(String dateString) throws Exception {
        try {
            if (dateString == null) {
                return null;
            }
            ZonedDateTime zoned = ZonedDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
            LocalDateTime local = LocalDateTime.ofInstant(zoned.toInstant(), ZoneId.systemDefault());
            return local;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error al deserializar la fecha [" + dateString + "].", ex);
            throw ex;
        }

    }

    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {
        try {
            if (dateTime == null) {
                return null;
            }
            //ZonedDateTime zoned = ZonedDateTime.of(dateTime, ZoneId.systemDefault());
            //return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zoned);
            Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
            return DateTimeFormatter.ISO_INSTANT.format(instant);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error al serializar la fecha [" + dateTime + "].", ex);
            throw ex;
        }
    }

    @Override
    public String adaptToJson(LocalDateTime localDateTime) throws Exception {
        return marshal(localDateTime);
    }

    @Override
    public LocalDateTime adaptFromJson(String s) throws Exception {
        return unmarshal(s);
    }
}