package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/stKtAgwSystemLoadingStateEventHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class stKtAgwSystemLoadingStateEventHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.stKtAgwSystemLoadingStateEvent value = null;

  public stKtAgwSystemLoadingStateEventHolder ()
  {
  }

  public stKtAgwSystemLoadingStateEventHolder (KTCosNMS.xAGWPackage.stKtAgwSystemLoadingStateEvent initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.stKtAgwSystemLoadingStateEventHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.stKtAgwSystemLoadingStateEventHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.stKtAgwSystemLoadingStateEventHelper.type ();
  }

}