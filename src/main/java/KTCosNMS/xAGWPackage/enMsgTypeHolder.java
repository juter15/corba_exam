package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/enMsgTypeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class enMsgTypeHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.enMsgType value = null;

  public enMsgTypeHolder ()
  {
  }

  public enMsgTypeHolder (KTCosNMS.xAGWPackage.enMsgType initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.enMsgTypeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.enMsgTypeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.enMsgTypeHelper.type ();
  }

}
