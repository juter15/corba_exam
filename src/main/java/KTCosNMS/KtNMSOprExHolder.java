package KTCosNMS;

/**
* KTCosNMS/KtNMSOprExHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class KtNMSOprExHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.KtNMSOprEx value = null;

  public KtNMSOprExHolder ()
  {
  }

  public KtNMSOprExHolder (KTCosNMS.KtNMSOprEx initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.KtNMSOprExHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.KtNMSOprExHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.KtNMSOprExHelper.type ();
  }

}
