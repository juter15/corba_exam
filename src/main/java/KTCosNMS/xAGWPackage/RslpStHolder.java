package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/RslpStHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
*/

public final class RslpStHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.RslpSt value = null;

  public RslpStHolder ()
  {
  }

  public RslpStHolder (KTCosNMS.xAGWPackage.RslpSt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.RslpStHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.RslpStHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.RslpStHelper.type ();
  }

}