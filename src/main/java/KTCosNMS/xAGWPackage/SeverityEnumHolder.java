package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/SeverityEnumHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class SeverityEnumHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.SeverityEnum value = null;

  public SeverityEnumHolder ()
  {
  }

  public SeverityEnumHolder (KTCosNMS.xAGWPackage.SeverityEnum initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.SeverityEnumHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.SeverityEnumHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.SeverityEnumHelper.type ();
  }

}
