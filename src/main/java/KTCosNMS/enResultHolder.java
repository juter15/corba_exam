package KTCosNMS;

/**
* KTCosNMS/enResultHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class enResultHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.enResult value = null;

  public enResultHolder ()
  {
  }

  public enResultHolder (KTCosNMS.enResult initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.enResultHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.enResultHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.enResultHelper.type ();
  }

}
