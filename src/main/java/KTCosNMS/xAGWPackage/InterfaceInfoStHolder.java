package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/InterfaceInfoStHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class InterfaceInfoStHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.InterfaceInfoSt value = null;

  public InterfaceInfoStHolder ()
  {
  }

  public InterfaceInfoStHolder (KTCosNMS.xAGWPackage.InterfaceInfoSt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.InterfaceInfoStHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.InterfaceInfoStHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.InterfaceInfoStHelper.type ();
  }

}