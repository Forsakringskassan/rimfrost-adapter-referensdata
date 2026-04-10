package se.fk.rimfrost.adapter.referensdata.adapter;

import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import se.fk.rimfrost.adapter.referensdata.model.ImmutableReferensdata;
import se.fk.rimfrost.adapter.referensdata.model.Referensdata;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusComponentTest
public class ReferensdataMapperTest
{
   @Inject
   ReferensdataMapper referensdataMapper;

   @Test
   void testToReferensdataList()
   {
      var referensdataList = new ArrayList<Referensdata>();
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();

      var referensdata = ImmutableReferensdata.builder()
            .id("ed7a3aba-7ba7-4639-b92f-87a8bb26989b")
            .kod("ABC-123")
            .namn("Testdata")
            .build();
      referensdataList.add(referensdata);

      var apiReferensdata = new se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata();
      apiReferensdata.setId("ed7a3aba-7ba7-4639-b92f-87a8bb26989b");
      apiReferensdata.setKod("ABC-123");
      apiReferensdata.setNamn("Testdata");
      apiReferensdataList.add(apiReferensdata);

      assertEquals(referensdataList, referensdataMapper.toReferensdataList(apiReferensdataList));
   }

   @Test
   void testToReferensdata()
   {
      var referensdata = ImmutableReferensdata.builder()
            .id("ed7a3aba-7ba7-4639-b92f-87a8bb26989b")
            .kod("ABC-123")
            .namn("Testdata")
            .build();

      var apiReferensdata = new se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata();
      apiReferensdata.setId("ed7a3aba-7ba7-4639-b92f-87a8bb26989b");
      apiReferensdata.setKod("ABC-123");
      apiReferensdata.setNamn("Testdata");

      assertEquals(referensdata, referensdataMapper.toReferensdata(apiReferensdata));
   }
}
