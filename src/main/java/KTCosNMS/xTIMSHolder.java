package KTCosNMS;

/**
* KTCosNMS/xTIMSHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/


//--------------------------------------------------------------------------------------
public final class xTIMSHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xTIMS value = null;

  public xTIMSHolder ()
  {
  }

  public xTIMSHolder (KTCosNMS.xTIMS initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xTIMSHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xTIMSHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xTIMSHelper.type ();
  }

}
