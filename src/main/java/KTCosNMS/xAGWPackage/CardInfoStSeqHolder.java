package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/CardInfoStSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class CardInfoStSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.CardInfoSt value[] = null;

  public CardInfoStSeqHolder ()
  {
  }

  public CardInfoStSeqHolder (KTCosNMS.xAGWPackage.CardInfoSt[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.CardInfoStSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.CardInfoStSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.CardInfoStSeqHelper.type ();
  }

}
