package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/stKtAgwSysConfig4BcnNmsRespHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class stKtAgwSysConfig4BcnNmsRespHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.stKtAgwSysConfig4BcnNmsResp value = null;

  public stKtAgwSysConfig4BcnNmsRespHolder ()
  {
  }

  public stKtAgwSysConfig4BcnNmsRespHolder (KTCosNMS.xAGWPackage.stKtAgwSysConfig4BcnNmsResp initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.stKtAgwSysConfig4BcnNmsRespHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.stKtAgwSysConfig4BcnNmsRespHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.stKtAgwSysConfig4BcnNmsRespHelper.type ();
  }

}
