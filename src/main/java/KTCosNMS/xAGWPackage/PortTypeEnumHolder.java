package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/PortTypeEnumHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class PortTypeEnumHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.PortTypeEnum value = null;

  public PortTypeEnumHolder ()
  {
  }

  public PortTypeEnumHolder (KTCosNMS.xAGWPackage.PortTypeEnum initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.PortTypeEnumHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.PortTypeEnumHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.PortTypeEnumHelper.type ();
  }

}
