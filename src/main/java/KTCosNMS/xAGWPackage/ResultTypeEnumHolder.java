package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/ResultTypeEnumHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/


//----------------------------------------------------------------------------------
public final class ResultTypeEnumHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.ResultTypeEnum value = null;

  public ResultTypeEnumHolder ()
  {
  }

  public ResultTypeEnumHolder (KTCosNMS.xAGWPackage.ResultTypeEnum initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.ResultTypeEnumHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.ResultTypeEnumHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.ResultTypeEnumHelper.type ();
  }

}
