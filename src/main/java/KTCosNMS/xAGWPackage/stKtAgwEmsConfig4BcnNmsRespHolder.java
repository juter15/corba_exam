package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/stKtAgwEmsConfig4BcnNmsRespHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class stKtAgwEmsConfig4BcnNmsRespHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.stKtAgwEmsConfig4BcnNmsResp value = null;

  public stKtAgwEmsConfig4BcnNmsRespHolder ()
  {
  }

  public stKtAgwEmsConfig4BcnNmsRespHolder (KTCosNMS.xAGWPackage.stKtAgwEmsConfig4BcnNmsResp initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.stKtAgwEmsConfig4BcnNmsRespHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.stKtAgwEmsConfig4BcnNmsRespHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.stKtAgwEmsConfig4BcnNmsRespHelper.type ();
  }

}
