package KTCosNMS;

/**
* KTCosNMS/enBooleanHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class enBooleanHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.enBoolean value = null;

  public enBooleanHolder ()
  {
  }

  public enBooleanHolder (KTCosNMS.enBoolean initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.enBooleanHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.enBooleanHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.enBooleanHelper.type ();
  }

}
