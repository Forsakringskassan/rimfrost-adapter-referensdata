package se.fk.rimfrost.adapter.referensdata.adapter;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import java.util.ArrayList;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.fk.rimfrost.adapter.referensdata.model.ImmutableReferensdata;
import se.fk.rimfrost.adapter.referensdata.model.Referensdata;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusComponentTest(useSystemConfigSources = true)
public class ReferensdataAdapterTest
{
   private static WireMockServer server;
   private static Referensdata referensdata;
   private final static ArrayList<Referensdata> referensdataList = new ArrayList<>();

   @Inject
   ReferensdataAdapter referensdataAdapter;

   @InjectMock
   ReferensdataMapper referensdataMapper;

   private se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata createApiReferensData(String id)
   {
      var apiReferensdata = new se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata();
      apiReferensdata.setId(id);
      apiReferensdata.setKod("ABC-123");
      apiReferensdata.setNamn("Testdata");

      return apiReferensdata;
   }

   @BeforeAll
   public static void setup()
   {
      server = new WireMockServer(
            options()
                  .dynamicPort()
                  .usingFilesUnderDirectory("src/test/resources"));
      server.start();

      System.setProperty("referensdata.api.base-url", server.baseUrl());

      referensdata = ImmutableReferensdata.builder()
            .id("ed7a3aba-7ba7-4639-b92f-87a8bb26989b")
            .kod("ABC-123")
            .namn("Testdata")
            .build();
      referensdataList.add(referensdata);
   }

   @BeforeEach
   void resetStubs()
   {
      server.resetToDefaultMappings();
   }

   @AfterAll
   public static void teardown()
   {
      if (server != null)
      {
         server.stop();
      }
   }

   @Test
   void testGetIdtyper() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("idtyp"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getIdtyper());
   }

   @Test
   void testGetIdtypThrowsNotFound()
   {
      server.stubFor(WireMock.get(WireMock.urlPathEqualTo("/idtyp/1234"))
            .willReturn(WireMock.aResponse().withStatus(404)));

      var exception = assertThrows(ReferensdataException.class, () -> referensdataAdapter.getIdtyp("1234"));
      assertEquals(ReferensdataErrorCode.NOT_FOUND, exception.getErrorCode());
   }

   @Test
   void testGetIdtyperThrowsBadRequest()
   {
      server.stubFor(WireMock.get(WireMock.urlPathEqualTo("/idtyp"))
            .willReturn(WireMock.aResponse().withStatus(400)));

      var exception = assertThrows(ReferensdataException.class, () -> referensdataAdapter.getIdtyper());
      assertEquals(ReferensdataErrorCode.BAD_REQUEST, exception.getErrorCode());
   }

   @Test
   void testGetIdtyperThrowsServiceUnavailable()
   {
      server.stubFor(WireMock.get(WireMock.urlPathEqualTo("/idtyp"))
            .willReturn(WireMock.aResponse().withStatus(503)));

      var exception = assertThrows(ReferensdataException.class, () -> referensdataAdapter.getIdtyper());
      assertEquals(ReferensdataErrorCode.SERVICE_UNAVAILABLE, exception.getErrorCode());
   }

   @Test
   void testGetIdtyperThrowsUnexpectedError()
   {
      server.stubFor(WireMock.get(WireMock.urlPathEqualTo("/idtyp"))
            .willReturn(WireMock.aResponse().withStatus(500)));

      var exception = assertThrows(ReferensdataException.class, () -> referensdataAdapter.getIdtyper());
      assertEquals(ReferensdataErrorCode.UNEXPECTED_ERROR, exception.getErrorCode());
   }

   @Test
   void testGetIdtyp() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("idtyp-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getIdtyp("1234"));
   }

   @Test
   void testGetYrkandestatusar() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("yrkandestatus"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getYrkandestatusar());
   }

   @Test
   void testGetYrkandestatus() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("yrkandestatus-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getYrkandestatus("1234"));
   }

   @Test
   void testGetAvsiktstyper() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("avsiktstyp"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getAvsiktstyper());
   }

   @Test
   void testGetAvsiktstyp() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("avsiktstyp-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getAvsiktstyp("1234"));
   }

   @Test
   void testGetAvslutstyper() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("avslutstyp"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getAvslutstyper());
   }

   @Test
   void testGetAvslutstyp() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("avslutstyp-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getAvslutstyp("1234"));
   }

   @Test
   void testGetBeslutstyper() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("beslutstyp"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getBeslutstyper());
   }

   @Test
   void testGetBeslutstyp() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("beslutstyp-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getBeslutstyp("1234"));
   }

   @Test
   void testGetBeslutsutfallstyper() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("beslutsutfallstyp"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getBeslutsutfallstyper());
   }

   @Test
   void testGetBeslutsutfallstyp() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("beslutsutfallstyp-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getBeslutsutfallstyp("1234"));
   }

   @Test
   void testGetUppgiftstatustyper() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("uppgiftstatustyp"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getUppgiftstatustyper());
   }

   @Test
   void testGetUppgiftstatustyp() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("uppgiftstatustyp-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getUppgiftstatustyp("1234"));
   }

   @Test
   void testGetFSSAinformationstyper() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("fssainformationstyp"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getFSSAinformationstyper());
   }

   @Test
   void testGetFSSAinformationstyp() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("fssainformationstyp-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getFSSAinformationstyp("1234"));
   }

   @Test
   void testGetYrkanderoller() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("yrkanderoll"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getYrkanderoller());
   }

   @Test
   void testGetYrkanderoll() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("yrkanderoll-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getYrkanderoll("1234"));
   }

   @Test
   void testGetErbjudanden() throws ReferensdataException
   {
      var apiReferensdataList = new ArrayList<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata>();
      apiReferensdataList.add(createApiReferensData("erbjudande"));

      Mockito.when(referensdataMapper.toReferensdataList(apiReferensdataList)).thenReturn(referensdataList);
      assertEquals(referensdataList, referensdataAdapter.getErbjudanden());
   }

   @Test
   void testGetErbjudande() throws ReferensdataException
   {
      var apiReferensdata = createApiReferensData("erbjudande-1234");
      Mockito.when(referensdataMapper.toReferensdata(apiReferensdata)).thenReturn(referensdata);
      assertEquals(referensdata, referensdataAdapter.getErbjudande("1234"));
   }
}
