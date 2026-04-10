package se.fk.rimfrost.adapter.referensdata.model;

import org.immutables.value.Value;
import java.util.UUID;

@Value.Immutable
public interface Referensdata
{

   String id();

   String kod();

   String namn();
}
