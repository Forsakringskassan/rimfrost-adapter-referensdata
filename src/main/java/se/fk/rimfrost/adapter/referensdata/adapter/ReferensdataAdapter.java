package se.fk.rimfrost.adapter.referensdata.adapter;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.ServiceUnavailableException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.glassfish.jersey.apache5.connector.Apache5ConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import se.fk.rimfrost.adapter.referensdata.model.Referensdata;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.ReferensdataControllerApi;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
@ApplicationScoped
public class ReferensdataAdapter
{

   @ConfigProperty(name = "referensdata.api.base-url")
   String referensdataBaseUrl;

   private ReferensdataControllerApi referensdataClient;

   private Client client;

   @Inject
   ReferensdataMapper referensdataMapper;

   @PostConstruct
   void init()
   {
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.connectorProvider(new Apache5ConnectorProvider());
      this.client = ClientBuilder.newClient(clientConfig);

      this.referensdataClient = WebResourceFactory.newResource(
            ReferensdataControllerApi.class,
            client.target(this.referensdataBaseUrl));
   }

   @PreDestroy
   void destroy()
   {
      this.referensdataClient = null;

      if (this.client != null)
      {
         this.client.close();
         this.client = null;
      }
   }

   public List<Referensdata> getIdtyper() throws ReferensdataException
   {
      var resourceName = "idtyper";
      var apiResponse = fetchFromClient(referensdataClient::getIdtyper, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getIdtyp(String id) throws ReferensdataException
   {
      var resourceName = "idtyp";
      var apiResponse = fetchFromClient(() -> referensdataClient.getIdtyp(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getYrkandestatusar() throws ReferensdataException
   {
      var resourceName = "yrkandestatusar";
      var apiResponse = fetchFromClient(referensdataClient::getYrkandestatusar, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getYrkandestatus(String id) throws ReferensdataException
   {
      var resourceName = "yrkandestatus";
      var apiResponse = fetchFromClient(() -> referensdataClient.getYrkandestatus(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getAvsiktstyper() throws ReferensdataException
   {
      var resourceName = "avsiktstyper";
      var apiResponse = fetchFromClient(referensdataClient::getAvsiktstyper, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getAvsiktstyp(String id) throws ReferensdataException
   {
      var resourceName = "avsiktstyp";
      var apiResponse = fetchFromClient(() -> referensdataClient.getAvsiktstyp(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getAvslutstyper() throws ReferensdataException
   {
      var resourceName = "avslutstyper";
      var apiResponse = fetchFromClient(referensdataClient::getAvslutstyper, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getAvslutstyp(String id) throws ReferensdataException
   {
      var resourceName = "avslutstyp";
      var apiResponse = fetchFromClient(() -> referensdataClient.getAvslutstyp(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getBeslutstyper() throws ReferensdataException
   {
      var resourceName = "beslutstyper";
      var apiResponse = fetchFromClient(referensdataClient::getBeslutstyper, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getBeslutstyp(String id) throws ReferensdataException
   {
      var resourceName = "beslutstyp";
      var apiResponse = fetchFromClient(() -> referensdataClient.getBeslutstyp(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getBeslutsutfallstyper() throws ReferensdataException
   {
      var resourceName = "beslutsutfallstyper";
      var apiResponse = fetchFromClient(referensdataClient::getBeslutsutfallstyper, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getBeslutsutfallstyp(String id) throws ReferensdataException
   {
      var resourceName = "beslutsutfallstyp";
      var apiResponse = fetchFromClient(() -> referensdataClient.getBeslutsutfallstyp(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getUppgiftstatustyper() throws ReferensdataException
   {
      var resourceName = "uppgiftstatustyper";
      var apiResponse = fetchFromClient(referensdataClient::getUppgiftstatustyper, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getUppgiftstatustyp(String id) throws ReferensdataException
   {
      var resourceName = "uppgiftstatustyp";
      var apiResponse = fetchFromClient(() -> referensdataClient.getUppgiftstatustyp(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getFSSAinformationstyper() throws ReferensdataException
   {
      var resourceName = "FSSAinformationstyper";
      var apiResponse = fetchFromClient(referensdataClient::getFSSAinformationstyper, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getFSSAinformationstyp(String id) throws ReferensdataException
   {
      var resourceName = "FSSAinformationstyp";
      var apiResponse = fetchFromClient(() -> referensdataClient.getFSSAinformationstyp(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getYrkanderoller() throws ReferensdataException
   {
      var resourceName = "yrkanderoller";
      var apiResponse = fetchFromClient(referensdataClient::getYrkanderoller, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getYrkanderoll(String id) throws ReferensdataException
   {
      var resourceName = "yrkanderoll";
      var apiResponse = fetchFromClient(() -> referensdataClient.getYrkanderoll(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   public List<Referensdata> getErbjudanden() throws ReferensdataException
   {
      var resourceName = "erbjudanden";
      var apiResponse = fetchFromClient(referensdataClient::getErbjudanden, resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdataList, resourceName);
   }

   public Referensdata getErbjudande(String id) throws ReferensdataException
   {
      var resourceName = "erbjudande";
      var apiResponse = fetchFromClient(() -> referensdataClient.getErbjudande(id), resourceName);
      return mapResponse(apiResponse, referensdataMapper::toReferensdata, resourceName);
   }

   private <T> T fetchFromClient(Supplier<T> clientCall, String resourceName) throws ReferensdataException
   {
      try
      {
         return clientCall.get();
      }
      catch (NotFoundException e)
      {
         throw new ReferensdataException(ReferensdataErrorCode.NOT_FOUND, "Referensdata not found when fetching " + resourceName);
      }
      catch (BadRequestException e)
      {
         throw new ReferensdataException(ReferensdataErrorCode.BAD_REQUEST, "Bad request when fetching " + resourceName);
      }
      catch (ServiceUnavailableException e)
      {
         throw new ReferensdataException(ReferensdataErrorCode.SERVICE_UNAVAILABLE, "Referensdata service unavailable");
      }
      catch (Exception e)
      {
         throw new ReferensdataException(ReferensdataErrorCode.UNEXPECTED_ERROR,
               "Unexpected error when fetching " + resourceName);
      }
   }

   private <T, R> R mapResponse(T apiResponse, Function<T, R> mapper, String resourceName) throws ReferensdataException
   {
      try
      {
         return mapper.apply(apiResponse);
      }
      catch (Exception e)
      {
         throw new ReferensdataException(ReferensdataErrorCode.UNEXPECTED_ERROR,
               "Unexpected error when mapping " + resourceName + " response");
      }
   }
}
