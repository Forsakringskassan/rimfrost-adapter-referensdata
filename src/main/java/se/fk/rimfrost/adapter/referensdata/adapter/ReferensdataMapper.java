package se.fk.rimfrost.adapter.referensdata.adapter;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.adapter.referensdata.model.ImmutableReferensdata;
import se.fk.rimfrost.adapter.referensdata.model.Referensdata;

import java.util.List;

@ApplicationScoped
public class ReferensdataMapper
{

   public List<Referensdata> toReferensdataList(
         List<se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata> apiResponse)
   {
      return apiResponse.stream().map(this::toReferensdata).toList();
   }

   public Referensdata toReferensdata(se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Referensdata apiResponse)
   {
      return ImmutableReferensdata.builder()
            .id(apiResponse.getId())
            .kod(apiResponse.getKod())
            .namn(apiResponse.getNamn())
            .build();
   }
}
