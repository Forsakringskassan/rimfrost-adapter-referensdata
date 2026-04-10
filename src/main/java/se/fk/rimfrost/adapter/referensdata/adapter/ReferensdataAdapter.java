package se.fk.rimfrost.adapter.referensdata.adapter;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import se.fk.rimfrost.adapter.referensdata.model.Referensdata;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.ReferensdataControllerApi;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
@ApplicationScoped
public class ReferensdataAdapter
{

   @ConfigProperty(name = "referensdata.api.base-url")
   String referensdataBaseUrl;

   private ReferensdataControllerApi referensdataClient;

   @Inject
   ReferensdataMapper referensdataMapper;

   @PostConstruct
   void init()
   {
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.connectorProvider(new ApacheConnectorProvider());
      Client client = ClientBuilder.newClient(clientConfig);

      this.referensdataClient = WebResourceFactory.newResource(
            ReferensdataControllerApi.class,
            client.target(this.referensdataBaseUrl));
   }

   public List<Referensdata> getIdtyper()
   {
      var apiResponse = referensdataClient.getIdtyper();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getIdtyp(String id)
   {
      var apiResponse = referensdataClient.getIdtyp(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getYrkandestatusar()
   {
      var apiResponse = referensdataClient.getYrkandestatusar();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getYrkandestatus(String id)
   {
      var apiResponse = referensdataClient.getYrkandestatus(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getAvsiktstyper()
   {
      var apiResponse = referensdataClient.getAvsiktstyper();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getAvsiktstyp(String id)
   {
      var apiResponse = referensdataClient.getAvsiktstyp(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getAvslutstyper()
   {
      var apiResponse = referensdataClient.getAvslutstyper();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getAvslutstyp(String id)
   {
      var apiResponse = referensdataClient.getAvslutstyp(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getBeslutstyper()
   {
      var apiResponse = referensdataClient.getBeslutstyper();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getBeslutstyp(String id)
   {
      var apiResponse = referensdataClient.getBeslutstyp(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getBeslutsutfallstyper()
   {
      var apiResponse = referensdataClient.getBeslutsutfallstyper();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getBeslutsutfallstyp(String id)
   {
      var apiResponse = referensdataClient.getBeslutsutfallstyp(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getUppgiftstatustyper()
   {
      var apiResponse = referensdataClient.getUppgiftstatustyper();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getUppgiftstatustyp(String id)
   {
      var apiResponse = referensdataClient.getUppgiftstatustyp(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getFSSAinformationstyper()
   {
      var apiResponse = referensdataClient.getFSSAinformationstyper();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getFSSAinformationstyp(String id)
   {
      var apiResponse = referensdataClient.getFSSAinformationstyp(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getYrkanderoller()
   {
      var apiResponse = referensdataClient.getYrkanderoller();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getYrkanderoll(String id)
   {
      var apiResponse = referensdataClient.getYrkanderoll(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }

   public List<Referensdata> getErbjudanden()
   {
      var apiResponse = referensdataClient.getErbjudanden();
      return referensdataMapper.toReferensdataList(apiResponse);
   }

   public Referensdata getErbjudande(String id)
   {
      var apiResponse = referensdataClient.getErbjudande(id);
      return referensdataMapper.toReferensdata(apiResponse);
   }
}
