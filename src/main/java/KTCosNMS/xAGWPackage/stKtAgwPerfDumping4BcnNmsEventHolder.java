package KTCosNMS.xAGWPackage;

/**
* KTCosNMS/xAGWPackage/stKtAgwPerfDumping4BcnNmsEventHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class stKtAgwPerfDumping4BcnNmsEventHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.xAGWPackage.stKtAgwPerfDumping4BcnNmsEvent value = null;

  public stKtAgwPerfDumping4BcnNmsEventHolder ()
  {
  }

  public stKtAgwPerfDumping4BcnNmsEventHolder (KTCosNMS.xAGWPackage.stKtAgwPerfDumping4BcnNmsEvent initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.xAGWPackage.stKtAgwPerfDumping4BcnNmsEventHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.xAGWPackage.stKtAgwPerfDumping4BcnNmsEventHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.xAGWPackage.stKtAgwPerfDumping4BcnNmsEventHelper.type ();
  }

}
