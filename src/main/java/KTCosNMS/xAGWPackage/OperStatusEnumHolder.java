package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/OperStatusEnumHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class OperStatusEnumHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.OperStatusEnum value = null;

  public OperStatusEnumHolder ()
  {
  }

  public OperStatusEnumHolder (KTCosNMS.xAGWPackage.OperStatusEnum initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.OperStatusEnumHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.OperStatusEnumHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.OperStatusEnumHelper.type ();
  }

}
