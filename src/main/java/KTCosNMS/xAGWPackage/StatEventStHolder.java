package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/StatEventStHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class StatEventStHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.StatEventSt value = null;

  public StatEventStHolder ()
  {
  }

  public StatEventStHolder (KTCosNMS.xAGWPackage.StatEventSt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.StatEventStHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.StatEventStHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.StatEventStHelper.type ();
  }

}
