package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/ModeStatusEnumHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class ModeStatusEnumHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.ModeStatusEnum value = null;

  public ModeStatusEnumHolder ()
  {
  }

  public ModeStatusEnumHolder (KTCosNMS.xAGWPackage.ModeStatusEnum initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.ModeStatusEnumHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.ModeStatusEnumHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.ModeStatusEnumHelper.type ();
  }

}
