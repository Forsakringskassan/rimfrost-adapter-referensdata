package se.fk.rimfrost.adapter.referensdata.adapter;

public class ReferensdataException extends Exception
{
   private final ReferensdataErrorCode errorCode;

   public ReferensdataException(ReferensdataErrorCode errorCode, String message)
   {
      super(message);
      this.errorCode = errorCode;
   }

   public ReferensdataErrorCode getErrorCode()
   {
      return errorCode;
   }
}
