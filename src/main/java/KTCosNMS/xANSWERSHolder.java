package KTCosNMS;

/**
* KTCosNMS/xANSWERSHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/


//--------------------------------------------------------------------------------------
public final class xANSWERSHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xANSWERS value = null;

  public xANSWERSHolder ()
  {
  }

  public xANSWERSHolder (KTCosNMS.xANSWERS initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xANSWERSHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xANSWERSHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xANSWERSHelper.type ();
  }

}
