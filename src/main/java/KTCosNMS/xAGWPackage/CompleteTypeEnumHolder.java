package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/CompleteTypeEnumHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class CompleteTypeEnumHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.CompleteTypeEnum value = null;

  public CompleteTypeEnumHolder ()
  {
  }

  public CompleteTypeEnumHolder (KTCosNMS.xAGWPackage.CompleteTypeEnum initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.CompleteTypeEnumHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.CompleteTypeEnumHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.CompleteTypeEnumHelper.type ();
  }

}